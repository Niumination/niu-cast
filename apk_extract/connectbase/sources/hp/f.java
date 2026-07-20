package hp;

import eo.j1;
import eo.t0;
import eo.u0;
import eo.z;
import kn.l0;
import vp.f0;
import vp.h1;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final dp.c f7484a = new dp.c("kotlin.jvm.JvmInline");

    public static final boolean a(@os.l eo.a aVar) {
        l0.p(aVar, "<this>");
        if (aVar instanceof u0) {
            t0 t0VarW = ((u0) aVar).W();
            l0.o(t0VarW, "correspondingProperty");
            if (d(t0VarW)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean b(@os.l eo.m mVar) {
        l0.p(mVar, "<this>");
        if (mVar instanceof eo.e) {
            eo.e eVar = (eo.e) mVar;
            if (eVar.isInline() || eVar.u()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        eo.h hVarD = f0Var.G0().d();
        if (hVarD == null) {
            return false;
        }
        return b(hVarD);
    }

    public static final boolean d(@os.l j1 j1Var) {
        z<n0> zVarY;
        l0.p(j1Var, "<this>");
        if (j1Var.R() == null) {
            eo.m mVarB = j1Var.b();
            dp.f fVar = null;
            eo.e eVar = mVarB instanceof eo.e ? (eo.e) mVarB : null;
            if (eVar != null && (zVarY = eVar.y()) != null) {
                fVar = zVarY.f4652a;
            }
            if (l0.g(fVar, j1Var.getName())) {
                return true;
            }
        }
        return false;
    }

    @os.m
    public static final f0 e(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        f0 f0VarF = f(f0Var);
        if (f0VarF == null) {
            return null;
        }
        return h1.f(f0Var).p(f0VarF, o1.INVARIANT);
    }

    @os.m
    public static final f0 f(@os.l f0 f0Var) {
        z<n0> zVarY;
        l0.p(f0Var, "<this>");
        eo.h hVarD = f0Var.G0().d();
        if (!(hVarD instanceof eo.e)) {
            hVarD = null;
        }
        eo.e eVar = (eo.e) hVarD;
        if (eVar == null || (zVarY = eVar.y()) == null) {
            return null;
        }
        return (n0) zVarY.f4653b;
    }
}
