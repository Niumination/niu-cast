package io.netty.handler.codec.spdy;

/* JADX INFO: loaded from: classes3.dex */
public interface SpdyRstStreamFrame extends SpdyStreamFrame {
    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdyRstStreamFrame setLast(boolean z10);

    SpdyRstStreamFrame setStatus(SpdyStreamStatus spdyStreamStatus);

    @Override // io.netty.handler.codec.spdy.SpdyStreamFrame, io.netty.handler.codec.spdy.SpdyDataFrame
    SpdyRstStreamFrame setStreamId(int i10);

    SpdyStreamStatus status();
}
