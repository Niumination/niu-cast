package l1;

import java.io.DataOutput;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public interface d extends DataOutput {
    byte[] toByteArray();

    @Override // java.io.DataOutput
    void write(int b10);

    @Override // java.io.DataOutput
    void write(byte[] b10);

    @Override // java.io.DataOutput
    void write(byte[] b10, int off, int len);

    @Override // java.io.DataOutput
    void writeBoolean(boolean v10);

    @Override // java.io.DataOutput
    void writeByte(int v10);

    @Override // java.io.DataOutput
    @Deprecated
    void writeBytes(String s10);

    @Override // java.io.DataOutput
    void writeChar(int v10);

    @Override // java.io.DataOutput
    void writeChars(String s10);

    @Override // java.io.DataOutput
    void writeDouble(double v10);

    @Override // java.io.DataOutput
    void writeFloat(float v10);

    @Override // java.io.DataOutput
    void writeInt(int v10);

    @Override // java.io.DataOutput
    void writeLong(long v10);

    @Override // java.io.DataOutput
    void writeShort(int v10);

    @Override // java.io.DataOutput
    void writeUTF(String s10);
}
