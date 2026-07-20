package vj;

import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
@t0
public final class u1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f17273c = Logger.getLogger(u1.class.getName());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static u1 f17274d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hm.a("this")
    public final LinkedHashSet<t1> f17275a = new LinkedHashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hm.a("this")
    public List<t1> f17276b = Collections.emptyList();

    public class a implements Comparator<t1> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t1 t1Var, t1 t1Var2) {
            return t1Var.f() - t1Var2.f();
        }
    }

    public static final class b implements x2.b<t1> {
        public b() {
        }

        @Override // vj.x2.b
        public boolean a(t1 t1Var) {
            return t1Var.d();
        }

        @Override // vj.x2.b
        public int b(t1 t1Var) {
            return t1Var.f();
        }

        public int c(t1 t1Var) {
            return t1Var.f();
        }

        public boolean d(t1 t1Var) {
            return t1Var.d();
        }

        public b(a aVar) {
        }
    }

    public static final class c extends RuntimeException {
        private static final long serialVersionUID = 1;

        public c(String str) {
            super(str);
        }
    }

    public static synchronized u1 c() {
        try {
            if (f17274d == null) {
                List<t1> listF = x2.f(t1.class, d(), t1.class.getClassLoader(), new b());
                f17274d = new u1();
                for (t1 t1Var : listF) {
                    f17273c.fine("Service loader found " + t1Var);
                    f17274d.a(t1Var);
                }
                f17274d.i();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f17274d;
    }

    @b1.e
    public static List<Class<?>> d() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.okhttp.OkHttpChannelProvider"));
        } catch (ClassNotFoundException e10) {
            f17273c.log(Level.FINE, "Unable to find OkHttpChannelProvider", (Throwable) e10);
        }
        try {
            arrayList.add(yj.g0.class);
        } catch (ClassNotFoundException e11) {
            f17273c.log(Level.FINE, "Unable to find NettyChannelProvider", (Throwable) e11);
        }
        try {
            arrayList.add(yj.g1.class);
        } catch (ClassNotFoundException e12) {
            f17273c.log(Level.FINE, "Unable to find UdsNettyChannelProvider", (Throwable) e12);
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final synchronized void a(t1 t1Var) {
        c1.h0.e(t1Var.d(), "isAvailable() returned false");
        this.f17275a.add(t1Var);
    }

    public synchronized void b(t1 t1Var) {
        this.f17275a.remove(t1Var);
        i();
    }

    public s1<?> e(String str, g gVar) {
        return f(z1.d(), str, gVar);
    }

    @b1.e
    public s1<?> f(z1 z1Var, String str, g gVar) {
        y1 y1VarG;
        try {
            y1VarG = z1Var.g(new URI(str).getScheme());
        } catch (URISyntaxException unused) {
            y1VarG = null;
        }
        if (y1VarG == null) {
            y1VarG = z1Var.g(z1Var.e());
        }
        Collection<Class<? extends SocketAddress>> collectionC = y1VarG != null ? y1VarG.c() : Collections.emptySet();
        if (h().isEmpty()) {
            throw new c("No functional channel service provider found. Try adding a dependency on the grpc-okhttp, grpc-netty, or grpc-netty-shaded artifact");
        }
        StringBuilder sb2 = new StringBuilder();
        for (t1 t1Var : h()) {
            if (t1Var.c().containsAll(collectionC)) {
                t1.a aVarE = t1Var.e(str, gVar);
                s1<?> s1Var = aVarE.f17265a;
                if (s1Var != null) {
                    return s1Var;
                }
                sb2.append("; ");
                sb2.append(t1Var.getClass().getName());
                sb2.append(": ");
                sb2.append(aVarE.f17266b);
            } else {
                sb2.append("; ");
                sb2.append(t1Var.getClass().getName());
                sb2.append(": does not support 1 or more of ");
                sb2.append(Arrays.toString(collectionC.toArray()));
            }
        }
        throw new c(sb2.substring(2));
    }

    public t1 g() {
        List<t1> listH = h();
        if (listH.isEmpty()) {
            return null;
        }
        return listH.get(0);
    }

    @b1.e
    public synchronized List<t1> h() {
        return this.f17276b;
    }

    public final synchronized void i() {
        ArrayList arrayList = new ArrayList(this.f17275a);
        Collections.sort(arrayList, Collections.reverseOrder(new a()));
        this.f17276b = Collections.unmodifiableList(arrayList);
    }

    public synchronized void j(t1 t1Var) {
        a(t1Var);
        i();
    }
}
