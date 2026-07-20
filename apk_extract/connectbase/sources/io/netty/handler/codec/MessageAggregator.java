package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.ObjectUtil;
import java.util.List;
import k.b;

/* JADX INFO: loaded from: classes3.dex */
public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder> extends MessageToMessageDecoder<I> {
    private static final int DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS = 1024;
    private boolean aggregating;
    private ChannelFutureListener continueResponseWriteListener;
    private ChannelHandlerContext ctx;
    private O currentMessage;
    private boolean handleIncompleteAggregateDuringClose;
    private boolean handlingOversizedMessage;
    private final int maxContentLength;
    private int maxCumulationBufferComponents;

    public MessageAggregator(int i10) {
        this.maxCumulationBufferComponents = 1024;
        this.handleIncompleteAggregateDuringClose = true;
        validateMaxContentLength(i10);
        this.maxContentLength = i10;
    }

    private static void appendPartialContent(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            compositeByteBuf.addComponent(true, byteBuf.retain());
        }
    }

    private void finishAggregation0(O o10) throws Exception {
        this.aggregating = false;
        finishAggregation(o10);
    }

    private void invokeHandleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s10) throws Exception {
        this.handlingOversizedMessage = true;
        this.currentMessage = null;
        this.handleIncompleteAggregateDuringClose = false;
        try {
            handleOversizedMessage(channelHandlerContext, s10);
        } finally {
            ReferenceCountUtil.release(s10);
        }
    }

    private void releaseCurrentMessage() {
        O o10 = this.currentMessage;
        if (o10 != null) {
            o10.release();
            this.currentMessage = null;
            this.handlingOversizedMessage = false;
            this.aggregating = false;
        }
    }

    private static void validateMaxContentLength(int i10) {
        ObjectUtil.checkPositiveOrZero(i10, "maxContentLength");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (!super.acceptInboundMessage(obj) || isAggregated(obj)) {
            return false;
        }
        if (isStartMessage(obj)) {
            return true;
        }
        return this.aggregating && isContentMessage(obj);
    }

    public void aggregate(O o10, C c10) throws Exception {
    }

    public abstract O beginAggregation(S s10, ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.aggregating && this.handleIncompleteAggregateDuringClose) {
            channelHandlerContext.fireExceptionCaught((Throwable) new PrematureChannelClosureException("Channel closed while still aggregating message"));
        }
        try {
            super.channelInactive(channelHandlerContext);
        } finally {
            releaseCurrentMessage();
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        if (this.currentMessage != null && !channelHandlerContext.channel().config().isAutoRead()) {
            channelHandlerContext.read();
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    public abstract boolean closeAfterContinueResponse(Object obj) throws Exception;

    public final ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline yet");
    }

    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public void decode(final ChannelHandlerContext channelHandlerContext, I i10, List<Object> list) throws Exception {
        boolean zIsLastContentMessage = true;
        if (!isStartMessage(i10)) {
            if (!isContentMessage(i10)) {
                throw new MessageAggregationException();
            }
            O o10 = this.currentMessage;
            if (o10 == null) {
                return;
            }
            CompositeByteBuf compositeByteBuf = (CompositeByteBuf) o10.content();
            ByteBufHolder byteBufHolder = (ByteBufHolder) i10;
            if (compositeByteBuf.readableBytes() > this.maxContentLength - byteBufHolder.content().readableBytes()) {
                invokeHandleOversizedMessage(channelHandlerContext, this.currentMessage);
                return;
            }
            appendPartialContent(compositeByteBuf, byteBufHolder.content());
            aggregate(this.currentMessage, byteBufHolder);
            if (byteBufHolder instanceof DecoderResultProvider) {
                DecoderResult decoderResult = ((DecoderResultProvider) byteBufHolder).decoderResult();
                if (decoderResult.isSuccess()) {
                    zIsLastContentMessage = isLastContentMessage(byteBufHolder);
                } else {
                    O o11 = this.currentMessage;
                    if (o11 instanceof DecoderResultProvider) {
                        ((DecoderResultProvider) o11).setDecoderResult(DecoderResult.failure(decoderResult.cause()));
                    }
                }
            } else {
                zIsLastContentMessage = isLastContentMessage(byteBufHolder);
            }
            if (zIsLastContentMessage) {
                finishAggregation0(this.currentMessage);
                list.add(this.currentMessage);
                this.currentMessage = null;
                return;
            }
            return;
        }
        this.aggregating = true;
        this.handlingOversizedMessage = false;
        O o12 = this.currentMessage;
        if (o12 != null) {
            o12.release();
            this.currentMessage = null;
            throw new MessageAggregationException();
        }
        Object objNewContinueResponse = newContinueResponse(i10, this.maxContentLength, channelHandlerContext.pipeline());
        if (objNewContinueResponse != null) {
            ChannelFutureListener channelFutureListener = this.continueResponseWriteListener;
            if (channelFutureListener == null) {
                channelFutureListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.MessageAggregator.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (channelFuture.isSuccess()) {
                            return;
                        }
                        channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                    }
                };
                this.continueResponseWriteListener = channelFutureListener;
            }
            boolean zCloseAfterContinueResponse = closeAfterContinueResponse(objNewContinueResponse);
            this.handlingOversizedMessage = ignoreContentAfterContinueResponse(objNewContinueResponse);
            Future<Void> futureAddListener = channelHandlerContext.writeAndFlush(objNewContinueResponse).addListener((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
            if (zCloseAfterContinueResponse) {
                this.handleIncompleteAggregateDuringClose = false;
                futureAddListener.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                return;
            } else if (this.handlingOversizedMessage) {
                return;
            }
        } else if (isContentLengthInvalid(i10, this.maxContentLength)) {
            invokeHandleOversizedMessage(channelHandlerContext, i10);
            return;
        }
        if ((i10 instanceof DecoderResultProvider) && !((DecoderResultProvider) i10).decoderResult().isSuccess()) {
            ByteBufHolder byteBufHolderBeginAggregation = i10 instanceof ByteBufHolder ? beginAggregation(i10, ((ByteBufHolder) i10).content().retain()) : beginAggregation(i10, Unpooled.EMPTY_BUFFER);
            finishAggregation0(byteBufHolderBeginAggregation);
            list.add(byteBufHolderBeginAggregation);
        } else {
            CompositeByteBuf compositeByteBufCompositeBuffer = channelHandlerContext.alloc().compositeBuffer(this.maxCumulationBufferComponents);
            if (i10 instanceof ByteBufHolder) {
                appendPartialContent(compositeByteBufCompositeBuffer, ((ByteBufHolder) i10).content());
            }
            this.currentMessage = (O) beginAggregation(i10, compositeByteBufCompositeBuffer);
        }
    }

    public void finishAggregation(O o10) throws Exception {
    }

    public void handleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s10) throws Exception {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException("content length exceeded " + maxContentLength() + " bytes."));
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        try {
            super.handlerRemoved(channelHandlerContext);
        } finally {
            releaseCurrentMessage();
        }
    }

    public abstract boolean ignoreContentAfterContinueResponse(Object obj) throws Exception;

    public abstract boolean isAggregated(I i10) throws Exception;

    public abstract boolean isContentLengthInvalid(S s10, int i10) throws Exception;

    public abstract boolean isContentMessage(I i10) throws Exception;

    @Deprecated
    public final boolean isHandlingOversizedMessage() {
        return this.handlingOversizedMessage;
    }

    public abstract boolean isLastContentMessage(C c10) throws Exception;

    public abstract boolean isStartMessage(I i10) throws Exception;

    public final int maxContentLength() {
        return this.maxContentLength;
    }

    public final int maxCumulationBufferComponents() {
        return this.maxCumulationBufferComponents;
    }

    public abstract Object newContinueResponse(S s10, int i10, ChannelPipeline channelPipeline) throws Exception;

    public final void setMaxCumulationBufferComponents(int i10) {
        if (i10 < 2) {
            throw new IllegalArgumentException(b.a("maxCumulationBufferComponents: ", i10, " (expected: >= 2)"));
        }
        if (this.ctx != null) {
            throw new IllegalStateException("decoder properties cannot be changed once the decoder is added to a pipeline.");
        }
        this.maxCumulationBufferComponents = i10;
    }

    public MessageAggregator(int i10, Class<? extends I> cls) {
        super(cls);
        this.maxCumulationBufferComponents = 1024;
        this.handleIncompleteAggregateDuringClose = true;
        validateMaxContentLength(i10);
        this.maxContentLength = i10;
    }
}
