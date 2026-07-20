package rp;

import eo.k0;
import eo.l0;
import eo.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final l0 f14758a;

    public n(@os.l l0 l0Var) {
        kn.l0.p(l0Var, "packageFragmentProvider");
        this.f14758a = l0Var;
    }

    @Override // rp.g
    @os.m
    public f a(@os.l dp.b bVar) {
        f fVarA;
        kn.l0.p(bVar, "classId");
        l0 l0Var = this.f14758a;
        dp.c cVarH = bVar.h();
        kn.l0.o(cVarH, "classId.packageFqName");
        for (k0 k0Var : n0.c(l0Var, cVarH)) {
            if ((k0Var instanceof o) && (fVarA = ((o) k0Var).B0().a(bVar)) != null) {
                return fVarA;
            }
        }
        return null;
    }
}
