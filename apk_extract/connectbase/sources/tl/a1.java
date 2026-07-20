package tl;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class a1 {
    public static final int a(@os.l e eVar, @os.l jn.l<? super Byte, Boolean> lVar, @os.l q0 q0Var) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(lVar, "predicate");
        kn.l0.p(q0Var, "dst");
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBuffer = eVar.f15820a;
        while (i10 != i11 && !lVar.invoke(Byte.valueOf(byteBuffer.get(i10))).booleanValue()) {
            i10++;
        }
        int i12 = i10 - eVar.f15821b.f15873b;
        s0.h(q0Var, eVar, i12);
        return i12;
    }

    public static final int b(@os.l e eVar, @os.l jn.l<? super Byte, Boolean> lVar, @os.l byte[] bArr, int i10, int i11) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(lVar, "predicate");
        kn.l0.p(bArr, "dst");
        m mVar = eVar.f15821b;
        int i12 = mVar.f15873b;
        int iMin = Math.min(mVar.f15874c, i11 + i12);
        ByteBuffer byteBuffer = eVar.f15820a;
        int i13 = i12;
        while (i13 < iMin) {
            int i14 = i13 + 1;
            if (lVar.invoke(Byte.valueOf(byteBuffer.get(i13))).booleanValue()) {
                iMin = i13;
                break;
            }
            i13 = i14;
        }
        int i15 = iMin - i12;
        ql.i.a(byteBuffer, bArr, i12, i15, i10);
        return i15;
    }

    public static final long c(@os.l g0 g0Var, byte b10) throws Throwable {
        kn.l0.p(g0Var, "<this>");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        long j10 = 0;
        if (bVarJ != null) {
            do {
                try {
                    int iD = z0.d(bVarJ, b10);
                    j10 += (long) iD;
                    if (iD > 0) {
                        m mVar = bVarJ.f15821b;
                        if (mVar.f15874c <= mVar.f15873b) {
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
                        }
                    }
                    ul.k.e(g0Var, bVarJ);
                    break;
                } catch (Throwable th3) {
                    th = th3;
                }
            } while (bVarJ != null);
        }
        return j10;
    }

    public static final int d(@os.l e eVar, byte b10) {
        kn.l0.p(eVar, "buffer");
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBuffer = eVar.f15820a;
        int i12 = i10;
        while (i12 < i11 && byteBuffer.get(i12) != b10) {
            i12++;
        }
        eVar.n(i12);
        return i12 - i10;
    }

    public static final long e(@os.l g0 g0Var, byte b10, byte b11) throws Throwable {
        kn.l0.p(g0Var, "<this>");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        long j10 = 0;
        if (bVarJ != null) {
            do {
                try {
                    int iF = z0.f(bVarJ, b10, b11);
                    j10 += (long) iF;
                    if (iF > 0) {
                        m mVar = bVarJ.f15821b;
                        if (mVar.f15874c <= mVar.f15873b) {
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
                        }
                    }
                    ul.k.e(g0Var, bVarJ);
                    break;
                } catch (Throwable th3) {
                    th = th3;
                }
            } while (bVarJ != null);
        }
        return j10;
    }

    public static final int f(@os.l e eVar, byte b10, byte b11) {
        kn.l0.p(eVar, "buffer");
        m mVar = eVar.f15821b;
        int i10 = mVar.f15873b;
        int i11 = mVar.f15874c;
        ByteBuffer byteBuffer = eVar.f15820a;
        int i12 = i10;
        while (i12 < i11) {
            byte b12 = byteBuffer.get(i12);
            if (b12 == b10 || b12 == b11) {
                break;
            }
            i12++;
        }
        eVar.n(i12);
        return i12 - i10;
    }

    public static final int g(@os.l g0 g0Var, byte b10, @os.l byte[] bArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(bArr, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i10;
        } else {
            i12 = i10;
            do {
                try {
                    int iM = z0.m(bVarJ, b10, bArr, i12, i11);
                    i12 += iM;
                    i11 -= iM;
                    if (i11 > 0) {
                        m mVar = bVarJ.f15821b;
                        if (mVar.f15874c <= mVar.f15873b) {
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
                        }
                    }
                    ul.k.e(g0Var, bVarJ);
                    break;
                } catch (Throwable th3) {
                    th = th3;
                }
            } while (bVarJ != null);
        }
        return i12 - i10;
    }

    public static final long h(@os.l g0 g0Var, byte b10, @os.l q0 q0Var) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(q0Var, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        long jL = 0;
        if (bVarJ != null) {
            do {
                try {
                    jL += (long) z0.l(bVarJ, b10, q0Var);
                    m mVar = bVarJ.f15821b;
                    if (mVar.f15874c > mVar.f15873b) {
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
        return jL;
    }

    public static /* synthetic */ int i(g0 g0Var, byte b10, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = bArr.length;
        }
        return g(g0Var, b10, bArr, i10, i11);
    }

    public static final int j(@os.l g0 g0Var, byte b10, byte b11, @os.l byte[] bArr, int i10, int i11) throws Throwable {
        int i12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(bArr, "dst");
        if (b10 == b11) {
            return g(g0Var, b10, bArr, i10, i11);
        }
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i10;
        } else {
            i12 = i10;
            do {
                try {
                    int iS = z0.s(bVarJ, b10, b11, bArr, i12, i11);
                    i12 += iS;
                    i11 -= iS;
                    m mVar = bVarJ.f15821b;
                    if (mVar.f15874c > mVar.f15873b || i11 <= 0) {
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
        return i12 - i10;
    }

    public static final long k(@os.l g0 g0Var, byte b10, byte b11, @os.l q0 q0Var) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(q0Var, "dst");
        boolean z10 = true;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        long jR = 0;
        if (bVarJ != null) {
            do {
                try {
                    jR += (long) z0.r(bVarJ, b10, b11, q0Var);
                    m mVar = bVarJ.f15821b;
                    if (mVar.f15874c > mVar.f15873b) {
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
        return jR;
    }

    public static /* synthetic */ int l(g0 g0Var, byte b10, byte b11, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            i10 = 0;
        }
        int i13 = i10;
        if ((i12 & 16) != 0) {
            i11 = bArr.length;
        }
        return j(g0Var, b10, b11, bArr, i13, i11);
    }
}
