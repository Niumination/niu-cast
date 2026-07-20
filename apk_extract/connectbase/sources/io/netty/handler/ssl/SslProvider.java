package io.netty.handler.ssl;

import java.security.Provider;

/* JADX INFO: loaded from: classes3.dex */
public enum SslProvider {
    JDK,
    OPENSSL,
    OPENSSL_REFCNT;

    /* JADX INFO: renamed from: io.netty.handler.ssl.SslProvider$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$SslProvider;

        static {
            int[] iArr = new int[SslProvider.values().length];
            $SwitchMap$io$netty$handler$ssl$SslProvider = iArr;
            try {
                iArr[SslProvider.JDK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$SslProvider[SslProvider.OPENSSL_REFCNT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static boolean isAlpnSupported(SslProvider sslProvider) {
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i10 == 1) {
            return JdkAlpnApplicationProtocolNegotiator.isAlpnSupported();
        }
        if (i10 == 2 || i10 == 3) {
            return OpenSsl.isAlpnSupported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isOptionSupported(SslProvider sslProvider, SslContextOption<?> sslContextOption) {
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 == 2 || i10 == 3) {
            return OpenSsl.isOptionSupported(sslContextOption);
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isTlsv13EnabledByDefault(SslProvider sslProvider, Provider provider) {
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i10 == 1) {
            return SslUtils.isTLSv13EnabledByJDK(provider);
        }
        if (i10 == 2 || i10 == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider) {
        return isTlsv13Supported(sslProvider, null);
    }

    public static boolean isTlsv13Supported(SslProvider sslProvider, Provider provider) {
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProvider.ordinal()];
        if (i10 == 1) {
            return SslUtils.isTLSv13SupportedByJDK(provider);
        }
        if (i10 == 2 || i10 == 3) {
            return OpenSsl.isTlsv13Supported();
        }
        throw new Error("Unknown SslProvider: " + sslProvider);
    }
}
