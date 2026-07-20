package io.netty.buffer;

import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
class UnpooledUnsafeNoCleanerDirectByteBuf extends UnpooledUnsafeDirectByteBuf {
    public UnpooledUnsafeNoCleanerDirectByteBuf(ByteBufAllocator byteBufAllocator, int i10, int i11) {
        super(byteBufAllocator, i10, i11);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public ByteBuffer allocateDirect(int i10) {
        return PlatformDependent.allocateDirectNoCleaner(i10);
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        checkNewCapacity(i10);
        if (i10 == capacity()) {
            return this;
        }
        trimIndicesToCapacity(i10);
        setByteBuffer(reallocateDirect(this.buffer, i10), false);
        return this;
    }

    @Override // io.netty.buffer.UnpooledDirectByteBuf
    public void freeDirect(ByteBuffer byteBuffer) {
        PlatformDependent.freeDirectNoCleaner(byteBuffer);
    }

    public ByteBuffer reallocateDirect(ByteBuffer byteBuffer, int i10) {
        return PlatformDependent.reallocateDirectNoCleaner(byteBuffer, i10);
    }
}
