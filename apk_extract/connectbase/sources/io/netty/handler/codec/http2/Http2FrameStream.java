package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2FrameStream {
    int id();

    Http2Stream.State state();
}
