package pl;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import lm.a1;

/* JADX INFO: loaded from: classes2.dex */
public final class d {
    @os.l
    public static final k a(@os.l String str, @os.l Charset charset) {
        kn.l0.p(str, "text");
        kn.l0.p(charset, "charset");
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        kn.l0.o(charsetEncoderNewEncoder, "charset.newEncoder()");
        return b(rl.a.j(charsetEncoderNewEncoder, str, 0, str.length()));
    }

    @os.l
    public static final k b(@os.l byte[] bArr) {
        kn.l0.p(bArr, t2.a.f15437d);
        return e.f(bArr, 0, bArr.length);
    }

    @os.l
    public static final k c(@os.l byte[] bArr, int i10) {
        kn.l0.p(bArr, t2.a.f15437d);
        return e.f(bArr, i10, bArr.length);
    }

    public static /* synthetic */ k d(String str, Charset charset, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            charset = jq.f.f8800b;
        }
        return a(str, charset);
    }

    @os.l
    public static final k e() {
        return k.f13204a.a();
    }

    @lm.k(level = lm.m.ERROR, message = "Use ByteReadChannel.Empty instead", replaceWith = @a1(expression = "ByteReadChannel.Empty", imports = {}))
    public static /* synthetic */ void f() {
    }
}
