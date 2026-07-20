package lb;

import com.android.internal.annotations.VisibleForTesting;
import le.y0;

/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9768a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9769b = "service is Null";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f9770c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f9771d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f9772e = 3;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f9773f = 4;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f9774g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static y0 f9775h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static v8.d f9776i;

    public static class a {
        @VisibleForTesting
        public static fh.b a(String str) {
            if (fc.b.b(str)) {
                dc.e.f(e.f9768a, "TranThubTrancareNative");
                y0 y0Var = e.f9775h;
                if (y0Var != null) {
                    return y0Var;
                }
                y0 y0Var2 = new y0();
                e.f9775h = y0Var2;
                return y0Var2;
            }
            dc.e.f(e.f9768a, "TranAospTrancareNative");
            v8.d dVar = e.f9776i;
            if (dVar != null) {
                return dVar;
            }
            v8.d dVar2 = new v8.d();
            e.f9776i = dVar2;
            return dVar2;
        }
    }

    public static void f(String str, String str2) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.e(str, str2);
    }

    public static void g(String str, String str2) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.a(str, str2);
    }

    public static void h(String str, String str2) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.d(str, str2);
    }

    public static void i(String str, String str2) throws ac.a {
        fh.b bVarA = a.a(fc.b.a.f5988h);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.g(str, str2);
    }

    public static void j(String str, String str2) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.h(str, str2);
    }

    public static void k(String str, float f10, int i10) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.b(str, f10, i10);
    }

    public static void l(String str, int i10, int i11) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.f(str, i10, i11);
    }

    public static void m(String str, long j10, int i10) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.i(str, j10, i10);
    }

    public static void n(String str, String str2) {
        fh.b bVarA = a.a(fc.b.a.f5983c);
        if (bVarA == null) {
            throw new NullPointerException("service is Null");
        }
        bVarA.c(str, str2);
    }
}
