package io.netty.handler.ssl;

import io.netty.buffer.ByteBufAllocator;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SniHostNameMatcher;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public final class ReferenceCountedOpenSslServerContext extends ReferenceCountedOpenSslContext {
    private final OpenSslServerSessionContext sessionContext;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslServerContext.class);
    private static final byte[] ID = {110, 101, 116, 116, 121};

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        public ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = x509ExtendedTrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    public static final class OpenSslServerCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public OpenSslServerCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        public void handle(long j10, byte[] bArr, byte[][] bArr2) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j10);
            if (referenceCountedOpenSslEngine == null) {
                return;
            }
            try {
                this.keyManagerHolder.setKeyMaterialServerSide(referenceCountedOpenSslEngine);
            } catch (Throwable th2) {
                referenceCountedOpenSslEngine.initHandshakeException(th2);
                if (!(th2 instanceof Exception)) {
                    throw new SSLException(th2);
                }
                throw th2;
            }
        }
    }

    public static final class OpenSslSniHostnameMatcher implements SniHostNameMatcher {
        private final OpenSslEngineMap engineMap;

        public OpenSslSniHostnameMatcher(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }

        public boolean match(long j10, String str) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j10);
            if (referenceCountedOpenSslEngine != null) {
                return referenceCountedOpenSslEngine.checkSniHostnameMatch(str.getBytes(CharsetUtil.UTF_8));
            }
            ReferenceCountedOpenSslServerContext.logger.warn("No ReferenceCountedOpenSslEngine found for SSL pointer: {}", Long.valueOf(j10));
            return false;
        }
    }

    public static final class TrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509TrustManager manager;

        public TrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
            super(openSslEngineMap);
            this.manager = x509TrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkClientTrusted(x509CertificateArr, str);
        }
    }

    public ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11, ClientAuth clientAuth, String[] strArr, boolean z10, boolean z11, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        this(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), j10, j11, clientAuth, strArr, z10, z11, str2, entryArr);
    }

    public static OpenSslServerSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j10, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2, long j11, long j12) throws Throwable {
        KeyManagerFactory openSslX509KeyManagerFactory;
        OpenSslKeyMaterialProvider openSslKeyMaterialProviderProviderFor;
        TrustManagerFactory trustManagerFactory2;
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = null;
        try {
            try {
                SSLContext.setVerify(j10, 0, 10);
                if (OpenSsl.useKeyManagerFactory()) {
                    if (keyManagerFactory == null) {
                        char[] cArrKeyStorePassword = SslContext.keyStorePassword(str);
                        KeyStore keyStoreBuildKeyStore = SslContext.buildKeyStore(x509CertificateArr2, privateKey, cArrKeyStorePassword, str2);
                        openSslX509KeyManagerFactory = keyStoreBuildKeyStore.aliases().hasMoreElements() ? new OpenSslX509KeyManagerFactory() : new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                        openSslX509KeyManagerFactory.init(keyStoreBuildKeyStore, cArrKeyStorePassword);
                    } else {
                        openSslX509KeyManagerFactory = keyManagerFactory;
                    }
                    openSslKeyMaterialProviderProviderFor = ReferenceCountedOpenSslContext.providerFor(openSslX509KeyManagerFactory, str);
                    try {
                        try {
                            SSLContext.setCertificateCallback(j10, new OpenSslServerCertificateCallback(openSslEngineMap, new OpenSslKeyMaterialManager(openSslKeyMaterialProviderProviderFor)));
                        } catch (Throwable th2) {
                            th = th2;
                            openSslKeyMaterialProvider = openSslKeyMaterialProviderProviderFor;
                            if (openSslKeyMaterialProvider != null) {
                                openSslKeyMaterialProvider.destroy();
                            }
                            throw th;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        throw new SSLException("failed to set certificate and key", e);
                    }
                } else {
                    if (keyManagerFactory != null) {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    }
                    ObjectUtil.checkNotNull(x509CertificateArr2, "keyCertChain");
                    ReferenceCountedOpenSslContext.setKeyMaterial(j10, x509CertificateArr2, privateKey, str);
                    openSslKeyMaterialProviderProviderFor = null;
                }
                try {
                    try {
                        if (x509CertificateArr != null) {
                            trustManagerFactory2 = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
                        } else if (trustManagerFactory == null) {
                            trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                            trustManagerFactory2.init((KeyStore) null);
                        } else {
                            trustManagerFactory2 = trustManagerFactory;
                        }
                        X509TrustManager x509TrustManagerChooseTrustManager = ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory2.getTrustManagers());
                        setVerifyCallback(j10, openSslEngineMap, x509TrustManagerChooseTrustManager);
                        X509Certificate[] acceptedIssuers = x509TrustManagerChooseTrustManager.getAcceptedIssuers();
                        long j13 = 0;
                        if (acceptedIssuers != null && acceptedIssuers.length > 0) {
                            try {
                                long bio = ReferenceCountedOpenSslContext.toBIO(ByteBufAllocator.DEFAULT, acceptedIssuers);
                                try {
                                    if (!SSLContext.setCACertificateBio(j10, bio)) {
                                        throw new SSLException("unable to setup accepted issuers for trustmanager " + x509TrustManagerChooseTrustManager);
                                    }
                                    ReferenceCountedOpenSslContext.freeBio(bio);
                                } catch (Throwable th3) {
                                    th = th3;
                                    j13 = bio;
                                    ReferenceCountedOpenSslContext.freeBio(j13);
                                    throw th;
                                }
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        if (PlatformDependent.javaVersion() >= 8) {
                            SSLContext.setSniHostnameMatcher(j10, new OpenSslSniHostnameMatcher(openSslEngineMap));
                        }
                        OpenSslServerSessionContext openSslServerSessionContext = new OpenSslServerSessionContext(referenceCountedOpenSslContext, openSslKeyMaterialProviderProviderFor);
                        openSslServerSessionContext.setSessionIdContext(ID);
                        openSslServerSessionContext.setSessionCacheEnabled(ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_CACHE);
                        if (j11 > 0) {
                            openSslServerSessionContext.setSessionCacheSize((int) Math.min(j11, 2147483647L));
                        }
                        if (j12 > 0) {
                            openSslServerSessionContext.setSessionTimeout((int) Math.min(j12, 2147483647L));
                        }
                        return openSslServerSessionContext;
                    } catch (SSLException e11) {
                        throw e11;
                    }
                } catch (Exception e12) {
                    throw new SSLException("unable to setup trustmanager", e12);
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    private static void setVerifyCallback(long j10, OpenSslEngineMap openSslEngineMap, X509TrustManager x509TrustManager) {
        if (ReferenceCountedOpenSslContext.useExtendedTrustManager(x509TrustManager)) {
            SSLContext.setCertVerifyCallback(j10, new ExtendedTrustManagerVerifyCallback(openSslEngineMap, (X509ExtendedTrustManager) x509TrustManager));
        } else {
            SSLContext.setCertVerifyCallback(j10, new TrustManagerVerifyCallback(openSslEngineMap, x509TrustManager));
        }
    }

    public ReferenceCountedOpenSslServerContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, long j10, long j11, ClientAuth clientAuth, String[] strArr, boolean z10, boolean z11, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws Throwable {
        super(iterable, cipherSuiteFilter, openSslApplicationProtocolNegotiator, 1, x509CertificateArr2, clientAuth, strArr, z10, z11, true, entryArr);
        try {
            try {
                OpenSslServerSessionContext openSslServerSessionContextNewSessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2, j10, j11);
                try {
                    this.sessionContext = openSslServerSessionContextNewSessionContext;
                    if (ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET) {
                        openSslServerSessionContextNewSessionContext.setTicketKeys(new OpenSslSessionTicketKey[0]);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    release();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslServerSessionContext sessionContext() {
        return this.sessionContext;
    }
}
