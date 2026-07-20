package io.netty.buffer;

import io.netty.util.ByteProcessor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class DuplicatedByteBuf extends AbstractDerivedByteBuf {
    private final ByteBuf buffer;

    public DuplicatedByteBuf(ByteBuf byteBuf) {
        this(byteBuf, byteBuf.readerIndex(), byteBuf.writerIndex());
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return unwrap().getByte(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return unwrap().getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return unwrap().getIntLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return unwrap().getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return unwrap().getLongLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return unwrap().getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return unwrap().getShortLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return unwrap().getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return unwrap().getUnsignedMediumLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        unwrap().setByte(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        unwrap().setInt(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        unwrap().setIntLE(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        unwrap().setLong(i10, j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        unwrap().setLongLE(i10, j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        unwrap().setMedium(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        unwrap().setMediumLE(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        unwrap().setShort(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        unwrap().setShortLE(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return unwrap().alloc();
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return unwrap().array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return unwrap().arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return unwrap().capacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        return unwrap().copy(i10, i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) {
        return unwrap().forEachByte(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) {
        return unwrap().forEachByteDesc(i10, i11, byteProcessor);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        return unwrap().getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        unwrap().getBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        return unwrap().getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        return unwrap().getIntLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        return unwrap().getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        return unwrap().getLongLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        return unwrap().getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        return unwrap().getShortLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        return unwrap().getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        return unwrap().getUnsignedMediumLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return unwrap().hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return unwrap().hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return unwrap().isDirect();
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return unwrap().nioBufferCount();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        return unwrap().nioBuffers(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    @Deprecated
    public ByteOrder order() {
        return unwrap().order();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        unwrap().setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        unwrap().setBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        unwrap().setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        unwrap().setIntLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        unwrap().setLong(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        unwrap().setLongLE(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        unwrap().setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        unwrap().setMediumLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        unwrap().setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        unwrap().setShortLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        return unwrap().slice(i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return this.buffer;
    }

    public DuplicatedByteBuf(ByteBuf byteBuf, int i10, int i11) {
        super(byteBuf.maxCapacity());
        if (byteBuf instanceof DuplicatedByteBuf) {
            this.buffer = ((DuplicatedByteBuf) byteBuf).buffer;
        } else if (byteBuf instanceof AbstractPooledDerivedByteBuf) {
            this.buffer = byteBuf.unwrap();
        } else {
            this.buffer = byteBuf;
        }
        setIndex(i10, i11);
        markReaderIndex();
        markWriterIndex();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        unwrap().capacity(i10);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        unwrap().getBytes(i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        unwrap().setBytes(i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        unwrap().getBytes(i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        unwrap().setBytes(i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        unwrap().getBytes(i10, outputStream, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        return unwrap().setBytes(i10, inputStream, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        return unwrap().getBytes(i10, gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException {
        return unwrap().setBytes(i10, scatteringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        return unwrap().getBytes(i10, fileChannel, j10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        return unwrap().setBytes(i10, fileChannel, j10, i11);
    }
}
