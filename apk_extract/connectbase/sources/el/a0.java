package el;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
@lm.k(level = lm.m.ERROR, message = "This authentication kind is potentially vulnerable with several hash functions. Use SessionTransportTransformerMessageAuthentication instead or ensure you are using secure enough hash.")
public final class a0 implements z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final String f4499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f4500b;

    /* JADX WARN: Multi-variable type inference failed */
    public a0() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // el.z
    @os.m
    public String a(@os.l String str) {
        l0.p(str, "transportValue");
        String strO5 = jq.h0.o5(str, b0.f4502a, "");
        String strY5 = jq.h0.y5(str, b0.f4502a, null, 2, null);
        try {
            if (MessageDigest.isEqual(fl.b0.g(strO5), c(strY5))) {
                return strY5;
            }
            return null;
        } catch (NumberFormatException unused) {
        }
    }

    @Override // el.z
    @os.l
    public String b(@os.l String str) {
        l0.p(str, "transportValue");
        return str + b0.f4502a + fl.b0.f(c(str));
    }

    public final byte[] c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(this.f4500b);
        String str2 = this.f4499a;
        Charset charset = jq.f.f8800b;
        byte[] bytes = str2.getBytes(charset);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] bytes2 = str.getBytes(charset);
        l0.o(bytes2, "this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes2);
        byte[] bArrDigest = messageDigest.digest();
        l0.o(bArrDigest, "md.digest()");
        return bArrDigest;
    }

    @os.l
    public final String d() {
        return this.f4500b;
    }

    @os.l
    public final String e() {
        return this.f4499a;
    }

    public a0(@os.l String str, @os.l String str2) {
        l0.p(str, "salt");
        l0.p(str2, "algorithm");
        this.f4499a = str;
        this.f4500b = str2;
    }

    public /* synthetic */ a0(String str, String str2, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? "ktor" : str, (i10 & 2) != 0 ? "SHA-384" : str2);
    }
}
