package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class PooledHeapByteBuf extends PooledByteBuf<byte[]> {
    private static final ObjectPool<PooledHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledHeapByteBuf>() { // from class: io.netty.buffer.PooledHeapByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledHeapByteBuf newObject(ObjectPool.Handle<PooledHeapByteBuf> handle) {
            return new PooledHeapByteBuf(handle, 0);
        }
    });

    public PooledHeapByteBuf(ObjectPool.Handle<? extends PooledHeapByteBuf> handle, int i10) {
        super(handle, i10);
    }

    public static PooledHeapByteBuf newInstance(int i10) {
        PooledHeapByteBuf pooledHeapByteBuf = RECYCLER.get();
        pooledHeapByteBuf.reuse(i10);
        return pooledHeapByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return HeapByteBufUtil.getByte((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return HeapByteBufUtil.getInt((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return HeapByteBufUtil.getIntLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return HeapByteBufUtil.getLong((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return HeapByteBufUtil.getLongLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return HeapByteBufUtil.getShort((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return HeapByteBufUtil.getShortLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return HeapByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return HeapByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        HeapByteBufUtil.setByte((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        HeapByteBufUtil.setInt((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        HeapByteBufUtil.setIntLE((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        HeapByteBufUtil.setLong((byte[]) this.memory, idx(i10), j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        HeapByteBufUtil.setLongLE((byte[]) this.memory, idx(i10), j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        HeapByteBufUtil.setMedium((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        HeapByteBufUtil.setMediumLE((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        HeapByteBufUtil.setShort((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        HeapByteBufUtil.setShortLE((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final byte[] array() {
        ensureAccessible();
        return (byte[]) this.memory;
    }

    @Override // io.netty.buffer.ByteBuf
    public final int arrayOffset() {
        return this.offset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf copy(int i10, int i11) {
        checkIndex(i10, i11);
        return alloc().heapBuffer(i11, maxCapacity()).writeBytes((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer duplicateInternalNioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return ByteBuffer.wrap((byte[]) this.memory, idx(i10), i11).slice();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory((byte[]) this.memory, idx(i10), ((long) i11) + byteBuf.memoryAddress(), i12);
        } else if (byteBuf.hasArray()) {
            getBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else {
            byteBuf.setBytes(i11, (byte[]) this.memory, idx(i10), i12);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasArray() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean hasMemoryAddress() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isDirect() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public final long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(byteBuf.memoryAddress() + ((long) i11), (byte[]) this.memory, idx(i10), i12);
        } else if (byteBuf.hasArray()) {
            setBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else {
            byteBuf.getBytes(i11, (byte[]) this.memory, idx(i10), i12);
        }
        return this;
    }

    @Override // io.netty.buffer.PooledByteBuf
    public final ByteBuffer newInternalNioBuffer(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        System.arraycopy(this.memory, idx(i10), bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        checkSrcIndex(i10, i12, i11, bArr.length);
        System.arraycopy(bArr, i11, this.memory, idx(i10), i12);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        byteBuffer.put((byte[]) this.memory, idx(i10), iRemaining);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        byteBuffer.get((byte[]) this.memory, idx(i10), iRemaining);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        outputStream.write((byte[]) this.memory, idx(i10), i11);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.ByteBuf
    public final int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        return inputStream.read((byte[]) this.memory, idx(i10), i11);
    }
}
