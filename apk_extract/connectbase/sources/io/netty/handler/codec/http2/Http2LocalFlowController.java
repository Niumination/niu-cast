package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2LocalFlowController extends Http2FlowController {
    boolean consumeBytes(Http2Stream http2Stream, int i10) throws Http2Exception;

    Http2LocalFlowController frameWriter(Http2FrameWriter http2FrameWriter);

    int initialWindowSize(Http2Stream http2Stream);

    void receiveFlowControlledFrame(Http2Stream http2Stream, ByteBuf byteBuf, int i10, boolean z10) throws Http2Exception;

    int unconsumedBytes(Http2Stream http2Stream);
}
