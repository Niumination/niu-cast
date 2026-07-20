package io.netty.handler.codec.spdy;

/* JADX INFO: loaded from: classes3.dex */
public interface SpdyStreamFrame extends SpdyFrame {
    boolean isLast();

    SpdyStreamFrame setLast(boolean z10);

    SpdyStreamFrame setStreamId(int i10);

    int streamId();
}
