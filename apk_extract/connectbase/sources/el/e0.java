package el;

import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class e0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final SecretKeySpec f4517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f4518b;

    public e0(@os.l SecretKeySpec secretKeySpec, @os.l String str) {
        l0.p(secretKeySpec, "keySpec");
        l0.p(str, "algorithm");
        this.f4517a = secretKeySpec;
        this.f4518b = str;
    }

    @Override // el.z
    @os.m
    public String a(@os.l String str) throws NoSuchAlgorithmException, InvalidKeyException {
        l0.p(str, "transportValue");
        String strO5 = jq.h0.o5(str, b0.f4502a, "");
        String strY5 = jq.h0.y5(str, b0.f4502a, null, 2, null);
        String strE = e(strY5);
        Charset charset = jq.f.f8800b;
        byte[] bytes = strE.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bytes2 = strO5.getBytes(charset);
        l0.o(bytes2, "this as java.lang.String).getBytes(charset)");
        if (MessageDigest.isEqual(bytes, bytes2)) {
            return strY5;
        }
        return null;
    }

    @Override // el.z
    @os.l
    public String b(@os.l String str) {
        l0.p(str, "transportValue");
        return str + b0.f4502a + e(str);
    }

    @os.l
    public final String c() {
        return this.f4518b;
    }

    @os.l
    public final SecretKeySpec d() {
        return this.f4517a;
    }

    public final String e(String str) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(this.f4518b);
        mac.init(this.f4517a);
        byte[] bytes = str.getBytes(jq.f.f8800b);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        byte[] bArrDoFinal = mac.doFinal(bytes);
        l0.o(bArrDoFinal, "mac.doFinal(value.toByteArray())");
        return fl.b0.f(bArrDoFinal);
    }

    public /* synthetic */ e0(SecretKeySpec secretKeySpec, String str, int i10, kn.w wVar) {
        this(secretKeySpec, (i10 & 2) != 0 ? "HmacSHA256" : str);
    }

    public /* synthetic */ e0(byte[] bArr, String str, int i10, kn.w wVar) {
        this(bArr, (i10 & 2) != 0 ? "HmacSHA256" : str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public e0(@os.l byte[] bArr, @os.l String str) {
        this(new SecretKeySpec(bArr, str), str);
        l0.p(bArr, cb.b.c.f1408o);
        l0.p(str, "algorithm");
    }
}
