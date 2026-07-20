package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;

/* JADX INFO: loaded from: classes2.dex */
final class UnsafeDirectSwappedByteBuf extends AbstractUnsafeSwappedByteBuf {
    public UnsafeDirectSwappedByteBuf(AbstractByteBuf abstractByteBuf) {
        super(abstractByteBuf);
    }

    private static long addr(AbstractByteBuf abstractByteBuf, int i10) {
        return abstractByteBuf.memoryAddress() + ((long) i10);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public int _getInt(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getInt(addr(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public long _getLong(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getLong(addr(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public short _getShort(AbstractByteBuf abstractByteBuf, int i10) {
        return PlatformDependent.getShort(addr(abstractByteBuf, i10));
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setInt(AbstractByteBuf abstractByteBuf, int i10, int i11) {
        PlatformDependent.putInt(addr(abstractByteBuf, i10), i11);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setLong(AbstractByteBuf abstractByteBuf, int i10, long j10) {
        PlatformDependent.putLong(addr(abstractByteBuf, i10), j10);
    }

    @Override // io.netty.buffer.AbstractUnsafeSwappedByteBuf
    public void _setShort(AbstractByteBuf abstractByteBuf, int i10, short s10) {
        PlatformDependent.putShort(addr(abstractByteBuf, i10), s10);
    }
}
