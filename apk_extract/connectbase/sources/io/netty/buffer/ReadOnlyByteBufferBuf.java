package io.netty.buffer;

import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;

/* JADX INFO: loaded from: classes2.dex */
class ReadOnlyByteBufferBuf extends AbstractReferenceCountedByteBuf {
    private final ByteBufAllocator allocator;
    protected final ByteBuffer buffer;
    private ByteBuffer tmpNioBuf;

    public ReadOnlyByteBufferBuf(ByteBufAllocator byteBufAllocator, ByteBuffer byteBuffer) {
        super(byteBuffer.remaining());
        if (!byteBuffer.isReadOnly()) {
            throw new IllegalArgumentException("must be a readonly buffer: " + StringUtil.simpleClassName(byteBuffer));
        }
        this.allocator = byteBufAllocator;
        ByteBuffer byteBufferOrder = byteBuffer.slice().order(ByteOrder.BIG_ENDIAN);
        this.buffer = byteBufferOrder;
        writerIndex(byteBufferOrder.limit());
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        return this.buffer.get(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        return this.buffer.getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        return ByteBufUtil.swapInt(this.buffer.getInt(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        return this.buffer.getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        return ByteBufUtil.swapLong(this.buffer.getLong(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        return this.buffer.getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        return ByteBufUtil.swapShort(this.buffer.getShort(i10));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        return (getByte(i10 + 2) & 255) | ((getByte(i10) & 255) << 16) | ((getByte(i10 + 1) & 255) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        return ((getByte(i10 + 2) & 255) << 16) | (getByte(i10) & 255) | ((getByte(i10 + 1) & 255) << 8);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setByte(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setInt(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setIntLE(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLong(int i10, long j10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setLongLE(int i10, long j10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMedium(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setMediumLE(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShort(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public void _setShortLE(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBufAllocator alloc() {
        return this.allocator;
    }

    @Override // io.netty.buffer.ByteBuf
    public byte[] array() {
        return this.buffer.array();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        return this.buffer.arrayOffset();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return maxCapacity();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        ensureAccessible();
        try {
            ByteBuffer byteBuffer = (ByteBuffer) internalNioBuffer().clear().position(i10).limit(i10 + i11);
            boolean zIsDirect = byteBuffer.isDirect();
            ByteBufAllocator byteBufAllocatorAlloc = alloc();
            ByteBuf byteBufDirectBuffer = zIsDirect ? byteBufAllocatorAlloc.directBuffer(i11) : byteBufAllocatorAlloc.heapBuffer(i11);
            byteBufDirectBuffer.writeBytes(byteBuffer);
            return byteBufDirectBuffer;
        } catch (IllegalArgumentException unused) {
            throw new IndexOutOfBoundsException("Too many bytes to read - Need " + (i10 + i11));
        }
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int ensureWritable(int i10, boolean z10) {
        return 1;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        ensureAccessible();
        return _getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (byteBuf.hasArray()) {
            getBytes(i10, byteBuf.array(), byteBuf.arrayOffset() + i11, i12);
        } else if (byteBuf.nioBufferCount() > 0) {
            ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i11, i12);
            for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
                int iRemaining = byteBuffer.remaining();
                getBytes(i10, byteBuffer);
                i10 += iRemaining;
            }
        } else {
            byteBuf.setBytes(i11, this, i10, i12);
        }
        return this;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getInt(int i10) {
        ensureAccessible();
        return _getInt(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getIntLE(int i10) {
        ensureAccessible();
        return _getIntLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLong(int i10) {
        ensureAccessible();
        return _getLong(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public long getLongLE(int i10) {
        ensureAccessible();
        return _getLongLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShort(int i10) {
        ensureAccessible();
        return _getShort(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public short getShortLE(int i10) {
        ensureAccessible();
        return _getShortLE(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMedium(int i10) {
        ensureAccessible();
        return _getUnsignedMedium(i10);
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int getUnsignedMediumLE(int i10) {
        ensureAccessible();
        return _getUnsignedMediumLE(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        return this.buffer.hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        return false;
    }

    public final ByteBuffer internalNioBuffer() {
        ByteBuffer byteBuffer = this.tmpNioBuf;
        if (byteBuffer != null) {
            return byteBuffer;
        }
        ByteBuffer byteBufferDuplicate = this.buffer.duplicate();
        this.tmpNioBuf = byteBufferDuplicate;
        return byteBufferDuplicate;
    }

    @Override // io.netty.buffer.ByteBuf
    public final boolean isContiguous() {
        return true;
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.buffer.isDirect();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isReadOnly() {
        return this.buffer.isReadOnly();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        return (ByteBuffer) this.buffer.duplicate().position(i10).limit(i10 + i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return 1;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        return new ByteBuffer[]{nioBuffer(i10, i11)};
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return ByteOrder.BIG_ENDIAN;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setByte(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setInt(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setIntLE(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLong(int i10, long j10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setLongLE(int i10, long j10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMediumLE(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShortLE(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf unwrap() {
        return null;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf capacity(int i10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf ensureWritable(int i10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable(int i10) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        ensureAccessible();
        return (ByteBuffer) internalNioBuffer().clear().position(i10).limit(i10 + i11);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) throws IOException {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) throws IOException {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10).limit(i10 + i12);
        byteBufferInternalNioBuffer.get(bArr, i11, i12);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        checkIndex(i10, byteBuffer.remaining());
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10).limit(byteBuffer.remaining() + i10);
        byteBuffer.put(byteBufferInternalNioBuffer);
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        ensureAccessible();
        if (i11 == 0) {
            return this;
        }
        if (this.buffer.hasArray()) {
            outputStream.write(this.buffer.array(), this.buffer.arrayOffset() + i10, i11);
        } else {
            byte[] bArrThreadLocalTempArray = ByteBufUtil.threadLocalTempArray(i11);
            ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
            byteBufferInternalNioBuffer.clear().position(i10);
            byteBufferInternalNioBuffer.get(bArrThreadLocalTempArray, 0, i11);
            outputStream.write(bArrThreadLocalTempArray, 0, i11);
        }
        return this;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        ensureAccessible();
        if (i11 == 0) {
            return 0;
        }
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10).limit(i10 + i11);
        return gatheringByteChannel.write(byteBufferInternalNioBuffer);
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        ensureAccessible();
        if (i11 == 0) {
            return 0;
        }
        ByteBuffer byteBufferInternalNioBuffer = internalNioBuffer();
        byteBufferInternalNioBuffer.clear().position(i10).limit(i10 + i11);
        return fileChannel.write(byteBufferInternalNioBuffer, j10);
    }
}
