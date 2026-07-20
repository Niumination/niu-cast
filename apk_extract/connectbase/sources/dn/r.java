package dn;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kn.l0;
import kn.r1;

/* JADX INFO: loaded from: classes3.dex */
@r1({"SMAP\nConsole.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Console.kt\nkotlin/io/LineReader\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,299:1\n1#2:300\n*E\n"})
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final r f3783a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3784b = 32;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static CharsetDecoder f3785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f3786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public static final byte[] f3787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public static final char[] f3788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final ByteBuffer f3789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public static final CharBuffer f3790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public static final StringBuilder f3791i;

    static {
        byte[] bArr = new byte[32];
        f3787e = bArr;
        char[] cArr = new char[32];
        f3788f = cArr;
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        l0.o(byteBufferWrap, "wrap(...)");
        f3789g = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(cArr);
        l0.o(charBufferWrap, "wrap(...)");
        f3790h = charBufferWrap;
        f3791i = new StringBuilder();
    }

    public final int a() {
        ByteBuffer byteBuffer = f3789g;
        byteBuffer.compact();
        int iPosition = byteBuffer.position();
        byteBuffer.position(0);
        return iPosition;
    }

    public final int b(boolean z10) throws CharacterCodingException {
        while (true) {
            CharsetDecoder charsetDecoder = f3785c;
            if (charsetDecoder == null) {
                l0.S("decoder");
                charsetDecoder = null;
            }
            ByteBuffer byteBuffer = f3789g;
            CharBuffer charBuffer = f3790h;
            CoderResult coderResultDecode = charsetDecoder.decode(byteBuffer, charBuffer, z10);
            l0.o(coderResultDecode, "decode(...)");
            if (coderResultDecode.isError()) {
                e();
                coderResultDecode.throwException();
            }
            int iPosition = charBuffer.position();
            if (!coderResultDecode.isOverflow()) {
                return iPosition;
            }
            StringBuilder sb2 = f3791i;
            char[] cArr = f3788f;
            int i10 = iPosition - 1;
            sb2.append(cArr, 0, i10);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i10]);
        }
    }

    public final int c(int i10, int i11) throws CharacterCodingException {
        ByteBuffer byteBuffer = f3789g;
        byteBuffer.limit(i10);
        f3790h.position(i11);
        int iB = b(true);
        CharsetDecoder charsetDecoder = f3785c;
        if (charsetDecoder == null) {
            l0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuffer.position(0);
        return iB;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0026 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:3:0x0001, B:6:0x0012, B:9:0x001c, B:13:0x002c, B:15:0x0037, B:21:0x0045, B:35:0x007a, B:37:0x0082, B:39:0x0086, B:41:0x008e, B:43:0x0092, B:45:0x009a, B:48:0x00a3, B:50:0x00b7, B:51:0x00ba, B:22:0x004a, B:25:0x0055, B:29:0x005c, B:31:0x006c, B:33:0x0074, B:54:0x00bf, B:11:0x0026), top: B:57:0x0001 }] */
    @os.m
    public final synchronized String d(@os.l InputStream inputStream, @os.l Charset charset) {
        int iC;
        try {
            l0.p(inputStream, "inputStream");
            l0.p(charset, "charset");
            CharsetDecoder charsetDecoder = f3785c;
            if (charsetDecoder == null) {
                g(charset);
            } else {
                if (charsetDecoder == null) {
                    l0.S("decoder");
                    charsetDecoder = null;
                }
                if (!l0.g(charsetDecoder.charset(), charset)) {
                    g(charset);
                }
            }
            int iA = 0;
            int iB = 0;
            while (true) {
                int i10 = inputStream.read();
                if (i10 == -1) {
                    if (f3791i.length() != 0 || iA != 0 || iB != 0) {
                        iC = c(iA, iB);
                        break;
                    }
                    return null;
                }
                int i11 = iA + 1;
                f3787e[iA] = (byte) i10;
                if (i10 == 10 || i11 == 32 || !f3786d) {
                    ByteBuffer byteBuffer = f3789g;
                    byteBuffer.limit(i11);
                    f3790h.position(iB);
                    iB = b(false);
                    if (iB > 0 && f3788f[iB - 1] == '\n') {
                        byteBuffer.position(0);
                        iC = iB;
                        break;
                    }
                    iA = a();
                } else {
                    iA = i11;
                }
            }
            if (iC > 0) {
                char[] cArr = f3788f;
                if (cArr[iC - 1] == '\n') {
                    int i12 = iC - 1;
                    iC = (i12 <= 0 || cArr[iC + (-2)] != '\r') ? i12 : iC - 2;
                }
            }
            StringBuilder sb2 = f3791i;
            if (sb2.length() == 0) {
                return new String(f3788f, 0, iC);
            }
            sb2.append(f3788f, 0, iC);
            String string = sb2.toString();
            l0.o(string, "toString(...)");
            if (sb2.length() > 32) {
                f();
            }
            sb2.setLength(0);
            return string;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void e() {
        CharsetDecoder charsetDecoder = f3785c;
        if (charsetDecoder == null) {
            l0.S("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        f3789g.position(0);
        f3791i.setLength(0);
    }

    public final void f() {
        StringBuilder sb2 = f3791i;
        sb2.setLength(32);
        sb2.trimToSize();
    }

    public final void g(Charset charset) {
        CharsetDecoder charsetDecoderNewDecoder = charset.newDecoder();
        l0.o(charsetDecoderNewDecoder, "newDecoder(...)");
        f3785c = charsetDecoderNewDecoder;
        ByteBuffer byteBuffer = f3789g;
        byteBuffer.clear();
        CharBuffer charBuffer = f3790h;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        CharsetDecoder charsetDecoder = f3785c;
        if (charsetDecoder == null) {
            l0.S("decoder");
            charsetDecoder = null;
        }
        boolean z10 = false;
        charsetDecoder.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z10 = true;
        }
        f3786d = z10;
        e();
    }
}
