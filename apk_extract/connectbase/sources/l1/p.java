package l1;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class p extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f9614a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(OutputStream out) {
        super(out);
        out.getClass();
    }

    public long b() {
        return this.f9614a;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] b10, int off, int len) throws IOException {
        ((FilterOutputStream) this).out.write(b10, off, len);
        this.f9614a += (long) len;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b10) throws IOException {
        ((FilterOutputStream) this).out.write(b10);
        this.f9614a++;
    }
}
