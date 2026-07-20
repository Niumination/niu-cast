package io.netty.channel.kqueue;

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
import io.netty.channel.socket.DuplexChannel;
import io.netty.channel.unix.IovArray;
import io.netty.channel.unix.SocketWritableByteChannel;
import io.netty.channel.unix.UnixChannelUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.IOException;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractKQueueStreamChannel extends AbstractKQueueChannel implements DuplexChannel {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private WritableByteChannel byteChannel;
    private final Runnable flushTask;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) AbstractKQueueStreamChannel.class);
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) DefaultFileRegion.class) + ')';

    public final class KQueueSocketWritableByteChannel extends SocketWritableByteChannel {
        public KQueueSocketWritableByteChannel() {
            super(AbstractKQueueStreamChannel.this.socket);
        }

        @Override // io.netty.channel.unix.SocketWritableByteChannel
        public ByteBufAllocator alloc() {
            return AbstractKQueueStreamChannel.this.alloc();
        }
    }

    public class KQueueStreamUnsafe extends AbstractKQueueChannel.AbstractKQueueUnsafe {
        public KQueueStreamUnsafe() {
            super();
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th2, boolean z10, KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            if (failConnectPromise(th2)) {
                return;
            }
            kQueueRecvByteAllocatorHandle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th2);
            if (z10 || (th2 instanceof OutOfMemoryError) || (th2 instanceof IOException)) {
                shutdownInput(false);
            }
        }

        @Override // io.netty.channel.AbstractChannel.AbstractUnsafe
        public Executor prepareToClose() {
            return super.prepareToClose();
        }

        @Override // io.netty.channel.kqueue.AbstractKQueueChannel.AbstractKQueueUnsafe
        public void readReady(KQueueRecvByteAllocatorHandle kQueueRecvByteAllocatorHandle) {
            Throwable th2;
            boolean z10;
            boolean z11;
            KQueueChannelConfig kQueueChannelConfigConfig = AbstractKQueueStreamChannel.this.config();
            if (AbstractKQueueStreamChannel.this.shouldBreakReadReady(kQueueChannelConfigConfig)) {
                clearReadFilter0();
                return;
            }
            ChannelPipeline channelPipelinePipeline = AbstractKQueueStreamChannel.this.pipeline();
            ByteBufAllocator allocator = kQueueChannelConfigConfig.getAllocator();
            kQueueRecvByteAllocatorHandle.reset(kQueueChannelConfigConfig);
            readReadyBefore();
            while (true) {
                ByteBuf byteBuf = null;
                try {
                    ByteBuf byteBufAllocate = kQueueRecvByteAllocatorHandle.allocate(allocator);
                    try {
                        kQueueRecvByteAllocatorHandle.lastBytesRead(AbstractKQueueStreamChannel.this.doReadBytes(byteBufAllocate));
                        if (kQueueRecvByteAllocatorHandle.lastBytesRead() > 0) {
                            kQueueRecvByteAllocatorHandle.incMessagesRead(1);
                            this.readPending = false;
                            channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                            if (!AbstractKQueueStreamChannel.this.shouldBreakReadReady(kQueueChannelConfigConfig) && kQueueRecvByteAllocatorHandle.continueReading()) {
                            }
                            z11 = false;
                            break;
                        }
                        byteBufAllocate.release();
                        z11 = kQueueRecvByteAllocatorHandle.lastBytesRead() < 0;
                        if (z11) {
                            try {
                                this.readPending = false;
                                break;
                            } catch (Throwable th3) {
                                th2 = th3;
                                z10 = z11;
                                try {
                                    handleReadException(channelPipelinePipeline, byteBuf, th2, z10, kQueueRecvByteAllocatorHandle);
                                } finally {
                                    readReadyFinally(kQueueChannelConfigConfig);
                                }
                            }
                        }
                    } catch (Throwable th4) {
                        z10 = false;
                        byteBuf = byteBufAllocate;
                        th2 = th4;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    z10 = false;
                }
            }
            kQueueRecvByteAllocatorHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (z11) {
                shutdownInput(false);
            }
        }
    }

    public AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, boolean z10) {
        super(channel, bsdSocket, z10);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
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

    private int doWriteMultiple(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        long maxBytesPerGatheringWrite = config().getMaxBytesPerGatheringWrite();
        IovArray iovArrayCleanArray = ((KQueueEventLoop) eventLoop()).cleanArray();
        iovArrayCleanArray.maxBytes(maxBytesPerGatheringWrite);
        channelOutboundBuffer.forEachFlushedMessage(iovArrayCleanArray);
        if (iovArrayCleanArray.count() >= 1) {
            return writeBytesMultiple(channelOutboundBuffer, iovArrayCleanArray);
        }
        channelOutboundBuffer.removeBytes(0L);
        return 0;
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
            channelFutureShutdownInput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.5
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture2) throws Exception {
                    AbstractKQueueStreamChannel.shutdownDone(channelFuture, channelFuture2, channelPromise);
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
        long jCount = defaultFileRegion.count();
        long jTransferred = defaultFileRegion.transferred();
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
            this.byteChannel = new KQueueSocketWritableByteChannel();
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
                    writeFilter(false);
                    return;
                }
                iDoWriteSingle = doWriteSingle(channelOutboundBuffer);
            }
            writeSpinCount -= iDoWriteSingle;
        } while (writeSpinCount > 0);
        if (writeSpinCount != 0) {
            writeFilter(true);
        } else {
            writeFilter(false);
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
        throw new Error();
    }

    @Override // io.netty.channel.AbstractChannel
    public Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return UnixChannelUtil.isBufferCopyNeededForWrite(byteBuf) ? newDirectBuffer(byteBuf) : byteBuf;
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
    public /* bridge */ /* synthetic */ boolean isActive() {
        return super.isActive();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public boolean isInputShutdown() {
        return this.socket.isInputShutdown();
    }

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.Channel
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

    @Override // io.netty.channel.kqueue.AbstractKQueueChannel, io.netty.channel.AbstractChannel
    public AbstractKQueueChannel.AbstractKQueueUnsafe newUnsafe() {
        return new KQueueStreamUnsafe();
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdown(final ChannelPromise channelPromise) {
        ChannelFuture channelFutureShutdownOutput = shutdownOutput();
        if (channelFutureShutdownOutput.isDone()) {
            shutdownOutputDone(channelFutureShutdownOutput, channelPromise);
        } else {
            channelFutureShutdownOutput.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.4
                @Override // io.netty.util.concurrent.GenericFutureListener
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    AbstractKQueueStreamChannel.this.shutdownOutputDone(channelFuture, channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownInput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            shutdownInput0(channelPromise);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.3
                @Override // java.lang.Runnable
                public void run() {
                    AbstractKQueueStreamChannel.this.shutdownInput0(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    @Override // io.netty.channel.socket.DuplexChannel
    public ChannelFuture shutdownOutput(final ChannelPromise channelPromise) {
        EventLoop eventLoop = eventLoop();
        if (eventLoop.inEventLoop()) {
            ((AbstractChannel.AbstractUnsafe) unsafe()).shutdownOutput(channelPromise);
        } else {
            eventLoop.execute(new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.2
                @Override // java.lang.Runnable
                public void run() {
                    ((AbstractChannel.AbstractUnsafe) AbstractKQueueStreamChannel.this.unsafe()).shutdownOutput(channelPromise);
                }
            });
        }
        return channelPromise;
    }

    public AbstractKQueueStreamChannel(Channel channel, BsdSocket bsdSocket, SocketAddress socketAddress) {
        super(channel, bsdSocket, socketAddress);
        this.flushTask = new Runnable() { // from class: io.netty.channel.kqueue.AbstractKQueueStreamChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractKQueueChannel.AbstractKQueueUnsafe) AbstractKQueueStreamChannel.this.unsafe()).flush0();
            }
        };
    }

    public AbstractKQueueStreamChannel(BsdSocket bsdSocket) {
        this((Channel) null, bsdSocket, AbstractKQueueChannel.isSoErrorZero(bsdSocket));
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
}
