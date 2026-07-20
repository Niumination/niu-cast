package io.netty.handler.codec.http.cookie;

/* JADX INFO: loaded from: classes3.dex */
public interface Cookie extends Comparable<Cookie> {
    public static final long UNDEFINED_MAX_AGE = Long.MIN_VALUE;

    String domain();

    boolean isHttpOnly();

    boolean isSecure();

    long maxAge();

    String name();

    String path();

    void setDomain(String str);

    void setHttpOnly(boolean z10);

    void setMaxAge(long j10);

    void setPath(String str);

    void setSecure(boolean z10);

    void setValue(String str);

    void setWrap(boolean z10);

    String value();

    boolean wrap();
}
