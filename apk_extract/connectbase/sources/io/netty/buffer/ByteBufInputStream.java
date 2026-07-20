package io.netty.buffer;

import h.b;
import io.netty.util.internal.ObjectUtil;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import lm.g2;

/* JADX INFO: loaded from: classes2.dex */
public class ByteBufInputStream extends InputStream implements DataInput {
    private final ByteBuf buffer;
    private boolean closed;
    private final int endIndex;
    private StringBuilder lineBuf;
    private final boolean releaseOnClose;
    private final int startIndex;

    public ByteBufInputStream(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readableBytes());
    }

    private void checkAvailable(int i10) throws IOException {
        if (i10 < 0) {
            throw new IndexOutOfBoundsException("fieldSize cannot be a negative number");
        }
        if (i10 <= available()) {
            return;
        }
        StringBuilder sbA = b.a("fieldSize is too long! Length is ", i10, ", but maximum is ");
        sbA.append(available());
        throw new EOFException(sbA.toString());
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.endIndex - this.buffer.readerIndex();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            super.close();
        } finally {
            if (this.releaseOnClose && !this.closed) {
                this.closed = true;
                this.buffer.release();
            }
        }
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.buffer.markReaderIndex();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (available() == 0) {
            return -1;
        }
        return this.buffer.readByte() & 255;
    }

    @Override // java.io.DataInput
    public boolean readBoolean() throws IOException {
        checkAvailable(1);
        return read() != 0;
    }

    @Override // java.io.DataInput
    public byte readByte() throws IOException {
        if (available() != 0) {
            return this.buffer.readByte();
        }
        throw new EOFException();
    }

    public int readBytes() {
        return this.buffer.readerIndex() - this.startIndex;
    }

    @Override // java.io.DataInput
    public char readChar() throws IOException {
        return (char) readShort();
    }

    @Override // java.io.DataInput
    public double readDouble() throws IOException {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public float readFloat() throws IOException {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr) throws IOException {
        readFully(bArr, 0, bArr.length);
    }

    @Override // java.io.DataInput
    public int readInt() throws IOException {
        checkAvailable(4);
        return this.buffer.readInt();
    }

    @Override // java.io.DataInput
    public String readLine() throws IOException {
        int iAvailable = available();
        if (iAvailable == 0) {
            return null;
        }
        StringBuilder sb2 = this.lineBuf;
        if (sb2 != null) {
            sb2.setLength(0);
        }
        do {
            short unsignedByte = this.buffer.readUnsignedByte();
            iAvailable--;
            if (unsignedByte != 10) {
                if (unsignedByte == 13) {
                    if (iAvailable <= 0) {
                        break;
                    }
                    ByteBuf byteBuf = this.buffer;
                    if (((char) byteBuf.getUnsignedByte(byteBuf.readerIndex())) != '\n') {
                        break;
                    }
                    this.buffer.skipBytes(1);
                    break;
                }
                if (this.lineBuf == null) {
                    this.lineBuf = new StringBuilder();
                }
                this.lineBuf.append((char) unsignedByte);
            } else {
                break;
            }
        } while (iAvailable > 0);
        StringBuilder sb3 = this.lineBuf;
        return (sb3 == null || sb3.length() <= 0) ? "" : this.lineBuf.toString();
    }

    @Override // java.io.DataInput
    public long readLong() throws IOException {
        checkAvailable(8);
        return this.buffer.readLong();
    }

    @Override // java.io.DataInput
    public short readShort() throws IOException {
        checkAvailable(2);
        return this.buffer.readShort();
    }

    @Override // java.io.DataInput
    public String readUTF() throws IOException {
        return DataInputStream.readUTF(this);
    }

    @Override // java.io.DataInput
    public int readUnsignedByte() throws IOException {
        return readByte() & 255;
    }

    @Override // java.io.DataInput
    public int readUnsignedShort() throws IOException {
        return readShort() & g2.f10190d;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.buffer.resetReaderIndex();
    }

    @Override // java.io.InputStream
    public long skip(long j10) throws IOException {
        return j10 > 2147483647L ? skipBytes(Integer.MAX_VALUE) : skipBytes((int) j10);
    }

    @Override // java.io.DataInput
    public int skipBytes(int i10) throws IOException {
        int iMin = Math.min(available(), i10);
        this.buffer.skipBytes(iMin);
        return iMin;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i10) {
        this(byteBuf, i10, false);
    }

    @Override // java.io.DataInput
    public void readFully(byte[] bArr, int i10, int i11) throws IOException {
        checkAvailable(i11);
        this.buffer.readBytes(bArr, i10, i11);
    }

    public ByteBufInputStream(ByteBuf byteBuf, boolean z10) {
        this(byteBuf, byteBuf.readableBytes(), z10);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int iAvailable = available();
        if (iAvailable == 0) {
            return -1;
        }
        int iMin = Math.min(iAvailable, i11);
        this.buffer.readBytes(bArr, i10, iMin);
        return iMin;
    }

    public ByteBufInputStream(ByteBuf byteBuf, int i10, boolean z10) {
        ObjectUtil.checkNotNull(byteBuf, "buffer");
        if (i10 < 0) {
            if (z10) {
                byteBuf.release();
            }
            ObjectUtil.checkPositiveOrZero(i10, "length");
        }
        if (i10 > byteBuf.readableBytes()) {
            if (z10) {
                byteBuf.release();
            }
            StringBuilder sbA = b.a("Too many bytes to be read - Needs ", i10, ", maximum is ");
            sbA.append(byteBuf.readableBytes());
            throw new IndexOutOfBoundsException(sbA.toString());
        }
        this.releaseOnClose = z10;
        this.buffer = byteBuf;
        int i11 = byteBuf.readerIndex();
        this.startIndex = i11;
        this.endIndex = i11 + i10;
        byteBuf.markReaderIndex();
    }
}
