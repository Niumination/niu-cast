package jp;

import eo.h0;
import kn.l0;
import vp.f0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class y extends a0<Long> {
    public y(long j10) {
        super(Long.valueOf(j10));
    }

    @Override // jp.g
    @os.l
    public f0 a(@os.l h0 h0Var) {
        l0.p(h0Var, "module");
        eo.e eVarA = eo.x.a(h0Var, ao.k.a.f616w0);
        if (eVarA == null) {
            n0 n0VarJ = vp.x.j("Unsigned type ULong not found");
            l0.o(n0VarJ, "createErrorType(\"Unsigned type ULong not found\")");
            return n0VarJ;
        }
        n0 n0VarQ = eVarA.q();
        l0.o(n0VarQ, "module.findClassAcrossMo…ed type ULong not found\")");
        return n0VarQ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jp.g
    @os.l
    public String toString() {
        return ((Number) this.f8774a).longValue() + ".toULong()";
    }
}
