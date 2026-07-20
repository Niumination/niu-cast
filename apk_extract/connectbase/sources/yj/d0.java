package yj;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.handler.codec.ByteToMessageDecoder;

/* JADX INFO: loaded from: classes2.dex */
public class d0 implements ByteToMessageDecoder.Cumulator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f20887a;

    public d0(int i10) {
        c1.h0.e(i10 >= 0, "composeMinSize must be non-negative");
        this.f20887a = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [io.netty.buffer.ByteBufAllocator] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v3, types: [io.netty.buffer.ByteBuf] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r11v0, types: [io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf, io.netty.buffer.CompositeByteBuf] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [io.netty.util.ReferenceCounted] */
    /* JADX WARN: Type inference failed for: r7v2 */
    @b1.e
    public static void b(ByteBufAllocator byteBufAllocator, CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) throws Throwable {
        int i10 = byteBuf.readableBytes();
        int iNumComponents = compositeByteBuf.numComponents() - 1;
        int byteIndex = compositeByteBuf.toByteIndex(iNumComponents);
        int iWriterIndex = compositeByteBuf.writerIndex() - byteIndex;
        int i11 = i10 + iWriterIndex;
        ByteBuf byteBufComponent = compositeByteBuf.component(iNumComponents);
        ?? r10 = 0;
        try {
            try {
                if (byteBufComponent.refCnt() != 1 || byteBufComponent.isReadOnly() || i11 > byteBufComponent.maxCapacity()) {
                    ByteBuf byteBufBuffer = byteBufAllocator.buffer(byteBufAllocator.calculateNewCapacity(i11, Integer.MAX_VALUE));
                    byteBufBuffer.setBytes(0, (ByteBuf) compositeByteBuf, byteIndex, iWriterIndex).setBytes(iWriterIndex, byteBuf, byteBuf.readerIndex(), i10).writerIndex(i11);
                    byteBuf.readerIndex(byteBuf.writerIndex());
                    byteBufAllocator = byteBufBuffer;
                } else {
                    ByteBuf byteBufRetain = byteBufComponent.retain();
                    ByteBuf byteBufDuplicate = compositeByteBuf.internalComponent(iNumComponents).duplicate();
                    byteBufRetain.setIndex(byteBufDuplicate.readerIndex(), byteBufDuplicate.writerIndex());
                    byteBufRetain.writeBytes(byteBuf);
                    byteBufAllocator = byteBufRetain;
                }
                int i12 = compositeByteBuf.readerIndex();
                compositeByteBuf.removeComponent(iNumComponents).setIndex(0, byteIndex);
                compositeByteBuf.addFlattenedComponents(true, byteBufAllocator);
                compositeByteBuf.readerIndex(i12);
                byteBuf.release();
            } catch (Throwable th2) {
                th = th2;
                r10 = byteBufAllocator;
                if (r10 != 0) {
                    r10.release();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    @b1.e
    public static boolean c(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf, int i10) {
        int iNumComponents = compositeByteBuf.numComponents();
        if (compositeByteBuf.numComponents() == 0) {
            return true;
        }
        return (compositeByteBuf.writerIndex() - compositeByteBuf.toByteIndex(iNumComponents - 1)) + byteBuf.readableBytes() >= i10;
    }

    @b1.e
    public void a(ByteBufAllocator byteBufAllocator, CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) throws Throwable {
        if (c(compositeByteBuf, byteBuf, this.f20887a)) {
            compositeByteBuf.addFlattenedComponents(true, byteBuf);
        } else {
            b(byteBufAllocator, compositeByteBuf, byteBuf);
        }
    }

    @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
    public final ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) throws Throwable {
        if (!byteBuf.isReadable()) {
            byteBuf.release();
            return byteBuf2;
        }
        CompositeByteBuf compositeByteBufAddFlattenedComponents = null;
        try {
            if ((byteBuf instanceof CompositeByteBuf) && byteBuf.refCnt() == 1) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) byteBuf;
                try {
                    if (compositeByteBuf.writerIndex() != compositeByteBuf.capacity()) {
                        compositeByteBuf.capacity(compositeByteBuf.writerIndex());
                    }
                    compositeByteBufAddFlattenedComponents = compositeByteBuf;
                } catch (Throwable th2) {
                    th = th2;
                    compositeByteBufAddFlattenedComponents = compositeByteBuf;
                    if (byteBuf2 != null) {
                        byteBuf2.release();
                        if (compositeByteBufAddFlattenedComponents != null && compositeByteBufAddFlattenedComponents != byteBuf) {
                            compositeByteBufAddFlattenedComponents.release();
                        }
                    }
                    throw th;
                }
            } else {
                compositeByteBufAddFlattenedComponents = byteBufAllocator.compositeBuffer(Integer.MAX_VALUE).addFlattenedComponents(true, byteBuf);
            }
            a(byteBufAllocator, compositeByteBufAddFlattenedComponents, byteBuf2);
            return compositeByteBufAddFlattenedComponents;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
