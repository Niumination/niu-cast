package yj;

import io.netty.handler.codec.http2.Http2SecurityUtil;
import io.netty.handler.ssl.ApplicationProtocolConfig;
import io.netty.handler.ssl.ApplicationProtocolNegotiator;
import io.netty.handler.ssl.OpenSsl;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.SslProtocols;
import io.netty.handler.ssl.SslProvider;
import io.netty.handler.ssl.SupportedCipherSuiteFilter;
import java.io.File;
import java.io.InputStream;
import java.security.Provider;
import java.security.Security;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
@vj.e0("https://github.com/grpc/grpc-java/issues/1784")
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f21177a = Logger.getLogger(o.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f21178b = "h2";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f21179c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ApplicationProtocolConfig f21180d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ApplicationProtocolConfig f21181e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ApplicationProtocolConfig f21182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f21183g = "SunJSSE";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f21184h = "IBMJSSE2";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f21185i = "OpenJSSE";

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21186a;

        static {
            int[] iArr = new int[SslProvider.values().length];
            f21186a = iArr;
            try {
                iArr[SslProvider.JDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21186a[SslProvider.OPENSSL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Provider f21187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Throwable f21188b;

        static {
            Provider providerC = null;
            try {
                th = null;
                providerC = wj.z.c();
            } catch (Throwable th2) {
                th = th2;
            }
            f21187a = providerC;
            f21188b = th;
        }
    }

    static {
        List<String> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList("h2"));
        f21179c = listUnmodifiableList;
        ApplicationProtocolConfig.Protocol protocol = ApplicationProtocolConfig.Protocol.ALPN;
        ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior = ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE;
        ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        f21180d = new ApplicationProtocolConfig(protocol, selectorFailureBehavior, selectedListenerFailureBehavior, (Iterable<String>) listUnmodifiableList);
        f21181e = new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN, selectorFailureBehavior, selectedListenerFailureBehavior, (Iterable<String>) listUnmodifiableList);
        f21182f = new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN_AND_ALPN, selectorFailureBehavior, selectedListenerFailureBehavior, (Iterable<String>) listUnmodifiableList);
    }

    @t1.a
    public static SslContextBuilder a(SslContextBuilder sslContextBuilder) {
        return b(sslContextBuilder, d());
    }

    @t1.a
    @vj.e0("https://github.com/grpc/grpc-java/issues/1784")
    public static SslContextBuilder b(SslContextBuilder sslContextBuilder, SslProvider sslProvider) {
        int i10 = a.f21186a[sslProvider.ordinal()];
        if (i10 == 1) {
            Provider providerF = f();
            if (providerF != null) {
                return c(sslContextBuilder, providerF);
            }
            throw new IllegalArgumentException("Could not find Jetty NPN/ALPN or Conscrypt as installed JDK providers");
        }
        if (i10 == 2) {
            return sslContextBuilder.sslProvider(SslProvider.OPENSSL).ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE).applicationProtocolConfig(OpenSsl.isAlpnSupported() ? f21182f : f21181e);
        }
        throw new IllegalArgumentException("Unsupported provider: " + sslProvider);
    }

    @t1.a
    public static SslContextBuilder c(SslContextBuilder sslContextBuilder, Provider provider) {
        ApplicationProtocolConfig applicationProtocolConfig;
        if (f21183g.equals(provider.getName())) {
            if (b0.e()) {
                applicationProtocolConfig = f21180d;
            } else if (b0.f()) {
                applicationProtocolConfig = f21181e;
            } else {
                if (!b0.d()) {
                    throw new IllegalArgumentException(provider.getName() + " selected, but Java 9+ and Jetty NPN/ALPN unavailable");
                }
                applicationProtocolConfig = f21180d;
            }
        } else if (f21184h.equals(provider.getName()) || f21185i.equals(provider.getName())) {
            if (!b0.d()) {
                throw new IllegalArgumentException(provider.getName() + " selected, but Java 9+ ALPN unavailable");
            }
            applicationProtocolConfig = f21180d;
        } else {
            if (!wj.z.a(provider)) {
                throw new IllegalArgumentException("Unknown provider; can't configure: " + provider);
            }
            applicationProtocolConfig = f21180d;
            sslContextBuilder.protocols(SslProtocols.TLS_v1_2);
        }
        return sslContextBuilder.sslProvider(SslProvider.JDK).ciphers(Http2SecurityUtil.CIPHERS, SupportedCipherSuiteFilter.INSTANCE).applicationProtocolConfig(applicationProtocolConfig).sslContextProvider(provider);
    }

    public static SslProvider d() {
        if (OpenSsl.isAvailable()) {
            f21177a.log(Level.FINE, "Selecting OPENSSL");
            return SslProvider.OPENSSL;
        }
        Provider providerF = f();
        if (providerF != null) {
            f21177a.log(Level.FINE, "Selecting JDK with provider {0}", providerF);
            return SslProvider.JDK;
        }
        Logger logger = f21177a;
        Level level = Level.INFO;
        logger.log(level, "Java 9 ALPN API unavailable (this may be normal)");
        logger.log(level, "netty-tcnative unavailable (this may be normal)", OpenSsl.unavailabilityCause());
        logger.log(level, "Conscrypt not found (this may be normal)", b.f21188b);
        logger.log(level, "Jetty ALPN unavailable (this may be normal)", b0.b());
        throw new IllegalStateException("Could not find TLS ALPN provider; no working netty-tcnative, Conscrypt, or Jetty NPN/ALPN available");
    }

    public static void e(ApplicationProtocolNegotiator applicationProtocolNegotiator) {
        boolean z10 = false;
        c1.h0.e(applicationProtocolNegotiator != null, "ALPN must be configured");
        if (applicationProtocolNegotiator.protocols() != null && !applicationProtocolNegotiator.protocols().isEmpty()) {
            z10 = true;
        }
        c1.h0.e(z10, "ALPN must be enabled and list HTTP/2 as a supported protocol.");
        c1.h0.y(applicationProtocolNegotiator.protocols().contains("h2"), "This ALPN config does not support HTTP/2. Expected %s, but got %s'.", "h2", applicationProtocolNegotiator.protocols());
    }

    public static Provider f() {
        for (Provider provider : Security.getProviders("SSLContext.TLS")) {
            if (f21183g.equals(provider.getName())) {
                if (b0.e() || b0.f() || b0.d()) {
                    return provider;
                }
            } else if (f21184h.equals(provider.getName()) || f21185i.equals(provider.getName())) {
                if (b0.d()) {
                    return provider;
                }
            } else if (wj.z.a(provider)) {
                return provider;
            }
        }
        Provider provider2 = b.f21187a;
        if (provider2 != null) {
            return provider2;
        }
        return null;
    }

    public static SslContextBuilder g() {
        return a(SslContextBuilder.forClient());
    }

    public static SslContextBuilder h(File file, File file2) {
        return a(SslContextBuilder.forServer(file, file2));
    }

    public static SslContextBuilder i(File file, File file2, String str) {
        return a(SslContextBuilder.forServer(file, file2, str));
    }

    public static SslContextBuilder j(InputStream inputStream, InputStream inputStream2) {
        return a(SslContextBuilder.forServer(inputStream, inputStream2));
    }

    public static SslContextBuilder k(InputStream inputStream, InputStream inputStream2, String str) {
        return a(SslContextBuilder.forServer(inputStream, inputStream2, str));
    }
}
