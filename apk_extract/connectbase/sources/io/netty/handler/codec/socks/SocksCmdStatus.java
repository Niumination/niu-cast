package io.netty.handler.codec.socks;

/* JADX INFO: loaded from: classes3.dex */
public enum SocksCmdStatus {
    SUCCESS((byte) 0),
    FAILURE((byte) 1),
    FORBIDDEN((byte) 2),
    NETWORK_UNREACHABLE((byte) 3),
    HOST_UNREACHABLE((byte) 4),
    REFUSED((byte) 5),
    TTL_EXPIRED((byte) 6),
    COMMAND_NOT_SUPPORTED((byte) 7),
    ADDRESS_NOT_SUPPORTED((byte) 8),
    UNASSIGNED((byte) -1);


    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte f8325b;

    SocksCmdStatus(byte b10) {
        this.f8325b = b10;
    }

    @Deprecated
    public static SocksCmdStatus fromByte(byte b10) {
        return valueOf(b10);
    }

    public byte byteValue() {
        return this.f8325b;
    }

    public static SocksCmdStatus valueOf(byte b10) {
        for (SocksCmdStatus socksCmdStatus : values()) {
            if (socksCmdStatus.f8325b == b10) {
                return socksCmdStatus;
            }
        }
        return UNASSIGNED;
    }
}
