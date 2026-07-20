package no;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final dp.c c(dp.c cVar, String str) {
        dp.c cVarC = cVar.c(dp.f.k(str));
        l0.o(cVarC, "child(Name.identifier(name))");
        return cVarC;
    }

    public static final dp.c d(dp.d dVar, String str) {
        dp.c cVarL = dVar.c(dp.f.k(str)).l();
        l0.o(cVarL, "child(Name.identifier(name)).toSafe()");
        return cVarL;
    }
}
