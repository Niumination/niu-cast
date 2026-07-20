package eo;

/* JADX INFO: loaded from: classes3.dex */
public final class s {
    @os.m
    public static final h a(@os.l m mVar) {
        kn.l0.p(mVar, "<this>");
        m mVarB = mVar.b();
        if (mVarB == null || (mVar instanceof k0)) {
            return null;
        }
        if (!b(mVarB)) {
            return a(mVarB);
        }
        if (mVarB instanceof h) {
            return (h) mVarB;
        }
        return null;
    }

    public static final boolean b(@os.l m mVar) {
        kn.l0.p(mVar, "<this>");
        return mVar.b() instanceof k0;
    }

    @os.m
    public static final e c(@os.l h0 h0Var, @os.l dp.c cVar, @os.l mo.b bVar) {
        h hVarF;
        kn.l0.p(h0Var, "<this>");
        kn.l0.p(cVar, "fqName");
        kn.l0.p(bVar, "lookupLocation");
        if (cVar.d()) {
            return null;
        }
        dp.c cVarE = cVar.e();
        kn.l0.o(cVarE, "fqName.parent()");
        op.h hVarO = h0Var.o0(cVarE).o();
        dp.f fVarG = cVar.g();
        kn.l0.o(fVarG, "fqName.shortName()");
        h hVarF2 = hVarO.f(fVarG, bVar);
        e eVar = hVarF2 instanceof e ? (e) hVarF2 : null;
        if (eVar != null) {
            return eVar;
        }
        dp.c cVarE2 = cVar.e();
        kn.l0.o(cVarE2, "fqName.parent()");
        e eVarC = c(h0Var, cVarE2, bVar);
        if (eVarC == null) {
            hVarF = null;
        } else {
            op.h hVarV = eVarC.V();
            dp.f fVarG2 = cVar.g();
            kn.l0.o(fVarG2, "fqName.shortName()");
            hVarF = hVarV.f(fVarG2, bVar);
        }
        if (hVarF instanceof e) {
            return (e) hVarF;
        }
        return null;
    }
}
