package ao;

import eo.e0;
import eo.h0;
import eo.t;
import eo.z0;
import ho.k0;
import ho.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import nm.z;
import vp.a1;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.n0;
import vp.o1;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final y f623a;

    static {
        h0 h0VarQ = x.q();
        l0.o(h0VarQ, "getErrorModule()");
        ho.m mVar = new ho.m(h0VarQ, k.f557e);
        eo.f fVar = eo.f.INTERFACE;
        dp.f fVarG = k.f560h.g();
        z0 z0Var = z0.f4654a;
        up.n nVar = up.f.f16364e;
        y yVar = new y(mVar, fVar, false, false, fVarG, z0Var, nVar);
        yVar.G0(e0.ABSTRACT);
        yVar.I0(t.f4633e);
        fo.g.f6167h.getClass();
        yVar.H0(nm.x.k(k0.L0(yVar, fo.g.a.f6169b, false, o1.IN_VARIANCE, dp.f.k("T"), 0, nVar)));
        yVar.E0();
        f623a = yVar;
    }

    @os.l
    public static final n0 a(@os.l f0 f0Var) {
        l0.p(f0Var, "suspendFunType");
        g.o(f0Var);
        h hVarH = zp.a.h(f0Var);
        fo.g annotations = f0Var.getAnnotations();
        f0 f0VarH = g.h(f0Var);
        List<c1> listJ = g.j(f0Var);
        ArrayList arrayList = new ArrayList(z.b0(listJ, 10));
        Iterator<T> it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(((c1) it.next()).getType());
        }
        fo.g.f6167h.getClass();
        fo.g gVar = fo.g.a.f6169b;
        a1 a1VarI = f623a.i();
        l0.o(a1VarI, "FAKE_CONTINUATION_CLASS_DESCRIPTOR.typeConstructor");
        List listF4 = nm.h0.F4(arrayList, g0.j(gVar, a1VarI, nm.x.k(zp.a.a(g.i(f0Var))), false, null, 16, null));
        n0 n0VarI = zp.a.h(f0Var).I();
        l0.o(n0VarI, "suspendFunType.builtIns.nullableAnyType");
        return g.b(hVarH, annotations, f0VarH, listF4, null, n0VarI, false, 64, null).N0(f0Var.H0());
    }
}
