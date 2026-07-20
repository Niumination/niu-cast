package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncSSLPrivateKeyMethod;
import io.netty.internal.tcnative.CertificateCompressionAlgo;
import io.netty.internal.tcnative.CertificateVerifier;
import io.netty.internal.tcnative.ResultCallback;
import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import io.netty.internal.tcnative.SSLPrivateKeyMethod;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.SystemPropertyUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateRevokedException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ReferenceCountedOpenSslContext extends SslContext implements ReferenceCounted {
    private static final Integer DH_KEY_LENGTH;
    protected static final int VERIFY_DEPTH = 10;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile int bioNonApplicationBufferSize;
    final ClientAuth clientAuth;
    protected long ctx;
    final ReadWriteLock ctxLock;
    final boolean enableOcsp;
    final OpenSslEngineMap engineMap;
    final Certificate[] keyCertChain;
    private final ResourceLeakTracker<ReferenceCountedOpenSslContext> leak;
    private final int mode;
    final String[] protocols;
    private final AbstractReferenceCounted refCnt;
    final boolean tlsFalseStart;
    private final List<String> unmodifiableCiphers;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslContext.class);
    private static final int DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE = Math.max(1, SystemPropertyUtil.getInt("io.netty.handler.ssl.openssl.bioNonApplicationBufferSize", 2048));
    static final boolean USE_TASKS = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.useTasks", true);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslContext> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslContext.class);
    static final boolean CLIENT_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", false);
    static final boolean CLIENT_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.client.enableSessionTicketExtension", true);
    static final boolean SERVER_ENABLE_SESSION_TICKET = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", false);
    static final boolean SERVER_ENABLE_SESSION_TICKET_TLSV13 = SystemPropertyUtil.getBoolean("jdk.tls.server.enableSessionTicketExtension", true);
    static final boolean SERVER_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheServer", true);
    static final boolean CLIENT_ENABLE_SESSION_CACHE = SystemPropertyUtil.getBoolean("io.netty.handler.ssl.openssl.sessionCacheClient", true);
    static final OpenSslApplicationProtocolNegotiator NONE_PROTOCOL_NEGOTIATOR = new OpenSslApplicationProtocolNegotiator() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.2
        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.Protocol protocol() {
            return ApplicationProtocolConfig.Protocol.NONE;
        }

        @Override // io.netty.handler.ssl.ApplicationProtocolNegotiator
        public List<String> protocols() {
            return Collections.emptyList();
        }

        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior() {
            return ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT;
        }

        @Override // io.netty.handler.ssl.OpenSslApplicationProtocolNegotiator
        public ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior() {
            return ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL;
        }
    };

    /* JADX INFO: renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslContext$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.SelectedListenerFailureBehavior.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior = iArr;
            try {
                iArr[ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[ApplicationProtocolConfig.SelectorFailureBehavior.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior = iArr2;
            try {
                iArr2[ApplicationProtocolConfig.SelectorFailureBehavior.NO_ADVERTISE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[ApplicationProtocolConfig.SelectorFailureBehavior.CHOOSE_MY_LAST_PROTOCOL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[OpenSslCertificateCompressionConfig.AlgorithmMode.values().length];
            $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode = iArr3;
            try {
                iArr3[OpenSslCertificateCompressionConfig.AlgorithmMode.Decompress.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode[OpenSslCertificateCompressionConfig.AlgorithmMode.Compress.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode[OpenSslCertificateCompressionConfig.AlgorithmMode.Both.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr4 = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr4;
            try {
                iArr4[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public static abstract class AbstractCertificateVerifier extends CertificateVerifier {
        private final OpenSslEngineMap engineMap;

        public AbstractCertificateVerifier(OpenSslEngineMap openSslEngineMap) {
            this.engineMap = openSslEngineMap;
        }

        @SuppressJava6Requirement(reason = "Usage guarded by java version check")
        private static int translateToError(Throwable th2) {
            if (th2 instanceof CertificateRevokedException) {
                return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
            }
            for (Throwable cause = th2.getCause(); cause != null; cause = cause.getCause()) {
                if (cause instanceof CertPathValidatorException) {
                    CertPathValidatorException.Reason reason = ((CertPathValidatorException) cause).getReason();
                    if (reason == CertPathValidatorException.BasicReason.EXPIRED) {
                        return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                    }
                    if (reason == CertPathValidatorException.BasicReason.NOT_YET_VALID) {
                        return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                    }
                    if (reason == CertPathValidatorException.BasicReason.REVOKED) {
                        return CertificateVerifier.X509_V_ERR_CERT_REVOKED;
                    }
                }
            }
            return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
        }

        public final int verify(long j10, byte[][] bArr, String str) {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = this.engineMap.get(j10);
            if (referenceCountedOpenSslEngine == null) {
                return CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
            try {
                verify(referenceCountedOpenSslEngine, ReferenceCountedOpenSslContext.certificates(bArr), str);
                return CertificateVerifier.X509_V_OK;
            } catch (Throwable th2) {
                ReferenceCountedOpenSslContext.logger.debug("verification of certificate failed", (Throwable) th2);
                referenceCountedOpenSslEngine.initHandshakeException(th2);
                if (th2 instanceof OpenSslCertificateException) {
                    return th2.errorCode();
                }
                if (th2 instanceof CertificateExpiredException) {
                    return CertificateVerifier.X509_V_ERR_CERT_HAS_EXPIRED;
                }
                if (th2 instanceof CertificateNotYetValidException) {
                    return CertificateVerifier.X509_V_ERR_CERT_NOT_YET_VALID;
                }
                return PlatformDependent.javaVersion() >= 7 ? translateToError(th2) : CertificateVerifier.X509_V_ERR_UNSPECIFIED;
            }
        }

        public abstract void verify(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, X509Certificate[] x509CertificateArr, String str) throws Exception;
    }

    public static final class AsyncPrivateKeyMethod implements AsyncSSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslAsyncPrivateKeyMethod keyMethod;

        public static final class ResultCallbackListener implements FutureListener<byte[]> {
            private final ReferenceCountedOpenSslEngine engine;
            private final ResultCallback<byte[]> resultCallback;
            private final long ssl;

            public ResultCallbackListener(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine, long j10, ResultCallback<byte[]> resultCallback) {
                this.engine = referenceCountedOpenSslEngine;
                this.ssl = j10;
                this.resultCallback = resultCallback;
            }

            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(Future<byte[]> future) {
                Throwable thCause = future.cause();
                if (thCause == null) {
                    try {
                        this.resultCallback.onSuccess(this.ssl, ReferenceCountedOpenSslContext.verifyResult(future.getNow()));
                        return;
                    } catch (SignatureException e10) {
                        thCause = e10;
                        this.engine.initHandshakeException(thCause);
                    }
                }
                this.resultCallback.onError(this.ssl, thCause);
            }
        }

        public AsyncPrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslAsyncPrivateKeyMethod;
        }

        public void decrypt(long j10, byte[] bArr, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j10);
                this.keyMethod.decrypt(referenceCountedOpenSslEngineRetrieveEngine, bArr).addListener(new ResultCallbackListener(referenceCountedOpenSslEngineRetrieveEngine, j10, resultCallback));
            } catch (SSLException e10) {
                resultCallback.onError(j10, e10);
            }
        }

        public void sign(long j10, int i10, byte[] bArr, ResultCallback<byte[]> resultCallback) {
            try {
                ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j10);
                this.keyMethod.sign(referenceCountedOpenSslEngineRetrieveEngine, i10, bArr).addListener(new ResultCallbackListener(referenceCountedOpenSslEngineRetrieveEngine, j10, resultCallback));
            } catch (SSLException e10) {
                resultCallback.onError(j10, e10);
            }
        }
    }

    public static final class CompressionAlgorithm implements CertificateCompressionAlgo {
        private final OpenSslCertificateCompressionAlgorithm compressionAlgorithm;
        private final OpenSslEngineMap engineMap;

        public CompressionAlgorithm(OpenSslEngineMap openSslEngineMap, OpenSslCertificateCompressionAlgorithm openSslCertificateCompressionAlgorithm) {
            this.engineMap = openSslEngineMap;
            this.compressionAlgorithm = openSslCertificateCompressionAlgorithm;
        }

        public int algorithmId() {
            return this.compressionAlgorithm.algorithmId();
        }

        public byte[] compress(long j10, byte[] bArr) throws Exception {
            return this.compressionAlgorithm.compress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j10), bArr);
        }

        public byte[] decompress(long j10, int i10, byte[] bArr) throws Exception {
            return this.compressionAlgorithm.decompress(ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j10), i10, bArr);
        }
    }

    public static final class DefaultOpenSslEngineMap implements OpenSslEngineMap {
        private final Map<Long, ReferenceCountedOpenSslEngine> engines;

        private DefaultOpenSslEngineMap() {
            this.engines = PlatformDependent.newConcurrentHashMap();
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public void add(ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine) {
            this.engines.put(Long.valueOf(referenceCountedOpenSslEngine.sslPointer()), referenceCountedOpenSslEngine);
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine get(long j10) {
            return this.engines.get(Long.valueOf(j10));
        }

        @Override // io.netty.handler.ssl.OpenSslEngineMap
        public ReferenceCountedOpenSslEngine remove(long j10) {
            return this.engines.remove(Long.valueOf(j10));
        }
    }

    public static final class PrivateKeyMethod implements SSLPrivateKeyMethod {
        private final OpenSslEngineMap engineMap;
        private final OpenSslPrivateKeyMethod keyMethod;

        public PrivateKeyMethod(OpenSslEngineMap openSslEngineMap, OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
            this.engineMap = openSslEngineMap;
            this.keyMethod = openSslPrivateKeyMethod;
        }

        public byte[] decrypt(long j10, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j10);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.decrypt(referenceCountedOpenSslEngineRetrieveEngine, bArr));
            } catch (Exception e10) {
                referenceCountedOpenSslEngineRetrieveEngine.initHandshakeException(e10);
                throw e10;
            }
        }

        public byte[] sign(long j10, int i10, byte[] bArr) throws Exception {
            ReferenceCountedOpenSslEngine referenceCountedOpenSslEngineRetrieveEngine = ReferenceCountedOpenSslContext.retrieveEngine(this.engineMap, j10);
            try {
                return ReferenceCountedOpenSslContext.verifyResult(this.keyMethod.sign(referenceCountedOpenSslEngineRetrieveEngine, i10, bArr));
            } catch (Exception e10) {
                referenceCountedOpenSslEngineRetrieveEngine.initHandshakeException(e10);
                throw e10;
            }
        }
    }

    static {
        Integer numValueOf = null;
        try {
            String str = SystemPropertyUtil.get("jdk.tls.ephemeralDHKeySize");
            if (str != null) {
                try {
                    numValueOf = Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    logger.debug("ReferenceCountedOpenSslContext supports -Djdk.tls.ephemeralDHKeySize={int}, but got: ".concat(str));
                }
            }
        } catch (Throwable unused2) {
        }
        DH_KEY_LENGTH = numValueOf;
    }

    public ReferenceCountedOpenSslContext(Iterable<String> iterable, CipherSuiteFilter cipherSuiteFilter, OpenSslApplicationProtocolNegotiator openSslApplicationProtocolNegotiator, int i10, Certificate[] certificateArr, ClientAuth clientAuth, String[] strArr, boolean z10, boolean z11, boolean z12, Map.Entry<SslContextOption<?>, Object>... entryArr) throws SSLException {
        boolean zBooleanValue;
        OpenSslPrivateKeyMethod openSslPrivateKeyMethod;
        OpenSslAsyncPrivateKeyMethod openSslAsyncPrivateKeyMethod;
        OpenSslCertificateCompressionConfig openSslCertificateCompressionConfig;
        Integer num;
        super(z10);
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslContext.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            public void deallocate() {
                ReferenceCountedOpenSslContext.this.destroy();
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.close(ReferenceCountedOpenSslContext.this);
                }
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslContext.this.leak != null) {
                    ReferenceCountedOpenSslContext.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslContext.this;
            }
        };
        this.engineMap = new DefaultOpenSslEngineMap();
        this.ctxLock = new ReentrantReadWriteLock();
        this.bioNonApplicationBufferSize = DEFAULT_BIO_NON_APPLICATION_BUFFER_SIZE;
        OpenSsl.ensureAvailability();
        if (z11 && !OpenSsl.isOcspSupported()) {
            throw new IllegalStateException("OCSP is not supported.");
        }
        if (i10 != 1 && i10 != 0) {
            throw new IllegalArgumentException("mode most be either SSL.SSL_MODE_SERVER or SSL.SSL_MODE_CLIENT");
        }
        boolean zBooleanValue2 = USE_TASKS;
        if (entryArr != null) {
            openSslPrivateKeyMethod = null;
            openSslAsyncPrivateKeyMethod = null;
            openSslCertificateCompressionConfig = null;
            num = null;
            zBooleanValue = false;
            for (Map.Entry<SslContextOption<?>, Object> entry : entryArr) {
                SslContextOption<?> key = entry.getKey();
                if (key == OpenSslContextOption.TLS_FALSE_START) {
                    zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
                } else if (key == OpenSslContextOption.USE_TASKS) {
                    zBooleanValue2 = ((Boolean) entry.getValue()).booleanValue();
                } else if (key == OpenSslContextOption.PRIVATE_KEY_METHOD) {
                    openSslPrivateKeyMethod = (OpenSslPrivateKeyMethod) entry.getValue();
                } else if (key == OpenSslContextOption.ASYNC_PRIVATE_KEY_METHOD) {
                    openSslAsyncPrivateKeyMethod = (OpenSslAsyncPrivateKeyMethod) entry.getValue();
                } else if (key == OpenSslContextOption.CERTIFICATE_COMPRESSION_ALGORITHMS) {
                    openSslCertificateCompressionConfig = (OpenSslCertificateCompressionConfig) entry.getValue();
                } else if (key == OpenSslContextOption.MAX_CERTIFICATE_LIST_BYTES) {
                    num = (Integer) entry.getValue();
                } else {
                    logger.debug("Skipping unsupported SslContextOption: " + entry.getKey());
                }
            }
        } else {
            zBooleanValue = false;
            openSslPrivateKeyMethod = null;
            openSslAsyncPrivateKeyMethod = null;
            openSslCertificateCompressionConfig = null;
            num = null;
        }
        if (openSslPrivateKeyMethod != null && openSslAsyncPrivateKeyMethod != null) {
            throw new IllegalArgumentException("You can either only use OpenSslAsyncPrivateKeyMethod or OpenSslPrivateKeyMethod");
        }
        this.tlsFalseStart = zBooleanValue;
        this.leak = z12 ? leakDetector.track(this) : null;
        this.mode = i10;
        this.clientAuth = isServer() ? (ClientAuth) ObjectUtil.checkNotNull(clientAuth, "clientAuth") : ClientAuth.NONE;
        this.protocols = strArr == null ? OpenSsl.defaultProtocols(i10 == 0) : strArr;
        this.enableOcsp = z11;
        this.keyCertChain = certificateArr == null ? null : (Certificate[]) certificateArr.clone();
        String[] strArrFilterCipherSuites = ((CipherSuiteFilter) ObjectUtil.checkNotNull(cipherSuiteFilter, "cipherFilter")).filterCipherSuites(iterable, OpenSsl.DEFAULT_CIPHERS, OpenSsl.availableJavaCipherSuites());
        LinkedHashSet linkedHashSet = new LinkedHashSet(strArrFilterCipherSuites.length);
        Collections.addAll(linkedHashSet, strArrFilterCipherSuites);
        ArrayList arrayList = new ArrayList(linkedHashSet);
        this.unmodifiableCiphers = arrayList;
        this.apn = (OpenSslApplicationProtocolNegotiator) ObjectUtil.checkNotNull(openSslApplicationProtocolNegotiator, "apn");
        try {
            boolean zIsTlsv13Supported = OpenSsl.isTlsv13Supported();
            try {
                this.ctx = SSLContext.make(zIsTlsv13Supported ? 62 : 30, i10);
                StringBuilder sb2 = new StringBuilder();
                StringBuilder sb3 = new StringBuilder();
                try {
                    if (arrayList.isEmpty()) {
                        SSLContext.setCipherSuite(this.ctx, "", false);
                        if (zIsTlsv13Supported) {
                            SSLContext.setCipherSuite(this.ctx, "", true);
                        }
                    } else {
                        CipherSuiteConverter.convertToCipherStrings(arrayList, sb2, sb3, OpenSsl.isBoringSSL());
                        SSLContext.setCipherSuite(this.ctx, sb2.toString(), false);
                        if (zIsTlsv13Supported) {
                            SSLContext.setCipherSuite(this.ctx, OpenSsl.checkTls13Ciphers(logger, sb3.toString()), true);
                        }
                    }
                    int options = SSLContext.getOptions(this.ctx) | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_CIPHER_SERVER_PREFERENCE | SSL.SSL_OP_NO_COMPRESSION | SSL.SSL_OP_NO_TICKET;
                    options = sb2.length() == 0 ? options | SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 : options;
                    SSLContext.setOptions(this.ctx, zIsTlsv13Supported ? options : options | SSL.SSL_OP_NO_TLSv1_3);
                    long j10 = this.ctx;
                    SSLContext.setMode(j10, SSLContext.getMode(j10) | SSL.SSL_MODE_ACCEPT_MOVING_WRITE_BUFFER);
                    Integer num2 = DH_KEY_LENGTH;
                    if (num2 != null) {
                        SSLContext.setTmpDHLength(this.ctx, num2.intValue());
                    }
                    List<String> listProtocols = openSslApplicationProtocolNegotiator.protocols();
                    if (!listProtocols.isEmpty()) {
                        String[] strArr2 = (String[]) listProtocols.toArray(EmptyArrays.EMPTY_STRINGS);
                        int iOpensslSelectorFailureBehavior = opensslSelectorFailureBehavior(openSslApplicationProtocolNegotiator.selectorFailureBehavior());
                        int i11 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[openSslApplicationProtocolNegotiator.protocol().ordinal()];
                        if (i11 == 1) {
                            SSLContext.setNpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                        } else if (i11 == 2) {
                            SSLContext.setAlpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                        } else {
                            if (i11 != 3) {
                                throw new Error();
                            }
                            SSLContext.setNpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                            SSLContext.setAlpnProtos(this.ctx, strArr2, iOpensslSelectorFailureBehavior);
                        }
                    }
                    if (z11) {
                        SSLContext.enableOcsp(this.ctx, isClient());
                    }
                    SSLContext.setUseTasks(this.ctx, zBooleanValue2);
                    if (openSslPrivateKeyMethod != null) {
                        SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod));
                    }
                    if (openSslAsyncPrivateKeyMethod != null) {
                        SSLContext.setPrivateKeyMethod(this.ctx, new AsyncPrivateKeyMethod(this.engineMap, openSslAsyncPrivateKeyMethod));
                    }
                    if (openSslCertificateCompressionConfig != null) {
                        for (OpenSslCertificateCompressionConfig.AlgorithmConfig algorithmConfig : openSslCertificateCompressionConfig) {
                            CompressionAlgorithm compressionAlgorithm = new CompressionAlgorithm(this.engineMap, algorithmConfig.algorithm());
                            int i12 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$OpenSslCertificateCompressionConfig$AlgorithmMode[algorithmConfig.mode().ordinal()];
                            if (i12 == 1) {
                                SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_DECOMPRESS, compressionAlgorithm);
                            } else if (i12 == 2) {
                                SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_COMPRESS, compressionAlgorithm);
                            } else {
                                if (i12 != 3) {
                                    throw new IllegalStateException();
                                }
                                SSLContext.addCertificateCompressionAlgorithm(this.ctx, SSL.SSL_CERT_COMPRESSION_DIRECTION_BOTH, compressionAlgorithm);
                            }
                        }
                    }
                    if (num != null) {
                        SSLContext.setMaxCertList(this.ctx, num.intValue());
                    }
                    SSLContext.setCurvesList(this.ctx, OpenSsl.NAMED_GROUPS);
                } catch (SSLException e10) {
                    throw e10;
                } catch (Exception e11) {
                    throw new SSLException("failed to set cipher suite: " + this.unmodifiableCiphers, e11);
                }
            } catch (Exception e12) {
                throw new SSLException("failed to create an SSL_CTX", e12);
            }
        } catch (Throwable th2) {
            release();
            throw th2;
        }
    }

    public static X509Certificate[] certificates(byte[][] bArr) {
        int length = bArr.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i10 = 0; i10 < length; i10++) {
            x509CertificateArr[i10] = new LazyX509Certificate(bArr[i10]);
        }
        return x509CertificateArr;
    }

    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
                if (PlatformDependent.javaVersion() < 7) {
                    return x509TrustManager;
                }
                X509TrustManager x509TrustManagerWrapIfNeeded = OpenSslX509TrustManagerWrapper.wrapIfNeeded(x509TrustManager);
                return useExtendedTrustManager(x509TrustManagerWrapIfNeeded) ? new EnhancingX509ExtendedTrustManager(x509TrustManagerWrapIfNeeded) : x509TrustManagerWrapIfNeeded;
            }
        }
        throw new IllegalStateException("no X509TrustManager found");
    }

    public static X509KeyManager chooseX509KeyManager(KeyManager[] keyManagerArr) {
        for (KeyManager keyManager : keyManagerArr) {
            if (keyManager instanceof X509KeyManager) {
                return (X509KeyManager) keyManager;
            }
        }
        throw new IllegalStateException("no X509KeyManager found");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void destroy() {
        Lock lockWriteLock = this.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            long j10 = this.ctx;
            if (j10 != 0) {
                if (this.enableOcsp) {
                    SSLContext.disableOcsp(j10);
                }
                SSLContext.free(this.ctx);
                this.ctx = 0L;
                OpenSslSessionContext openSslSessionContextSessionContext = sessionContext();
                if (openSslSessionContextSessionContext != null) {
                    openSslSessionContextSessionContext.destroy();
                }
            }
        } finally {
            lockWriteLock.unlock();
        }
    }

    public static void freeBio(long j10) {
        if (j10 != 0) {
            SSL.freeBIO(j10);
        }
    }

    private static long newBIO(ByteBuf byteBuf) throws Exception {
        try {
            long jNewMemBIO = SSL.newMemBIO();
            int i10 = byteBuf.readableBytes();
            if (SSL.bioWrite(jNewMemBIO, OpenSsl.memoryAddress(byteBuf) + ((long) byteBuf.readerIndex()), i10) == i10) {
                byteBuf.release();
                return jNewMemBIO;
            }
            SSL.freeBIO(jNewMemBIO);
            throw new IllegalStateException("Could not write data to memory BIO");
        } catch (Throwable th2) {
            byteBuf.release();
            throw th2;
        }
    }

    private static int opensslSelectorFailureBehavior(ApplicationProtocolConfig.SelectorFailureBehavior selectorFailureBehavior) {
        int i10 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[selectorFailureBehavior.ordinal()];
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        throw new Error();
    }

    public static OpenSslKeyMaterialProvider providerFor(KeyManagerFactory keyManagerFactory, String str) {
        if (keyManagerFactory instanceof OpenSslX509KeyManagerFactory) {
            return ((OpenSslX509KeyManagerFactory) keyManagerFactory).newProvider();
        }
        return keyManagerFactory instanceof OpenSslCachingX509KeyManagerFactory ? ((OpenSslCachingX509KeyManagerFactory) keyManagerFactory).newProvider(str) : new OpenSslKeyMaterialProvider(chooseX509KeyManager(keyManagerFactory.getKeyManagers()), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ReferenceCountedOpenSslEngine retrieveEngine(OpenSslEngineMap openSslEngineMap, long j10) throws SSLException {
        ReferenceCountedOpenSslEngine referenceCountedOpenSslEngine = openSslEngineMap.get(j10);
        if (referenceCountedOpenSslEngine != null) {
            return referenceCountedOpenSslEngine;
        }
        throw new SSLException("Could not find a " + StringUtil.simpleClassName((Class<?>) ReferenceCountedOpenSslEngine.class) + " for sslPointer " + j10);
    }

    /* JADX WARN: Code duplicated, block: B:54:0x009c  */
    public static void setKeyMaterial(long j10, X509Certificate[] x509CertificateArr, PrivateKey privateKey, String str) throws Throwable {
        long j11;
        long bio;
        long bio2 = 0;
        PemEncoded pem = null;
        try {
            try {
                ByteBufAllocator byteBufAllocator = ByteBufAllocator.DEFAULT;
                pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
                try {
                    bio = toBIO(byteBufAllocator, pem.retain());
                    try {
                        long bio3 = toBIO(byteBufAllocator, pem.retain());
                        if (privateKey != null) {
                            try {
                                bio2 = toBIO(byteBufAllocator, privateKey);
                            } catch (SSLException e10) {
                                throw e10;
                            } catch (Exception e11) {
                                e = e11;
                                throw new SSLException("failed to set certificate and key", e);
                            }
                        }
                        try {
                            SSLContext.setCertificateBio(j10, bio, bio2, str == null ? "" : str);
                            SSLContext.setCertificateChainBio(j10, bio3, true);
                            freeBio(bio2);
                            freeBio(bio);
                            freeBio(bio3);
                            pem.release();
                        } catch (SSLException e12) {
                            throw e12;
                        } catch (Exception e13) {
                            e = e13;
                            throw new SSLException("failed to set certificate and key", e);
                        } catch (Throwable th2) {
                            th = th2;
                            j11 = bio3;
                            pem = pem;
                            freeBio(bio2);
                            freeBio(bio);
                            freeBio(j11);
                            if (pem != null) {
                                pem.release();
                            }
                            throw th;
                        }
                    } catch (SSLException e14) {
                        throw e14;
                    } catch (Exception e15) {
                        e = e15;
                    } catch (Throwable th3) {
                        th = th3;
                        j11 = 0;
                    }
                } catch (SSLException e16) {
                    e = e16;
                    throw e;
                } catch (Exception e17) {
                    e = e17;
                    throw new SSLException("failed to set certificate and key", e);
                } catch (Throwable th4) {
                    th = th4;
                    j11 = 0;
                    bio = 0;
                    freeBio(bio2);
                    freeBio(bio);
                    freeBio(j11);
                    if (pem != null) {
                        pem.release();
                    }
                    throw th;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (SSLException e18) {
            e = e18;
        } catch (Exception e19) {
            e = e19;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, PrivateKey privateKey) throws Exception {
        if (privateKey == null) {
            return 0L;
        }
        PemEncoded pem = PemPrivateKey.toPEM(byteBufAllocator, true, privateKey);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    public static OpenSslApplicationProtocolNegotiator toNegotiator(ApplicationProtocolConfig applicationProtocolConfig) {
        if (applicationProtocolConfig == null) {
            return NONE_PROTOCOL_NEGOTIATOR;
        }
        int i10 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[applicationProtocolConfig.protocol().ordinal()];
        if (i10 != 1 && i10 != 2 && i10 != 3) {
            if (i10 == 4) {
                return NONE_PROTOCOL_NEGOTIATOR;
            }
            throw new Error();
        }
        int i11 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectedListenerFailureBehavior[applicationProtocolConfig.selectedListenerFailureBehavior().ordinal()];
        if (i11 != 1 && i11 != 2) {
            throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectedListenerFailureBehavior() + " behavior");
        }
        int i12 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$SelectorFailureBehavior[applicationProtocolConfig.selectorFailureBehavior().ordinal()];
        if (i12 == 1 || i12 == 2) {
            return new OpenSslDefaultApplicationProtocolNegotiator(applicationProtocolConfig);
        }
        throw new UnsupportedOperationException("OpenSSL provider does not support " + applicationProtocolConfig.selectorFailureBehavior() + " behavior");
    }

    @SuppressJava6Requirement(reason = "Guarded by java version check")
    public static boolean useExtendedTrustManager(X509TrustManager x509TrustManager) {
        return PlatformDependent.javaVersion() >= 7 && (x509TrustManager instanceof X509ExtendedTrustManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] verifyResult(byte[] bArr) throws SignatureException {
        if (bArr != null) {
            return bArr;
        }
        throw new SignatureException();
    }

    @Override // io.netty.handler.ssl.SslContext
    public ApplicationProtocolNegotiator applicationProtocolNegotiator() {
        return this.apn;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final List<String> cipherSuites() {
        return this.unmodifiableCiphers;
    }

    @Deprecated
    public final long context() {
        return sslCtxPointer();
    }

    public int getBioNonApplicationBufferSize() {
        return this.bioNonApplicationBufferSize;
    }

    @Deprecated
    public boolean getRejectRemoteInitiatedRenegotiation() {
        return true;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final boolean isClient() {
        return this.mode == 0;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator, String str, int i10) {
        return newEngine0(byteBufAllocator, str, i10, true);
    }

    public SSLEngine newEngine0(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10) {
        return new ReferenceCountedOpenSslEngine(this, byteBufAllocator, str, i10, z10, true);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z10) {
        return new SslHandler(newEngine0(byteBufAllocator, null, -1, false), z10);
    }

    @Override // io.netty.util.ReferenceCounted
    public final int refCnt() {
        return this.refCnt.refCnt();
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release() {
        return this.refCnt.release();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain() {
        this.refCnt.retain();
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public abstract OpenSslSessionContext sessionContext();

    public void setBioNonApplicationBufferSize(int i10) {
        this.bioNonApplicationBufferSize = ObjectUtil.checkPositiveOrZero(i10, "bioNonApplicationBufferSize");
    }

    @Deprecated
    public final void setPrivateKeyMethod(OpenSslPrivateKeyMethod openSslPrivateKeyMethod) {
        ObjectUtil.checkNotNull(openSslPrivateKeyMethod, "method");
        Lock lockWriteLock = this.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.setPrivateKeyMethod(this.ctx, new PrivateKeyMethod(this.engineMap, openSslPrivateKeyMethod));
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Deprecated
    public void setRejectRemoteInitiatedRenegotiation(boolean z10) {
        if (!z10) {
            throw new UnsupportedOperationException("Renegotiation is not supported");
        }
    }

    @Deprecated
    public final void setTicketKeys(byte[] bArr) {
        sessionContext().setTicketKeys(bArr);
    }

    @Deprecated
    public final void setUseTasks(boolean z10) {
        Lock lockWriteLock = this.ctxLock.writeLock();
        lockWriteLock.lock();
        try {
            SSLContext.setUseTasks(this.ctx, z10);
        } finally {
            lockWriteLock.unlock();
        }
    }

    @Deprecated
    public final long sslCtxPointer() {
        Lock lock = this.ctxLock.readLock();
        lock.lock();
        try {
            return SSLContext.getSslCtx(this.ctx);
        } finally {
            lock.unlock();
        }
    }

    @Deprecated
    public final OpenSslSessionStats stats() {
        return sessionContext().stats();
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SSLEngine newEngine(ByteBufAllocator byteBufAllocator) {
        return newEngine(byteBufAllocator, null, -1);
    }

    @Override // io.netty.handler.ssl.SslContext
    public final SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i10, false), z10);
    }

    @Override // io.netty.util.ReferenceCounted
    public final boolean release(int i10) {
        return this.refCnt.release(i10);
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted retain(int i10) {
        this.refCnt.retain(i10);
        return this;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch(Object obj) {
        this.refCnt.touch(obj);
        return this;
    }

    @Override // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, boolean z10, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, null, -1, false), z10, executor);
    }

    @Override // io.netty.handler.ssl.SslContext
    public SslHandler newHandler(ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10, Executor executor) {
        return new SslHandler(newEngine0(byteBufAllocator, str, i10, false), executor);
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, X509Certificate... x509CertificateArr) throws Exception {
        if (x509CertificateArr == null) {
            return 0L;
        }
        ObjectUtil.checkNonEmpty(x509CertificateArr, "certChain");
        PemEncoded pem = PemX509Certificate.toPEM(byteBufAllocator, true, x509CertificateArr);
        try {
            return toBIO(byteBufAllocator, pem.retain());
        } finally {
            pem.release();
        }
    }

    public static long toBIO(ByteBufAllocator byteBufAllocator, PemEncoded pemEncoded) throws Exception {
        try {
            ByteBuf byteBufContent = pemEncoded.content();
            if (byteBufContent.isDirect()) {
                long jNewBIO = newBIO(byteBufContent.retainedSlice());
                pemEncoded.release();
                return jNewBIO;
            }
            ByteBuf byteBufDirectBuffer = byteBufAllocator.directBuffer(byteBufContent.readableBytes());
            try {
                byteBufDirectBuffer.writeBytes(byteBufContent, byteBufContent.readerIndex(), byteBufContent.readableBytes());
                long jNewBIO2 = newBIO(byteBufDirectBuffer.retainedSlice());
                try {
                    if (pemEncoded.isSensitive()) {
                        SslUtils.zeroout(byteBufDirectBuffer);
                    }
                    byteBufDirectBuffer.release();
                    pemEncoded.release();
                    return jNewBIO2;
                } catch (Throwable th2) {
                    byteBufDirectBuffer.release();
                    throw th2;
                }
            } catch (Throwable th3) {
                try {
                    if (pemEncoded.isSensitive()) {
                        SslUtils.zeroout(byteBufDirectBuffer);
                    }
                    throw th3;
                } finally {
                    byteBufDirectBuffer.release();
                }
            }
        } catch (Throwable th4) {
            pemEncoded.release();
            throw th4;
        }
    }
}
