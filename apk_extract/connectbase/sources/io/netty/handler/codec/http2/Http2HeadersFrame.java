package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2HeadersFrame extends Http2StreamFrame {
    Http2Headers headers();

    boolean isEndStream();

    int padding();
}
