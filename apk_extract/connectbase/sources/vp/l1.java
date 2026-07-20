package vp;

/* JADX INFO: loaded from: classes3.dex */
public final class l1 {
    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    public static final f0 a(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        if (f0Var instanceof k1) {
            return ((k1) f0Var).f0();
        }
        return null;
    }

    @os.l
    public static final n1 b(@os.l n1 n1Var, @os.l f0 f0Var) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(f0Var, n1.d.a.f11176d);
        return e(n1Var, a(f0Var));
    }

    @os.l
    public static final n1 c(@os.l n1 n1Var, @os.l f0 f0Var, @os.l jn.l<? super f0, ? extends f0> lVar) {
        kn.l0.p(n1Var, "<this>");
        kn.l0.p(f0Var, n1.d.a.f11176d);
        kn.l0.p(lVar, "transform");
        f0 f0VarA = a(f0Var);
        return e(n1Var, f0VarA == null ? null : lVar.invoke(f0VarA));
    }

    @os.l
    public static final f0 d(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        f0 f0VarA = a(f0Var);
        return f0VarA == null ? f0Var : f0VarA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public static final n1 e(@os.l n1 n1Var, @os.m f0 f0Var) {
        kn.l0.p(n1Var, "<this>");
        if (n1Var instanceof k1) {
            return e(((k1) n1Var).B0(), f0Var);
        }
        if (f0Var == null || kn.l0.g(f0Var, n1Var)) {
            return n1Var;
        }
        if (n1Var instanceof n0) {
            return new p0((n0) n1Var, f0Var);
        }
        if (n1Var instanceof z) {
            return new b0((z) n1Var, f0Var);
        }
        throw new lm.i0();
    }
}
