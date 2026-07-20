package li;

import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class a extends dr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f10012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f10013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f10014c;

    public a(String str) {
        this.f10014c = b(str);
    }

    @Override // dr.a
    public byte[] e(String str) throws Exception {
        throw new Exception("do not support decrypt mode");
    }

    @Override // dr.a
    public byte[] f(byte[] bArr) throws Exception {
        throw new Exception("do not support decrypt mode");
    }

    @Override // dr.a
    public byte[] g(String str) throws Exception {
        return h(str.getBytes(Charset.forName("UTF-8")));
    }

    @Override // dr.a
    public byte[] h(byte[] bArr) throws Exception {
        i();
        return this.f10013b.doFinal(bArr);
    }

    @b.a({"TrulyRandom"})
    public final void i() throws Exception {
        if (this.f10013b == null) {
            PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f10014c));
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, publicKeyGeneratePublic);
            this.f10013b = cipher;
        }
    }

    public final boolean j(byte[] bArr, byte[] bArr2) throws Exception {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(this.f10014c));
        Signature signature = Signature.getInstance("MD5withRSA");
        signature.initVerify(publicKeyGeneratePublic);
        signature.update(bArr);
        return signature.verify(bArr2);
    }

    public boolean k(String str, String str2) throws Exception {
        return j(str.getBytes(Charset.forName("UTF-8")), str2.getBytes(Charset.forName("UTF-8")));
    }

    public boolean l(byte[] bArr, byte[] bArr2) throws Exception {
        return j(bArr, bArr2);
    }

    public a(byte[] bArr) {
        this.f10014c = bArr;
    }
}
