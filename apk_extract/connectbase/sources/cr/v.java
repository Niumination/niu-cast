package cr;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import jq.m0;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3480a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f3481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3482c;

    public v(a0 a0Var) {
        if (a0Var == null) {
            throw new NullPointerException("source == null");
        }
        this.f3481b = a0Var;
    }

    @Override // cr.e
    public void A0(long j10) throws IOException {
        if (!d0(j10)) {
            throw new EOFException();
        }
    }

    @Override // cr.e
    public c C() {
        return this.f3480a;
    }

    @Override // cr.e
    public long D0(byte b10) throws IOException {
        return L(b10, 0L, Long.MAX_VALUE);
    }

    @Override // cr.e
    public long G1(z zVar) throws IOException {
        if (zVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        long j10 = 0;
        while (this.f3481b.Y0(this.f3480a, 8192L) != -1) {
            long jH = this.f3480a.h();
            if (jH > 0) {
                j10 += jH;
                zVar.Z0(this.f3480a, jH);
            }
        }
        c cVar = this.f3480a;
        long j11 = cVar.f3404b;
        if (j11 <= 0) {
            return j10;
        }
        long j12 = j10 + j11;
        zVar.Z0(cVar, j11);
        return j12;
    }

    @Override // cr.e
    public long H(byte b10, long j10) throws IOException {
        return L(b10, j10, Long.MAX_VALUE);
    }

    @Override // cr.e
    public int H1() throws IOException {
        A0(4L);
        return this.f3480a.H1();
    }

    @Override // cr.e
    public String I0(long j10) throws IOException {
        A0(j10);
        c cVar = this.f3480a;
        cVar.getClass();
        return cVar.L1(j10, d0.f3414a);
    }

    @Override // cr.e
    public boolean J(long j10, f fVar) throws IOException {
        return T(j10, fVar, 0, fVar.size());
    }

    @Override // cr.e
    public f K0(long j10) throws IOException {
        A0(j10);
        return this.f3480a.K0(j10);
    }

    @Override // cr.e
    public String K1() throws IOException {
        this.f3480a.F1(this.f3481b);
        return this.f3480a.K1();
    }

    @Override // cr.e
    public long L(byte b10, long j10, long j11) throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || j11 < j10) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j10), Long.valueOf(j11)));
        }
        while (j10 < j11) {
            long jL = this.f3480a.L(b10, j10, j11);
            if (jL != -1) {
                return jL;
            }
            c cVar = this.f3480a;
            long j12 = cVar.f3404b;
            if (j12 >= j11 || this.f3481b.Y0(cVar, 8192L) == -1) {
                break;
            }
            j10 = Math.max(j10, j12);
        }
        return -1L;
    }

    @Override // cr.e
    public String L1(long j10, Charset charset) throws IOException {
        A0(j10);
        if (charset != null) {
            return this.f3480a.L1(j10, charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // cr.e
    @gm.j
    public String M() throws IOException {
        long jD0 = D0((byte) 10);
        if (jD0 != -1) {
            return this.f3480a.u0(jD0);
        }
        long j10 = this.f3480a.f3404b;
        if (j10 != 0) {
            return I0(j10);
        }
        return null;
    }

    @Override // cr.e
    public String P(long j10) throws IOException {
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("limit < 0: ", j10));
        }
        long j11 = j10 == Long.MAX_VALUE ? Long.MAX_VALUE : j10 + 1;
        long jL = L((byte) 10, 0L, j11);
        if (jL != -1) {
            return this.f3480a.u0(jL);
        }
        if (j11 < Long.MAX_VALUE && d0(j11) && this.f3480a.t(j11 - 1) == 13 && d0(1 + j11) && this.f3480a.t(j11) == 10) {
            return this.f3480a.u0(j11);
        }
        c cVar = new c();
        c cVar2 = this.f3480a;
        cVar2.k(cVar, 0L, Math.min(32L, cVar2.f3404b));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f3480a.f3404b, j10) + " content=" + cVar.v1().hex() + m0.F);
    }

    @Override // cr.e
    public long Q(f fVar, long j10) throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jQ = this.f3480a.Q(fVar, j10);
            if (jQ != -1) {
                return jQ;
            }
            c cVar = this.f3480a;
            long j11 = cVar.f3404b;
            if (this.f3481b.Y0(cVar, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, j11);
        }
    }

    @Override // cr.e
    public boolean T(long j10, f fVar, int i10, int i11) throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        if (j10 < 0 || i10 < 0 || i11 < 0 || fVar.size() - i10 < i11) {
            return false;
        }
        for (int i12 = 0; i12 < i11; i12++) {
            long j11 = ((long) i12) + j10;
            if (!d0(1 + j11) || this.f3480a.t(j11) != fVar.getByte(i10 + i12)) {
                return false;
            }
        }
        return true;
    }

    @Override // cr.e
    public byte[] X0() throws IOException {
        this.f3480a.F1(this.f3481b);
        return this.f3480a.X0();
    }

    @Override // cr.a0
    public long Y0(c cVar, long j10) throws IOException {
        if (cVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        c cVar2 = this.f3480a;
        if (cVar2.f3404b == 0 && this.f3481b.Y0(cVar2, 8192L) == -1) {
            return -1L;
        }
        return this.f3480a.Y0(cVar, Math.min(j10, this.f3480a.f3404b));
    }

    @Override // cr.e
    public long Z1() throws IOException {
        A0(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!d0(i11)) {
                break;
            }
            byte bT = this.f3480a.t(i10);
            if ((bT < 48 || bT > 57) && ((bT < 97 || bT > 102) && (bT < 65 || bT > 70))) {
                if (i10 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(bT)));
            }
            i10 = i11;
        }
        return this.f3480a.Z1();
    }

    @Override // cr.e
    public boolean b1() throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        return this.f3480a.b1() && this.f3481b.Y0(this.f3480a, 8192L) == -1;
    }

    @Override // cr.e, cr.d
    public c buffer() {
        return this.f3480a;
    }

    @Override // cr.e
    public InputStream c2() {
        return new a();
    }

    @Override // cr.a0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3482c) {
            return;
        }
        this.f3482c = true;
        this.f3481b.close();
        this.f3480a.b();
    }

    @Override // cr.e
    public boolean d0(long j10) throws IOException {
        c cVar;
        if (j10 < 0) {
            throw new IllegalArgumentException(h0.b.a("byteCount < 0: ", j10));
        }
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        do {
            cVar = this.f3480a;
            if (cVar.f3404b >= j10) {
                return true;
            }
        } while (this.f3481b.Y0(cVar, 8192L) != -1);
        return false;
    }

    @Override // cr.e
    public long d2(f fVar, long j10) throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        while (true) {
            long jD2 = this.f3480a.d2(fVar, j10);
            if (jD2 != -1) {
                return jD2;
            }
            c cVar = this.f3480a;
            long j11 = cVar.f3404b;
            if (this.f3481b.Y0(cVar, 8192L) == -1) {
                return -1L;
            }
            j10 = Math.max(j10, (j11 - ((long) fVar.size())) + 1);
        }
    }

    @Override // cr.a0
    public b0 f() {
        return this.f3481b.f();
    }

    @Override // cr.e
    public long g1() throws IOException {
        A0(1L);
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            if (!d0(i11)) {
                break;
            }
            byte bT = this.f3480a.t(i10);
            if ((bT < 48 || bT > 57) && !(i10 == 0 && bT == 45)) {
                if (i10 != 0) {
                    break;
                }
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(bT)));
            }
            i10 = i11;
        }
        return this.f3480a.g1();
    }

    @Override // cr.e
    public void h1(c cVar, long j10) throws IOException {
        try {
            A0(j10);
            this.f3480a.h1(cVar, j10);
        } catch (EOFException e10) {
            cVar.F1(this.f3480a);
            throw e10;
        }
    }

    @Override // cr.e
    public String i0() throws IOException {
        return P(Long.MAX_VALUE);
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3482c;
    }

    @Override // cr.e
    public long l1(f fVar) throws IOException {
        return Q(fVar, 0L);
    }

    @Override // cr.e
    public byte[] n0(long j10) throws IOException {
        A0(j10);
        return this.f3480a.n0(j10);
    }

    @Override // cr.e
    public String o1(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f3480a.F1(this.f3481b);
        return this.f3480a.o1(charset);
    }

    @Override // cr.e
    public e peek() {
        return p.d(new r(this));
    }

    @Override // cr.e
    public int q1() throws IOException {
        A0(1L);
        byte bT = this.f3480a.t(0L);
        if ((bT & 224) == 192) {
            A0(2L);
        } else if ((bT & 240) == 224) {
            A0(3L);
        } else if ((bT & 248) == 240) {
            A0(4L);
        }
        return this.f3480a.q1();
    }

    @Override // cr.e
    public short r0() throws IOException {
        A0(2L);
        return this.f3480a.r0();
    }

    @Override // cr.e
    public int r1(q qVar) throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        do {
            int iW0 = this.f3480a.w0(qVar, true);
            if (iW0 == -1) {
                return -1;
            }
            if (iW0 != -2) {
                this.f3480a.skip(qVar.f3453a[iW0].size());
                return iW0;
            }
        } while (this.f3481b.Y0(this.f3480a, 8192L) != -1);
        return -1;
    }

    @Override // cr.e
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // cr.e
    public byte readByte() throws IOException {
        A0(1L);
        return this.f3480a.readByte();
    }

    @Override // cr.e
    public void readFully(byte[] bArr) throws IOException {
        try {
            A0(bArr.length);
            this.f3480a.readFully(bArr);
        } catch (EOFException e10) {
            int i10 = 0;
            while (true) {
                c cVar = this.f3480a;
                long j10 = cVar.f3404b;
                if (j10 <= 0) {
                    throw e10;
                }
                int i11 = cVar.read(bArr, i10, (int) j10);
                if (i11 == -1) {
                    throw new AssertionError();
                }
                i10 += i11;
            }
        }
    }

    @Override // cr.e
    public int readInt() throws IOException {
        A0(4L);
        return this.f3480a.readInt();
    }

    @Override // cr.e
    public long readLong() throws IOException {
        A0(8L);
        return this.f3480a.readLong();
    }

    @Override // cr.e
    public short readShort() throws IOException {
        A0(2L);
        return this.f3480a.readShort();
    }

    @Override // cr.e
    public long s0() throws IOException {
        A0(8L);
        return this.f3480a.s0();
    }

    @Override // cr.e
    public long s1(f fVar) throws IOException {
        return d2(fVar, 0L);
    }

    @Override // cr.e
    public void skip(long j10) throws IOException {
        if (this.f3482c) {
            throw new IllegalStateException("closed");
        }
        while (j10 > 0) {
            c cVar = this.f3480a;
            if (cVar.f3404b == 0 && this.f3481b.Y0(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j10, this.f3480a.f3404b);
            this.f3480a.skip(jMin);
            j10 -= jMin;
        }
    }

    public String toString() {
        return "buffer(" + this.f3481b + ")";
    }

    @Override // cr.e
    public f v1() throws IOException {
        this.f3480a.F1(this.f3481b);
        return this.f3480a.v1();
    }

    @Override // cr.e
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        long j10 = i11;
        d0.b(bArr.length, i10, j10);
        c cVar = this.f3480a;
        if (cVar.f3404b == 0 && this.f3481b.Y0(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f3480a.read(bArr, i10, (int) Math.min(j10, this.f3480a.f3404b));
    }

    public class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            v vVar = v.this;
            if (vVar.f3482c) {
                throw new IOException("closed");
            }
            return (int) Math.min(vVar.f3480a.f3404b, 2147483647L);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            v.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            v vVar = v.this;
            if (vVar.f3482c) {
                throw new IOException("closed");
            }
            c cVar = vVar.f3480a;
            if (cVar.f3404b == 0 && vVar.f3481b.Y0(cVar, 8192L) == -1) {
                return -1;
            }
            return v.this.f3480a.readByte() & 255;
        }

        public String toString() {
            return v.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i10, int i11) throws IOException {
            if (!v.this.f3482c) {
                d0.b(bArr.length, i10, i11);
                v vVar = v.this;
                c cVar = vVar.f3480a;
                if (cVar.f3404b == 0 && vVar.f3481b.Y0(cVar, 8192L) == -1) {
                    return -1;
                }
                return v.this.f3480a.read(bArr, i10, i11);
            }
            throw new IOException("closed");
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        c cVar = this.f3480a;
        if (cVar.f3404b == 0 && this.f3481b.Y0(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f3480a.read(byteBuffer);
    }
}
