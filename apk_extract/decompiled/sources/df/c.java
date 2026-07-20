package df;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f4434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f4435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String[] f4436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f4437d;

    static {
        a[] aVarArr = {a.TLS_AES_128_GCM_SHA256, a.TLS_AES_256_GCM_SHA384, a.TLS_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_AES_128_GCM_SHA256, a.TLS_RSA_WITH_AES_256_GCM_SHA384, a.TLS_RSA_WITH_AES_128_CBC_SHA, a.TLS_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        b bVar = new b(true);
        bVar.a(aVarArr);
        n nVar = n.TLS_1_3;
        n nVar2 = n.TLS_1_2;
        bVar.b(nVar, nVar2);
        if (!bVar.f4430a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        bVar.f4433d = true;
        c cVar = new c(bVar);
        e = cVar;
        b bVar2 = new b(cVar);
        bVar2.b(nVar, nVar2, n.TLS_1_1, n.TLS_1_0);
        if (!bVar2.f4430a) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        bVar2.f4433d = true;
        new c(bVar2);
        new c(new b(false));
    }

    public c(b bVar) {
        this.f4434a = bVar.f4430a;
        this.f4435b = bVar.f4431b;
        this.f4436c = bVar.f4432c;
        this.f4437d = bVar.f4433d;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        c cVar = (c) obj;
        boolean z2 = cVar.f4434a;
        boolean z3 = this.f4434a;
        if (z3 != z2) {
            return false;
        }
        return !z3 || (Arrays.equals(this.f4435b, cVar.f4435b) && Arrays.equals(this.f4436c, cVar.f4436c) && this.f4437d == cVar.f4437d);
    }

    public final int hashCode() {
        if (this.f4434a) {
            return ((((527 + Arrays.hashCode(this.f4435b)) * 31) + Arrays.hashCode(this.f4436c)) * 31) + (!this.f4437d ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        List listUnmodifiableList;
        if (!this.f4434a) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.f4435b;
        if (strArr == null) {
            listUnmodifiableList = null;
        } else {
            a[] aVarArr = new a[strArr.length];
            for (int i8 = 0; i8 < strArr.length; i8++) {
                aVarArr[i8] = a.forJavaName(strArr[i8]);
            }
            String[] strArr2 = o.f4461a;
            listUnmodifiableList = Collections.unmodifiableList(Arrays.asList((Object[]) aVarArr.clone()));
        }
        StringBuilder sbY = a1.a.y("ConnectionSpec(cipherSuites=", listUnmodifiableList == null ? "[use default]" : listUnmodifiableList.toString(), ", tlsVersions=");
        String[] strArr3 = this.f4436c;
        n[] nVarArr = new n[strArr3.length];
        for (int i9 = 0; i9 < strArr3.length; i9++) {
            nVarArr[i9] = n.forJavaName(strArr3[i9]);
        }
        String[] strArr4 = o.f4461a;
        sbY.append(Collections.unmodifiableList(Arrays.asList((Object[]) nVarArr.clone())));
        sbY.append(", supportsTlsExtensions=");
        sbY.append(this.f4437d);
        sbY.append(")");
        return sbY.toString();
    }
}
