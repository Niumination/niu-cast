package rl;

import java.io.EOFException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.MalformedInputException;
import kn.l0;
import lm.y;
import os.l;
import tl.g0;
import tl.m;
import tl.q0;
import tl.s0;
import tl.v;
import ul.j;
import ul.k;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f14552a = 8192;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public static final CharBuffer f14553b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public static final ByteBuffer f14554c;

    static {
        CharBuffer charBufferAllocate = CharBuffer.allocate(0);
        l0.m(charBufferAllocate);
        f14553b = charBufferAllocate;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(0);
        l0.m(byteBufferAllocate);
        f14554c = byteBufferAllocate;
    }

    public static /* synthetic */ void a() {
    }

    public static final int b(@l CharsetDecoder charsetDecoder, @l g0 g0Var, @l Appendable appendable, int i10) throws Throwable {
        CoderResult coderResultDecode;
        ul.b bVarM;
        l0.p(charsetDecoder, "<this>");
        l0.p(g0Var, "input");
        l0.p(appendable, "dst");
        CharBuffer charBufferAllocate = CharBuffer.allocate(8192);
        boolean z10 = true;
        ul.b bVarJ = k.j(g0Var, 1);
        int iRemaining = 0;
        if (bVarJ != null) {
            int i11 = 1;
            int i12 = 1;
            int iRemaining2 = 0;
            while (true) {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c;
                    int i14 = mVar.f15873b;
                    int i15 = i13 - i14;
                    if (i15 >= i11) {
                        int i16 = i10 - iRemaining2;
                        if (i16 != 0) {
                            try {
                                int i17 = i13 - i14;
                                ByteBuffer byteBufferN = ql.f.n(bVarJ.f15820a, i14, i17);
                                charBufferAllocate.clear();
                                if (i16 < 8192) {
                                    charBufferAllocate.limit(i16);
                                }
                                CoderResult coderResultDecode2 = charsetDecoder.decode(byteBufferN, charBufferAllocate, false);
                                charBufferAllocate.flip();
                                iRemaining2 += charBufferAllocate.remaining();
                                appendable.append(charBufferAllocate);
                                if (coderResultDecode2.isMalformed() || coderResultDecode2.isUnmappable()) {
                                    l0.o(coderResultDecode2, "rc");
                                    q(coderResultDecode2);
                                }
                                i12 = (coderResultDecode2.isUnderflow() && byteBufferN.hasRemaining()) ? i12 + 1 : 1;
                                if (byteBufferN.limit() != i17) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed");
                                }
                                bVarJ.h(byteBufferN.position());
                                i11 = i12;
                            } catch (Throwable th2) {
                                m mVar2 = bVarJ.f15821b;
                                int i18 = mVar2.f15874c;
                                int i19 = mVar2.f15873b;
                                throw th2;
                            }
                            th = th;
                            if (z10) {
                                k.e(g0Var, bVarJ);
                            }
                            throw th;
                        }
                        i11 = 0;
                        m mVar3 = bVarJ.f15821b;
                        i15 = mVar3.f15874c - mVar3.f15873b;
                    }
                    if (i15 == 0) {
                        try {
                            bVarM = k.m(g0Var, bVarJ);
                        } catch (Throwable th3) {
                            th = th3;
                            z10 = false;
                        }
                    } else if (i15 < i11 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        k.e(g0Var, bVarJ);
                        bVarM = k.j(g0Var, i11);
                    } else {
                        bVarM = bVarJ;
                    }
                    if (bVarM == null) {
                        break;
                    }
                    if (i11 <= 0) {
                        iRemaining = 1;
                        bVarJ = bVarM;
                        break;
                    }
                    bVarJ = bVarM;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            if (iRemaining != 0) {
                k.e(g0Var, bVarJ);
            }
            iRemaining = iRemaining2;
        }
        do {
            charBufferAllocate.clear();
            int i20 = i10 - iRemaining;
            if (i20 == 0) {
                break;
            }
            if (i20 < 8192) {
                charBufferAllocate.limit(i20);
            }
            coderResultDecode = charsetDecoder.decode(f14554c, charBufferAllocate, true);
            charBufferAllocate.flip();
            iRemaining += charBufferAllocate.remaining();
            appendable.append(charBufferAllocate);
            if (coderResultDecode.isUnmappable() || coderResultDecode.isMalformed()) {
                l0.o(coderResultDecode, "cr");
                q(coderResultDecode);
            }
        } while (coderResultDecode.isOverflow());
        return iRemaining;
    }

    public static final int c(@l CharsetDecoder charsetDecoder, @l tl.e eVar, @l Appendable appendable, boolean z10, int i10) {
        l0.p(charsetDecoder, "<this>");
        l0.p(eVar, "input");
        l0.p(appendable, "out");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i11 = mVar.f15873b;
        int i12 = mVar.f15874c - i11;
        ByteBuffer byteBufferN = ql.f.n(byteBuffer, i11, i12);
        ul.b.f16311i.getClass();
        ul.b bVar = (ul.b) ul.b.f16315w.W0();
        CharBuffer charBufferAsCharBuffer = bVar.f15820a.asCharBuffer();
        l0.m(charBufferAsCharBuffer);
        int i13 = 0;
        while (byteBufferN.hasRemaining() && i13 < i10) {
            try {
                int iMin = Math.min(charBufferAsCharBuffer.capacity(), i10 - i13);
                charBufferAsCharBuffer.clear();
                charBufferAsCharBuffer.limit(iMin);
                CoderResult coderResultDecode = charsetDecoder.decode(byteBufferN, charBufferAsCharBuffer, z10);
                if (coderResultDecode.isMalformed() || coderResultDecode.isUnmappable()) {
                    l0.o(coderResultDecode, "result");
                    q(coderResultDecode);
                }
                i13 += iMin;
            } catch (Throwable th2) {
                ul.b.f16311i.getClass();
                bVar.j2(ul.b.f16315w);
                throw th2;
            }
        }
        ul.b.f16311i.getClass();
        bVar.j2(ul.b.f16315w);
        if (byteBufferN.limit() != i12) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        eVar.h(byteBufferN.position());
        return i13;
    }

    public static /* synthetic */ int d(CharsetDecoder charsetDecoder, tl.e eVar, Appendable appendable, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            i10 = Integer.MAX_VALUE;
        }
        return c(charsetDecoder, eVar, appendable, z10, i10);
    }

    @l
    public static final String e(@l CharsetDecoder charsetDecoder, @l g0 g0Var, int i10) throws EOFException {
        l0.p(charsetDecoder, "<this>");
        l0.p(g0Var, "input");
        if (i10 == 0) {
            return "";
        }
        if (g0Var instanceof tl.a) {
            tl.a aVar = (tl.a) g0Var;
            tl.b bVar = aVar.f15790b;
            if (bVar.f15801d - bVar.f15800c >= i10) {
                if (!bVar.f15799b.hasArray()) {
                    return f(charsetDecoder, aVar, i10);
                }
                ByteBuffer byteBuffer = aVar.f15790b.f15799b;
                byte[] bArrArray = byteBuffer.array();
                l0.o(bArrArray, "bb.array()");
                int iPosition = byteBuffer.position() + byteBuffer.arrayOffset() + aVar.p0().f15821b.f15873b;
                Charset charset = charsetDecoder.charset();
                l0.o(charset, "charset()");
                String str = new String(bArrArray, iPosition, i10, charset);
                aVar.t(i10);
                return str;
            }
        }
        return g(charsetDecoder, g0Var, i10);
    }

    public static final String f(CharsetDecoder charsetDecoder, tl.a aVar, int i10) throws CharacterCodingException, EOFException {
        CharBuffer charBufferAllocate = CharBuffer.allocate(i10);
        ByteBuffer byteBufferN = ql.f.n(aVar.f15790b.f15799b, aVar.p0().f15821b.f15873b, i10);
        CoderResult coderResultDecode = charsetDecoder.decode(byteBufferN, charBufferAllocate, true);
        if (coderResultDecode.isMalformed() || coderResultDecode.isUnmappable()) {
            l0.o(coderResultDecode, "rc");
            q(coderResultDecode);
        }
        charBufferAllocate.flip();
        aVar.t(byteBufferN.position());
        String string = charBufferAllocate.toString();
        l0.o(string, "cb.toString()");
        return string;
    }

    public static final String g(CharsetDecoder charsetDecoder, g0 g0Var, int i10) throws Throwable {
        int iPosition;
        ul.b bVarM;
        CharBuffer charBufferAllocate = CharBuffer.allocate(i10);
        boolean z10 = true;
        ul.b bVarJ = k.j(g0Var, 1);
        boolean z11 = false;
        if (bVarJ == null) {
            iPosition = i10;
        } else {
            iPosition = i10;
            int i11 = 1;
            int i12 = 1;
            boolean z12 = false;
            while (true) {
                try {
                    m mVar = bVarJ.f15821b;
                    int i13 = mVar.f15874c - mVar.f15873b;
                    if (i13 >= i11) {
                        try {
                            if (charBufferAllocate.hasRemaining() && iPosition != 0) {
                                ByteBuffer byteBuffer = bVarJ.f15820a;
                                m mVar2 = bVarJ.f15821b;
                                int i14 = mVar2.f15873b;
                                int i15 = mVar2.f15874c - i14;
                                ByteBuffer byteBufferN = ql.f.n(byteBuffer, i14, i15);
                                int iLimit = byteBufferN.limit();
                                int iPosition2 = byteBufferN.position();
                                boolean z13 = iLimit - iPosition2 >= iPosition;
                                if (z13) {
                                    byteBufferN.limit(iPosition2 + iPosition);
                                }
                                CoderResult coderResultDecode = charsetDecoder.decode(byteBufferN, charBufferAllocate, z13);
                                if (coderResultDecode.isMalformed() || coderResultDecode.isUnmappable()) {
                                    l0.o(coderResultDecode, "rc");
                                    q(coderResultDecode);
                                }
                                i12 = (coderResultDecode.isUnderflow() && byteBufferN.hasRemaining()) ? i12 + 1 : 1;
                                byteBufferN.limit(iLimit);
                                iPosition -= byteBufferN.position() - iPosition2;
                                if (byteBufferN.limit() != i15) {
                                    throw new IllegalStateException("Buffer's limit change is not allowed");
                                }
                                bVarJ.h(byteBufferN.position());
                                i11 = i12;
                                z12 = z13;
                                th = th;
                                if (z10) {
                                    k.e(g0Var, bVarJ);
                                }
                                throw th;
                            }
                            i11 = 0;
                            m mVar3 = bVarJ.f15821b;
                            i13 = mVar3.f15874c - mVar3.f15873b;
                        } catch (Throwable th2) {
                            m mVar4 = bVarJ.f15821b;
                            int i16 = mVar4.f15874c;
                            int i17 = mVar4.f15873b;
                            throw th2;
                        }
                    }
                    if (i13 == 0) {
                        try {
                            bVarM = k.m(g0Var, bVarJ);
                        } catch (Throwable th3) {
                            th = th3;
                            z10 = false;
                        }
                    } else if (i13 < i11 || bVarJ.f15822c - bVarJ.f15821b.f15872a < 8) {
                        k.e(g0Var, bVarJ);
                        bVarM = k.j(g0Var, i11);
                    } else {
                        bVarM = bVarJ;
                    }
                    if (bVarM == null) {
                        break;
                    }
                    if (i11 <= 0) {
                        z11 = true;
                        bVarJ = bVarM;
                        break;
                    }
                    bVarJ = bVarM;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
            if (z11) {
                k.e(g0Var, bVarJ);
            }
            z11 = z12;
        }
        if (charBufferAllocate.hasRemaining() && !z11) {
            CoderResult coderResultDecode2 = charsetDecoder.decode(f14554c, charBufferAllocate, true);
            if (coderResultDecode2.isMalformed() || coderResultDecode2.isUnmappable()) {
                l0.o(coderResultDecode2, "rc");
                q(coderResultDecode2);
            }
        }
        if (iPosition > 0) {
            throw new EOFException("Not enough bytes available: had only " + (i10 - iPosition) + " instead of " + i10);
        }
        if (iPosition < 0) {
            throw new AssertionError("remainingInputBytes < 0");
        }
        charBufferAllocate.flip();
        String string = charBufferAllocate.toString();
        l0.o(string, "cb.toString()");
        return string;
    }

    public static final boolean h(@l CharsetEncoder charsetEncoder, @l tl.e eVar) throws CharacterCodingException {
        l0.p(charsetEncoder, "<this>");
        l0.p(eVar, "dst");
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i10 = mVar.f15874c;
        int i11 = mVar.f15872a - i10;
        ByteBuffer byteBufferN = ql.f.n(byteBuffer, i10, i11);
        CoderResult coderResultEncode = charsetEncoder.encode(f14553b, byteBufferN, true);
        if (coderResultEncode.isMalformed() || coderResultEncode.isUnmappable()) {
            l0.o(coderResultEncode, "result");
            q(coderResultEncode);
        }
        boolean zIsUnderflow = coderResultEncode.isUnderflow();
        if (byteBufferN.limit() != i11) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        eVar.b(byteBufferN.position());
        return zIsUnderflow;
    }

    public static final int i(@l CharsetEncoder charsetEncoder, @l CharSequence charSequence, int i10, int i11, @l tl.e eVar) throws CharacterCodingException {
        l0.p(charsetEncoder, "<this>");
        l0.p(charSequence, "input");
        l0.p(eVar, "dst");
        CharBuffer charBufferWrap = CharBuffer.wrap(charSequence, i10, i11);
        int iRemaining = charBufferWrap.remaining();
        ByteBuffer byteBuffer = eVar.f15820a;
        m mVar = eVar.f15821b;
        int i12 = mVar.f15874c;
        int i13 = mVar.f15872a - i12;
        ByteBuffer byteBufferN = ql.f.n(byteBuffer, i12, i13);
        CoderResult coderResultEncode = charsetEncoder.encode(charBufferWrap, byteBufferN, false);
        if (coderResultEncode.isMalformed() || coderResultEncode.isUnmappable()) {
            l0.o(coderResultEncode, "result");
            q(coderResultEncode);
        }
        if (byteBufferN.limit() != i13) {
            throw new IllegalStateException("Buffer's limit change is not allowed");
        }
        eVar.b(byteBufferN.position());
        return iRemaining - charBufferWrap.remaining();
    }

    @l
    public static final byte[] j(@l CharsetEncoder charsetEncoder, @l CharSequence charSequence, int i10, int i11) {
        l0.p(charsetEncoder, "<this>");
        l0.p(charSequence, "input");
        if (!(charSequence instanceof String)) {
            return l(charsetEncoder, charSequence, i10, i11);
        }
        if (i10 == 0 && i11 == ((String) charSequence).length()) {
            byte[] bytes = ((String) charSequence).getBytes(charsetEncoder.charset());
            l0.o(bytes, "input as java.lang.String).getBytes(charset())");
            return bytes;
        }
        String strSubstring = ((String) charSequence).substring(i10, i11);
        l0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        byte[] bytes2 = strSubstring.getBytes(charsetEncoder.charset());
        l0.o(bytes2, "input.substring(fromInde…ring).getBytes(charset())");
        return bytes2;
    }

    public static /* synthetic */ byte[] k(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return j(charsetEncoder, charSequence, i10, i11);
    }

    public static final byte[] l(CharsetEncoder charsetEncoder, CharSequence charSequence, int i10, int i11) throws CharacterCodingException {
        byte[] bArrArray;
        ByteBuffer byteBufferEncode = charsetEncoder.encode(CharBuffer.wrap(charSequence, i10, i11));
        byte[] bArr = null;
        if (byteBufferEncode.hasArray() && byteBufferEncode.arrayOffset() == 0 && (bArrArray = byteBufferEncode.array()) != null && bArrArray.length == byteBufferEncode.remaining()) {
            bArr = bArrArray;
        }
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[byteBufferEncode.remaining()];
        byteBufferEncode.get(bArr2);
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [ul.b] */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16, types: [tl.e, ul.b] */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v27 */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v29 */
    /* JADX WARN: Type inference failed for: r7v3, types: [int] */
    /* JADX WARN: Type inference failed for: r7v30 */
    /* JADX WARN: Type inference failed for: r7v31 */
    /* JADX WARN: Type inference failed for: r7v32 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    public static final void m(@l CharsetEncoder charsetEncoder, @l v vVar, @l q0 q0Var) throws Throwable {
        ?? r10;
        ul.b bVar;
        int i10;
        ?? r11;
        ul.b bVar2;
        int i11;
        ?? r12;
        ul.b bVar3;
        char cN;
        l0.p(charsetEncoder, "<this>");
        l0.p(vVar, "input");
        l0.p(q0Var, "dst");
        if (o(charsetEncoder) == jq.f.f8800b) {
            s0.C(q0Var, vVar);
            return;
        }
        ul.b.f16311i.getClass();
        ul.b bVar4 = (ul.b) ul.b.f16315w.W0();
        try {
            ByteBuffer byteBuffer = bVar4.f15820a;
            m mVar = bVar4.f15821b;
            int i12 = mVar.f15874c;
            int i13 = mVar.f15872a - i12;
            ByteBuffer byteBufferN = ql.f.n(byteBuffer, i12, i13);
            CharBuffer charBufferAsCharBuffer = byteBufferN.asCharBuffer();
            l0.m(charBufferAsCharBuffer);
            bVar4 = bVar4;
            while (true) {
                ?? K2 = (vVar.S0() > 0L ? 1 : (vVar.S0() == 0L ? 0 : -1));
                if (K2 > 0) {
                    try {
                        charBufferAsCharBuffer.clear();
                        K2 = vVar.k2(1);
                        if (K2 != 0) {
                            ByteBuffer byteBuffer2 = K2.f15820a;
                            m mVar2 = K2.f15821b;
                            int i14 = mVar2.f15873b;
                            int i15 = mVar2.f15874c;
                            int i16 = i14;
                            int i17 = 0;
                            int i18 = 0;
                            int i19 = 0;
                            while (true) {
                                if (i16 >= i15) {
                                    bVar2 = bVar4;
                                    K2.h(i15 - i14);
                                    i11 = 0;
                                    break;
                                }
                                i16++;
                                byte b10 = byteBuffer2.get(i16);
                                int i20 = b10 & 255;
                                byteBuffer2 = byteBuffer2;
                                i11 = -1;
                                if ((b10 & 128) == 0) {
                                    if (i17 != 0) {
                                        j.o(i17);
                                        throw new y();
                                    }
                                    char c10 = (char) i20;
                                    if (!charBufferAsCharBuffer.hasRemaining()) {
                                        K2.h(i16 - i14);
                                        bVar2 = bVar4;
                                        break;
                                    } else {
                                        charBufferAsCharBuffer.put(c10);
                                        bVar4 = bVar4;
                                    }
                                } else if (i17 == 0) {
                                    int i21 = 128;
                                    ul.b bVar5 = bVar4;
                                    i18 = i20;
                                    int i22 = i17;
                                    int i23 = 1;
                                    while (i23 < 7) {
                                        i23++;
                                        if ((i18 & i21) == 0) {
                                            break;
                                        }
                                        i18 &= ~i21;
                                        i21 >>= 1;
                                        i22++;
                                    }
                                    i17 = i22 - 1;
                                    if (i22 > i15 - i16) {
                                        K2.h(i16 - i14);
                                        i11 = i22;
                                        bVar2 = bVar5;
                                        break;
                                    } else {
                                        i19 = i22;
                                        bVar3 = bVar5;
                                        bVar4 = bVar3;
                                    }
                                } else {
                                    ul.b bVar6 = bVar4;
                                    int i24 = (i18 << 6) | (b10 & 127);
                                    i17--;
                                    if (i17 != 0) {
                                        i18 = i24;
                                        bVar3 = bVar6;
                                        bVar4 = bVar3;
                                    } else {
                                        if (!j.l(i24)) {
                                            if (!j.m(i24)) {
                                                j.p(i24);
                                                throw new y();
                                            }
                                            char cK = (char) j.k(i24);
                                            if (charBufferAsCharBuffer.hasRemaining()) {
                                                charBufferAsCharBuffer.put(cK);
                                                cN = (char) j.n(i24);
                                                if (charBufferAsCharBuffer.hasRemaining()) {
                                                    charBufferAsCharBuffer.put(cN);
                                                    i16 = i16;
                                                    byteBuffer2 = byteBuffer2;
                                                    bVar4 = bVar6;
                                                    i18 = 0;
                                                }
                                            }
                                            K2.h(((i16 - i14) - i19) + 1);
                                            bVar2 = bVar6;
                                            break;
                                        }
                                        cN = (char) i24;
                                        if (!charBufferAsCharBuffer.hasRemaining()) {
                                            K2.h(((i16 - i14) - i19) + 1);
                                            bVar2 = bVar6;
                                            break;
                                        }
                                        charBufferAsCharBuffer.put(cN);
                                        i16 = i16;
                                        byteBuffer2 = byteBuffer2;
                                        bVar4 = bVar6;
                                        i18 = 0;
                                    }
                                }
                                ul.b.f16311i.getClass();
                                r10.j2(ul.b.f16315w);
                                throw th;
                            }
                            try {
                                int i25 = K2.f15821b.f15873b;
                                tl.b bVar7 = vVar.f15790b;
                                bVar7.f15800c = i25;
                                charBufferAsCharBuffer.flip();
                                if (charBufferAsCharBuffer.hasRemaining()) {
                                    ul.b bVarO = k.o(q0Var, 1, null);
                                    int i26 = 1;
                                    while (true) {
                                        try {
                                            ByteBuffer byteBuffer3 = bVarO.f15820a;
                                            m mVar3 = bVarO.f15821b;
                                            int i27 = mVar3.f15874c;
                                            int i28 = mVar3.f15872a - i27;
                                            ByteBuffer byteBufferN2 = ql.f.n(byteBuffer3, i27, i28);
                                            i10 = 0;
                                            CoderResult coderResultEncode = charsetEncoder.encode(charBufferAsCharBuffer, byteBufferN2, false);
                                            if (coderResultEncode.isUnmappable() || coderResultEncode.isMalformed()) {
                                                l0.o(coderResultEncode, "cr");
                                                q(coderResultEncode);
                                            }
                                            i26 = (coderResultEncode.isOverflow() && byteBufferN2.hasRemaining()) ? i26 + 1 : 1;
                                            if (byteBufferN2.limit() != i28) {
                                                throw new IllegalStateException("Buffer's limit change is not allowed");
                                            }
                                            bVarO.b(byteBufferN2.position());
                                            int i29 = charBufferAsCharBuffer.hasRemaining() ? i26 : 0;
                                            if (i29 <= 0) {
                                                k.b(q0Var, bVarO);
                                                r12 = i29;
                                                break;
                                            }
                                            bVarO = k.o(q0Var, i29, bVarO);
                                        } catch (Throwable th2) {
                                            k.b(q0Var, bVarO);
                                            throw th2;
                                        }
                                    }
                                } else {
                                    i10 = 0;
                                }
                                if (i11 > 0) {
                                    r12 = bVar7;
                                    r11 = r12;
                                    bVar = bVar2;
                                    break;
                                }
                                r12 = bVar7;
                                bVar4 = bVar2;
                            } catch (Throwable th3) {
                                th = th3;
                                r10 = bVar2;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        bVar2 = bVar4;
                    }
                }
                bVar = bVar4;
                i10 = 0;
                r11 = K2;
                break;
            }
            charBufferAsCharBuffer.clear();
            charBufferAsCharBuffer.flip();
            ul.b bVarO2 = k.o(q0Var, 1, null);
            int i30 = 1;
            r10 = r11;
            ul.b bVar8 = bVar;
            while (true) {
                try {
                    try {
                        ByteBuffer byteBuffer4 = bVarO2.f15820a;
                        m mVar4 = bVarO2.f15821b;
                        int i31 = mVar4.f15874c;
                        int i32 = mVar4.f15872a - i31;
                        ByteBuffer byteBufferN3 = ql.f.n(byteBuffer4, i31, i32);
                        CoderResult coderResultEncode2 = charsetEncoder.encode(charBufferAsCharBuffer, byteBufferN3, true);
                        if (coderResultEncode2.isMalformed() || coderResultEncode2.isUnmappable()) {
                            l0.o(coderResultEncode2, "cr");
                            q(coderResultEncode2);
                        }
                        i30 = coderResultEncode2.isOverflow() ? i30 + 1 : i10;
                        if (byteBufferN3.limit() != i32) {
                            throw new IllegalStateException("Buffer's limit change is not allowed");
                        }
                        bVarO2.b(byteBufferN3.position());
                        if (i30 <= 0) {
                            k.b(q0Var, bVarO2);
                            if (byteBufferN.limit() != i13) {
                                throw new IllegalStateException("Buffer's limit change is not allowed");
                            }
                            ul.b bVar9 = bVar8;
                            bVar9.b(byteBufferN.position());
                            ul.b.f16311i.getClass();
                            bVar9.j2(ul.b.f16315w);
                            return;
                        }
                        ul.b bVar10 = bVar8;
                        try {
                            bVarO2 = k.o(q0Var, i30, bVarO2);
                            bVar8 = bVar10;
                            r10 = bVar10;
                        } catch (Throwable th5) {
                            th = th5;
                        }
                        th = th5;
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
                k.b(q0Var, bVarO2);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            r10 = bVar4;
        }
    }

    @l
    public static final Charset n(@l CharsetDecoder charsetDecoder) {
        l0.p(charsetDecoder, "<this>");
        Charset charset = charsetDecoder.charset();
        l0.m(charset);
        return charset;
    }

    @l
    public static final Charset o(@l CharsetEncoder charsetEncoder) {
        l0.p(charsetEncoder, "<this>");
        Charset charset = charsetEncoder.charset();
        l0.o(charset, "charset()");
        return charset;
    }

    @l
    public static final String p(@l Charset charset) {
        l0.p(charset, "<this>");
        String strName = charset.name();
        l0.o(strName, "name()");
        return strName;
    }

    public static final void q(CoderResult coderResult) throws CharacterCodingException {
        try {
            coderResult.throwException();
        } catch (MalformedInputException e10) {
            String message = e10.getMessage();
            if (message == null) {
                message = "Failed to decode bytes";
            }
            throw new c(message);
        }
    }
}
