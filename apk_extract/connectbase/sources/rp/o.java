package rp;

import eo.h0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o extends ho.z {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final up.n f14759g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@os.l dp.c cVar, @os.l up.n nVar, @os.l h0 h0Var) {
        super(h0Var, cVar);
        l0.p(cVar, "fqName");
        l0.p(nVar, "storageManager");
        l0.p(h0Var, "module");
        this.f14759g = nVar;
    }

    @os.l
    public abstract g B0();

    public boolean E0(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        op.h hVarO = o();
        return (hVarO instanceof tp.i) && ((tp.i) hVarO).s().contains(fVar);
    }

    public abstract void F0(@os.l j jVar);
}
