package io.netty.handler.ssl;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.ssl.util.LazyJavaxX509Certificate;
import io.netty.handler.ssl.util.LazyX509Certificate;
import io.netty.internal.tcnative.AsyncTask;
import io.netty.internal.tcnative.Buffer;
import io.netty.internal.tcnative.SSL;
import io.netty.util.AbstractReferenceCounted;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.ResourceLeakDetector;
import io.netty.util.ResourceLeakDetectorFactory;
import io.netty.util.ResourceLeakTracker;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.SuppressJava6Requirement;
import io.netty.util.internal.ThrowableUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ReadOnlyBufferException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionBindingEvent;
import javax.net.ssl.SSLSessionBindingListener;
import javax.security.cert.X509Certificate;
import n.a;
import rs.f;

/* JADX INFO: loaded from: classes3.dex */
public class ReferenceCountedOpenSslEngine extends SSLEngine implements ReferenceCounted, ApplicationProtocolAccessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final SSLEngineResult CLOSED_NOT_HANDSHAKING;
    private static final X509Certificate[] JAVAX_CERTS_NOT_SUPPORTED;
    private static final SSLEngineResult NEED_UNWRAP_CLOSED;
    private static final SSLEngineResult NEED_UNWRAP_OK;
    private static final SSLEngineResult NEED_WRAP_CLOSED;
    private static final SSLEngineResult NEED_WRAP_OK;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV2 = 0;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_SSLV3 = 1;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1 = 2;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_1 = 3;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_2 = 4;
    private static final int OPENSSL_OP_NO_PROTOCOL_INDEX_TLSv1_3 = 5;
    private Object algorithmConstraints;
    final ByteBufAllocator alloc;
    private final OpenSslApplicationProtocolNegotiator apn;
    private volatile String applicationProtocol;
    private volatile ClientAuth clientAuth;
    private final boolean clientMode;
    private volatile boolean destroyed;
    private final boolean enableOcsp;
    private String endPointIdentificationAlgorithm;
    private final OpenSslEngineMap engineMap;
    private String[] explicitlyEnabledProtocols;
    private HandshakeState handshakeState;
    private boolean isInboundDone;
    final boolean jdkCompatibilityMode;
    private volatile long lastAccessed;
    private final ResourceLeakTracker<ReferenceCountedOpenSslEngine> leak;
    private volatile Collection<?> matchers;
    private int maxWrapBufferSize;
    private int maxWrapOverhead;
    private volatile boolean needTask;
    private long networkBIO;
    private boolean outboundClosed;
    private final ReferenceCountedOpenSslContext parentContext;
    private Throwable pendingException;
    private boolean receivedShutdown;
    private final AbstractReferenceCounted refCnt;
    private final OpenSslSession session;
    private boolean sessionSet;
    private final ByteBuffer[] singleDstBuffer;
    private final ByteBuffer[] singleSrcBuffer;
    private List<String> sniHostNames;
    private long ssl;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) ReferenceCountedOpenSslEngine.class);
    private static final ResourceLeakDetector<ReferenceCountedOpenSslEngine> leakDetector = ResourceLeakDetectorFactory.instance().newResourceLeakDetector(ReferenceCountedOpenSslEngine.class);
    private static final int[] OPENSSL_OP_NO_PROTOCOLS = {SSL.SSL_OP_NO_SSLv2, SSL.SSL_OP_NO_SSLv3, SSL.SSL_OP_NO_TLSv1, SSL.SSL_OP_NO_TLSv1_1, SSL.SSL_OP_NO_TLSv1_2, SSL.SSL_OP_NO_TLSv1_3};
    static final int MAX_PLAINTEXT_LENGTH = SSL.SSL_MAX_PLAINTEXT_LENGTH;
    static final int MAX_RECORD_SIZE = SSL.SSL_MAX_RECORD_LENGTH;

    /* JADX INFO: renamed from: io.netty.handler.ssl.ReferenceCountedOpenSslEngine$3, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ClientAuth;
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState;

        static {
            int[] iArr = new int[ApplicationProtocolConfig.Protocol.values().length];
            $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol = iArr;
            try {
                iArr[ApplicationProtocolConfig.Protocol.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.ALPN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[ApplicationProtocolConfig.Protocol.NPN_AND_ALPN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ClientAuth.values().length];
            $SwitchMap$io$netty$handler$ssl$ClientAuth = iArr2;
            try {
                iArr2[ClientAuth.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.REQUIRE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ClientAuth[ClientAuth.OPTIONAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[HandshakeState.values().length];
            $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState = iArr3;
            try {
                iArr3[HandshakeState.NOT_STARTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_IMPLICITLY.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[HandshakeState.STARTED_EXPLICITLY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    public final class AsyncTaskDecorator extends TaskDecorator<AsyncTask> implements AsyncRunnable {
        public AsyncTaskDecorator(AsyncTask asyncTask) {
            super(asyncTask);
        }

        @Override // io.netty.handler.ssl.AsyncRunnable
        public void run(Runnable runnable) {
            if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                return;
            }
            this.task.runAsync(ReferenceCountedOpenSslEngine.this.new TaskDecorator(runnable));
        }
    }

    public final class DefaultOpenSslSession implements OpenSslSession {
        private String cipher;
        private volatile long creationTime;
        private volatile Certificate[] localCertificateChain;
        private Certificate[] peerCerts;
        private String protocol;
        private final OpenSslSessionContext sessionContext;
        private Map<String, Object> values;
        private X509Certificate[] x509PeerCerts;
        private boolean valid = true;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private OpenSslSessionId f8334id = OpenSslSessionId.NULL_ID;
        private volatile int applicationBufferSize = ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH;

        public DefaultOpenSslSession(OpenSslSessionContext openSslSessionContext) {
            this.sessionContext = openSslSessionContext;
        }

        private void initCerts(byte[][] bArr, int i10) {
            for (int i11 = 0; i11 < bArr.length; i11++) {
                int i12 = i10 + i11;
                this.peerCerts[i12] = new LazyX509Certificate(bArr[i11]);
                if (this.x509PeerCerts != ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED) {
                    this.x509PeerCerts[i12] = new LazyJavaxX509Certificate(bArr[i11]);
                }
            }
        }

        private SSLSessionBindingEvent newSSLSessionBindingEvent(String str) {
            return new SSLSessionBindingEvent(ReferenceCountedOpenSslEngine.this.session, str);
        }

        private void notifyUnbound(Object obj, String str) {
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueUnbound(newSSLSessionBindingEvent(str));
            }
        }

        @Override // javax.net.ssl.SSLSession
        public int getApplicationBufferSize() {
            return this.applicationBufferSize;
        }

        @Override // javax.net.ssl.SSLSession
        public String getCipherSuite() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    String str = this.cipher;
                    return str == null ? "SSL_NULL_WITH_NULL_NULL" : str;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public long getCreationTime() {
            long j10;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                j10 = this.creationTime;
            }
            return j10;
        }

        @Override // javax.net.ssl.SSLSession
        public byte[] getId() {
            return sessionId().cloneBytes();
        }

        @Override // javax.net.ssl.SSLSession
        public long getLastAccessedTime() {
            long j10 = ReferenceCountedOpenSslEngine.this.lastAccessed;
            return j10 == -1 ? getCreationTime() : j10;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getLocalCertificates() {
            Certificate[] certificateArr = this.localCertificateChain;
            if (certificateArr == null) {
                return null;
            }
            return (Certificate[]) certificateArr.clone();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getLocalPrincipal() {
            Certificate[] certificateArr = this.localCertificateChain;
            if (certificateArr == null || certificateArr.length == 0) {
                return null;
            }
            return ((java.security.cert.X509Certificate) certificateArr[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPacketBufferSize() {
            return SSL.SSL_MAX_ENCRYPTED_LENGTH;
        }

        @Override // javax.net.ssl.SSLSession
        public X509Certificate[] getPeerCertificateChain() throws SSLPeerUnverifiedException {
            X509Certificate[] x509CertificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.x509PeerCerts == ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED) {
                        throw new UnsupportedOperationException();
                    }
                    if (ReferenceCountedOpenSslEngine.isEmpty(this.x509PeerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    x509CertificateArr = (X509Certificate[]) this.x509PeerCerts.clone();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return x509CertificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
            Certificate[] certificateArr;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.isEmpty(this.peerCerts)) {
                        throw new SSLPeerUnverifiedException("peer not verified");
                    }
                    certificateArr = (Certificate[]) this.peerCerts.clone();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return certificateArr;
        }

        @Override // javax.net.ssl.SSLSession
        public String getPeerHost() {
            return ReferenceCountedOpenSslEngine.this.getPeerHost();
        }

        @Override // javax.net.ssl.SSLSession
        public int getPeerPort() {
            return ReferenceCountedOpenSslEngine.this.getPeerPort();
        }

        @Override // javax.net.ssl.SSLSession
        public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
            return ((java.security.cert.X509Certificate) getPeerCertificates()[0]).getSubjectX500Principal();
        }

        @Override // javax.net.ssl.SSLSession
        public String getProtocol() {
            String version = this.protocol;
            if (version == null) {
                synchronized (ReferenceCountedOpenSslEngine.this) {
                    try {
                        version = !ReferenceCountedOpenSslEngine.this.isDestroyed() ? SSL.getVersion(ReferenceCountedOpenSslEngine.this.ssl) : "";
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return version;
        }

        @Override // javax.net.ssl.SSLSession
        public Object getValue(String str) {
            ObjectUtil.checkNotNull(str, "name");
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return null;
                    }
                    return map.get(str);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public String[] getValueNames() {
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map != null && !map.isEmpty()) {
                        return (String[]) map.keySet().toArray(EmptyArrays.EMPTY_STRINGS);
                    }
                    return EmptyArrays.EMPTY_STRINGS;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void handshakeFinished(byte[] bArr, String str, String str2, byte[] bArr2, byte[][] bArr3, long j10, long j11) throws SSLException {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (ReferenceCountedOpenSslEngine.this.isDestroyed()) {
                        throw new SSLException("Already closed");
                    }
                    this.creationTime = j10;
                    OpenSslSessionId openSslSessionId = this.f8334id;
                    OpenSslSessionId openSslSessionId2 = OpenSslSessionId.NULL_ID;
                    if (openSslSessionId == openSslSessionId2) {
                        if (bArr != null) {
                            openSslSessionId2 = new OpenSslSessionId(bArr);
                        }
                        this.f8334id = openSslSessionId2;
                    }
                    this.cipher = ReferenceCountedOpenSslEngine.this.toJavaCipherSuite(str);
                    this.protocol = str2;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        if (ReferenceCountedOpenSslEngine.isEmpty(bArr3)) {
                            this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                            if (OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED) {
                                this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                            } else {
                                this.x509PeerCerts = ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                            }
                        } else {
                            this.peerCerts = new Certificate[bArr3.length];
                            if (OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED) {
                                this.x509PeerCerts = new X509Certificate[bArr3.length];
                            } else {
                                this.x509PeerCerts = ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                            }
                            initCerts(bArr3, 0);
                        }
                    } else if (ReferenceCountedOpenSslEngine.isEmpty(bArr2)) {
                        this.peerCerts = EmptyArrays.EMPTY_CERTIFICATES;
                        this.x509PeerCerts = EmptyArrays.EMPTY_JAVAX_X509_CERTIFICATES;
                    } else if (ReferenceCountedOpenSslEngine.isEmpty(bArr3)) {
                        this.peerCerts = new Certificate[]{new LazyX509Certificate(bArr2)};
                        if (OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED) {
                            this.x509PeerCerts = new X509Certificate[]{new LazyJavaxX509Certificate(bArr2)};
                        } else {
                            this.x509PeerCerts = ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                        }
                    } else {
                        Certificate[] certificateArr = new Certificate[bArr3.length + 1];
                        this.peerCerts = certificateArr;
                        certificateArr[0] = new LazyX509Certificate(bArr2);
                        if (OpenSsl.JAVAX_CERTIFICATE_CREATION_SUPPORTED) {
                            X509Certificate[] x509CertificateArr = new X509Certificate[bArr3.length + 1];
                            this.x509PeerCerts = x509CertificateArr;
                            x509CertificateArr[0] = new LazyJavaxX509Certificate(bArr2);
                        } else {
                            this.x509PeerCerts = ReferenceCountedOpenSslEngine.JAVAX_CERTS_NOT_SUPPORTED;
                        }
                        initCerts(bArr3, 1);
                    }
                    ReferenceCountedOpenSslEngine.this.calculateMaxWrapOverhead();
                    ReferenceCountedOpenSslEngine.this.handshakeState = HandshakeState.FINISHED;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public void invalidate() {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                this.valid = false;
                this.sessionContext.removeFromCache(this.f8334id);
            }
        }

        @Override // javax.net.ssl.SSLSession
        public boolean isValid() {
            boolean z10;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    z10 = this.valid || this.sessionContext.isInCache(this.f8334id);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return z10;
        }

        @Override // javax.net.ssl.SSLSession
        public void putValue(String str, Object obj) {
            Object objPut;
            ObjectUtil.checkNotNull(str, "name");
            ObjectUtil.checkNotNull(obj, "value");
            synchronized (this) {
                try {
                    Map map = this.values;
                    if (map == null) {
                        map = new HashMap(2);
                        this.values = map;
                    }
                    objPut = map.put(str, obj);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (obj instanceof SSLSessionBindingListener) {
                ((SSLSessionBindingListener) obj).valueBound(newSSLSessionBindingEvent(str));
            }
            notifyUnbound(objPut, str);
        }

        @Override // javax.net.ssl.SSLSession
        public void removeValue(String str) {
            ObjectUtil.checkNotNull(str, "name");
            synchronized (this) {
                try {
                    Map<String, Object> map = this.values;
                    if (map == null) {
                        return;
                    }
                    notifyUnbound(map.remove(str), str);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public OpenSslSessionId sessionId() {
            OpenSslSessionId openSslSessionId;
            byte[] sessionId;
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.f8334id == OpenSslSessionId.NULL_ID && !ReferenceCountedOpenSslEngine.this.isDestroyed() && (sessionId = SSL.getSessionId(ReferenceCountedOpenSslEngine.this.ssl)) != null) {
                        this.f8334id = new OpenSslSessionId(sessionId);
                    }
                    openSslSessionId = this.f8334id;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return openSslSessionId;
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void setLocalCertificate(Certificate[] certificateArr) {
            this.localCertificateChain = certificateArr;
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void setSessionId(OpenSslSessionId openSslSessionId) {
            synchronized (ReferenceCountedOpenSslEngine.this) {
                try {
                    if (this.f8334id == OpenSslSessionId.NULL_ID) {
                        this.f8334id = openSslSessionId;
                        this.creationTime = System.currentTimeMillis();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public String toString() {
            return "DefaultOpenSslSession{sessionContext=" + this.sessionContext + ", id=" + this.f8334id + f.f14860b;
        }

        @Override // io.netty.handler.ssl.OpenSslSession
        public void tryExpandApplicationBufferSize(int i10) {
            if (i10 > ReferenceCountedOpenSslEngine.MAX_PLAINTEXT_LENGTH) {
                int i11 = this.applicationBufferSize;
                int i12 = ReferenceCountedOpenSslEngine.MAX_RECORD_SIZE;
                if (i11 != i12) {
                    this.applicationBufferSize = i12;
                }
            }
        }

        @Override // javax.net.ssl.SSLSession
        public OpenSslSessionContext getSessionContext() {
            return this.sessionContext;
        }
    }

    public enum HandshakeState {
        NOT_STARTED,
        STARTED_IMPLICITLY,
        STARTED_EXPLICITLY,
        FINISHED
    }

    public interface NativeSslException {
        int errorCode();
    }

    public static final class OpenSslException extends SSLException implements NativeSslException {
        private final int errorCode;

        public OpenSslException(String str, int i10) {
            super(str);
            this.errorCode = i10;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslEngine.NativeSslException
        public int errorCode() {
            return this.errorCode;
        }
    }

    public static final class OpenSslHandshakeException extends SSLHandshakeException implements NativeSslException {
        private final int errorCode;

        public OpenSslHandshakeException(String str, int i10) {
            super(str);
            this.errorCode = i10;
        }

        @Override // io.netty.handler.ssl.ReferenceCountedOpenSslEngine.NativeSslException
        public int errorCode() {
            return this.errorCode;
        }
    }

    public class TaskDecorator<R extends Runnable> implements Runnable {
        protected final R task;

        public TaskDecorator(R r10) {
            this.task = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReferenceCountedOpenSslEngine.this.runAndResetNeedTask(this.task);
        }
    }

    static {
        SSLEngineResult.Status status = SSLEngineResult.Status.OK;
        SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
        NEED_UNWRAP_OK = new SSLEngineResult(status, handshakeStatus, 0, 0);
        SSLEngineResult.Status status2 = SSLEngineResult.Status.CLOSED;
        NEED_UNWRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus, 0, 0);
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.NEED_WRAP;
        NEED_WRAP_OK = new SSLEngineResult(status, handshakeStatus2, 0, 0);
        NEED_WRAP_CLOSED = new SSLEngineResult(status2, handshakeStatus2, 0, 0);
        CLOSED_NOT_HANDSHAKING = new SSLEngineResult(status2, SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
        JAVAX_CERTS_NOT_SUPPORTED = new X509Certificate[0];
    }

    public ReferenceCountedOpenSslEngine(ReferenceCountedOpenSslContext referenceCountedOpenSslContext, ByteBufAllocator byteBufAllocator, String str, int i10, boolean z10, boolean z11) {
        super(str, i10);
        this.handshakeState = HandshakeState.NOT_STARTED;
        this.refCnt = new AbstractReferenceCounted() { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.1
            static final /* synthetic */ boolean $assertionsDisabled = false;

            @Override // io.netty.util.AbstractReferenceCounted
            public void deallocate() {
                ReferenceCountedOpenSslEngine.this.shutdown();
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.close(ReferenceCountedOpenSslEngine.this);
                }
                ReferenceCountedOpenSslEngine.this.parentContext.release();
            }

            @Override // io.netty.util.ReferenceCounted
            public ReferenceCounted touch(Object obj) {
                if (ReferenceCountedOpenSslEngine.this.leak != null) {
                    ReferenceCountedOpenSslEngine.this.leak.record(obj);
                }
                return ReferenceCountedOpenSslEngine.this;
            }
        };
        ClientAuth clientAuth = ClientAuth.NONE;
        this.clientAuth = clientAuth;
        this.lastAccessed = -1L;
        this.singleSrcBuffer = new ByteBuffer[1];
        this.singleDstBuffer = new ByteBuffer[1];
        OpenSsl.ensureAvailability();
        this.engineMap = referenceCountedOpenSslContext.engineMap;
        boolean z12 = referenceCountedOpenSslContext.enableOcsp;
        this.enableOcsp = z12;
        this.jdkCompatibilityMode = z10;
        this.alloc = (ByteBufAllocator) ObjectUtil.checkNotNull(byteBufAllocator, "alloc");
        this.apn = (OpenSslApplicationProtocolNegotiator) referenceCountedOpenSslContext.applicationProtocolNegotiator();
        boolean zIsClient = referenceCountedOpenSslContext.isClient();
        this.clientMode = zIsClient;
        if (PlatformDependent.javaVersion() >= 7) {
            this.session = new ExtendedOpenSslSession(new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext())) { // from class: io.netty.handler.ssl.ReferenceCountedOpenSslEngine.2
                private String[] peerSupportedSignatureAlgorithms;
                private List requestedServerNames;

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public String[] getPeerSupportedSignatureAlgorithms() {
                    String[] strArr;
                    String[] sigAlgs;
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.peerSupportedSignatureAlgorithms == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed() || (sigAlgs = SSL.getSigAlgs(ReferenceCountedOpenSslEngine.this.ssl)) == null) {
                                    this.peerSupportedSignatureAlgorithms = EmptyArrays.EMPTY_STRINGS;
                                } else {
                                    LinkedHashSet linkedHashSet = new LinkedHashSet(sigAlgs.length);
                                    for (String str2 : sigAlgs) {
                                        String javaName = SignatureAlgorithmConverter.toJavaName(str2);
                                        if (javaName != null) {
                                            linkedHashSet.add(javaName);
                                        }
                                    }
                                    this.peerSupportedSignatureAlgorithms = (String[]) linkedHashSet.toArray(EmptyArrays.EMPTY_STRINGS);
                                }
                            }
                            strArr = (String[]) this.peerSupportedSignatureAlgorithms.clone();
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return strArr;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession, javax.net.ssl.ExtendedSSLSession
                public List getRequestedServerNames() {
                    List list;
                    if (ReferenceCountedOpenSslEngine.this.clientMode) {
                        return Java8SslUtils.getSniHostNames((List<String>) ReferenceCountedOpenSslEngine.this.sniHostNames);
                    }
                    synchronized (ReferenceCountedOpenSslEngine.this) {
                        try {
                            if (this.requestedServerNames == null) {
                                if (ReferenceCountedOpenSslEngine.this.isDestroyed() || SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl) == null) {
                                    this.requestedServerNames = Collections.emptyList();
                                } else {
                                    this.requestedServerNames = Java8SslUtils.getSniHostName(SSL.getSniHostname(ReferenceCountedOpenSslEngine.this.ssl).getBytes(CharsetUtil.UTF_8));
                                }
                            }
                            list = this.requestedServerNames;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    return list;
                }

                @Override // io.netty.handler.ssl.ExtendedOpenSslSession
                public List<byte[]> getStatusResponses() {
                    byte[] ocspResponse = null;
                    if (ReferenceCountedOpenSslEngine.this.enableOcsp && ReferenceCountedOpenSslEngine.this.clientMode) {
                        synchronized (ReferenceCountedOpenSslEngine.this) {
                            try {
                                ocspResponse = ReferenceCountedOpenSslEngine.this.isDestroyed() ? null : SSL.getOcspResponse(ReferenceCountedOpenSslEngine.this.ssl);
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                    }
                    return ocspResponse == null ? Collections.emptyList() : Collections.singletonList(ocspResponse);
                }
            };
        } else {
            this.session = new DefaultOpenSslSession(referenceCountedOpenSslContext.sessionContext());
        }
        if (!referenceCountedOpenSslContext.sessionContext().useKeyManager()) {
            this.session.setLocalCertificate(referenceCountedOpenSslContext.keyCertChain);
        }
        Lock lock = referenceCountedOpenSslContext.ctxLock.readLock();
        lock.lock();
        try {
            long jNewSSL = SSL.newSSL(referenceCountedOpenSslContext.ctx, !referenceCountedOpenSslContext.isClient());
            lock.unlock();
            synchronized (this) {
                this.ssl = jNewSSL;
                try {
                    this.networkBIO = SSL.bioNewByteBuffer(jNewSSL, referenceCountedOpenSslContext.getBioNonApplicationBufferSize());
                    if (!zIsClient) {
                        clientAuth = referenceCountedOpenSslContext.clientAuth;
                    }
                    setClientAuth(clientAuth);
                    String[] strArr = referenceCountedOpenSslContext.protocols;
                    if (strArr != null) {
                        setEnabledProtocols0(strArr, true);
                    } else {
                        this.explicitlyEnabledProtocols = getEnabledProtocols();
                    }
                    if (zIsClient && SslUtils.isValidHostNameForSNI(str) && (PlatformDependent.javaVersion() < 8 || Java8SslUtils.isValidHostNameForSNI(str))) {
                        SSL.setTlsExtHostName(this.ssl, str);
                        this.sniHostNames = Collections.singletonList(str);
                    }
                    if (z12) {
                        SSL.enableOcsp(this.ssl);
                    }
                    if (!z10) {
                        long j10 = this.ssl;
                        SSL.setMode(j10, SSL.getMode(j10) | SSL.SSL_MODE_ENABLE_PARTIAL_WRITE);
                    }
                    if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                        if (zIsClient ? ReferenceCountedOpenSslContext.CLIENT_ENABLE_SESSION_TICKET_TLSV13 : ReferenceCountedOpenSslContext.SERVER_ENABLE_SESSION_TICKET_TLSV13) {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_TICKET);
                        }
                    }
                    if (OpenSsl.isBoringSSL() && zIsClient) {
                        SSL.setRenegotiateMode(this.ssl, SSL.SSL_RENEGOTIATE_ONCE);
                    }
                    calculateMaxWrapOverhead();
                } catch (Throwable th2) {
                    shutdown();
                    PlatformDependent.throwException(th2);
                }
            }
            this.parentContext = referenceCountedOpenSslContext;
            referenceCountedOpenSslContext.retain();
            this.leak = z11 ? leakDetector.track(this) : null;
        } catch (Throwable th3) {
            lock.unlock();
            throw th3;
        }
    }

    private static long bufferAddress(ByteBuffer byteBuffer) {
        return PlatformDependent.hasUnsafe() ? PlatformDependent.directBufferAddress(byteBuffer) : Buffer.address(byteBuffer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void calculateMaxWrapOverhead() {
        this.maxWrapOverhead = SSL.getMaxWrapOverhead(this.ssl);
        this.maxWrapBufferSize = this.jdkCompatibilityMode ? maxEncryptedPacketLength0() : maxEncryptedPacketLength0() << 4;
    }

    private void checkEngineClosed() throws SSLException {
        if (isDestroyed()) {
            throw new SSLException("engine closed");
        }
    }

    private void closeAll() throws SSLException {
        this.receivedShutdown = true;
        closeOutbound();
        closeInbound();
    }

    private boolean doSSLShutdown() {
        if (SSL.isInInit(this.ssl) != 0) {
            return false;
        }
        int iShutdownSSL = SSL.shutdownSSL(this.ssl);
        if (iShutdownSSL >= 0) {
            return true;
        }
        int error = SSL.getError(this.ssl, iShutdownSSL);
        if (error != SSL.SSL_ERROR_SYSCALL && error != SSL.SSL_ERROR_SSL) {
            SSL.clearError();
            return true;
        }
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            int lastErrorNumber = SSL.getLastErrorNumber();
            internalLogger.debug("SSL_shutdown failed: OpenSSL error: {} {}", Integer.valueOf(lastErrorNumber), SSL.getErrorString(lastErrorNumber));
        }
        shutdown();
        return false;
    }

    private SSLEngineResult handleUnwrapException(int i10, int i11, SSLException sSLException) throws SSLException {
        int lastErrorNumber = SSL.getLastErrorNumber();
        if (lastErrorNumber != 0) {
            return sslReadErrorResult(SSL.SSL_ERROR_SSL, lastErrorNumber, i10, i11);
        }
        throw sSLException;
    }

    private SSLEngineResult.HandshakeStatus handshake() throws SSLException {
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (this.handshakeState == HandshakeState.FINISHED) {
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        checkEngineClosed();
        if (this.pendingException != null) {
            if (SSL.doHandshake(this.ssl) <= 0) {
                SSL.clearError();
            }
            return handshakeException();
        }
        this.engineMap.add(this);
        if (!this.sessionSet) {
            this.parentContext.sessionContext().setSessionFromCache(getPeerHost(), getPeerPort(), this.ssl);
            this.sessionSet = true;
        }
        if (this.lastAccessed == -1) {
            this.lastAccessed = System.currentTimeMillis();
        }
        int iDoHandshake = SSL.doHandshake(this.ssl);
        if (iDoHandshake > 0) {
            if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
            this.session.handshakeFinished(SSL.getSessionId(this.ssl), SSL.getCipherForSSL(this.ssl), SSL.getVersion(this.ssl), SSL.getPeerCertificate(this.ssl), SSL.getPeerCertChain(this.ssl), SSL.getTime(this.ssl) * 1000, 1000 * this.parentContext.sessionTimeout());
            selectApplicationProtocol();
            return SSLEngineResult.HandshakeStatus.FINISHED;
        }
        int error = SSL.getError(this.ssl, iDoHandshake);
        if (error == SSL.SSL_ERROR_WANT_READ || error == SSL.SSL_ERROR_WANT_WRITE) {
            return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
        }
        if (error == SSL.SSL_ERROR_WANT_X509_LOOKUP || error == SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY || error == SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        if (needWrapAgain(SSL.getLastErrorNumber())) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        if (this.pendingException != null) {
            return handshakeException();
        }
        throw shutdownWithError("SSL_do_handshake", error);
    }

    private SSLEngineResult.HandshakeStatus handshakeException() throws SSLException {
        if (SSL.bioLengthNonApplication(this.networkBIO) > 0) {
            return SSLEngineResult.HandshakeStatus.NEED_WRAP;
        }
        Throwable th2 = this.pendingException;
        this.pendingException = null;
        shutdown();
        if (th2 instanceof SSLHandshakeException) {
            throw ((SSLHandshakeException) th2);
        }
        SSLHandshakeException sSLHandshakeException = new SSLHandshakeException("General OpenSslEngine problem");
        sSLHandshakeException.initCause(th2);
        throw sSLHandshakeException;
    }

    private boolean isBytesAvailableEnoughForWrap(int i10, int i11, int i12) {
        return ((long) i10) - (((long) this.maxWrapOverhead) * ((long) i12)) >= ((long) i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isDestroyed() {
        return this.destroyed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    private static boolean isEndPointVerificationEnabled(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private static boolean isProtocolEnabled(int i10, int i11, String str) {
        return (i10 & i11) == 0 && OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str);
    }

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i10, int i11) throws SSLException {
        if ((handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_UNWRAP && i11 > 0) || (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_WRAP && i10 > 0)) {
            return handshake();
        }
        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
        if (handshakeStatus != handshakeStatus2) {
            handshakeStatus2 = getHandshakeStatus();
        }
        return mayFinishHandshake(handshakeStatus2);
    }

    private boolean needPendingStatus() {
        return (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed() || (this.handshakeState == HandshakeState.FINISHED && !isInboundDone() && !isOutboundDone())) ? false : true;
    }

    private boolean needWrapAgain(int i10) {
        if (SSL.bioLengthNonApplication(this.networkBIO) <= 0) {
            return false;
        }
        Throwable th2 = this.pendingException;
        if (th2 == null) {
            this.pendingException = newSSLExceptionForError(i10);
        } else if (shouldAddSuppressed(th2, i10)) {
            ThrowableUtil.addSuppressed(this.pendingException, newSSLExceptionForError(i10));
        }
        SSL.clearError();
        return true;
    }

    private SSLEngineResult newResult(SSLEngineResult.HandshakeStatus handshakeStatus, int i10, int i11) {
        return newResult(SSLEngineResult.Status.OK, handshakeStatus, i10, i11);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus, int i10, int i11) throws SSLException {
        return newResult(mayFinishHandshake(handshakeStatus, i10, i11), i10, i11);
    }

    private SSLException newSSLExceptionForError(int i10) {
        String errorString = SSL.getErrorString(i10);
        return this.handshakeState == HandshakeState.FINISHED ? new OpenSslException(errorString, i10) : new OpenSslHandshakeException(errorString, i10);
    }

    private static SSLEngineResult.HandshakeStatus pendingStatus(int i10) {
        return i10 > 0 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : SSLEngineResult.HandshakeStatus.NEED_UNWRAP;
    }

    private int readPlaintextData(ByteBuffer byteBuffer) throws SSLException {
        int fromSSL;
        int iPosition = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            fromSSL = SSL.readFromSSL(this.ssl, bufferAddress(byteBuffer) + ((long) iPosition), byteBuffer.limit() - iPosition);
            if (fromSSL > 0) {
                byteBuffer.position(iPosition + fromSSL);
            }
        } else {
            int iLimit = byteBuffer.limit();
            int iMin = Math.min(maxEncryptedPacketLength0(), iLimit - iPosition);
            ByteBuf byteBufDirectBuffer = this.alloc.directBuffer(iMin);
            try {
                fromSSL = SSL.readFromSSL(this.ssl, OpenSsl.memoryAddress(byteBufDirectBuffer), iMin);
                if (fromSSL > 0) {
                    byteBuffer.limit(iPosition + fromSSL);
                    byteBufDirectBuffer.getBytes(byteBufDirectBuffer.readerIndex(), byteBuffer);
                    byteBuffer.limit(iLimit);
                }
            } finally {
                byteBufDirectBuffer.release();
            }
        }
        return fromSSL;
    }

    private void rejectRemoteInitiatedRenegotiation() throws SSLHandshakeException {
        if (isDestroyed()) {
            return;
        }
        if (((this.clientMode || SSL.getHandshakeCount(this.ssl) <= 1) && (!this.clientMode || SSL.getHandshakeCount(this.ssl) <= 2)) || SslProtocols.TLS_v1_3.equals(this.session.getProtocol()) || this.handshakeState != HandshakeState.FINISHED) {
            return;
        }
        shutdown();
        throw new SSLHandshakeException("remote-initiated renegotiation not allowed");
    }

    private void resetSingleDstBuffer() {
        this.singleDstBuffer[0] = null;
    }

    private void resetSingleSrcBuffer() {
        this.singleSrcBuffer[0] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void runAndResetNeedTask(Runnable runnable) {
        try {
            if (isDestroyed()) {
                this.needTask = false;
            } else {
                runnable.run();
                this.needTask = false;
            }
        } catch (Throwable th2) {
            this.needTask = false;
            throw th2;
        }
    }

    private void selectApplicationProtocol() throws SSLException {
        ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior = this.apn.selectedListenerFailureBehavior();
        List<String> listProtocols = this.apn.protocols();
        int i10 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ApplicationProtocolConfig$Protocol[this.apn.protocol().ordinal()];
        if (i10 != 1) {
            if (i10 == 2) {
                String alpnSelected = SSL.getAlpnSelected(this.ssl);
                if (alpnSelected != null) {
                    this.applicationProtocol = selectApplicationProtocol(listProtocols, selectedListenerFailureBehavior, alpnSelected);
                    return;
                }
                return;
            }
            if (i10 == 3) {
                String nextProtoNegotiated = SSL.getNextProtoNegotiated(this.ssl);
                if (nextProtoNegotiated != null) {
                    this.applicationProtocol = selectApplicationProtocol(listProtocols, selectedListenerFailureBehavior, nextProtoNegotiated);
                    return;
                }
                return;
            }
            if (i10 != 4) {
                throw new Error();
            }
            String alpnSelected2 = SSL.getAlpnSelected(this.ssl);
            if (alpnSelected2 == null) {
                alpnSelected2 = SSL.getNextProtoNegotiated(this.ssl);
            }
            if (alpnSelected2 != null) {
                this.applicationProtocol = selectApplicationProtocol(listProtocols, selectedListenerFailureBehavior, alpnSelected2);
            }
        }
    }

    private void setClientAuth(ClientAuth clientAuth) {
        if (this.clientMode) {
            return;
        }
        synchronized (this) {
            try {
                if (this.clientAuth == clientAuth) {
                    return;
                }
                if (!isDestroyed()) {
                    int i10 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ClientAuth[clientAuth.ordinal()];
                    if (i10 == 1) {
                        SSL.setVerify(this.ssl, 0, 10);
                    } else if (i10 == 2) {
                        SSL.setVerify(this.ssl, 2, 10);
                    } else {
                        if (i10 != 3) {
                            throw new Error(clientAuth.toString());
                        }
                        SSL.setVerify(this.ssl, 1, 10);
                    }
                }
                this.clientAuth = clientAuth;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035 A[PHI: r0 r5
      0x0035: PHI (r0v15 int) = (r0v7 int), (r0v9 int), (r0v11 int), (r0v13 int), (r0v16 int) binds: [B:45:0x0070, B:38:0x0061, B:31:0x0052, B:24:0x0043, B:17:0x0033] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r5v13 int) = (r5v9 int), (r5v10 int), (r5v11 int), (r5v12 int), (r5v0 int) binds: [B:45:0x0070, B:38:0x0061, B:31:0x0052, B:24:0x0043, B:17:0x0033] A[DONT_GENERATE, DONT_INLINE]] */
    private void setEnabledProtocols0(String[] strArr, boolean z10) {
        ObjectUtil.checkNotNullWithIAE(strArr, "protocols");
        int length = OPENSSL_OP_NO_PROTOCOLS.length;
        int length2 = strArr.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = 1;
            if (i10 >= length2) {
                synchronized (this) {
                    if (z10) {
                        try {
                            this.explicitlyEnabledProtocols = strArr;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    if (isDestroyed()) {
                        throw new IllegalStateException("failed to enable protocols: " + Arrays.asList(strArr));
                    }
                    SSL.clearOptions(this.ssl, SSL.SSL_OP_NO_SSLv2 | SSL.SSL_OP_NO_SSLv3 | SSL.SSL_OP_NO_TLSv1 | SSL.SSL_OP_NO_TLSv1_1 | SSL.SSL_OP_NO_TLSv1_2 | SSL.SSL_OP_NO_TLSv1_3);
                    int i13 = 0;
                    for (int i14 = 0; i14 < length; i14++) {
                        i13 |= OPENSSL_OP_NO_PROTOCOLS[i14];
                    }
                    int i15 = i11 + 1;
                    while (true) {
                        int[] iArr = OPENSSL_OP_NO_PROTOCOLS;
                        if (i15 < iArr.length) {
                            i13 |= iArr[i15];
                            i15++;
                        } else {
                            SSL.setOptions(this.ssl, i13);
                        }
                    }
                }
                return;
            }
            String str = strArr[i10];
            if (!OpenSsl.SUPPORTED_PROTOCOLS_SET.contains(str)) {
                throw new IllegalArgumentException(a.a("Protocol ", str, " is not supported."));
            }
            if (str.equals(SslProtocols.SSL_v2)) {
                if (length > 0) {
                    length = 0;
                }
                if (i11 < 0) {
                    i11 = 0;
                }
            } else if (str.equals(SslProtocols.SSL_v3)) {
                if (length > 1) {
                    length = 1;
                }
                if (i11 < 1) {
                    i11 = i12;
                }
            } else if (str.equals(SslProtocols.TLS_v1)) {
                i12 = 2;
                if (length > 2) {
                    length = 2;
                }
                if (i11 < 2) {
                    i11 = i12;
                }
            } else if (str.equals(SslProtocols.TLS_v1_1)) {
                i12 = 3;
                if (length > 3) {
                    length = 3;
                }
                if (i11 < 3) {
                    i11 = i12;
                }
            } else if (str.equals(SslProtocols.TLS_v1_2)) {
                i12 = 4;
                if (length > 4) {
                    length = 4;
                }
                if (i11 < 4) {
                    i11 = i12;
                }
            } else if (str.equals(SslProtocols.TLS_v1_3)) {
                i12 = 5;
                if (length > 5) {
                    length = 5;
                }
                if (i11 < 5) {
                    i11 = i12;
                }
            }
            i10++;
        }
    }

    private static boolean shouldAddSuppressed(Throwable th2, int i10) {
        for (Object obj : ThrowableUtil.getSuppressed(th2)) {
            if ((obj instanceof NativeSslException) && ((NativeSslException) obj).errorCode() == i10) {
                return false;
            }
        }
        return true;
    }

    private SSLException shutdownWithError(String str, int i10) {
        return shutdownWithError(str, i10, SSL.getLastErrorNumber());
    }

    private ByteBuffer[] singleDstBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleDstBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private ByteBuffer[] singleSrcBuffer(ByteBuffer byteBuffer) {
        ByteBuffer[] byteBufferArr = this.singleSrcBuffer;
        byteBufferArr[0] = byteBuffer;
        return byteBufferArr;
    }

    private int sslPending0() {
        if (this.handshakeState != HandshakeState.FINISHED) {
            return 0;
        }
        return SSL.sslPending(this.ssl);
    }

    private SSLEngineResult sslReadErrorResult(int i10, int i11, int i12, int i13) throws SSLException {
        if (needWrapAgain(i11)) {
            return new SSLEngineResult(SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_WRAP, i12, i13);
        }
        throw shutdownWithError("SSL_read", i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toJavaCipherSuite(String str) {
        if (str == null) {
            return null;
        }
        return CipherSuiteConverter.toJava(str, toJavaCipherSuitePrefix(SSL.getVersion(this.ssl)));
    }

    private static String toJavaCipherSuitePrefix(String str) {
        char cCharAt = 0;
        if (str != null && !str.isEmpty()) {
            cCharAt = str.charAt(0);
        }
        if (cCharAt != 'S') {
            return cCharAt != 'T' ? "UNKNOWN" : "TLS";
        }
        return "SSL";
    }

    private ByteBuf writeEncryptedData(ByteBuffer byteBuffer, int i10) throws Throwable {
        int iPosition = byteBuffer.position();
        if (byteBuffer.isDirect()) {
            SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + ((long) iPosition), i10, false);
            return null;
        }
        ByteBuf byteBufDirectBuffer = this.alloc.directBuffer(i10);
        try {
            int iLimit = byteBuffer.limit();
            byteBuffer.limit(iPosition + i10);
            byteBufDirectBuffer.writeBytes(byteBuffer);
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(byteBufDirectBuffer), i10, false);
            return byteBufDirectBuffer;
        } catch (Throwable th2) {
            byteBufDirectBuffer.release();
            PlatformDependent.throwException(th2);
            return null;
        }
    }

    private int writePlaintextData(ByteBuffer byteBuffer, int i10) {
        int iWriteToSSL;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        if (byteBuffer.isDirect()) {
            iWriteToSSL = SSL.writeToSSL(this.ssl, bufferAddress(byteBuffer) + ((long) iPosition), i10);
            if (iWriteToSSL > 0) {
                byteBuffer.position(iPosition + iWriteToSSL);
            }
        } else {
            ByteBuf byteBufDirectBuffer = this.alloc.directBuffer(i10);
            try {
                byteBuffer.limit(iPosition + i10);
                byteBufDirectBuffer.setBytes(0, byteBuffer);
                byteBuffer.limit(iLimit);
                iWriteToSSL = SSL.writeToSSL(this.ssl, OpenSsl.memoryAddress(byteBufDirectBuffer), i10);
                if (iWriteToSSL > 0) {
                    byteBuffer.position(iPosition + iWriteToSSL);
                } else {
                    byteBuffer.position(iPosition);
                }
            } finally {
                byteBufDirectBuffer.release();
            }
        }
        return iWriteToSSL;
    }

    public final synchronized String[] authMethods() {
        if (isDestroyed()) {
            return EmptyArrays.EMPTY_STRINGS;
        }
        return SSL.authenticationMethods(this.ssl);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void beginHandshake() throws SSLException {
        try {
            int i10 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
            if (i10 == 1) {
                this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                if (handshake() == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                    this.needTask = true;
                }
                calculateMaxWrapOverhead();
            } else {
                if (i10 == 2) {
                    throw new SSLException("renegotiation unsupported");
                }
                if (i10 == 3) {
                    checkEngineClosed();
                    this.handshakeState = HandshakeState.STARTED_EXPLICITLY;
                    calculateMaxWrapOverhead();
                } else if (i10 != 4) {
                    throw new Error();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void bioSetFd(int i10) {
        if (!isDestroyed()) {
            SSL.bioSetFd(this.ssl, i10);
        }
    }

    public final int calculateMaxLengthForWrap(int i10, int i11) {
        return (int) Math.min(this.maxWrapBufferSize, (((long) this.maxWrapOverhead) * ((long) i11)) + ((long) i10));
    }

    public final int calculateOutNetBufSize(int i10, int i11) {
        return (int) Math.min(2147483647L, (((long) this.maxWrapOverhead) * ((long) i11)) + ((long) i10));
    }

    public final boolean checkSniHostnameMatch(byte[] bArr) {
        return Java8SslUtils.checkSniHostnameMatch(this.matchers, bArr);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeInbound() throws SSLException {
        try {
            if (this.isInboundDone) {
                return;
            }
            this.isInboundDone = true;
            if (isOutboundDone()) {
                shutdown();
            }
            if (this.handshakeState != HandshakeState.NOT_STARTED && !this.receivedShutdown) {
                throw new SSLException("Inbound closed before receiving peer's close_notify: possible truncation attack?");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized void closeOutbound() {
        try {
            if (this.outboundClosed) {
                return;
            }
            this.outboundClosed = true;
            if (this.handshakeState == HandshakeState.NOT_STARTED || isDestroyed()) {
                shutdown();
            } else if ((SSL.getShutdown(this.ssl) & SSL.SSL_SENT_SHUTDOWN) != SSL.SSL_SENT_SHUTDOWN) {
                doSSLShutdown();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public String getApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized Runnable getDelegatedTask() {
        if (isDestroyed()) {
            return null;
        }
        AsyncTask task = SSL.getTask(this.ssl);
        if (task == null) {
            return null;
        }
        if (task instanceof AsyncTask) {
            return new AsyncTaskDecorator(task);
        }
        return new TaskDecorator(task);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getEnableSessionCreation() {
        return false;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledCipherSuites() {
        String[] strArr;
        boolean z10;
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                String[] ciphers = SSL.getCiphers(this.ssl);
                if (isProtocolEnabled(SSL.getOptions(this.ssl), SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                    strArr = OpenSsl.EXTRA_SUPPORTED_TLS_1_3_CIPHERS;
                    z10 = true;
                } else {
                    strArr = EmptyArrays.EMPTY_STRINGS;
                    z10 = false;
                }
                if (ciphers == null) {
                    return EmptyArrays.EMPTY_STRINGS;
                }
                LinkedHashSet linkedHashSet = new LinkedHashSet(ciphers.length + strArr.length);
                synchronized (this) {
                    for (int i10 = 0; i10 < ciphers.length; i10++) {
                        try {
                            String javaCipherSuite = toJavaCipherSuite(ciphers[i10]);
                            if (javaCipherSuite == null) {
                                javaCipherSuite = ciphers[i10];
                            }
                            if ((z10 && OpenSsl.isTlsv13Supported()) || !SslUtils.isTLSv13Cipher(javaCipherSuite)) {
                                linkedHashSet.add(javaCipherSuite);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                    Collections.addAll(linkedHashSet, strArr);
                }
                return (String[]) linkedHashSet.toArray(EmptyArrays.EMPTY_STRINGS);
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getEnabledProtocols() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(SslProtocols.SSL_v2_HELLO);
        synchronized (this) {
            if (isDestroyed()) {
                return (String[]) arrayList.toArray(EmptyArrays.EMPTY_STRINGS);
            }
            int options = SSL.getOptions(this.ssl);
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1, SslProtocols.TLS_v1)) {
                arrayList.add(SslProtocols.TLS_v1);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_1, SslProtocols.TLS_v1_1)) {
                arrayList.add(SslProtocols.TLS_v1_1);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_2, SslProtocols.TLS_v1_2)) {
                arrayList.add(SslProtocols.TLS_v1_2);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_TLSv1_3, SslProtocols.TLS_v1_3)) {
                arrayList.add(SslProtocols.TLS_v1_3);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv2, SslProtocols.SSL_v2)) {
                arrayList.add(SslProtocols.SSL_v2);
            }
            if (isProtocolEnabled(options, SSL.SSL_OP_NO_SSLv3, SslProtocols.SSL_v3)) {
                arrayList.add(SslProtocols.SSL_v3);
            }
            return (String[]) arrayList.toArray(EmptyArrays.EMPTY_STRINGS);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public String getHandshakeApplicationProtocol() {
        return this.applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLSession getHandshakeSession() {
        int i10 = AnonymousClass3.$SwitchMap$io$netty$handler$ssl$ReferenceCountedOpenSslEngine$HandshakeState[this.handshakeState.ordinal()];
        if (i10 == 1 || i10 == 2) {
            return null;
        }
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        if (!needPendingStatus()) {
            return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
        }
        if (this.needTask) {
            return SSLEngineResult.HandshakeStatus.NEED_TASK;
        }
        return pendingStatus(SSL.bioLengthNonApplication(this.networkBIO));
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getNeedClientAuth() {
        return this.clientAuth == ClientAuth.REQUIRE;
    }

    @Override // io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    public byte[] getOcspResponse() {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (!this.clientMode) {
            throw new IllegalStateException("Not a client SSLEngine");
        }
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return EmptyArrays.EMPTY_BYTES;
                }
                return SSL.getOcspResponse(this.ssl);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized SSLParameters getSSLParameters() {
        SSLParameters sSLParameters;
        try {
            sSLParameters = super.getSSLParameters();
            int iJavaVersion = PlatformDependent.javaVersion();
            if (iJavaVersion >= 7) {
                sSLParameters.setEndpointIdentificationAlgorithm(this.endPointIdentificationAlgorithm);
                Java7SslParametersUtils.setAlgorithmConstraints(sSLParameters, this.algorithmConstraints);
                if (iJavaVersion >= 8) {
                    List<String> list = this.sniHostNames;
                    if (list != null) {
                        Java8SslUtils.setSniHostNames(sSLParameters, list);
                    }
                    if (!isDestroyed()) {
                        Java8SslUtils.setUseCipherSuitesOrder(sSLParameters, (SSL.getOptions(this.ssl) & SSL.SSL_OP_CIPHER_SERVER_PREFERENCE) != 0);
                    }
                    Java8SslUtils.setSNIMatchers(sSLParameters, this.matchers);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return sSLParameters;
    }

    @Override // javax.net.ssl.SSLEngine
    public final SSLSession getSession() {
        return this.session;
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedCipherSuites() {
        return (String[]) OpenSsl.AVAILABLE_CIPHER_SUITES.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    @Override // javax.net.ssl.SSLEngine
    public final String[] getSupportedProtocols() {
        return (String[]) OpenSsl.SUPPORTED_PROTOCOLS_SET.toArray(EmptyArrays.EMPTY_STRINGS);
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getUseClientMode() {
        return this.clientMode;
    }

    @Override // javax.net.ssl.SSLEngine
    public final boolean getWantClientAuth() {
        return this.clientAuth == ClientAuth.OPTIONAL;
    }

    public final void initHandshakeException(Throwable th2) {
        Throwable th3 = this.pendingException;
        if (th3 == null) {
            this.pendingException = th2;
        } else {
            ThrowableUtil.addSuppressed(th3, th2);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isInboundDone() {
        return this.isInboundDone;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0018  */
    @Override // javax.net.ssl.SSLEngine
    public final synchronized boolean isOutboundDone() {
        boolean z10;
        if (this.outboundClosed) {
            long j10 = this.networkBIO;
            if (j10 == 0 || SSL.bioLengthNonApplication(j10) == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
        } else {
            z10 = false;
        }
        return z10;
    }

    public synchronized boolean isSessionReused() {
        if (isDestroyed()) {
            return false;
        }
        return SSL.isSessionReused(this.ssl);
    }

    public final synchronized SecretKeySpec masterKey() {
        if (isDestroyed()) {
            return null;
        }
        return new SecretKeySpec(SSL.getMasterKey(this.ssl), "AES");
    }

    public final synchronized int maxEncryptedPacketLength() {
        return maxEncryptedPacketLength0();
    }

    public final int maxEncryptedPacketLength0() {
        return this.maxWrapOverhead + MAX_PLAINTEXT_LENGTH;
    }

    public final synchronized int maxWrapOverhead() {
        return this.maxWrapOverhead;
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

    @Override // javax.net.ssl.SSLEngine
    public final void setEnableSessionCreation(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledCipherSuites(String[] strArr) {
        ObjectUtil.checkNotNull(strArr, "cipherSuites");
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        CipherSuiteConverter.convertToCipherStrings(Arrays.asList(strArr), sb2, sb3, OpenSsl.isBoringSSL());
        String string = sb2.toString();
        String string2 = sb3.toString();
        if (!OpenSsl.isTlsv13Supported() && !string2.isEmpty()) {
            throw new IllegalArgumentException("TLSv1.3 is not supported by this java version.");
        }
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    throw new IllegalStateException("failed to enable cipher suites: " + string);
                }
                try {
                    SSL.setCipherSuites(this.ssl, string, false);
                    if (OpenSsl.isTlsv13Supported()) {
                        SSL.setCipherSuites(this.ssl, OpenSsl.checkTls13Ciphers(logger, string2), true);
                    }
                    HashSet hashSet = new HashSet(this.explicitlyEnabledProtocols.length);
                    Collections.addAll(hashSet, this.explicitlyEnabledProtocols);
                    if (string.isEmpty()) {
                        hashSet.remove(SslProtocols.TLS_v1);
                        hashSet.remove(SslProtocols.TLS_v1_1);
                        hashSet.remove(SslProtocols.TLS_v1_2);
                        hashSet.remove(SslProtocols.SSL_v3);
                        hashSet.remove(SslProtocols.SSL_v2);
                        hashSet.remove(SslProtocols.SSL_v2_HELLO);
                    }
                    if (string2.isEmpty()) {
                        hashSet.remove(SslProtocols.TLS_v1_3);
                    }
                    setEnabledProtocols0((String[]) hashSet.toArray(EmptyArrays.EMPTY_STRINGS), false);
                } catch (Exception e10) {
                    throw new IllegalStateException("failed to enable cipher suites: " + string, e10);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setEnabledProtocols(String[] strArr) {
        setEnabledProtocols0(strArr, true);
    }

    public final boolean setKeyMaterial(OpenSslKeyMaterial openSslKeyMaterial) throws Exception {
        synchronized (this) {
            try {
                if (isDestroyed()) {
                    return false;
                }
                SSL.setKeyMaterial(this.ssl, openSslKeyMaterial.certificateChainAddress(), openSslKeyMaterial.privateKeyAddress());
                this.session.setLocalCertificate(openSslKeyMaterial.certificateChain());
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setNeedClientAuth(boolean z10) {
        setClientAuth(z10 ? ClientAuth.REQUIRE : ClientAuth.NONE);
    }

    public void setOcspResponse(byte[] bArr) {
        if (!this.enableOcsp) {
            throw new IllegalStateException("OCSP stapling is not enabled");
        }
        if (this.clientMode) {
            throw new IllegalStateException("Not a server SSLEngine");
        }
        synchronized (this) {
            try {
                if (!isDestroyed()) {
                    SSL.setOcspResponse(this.ssl, bArr);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Usage guarded by java version check")
    public final synchronized void setSSLParameters(SSLParameters sSLParameters) {
        try {
            int iJavaVersion = PlatformDependent.javaVersion();
            if (iJavaVersion >= 7) {
                if (sSLParameters.getAlgorithmConstraints() != null) {
                    throw new IllegalArgumentException("AlgorithmConstraints are not supported.");
                }
                boolean zIsDestroyed = isDestroyed();
                if (iJavaVersion >= 8) {
                    if (!zIsDestroyed) {
                        if (this.clientMode) {
                            List<String> sniHostNames = Java8SslUtils.getSniHostNames(sSLParameters);
                            Iterator<String> it = sniHostNames.iterator();
                            while (it.hasNext()) {
                                SSL.setTlsExtHostName(this.ssl, it.next());
                            }
                            this.sniHostNames = sniHostNames;
                        }
                        if (Java8SslUtils.getUseCipherSuitesOrder(sSLParameters)) {
                            SSL.setOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        } else {
                            SSL.clearOptions(this.ssl, SSL.SSL_OP_CIPHER_SERVER_PREFERENCE);
                        }
                    }
                    this.matchers = sSLParameters.getSNIMatchers();
                }
                String endpointIdentificationAlgorithm = sSLParameters.getEndpointIdentificationAlgorithm();
                if (!zIsDestroyed && this.clientMode && isEndPointVerificationEnabled(endpointIdentificationAlgorithm)) {
                    SSL.setVerify(this.ssl, 2, -1);
                }
                this.endPointIdentificationAlgorithm = endpointIdentificationAlgorithm;
                this.algorithmConstraints = sSLParameters.getAlgorithmConstraints();
            }
            super.setSSLParameters(sSLParameters);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void setSessionId(OpenSslSessionId openSslSessionId) {
        this.session.setSessionId(openSslSessionId);
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setUseClientMode(boolean z10) {
        if (z10 != this.clientMode) {
            throw new UnsupportedOperationException();
        }
    }

    public final synchronized void setVerify(int i10, int i11) {
        if (!isDestroyed()) {
            SSL.setVerify(this.ssl, i10, i11);
        }
    }

    @Override // javax.net.ssl.SSLEngine
    public final void setWantClientAuth(boolean z10) {
        setClientAuth(z10 ? ClientAuth.OPTIONAL : ClientAuth.NONE);
    }

    public final synchronized void shutdown() {
        try {
            if (!this.destroyed) {
                this.destroyed = true;
                OpenSslEngineMap openSslEngineMap = this.engineMap;
                if (openSslEngineMap != null) {
                    openSslEngineMap.remove(this.ssl);
                }
                SSL.freeSSL(this.ssl);
                this.networkBIO = 0L;
                this.ssl = 0L;
                this.outboundClosed = true;
                this.isInboundDone = true;
            }
            SSL.clearError();
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized int sslPending() {
        return sslPending0();
    }

    public final synchronized long sslPointer() {
        return this.ssl;
    }

    @Override // io.netty.util.ReferenceCounted
    public final ReferenceCounted touch() {
        this.refCnt.touch();
        return this;
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, int i10, int i11, ByteBuffer[] byteBufferArr2, int i12, int i13) throws SSLException {
        int i14;
        int i15;
        int encryptedPacketLength;
        int iMin;
        ByteBuf byteBufWriteEncryptedData;
        int i16 = i12;
        ObjectUtil.checkNotNullWithIAE(byteBufferArr, "srcs");
        if (i10 >= byteBufferArr.length || (i14 = i10 + i11) > byteBufferArr.length) {
            throw new IndexOutOfBoundsException(c.a.a(i0.a.a("offset: ", i10, ", length: ", i11, " (expected: offset <= offset + length <= srcs.length ("), byteBufferArr.length, "))"));
        }
        ObjectUtil.checkNotNullWithIAE(byteBufferArr2, "dsts");
        if (i16 >= byteBufferArr2.length || (i15 = i16 + i13) > byteBufferArr2.length) {
            throw new IndexOutOfBoundsException(c.a.a(i0.a.a("offset: ", i16, ", length: ", i13, " (expected: offset <= offset + length <= dsts.length ("), byteBufferArr2.length, "))"));
        }
        long jRemaining = 0;
        for (int i17 = i16; i17 < i15; i17++) {
            ByteBuffer byteBuffer = (ByteBuffer) ObjectUtil.checkNotNullArrayParam(byteBufferArr2[i17], i17, "dsts");
            if (byteBuffer.isReadOnly()) {
                throw new ReadOnlyBufferException();
            }
            jRemaining += (long) byteBuffer.remaining();
        }
        long jRemaining2 = 0;
        for (int i18 = i10; i18 < i14; i18++) {
            jRemaining2 += (long) ((ByteBuffer) ObjectUtil.checkNotNullArrayParam(byteBufferArr[i18], i18, "srcs")).remaining();
        }
        synchronized (this) {
            try {
                if (isInboundDone()) {
                    return (isOutboundDone() || isDestroyed()) ? CLOSED_NOT_HANDSHAKING : NEED_WRAP_CLOSED;
                }
                SSLEngineResult.HandshakeStatus handshakeStatusHandshake = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                HandshakeState handshakeState = this.handshakeState;
                HandshakeState handshakeState2 = HandshakeState.FINISHED;
                if (handshakeState != handshakeState2) {
                    if (handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                        this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                    }
                    handshakeStatusHandshake = handshake();
                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                        return newResult(handshakeStatusHandshake, 0, 0);
                    }
                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_WRAP) {
                        return NEED_WRAP_OK;
                    }
                    if (this.isInboundDone) {
                        return NEED_WRAP_CLOSED;
                    }
                }
                int iSslPending0 = sslPending0();
                if (this.jdkCompatibilityMode || handshakeState != handshakeState2) {
                    if (jRemaining2 < 5) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                    encryptedPacketLength = SslUtils.getEncryptedPacketLength(byteBufferArr, i10);
                    if (encryptedPacketLength == -2) {
                        throw new NotSslRecordException("not an SSL/TLS record");
                    }
                    int i19 = encryptedPacketLength - 5;
                    if (i19 > jRemaining) {
                        if (i19 <= MAX_RECORD_SIZE) {
                            this.session.tryExpandApplicationBufferSize(i19);
                            return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, 0, 0);
                        }
                        throw new SSLException("Illegal packet length: " + i19 + " > " + this.session.getApplicationBufferSize());
                    }
                    if (jRemaining2 < encryptedPacketLength) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                } else {
                    if (jRemaining2 == 0 && iSslPending0 <= 0) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_UNDERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                    if (jRemaining == 0) {
                        return newResultMayFinishHandshake(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, 0, 0);
                    }
                    encryptedPacketLength = (int) Math.min(2147483647L, jRemaining2);
                }
                int i20 = 0;
                int iSslPending1 = iSslPending0;
                int i21 = i10;
                int i22 = 0;
                loop2: while (true) {
                    try {
                        ByteBuffer byteBuffer2 = byteBufferArr[i21];
                        int iRemaining = byteBuffer2.remaining();
                        if (iRemaining != 0) {
                            iMin = Math.min(encryptedPacketLength, iRemaining);
                            try {
                                byteBufWriteEncryptedData = writeEncryptedData(byteBuffer2, iMin);
                            } catch (SSLException e10) {
                                SSLEngineResult sSLEngineResultHandleUnwrapException = handleUnwrapException(i20, i22, e10);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                rejectRemoteInitiatedRenegotiation();
                                return sSLEngineResultHandleUnwrapException;
                            }
                        } else if (iSslPending1 <= 0) {
                            i21++;
                            if (i21 >= i14) {
                                break;
                            }
                        } else {
                            iMin = SSL.bioLengthByteBuffer(this.networkBIO);
                            byteBufWriteEncryptedData = null;
                        }
                        while (true) {
                            try {
                                ByteBuffer byteBuffer3 = byteBufferArr2[i16];
                                if (!byteBuffer3.hasRemaining()) {
                                    i16++;
                                    if (i16 >= i15) {
                                        if (byteBufWriteEncryptedData == null) {
                                            break loop2;
                                        }
                                        byteBufWriteEncryptedData.release();
                                        break loop2;
                                    }
                                } else {
                                    int i23 = iSslPending1;
                                    try {
                                        int plaintextData = readPlaintextData(byteBuffer3);
                                        SSLEngineResult.HandshakeStatus handshakeStatus = handshakeStatusHandshake;
                                        int i24 = i14;
                                        int iBioLengthByteBuffer = iMin - SSL.bioLengthByteBuffer(this.networkBIO);
                                        i20 += iBioLengthByteBuffer;
                                        encryptedPacketLength -= iBioLengthByteBuffer;
                                        iMin -= iBioLengthByteBuffer;
                                        byteBuffer2.position(byteBuffer2.position() + iBioLengthByteBuffer);
                                        if (plaintextData > 0) {
                                            i22 += plaintextData;
                                            if (byteBuffer3.hasRemaining()) {
                                                handshakeStatusHandshake = handshakeStatus;
                                                if (encryptedPacketLength != 0 && !this.jdkCompatibilityMode) {
                                                    iSslPending1 = i23;
                                                }
                                                if (byteBufWriteEncryptedData == null) {
                                                    break loop2;
                                                }
                                                byteBufWriteEncryptedData.release();
                                                break loop2;
                                            }
                                            iSslPending1 = sslPending0();
                                            i16++;
                                            if (i16 >= i15) {
                                                SSLEngineResult sSLEngineResultNewResult = iSslPending1 > 0 ? newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatus, i20, i22) : newResultMayFinishHandshake(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, handshakeStatus, i20, i22);
                                                if (byteBufWriteEncryptedData != null) {
                                                    byteBufWriteEncryptedData.release();
                                                }
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                rejectRemoteInitiatedRenegotiation();
                                                return sSLEngineResultNewResult;
                                            }
                                            handshakeStatusHandshake = handshakeStatus;
                                            i14 = i24;
                                        } else {
                                            handshakeStatusHandshake = handshakeStatus;
                                            int error = SSL.getError(this.ssl, plaintextData);
                                            if (error != SSL.SSL_ERROR_WANT_READ && error != SSL.SSL_ERROR_WANT_WRITE) {
                                                if (error == SSL.SSL_ERROR_ZERO_RETURN) {
                                                    if (!this.receivedShutdown) {
                                                        closeAll();
                                                    }
                                                    SSLEngineResult sSLEngineResultNewResultMayFinishHandshake = newResultMayFinishHandshake(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, handshakeStatusHandshake, i20, i22);
                                                    if (byteBufWriteEncryptedData != null) {
                                                        byteBufWriteEncryptedData.release();
                                                    }
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                    rejectRemoteInitiatedRenegotiation();
                                                    return sSLEngineResultNewResultMayFinishHandshake;
                                                }
                                                if (error != SSL.SSL_ERROR_WANT_X509_LOOKUP && error != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY && error != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                                                    SSLEngineResult sSLEngineResultSslReadErrorResult = sslReadErrorResult(error, SSL.getLastErrorNumber(), i20, i22);
                                                    if (byteBufWriteEncryptedData != null) {
                                                        byteBufWriteEncryptedData.release();
                                                    }
                                                    SSL.bioClearByteBuffer(this.networkBIO);
                                                    rejectRemoteInitiatedRenegotiation();
                                                    return sSLEngineResultSslReadErrorResult;
                                                }
                                                SSLEngineResult sSLEngineResultNewResult2 = newResult(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, SSLEngineResult.HandshakeStatus.NEED_TASK, i20, i22);
                                                if (byteBufWriteEncryptedData != null) {
                                                    byteBufWriteEncryptedData.release();
                                                }
                                                SSL.bioClearByteBuffer(this.networkBIO);
                                                rejectRemoteInitiatedRenegotiation();
                                                return sSLEngineResultNewResult2;
                                            }
                                            i21++;
                                            i14 = i24;
                                            if (i21 >= i14) {
                                                if (byteBufWriteEncryptedData == null) {
                                                    break;
                                                }
                                                byteBufWriteEncryptedData.release();
                                                break loop2;
                                            }
                                            if (byteBufWriteEncryptedData != null) {
                                                byteBufWriteEncryptedData.release();
                                            }
                                            iSslPending1 = i23;
                                        }
                                    } catch (SSLException e11) {
                                        SSLEngineResult sSLEngineResultHandleUnwrapException2 = handleUnwrapException(i20, i22, e11);
                                        if (byteBufWriteEncryptedData != null) {
                                            byteBufWriteEncryptedData.release();
                                        }
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        rejectRemoteInitiatedRenegotiation();
                                        return sSLEngineResultHandleUnwrapException2;
                                    }
                                }
                            } catch (Throwable th2) {
                                if (byteBufWriteEncryptedData != null) {
                                    byteBufWriteEncryptedData.release();
                                }
                                throw th2;
                            }
                        }
                    } catch (Throwable th3) {
                        SSL.bioClearByteBuffer(this.networkBIO);
                        rejectRemoteInitiatedRenegotiation();
                        throw th3;
                    }
                }
                SSL.bioClearByteBuffer(this.networkBIO);
                rejectRemoteInitiatedRenegotiation();
                if (!this.receivedShutdown && (SSL.getShutdown(this.ssl) & SSL.SSL_RECEIVED_SHUTDOWN) == SSL.SSL_RECEIVED_SHUTDOWN) {
                    closeAll();
                }
                return newResultMayFinishHandshake(isInboundDone() ? SSLEngineResult.Status.CLOSED : SSLEngineResult.Status.OK, handshakeStatusHandshake, i20, i22);
            } catch (Throwable th4) {
                throw th4;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:295:0x0525 A[Catch: all -> 0x002f, TryCatch #5 {all -> 0x002f, blocks: (B:9:0x0019, B:11:0x001f, B:13:0x0025, B:16:0x002c, B:20:0x0034, B:19:0x0032, B:35:0x0090, B:37:0x0097, B:39:0x00ad, B:38:0x009f, B:46:0x00c1, B:48:0x00c8, B:50:0x00df, B:49:0x00d1, B:57:0x00f1, B:59:0x00f8, B:61:0x010f, B:60:0x0101, B:66:0x011e, B:68:0x0125, B:70:0x013c, B:69:0x012e, B:293:0x051e, B:295:0x0525, B:297:0x053c, B:296:0x0534, B:84:0x0165, B:86:0x016c, B:88:0x0183, B:87:0x0175, B:93:0x0192, B:95:0x0199, B:97:0x01b0, B:96:0x01a2, B:102:0x01c6, B:104:0x01cd, B:106:0x01e4, B:105:0x01d6, B:115:0x0203, B:117:0x020a, B:119:0x0221, B:118:0x0213, B:127:0x0232, B:129:0x0239, B:131:0x0250, B:130:0x0242, B:137:0x0260, B:139:0x0267, B:141:0x027e, B:140:0x0270, B:173:0x02ff, B:175:0x0306, B:177:0x031d, B:176:0x030f, B:210:0x039a, B:212:0x03a1, B:214:0x03b8, B:213:0x03aa, B:229:0x03f3, B:231:0x03fa, B:233:0x0411, B:232:0x0403, B:236:0x0419, B:238:0x0420, B:240:0x0437, B:239:0x0429, B:245:0x0443, B:247:0x044a, B:249:0x0461, B:248:0x0453, B:255:0x046f, B:257:0x0476, B:259:0x048d, B:258:0x047f, B:262:0x0495, B:264:0x049c, B:266:0x04b3, B:265:0x04a5, B:278:0x04cf, B:280:0x04d6, B:282:0x04ed, B:281:0x04df, B:191:0x0353, B:193:0x035a, B:195:0x0371, B:194:0x0363, B:285:0x04f3, B:287:0x04fa, B:289:0x0511, B:288:0x0503, B:164:0x02d3, B:166:0x02da, B:168:0x02f1, B:167:0x02e3), top: B:308:0x0019 }] */
    /* JADX WARN: Code duplicated, block: B:296:0x0534 A[Catch: all -> 0x002f, TryCatch #5 {all -> 0x002f, blocks: (B:9:0x0019, B:11:0x001f, B:13:0x0025, B:16:0x002c, B:20:0x0034, B:19:0x0032, B:35:0x0090, B:37:0x0097, B:39:0x00ad, B:38:0x009f, B:46:0x00c1, B:48:0x00c8, B:50:0x00df, B:49:0x00d1, B:57:0x00f1, B:59:0x00f8, B:61:0x010f, B:60:0x0101, B:66:0x011e, B:68:0x0125, B:70:0x013c, B:69:0x012e, B:293:0x051e, B:295:0x0525, B:297:0x053c, B:296:0x0534, B:84:0x0165, B:86:0x016c, B:88:0x0183, B:87:0x0175, B:93:0x0192, B:95:0x0199, B:97:0x01b0, B:96:0x01a2, B:102:0x01c6, B:104:0x01cd, B:106:0x01e4, B:105:0x01d6, B:115:0x0203, B:117:0x020a, B:119:0x0221, B:118:0x0213, B:127:0x0232, B:129:0x0239, B:131:0x0250, B:130:0x0242, B:137:0x0260, B:139:0x0267, B:141:0x027e, B:140:0x0270, B:173:0x02ff, B:175:0x0306, B:177:0x031d, B:176:0x030f, B:210:0x039a, B:212:0x03a1, B:214:0x03b8, B:213:0x03aa, B:229:0x03f3, B:231:0x03fa, B:233:0x0411, B:232:0x0403, B:236:0x0419, B:238:0x0420, B:240:0x0437, B:239:0x0429, B:245:0x0443, B:247:0x044a, B:249:0x0461, B:248:0x0453, B:255:0x046f, B:257:0x0476, B:259:0x048d, B:258:0x047f, B:262:0x0495, B:264:0x049c, B:266:0x04b3, B:265:0x04a5, B:278:0x04cf, B:280:0x04d6, B:282:0x04ed, B:281:0x04df, B:191:0x0353, B:193:0x035a, B:195:0x0371, B:194:0x0363, B:285:0x04f3, B:287:0x04fa, B:289:0x0511, B:288:0x0503, B:164:0x02d3, B:166:0x02da, B:168:0x02f1, B:167:0x02e3), top: B:308:0x0019 }] */
    @Override // javax.net.ssl.SSLEngine
    public final SSLEngineResult wrap(ByteBuffer[] byteBufferArr, int i10, int i11, ByteBuffer byteBuffer) throws SSLException {
        int i12;
        ByteBuf byteBufDirectBuffer;
        SSLEngineResult.HandshakeStatus handshakeStatusHandshake;
        int iBioLengthByteBuffer;
        int iWritePlaintextData;
        ObjectUtil.checkNotNullWithIAE(byteBufferArr, "srcs");
        ObjectUtil.checkNotNullWithIAE(byteBuffer, "dst");
        if (i10 >= byteBufferArr.length || (i12 = i10 + i11) > byteBufferArr.length) {
            throw new IndexOutOfBoundsException(c.a.a(i0.a.a("offset: ", i10, ", length: ", i11, " (expected: offset <= offset + length <= srcs.length ("), byteBufferArr.length, "))"));
        }
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        synchronized (this) {
            try {
                if (isOutboundDone()) {
                    return (isInboundDone() || isDestroyed()) ? CLOSED_NOT_HANDSHAKING : NEED_UNWRAP_CLOSED;
                }
                ByteBuf byteBuf = null;
                int i13 = 0;
                int i14 = 0;
                i13 = 0;
                try {
                    if (byteBuffer.isDirect()) {
                        SSL.bioSetByteBuffer(this.networkBIO, bufferAddress(byteBuffer) + ((long) byteBuffer.position()), byteBuffer.remaining(), true);
                        byteBufDirectBuffer = null;
                    } else {
                        byteBufDirectBuffer = this.alloc.directBuffer(byteBuffer.remaining());
                        try {
                            SSL.bioSetByteBuffer(this.networkBIO, OpenSsl.memoryAddress(byteBufDirectBuffer), byteBufDirectBuffer.writableBytes(), true);
                        } catch (Throwable th2) {
                            th = th2;
                            byteBuf = byteBufDirectBuffer;
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (byteBuf != null) {
                                byteBuffer.put(byteBuf.internalNioBuffer(byteBuf.readerIndex(), i13));
                                byteBuf.release();
                            } else {
                                byteBuffer.position(byteBuffer.position() + i13);
                            }
                            throw th;
                        }
                    }
                    int iBioLengthByteBuffer2 = SSL.bioLengthByteBuffer(this.networkBIO);
                    try {
                        try {
                            if (this.outboundClosed) {
                                if (!isBytesAvailableEnoughForWrap(byteBuffer.remaining(), 2, 1)) {
                                    SSLEngineResult sSLEngineResult = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        byteBuffer.position(byteBuffer.position());
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), 0));
                                        byteBufDirectBuffer.release();
                                    }
                                    return sSLEngineResult;
                                }
                                int iBioFlushByteBuffer = SSL.bioFlushByteBuffer(this.networkBIO);
                                if (iBioFlushByteBuffer <= 0) {
                                    SSLEngineResult sSLEngineResultNewResultMayFinishHandshake = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, 0);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                        byteBufDirectBuffer.release();
                                    }
                                    return sSLEngineResultNewResultMayFinishHandshake;
                                }
                                if (!doSSLShutdown()) {
                                    SSLEngineResult sSLEngineResultNewResultMayFinishHandshake2 = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, 0, iBioFlushByteBuffer);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer));
                                        byteBufDirectBuffer.release();
                                    }
                                    return sSLEngineResultNewResultMayFinishHandshake2;
                                }
                                int iBioLengthByteBuffer3 = iBioLengthByteBuffer2 - SSL.bioLengthByteBuffer(this.networkBIO);
                                SSLEngineResult sSLEngineResultNewResultMayFinishHandshake3 = newResultMayFinishHandshake(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, iBioLengthByteBuffer3);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (byteBufDirectBuffer == null) {
                                    byteBuffer.position(byteBuffer.position() + iBioLengthByteBuffer3);
                                } else {
                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer3));
                                    byteBufDirectBuffer.release();
                                }
                                return sSLEngineResultNewResultMayFinishHandshake3;
                            }
                            SSLEngineResult.HandshakeStatus handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
                            HandshakeState handshakeState = this.handshakeState;
                            HandshakeState handshakeState2 = HandshakeState.FINISHED;
                            if (handshakeState != handshakeState2) {
                                if (handshakeState != HandshakeState.STARTED_EXPLICITLY) {
                                    this.handshakeState = HandshakeState.STARTED_IMPLICITLY;
                                }
                                int iBioFlushByteBuffer2 = SSL.bioFlushByteBuffer(this.networkBIO);
                                try {
                                    if (this.pendingException != null) {
                                        if (iBioFlushByteBuffer2 > 0) {
                                            SSLEngineResult sSLEngineResultNewResult = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, 0, iBioFlushByteBuffer2);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (byteBufDirectBuffer == null) {
                                                byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer2);
                                            } else {
                                                byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer2));
                                                byteBufDirectBuffer.release();
                                            }
                                            return sSLEngineResultNewResult;
                                        }
                                        SSLEngineResult sSLEngineResultNewResult2 = newResult(handshakeException(), 0, 0);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer2);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer2));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult2;
                                    }
                                    handshakeStatusHandshake = handshake();
                                    iBioLengthByteBuffer = iBioLengthByteBuffer2 - SSL.bioLengthByteBuffer(this.networkBIO);
                                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                                        SSLEngineResult sSLEngineResultNewResult3 = newResult(handshakeStatusHandshake, 0, iBioLengthByteBuffer);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + iBioLengthByteBuffer);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult3;
                                    }
                                    if (iBioLengthByteBuffer > 0) {
                                        SSLEngineResult.HandshakeStatus handshakeStatus2 = SSLEngineResult.HandshakeStatus.FINISHED;
                                        if (handshakeStatusHandshake != handshakeStatus2) {
                                            handshakeStatus2 = iBioLengthByteBuffer == iBioLengthByteBuffer2 ? SSLEngineResult.HandshakeStatus.NEED_WRAP : getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                        }
                                        SSLEngineResult sSLEngineResultNewResult4 = newResult(mayFinishHandshake(handshakeStatus2), 0, iBioLengthByteBuffer);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + iBioLengthByteBuffer);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult4;
                                    }
                                    if (handshakeStatusHandshake == SSLEngineResult.HandshakeStatus.NEED_UNWRAP) {
                                        SSLEngineResult sSLEngineResult2 = isOutboundDone() ? NEED_UNWRAP_CLOSED : NEED_UNWRAP_OK;
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + iBioLengthByteBuffer);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResult2;
                                    }
                                    if (this.outboundClosed) {
                                        int iBioFlushByteBuffer3 = SSL.bioFlushByteBuffer(this.networkBIO);
                                        SSLEngineResult sSLEngineResultNewResultMayFinishHandshake4 = newResultMayFinishHandshake(handshakeStatusHandshake, 0, iBioFlushByteBuffer3);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer3);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer3));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResultMayFinishHandshake4;
                                    }
                                } catch (Throwable th3) {
                                    th = th3;
                                    byteBuf = byteBufDirectBuffer;
                                    i13 = iBioFlushByteBuffer2;
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBuf != null) {
                                        byteBuffer.put(byteBuf.internalNioBuffer(byteBuf.readerIndex(), i13));
                                        byteBuf.release();
                                    } else {
                                        byteBuffer.position(byteBuffer.position() + i13);
                                    }
                                    throw th;
                                }
                            } else {
                                handshakeStatusHandshake = handshakeStatus;
                                iBioLengthByteBuffer = 0;
                            }
                            if (this.jdkCompatibilityMode || handshakeState != handshakeState2) {
                                int iRemaining = 0;
                                for (int i15 = i10; i15 < i12; i15++) {
                                    ByteBuffer byteBuffer2 = byteBufferArr[i15];
                                    if (byteBuffer2 == null) {
                                        throw new IllegalArgumentException("srcs[" + i15 + "] is null");
                                    }
                                    int i16 = MAX_PLAINTEXT_LENGTH;
                                    if (iRemaining != i16 && ((iRemaining = iRemaining + byteBuffer2.remaining()) > i16 || iRemaining < 0)) {
                                        iRemaining = i16;
                                    }
                                }
                                if (!isBytesAvailableEnoughForWrap(byteBuffer.remaining(), iRemaining, 1)) {
                                    SSLEngineResult sSLEngineResult3 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), 0, 0);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        byteBuffer.position(byteBuffer.position() + iBioLengthByteBuffer);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer));
                                        byteBufDirectBuffer.release();
                                    }
                                    return sSLEngineResult3;
                                }
                            }
                            int iBioFlushByteBuffer4 = SSL.bioFlushByteBuffer(this.networkBIO);
                            if (iBioFlushByteBuffer4 > 0) {
                                SSLEngineResult sSLEngineResultNewResultMayFinishHandshake5 = newResultMayFinishHandshake(handshakeStatusHandshake, 0, iBioFlushByteBuffer4);
                                SSL.bioClearByteBuffer(this.networkBIO);
                                if (byteBufDirectBuffer == null) {
                                    byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer4);
                                } else {
                                    byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer4));
                                    byteBufDirectBuffer.release();
                                }
                                return sSLEngineResultNewResultMayFinishHandshake5;
                            }
                            Throwable th4 = this.pendingException;
                            if (th4 != null) {
                                this.pendingException = null;
                                shutdown();
                                throw new SSLException(th4);
                            }
                            while (i10 < i12) {
                                ByteBuffer byteBuffer3 = byteBufferArr[i10];
                                int iRemaining2 = byteBuffer3.remaining();
                                if (iRemaining2 != 0) {
                                    if (this.jdkCompatibilityMode) {
                                        iWritePlaintextData = writePlaintextData(byteBuffer3, Math.min(iRemaining2, MAX_PLAINTEXT_LENGTH - i14));
                                    } else {
                                        int iRemaining3 = (byteBuffer.remaining() - iBioFlushByteBuffer4) - this.maxWrapOverhead;
                                        if (iRemaining3 <= 0) {
                                            SSLEngineResult sSLEngineResult4 = new SSLEngineResult(SSLEngineResult.Status.BUFFER_OVERFLOW, getHandshakeStatus(), i14, iBioFlushByteBuffer4);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (byteBufDirectBuffer == null) {
                                                byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer4);
                                            } else {
                                                byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer4));
                                                byteBufDirectBuffer.release();
                                            }
                                            return sSLEngineResult4;
                                        }
                                        iWritePlaintextData = writePlaintextData(byteBuffer3, Math.min(iRemaining2, iRemaining3));
                                    }
                                    int iBioLengthByteBuffer4 = SSL.bioLengthByteBuffer(this.networkBIO);
                                    int i17 = (iBioLengthByteBuffer2 - iBioLengthByteBuffer4) + iBioFlushByteBuffer4;
                                    if (iWritePlaintextData > 0) {
                                        i14 += iWritePlaintextData;
                                        if (!this.jdkCompatibilityMode && i17 != byteBuffer.remaining()) {
                                            iBioFlushByteBuffer4 = i17;
                                            iBioLengthByteBuffer2 = iBioLengthByteBuffer4;
                                        }
                                        SSLEngineResult sSLEngineResultNewResultMayFinishHandshake6 = newResultMayFinishHandshake(handshakeStatusHandshake, i14, i17);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + i17);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), i17));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResultMayFinishHandshake6;
                                    }
                                    int error = SSL.getError(this.ssl, iWritePlaintextData);
                                    if (error == SSL.SSL_ERROR_ZERO_RETURN) {
                                        if (this.receivedShutdown) {
                                            SSLEngineResult sSLEngineResultNewResult5 = newResult(SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING, i14, i17);
                                            SSL.bioClearByteBuffer(this.networkBIO);
                                            if (byteBufDirectBuffer == null) {
                                                byteBuffer.position(byteBuffer.position() + i17);
                                            } else {
                                                byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), i17));
                                                byteBufDirectBuffer.release();
                                            }
                                            return sSLEngineResultNewResult5;
                                        }
                                        closeAll();
                                        int iBioLengthByteBuffer5 = (iBioLengthByteBuffer4 - SSL.bioLengthByteBuffer(this.networkBIO)) + i17;
                                        SSLEngineResult.HandshakeStatus handshakeStatus3 = SSLEngineResult.HandshakeStatus.FINISHED;
                                        if (handshakeStatusHandshake != handshakeStatus3) {
                                            handshakeStatus3 = iBioLengthByteBuffer5 == byteBuffer.remaining() ? SSLEngineResult.HandshakeStatus.NEED_WRAP : getHandshakeStatus(SSL.bioLengthNonApplication(this.networkBIO));
                                        }
                                        SSLEngineResult sSLEngineResultNewResult6 = newResult(mayFinishHandshake(handshakeStatus3), i14, iBioLengthByteBuffer5);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + iBioLengthByteBuffer5);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioLengthByteBuffer5));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult6;
                                    }
                                    if (error == SSL.SSL_ERROR_WANT_READ) {
                                        SSLEngineResult sSLEngineResultNewResult7 = newResult(SSLEngineResult.HandshakeStatus.NEED_UNWRAP, i14, i17);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + i17);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), i17));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult7;
                                    }
                                    if (error != SSL.SSL_ERROR_WANT_WRITE) {
                                        if (error != SSL.SSL_ERROR_WANT_X509_LOOKUP && error != SSL.SSL_ERROR_WANT_CERTIFICATE_VERIFY && error != SSL.SSL_ERROR_WANT_PRIVATE_KEY_OPERATION) {
                                            throw shutdownWithError("SSL_write", error);
                                        }
                                        SSLEngineResult sSLEngineResultNewResult8 = newResult(SSLEngineResult.HandshakeStatus.NEED_TASK, i14, i17);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + i17);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), i17));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult8;
                                    }
                                    if (i17 > 0) {
                                        SSLEngineResult sSLEngineResultNewResult9 = newResult(SSLEngineResult.HandshakeStatus.NEED_WRAP, i14, i17);
                                        SSL.bioClearByteBuffer(this.networkBIO);
                                        if (byteBufDirectBuffer == null) {
                                            byteBuffer.position(byteBuffer.position() + i17);
                                        } else {
                                            byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), i17));
                                            byteBufDirectBuffer.release();
                                        }
                                        return sSLEngineResultNewResult9;
                                    }
                                    SSLEngineResult sSLEngineResultNewResult10 = newResult(SSLEngineResult.Status.BUFFER_OVERFLOW, handshakeStatusHandshake, i14, i17);
                                    SSL.bioClearByteBuffer(this.networkBIO);
                                    if (byteBufDirectBuffer == null) {
                                        byteBuffer.position(byteBuffer.position() + i17);
                                    } else {
                                        byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), i17));
                                        byteBufDirectBuffer.release();
                                    }
                                    return sSLEngineResultNewResult10;
                                }
                                i10++;
                            }
                            SSLEngineResult sSLEngineResultNewResultMayFinishHandshake7 = newResultMayFinishHandshake(handshakeStatusHandshake, i14, iBioFlushByteBuffer4);
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (byteBufDirectBuffer == null) {
                                byteBuffer.position(byteBuffer.position() + iBioFlushByteBuffer4);
                            } else {
                                byteBuffer.put(byteBufDirectBuffer.internalNioBuffer(byteBufDirectBuffer.readerIndex(), iBioFlushByteBuffer4));
                                byteBufDirectBuffer.release();
                            }
                            return sSLEngineResultNewResultMayFinishHandshake7;
                        } catch (Throwable th5) {
                            i13 = byteBufferArr;
                            th = th5;
                            byteBuf = byteBufDirectBuffer;
                            SSL.bioClearByteBuffer(this.networkBIO);
                            if (byteBuf != null) {
                                byteBuffer.put(byteBuf.internalNioBuffer(byteBuf.readerIndex(), i13));
                                byteBuf.release();
                            } else {
                                byteBuffer.position(byteBuffer.position() + i13);
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        byteBuf = byteBufDirectBuffer;
                        i13 = iBioLengthByteBuffer2;
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Throwable th8) {
                throw th8;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isEmpty(byte[] bArr) {
        return bArr == null || bArr.length == 0;
    }

    private SSLEngineResult newResult(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i10, int i11) {
        if (!isOutboundDone()) {
            if (handshakeStatus == SSLEngineResult.HandshakeStatus.NEED_TASK) {
                this.needTask = true;
            }
            return new SSLEngineResult(status, handshakeStatus, i10, i11);
        }
        if (isInboundDone()) {
            handshakeStatus = SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
            shutdown();
        }
        return new SSLEngineResult(SSLEngineResult.Status.CLOSED, handshakeStatus, i10, i11);
    }

    private SSLEngineResult newResultMayFinishHandshake(SSLEngineResult.Status status, SSLEngineResult.HandshakeStatus handshakeStatus, int i10, int i11) throws SSLException {
        return newResult(status, mayFinishHandshake(handshakeStatus, i10, i11), i10, i11);
    }

    private SSLException shutdownWithError(String str, int i10, int i11) {
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("{} failed with {}: OpenSSL error: {} {}", str, Integer.valueOf(i10), Integer.valueOf(i11), SSL.getErrorString(i11));
        }
        shutdown();
        SSLException sSLExceptionNewSSLExceptionForError = newSSLExceptionForError(i11);
        Throwable th2 = this.pendingException;
        if (th2 != null) {
            sSLExceptionNewSSLExceptionForError.initCause(th2);
            this.pendingException = null;
        }
        return sSLExceptionNewSSLExceptionForError;
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

    private SSLEngineResult.HandshakeStatus mayFinishHandshake(SSLEngineResult.HandshakeStatus handshakeStatus) throws SSLException {
        if (handshakeStatus == SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING) {
            if (this.handshakeState != HandshakeState.FINISHED) {
                return handshake();
            }
            if (!isDestroyed() && SSL.bioLengthNonApplication(this.networkBIO) > 0) {
                return SSLEngineResult.HandshakeStatus.NEED_WRAP;
            }
        }
        return handshakeStatus;
    }

    private SSLEngineResult.HandshakeStatus getHandshakeStatus(int i10) {
        if (needPendingStatus()) {
            if (this.needTask) {
                return SSLEngineResult.HandshakeStatus.NEED_TASK;
            }
            return pendingStatus(i10);
        }
        return SSLEngineResult.HandshakeStatus.NOT_HANDSHAKING;
    }

    private String selectApplicationProtocol(List<String> list, ApplicationProtocolConfig.SelectedListenerFailureBehavior selectedListenerFailureBehavior, String str) throws SSLException {
        if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.ACCEPT) {
            return str;
        }
        int size = list.size();
        if (list.contains(str)) {
            return str;
        }
        if (selectedListenerFailureBehavior == ApplicationProtocolConfig.SelectedListenerFailureBehavior.CHOOSE_MY_LAST_PROTOCOL) {
            return list.get(size - 1);
        }
        throw new SSLException(m.a.a("unknown protocol ", str));
    }

    public final SSLEngineResult unwrap(ByteBuffer[] byteBufferArr, ByteBuffer[] byteBufferArr2) throws SSLException {
        return unwrap(byteBufferArr, 0, byteBufferArr.length, byteBufferArr2, 0, byteBufferArr2.length);
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr, int i10, int i11) throws SSLException {
        SSLEngineResult sSLEngineResultUnwrap;
        try {
            sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), 0, 1, byteBufferArr, i10, i11);
            resetSingleSrcBuffer();
        } catch (Throwable th2) {
            resetSingleSrcBuffer();
            throw th2;
        }
        return sSLEngineResultUnwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult sSLEngineResultUnwrap;
        try {
            sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), singleDstBuffer(byteBuffer2));
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
        } catch (Throwable th2) {
            resetSingleSrcBuffer();
            resetSingleDstBuffer();
            throw th2;
        }
        return sSLEngineResultUnwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) throws SSLException {
        SSLEngineResult sSLEngineResultUnwrap;
        try {
            sSLEngineResultUnwrap = unwrap(singleSrcBuffer(byteBuffer), byteBufferArr);
            resetSingleSrcBuffer();
        } catch (Throwable th2) {
            resetSingleSrcBuffer();
            throw th2;
        }
        return sSLEngineResultUnwrap;
    }

    @Override // javax.net.ssl.SSLEngine
    public final synchronized SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        SSLEngineResult sSLEngineResultWrap;
        try {
            sSLEngineResultWrap = wrap(singleSrcBuffer(byteBuffer), byteBuffer2);
            resetSingleSrcBuffer();
        } catch (Throwable th2) {
            resetSingleSrcBuffer();
            throw th2;
        }
        return sSLEngineResultWrap;
    }
}
