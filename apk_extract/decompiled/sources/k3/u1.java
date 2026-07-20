package k3;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class u1 {
    public static dj.q a(SSLSession handshake) throws IOException {
        List listEmptyList;
        Intrinsics.checkNotNullParameter(handshake, "$this$handshake");
        String cipherSuite = handshake.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        int iHashCode = cipherSuite.hashCode();
        if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
            throw new IOException("cipherSuite == ".concat(cipherSuite));
        }
        dj.h hVarD = dj.h.f4555t.d(cipherSuite);
        String protocol = handshake.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if (Intrinsics.areEqual("NONE", protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        dj.p0.Companion.getClass();
        dj.p0 p0VarA = dj.o0.a(protocol);
        try {
            Certificate[] peerCertificates = handshake.getPeerCertificates();
            listEmptyList = peerCertificates != null ? ej.b.l((Certificate[]) Arrays.copyOf(peerCertificates, peerCertificates.length)) : CollectionsKt.emptyList();
        } catch (SSLPeerUnverifiedException unused) {
            listEmptyList = CollectionsKt.emptyList();
        }
        Certificate[] localCertificates = handshake.getLocalCertificates();
        return new dj.q(p0VarA, hVarD, localCertificates != null ? ej.b.l((Certificate[]) Arrays.copyOf(localCertificates, localCertificates.length)) : CollectionsKt.emptyList(), new dj.o(listEmptyList));
    }
}
