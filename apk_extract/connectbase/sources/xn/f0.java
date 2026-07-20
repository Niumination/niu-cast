package xn;

import ik.y0;
import kn.l0;
import vp.a1;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class f0 {
    @os.l
    public static final un.s a(@os.l un.s sVar) {
        l0.p(sVar, y0.a.f8215h);
        vp.f0 f0Var = ((v) sVar).f20427a;
        if (!(f0Var instanceof n0)) {
            throw new IllegalArgumentException(l0.C("Non-simple type cannot be a mutable collection type: ", sVar).toString());
        }
        eo.h hVarD = f0Var.G0().d();
        eo.e eVar = hVarD instanceof eo.e ? (eo.e) hVarD : null;
        if (eVar == null) {
            throw new IllegalArgumentException(l0.C("Non-class type cannot be a mutable collection type: ", sVar));
        }
        n0 n0Var = (n0) f0Var;
        a1 a1VarI = d(eVar).i();
        l0.o(a1VarI, "classifier.readOnlyToMutable().typeConstructor");
        return new v(vp.g0.k(n0Var, null, a1VarI, null, false, 26, null), null, 2, null);
    }

    @os.l
    public static final un.s b(@os.l un.s sVar) {
        l0.p(sVar, y0.a.f8215h);
        vp.f0 f0Var = ((v) sVar).f20427a;
        if (!(f0Var instanceof n0)) {
            throw new IllegalArgumentException(l0.C("Non-simple type cannot be a Nothing type: ", sVar).toString());
        }
        n0 n0Var = (n0) f0Var;
        a1 a1VarI = zp.a.h(f0Var).G().i();
        l0.o(a1VarI, "kotlinType.builtIns.nothing.typeConstructor");
        return new v(vp.g0.k(n0Var, null, a1VarI, null, false, 26, null), null, 2, null);
    }

    @os.l
    public static final un.s c(@os.l un.s sVar, @os.l un.s sVar2) {
        l0.p(sVar, "lowerBound");
        l0.p(sVar2, "upperBound");
        return new v(vp.g0.d((n0) ((v) sVar).f20427a, (n0) ((v) sVar2).f20427a), null, 2, null);
    }

    public static final eo.e d(eo.e eVar) {
        dp.c cVarQ = co.c.f1685a.q(lp.a.j(eVar));
        if (cVarQ == null) {
            throw new IllegalArgumentException(l0.C("Not a readonly collection: ", eVar));
        }
        eo.e eVarO = lp.a.g(eVar).o(cVarQ);
        l0.o(eVarO, "builtIns.getBuiltInClassByFqName(fqName)");
        return eVarO;
    }
}
