package j1;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
@b1.a
@l
public final class v extends FilterOutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f8466a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(r hashFunction, OutputStream out) {
        super(out);
        out.getClass();
        s sVarNewHasher = hashFunction.newHasher();
        sVarNewHasher.getClass();
        this.f8466a = sVarNewHasher;
    }

    public q b() {
        return this.f8466a.i();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int b10) throws IOException {
        this.f8466a.c((byte) b10);
        ((FilterOutputStream) this).out.write(b10);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bytes, int off, int len) throws IOException {
        this.f8466a.e(bytes, off, len);
        ((FilterOutputStream) this).out.write(bytes, off, len);
    }
}
