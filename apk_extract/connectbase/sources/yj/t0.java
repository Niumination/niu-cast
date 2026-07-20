package yj;

import io.netty.handler.ssl.SslContext;

/* JADX INFO: loaded from: classes2.dex */
@vj.e0("There is no plan to make this API stable, given transport API instability")
public final class t0 {
    public static vj.g a(SslContext sslContext) {
        c1.h0.e(sslContext.isClient(), "Server SSL context can not be used for client channel");
        o.e(sslContext.applicationProtocolNegotiator());
        return new f0(z0.s(sslContext));
    }
}
