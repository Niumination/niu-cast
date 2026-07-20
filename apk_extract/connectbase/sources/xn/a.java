package xn;

import eo.t0;
import kn.l0;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public class a extends ho.l<f<?>, l2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j f20301a;

    public a(@os.l j jVar) {
        l0.p(jVar, "container");
        this.f20301a = jVar;
    }

    @Override // ho.l, eo.o
    @os.l
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public f<?> m(@os.l eo.y yVar, @os.l l2 l2Var) {
        l0.p(yVar, "descriptor");
        l0.p(l2Var, "data");
        return new k(this.f20301a, yVar);
    }

    @Override // ho.l, eo.o
    @os.l
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public f<?> b(@os.l t0 t0Var, @os.l l2 l2Var) {
        l0.p(t0Var, "descriptor");
        l0.p(l2Var, "data");
        int i10 = (t0Var.O() == null ? 0 : 1) + (t0Var.R() != null ? 1 : 0);
        if (t0Var.Q()) {
            if (i10 == 0) {
                return new l(this.f20301a, t0Var);
            }
            if (i10 == 1) {
                return new m(this.f20301a, t0Var);
            }
            if (i10 == 2) {
                return new n(this.f20301a, t0Var);
            }
        } else {
            if (i10 == 0) {
                return new q(this.f20301a, t0Var);
            }
            if (i10 == 1) {
                return new r(this.f20301a, t0Var);
            }
            if (i10 == 2) {
                return new s(this.f20301a, t0Var);
            }
        }
        throw new y(l0.C("Unsupported property: ", t0Var));
    }
}
