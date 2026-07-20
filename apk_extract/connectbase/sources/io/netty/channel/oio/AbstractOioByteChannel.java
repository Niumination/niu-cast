package io.netty.channel.oio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.util.internal.StringUtil;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractOioByteChannel extends AbstractOioChannel {
    private static final ChannelMetadata METADATA = new ChannelMetadata(false);
    private static final String EXPECTED_TYPES = " (expected: " + StringUtil.simpleClassName((Class<?>) ByteBuf.class) + ", " + StringUtil.simpleClassName((Class<?>) FileRegion.class) + ')';

    public AbstractOioByteChannel(Channel channel) {
        super(channel);
    }

    private void closeOnRead(ChannelPipeline channelPipeline) {
        if (isOpen()) {
            if (Boolean.TRUE.equals(config().getOption(ChannelOption.ALLOW_HALF_CLOSURE))) {
                shutdownInput();
                channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownEvent.INSTANCE);
            } else {
                unsafe().close(unsafe().voidPromise());
            }
            channelPipeline.fireUserEventTriggered((Object) ChannelInputShutdownReadComplete.INSTANCE);
        }
    }

    private void handleReadException(ChannelPipeline channelPipeline, ByteBuf byteBuf, Throwable th2, boolean z10, RecvByteBufAllocator.Handle handle) {
        if (byteBuf != null) {
            if (byteBuf.isReadable()) {
                this.readPending = false;
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

    public abstract int available();

    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:115:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac A[Catch: all -> 0x00b2, TryCatch #2 {all -> 0x00b2, blocks: (B:49:0x00a6, B:51:0x00ac, B:54:0x00b5), top: B:99:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00b5 A[Catch: all -> 0x00b2, TRY_LEAVE, TryCatch #2 {all -> 0x00b2, blocks: (B:49:0x00a6, B:51:0x00ac, B:54:0x00b5), top: B:99:0x00a6 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00bc A[Catch: all -> 0x0050, TRY_ENTER, TryCatch #0 {all -> 0x0050, blocks: (B:20:0x004d, B:58:0x00bc, B:60:0x00c4), top: B:94:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00c4 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:20:0x004d, B:58:0x00bc, B:60:0x00c4), top: B:94:0x004d }] */
    /* JADX WARN: Code duplicated, block: B:76:0x00eb A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:78:0x00f1 A[DONT_GENERATE, DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x00f3 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:99:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // io.netty.channel.oio.AbstractOioChannel
    public void doRead() {
        Throwable th2;
        boolean z10;
        boolean zIsAutoRead;
        boolean zIsActive;
        boolean z11;
        Throwable th3;
        ChannelConfig channelConfigConfig = config();
        if (isInputShutdown() || !this.readPending) {
            return;
        }
        boolean z12 = false;
        this.readPending = false;
        ChannelPipeline channelPipelinePipeline = pipeline();
        ByteBufAllocator allocator = channelConfigConfig.getAllocator();
        RecvByteBufAllocator.Handle handleRecvBufAllocHandle = unsafe().recvBufAllocHandle();
        handleRecvBufAllocHandle.reset(channelConfigConfig);
        ByteBuf byteBuf = null;
        try {
            ByteBuf byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
            boolean z13 = false;
            while (true) {
                try {
                    handleRecvBufAllocHandle.lastBytesRead(doReadBytes(byteBufAllocate));
                    if (handleRecvBufAllocHandle.lastBytesRead() <= 0) {
                        if (!byteBufAllocate.isReadable()) {
                            byteBufAllocate.release();
                            try {
                                z11 = handleRecvBufAllocHandle.lastBytesRead() < 0;
                                if (z11) {
                                    try {
                                        this.readPending = false;
                                    } catch (Throwable th4) {
                                        th3 = th4;
                                        th2 = th3;
                                        z12 = z13;
                                        z12 = z11;
                                        try {
                                            handleReadException(channelPipelinePipeline, byteBuf, th2, z12, handleRecvBufAllocHandle);
                                            if (!z10) {
                                                if (!zIsAutoRead) {
                                                    if (!z12) {
                                                        return;
                                                    } else {
                                                        if (!zIsActive) {
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                            return;
                                        } finally {
                                            if (this.readPending || channelConfigConfig.isAutoRead() || (!z12 && isActive())) {
                                                read();
                                            }
                                        }
                                    }
                                }
                                byteBufAllocate = null;
                            } catch (Throwable th5) {
                                th = th5;
                                th2 = th;
                                boolean z14 = z13;
                                z12 = false;
                                z12 = z14;
                                handleReadException(channelPipelinePipeline, byteBuf, th2, z12, handleRecvBufAllocHandle);
                                if (!z10) {
                                    if (!zIsAutoRead) {
                                        if (!z12) {
                                            return;
                                        } else {
                                            if (!zIsActive) {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (byteBufAllocate == null) {
                            try {
                                if (byteBufAllocate.isReadable()) {
                                    this.readPending = false;
                                    channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                                } else {
                                    byteBufAllocate.release();
                                }
                            } catch (Throwable th6) {
                                th3 = th6;
                                byteBuf = byteBufAllocate;
                                th2 = th3;
                                z12 = z13;
                                z12 = z11;
                                handleReadException(channelPipelinePipeline, byteBuf, th2, z12, handleRecvBufAllocHandle);
                                if (!z10) {
                                    if (!zIsAutoRead) {
                                        if (!z12) {
                                            return;
                                        } else {
                                            if (!zIsActive) {
                                                return;
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            byteBuf = byteBufAllocate;
                        }
                        if (z13) {
                            handleRecvBufAllocHandle.readComplete();
                            channelPipelinePipeline.fireChannelReadComplete();
                        }
                        if (z11) {
                            closeOnRead(channelPipelinePipeline);
                        }
                        if (!this.readPending && !channelConfigConfig.isAutoRead() && (z13 || !isActive())) {
                            return;
                        }
                        return;
                    }
                    try {
                        int iAvailable = available();
                        if (iAvailable > 0) {
                            if (!byteBufAllocate.isWritable()) {
                                int iCapacity = byteBufAllocate.capacity();
                                int iMaxCapacity = byteBufAllocate.maxCapacity();
                                if (iCapacity == iMaxCapacity) {
                                    handleRecvBufAllocHandle.incMessagesRead(1);
                                    this.readPending = false;
                                    channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                                    byteBufAllocate = handleRecvBufAllocHandle.allocate(allocator);
                                } else if (byteBufAllocate.writerIndex() + iAvailable > iMaxCapacity) {
                                    byteBufAllocate.capacity(iMaxCapacity);
                                } else {
                                    byteBufAllocate.ensureWritable(iAvailable);
                                }
                            }
                            if (handleRecvBufAllocHandle.continueReading()) {
                                z13 = true;
                            }
                        }
                        z13 = true;
                    } catch (Throwable th7) {
                        th = th7;
                        byteBuf = byteBufAllocate;
                        z12 = true;
                        th2 = th;
                        handleReadException(channelPipelinePipeline, byteBuf, th2, z12, handleRecvBufAllocHandle);
                        if (!z10) {
                            if (!zIsAutoRead) {
                                if (!z12) {
                                    return;
                                } else {
                                    if (!zIsActive) {
                                        return;
                                    }
                                }
                            }
                        }
                    }
                    z11 = false;
                    if (byteBufAllocate == null) {
                        byteBuf = byteBufAllocate;
                    } else if (byteBufAllocate.isReadable()) {
                        this.readPending = false;
                        channelPipelinePipeline.fireChannelRead((Object) byteBufAllocate);
                    } else {
                        byteBufAllocate.release();
                    }
                    if (z13) {
                        handleRecvBufAllocHandle.readComplete();
                        channelPipelinePipeline.fireChannelReadComplete();
                    }
                    if (z11) {
                        closeOnRead(channelPipelinePipeline);
                    }
                    if (!this.readPending) {
                        return;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    byteBuf = byteBufAllocate;
                }
                return;
            }
        } catch (Throwable th9) {
            th = th9;
        }
    }

    public abstract int doReadBytes(ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    public void doWrite(ChannelOutboundBuffer channelOutboundBuffer) throws Exception {
        while (true) {
            Object objCurrent = channelOutboundBuffer.current();
            if (objCurrent == null) {
                return;
            }
            if (objCurrent instanceof ByteBuf) {
                ByteBuf byteBuf = (ByteBuf) objCurrent;
                int i10 = byteBuf.readableBytes();
                while (i10 > 0) {
                    doWriteBytes(byteBuf);
                    int i11 = byteBuf.readableBytes();
                    channelOutboundBuffer.progress(i10 - i11);
                    i10 = i11;
                }
                channelOutboundBuffer.remove();
            } else if (objCurrent instanceof FileRegion) {
                FileRegion fileRegion = (FileRegion) objCurrent;
                long jTransferred = fileRegion.transferred();
                doWriteFileRegion(fileRegion);
                channelOutboundBuffer.progress(fileRegion.transferred() - jTransferred);
                channelOutboundBuffer.remove();
            } else {
                channelOutboundBuffer.remove(new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(objCurrent)));
            }
        }
    }

    public abstract void doWriteBytes(ByteBuf byteBuf) throws Exception;

    public abstract void doWriteFileRegion(FileRegion fileRegion) throws Exception;

    @Override // io.netty.channel.AbstractChannel
    public final Object filterOutboundMessage(Object obj) throws Exception {
        if ((obj instanceof ByteBuf) || (obj instanceof FileRegion)) {
            return obj;
        }
        throw new UnsupportedOperationException("unsupported message type: " + StringUtil.simpleClassName(obj) + EXPECTED_TYPES);
    }

    public abstract boolean isInputShutdown();

    @Override // io.netty.channel.Channel
    public ChannelMetadata metadata() {
        return METADATA;
    }

    public abstract ChannelFuture shutdownInput();
}
