package rl;

import f1.j5;
import java.nio.ByteBuffer;
import jq.h0;
import kn.l0;
import lm.y;
import os.l;
import tl.f0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14555a = 1114111;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14556b = 56320;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f14557c = 55296;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f14558d = 65536;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f14559e = 55232;

    @f0
    public static final long a(@l ByteBuffer byteBuffer, @l char[] cArr, int i10, int i11) {
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        int iA = d.a(byteBuffer, cArr, i10, i11);
        if (!byteBuffer.hasRemaining() || iA == i11) {
            return j(iA, 0);
        }
        return byteBuffer.hasArray() ? k(iA, f(byteBuffer, cArr, i10 + iA, i11 - iA)) : k(iA, h(byteBuffer, cArr, i10 + iA, i11 - iA));
    }

    @f0
    public static final long b(@l ByteBuffer byteBuffer, @l char[] cArr, int i10, int i11) {
        l0.p(byteBuffer, "<this>");
        l0.p(cArr, "out");
        return byteBuffer.hasArray() ? d(byteBuffer, cArr, i10, i11) : e(byteBuffer, cArr, i10, i11);
    }

    public static /* synthetic */ long c(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        return b(byteBuffer, cArr, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:136:0x004b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:137:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x014c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:141:0x00d8 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:146:0x0081 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0051  */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:67:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:88:0x013d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x013f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0142 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:92:0x0144  */
    /* JADX WARN: Code duplicated, block: B:94:0x0147 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x014e  */
    public static final long d(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) throws Throwable {
        long jA;
        boolean z10;
        char c10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (iPosition > iRemaining) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (iRemaining > bArrArray.length) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i12 = i10 + i11;
        if (i12 > cArr.length) {
            throw n(i10, i11, cArr.length);
        }
        int i13 = i10;
        boolean z15 = false;
        while (true) {
            if (iPosition >= iRemaining || i13 >= i12) {
                jA = g.a(byteBuffer, iPosition, i13, i10, 0);
            } else {
                int i14 = iPosition + 1;
                byte b10 = bArrArray[iPosition];
                if (b10 >= 0) {
                    char c11 = (char) b10;
                    if (c11 == '\r') {
                        z15 = true;
                    } else {
                        if (c11 == '\n') {
                            z15 = false;
                        } else {
                            if (z15) {
                            }
                            if (z10) {
                                cArr[i13] = c11;
                                i13++;
                                iPosition = i14;
                            } else {
                                jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                            }
                        }
                        z10 = false;
                        if (z10) {
                            jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                        } else {
                            cArr[i13] = c11;
                            i13++;
                            iPosition = i14;
                        }
                    }
                    z10 = true;
                    if (z10) {
                        jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                    } else {
                        cArr[i13] = c11;
                        i13++;
                        iPosition = i14;
                    }
                } else if ((b10 & 224) == 192) {
                    if (i14 >= iRemaining) {
                        jA = g.a(byteBuffer, iPosition, i13, i10, 2);
                    } else {
                        int i15 = iPosition + 2;
                        char c12 = (char) ((bArrArray[i14] & fl.h.f6042b) | ((b10 & c1.c.I) << 6));
                        if (c12 == '\r') {
                            z15 = true;
                        } else {
                            if (c12 == '\n') {
                                z15 = false;
                            } else {
                                if (z15) {
                                }
                                if (z14) {
                                    cArr[i13] = c12;
                                    i13++;
                                    iPosition = i15;
                                } else {
                                    jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                                }
                            }
                            z14 = false;
                            if (z14) {
                                jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                            } else {
                                cArr[i13] = c12;
                                i13++;
                                iPosition = i15;
                            }
                        }
                        z14 = true;
                        if (z14) {
                            jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                        } else {
                            cArr[i13] = c12;
                            i13++;
                            iPosition = i15;
                        }
                    }
                } else if ((b10 & 240) == 224) {
                    if (iRemaining - i14 < 2) {
                        jA = g.a(byteBuffer, iPosition, i13, i10, 3);
                    } else {
                        byte b11 = bArrArray[i14];
                        int i16 = iPosition + 3;
                        byte b12 = bArrArray[iPosition + 2];
                        int i17 = b10 & c1.c.f1123q;
                        int i18 = (b12 & fl.h.f6042b) | ((b11 & fl.h.f6042b) << 6) | (i17 << 12);
                        if (i17 != 0 && !o(i18)) {
                            r(i18);
                            throw new y();
                        }
                        char c13 = (char) i18;
                        if (c13 == '\r') {
                            z15 = true;
                        } else {
                            if (c13 == '\n') {
                                z15 = false;
                            } else {
                                if (z15) {
                                }
                                if (z13) {
                                    cArr[i13] = c13;
                                    i13++;
                                    iPosition = i16;
                                } else {
                                    jA = g.a(byteBuffer, iPosition - 1, i13, i10, -1);
                                }
                            }
                            z13 = false;
                            if (z13) {
                                jA = g.a(byteBuffer, iPosition - 1, i13, i10, -1);
                            } else {
                                cArr[i13] = c13;
                                i13++;
                                iPosition = i16;
                            }
                        }
                        z13 = true;
                        if (z13) {
                            jA = g.a(byteBuffer, iPosition - 1, i13, i10, -1);
                        } else {
                            cArr[i13] = c13;
                            i13++;
                            iPosition = i16;
                        }
                    }
                } else {
                    if ((b10 & 248) != 240) {
                        s(b10);
                        throw new y();
                    }
                    if (iRemaining - i14 < 3) {
                        jA = g.a(byteBuffer, iPosition, i13, i10, 4);
                    } else {
                        byte b13 = bArrArray[i14];
                        byte b14 = bArrArray[iPosition + 2];
                        i14 = iPosition + 4;
                        byte b15 = bArrArray[iPosition + 3];
                        int i19 = ((b14 & fl.h.f6042b) << 6) | ((b13 & fl.h.f6042b) << 12) | ((b10 & 7) << 18) | (b15 & fl.h.f6042b);
                        if (!p(i19)) {
                            r(i19);
                            throw new y();
                        }
                        if (i12 - i13 >= 2) {
                            char cM = (char) m(i19);
                            char cQ = (char) q(i19);
                            if (cM == '\r') {
                                z15 = true;
                                c10 = '\n';
                            } else {
                                c10 = '\n';
                                if (cM == '\n') {
                                    z15 = false;
                                } else {
                                    if (z15) {
                                    }
                                    if (z11) {
                                        if (cQ == '\r') {
                                            z15 = true;
                                        } else {
                                            if (cQ == c10) {
                                                z15 = false;
                                            } else {
                                                if (z15) {
                                                }
                                                if (z12) {
                                                    int i20 = i13 + 1;
                                                    cArr[i13] = cM;
                                                    i13 += 2;
                                                    cArr[i20] = cQ;
                                                    iPosition = i14;
                                                }
                                            }
                                            z12 = false;
                                            if (z12) {
                                                int i21 = i13 + 1;
                                                cArr[i13] = cM;
                                                i13 += 2;
                                                cArr[i21] = cQ;
                                                iPosition = i14;
                                            }
                                        }
                                        z12 = true;
                                        if (z12) {
                                            int i22 = i13 + 1;
                                            cArr[i13] = cM;
                                            i13 += 2;
                                            cArr[i22] = cQ;
                                            iPosition = i14;
                                        }
                                    }
                                    jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                                }
                                z11 = false;
                                if (z11) {
                                    if (cQ == '\r') {
                                        z15 = true;
                                    } else {
                                        if (cQ == c10) {
                                            z15 = false;
                                        } else {
                                            if (z15) {
                                            }
                                            if (z12) {
                                                int i23 = i13 + 1;
                                                cArr[i13] = cM;
                                                i13 += 2;
                                                cArr[i23] = cQ;
                                                iPosition = i14;
                                            }
                                        }
                                        z12 = false;
                                        if (z12) {
                                            int i24 = i13 + 1;
                                            cArr[i13] = cM;
                                            i13 += 2;
                                            cArr[i24] = cQ;
                                            iPosition = i14;
                                        }
                                    }
                                    z12 = true;
                                    if (z12) {
                                        int i25 = i13 + 1;
                                        cArr[i13] = cM;
                                        i13 += 2;
                                        cArr[i25] = cQ;
                                        iPosition = i14;
                                    }
                                }
                                jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                            }
                            z11 = true;
                            if (z11) {
                                if (cQ == '\r') {
                                    z15 = true;
                                } else {
                                    if (cQ == c10) {
                                        z15 = false;
                                    } else {
                                        if (z15) {
                                        }
                                        if (z12) {
                                            int i26 = i13 + 1;
                                            cArr[i13] = cM;
                                            i13 += 2;
                                            cArr[i26] = cQ;
                                            iPosition = i14;
                                        }
                                    }
                                    z12 = false;
                                    if (z12) {
                                        int i27 = i13 + 1;
                                        cArr[i13] = cM;
                                        i13 += 2;
                                        cArr[i27] = cQ;
                                        iPosition = i14;
                                    }
                                }
                                z12 = true;
                                if (z12) {
                                    int i28 = i13 + 1;
                                    cArr[i13] = cM;
                                    i13 += 2;
                                    cArr[i28] = cQ;
                                    iPosition = i14;
                                }
                            }
                            jA = g.a(byteBuffer, iPosition, i13, i10, -1);
                        } else {
                            jA = g.a(byteBuffer, iPosition, i13, i10, 0);
                        }
                    }
                }
            }
            int i29 = (int) (4294967295L & jA);
            if (i29 == -1) {
                int i30 = (int) (jA >> 32);
                if (z15) {
                    return j(i30 - 1, -1);
                }
                byteBuffer.position(byteBuffer.position() + 1);
                if (i30 > 0) {
                    int i31 = i30 - 1;
                    if (cArr[i31] == '\r') {
                        return j(i31, -1);
                    }
                }
            } else if (i29 == 0 && z15) {
                return f.a(byteBuffer, 1, (int) (jA >> 32), 1, 2);
            }
            return jA;
        }
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:124:0x0070 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:0x00c6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x0141 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0076  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:83:0x0126 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x0128  */
    /* JADX WARN: Code duplicated, block: B:86:0x012b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x012d  */
    /* JADX WARN: Code duplicated, block: B:88:0x012f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:89:0x0131  */
    /* JADX WARN: Code duplicated, block: B:90:0x0133  */
    /* JADX WARN: Code duplicated, block: B:93:0x0137  */
    public static final long e(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) throws Throwable {
        long j10;
        boolean z10;
        int i12;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int i13 = i10 + i11;
        if (i13 > cArr.length) {
            throw n(i10, i11, cArr.length);
        }
        int i14 = i10;
        boolean z15 = false;
        while (true) {
            if (!byteBuffer.hasRemaining() || i14 >= i13) {
                j10 = j(i14 - i10, 0);
                break;
            }
            byte b10 = byteBuffer.get();
            if (b10 >= 0) {
                char c10 = (char) b10;
                if (c10 == '\r') {
                    z15 = true;
                } else {
                    if (c10 == '\n') {
                        z15 = false;
                    } else {
                        z10 = !z15;
                    }
                    if (!z10) {
                        j10 = f.a(byteBuffer, 1, i14, i10, -1);
                        break;
                    }
                    i12 = i14 + 1;
                    cArr[i14] = c10;
                    i14 = i12;
                }
                z10 = z15;
                if (!z10) {
                    j10 = f.a(byteBuffer, 1, i14, i10, -1);
                    break;
                }
                i12 = i14 + 1;
                cArr[i14] = c10;
                i14 = i12;
            } else if ((b10 & 224) == 192) {
                if (!byteBuffer.hasRemaining()) {
                    j10 = f.a(byteBuffer, 1, i14, i10, 2);
                    break;
                }
                char c11 = (char) (((b10 & c1.c.I) << 6) | (byteBuffer.get() & fl.h.f6042b));
                if (c11 == '\r') {
                    z15 = true;
                } else {
                    if (c11 == '\n') {
                        z15 = false;
                    } else {
                        z11 = !z15;
                    }
                    if (!z11) {
                        j10 = f.a(byteBuffer, 2, i14, i10, -1);
                        break;
                    }
                    i12 = i14 + 1;
                    cArr[i14] = c11;
                    i14 = i12;
                }
                z11 = z15;
                if (!z11) {
                    j10 = f.a(byteBuffer, 2, i14, i10, -1);
                    break;
                }
                i12 = i14 + 1;
                cArr[i14] = c11;
                i14 = i12;
            } else {
                if ((b10 & 240) != 224) {
                    if ((b10 & 248) != 240) {
                        s(b10);
                        throw new y();
                    }
                    if (byteBuffer.remaining() < 3) {
                        j10 = f.a(byteBuffer, 1, i14, i10, 4);
                        break;
                    }
                    int i15 = ((b10 & 7) << 18) | ((byteBuffer.get() & fl.h.f6042b) << 12) | ((byteBuffer.get() & fl.h.f6042b) << 6) | (byteBuffer.get() & fl.h.f6042b);
                    if (!p(i15)) {
                        r(i15);
                        throw new y();
                    }
                    if (i13 - i14 < 2) {
                        j10 = f.a(byteBuffer, 4, i14, i10, 0);
                        break;
                    }
                    char cM = (char) m(i15);
                    char cQ = (char) q(i15);
                    if (cM != '\r') {
                        if (cM == '\n') {
                            z15 = false;
                        } else {
                            z13 = !z15;
                        }
                        if (!z13) {
                            if (cQ == '\r') {
                                z15 = true;
                            } else {
                                if (cQ == '\n') {
                                    z15 = false;
                                } else if (z15) {
                                    z14 = false;
                                } else {
                                    z14 = true;
                                }
                                if (!z14) {
                                    int i16 = i14 + 1;
                                    cArr[i14] = cM;
                                    i14 += 2;
                                    cArr[i16] = cQ;
                                }
                            }
                            z14 = z15;
                            if (!z14) {
                                int i17 = i14 + 1;
                                cArr[i14] = cM;
                                i14 += 2;
                                cArr[i17] = cQ;
                            }
                        }
                        j10 = f.a(byteBuffer, 4, i14, i10, -1);
                        break;
                    }
                    z15 = true;
                    z13 = z15;
                    if (!z13) {
                        if (cQ == '\r') {
                            z15 = true;
                        } else {
                            if (cQ == '\n') {
                                z15 = false;
                            } else if (z15) {
                                z14 = false;
                            } else {
                                z14 = true;
                            }
                            if (!z14) {
                                int i18 = i14 + 1;
                                cArr[i14] = cM;
                                i14 += 2;
                                cArr[i18] = cQ;
                            }
                        }
                        z14 = z15;
                        if (!z14) {
                            int i19 = i14 + 1;
                            cArr[i14] = cM;
                            i14 += 2;
                            cArr[i19] = cQ;
                        }
                    }
                    j10 = f.a(byteBuffer, 4, i14, i10, -1);
                    break;
                }
                if (byteBuffer.remaining() < 2) {
                    j10 = f.a(byteBuffer, 1, i14, i10, 3);
                    break;
                }
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                int i20 = b10 & c1.c.f1123q;
                int i21 = (i20 << 12) | ((b11 & fl.h.f6042b) << 6) | (b12 & fl.h.f6042b);
                if (i20 != 0 && !o(i21)) {
                    r(i21);
                    throw new y();
                }
                char c12 = (char) i21;
                if (c12 == '\r') {
                    z15 = true;
                } else {
                    if (c12 == '\n') {
                        z15 = false;
                    } else {
                        z12 = !z15;
                    }
                    if (!z12) {
                        j10 = f.a(byteBuffer, 3, i14, i10, -1);
                        break;
                    }
                    i12 = i14 + 1;
                    cArr[i14] = c12;
                    i14 = i12;
                }
                z12 = z15;
                if (!z12) {
                    j10 = f.a(byteBuffer, 3, i14, i10, -1);
                    break;
                }
                i12 = i14 + 1;
                cArr[i14] = c12;
                i14 = i12;
            }
        }
        int i22 = (int) (4294967295L & j10);
        if (i22 == -1) {
            int i23 = (int) (j10 >> 32);
            if (z15) {
                return j(i23 - 1, -1);
            }
            byteBuffer.position(byteBuffer.position() + 1);
            if (i23 > 0) {
                int i24 = i23 - 1;
                if (cArr[i24] == '\r') {
                    return j(i24, -1);
                }
            }
        } else if (i22 == 0 && z15) {
            return f.a(byteBuffer, 1, (int) (j10 >> 32), 1, 2);
        }
        return j10;
    }

    public static final long f(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) throws Throwable {
        int i12;
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (iPosition > iRemaining) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (iRemaining > bArrArray.length) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i13 = i10 + i11;
        if (i13 > cArr.length) {
            throw n(i10, i11, cArr.length);
        }
        int i14 = i10;
        while (iPosition < iRemaining && i14 < i13) {
            int i15 = iPosition + 1;
            byte b10 = bArrArray[iPosition];
            if (b10 >= 0) {
                cArr[i14] = (char) b10;
                i14++;
                iPosition = i15;
            } else {
                if ((b10 & 224) == 192) {
                    if (i15 >= iRemaining) {
                        return g.a(byteBuffer, iPosition, i14, i10, 2);
                    }
                    iPosition += 2;
                    byte b11 = bArrArray[i15];
                    i12 = i14 + 1;
                    cArr[i14] = (char) ((b11 & fl.h.f6042b) | ((b10 & c1.c.I) << 6));
                } else if ((b10 & 240) == 224) {
                    if (iRemaining - i15 < 2) {
                        return g.a(byteBuffer, iPosition, i14, i10, 3);
                    }
                    int i16 = iPosition + 2;
                    byte b12 = bArrArray[i15];
                    iPosition += 3;
                    byte b13 = bArrArray[i16];
                    int i17 = b10 & c1.c.f1123q;
                    int i18 = (b12 & fl.h.f6042b) << 6;
                    int i19 = (b13 & fl.h.f6042b) | i18 | (i17 << 12);
                    if (i17 != 0 && !o(i19)) {
                        r(i19);
                        throw new y();
                    }
                    i12 = i14 + 1;
                    cArr[i14] = (char) i19;
                } else {
                    if ((b10 & 248) != 240) {
                        s(b10);
                        throw new y();
                    }
                    if (iRemaining - i15 < 3) {
                        return g.a(byteBuffer, iPosition, i14, i10, 4);
                    }
                    byte b14 = bArrArray[i15];
                    byte b15 = bArrArray[iPosition + 2];
                    int i20 = iPosition + 4;
                    byte b16 = bArrArray[iPosition + 3];
                    int i21 = ((b14 & fl.h.f6042b) << 12) | ((b10 & 7) << 18) | ((b15 & fl.h.f6042b) << 6) | (b16 & fl.h.f6042b);
                    if (!p(i21)) {
                        r(i21);
                        throw new y();
                    }
                    if (i13 - i14 < 2) {
                        return g.a(byteBuffer, iPosition, i14, i10, 0);
                    }
                    int iM = m(i21);
                    int iQ = q(i21);
                    int i22 = i14 + 1;
                    cArr[i14] = (char) iM;
                    i14 += 2;
                    cArr[i22] = (char) iQ;
                    iPosition = i20;
                }
                i14 = i12;
            }
        }
        return g.a(byteBuffer, iPosition, i14, i10, 0);
    }

    public static final long g(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l<? super Character, Boolean> lVar) throws Throwable {
        byte[] bArrArray = byteBuffer.array();
        l0.m(bArrArray);
        int iPosition = byteBuffer.position() + byteBuffer.arrayOffset();
        int iRemaining = byteBuffer.remaining() + iPosition;
        if (iPosition > iRemaining) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        if (iRemaining > bArrArray.length) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        int i12 = i10 + i11;
        if (i12 > cArr.length) {
            throw n(i10, i11, cArr.length);
        }
        int i13 = i10;
        while (iPosition < iRemaining && i13 < i12) {
            int i14 = iPosition + 1;
            byte b10 = bArrArray[iPosition];
            if (b10 >= 0) {
                char c10 = (char) b10;
                if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                    return g.a(byteBuffer, iPosition, i13, i10, -1);
                }
                cArr[i13] = c10;
                i13++;
                iPosition = i14;
            } else if ((b10 & 224) == 192) {
                if (i14 >= iRemaining) {
                    return g.a(byteBuffer, iPosition, i13, i10, 2);
                }
                int i15 = iPosition + 2;
                char c11 = (char) ((bArrArray[i14] & fl.h.f6042b) | ((b10 & c1.c.I) << 6));
                if (!lVar.invoke(Character.valueOf(c11)).booleanValue()) {
                    return g.a(byteBuffer, iPosition, i13, i10, -1);
                }
                cArr[i13] = c11;
                i13++;
                iPosition = i15;
            } else if ((b10 & 240) == 224) {
                if (iRemaining - i14 < 2) {
                    return g.a(byteBuffer, iPosition, i13, i10, 3);
                }
                byte b11 = bArrArray[i14];
                int i16 = iPosition + 3;
                byte b12 = bArrArray[iPosition + 2];
                int i17 = b10 & c1.c.f1123q;
                int i18 = (b12 & fl.h.f6042b) | ((b11 & fl.h.f6042b) << 6) | (i17 << 12);
                if (i17 != 0 && !o(i18)) {
                    r(i18);
                    throw new y();
                }
                char c12 = (char) i18;
                if (!lVar.invoke(Character.valueOf(c12)).booleanValue()) {
                    return g.a(byteBuffer, iPosition - 1, i13, i10, -1);
                }
                cArr[i13] = c12;
                i13++;
                iPosition = i16;
            } else {
                if ((b10 & 248) != 240) {
                    s(b10);
                    throw new y();
                }
                if (iRemaining - i14 < 3) {
                    return g.a(byteBuffer, iPosition, i13, i10, 4);
                }
                byte b13 = bArrArray[i14];
                byte b14 = bArrArray[iPosition + 2];
                int i19 = iPosition + 4;
                byte b15 = bArrArray[iPosition + 3];
                int i20 = ((b14 & fl.h.f6042b) << 6) | ((b13 & fl.h.f6042b) << 12) | ((b10 & 7) << 18) | (b15 & fl.h.f6042b);
                if (!p(i20)) {
                    r(i20);
                    throw new y();
                }
                if (i12 - i13 < 2) {
                    return g.a(byteBuffer, iPosition, i13, i10, 0);
                }
                char cM = (char) m(i20);
                char cQ = (char) q(i20);
                if (!lVar.invoke(Character.valueOf(cM)).booleanValue() || !lVar.invoke(Character.valueOf(cQ)).booleanValue()) {
                    return g.a(byteBuffer, iPosition, i13, i10, -1);
                }
                int i21 = i13 + 1;
                cArr[i13] = cM;
                i13 += 2;
                cArr[i21] = cQ;
                iPosition = i19;
            }
        }
        return g.a(byteBuffer, iPosition, i13, i10, 0);
    }

    public static final long h(ByteBuffer byteBuffer, char[] cArr, int i10, int i11) throws Throwable {
        int i12 = i10 + i11;
        if (i12 > cArr.length) {
            throw n(i10, i11, cArr.length);
        }
        int i13 = i10;
        while (byteBuffer.hasRemaining() && i13 < i12) {
            byte b10 = byteBuffer.get();
            if (b10 >= 0) {
                cArr[i13] = (char) b10;
                i13++;
            } else if ((b10 & 224) == 192) {
                if (byteBuffer.hasRemaining()) {
                    return f.a(byteBuffer, 1, i13, i10, 2);
                }
                cArr[i13] = (char) (((b10 & c1.c.I) << 6) | (byteBuffer.get() & fl.h.f6042b));
                i13++;
            } else if ((b10 & 240) == 224) {
                if (byteBuffer.remaining() < 2) {
                    return f.a(byteBuffer, 1, i13, i10, 3);
                }
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                int i14 = b10 & c1.c.f1123q;
                int i15 = ((b11 & fl.h.f6042b) << 6) | (i14 << 12) | (b12 & fl.h.f6042b);
                if (i14 != 0 && !o(i15)) {
                    r(i15);
                    throw new y();
                }
                cArr[i13] = (char) i15;
                i13++;
            } else {
                if ((b10 & 248) != 240) {
                    s(b10);
                    throw new y();
                }
                if (byteBuffer.remaining() < 3) {
                    return f.a(byteBuffer, 1, i13, i10, 4);
                }
                int i16 = ((b10 & 7) << 18) | ((byteBuffer.get() & fl.h.f6042b) << 12) | ((byteBuffer.get() & fl.h.f6042b) << 6) | (byteBuffer.get() & fl.h.f6042b);
                if (!p(i16)) {
                    r(i16);
                    throw new y();
                }
                if (i12 - i13 < 2) {
                    return f.a(byteBuffer, 4, i13, i10, 0);
                }
                int iM = m(i16);
                int iQ = q(i16);
                int i17 = i13 + 1;
                cArr[i13] = (char) iM;
                i13 += 2;
                cArr[i17] = (char) iQ;
            }
        }
        return j(i13 - i10, 0);
    }

    public static final long i(ByteBuffer byteBuffer, char[] cArr, int i10, int i11, jn.l<? super Character, Boolean> lVar) throws Throwable {
        int i12;
        int i13 = i10 + i11;
        if (i13 > cArr.length) {
            throw n(i10, i11, cArr.length);
        }
        int i14 = i10;
        while (byteBuffer.hasRemaining() && i14 < i13) {
            byte b10 = byteBuffer.get();
            if (b10 >= 0) {
                char c10 = (char) b10;
                if (!lVar.invoke(Character.valueOf(c10)).booleanValue()) {
                    return f.a(byteBuffer, 1, i14, i10, -1);
                }
                i12 = i14 + 1;
                cArr[i14] = c10;
            } else if ((b10 & 224) == 192) {
                if (!byteBuffer.hasRemaining()) {
                    return f.a(byteBuffer, 1, i14, i10, 2);
                }
                char c11 = (char) (((b10 & c1.c.I) << 6) | (byteBuffer.get() & fl.h.f6042b));
                if (!lVar.invoke(Character.valueOf(c11)).booleanValue()) {
                    return f.a(byteBuffer, 2, i14, i10, -1);
                }
                i12 = i14 + 1;
                cArr[i14] = c11;
            } else if ((b10 & 240) == 224) {
                if (byteBuffer.remaining() < 2) {
                    return f.a(byteBuffer, 1, i14, i10, 3);
                }
                byte b11 = byteBuffer.get();
                byte b12 = byteBuffer.get();
                int i15 = b10 & c1.c.f1123q;
                int i16 = ((b11 & fl.h.f6042b) << 6) | (i15 << 12) | (b12 & fl.h.f6042b);
                if (i15 != 0 && !o(i16)) {
                    r(i16);
                    throw new y();
                }
                char c12 = (char) i16;
                if (!lVar.invoke(Character.valueOf(c12)).booleanValue()) {
                    return f.a(byteBuffer, 3, i14, i10, -1);
                }
                i12 = i14 + 1;
                cArr[i14] = c12;
            } else {
                if ((b10 & 248) != 240) {
                    s(b10);
                    throw new y();
                }
                if (byteBuffer.remaining() < 3) {
                    return f.a(byteBuffer, 1, i14, i10, 4);
                }
                int i17 = ((b10 & 7) << 18) | ((byteBuffer.get() & fl.h.f6042b) << 12) | ((byteBuffer.get() & fl.h.f6042b) << 6) | (byteBuffer.get() & fl.h.f6042b);
                if (!p(i17)) {
                    r(i17);
                    throw new y();
                }
                if (i13 - i14 < 2) {
                    return f.a(byteBuffer, 4, i14, i10, 0);
                }
                char cM = (char) m(i17);
                char cQ = (char) q(i17);
                if (!lVar.invoke(Character.valueOf(cM)).booleanValue() || !lVar.invoke(Character.valueOf(cQ)).booleanValue()) {
                    return f.a(byteBuffer, 4, i14, i10, -1);
                }
                int i18 = i14 + 1;
                cArr[i14] = cM;
                i14 += 2;
                cArr[i18] = cQ;
            }
            i14 = i12;
        }
        return j(i14 - i10, 0);
    }

    @ul.d
    public static final long j(int i10, int i11) {
        return (((long) i11) & 4294967295L) | (((long) i10) << 32);
    }

    public static final long k(int i10, long j10) {
        return j(i10 + ((int) (j10 >> 32)), (int) (j10 & 4294967295L));
    }

    @ul.d
    public static final long l(long j10, long j11) {
        return ((j10 & j5.f4984l) + (j5.f4984l & j11)) | (j11 & 4294967295L);
    }

    public static final int m(int i10) {
        return (i10 >>> 10) + 55232;
    }

    public static final Throwable n(int i10, int i11, int i12) {
        return new IndexOutOfBoundsException(i10 + " (offset) + " + i11 + " (length) > " + i12 + " (array.length)");
    }

    public static final boolean o(int i10) {
        return (i10 >>> 16) == 0;
    }

    public static final boolean p(int i10) {
        return i10 <= 1114111;
    }

    public static final int q(int i10) {
        return (i10 & 1023) + 56320;
    }

    public static final Void r(int i10) {
        throw new IllegalArgumentException("Malformed code-point " + ((Object) Integer.toHexString(i10)) + " found");
    }

    public static final Void s(byte b10) {
        String string = Integer.toString(b10 & 255, jq.d.a(16));
        l0.o(string, "toString(this, checkRadix(radix))");
        throw new IllegalStateException(l0.C("Unsupported byte code, first byte is 0x", h0.R3(string, 2, '0')).toString());
    }
}
