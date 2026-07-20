package j1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@l
@t1.j
public abstract class e extends c {

    public final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f8364a;

        public a(int expectedInputSize) {
            this.f8364a = new b(expectedInputSize);
        }

        @Override // j1.s, j1.j0
        public s c(byte b10) throws IOException {
            this.f8364a.write(b10);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        public s e(byte[] bytes, int off, int len) throws IOException {
            this.f8364a.write(bytes, off, len);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        public s f(ByteBuffer bytes) {
            this.f8364a.d(bytes);
            return this;
        }

        @Override // j1.s
        public q i() {
            return e.this.hashBytes(this.f8364a.b(), 0, this.f8364a.c());
        }

        @Override // j1.s, j1.j0
        public j0 c(byte b10) throws IOException {
            this.f8364a.write(b10);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        public j0 e(byte[] bytes, int off, int len) throws IOException {
            this.f8364a.write(bytes, off, len);
            return this;
        }

        @Override // j1.d, j1.s, j1.j0
        public j0 f(ByteBuffer bytes) {
            this.f8364a.d(bytes);
            return this;
        }
    }

    public static final class b extends ByteArrayOutputStream {
        public b(int expectedInputSize) {
            super(expectedInputSize);
        }

        public byte[] b() {
            return ((ByteArrayOutputStream) this).buf;
        }

        public int c() {
            return ((ByteArrayOutputStream) this).count;
        }

        public void d(ByteBuffer input) {
            int iRemaining = input.remaining();
            int i10 = ((ByteArrayOutputStream) this).count;
            int i11 = i10 + iRemaining;
            byte[] bArr = ((ByteArrayOutputStream) this).buf;
            if (i11 > bArr.length) {
                ((ByteArrayOutputStream) this).buf = Arrays.copyOf(bArr, i10 + iRemaining);
            }
            input.get(((ByteArrayOutputStream) this).buf, ((ByteArrayOutputStream) this).count, iRemaining);
            ((ByteArrayOutputStream) this).count += iRemaining;
        }
    }

    @Override // j1.c, j1.r
    public q hashBytes(ByteBuffer input) {
        return newHasher(input.remaining()).f(input).i();
    }

    @Override // j1.c, j1.r
    public abstract q hashBytes(byte[] input, int off, int len);

    @Override // j1.c, j1.r
    public q hashInt(int input) {
        return hashBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(input).array());
    }

    @Override // j1.c, j1.r
    public q hashLong(long input) {
        return hashBytes(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(input).array());
    }

    @Override // j1.c, j1.r
    public q hashString(CharSequence input, Charset charset) {
        return hashBytes(input.toString().getBytes(charset));
    }

    @Override // j1.c, j1.r
    public q hashUnencodedChars(CharSequence input) {
        int length = input.length();
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(length * 2).order(ByteOrder.LITTLE_ENDIAN);
        for (int i10 = 0; i10 < length; i10++) {
            byteBufferOrder.putChar(input.charAt(i10));
        }
        return hashBytes(byteBufferOrder.array());
    }

    @Override // j1.r
    public s newHasher() {
        return newHasher(32);
    }

    @Override // j1.c, j1.r
    public s newHasher(int expectedInputSize) {
        c1.h0.d(expectedInputSize >= 0);
        return new a(expectedInputSize);
    }
}
