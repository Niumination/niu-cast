package io.netty.handler.codec.http;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class ClientCookieEncoder {
    private ClientCookieEncoder() {
    }

    @Deprecated
    public static String encode(String str, String str2) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(str, str2);
    }

    @Deprecated
    public static String encode(Cookie cookie) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(cookie);
    }

    @Deprecated
    public static String encode(Cookie... cookieArr) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(cookieArr);
    }

    @Deprecated
    public static String encode(Iterable<Cookie> iterable) {
        return io.netty.handler.codec.http.cookie.ClientCookieEncoder.LAX.encode(iterable);
    }
}
