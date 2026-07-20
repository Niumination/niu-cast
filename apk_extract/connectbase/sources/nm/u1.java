package nm;

import lm.a2;
import lm.g2;

/* JADX INFO: loaded from: classes3.dex */
public final class u1 {
    @lm.t
    public static final int a(long[] jArr, int i10, int i11) {
        long jM = a2.m(jArr[(i10 + i11) / 2]);
        while (i10 <= i11) {
            while (Long.compareUnsigned(a2.m(jArr[i10]), jM) < 0) {
                i10++;
            }
            while (Long.compareUnsigned(a2.m(jArr[i11]), jM) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                long jM2 = a2.m(jArr[i10]);
                jArr[i10] = a2.m(jArr[i11]);
                jArr[i11] = jM2;
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @lm.t
    public static final int b(byte[] bArr, int i10, int i11) {
        int i12;
        byte bM = lm.s1.m(bArr[(i10 + i11) / 2]);
        while (i10 <= i11) {
            while (true) {
                i12 = bM & 255;
                if (kn.l0.t(lm.s1.m(bArr[i10]) & 255, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (kn.l0.t(lm.s1.m(bArr[i11]) & 255, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                byte bM2 = lm.s1.m(bArr[i10]);
                bArr[i10] = lm.s1.m(bArr[i11]);
                bArr[i11] = bM2;
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @lm.t
    public static final int c(short[] sArr, int i10, int i11) {
        int i12;
        short sM = g2.m(sArr[(i10 + i11) / 2]);
        while (i10 <= i11) {
            while (true) {
                int iM = g2.m(sArr[i10]) & g2.f10190d;
                i12 = sM & g2.f10190d;
                if (kn.l0.t(iM, i12) >= 0) {
                    break;
                }
                i10++;
            }
            while (kn.l0.t(g2.m(sArr[i11]) & g2.f10190d, i12) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                short sM2 = g2.m(sArr[i10]);
                sArr[i10] = g2.m(sArr[i11]);
                sArr[i11] = sM2;
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @lm.t
    public static final int d(int[] iArr, int i10, int i11) {
        int iM = lm.w1.m(iArr[(i10 + i11) / 2]);
        while (i10 <= i11) {
            while (Integer.compareUnsigned(lm.w1.m(iArr[i10]), iM) < 0) {
                i10++;
            }
            while (Integer.compareUnsigned(lm.w1.m(iArr[i11]), iM) > 0) {
                i11--;
            }
            if (i10 <= i11) {
                int iM2 = lm.w1.m(iArr[i10]);
                iArr[i10] = lm.w1.m(iArr[i11]);
                iArr[i11] = iM2;
                i10++;
                i11--;
            }
        }
        return i10;
    }

    @lm.t
    public static final void e(long[] jArr, int i10, int i11) {
        int iA = a(jArr, i10, i11);
        int i12 = iA - 1;
        if (i10 < i12) {
            e(jArr, i10, i12);
        }
        if (iA < i11) {
            e(jArr, iA, i11);
        }
    }

    @lm.t
    public static final void f(byte[] bArr, int i10, int i11) {
        int iB = b(bArr, i10, i11);
        int i12 = iB - 1;
        if (i10 < i12) {
            f(bArr, i10, i12);
        }
        if (iB < i11) {
            f(bArr, iB, i11);
        }
    }

    @lm.t
    public static final void g(short[] sArr, int i10, int i11) {
        int iC = c(sArr, i10, i11);
        int i12 = iC - 1;
        if (i10 < i12) {
            g(sArr, i10, i12);
        }
        if (iC < i11) {
            g(sArr, iC, i11);
        }
    }

    @lm.t
    public static final void h(int[] iArr, int i10, int i11) {
        int iD = d(iArr, i10, i11);
        int i12 = iD - 1;
        if (i10 < i12) {
            h(iArr, i10, i12);
        }
        if (iD < i11) {
            h(iArr, iD, i11);
        }
    }

    @lm.t
    public static final void i(@os.l long[] jArr, int i10, int i11) {
        kn.l0.p(jArr, dc.d.f3685p);
        e(jArr, i10, i11 - 1);
    }

    @lm.t
    public static final void j(@os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(bArr, dc.d.f3685p);
        f(bArr, i10, i11 - 1);
    }

    @lm.t
    public static final void k(@os.l short[] sArr, int i10, int i11) {
        kn.l0.p(sArr, dc.d.f3685p);
        g(sArr, i10, i11 - 1);
    }

    @lm.t
    public static final void l(@os.l int[] iArr, int i10, int i11) {
        kn.l0.p(iArr, dc.d.f3685p);
        h(iArr, i10, i11 - 1);
    }
}
