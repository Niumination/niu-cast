package co;

import eo.e0;
import eo.t;
import eo.w0;
import eo.y;
import eo.z0;
import ho.g0;
import java.util.List;
import kn.l0;
import kn.w;
import nm.k0;
import nm.x;
import os.l;
import up.n;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends op.e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final C0072a f1681e = new C0072a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final dp.f f1682f;

    /* JADX INFO: renamed from: co.a$a, reason: collision with other inner class name */
    public static final class C0072a {
        public C0072a() {
        }

        @l
        public final dp.f a() {
            return a.f1682f;
        }

        public C0072a(w wVar) {
        }
    }

    static {
        dp.f fVarK = dp.f.k("clone");
        l0.o(fVarK, "identifier(\"clone\")");
        f1682f = fVarK;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@l n nVar, @l eo.e eVar) {
        super(nVar, eVar);
        l0.p(nVar, "storageManager");
        l0.p(eVar, "containingClass");
    }

    @Override // op.e
    @l
    public List<y> j() {
        eo.e eVar = this.f12397b;
        fo.g.f6167h.getClass();
        g0 g0VarF1 = g0.f1(eVar, fo.g.a.f6169b, f1682f, eo.b.a.DECLARATION, z0.f4654a);
        w0 w0VarD0 = this.f12397b.D0();
        k0 k0Var = k0.INSTANCE;
        g0VarF1.L0(null, w0VarD0, k0Var, k0Var, lp.a.g(this.f12397b).i(), e0.OPEN, t.f4631c);
        return x.k(g0VarF1);
    }
}
