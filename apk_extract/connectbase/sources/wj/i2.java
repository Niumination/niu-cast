package wj;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public interface i2 extends Closeable {
    void B0(ByteBuffer byteBuffer);

    boolean G0();

    void P1(OutputStream outputStream, int i10) throws IOException;

    byte[] S();

    int U1();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int e();

    @gm.j
    ByteBuffer i();

    boolean l();

    boolean markSupported();

    void p1(byte[] bArr, int i10, int i11);

    int readInt();

    int readUnsignedByte();

    void reset();

    void skipBytes(int i10);

    default void touch() {
    }

    i2 u(int i10);

    void y1();
}
