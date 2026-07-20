package io.netty.handler.codec.spdy;

/* JADX INFO: loaded from: classes3.dex */
public interface SpdyWindowUpdateFrame extends SpdyFrame {
    int deltaWindowSize();

    SpdyWindowUpdateFrame setDeltaWindowSize(int i10);

    SpdyWindowUpdateFrame setStreamId(int i10);

    int streamId();
}
