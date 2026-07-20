package io.netty.handler.codec.spdy;

/* JADX INFO: loaded from: classes3.dex */
public enum SpdyVersion {
    SPDY_3_1(3, 1);

    private final int minorVersion;
    private final int version;

    SpdyVersion(int i10, int i11) {
        this.version = i10;
        this.minorVersion = i11;
    }

    public int getMinorVersion() {
        return this.minorVersion;
    }

    public int getVersion() {
        return this.version;
    }
}
