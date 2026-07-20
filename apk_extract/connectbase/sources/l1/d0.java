package l1;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public class d0 extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends k> f9549a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @gm.a
    public Reader f9550b;

    public d0(Iterator<? extends k> readers) throws IOException {
        this.f9549a = readers;
        b();
    }

    public final void b() throws IOException {
        close();
        if (this.f9549a.hasNext()) {
            this.f9550b = this.f9549a.next().m();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Reader reader = this.f9550b;
        if (reader != null) {
            try {
                reader.close();
            } finally {
                this.f9550b = null;
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        cbuf.getClass();
        Reader reader = this.f9550b;
        if (reader == null) {
            return -1;
        }
        int i10 = reader.read(cbuf, off, len);
        if (i10 != -1) {
            return i10;
        }
        b();
        return read(cbuf, off, len);
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        Reader reader = this.f9550b;
        return reader != null && reader.ready();
    }

    @Override // java.io.Reader
    public long skip(long n10) throws IOException {
        c1.h0.e(n10 >= 0, "n is negative");
        if (n10 > 0) {
            while (true) {
                Reader reader = this.f9550b;
                if (reader == null) {
                    break;
                }
                long jSkip = reader.skip(n10);
                if (jSkip > 0) {
                    return jSkip;
                }
                b();
            }
        }
        return 0L;
    }
}
