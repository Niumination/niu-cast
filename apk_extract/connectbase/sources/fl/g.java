package fl;

/* JADX INFO: loaded from: classes2.dex */
public final class g {
    @t0
    @lm.k(level = lm.m.ERROR, message = "USe decodeBase64Bytes instead", replaceWith = @lm.a1(expression = "encodedString.decodeBase64Bytes()", imports = {}))
    @os.l
    public static final byte[] a(@os.l String str) {
        kn.l0.p(str, "encodedString");
        return h.e(str);
    }

    @t0
    @lm.k(level = lm.m.ERROR, message = "Use encodeBase64 extension instead", replaceWith = @lm.a1(expression = "bytes.encodeBase64()", imports = {}))
    @os.l
    public static final String b(@os.l byte[] bArr) {
        kn.l0.p(bArr, "bytes");
        return h.i(bArr);
    }
}
