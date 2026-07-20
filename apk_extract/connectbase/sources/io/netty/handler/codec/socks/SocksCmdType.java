package io.netty.handler.codec.socks;

/* JADX INFO: loaded from: classes3.dex */
public enum SocksCmdType {
    CONNECT((byte) 1),
    BIND((byte) 2),
    UDP((byte) 3),
    UNKNOWN((byte) -1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f8326b;

    SocksCmdType(byte b10) {
        this.f8326b = b10;
    }

    @Deprecated
    public static SocksCmdType fromByte(byte b10) {
        return valueOf(b10);
    }

    public byte byteValue() {
        return this.f8326b;
    }

    public static SocksCmdType valueOf(byte b10) {
        for (SocksCmdType socksCmdType : values()) {
            if (socksCmdType.f8326b == b10) {
                return socksCmdType;
            }
        }
        return UNKNOWN;
    }
}
