package ob;

import android.text.TextUtils;
import com.android.internal.annotations.VisibleForTesting;
import fc.b;
import j1.g;
import qb.e;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12156a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12157b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12158c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12159d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12160e = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12161f = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12162g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12163h = "a";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f12164i = "service is Null";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f12165j = "uid parameter error,uid must >= 1000,current is: ";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f12166k = "mode is invalid,mode shuold in [-1,1,2], current mode is: ";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f12167l = "pkgName is null";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f12168m = "reason is null";

    /* JADX INFO: renamed from: ob.a$a, reason: collision with other inner class name */
    public static class C0310a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e.a<ih.a> f12169a = new C0311a();

        /* JADX INFO: renamed from: ob.a$a$a, reason: collision with other inner class name */
        public class C0311a extends e.a<ih.a> {
            @Override // qb.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public ih.a b() {
                if (b.b(b.a.f6005y) && fc.a.g()) {
                    dc.e.f(a.f12163h, "TranThubUsfManager");
                    return new oe.a();
                }
                dc.e.f(a.f12163h, x8.a.f20120c);
                return new x8.a();
            }
        }

        @VisibleForTesting
        public static void a() {
            f12169a.f13899a = null;
        }

        @VisibleForTesting
        public static ih.a b() {
            return f12169a.c();
        }
    }

    public boolean b(int i10, boolean z10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 >= 1000) {
            return aVarB.n(i10, z10);
        }
        throw new IllegalArgumentException(h.a.a(f12165j, i10));
    }

    public boolean c(boolean z10) {
        ih.a aVarB = C0310a.b();
        if (aVarB != null) {
            return aVarB.a(z10);
        }
        throw new NullPointerException("service is Null");
    }

    public void d(boolean z10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.e(z10);
    }

    public void e(boolean z10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        aVarB.k(z10);
    }

    public void f(String str) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12168m);
        }
        aVarB.o(str);
    }

    public void g(String str, long j10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12168m);
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(g.a("unFreezeDelayTime is less than 0,current is ", j10, ",please check it"));
        }
        aVarB.m(str, j10);
    }

    public void h(String str) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12168m);
        }
        aVarB.r(str);
    }

    public int i(int i10, String str) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 < 1000) {
            throw new IllegalArgumentException(h.a.a(f12165j, i10));
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12167l);
        }
        return aVarB.l(i10, str);
    }

    public int[] j(int i10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 > 2 || i10 < -1 || i10 == 0) {
            throw new IllegalArgumentException(h.a.a(f12166k, i10));
        }
        return aVarB.d(i10);
    }

    public int k(int i10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 >= 1000) {
            return aVarB.h(i10);
        }
        throw new IllegalArgumentException(h.a.a(f12165j, i10));
    }

    public String l(int i10, String str) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 < 1000) {
            throw new IllegalArgumentException(h.a.a(f12165j, i10));
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12167l);
        }
        return aVarB.g(i10, str);
    }

    public boolean m() {
        ih.a aVarB = C0310a.b();
        if (aVarB != null) {
            return aVarB.j();
        }
        throw new NullPointerException("service is Null");
    }

    public boolean n() {
        ih.a aVarB = C0310a.b();
        if (aVarB != null) {
            return aVarB.f();
        }
        throw new NullPointerException("service is Null");
    }

    public boolean o() {
        ih.a aVarB = C0310a.b();
        if (aVarB != null) {
            return aVarB.q();
        }
        throw new NullPointerException("service is Null");
    }

    public boolean p(int i10) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 >= 1000) {
            return aVarB.i(i10);
        }
        throw new IllegalArgumentException(h.a.a(f12165j, i10));
    }

    public boolean q(String str) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12167l);
        }
        return aVarB.b(str);
    }

    public void r(int i10, int i11) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 < 1000) {
            throw new IllegalArgumentException(h.a.a(f12165j, i10));
        }
        if (i11 > 2 || i11 < -1 || i11 == 0) {
            throw new IllegalArgumentException(h.a.a(f12166k, i11));
        }
        aVarB.c(i10, i11);
    }

    public void s(int i10, String str, String str2) {
        ih.a aVarB = C0310a.b();
        if (aVarB == null) {
            throw new NullPointerException("service is Null");
        }
        if (i10 < 1000) {
            throw new IllegalArgumentException(h.a.a(f12165j, i10));
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(f12167l);
        }
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException(f12168m);
        }
        aVarB.p(i10, str, str2);
    }
}
