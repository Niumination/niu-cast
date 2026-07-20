package io.netty.buffer;

/* JADX INFO: loaded from: classes2.dex */
public interface ByteBufAllocator {
    public static final ByteBufAllocator DEFAULT = ByteBufUtil.DEFAULT_ALLOCATOR;

    ByteBuf buffer();

    ByteBuf buffer(int i10);

    ByteBuf buffer(int i10, int i11);

    int calculateNewCapacity(int i10, int i11);

    CompositeByteBuf compositeBuffer();

    CompositeByteBuf compositeBuffer(int i10);

    CompositeByteBuf compositeDirectBuffer();

    CompositeByteBuf compositeDirectBuffer(int i10);

    CompositeByteBuf compositeHeapBuffer();

    CompositeByteBuf compositeHeapBuffer(int i10);

    ByteBuf directBuffer();

    ByteBuf directBuffer(int i10);

    ByteBuf directBuffer(int i10, int i11);

    ByteBuf heapBuffer();

    ByteBuf heapBuffer(int i10);

    ByteBuf heapBuffer(int i10, int i11);

    ByteBuf ioBuffer();

    ByteBuf ioBuffer(int i10);

    ByteBuf ioBuffer(int i10, int i11);

    boolean isDirectBufferPooled();
}
