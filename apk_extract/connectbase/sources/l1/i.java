package l1;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class i extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    public CharSequence f9584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f9586c;

    public i(CharSequence seq) {
        seq.getClass();
        this.f9584a = seq;
    }

    public final void b() throws IOException {
        if (this.f9584a == null) {
            throw new IOException("reader closed");
        }
    }

    public final boolean c() {
        return d() > 0;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f9584a = null;
    }

    public final int d() {
        Objects.requireNonNull(this.f9584a);
        return this.f9584a.length() - this.f9585b;
    }

    @Override // java.io.Reader
    public synchronized void mark(int readAheadLimit) throws IOException {
        c1.h0.k(readAheadLimit >= 0, "readAheadLimit (%s) may not be negative", readAheadLimit);
        b();
        this.f9586c = this.f9585b;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.Reader
    public synchronized int read() throws IOException {
        int iCharAt;
        b();
        Objects.requireNonNull(this.f9584a);
        if (c()) {
            CharSequence charSequence = this.f9584a;
            int i10 = this.f9585b;
            this.f9585b = i10 + 1;
            iCharAt = charSequence.charAt(i10);
        } else {
            iCharAt = -1;
        }
        return iCharAt;
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        b();
        return true;
    }

    @Override // java.io.Reader
    public synchronized void reset() throws IOException {
        b();
        this.f9585b = this.f9586c;
    }

    @Override // java.io.Reader
    public synchronized long skip(long n10) throws IOException {
        int iMin;
        c1.h0.p(n10 >= 0, "n (%s) may not be negative", n10);
        b();
        iMin = (int) Math.min(d(), n10);
        this.f9585b += iMin;
        return iMin;
    }

    @Override // java.io.Reader
    public synchronized int read(char[] cbuf, int off, int len) throws IOException {
        c1.h0.f0(off, off + len, cbuf.length);
        b();
        Objects.requireNonNull(this.f9584a);
        if (!c()) {
            return -1;
        }
        int iMin = Math.min(len, d());
        for (int i10 = 0; i10 < iMin; i10++) {
            CharSequence charSequence = this.f9584a;
            int i11 = this.f9585b;
            this.f9585b = i11 + 1;
            cbuf[off + i10] = charSequence.charAt(i11);
        }
        return iMin;
    }

    @Override // java.io.Reader, java.lang.Readable
    public synchronized int read(CharBuffer target) throws IOException {
        target.getClass();
        b();
        Objects.requireNonNull(this.f9584a);
        if (!c()) {
            return -1;
        }
        int iMin = Math.min(target.remaining(), d());
        for (int i10 = 0; i10 < iMin; i10++) {
            CharSequence charSequence = this.f9584a;
            int i11 = this.f9585b;
            this.f9585b = i11 + 1;
            target.put(charSequence.charAt(i11));
        }
        return iMin;
    }
}
