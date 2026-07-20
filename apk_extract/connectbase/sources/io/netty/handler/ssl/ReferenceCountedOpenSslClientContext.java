package io.netty.handler.ssl;

import androidx.constraintlayout.widget.ConstraintLayout;
import io.netty.internal.tcnative.CertificateCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.SuppressJava6Requirement;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
public final class ReferenceCountedOpenSslClientContext extends ReferenceCountedOpenSslContext {
    private static final Set<String> SUPPORTED_KEY_TYPES = Collections.unmodifiableSet(new LinkedHashSet(Arrays.asList("RSA", "DH_RSA", "EC", "EC_RSA", "EC_EC")));
    private final OpenSslSessionContext sessionContext;

    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public static final class ExtendedTrustManagerVerifyCallback extends ReferenceCountedOpenSslContext.AbstractCertificateVerifier {
        private final X509ExtendedTrustManager manager;

        public ExtendedTrustManagerVerifyCallback(OpenSslEngineMap openSslEngineMap, X509ExtendedTrustManager x509ExtendedTrustManager) {
            super(openSslEngineMap);
            this.manager = x509ExtendedTrustManager;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext.AbstractCertificateVerifier
        public void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception {
            this.manager.checkServerTrusted(x509CertificateArr, str, referenceCountedOpenSslEngine);
        }
    }

    public static final class OpenSslClientCertificateCallback implements CertificateCallback {
        private final OpenSslEngineMap engineMap;
        private final OpenSslKeyMaterialManager keyManagerHolder;

        public OpenSslClientCertificateCallback(OpenSslEngineMap openSslEngineMap, OpenSslKeyMaterialManager openSslKeyMaterialManager) {
            this.engineMap = openSslEngineMap;
            this.keyManagerHolder = openSslKeyMaterialManager;
        }

        private static String clientKeyType(byte b10) {
            if (b10 == 1) {
                return "RSA";
            }
            if (b10 == 3) {
                return "DH_RSA";
            }
            switch (b10) {
                case 64:
                    return "EC";
                case ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_HEIGHT /* 65 */:
                    return "EC_RSA";
                case ConstraintLayout.LayoutParams.Table.LAYOUT_WRAP_BEHAVIOR_IN_PARENT /* 66 */:
                    return "EC_EC";
                default:
                    return null;
            }
        }

        private static Set<String> supportedClientKeyTypes(byte[] bArr) {
            if (bArr == null) {
                return ReferenceCountedOpenSslClientContext.SUPPORTED_KEY_TYPES;
            }
            HashSet hashSet = new HashSet(bArr.length);
            for (byte b10 : bArr) {
                String strClientKeyType = clientKeyType(b10);
                if (strClientKeyType != null) {
                    hashSet.add(strClientKeyType);
                }
            }
            return hashSet;
        }

        public void handle(long j10, byte[] bArr, byte[][] bArr2) throws Exception {
            X500Principal[] x500PrincipalArr;
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j10);
            if (referenceCountedOpenSslEngine == null) {
                return;
            }
            try {
                String[] strArr = (String[]) supportedClientKeyTypes(bArr).toArray(EmptyArrays.EMPTY_STRINGS);
                if (bArr2 == null) {
                    x500PrincipalArr = null;
                } else {
                    x500PrincipalArr = new X500Principal[bArr2.length];
                    for (int i10 = 0; i10 < bArr2.length; i10++) {
                        x500PrincipalArr[i10] = new X500Principal(bArr2[i10]);
                    }
                }
                this.keyManagerHolder.setKeyMaterialClientSide(referenceCountedOpenSslEngine, strArr, x500PrincipalArr);
            } catch (Throwable th2) {
                referenceCountedOpenSslEngine.initHandshakeException(th2);
                if (!(th2 instanceof Exception)) {
                    throw new SSLException(th2);
                }
                throw th2;
            }
        }
    }

    public static final class OpenSslClientSessionContext extends OpenSslSessionContext {
        public OpenSslClientSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, OpenSslKeyMaterialProvider openSslKeyMaterialProvider) {
            super(referenceCountedOpenSslContext, openSslKeyMaterialProvider, SSL.SSL_SESS_CACHE_CLIENT, new OpenSslClientSessionCache(referenceCountedOpenSslContext.engineMap));
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
            this.manager.checkServerTrusted(x509CertificateArr, str);
        }
    }

    public ReferenceCountedOpenSslClientContext(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j10, long j11, boolean z10, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws Throwable {
        super(iterable, cipherSuiteFilter, ReferenceCountedOpenSslContext.toNegotiator(applicationProtocolConfig), 0, x509CertificateArr2, ClientAuth.NONE, strArr, false, z10, true, entryArr);
        try {
            try {
                try {
                    this.sessionContext = newSessionContext(this, this.ctx, this.engineMap, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, str2, j10, j11);
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

    public static OpenSslSessionContext newSessionContext(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, long j10, OpenSslEngineMap openSslEngineMap, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, String str2, long j11, long j12) throws Throwable {
        OpenSslKeyMaterialProvider openSslKeyMaterialProviderProviderFor;
        TrustManagerFactory trustManagerFactory2;
        if ((privateKey == null && x509CertificateArr2 != null) || (privateKey != null && x509CertificateArr2 == null)) {
            throw new IllegalArgumentException("Either both keyCertChain and key needs to be null or none of them");
        }
        OpenSslKeyMaterialProvider openSslKeyMaterialProvider = null;
        try {
            try {
                if (OpenSsl.useKeyManagerFactory()) {
                    if (keyManagerFactory != null || x509CertificateArr2 == null) {
                        openSslKeyMaterialProviderProviderFor = keyManagerFactory != null ? ReferenceCountedOpenSslContext.providerFor(keyManagerFactory, str) : null;
                    } else {
                        char[] cArrKeyStorePassword = SslContext.keyStorePassword(str);
                        KeyStore keyStoreBuildKeyStore = SslContext.buildKeyStore(x509CertificateArr2, privateKey, cArrKeyStorePassword, str2);
                        KeyManagerFactory openSslX509KeyManagerFactory = keyStoreBuildKeyStore.aliases().hasMoreElements() ? new OpenSslX509KeyManagerFactory() : new OpenSslCachingX509KeyManagerFactory(KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm()));
                        openSslX509KeyManagerFactory.init(keyStoreBuildKeyStore, cArrKeyStorePassword);
                        openSslKeyMaterialProviderProviderFor = ReferenceCountedOpenSslContext.providerFor(openSslX509KeyManagerFactory, str);
                    }
                    if (openSslKeyMaterialProviderProviderFor != null) {
                        try {
                            try {
                                SSLContext.setCertificateCallback(j10, new OpenSslClientCertificateCallback(openSslEngineMap, new OpenSslKeyMaterialManager(openSslKeyMaterialProviderProviderFor)));
                            } catch (Exception e10) {
                                e = e10;
                                throw new SSLException("failed to set certificate and key", e);
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            openSslKeyMaterialProvider = openSslKeyMaterialProviderProviderFor;
                            if (openSslKeyMaterialProvider != null) {
                                openSslKeyMaterialProvider.destroy();
                            }
                            throw th;
                        }
                    }
                } else {
                    if (keyManagerFactory != null) {
                        throw new IllegalArgumentException("KeyManagerFactory not supported");
                    }
                    if (x509CertificateArr2 != null) {
                        ReferenceCountedOpenSslContext.setKeyMaterial(j10, x509CertificateArr2, privateKey, str);
                    }
                    openSslKeyMaterialProviderProviderFor = null;
                }
                SSLContext.setVerify(j10, 1, 10);
                try {
                    if (x509CertificateArr != null) {
                        trustManagerFactory2 = SslContext.buildTrustManagerFactory(x509CertificateArr, trustManagerFactory, str2);
                    } else if (trustManagerFactory == null) {
                        trustManagerFactory2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                        trustManagerFactory2.init((KeyStore) null);
                    } else {
                        trustManagerFactory2 = trustManagerFactory;
                    }
                    setVerifyCallback(j10, openSslEngineMap, ReferenceCountedOpenSslContext.chooseTrustManager(trustManagerFactory2.getTrustManagers()));
                    OpenSslClientSessionContext openSslClientSessionContext = new OpenSslClientSessionContext(referenceCountedOpenSslContext, openSslKeyMaterialProviderProviderFor);
                    openSslClientSessionContext.setSessionCacheEnabled(ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_CACHE);
                    if (j11 > 0) {
                        openSslClientSessionContext.setSessionCacheSize((int) Math.min(j11, 2147483647L));
                    }
                    if (j12 > 0) {
                        openSslClientSessionContext.setSessionTimeout((int) Math.min(j12, 2147483647L));
                    }
                    if (ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET) {
                        openSslClientSessionContext.setTicketKeys(new OpenSslSessionTicketKey[0]);
                    }
                    return openSslClientSessionContext;
                } catch (Exception e11) {
                    if (openSslKeyMaterialProviderProviderFor != null) {
                        openSslKeyMaterialProviderProviderFor.destroy();
                    }
                    throw new SSLException("unable to setup trustmanager", e11);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception e12) {
            e = e12;
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

    @Override // io.netty.handler.ssl.ReferenceCountedOpenSslContext, io.netty.handler.ssl.SslContext
    public OpenSslSessionContext sessionContext() {
        return this.sessionContext;
    }
}
