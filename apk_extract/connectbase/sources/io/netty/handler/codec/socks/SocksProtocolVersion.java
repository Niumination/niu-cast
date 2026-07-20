package io.netty.handler.codec.socks;

/* JADX INFO: loaded from: classes3.dex */
public enum SocksProtocolVersion {
    SOCKS4a((byte) 4),
    SOCKS5((byte) 5),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f8327b;

    SocksProtocolVersion(byte b10) {
        this.f8327b = b10;
    }

    @Deprecated
    public static SocksProtocolVersion fromByte(byte b10) {
        return valueOf(b10);
    }

    public byte byteValue() {
        return this.f8327b;
    }

    public static SocksProtocolVersion valueOf(byte b10) {
        for (SocksProtocolVersion socksProtocolVersion : values()) {
            if (socksProtocolVersion.f8327b == b10) {
                return socksProtocolVersion;
            }
        }
        return UNKNOWN;
    }
}
