package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public final class InboundHttp2ToHttpAdapterBuilder extends AbstractInboundHttp2ToHttpAdapterBuilder<InboundHttp2ToHttpAdapter, InboundHttp2ToHttpAdapterBuilder> {
    public InboundHttp2ToHttpAdapterBuilder(Http2Connection http2Connection) {
        super(http2Connection);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapter build() {
        return super.build();
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapter build(Http2Connection http2Connection, int i10, boolean z10, boolean z11) throws Exception {
        return new InboundHttp2ToHttpAdapter(http2Connection, i10, z10, z11);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder maxContentLength(int i10) {
        return (InboundHttp2ToHttpAdapterBuilder) super.maxContentLength(i10);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder propagateSettings(boolean z10) {
        return (InboundHttp2ToHttpAdapterBuilder) super.propagateSettings(z10);
    }

    @Override // io.netty.handler.codec.http2.AbstractInboundHttp2ToHttpAdapterBuilder
    public InboundHttp2ToHttpAdapterBuilder validateHttpHeaders(boolean z10) {
        return (InboundHttp2ToHttpAdapterBuilder) super.validateHttpHeaders(z10);
    }
}
