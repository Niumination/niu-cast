package jp;

import eo.h0;
import kn.l0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class r extends o<Long> {
    public r(long j10) {
        super(Long.valueOf(j10));
    }

    @Override // jp.g
    @os.l
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        n0 n0VarF = h0Var.n().F();
        l0.o(n0VarF, "module.builtIns.longType");
        return n0VarF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.g
    @os.l
    public String toString() {
        return ((Number) this.f8774a).longValue() + ".toLong()";
    }
}
