package en;

import io.netty.handler.codec.rtsp.RtspHeaders;
import java.nio.charset.Charset;
import kn.l0;
import lm.f1;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    @f
    @f1(version = "1.8")
    @an.f
    public static final byte[] a(a aVar, CharSequence charSequence, int i10, int i11) {
        l0.p(aVar, "<this>");
        l0.p(charSequence, "source");
        if (!(charSequence instanceof String)) {
            return aVar.e(charSequence, i10, i11);
        }
        aVar.g(((String) charSequence).length(), i10, i11);
        String strSubstring = ((String) charSequence).substring(i10, i11);
        l0.o(strSubstring, "substring(...)");
        Charset charset = jq.f.f8805g;
        l0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = strSubstring.getBytes(charset);
        l0.o(bytes, "getBytes(...)");
        return bytes;
    }

    @f
    @f1(version = "1.8")
    @an.f
    public static final int b(a aVar, byte[] bArr, byte[] bArr2, int i10, int i11, int i12) {
        l0.p(aVar, "<this>");
        l0.p(bArr, "source");
        l0.p(bArr2, RtspHeaders.Values.DESTINATION);
        return aVar.v(bArr, bArr2, i10, i11, i12);
    }

    @f
    @f1(version = "1.8")
    @an.f
    public static final byte[] c(a aVar, byte[] bArr, int i10, int i11) {
        l0.p(aVar, "<this>");
        l0.p(bArr, "source");
        return aVar.B(bArr, i10, i11);
    }

    @f
    @f1(version = "1.8")
    @an.f
    public static final String d(a aVar, byte[] bArr, int i10, int i11) {
        l0.p(aVar, "<this>");
        l0.p(bArr, "source");
        return new String(aVar.B(bArr, i10, i11), jq.f.f8805g);
    }
}
