package io.netty.handler.stream;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelProgressivePromise;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: loaded from: classes3.dex */
public class ChunkedWriteHandler extends ChannelDuplexHandler {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ChunkedWriteHandler.class);
    private volatile ChannelHandlerContext ctx;
    private final Queue<PendingWrite> queue = new ArrayDeque();

    public static final class PendingWrite {
        final Object msg;
        final ChannelPromise promise;

        public PendingWrite(Object obj, ChannelPromise channelPromise) {
            this.msg = obj;
            this.promise = channelPromise;
        }

        public void fail(Throwable th2) {
            ReferenceCountUtil.release(this.msg);
            this.promise.tryFailure(th2);
        }

        public void progress(long j10, long j11) {
            ChannelPromise channelPromise = this.promise;
            if (channelPromise instanceof ChannelProgressivePromise) {
                ((ChannelProgressivePromise) channelPromise).tryProgress(j10, j11);
            }
        }

        public void success(long j10) {
            if (this.promise.isDone()) {
                return;
            }
            progress(j10, j10);
            this.promise.trySuccess();
        }
    }

    public ChunkedWriteHandler() {
    }

    private static void closeInput(ChunkedInput<?> chunkedInput) {
        try {
            chunkedInput.close();
        } catch (Throwable th2) {
            if (logger.isWarnEnabled()) {
                logger.warn("Failed to close a chunked input.", th2);
            }
        }
    }

    private void discard(Throwable th2) {
        while (true) {
            PendingWrite pendingWritePoll = this.queue.poll();
            if (pendingWritePoll == null) {
                return;
            }
            Object obj = pendingWritePoll.msg;
            if (obj instanceof ChunkedInput) {
                ChunkedInput chunkedInput = (ChunkedInput) obj;
                try {
                    boolean zIsEndOfInput = chunkedInput.isEndOfInput();
                    long length = chunkedInput.length();
                    closeInput(chunkedInput);
                    if (zIsEndOfInput) {
                        pendingWritePoll.success(length);
                    } else {
                        if (th2 == null) {
                            th2 = new ClosedChannelException();
                        }
                        pendingWritePoll.fail(th2);
                    }
                } catch (Exception e10) {
                    closeInput(chunkedInput);
                    pendingWritePoll.fail(e10);
                    InternalLogger internalLogger = logger;
                    if (internalLogger.isWarnEnabled()) {
                        internalLogger.warn("ChunkedInput failed", (Throwable) e10);
                    }
                }
            } else {
                if (th2 == null) {
                    th2 = new ClosedChannelException();
                }
                pendingWritePoll.fail(th2);
            }
        }
    }

    private void doFlush(ChannelHandlerContext channelHandlerContext) {
        final PendingWrite pendingWritePeek;
        Channel channel = channelHandlerContext.channel();
        Object obj = null;
        if (!channel.isActive()) {
            discard(null);
            return;
        }
        ByteBufAllocator byteBufAllocatorAlloc = channelHandlerContext.alloc();
        boolean z10 = true;
        while (channel.isWritable() && (pendingWritePeek = this.queue.peek()) != null) {
            if (pendingWritePeek.promise.isDone()) {
                this.queue.remove();
            } else {
                Object obj2 = pendingWritePeek.msg;
                if (obj2 instanceof ChunkedInput) {
                    ChunkedInput chunkedInput = (ChunkedInput) obj2;
                    try {
                        Object chunk = chunkedInput.readChunk(byteBufAllocatorAlloc);
                        try {
                            boolean zIsEndOfInput = chunkedInput.isEndOfInput();
                            if (chunk == null ? !zIsEndOfInput : false) {
                                break;
                            }
                            if (chunk == null) {
                                chunk = Unpooled.EMPTY_BUFFER;
                            }
                            if (zIsEndOfInput) {
                                this.queue.remove();
                            }
                            ChannelFuture channelFutureWriteAndFlush = channelHandlerContext.writeAndFlush(chunk);
                            if (!zIsEndOfInput) {
                                final boolean z11 = !channel.isWritable();
                                if (channelFutureWriteAndFlush.isDone()) {
                                    handleFuture(channelFutureWriteAndFlush, pendingWritePeek, z11);
                                } else {
                                    channelFutureWriteAndFlush.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.3
                                        @Override // io.netty.util.concurrent.GenericFutureListener
                                        public void operationComplete(ChannelFuture channelFuture) {
                                            ChunkedWriteHandler.this.handleFuture(channelFuture, pendingWritePeek, z11);
                                        }
                                    });
                                }
                            } else if (channelFutureWriteAndFlush.isDone()) {
                                handleEndOfInputFuture(channelFutureWriteAndFlush, pendingWritePeek);
                            } else {
                                channelFutureWriteAndFlush.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.stream.ChunkedWriteHandler.2
                                    @Override // io.netty.util.concurrent.GenericFutureListener
                                    public void operationComplete(ChannelFuture channelFuture) {
                                        ChunkedWriteHandler.handleEndOfInputFuture(channelFuture, pendingWritePeek);
                                    }
                                });
                            }
                            z10 = false;
                        } catch (Throwable th2) {
                            th = th2;
                            obj = chunk;
                            this.queue.remove();
                            if (obj != null) {
                                ReferenceCountUtil.release(obj);
                            }
                            closeInput(chunkedInput);
                            pendingWritePeek.fail(th);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                } else {
                    this.queue.remove();
                    channelHandlerContext.write(obj2, pendingWritePeek.promise);
                    z10 = true;
                }
                if (!channel.isActive()) {
                    discard(new ClosedChannelException());
                    break;
                }
            }
        }
        if (z10) {
            channelHandlerContext.flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleEndOfInputFuture(ChannelFuture channelFuture, PendingWrite pendingWrite) {
        ChunkedInput chunkedInput = (ChunkedInput) pendingWrite.msg;
        if (!channelFuture.isSuccess()) {
            closeInput(chunkedInput);
            pendingWrite.fail(channelFuture.cause());
            return;
        }
        long jProgress = chunkedInput.progress();
        long length = chunkedInput.length();
        closeInput(chunkedInput);
        pendingWrite.progress(jProgress, length);
        pendingWrite.success(length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFuture(ChannelFuture channelFuture, PendingWrite pendingWrite, boolean z10) {
        ChunkedInput chunkedInput = (ChunkedInput) pendingWrite.msg;
        if (!channelFuture.isSuccess()) {
            closeInput(chunkedInput);
            pendingWrite.fail(channelFuture.cause());
            return;
        }
        pendingWrite.progress(chunkedInput.progress(), chunkedInput.length());
        if (z10 && channelFuture.channel().isWritable()) {
            resumeTransfer();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeTransfer0(ChannelHandlerContext channelHandlerContext) {
        try {
            doFlush(channelHandlerContext);
        } catch (Exception e10) {
            logger.warn("Unexpected exception while sending chunks.", (Throwable) e10);
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        doFlush(channelHandlerContext);
        channelHandlerContext.fireChannelInactive();
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelWritabilityChanged(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (channelHandlerContext.channel().isWritable()) {
            doFlush(channelHandlerContext);
        }
        channelHandlerContext.fireChannelWritabilityChanged();
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void flush(ChannelHandlerContext channelHandlerContext) throws Exception {
        doFlush(channelHandlerContext);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public void resumeTransfer() {
        final ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext == null) {
            return;
        }
        if (channelHandlerContext.executor().inEventLoop()) {
            resumeTransfer0(channelHandlerContext);
        } else {
            channelHandlerContext.executor().execute(new Runnable() { // from class: io.netty.handler.stream.ChunkedWriteHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    ChunkedWriteHandler.this.resumeTransfer0(channelHandlerContext);
                }
            });
        }
    }

    @Override // io.netty.channel.ChannelDuplexHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        this.queue.add(new PendingWrite(obj, channelPromise));
    }

    @Deprecated
    public ChunkedWriteHandler(int i10) {
        ObjectUtil.checkPositive(i10, "maxPendingWrites");
    }
}
