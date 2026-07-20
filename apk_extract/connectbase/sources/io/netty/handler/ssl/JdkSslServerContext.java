package io.netty.handler.ssl;

import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import java.io.File;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.cert.X509Certificate;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class JdkSslServerContext extends JdkSslContext {
    @Deprecated
    public JdkSslServerContext(File file, File file2) throws SSLException {
        this(null, file, file2, null, null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L, null);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0032 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:11:0x0019, B:19:0x0032, B:24:0x0047, B:26:0x0050, B:28:0x006c, B:31:0x0078, B:25:0x004c, B:16:0x0023), top: B:39:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0041  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047 A[Catch: Exception -> 0x001f, TRY_ENTER, TryCatch #0 {Exception -> 0x001f, blocks: (B:11:0x0019, B:19:0x0032, B:24:0x0047, B:26:0x0050, B:28:0x006c, B:31:0x0078, B:25:0x004c, B:16:0x0023), top: B:39:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x004c A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:11:0x0019, B:19:0x0032, B:24:0x0047, B:26:0x0050, B:28:0x006c, B:31:0x0078, B:25:0x004c, B:16:0x0023), top: B:39:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x006c A[Catch: Exception -> 0x001f, TryCatch #0 {Exception -> 0x001f, blocks: (B:11:0x0019, B:19:0x0032, B:24:0x0047, B:26:0x0050, B:28:0x006c, B:31:0x0078, B:25:0x004c, B:16:0x0023), top: B:39:0x0015 }] */
    /* JADX WARN: Code duplicated, block: B:31:0x0078 A[Catch: Exception -> 0x001f, TRY_LEAVE, TryCatch #0 {Exception -> 0x001f, blocks: (B:11:0x0019, B:19:0x0032, B:24:0x0047, B:26:0x0050, B:28:0x006c, B:31:0x0078, B:25:0x004c, B:16:0x0023), top: B:39:0x0015 }] */
    private static SSLContext newSSLContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, long j10, long j11, String str2) throws SSLException {
        TrustManagerFactory trustManagerFactory2;
        TrustManagerFactory trustManagerFactory3;
        KeyManagerFactory keyManagerFactoryBuildKeyManagerFactory;
        SSLContext sSLContext;
        SSLSessionContext serverSessionContext;
        if (privateKey == null && keyManagerFactory == null) {
            throw new NullPointerException("key, keyManagerFactory");
        }
        try {
            if (x509CertificateArr == null) {
                if (trustManagerFactory == null) {
                    trustManagerFactory3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                    trustManagerFactory3.init((KeyStore) null);
                } else {
                    trustManagerFactory2 = trustManagerFactory;
                }
                if (privateKey != null) {
                    keyManagerFactoryBuildKeyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, null, privateKey, str, keyManagerFactory, null);
                } else {
                    keyManagerFactoryBuildKeyManagerFactory = keyManagerFactory;
                }
                if (provider == null) {
                    sSLContext = SSLContext.getInstance("TLS");
                } else {
                    sSLContext = SSLContext.getInstance("TLS", provider);
                }
                sSLContext.init(keyManagerFactoryBuildKeyManagerFactory.getKeyManagers(), wrapTrustManagerIfNeeded(trustManagerFactory2.getTrustManagers()), null);
                serverSessionContext = sSLContext.getServerSessionContext();
                if (j10 > 0) {
                    serverSessionContext.setSessionCacheSize((int) Math.min(j10, 2147483647L));
                }
                if (j11 > 0) {
                    serverSessionContext.setSessionTimeout((int) Math.min(j11, 2147483647L));
                }
                return sSLContext;
            }
            trustManagerFactory3 = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
            trustManagerFactory2 = trustManagerFactory3;
            if (privateKey != null) {
                keyManagerFactoryBuildKeyManagerFactory = SslContext.buildKeyManagerFactory(x509CertificateArr2, null, privateKey, str, keyManagerFactory, null);
            } else {
                keyManagerFactoryBuildKeyManagerFactory = keyManagerFactory;
            }
            if (provider == null) {
                sSLContext = SSLContext.getInstance("TLS");
            } else {
                sSLContext = SSLContext.getInstance("TLS", provider);
            }
            sSLContext.init(keyManagerFactoryBuildKeyManagerFactory.getKeyManagers(), wrapTrustManagerIfNeeded(trustManagerFactory2.getTrustManagers()), null);
            serverSessionContext = sSLContext.getServerSessionContext();
            if (j10 > 0) {
                serverSessionContext.setSessionCacheSize((int) Math.min(j10, 2147483647L));
            }
            if (j11 > 0) {
                serverSessionContext.setSessionTimeout((int) Math.min(j11, 2147483647L));
            }
            return sSLContext;
        } catch (Exception e10) {
            if (e10 instanceof SSLException) {
                throw ((SSLException) e10);
            }
            throw new SSLException("failed to initialize the server-side SSL context", e10);
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static TrustManager[] wrapTrustManagerIfNeeded(TrustManager[] trustManagerArr) {
        if (PlatformDependent.javaVersion() >= 7) {
            for (int i10 = 0; i10 < trustManagerArr.length; i10++) {
                TrustManager trustManager = trustManagerArr[i10];
                if (trustManager instanceof X509ExtendedTrustManager) {
                    trustManagerArr[i10] = new EnhancingX509ExtendedTrustManager((X509ExtendedTrustManager) trustManager);
                }
            }
        }
        return trustManagerArr;
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str) throws SSLException {
        this(file, file2, str, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, JdkDefaultApplicationProtocolNegotiator.INSTANCE, 0L, 0L);
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j10, long j11) throws SSLException {
        this(null, file, file2, str, iterable, IdentityCipherSuiteFilter.INSTANCE, JdkSslContext.toNegotiator(SslContext.toApplicationProtocolConfig(iterable2), true), j10, j11, KeyStore.getDefaultType());
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        this(null, file, file2, str, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, true), j10, j11, KeyStore.getDefaultType());
    }

    @Deprecated
    public JdkSslServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j10, long j11) throws SSLException {
        this(null, file, file2, str, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, j10, j11, KeyStore.getDefaultType());
    }

    public JdkSslServerContext(Provider provider, File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j10, long j11, String str2) throws SSLException {
        super(newSSLContext(provider, null, null, SslContext.toX509CertificatesInternal(file), SslContext.toPrivateKeyInternal(file2, str), str, null, j10, j11, str2), false, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, ClientAuth.NONE, (String[]) null, false);
    }

    @Deprecated
    public JdkSslServerContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        super(newSSLContext(null, SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, j10, j11, null), false, iterable, cipherSuiteFilter, applicationProtocolConfig, ClientAuth.NONE, (String[]) null, false);
    }

    @Deprecated
    public JdkSslServerContext(File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, JdkApplicationProtocolNegotiator jdkApplicationProtocolNegotiator, long j10, long j11) throws SSLException {
        super(newSSLContext(null, SslContext.toX509CertificatesInternal(file), trustManagerFactory, SslContext.toX509CertificatesInternal(file2), SslContext.toPrivateKeyInternal(file3, str), str, keyManagerFactory, j10, j11, KeyStore.getDefaultType()), false, iterable, cipherSuiteFilter, jdkApplicationProtocolNegotiator, ClientAuth.NONE, (String[]) null, false);
    }

    public JdkSslServerContext(Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11, ClientAuth clientAuth, String[] strArr, boolean z10, String str2) throws SSLException {
        super(newSSLContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, j10, j11, str2), false, iterable, cipherSuiteFilter, JdkSslContext.toNegotiator(applicationProtocolConfig, true), clientAuth, strArr, z10);
    }
}
