package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class InboundHttp2ToHttpAdapter extends Http2EventAdapter {
    private static final ImmediateSendDetector DEFAULT_SEND_DETECTOR = new ImmediateSendDetector() { // from class: io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter.1
        @Override // io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter.ImmediateSendDetector
        public FullHttpMessage copyIfNeeded(ByteBufAllocator byteBufAllocator, FullHttpMessage fullHttpMessage) {
            if (!(fullHttpMessage instanceof FullHttpRequest)) {
                return null;
            }
            FullHttpRequest fullHttpRequestReplace = ((FullHttpRequest) fullHttpMessage).replace(byteBufAllocator.buffer(0));
            fullHttpRequestReplace.headers().remove(HttpHeaderNames.EXPECT);
            return fullHttpRequestReplace;
        }

        @Override // io.netty.handler.codec.http2.InboundHttp2ToHttpAdapter.ImmediateSendDetector
        public boolean mustSendImmediately(FullHttpMessage fullHttpMessage) {
            if (fullHttpMessage instanceof FullHttpResponse) {
                return ((FullHttpResponse) fullHttpMessage).status().codeClass() == HttpStatusClass.INFORMATIONAL;
            }
            if (fullHttpMessage instanceof FullHttpRequest) {
                return fullHttpMessage.headers().contains(HttpHeaderNames.EXPECT);
            }
            return false;
        }
    };
    protected final Http2Connection connection;
    private final int maxContentLength;
    private final Http2Connection.PropertyKey messageKey;
    private final boolean propagateSettings;
    private final ImmediateSendDetector sendDetector = DEFAULT_SEND_DETECTOR;
    protected final boolean validateHttpHeaders;

    public interface ImmediateSendDetector {
        FullHttpMessage copyIfNeeded(ByteBufAllocator byteBufAllocator, FullHttpMessage fullHttpMessage);

        boolean mustSendImmediately(FullHttpMessage fullHttpMessage);
    }

    public InboundHttp2ToHttpAdapter(Http2Connection http2Connection, int i10, boolean z10, boolean z11) {
        this.connection = (Http2Connection) ObjectUtil.checkNotNull(http2Connection, "connection");
        this.maxContentLength = ObjectUtil.checkPositive(i10, "maxContentLength");
        this.validateHttpHeaders = z10;
        this.propagateSettings = z11;
        this.messageKey = http2Connection.newKey();
    }

    private void processHeadersEnd(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, FullHttpMessage fullHttpMessage, boolean z10) {
        if (z10) {
            fireChannelRead(channelHandlerContext, fullHttpMessage, getMessage(http2Stream) != fullHttpMessage, http2Stream);
        } else {
            putMessage(http2Stream, fullHttpMessage);
        }
    }

    public void fireChannelRead(ChannelHandlerContext channelHandlerContext, FullHttpMessage fullHttpMessage, boolean z10, Http2Stream http2Stream) {
        removeMessage(http2Stream, z10);
        HttpUtil.setContentLength(fullHttpMessage, fullHttpMessage.content().readableBytes());
        channelHandlerContext.fireChannelRead((Object) fullHttpMessage);
    }

    public final FullHttpMessage getMessage(Http2Stream http2Stream) {
        return (FullHttpMessage) http2Stream.getProperty(this.messageKey);
    }

    public FullHttpMessage newMessage(Http2Stream http2Stream, Http2Headers http2Headers, boolean z10, ByteBufAllocator byteBufAllocator) throws Http2Exception {
        return this.connection.isServer() ? HttpConversionUtil.toFullHttpRequest(http2Stream.id(), http2Headers, byteBufAllocator, z10) : HttpConversionUtil.toFullHttpResponse(http2Stream.id(), http2Headers, byteBufAllocator, z10);
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public int onDataRead(ChannelHandlerContext channelHandlerContext, int i10, ByteBuf byteBuf, int i11, boolean z10) throws Http2Exception {
        Http2Stream http2StreamStream = this.connection.stream(i10);
        FullHttpMessage message = getMessage(http2StreamStream);
        if (message == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Data Frame received for unknown stream id %d", Integer.valueOf(i10));
        }
        ByteBuf byteBufContent = message.content();
        int i12 = byteBuf.readableBytes();
        int i13 = byteBufContent.readableBytes();
        int i14 = this.maxContentLength;
        if (i13 > i14 - i12) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Content length exceeded max of %d for stream id %d", Integer.valueOf(i14), Integer.valueOf(i10));
        }
        byteBufContent.writeBytes(byteBuf, byteBuf.readerIndex(), i12);
        if (z10) {
            fireChannelRead(channelHandlerContext, message, false, http2StreamStream);
        }
        return i12 + i11;
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, boolean z10) throws Http2Exception {
        Http2Stream http2StreamStream = this.connection.stream(i10);
        FullHttpMessage fullHttpMessageProcessHeadersBegin = processHeadersBegin(channelHandlerContext, http2StreamStream, http2Headers, z10, true, true);
        if (fullHttpMessageProcessHeadersBegin != null) {
            processHeadersEnd(channelHandlerContext, http2StreamStream, fullHttpMessageProcessHeadersBegin, z10);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onPushPromiseRead(ChannelHandlerContext channelHandlerContext, int i10, int i11, Http2Headers http2Headers, int i12) throws Http2Exception {
        Http2Stream http2StreamStream = this.connection.stream(i11);
        if (http2Headers.status() == null) {
            http2Headers.status(HttpResponseStatus.OK.codeAsText());
        }
        FullHttpMessage fullHttpMessageProcessHeadersBegin = processHeadersBegin(channelHandlerContext, http2StreamStream, http2Headers, false, false, false);
        if (fullHttpMessageProcessHeadersBegin == null) {
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Push Promise Frame received for pre-existing stream id %d", Integer.valueOf(i11));
        }
        fullHttpMessageProcessHeadersBegin.headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_PROMISE_ID.text(), i10);
        fullHttpMessageProcessHeadersBegin.headers().setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short) 16);
        processHeadersEnd(channelHandlerContext, http2StreamStream, fullHttpMessageProcessHeadersBegin, false);
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onRstStreamRead(ChannelHandlerContext channelHandlerContext, int i10, long j10) throws Http2Exception {
        Http2Stream http2StreamStream = this.connection.stream(i10);
        FullHttpMessage message = getMessage(http2StreamStream);
        if (message != null) {
            onRstStreamRead(http2StreamStream, message);
        }
        channelHandlerContext.fireExceptionCaught((Throwable) Http2Exception.streamError(i10, Http2Error.valueOf(j10), "HTTP/2 to HTTP layer caught stream reset", new Object[0]));
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onSettingsRead(ChannelHandlerContext channelHandlerContext, Http2Settings http2Settings) throws Http2Exception {
        if (this.propagateSettings) {
            channelHandlerContext.fireChannelRead((Object) http2Settings);
        }
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2Connection.Listener
    public void onStreamRemoved(Http2Stream http2Stream) {
        removeMessage(http2Stream, true);
    }

    public FullHttpMessage processHeadersBegin(ChannelHandlerContext channelHandlerContext, Http2Stream http2Stream, Http2Headers http2Headers, boolean z10, boolean z11, boolean z12) throws Http2Exception {
        boolean z13;
        FullHttpMessage message = getMessage(http2Stream);
        if (message == null) {
            message = newMessage(http2Stream, http2Headers, this.validateHttpHeaders, channelHandlerContext.alloc());
            z13 = true;
        } else {
            if (z11) {
                HttpConversionUtil.addHttp2ToHttpHeaders(http2Stream.id(), http2Headers, message, z12);
            } else {
                message = null;
            }
            z13 = false;
        }
        if (!this.sendDetector.mustSendImmediately(message)) {
            return message;
        }
        FullHttpMessage fullHttpMessageCopyIfNeeded = z10 ? null : this.sendDetector.copyIfNeeded(channelHandlerContext.alloc(), message);
        fireChannelRead(channelHandlerContext, message, z13, http2Stream);
        return fullHttpMessageCopyIfNeeded;
    }

    public final void putMessage(Http2Stream http2Stream, FullHttpMessage fullHttpMessage) {
        FullHttpMessage fullHttpMessage2 = (FullHttpMessage) http2Stream.setProperty(this.messageKey, fullHttpMessage);
        if (fullHttpMessage2 == fullHttpMessage || fullHttpMessage2 == null) {
            return;
        }
        fullHttpMessage2.release();
    }

    public final void removeMessage(Http2Stream http2Stream, boolean z10) {
        FullHttpMessage fullHttpMessage = (FullHttpMessage) http2Stream.removeProperty(this.messageKey);
        if (!z10 || fullHttpMessage == null) {
            return;
        }
        fullHttpMessage.release();
    }

    @Override // io.netty.handler.codec.http2.Http2EventAdapter, io.netty.handler.codec.http2.Http2FrameListener
    public void onHeadersRead(ChannelHandlerContext channelHandlerContext, int i10, Http2Headers http2Headers, int i11, short s10, boolean z10, int i12, boolean z11) throws Http2Exception {
        Http2Stream http2StreamStream = this.connection.stream(i10);
        FullHttpMessage fullHttpMessageProcessHeadersBegin = processHeadersBegin(channelHandlerContext, http2StreamStream, http2Headers, z11, true, true);
        if (fullHttpMessageProcessHeadersBegin != null) {
            if (i11 != 0) {
                fullHttpMessageProcessHeadersBegin.headers().setInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), i11);
            }
            fullHttpMessageProcessHeadersBegin.headers().setShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), s10);
            processHeadersEnd(channelHandlerContext, http2StreamStream, fullHttpMessageProcessHeadersBegin, z11);
        }
    }

    public void onRstStreamRead(Http2Stream http2Stream, FullHttpMessage fullHttpMessage) {
        removeMessage(http2Stream, true);
    }
}
