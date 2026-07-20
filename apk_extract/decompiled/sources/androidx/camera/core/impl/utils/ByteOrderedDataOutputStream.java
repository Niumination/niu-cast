package androidx.camera.core.impl.utils;

import androidx.annotation.RequiresApi;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ByteOrderedDataOutputStream extends FilterOutputStream {
    private ByteOrder mByteOrder;
    final OutputStream mOutputStream;

    public ByteOrderedDataOutputStream(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.mOutputStream = outputStream;
        this.mByteOrder = byteOrder;
    }

    public void setByteOrder(ByteOrder byteOrder) {
        this.mByteOrder = byteOrder;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        this.mOutputStream.write(bArr);
    }

    public void writeByte(int i8) throws IOException {
        this.mOutputStream.write(i8);
    }

    public void writeInt(int i8) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(i8 & 255);
            this.mOutputStream.write((i8 >>> 8) & 255);
            this.mOutputStream.write((i8 >>> 16) & 255);
            this.mOutputStream.write((i8 >>> 24) & 255);
            return;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((i8 >>> 24) & 255);
            this.mOutputStream.write((i8 >>> 16) & 255);
            this.mOutputStream.write((i8 >>> 8) & 255);
            this.mOutputStream.write(i8 & 255);
        }
    }

    public void writeShort(short s2) throws IOException {
        ByteOrder byteOrder = this.mByteOrder;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            this.mOutputStream.write(s2 & 255);
            this.mOutputStream.write((s2 >>> 8) & 255);
        } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
            this.mOutputStream.write((s2 >>> 8) & 255);
            this.mOutputStream.write(s2 & 255);
        }
    }

    public void writeUnsignedInt(long j8) throws IOException {
        writeInt((int) j8);
    }

    public void writeUnsignedShort(int i8) throws IOException {
        writeShort((short) i8);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i8, int i9) throws IOException {
        this.mOutputStream.write(bArr, i8, i9);
    }
}
