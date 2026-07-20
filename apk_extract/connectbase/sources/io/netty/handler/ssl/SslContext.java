package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.util.AttributeMap;
import io.netty.util.DefaultAttributeMap;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.PlatformDependent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.EncryptedPrivateKeyInfo;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.TrustManagerFactory;

/* JADX INFO: loaded from: classes3.dex */
public abstract class SslContext {
    static final String ALIAS = "key";
    private static final String OID_PKCS5_PBES2 = "1.2.840.113549.1.5.13";
    private static final String PBES2 = "PBES2";
    static final CertificateFactory X509_CERT_FACTORY;
    private final AttributeMap attributes;
    private final boolean startTls;

    /* JADX INFO: renamed from: io.netty.handler.ssl.SslContext$1, reason: invalid class name */
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

    static {
        try {
            X509_CERT_FACTORY = CertificateFactory.getInstance("X.509");
        } catch (CertificateException e10) {
            throw new IllegalStateException("unable to instance X.509 CertificateFactory", e10);
        }
    }

    public SslContext() {
        this(false);
    }

    public static KeyManagerFactory buildKeyManagerFactory(X509Certificate[] x509CertificateArr, String str, PrivateKey privateKey, String str2, KeyManagerFactory keyManagerFactory, String str3) throws NoSuchAlgorithmException, UnrecoverableKeyException, IOException, KeyStoreException, CertificateException {
        if (str == null) {
            str = KeyManagerFactory.getDefaultAlgorithm();
        }
        char[] cArrKeyStorePassword = keyStorePassword(str2);
        return buildKeyManagerFactory(buildKeyStore(x509CertificateArr, privateKey, cArrKeyStorePassword, str3), str, cArrKeyStorePassword, keyManagerFactory);
    }

    public static KeyStore buildKeyStore(X509Certificate[] x509CertificateArr, PrivateKey privateKey, char[] cArr, String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (str == null) {
            str = KeyStore.getDefaultType();
        }
        KeyStore keyStore = KeyStore.getInstance(str);
        keyStore.load(null, null);
        keyStore.setKeyEntry("key", privateKey, cArr, x509CertificateArr);
        return keyStore;
    }

    @Deprecated
    public static TrustManagerFactory buildTrustManagerFactory(File file, TrustManagerFactory trustManagerFactory) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        return buildTrustManagerFactory(file, trustManagerFactory, (String) null);
    }

    public static SslProvider defaultClientProvider() {
        return defaultProvider();
    }

    private static SslProvider defaultProvider() {
        return OpenSsl.isAvailable() ? SslProvider.OPENSSL : SslProvider.JDK;
    }

    public static SslProvider defaultServerProvider() {
        return defaultProvider();
    }

    @Deprecated
    public static PKCS8EncodedKeySpec generateKeySpec(char[] cArr, byte[] bArr) throws InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException, InvalidAlgorithmParameterException {
        if (cArr == null) {
            return new PKCS8EncodedKeySpec(bArr);
        }
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(bArr);
        String pBEAlgorithm = getPBEAlgorithm(encryptedPrivateKeyInfo);
        SecretKey secretKeyGenerateSecret = SecretKeyFactory.getInstance(pBEAlgorithm).generateSecret(new PBEKeySpec(cArr));
        Cipher cipher = Cipher.getInstance(pBEAlgorithm);
        cipher.init(2, secretKeyGenerateSecret, encryptedPrivateKeyInfo.getAlgParameters());
        return encryptedPrivateKeyInfo.getKeySpec(cipher);
    }

    private static X509Certificate[] getCertificatesFromBuffers(ByteBuf[] byteBufArr) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        X509Certificate[] x509CertificateArr = new X509Certificate[byteBufArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < byteBufArr.length; i11++) {
            try {
                ByteBufInputStream byteBufInputStream = new ByteBufInputStream(byteBufArr[i11], false);
                try {
                    x509CertificateArr[i11] = (X509Certificate) certificateFactory.generateCertificate(byteBufInputStream);
                    try {
                        byteBufInputStream.close();
                    } catch (IOException e10) {
                        throw new RuntimeException(e10);
                    }
                } catch (Throwable th2) {
                    try {
                        byteBufInputStream.close();
                        throw th2;
                    } catch (IOException e11) {
                        throw new RuntimeException(e11);
                    }
                }
            } catch (Throwable th3) {
                int length = byteBufArr.length;
                while (i10 < length) {
                    byteBufArr[i10].release();
                    i10++;
                }
                throw th3;
            }
        }
        int length2 = byteBufArr.length;
        while (i10 < length2) {
            byteBufArr[i10].release();
            i10++;
        }
        return x509CertificateArr;
    }

    private static String getPBEAlgorithm(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo) {
        AlgorithmParameters algParameters = encryptedPrivateKeyInfo.getAlgParameters();
        String algName = encryptedPrivateKeyInfo.getAlgName();
        return (PlatformDependent.javaVersion() < 8 || algParameters == null || !(OID_PKCS5_PBES2.equals(algName) || PBES2.equals(algName))) ? encryptedPrivateKeyInfo.getAlgName() : algParameters.toString();
    }

    private static PrivateKey getPrivateKeyFromByteBuffer(ByteBuf byteBuf, String str) throws KeyException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException {
        byte[] bArr = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(bArr).release();
        PKCS8EncodedKeySpec pKCS8EncodedKeySpecGenerateKeySpec = generateKeySpec(str == null ? null : str.toCharArray(), bArr);
        try {
            try {
                try {
                    return KeyFactory.getInstance("RSA").generatePrivate(pKCS8EncodedKeySpecGenerateKeySpec);
                } catch (InvalidKeySpecException unused) {
                    return KeyFactory.getInstance("DSA").generatePrivate(pKCS8EncodedKeySpecGenerateKeySpec);
                }
            } catch (InvalidKeySpecException e10) {
                throw new InvalidKeySpecException("Neither RSA, DSA nor EC worked", e10);
            }
        } catch (InvalidKeySpecException unused2) {
            return KeyFactory.getInstance("EC").generatePrivate(pKCS8EncodedKeySpecGenerateKeySpec);
        }
    }

    public static char[] keyStorePassword(String str) {
        return str == null ? EmptyArrays.EMPTY_CHARS : str.toCharArray();
    }

    @Deprecated
    public static SslContext newClientContext() throws SSLException {
        return newClientContext(null, null, null);
    }

    public static SslContext newClientContextInternal(SslProvider sslProvider, Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, String[] strArr, long j10, long j11, boolean z10, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        SslProvider sslProviderDefaultClientProvider = sslProvider == null ? defaultClientProvider() : sslProvider;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProviderDefaultClientProvider.ordinal()];
        if (i10 == 1) {
            if (!z10) {
                return new JdkSslClientContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j10, j11, str2);
            }
            throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + sslProviderDefaultClientProvider);
        }
        if (i10 == 2) {
            verifyNullSslContextProvider(sslProviderDefaultClientProvider, provider);
            OpenSsl.ensureAvailability();
            return new OpenSslClientContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j10, j11, z10, str2, entryArr);
        }
        if (i10 != 3) {
            throw new Error(sslProviderDefaultClientProvider.toString());
        }
        verifyNullSslContextProvider(sslProviderDefaultClientProvider, provider);
        OpenSsl.ensureAvailability();
        return new ReferenceCountedOpenSslClientContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, strArr, j10, j11, z10, str2, entryArr);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2) throws SSLException {
        return newServerContext(file, file2, (String) null);
    }

    public static SslContext newServerContextInternal(SslProvider sslProvider, Provider provider, X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, X509Certificate[] x509CertificateArr2, PrivateKey privateKey, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11, ClientAuth clientAuth, String[] strArr, boolean z10, boolean z11, String str2, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        SslProvider sslProviderDefaultServerProvider = sslProvider == null ? defaultServerProvider() : sslProvider;
        int i10 = AnonymousClass1.$SwitchMap$io$netty$handler$ssl$SslProvider[sslProviderDefaultServerProvider.ordinal()];
        if (i10 == 1) {
            if (!z11) {
                return new JdkSslServerContext(provider, x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11, clientAuth, strArr, z10, str2);
            }
            throw new IllegalArgumentException("OCSP is not supported with this SslProvider: " + sslProviderDefaultServerProvider);
        }
        if (i10 == 2) {
            verifyNullSslContextProvider(sslProviderDefaultServerProvider, provider);
            return new OpenSslServerContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11, clientAuth, strArr, z10, z11, str2, entryArr);
        }
        if (i10 != 3) {
            throw new Error(sslProviderDefaultServerProvider.toString());
        }
        verifyNullSslContextProvider(sslProviderDefaultServerProvider, provider);
        return new ReferenceCountedOpenSslServerContext(x509CertificateArr, trustManagerFactory, x509CertificateArr2, privateKey, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11, clientAuth, strArr, z10, z11, str2, entryArr);
    }

    public static ApplicationProtocolConfig toApplicationProtocolConfig(Iterable<String> iterable) {
        return iterable == null ? ApplicationProtocolConfig.DISABLED : new ApplicationProtocolConfig(ApplicationProtocolConfig.Protocol.NPN_AND_ALPN, ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL, ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT, iterable);
    }

    public static PrivateKey toPrivateKey(File file, String str) throws KeyException, NoSuchPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException {
        return toPrivateKey(file, str, true);
    }

    public static PrivateKey toPrivateKeyInternal(File file, String str) throws SSLException {
        try {
            return toPrivateKey(file, str);
        } catch (Exception e10) {
            throw new SSLException(e10);
        }
    }

    public static X509Certificate[] toX509Certificates(File file) throws CertificateException {
        if (file == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(file));
    }

    public static X509Certificate[] toX509CertificatesInternal(File file) throws SSLException {
        try {
            return toX509Certificates(file);
        } catch (CertificateException e10) {
            throw new SSLException(e10);
        }
    }

    private static void verifyNullSslContextProvider(SslProvider sslProvider, Provider provider) {
        if (provider == null) {
            return;
        }
        throw new IllegalArgumentException("Java Security Provider unsupported for SslProvider: " + sslProvider);
    }

    public abstract ApplicationProtocolNegotiator applicationProtocolNegotiator();

    public final AttributeMap attributes() {
        return this.attributes;
    }

    public abstract List<String> cipherSuites();

    public abstract boolean isClient();

    public final boolean isServer() {
        return !isClient();
    }

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator);

    public abstract SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i10);

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator) {
        return newHandler(byteBufAllocator, this.startTls);
    }

    @Deprecated
    public final List<String> nextProtocols() {
        return applicationProtocolNegotiator().protocols();
    }

    public long sessionCacheSize() {
        return sessionContext().getSessionCacheSize();
    }

    public abstract SSLSessionContext sessionContext();

    public long sessionTimeout() {
        return sessionContext().getSessionTimeout();
    }

    public SslContext(boolean z10) {
        this.attributes = new DefaultAttributeMap();
        this.startTls = z10;
    }

    public static TrustManagerFactory buildTrustManagerFactory(File file, TrustManagerFactory trustManagerFactory, String str) throws NoSuchAlgorithmException, IOException, CertificateException, KeyStoreException {
        return buildTrustManagerFactory(toX509Certificates(file), trustManagerFactory, str);
    }

    @Deprecated
    public static SslContext newClientContext(File file) throws SSLException {
        return newClientContext((SslProvider) null, file);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2, String str) throws SSLException {
        return newServerContext(null, file, file2, str);
    }

    public static PrivateKey toPrivateKey(File file, String str, boolean z10) throws KeyException, NoSuchPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException {
        PrivateKey privateKey;
        if (file == null) {
            return null;
        }
        return (z10 && BouncyCastlePemReader.isAvailable() && (privateKey = BouncyCastlePemReader.getPrivateKey(file, str)) != null) ? privateKey : getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(file), str);
    }

    public static X509Certificate[] toX509Certificates(InputStream inputStream) throws CertificateException {
        if (inputStream == null) {
            return null;
        }
        return getCertificatesFromBuffers(PemReader.readCertificates(inputStream));
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z10) {
        return new SslHandler(newEngine(byteBufAllocator), z10);
    }

    @Deprecated
    public static SslContext newClientContext(TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(null, null, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j10, long j11) throws SSLException {
        return newServerContext((SslProvider) null, file, file2, str, iterable, iterable2, j10, j11);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, Executor executor) {
        return newHandler(byteBufAllocator, this.startTls, executor);
    }

    public static TrustManagerFactory buildTrustManagerFactory(X509Certificate[] x509CertificateArr, TrustManagerFactory trustManagerFactory, String str) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        if (str == null) {
            str = KeyStore.getDefaultType();
        }
        KeyStore keyStore = KeyStore.getInstance(str);
        keyStore.load(null, null);
        int i10 = 1;
        for (X509Certificate x509Certificate : x509CertificateArr) {
            keyStore.setCertificateEntry(Integer.toString(i10), x509Certificate);
            i10++;
        }
        if (trustManagerFactory == null) {
            trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        }
        trustManagerFactory.init(keyStore);
        return trustManagerFactory;
    }

    @Deprecated
    public static SslContext newClientContext(File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(null, file, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newServerContext(File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        return newServerContext((SslProvider) null, file, file2, str, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z10, Executor executor) {
        return new SslHandler(newEngine(byteBufAllocator), z10, executor);
    }

    public static KeyManagerFactory buildKeyManagerFactory(KeyStore keyStore, String str, char[] cArr, KeyManagerFactory keyManagerFactory) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException {
        if (keyManagerFactory == null) {
            if (str == null) {
                str = KeyManagerFactory.getDefaultAlgorithm();
            }
            keyManagerFactory = KeyManagerFactory.getInstance(str);
        }
        keyManagerFactory.init(keyStore, cArr);
        return keyManagerFactory;
    }

    @Deprecated
    public static SslContext newClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j10, long j11) throws SSLException {
        return newClientContext((SslProvider) null, file, trustManagerFactory, iterable, iterable2, j10, j11);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2) throws SSLException {
        return newServerContext(sslProvider, file, file2, null);
    }

    public static PrivateKey toPrivateKey(InputStream inputStream, String str) throws KeyException, NoSuchPaddingException, InvalidKeySpecException, NoSuchAlgorithmException, IOException, InvalidAlgorithmParameterException {
        if (inputStream == null) {
            return null;
        }
        if (BouncyCastlePemReader.isAvailable()) {
            if (!inputStream.markSupported()) {
                inputStream = new BufferedInputStream(inputStream);
            }
            inputStream.mark(1048576);
            PrivateKey privateKey = BouncyCastlePemReader.getPrivateKey(inputStream, str);
            if (privateKey != null) {
                return privateKey;
            }
            inputStream.reset();
        }
        return getPrivateKeyFromByteBuffer(PemReader.readPrivateKey(inputStream), str);
    }

    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10) {
        return newHandler(byteBufAllocator, str, i10, this.startTls);
    }

    @Deprecated
    public static SslContext newClientContext(File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        return newClientContext(null, file, trustManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str) throws SSLException {
        return newServerContext(sslProvider, file, file2, str, (Iterable<String>) null, IdentityCipherSuiteFilter.INSTANCE, (ApplicationProtocolConfig) null, 0L, 0L);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10) {
        return new SslHandler(newEngine(byteBufAllocator, str, i10), z10);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider) throws SSLException {
        return newClientContext(sslProvider, null, null);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str, Iterable<String> iterable, Iterable<String> iterable2, long j10, long j11) throws SSLException {
        return newServerContext(sslProvider, file, file2, str, iterable, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(iterable2), j10, j11);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, Executor executor) {
        return newHandler(byteBufAllocator, str, i10, this.startTls, executor);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file) throws SSLException {
        return newClientContext(sslProvider, file, null);
    }

    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10, Executor executor) {
        return new SslHandler(newEngine(byteBufAllocator, str, i10), z10, executor);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(sslProvider, null, trustManagerFactory);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory) throws SSLException {
        return newClientContext(sslProvider, file, trustManagerFactory, null, IdentityCipherSuiteFilter.INSTANCE, null, 0L, 0L);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j10, long j11) throws SSLException {
        return newServerContext(sslProvider, null, trustManagerFactory, file, file2, str, null, iterable, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(iterable2), j10, j11);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, Iterable<String> iterable2, long j10, long j11) throws SSLException {
        return newClientContext(sslProvider, file, trustManagerFactory, null, null, null, null, iterable, IdentityCipherSuiteFilter.INSTANCE, toApplicationProtocolConfig(iterable2), j10, j11);
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, File file2, String str, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        return newServerContext(sslProvider, null, null, file, file2, str, null, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11, KeyStore.getDefaultType());
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        return newClientContext(sslProvider, file, trustManagerFactory, null, null, null, null, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11);
    }

    @Deprecated
    public static SslContext newClientContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        try {
            return newClientContextInternal(sslProvider, null, toX509Certificates(file), trustManagerFactory, toX509Certificates(file2), toPrivateKey(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, null, j10, j11, false, KeyStore.getDefaultType(), new Map.Entry[0]);
        } catch (Exception e10) {
            if (e10 instanceof SSLException) {
                throw ((SSLException) e10);
            }
            throw new SSLException("failed to initialize the client-side SSL context", e10);
        }
    }

    @Deprecated
    public static SslContext newServerContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11) throws SSLException {
        return newServerContext(sslProvider, file, trustManagerFactory, file2, file3, str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11, KeyStore.getDefaultType());
    }

    public static SslContext newServerContext(SslProvider sslProvider, File file, TrustManagerFactory trustManagerFactory, File file2, File file3, String str, KeyManagerFactory keyManagerFactory, Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, ApplicationProtocolConfig applicationProtocolConfig, long j10, long j11, String str2) throws SSLException {
        try {
            return newServerContextInternal(sslProvider, null, toX509Certificates(file), trustManagerFactory, toX509Certificates(file2), toPrivateKey(file3, str), str, keyManagerFactory, iterable, cipherSuiteFilter, applicationProtocolConfig, j10, j11, ClientAuth.NONE, null, false, false, str2, new Map.Entry[0]);
        } catch (Exception e10) {
            if (e10 instanceof SSLException) {
                throw ((SSLException) e10);
            }
            throw new SSLException("failed to initialize the server-side SSL context", e10);
        }
    }
}
