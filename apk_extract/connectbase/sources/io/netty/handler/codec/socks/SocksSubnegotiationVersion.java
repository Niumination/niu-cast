package io.netty.handler.codec.socks;

/* JADX INFO: loaded from: classes3.dex */
public enum SocksSubnegotiationVersion {
    AUTH_PASSWORD((byte) 1),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f8328b;

    SocksSubnegotiationVersion(byte b10) {
        this.f8328b = b10;
    }

    @Deprecated
    public static SocksSubnegotiationVersion fromByte(byte b10) {
        return valueOf(b10);
    }

    public byte byteValue() {
        return this.f8328b;
    }

    public static SocksSubnegotiationVersion valueOf(byte b10) {
        for (SocksSubnegotiationVersion socksSubnegotiationVersion : values()) {
            if (socksSubnegotiationVersion.f8328b == b10) {
                return socksSubnegotiationVersion;
            }
        }
        return UNKNOWN;
    }
}
