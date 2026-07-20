package l1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class o extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f9613b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(InputStream in2) {
        super(in2);
        in2.getClass();
        this.f9613b = -1L;
    }

    public long b() {
        return this.f9612a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int readlimit) {
        ((FilterInputStream) this).in.mark(readlimit);
        this.f9613b = this.f9612a;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (i10 != -1) {
            this.f9612a++;
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f9613b == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f9612a = this.f9613b;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long n10) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(n10);
        this.f9612a += jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] b10, int off, int len) throws IOException {
        int i10 = ((FilterInputStream) this).in.read(b10, off, len);
        if (i10 != -1) {
            this.f9612a += (long) i10;
        }
        return i10;
    }
}
