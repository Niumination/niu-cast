package ps;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.ILoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;
import rs.h;
import rs.k;
import rs.l;
import rs.m;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13320a = "http://www.slf4j.org/codes.html";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f13321b = "http://www.slf4j.org/codes.html#StaticLoggerBinder";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13322c = "http://www.slf4j.org/codes.html#multiple_bindings";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13323d = "http://www.slf4j.org/codes.html#null_LF";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f13324e = "http://www.slf4j.org/codes.html#version_mismatch";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f13325f = "http://www.slf4j.org/codes.html#substituteLogger";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f13326g = "http://www.slf4j.org/codes.html#loggerNameMismatch";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f13327h = "http://www.slf4j.org/codes.html#replay";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f13328i = "http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f13329j = "org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f13330k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f13331l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f13332m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f13333n = 3;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f13334o = 4;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static volatile int f13335p = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f13339t = "java.vendor.url";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final l f13336q = new l();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final h f13337r = new h();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f13338s = "slf4j.detectLoggerNameMismatch";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static boolean f13340u = m.f(f13338s);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final String[] f13341v = {"1.6", "1.7"};

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f13342w = "org/slf4j/impl/StaticLoggerBinder.class";

    public static final void a() {
        Set<URL> setF;
        try {
            try {
                if (l()) {
                    setF = null;
                } else {
                    setF = f();
                    t(setF);
                }
                StaticLoggerBinder.getSingleton();
                f13335p = 3;
                s(setF);
            } catch (Exception e10) {
                e(e10);
                throw new IllegalStateException("Unexpected initialization failure", e10);
            } catch (NoClassDefFoundError e11) {
                if (!m(e11.getMessage())) {
                    e(e11);
                    throw e11;
                }
                f13335p = 4;
                m.c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                m.c("Defaulting to no-operation (NOP) logger implementation");
                m.c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
            } catch (NoSuchMethodError e12) {
                String message = e12.getMessage();
                if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                    f13335p = 2;
                    m.c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                    m.c("Your binding is version 1.5.5 or earlier.");
                    m.c("Upgrade your binding to version 1.6.x.");
                }
                throw e12;
            }
            p();
        } catch (Throwable th2) {
            p();
            throw th2;
        }
    }

    public static void b(qs.e eVar, int i10) {
        if (eVar.i().d()) {
            c(i10);
        } else {
            if (eVar.i().e()) {
                return;
            }
            d();
        }
    }

    public static void c(int i10) {
        m.c("A number (" + i10 + ") of logging calls during the initialization phase have been intercepted and are");
        m.c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        m.c("See also http://www.slf4j.org/codes.html#replay");
    }

    public static void d() {
        m.c("The following set of substitute loggers may have been accessed");
        m.c("during the initialization phase. Logging calls during this");
        m.c("phase were not honored. However, subsequent logging calls to these");
        m.c("loggers will work as normally expected.");
        m.c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    public static void e(Throwable th2) {
        f13335p = 2;
        m.d("Failed to instantiate SLF4J LoggerFactory", th2);
    }

    public static Set<URL> f() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = b.class.getClassLoader();
            Enumeration<URL> systemResources = classLoader == null ? ClassLoader.getSystemResources(f13342w) : classLoader.getResources(f13342w);
            while (systemResources.hasMoreElements()) {
                linkedHashSet.add(systemResources.nextElement());
            }
        } catch (IOException e10) {
            m.d("Error getting resources from path", e10);
        }
        return linkedHashSet;
    }

    public static void g() {
        l lVar = f13336q;
        synchronized (lVar) {
            try {
                lVar.f();
                for (k kVar : lVar.e()) {
                    kVar.h(j(kVar.getName()));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static ILoggerFactory h() {
        if (f13335p == 0) {
            synchronized (b.class) {
                try {
                    if (f13335p == 0) {
                        f13335p = 1;
                        o();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        int i10 = f13335p;
        if (i10 == 1) {
            return f13336q;
        }
        if (i10 == 2) {
            throw new IllegalStateException(f13329j);
        }
        if (i10 == 3) {
            return StaticLoggerBinder.getSingleton().getLoggerFactory();
        }
        if (i10 == 4) {
            return f13337r;
        }
        throw new IllegalStateException("Unreachable code");
    }

    public static a i(Class<?> cls) {
        Class<?> clsA;
        a aVarJ = j(cls.getName());
        if (f13340u && (clsA = m.a()) != null && n(cls, clsA)) {
            m.c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", aVarJ.getName(), clsA.getName()));
            m.c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return aVarJ;
    }

    public static a j(String str) {
        return h().a(str);
    }

    public static boolean k(Set<URL> set) {
        return set.size() > 1;
    }

    public static boolean l() {
        String strG = m.g(f13339t);
        if (strG == null) {
            return false;
        }
        return strG.toLowerCase().contains("android");
    }

    public static boolean m(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    public static boolean n(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    public static final void o() {
        a();
        if (f13335p == 3) {
            v();
        }
    }

    public static void p() {
        g();
        q();
        f13336q.b();
    }

    public static void q() {
        LinkedBlockingQueue<qs.e> linkedBlockingQueueC = f13336q.c();
        int size = linkedBlockingQueueC.size();
        ArrayList<qs.e> arrayList = new ArrayList(128);
        int i10 = 0;
        while (linkedBlockingQueueC.drainTo(arrayList, 128) != 0) {
            for (qs.e eVar : arrayList) {
                r(eVar);
                int i11 = i10 + 1;
                if (i10 == 0) {
                    b(eVar, size);
                }
                i10 = i11;
            }
            arrayList.clear();
        }
    }

    public static void r(qs.e eVar) {
        if (eVar == null) {
            return;
        }
        k kVarI = eVar.i();
        String name = kVarI.getName();
        if (kVarI.f()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (kVarI.e()) {
            return;
        }
        if (kVarI.d()) {
            kVarI.g(eVar);
        } else {
            m.c(name);
        }
    }

    public static void s(Set<URL> set) {
        if (set == null || !k(set)) {
            return;
        }
        m.c("Actual binding is of type [" + StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr() + "]");
    }

    public static void t(Set<URL> set) {
        if (k(set)) {
            m.c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                m.c("Found binding in [" + it.next() + "]");
            }
            m.c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    public static void u() {
        f13335p = 0;
    }

    public static final void v() {
        try {
            String str = StaticLoggerBinder.REQUESTED_API_VERSION;
            boolean z10 = false;
            for (String str2 : f13341v) {
                if (str.startsWith(str2)) {
                    z10 = true;
                }
            }
            if (z10) {
                return;
            }
            m.c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f13341v).toString());
            m.c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th2) {
            m.d("Unexpected problem occured during version sanity check", th2);
        }
    }
}
