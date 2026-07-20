package fl;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class z {
    @os.l
    public static final h0 a(@os.l String str) {
        return a0.a(str);
    }

    @os.m
    @t0
    public static final Object b(@os.l h0 h0Var, @os.l String str, @os.l Charset charset, @os.l um.d<? super byte[]> dVar) {
        return b0.a(h0Var, str, charset, dVar);
    }

    @os.m
    @t0
    public static final Object c(@os.l h0 h0Var, @os.l byte[] bArr, @os.l um.d<? super byte[]> dVar) {
        return b0.b(h0Var, bArr, dVar);
    }

    @os.l
    public static final String e() {
        return a0.c();
    }

    @t0
    @os.l
    public static final byte[] f(int i10) {
        return b0.d(i10);
    }

    @lm.k(level = lm.m.ERROR, message = "Use getDigestFunction with non-constant salt.")
    @os.l
    public static final jn.l<String, byte[]> g(@os.l String str, @os.l String str2) {
        return a0.f(str, str2);
    }

    @os.l
    public static final jn.l<String, byte[]> h(@os.l String str, @os.l jn.l<? super String, String> lVar) {
        return a0.g(str, lVar);
    }

    @os.l
    public static final String i(@os.l byte[] bArr) {
        return b0.f(bArr);
    }

    @os.l
    public static final byte[] j(@os.l String str) {
        return b0.g(str);
    }

    @os.l
    public static final byte[] k(@os.l byte[] bArr) {
        return a0.h(bArr);
    }
}
