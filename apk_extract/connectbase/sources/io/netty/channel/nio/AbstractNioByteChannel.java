package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractNioByteChannel extends AbstractNioChannel {
    private final Runnable flushTask;
    private boolean inputClosedSeenErrorOnRead;
    private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    public class NioByteUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        public NioByteUnsafe() {
            super();
        }

        private void closeOnRead(ChannelPipeline channelPipeline) {
            if (AbstractNioByteChannel.this.isInputShutdown0()) {
                if (AbstractNioByteChannel.this.inputClosedSeenErrorOnRead) {
                    return;
                }
                AbstractNioByteChannel.this.inputClosedSeenErrorOnRead = true;
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
                return;
            }
            if (!AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config())) {
                close(voidPromise());
            } else {
                AbstractNioByteChannel.this.shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            }
        }

        private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th2, boolean z10, RecvByteBufAllocator.Handle handle) {
            if (byteBuf != null) {
                if (byteBuf.isReadable()) {
                    AbstractNioByteChannel.this.readPending = false;
                    channelPipeline.fireChannelRead((Object) byteBuf);
                } else {
                    byteBuf.release();
                }
            }
            handle.readComplete();
            channelPipeline.fireChannelReadComplete();
            channelPipeline.fireExceptionCaught(th2);
            if (z10 || (th2 instanceof OutOfMemoryError) || (th2 instanceof IOException)) {
                closeOnRead(channelPipeline);
            }
        }

        @Override // io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public final void read() {
            boolean z10;
            Throwable th2;
            boolean z11;
            boolean z12;
            boolean zIsAutoRead;
            ChannelConfig channelConfigConfig = AbstractNioByteChannel.this.config();
            if (AbstractNioByteChannel.this.shouldBreakReadReady(channelConfigConfig)) {
                AbstractNioByteChannel.this.clearReadPending();
                return;
            }
            ChannelPipeline channelPipelinePipeline = AbstractNioByteChannel.this.pipeline();
            ByteBufAllocator allocator = channelConfigConfig.getAllocator();
            RecvByteBufAllocator.Handle handleRecvBufAllocHandle = recvBufAllocHandle();
            handleRecvBufAllocHandle.reset(channelConfigConfig);
            do {
                z10 = false;
                ByteBuf byteBuf = null;
                try {
                    ByteBuf byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                    try {
                        handleRecvBufAllocHandle.lastBytesRead(AbstractNioByteChannel.this.doReadBytes(byteBufAllocate));
                        if (handleRecvBufAllocHandle.lastBytesRead() <= 0) {
                            byteBufAllocate.release();
                            boolean z13 = handleRecvBufAllocHandle.lastBytesRead() < 0;
                            if (z13) {
                                try {
                                    AbstractNioByteChannel.this.readPending = false;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    z11 = z13;
                                    try {
                                        handleReadException(channelPipelinePipeline, byteBuf, th2, z11, handleRecvBufAllocHandle);
                                        if (z12) {
                                            return;
                                        } else {
                                            if (zIsAutoRead) {
                                                return;
                                            }
                                        }
                                    } finally {
                                        if (!AbstractNioByteChannel.this.readPending && !channelConfigConfig.isAutoRead()) {
                                            removeReadOp();
                                        }
                                    }
                                }
                            }
                            z10 = z13;
                            break;
                        }
                        handleRecvBufAllocHandle.incMessagesRead(1);
                        AbstractNioByteChannel.this.readPending = false;
                        channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                    } catch (Throwable th4) {
                        z11 = false;
                        byteBuf = byteBufAllocate;
                        th2 = th4;
                    }
                } catch (Throwable th5) {
                    th2 = th5;
                    z11 = z10;
                }
            } while (handleRecvBufAllocHandle.continueReading());
            handleRecvBufAllocHandle.readComplete();
            channelPipelinePipeline.fireChannelReadComplete();
            if (z10) {
                closeOnRead(channelPipelinePipeline);
            }
            if (AbstractNioByteChannel.this.readPending || channelConfigConfig.isAutoRead()) {
            }
        }
    }

    public AbstractNioByteChannel(Channel channel, SelectableChannel selectableChannel) {
        super(channel, selectableChannel, 1);
        this.flushTask = new Runnable() { // from class: io.netty.channel.nio.AbstractNioByteChannel.1
            @Override // java.lang.Runnable
            public void run() {
                ((AbstractNioChannel.AbstractNioUnsafe) AbstractNioByteChannel.this.unsafe()).flush0();
            }
        };
    }

    private int doWriteInternal(ChannelOutboundBuffer channelOutboundBuffer, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
                return 0;
            }
            int iDoWriteBytes = doWriteBytes(byteBuf);
            if (iDoWriteBytes <= 0) {
                return Integer.MAX_VALUE;
            }
            channelOutboundBuffer.progress(iDoWriteBytes);
            if (!byteBuf.isReadable()) {
                channelOutboundBuffer.remove();
            }
            return 1;
        }
        if (!(obj instanceof FileRegion)) {
            throw new Error();
        }
        FileRegion fileRegion = (FileRegion) obj;
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
            return 0;
        }
        long jDoWriteFileRegion = doWriteFileRegion(fileRegion);
        if (jDoWriteFileRegion <= 0) {
            return Integer.MAX_VALUE;
        }
        channelOutboundBuffer.progress(jDoWriteFileRegion);
        if (fileRegion.transferred() >= fileRegion.count()) {
            channelOutboundBuffer.remove();
        }
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllowHalfClosure(ChannelConfig channelConfig) {
        return (channelConfig instanceof SocketChannelConfig) && ((SocketChannelConfig) channelConfig).isAllowHalfClosure();
    }

    public final void clearOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) != 0) {
                selectionKey.interestOps(iInterestOps & (-5));
            }
        }
    }

    public abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        int writeSpinCount = config().getWriteSpinCount();
        do {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                clearOpWrite();
                return;
            }
            writeSpinCount -= doWriteInternal(channelOutboundBuffer, objCurrent);
        } while (writeSpinCount > 0);
        incompleteWrite(writeSpinCount < 0);
    }

    public final int doWrite0(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        if (channelOutboundBuffer.current() == null) {
            return 0;
        }
        return doWriteInternal(channelOutboundBuffer, channelOutboundBuffer.current());
    }

    public abstract int doWriteBytes(ByteBuf byteBuf) throws Exception;

    public abstract long doWriteFileRegion(FileRegion fileRegion) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) {
        if (obj instanceof ByteBuf) {
            ByteBuf byteBuf = (ByteBuf) obj;
            return byteBuf.isDirect() ? obj : newDirectBuffer(byteBuf);
        }
        if (obj instanceof FileRegion) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    public final void incompleteWrite(boolean z10) {
        if (z10) {
            setOpWrite();
        } else {
            clearOpWrite();
            eventLoop().execute(this.flushTask);
        }
    }

    public boolean isInputShutdown0() {
        return false;
    }

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public final void setOpWrite() {
        SelectionKey selectionKey = selectionKey();
        if (selectionKey.isValid()) {
            int iInterestOps = selectionKey.interestOps();
            if ((iInterestOps & 4) == 0) {
                selectionKey.interestOps(iInterestOps | 4);
            }
        }
    }

    public final boolean shouldBreakReadReady(ChannelConfig channelConfig) {
        return isInputShutdown0() && (this.inputClosedSeenErrorOnRead || !isAllowHalfClosure(channelConfig));
    }

    public abstract ChannelFuture shutdownInput();

    @Override // io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioByteUnsafe();
    }
}
