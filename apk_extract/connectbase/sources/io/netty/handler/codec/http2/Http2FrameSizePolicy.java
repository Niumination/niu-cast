package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2FrameSizePolicy {
    int maxFrameSize();

    void maxFrameSize(int i10) throws Http2Exception;
}
