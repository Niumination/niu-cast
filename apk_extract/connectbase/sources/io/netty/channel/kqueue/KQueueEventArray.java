package io.netty.channel.kqueue;

import h.a;
import h.b;
import io.netty.channel.unix.Buffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class KQueueEventArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;
    private static final int KQUEUE_EVENT_SIZE = Native.sizeofKEvent();
    private static final int KQUEUE_IDENT_OFFSET = Native.offsetofKEventIdent();
    private static final int KQUEUE_FILTER_OFFSET = Native.offsetofKEventFilter();
    private static final int KQUEUE_FFLAGS_OFFSET = Native.offsetofKEventFFlags();
    private static final int KQUEUE_FLAGS_OFFSET = Native.offsetofKEventFlags();
    private static final int KQUEUE_DATA_OFFSET = Native.offsetofKeventData();

    public KQueueEventArray(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(a.a("capacity must be >= 1 but was ", i10));
        }
        ByteBuffer byteBufferAllocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i10));
        this.memory = byteBufferAllocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(byteBufferAllocateDirectWithNativeOrder);
        this.capacity = i10;
    }

    private static int calculateBufferCapacity(int i10) {
        return i10 * KQUEUE_EVENT_SIZE;
    }

    private static native void evSet(long j10, int i10, short s10, short s11, int i11);

    private static int getKEventOffset(int i10) {
        return i10 * KQUEUE_EVENT_SIZE;
    }

    private long getKEventOffsetAddress(int i10) {
        return ((long) getKEventOffset(i10)) + this.memoryAddress;
    }

    private short getShort(int i10, int i11) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.getShort(getKEventOffsetAddress(i10) + ((long) i11)) : this.memory.getShort(getKEventOffset(i10) + i11);
    }

    private void reallocIfNeeded() {
        if (this.size == this.capacity) {
            realloc(true);
        }
    }

    public int capacity() {
        return this.capacity;
    }

    public void clear() {
        this.size = 0;
    }

    public long data(int i10) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.getLong(getKEventOffsetAddress(i10) + ((long) KQUEUE_DATA_OFFSET)) : this.memory.getLong(getKEventOffset(i10) + KQUEUE_DATA_OFFSET);
    }

    public void evSet(AbstractKQueueChannel abstractKQueueChannel, short s10, short s11, int i10) {
        reallocIfNeeded();
        int i11 = this.size;
        this.size = i11 + 1;
        evSet(((long) getKEventOffset(i11)) + this.memoryAddress, abstractKQueueChannel.socket.intValue(), s10, s11, i10);
    }

    public int fd(int i10) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.getInt(getKEventOffsetAddress(i10) + ((long) KQUEUE_IDENT_OFFSET)) : this.memory.getInt(getKEventOffset(i10) + KQUEUE_IDENT_OFFSET);
    }

    public short fflags(int i10) {
        return getShort(i10, KQUEUE_FFLAGS_OFFSET);
    }

    public short filter(int i10) {
        return getShort(i10, KQUEUE_FILTER_OFFSET);
    }

    public short flags(int i10) {
        return getShort(i10, KQUEUE_FLAGS_OFFSET);
    }

    public void free() {
        Buffer.free(this.memory);
        this.capacity = 0;
        this.size = 0;
        this.memoryAddress = 0;
    }

    public long memoryAddress() {
        return this.memoryAddress;
    }

    public void realloc(boolean z10) {
        int i10 = this.capacity;
        int i11 = i10 <= 65536 ? i10 << 1 : (i10 + i10) >> 1;
        try {
            ByteBuffer byteBufferAllocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i11));
            this.memory.position(0).limit(this.size);
            byteBufferAllocateDirectWithNativeOrder.put(this.memory);
            byteBufferAllocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = byteBufferAllocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(byteBufferAllocateDirectWithNativeOrder);
        } catch (OutOfMemoryError e10) {
            if (z10) {
                StringBuilder sbA = b.a("unable to allocate ", i11, " new bytes! Existing capacity is: ");
                sbA.append(this.capacity);
                OutOfMemoryError outOfMemoryError = new OutOfMemoryError(sbA.toString());
                outOfMemoryError.initCause(e10);
                throw outOfMemoryError;
            }
        }
    }

    public int size() {
        return this.size;
    }
}
