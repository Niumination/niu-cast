package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2StreamFrame extends Http2Frame {
    Http2FrameStream stream();

    Http2StreamFrame stream(Http2FrameStream http2FrameStream);
}
