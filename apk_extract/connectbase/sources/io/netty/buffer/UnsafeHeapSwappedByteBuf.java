package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes2.dex */
final class UnsafeHeapSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeHeapSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static int idx(ByteBuf byteBuf, int i10) {
        return byteBuf.arrayOffset() + i10;
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public int _getInt(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getInt(abstractByteBuf.array(), idx(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public long _getLong(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getLong(abstractByteBuf.array(), idx(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public short _getShort(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getShort(abstractByteBuf.array(), idx(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setInt(AbstractByteBuf abstractByteBuf, int i10, int i11) {
        PlatformDependent.putInt(abstractByteBuf.array(), idx(abstractByteBuf, i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setLong(AbstractByteBuf abstractByteBuf, int i10, long j10) {
        PlatformDependent.putLong(abstractByteBuf.array(), idx(abstractByteBuf, i10), j10);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setShort(AbstractByteBuf abstractByteBuf, int i10, short s10) {
        PlatformDependent.putShort(abstractByteBuf.array(), idx(abstractByteBuf, i10), s10);
    }
}
