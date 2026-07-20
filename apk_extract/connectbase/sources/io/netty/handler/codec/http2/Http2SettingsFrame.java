package io.netty.handler.codec.http2;

/* JADX INFO: loaded from: classes3.dex */
public interface Http2SettingsFrame extends Http2Frame {
    @Override // io.netty.handler.codec.http2.Http2Frame
    String name();

    Http2Settings settings();
}
