package l1;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class c0 extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Iterator<? extends g> f9547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public InputStream f9548b;

    public c0(Iterator<? extends g> it) throws IOException {
        it.getClass();
        this.f9547a = it;
        b();
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        InputStream inputStream = this.f9548b;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public final void b() throws IOException {
        close();
        if (this.f9547a.hasNext()) {
            this.f9548b = this.f9547a.next().m();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        InputStream inputStream = this.f9548b;
        if (inputStream != null) {
            try {
                inputStream.close();
            } finally {
                this.f9548b = null;
            }
        }
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f9548b;
            if (inputStream == null) {
                return -1;
            }
            int i10 = inputStream.read();
            if (i10 != -1) {
                return i10;
            }
            b();
        }
    }

    @Override // java.io.InputStream
    public long skip(long n10) throws IOException {
        InputStream inputStream = this.f9548b;
        if (inputStream == null || n10 <= 0) {
            return 0L;
        }
        long jSkip = inputStream.skip(n10);
        if (jSkip != 0) {
            return jSkip;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f9548b.skip(n10 - 1) + 1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b10, int off, int len) throws IOException {
        b10.getClass();
        while (true) {
            InputStream inputStream = this.f9548b;
            if (inputStream == null) {
                return -1;
            }
            int i10 = inputStream.read(b10, off, len);
            if (i10 != -1) {
                return i10;
            }
            b();
        }
    }
}
