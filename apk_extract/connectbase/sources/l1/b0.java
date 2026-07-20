package l1;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@q
@b1.d
public final class b0 extends FilterOutputStream implements DataOutput {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(OutputStream out) {
        super(new DataOutputStream(out));
        out.getClass();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] b10, int off, int len) throws IOException {
        ((FilterOutputStream) this).out.write(b10, off, len);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean v10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(v10);
    }

    @Override // java.io.DataOutput
    public void writeByte(int v10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(v10);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String s10) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(s10);
    }

    @Override // java.io.DataOutput
    public void writeChar(int v10) throws IOException {
        writeShort(v10);
    }

    @Override // java.io.DataOutput
    public void writeChars(String s10) throws IOException {
        for (int i10 = 0; i10 < s10.length(); i10++) {
            writeShort(s10.charAt(i10));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double v10) throws IOException {
        writeLong(Double.doubleToLongBits(v10));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float v10) throws IOException {
        writeInt(Float.floatToIntBits(v10));
    }

    @Override // java.io.DataOutput
    public void writeInt(int v10) throws IOException {
        ((FilterOutputStream) this).out.write(v10 & 255);
        ((FilterOutputStream) this).out.write((v10 >> 8) & 255);
        ((FilterOutputStream) this).out.write((v10 >> 16) & 255);
        ((FilterOutputStream) this).out.write((v10 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long v10) throws IOException {
        byte[] bArrD = o1.n.D(Long.reverseBytes(v10));
        write(bArrD, 0, bArrD.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int v10) throws IOException {
        ((FilterOutputStream) this).out.write(v10 & 255);
        ((FilterOutputStream) this).out.write((v10 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) throws IOException {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
