package io.netty.handler.codec.socks;

import io.netty.buffer.ByteBuf;

/* JADX INFO: loaded from: classes3.dex */
public final class UnknownSocksResponse extends SocksResponse {
    public UnknownSocksResponse() {
        super(SocksResponseType.UNKNOWN);
    }

    @Override // io.netty.handler.codec.socks.SocksMessage
    public void encodeAsByteBuf(ByteBuf byteBuf) {
    }
}
