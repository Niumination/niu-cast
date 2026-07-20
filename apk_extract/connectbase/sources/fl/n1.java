package fl;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes2.dex */
public final class n1 implements d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final SecretKeySpec f6070a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final String f6071b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6072c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final jn.a<String> f6073d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f6074e;

    public static final class a extends kn.n0 implements jn.a<String> {
        public static final a INSTANCE = new a();

        public a() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return a0.c();
        }
    }

    public static final class b extends kn.n0 implements jn.a<String> {
        public static final b INSTANCE = new b();

        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final String invoke() {
            return a0.c();
        }
    }

    public n1(@os.l SecretKeySpec secretKeySpec, @os.l String str, long j10, @os.l jn.a<String> aVar) throws NoSuchAlgorithmException, InvalidKeyException {
        kn.l0.p(secretKeySpec, "keySpec");
        kn.l0.p(str, "algorithm");
        kn.l0.p(aVar, "nonceGenerator");
        this.f6070a = secretKeySpec;
        this.f6071b = str;
        this.f6072c = j10;
        this.f6073d = aVar;
        Mac mac = Mac.getInstance(str);
        mac.init(secretKeySpec);
        this.f6074e = mac.getMacLength();
    }

    @Override // fl.d1
    @os.m
    public Object a(@os.l um.d<? super String> dVar) throws NoSuchAlgorithmException, InvalidKeyException {
        String strInvoke = this.f6073d.invoke();
        String string = Long.toString(System.nanoTime(), jq.d.a(16));
        kn.l0.o(string, "toString(this, checkRadix(radix))");
        String strR3 = jq.h0.R3(string, 16, '0');
        Mac mac = Mac.getInstance(this.f6071b);
        mac.init(this.f6070a);
        byte[] bytes = (strInvoke + n1.e.f11184d + strR3).getBytes(jq.f.f8805g);
        kn.l0.o(bytes, "this as java.lang.String).getBytes(charset)");
        mac.update(bytes);
        byte[] bArrDoFinal = mac.doFinal();
        kn.l0.o(bArrDoFinal, "getInstance(algorithm).a…)\n            }.doFinal()");
        return strInvoke + '+' + strR3 + '+' + b0.f(bArrDoFinal);
    }

    @Override // fl.d1
    @os.m
    public Object b(@os.l String str, @os.l um.d<? super Boolean> dVar) throws NoSuchAlgorithmException, InvalidKeyException {
        List listQ4 = jq.h0.Q4(str, new char[]{'+'}, false, 0, 6, null);
        if (listQ4.size() != 3) {
            return Boolean.FALSE;
        }
        String str2 = (String) listQ4.get(0);
        String str3 = (String) listQ4.get(1);
        String str4 = (String) listQ4.get(2);
        if (str2.length() >= 8 && str4.length() == this.f6074e * 2 && str3.length() == 16 && TimeUnit.MILLISECONDS.toNanos(this.f6072c) + Long.parseLong(str3, jq.d.a(16)) >= System.nanoTime()) {
            Mac mac = Mac.getInstance(this.f6071b);
            mac.init(this.f6070a);
            byte[] bytes = (str2 + n1.e.f11184d + str3).getBytes(jq.f.f8805g);
            kn.l0.o(bytes, "this as java.lang.String).getBytes(charset)");
            mac.update(bytes);
            byte[] bArrDoFinal = mac.doFinal();
            kn.l0.o(bArrDoFinal, "getInstance(algorithm).a…)\n            }.doFinal()");
            String strF = b0.f(bArrDoFinal);
            int iMin = Math.min(strF.length(), str4.length());
            int i10 = 0;
            int i11 = 0;
            while (i10 < iMin) {
                int i12 = i10 + 1;
                if (strF.charAt(i10) == str4.charAt(i10)) {
                    i11++;
                }
                i10 = i12;
            }
            return Boolean.valueOf(i11 == this.f6074e * 2);
        }
        return Boolean.FALSE;
    }

    @os.l
    public final String c() {
        return this.f6071b;
    }

    @os.l
    public final SecretKeySpec d() {
        return this.f6070a;
    }

    @os.l
    public final jn.a<String> e() {
        return this.f6073d;
    }

    public final long f() {
        return this.f6072c;
    }

    public /* synthetic */ n1(SecretKeySpec secretKeySpec, String str, long j10, jn.a aVar, int i10, kn.w wVar) {
        this(secretKeySpec, (i10 & 2) != 0 ? "HmacSHA256" : str, (i10 & 4) != 0 ? 60000L : j10, (jn.a<String>) ((i10 & 8) != 0 ? a.INSTANCE : aVar));
    }

    public /* synthetic */ n1(byte[] bArr, String str, long j10, jn.a aVar, int i10, kn.w wVar) {
        this(bArr, (i10 & 2) != 0 ? "HmacSHA256" : str, (i10 & 4) != 0 ? 60000L : j10, (jn.a<String>) ((i10 & 8) != 0 ? b.INSTANCE : aVar));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n1(@os.l byte[] bArr, @os.l String str, long j10, @os.l jn.a<String> aVar) {
        this(new SecretKeySpec(bArr, str), str, j10, aVar);
        kn.l0.p(bArr, cb.b.c.f1408o);
        kn.l0.p(str, "algorithm");
        kn.l0.p(aVar, "nonceGenerator");
    }
}
