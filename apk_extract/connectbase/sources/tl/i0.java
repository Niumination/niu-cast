package tl;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.EOFException;
import java.nio.ByteBuffer;
import lm.l2;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 {
    public static /* synthetic */ void A(g0 g0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        t(g0Var, fArr, i10, i11);
    }

    public static /* synthetic */ void B(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        u(g0Var, iArr, i10, i11);
    }

    public static /* synthetic */ void C(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        v(g0Var, jArr, i10, i11);
    }

    public static /* synthetic */ void D(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        w(g0Var, sArr, i10, i11);
    }

    public static final void E(@os.l g0 g0Var, @os.l ByteBuffer byteBuffer, int i10, int i11) throws EOFException {
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        F(g0Var, byteBuffer, i10, i11);
    }

    public static final void F(@os.l g0 g0Var, @os.l ByteBuffer byteBuffer, long j10, long j11) throws EOFException {
        kn.l0.p(g0Var, "$this$readFully");
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        if (p(g0Var, byteBuffer, j10, j11) == j11) {
            return;
        }
        d1.d(j11);
        throw new lm.y();
    }

    public static final int G(g0 g0Var, int i10, int i11, jn.q<? super e, ? super Integer, ? super Integer, l2> qVar) throws Throwable {
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            while (true) {
                try {
                    m mVar = bVarJ.f15821b;
                    int iMin = Math.min(i11, mVar.f15874c - mVar.f15873b);
                    qVar.invoke(bVarJ, Integer.valueOf(i10), Integer.valueOf(iMin));
                    i11 -= iMin;
                    i10 += iMin;
                    if (i11 <= 0) {
                        break;
                    }
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
        return i11;
    }

    public static final long H(g0 g0Var, long j10, long j11, jn.r<? super ql.f, ? super Long, ? super Long, ? super Integer, l2> rVar) throws Throwable {
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            while (true) {
                try {
                    m mVar = bVarJ.f15821b;
                    int iMin = (int) Math.min(j11, mVar.f15874c - mVar.f15873b);
                    rVar.invoke(ql.f.b(bVarJ.f15820a), Long.valueOf(bVarJ.f15821b.f15873b), Long.valueOf(j10), Integer.valueOf(iMin));
                    bVarJ.h(iMin);
                    long j12 = iMin;
                    j11 -= j12;
                    j10 += j12;
                    if (j11 <= 0) {
                        break;
                    }
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
        return j11;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    public static final int I(g0 g0Var, int i10, int i11, int i12, jn.q<? super e, ? super Integer, ? super Integer, l2> qVar) throws Throwable {
        ul.b bVarM;
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            int i13 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i14 = mVar.f15874c;
                    int i15 = mVar.f15873b;
                    int i16 = i14 - i15;
                    if (i16 >= i13) {
                        try {
                            int iMin = Math.min(i11, (i14 - i15) / i12);
                            qVar.invoke(bVarJ, Integer.valueOf(i10), Integer.valueOf(iMin));
                            i11 -= iMin;
                            i10 += iMin;
                            i13 = i11 > 0 ? i12 : 0;
                            m mVar2 = bVarJ.f15821b;
                            i16 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i17 = mVar3.f15874c;
                            int i18 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i16 == 0) {
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
                    } else if (i16 < i13 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i13);
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
            } while (i13 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        return i11;
    }

    public static final void J(int i10) {
        if (i10 > 0) {
            throw pl.h.a(i10);
        }
    }

    public static final int a(@os.l g0 g0Var, @os.l e eVar, int i10) throws Throwable {
        int i11;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(eVar, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i11 = i10;
        } else {
            i11 = i10;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int iMin = Math.min(i11, mVar.f15874c - mVar.f15873b);
                    l.E(bVarJ, eVar, iMin);
                    i11 -= iMin;
                    if (i11 <= 0) {
                        ul.k.e(g0Var, bVarJ);
                        break;
                    }
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
        return i10 - i11;
    }

    public static final int b(@os.l g0 g0Var, @os.l byte[] bArr, int i10, int i11) {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(bArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
        } else {
            i12 = i11;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int iMin = Math.min(i12, mVar.f15874c - mVar.f15873b);
                    l.F(bVarJ, bArr, i10, iMin);
                    i12 -= iMin;
                    i10 += iMin;
                    if (i12 <= 0) {
                        ul.k.e(g0Var, bVarJ);
                        break;
                    }
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
        return i11 - i12;
    }

    public static final int c(@os.l g0 g0Var, @os.l double[] dArr, int i10, int i11) throws Throwable {
        int i12;
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(dArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
        } else {
            i12 = i11;
            int i13 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i14 = mVar.f15874c;
                    int i15 = mVar.f15873b;
                    int i16 = i14 - i15;
                    if (i16 >= i13) {
                        try {
                            int iMin = Math.min(i12, (i14 - i15) / 8);
                            l.G(bVarJ, dArr, i10, iMin);
                            i12 -= iMin;
                            i10 += iMin;
                            i13 = i12 > 0 ? 8 : 0;
                            m mVar2 = bVarJ.f15821b;
                            i16 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i17 = mVar3.f15874c;
                            int i18 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i16 == 0) {
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
                    } else if (i16 < i13 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i13);
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
            } while (i13 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        return i11 - i12;
    }

    public static final int d(@os.l g0 g0Var, @os.l float[] fArr, int i10, int i11) throws Throwable {
        int i12;
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(fArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
        } else {
            i12 = i11;
            int i13 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i14 = mVar.f15874c;
                    int i15 = mVar.f15873b;
                    int i16 = i14 - i15;
                    if (i16 >= i13) {
                        try {
                            int iMin = Math.min(i12, (i14 - i15) / 4);
                            l.H(bVarJ, fArr, i10, iMin);
                            i12 -= iMin;
                            i10 += iMin;
                            i13 = i12 <= 0 ? 0 : 4;
                            m mVar2 = bVarJ.f15821b;
                            i16 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i17 = mVar3.f15874c;
                            int i18 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i16 == 0) {
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
                    } else if (i16 < i13 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i13);
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
            } while (i13 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        return i11 - i12;
    }

    public static final int e(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) throws Throwable {
        int i12;
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(iArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
        } else {
            i12 = i11;
            int i13 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i14 = mVar.f15874c;
                    int i15 = mVar.f15873b;
                    int i16 = i14 - i15;
                    if (i16 >= i13) {
                        try {
                            int iMin = Math.min(i12, (i14 - i15) / 4);
                            l.I(bVarJ, iArr, i10, iMin);
                            i12 -= iMin;
                            i10 += iMin;
                            i13 = i12 <= 0 ? 0 : 4;
                            m mVar2 = bVarJ.f15821b;
                            i16 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i17 = mVar3.f15874c;
                            int i18 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i16 == 0) {
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
                    } else if (i16 < i13 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i13);
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
            } while (i13 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        return i11 - i12;
    }

    public static final int f(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) throws Throwable {
        int i12;
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(jArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
        } else {
            i12 = i11;
            int i13 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i14 = mVar.f15874c;
                    int i15 = mVar.f15873b;
                    int i16 = i14 - i15;
                    if (i16 >= i13) {
                        try {
                            int iMin = Math.min(i12, (i14 - i15) / 8);
                            l.J(bVarJ, jArr, i10, iMin);
                            i12 -= iMin;
                            i10 += iMin;
                            i13 = i12 > 0 ? 8 : 0;
                            m mVar2 = bVarJ.f15821b;
                            i16 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i17 = mVar3.f15874c;
                            int i18 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i16 == 0) {
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
                    } else if (i16 < i13 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i13);
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
            } while (i13 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        return i11 - i12;
    }

    public static final int g(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) throws Throwable {
        int i12;
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(sArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
        } else {
            i12 = i11;
            int i13 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i14 = mVar.f15874c;
                    int i15 = mVar.f15873b;
                    int i16 = i14 - i15;
                    if (i16 >= i13) {
                        try {
                            int iMin = Math.min(i12, (i14 - i15) / 2);
                            l.K(bVarJ, sArr, i10, iMin);
                            i12 -= iMin;
                            i10 += iMin;
                            i13 = i12 <= 0 ? 0 : 2;
                            m mVar2 = bVarJ.f15821b;
                            i16 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i17 = mVar3.f15874c;
                            int i18 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i16 == 0) {
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
                    } else if (i16 < i13 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i13);
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
            } while (i13 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        return i11 - i12;
    }

    public static int h(g0 g0Var, e eVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            m mVar = eVar.f15821b;
            i10 = mVar.f15872a - mVar.f15874c;
        }
        return a(g0Var, eVar, i10);
    }

    public static /* synthetic */ int i(g0 g0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        return b(g0Var, bArr, i10, i11);
    }

    public static /* synthetic */ int j(g0 g0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        return c(g0Var, dArr, i10, i11);
    }

    public static /* synthetic */ int k(g0 g0Var, float[] fArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = fArr.length - i10;
        }
        return d(g0Var, fArr, i10, i11);
    }

    public static /* synthetic */ int l(g0 g0Var, int[] iArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = iArr.length - i10;
        }
        return e(g0Var, iArr, i10, i11);
    }

    public static /* synthetic */ int m(g0 g0Var, long[] jArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = jArr.length - i10;
        }
        return f(g0Var, jArr, i10, i11);
    }

    public static /* synthetic */ int n(g0 g0Var, short[] sArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = sArr.length - i10;
        }
        return g(g0Var, sArr, i10, i11);
    }

    public static final int o(@os.l g0 g0Var, @os.l ByteBuffer byteBuffer, int i10, int i11) {
        kn.l0.p(g0Var, "$this$readAvailable");
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        return (int) p(g0Var, byteBuffer, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0070  */
    public static final long p(@os.l g0 g0Var, @os.l ByteBuffer byteBuffer, long j10, long j11) throws Throwable {
        long j12;
        ul.b bVar;
        boolean z10;
        kn.l0.p(g0Var, "$this$readAvailable");
        kn.l0.p(byteBuffer, RtspHeaders.Values.DESTINATION);
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            j12 = j11;
        } else {
            long j13 = j10;
            j12 = j11;
            ul.b bVarM = bVarJ;
            do {
                try {
                    m mVar = bVarM.f15821b;
                    int iMin = (int) Math.min(j12, mVar.f15874c - mVar.f15873b);
                    long j14 = iMin;
                    long j15 = j12;
                    bVar = bVarM;
                    try {
                        ql.f.e(bVarM.f15820a, byteBuffer, bVarM.f15821b.f15873b, j14, j13);
                        bVar.h(iMin);
                        j12 = j15 - j14;
                        j13 += j14;
                        if (j12 <= 0) {
                            ul.k.e(g0Var, bVar);
                            break;
                        }
                        try {
                            bVarM = ul.k.m(g0Var, bVar);
                        } catch (Throwable th2) {
                            th = th2;
                            z10 = false;
                            if (z10) {
                                ul.k.e(g0Var, bVar);
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        z10 = true;
                        if (z10) {
                            ul.k.e(g0Var, bVar);
                        }
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bVar = bVarM;
                }
            } while (bVarM != null);
        }
        long j16 = j11 - j12;
        if (j16 == 0 && g0Var.B1()) {
            return -1L;
        }
        return j16;
    }

    public static final void q(@os.l g0 g0Var, @os.l e eVar, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(eVar, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int iMin = Math.min(i10, mVar.f15874c - mVar.f15873b);
                    l.E(bVarJ, eVar, iMin);
                    i10 -= iMin;
                    if (i10 <= 0) {
                        ul.k.e(g0Var, bVarJ);
                        break;
                    }
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
        if (i10 > 0) {
            throw pl.h.a(i10);
        }
    }

    public static final void r(@os.l g0 g0Var, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(bArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int iMin = Math.min(i11, mVar.f15874c - mVar.f15873b);
                    l.F(bVarJ, bArr, i10, iMin);
                    i11 -= iMin;
                    i10 += iMin;
                    if (i11 <= 0) {
                        ul.k.e(g0Var, bVarJ);
                        break;
                    }
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
        if (i11 > 0) {
            throw pl.h.a(i11);
        }
    }

    public static final void s(@os.l g0 g0Var, @os.l double[] dArr, int i10, int i11) {
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(dArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            int i12 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c;
                    int i14 = mVar.f15873b;
                    int i15 = i13 - i14;
                    if (i15 >= i12) {
                        try {
                            int iMin = Math.min(i11, (i13 - i14) / 8);
                            l.G(bVarJ, dArr, i10, iMin);
                            i11 -= iMin;
                            i10 += iMin;
                            i12 = i11 > 0 ? 8 : 0;
                            m mVar2 = bVarJ.f15821b;
                            i15 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i16 = mVar3.f15874c;
                            int i17 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i15 == 0) {
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
                    } else if (i15 < i12 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i12);
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
            } while (i12 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        if (i11 > 0) {
            throw pl.h.a(i11);
        }
    }

    public static final void t(@os.l g0 g0Var, @os.l float[] fArr, int i10, int i11) {
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(fArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            int i12 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c;
                    int i14 = mVar.f15873b;
                    int i15 = i13 - i14;
                    if (i15 >= i12) {
                        try {
                            int iMin = Math.min(i11, (i13 - i14) / 4);
                            l.H(bVarJ, fArr, i10, iMin);
                            i11 -= iMin;
                            i10 += iMin;
                            i12 = i11 <= 0 ? 0 : 4;
                            m mVar2 = bVarJ.f15821b;
                            i15 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i16 = mVar3.f15874c;
                            int i17 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i15 == 0) {
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
                    } else if (i15 < i12 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i12);
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
            } while (i12 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        if (i11 > 0) {
            throw pl.h.a(i11);
        }
    }

    public static final void u(@os.l g0 g0Var, @os.l int[] iArr, int i10, int i11) {
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(iArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            int i12 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c;
                    int i14 = mVar.f15873b;
                    int i15 = i13 - i14;
                    if (i15 >= i12) {
                        try {
                            int iMin = Math.min(i11, (i13 - i14) / 4);
                            l.I(bVarJ, iArr, i10, iMin);
                            i11 -= iMin;
                            i10 += iMin;
                            i12 = i11 <= 0 ? 0 : 4;
                            m mVar2 = bVarJ.f15821b;
                            i15 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i16 = mVar3.f15874c;
                            int i17 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i15 == 0) {
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
                    } else if (i15 < i12 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i12);
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
            } while (i12 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        if (i11 > 0) {
            throw pl.h.a(i11);
        }
    }

    public static final void v(@os.l g0 g0Var, @os.l long[] jArr, int i10, int i11) {
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(jArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            int i12 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c;
                    int i14 = mVar.f15873b;
                    int i15 = i13 - i14;
                    if (i15 >= i12) {
                        try {
                            int iMin = Math.min(i11, (i13 - i14) / 8);
                            l.J(bVarJ, jArr, i10, iMin);
                            i11 -= iMin;
                            i10 += iMin;
                            i12 = i11 > 0 ? 8 : 0;
                            m mVar2 = bVarJ.f15821b;
                            i15 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i16 = mVar3.f15874c;
                            int i17 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i15 == 0) {
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
                    } else if (i15 < i12 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i12);
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
            } while (i12 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        if (i11 > 0) {
            throw pl.h.a(i11);
        }
    }

    public static final void w(@os.l g0 g0Var, @os.l short[] sArr, int i10, int i11) {
        ul.b bVarM;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(sArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ != null) {
            int i12 = 1;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c;
                    int i14 = mVar.f15873b;
                    int i15 = i13 - i14;
                    if (i15 >= i12) {
                        try {
                            int iMin = Math.min(i11, (i13 - i14) / 2);
                            l.K(bVarJ, sArr, i10, iMin);
                            i11 -= iMin;
                            i10 += iMin;
                            i12 = i11 <= 0 ? 0 : 2;
                            m mVar2 = bVarJ.f15821b;
                            i15 = mVar2.f15874c - mVar2.f15873b;
                        } catch (Throwable th2) {
                            m mVar3 = bVarJ.f15821b;
                            int i16 = mVar3.f15874c;
                            int i17 = mVar3.f15873b;
                            throw th2;
                        }
                    }
                    if (i15 == 0) {
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
                    } else if (i15 < i12 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i12);
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
            } while (i12 > 0);
            if (z10) {
                ul.k.e(g0Var, bVarJ);
            }
        }
        if (i11 > 0) {
            throw pl.h.a(i11);
        }
    }

    public static void x(g0 g0Var, e eVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            m mVar = eVar.f15821b;
            i10 = mVar.f15872a - mVar.f15874c;
        }
        q(g0Var, eVar, i10);
    }

    public static /* synthetic */ void y(g0 g0Var, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length - i10;
        }
        r(g0Var, bArr, i10, i11);
    }

    public static /* synthetic */ void z(g0 g0Var, double[] dArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = dArr.length - i10;
        }
        s(g0Var, dArr, i10, i11);
    }
}
