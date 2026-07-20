package no;

import eo.h1;
import java.util.List;
import kn.l0;
import lm.t0;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements hp.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a f11775a = new a();

    public static final class a {
        public a() {
        }

        public final boolean a(@os.l eo.a aVar, @os.l eo.a aVar2) {
            l0.p(aVar, "superDescriptor");
            l0.p(aVar2, "subDescriptor");
            if ((aVar2 instanceof po.e) && (aVar instanceof eo.y)) {
                po.e eVar = (po.e) aVar2;
                eVar.h().size();
                eo.y yVar = (eo.y) aVar;
                yVar.h().size();
                List<h1> listH = eVar.a().h();
                l0.o(listH, "subDescriptor.original.valueParameters");
                List<h1> listH2 = yVar.a().h();
                l0.o(listH2, "superDescriptor.original.valueParameters");
                for (t0 t0Var : nm.h0.i6(listH, listH2)) {
                    h1 h1Var = (h1) t0Var.component1();
                    h1 h1Var2 = (h1) t0Var.component2();
                    l0.o(h1Var, "subParameter");
                    boolean z10 = c((eo.y) aVar2, h1Var) instanceof wo.k.d;
                    l0.o(h1Var2, "superParameter");
                    if (z10 != (c(yVar, h1Var2) instanceof wo.k.d)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean b(eo.y yVar) {
            if (yVar.h().size() != 1) {
                return false;
            }
            eo.m mVarB = yVar.b();
            eo.e eVar = mVarB instanceof eo.e ? (eo.e) mVarB : null;
            if (eVar == null) {
                return false;
            }
            List<h1> listH = yVar.h();
            l0.o(listH, "f.valueParameters");
            eo.h hVarD = ((h1) nm.h0.h5(listH)).getType().G0().d();
            eo.e eVar2 = hVarD instanceof eo.e ? (eo.e) hVarD : null;
            return eVar2 != null && ao.h.p0(eVar) && l0.g(lp.a.i(eVar), lp.a.i(eVar2));
        }

        public final wo.k c(eo.y yVar, h1 h1Var) {
            if (wo.u.e(yVar) || b(yVar)) {
                vp.f0 type = h1Var.getType();
                l0.o(type, "valueParameterDescriptor.type");
                return wo.u.g(zp.a.q(type));
            }
            vp.f0 type2 = h1Var.getType();
            l0.o(type2, "valueParameterDescriptor.type");
            return wo.u.g(type2);
        }

        public a(kn.w wVar) {
        }
    }

    @Override // hp.e
    @os.l
    public hp.e.a a() {
        return hp.e.a.CONFLICTS_ONLY;
    }

    @Override // hp.e
    @os.l
    public hp.e.b b(@os.l eo.a aVar, @os.l eo.a aVar2, @os.m eo.e eVar) {
        l0.p(aVar, "superDescriptor");
        l0.p(aVar2, "subDescriptor");
        if (!c(aVar, aVar2, eVar) && !f11775a.a(aVar, aVar2)) {
            return hp.e.b.UNKNOWN;
        }
        return hp.e.b.INCOMPATIBLE;
    }

    public final boolean c(eo.a aVar, eo.a aVar2, eo.e eVar) {
        if ((aVar instanceof eo.b) && (aVar2 instanceof eo.y) && !ao.h.e0(aVar2)) {
            f fVar = f.f11736n;
            eo.y yVar = (eo.y) aVar2;
            dp.f name = yVar.getName();
            l0.o(name, "subDescriptor.name");
            if (!fVar.l(name)) {
                g0.a aVar3 = g0.f11742a;
                dp.f name2 = yVar.getName();
                l0.o(name2, "subDescriptor.name");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            eo.b bVarE = f0.e((eo.b) aVar);
            boolean zY0 = yVar.y0();
            boolean z10 = aVar instanceof eo.y;
            eo.y yVar2 = z10 ? (eo.y) aVar : null;
            if (!(yVar2 != null && zY0 == yVar2.y0()) && (bVarE == null || !yVar.y0())) {
                return true;
            }
            if ((eVar instanceof po.c) && yVar.q0() == null && bVarE != null && !f0.f(eVar, bVarE)) {
                if ((bVarE instanceof eo.y) && z10 && f.k((eo.y) bVarE) != null) {
                    String strC = wo.u.c(yVar, false, false, 2, null);
                    eo.y yVarA = ((eo.y) aVar).a();
                    l0.o(yVarA, "superDescriptor.original");
                    if (l0.g(strC, wo.u.c(yVarA, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
