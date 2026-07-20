package io.netty.handler.codec.socks;

/* JADX INFO: loaded from: classes3.dex */
public enum SocksAuthStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) -1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f8324b;

    SocksAuthStatus(byte b10) {
        this.f8324b = b10;
    }

    @Deprecated
    public static SocksAuthStatus fromByte(byte b10) {
        return valueOf(b10);
    }

    public byte byteValue() {
        return this.f8324b;
    }

    public static SocksAuthStatus valueOf(byte b10) {
        for (SocksAuthStatus socksAuthStatus : values()) {
            if (socksAuthStatus.f8324b == b10) {
                return socksAuthStatus;
            }
        }
        return FAILURE;
    }
}
