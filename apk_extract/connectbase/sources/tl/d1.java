package tl;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Arrays;
import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
public final class d1 {
    public static /* synthetic */ String A(g0 g0Var, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return y(g0Var, charset, i10);
    }

    @os.l
    public static final String B(@os.l g0 g0Var, int i10, @os.l Charset charset) throws EOFException {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(charset, "charset");
        String strO = o(g0Var, charset, i10);
        if (strO.length() >= i10) {
            return strO;
        }
        e(i10);
        throw new lm.y();
    }

    public static /* synthetic */ String C(g0 g0Var, int i10, Charset charset, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        return B(g0Var, i10, charset);
    }

    @os.m
    public static final String D(@os.l v vVar, int i10, int i11) {
        kn.l0.p(vVar, "<this>");
        if (vVar.B1()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(i10);
        if (H(vVar, sb2, i11)) {
            return sb2.toString();
        }
        return null;
    }

    @os.m
    public static final String E(@os.l g0 g0Var, int i10, int i11) {
        kn.l0.p(g0Var, "<this>");
        StringBuilder sb2 = new StringBuilder(i10);
        if (H(g0Var, sb2, i11)) {
            return sb2.toString();
        }
        return null;
    }

    public static /* synthetic */ String F(v vVar, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 16;
        }
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return D(vVar, i10, i11);
    }

    public static /* synthetic */ String G(g0 g0Var, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 16;
        }
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return E(g0Var, i10, i11);
    }

    /* JADX WARN: Code duplicated, block: B:155:0x0205  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean H(@os.l g0 g0Var, @os.l Appendable appendable, int i10) throws Throwable {
        int i11;
        int i12;
        int i13;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        ul.b bVarM;
        int i14;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(appendable, "out");
        int i15 = 1;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i14 = 1;
            i11 = 0;
        } else {
            int i16 = 1;
            int i17 = 1;
            i11 = 0;
            boolean z14 = false;
            boolean z15 = false;
            do {
                try {
                    m mVar = bVarJ.f15821b;
                    int i18 = mVar.f15874c;
                    int i19 = mVar.f15873b;
                    int i20 = i18 - i19;
                    if (i20 >= i16) {
                        try {
                            ByteBuffer byteBuffer = bVarJ.f15820a;
                            int i21 = i19;
                            int i22 = 0;
                            int i23 = 0;
                            int i24 = 0;
                            int i25 = 0;
                            while (true) {
                                if (i21 < i18) {
                                    i21++;
                                    byte b10 = byteBuffer.get(i21);
                                    int i26 = b10 & 255;
                                    byteBuffer = byteBuffer;
                                    boolean z16 = z15;
                                    if ((b10 & 128) != 0) {
                                        if (i22 == 0) {
                                            int i27 = 128;
                                            i23 = i26;
                                            i24 = i22;
                                            int i28 = 1;
                                            while (i28 < 7) {
                                                i28++;
                                                if ((i23 & i27) == 0) {
                                                    break;
                                                }
                                                i23 &= ~i27;
                                                i27 >>= 1;
                                                i24++;
                                            }
                                            i22 = i24 - 1;
                                            if (i24 > i18 - i21) {
                                                bVarJ.h(i21 - i19);
                                                i17 = i24;
                                                i13 = i25;
                                                z15 = z16;
                                            }
                                        } else {
                                            i23 = (i23 << 6) | (b10 & 127);
                                            i22--;
                                            if (i22 == 0) {
                                                if (ul.j.l(i23)) {
                                                    char c10 = (char) i23;
                                                    if (c10 == '\r') {
                                                        if (z14) {
                                                            z13 = false;
                                                            z15 = true;
                                                        } else {
                                                            z15 = z16;
                                                            z13 = true;
                                                            z14 = true;
                                                        }
                                                    } else if (c10 == '\n') {
                                                        z13 = false;
                                                        z15 = true;
                                                        i25 = 1;
                                                    } else if (z14) {
                                                        z13 = false;
                                                        z15 = true;
                                                    } else {
                                                        if (i11 == i10) {
                                                            a(i10);
                                                            throw new lm.y();
                                                        }
                                                        i11++;
                                                        appendable.append(c10);
                                                        z15 = z16;
                                                        z13 = true;
                                                    }
                                                    if (!z13) {
                                                        bVarJ.h(((i21 - i19) - i24) + 1);
                                                        i13 = i25;
                                                        i17 = -1;
                                                    }
                                                } else {
                                                    if (!ul.j.m(i23)) {
                                                        ul.j.p(i23);
                                                        throw new lm.y();
                                                    }
                                                    char cK = (char) ul.j.k(i23);
                                                    if (cK == '\r') {
                                                        if (z14) {
                                                            z11 = false;
                                                            z16 = true;
                                                        } else {
                                                            z11 = true;
                                                            z14 = true;
                                                        }
                                                    } else if (cK == '\n') {
                                                        z11 = false;
                                                        i25 = 1;
                                                        z16 = true;
                                                    } else if (z14) {
                                                        z11 = false;
                                                        z16 = true;
                                                    } else {
                                                        if (i11 == i10) {
                                                            a(i10);
                                                            throw new lm.y();
                                                        }
                                                        i11++;
                                                        appendable.append(cK);
                                                        z11 = true;
                                                    }
                                                    if (z11) {
                                                        char cN = (char) ul.j.n(i23);
                                                        if (cN == '\r') {
                                                            if (z14) {
                                                                z12 = false;
                                                                z16 = true;
                                                            } else {
                                                                z12 = true;
                                                                z14 = true;
                                                            }
                                                        } else if (cN == '\n') {
                                                            z12 = false;
                                                            i25 = 1;
                                                            z16 = true;
                                                        } else if (z14) {
                                                            z12 = false;
                                                            z16 = true;
                                                        } else {
                                                            if (i11 == i10) {
                                                                a(i10);
                                                                throw new lm.y();
                                                            }
                                                            i11++;
                                                            appendable.append(cN);
                                                            z12 = true;
                                                        }
                                                        if (z12) {
                                                            z15 = z16;
                                                        }
                                                    }
                                                    bVarJ.h(((i21 - i19) - i24) + 1);
                                                    i13 = i25;
                                                    z15 = z16;
                                                    i17 = -1;
                                                }
                                                i21 = i21;
                                                byteBuffer = byteBuffer;
                                                i23 = 0;
                                            }
                                        }
                                        z15 = z16;
                                    } else {
                                        if (i22 != 0) {
                                            ul.j.o(i22);
                                            throw new lm.y();
                                        }
                                        char c11 = (char) i26;
                                        if (c11 == '\r') {
                                            if (z14) {
                                                z10 = false;
                                                z15 = true;
                                            } else {
                                                z15 = z16;
                                                z10 = true;
                                                z14 = true;
                                            }
                                        } else if (c11 == '\n') {
                                            z10 = false;
                                            z15 = true;
                                            i25 = 1;
                                        } else if (z14) {
                                            z10 = false;
                                            z15 = true;
                                        } else {
                                            if (i11 == i10) {
                                                a(i10);
                                                throw new lm.y();
                                            }
                                            i11++;
                                            appendable.append(c11);
                                            z15 = z16;
                                            z10 = true;
                                        }
                                        if (!z10) {
                                            bVarJ.h(i21 - i19);
                                            i13 = i25;
                                            i17 = -1;
                                        }
                                    }
                                } else {
                                    bVarJ.h(i18 - i19);
                                    i13 = i25;
                                    z15 = z15;
                                    i17 = 0;
                                }
                                if (i13 > 0) {
                                    bVarJ.h(i13);
                                }
                                if (z15) {
                                    i16 = 0;
                                } else {
                                    i16 = i17 < 1 ? 1 : i17;
                                }
                                try {
                                    m mVar2 = bVarJ.f15821b;
                                    i20 = mVar2.f15874c - mVar2.f15873b;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i12 = 1;
                                    if (i12 != 0) {
                                        ul.k.e(g0Var, bVarJ);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            m mVar3 = bVarJ.f15821b;
                            int i29 = mVar3.f15874c;
                            int i30 = mVar3.f15873b;
                            throw th3;
                        }
                    }
                    if (i20 == 0) {
                        try {
                            bVarM = ul.k.m(g0Var, bVarJ);
                        } catch (Throwable th4) {
                            th = th4;
                            i12 = 0;
                            if (i12 != 0) {
                                ul.k.e(g0Var, bVarJ);
                            }
                            throw th;
                        }
                    } else if (i20 < i16 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVarJ);
                        bVarM = ul.k.j(g0Var, i16);
                    } else {
                        bVarM = bVarJ;
                    }
                    if (bVarM == null) {
                        i15 = 0;
                        break;
                    }
                    bVarJ = bVarM;
                    i15 = 1;
                } catch (Throwable th5) {
                    th = th5;
                    i12 = i15;
                }
            } while (i16 > 0);
            if (i15 != 0) {
                ul.k.e(g0Var, bVarJ);
            }
            i15 = i17;
            i14 = 1;
        }
        if (i15 > i14) {
            throw pl.h.a(i15);
        }
        if (i11 > 0 || !g0Var.B1()) {
            return i14;
        }
        return false;
    }

    @os.l
    public static final String I(@os.l g0 g0Var, @os.l String str, int i10) throws Throwable {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(str, "delimiters");
        StringBuilder sb2 = new StringBuilder();
        K(g0Var, sb2, str, i10);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public static /* synthetic */ String J(g0 g0Var, String str, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return I(g0Var, str, i10);
    }

    public static final int K(@os.l g0 g0Var, @os.l Appendable appendable, @os.l String str, int i10) throws Throwable {
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(appendable, "out");
        kn.l0.p(str, "delimiters");
        ul.b bVarJ = ul.k.j(g0Var, 1);
        boolean z13 = false;
        if (bVarJ == null) {
            i11 = 0;
        } else {
            i11 = 0;
            boolean z14 = false;
            do {
                try {
                    ByteBuffer byteBuffer = bVarJ.f15820a;
                    m mVar = bVarJ.f15821b;
                    int i12 = mVar.f15873b;
                    int i13 = mVar.f15874c;
                    int i14 = i12;
                    while (true) {
                        if (i14 >= i13) {
                            bVarJ.h(i13 - i12);
                            z11 = true;
                            break;
                        }
                        int i15 = i14 + 1;
                        byte b10 = byteBuffer.get(i14);
                        int i16 = b10 & 255;
                        if ((b10 & 128) != 128) {
                            char c10 = (char) i16;
                            if (!jq.h0.S2(str, c10, false, 2, null)) {
                                if (i11 == i10) {
                                    a(i10);
                                    throw new lm.y();
                                }
                                i11++;
                                appendable.append(c10);
                                z12 = true;
                                if (z10) {
                                    ul.k.e(g0Var, bVarJ);
                                }
                                throw th;
                            }
                            z12 = false;
                            z14 = true;
                            if (z12) {
                                i14 = i15;
                            }
                        }
                        bVarJ.h(i14 - i12);
                        z11 = false;
                        break;
                    }
                    if (!z11) {
                        ul.k.e(g0Var, bVarJ);
                        break;
                    }
                    try {
                        bVarJ = ul.k.m(g0Var, bVarJ);
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = false;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z10 = true;
                }
            } while (bVarJ != null);
            z13 = z14;
        }
        return !z13 ? Q(g0Var, appendable, str, i10, i11) : i11;
    }

    @lm.k(level = lm.m.HIDDEN, message = "Use Output version instead")
    public static final /* synthetic */ int L(g0 g0Var, t tVar, String str, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(tVar, "out");
        kn.l0.p(str, "delimiters");
        return M(g0Var, tVar, str, i10);
    }

    public static final int M(@os.l g0 g0Var, @os.l q0 q0Var, @os.l String str, int i10) {
        long jK;
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(q0Var, "out");
        kn.l0.p(str, "delimiters");
        int length = str.length();
        if (length == 1 && str.charAt(0) <= 127) {
            jK = a1.h(g0Var, (byte) str.charAt(0), q0Var);
        } else {
            if (length != 2 || str.charAt(0) > 127 || str.charAt(1) > 127) {
                return S(g0Var, str, i10, q0Var);
            }
            jK = a1.k(g0Var, (byte) str.charAt(0), (byte) str.charAt(1), q0Var);
        }
        return (int) jK;
    }

    public static /* synthetic */ int N(g0 g0Var, Appendable appendable, String str, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return K(g0Var, appendable, str, i10);
    }

    public static /* synthetic */ int O(g0 g0Var, t tVar, String str, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return L(g0Var, tVar, str, i10);
    }

    public static /* synthetic */ int P(g0 g0Var, q0 q0Var, String str, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return M(g0Var, q0Var, str, i10);
    }

    /* JADX WARN: Code duplicated, block: B:120:0x019b  */
    public static final int Q(g0 g0Var, Appendable appendable, String str, int i10, int i11) throws Throwable {
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        ul.b bVarM;
        int i16;
        int i17 = 1;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
            i16 = 1;
        } else {
            int i18 = 1;
            int i19 = 1;
            ul.b bVar = bVarJ;
            i12 = i11;
            while (true) {
                try {
                    m mVar = bVar.f15821b;
                    int i20 = mVar.f15874c;
                    int i21 = mVar.f15873b;
                    int i22 = i20 - i21;
                    if (i22 >= i18) {
                        try {
                            ByteBuffer byteBuffer = bVar.f15820a;
                            int i23 = i21;
                            int i24 = 0;
                            int i25 = 0;
                            int i26 = 0;
                            while (true) {
                                if (i23 < i20) {
                                    int i27 = i23 + 1;
                                    byte b10 = byteBuffer.get(i23);
                                    int i28 = b10 & 255;
                                    ByteBuffer byteBuffer2 = byteBuffer;
                                    if ((b10 & 128) != 0) {
                                        if (i24 == 0) {
                                            int i29 = 128;
                                            i25 = i28;
                                            i26 = i24;
                                            int i30 = 1;
                                            while (i30 < 7) {
                                                i30++;
                                                if ((i25 & i29) == 0) {
                                                    break;
                                                }
                                                i25 &= ~i29;
                                                i29 >>= 1;
                                                i26++;
                                            }
                                            i24 = i26 - 1;
                                            if (i26 > i20 - i23) {
                                                bVar.h(i23 - i21);
                                                i15 = -1;
                                                i14 = 0;
                                            }
                                        } else {
                                            i25 = (i25 << 6) | (b10 & 127);
                                            i24--;
                                            if (i24 != 0) {
                                                continue;
                                            } else {
                                                if (ul.j.l(i25)) {
                                                    char c10 = (char) i25;
                                                    if (jq.h0.S2(str, c10, false, 2, null)) {
                                                        z12 = false;
                                                    } else {
                                                        if (i12 == i10) {
                                                            a(i10);
                                                            throw new lm.y();
                                                        }
                                                        i12++;
                                                        appendable.append(c10);
                                                        z12 = true;
                                                    }
                                                    if (z12) {
                                                        i14 = 0;
                                                    } else {
                                                        bVar.h(((i23 - i21) - i26) + 1);
                                                        i15 = -1;
                                                        i14 = 0;
                                                    }
                                                } else {
                                                    if (!ul.j.m(i25)) {
                                                        ul.j.p(i25);
                                                        throw new lm.y();
                                                    }
                                                    char cK = (char) ul.j.k(i25);
                                                    if (jq.h0.S2(str, cK, false, 2, null)) {
                                                        z10 = false;
                                                    } else {
                                                        if (i12 == i10) {
                                                            a(i10);
                                                            throw new lm.y();
                                                        }
                                                        i12++;
                                                        appendable.append(cK);
                                                        z10 = true;
                                                    }
                                                    if (z10) {
                                                        char cN = (char) ul.j.n(i25);
                                                        i14 = 0;
                                                        if (jq.h0.S2(str, cN, false, 2, null)) {
                                                            z11 = false;
                                                        } else {
                                                            if (i12 == i10) {
                                                                a(i10);
                                                                throw new lm.y();
                                                            }
                                                            i12++;
                                                            appendable.append(cN);
                                                            z11 = true;
                                                        }
                                                        if (!z11) {
                                                        }
                                                    } else {
                                                        i14 = 0;
                                                    }
                                                    bVar.h(((i23 - i21) - i26) + 1);
                                                    i15 = -1;
                                                }
                                                i25 = i14;
                                            }
                                        }
                                        i23 = i27;
                                        byteBuffer = byteBuffer2;
                                    } else {
                                        if (i24 != 0) {
                                            ul.j.o(i24);
                                            throw new lm.y();
                                        }
                                        char c11 = (char) i28;
                                        if (jq.h0.S2(str, c11, false, 2, null)) {
                                            z13 = false;
                                        } else {
                                            if (i12 == i10) {
                                                a(i10);
                                                throw new lm.y();
                                            }
                                            i12++;
                                            appendable.append(c11);
                                            z13 = true;
                                        }
                                        if (z13) {
                                            i23 = i27;
                                            byteBuffer = byteBuffer2;
                                        } else {
                                            bVar.h(i23 - i21);
                                            i15 = -1;
                                            i14 = 0;
                                        }
                                    }
                                    i26 = -1;
                                } else {
                                    i14 = 0;
                                    bVar.h(i20 - i21);
                                    i26 = 0;
                                    i15 = -1;
                                }
                                if (i26 == i15) {
                                    i18 = i14;
                                } else {
                                    i18 = i26 < 1 ? 1 : i26;
                                }
                                try {
                                    m mVar2 = bVar.f15821b;
                                    i22 = mVar2.f15874c - mVar2.f15873b;
                                    i19 = i18;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i13 = 1;
                                    if (i13 != 0) {
                                        ul.k.e(g0Var, bVar);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            m mVar3 = bVar.f15821b;
                            int i31 = mVar3.f15874c;
                            int i32 = mVar3.f15873b;
                            throw th3;
                        }
                    } else {
                        i14 = 0;
                    }
                    if (i22 == 0) {
                        try {
                            bVarM = ul.k.m(g0Var, bVar);
                        } catch (Throwable th4) {
                            th = th4;
                            i13 = i14;
                            if (i13 != 0) {
                                ul.k.e(g0Var, bVar);
                            }
                            throw th;
                        }
                    } else if (i22 < i18 || bVar.f15822c - bVar.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVar);
                        bVarM = ul.k.j(g0Var, i18);
                    } else {
                        bVarM = bVar;
                    }
                    if (bVarM == null) {
                        break;
                    }
                    bVar = bVarM;
                    if (i18 <= 0) {
                        i14 = 1;
                        break;
                    }
                    i17 = 1;
                } catch (Throwable th5) {
                    th = th5;
                    i13 = i17;
                }
            }
            if (i14 != 0) {
                ul.k.e(g0Var, bVar);
            }
            i17 = i19;
            i16 = 1;
        }
        if (i17 <= i16) {
            return i12;
        }
        throw pl.h.a(i17);
    }

    /* JADX WARN: Code duplicated, block: B:124:0x01a2  */
    public static final int R(g0 g0Var, q0 q0Var, String str, int i10, int i11) throws Throwable {
        int i12;
        int i13;
        int i14;
        ul.b bVarM;
        int i15;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i16 = 1;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            i12 = i11;
            i15 = 1;
        } else {
            int i17 = 1;
            int i18 = 1;
            ul.b bVar = bVarJ;
            i12 = i11;
            while (true) {
                try {
                    m mVar = bVar.f15821b;
                    int i19 = mVar.f15874c;
                    int i20 = mVar.f15873b;
                    int i21 = i19 - i20;
                    if (i21 >= i17) {
                        int i22 = i19 - i20;
                        try {
                            ByteBuffer byteBuffer = bVar.f15820a;
                            int i23 = i20;
                            int i24 = 0;
                            int i25 = 0;
                            int i26 = 0;
                            while (true) {
                                if (i23 < i19) {
                                    int i27 = i23 + 1;
                                    byte b10 = byteBuffer.get(i23);
                                    int i28 = b10 & 255;
                                    ByteBuffer byteBuffer2 = byteBuffer;
                                    if ((b10 & 128) != 0) {
                                        if (i24 == 0) {
                                            int i29 = 128;
                                            i25 = i28;
                                            i26 = i24;
                                            int i30 = 1;
                                            while (i30 < 7) {
                                                i30++;
                                                if ((i25 & i29) == 0) {
                                                    break;
                                                }
                                                i25 &= ~i29;
                                                i29 >>= 1;
                                                i26++;
                                            }
                                            i24 = i26 - 1;
                                            if (i26 > i19 - i23) {
                                                bVar.h(i23 - i20);
                                                i14 = 0;
                                            }
                                        } else {
                                            i25 = (i25 << 6) | (b10 & 127);
                                            i24--;
                                            if (i24 != 0) {
                                                continue;
                                            } else {
                                                if (ul.j.l(i25)) {
                                                    if (jq.h0.S2(str, (char) i25, false, 2, null)) {
                                                        z12 = false;
                                                    } else {
                                                        if (i12 == i10) {
                                                            a(i10);
                                                            throw new lm.y();
                                                        }
                                                        i12++;
                                                        z12 = true;
                                                    }
                                                    if (z12) {
                                                        i14 = 0;
                                                    } else {
                                                        bVar.h(((i23 - i20) - i26) + 1);
                                                        i14 = 0;
                                                    }
                                                } else {
                                                    if (!ul.j.m(i25)) {
                                                        ul.j.p(i25);
                                                        throw new lm.y();
                                                    }
                                                    if (jq.h0.S2(str, (char) ul.j.k(i25), false, 2, null)) {
                                                        z10 = false;
                                                    } else {
                                                        if (i12 == i10) {
                                                            a(i10);
                                                            throw new lm.y();
                                                        }
                                                        i12++;
                                                        z10 = true;
                                                    }
                                                    if (z10) {
                                                        i14 = 0;
                                                        if (jq.h0.S2(str, (char) ul.j.n(i25), false, 2, null)) {
                                                            z11 = false;
                                                        } else {
                                                            if (i12 == i10) {
                                                                a(i10);
                                                                throw new lm.y();
                                                            }
                                                            i12++;
                                                            z11 = true;
                                                        }
                                                        if (!z11) {
                                                        }
                                                    } else {
                                                        i14 = 0;
                                                    }
                                                    bVar.h(((i23 - i20) - i26) + 1);
                                                }
                                                i25 = i14;
                                            }
                                        }
                                        i23 = i27;
                                        byteBuffer = byteBuffer2;
                                    } else {
                                        if (i24 != 0) {
                                            ul.j.o(i24);
                                            throw new lm.y();
                                        }
                                        if (jq.h0.S2(str, (char) i28, false, 2, null)) {
                                            z13 = false;
                                        } else {
                                            if (i12 == i10) {
                                                a(i10);
                                                throw new lm.y();
                                            }
                                            i12++;
                                            z13 = true;
                                        }
                                        if (z13) {
                                            i23 = i27;
                                            byteBuffer = byteBuffer2;
                                        } else {
                                            bVar.h(i23 - i20);
                                            i14 = 0;
                                        }
                                    }
                                    i26 = -1;
                                } else {
                                    i14 = 0;
                                    bVar.h(i19 - i20);
                                    i26 = 0;
                                }
                                m mVar2 = bVar.f15821b;
                                int i31 = i22 - (mVar2.f15874c - mVar2.f15873b);
                                if (i31 > 0) {
                                    bVar.y0(i31);
                                    s0.h(q0Var, bVar, i31);
                                }
                                if (i26 == -1) {
                                    i17 = i14;
                                } else {
                                    if (i26 < 1) {
                                        i26 = 1;
                                    }
                                    i17 = i26;
                                }
                                try {
                                    m mVar3 = bVar.f15821b;
                                    i21 = mVar3.f15874c - mVar3.f15873b;
                                    i18 = i17;
                                } catch (Throwable th2) {
                                    th = th2;
                                    i13 = 1;
                                    if (i13 != 0) {
                                        ul.k.e(g0Var, bVar);
                                    }
                                    throw th;
                                }
                            }
                        } catch (Throwable th3) {
                            m mVar4 = bVar.f15821b;
                            int i32 = mVar4.f15874c;
                            int i33 = mVar4.f15873b;
                            throw th3;
                        }
                    } else {
                        i14 = 0;
                    }
                    if (i21 == 0) {
                        try {
                            bVarM = ul.k.m(g0Var, bVar);
                        } catch (Throwable th4) {
                            th = th4;
                            i13 = i14;
                            if (i13 != 0) {
                                ul.k.e(g0Var, bVar);
                            }
                            throw th;
                        }
                    } else if (i21 < i17 || bVar.f15822c - bVar.f15821b.f15872a < 8) {
                        ul.k.e(g0Var, bVar);
                        bVarM = ul.k.j(g0Var, i17);
                    } else {
                        bVarM = bVar;
                    }
                    if (bVarM == null) {
                        break;
                    }
                    bVar = bVarM;
                    if (i17 <= 0) {
                        i14 = 1;
                        break;
                    }
                    i16 = 1;
                } catch (Throwable th5) {
                    th = th5;
                    i13 = i16;
                }
            }
            if (i14 != 0) {
                ul.k.e(g0Var, bVar);
            }
            i16 = i18;
            i15 = 1;
        }
        if (i16 <= i15) {
            return i12;
        }
        throw pl.h.a(i16);
    }

    public static final int S(g0 g0Var, String str, int i10, q0 q0Var) throws Throwable {
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        ul.b bVarJ = ul.k.j(g0Var, 1);
        if (bVarJ == null) {
            z14 = false;
            i11 = 0;
        } else {
            i11 = 0;
            boolean z16 = false;
            while (true) {
                try {
                    m mVar = bVarJ.f15821b;
                    int i12 = mVar.f15874c;
                    int i13 = mVar.f15873b;
                    int i14 = i12 - i13;
                    ByteBuffer byteBuffer = bVarJ.f15820a;
                    int i15 = i13;
                    while (true) {
                        if (i15 >= i12) {
                            z11 = z16;
                            z12 = false;
                            bVarJ.h(i12 - i13);
                            z13 = true;
                            break;
                        }
                        int i16 = i15 + 1;
                        byte b10 = byteBuffer.get(i15);
                        int i17 = b10 & 255;
                        if ((b10 & 128) != 128) {
                            z11 = z16;
                            z12 = false;
                            if (!jq.h0.S2(str, (char) i17, false, 2, null)) {
                                if (i11 == i10) {
                                    a(i10);
                                    throw new lm.y();
                                }
                                i11++;
                                z15 = true;
                                if (z10) {
                                    ul.k.e(g0Var, bVarJ);
                                }
                                throw th;
                            }
                            z15 = false;
                            z11 = true;
                            if (z15) {
                                i15 = i16;
                                z16 = z11;
                            }
                        } else {
                            z11 = z16;
                            z12 = false;
                        }
                        bVarJ.h(i15 - i13);
                        z13 = z12;
                        break;
                    }
                    m mVar2 = bVarJ.f15821b;
                    int i18 = i14 - (mVar2.f15874c - mVar2.f15873b);
                    if (i18 > 0) {
                        bVarJ.y0(i18);
                        s0.h(q0Var, bVarJ, i18);
                    }
                    if (!z13) {
                        ul.k.e(g0Var, bVarJ);
                        break;
                    }
                    try {
                        bVarJ = ul.k.m(g0Var, bVarJ);
                        if (bVarJ == null) {
                            break;
                        }
                        z16 = z11;
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = z12;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    z10 = true;
                }
            }
            z14 = z11;
        }
        return (z14 || g0Var.B1()) ? i11 : R(g0Var, q0Var, str, i10, i11);
    }

    @os.l
    public static final byte[] T(@os.l String str, @os.l Charset charset) {
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        return rl.a.j(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static /* synthetic */ byte[] U(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        kn.l0.p(str, "<this>");
        kn.l0.p(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        return rl.a.j(charsetEncoderNewEncoder, str, 0, str.length());
    }

    public static final void V(@os.l q0 q0Var, @os.l CharSequence charSequence, int i10, int i11, @os.l Charset charset) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(charSequence, "text");
        kn.l0.p(charset, "charset");
        if (charset == jq.f.f8800b) {
            b0(q0Var, charSequence, i10, i11);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        rl.b.m(charsetEncoderNewEncoder, q0Var, charSequence, i10, i11);
    }

    @lm.k(level = lm.m.ERROR, message = "Use the implementation with Charset instead", replaceWith = @lm.a1(expression = "writeText(text, fromIndex, toIndex, encoder.charset)", imports = {"io.ktor.utils.io.charsets.charset"}))
    public static final void W(@os.l q0 q0Var, @os.l CharSequence charSequence, int i10, int i11, @os.l CharsetEncoder charsetEncoder) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(charSequence, "text");
        kn.l0.p(charsetEncoder, "encoder");
        rl.b.m(charsetEncoder, q0Var, charSequence, i10, i11);
    }

    public static final void X(@os.l q0 q0Var, @os.l char[] cArr, int i10, int i11, @os.l Charset charset) {
        kn.l0.p(q0Var, "<this>");
        kn.l0.p(cArr, "text");
        kn.l0.p(charset, "charset");
        if (charset == jq.f.f8800b) {
            b0(q0Var, new ul.a(cArr, 0, cArr.length), i10, i11);
            return;
        }
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        rl.b.e(charsetEncoderNewEncoder, cArr, i10, i11, q0Var);
    }

    public static /* synthetic */ void Y(q0 q0Var, CharSequence charSequence, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        if ((i12 & 8) != 0) {
            charset = jq.f.f8800b;
        }
        V(q0Var, charSequence, i10, i11, charset);
    }

    public static /* synthetic */ void Z(q0 q0Var, CharSequence charSequence, int i10, int i11, CharsetEncoder charsetEncoder, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        W(q0Var, charSequence, i10, i11, charsetEncoder);
    }

    public static final Void a(int i10) throws j {
        throw new j(k.b.a("Too many characters before delimiter: limit ", i10, " exceeded"));
    }

    public static /* synthetic */ void a0(q0 q0Var, char[] cArr, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = cArr.length;
        }
        if ((i12 & 8) != 0) {
            charset = jq.f.f8800b;
        }
        X(q0Var, cArr, i10, i11, charset);
    }

    public static final boolean b(char c10) {
        return c10 <= 127;
    }

    public static final void b0(q0 q0Var, CharSequence charSequence, int i10, int i11) {
        int i12;
        ul.b bVarO = ul.k.o(q0Var, 1, null);
        while (true) {
            try {
                ByteBuffer byteBuffer = bVarO.f15820a;
                m mVar = bVarO.f15821b;
                int iH = ul.j.h(byteBuffer, charSequence, i10, i11, mVar.f15874c, mVar.f15872a);
                int iM = g2.m((short) (iH >>> 16)) & g2.f10190d;
                i10 += iM;
                bVarO.b(((short) (iH & 65535)) & g2.f10190d);
                if (iM != 0 || i10 >= i11) {
                    i12 = i10 < i11 ? 1 : 0;
                } else {
                    i12 = 8;
                }
                if (i12 <= 0) {
                    ul.k.b(q0Var, bVarO);
                    return;
                }
                bVarO = ul.k.o(q0Var, i12, bVarO);
            } catch (Throwable th2) {
                ul.k.b(q0Var, bVarO);
                throw th2;
            }
        }
    }

    @lm.z0
    @os.l
    public static final Void c(int i10) throws EOFException {
        throw new EOFException(k.b.a("Premature end of stream: expected ", i10, " bytes"));
    }

    @lm.z0
    @os.l
    public static final Void d(long j10) throws EOFException {
        throw new EOFException(j1.g.a("Premature end of stream: expected ", j10, " bytes"));
    }

    public static final Void e(int i10) throws EOFException {
        throw new EOFException(k.b.a("Not enough input bytes to read ", i10, " characters."));
    }

    @os.l
    public static final byte[] f(@os.l v vVar, int i10) {
        kn.l0.p(vVar, "<this>");
        if (i10 == 0) {
            return ul.k.f16328a;
        }
        byte[] bArr = new byte[i10];
        i0.r(vVar, bArr, 0, i10);
        return bArr;
    }

    @os.l
    public static final byte[] g(@os.l g0 g0Var) {
        kn.l0.p(g0Var, "<this>");
        return k(g0Var, 0, 0, 3, null);
    }

    @os.l
    public static final byte[] h(@os.l g0 g0Var, int i10) {
        kn.l0.p(g0Var, "<this>");
        return j(g0Var, i10, i10);
    }

    public static /* synthetic */ byte[] i(v vVar, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            long jS0 = vVar.S0();
            if (jS0 > 2147483647L) {
                throw new IllegalArgumentException("Unable to convert to a ByteArray: packet is too big");
            }
            i10 = (int) jS0;
        }
        return f(vVar, i10);
    }

    @os.l
    public static final byte[] j(@os.l g0 g0Var, int i10, int i11) throws EOFException {
        int iB;
        kn.l0.p(g0Var, "<this>");
        if (i10 == i11 && i10 == 0) {
            return ul.k.f16328a;
        }
        int i12 = 0;
        if (i10 == i11) {
            byte[] bArr = new byte[i10];
            i0.r(g0Var, bArr, 0, i10);
            return bArr;
        }
        byte[] bArrCopyOf = new byte[(int) tn.u.v(tn.u.C(i11, rl.b.o(g0Var)), i10)];
        while (i12 < i11 && (iB = i0.b(g0Var, bArrCopyOf, i12, Math.min(i11, bArrCopyOf.length) - i12)) > 0) {
            i12 += iB;
            if (bArrCopyOf.length == i12) {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i12 * 2);
                kn.l0.o(bArrCopyOf, "copyOf(this, newSize)");
            }
        }
        if (i12 < i10) {
            StringBuilder sbA = h.b.a("Not enough bytes available to read ", i10, " bytes: ");
            sbA.append(i10 - i12);
            sbA.append(" more required");
            throw new EOFException(sbA.toString());
        }
        if (i12 == bArrCopyOf.length) {
            return bArrCopyOf;
        }
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrCopyOf, i12);
        kn.l0.o(bArrCopyOf2, "copyOf(this, newSize)");
        return bArrCopyOf2;
    }

    public static /* synthetic */ byte[] k(g0 g0Var, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = Integer.MAX_VALUE;
        }
        return j(g0Var, i10, i11);
    }

    public static final int l(@os.l g0 g0Var, @os.l Appendable appendable, @os.l Charset charset, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(appendable, "out");
        kn.l0.p(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        kn.l0.o(charsetDecoderNewDecoder, "charset.newDecoder()");
        return rl.a.b(charsetDecoderNewDecoder, g0Var, appendable, i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Use CharsetDecoder.decode instead", replaceWith = @lm.a1(expression = "decoder.decode(this, out, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    public static final int m(@os.l g0 g0Var, @os.l Appendable appendable, @os.l CharsetDecoder charsetDecoder, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(appendable, "out");
        kn.l0.p(charsetDecoder, "decoder");
        return rl.a.b(charsetDecoder, g0Var, appendable, i10);
    }

    @os.l
    public static final String n(@os.l e eVar, @os.l Charset charset, int i10) {
        kn.l0.p(eVar, "<this>");
        kn.l0.p(charset, "charset");
        StringBuilder sb2 = new StringBuilder();
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        kn.l0.o(charsetDecoderNewDecoder, "charset.newDecoder()");
        rl.a.c(charsetDecoderNewDecoder, eVar, sb2, true, i10);
        String string = sb2.toString();
        kn.l0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @os.l
    public static final String o(@os.l g0 g0Var, @os.l Charset charset, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        kn.l0.o(charsetDecoderNewDecoder, "charset.newDecoder()");
        return rl.b.a(charsetDecoderNewDecoder, g0Var, i10);
    }

    @lm.k(message = "Use CharsetDecoder.decode instead", replaceWith = @lm.a1(expression = "decoder.decode(this, max)", imports = {"io.ktor.utils.io.charsets.decode"}))
    @os.l
    public static final String p(@os.l g0 g0Var, @os.l CharsetDecoder charsetDecoder, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(charsetDecoder, "decoder");
        return rl.b.a(charsetDecoder, g0Var, i10);
    }

    public static /* synthetic */ int q(g0 g0Var, Appendable appendable, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return l(g0Var, appendable, charset, i10);
    }

    public static /* synthetic */ int r(g0 g0Var, Appendable appendable, CharsetDecoder charsetDecoder, int i10, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return m(g0Var, appendable, charsetDecoder, i10);
    }

    public static /* synthetic */ String s(e eVar, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return n(eVar, charset, i10);
    }

    public static /* synthetic */ String t(g0 g0Var, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return o(g0Var, charset, i10);
    }

    public static /* synthetic */ String u(g0 g0Var, CharsetDecoder charsetDecoder, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return p(g0Var, charsetDecoder, i10);
    }

    @lm.k(message = "Use readTextExactCharacters instead.", replaceWith = @lm.a1(expression = "readTextExactCharacters(n, charset)", imports = {}))
    @os.l
    public static final String v(@os.l g0 g0Var, @os.l Charset charset, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(charset, "charset");
        return B(g0Var, i10, charset);
    }

    public static /* synthetic */ String w(g0 g0Var, Charset charset, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            charset = jq.f.f8800b;
        }
        return v(g0Var, charset, i10);
    }

    @os.l
    public static final String x(@os.l g0 g0Var, int i10, @os.l Charset charset) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(charset, "charset");
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        kn.l0.o(charsetDecoderNewDecoder, "charset.newDecoder()");
        return rl.a.e(charsetDecoderNewDecoder, g0Var, i10);
    }

    @lm.k(message = "Parameters order is changed.", replaceWith = @lm.a1(expression = "readTextExactBytes(bytes, charset)", imports = {}))
    @os.l
    public static final String y(@os.l g0 g0Var, @os.l Charset charset, int i10) {
        kn.l0.p(g0Var, "<this>");
        kn.l0.p(charset, "charset");
        return x(g0Var, i10, charset);
    }

    public static /* synthetic */ String z(g0 g0Var, int i10, Charset charset, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        return x(g0Var, i10, charset);
    }
}
