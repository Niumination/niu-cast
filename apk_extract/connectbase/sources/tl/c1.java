package tl;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class c1 {
    @os.l
    public static final String a(@os.l byte[] bArr, int i10, int i11, @os.l Charset charset) {
        kn.l0.p(bArr, "bytes");
        kn.l0.p(charset, "charset");
        return new String(bArr, i10, i11, charset);
    }

    public static /* synthetic */ String b(byte[] bArr, int i10, int i11, Charset charset, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        if ((i12 & 8) != 0) {
            charset = jq.f.f8800b;
        }
        kn.l0.p(bArr, "bytes");
        kn.l0.p(charset, "charset");
        return new String(bArr, i10, i11, charset);
    }

    public static final void c(@os.l String str, @os.l char[] cArr, int i10) {
        kn.l0.p(str, "<this>");
        kn.l0.p(cArr, "dst");
        str.getChars(0, str.length(), cArr, i10);
    }
}
