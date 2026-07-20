package io.netty.buffer;

import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes2.dex */
final class PooledUnsafeHeapByteBuf extends PooledHeapByteBuf {
    private static final ObjectPool<PooledUnsafeHeapByteBuf> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator<PooledUnsafeHeapByteBuf>() { // from class: io.netty.buffer.PooledUnsafeHeapByteBuf.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.netty.util.internal.ObjectPool.ObjectCreator
        public PooledUnsafeHeapByteBuf newObject(ObjectPool.Handle<PooledUnsafeHeapByteBuf> handle) {
            return new PooledUnsafeHeapByteBuf(handle, 0);
        }
    });

    public static PooledUnsafeHeapByteBuf newUnsafeInstance(int i10) {
        PooledUnsafeHeapByteBuf pooledUnsafeHeapByteBuf = RECYCLER.get();
        pooledUnsafeHeapByteBuf.reuse(i10);
        return pooledUnsafeHeapByteBuf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return UnsafeByteBufUtil.getIntLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return UnsafeByteBufUtil.getLongLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return UnsafeByteBufUtil.getShortLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return UnsafeByteBufUtil.getUnsignedMedium((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return UnsafeByteBufUtil.getUnsignedMediumLE((byte[]) this.memory, idx(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        UnsafeByteBufUtil.setByte((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        UnsafeByteBufUtil.setInt((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        UnsafeByteBufUtil.setIntLE((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        UnsafeByteBufUtil.setLong((byte[]) this.memory, idx(i10), j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        UnsafeByteBufUtil.setLongLE((byte[]) this.memory, idx(i10), j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        UnsafeByteBufUtil.setMedium((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        UnsafeByteBufUtil.setMediumLE((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        UnsafeByteBufUtil.setShort((byte[]) this.memory, idx(i10), i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.PooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        UnsafeByteBufUtil.setShortLE((byte[]) this.memory, idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeHeapSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        if (PlatformDependent.javaVersion() < 7) {
            return super.setZero(i10, i11);
        }
        checkIndex(i10, i11);
        UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(i10), i11);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        if (PlatformDependent.javaVersion() < 7) {
            return super.writeZero(i10);
        }
        ensureWritable(i10);
        int i11 = this.writerIndex;
        UnsafeByteBufUtil.setZero((byte[]) this.memory, idx(i11), i10);
        this.writerIndex = i11 + i10;
        return this;
    }

    private PooledUnsafeHeapByteBuf(ObjectPool.Handle<PooledUnsafeHeapByteBuf> handle, int i10) {
        super(handle, i10);
    }
}
