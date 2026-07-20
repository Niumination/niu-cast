package wj;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class j2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i2 f18772a = new c(new byte[0]);

    public class a extends s0 {
        public a(i2 i2Var) {
            super(i2Var);
        }

        @Override // wj.s0, wj.i2, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    public static class d extends wj.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f18778a;

        public d(ByteBuffer byteBuffer) {
            this.f18778a = (ByteBuffer) c1.h0.F(byteBuffer, "bytes");
        }

        @Override // wj.i2
        public void B0(ByteBuffer byteBuffer) {
            c1.h0.F(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            b(iRemaining);
            int iLimit = this.f18778a.limit();
            ByteBuffer byteBuffer2 = this.f18778a;
            byteBuffer2.limit(byteBuffer2.position() + iRemaining);
            byteBuffer.put(this.f18778a);
            this.f18778a.limit(iLimit);
        }

        @Override // wj.b, wj.i2
        public boolean G0() {
            return this.f18778a.hasArray();
        }

        @Override // wj.i2
        public void P1(OutputStream outputStream, int i10) throws IOException {
            b(i10);
            if (G0()) {
                outputStream.write(S(), U1(), i10);
                ByteBuffer byteBuffer = this.f18778a;
                byteBuffer.position(byteBuffer.position() + i10);
            } else {
                byte[] bArr = new byte[i10];
                this.f18778a.get(bArr);
                outputStream.write(bArr);
            }
        }

        @Override // wj.b, wj.i2
        public byte[] S() {
            return this.f18778a.array();
        }

        @Override // wj.b, wj.i2
        public int U1() {
            return this.f18778a.position() + this.f18778a.arrayOffset();
        }

        @Override // wj.i2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public d u(int i10) {
            b(i10);
            ByteBuffer byteBufferDuplicate = this.f18778a.duplicate();
            byteBufferDuplicate.limit(this.f18778a.position() + i10);
            ByteBuffer byteBuffer = this.f18778a;
            byteBuffer.position(byteBuffer.position() + i10);
            return new d(byteBufferDuplicate);
        }

        @Override // wj.i2
        public int e() {
            return this.f18778a.remaining();
        }

        @Override // wj.b, wj.i2
        public ByteBuffer i() {
            return this.f18778a.slice();
        }

        @Override // wj.b, wj.i2
        public boolean l() {
            return true;
        }

        @Override // wj.b, wj.i2
        public boolean markSupported() {
            return true;
        }

        @Override // wj.i2
        public void p1(byte[] bArr, int i10, int i11) {
            b(i11);
            this.f18778a.get(bArr, i10, i11);
        }

        @Override // wj.i2
        public int readUnsignedByte() {
            b(1);
            return this.f18778a.get() & 255;
        }

        @Override // wj.b, wj.i2
        public void reset() {
            this.f18778a.reset();
        }

        @Override // wj.i2
        public void skipBytes(int i10) {
            b(i10);
            ByteBuffer byteBuffer = this.f18778a;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // wj.b, wj.i2
        public void y1() {
            this.f18778a.mark();
        }
    }

    public static i2 a() {
        return f18772a;
    }

    public static i2 b(i2 i2Var) {
        return new a(i2Var);
    }

    public static InputStream c(i2 i2Var, boolean z10) {
        if (!z10) {
            i2Var = new a(i2Var);
        }
        return new b(i2Var);
    }

    public static byte[] d(i2 i2Var) {
        c1.h0.F(i2Var, "buffer");
        int iE = i2Var.e();
        byte[] bArr = new byte[iE];
        i2Var.p1(bArr, 0, iE);
        return bArr;
    }

    public static String e(i2 i2Var, Charset charset) {
        c1.h0.F(charset, "charset");
        return new String(d(i2Var), charset);
    }

    public static String f(i2 i2Var) {
        return e(i2Var, c1.f.f1179c);
    }

    public static i2 g(ByteBuffer byteBuffer) {
        return new d(byteBuffer);
    }

    public static i2 h(byte[] bArr) {
        return new c(bArr, 0, bArr.length);
    }

    public static i2 i(byte[] bArr, int i10, int i11) {
        return new c(bArr, i10, i11);
    }

    public static final class b extends InputStream implements vj.n1, vj.p0, vj.b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public i2 f18773a;

        public b(i2 i2Var) {
            this.f18773a = (i2) c1.h0.F(i2Var, "buffer");
        }

        @Override // java.io.InputStream, vj.n1
        public int available() throws IOException {
            return this.f18773a.e();
        }

        @Override // vj.b0
        public InputStream b() {
            i2 i2Var = this.f18773a;
            this.f18773a = i2Var.u(0);
            return new b(i2Var);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f18773a.close();
        }

        @Override // vj.p0
        @gm.j
        public ByteBuffer i() {
            return this.f18773a.i();
        }

        @Override // vj.p0
        public boolean l() {
            return this.f18773a.l();
        }

        @Override // java.io.InputStream
        public void mark(int i10) {
            this.f18773a.y1();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f18773a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f18773a.e() == 0) {
                return -1;
            }
            return this.f18773a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public void reset() throws IOException {
            this.f18773a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j10) throws IOException {
            int iMin = (int) Math.min(this.f18773a.e(), j10);
            this.f18773a.skipBytes(iMin);
            return iMin;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (this.f18773a.e() == 0) {
                return -1;
            }
            int iMin = Math.min(this.f18773a.e(), i11);
            this.f18773a.p1(bArr, i10, iMin);
            return iMin;
        }
    }

    public static class c extends wj.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f18775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f18776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18777d;

        public c(byte[] bArr, int i10, int i11) {
            this.f18777d = -1;
            c1.h0.e(i10 >= 0, "offset must be >= 0");
            c1.h0.e(i11 >= 0, "length must be >= 0");
            int i12 = i11 + i10;
            c1.h0.e(i12 <= bArr.length, "offset + length exceeds array boundary");
            this.f18776c = (byte[]) c1.h0.F(bArr, "bytes");
            this.f18774a = i10;
            this.f18775b = i12;
        }

        @Override // wj.i2
        public void B0(ByteBuffer byteBuffer) {
            c1.h0.F(byteBuffer, "dest");
            int iRemaining = byteBuffer.remaining();
            b(iRemaining);
            byteBuffer.put(this.f18776c, this.f18774a, iRemaining);
            this.f18774a += iRemaining;
        }

        @Override // wj.b, wj.i2
        public boolean G0() {
            return true;
        }

        @Override // wj.i2
        public void P1(OutputStream outputStream, int i10) throws IOException {
            b(i10);
            outputStream.write(this.f18776c, this.f18774a, i10);
            this.f18774a += i10;
        }

        @Override // wj.b, wj.i2
        public byte[] S() {
            return this.f18776c;
        }

        @Override // wj.b, wj.i2
        public int U1() {
            return this.f18774a;
        }

        @Override // wj.i2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public c u(int i10) {
            b(i10);
            int i11 = this.f18774a;
            this.f18774a = i11 + i10;
            return new c(this.f18776c, i11, i10);
        }

        @Override // wj.i2
        public int e() {
            return this.f18775b - this.f18774a;
        }

        @Override // wj.b, wj.i2
        public boolean markSupported() {
            return true;
        }

        @Override // wj.i2
        public void p1(byte[] bArr, int i10, int i11) {
            System.arraycopy(this.f18776c, this.f18774a, bArr, i10, i11);
            this.f18774a += i11;
        }

        @Override // wj.i2
        public int readUnsignedByte() {
            b(1);
            byte[] bArr = this.f18776c;
            int i10 = this.f18774a;
            this.f18774a = i10 + 1;
            return bArr[i10] & 255;
        }

        @Override // wj.b, wj.i2
        public void reset() {
            int i10 = this.f18777d;
            if (i10 == -1) {
                throw new InvalidMarkException();
            }
            this.f18774a = i10;
        }

        @Override // wj.i2
        public void skipBytes(int i10) {
            b(i10);
            this.f18774a += i10;
        }

        @Override // wj.b, wj.i2
        public void y1() {
            this.f18777d = this.f18774a;
        }

        public c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }
    }
}
