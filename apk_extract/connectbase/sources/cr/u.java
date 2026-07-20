package cr;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f3476a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f3477b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3478c;

    public u(z zVar) {
        if (zVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f3477b = zVar;
    }

    @Override // cr.d
    public d C0(long j10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.C0(j10);
        return N();
    }

    @Override // cr.d
    public long F1(a0 a0Var) throws IOException {
        if (a0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j10 = 0;
        while (true) {
            long jY0 = a0Var.Y0(this.f3476a, 8192L);
            if (jY0 == -1) {
                return j10;
            }
            j10 += jY0;
            N();
        }
    }

    @Override // cr.d
    public d N() throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        long jH = this.f3476a.h();
        if (jH > 0) {
            this.f3477b.Z0(this.f3476a, jH);
        }
        return this;
    }

    @Override // cr.d
    public d T1(f fVar) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.T1(fVar);
        return N();
    }

    @Override // cr.d
    public d V(String str) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.V(str);
        return N();
    }

    @Override // cr.z
    public void Z0(c cVar, long j10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.Z0(cVar, j10);
        N();
    }

    @Override // cr.d
    public d a1(int i10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.a1(i10);
        return N();
    }

    @Override // cr.d
    public c buffer() {
        return this.f3476a;
    }

    @Override // cr.d
    public d c0(String str, int i10, int i11) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.c0(str, i10, i11);
        return N();
    }

    @Override // cr.z, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f3478c) {
            return;
        }
        c cVar = this.f3476a;
        long j10 = cVar.f3404b;
        if (j10 > 0) {
            this.f3477b.Z0(cVar, j10);
        }
        th = null;
        try {
            this.f3477b.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f3478c = true;
        if (th != null) {
            d0.f(th);
        }
    }

    @Override // cr.d
    public d e1(a0 a0Var, long j10) throws IOException {
        while (j10 > 0) {
            long jY0 = a0Var.Y0(this.f3476a, j10);
            if (jY0 == -1) {
                throw new EOFException();
            }
            j10 -= jY0;
            N();
        }
        return this;
    }

    @Override // cr.z
    public b0 f() {
        return this.f3477b.f();
    }

    @Override // cr.d, cr.z, java.io.Flushable
    public void flush() throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f3476a;
        long j10 = cVar.f3404b;
        if (j10 > 0) {
            this.f3477b.Z0(cVar, j10);
        }
        this.f3477b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3478c;
    }

    @Override // cr.d
    public d j1(int i10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.j1(i10);
        return N();
    }

    @Override // cr.d
    public OutputStream outputStream() {
        return new a();
    }

    @Override // cr.d
    public d r() throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f3476a;
        long j10 = cVar.f3404b;
        if (j10 > 0) {
            this.f3477b.Z0(cVar, j10);
        }
        return this;
    }

    @Override // cr.d
    public d s(int i10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.s(i10);
        return N();
    }

    public String toString() {
        return "buffer(" + this.f3477b + ")";
    }

    @Override // cr.d
    public d u1(long j10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.u1(j10);
        return N();
    }

    @Override // cr.d
    public d w1(String str, Charset charset) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.w1(str, charset);
        return N();
    }

    @Override // cr.d
    public d write(byte[] bArr) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.write(bArr);
        return N();
    }

    @Override // cr.d
    public d writeByte(int i10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.writeByte(i10);
        return N();
    }

    @Override // cr.d
    public d writeInt(int i10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.writeInt(i10);
        return N();
    }

    @Override // cr.d
    public d writeLong(long j10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.writeLong(j10);
        return N();
    }

    @Override // cr.d
    public d writeShort(int i10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.writeShort(i10);
        return N();
    }

    @Override // cr.d
    public d x(long j10) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.x(j10);
        return N();
    }

    @Override // cr.d
    public d z0(String str, int i10, int i11, Charset charset) throws IOException {
        if (this.f3478c) {
            throw new IllegalStateException("closed");
        }
        this.f3476a.z0(str, i10, i11, charset);
        return N();
    }

    public class a extends OutputStream {
        public a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws Throwable {
            u.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() throws IOException {
            u uVar = u.this;
            if (uVar.f3478c) {
                return;
            }
            uVar.flush();
        }

        public String toString() {
            return u.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i10) throws IOException {
            u uVar = u.this;
            if (uVar.f3478c) {
                throw new IOException("closed");
            }
            uVar.f3476a.writeByte((byte) i10);
            u.this.N();
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i10, int i11) throws IOException {
            u uVar = u.this;
            if (!uVar.f3478c) {
                uVar.f3476a.write(bArr, i10, i11);
                u.this.N();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // cr.d
    public d write(byte[] bArr, int i10, int i11) throws IOException {
        if (!this.f3478c) {
            this.f3476a.write(bArr, i10, i11);
            return N();
        }
        throw new IllegalStateException("closed");
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (!this.f3478c) {
            int iWrite = this.f3476a.write(byteBuffer);
            N();
            return iWrite;
        }
        throw new IllegalStateException("closed");
    }
}
