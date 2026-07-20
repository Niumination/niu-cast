package pj;

import java.security.GeneralSecurityException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import k3.lc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends lc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f8914a;

    public a(b trustRootIndex) {
        Intrinsics.checkNotNullParameter(trustRootIndex, "trustRootIndex");
        this.f8914a = trustRootIndex;
    }

    @Override // k3.lc
    public final List a(String hostname, List chain) throws SSLPeerUnverifiedException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Intrinsics.checkNotNullParameter(hostname, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(chain);
        ArrayList arrayList = new ArrayList();
        Object objRemoveFirst = arrayDeque.removeFirst();
        Intrinsics.checkNotNullExpressionValue(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        int i8 = 0;
        boolean z2 = false;
        while (i8 < 9) {
            Object objI = a1.a.i(1, arrayList);
            if (objI == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate cert = (X509Certificate) objI;
            b bVar = this.f8914a;
            bVar.getClass();
            Intrinsics.checkNotNullParameter(cert, "cert");
            Set set = (Set) bVar.f8915a.get(cert.getIssuerX500Principal());
            X509Certificate x509Certificate = null;
            Object obj = null;
            if (set != null) {
                for (Object obj2 : set) {
                    try {
                        cert.verify(((X509Certificate) obj2).getPublicKey());
                        obj = obj2;
                        break;
                    } catch (Exception unused) {
                    }
                }
                x509Certificate = (X509Certificate) obj;
            }
            if (x509Certificate != null) {
                if (arrayList.size() > 1 || !Intrinsics.areEqual(cert, x509Certificate)) {
                    arrayList.add(x509Certificate);
                }
                if (Intrinsics.areEqual(x509Certificate.getIssuerDN(), x509Certificate.getSubjectDN())) {
                    try {
                        x509Certificate.verify(x509Certificate.getPublicKey());
                        return arrayList;
                    } catch (GeneralSecurityException unused2) {
                    }
                }
                z2 = true;
            } else {
                Iterator it = arrayDeque.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "queue.iterator()");
                while (true) {
                    if (!it.hasNext()) {
                        if (z2) {
                            return arrayList;
                        }
                        throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + cert);
                    }
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (Intrinsics.areEqual(cert.getIssuerDN(), x509Certificate2.getSubjectDN())) {
                        try {
                            cert.verify(x509Certificate2.getPublicKey());
                            it.remove();
                            arrayList.add(x509Certificate2);
                            break;
                        } catch (GeneralSecurityException unused3) {
                            continue;
                        }
                    }
                }
            }
            i8++;
            z2 = z2;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof a) && Intrinsics.areEqual(((a) obj).f8914a, this.f8914a);
    }

    public final int hashCode() {
        return this.f8914a.hashCode();
    }
}
