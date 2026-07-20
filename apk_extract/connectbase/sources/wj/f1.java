package wj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

/* JADX INFO: loaded from: classes2.dex */
public final class f1 implements f0.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.j
    public static final Throwable f18662a = d();

    @b1.e
    @b.a({"all"})
    @is.a
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ boolean f18663a = false;

        public static void b() {
            if (f1.f18662a != null) {
                throw new UnsupportedOperationException("JNDI is not currently available", f1.f18662a);
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        public static void c(NamingEnumeration<?> namingEnumeration, NamingException namingException) throws NamingException {
            try {
                namingEnumeration.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        public static void d(DirContext dirContext, NamingException namingException) throws NamingException {
            try {
                dirContext.close();
                throw namingException;
            } catch (NamingException unused) {
                throw namingException;
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        @Override // wj.f1.c
        public List<String> a(String str, String str2) throws NamingException {
            b();
            String[] strArr = {str};
            ArrayList arrayList = new ArrayList();
            Hashtable hashtable = new Hashtable();
            hashtable.put("com.sun.jndi.ldap.connect.timeout", "5000");
            hashtable.put("com.sun.jndi.ldap.read.timeout", "5000");
            InitialDirContext initialDirContext = new InitialDirContext(hashtable);
            try {
                NamingEnumeration all = initialDirContext.getAttributes(str2, strArr).getAll();
                while (all.hasMore()) {
                    try {
                        NamingEnumeration all2 = ((Attribute) all.next()).getAll();
                        while (all2.hasMore()) {
                            try {
                                arrayList.add(String.valueOf(all2.next()));
                            } catch (NamingException e10) {
                                c(all2, e10);
                            }
                        }
                        all2.close();
                    } catch (NamingException e11) {
                        c(all, e11);
                    }
                }
                all.close();
            } catch (NamingException e12) {
                d(initialDirContext, e12);
            }
            initialDirContext.close();
            return arrayList;
        }
    }

    @b1.e
    public static final class b implements f0.f {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Logger f18664b = Logger.getLogger(b.class.getName());

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Pattern f18665c = Pattern.compile("\\s+");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ boolean f18666d = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f18667a;

        public b(c cVar) {
            this.f18667a = cVar;
        }

        @b1.e
        public static String c(String str) {
            StringBuilder sb2 = new StringBuilder(str.length());
            int i10 = 0;
            boolean z10 = false;
            while (i10 < str.length()) {
                char cCharAt = str.charAt(i10);
                if (z10) {
                    if (cCharAt == '\"') {
                        z10 = false;
                    } else {
                        if (cCharAt == '\\') {
                            i10++;
                            cCharAt = str.charAt(i10);
                        }
                        sb2.append(cCharAt);
                    }
                } else if (cCharAt != ' ') {
                    if (cCharAt == '\"') {
                        z10 = true;
                    } else {
                        sb2.append(cCharAt);
                    }
                }
                i10++;
            }
            return sb2.toString();
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        @Override // wj.f0.f
        public List<String> a(String str) throws NamingException {
            Logger logger = f18664b;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                logger.log(level, "About to query TXT records for {0}", new Object[]{str});
            }
            List<String> listA = this.f18667a.a("TXT", "dns:///" + str);
            if (logger.isLoggable(level)) {
                logger.log(level, "Found {0} TXT records", new Object[]{Integer.valueOf(listA.size())});
            }
            ArrayList arrayList = new ArrayList(listA.size());
            Iterator<String> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(c(it.next()));
            }
            return Collections.unmodifiableList(arrayList);
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: javax.naming.NamingException */
        @Override // wj.f0.f
        public List<f0.h> b(String str) throws Exception {
            Logger logger = f18664b;
            Level level = Level.FINER;
            if (logger.isLoggable(level)) {
                logger.log(level, "About to query SRV records for {0}", new Object[]{str});
            }
            List<String> listA = this.f18667a.a("SRV", "dns:///" + str);
            if (logger.isLoggable(level)) {
                logger.log(level, "Found {0} SRV records", new Object[]{Integer.valueOf(listA.size())});
            }
            ArrayList arrayList = new ArrayList(listA.size());
            Level level2 = Level.WARNING;
            RuntimeException runtimeException = null;
            for (String str2 : listA) {
                try {
                    String[] strArrSplit = f18665c.split(str2, 5);
                    c1.w0.q(strArrSplit.length == 4, "Bad SRV Record: %s", str2);
                    if (!strArrSplit[3].endsWith(".")) {
                        throw new RuntimeException("Returned SRV host does not end in period: " + strArrSplit[3]);
                    }
                    arrayList.add(new f0.h(strArrSplit[3], Integer.parseInt(strArrSplit[2])));
                } catch (RuntimeException e10) {
                    f18664b.log(level2, "Failed to construct SRV record " + str2, (Throwable) e10);
                    if (runtimeException == null) {
                        level2 = Level.FINE;
                        runtimeException = e10;
                    }
                }
            }
            if (!arrayList.isEmpty() || runtimeException == null) {
                return Collections.unmodifiableList(arrayList);
            }
            throw runtimeException;
        }
    }

    @b1.e
    public interface c {
        List<String> a(String str, String str2) throws NamingException;
    }

    @gm.j
    public static Throwable d() {
        try {
            Class.forName("javax.naming.directory.InitialDirContext");
            Class.forName("com.sun.jndi.dns.DnsContextFactory");
            return null;
        } catch (ClassNotFoundException | Error | RuntimeException e10) {
            return e10;
        }
    }

    @Override // wj.f0.g
    @gm.j
    public f0.f a() {
        if (f18662a != null) {
            return null;
        }
        return new b(new a());
    }

    @Override // wj.f0.g
    @gm.j
    public Throwable b() {
        return f18662a;
    }
}
