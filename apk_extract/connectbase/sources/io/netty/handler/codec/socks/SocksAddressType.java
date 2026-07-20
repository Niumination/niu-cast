package io.netty.handler.codec.socks;

/* JADX INFO: loaded from: classes3.dex */
public enum SocksAddressType {
    IPv4((byte) 1),
    DOMAIN((byte) 3),
    IPv6((byte) 4),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f8322b;

    SocksAddressType(byte b10) {
        this.f8322b = b10;
    }

    @Deprecated
    public static SocksAddressType fromByte(byte b10) {
        return valueOf(b10);
    }

    public byte byteValue() {
        return this.f8322b;
    }

    public static SocksAddressType valueOf(byte b10) {
        for (SocksAddressType socksAddressType : values()) {
            if (socksAddressType.f8322b == b10) {
                return socksAddressType;
            }
        }
        return UNKNOWN;
    }
}
