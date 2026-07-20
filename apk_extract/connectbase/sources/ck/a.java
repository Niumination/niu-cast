package ck;

import c1.h0;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import vj.e0;

/* JADX INFO: loaded from: classes2.dex */
@e0("https://github.com/grpc/grpc-java/issues/8024")
public final class a extends X509ExtendedKeyManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f1471b = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f1472a;

    /* JADX INFO: renamed from: ck.a$a, reason: collision with other inner class name */
    public class C0064a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledFuture f1473a;

        public C0064a(ScheduledFuture scheduledFuture) {
            this.f1473a = scheduledFuture;
        }

        @Override // ck.a.b, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f1473a.cancel(false);
        }
    }

    public interface b extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PrivateKey f1475a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final X509Certificate[] f1476b;

        public c(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.f1475a = privateKey;
            this.f1476b = x509CertificateArr;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public File f1477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public File f1478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1479c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f1480d = 0;

        public d(File file, File file2) {
            this.f1477a = file;
            this.f1478b = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVarC = a.this.c(this.f1477a, this.f1478b, this.f1479c, this.f1480d);
                if (eVarC.f1482a) {
                    this.f1479c = eVarC.f1483b;
                    this.f1480d = eVarC.f1484c;
                }
            } catch (IOException | GeneralSecurityException e10) {
                a.f1471b.log(Level.SEVERE, "Failed refreshing private key and certificate chain from files. Using previous ones", e10);
            }
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f1482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f1483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1484c;

        public e(boolean z10, long j10, long j11) {
            this.f1482a = z10;
            this.f1483b = j10;
            this.f1484c = j11;
        }
    }

    public final e c(File file, File file2, long j10, long j11) throws GeneralSecurityException, IOException {
        long jLastModified = file.lastModified();
        long jLastModified2 = file2.lastModified();
        if (jLastModified == j10 || jLastModified2 == j11) {
            return new e(false, j10, j11);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            PrivateKey privateKeyA = ck.c.a(fileInputStream);
            fileInputStream = new FileInputStream(file2);
            try {
                d(privateKeyA, ck.c.b(fileInputStream));
                e eVar = new e(true, jLastModified, jLastModified2);
                fileInputStream.close();
                return eVar;
            } finally {
                fileInputStream.close();
            }
        } catch (Throwable th2) {
            fileInputStream.close();
            throw th2;
        }
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        return ks.c.f9460f;
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        return ks.c.f9460f;
    }

    @Override // javax.net.ssl.X509ExtendedKeyManager
    public String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        return ks.c.f9460f;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        return ks.c.f9460f;
    }

    public void d(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        this.f1472a = new c((PrivateKey) h0.F(privateKey, cb.b.c.f1408o), (X509Certificate[]) h0.F(x509CertificateArr, "certs"));
    }

    public b e(File file, File file2, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) throws GeneralSecurityException, IOException {
        if (c(file, file2, 0L, 0L).f1482a) {
            return new C0064a(scheduledExecutorService.scheduleWithFixedDelay(new d(file, file2), j10, j10, timeUnit));
        }
        throw new GeneralSecurityException("Files were unmodified before their initial update. Probably a bug.");
    }

    public void f(File file, File file2) throws GeneralSecurityException, IOException {
        if (!c(file, file2, 0L, 0L).f1482a) {
            throw new GeneralSecurityException("Files were unmodified before their initial update. Probably a bug.");
        }
    }

    @Override // javax.net.ssl.X509KeyManager
    public X509Certificate[] getCertificateChain(String str) {
        if (str.equals(ks.c.f9460f)) {
            return (X509Certificate[]) Arrays.copyOf(this.f1472a.f1476b, this.f1472a.f1476b.length);
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getClientAliases(String str, Principal[] principalArr) {
        return new String[]{ks.c.f9460f};
    }

    @Override // javax.net.ssl.X509KeyManager
    public PrivateKey getPrivateKey(String str) {
        if (str.equals(ks.c.f9460f)) {
            return this.f1472a.f1475a;
        }
        return null;
    }

    @Override // javax.net.ssl.X509KeyManager
    public String[] getServerAliases(String str, Principal[] principalArr) {
        return new String[]{ks.c.f9460f};
    }
}
