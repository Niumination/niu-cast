package ck;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509ExtendedTrustManager;
import vj.e0;

/* JADX INFO: loaded from: classes2.dex */
@is.a
@e0("https://github.com/grpc/grpc-java/issues/8024")
public final class b extends X509ExtendedTrustManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Logger f1485d = Logger.getLogger(b.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f1487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile X509ExtendedTrustManager f1488c;

    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledFuture f1489a;

        public a(ScheduledFuture scheduledFuture) {
            this.f1489a = scheduledFuture;
        }

        @Override // ck.b.c, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f1489a.cancel(false);
        }
    }

    /* JADX INFO: renamed from: ck.b$b, reason: collision with other inner class name */
    public static final class C0065b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public f f1491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f1492b;

        public /* synthetic */ C0065b(a aVar) {
            this();
        }

        public b a() throws CertificateException {
            return new b(this.f1491a, this.f1492b);
        }

        public C0065b b(e eVar) {
            this.f1492b = eVar;
            return this;
        }

        public C0065b c(f fVar) {
            this.f1491a = fVar;
            return this;
        }

        public C0065b() {
            this.f1491a = f.CERTIFICATE_AND_HOST_NAME_VERIFICATION;
        }
    }

    public interface c extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f1493a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1494b = 0;

        public d(File file) {
            this.f1493a = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f1494b = b.this.f(this.f1493a, this.f1494b);
            } catch (IOException | GeneralSecurityException e10) {
                b.f1485d.log(Level.SEVERE, "Failed refreshing trust CAs from file. Using previous CAs", e10);
            }
        }
    }

    public interface e {
        void a(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException;

        void b(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException;
    }

    public enum f {
        CERTIFICATE_AND_HOST_NAME_VERIFICATION,
        CERTIFICATE_ONLY_VERIFICATION,
        INSECURELY_SKIP_ALL_VERIFICATION
    }

    public /* synthetic */ b(f fVar, e eVar, a aVar) throws CertificateException {
        this(fVar, eVar);
    }

    public static X509ExtendedTrustManager d(KeyStore keyStore) throws NoSuchAlgorithmException, KeyStoreException, CertificateException {
        X509ExtendedTrustManager x509ExtendedTrustManager;
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(keyStore);
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        int i10 = 0;
        while (true) {
            if (i10 >= trustManagers.length) {
                x509ExtendedTrustManager = null;
                break;
            }
            TrustManager trustManager = trustManagers[i10];
            if (trustManager instanceof X509ExtendedTrustManager) {
                x509ExtendedTrustManager = (X509ExtendedTrustManager) trustManager;
                break;
            }
            i10++;
        }
        if (x509ExtendedTrustManager != null) {
            return x509ExtendedTrustManager;
        }
        throw new CertificateException("Failed to find X509ExtendedTrustManager with default TrustManager algorithm " + TrustManagerFactory.getDefaultAlgorithm());
    }

    public static C0065b e() {
        return new C0065b();
    }

    public final void c(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine, Socket socket, boolean z10) throws CertificateException {
        if (x509CertificateArr == null || x509CertificateArr.length == 0) {
            throw new IllegalArgumentException("Want certificate verification but got null or empty certificates");
        }
        if (sSLEngine == null && socket == null) {
            throw new CertificateException("Not enough information to validate peer. SSLEngine or Socket required.");
        }
        if (this.f1486a != f.INSECURELY_SKIP_ALL_VERIFICATION) {
            X509ExtendedTrustManager x509ExtendedTrustManager = this.f1488c;
            if (x509ExtendedTrustManager == null) {
                throw new CertificateException("No trust roots configured");
            }
            if (z10) {
                String str2 = this.f1486a == f.CERTIFICATE_AND_HOST_NAME_VERIFICATION ? "HTTPS" : "";
                if (sSLEngine != null) {
                    SSLParameters sSLParameters = sSLEngine.getSSLParameters();
                    sSLParameters.setEndpointIdentificationAlgorithm(str2);
                    sSLEngine.setSSLParameters(sSLParameters);
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, sSLEngine);
                } else {
                    if (!(socket instanceof SSLSocket)) {
                        throw new CertificateException("socket is not a type of SSLSocket");
                    }
                    SSLSocket sSLSocket = (SSLSocket) socket;
                    SSLParameters sSLParameters2 = sSLSocket.getSSLParameters();
                    sSLParameters2.setEndpointIdentificationAlgorithm(str2);
                    sSLSocket.setSSLParameters(sSLParameters2);
                    x509ExtendedTrustManager.checkServerTrusted(x509CertificateArr, str, sSLSocket);
                }
            } else {
                x509ExtendedTrustManager.checkClientTrusted(x509CertificateArr, str, sSLEngine);
            }
        }
        e eVar = this.f1487b;
        if (eVar != null) {
            if (sSLEngine != null) {
                eVar.a(x509CertificateArr, str, sSLEngine);
            } else {
                eVar.b(x509CertificateArr, str, socket);
            }
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Not enough information to validate peer. SSLEngine or Socket required.");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        c(x509CertificateArr, str, sSLEngine, null, true);
    }

    public final long f(File file, long j10) throws GeneralSecurityException, IOException {
        long jLastModified = file.lastModified();
        if (jLastModified == j10) {
            return j10;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            g(ck.c.b(fileInputStream));
            return jLastModified;
        } finally {
            fileInputStream.close();
        }
    }

    public void g(X509Certificate[] x509CertificateArr) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        int i10 = 1;
        for (X509Certificate x509Certificate : x509CertificateArr) {
            keyStore.setCertificateEntry(Integer.toString(i10), x509Certificate);
            i10++;
        }
        this.f1488c = d(keyStore);
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.f1488c == null ? new X509Certificate[0] : this.f1488c.getAcceptedIssuers();
    }

    public c h(File file, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) throws GeneralSecurityException, IOException {
        if (f(file, 0L) != 0) {
            return new a(scheduledExecutorService.scheduleWithFixedDelay(new d(file), j10, j10, timeUnit));
        }
        throw new GeneralSecurityException("Files were unmodified before their initial update. Probably a bug.");
    }

    public void i(File file) throws GeneralSecurityException, IOException {
        if (f(file, 0L) == 0) {
            throw new GeneralSecurityException("Files were unmodified before their initial update. Probably a bug.");
        }
    }

    public void j() throws NoSuchAlgorithmException, CertificateException, KeyStoreException {
        this.f1488c = d(null);
    }

    public b(f fVar, e eVar) throws CertificateException {
        this.f1488c = null;
        this.f1486a = fVar;
        this.f1487b = eVar;
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        c(x509CertificateArr, str, null, socket, false);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        throw new CertificateException("Not enough information to validate peer. SSLEngine or Socket required.");
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        c(x509CertificateArr, str, sSLEngine, null, false);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        c(x509CertificateArr, str, null, socket, true);
    }
}
