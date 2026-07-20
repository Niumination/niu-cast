package io.netty.handler.ssl;

import io.netty.util.internal.SuppressJava6Requirement;
import java.net.Socket;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedTrustManager;
import javax.net.ssl.X509TrustManager;
import k.c;
import ks.g;

/* JADX INFO: loaded from: classes3.dex */
@SuppressJava6Requirement(reason = "Usage guarded by java version check")
final class EnhancingX509ExtendedTrustManager extends X509ExtendedTrustManager {
    private final X509ExtendedTrustManager wrapped;

    public EnhancingX509ExtendedTrustManager(X509TrustManager x509TrustManager) {
        this.wrapped = (X509ExtendedTrustManager) x509TrustManager;
    }

    private static void throwEnhancedCertificateException(X509Certificate[] x509CertificateArr, CertificateException certificateException) throws CertificateException {
        String message = certificateException.getMessage();
        if (message == null || !certificateException.getMessage().startsWith("No subject alternative DNS name matching")) {
            throw certificateException;
        }
        StringBuilder sb2 = new StringBuilder(64);
        for (X509Certificate x509Certificate : x509CertificateArr) {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                for (List<?> list : subjectAlternativeNames) {
                    if (list.size() >= 2 && ((Integer) list.get(0)).intValue() == 2) {
                        sb2.append((String) list.get(1));
                        sb2.append(g.f9491d);
                    }
                }
            }
        }
        if (sb2.length() == 0) {
            throw certificateException;
        }
        sb2.setLength(sb2.length() - 1);
        StringBuilder sbA = c.a(message, " Subject alternative DNS names in the certificate chain of ");
        sbA.append(x509CertificateArr.length);
        sbA.append(" certificate(s): ");
        sbA.append((Object) sb2);
        throw new CertificateException(sbA.toString(), certificateException);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        this.wrapped.checkClientTrusted(x509CertificateArr, str, socket);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, Socket socket) throws CertificateException {
        try {
            this.wrapped.checkServerTrusted(x509CertificateArr, str, socket);
        } catch (CertificateException e10) {
            throwEnhancedCertificateException(x509CertificateArr, e10);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        return this.wrapped.getAcceptedIssuers();
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        this.wrapped.checkClientTrusted(x509CertificateArr, str, sSLEngine);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        this.wrapped.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509ExtendedTrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str, SSLEngine sSLEngine) throws CertificateException {
        try {
            this.wrapped.checkServerTrusted(x509CertificateArr, str, sSLEngine);
        } catch (CertificateException e10) {
            throwEnhancedCertificateException(x509CertificateArr, e10);
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        try {
            this.wrapped.checkServerTrusted(x509CertificateArr, str);
        } catch (CertificateException e10) {
            throwEnhancedCertificateException(x509CertificateArr, e10);
        }
    }
}
