package io.netty.handler.codec.socks;

import ik.y0;
import io.netty.buffer.ByteBuf;
import io.netty.util.internal.ObjectUtil;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SocksMessage {
    private final SocksProtocolVersion protocolVersion = SocksProtocolVersion.SOCKS5;
    private final SocksMessageType type;

    public SocksMessage(SocksMessageType socksMessageType) {
        this.type = (SocksMessageType) ObjectUtil.checkNotNull(socksMessageType, y0.a.f8215h);
    }

    @Deprecated
    public abstract void encodeAsByteBuf(ByteBuf byteBuf);

    public SocksProtocolVersion protocolVersion() {
        return this.protocolVersion;
    }

    public SocksMessageType type() {
        return this.type;
    }
}
