package wi;

import java.io.EOFException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static final String a(a aVar, long j8) throws EOFException {
        if (j8 == 0) {
            return "";
        }
        h hVar = aVar.f10762a;
        if (hVar == null) {
            throw new IllegalStateException("Unreacheable");
        }
        if (hVar.b() < j8) {
            byte[] bArrC = o.c(aVar, (int) j8);
            return zi.a.a(bArrC, 0, bArrC.length);
        }
        int i8 = hVar.f10777b;
        String strA = zi.a.a(hVar.f10776a, i8, Math.min(hVar.f10778c, ((int) j8) + i8));
        aVar.h(j8);
        return strA;
    }

    public static final String b(k kVar) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        kVar.request(Long.MAX_VALUE);
        return a(kVar.getBuffer(), kVar.getBuffer().f10764c);
    }

    public static final String c(k kVar, long j8) {
        Intrinsics.checkNotNullParameter(kVar, "<this>");
        kVar.K(j8);
        return a(kVar.getBuffer(), j8);
    }
}
