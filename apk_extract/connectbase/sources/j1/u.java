package j1;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@b1.a
@l
public final class u extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f8465a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(r hashFunction, InputStream in2) {
        super(in2);
        in2.getClass();
        s sVarNewHasher = hashFunction.newHasher();
        sVarNewHasher.getClass();
        this.f8465a = sVarNewHasher;
    }

    public q b() {
        return this.f8465a.i();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int readlimit) {
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @t1.a
    public int read() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (i10 != -1) {
            this.f8465a.c((byte) i10);
        }
        return i10;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        throw new IOException("reset not supported");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    @t1.a
    public int read(byte[] bytes, int off, int len) throws IOException {
        int i10 = ((FilterInputStream) this).in.read(bytes, off, len);
        if (i10 != -1) {
            this.f8465a.e(bytes, off, i10);
        }
        return i10;
    }
}
