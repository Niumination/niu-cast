package l1;

import java.io.DataInput;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public interface c extends DataInput {
    @Override // java.io.DataInput
    @t1.a
    boolean readBoolean();

    @Override // java.io.DataInput
    @t1.a
    byte readByte();

    @Override // java.io.DataInput
    @t1.a
    char readChar();

    @Override // java.io.DataInput
    @t1.a
    double readDouble();

    @Override // java.io.DataInput
    @t1.a
    float readFloat();

    @Override // java.io.DataInput
    void readFully(byte[] b10);

    @Override // java.io.DataInput
    void readFully(byte[] b10, int off, int len);

    @Override // java.io.DataInput
    @t1.a
    int readInt();

    @Override // java.io.DataInput
    @gm.a
    @t1.a
    String readLine();

    @Override // java.io.DataInput
    @t1.a
    long readLong();

    @Override // java.io.DataInput
    @t1.a
    short readShort();

    @Override // java.io.DataInput
    @t1.a
    String readUTF();

    @Override // java.io.DataInput
    @t1.a
    int readUnsignedByte();

    @Override // java.io.DataInput
    @t1.a
    int readUnsignedShort();

    @Override // java.io.DataInput
    int skipBytes(int n10);
}
