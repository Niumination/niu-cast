package no;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class d0 {
    @os.l
    public static final List<dp.f> a(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        String strB = fVar.b();
        l0.o(strB, "name.asString()");
        if (y.c(strB)) {
            return nm.y.P(b(fVar));
        }
        return y.d(strB) ? f(fVar) : g.f11737a.b(fVar);
    }

    @os.m
    public static final dp.f b(@os.l dp.f fVar) {
        l0.p(fVar, "methodName");
        dp.f fVarE = e(fVar, "get", false, null, 12, null);
        return fVarE == null ? e(fVar, "is", false, null, 8, null) : fVarE;
    }

    @os.m
    public static final dp.f c(@os.l dp.f fVar, boolean z10) {
        l0.p(fVar, "methodName");
        return e(fVar, "set", false, z10 ? "is" : null, 4, null);
    }

    public static final dp.f d(dp.f fVar, String str, boolean z10, String str2) {
        if (fVar.f3821b) {
            return null;
        }
        String strF = fVar.f();
        l0.o(strF, "methodName.identifier");
        if (!jq.e0.s2(strF, str, false, 2, null) || strF.length() == str.length()) {
            return null;
        }
        char cCharAt = strF.charAt(str.length());
        if ('a' <= cCharAt && cCharAt < '{') {
            return null;
        }
        if (str2 != null) {
            return dp.f.k(l0.C(str2, jq.h0.a4(strF, str)));
        }
        if (!z10) {
            return fVar;
        }
        String strC = cq.a.c(jq.h0.a4(strF, str), true);
        if (dp.f.m(strC)) {
            return dp.f.k(strC);
        }
        return null;
    }

    public static /* synthetic */ dp.f e(dp.f fVar, String str, boolean z10, String str2, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        if ((i10 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z10, str2);
    }

    @os.l
    public static final List<dp.f> f(@os.l dp.f fVar) {
        l0.p(fVar, "methodName");
        return nm.y.Q(c(fVar, false), c(fVar, true));
    }
}
