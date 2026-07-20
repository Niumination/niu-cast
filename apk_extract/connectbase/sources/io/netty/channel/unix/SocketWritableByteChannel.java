package io.netty.channel.unix;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: loaded from: classes2.dex */
public abstract class SocketWritableByteChannel implements WritableByteChannel {

    /* JADX INFO: renamed from: fd, reason: collision with root package name */
    protected final FileDescriptor f8303fd;

    public SocketWritableByteChannel(FileDescriptor fileDescriptor) {
        this.f8303fd = (FileDescriptor) ObjectUtil.checkNotNull(fileDescriptor, "fd");
    }

    public abstract ByteBufAllocator alloc();

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f8303fd.close();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return this.f8303fd.isOpen();
    }

    public int write(ByteBuffer byteBuffer, int i10, int i11) throws IOException {
        return this.f8303fd.write(byteBuffer, i10, i11);
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer byteBuffer) throws IOException {
        int iWrite;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            iWrite = write(byteBuffer, iPosition, byteBuffer.limit());
        } else {
            int i10 = iLimit - iPosition;
            ByteBuf byteBufThreadLocalDirectBuffer = null;
            try {
                if (i10 == 0) {
                    byteBufThreadLocalDirectBuffer = Unpooled.EMPTY_BUFFER;
                } else {
                    ByteBufAllocator byteBufAllocatorAlloc = alloc();
                    if (byteBufAllocatorAlloc.isDirectBufferPooled()) {
                        byteBufThreadLocalDirectBuffer = byteBufAllocatorAlloc.directBuffer(i10);
                    } else {
                        byteBufThreadLocalDirectBuffer = ByteBufUtil.threadLocalDirectBuffer();
                        if (byteBufThreadLocalDirectBuffer == null) {
                            byteBufThreadLocalDirectBuffer = Unpooled.directBuffer(i10);
                        }
                    }
                }
                byteBufThreadLocalDirectBuffer.writeBytes(byteBuffer.duplicate());
                ByteBuffer byteBufferInternalNioBuffer = byteBufThreadLocalDirectBuffer.internalNioBuffer(byteBufThreadLocalDirectBuffer.readerIndex(), i10);
                iWrite = write(byteBufferInternalNioBuffer, byteBufferInternalNioBuffer.position(), byteBufferInternalNioBuffer.limit());
                byteBufThreadLocalDirectBuffer.release();
            } catch (Throwable th2) {
                if (byteBufThreadLocalDirectBuffer != null) {
                    byteBufThreadLocalDirectBuffer.release();
                }
                throw th2;
            }
        }
        if (iWrite > 0) {
            byteBuffer.position(iPosition + iWrite);
        }
        return iWrite;
    }
}
