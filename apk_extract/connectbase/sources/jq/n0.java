package jq;

import lm.a2;
import lm.f1;
import lm.g2;
import lm.s1;
import lm.w1;

/* JADX INFO: loaded from: classes3.dex */
public final class n0 {
    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final byte a(String str, k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return s1.m(j.h(str, kVar));
    }

    public static byte b(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return s1.m(j.h(str, kVar));
    }

    @an.f
    @f1(version = "1.9")
    @lm.t
    @lm.r
    public static final byte[] c(String str, k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        byte[] bArrL = j.l(str, kVar);
        kn.l0.p(bArrL, "storage");
        return bArrL;
    }

    public static byte[] d(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        byte[] bArrL = j.l(str, kVar);
        kn.l0.p(bArrL, "storage");
        return bArrL;
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final int e(String str, k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return w1.m(j.p(str, kVar));
    }

    public static int f(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return w1.m(j.p(str, kVar));
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final long g(String str, k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return a2.m(j.t(str, kVar));
    }

    public static long h(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return a2.m(j.t(str, kVar));
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final short i(String str, k kVar) {
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return g2.m(j.z(str, kVar));
    }

    public static short j(String str, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(kVar, "format");
        return g2.m(j.z(str, kVar));
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final String k(int i10, k kVar) {
        kn.l0.p(kVar, "format");
        return j.E(i10, kVar);
    }

    public static String l(int i10, k kVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(kVar, "format");
        return j.E(i10, kVar);
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final String m(long j10, k kVar) {
        kn.l0.p(kVar, "format");
        return j.F(j10, kVar);
    }

    public static String n(long j10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(kVar, "format");
        return j.F(j10, kVar);
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final String o(byte b10, k kVar) {
        kn.l0.p(kVar, "format");
        return j.D(b10, kVar);
    }

    public static String p(byte b10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(kVar, "format");
        return j.D(b10, kVar);
    }

    @an.f
    @f1(version = "1.9")
    @lm.t
    @lm.r
    public static final String q(byte[] bArr, int i10, int i11, k kVar) {
        kn.l0.p(bArr, "$this$toHexString");
        kn.l0.p(kVar, "format");
        return j.H(bArr, i10, i11, kVar);
    }

    public static String r(byte[] bArr, int i10, int i11, k kVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 4) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(bArr, "$this$toHexString");
        kn.l0.p(kVar, "format");
        return j.H(bArr, i10, i11, kVar);
    }

    @f1(version = "1.9")
    @an.f
    @lm.r
    public static final String s(short s10, k kVar) {
        kn.l0.p(kVar, "format");
        return j.G(s10, kVar);
    }

    public static String t(short s10, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(kVar, "format");
        return j.G(s10, kVar);
    }

    @an.f
    @f1(version = "1.9")
    @lm.t
    @lm.r
    public static final String u(byte[] bArr, k kVar) {
        kn.l0.p(bArr, "$this$toHexString");
        kn.l0.p(kVar, "format");
        return j.I(bArr, kVar);
    }

    public static String v(byte[] bArr, k kVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            k.f8828d.getClass();
            kVar = k.f8829e;
        }
        kn.l0.p(bArr, "$this$toHexString");
        kn.l0.p(kVar, "format");
        return j.I(bArr, kVar);
    }
}
