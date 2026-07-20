package vp;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class g1 {
    @os.l
    public static final n0 a(@os.l f0 f0Var) {
        kn.l0.p(f0Var, "<this>");
        n1 n1VarJ0 = f0Var.J0();
        n0 n0Var = n1VarJ0 instanceof n0 ? (n0) n1VarJ0 : null;
        if (n0Var != null) {
            return n0Var;
        }
        throw new IllegalStateException(kn.l0.C("This is should be simple type: ", f0Var).toString());
    }

    @in.j
    @os.l
    public static final f0 b(@os.l f0 f0Var, @os.l List<? extends c1> list, @os.l fo.g gVar) {
        kn.l0.p(f0Var, "<this>");
        kn.l0.p(list, "newArguments");
        kn.l0.p(gVar, "newAnnotations");
        return e(f0Var, list, gVar, null, 4, null);
    }

    @in.j
    @os.l
    public static final f0 c(@os.l f0 f0Var, @os.l List<? extends c1> list, @os.l fo.g gVar, @os.l List<? extends c1> list2) {
        kn.l0.p(f0Var, "<this>");
        kn.l0.p(list, "newArguments");
        kn.l0.p(gVar, "newAnnotations");
        kn.l0.p(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == f0Var.F0()) && gVar == f0Var.getAnnotations()) {
            return f0Var;
        }
        n1 n1VarJ0 = f0Var.J0();
        if (n1VarJ0 instanceof z) {
            z zVar = (z) n1VarJ0;
            return g0.d(d(zVar.f17773b, list, gVar), d(zVar.f17774c, list2, gVar));
        }
        if (n1VarJ0 instanceof n0) {
            return d((n0) n1VarJ0, list, gVar);
        }
        throw new lm.i0();
    }

    @in.j
    @os.l
    public static final n0 d(@os.l n0 n0Var, @os.l List<? extends c1> list, @os.l fo.g gVar) {
        kn.l0.p(n0Var, "<this>");
        kn.l0.p(list, "newArguments");
        kn.l0.p(gVar, "newAnnotations");
        if (list.isEmpty() && gVar == n0Var.getAnnotations()) {
            return n0Var;
        }
        return list.isEmpty() ? n0Var.O0(gVar) : g0.j(gVar, n0Var.G0(), list, n0Var.H0(), null, 16, null);
    }

    public static /* synthetic */ f0 e(f0 f0Var, List list, fo.g gVar, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = f0Var.F0();
        }
        if ((i10 & 2) != 0) {
            gVar = f0Var.getAnnotations();
        }
        if ((i10 & 4) != 0) {
            list2 = list;
        }
        return c(f0Var, list, gVar, list2);
    }

    public static /* synthetic */ n0 f(n0 n0Var, List list, fo.g gVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = n0Var.F0();
        }
        if ((i10 & 2) != 0) {
            gVar = n0Var.getAnnotations();
        }
        return d(n0Var, list, gVar);
    }
}
