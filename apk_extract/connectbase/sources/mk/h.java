package mk;

import java.nio.charset.CharsetDecoder;
import java.util.Arrays;
import kn.l0;
import tl.m0;
import tl.s0;
import tl.w0;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    @os.l
    public static final byte[] a(@os.l g gVar) {
        l0.p(gVar, "<this>");
        byte[] bArr = gVar.f10770c;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        l0.o(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    @os.m
    public static final a b(@os.l g.b bVar) {
        l0.p(bVar, "<this>");
        if (bVar.f10770c.length < 2) {
            return null;
        }
        tl.s sVarA = w0.a(0);
        try {
            s0.r(sVarA, bVar.f10770c, 0, 0, 6, null);
            tl.v vVarZ2 = sVarA.z2();
            return new a(m0.k(vVarZ2), tl.a.v2(vVarZ2, 0, 0, 3, null));
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }

    @os.l
    public static final String c(@os.l g.f fVar) {
        l0.p(fVar, "<this>");
        if (!fVar.f10768a) {
            throw new IllegalArgumentException("Text could be only extracted from non-fragmented frame");
        }
        CharsetDecoder charsetDecoderNewDecoder = jq.f.f8800b.newDecoder();
        l0.o(charsetDecoderNewDecoder, "UTF_8.newDecoder()");
        tl.s sVarA = w0.a(0);
        try {
            s0.r(sVarA, fVar.f10770c, 0, 0, 6, null);
            return rl.b.b(charsetDecoderNewDecoder, sVarA.z2(), 0, 2, null);
        } catch (Throwable th2) {
            sVarA.close();
            throw th2;
        }
    }
}
