package io.netty.channel.epoll;

import h.a;
import io.netty.channel.unix.Buffer;
import io.netty.util.internal.PlatformDependent;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class EpollEventArray {
    private int length;
    private ByteBuffer memory;
    private long memoryAddress;
    private static final int EPOLL_EVENT_SIZE = Native.sizeofEpollEvent();
    private static final int EPOLL_DATA_OFFSET = Native.offsetofEpollData();

    public EpollEventArray(int i10) {
        if (i10 < 1) {
            throw new IllegalArgumentException(a.a("length must be >= 1 but was ", i10));
        }
        this.length = i10;
        ByteBuffer byteBufferAllocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i10));
        this.memory = byteBufferAllocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(byteBufferAllocateDirectWithNativeOrder);
    }

    private static int calculateBufferCapacity(int i10) {
        return i10 * EPOLL_EVENT_SIZE;
    }

    private int getInt(int i10, int i11) {
        if (!PlatformDependent.hasUnsafe()) {
            return this.memory.getInt((i10 * EPOLL_EVENT_SIZE) + i11);
        }
        return PlatformDependent.getInt(this.memoryAddress + (((long) i10) * ((long) EPOLL_EVENT_SIZE)) + ((long) i11));
    }

    public int events(int i10) {
        return getInt(i10, 0);
    }

    public int fd(int i10) {
        return getInt(i10, EPOLL_DATA_OFFSET);
    }

    public void free() {
        Buffer.free(this.memory);
        this.memoryAddress = 0L;
    }

    public void increase() {
        int i10 = this.length << 1;
        this.length = i10;
        ByteBuffer byteBufferAllocateDirectWithNativeOrder = Buffer.allocateDirectWithNativeOrder(calculateBufferCapacity(i10));
        Buffer.free(this.memory);
        this.memory = byteBufferAllocateDirectWithNativeOrder;
        this.memoryAddress = Buffer.memoryAddress(byteBufferAllocateDirectWithNativeOrder);
    }

    public int length() {
        return this.length;
    }

    public long memoryAddress() {
        return this.memoryAddress;
    }
}
