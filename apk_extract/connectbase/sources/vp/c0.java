package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {
    @os.l
    public static final z a(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        return (z) f0Var.J0();
    }

    public static final boolean b(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        return f0Var.J0() instanceof z;
    }

    @os.l
    public static final n0 c(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof z) {
            return ((z) n1VarJ0).f17773b;
        }
        if (n1VarJ0 instanceof n0) {
            return (n0) n1VarJ0;
        }
        throw new lm.i0();
    }

    @os.l
    public static final n0 d(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof z) {
            return ((z) n1VarJ0).f17774c;
        }
        if (n1VarJ0 instanceof n0) {
            return (n0) n1VarJ0;
        }
        throw new lm.i0();
    }
}
