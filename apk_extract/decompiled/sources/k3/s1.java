package k3;

import java.security.PublicKey;
import java.security.cert.X509Certificate;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public abstract class s1 {
    public static String a(X509Certificate sha256Hash) {
        Intrinsics.checkNotNullParameter(sha256Hash, "certificate");
        if (sha256Hash == null) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        StringBuilder sb2 = new StringBuilder("sha256/");
        Intrinsics.checkNotNullParameter(sha256Hash, "$this$sha256Hash");
        qj.i iVar = qj.j.Companion;
        PublicKey publicKey = sha256Hash.getPublicKey();
        Intrinsics.checkNotNullExpressionValue(publicKey, "publicKey");
        byte[] encoded = publicKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "publicKey.encoded");
        iVar.getClass();
        sb2.append(qj.i.c(encoded, 0, -1234567890).sha256().base64());
        return sb2.toString();
    }
}
