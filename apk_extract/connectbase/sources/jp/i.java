package jp;

import eo.h0;
import kn.l0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class i extends g<Double> {
    public i(double d10) {
        super(Double.valueOf(d10));
    }

    @Override // jp.g
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        n0 n0VarZ = h0Var.n().z();
        l0.o(n0VarZ, "module.builtIns.doubleType");
        return n0VarZ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.g
    @os.l
    public String toString() {
        return ((Number) this.f8774a).doubleValue() + ".toDouble()";
    }
}
