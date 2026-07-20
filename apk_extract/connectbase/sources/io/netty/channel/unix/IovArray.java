package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public final class IovArray implements ChannelOutboundBuffer.MessageProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ADDRESS_SIZE;
    public static final int IOV_SIZE;
    private static final int MAX_CAPACITY;
    private int count;
    private long maxBytes;
    private final ByteBuf memory;
    private final long memoryAddress;
    private long size;

    static {
        int iAddressSize = Buffer.addressSize();
        ADDRESS_SIZE = iAddressSize;
        int i10 = iAddressSize * 2;
        IOV_SIZE = i10;
        MAX_CAPACITY = Limits.IOV_MAX * i10;
    }

    public IovArray() {
        this(Unpooled.wrappedBuffer(Buffer.allocateDirectWithNativeOrder(MAX_CAPACITY)).setIndex(0, 0));
    }

    private static int idx(int i10) {
        return IOV_SIZE * i10;
    }

    @Deprecated
    public boolean add(ByteBuf byteBuf) {
        return add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public void clear() {
        this.count = 0;
        this.size = 0L;
    }

    public int count() {
        return this.count;
    }

    public void maxBytes(long j10) {
        this.maxBytes = Math.min(Limits.SSIZE_MAX, ObjectUtil.checkPositive(j10, "maxBytes"));
    }

    public long memoryAddress(int i10) {
        return this.memoryAddress + ((long) idx(i10));
    }

    @Override // io.netty.channel.ChannelOutboundBuffer.MessageProcessor
    public boolean processMessage(Object obj) throws Exception {
        if (!(obj instanceof ByteBuf)) {
            return false;
        }
        ByteBuf byteBuf = (ByteBuf) obj;
        return add(byteBuf, byteBuf.readerIndex(), byteBuf.readableBytes());
    }

    public void release() {
        this.memory.release();
    }

    public long size() {
        return this.size;
    }

    public IovArray(ByteBuf byteBuf) {
        ByteBuf byteBufOrder;
        this.maxBytes = Limits.SSIZE_MAX;
        if (PlatformDependent.hasUnsafe()) {
            byteBufOrder = byteBuf;
        } else {
            byteBufOrder = byteBuf.order(PlatformDependent.BIG_ENDIAN_NATIVE_ORDER ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        }
        this.memory = byteBufOrder;
        if (byteBuf.hasMemoryAddress()) {
            this.memoryAddress = byteBuf.memoryAddress();
        } else {
            this.memoryAddress = Buffer.memoryAddress(byteBuf.internalNioBuffer(0, byteBuf.capacity()));
        }
    }

    public boolean add(ByteBuf byteBuf, int i10, int i11) {
        if (this.count == Limits.IOV_MAX) {
            return false;
        }
        if (byteBuf.nioBufferCount() == 1) {
            if (i11 == 0) {
                return true;
            }
            if (byteBuf.hasMemoryAddress()) {
                return add(this.memoryAddress, byteBuf.memoryAddress() + ((long) i10), i11);
            }
            ByteBuffer byteBufferInternalNioBuffer = byteBuf.internalNioBuffer(i10, i11);
            return add(this.memoryAddress, Buffer.memoryAddress(byteBufferInternalNioBuffer) + ((long) byteBufferInternalNioBuffer.position()), i11);
        }
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers(i10, i11);
        for (ByteBuffer byteBuffer : byteBufferArrNioBuffers) {
            int iRemaining = byteBuffer.remaining();
            if (iRemaining != 0 && (!add(this.memoryAddress, Buffer.memoryAddress(byteBuffer) + ((long) byteBuffer.position()), iRemaining) || this.count == Limits.IOV_MAX)) {
                return false;
            }
        }
        return true;
    }

    public long maxBytes() {
        return this.maxBytes;
    }

    private boolean add(long j10, long j11, int i10) {
        long j12 = i10;
        if (this.maxBytes - j12 < this.size && this.count > 0) {
            return false;
        }
        int iCapacity = this.memory.capacity();
        int i11 = this.count;
        if (iCapacity < (i11 + 1) * IOV_SIZE) {
            return false;
        }
        int iIdx = idx(i11);
        int i12 = ADDRESS_SIZE;
        int i13 = iIdx + i12;
        this.size += j12;
        this.count++;
        if (i12 == 8) {
            if (PlatformDependent.hasUnsafe()) {
                PlatformDependent.putLong(((long) iIdx) + j10, j11);
                PlatformDependent.putLong(((long) i13) + j10, j12);
            } else {
                this.memory.setLong(iIdx, j11);
                this.memory.setLong(i13, j12);
            }
        } else if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putInt(((long) iIdx) + j10, (int) j11);
            PlatformDependent.putInt(((long) i13) + j10, i10);
        } else {
            this.memory.setInt(iIdx, (int) j11);
            this.memory.setInt(i13, i10);
        }
        return true;
    }
}
