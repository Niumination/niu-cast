package l1;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class a0 extends FilterInputStream implements DataInput {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(InputStream in2) {
        super(in2);
        in2.getClass();
    }

    public final byte b() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (-1 != i10) {
            return (byte) i10;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    @t1.a
    public boolean readBoolean() throws IOException {
        return readUnsignedByte() != 0;
    }

    @Override // java.io.DataInput
    @t1.a
    public byte readByte() throws IOException {
        return (byte) readUnsignedByte();
    }

    @Override // java.io.DataInput
    @t1.a
    public char readChar() throws IOException {
        return (char) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @t1.a
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    @t1.a
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] b10) throws IOException {
        h.p(this, b10);
    }

    @Override // java.io.DataInput
    @t1.a
    public int readInt() throws IOException {
        byte b10 = b();
        byte b11 = b();
        return o1.l.k(b(), b(), b11, b10);
    }

    @Override // java.io.DataInput
    @t1.a
    @t1.e("Always throws UnsupportedOperationException")
    public String readLine() {
        throw new UnsupportedOperationException("readLine is not supported");
    }

    @Override // java.io.DataInput
    @t1.a
    public long readLong() throws IOException {
        byte b10 = b();
        byte b11 = b();
        byte b12 = b();
        byte b13 = b();
        byte b14 = b();
        byte b15 = b();
        return o1.n.k(b(), b(), b15, b14, b13, b12, b11, b10);
    }

    @Override // java.io.DataInput
    @t1.a
    public short readShort() throws IOException {
        return (short) readUnsignedShort();
    }

    @Override // java.io.DataInput
    @t1.a
    public String readUTF() throws IOException {
        return new DataInputStream(((FilterInputStream) this).in).readUTF();
    }

    @Override // java.io.DataInput
    @t1.a
    public int readUnsignedByte() throws IOException {
        int i10 = ((FilterInputStream) this).in.read();
        if (i10 >= 0) {
            return i10;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    @t1.a
    public int readUnsignedShort() throws IOException {
        return o1.l.k((byte) 0, (byte) 0, b(), b());
    }

    @Override // java.io.DataInput
    public int skipBytes(int n10) throws IOException {
        return (int) ((FilterInputStream) this).in.skip(n10);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] b10, int off, int len) throws IOException {
        h.q(this, b10, off, len);
    }
}
