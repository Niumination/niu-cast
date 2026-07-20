package af;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class k4 extends InputStream implements ze.w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f400a;

    @Override // java.io.InputStream
    public final int available() {
        return this.f400a.o();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f400a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i8) {
        this.f400a.c();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f400a.g();
    }

    @Override // java.io.InputStream
    public final int read() {
        d dVar = this.f400a;
        if (dVar.o() == 0) {
            return -1;
        }
        return dVar.m();
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f400a.s();
    }

    @Override // java.io.InputStream
    public final long skip(long j8) {
        d dVar = this.f400a;
        int iMin = (int) Math.min(dVar.o(), j8);
        dVar.t(iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i8, int i9) {
        d dVar = this.f400a;
        if (dVar.o() == 0) {
            return -1;
        }
        int iMin = Math.min(dVar.o(), i9);
        dVar.l(bArr, i8, iMin);
        return iMin;
    }
}
