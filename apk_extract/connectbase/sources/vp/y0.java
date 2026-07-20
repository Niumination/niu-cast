package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class y0 {
    @os.m
    public static final n a(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        yp.i iVarJ0 = f0Var.J0();
        n nVar = iVarJ0 instanceof n ? (n) iVarJ0 : null;
        if (nVar != null && nVar.B()) {
            return nVar;
        }
        return null;
    }

    public static final boolean b(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        yp.i iVarJ0 = f0Var.J0();
        n nVar = iVarJ0 instanceof n ? (n) iVarJ0 : null;
        if (nVar == null) {
            return false;
        }
        return nVar.B();
    }
}
