package vj;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes2.dex */
public final class n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @e0("https://github.com/grpc/grpc-java/issues/1710")
    public static final vj.a.c<SocketAddress> f17193a = new vj.a.c<>("io.grpc.Grpc.TRANSPORT_ATTR_REMOTE_ADDR");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @e0("https://github.com/grpc/grpc-java/issues/1710")
    public static final vj.a.c<SocketAddress> f17194b = new vj.a.c<>("io.grpc.Grpc.TRANSPORT_ATTR_LOCAL_ADDR");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @e0("https://github.com/grpc/grpc-java/issues/1710")
    public static final vj.a.c<SSLSession> f17195c = new vj.a.c<>("io.grpc.Grpc.TRANSPORT_ATTR_SSL_SESSION");

    @e0("https://github.com/grpc/grpc-java/issues/4972")
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface a {
    }

    public static String a(String str, int i10) {
        try {
            return new URI(null, null, str, i10, null, null, null).getAuthority();
        } catch (URISyntaxException e10) {
            throw new IllegalArgumentException("Invalid host or port: " + str + " " + i10, e10);
        }
    }

    public static s1<?> b(String str, g gVar) {
        return u1.c().e(str, gVar);
    }

    public static s1<?> c(String str, int i10, g gVar) {
        return b(a(str, i10), gVar);
    }

    public static j2<?> d(int i10, n2 n2Var) {
        return s2.c().e(i10, n2Var);
    }
}
