package dj;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4620a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p0 f4621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f4622c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f4623d;

    public q(p0 tlsVersion, h cipherSuite, List localCertificates, Function0 peerCertificatesFn) {
        Intrinsics.checkNotNullParameter(tlsVersion, "tlsVersion");
        Intrinsics.checkNotNullParameter(cipherSuite, "cipherSuite");
        Intrinsics.checkNotNullParameter(localCertificates, "localCertificates");
        Intrinsics.checkNotNullParameter(peerCertificatesFn, "peerCertificatesFn");
        this.f4621b = tlsVersion;
        this.f4622c = cipherSuite;
        this.f4623d = localCertificates;
        this.f4620a = LazyKt.lazy(new p(peerCertificatesFn));
    }

    public final List a() {
        return (List) this.f4620a.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (qVar.f4621b == this.f4621b && Intrinsics.areEqual(qVar.f4622c, this.f4622c) && Intrinsics.areEqual(qVar.a(), a()) && Intrinsics.areEqual(qVar.f4623d, this.f4623d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f4623d.hashCode() + ((a().hashCode() + ((this.f4622c.hashCode() + ((this.f4621b.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> listA = a();
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listA));
        for (Certificate certificate : listA) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "type");
            }
            arrayList.add(type2);
        }
        String string = arrayList.toString();
        StringBuilder sb2 = new StringBuilder("Handshake{tlsVersion=");
        sb2.append(this.f4621b);
        sb2.append(" cipherSuite=");
        sb2.append(this.f4622c);
        sb2.append(" peerCertificates=");
        sb2.append(string);
        sb2.append(" localCertificates=");
        List<Certificate> list = this.f4623d;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.i(list));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                Intrinsics.checkNotNullExpressionValue(type, "type");
            }
            arrayList2.add(type);
        }
        sb2.append(arrayList2);
        sb2.append('}');
        return sb2.toString();
    }
}
