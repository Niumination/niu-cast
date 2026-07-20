package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.EmptyHttpHeaders;
import io.netty.handler.codec.http.FullHttpMessage;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMessage;
import io.netty.handler.codec.http.HttpScheme;
import io.netty.handler.codec.http.LastHttpContent;
import io.netty.util.ReferenceCountUtil;

/* JADX INFO: loaded from: classes3.dex */
public class HttpToHttp2ConnectionHandler extends Http2ConnectionHandler {
    private int currentStreamId;
    private HttpScheme httpScheme;
    private final boolean validateHeaders;

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z10) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings);
        this.validateHeaders = z10;
    }

    private int getStreamId(HttpHeaders httpHeaders) throws Exception {
        return httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_ID.text(), connection().local().incrementAndGetNextStreamId());
    }

    private static void writeHeaders(ChannelHandlerContext channelHandlerContext, Http2ConnectionEncoder http2ConnectionEncoder, int i10, HttpHeaders httpHeaders, Http2Headers http2Headers, boolean z10, Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator) {
        http2ConnectionEncoder.writeHeaders(channelHandlerContext, i10, http2Headers, httpHeaders.getInt(HttpConversionUtil.ExtensionHeaderNames.STREAM_DEPENDENCY_ID.text(), 0), httpHeaders.getShort(HttpConversionUtil.ExtensionHeaderNames.STREAM_WEIGHT.text(), (short) 16), false, 0, z10, simpleChannelPromiseAggregator.newPromise());
    }

    /* JADX WARN: Code duplicated, block: B:48:0x00da A[DONT_GENERATE] */
    @Override // io.netty.handler.codec.http2.Http2ConnectionHandler, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) {
        boolean z10;
        boolean z11;
        HttpHeaders httpHeaders;
        Http2Headers http2Headers;
        boolean z12;
        if (!(obj instanceof HttpMessage) && !(obj instanceof HttpContent)) {
            channelHandlerContext.write(obj, channelPromise);
            return;
        }
        Http2CodecUtil.SimpleChannelPromiseAggregator simpleChannelPromiseAggregator = new Http2CodecUtil.SimpleChannelPromiseAggregator(channelPromise, channelHandlerContext.channel(), channelHandlerContext.executor());
        boolean z13 = true;
        try {
            Http2ConnectionEncoder http2ConnectionEncoderEncoder = encoder();
            z10 = false;
            if (obj instanceof HttpMessage) {
                HttpMessage httpMessage = (HttpMessage) obj;
                this.currentStreamId = getStreamId(httpMessage.headers());
                if (this.httpScheme != null) {
                    HttpHeaders httpHeadersHeaders = httpMessage.headers();
                    HttpConversionUtil.ExtensionHeaderNames extensionHeaderNames = HttpConversionUtil.ExtensionHeaderNames.SCHEME;
                    if (!httpHeadersHeaders.contains(extensionHeaderNames.text())) {
                        httpMessage.headers().set(extensionHeaderNames.text(), this.httpScheme.name());
                    }
                }
                Http2Headers http2Headers2 = HttpConversionUtil.toHttp2Headers(httpMessage, this.validateHeaders);
                z11 = (obj instanceof FullHttpMessage) && !((FullHttpMessage) obj).content().isReadable();
                writeHeaders(channelHandlerContext, http2ConnectionEncoderEncoder, this.currentStreamId, httpMessage.headers(), http2Headers2, z11, simpleChannelPromiseAggregator);
            } else {
                z11 = false;
            }
            if (!z11 && (obj instanceof HttpContent)) {
                EmptyHttpHeaders emptyHttpHeaders = EmptyHttpHeaders.INSTANCE;
                EmptyHttp2Headers emptyHttp2Headers = EmptyHttp2Headers.INSTANCE;
                if (obj instanceof LastHttpContent) {
                    HttpHeaders httpHeadersTrailingHeaders = ((LastHttpContent) obj).trailingHeaders();
                    httpHeaders = httpHeadersTrailingHeaders;
                    http2Headers = HttpConversionUtil.toHttp2Headers(httpHeadersTrailingHeaders, this.validateHeaders);
                    z12 = true;
                } else {
                    httpHeaders = emptyHttpHeaders;
                    http2Headers = emptyHttp2Headers;
                    z12 = false;
                }
                http2ConnectionEncoderEncoder.writeData(channelHandlerContext, this.currentStreamId, ((HttpContent) obj).content(), 0, z12 && httpHeaders.isEmpty(), simpleChannelPromiseAggregator.newPromise());
                try {
                    if (!httpHeaders.isEmpty()) {
                        writeHeaders(channelHandlerContext, http2ConnectionEncoderEncoder, this.currentStreamId, httpHeaders, http2Headers, true, simpleChannelPromiseAggregator);
                    }
                    z13 = false;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        onError(channelHandlerContext, true, th);
                        simpleChannelPromiseAggregator.setFailure(th);
                    } finally {
                        if (z10) {
                            ReferenceCountUtil.release(obj);
                        }
                        simpleChannelPromiseAggregator.doneAllocatingPromises();
                    }
                }
            }
            if (z13) {
            }
        } catch (Throwable th3) {
            th = th3;
            z10 = true;
        }
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z10, boolean z11) {
        this(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z10, z11, null);
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z10, boolean z11, HttpScheme httpScheme) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z11);
        this.validateHeaders = z10;
        this.httpScheme = httpScheme;
    }

    public HttpToHttp2ConnectionHandler(Http2ConnectionDecoder http2ConnectionDecoder, Http2ConnectionEncoder http2ConnectionEncoder, Http2Settings http2Settings, boolean z10, boolean z11, boolean z12, HttpScheme httpScheme) {
        super(http2ConnectionDecoder, http2ConnectionEncoder, http2Settings, z11, z12);
        this.validateHeaders = z10;
        this.httpScheme = httpScheme;
    }
}
