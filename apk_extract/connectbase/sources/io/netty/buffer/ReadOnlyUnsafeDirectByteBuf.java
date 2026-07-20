package io.netty.buffer;

import h.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class ReadOnlyUnsafeDirectByteBuf extends ReadOnlyByteBufferBuf {
    private final long memoryAddress;

    public ReadOnlyUnsafeDirectByteBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBufAllocator, byteBuffer);
        this.memoryAddress = PlatformDependent.directBufferAddress(this.buffer);
    }

    private long addr(int i10) {
        return this.memoryAddress + ((long) i10);
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return UnsafeByteBufUtil.getByte(addr(i10));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return UnsafeByteBufUtil.getInt(addr(i10));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return UnsafeByteBufUtil.getLong(addr(i10));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return UnsafeByteBufUtil.getShort(addr(i10));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return UnsafeByteBufUtil.getUnsignedMedium(addr(i10));
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        checkIndex(i10, i11);
        ByteBuf byteBufDirectBuffer = alloc().directBuffer(i11, maxCapacity());
        if (i11 != 0) {
            if (byteBufDirectBuffer.hasMemoryAddress()) {
                PlatformDependent.copyMemory(addr(i10), byteBufDirectBuffer.memoryAddress(), i11);
                byteBufDirectBuffer.setIndex(0, i11);
            } else {
                byteBufDirectBuffer.writeBytes(this, i10, i11);
            }
        }
        return byteBufDirectBuffer;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkIndex(i10, i12);
        ObjectUtil.checkNotNull(byteBuf, "dst");
        if (i11 < 0 || i11 > byteBuf.capacity() - i12) {
            throw new IndexOutOfBoundsException(a.a("dstIndex: ", i11));
        }
        if (byteBuf.hasMemoryAddress()) {
            PlatformDependent.copyMemory(addr(i10), ((long) i11) + byteBuf.memoryAddress(), i12);
        } else if (byteBuf.hasArray()) {
            PlatformDependent.copyMemory(addr(i10), byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else {
            byteBuf.setBytes(i11, this, i10, i12);
        }
        return this;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return true;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public long memoryAddress() {
        return this.memoryAddress;
    }

    @Override // io.netty.buffer.ReadOnlyByteBufferBuf, io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkIndex(i10, i12);
        ObjectUtil.checkNotNull(bArr, "dst");
        if (i11 < 0 || i11 > bArr.length - i12) {
            throw new IndexOutOfBoundsException(String.format("dstIndex: %d, length: %d (expected: range(0, %d))", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(bArr.length)));
        }
        if (i12 != 0) {
            PlatformDependent.copyMemory(addr(i10), bArr, i11, i12);
        }
        return this;
    }
}
