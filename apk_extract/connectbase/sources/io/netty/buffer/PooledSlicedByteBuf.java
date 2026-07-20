package io.netty.buffer;

import io.netty.util.ByteProcessor;
import io.netty.util.internal.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: loaded from: classes2.dex */
final class PooledSlicedByteBuf extends AbstractPooledDerivedByteBuf {
    private static final ObjectPool<PooledSlicedByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledSlicedByteBuf>() { // from class: io.netty.buffer.PooledSlicedByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledSlicedByteBuf newObject(ObjectPool.Handle<PooledSlicedByteBuf> handle) {
            return new PooledSlicedByteBuf(handle);
        }
    });
    int adjustment;

    private int idx(int i10) {
        return i10 + this.adjustment;
    }

    public static PooledSlicedByteBuf newInstance(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i10, int i11) {
        AbstractUnpooledSlicedByteBuf.checkSliceOutOfBounds(i10, i11, abstractByteBuf);
        return newInstance0(abstractByteBuf, byteBuf, i10, i11);
    }

    private static PooledSlicedByteBuf newInstance0(AbstractByteBuf abstractByteBuf, ByteBuf byteBuf, int i10, int i11) {
        PooledSlicedByteBuf pooledSlicedByteBuf = RECYCLER.get();
        pooledSlicedByteBuf.init(abstractByteBuf, byteBuf, 0, i11, i11);
        pooledSlicedByteBuf.discardMarks();
        pooledSlicedByteBuf.adjustment = i10;
        return pooledSlicedByteBuf;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return unwrap()._getByte(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return unwrap()._getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return unwrap()._getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return unwrap()._getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return unwrap()._getLongLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return unwrap()._getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return unwrap()._getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return unwrap()._getUnsignedMedium(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return unwrap()._getUnsignedMediumLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        unwrap()._setByte(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        unwrap()._setInt(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        unwrap()._setIntLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        unwrap()._setLong(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        unwrap().setLongLE(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        unwrap()._setMedium(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        unwrap()._setMediumLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        unwrap()._setShort(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        unwrap()._setShortLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return idx(unwrap().arrayOffset());
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().copy(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf duplicate() {
        return duplicate0().setIndex(idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByte(int i10, int i11, ByteProcessor byteProcessor) throws Throwable {
        checkIndex0(i10, i11);
        int iForEachByte = unwrap().forEachByte(idx(i10), i11, byteProcessor);
        int i12 = this.adjustment;
        if (iForEachByte < i12) {
            return -1;
        }
        return iForEachByte - i12;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int forEachByteDesc(int i10, int i11, ByteProcessor byteProcessor) throws Throwable {
        checkIndex0(i10, i11);
        int iForEachByteDesc = unwrap().forEachByteDesc(idx(i10), i11, byteProcessor);
        int i12 = this.adjustment;
        if (iForEachByteDesc < i12) {
            return -1;
        }
        return iForEachByteDesc - i12;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex0(i10, 1);
        return unwrap().getByte(idx(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex0(i10, 4);
        return unwrap().getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex0(i10, 4);
        return unwrap().getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex0(i10, 8);
        return unwrap().getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        checkIndex0(i10, 8);
        return unwrap().getLongLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex0(i10, 2);
        return unwrap().getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex0(i10, 2);
        return unwrap().getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        checkIndex0(i10, 3);
        return unwrap().getUnsignedMedium(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        checkIndex0(i10, 3);
        return unwrap().getUnsignedMediumLE(idx(i10));
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return unwrap().memoryAddress() + ((long) this.adjustment);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffer(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex0(i10, i11);
        return unwrap().nioBuffers(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedDuplicate() {
        return PooledDuplicatedByteBuf.newInstance(unwrap(), this, idx(readerIndex()), idx(writerIndex()));
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf retainedSlice(int i10, int i11) {
        checkIndex0(i10, i11);
        return newInstance0(unwrap(), this, idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex0(i10, 1);
        unwrap().setByte(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex0(i10, 4);
        unwrap().setInt(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        checkIndex0(i10, 4);
        unwrap().setIntLE(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        checkIndex0(i10, 8);
        unwrap().setLong(idx(i10), j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        checkIndex0(i10, 8);
        unwrap().setLongLE(idx(i10), j10);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex0(i10, 3);
        unwrap().setMedium(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        checkIndex0(i10, 3);
        unwrap().setMediumLE(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex0(i10, 2);
        unwrap().setShort(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        checkIndex0(i10, 2);
        unwrap().setShortLE(idx(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractPooledDerivedByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf slice(int i10, int i11) {
        checkIndex0(i10, i11);
        return super.slice(idx(i10), i11);
    }

    private PooledSlicedByteBuf(ObjectPool.Handle<PooledSlicedByteBuf> handle) {
        super(handle);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        throw new UnsupportedOperationException("sliced buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().getBytes(idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex0(i10, i12);
        unwrap().setBytes(idx(i10), byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        checkIndex0(i10, byteBuffer.remaining());
        unwrap().getBytes(idx(i10), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        checkIndex0(i10, byteBuffer.remaining());
        unwrap().setBytes(idx(i10), byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        checkIndex0(i10, i11);
        unwrap().getBytes(idx(i10), outputStream, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), inputStream, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().getBytes(idx(i10), gatheringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), scatteringByteChannel, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().getBytes(idx(i10), fileChannel, j10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        checkIndex0(i10, i11);
        return unwrap().setBytes(idx(i10), fileChannel, j10, i11);
    }
}
