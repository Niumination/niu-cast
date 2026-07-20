package io.netty.handler.codec.http2;

import io.netty.channel.ChannelHandlerContext;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2FlowController {
    void channelHandlerContext(ChannelHandlerContext channelHandlerContext) throws Http2Exception;

    void incrementWindowSize(Http2Stream http2Stream, int i10) throws Http2Exception;

    int initialWindowSize();

    void initialWindowSize(int i10) throws Http2Exception;

    int windowSize(Http2Stream http2Stream);
}
