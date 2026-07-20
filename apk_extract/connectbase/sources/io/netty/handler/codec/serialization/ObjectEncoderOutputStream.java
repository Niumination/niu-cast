package io.netty.handler.codec.serialization;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class ObjectEncoderOutputStream extends OutputStream implements ObjectOutput {
    private final int estimatedLength;
    private final DataOutputStream out;

    public ObjectEncoderOutputStream(OutputStream outputStream) {
        this(outputStream, 512);
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.ObjectOutput
    public void close() throws IOException {
        this.out.close();
    }

    @Override // java.io.OutputStream, java.io.Flushable, java.io.ObjectOutput
    public void flush() throws IOException {
        this.out.flush();
    }

    public final int size() {
        return this.out.size();
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(int i10) throws IOException {
        this.out.write(i10);
    }

    @Override // java.io.DataOutput
    public final void writeBoolean(boolean z10) throws IOException {
        this.out.writeBoolean(z10);
    }

    @Override // java.io.DataOutput
    public final void writeByte(int i10) throws IOException {
        this.out.writeByte(i10);
    }

    @Override // java.io.DataOutput
    public final void writeBytes(String str) throws IOException {
        this.out.writeBytes(str);
    }

    @Override // java.io.DataOutput
    public final void writeChar(int i10) throws IOException {
        this.out.writeChar(i10);
    }

    @Override // java.io.DataOutput
    public final void writeChars(String str) throws IOException {
        this.out.writeChars(str);
    }

    @Override // java.io.DataOutput
    public final void writeDouble(double d10) throws IOException {
        this.out.writeDouble(d10);
    }

    @Override // java.io.DataOutput
    public final void writeFloat(float f10) throws IOException {
        this.out.writeFloat(f10);
    }

    @Override // java.io.DataOutput
    public final void writeInt(int i10) throws IOException {
        this.out.writeInt(i10);
    }

    @Override // java.io.DataOutput
    public final void writeLong(long j10) throws IOException {
        this.out.writeLong(j10);
    }

    @Override // java.io.ObjectOutput
    public void writeObject(Object obj) throws IOException {
        ByteBuf byteBufBuffer = Unpooled.buffer(this.estimatedLength);
        try {
            CompactObjectOutputStream compactObjectOutputStream = new CompactObjectOutputStream(new ByteBufOutputStream(byteBufBuffer));
            try {
                compactObjectOutputStream.writeObject(obj);
                compactObjectOutputStream.flush();
                compactObjectOutputStream.close();
                int i10 = byteBufBuffer.readableBytes();
                writeInt(i10);
                byteBufBuffer.getBytes(0, this, i10);
                byteBufBuffer.release();
            } catch (Throwable th2) {
                compactObjectOutputStream.close();
                throw th2;
            }
        } catch (Throwable th3) {
            byteBufBuffer.release();
            throw th3;
        }
    }

    @Override // java.io.DataOutput
    public final void writeShort(int i10) throws IOException {
        this.out.writeShort(i10);
    }

    @Override // java.io.DataOutput
    public final void writeUTF(String str) throws IOException {
        this.out.writeUTF(str);
    }

    public ObjectEncoderOutputStream(OutputStream outputStream, int i10) {
        ObjectUtil.checkNotNull(outputStream, "out");
        ObjectUtil.checkPositiveOrZero(i10, "estimatedLength");
        if (outputStream instanceof DataOutputStream) {
            this.out = (DataOutputStream) outputStream;
        } else {
            this.out = new DataOutputStream(outputStream);
        }
        this.estimatedLength = i10;
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] bArr, int i10, int i11) throws IOException {
        this.out.write(bArr, i10, i11);
    }

    @Override // java.io.OutputStream, java.io.ObjectOutput, java.io.DataOutput
    public void write(byte[] bArr) throws IOException {
        this.out.write(bArr);
    }
}
