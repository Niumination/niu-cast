package l1;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class g0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Reader f9564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CharsetEncoder f9565b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f9566c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CharBuffer f9567d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ByteBuffer f9568e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f9569f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9570g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f9571i;

    /* JADX WARN: Illegal instructions before constructor call */
    public g0(Reader reader, Charset charset, int bufferSize) {
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        CodingErrorAction codingErrorAction = CodingErrorAction.REPLACE;
        this(reader, charsetEncoderNewEncoder.onMalformedInput(codingErrorAction).onUnmappableCharacter(codingErrorAction), bufferSize);
    }

    public static int b(Buffer buffer) {
        return buffer.capacity() - buffer.limit();
    }

    public static CharBuffer d(CharBuffer buf) {
        CharBuffer charBufferWrap = CharBuffer.wrap(Arrays.copyOf(buf.array(), buf.capacity() * 2));
        charBufferWrap.position(buf.position());
        charBufferWrap.limit(buf.limit());
        return charBufferWrap;
    }

    public final int c(byte[] b10, int off, int len) {
        int iMin = Math.min(len, this.f9568e.remaining());
        this.f9568e.get(b10, off, iMin);
        return iMin;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9564a.close();
    }

    public final void h() throws IOException {
        if (b(this.f9567d) == 0) {
            if (this.f9567d.position() > 0) {
                this.f9567d.compact().flip();
            } else {
                this.f9567d = d(this.f9567d);
            }
        }
        int iLimit = this.f9567d.limit();
        int i10 = this.f9564a.read(this.f9567d.array(), iLimit, b(this.f9567d));
        if (i10 == -1) {
            this.f9569f = true;
        } else {
            this.f9567d.limit(iLimit + i10);
        }
    }

    public final void k(boolean overflow) {
        this.f9568e.flip();
        if (overflow && this.f9568e.remaining() == 0) {
            this.f9568e = ByteBuffer.allocate(this.f9568e.capacity() * 2);
        } else {
            this.f9570g = true;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.f9566c) == 1) {
            return this.f9566c[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b10, int off, int len) throws IOException {
        CoderResult coderResultFlush;
        c1.h0.f0(off, off + len, b10.length);
        if (len == 0) {
            return 0;
        }
        boolean z10 = this.f9569f;
        int iC = 0;
        while (true) {
            if (this.f9570g) {
                iC += c(b10, off + iC, len - iC);
                if (iC == len || this.f9571i) {
                    break;
                }
                this.f9570g = false;
                this.f9568e.clear();
            }
            while (true) {
                if (this.f9571i) {
                    coderResultFlush = CoderResult.UNDERFLOW;
                } else {
                    coderResultFlush = z10 ? this.f9565b.flush(this.f9568e) : this.f9565b.encode(this.f9567d, this.f9568e, this.f9569f);
                }
                if (coderResultFlush.isOverflow()) {
                    k(true);
                    break;
                }
                if (coderResultFlush.isUnderflow()) {
                    if (z10) {
                        this.f9571i = true;
                        k(false);
                        break;
                    }
                    if (this.f9569f) {
                        z10 = true;
                    } else {
                        h();
                    }
                } else if (coderResultFlush.isError()) {
                    coderResultFlush.throwException();
                    return 0;
                }
            }
        }
        if (iC > 0) {
            return iC;
        }
        return -1;
    }

    public g0(Reader reader, CharsetEncoder encoder, int bufferSize) {
        this.f9566c = new byte[1];
        reader.getClass();
        this.f9564a = reader;
        encoder.getClass();
        this.f9565b = encoder;
        c1.h0.k(bufferSize > 0, "bufferSize must be positive: %s", bufferSize);
        encoder.reset();
        CharBuffer charBufferAllocate = CharBuffer.allocate(bufferSize);
        this.f9567d = charBufferAllocate;
        charBufferAllocate.flip();
        this.f9568e = ByteBuffer.allocate(bufferSize);
    }
}
