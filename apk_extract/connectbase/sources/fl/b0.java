package fl;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final char[] f6018a = r.b(jq.j.f8821a);

    @os.m
    @t0
    public static final Object a(@os.l h0 h0Var, @os.l String str, @os.l Charset charset, @os.l um.d<? super byte[]> dVar) {
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        h0Var.a(rl.a.j(charsetEncoderNewEncoder, str, 0, str.length()));
        return h0Var.b(dVar);
    }

    @os.m
    @t0
    public static final Object b(@os.l h0 h0Var, @os.l byte[] bArr, @os.l um.d<? super byte[]> dVar) {
        h0Var.a(bArr);
        return h0Var.b(dVar);
    }

    public static Object c(h0 h0Var, String str, Charset charset, um.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        return a(h0Var, str, charset, dVar);
    }

    @t0
    @os.l
    public static final byte[] d(int i10) {
        tl.s sVarA = tl.w0.a(0);
        while (sVarA.P0() < i10) {
            try {
                tl.d1.Y(sVarA, a0.c(), 0, 0, null, 14, null);
            } catch (Throwable th2) {
                sVarA.close();
                throw th2;
            }
        }
        return tl.d1.f(sVarA.z2(), i10);
    }

    public static /* synthetic */ void e() {
    }

    @os.l
    public static final String f(@os.l byte[] bArr) {
        kn.l0.p(bArr, "bytes");
        char[] cArr = new char[bArr.length * 2];
        char[] cArr2 = f6018a;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            int i13 = i11 + 1;
            cArr[i11] = cArr2[(b10 & 255) >> 4];
            i11 += 2;
            cArr[i13] = cArr2[b10 & c1.c.f1123q];
            i10 = i12;
        }
        return jq.e0.t1(cArr);
    }

    @os.l
    public static final byte[] g(@os.l String str) {
        kn.l0.p(str, p6.s.f13016a);
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = (byte) (Integer.parseInt(String.valueOf(str.charAt(i11 + 1)), jq.d.a(16)) | (Integer.parseInt(String.valueOf(str.charAt(i11)), jq.d.a(16)) << 4));
        }
        return bArr;
    }
}
