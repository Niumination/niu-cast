package yj;

import io.netty.handler.ssl.SslContext;
import vj.n2;

/* JADX INFO: loaded from: classes2.dex */
@vj.e0("There is no plan to make this API stable, given transport API instability")
public final class u0 {
    public static n2 a(SslContext sslContext) {
        c1.h0.e(sslContext.isServer(), "Client SSL context can not be used for server");
        o.e(sslContext.applicationProtocolNegotiator());
        return new n0(z0.p(sslContext));
    }
}
