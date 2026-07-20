package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.EncoderException;
import io.netty.handler.codec.MessageToMessageCodec;
import io.netty.handler.codec.http.DefaultHttpContent;
import io.netty.handler.codec.http.DefaultLastHttpContent;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpObject;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.HttpStatusClass;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
@ChannelHandler.Sharable
public class Http2StreamFrameToHttpObjectCodec extends MessageToMessageCodec<Http2StreamFrame, HttpObject> {
    private static final AttributeKey<HttpScheme> SCHEME_ATTR_KEY = AttributeKey.valueOf(HttpScheme.class, "STREAMFRAMECODEC_SCHEME");
    private final boolean isServer;
    private final boolean validateHeaders;

    public Http2StreamFrameToHttpObjectCodec(boolean z10, boolean z11) {
        this.isServer = z10;
        this.validateHeaders = z11;
    }

    private static Channel connectionChannel(ChannelHandlerContext channelHandlerContext) {
        Channel channel = channelHandlerContext.channel();
        return channel instanceof Http2StreamChannel ? channel.parent() : channel;
    }

    private static HttpScheme connectionScheme(ChannelHandlerContext channelHandlerContext) {
        HttpScheme httpScheme = connectionSchemeAttribute(channelHandlerContext).get();
        return httpScheme == null ? HttpScheme.HTTP : httpScheme;
    }

    private static Attribute<HttpScheme> connectionSchemeAttribute(ChannelHandlerContext channelHandlerContext) {
        return connectionChannel(channelHandlerContext).attr(SCHEME_ATTR_KEY);
    }

    private void encodeLastContent(LastHttpContent lastHttpContent, List<Object> list) {
        boolean z10 = !(lastHttpContent instanceof FullHttpMessage) && lastHttpContent.trailingHeaders().isEmpty();
        if (lastHttpContent.content().isReadable() || z10) {
            list.add(new DefaultHttp2DataFrame(lastHttpContent.content().retain(), lastHttpContent.trailingHeaders().isEmpty()));
        }
        if (lastHttpContent.trailingHeaders().isEmpty()) {
            return;
        }
        list.add(new DefaultHttp2HeadersFrame(HttpConversionUtil.toHttp2Headers(lastHttpContent.trailingHeaders(), this.validateHeaders), true));
    }

    private static boolean isContentAlwaysEmpty(CharSequence charSequence) {
        if (charSequence.length() != 3) {
            return false;
        }
        char cCharAt = charSequence.charAt(0);
        return (cCharAt == '2' || cCharAt == '3') && charSequence.charAt(1) == '0' && charSequence.charAt(2) == '4';
    }

    private static boolean isInformationalResponseHeaderFrame(CharSequence charSequence) {
        if (charSequence.length() != 3) {
            return false;
        }
        char cCharAt = charSequence.charAt(0);
        char cCharAt2 = charSequence.charAt(1);
        char cCharAt3 = charSequence.charAt(2);
        return cCharAt == '1' && cCharAt2 >= '0' && cCharAt2 <= '9' && cCharAt3 >= '0' && cCharAt3 <= '9' && cCharAt3 != '1';
    }

    private FullHttpMessage newFullMessage(int i10, Http2Headers http2Headers, ByteBufAllocator byteBufAllocator) throws Http2Exception {
        return this.isServer ? HttpConversionUtil.toFullHttpRequest(i10, http2Headers, byteBufAllocator, this.validateHeaders) : HttpConversionUtil.toFullHttpResponse(i10, http2Headers, byteBufAllocator, this.validateHeaders);
    }

    private HttpMessage newMessage(int i10, Http2Headers http2Headers) throws Http2Exception {
        return this.isServer ? HttpConversionUtil.toHttpRequest(i10, http2Headers, this.validateHeaders) : HttpConversionUtil.toHttpResponse(i10, http2Headers, this.validateHeaders);
    }

    private Http2Headers toHttp2Headers(ChannelHandlerContext channelHandlerContext, HttpMessage httpMessage) {
        if (httpMessage instanceof HttpRequest) {
            httpMessage.headers().set(HttpConversionUtil.ExtensionHeaderNames.SCHEME.text(), connectionScheme(channelHandlerContext));
        }
        return HttpConversionUtil.toHttp2Headers(httpMessage, this.validateHeaders);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public boolean acceptInboundMessage(Object obj) throws Exception {
        return (obj instanceof Http2HeadersFrame) || (obj instanceof Http2DataFrame);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public /* bridge */ /* synthetic */ void decode(ChannelHandlerContext channelHandlerContext, Http2StreamFrame http2StreamFrame, List list) throws Exception {
        decode2(channelHandlerContext, http2StreamFrame, (List<Object>) list);
    }

    @Override // io.netty.handler.codec.MessageToMessageCodec
    public /* bridge */ /* synthetic */ void encode(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List list) throws Exception {
        encode2(channelHandlerContext, httpObject, (List<Object>) list);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerAdded(channelHandlerContext);
        Attribute<HttpScheme> attributeConnectionSchemeAttribute = connectionSchemeAttribute(channelHandlerContext);
        if (attributeConnectionSchemeAttribute.get() == null) {
            attributeConnectionSchemeAttribute.set(isSsl(channelHandlerContext) ? HttpScheme.HTTPS : HttpScheme.HTTP);
        }
    }

    public boolean isSsl(ChannelHandlerContext channelHandlerContext) {
        return connectionChannel(channelHandlerContext).pipeline().get(SslHandler.class) != null;
    }

    /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
    public void decode2(ChannelHandlerContext channelHandlerContext, Http2StreamFrame http2StreamFrame, List<Object> list) throws Exception {
        if (!(http2StreamFrame instanceof Http2HeadersFrame)) {
            if (http2StreamFrame instanceof Http2DataFrame) {
                Http2DataFrame http2DataFrame = (Http2DataFrame) http2StreamFrame;
                if (http2DataFrame.isEndStream()) {
                    list.add(new DefaultLastHttpContent(http2DataFrame.content().retain(), this.validateHeaders));
                    return;
                } else {
                    list.add(new DefaultHttpContent(http2DataFrame.content().retain()));
                    return;
                }
            }
            return;
        }
        Http2HeadersFrame http2HeadersFrame = (Http2HeadersFrame) http2StreamFrame;
        Http2Headers http2HeadersHeaders = http2HeadersFrame.headers();
        Http2FrameStream http2FrameStreamStream = http2HeadersFrame.stream();
        int iId = http2FrameStreamStream == null ? 0 : http2FrameStreamStream.id();
        CharSequence charSequenceStatus = http2HeadersHeaders.status();
        if (charSequenceStatus != null && isInformationalResponseHeaderFrame(charSequenceStatus)) {
            list.add(newFullMessage(iId, http2HeadersHeaders, channelHandlerContext.alloc()));
            return;
        }
        if (!http2HeadersFrame.isEndStream()) {
            HttpMessage httpMessageNewMessage = newMessage(iId, http2HeadersHeaders);
            if ((charSequenceStatus == null || !isContentAlwaysEmpty(charSequenceStatus)) && !HttpUtil.isContentLengthSet(httpMessageNewMessage)) {
                httpMessageNewMessage.headers().add(HttpHeaderNames.TRANSFER_ENCODING, HttpHeaderValues.CHUNKED);
            }
            list.add(httpMessageNewMessage);
            return;
        }
        if (http2HeadersHeaders.method() != null || charSequenceStatus != null) {
            list.add(newFullMessage(iId, http2HeadersHeaders, channelHandlerContext.alloc()));
            return;
        }
        DefaultLastHttpContent defaultLastHttpContent = new DefaultLastHttpContent(Unpooled.EMPTY_BUFFER, this.validateHeaders);
        HttpConversionUtil.addHttp2ToHttpHeaders(iId, http2HeadersHeaders, defaultLastHttpContent.trailingHeaders(), HttpVersion.HTTP_1_1, true, true);
        list.add(defaultLastHttpContent);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x006c  */
    /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
    public void encode2(ChannelHandlerContext channelHandlerContext, HttpObject httpObject, List<Object> list) throws Exception {
        boolean z10;
        if (httpObject instanceof HttpResponse) {
            HttpResponse httpResponse = (HttpResponse) httpObject;
            HttpResponseStatus httpResponseStatusStatus = httpResponse.status();
            int iCode = httpResponseStatusStatus.code();
            if (httpResponseStatusStatus.codeClass() == HttpStatusClass.INFORMATIONAL && iCode != 101) {
                if (httpResponse instanceof FullHttpResponse) {
                    list.add(new DefaultHttp2HeadersFrame(toHttp2Headers(channelHandlerContext, httpResponse), false));
                    return;
                }
                throw new EncoderException(httpResponseStatusStatus + " must be a FullHttpResponse");
            }
        }
        if (httpObject instanceof HttpMessage) {
            Http2Headers http2Headers = toHttp2Headers(channelHandlerContext, (HttpMessage) httpObject);
            if (httpObject instanceof FullHttpMessage) {
                FullHttpMessage fullHttpMessage = (FullHttpMessage) httpObject;
                if (fullHttpMessage.content().isReadable() || !fullHttpMessage.trailingHeaders().isEmpty()) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            } else {
                z10 = false;
            }
            list.add(new DefaultHttp2HeadersFrame(http2Headers, z10));
        }
        if (httpObject instanceof LastHttpContent) {
            encodeLastContent((LastHttpContent) httpObject, list);
        } else if (httpObject instanceof HttpContent) {
            list.add(new DefaultHttp2DataFrame(((HttpContent) httpObject).content().retain(), false));
        }
    }

    public Http2StreamFrameToHttpObjectCodec(boolean z10) {
        this(z10, true);
    }
}
