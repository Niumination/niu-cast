package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2PingFrame extends Http2Frame {
    boolean ack();

    long content();
}
