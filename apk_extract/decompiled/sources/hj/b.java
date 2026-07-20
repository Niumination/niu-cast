package hj;

import java.net.UnknownServiceException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5417a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f5418b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5419c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5420d;

    public b(List connectionSpecs) {
        Intrinsics.checkNotNullParameter(connectionSpecs, "connectionSpecs");
        this.f5420d = connectionSpecs;
    }

    public final dj.j a(SSLSocket sslSocket) throws UnknownServiceException, CloneNotSupportedException {
        dj.j connectionSpec;
        int i8;
        boolean z2;
        String[] cipherSuitesIntersection;
        String[] tlsVersionsIntersection;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        int i9 = this.f5417a;
        List list = this.f5420d;
        int size = list.size();
        while (true) {
            if (i9 >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = (dj.j) list.get(i9);
            if (connectionSpec.b(sslSocket)) {
                this.f5417a = i9 + 1;
                break;
            }
            i9++;
        }
        if (connectionSpec == null) {
            StringBuilder sb2 = new StringBuilder("Unable to find acceptable protocols. isFallback=");
            sb2.append(this.f5419c);
            sb2.append(", modes=");
            sb2.append(list);
            sb2.append(", supported protocols=");
            String[] enabledProtocols = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNull(enabledProtocols);
            String string = Arrays.toString(enabledProtocols);
            Intrinsics.checkNotNullExpressionValue(string, "java.util.Arrays.toString(this)");
            sb2.append(string);
            throw new UnknownServiceException(sb2.toString());
        }
        int i10 = this.f5417a;
        int size2 = list.size();
        while (true) {
            i8 = 0;
            if (i10 >= size2) {
                z2 = false;
                break;
            }
            if (((dj.j) list.get(i10)).b(sslSocket)) {
                z2 = true;
                break;
            }
            i10++;
        }
        this.f5418b = z2;
        boolean z3 = this.f5419c;
        Intrinsics.checkNotNullParameter(sslSocket, "sslSocket");
        String[] strArr = connectionSpec.f4574c;
        if (strArr != null) {
            String[] enabledCipherSuites = sslSocket.getEnabledCipherSuites();
            Intrinsics.checkNotNullExpressionValue(enabledCipherSuites, "sslSocket.enabledCipherSuites");
            cipherSuitesIntersection = ej.b.p(enabledCipherSuites, strArr, dj.h.f4541b);
        } else {
            cipherSuitesIntersection = sslSocket.getEnabledCipherSuites();
        }
        String[] strArr2 = connectionSpec.f4575d;
        if (strArr2 != null) {
            String[] enabledProtocols2 = sslSocket.getEnabledProtocols();
            Intrinsics.checkNotNullExpressionValue(enabledProtocols2, "sslSocket.enabledProtocols");
            tlsVersionsIntersection = ej.b.p(enabledProtocols2, strArr2, ComparisonsKt.naturalOrder());
        } else {
            tlsVersionsIntersection = sslSocket.getEnabledProtocols();
        }
        String[] indexOf = sslSocket.getSupportedCipherSuites();
        Intrinsics.checkNotNullExpressionValue(indexOf, "supportedCipherSuites");
        dj.g comparator = dj.h.f4541b;
        byte[] bArr = ej.b.f4964a;
        Intrinsics.checkNotNullParameter(indexOf, "$this$indexOf");
        Intrinsics.checkNotNullParameter("TLS_FALLBACK_SCSV", "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = indexOf.length;
        while (true) {
            if (i8 >= length) {
                i8 = -1;
                break;
            }
            if (comparator.compare(indexOf[i8], "TLS_FALLBACK_SCSV") == 0) {
                break;
            }
            i8++;
        }
        if (z3 && i8 != -1) {
            Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
            String value = indexOf[i8];
            Intrinsics.checkNotNullExpressionValue(value, "supportedCipherSuites[indexOfFallbackScsv]");
            Intrinsics.checkNotNullParameter(cipherSuitesIntersection, "$this$concat");
            Intrinsics.checkNotNullParameter(value, "value");
            Object[] objArrCopyOf = Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length + 1);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
            cipherSuitesIntersection = (String[]) objArrCopyOf;
            cipherSuitesIntersection[ArraysKt.getLastIndex(cipherSuitesIntersection)] = value;
        }
        Intrinsics.checkNotNullParameter(connectionSpec, "connectionSpec");
        dj.i iVar = new dj.i();
        iVar.f4557a = connectionSpec.f4572a;
        iVar.f4558b = strArr;
        iVar.f4559c = strArr2;
        iVar.f4560d = connectionSpec.f4573b;
        Intrinsics.checkNotNullExpressionValue(cipherSuitesIntersection, "cipherSuitesIntersection");
        iVar.c((String[]) Arrays.copyOf(cipherSuitesIntersection, cipherSuitesIntersection.length));
        Intrinsics.checkNotNullExpressionValue(tlsVersionsIntersection, "tlsVersionsIntersection");
        iVar.e((String[]) Arrays.copyOf(tlsVersionsIntersection, tlsVersionsIntersection.length));
        dj.j jVarA = iVar.a();
        if (jVarA.c() != null) {
            sslSocket.setEnabledProtocols(jVarA.f4575d);
        }
        if (jVarA.a() != null) {
            sslSocket.setEnabledCipherSuites(jVarA.f4574c);
        }
        return connectionSpec;
    }
}
