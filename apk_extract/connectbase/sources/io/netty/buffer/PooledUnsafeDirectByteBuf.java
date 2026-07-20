package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class PooledUnsafeDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final ObjectPool<PooledUnsafeDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledUnsafeDirectByteBuf>() { // from class: io.netty.buffer.PooledUnsafeDirectByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledUnsafeDirectByteBuf newObject(ObjectPool.Handle<PooledUnsafeDirectByteBuf> handle) {
            return new PooledUnsafeDirectByteBuf(handle, 0);
        }
    });
    private long memoryAddress;

    private long addr(int i10) {
        return this.memoryAddress + ((long) i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void initMemoryAddress() {
        this.memoryAddress = PlatformDependent.directBufferAddress((ByteBuffer) this.memory) + ((long) this.offset);
    }

    public static PooledUnsafeDirectByteBuf newInstance(int i10) {
        PooledUnsafeDirectByteBuf pooledUnsafeDirectByteBuf = RECYCLER.get();
        pooledUnsafeDirectByteBuf.reuse(i10);
        return pooledUnsafeDirectByteBuf;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return UnsafeByteBufUtil.getIntLE(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return UnsafeByteBufUtil.getLongLE(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return UnsafeByteBufUtil.getShortLE(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(addr(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        UnsafeByteBufUtil.setByte(addr(i10), (byte) i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        UnsafeByteBufUtil.setInt(addr(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        UnsafeByteBufUtil.setIntLE(addr(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        UnsafeByteBufUtil.setLong(addr(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        UnsafeByteBufUtil.setLongLE(addr(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        UnsafeByteBufUtil.setMedium(addr(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        UnsafeByteBufUtil.setMediumLE(addr(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        UnsafeByteBufUtil.setShort(addr(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        UnsafeByteBufUtil.setShortLE(addr(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        throw new UnsupportedOperationException("direct buffer");
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        return UnsafeByteBufUtil.copy(this, addr(i10), i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.PooledByteBuf
    public void init(PoolChunk<ByteBuffer> poolChunk, ByteBuffer byteBuffer, long j10, int i10, int i11, int i12, PoolThreadCache poolThreadCache) {
        super.init(poolChunk, byteBuffer, j10, i10, i11, i12, poolThreadCache);
        initMemoryAddress();
    }

    @Override // io.netty.buffer.PooledByteBuf
    public void initUnpooled(PoolChunk<ByteBuffer> poolChunk, int i10) {
        super.initUnpooled(poolChunk, i10);
        initMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        ensureAccessible();
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeDirectSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, byteBuf, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        checkIndex(i10, i11);
        UnsafeByteBufUtil.setZero(addr(i10), i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        ensureWritable(i10);
        int i11 = this.writerIndex;
        UnsafeByteBufUtil.setZero(addr(i11), i10);
        this.writerIndex = i11 + i10;
        return this;
    }

    private PooledUnsafeDirectByteBuf(ObjectPool.Handle<PooledUnsafeDirectByteBuf> handle, int i10) {
        super(handle, i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        UnsafeByteBufUtil.setBytes(this, addr(i10), i10, byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        UnsafeByteBufUtil.getBytes(this, addr(i10), i10, outputStream, i11);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        return UnsafeByteBufUtil.setBytes(this, addr(i10), i10, inputStream, i11);
    }
}
