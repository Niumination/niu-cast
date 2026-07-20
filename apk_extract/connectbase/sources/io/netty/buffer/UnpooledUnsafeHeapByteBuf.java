package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes2.dex */
public class UnpooledUnsafeHeapByteBuf extends UnpooledHeapByteBuf {
    public UnpooledUnsafeHeapByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(byteBufAllocator, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return UnsafeByteBufUtil.getIntLE(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return UnsafeByteBufUtil.getLongLE(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return UnsafeByteBufUtil.getShortLE(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return UnsafeByteBufUtil.getUnsignedMedium(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return UnsafeByteBufUtil.getUnsignedMediumLE(this.array, i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        UnsafeByteBufUtil.setByte(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        UnsafeByteBufUtil.setInt(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        UnsafeByteBufUtil.setIntLE(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        UnsafeByteBufUtil.setLong(this.array, i10, j10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        UnsafeByteBufUtil.setLongLE(this.array, i10, j10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        UnsafeByteBufUtil.setMedium(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        UnsafeByteBufUtil.setMediumLE(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        UnsafeByteBufUtil.setShort(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        UnsafeByteBufUtil.setShortLE(this.array, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf
    public byte[] allocateArray(int i10) {
        return PlatformDependent.allocateUninitializedArray(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        checkIndex(i10);
        return _getByte(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        checkIndex(i10, 4);
        return _getInt(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        checkIndex(i10, 4);
        return _getIntLE(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        checkIndex(i10, 8);
        return _getLong(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        checkIndex(i10, 8);
        return _getLongLE(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        checkIndex(i10, 2);
        return _getShort(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        checkIndex(i10, 2);
        return _getShortLE(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        checkIndex(i10, 3);
        return _getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        checkIndex(i10, 3);
        return _getUnsignedMediumLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    @Deprecated
    public SwappedByteBuf newSwappedByteBuf() {
        return PlatformDependent.isUnaligned() ? new UnsafeHeapSwappedByteBuf(this) : super.newSwappedByteBuf();
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        checkIndex(i10);
        _setByte(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        checkIndex(i10, 4);
        _setInt(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        checkIndex(i10, 4);
        _setIntLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        checkIndex(i10, 8);
        _setLong(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        checkIndex(i10, 8);
        _setLongLE(i10, j10);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        checkIndex(i10, 3);
        _setMedium(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        checkIndex(i10, 3);
        _setMediumLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        checkIndex(i10, 2);
        _setShort(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.UnpooledHeapByteBuf, io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        checkIndex(i10, 2);
        _setShortLE(i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setZero(int i10, int i11) {
        if (PlatformDependent.javaVersion() < 7) {
            return super.setZero(i10, i11);
        }
        checkIndex(i10, i11);
        UnsafeByteBufUtil.setZero(this.array, i10, i11);
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf writeZero(int i10) {
        if (PlatformDependent.javaVersion() < 7) {
            return super.writeZero(i10);
        }
        ensureWritable(i10);
        int i11 = this.writerIndex;
        UnsafeByteBufUtil.setZero(this.array, i11, i10);
        this.writerIndex = i11 + i10;
        return this;
    }
}
