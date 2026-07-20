package li;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.KeyStore;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes2.dex */
public class b extends dr.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Cipher f10015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Cipher f10016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Key f10017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Key f10018d;

    @b.a({"TrulyRandom"})
    private void j() throws Exception {
        k();
        if (this.f10016b == null) {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f10018d);
            this.f10016b = cipher;
        }
    }

    @Override // dr.a
    public byte[] e(String str) throws Exception {
        return f(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // dr.a
    public byte[] f(byte[] bArr) throws Exception {
        i();
        return this.f10015a.doFinal(bArr);
    }

    @Override // dr.a
    public byte[] g(String str) throws Exception {
        return h(str.getBytes(StandardCharsets.UTF_8));
    }

    @Override // dr.a
    public byte[] h(byte[] bArr) throws Exception {
        j();
        return this.f10016b.doFinal(bArr);
    }

    public final void i() throws Exception {
        try {
            k();
            if (this.f10015a == null) {
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(2, this.f10017c);
                this.f10015a = cipher;
            }
        } catch (NoClassDefFoundError unused) {
            throw new Exception("NoClassDefFound...");
        }
    }

    public final void k() throws Exception {
        if (this.f10017c == null || this.f10018d == null) {
            KeyStore keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            this.f10017c = keyStore.getKey("crypto", null);
            this.f10018d = keyStore.getCertificate("crypto").getPublicKey();
        }
    }
}
