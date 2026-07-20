package jp;

import eo.h0;
import kn.l0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends g<Float> {
    public l(float f10) {
        super(Float.valueOf(f10));
    }

    @Override // jp.g
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        n0 n0VarB = h0Var.n().B();
        l0.o(n0VarB, "module.builtIns.floatType");
        return n0VarB;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.g
    @os.l
    public String toString() {
        return ((Number) this.f8774a).floatValue() + ".toFloat()";
    }
}
