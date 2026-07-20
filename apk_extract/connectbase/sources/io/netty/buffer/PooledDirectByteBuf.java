package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class PooledDirectByteBuf extends PooledByteBuf<ByteBuffer> {
    private static final ObjectPool<PooledDirectByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledDirectByteBuf>() { // from class: io.netty.buffer.PooledDirectByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledDirectByteBuf newObject(ObjectPool.Handle<PooledDirectByteBuf> handle) {
            return new PooledDirectByteBuf(handle, 0);
        }
    });

    public static PooledDirectByteBuf newInstance(int i10) {
        PooledDirectByteBuf pooledDirectByteBuf = RECYCLER.get();
        pooledDirectByteBuf.reuse(i10);
        return pooledDirectByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return ((ByteBuffer) this.memory).get(idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return ((ByteBuffer) this.memory).getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return ByteBufUtil.swapInt(_getInt(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return ((ByteBuffer) this.memory).getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return ByteBufUtil.swapLong(_getLong(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return ((ByteBuffer) this.memory).getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return ByteBufUtil.swapShort(_getShort(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        int iIdx = idx(i10);
        return (((ByteBuffer) this.memory).get(iIdx + 2) & 255) | ((((ByteBuffer) this.memory).get(iIdx) & 255) << 16) | ((((ByteBuffer) this.memory).get(iIdx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        int iIdx = idx(i10);
        return ((((ByteBuffer) this.memory).get(iIdx + 2) & 255) << 16) | (((ByteBuffer) this.memory).get(iIdx) & 255) | ((((ByteBuffer) this.memory).get(iIdx + 1) & 255) << 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        ((ByteBuffer) this.memory).put(idx(i10), (byte) i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        ((ByteBuffer) this.memory).putInt(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        _setInt(i10, ByteBufUtil.swapInt(i11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        ((ByteBuffer) this.memory).putLong(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        _setLong(i10, ByteBufUtil.swapLong(j10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        int iIdx = idx(i10);
        ((ByteBuffer) this.memory).put(iIdx, (byte) (i11 >>> 16));
        ((ByteBuffer) this.memory).put(iIdx + 1, (byte) (i11 >>> 8));
        ((ByteBuffer) this.memory).put(iIdx + 2, (byte) i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        int iIdx = idx(i10);
        ((ByteBuffer) this.memory).put(iIdx, (byte) i11);
        ((ByteBuffer) this.memory).put(iIdx + 1, (byte) (i11 >>> 8));
        ((ByteBuffer) this.memory).put(iIdx + 2, (byte) (i11 >>> 16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        ((ByteBuffer) this.memory).putShort(idx(i10), (short) i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        _setShort(i10, ByteBufUtil.swapShort((short) i11));
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
        checkIndex(i10, i11);
        return alloc().directBuffer(i11, maxCapacity()).writeBytes(this, i10, i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
            for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
                int iRemaining = byteBuffer.remaining();
                getBytes(i10, byteBuffer);
                i10 += iRemaining;
            }
        } else {
            byteBuf.setBytes(i11, this, i10, i12);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(byte[] bArr, int i10, int i11) {
        checkDstIndex(i11, i10, bArr.length);
        _internalNioBuffer(this.readerIndex, i11, false).get(bArr, i10, i11);
        this.readerIndex += i11;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            setBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
            for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
                int iRemaining = byteBuffer.remaining();
                setBytes(i10, byteBuffer);
                i10 += iRemaining;
            }
        } else {
            byteBuf.getBytes(i11, this, i10, i12);
        }
        return this;
    }

    private PooledDirectByteBuf(ObjectPool.Handle<PooledDirectByteBuf> handle, int i10) {
        super(handle, i10);
    }

    @Override // io.netty.buffer.PooledByteBuf
    public ByteBuffer newInternalNioBuffer(ByteBuffer byteBuffer) {
        return byteBuffer.duplicate();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkReadableBytes(iRemaining);
        byteBuffer.put(_internalNioBuffer(this.readerIndex, iRemaining, false));
        this.readerIndex += iRemaining;
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf readBytes(OutputStream outputStream, int i10) throws IOException {
        checkReadableBytes(i10);
        getBytes(this.readerIndex, outputStream, i10, true);
        this.readerIndex += i10;
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        _internalNioBuffer(i10, i12, true).get(bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        _internalNioBuffer(i10, i12, false).put(bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        byteBuffer.put(duplicateInternalNioBuffer(i10, byteBuffer.remaining()));
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        if (byteBuffer == byteBufferInternalNioBuffer) {
            byteBuffer = byteBuffer.duplicate();
        }
        int iIdx = idx(i10);
        byteBufferInternalNioBuffer.limit(iRemaining + iIdx).position(iIdx);
        byteBufferInternalNioBuffer.put(byteBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        getBytes(i10, outputStream, i11, false);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void getBytes(int i10, OutputStream outputStream, int i11, boolean z10) throws IOException {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return;
        }
        ByteBufUtil.readBytes(alloc(), z10 ? internalNioBuffer() : ((ByteBuffer) this.memory).duplicate(), idx(i10), i11, outputStream);
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        byte[] bArrThreadLocalTempArray = ByteBufUtil.threadLocalTempArray(i11);
        int i12 = inputStream.read(bArrThreadLocalTempArray, 0, i11);
        if (i12 <= 0) {
            return i12;
        }
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.position(idx(i10));
        byteBufferInternalNioBuffer.put(bArrThreadLocalTempArray, 0, i12);
        return i12;
    }
}
