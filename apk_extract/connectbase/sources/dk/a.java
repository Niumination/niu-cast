package dk;

import kn.l0;
import nq.b0;
import nq.l2;
import nq.l3;
import nq.s0;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends c implements s0 {

    @os.l
    public final e I;

    @os.l
    public final b0 J;

    @os.l
    public final um.g K;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@os.l e eVar) {
        super(eVar.h());
        l0.p(eVar, "environment");
        this.I = eVar;
        l3 l3Var = new l3((l2) eVar.g().get(l2.f11882k));
        this.J = l3Var;
        this.K = eVar.g().plus(l3Var);
    }

    public final void X() {
        l2.a.b(this.J, null, 1, null);
        i.f(this);
    }

    @os.l
    public final e Y() {
        return this.I;
    }

    @Override // nq.s0
    @os.l
    public um.g getCoroutineContext() {
        return this.K;
    }
}
