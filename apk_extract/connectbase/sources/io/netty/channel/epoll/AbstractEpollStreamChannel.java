package io.netty.channel.epoll;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.AbstractChannel;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultFileRegion;
import io.netty.channel.EventLoop;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.FileDescriptor;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.Queue;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractEpollStreamChannel extends AbstractEpollChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    private FileDescriptor pipeIn;
    private FileDescriptor pipeOut;
    private volatile Queue<SpliceInTask> spliceQueue;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractEpollStreamChannel.class);

    public final class EpollSocketWritableByteChannel extends SocketWritableByteChannel {
        public EpollSocketWritableByteChannel() {
            super(AbstractEpollStreamChannel.this.socket);
        }

        @Override // io.netty.channel.unix.SocketWritableByteChannel
        public ByteBufAllocator alloc() {
            return AbstractEpollStreamChannel.this.alloc();
        }
    }

    public class EpollStreamUnsafe extends AbstractEpollChannel.AbstractEpollUnsafe {
        public EpollStreamUnsafe() {
            super();
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th2, boolean z10, EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            epollRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th2);
            if (z10 || (th2 instanceof OutOfMemoryError) || (th2 instanceof IOException)) {
                shutdownInput(false);
            }
        }

        /* JADX WARN: Code duplicated, block: B:17:0x004d A[Catch: all -> 0x003f, TryCatch #3 {all -> 0x003f, blocks: (B:9:0x0036, B:23:0x0061, B:27:0x0078, B:39:0x0095, B:42:0x009e, B:15:0x0045, B:17:0x004d, B:19:0x0053, B:21:0x005b), top: B:62:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:19:0x0053 A[Catch: all -> 0x003f, TryCatch #3 {all -> 0x003f, blocks: (B:9:0x0036, B:23:0x0061, B:27:0x0078, B:39:0x0095, B:42:0x009e, B:15:0x0045, B:17:0x004d, B:19:0x0053, B:21:0x005b), top: B:62:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:21:0x005b A[Catch: all -> 0x003f, TryCatch #3 {all -> 0x003f, blocks: (B:9:0x0036, B:23:0x0061, B:27:0x0078, B:39:0x0095, B:42:0x009e, B:15:0x0045, B:17:0x004d, B:19:0x0053, B:21:0x005b), top: B:62:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:30:0x007f  */
        /* JADX WARN: Code duplicated, block: B:38:0x008d A[Catch: all -> 0x008a, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x008a, blocks: (B:24:0x0065, B:26:0x0075, B:38:0x008d), top: B:60:0x0065 }] */
        /* JADX WARN: Code duplicated, block: B:42:0x009e A[Catch: all -> 0x003f, PHI: r4
          0x009e: PHI (r4v10 java.util.Queue) = (r4v6 java.util.Queue), (r4v11 java.util.Queue), (r4v11 java.util.Queue) binds: [B:40:0x009b, B:20:0x0059, B:21:0x005b] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {all -> 0x003f, blocks: (B:9:0x0036, B:23:0x0061, B:27:0x0078, B:39:0x0095, B:42:0x009e, B:15:0x0045, B:17:0x004d, B:19:0x0053, B:21:0x005b), top: B:62:0x0036 }] */
        /* JADX WARN: Code duplicated, block: B:56:0x0082 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:64:0x009d A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:65:0x005f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:66:0x005f A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:67:0x0075 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:68:? A[LOOP:0: B:7:0x0033->B:68:?, LOOP_END, SYNTHETIC] */
        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public void epollInReady() {
            ByteBuf byteBuf;
            Throwable th2;
            boolean z10;
            Throwable th3;
            ByteBuf byteBufAllocate;
            boolean z11;
            SpliceInTask spliceInTask;
            EpollChannelConfig epollChannelConfigConfig = AbstractEpollStreamChannel.this.config();
            if (AbstractEpollStreamChannel.this.shouldBreakEpollInReady(epollChannelConfigConfig)) {
                clearEpollIn0();
                return;
            }
            EpollRecvByteAllocatorHandle epollRecvByteAllocatorHandleRecvBufAllocHandle = recvBufAllocHandle();
            epollRecvByteAllocatorHandleRecvBufAllocHandle.edgeTriggered(AbstractEpollStreamChannel.this.isFlagSet(Native.EPOLLET));
            ChannelPipeline channelPipelinePipeline = AbstractEpollStreamChannel.this.pipeline();
            ByteBufAllocator allocator = epollChannelConfigConfig.getAllocator();
            epollRecvByteAllocatorHandleRecvBufAllocHandle.reset(epollChannelConfigConfig);
            epollInBefore();
            Queue queue = null;
            while (true) {
                if (queue != null) {
                    spliceInTask = (SpliceInTask) queue.peek();
                    if (spliceInTask == null) {
                        byteBufAllocate = epollRecvByteAllocatorHandleRecvBufAllocHandle.allocate(allocator);
                        epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(AbstractEpollStreamChannel.this.doReadBytes(byteBufAllocate));
                        if (epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead() <= 0) {
                            epollRecvByteAllocatorHandleRecvBufAllocHandle.incMessagesRead(1);
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                            if (AbstractEpollStreamChannel.this.shouldBreakEpollInReady(epollChannelConfigConfig)) {
                                if (!epollRecvByteAllocatorHandleRecvBufAllocHandle.continueReading()) {
                                }
                            }
                            z11 = false;
                            break;
                        }
                        byteBufAllocate.release();
                        if (epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead() < 0) {
                        }
                        if (z11) {
                            this.readPending = false;
                            break;
                        }
                    } else {
                        if (!spliceInTask.spliceIn(epollRecvByteAllocatorHandleRecvBufAllocHandle)) {
                            if (AbstractEpollStreamChannel.this.isActive()) {
                                queue.remove();
                            }
                            if (!epollRecvByteAllocatorHandleRecvBufAllocHandle.continueReading()) {
                            }
                        }
                        z11 = false;
                        break;
                    }
                } else {
                    try {
                        queue = AbstractEpollStreamChannel.this.spliceQueue;
                        try {
                            if (queue != null) {
                                spliceInTask = (SpliceInTask) queue.peek();
                                if (spliceInTask == null) {
                                    if (!spliceInTask.spliceIn(epollRecvByteAllocatorHandleRecvBufAllocHandle)) {
                                        if (AbstractEpollStreamChannel.this.isActive()) {
                                            queue.remove();
                                        }
                                        if (!epollRecvByteAllocatorHandleRecvBufAllocHandle.continueReading()) {
                                        }
                                    }
                                    z11 = false;
                                    break;
                                }
                            }
                            epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead(AbstractEpollStreamChannel.this.doReadBytes(byteBufAllocate));
                            if (epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead() <= 0) {
                                epollRecvByteAllocatorHandleRecvBufAllocHandle.incMessagesRead(1);
                                this.readPending = false;
                                channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                                if (AbstractEpollStreamChannel.this.shouldBreakEpollInReady(epollChannelConfigConfig)) {
                                    if (!epollRecvByteAllocatorHandleRecvBufAllocHandle.continueReading()) {
                                    }
                                }
                                z11 = false;
                                break;
                            }
                            byteBufAllocate.release();
                            z11 = epollRecvByteAllocatorHandleRecvBufAllocHandle.lastBytesRead() < 0;
                            if (z11) {
                                try {
                                    this.readPending = false;
                                    break;
                                } catch (Throwable th4) {
                                    th3 = th4;
                                    byteBuf = null;
                                    z10 = z11;
                                    try {
                                        handleReadException(channelPipelinePipeline, byteBuf, th3, z10, epollRecvByteAllocatorHandleRecvBufAllocHandle);
                                    } finally {
                                        epollInFinally(epollChannelConfigConfig);
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            byteBuf = byteBufAllocate;
                            z10 = false;
                            th3 = th2;
                            handleReadException(channelPipelinePipeline, byteBuf, th3, z10, epollRecvByteAllocatorHandleRecvBufAllocHandle);
                        }
                        byteBufAllocate = epollRecvByteAllocatorHandleRecvBufAllocHandle.allocate(allocator);
                    } catch (Throwable th6) {
                        th2 = th6;
                        byteBuf = null;
                        z10 = false;
                        th3 = th2;
                        handleReadException(channelPipelinePipeline, byteBuf, th3, z10, epollRecvByteAllocatorHandleRecvBufAllocHandle);
                    }
                }
            }
            epollRecvByteAllocatorHandleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (z11) {
                shutdownInput(false);
            }
        }

        @Override // io.netty.channel.epoll.AbstractEpollChannel.AbstractEpollUnsafe
        public EpollRecvByteAllocatorHandle newEpollHandle(RecvByteBufAllocator.ExtendedHandle extendedHandle) {
            return new EpollRecvByteAllocatorStreamingHandle(extendedHandle);
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public Executor prepareToClose() {
            return super.prepareToClose();
        }
    }

    public final class SpliceFdTask extends SpliceInTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX INFO: renamed from: fd, reason: collision with root package name */
        private final FileDescriptor f8293fd;
        private int offset;
        private final ChannelPromise promise;

        public SpliceFdTask(FileDescriptor fileDescriptor, int i10, int i11, ChannelPromise channelPromise) {
            super(i11, channelPromise);
            this.f8293fd = fileDescriptor;
            this.promise = channelPromise;
            this.offset = i10;
        }

        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor[] fileDescriptorArrPipe = FileDescriptor.pipe();
                FileDescriptor fileDescriptor = fileDescriptorArrPipe[0];
                FileDescriptor fileDescriptor2 = fileDescriptorArrPipe[1];
                try {
                    int iSpliceIn = spliceIn(fileDescriptor2, handle);
                    if (iSpliceIn > 0) {
                        int i10 = this.len;
                        if (i10 != Integer.MAX_VALUE) {
                            this.len = i10 - iSpliceIn;
                        }
                        do {
                            int iSplice = Native.splice(fileDescriptor.intValue(), -1L, this.f8293fd.intValue(), this.offset, iSpliceIn);
                            this.offset += iSplice;
                            iSpliceIn -= iSplice;
                        } while (iSpliceIn > 0);
                        if (this.len == 0) {
                            this.promise.setSuccess();
                            return true;
                        }
                    }
                    return false;
                } finally {
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor);
                    AbstractEpollStreamChannel.safeClosePipe(fileDescriptor2);
                }
            } catch (Throwable th2) {
                this.promise.setFailure(th2);
                return true;
            }
        }
    }

    public final class SpliceInChannelTask extends SpliceInTask implements ChannelFutureListener {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* JADX INFO: renamed from: ch, reason: collision with root package name */
        private final AbstractEpollStreamChannel f8294ch;

        public SpliceInChannelTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i10, ChannelPromise channelPromise) {
            super(i10, channelPromise);
            this.f8294ch = abstractEpollStreamChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15 */
        /* JADX WARN: Type inference failed for: r0v16 */
        /* JADX WARN: Type inference failed for: r0v9, types: [io.netty.channel.ChannelPromise, java.util.concurrent.Future] */
        /* JADX WARN: Type inference failed for: r4v1, types: [io.netty.channel.Channel$Unsafe] */
        @Override // io.netty.channel.epoll.AbstractEpollStreamChannel.SpliceInTask
        public boolean spliceIn(RecvByteBufAllocator.Handle handle) {
            if (this.len == 0) {
                this.promise.setSuccess();
                return true;
            }
            try {
                FileDescriptor fileDescriptor = this.f8294ch.pipeOut;
                if (fileDescriptor == null) {
                    FileDescriptor[] fileDescriptorArrPipe = FileDescriptor.pipe();
                    this.f8294ch.pipeIn = fileDescriptorArrPipe[0];
                    fileDescriptor = this.f8294ch.pipeOut = fileDescriptorArrPipe[1];
                }
                int iSpliceIn = spliceIn(fileDescriptor, handle);
                if (iSpliceIn > 0) {
                    int i10 = this.len;
                    if (i10 != Integer.MAX_VALUE) {
                        this.len = i10 - iSpliceIn;
                    }
                    ?? AddListener = this.len == 0 ? this.promise : this.f8294ch.newPromise().addListener((GenericFutureListener<? extends Future<? super Void>>) this);
                    boolean zIsAutoRead = AbstractEpollStreamChannel.this.config().isAutoRead();
                    this.f8294ch.unsafe().write(AbstractEpollStreamChannel.this.new SpliceOutTask(this.f8294ch, iSpliceIn, zIsAutoRead), AddListener);
                    this.f8294ch.unsafe().flush();
                    if (zIsAutoRead && !AddListener.isDone()) {
                        AbstractEpollStreamChannel.this.config().setAutoRead(false);
                    }
                }
                return this.len == 0;
            } catch (Throwable th2) {
                this.promise.setFailure(th2);
                return true;
            }
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(ChannelFuture channelFuture) throws Exception {
            if (channelFuture.isSuccess()) {
                return;
            }
            this.promise.setFailure(channelFuture.cause());
        }
    }

    public abstract class SpliceInTask {
        int len;
        final ChannelPromise promise;

        public SpliceInTask(int i10, ChannelPromise channelPromise) {
            this.promise = channelPromise;
            this.len = i10;
        }

        public final int spliceIn(FileDescriptor fileDescriptor, RecvByteBufAllocator.Handle handle) throws IOException {
            int iMin = Math.min(handle.guess(), this.len);
            int i10 = 0;
            while (true) {
                int iSplice = Native.splice(AbstractEpollStreamChannel.this.socket.intValue(), -1L, fileDescriptor.intValue(), -1L, iMin);
                if (iSplice == 0) {
                    return i10;
                }
                i10 += iSplice;
                iMin -= iSplice;
            }
        }

        public abstract boolean spliceIn(RecvByteBufAllocator.Handle handle);
    }

    public final class SpliceOutTask {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final boolean autoRead;

        /* JADX INFO: renamed from: ch, reason: collision with root package name */
        private final AbstractEpollStreamChannel f8295ch;
        private int len;

        public SpliceOutTask(AbstractEpollStreamChannel abstractEpollStreamChannel, int i10, boolean z10) {
            this.f8295ch = abstractEpollStreamChannel;
            this.len = i10;
            this.autoRead = z10;
        }

        public boolean spliceOut() throws Exception {
            try {
                int iSplice = this.len - Native.splice(this.f8295ch.pipeIn.intValue(), -1L, this.f8295ch.socket.intValue(), -1L, this.len);
                this.len = iSplice;
                if (iSplice != 0) {
                    return false;
                }
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                return true;
            } catch (IOException e10) {
                if (this.autoRead) {
                    AbstractEpollStreamChannel.this.config().setAutoRead(true);
                }
                throw e10;
            }
        }
    }

    public AbstractEpollStreamChannel(Channel channel, int i10) {
        this(channel, new LinuxSocket(i10));
    }

    private void addToSpliceQueue(SpliceInTask spliceInTask) {
        Queue<SpliceInTask> queueNewMpscQueue = this.spliceQueue;
        if (queueNewMpscQueue == null) {
            synchronized (this) {
                try {
                    queueNewMpscQueue = this.spliceQueue;
                    if (queueNewMpscQueue == null) {
                        queueNewMpscQueue = PlatformDependent.newMpscQueue();
                        this.spliceQueue = queueNewMpscQueue;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        queueNewMpscQueue.add(spliceInTask);
    }

    private void adjustMaxBytesPerGatheringWrite(long j10, long j11, long j12) {
        if (j10 == j11) {
            long j13 = j10 << 1;
            if (j13 > j12) {
                config().setMaxBytesPerGatheringWrite(j13);
                return;
            }
            return;
        }
        if (j10 > 4096) {
            long j14 = j10 >>> 1;
            if (j11 < j14) {
                config().setMaxBytesPerGatheringWrite(j14);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSpliceQueue() {
        Queue<SpliceInTask> queue = this.spliceQueue;
        if (queue == null) {
            return;
        }
        ClosedChannelException closedChannelException = null;
        while (true) {
            SpliceInTask spliceInTaskPoll = queue.poll();
            if (spliceInTaskPoll == null) {
                return;
            }
            if (closedChannelException == null) {
                closedChannelException = new ClosedChannelException();
            }
            spliceInTaskPoll.promise.tryFailure(closedChannelException);
        }
    }

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray iovArrayCleanIovArray = ((EpollEventLoop) eventLoop()).cleanIovArray();
        iovArrayCleanIovArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(iovArrayCleanIovArray);
        if (iovArrayCleanIovArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, iovArrayCleanIovArray);
        }
        channelOutboundBuffer.removeBytes(0L);
        return 0;
    }

    private void failSpliceIfClosed(ChannelPromise channelPromise) {
        if (isOpen() || !channelPromise.tryFailure(new ClosedChannelException())) {
            return;
        }
        eventLoop().execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.2
            @Override // java.lang.Runnable
            public void run() {
                AbstractEpollStreamChannel.this.clearSpliceQueue();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void safeClosePipe(FileDescriptor fileDescriptor) {
        if (fileDescriptor != null) {
            try {
                fileDescriptor.close();
            } catch (IOException e10) {
                logger.warn("Error while closing a pipe", (Throwable) e10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void shutdownDone(ChannelFuture channelFuture, ChannelFuture channelFuture2, ChannelPromise channelPromise) {
        Throwable thCause = channelFuture.cause();
        Throwable thCause2 = channelFuture2.cause();
        if (thCause != null) {
            if (thCause2 != null) {
                logger.debug("Exception suppressed because a previous exception occurred.", thCause2);
            }
            channelPromise.setFailure(thCause);
        } else if (thCause2 != null) {
            channelPromise.setFailure(thCause2);
        } else {
            channelPromise.setSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownInput0(ChannelPromise channelPromise) {
        try {
            this.socket.shutdown(true, false);
            channelPromise.setSuccess();
        } catch (Throwable th2) {
            channelPromise.setFailure(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void shutdownOutputDone(final ChannelFuture channelFuture, final ChannelPromise channelPromise) {
        ChannelFuture channelFutureShutdownInput = shutdownInput();
        if (channelFutureShutdownInput.isDone()) {
            shutdownDone(channelFuture, channelFutureShutdownInput, channelPromise);
        } else {
            channelFutureShutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.7
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractEpollStreamChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
                }
            });
        }
    }

    private int writeBytes(ChannelOutboundBuffer channelOutboundBuffer, ByteBuf byteBuf) throws Exception {
        int i10 = byteBuf.readableBytes();
        if (i10 == 0) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (byteBuf.hasMemoryAddress() || byteBuf.nioBufferCount() == 1) {
            return doWriteBytes(channelOutboundBuffer, byteBuf);
        }
        ByteBuffer[] byteBufferArrNioBuffers = byteBuf.nioBuffers();
        return writeBytesMultiple(channelOutboundBuffer, byteBufferArrNioBuffers, byteBufferArrNioBuffers.length, i10, config().getMaxBytesPerGatheringWrite());
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, IovArray iovArray) throws IOException {
        long size = iovArray.size();
        long jWritevAddresses = this.socket.writevAddresses(iovArray.memoryAddress(0), iovArray.count());
        if (jWritevAddresses <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(size, jWritevAddresses, iovArray.maxBytes());
        channelOutboundBuffer.removeBytes(jWritevAddresses);
        return 1;
    }

    private int writeDefaultFileRegion(ChannelOutboundBuffer channelOutboundBuffer, DefaultFileRegion defaultFileRegion) throws Exception {
        long jTransferred = defaultFileRegion.transferred();
        long jCount = defaultFileRegion.count();
        if (jTransferred >= jCount) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long jSendFile = this.socket.sendFile(defaultFileRegion, defaultFileRegion.position(), jTransferred, jCount - jTransferred);
        if (jSendFile <= 0) {
            if (jSendFile != 0) {
                return Integer.MAX_VALUE;
            }
            validateFileRegion(defaultFileRegion, jTransferred);
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(jSendFile);
        if (defaultFileRegion.transferred() < jCount) {
            return 1;
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    private int writeFileRegion(ChannelOutboundBuffer channelOutboundBuffer, FileRegion fileRegion) throws Exception {
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        if (this.byteChannel == null) {
            this.byteChannel = new EpollSocketWritableByteChannel();
        }
        long jTransferTo = fileRegion.transferTo(this.byteChannel, fileRegion.transferred());
        if (jTransferTo <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(jTransferTo);
        if (fileRegion.transferred() < fileRegion.count()) {
            return 1;
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public void doClose() throws Exception {
        try {
            super.doClose();
        } finally {
            safeClosePipe(this.pipeIn);
            safeClosePipe(this.pipeOut);
            clearSpliceQueue();
        }
    }

    @Override // io.netty.channel.AbstractChannel
    public final void doShutdownOutput() throws Exception {
        this.socket.shutdown(false, true);
    }

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int iDoWriteSingle;
        int writeSpinCount = config().getWriteSpinCount();
        do {
            int size = channelOutboundBuffer.size();
            if (size > 1 && (channelOutboundBuffer.current() instanceof ByteBuf)) {
                iDoWriteSingle = doWriteMultiple(channelOutboundBuffer);
            } else {
                if (size == 0) {
                    clearFlag(Native.EPOLLOUT);
                    return;
                }
                iDoWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= iDoWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount != 0) {
            setFlag(Native.EPOLLOUT);
        } else {
            clearFlag(Native.EPOLLOUT);
            eventLoop().execute(this.flushTask);
        }
    }

    public int doWriteSingle(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        Object objCurrent = channelOutboundBuffer.current();
        if (objCurrent instanceof ByteBuf) {
            return writeBytes(channelOutboundBuffer, (ByteBuf) objCurrent);
        }
        if (objCurrent instanceof DefaultFileRegion) {
            return writeDefaultFileRegion(channelOutboundBuffer, (DefaultFileRegion) objCurrent);
        }
        if (objCurrent instanceof FileRegion) {
            return writeFileRegion(channelOutboundBuffer, (FileRegion) objCurrent);
        }
        if (!(objCurrent instanceof SpliceOutTask)) {
            throw new Error();
        }
        if (!((SpliceOutTask) objCurrent).spliceOut()) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.remove();
        return 1;
    }

    @Override // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if ((obj instanceof FileRegion) || (obj instanceof SpliceOutTask)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isOpen() {
        return super.isOpen();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isOutputShutdown() {
        return this.socket.isOutputShutdown();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isShutdown() {
        return this.socket.isShutdown();
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown() {
        return shutdown(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput() {
        return shutdownInput(newPromise());
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput() {
        return shutdownOutput(newPromise());
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i10) {
        return spliceTo(abstractEpollStreamChannel, i10, newPromise());
    }

    public AbstractEpollStreamChannel(int i10) {
        this(new LinuxSocket(i10));
    }

    @Override // io.netty.channel.epoll.AbstractEpollChannel, io.netty.channel.AbstractChannel
    public AbstractEpollChannel.AbstractEpollUnsafe newUnsafe() {
        return new EpollStreamUnsafe();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture channelFutureShutdownOutput = shutdownOutput();
        if (channelFutureShutdownOutput.isDone()) {
            shutdownOutputDone(channelFutureShutdownOutput, channelPromise);
        } else {
            channelFutureShutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.6
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractEpollStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        Executor executorPrepareToClose = ((EpollStreamUnsafe) unsafe()).prepareToClose();
        if (executorPrepareToClose != null) {
            executorPrepareToClose.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.4
                @Override // java.lang.Runnable
                public void run() {
                    AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
        } else {
            EventLoop eventLoop = eventLoop();
            if (eventLoop.inEventLoop()) {
                shutdownInput0(channelPromise);
            } else {
                eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AbstractEpollStreamChannel.this.shutdownInput0(channelPromise);
                    }
                });
            }
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractEpollStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public final ChannelFuture spliceTo(AbstractEpollStreamChannel abstractEpollStreamChannel, int i10, ChannelPromise channelPromise) {
        if (abstractEpollStreamChannel.eventLoop() != eventLoop()) {
            throw new IllegalArgumentException("EventLoops are not the same.");
        }
        ObjectUtil.checkPositiveOrZero(i10, "len");
        EpollMode epollMode = abstractEpollStreamChannel.config().getEpollMode();
        EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
        if (epollMode != epollMode2 || config().getEpollMode() != epollMode2) {
            throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
        }
        ObjectUtil.checkNotNull(channelPromise, "promise");
        if (isOpen()) {
            addToSpliceQueue(new SpliceInChannelTask(abstractEpollStreamChannel, i10, channelPromise));
            failSpliceIfClosed(channelPromise);
        } else {
            channelPromise.tryFailure(new ClosedChannelException());
        }
        return channelPromise;
    }

    public AbstractEpollStreamChannel(LinuxSocket linuxSocket) {
        this(linuxSocket, AbstractEpollChannel.isSoErrorZero(linuxSocket));
    }

    public AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket) {
        super(channel, linuxSocket, true);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    private int writeBytesMultiple(ChannelOutboundBuffer channelOutboundBuffer, ByteBuffer[] byteBufferArr, int i10, long j10, long j11) throws IOException {
        if (j10 > j11) {
            j10 = j11;
        }
        long jWritev = this.socket.writev(byteBufferArr, 0, i10, j10);
        if (jWritev <= 0) {
            return Integer.MAX_VALUE;
        }
        adjustMaxBytesPerGatheringWrite(j10, jWritev, j11);
        channelOutboundBuffer.removeBytes(jWritev);
        return 1;
    }

    public AbstractEpollStreamChannel(Channel channel, LinuxSocket linuxSocket, SocketAddress socketAddress) {
        super(channel, linuxSocket, socketAddress);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    public AbstractEpollStreamChannel(LinuxSocket linuxSocket, boolean z10) {
        super((Channel) null, linuxSocket, z10);
        this.flushTask = new Runnable() { // from class: io.netty.channel.epoll.AbstractEpollStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractEpollChannel.AbstractEpollUnsafe) AbstractEpollStreamChannel.this.unsafe()).flush0();
            }
        };
        this.flags |= Native.EPOLLRDHUP;
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i10, int i11) {
        return spliceTo(fileDescriptor, i10, i11, newPromise());
    }

    public final ChannelFuture spliceTo(FileDescriptor fileDescriptor, int i10, int i11, ChannelPromise channelPromise) {
        ObjectUtil.checkPositiveOrZero(i11, "len");
        ObjectUtil.checkPositiveOrZero(i10, TypedValues.CycleType.S_WAVE_OFFSET);
        EpollMode epollMode = config().getEpollMode();
        EpollMode epollMode2 = EpollMode.LEVEL_TRIGGERED;
        if (epollMode == epollMode2) {
            ObjectUtil.checkNotNull(channelPromise, "promise");
            if (!isOpen()) {
                channelPromise.tryFailure(new ClosedChannelException());
            } else {
                addToSpliceQueue(new SpliceFdTask(fileDescriptor, i10, i11, channelPromise));
                failSpliceIfClosed(channelPromise);
            }
            return channelPromise;
        }
        throw new IllegalStateException("spliceTo() supported only when using " + epollMode2);
    }
}
