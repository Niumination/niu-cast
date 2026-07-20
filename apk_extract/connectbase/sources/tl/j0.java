package tl;

import java.io.EOFException;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class j0 {
    @in.i(name = "readFully")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void A(g0 g0Var, short[] sArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(sArr, "dst");
        i0.w(g0Var, sArr, i10, i11);
    }

    public static void B(g0 g0Var, o0 o0Var, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            m mVar = o0Var.f15821b;
            i10 = mVar.f15872a - mVar.f15874c;
        }
        u(g0Var, o0Var, i10);
    }

    public static /* synthetic */ void C(g0 g0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        v(g0Var, bArr, i10, i11);
    }

    public static /* synthetic */ void D(g0 g0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        w(g0Var, dArr, i10, i11);
    }

    public static /* synthetic */ void E(g0 g0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        x(g0Var, fArr, i10, i11);
    }

    public static /* synthetic */ void F(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        y(g0Var, iArr, i10, i11);
    }

    public static /* synthetic */ void G(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        z(g0Var, jArr, i10, i11);
    }

    public static /* synthetic */ void H(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        A(g0Var, sArr, i10, i11);
    }

    @ul.d
    public static final void I(@os.l g0 g0Var, @os.l jn.l<? super e, Boolean> lVar) throws Throwable {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(lVar, "block");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            return;
        }
        while (lVar.invoke(bVarJ).booleanValue()) {
            try {
                try {
                    ul.b bVarM = ul.k.m(g0Var, bVarJ);
                    if (bVarM == null) {
                        z10 = false;
                        break;
                    }
                    bVarJ = bVarM;
                } catch (Throwable th2) {
                    th = th2;
                    z10 = false;
                    if (z10) {
                        ul.k.e(g0Var, bVarJ);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (z10) {
            ul.k.e(g0Var, bVarJ);
        }
    }

    @ul.d
    public static final void J(@os.l g0 g0Var, int i10, @os.l jn.l<? super e, Integer> lVar) throws Throwable {
        boolean z10;
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarJ = ul.k.j(g0Var, i10);
        if (bVarJ == null) {
            return;
        }
        do {
            z10 = true;
            try {
                m mVar = bVarJ.f15821b;
                int i11 = mVar.f15874c - mVar.f15873b;
                if (i11 >= i10) {
                    try {
                        i10 = lVar.invoke(bVarJ).intValue();
                        m mVar2 = bVarJ.f15821b;
                        i11 = mVar2.f15874c - mVar2.f15873b;
                    } catch (Throwable th2) {
                        m mVar3 = bVarJ.f15821b;
                        int i12 = mVar3.f15874c;
                        int i13 = mVar3.f15873b;
                        throw th2;
                    }
                }
                if (i11 == 0) {
                    try {
                        bVarM = ul.k.m(g0Var, bVarJ);
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = false;
                        if (z10) {
                            ul.k.e(g0Var, bVarJ);
                        }
                        throw th;
                    }
                } else if (i11 < i10 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                    ul.k.e(g0Var, bVarJ);
                    bVarM = ul.k.j(g0Var, i10);
                } else {
                    bVarM = bVarJ;
                }
                if (bVarM == null) {
                    z10 = false;
                    break;
                }
                bVarJ = bVarM;
            } catch (Throwable th4) {
                th = th4;
            }
        } while (i10 > 0);
        if (z10) {
            ul.k.e(g0Var, bVarJ);
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    public static void K(g0 g0Var, int i10, jn.l lVar, int i11, Object obj) throws Throwable {
        ul.b bVarM;
        boolean z10 = true;
        if ((i11 & 1) != 0) {
            i10 = 1;
        }
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(lVar, "block");
        ul.b bVarJ = ul.k.j(g0Var, i10);
        if (bVarJ == null) {
            return;
        }
        do {
            try {
                m mVar = bVarJ.f15821b;
                int i12 = mVar.f15874c - mVar.f15873b;
                if (i12 >= i10) {
                    try {
                        i10 = ((Number) lVar.invoke(bVarJ)).intValue();
                        m mVar2 = bVarJ.f15821b;
                        i12 = mVar2.f15874c - mVar2.f15873b;
                    } catch (Throwable th2) {
                        m mVar3 = bVarJ.f15821b;
                        int i13 = mVar3.f15874c;
                        int i14 = mVar3.f15873b;
                        throw th2;
                    }
                }
                if (i12 == 0) {
                    try {
                        bVarM = ul.k.m(g0Var, bVarJ);
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = false;
                        if (z10) {
                            ul.k.e(g0Var, bVarJ);
                        }
                        throw th;
                    }
                } else if (i12 < i10 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                    ul.k.e(g0Var, bVarJ);
                    bVarM = ul.k.j(g0Var, i10);
                } else {
                    bVarM = bVarJ;
                }
                if (bVarM == null) {
                    z10 = false;
                    break;
                }
                bVarJ = bVarM;
            } catch (Throwable th4) {
                th = th4;
                if (z10) {
                    ul.k.e(g0Var, bVarJ);
                }
                throw th;
            }
        } while (i10 > 0);
        if (z10) {
            ul.k.e(g0Var, bVarJ);
        }
    }

    public static final long a(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return g0Var.t1(Long.MAX_VALUE);
    }

    public static final void b(@os.l g0 g0Var, int i10) {
        kn.l0.p(g0Var, "<this>");
        c(g0Var, i10);
    }

    public static final void c(@os.l g0 g0Var, long j10) {
        kn.l0.p(g0Var, "<this>");
        long jT1 = g0Var.t1(j10);
        if (jT1 != j10) {
            throw new IllegalStateException(k.d.a(j.b.a("Only ", jT1, " bytes were discarded of "), j10, " requested"));
        }
    }

    @f0
    public static final void d(@os.l g0 g0Var, @os.l jn.l<? super Byte, l2> lVar) throws Throwable {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(lVar, "block");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            return;
        }
        do {
            try {
                ByteBuffer byteBuffer = bVarJ.f15820a;
                m mVar = bVarJ.f15821b;
                int i10 = mVar.f15873b;
                int i11 = mVar.f15874c;
                for (int i12 = i10; i12 < i11; i12++) {
                    lVar.invoke(Byte.valueOf(byteBuffer.get(i12)));
                }
                bVarJ.h(i11 - i10);
                try {
                    bVarJ = ul.k.m(g0Var, bVarJ);
                } catch (Throwable th2) {
                    th = th2;
                    z10 = false;
                    if (z10) {
                        ul.k.e(g0Var, bVarJ);
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } while (bVarJ != null);
    }

    @f0
    public static final char e(@os.l g0 g0Var) throws EOFException {
        kn.l0.p(g0Var, "<this>");
        int iG = g0Var.G();
        if ((iG & 128) == 0) {
            return (char) iG;
        }
        if (iG != -1) {
            return f(g0Var, iG);
        }
        throw new EOFException("Failed to peek a char: end of input");
    }

    public static final char f(g0 g0Var, int i10) throws Throwable {
        boolean z10;
        int i11;
        ul.b bVarM;
        boolean z11;
        boolean z12;
        int iA = ul.j.a(i10);
        ul.b bVarJ = ul.k.j(g0Var, iA);
        char cK = '?';
        if (bVarJ == null) {
            z12 = false;
        } else {
            boolean z13 = false;
            while (true) {
                try {
                    m mVar = bVarJ.f15821b;
                    int i12 = mVar.f15874c;
                    int i13 = mVar.f15873b;
                    int i14 = i12 - i13;
                    if (i14 >= iA) {
                        try {
                            ByteBuffer byteBuffer = bVarJ.f15820a;
                            int i15 = i13;
                            int i16 = 0;
                            int i17 = 0;
                            int i18 = 0;
                            while (true) {
                                if (i15 >= i12) {
                                    bVarJ.h(i12 - i13);
                                    i11 = 0;
                                    break;
                                }
                                int i19 = i15 + 1;
                                byte b10 = byteBuffer.get(i15);
                                int i20 = b10 & 255;
                                i11 = -1;
                                if ((b10 & 128) != 0) {
                                    if (i16 == 0) {
                                        int i21 = 128;
                                        i18 = i16;
                                        i17 = i20;
                                        int i22 = 1;
                                        while (i22 < 7) {
                                            i22++;
                                            if ((i17 & i21) == 0) {
                                                break;
                                            }
                                            i17 &= ~i21;
                                            i21 >>= 1;
                                            i18++;
                                        }
                                        i16 = i18 - 1;
                                        if (i18 > i12 - i15) {
                                            bVarJ.h(i15 - i13);
                                            i11 = i18;
                                            break;
                                        }
                                    } else {
                                        i17 = (b10 & 127) | (i17 << 6);
                                        i16--;
                                        if (i16 == 0) {
                                            if (ul.j.l(i17)) {
                                                cK = (char) i17;
                                                bVarJ.h(((i15 - i13) - i18) + 1);
                                            } else {
                                                if (!ul.j.m(i17)) {
                                                    ul.j.p(i17);
                                                    throw new lm.y();
                                                }
                                                cK = (char) ul.j.k(i17);
                                                bVarJ.h(((i15 - i13) - i18) + 1);
                                            }
                                        }
                                    }
                                    i15 = i19;
                                } else {
                                    if (i16 != 0) {
                                        ul.j.o(i16);
                                        throw new lm.y();
                                    }
                                    cK = (char) i20;
                                    bVarJ.h(i15 - i13);
                                }
                                z13 = true;
                                break;
                            }
                            m mVar2 = bVarJ.f15821b;
                            i14 = mVar2.f15874c - mVar2.f15873b;
                            iA = i11;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i23 = mVar3.f15874c;
                            int i24 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i14 == 0) {
                        try {
                            bVarM = ul.k.m(g0Var, bVarJ);
                        } catch (Throwable th3) {
                            th = th3;
                            z10 = false;
                            if (z10) {
                                ul.k.e(g0Var, bVarJ);
                            }
                            throw th;
                        }
                    } else if (i14 < iA || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, iA);
                    } else {
                        bVarM = bVarJ;
                    }
                    if (bVarM == null) {
                        z11 = false;
                        break;
                    }
                    bVarJ = bVarM;
                    if (iA <= 0) {
                        z11 = true;
                        break;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z10 = true;
                }
            }
            if (z11) {
                ul.k.e(g0Var, bVarJ);
            }
            z12 = z13;
        }
        if (z12) {
            return cK;
        }
        throw new ul.f("No UTF-8 character found");
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int g(g0 g0Var, o0 o0Var, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(o0Var, "dst");
        return i0.a(g0Var, o0Var, i10);
    }

    @in.i(name = "readAvailable")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int h(g0 g0Var, byte[] bArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(bArr, "dst");
        return i0.b(g0Var, bArr, i10, i11);
    }

    @in.i(name = "readAvailable")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int i(g0 g0Var, double[] dArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(dArr, "dst");
        return i0.c(g0Var, dArr, i10, i11);
    }

    @in.i(name = "readAvailable")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int j(g0 g0Var, float[] fArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(fArr, "dst");
        return i0.d(g0Var, fArr, i10, i11);
    }

    @in.i(name = "readAvailable")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int k(g0 g0Var, int[] iArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(iArr, "dst");
        return i0.e(g0Var, iArr, i10, i11);
    }

    @in.i(name = "readAvailable")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int l(g0 g0Var, long[] jArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(jArr, "dst");
        return i0.f(g0Var, jArr, i10, i11);
    }

    @in.i(name = "readAvailable")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ int m(g0 g0Var, short[] sArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(sArr, "dst");
        return i0.g(g0Var, sArr, i10, i11);
    }

    public static int n(g0 g0Var, o0 o0Var, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            m mVar = o0Var.f15821b;
            i10 = mVar.f15872a - mVar.f15874c;
        }
        return g(g0Var, o0Var, i10);
    }

    public static /* synthetic */ int o(g0 g0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        return h(g0Var, bArr, i10, i11);
    }

    public static /* synthetic */ int p(g0 g0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        return i(g0Var, dArr, i10, i11);
    }

    public static /* synthetic */ int q(g0 g0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        return j(g0Var, fArr, i10, i11);
    }

    public static /* synthetic */ int r(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return k(g0Var, iArr, i10, i11);
    }

    public static /* synthetic */ int s(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return l(g0Var, jArr, i10, i11);
    }

    public static /* synthetic */ int t(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return m(g0Var, sArr, i10, i11);
    }

    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void u(g0 g0Var, o0 o0Var, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(o0Var, "dst");
        i0.q(g0Var, o0Var, i10);
    }

    @in.i(name = "readFully")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void v(g0 g0Var, byte[] bArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(bArr, "dst");
        i0.r(g0Var, bArr, i10, i11);
    }

    @in.i(name = "readFully")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void w(g0 g0Var, double[] dArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(dArr, "dst");
        i0.s(g0Var, dArr, i10, i11);
    }

    @in.i(name = "readFully")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void x(g0 g0Var, float[] fArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(fArr, "dst");
        i0.t(g0Var, fArr, i10, i11);
    }

    @in.i(name = "readFully")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void y(g0 g0Var, int[] iArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(iArr, "dst");
        i0.u(g0Var, iArr, i10, i11);
    }

    @in.i(name = "readFully")
    @lm.k(level = lm.m.HIDDEN, message = "Binary compatibility.")
    public static final /* synthetic */ void z(g0 g0Var, long[] jArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(jArr, "dst");
        i0.v(g0Var, jArr, i10, i11);
    }
}
