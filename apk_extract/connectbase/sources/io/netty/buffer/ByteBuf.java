package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.ReferenceCounted;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ByteBuf implements ReferenceCounted, Comparable<ByteBuf>, ByteBufConvertible {
    public abstract ByteBufAllocator alloc();

    public abstract byte[] array();

    public abstract int arrayOffset();

    @Override // io.netty.buffer.ByteBufConvertible
    public ByteBuf asByteBuf() {
        return this;
    }

    public abstract ByteBuf asReadOnly();

    public abstract int bytesBefore(byte b10);

    public abstract int bytesBefore(int i10, byte b10);

    public abstract int bytesBefore(int i10, int i11, byte b10);

    public abstract int capacity();

    public abstract ByteBuf capacity(int i10);

    public abstract ByteBuf clear();

    @Override // java.lang.Comparable
    public abstract int compareTo(ByteBuf byteBuf);

    public abstract ByteBuf copy();

    public abstract ByteBuf copy(int i10, int i11);

    public abstract ByteBuf discardReadBytes();

    public abstract ByteBuf discardSomeReadBytes();

    public abstract ByteBuf duplicate();

    public abstract int ensureWritable(int i10, boolean z10);

    public abstract ByteBuf ensureWritable(int i10);

    public abstract boolean equals(Object obj);

    public abstract int forEachByte(int i10, int i11, ByteProcessor byteProcessor);

    public abstract int forEachByte(ByteProcessor byteProcessor);

    public abstract int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor);

    public abstract int forEachByteDesc(ByteProcessor byteProcessor);

    public abstract boolean getBoolean(int i10);

    public abstract byte getByte(int i10);

    public abstract int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException;

    public abstract int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException;

    public abstract ByteBuf getBytes(int i10, ByteBuf byteBuf);

    public abstract ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11);

    public abstract ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12);

    public abstract ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException;

    public abstract ByteBuf getBytes(int i10, ByteBuffer byteBuffer);

    public abstract ByteBuf getBytes(int i10, byte[] bArr);

    public abstract ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12);

    public abstract char getChar(int i10);

    public abstract CharSequence getCharSequence(int i10, int i11, Charset charset);

    public abstract double getDouble(int i10);

    public double getDoubleLE(int i10) {
        return Double.longBitsToDouble(getLongLE(i10));
    }

    public abstract float getFloat(int i10);

    public float getFloatLE(int i10) {
        return Float.intBitsToFloat(getIntLE(i10));
    }

    public abstract int getInt(int i10);

    public abstract int getIntLE(int i10);

    public abstract long getLong(int i10);

    public abstract long getLongLE(int i10);

    public abstract int getMedium(int i10);

    public abstract int getMediumLE(int i10);

    public abstract short getShort(int i10);

    public abstract short getShortLE(int i10);

    public abstract short getUnsignedByte(int i10);

    public abstract long getUnsignedInt(int i10);

    public abstract long getUnsignedIntLE(int i10);

    public abstract int getUnsignedMedium(int i10);

    public abstract int getUnsignedMediumLE(int i10);

    public abstract int getUnsignedShort(int i10);

    public abstract int getUnsignedShortLE(int i10);

    public abstract boolean hasArray();

    public abstract boolean hasMemoryAddress();

    public abstract int hashCode();

    public abstract int indexOf(int i10, int i11, byte b10);

    public abstract ByteBuffer internalNioBuffer(int i10, int i11);

    public boolean isAccessible() {
        return refCnt() != 0;
    }

    public boolean isContiguous() {
        return false;
    }

    public abstract boolean isDirect();

    public abstract boolean isReadOnly();

    public abstract boolean isReadable();

    public abstract boolean isReadable(int i10);

    public abstract boolean isWritable();

    public abstract boolean isWritable(int i10);

    public abstract ByteBuf markReaderIndex();

    public abstract ByteBuf markWriterIndex();

    public abstract int maxCapacity();

    public int maxFastWritableBytes() {
        return writableBytes();
    }

    public abstract int maxWritableBytes();

    public abstract long memoryAddress();

    public abstract ByteBuffer nioBuffer();

    public abstract ByteBuffer nioBuffer(int i10, int i11);

    public abstract int nioBufferCount();

    public abstract ByteBuffer[] nioBuffers();

    public abstract ByteBuffer[] nioBuffers(int i10, int i11);

    @Deprecated
    public abstract ByteBuf order(ByteOrder byteOrder);

    @Deprecated
    public abstract ByteOrder order();

    public abstract boolean readBoolean();

    public abstract byte readByte();

    public abstract int readBytes(FileChannel fileChannel, long j10, int i10) throws IOException;

    public abstract int readBytes(GatheringByteChannel gatheringByteChannel, int i10) throws IOException;

    public abstract ByteBuf readBytes(int i10);

    public abstract ByteBuf readBytes(ByteBuf byteBuf);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i10);

    public abstract ByteBuf readBytes(ByteBuf byteBuf, int i10, int i11);

    public abstract ByteBuf readBytes(OutputStream outputStream, int i10) throws IOException;

    public abstract ByteBuf readBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf readBytes(byte[] bArr);

    public abstract ByteBuf readBytes(byte[] bArr, int i10, int i11);

    public abstract char readChar();

    public abstract CharSequence readCharSequence(int i10, Charset charset);

    public abstract double readDouble();

    public double readDoubleLE() {
        return Double.longBitsToDouble(readLongLE());
    }

    public abstract float readFloat();

    public float readFloatLE() {
        return Float.intBitsToFloat(readIntLE());
    }

    public abstract int readInt();

    public abstract int readIntLE();

    public abstract long readLong();

    public abstract long readLongLE();

    public abstract int readMedium();

    public abstract int readMediumLE();

    public abstract ByteBuf readRetainedSlice(int i10);

    public abstract short readShort();

    public abstract short readShortLE();

    public abstract ByteBuf readSlice(int i10);

    public abstract short readUnsignedByte();

    public abstract long readUnsignedInt();

    public abstract long readUnsignedIntLE();

    public abstract int readUnsignedMedium();

    public abstract int readUnsignedMediumLE();

    public abstract int readUnsignedShort();

    public abstract int readUnsignedShortLE();

    public abstract int readableBytes();

    public abstract int readerIndex();

    public abstract ByteBuf readerIndex(int i10);

    public abstract ByteBuf resetReaderIndex();

    public abstract ByteBuf resetWriterIndex();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf retain(int i10);

    public abstract ByteBuf retainedDuplicate();

    public abstract ByteBuf retainedSlice();

    public abstract ByteBuf retainedSlice(int i10, int i11);

    public abstract ByteBuf setBoolean(int i10, boolean z10);

    public abstract ByteBuf setByte(int i10, int i11);

    public abstract int setBytes(int i10, InputStream inputStream, int i11) throws IOException;

    public abstract int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException;

    public abstract int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException;

    public abstract ByteBuf setBytes(int i10, ByteBuf byteBuf);

    public abstract ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11);

    public abstract ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12);

    public abstract ByteBuf setBytes(int i10, ByteBuffer byteBuffer);

    public abstract ByteBuf setBytes(int i10, byte[] bArr);

    public abstract ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12);

    public abstract ByteBuf setChar(int i10, int i11);

    public abstract int setCharSequence(int i10, CharSequence charSequence, Charset charset);

    public abstract ByteBuf setDouble(int i10, double d10);

    public ByteBuf setDoubleLE(int i10, double d10) {
        return setLongLE(i10, Double.doubleToRawLongBits(d10));
    }

    public abstract ByteBuf setFloat(int i10, float f10);

    public ByteBuf setFloatLE(int i10, float f10) {
        return setIntLE(i10, Float.floatToRawIntBits(f10));
    }

    public abstract ByteBuf setIndex(int i10, int i11);

    public abstract ByteBuf setInt(int i10, int i11);

    public abstract ByteBuf setIntLE(int i10, int i11);

    public abstract ByteBuf setLong(int i10, long j10);

    public abstract ByteBuf setLongLE(int i10, long j10);

    public abstract ByteBuf setMedium(int i10, int i11);

    public abstract ByteBuf setMediumLE(int i10, int i11);

    public abstract ByteBuf setShort(int i10, int i11);

    public abstract ByteBuf setShortLE(int i10, int i11);

    public abstract ByteBuf setZero(int i10, int i11);

    public abstract ByteBuf skipBytes(int i10);

    public abstract ByteBuf slice();

    public abstract ByteBuf slice(int i10, int i11);

    public abstract String toString();

    public abstract String toString(int i10, int i11, Charset charset);

    public abstract String toString(Charset charset);

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch();

    @Override // io.netty.util.ReferenceCounted
    public abstract ByteBuf touch(Object obj);

    public abstract ByteBuf unwrap();

    public abstract int writableBytes();

    public abstract ByteBuf writeBoolean(boolean z10);

    public abstract ByteBuf writeByte(int i10);

    public abstract int writeBytes(InputStream inputStream, int i10) throws IOException;

    public abstract int writeBytes(FileChannel fileChannel, long j10, int i10) throws IOException;

    public abstract int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) throws IOException;

    public abstract ByteBuf writeBytes(ByteBuf byteBuf);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i10);

    public abstract ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11);

    public abstract ByteBuf writeBytes(ByteBuffer byteBuffer);

    public abstract ByteBuf writeBytes(byte[] bArr);

    public abstract ByteBuf writeBytes(byte[] bArr, int i10, int i11);

    public abstract ByteBuf writeChar(int i10);

    public abstract int writeCharSequence(CharSequence charSequence, Charset charset);

    public abstract ByteBuf writeDouble(double d10);

    public ByteBuf writeDoubleLE(double d10) {
        return writeLongLE(Double.doubleToRawLongBits(d10));
    }

    public abstract ByteBuf writeFloat(float f10);

    public ByteBuf writeFloatLE(float f10) {
        return writeIntLE(Float.floatToRawIntBits(f10));
    }

    public abstract ByteBuf writeInt(int i10);

    public abstract ByteBuf writeIntLE(int i10);

    public abstract ByteBuf writeLong(long j10);

    public abstract ByteBuf writeLongLE(long j10);

    public abstract ByteBuf writeMedium(int i10);

    public abstract ByteBuf writeMediumLE(int i10);

    public abstract ByteBuf writeShort(int i10);

    public abstract ByteBuf writeShortLE(int i10);

    public abstract ByteBuf writeZero(int i10);

    public abstract int writerIndex();

    public abstract ByteBuf writerIndex(int i10);
}
