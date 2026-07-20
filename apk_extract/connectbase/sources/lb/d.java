package lb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.internal.annotations.VisibleForTesting;
import java.util.ArrayList;
import le.o0;

/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9763a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9764b = "com.transsion.log.ATHENA_STATE_CHANGED";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9765c = "service is Null";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9766d = "Parameter must not null!!!";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final qb.e.a<fh.a> f9767a = new C0259a();

        /* JADX INFO: renamed from: lb.d$a$a, reason: collision with other inner class name */
        public class C0259a extends qb.e.a<fh.a> {
            @Override // qb.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public fh.a b() {
                if (fc.b.b(fc.b.a.f5981a)) {
                    dc.e.f(d.f9763a, "TranThubTrancareManager");
                    return new o0();
                }
                dc.e.f(d.f9763a, "TranAospTrancareManager");
                return new v8.c();
            }
        }

        @VisibleForTesting
        public static void a() {
            f9767a.f13899a = null;
        }

        @VisibleForTesting
        public static fh.a b() {
            return f9767a.c();
        }
    }

    public static void A(String str, String str2, String str3) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.u(str, str2, str3);
    }

    public static void B(String str, String str2, String[] strArr) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.g(str, str2, strArr);
    }

    public static void C(String str, String str2) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.m(str, str2);
    }

    public static void D(String str, String str2, lb.a aVar) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (aVar == null) {
            throw new NullPointerException(f9766d);
        }
        aVarB.I(str, str2, aVar);
    }

    public static void E(c cVar) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (cVar == null) {
            throw new NullPointerException(f9766d);
        }
        aVarB.j(cVar);
    }

    public static void F(int i10, String str) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.y(i10, str);
    }

    public static void G(int i10, String str, int i11, Bundle bundle) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.d(i10, str, i11, bundle);
    }

    public static void H(int i10, String str, int i11, ArrayList<Bundle> arrayList, Bundle bundle) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.K(i10, str, i11, arrayList, bundle);
    }

    public static void I(long j10, String str) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.v(j10, str);
    }

    public static void J(long j10, String str, int i10, Bundle bundle) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.J(j10, str, i10, bundle);
    }

    public static void K(long j10, String str, int i10, ArrayList<Bundle> arrayList, Bundle bundle) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.l(j10, str, i10, arrayList, bundle);
    }

    public static void L(String str, lb.a aVar) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            throw new NullPointerException(f9766d);
        }
        aVarB.r(str, aVar);
    }

    public static void M(c cVar) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (cVar == null) {
            throw new NullPointerException(f9766d);
        }
        aVarB.q(cVar);
    }

    public static void b(int i10) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.h(i10);
    }

    public static void c(String str, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.s(str, z10);
    }

    public static boolean d(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.x(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static boolean[] e(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.B(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static boolean f(String str, String str2, boolean z10, boolean z11) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.z(str, str2, z10, z11);
        }
        throw new NullPointerException("service is Null");
    }

    public static long g(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.f(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static long[] h(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.t(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static long i(String str, String str2, boolean z10, long j10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.c(str, str2, z10, j10);
        }
        throw new NullPointerException("service is Null");
    }

    public static String j(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.L(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static String[] k(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.w(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static String l(String str, String str2, boolean z10, String str3) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.H(str, str2, z10, str3);
        }
        throw new NullPointerException("service is Null");
    }

    public static String m(String str) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.a(str);
        }
        throw new NullPointerException("service is Null");
    }

    public static String n(Context context, String str) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.n(context, str);
        }
        throw new NullPointerException("service is Null");
    }

    public static String o(String str) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.p(str);
        }
        throw new NullPointerException("service is Null");
    }

    public static String p(String str, String str2) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.D(str, str2);
        }
        throw new NullPointerException("service is Null");
    }

    public static String q(String str) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.C(str);
        }
        throw new NullPointerException("service is Null");
    }

    public static boolean r(String str, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.b(str, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static boolean s(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.A(str, str2, z10);
        }
        throw new NullPointerException("service is Null");
    }

    public static String t(String str, String str2) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.F(str, str2);
        }
        throw new NullPointerException("service is Null");
    }

    public static String u(String str) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.k(str);
        }
        throw new NullPointerException("service is Null");
    }

    public static boolean v(long j10) {
        fh.a aVarB = a.b();
        if (aVarB != null) {
            return aVarB.i(j10);
        }
        throw new NullPointerException("service is Null");
    }

    public static void w(String str, String str2, boolean z10) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.E(str, str2, z10);
    }

    public static void x(String str, String str2, boolean[] zArr) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.o(str, str2, zArr);
    }

    public static void y(String str, String str2, long j10) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.e(str, str2, j10);
    }

    public static void z(String str, String str2, long[] jArr) {
        fh.a aVarB = a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.G(str, str2, jArr);
    }
}
