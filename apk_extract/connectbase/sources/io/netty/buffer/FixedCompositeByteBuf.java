package io.netty.buffer;

import c0.b;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.RecyclableArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.util.Collections;
import k.c;
import lm.g2;
import u.a;

/* JADX INFO: loaded from: classes2.dex */
final class FixedCompositeByteBuf extends AbstractReferenceCountedByteBuf {
    private static final ByteBuf[] EMPTY = {Unpooled.EMPTY_BUFFER};
    private final ByteBufAllocator allocator;
    private final ByteBuf[] buffers;
    private final int capacity;
    private final boolean direct;
    private final int nioBufferCount;
    private final ByteOrder order;

    public static final class Component extends WrappedByteBuf {
        private final int endOffset;
        private final int index;
        private final int offset;

        public Component(int i10, int i11, ByteBuf byteBuf) {
            super(byteBuf);
            this.index = i10;
            this.offset = i11;
            this.endOffset = byteBuf.readableBytes() + i11;
        }
    }

    public FixedCompositeByteBuf(ByteBufAllocator byteBufAllocator, ByteBuf... byteBufArr) {
        super(Integer.MAX_VALUE);
        if (byteBufArr.length == 0) {
            this.buffers = EMPTY;
            this.order = ByteOrder.BIG_ENDIAN;
            this.nioBufferCount = 1;
            this.capacity = 0;
            this.direct = Unpooled.EMPTY_BUFFER.isDirect();
        } else {
            ByteBuf byteBuf = byteBufArr[0];
            this.buffers = byteBufArr;
            int iNioBufferCount = byteBuf.nioBufferCount();
            int i10 = byteBuf.readableBytes();
            this.order = byteBuf.order();
            boolean z10 = true;
            for (int i11 = 1; i11 < byteBufArr.length; i11++) {
                ByteBuf byteBuf2 = byteBufArr[i11];
                if (byteBuf2.order() != this.order) {
                    throw new IllegalArgumentException("All ByteBufs need to have same ByteOrder");
                }
                iNioBufferCount += byteBuf2.nioBufferCount();
                i10 += byteBuf2.readableBytes();
                if (!byteBuf2.isDirect()) {
                    z10 = false;
                }
            }
            this.nioBufferCount = iNioBufferCount;
            this.capacity = i10;
            this.direct = z10;
        }
        setIndex(0, capacity());
        this.allocator = byteBufAllocator;
    }

    private ByteBuf buffer(int i10) {
        ByteBuf byteBuf = this.buffers[i10];
        return byteBuf instanceof Component ? ((Component) byteBuf).buf : byteBuf;
    }

    private Component findComponent(int i10) {
        Component component;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            ByteBuf[] byteBufArr = this.buffers;
            if (i11 >= byteBufArr.length) {
                throw new IllegalStateException();
            }
            ByteBuf byteBuf = byteBufArr[i11];
            if (byteBuf instanceof Component) {
                Component component2 = (Component) byteBuf;
                component = component2;
                byteBuf = component2.buf;
            } else {
                component = null;
            }
            i12 += byteBuf.readableBytes();
            if (i10 < i12) {
                if (component != null) {
                    return component;
                }
                Component component3 = new Component(i11, i12 - byteBuf.readableBytes(), byteBuf);
                this.buffers[i11] = component3;
                return component3;
            }
            i11++;
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public byte _getByte(int i10) {
        Component componentFindComponent = findComponent(i10);
        return componentFindComponent.buf.getByte(i10 - componentFindComponent.offset);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getInt(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 4 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getInt(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getShort(i10 + 2) & g2.f10190d) | ((_getShort(i10) & g2.f10190d) << 16);
        }
        return ((_getShort(i10 + 2) & g2.f10190d) << 16) | (_getShort(i10) & g2.f10190d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getIntLE(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 4 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getIntLE(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getShortLE(i10 + 2) & g2.f10190d) << 16) | (_getShortLE(i10) & g2.f10190d);
        }
        return (_getShortLE(i10 + 2) & g2.f10190d) | ((_getShortLE(i10) & g2.f10190d) << 16);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLong(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 8 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getLong(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (((long) _getInt(i10 + 4)) & 4294967295L) | ((((long) _getInt(i10)) & 4294967295L) << 32);
        }
        return ((((long) _getInt(i10 + 4)) & 4294967295L) << 32) | (((long) _getInt(i10)) & 4294967295L);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public long _getLongLE(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 8 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getLongLE(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((((long) _getIntLE(i10 + 4)) & 4294967295L) << 32) | (((long) _getIntLE(i10)) & 4294967295L);
        }
        return (((long) _getIntLE(i10 + 4)) & 4294967295L) | ((((long) _getIntLE(i10)) & 4294967295L) << 32);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShort(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 2 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getShort(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) ((_getByte(i10 + 1) & 255) | ((_getByte(i10) & 255) << 8));
        }
        return (short) (((_getByte(i10 + 1) & 255) << 8) | (_getByte(i10) & 255));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public short _getShortLE(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 2 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getShortLE(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (short) (((_getByte(i10 + 1) & 255) << 8) | (_getByte(i10) & 255));
        }
        return (short) ((_getByte(i10 + 1) & 255) | ((_getByte(i10) & 255) << 8));
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMedium(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 3 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getUnsignedMedium(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return (_getByte(i10 + 2) & 255) | ((_getShort(i10) & g2.f10190d) << 8);
        }
        return ((_getByte(i10 + 2) & 255) << 16) | (_getShort(i10) & g2.f10190d);
    }

    @Override // io.netty.buffer.AbstractByteBuf
    public int _getUnsignedMediumLE(int i10) {
        Component componentFindComponent = findComponent(i10);
        if (i10 + 3 <= componentFindComponent.endOffset) {
            return componentFindComponent.buf.getUnsignedMediumLE(i10 - componentFindComponent.offset);
        }
        if (order() == ByteOrder.BIG_ENDIAN) {
            return ((_getByte(i10 + 2) & 255) << 16) | (_getShortLE(i10) & g2.f10190d);
        }
        return (_getByte(i10 + 2) & 255) | ((_getShortLE(i10) & g2.f10190d) << 8);
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
        int length = this.buffers.length;
        if (length == 0) {
            return EmptyArrays.EMPTY_BYTES;
        }
        if (length == 1) {
            return buffer(0).array();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int arrayOffset() {
        int length = this.buffers.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return buffer(0).arrayOffset();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int capacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf copy(int i10, int i11) {
        checkIndex(i10, i11);
        ByteBuf byteBufBuffer = alloc().buffer(i11);
        try {
            byteBufBuffer.writeBytes(this, i10, i11);
            return byteBufBuffer;
        } catch (Throwable th2) {
            byteBufBuffer.release();
            throw th2;
        }
    }

    @Override // io.netty.buffer.AbstractReferenceCountedByteBuf
    public void deallocate() {
        for (int i10 = 0; i10 < this.buffers.length; i10++) {
            buffer(i10).release();
        }
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf discardReadBytes() {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public byte getByte(int i10) {
        return _getByte(i10);
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, byte[] bArr, int i11, int i12) {
        checkDstIndex(i10, i12, i11, bArr.length);
        if (i12 == 0) {
            return this;
        }
        Component componentFindComponent = findComponent(i10);
        int i13 = componentFindComponent.index;
        int i14 = componentFindComponent.offset;
        ByteBuf byteBufBuffer = componentFindComponent.buf;
        while (true) {
            int i15 = i10 - i14;
            int iMin = Math.min(i12, byteBufBuffer.readableBytes() - i15);
            byteBufBuffer.getBytes(i15, bArr, i11, iMin);
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            i14 += byteBufBuffer.readableBytes();
            if (i12 <= 0) {
                return this;
            }
            i13++;
            byteBufBuffer = buffer(i13);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasArray() {
        int length = this.buffers.length;
        if (length == 0) {
            return true;
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasArray();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean hasMemoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.hasMemoryAddress();
        }
        if (length != 1) {
            return false;
        }
        return buffer(0).hasMemoryAddress();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer internalNioBuffer(int i10, int i11) {
        if (this.buffers.length == 1) {
            return buffer(0).internalNioBuffer(i10, i11);
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public boolean isDirect() {
        return this.direct;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public boolean isWritable() {
        return false;
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public int maxCapacity() {
        return this.capacity;
    }

    @Override // io.netty.buffer.ByteBuf
    public long memoryAddress() {
        int length = this.buffers.length;
        if (length == 0) {
            return Unpooled.EMPTY_BUFFER.memoryAddress();
        }
        if (length == 1) {
            return buffer(0).memoryAddress();
        }
        throw new UnsupportedOperationException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer nioBuffer(int i10, int i11) {
        checkIndex(i10, i11);
        if (this.buffers.length == 1) {
            ByteBuf byteBufBuffer = buffer(0);
            if (byteBufBuffer.nioBufferCount() == 1) {
                return byteBufBuffer.nioBuffer(i10, i11);
            }
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(i11).order(order());
        for (ByteBuffer byteBuffer : nioBuffers(i10, i11)) {
            byteBufferOrder.put(byteBuffer);
        }
        byteBufferOrder.flip();
        return byteBufferOrder;
    }

    @Override // io.netty.buffer.ByteBuf
    public int nioBufferCount() {
        return this.nioBufferCount;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuffer[] nioBuffers(int i10, int i11) {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return EmptyArrays.EMPTY_BYTE_BUFFERS;
        }
        RecyclableArrayList recyclableArrayListNewInstance = RecyclableArrayList.newInstance(this.buffers.length);
        try {
            Component componentFindComponent = findComponent(i10);
            int i12 = componentFindComponent.index;
            int i13 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i14 = i10 - i13;
                int iMin = Math.min(i11, byteBufBuffer.readableBytes() - i14);
                int iNioBufferCount = byteBufBuffer.nioBufferCount();
                if (iNioBufferCount == 0) {
                    throw new UnsupportedOperationException();
                }
                if (iNioBufferCount != 1) {
                    Collections.addAll(recyclableArrayListNewInstance, byteBufBuffer.nioBuffers(i14, iMin));
                } else {
                    recyclableArrayListNewInstance.add(byteBufBuffer.nioBuffer(i14, iMin));
                }
                i10 += iMin;
                i11 -= iMin;
                i13 += byteBufBuffer.readableBytes();
                if (i11 <= 0) {
                    ByteBuffer[] byteBufferArr = (ByteBuffer[]) recyclableArrayListNewInstance.toArray(EmptyArrays.EMPTY_BYTE_BUFFERS);
                    recyclableArrayListNewInstance.recycle();
                    return byteBufferArr;
                }
                i12++;
                byteBufBuffer = buffer(i12);
            }
        } catch (Throwable th2) {
            recyclableArrayListNewInstance.recycle();
            throw th2;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteOrder order() {
        return this.order;
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
    public ByteBuf setLong(int i10, long j10) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setMedium(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public ByteBuf setShort(int i10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.AbstractByteBuf, io.netty.buffer.ByteBuf
    public String toString() {
        return a.a(c.a(b.a(super.toString(), 1, 0), ", components="), this.buffers.length, ')');
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
    public boolean isWritable(int i10) {
        return false;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, byte[] bArr, int i11, int i12) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf setBytes(int i10, ByteBuffer byteBuffer) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, InputStream inputStream, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, ScatteringByteChannel scatteringByteChannel, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public int setBytes(int i10, FileChannel fileChannel, long j10, int i11) {
        throw new ReadOnlyBufferException();
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iRemaining = byteBuffer.remaining();
        checkIndex(i10, iRemaining);
        if (iRemaining == 0) {
            return this;
        }
        try {
            Component componentFindComponent = findComponent(i10);
            int i11 = componentFindComponent.index;
            int i12 = componentFindComponent.offset;
            ByteBuf byteBufBuffer = componentFindComponent.buf;
            while (true) {
                int i13 = i10 - i12;
                int iMin = Math.min(iRemaining, byteBufBuffer.readableBytes() - i13);
                byteBuffer.limit(byteBuffer.position() + iMin);
                byteBufBuffer.getBytes(i13, byteBuffer);
                i10 += iMin;
                iRemaining -= iMin;
                i12 += byteBufBuffer.readableBytes();
                if (iRemaining <= 0) {
                    byteBuffer.limit(iLimit);
                    return this;
                }
                i11++;
                byteBufBuffer = buffer(i11);
            }
        } catch (Throwable th2) {
            byteBuffer.limit(iLimit);
            throw th2;
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, ByteBuf byteBuf, int i11, int i12) {
        checkDstIndex(i10, i12, i11, byteBuf.capacity());
        if (i12 == 0) {
            return this;
        }
        Component componentFindComponent = findComponent(i10);
        int i13 = componentFindComponent.index;
        int i14 = componentFindComponent.offset;
        ByteBuf byteBufBuffer = componentFindComponent.buf;
        while (true) {
            int i15 = i10 - i14;
            int iMin = Math.min(i12, byteBufBuffer.readableBytes() - i15);
            byteBufBuffer.getBytes(i15, byteBuf, i11, iMin);
            i10 += iMin;
            i11 += iMin;
            i12 -= iMin;
            i14 += byteBufBuffer.readableBytes();
            if (i12 <= 0) {
                return this;
            }
            i13++;
            byteBufBuffer = buffer(i13);
        }
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, GatheringByteChannel gatheringByteChannel, int i11) throws IOException {
        if (nioBufferCount() == 1) {
            return gatheringByteChannel.write(internalNioBuffer(i10, i11));
        }
        long jWrite = gatheringByteChannel.write(nioBuffers(i10, i11));
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public int getBytes(int i10, FileChannel fileChannel, long j10, int i11) throws IOException {
        if (nioBufferCount() == 1) {
            return fileChannel.write(internalNioBuffer(i10, i11), j10);
        }
        ByteBuffer[] byteBufferArrNioBuffers = nioBuffers(i10, i11);
        long jWrite = 0;
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            jWrite += (long) fileChannel.write(byteBuffer, j10 + jWrite);
        }
        if (jWrite > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) jWrite;
    }

    @Override // io.netty.buffer.ByteBuf
    public ByteBuf getBytes(int i10, OutputStream outputStream, int i11) throws IOException {
        checkIndex(i10, i11);
        if (i11 == 0) {
            return this;
        }
        Component componentFindComponent = findComponent(i10);
        int i12 = componentFindComponent.index;
        int i13 = componentFindComponent.offset;
        ByteBuf byteBufBuffer = componentFindComponent.buf;
        while (true) {
            int i14 = i10 - i13;
            int iMin = Math.min(i11, byteBufBuffer.readableBytes() - i14);
            byteBufBuffer.getBytes(i14, outputStream, iMin);
            i10 += iMin;
            i11 -= iMin;
            i13 += byteBufBuffer.readableBytes();
            if (i11 <= 0) {
                return this;
            }
            i12++;
            byteBufBuffer = buffer(i12);
        }
    }
}
