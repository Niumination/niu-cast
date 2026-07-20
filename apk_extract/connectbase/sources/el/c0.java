package el;

import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kn.l0;
import kn.l1;
import kn.n0;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements z {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public static final c f4508g = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ps.a f4509h = ps.b.j(l1.d(c0.class).v());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final SecretKeySpec f4510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final SecretKeySpec f4511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final jn.l<Integer, byte[]> f4512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final String f4513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final String f4514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final Charset f4515f;

    public static final class a extends n0 implements jn.l<Integer, byte[]> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ byte[] invoke(Integer num) {
            return invoke(num.intValue());
        }

        @os.l
        public final byte[] invoke(int i10) {
            byte[] bArr = new byte[i10];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
    }

    public static final class b extends n0 implements jn.l<Integer, byte[]> {
        public static final b INSTANCE = new b();

        public b() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ byte[] invoke(Integer num) {
            return invoke(num.intValue());
        }

        @os.l
        public final byte[] invoke(int i10) {
            byte[] bArr = new byte[i10];
            new SecureRandom().nextBytes(bArr);
            return bArr;
        }
    }

    public static final class c {
        public c() {
        }

        public c(kn.w wVar) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@os.l SecretKeySpec secretKeySpec, @os.l SecretKeySpec secretKeySpec2, @os.l jn.l<? super Integer, byte[]> lVar, @os.l String str, @os.l String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        l0.p(secretKeySpec, "encryptionKeySpec");
        l0.p(secretKeySpec2, "signKeySpec");
        l0.p(lVar, "ivGenerator");
        l0.p(str, "encryptAlgorithm");
        l0.p(str2, "signAlgorithm");
        this.f4510a = secretKeySpec;
        this.f4511b = secretKeySpec2;
        this.f4512c = lVar;
        this.f4513d = str;
        this.f4514e = str2;
        this.f4515f = jq.f.f8800b;
        e(1, (byte[]) lVar.invoke(Integer.valueOf(g())), new byte[0]);
        l(new byte[0]);
    }

    @Override // el.z
    @os.m
    public String a(@os.l String str) {
        l0.p(str, "transportValue");
        try {
            String strO5 = jq.h0.o5(str, b0.f4502a, "");
            byte[] bArrG = fl.b0.g(jq.h0.y5(str, b0.f4502a, null, 2, null));
            byte[] bArrG2 = fl.b0.g(jq.h0.y5(strO5, n1.e.f11184d, null, 2, null));
            String strO6 = jq.h0.o5(strO5, n1.e.f11184d, "");
            byte[] bArrE = e(2, bArrG, bArrG2);
            if (l0.g(fl.b0.f(l(bArrE)), strO6)) {
                return new String(bArrE, this.f4515f);
            }
            return null;
        } catch (Throwable th2) {
            ps.a aVar = f4509h;
            if (aVar.isDebugEnabled()) {
                aVar.debug(th2.toString());
            }
            return null;
        }
    }

    @Override // el.z
    @os.l
    public String b(@os.l String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        l0.p(str, "transportValue");
        byte[] bArrInvoke = this.f4512c.invoke(Integer.valueOf(g()));
        byte[] bytes = str.getBytes(this.f4515f);
        l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        return fl.b0.f(bArrInvoke) + b0.f4502a + fl.b0.f(e(1, bArrInvoke, bytes)) + n1.e.f11184d + fl.b0.f(l(bytes));
    }

    public final byte[] c(byte[] bArr, byte[] bArr2) {
        return e(2, bArr, bArr2);
    }

    public final byte[] d(byte[] bArr, byte[] bArr2) {
        return e(1, bArr, bArr2);
    }

    public final byte[] e(int i10, byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
        Cipher cipher = Cipher.getInstance(l0.C(this.f4513d, "/CBC/PKCS5PADDING"));
        cipher.init(i10, this.f4510a, ivParameterSpec);
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        l0.o(bArrDoFinal, "cipher.doFinal(input)");
        return bArrDoFinal;
    }

    @os.l
    public final String f() {
        return this.f4513d;
    }

    public final int g() {
        return this.f4510a.getEncoded().length;
    }

    @os.l
    public final SecretKeySpec h() {
        return this.f4510a;
    }

    @os.l
    public final jn.l<Integer, byte[]> i() {
        return this.f4512c;
    }

    @os.l
    public final String j() {
        return this.f4514e;
    }

    @os.l
    public final SecretKeySpec k() {
        return this.f4511b;
    }

    public final byte[] l(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(this.f4514e);
        mac.init(this.f4511b);
        byte[] bArrDoFinal = mac.doFinal(bArr);
        l0.o(bArrDoFinal, "getInstance(signAlgorith…     doFinal(value)\n    }");
        return bArrDoFinal;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ c0(SecretKeySpec secretKeySpec, SecretKeySpec secretKeySpec2, jn.l lVar, String str, String str2, int i10, kn.w wVar) {
        jn.l lVar2 = (i10 & 4) != 0 ? a.INSTANCE : lVar;
        if ((i10 & 8) != 0) {
            str = secretKeySpec.getAlgorithm();
            l0.o(str, "class SessionTransportTr…   doFinal(value)\n    }\n}");
        }
        String str3 = str;
        if ((i10 & 16) != 0) {
            str2 = secretKeySpec2.getAlgorithm();
            l0.o(str2, "class SessionTransportTr…   doFinal(value)\n    }\n}");
        }
        this(secretKeySpec, secretKeySpec2, (jn.l<? super Integer, byte[]>) lVar2, str3, str2);
    }

    public /* synthetic */ c0(byte[] bArr, byte[] bArr2, jn.l lVar, String str, String str2, int i10, kn.w wVar) {
        this(bArr, bArr2, (jn.l<? super Integer, byte[]>) ((i10 & 4) != 0 ? b.INSTANCE : lVar), (i10 & 8) != 0 ? "AES" : str, (i10 & 16) != 0 ? "HmacSHA256" : str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c0(@os.l byte[] bArr, @os.l byte[] bArr2, @os.l jn.l<? super Integer, byte[]> lVar, @os.l String str, @os.l String str2) {
        this(new SecretKeySpec(bArr, str), new SecretKeySpec(bArr2, str2), lVar, (String) null, (String) null, 24, (kn.w) null);
        l0.p(bArr, "encryptionKey");
        l0.p(bArr2, "signKey");
        l0.p(lVar, "ivGenerator");
        l0.p(str, "encryptAlgorithm");
        l0.p(str2, "signAlgorithm");
    }
}
