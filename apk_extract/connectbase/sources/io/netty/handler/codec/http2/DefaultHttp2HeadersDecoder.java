package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultHttp2HeadersDecoder implements Http2HeadersDecoder, Http2HeadersDecoder.Configuration {
    private static final float HEADERS_COUNT_WEIGHT_HISTORICAL = 0.8f;
    private static final float HEADERS_COUNT_WEIGHT_NEW = 0.2f;
    private float headerArraySizeAccumulator;
    private final HpackDecoder hpackDecoder;
    private long maxHeaderListSizeGoAway;
    private final boolean validateHeaderValues;
    private final boolean validateHeaders;

    public DefaultHttp2HeadersDecoder() {
        this(true);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2HeadersDecoder.Configuration configuration() {
        return this;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder
    public Http2Headers decodeHeaders(int i10, ByteBuf byteBuf) throws Http2Exception {
        try {
            Http2Headers http2HeadersNewHeaders = newHeaders();
            this.hpackDecoder.decode(i10, byteBuf, http2HeadersNewHeaders, this.validateHeaders);
            this.headerArraySizeAccumulator = (this.headerArraySizeAccumulator * 0.8f) + (http2HeadersNewHeaders.size() * 0.2f);
            return http2HeadersNewHeaders;
        } catch (Http2Exception e10) {
            throw e10;
        } catch (Throwable th2) {
            throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, th2, "Error decoding headers: %s", th2.getMessage());
        }
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public void maxHeaderListSize(long j10, long j11) throws Http2Exception {
        if (j11 < j10 || j11 < 0) {
            throw Http2Exception.connectionError(Http2Error.INTERNAL_ERROR, "Header List Size GO_AWAY %d must be non-negative and >= %d", Long.valueOf(j11), Long.valueOf(j10));
        }
        this.hpackDecoder.setMaxHeaderListSize(j10);
        this.maxHeaderListSizeGoAway = j11;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderListSizeGoAway() {
        return this.maxHeaderListSizeGoAway;
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public void maxHeaderTableSize(long j10) throws Http2Exception {
        this.hpackDecoder.setMaxHeaderTableSize(j10);
    }

    public Http2Headers newHeaders() {
        return new DefaultHttp2Headers(this.validateHeaders, this.validateHeaderValues, (int) this.headerArraySizeAccumulator);
    }

    public final int numberOfHeadersGuess() {
        return (int) this.headerArraySizeAccumulator;
    }

    public boolean validateHeaderValues() {
        return this.validateHeaderValues;
    }

    public final boolean validateHeaders() {
        return this.validateHeaders;
    }

    public DefaultHttp2HeadersDecoder(boolean z10) {
        this(z10, 8192L);
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderTableSize() {
        return this.hpackDecoder.getMaxHeaderTableSize();
    }

    public DefaultHttp2HeadersDecoder(boolean z10, boolean z11) {
        this(z10, z11, 8192L);
    }

    public DefaultHttp2HeadersDecoder(boolean z10, long j10) {
        this(z10, false, new HpackDecoder(j10));
    }

    public DefaultHttp2HeadersDecoder(boolean z10, boolean z11, long j10) {
        this(z10, z11, new HpackDecoder(j10));
    }

    public DefaultHttp2HeadersDecoder(boolean z10, long j10, @Deprecated int i10) {
        this(z10, false, new HpackDecoder(j10));
    }

    @Override // io.netty.handler.codec.http2.Http2HeadersDecoder.Configuration
    public long maxHeaderListSize() {
        return this.hpackDecoder.getMaxHeaderListSize();
    }

    public DefaultHttp2HeadersDecoder(boolean z10, boolean z11, HpackDecoder hpackDecoder) {
        this.headerArraySizeAccumulator = 8.0f;
        this.hpackDecoder = (HpackDecoder) ObjectUtil.checkNotNull(hpackDecoder, "hpackDecoder");
        this.validateHeaders = z10;
        this.validateHeaderValues = z11;
        this.maxHeaderListSizeGoAway = Http2CodecUtil.calculateMaxHeaderListSizeGoAway(hpackDecoder.getMaxHeaderListSize());
    }
}
