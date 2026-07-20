package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
class UnpooledSlicedByteBuf extends AbstractUnpooledSlicedByteBuf {
    public UnpooledSlicedByteBuf(AbstractByteBuf abstractByteBuf, int i10, int i11) {
        super(abstractByteBuf, i10, i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return unwrap()._getByte(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return unwrap()._getInt(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return unwrap()._getIntLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return unwrap()._getLong(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return unwrap()._getLongLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return unwrap()._getShort(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return unwrap()._getShortLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return unwrap()._getUnsignedMedium(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return unwrap()._getUnsignedMediumLE(idx(i10));
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        unwrap()._setByte(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        unwrap()._setInt(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        unwrap()._setIntLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        unwrap()._setLong(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        unwrap()._setLongLE(idx(i10), j10);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        unwrap()._setMedium(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        unwrap()._setMediumLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        unwrap()._setShort(idx(i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        unwrap()._setShortLE(idx(i10), i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // io.netty.buffer.AbstractUnpooledSlicedByteBuf, io.netty.buffer.ByteBuf
    public AbstractByteBuf unwrap() {
        return (AbstractByteBuf) super.unwrap();
    }
}
