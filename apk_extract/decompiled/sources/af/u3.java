package af;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class u3 extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h6 f612b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f613c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f614d;
    public long e;

    public u3(InputStream inputStream, int i8, h6 h6Var) {
        super(inputStream);
        this.e = -1L;
        this.f611a = i8;
        this.f612b = h6Var;
    }

    public final void a() {
        long j8 = this.f614d;
        long j10 = this.f613c;
        if (j8 > j10) {
            long j11 = j8 - j10;
            for (ze.n nVar : this.f612b.f312a) {
                nVar.f(j11);
            }
            this.f613c = this.f614d;
        }
    }

    public final void c() {
        long j8 = this.f614d;
        int i8 = this.f611a;
        if (j8 <= i8) {
            return;
        }
        throw new ze.s2(ze.q2.f11408k.h("Decompressed gRPC message exceeds maximum size " + i8));
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i8) {
        ((FilterInputStream) this).in.mark(i8);
        this.e = this.f614d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i8 = ((FilterInputStream) this).in.read();
        if (i8 != -1) {
            this.f614d++;
        }
        c();
        a();
        return i8;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.e == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f614d = this.e;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j8) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(j8);
        this.f614d += jSkip;
        c();
        a();
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i8, int i9) throws IOException {
        int i10 = ((FilterInputStream) this).in.read(bArr, i8, i9);
        if (i10 != -1) {
            this.f614d += (long) i10;
        }
        c();
        a();
        return i10;
    }
}
