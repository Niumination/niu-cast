package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
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
class WrappedByteBuf extends ByteBuf {
    protected final ByteBuf buf;

    public WrappedByteBuf(ByteBuf byteBuf) {
        this.buf = (ByteBuf) ObjectUtil.checkNotNull(byteBuf, "buf");
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBufAllocator alloc() {
        return this.buf.alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf asReadOnly() {
        return this.buf.asReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(byte b10) {
        return this.buf.bytesBefore(b10);
    }

    @Override // io.netty.buffer.ByteBuf
    public final int capacity() {
        return this.buf.capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf clear() {
        this.buf.clear();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy() {
        return this.buf.copy();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        this.buf.discardReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf discardSomeReadBytes() {
        this.buf.discardSomeReadBytes();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return this.buf.duplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        this.buf.ensureWritable(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean equals(Object obj) {
        return this.buf.equals(obj);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(ByteProcessor byteProcessor) {
        return this.buf.forEachByte(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean getBoolean(int i10) {
        return this.buf.getBoolean(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        return this.buf.getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf) {
        this.buf.getBytes(i10, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public char getChar(int i10) {
        return this.buf.getChar(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence getCharSequence(int i10, int i11, Charset charset) {
        return this.buf.getCharSequence(i10, i11, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double getDouble(int i10) {
        return this.buf.getDouble(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public float getFloat(int i10) {
        return this.buf.getFloat(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        return this.buf.getInt(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        return this.buf.getIntLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        return this.buf.getLong(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        return this.buf.getLongLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMedium(int i10) {
        return this.buf.getMedium(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getMediumLE(int i10) {
        return this.buf.getMediumLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        return this.buf.getShort(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        return this.buf.getShortLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short getUnsignedByte(int i10) {
        return this.buf.getUnsignedByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedInt(int i10) {
        return this.buf.getUnsignedInt(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public long getUnsignedIntLE(int i10) {
        return this.buf.getUnsignedIntLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        return this.buf.getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        return this.buf.getUnsignedMediumLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShort(int i10) {
        return this.buf.getUnsignedShort(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getUnsignedShortLE(int i10) {
        return this.buf.getUnsignedShortLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return this.buf.hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int hashCode() {
        return this.buf.hashCode();
    }

    @Override // io.netty.buffer.ByteBuf
    public int indexOf(int i10, int i11, byte b10) {
        return this.buf.indexOf(i10, i11, b10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        return this.buf.internalNioBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isAccessible() {
        return this.buf.isAccessible();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isContiguous() {
        return this.buf.isContiguous();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return this.buf.isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buf.isReadOnly();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable() {
        return this.buf.isReadable();
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isWritable() {
        return this.buf.isWritable();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf markReaderIndex() {
        this.buf.markReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf markWriterIndex() {
        this.buf.markWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxCapacity() {
        return this.buf.maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public int maxFastWritableBytes() {
        return this.buf.maxFastWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int maxWritableBytes() {
        return this.buf.maxWritableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        return this.buf.memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer() {
        return this.buf.nioBuffer();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.buf.nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers() {
        return this.buf.nioBuffers();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteOrder order() {
        return this.buf.order();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean readBoolean() {
        return this.buf.readBoolean();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte readByte() {
        return this.buf.readByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(int i10) {
        return this.buf.readBytes(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public char readChar() {
        return this.buf.readChar();
    }

    @Override // io.netty.buffer.ByteBuf
    public CharSequence readCharSequence(int i10, Charset charset) {
        return this.buf.readCharSequence(i10, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public double readDouble() {
        return this.buf.readDouble();
    }

    @Override // io.netty.buffer.ByteBuf
    public float readFloat() {
        return this.buf.readFloat();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readInt() {
        return this.buf.readInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readIntLE() {
        return this.buf.readIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLong() {
        return this.buf.readLong();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readLongLE() {
        return this.buf.readLongLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMedium() {
        return this.buf.readMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readMediumLE() {
        return this.buf.readMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readRetainedSlice(int i10) {
        return this.buf.readRetainedSlice(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShort() {
        return this.buf.readShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public short readShortLE() {
        return this.buf.readShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readSlice(int i10) {
        return this.buf.readSlice(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public short readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedInt() {
        return this.buf.readUnsignedInt();
    }

    @Override // io.netty.buffer.ByteBuf
    public long readUnsignedIntLE() {
        return this.buf.readUnsignedIntLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedMediumLE() {
        return this.buf.readUnsignedMediumLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }

    @Override // io.netty.buffer.ByteBuf
    public int readUnsignedShortLE() {
        return this.buf.readUnsignedShortLE();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public final int readerIndex() {
        return this.buf.readerIndex();
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.buf.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release() {
        return this.buf.release();
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetReaderIndex() {
        this.buf.resetReaderIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf resetWriterIndex() {
        this.buf.resetWriterIndex();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return this.buf.retainedDuplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice() {
        return this.buf.retainedSlice();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBoolean(int i10, boolean z10) {
        this.buf.setBoolean(i10, z10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        this.buf.setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf) {
        this.buf.setBytes(i10, byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setChar(int i10, int i11) {
        this.buf.setChar(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setCharSequence(int i10, CharSequence charSequence, Charset charset) {
        return this.buf.setCharSequence(i10, charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setDouble(int i10, double d10) {
        this.buf.setDouble(i10, d10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setFloat(int i10, float f10) {
        this.buf.setFloat(i10, f10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIndex(int i10, int i11) {
        this.buf.setIndex(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        this.buf.setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        this.buf.setIntLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        this.buf.setLong(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        this.buf.setLongLE(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        this.buf.setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        this.buf.setMediumLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        this.buf.setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        this.buf.setShortLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        this.buf.setZero(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf skipBytes(int i10) {
        this.buf.skipBytes(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice() {
        return this.buf.slice();
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(Charset charset) {
        return this.buf.toString(charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf unwrap() {
        return this.buf;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writableBytes() {
        return this.buf.writableBytes();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBoolean(boolean z10) {
        this.buf.writeBoolean(z10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeByte(int i10) {
        this.buf.writeByte(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf) {
        this.buf.writeBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeChar(int i10) {
        this.buf.writeChar(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeCharSequence(CharSequence charSequence, Charset charset) {
        return this.buf.writeCharSequence(charSequence, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeDouble(double d10) {
        this.buf.writeDouble(d10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeFloat(float f10) {
        this.buf.writeFloat(f10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeInt(int i10) {
        this.buf.writeInt(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeIntLE(int i10) {
        this.buf.writeIntLE(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLong(long j10) {
        this.buf.writeLong(j10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeLongLE(long j10) {
        this.buf.writeLongLE(j10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMedium(int i10) {
        this.buf.writeMedium(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeMediumLE(int i10) {
        this.buf.writeMediumLE(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShort(int i10) {
        this.buf.writeShort(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeShortLE(int i10) {
        this.buf.writeShortLE(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        this.buf.writeZero(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int writerIndex() {
        return this.buf.writerIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i10, byte b10) {
        return this.buf.bytesBefore(i10, b10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        this.buf.capacity(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, java.lang.Comparable
    public int compareTo(ByteBuf byteBuf) {
        return this.buf.compareTo(byteBuf);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        return this.buf.copy(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int ensureWritable(int i10, boolean z10) {
        return this.buf.ensureWritable(i10, z10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        return this.buf.forEachByte(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) {
        return this.buf.forEachByteDesc(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11) {
        this.buf.getBytes(i10, byteBuf, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isReadable(int i10) {
        return this.buf.isReadable(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isWritable(int i10) {
        return this.buf.isWritable(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        return this.buf.nioBuffer(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        return this.buf.nioBuffers(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf order(ByteOrder byteOrder) {
        return this.buf.order(byteOrder);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf) {
        this.buf.readBytes(byteBuf);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf readerIndex(int i10) {
        this.buf.readerIndex(i10);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public boolean release(int i10) {
        return this.buf.release(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i10, int i11) {
        return this.buf.retainedSlice(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11) {
        this.buf.setBytes(i10, byteBuf, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        return this.buf.slice(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString(int i10, int i11, Charset charset) {
        return this.buf.toString(i10, i11, charset);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10) {
        this.buf.writeBytes(byteBuf, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf writerIndex(int i10) {
        this.buf.writerIndex(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int bytesBefore(int i10, int i11, byte b10) {
        return this.buf.bytesBefore(i10, i11, b10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        this.buf.getBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10) {
        this.buf.readBytes(byteBuf, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain(int i10) {
        this.buf.retain(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        this.buf.setBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public String toString() {
        return StringUtil.simpleClassName(this) + '(' + this.buf.toString() + ')';
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch() {
        this.buf.touch();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuf byteBuf, int i10, int i11) {
        this.buf.writeBytes(byteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr) {
        this.buf.getBytes(i10, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuf byteBuf, int i10, int i11) {
        this.buf.readBytes(byteBuf, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf retain() {
        this.buf.retain();
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr) {
        this.buf.setBytes(i10, bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf, io.netty.util.ReferenceCounted
    public ByteBuf touch(Object obj) {
        this.buf.touch(obj);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr) {
        this.buf.writeBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        this.buf.getBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr) {
        this.buf.readBytes(bArr);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        this.buf.setBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(byte[] bArr, int i10, int i11) {
        this.buf.writeBytes(bArr, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        this.buf.getBytes(i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i10, int i11) {
        this.buf.readBytes(bArr, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        this.buf.setBytes(i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf writeBytes(ByteBuffer byteBuffer) {
        this.buf.writeBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        this.buf.getBytes(i10, outputStream, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        return this.buf.setBytes(i10, inputStream, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(InputStream inputStream, int i10) throws IOException {
        return this.buf.writeBytes(inputStream, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        return this.buf.getBytes(i10, gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i10) throws IOException {
        this.buf.readBytes(outputStream, i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException {
        return this.buf.setBytes(i10, scatteringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(ScatteringByteChannel scatteringByteChannel, int i10) throws IOException {
        return this.buf.writeBytes(scatteringByteChannel, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        return this.buf.getBytes(i10, fileChannel, j10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(GatheringByteChannel gatheringByteChannel, int i10) throws IOException {
        return this.buf.readBytes(gatheringByteChannel, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        return this.buf.setBytes(i10, fileChannel, j10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int writeBytes(FileChannel fileChannel, long j10, int i10) throws IOException {
        return this.buf.writeBytes(fileChannel, j10, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public int readBytes(FileChannel fileChannel, long j10, int i10) throws IOException {
        return this.buf.readBytes(fileChannel, j10, i10);
    }
}
