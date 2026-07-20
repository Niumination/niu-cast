package wj;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b implements i2 {
    @Override // wj.i2
    public boolean G0() {
        return false;
    }

    @Override // wj.i2
    public byte[] S() {
        throw new UnsupportedOperationException();
    }

    @Override // wj.i2
    public int U1() {
        throw new UnsupportedOperationException();
    }

    public final void b(int i10) {
        if (e() < i10) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // wj.i2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // wj.i2
    public ByteBuffer i() {
        throw new UnsupportedOperationException();
    }

    @Override // wj.i2
    public boolean l() {
        return false;
    }

    @Override // wj.i2
    public boolean markSupported() {
        return false;
    }

    @Override // wj.i2
    public final int readInt() {
        b(4);
        return readUnsignedByte() | (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8);
    }

    @Override // wj.i2
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Override // wj.i2
    public void y1() {
    }
}
