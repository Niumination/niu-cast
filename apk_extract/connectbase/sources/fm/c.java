package fm;

import t1.p;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6114a;

    static {
        Object obj;
        Class<?> cls;
        a aVar;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            obj = null;
        } catch (Throwable th2) {
            obj = th2;
            cls = null;
        }
        if (cls != null) {
            try {
                aVar = (a) cls.asSubclass(a.class).getConstructor(e.class).newInstance(a.f6111d);
            } catch (Throwable th3) {
                obj = th3;
                aVar = null;
            }
        } else {
            aVar = null;
        }
        if (aVar != null) {
            f6114a = aVar;
        } else {
            f6114a = new a(a.f6111d);
        }
        if (obj != null) {
            try {
                if (Boolean.getBoolean("io.perfmark.PerfMark.debug")) {
                    Class<?> cls2 = Class.forName("java.util.logging.Logger");
                    Object objInvoke = cls2.getMethod("getLogger", String.class).invoke(null, c.class.getName());
                    Class<?> cls3 = Class.forName("java.util.logging.Level");
                    cls2.getMethod("log", cls3, String.class, Throwable.class).invoke(objInvoke, cls3.getField("FINE").get(null), "Error during PerfMark.<clinit>", obj);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(e eVar) {
        f6114a.a(eVar);
    }

    public static void b(String str, long j10) {
        f6114a.b(str, j10);
    }

    public static void c(String str, long j10, long j11) {
        f6114a.c(str, j10, j11);
    }

    public static <T> void d(String str, T t10, d<? super T> dVar) {
        f6114a.d(str, t10, dVar);
    }

    public static void e(String str, String str2) {
        f6114a.e(str, str2);
    }

    public static e f() {
        return a.f6111d;
    }

    public static e g(long j10) {
        return f6114a.f("", j10);
    }

    public static e h(String str) {
        return f6114a.f(str, Long.MIN_VALUE);
    }

    public static e i(String str, long j10) {
        return f6114a.f(str, j10);
    }

    public static void j(String str) {
        f6114a.g(str);
    }

    public static void k(String str, e eVar) {
        f6114a.h(str, eVar);
    }

    public static void l(String str, String str2) {
        f6114a.i(str, str2);
    }

    @t1.e
    @Deprecated
    public static b m() {
        return a.f6112e;
    }

    public static void n(b bVar) {
        f6114a.j(bVar);
    }

    public static b o() {
        return f6114a.k();
    }

    @t1.a
    public static boolean p(boolean z10) {
        return f6114a.o(z10, false);
    }

    public static <T> void q(T t10, d<? super T> dVar) {
        f6114a.p(t10, dVar);
    }

    public static void r(String str) {
        f6114a.q(str);
    }

    public static void s(String str, e eVar) {
        f6114a.r(str, eVar);
    }

    public static void t(String str, String str2) {
        f6114a.s(str, str2);
    }

    public static void u() {
        f6114a.t();
    }

    public static void v(String str) {
        f6114a.u(str);
    }

    public static void w(String str, e eVar) {
        f6114a.v(str, eVar);
    }

    public static void x(String str, String str2) {
        f6114a.w(str, str2);
    }

    @p
    public static <T> f y(T t10, d<? super T> dVar) {
        f6114a.p(t10, dVar);
        return f.f6117a;
    }

    @p
    public static f z(String str) {
        f6114a.q(str);
        return f.f6117a;
    }
}
