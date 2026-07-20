package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* JADX INFO: loaded from: classes3.dex */
public class Utf8FrameValidator extends ChannelInboundHandlerAdapter {
    private final boolean closeOnProtocolViolation;
    private int fragmentedFramesCount;
    private Utf8Validator utf8Validator;

    public Utf8FrameValidator() {
        this(true);
    }

    private void checkUTF8String(ByteBuf byteBuf) {
        if (this.utf8Validator == null) {
            this.utf8Validator = new Utf8Validator();
        }
        this.utf8Validator.check(byteBuf);
    }

    private void protocolViolation(ChannelHandlerContext channelHandlerContext, WebSocketFrame webSocketFrame, CorruptedWebSocketFrameException corruptedWebSocketFrameException) {
        webSocketFrame.release();
        if (!this.closeOnProtocolViolation || !channelHandlerContext.channel().isOpen()) {
            throw corruptedWebSocketFrameException;
        }
        WebSocketCloseStatus webSocketCloseStatusCloseStatus = corruptedWebSocketFrameException.closeStatus();
        String message = corruptedWebSocketFrameException.getMessage();
        if (message == null) {
            message = webSocketCloseStatusCloseStatus.reasonText();
        }
        channelHandlerContext.writeAndFlush(new CloseWebSocketFrame(webSocketCloseStatusCloseStatus.code(), message)).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
        throw corruptedWebSocketFrameException;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        Utf8Validator utf8Validator;
        if (obj instanceof WebSocketFrame) {
            WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
            try {
                if (!((WebSocketFrame) obj).isFinalFragment()) {
                    if (this.fragmentedFramesCount != 0) {
                        Utf8Validator utf8Validator2 = this.utf8Validator;
                        if (utf8Validator2 != null && utf8Validator2.isChecking()) {
                            checkUTF8String(webSocketFrame.content());
                        }
                    } else if (webSocketFrame instanceof TextWebSocketFrame) {
                        checkUTF8String(webSocketFrame.content());
                    }
                    this.fragmentedFramesCount++;
                } else if (!(webSocketFrame instanceof PingWebSocketFrame)) {
                    this.fragmentedFramesCount = 0;
                    if ((webSocketFrame instanceof TextWebSocketFrame) || ((utf8Validator = this.utf8Validator) != null && utf8Validator.isChecking())) {
                        checkUTF8String(webSocketFrame.content());
                        this.utf8Validator.finish();
                    }
                }
            } catch (CorruptedWebSocketFrameException e10) {
                protocolViolation(channelHandlerContext, webSocketFrame, e10);
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler, io.netty.channel.ChannelInboundHandler
    public void exceptionCaught(ChannelHandlerContext channelHandlerContext, Throwable th2) throws Exception {
        super.exceptionCaught(channelHandlerContext, th2);
    }

    public Utf8FrameValidator(boolean z10) {
        this.closeOnProtocolViolation = z10;
    }
}
