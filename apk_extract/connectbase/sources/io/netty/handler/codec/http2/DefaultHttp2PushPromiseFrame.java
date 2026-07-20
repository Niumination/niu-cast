package io.netty.handler.codec.http2;

import rs.f;
import u.a;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultHttp2PushPromiseFrame implements Http2PushPromiseFrame {
    private final Http2Headers http2Headers;
    private final int padding;
    private final int promisedStreamId;
    private Http2FrameStream pushStreamFrame;
    private Http2FrameStream streamFrame;

    public DefaultHttp2PushPromiseFrame(Http2Headers http2Headers) {
        this(http2Headers, 0);
    }

    @Override // io.netty.handler.codec.http2.Http2PushPromiseFrame
    public Http2Headers http2Headers() {
        return this.http2Headers;
    }

    @Override // io.netty.handler.codec.http2.Http2Frame
    public String name() {
        return "PUSH_PROMISE_FRAME";
    }

    @Override // io.netty.handler.codec.http2.Http2PushPromiseFrame
    public int padding() {
        return this.padding;
    }

    @Override // io.netty.handler.codec.http2.Http2PushPromiseFrame
    public int promisedStreamId() {
        Http2FrameStream http2FrameStream = this.pushStreamFrame;
        return http2FrameStream != null ? http2FrameStream.id() : this.promisedStreamId;
    }

    @Override // io.netty.handler.codec.http2.Http2PushPromiseFrame
    public Http2StreamFrame pushStream(Http2FrameStream http2FrameStream) {
        this.pushStreamFrame = http2FrameStream;
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DefaultHttp2PushPromiseFrame{pushStreamFrame=");
        sb2.append(this.pushStreamFrame);
        sb2.append(", http2Headers=");
        sb2.append(this.http2Headers);
        sb2.append(", streamFrame=");
        sb2.append(this.streamFrame);
        sb2.append(", padding=");
        return a.a(sb2, this.padding, f.f14860b);
    }

    public DefaultHttp2PushPromiseFrame(Http2Headers http2Headers, int i10) {
        this(http2Headers, i10, -1);
    }

    @Override // io.netty.handler.codec.http2.Http2PushPromiseFrame
    public Http2FrameStream pushStream() {
        return this.pushStreamFrame;
    }

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    public Http2PushPromiseFrame stream(Http2FrameStream http2FrameStream) {
        this.streamFrame = http2FrameStream;
        return this;
    }

    public DefaultHttp2PushPromiseFrame(Http2Headers http2Headers, int i10, int i11) {
        this.http2Headers = http2Headers;
        this.padding = i10;
        this.promisedStreamId = i11;
    }

    @Override // io.netty.handler.codec.http2.Http2StreamFrame
    public Http2FrameStream stream() {
        return this.streamFrame;
    }
}
