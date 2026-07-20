package af;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements Closeable {
    public final void a(int i8) {
        if (o() < i8) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void c() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean g() {
        return this instanceof l4;
    }

    public abstract d h(int i8);

    public abstract void i(OutputStream outputStream, int i8);

    public abstract void k(ByteBuffer byteBuffer);

    public abstract void l(byte[] bArr, int i8, int i9);

    public abstract int m();

    public abstract int o();

    public void s() {
        throw new UnsupportedOperationException();
    }

    public abstract void t(int i8);
}
