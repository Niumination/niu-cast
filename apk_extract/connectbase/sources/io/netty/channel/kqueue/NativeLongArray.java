package io.netty.channel.kqueue;

import io.netty.channel.unix.Buffer;
import io.netty.channel.unix.Limits;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
final class NativeLongArray {
    private int capacity;
    private ByteBuffer memory;
    private long memoryAddress;
    private int size;

    public NativeLongArray(int i10) {
        this.capacity = ObjectUtil.checkPositive(i10, "capacity");
        ByteBuffer byteBufferAllocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i10));
        this.memory = byteBufferAllocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(byteBufferAllocateDirectWithNativeOrder);
    }

    private static int calculateBufferCapacity(int i10) {
        return i10 * Limits.SIZEOF_JLONG;
    }

    private static int idx(int i10) {
        return i10 * Limits.SIZEOF_JLONG;
    }

    private long memoryOffset(int i10) {
        return this.memoryAddress + ((long) idx(i10));
    }

    private void reallocIfNeeded() {
        int i10 = this.size;
        int i11 = this.capacity;
        if (i10 == i11) {
            int i12 = i11 <= 65536 ? i11 << 1 : (i11 + i11) >> 1;
            ByteBuffer byteBufferAllocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i12));
            this.memory.position(0).limit(this.size);
            byteBufferAllocateDirectWithNativeOrder.put(this.memory);
            byteBufferAllocateDirectWithNativeOrder.position(0);
            Buffer.free(this.memory);
            this.memory = byteBufferAllocateDirectWithNativeOrder;
            this.memoryAddress = Buffer.memoryAddress(byteBufferAllocateDirectWithNativeOrder);
            this.capacity = i12;
        }
    }

    public void add(long j10) {
        reallocIfNeeded();
        if (PlatformDependent.hasUnsafe()) {
            PlatformDependent.putLong(memoryOffset(this.size), j10);
        } else {
            this.memory.putLong(idx(this.size), j10);
        }
        this.size++;
    }

    public void clear() {
        this.size = 0;
    }

    public void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0L;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public long memoryAddress() {
        return this.memoryAddress;
    }

    public long memoryAddressEnd() {
        return memoryOffset(this.size);
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        return "memoryAddress: " + this.memoryAddress + " capacity: " + this.capacity + " size: " + this.size;
    }
}
