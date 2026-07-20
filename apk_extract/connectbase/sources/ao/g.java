package ao;

import java.util.ArrayList;
import java.util.List;
import jp.v;
import kn.l0;
import lm.t0;
import nm.d1;
import nm.h0;
import nm.y;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    @in.j
    @os.l
    public static final n0 a(@os.l h hVar, @os.l fo.g gVar, @os.m f0 f0Var, @os.l List<? extends f0> list, @os.m List<dp.f> list2, @os.l f0 f0Var2, boolean z10) {
        l0.p(hVar, "builtIns");
        l0.p(gVar, "annotations");
        l0.p(list, "parameterTypes");
        l0.p(f0Var2, "returnType");
        List<c1> listE = e(f0Var, list, list2, f0Var2, hVar);
        int size = list.size();
        if (f0Var != null) {
            size++;
        }
        eo.e eVarD = d(hVar, size, z10);
        if (f0Var != null) {
            gVar = q(gVar, hVar);
        }
        return g0.g(gVar, eVarD, listE);
    }

    public static /* synthetic */ n0 b(h hVar, fo.g gVar, f0 f0Var, List list, List list2, f0 f0Var2, boolean z10, int i10, Object obj) {
        if ((i10 & 64) != 0) {
            z10 = false;
        }
        return a(hVar, gVar, f0Var, list, list2, f0Var2, z10);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x002b  */
    /* JADX WARN: Multi-variable type inference failed */
    @os.m
    public static final dp.f c(@os.l f0 f0Var) {
        String str;
        l0.p(f0Var, "<this>");
        fo.c cVarD = f0Var.getAnnotations().d(k.a.D);
        if (cVarD == null) {
            return null;
        }
        Object objI5 = h0.i5(cVarD.a().values());
        v vVar = objI5 instanceof v ? (v) objI5 : null;
        if (vVar == null) {
            str = null;
        } else {
            str = (String) vVar.f8774a;
            if (!dp.f.m(str)) {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        return dp.f.k(str);
    }

    @os.l
    public static final eo.e d(@os.l h hVar, int i10, boolean z10) {
        l0.p(hVar, "builtIns");
        eo.e eVarX = z10 ? hVar.X(i10) : hVar.C(i10);
        l0.o(eVarX, "if (isSuspendFunction) b…tFunction(parameterCount)");
        return eVarX;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0048  */
    @os.l
    public static final List<c1> e(@os.m f0 f0Var, @os.l List<? extends f0> list, @os.m List<dp.f> list2, @os.l f0 f0Var2, @os.l h hVar) {
        dp.f fVar;
        l0.p(list, "parameterTypes");
        l0.p(f0Var2, "returnType");
        l0.p(hVar, "builtIns");
        int i10 = 0;
        ArrayList arrayList = new ArrayList(list.size() + (f0Var != null ? 1 : 0) + 1);
        eq.a.a(arrayList, f0Var == null ? null : zp.a.a(f0Var));
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                y.Z();
            }
            f0 f0VarR = (f0) obj;
            if (list2 == null) {
                fVar = null;
            } else {
                fVar = list2.get(i10);
                if (fVar.f3821b) {
                    fVar = null;
                }
            }
            if (fVar != null) {
                dp.c cVar = k.a.D;
                dp.f fVarK = dp.f.k("name");
                String strB = fVar.b();
                l0.o(strB, "name.asString()");
                f0VarR = zp.a.r(f0VarR, fo.g.f6167h.a(h0.B4(f0VarR.getAnnotations(), new fo.j(hVar, cVar, nm.c1.k(new t0(fVarK, new v(strB)))))));
            }
            arrayList.add(zp.a.a(f0VarR));
            i10 = i11;
        }
        arrayList.add(zp.a.a(f0Var2));
        return arrayList;
    }

    public static final bo.c f(dp.d dVar) {
        if (!dVar.f() || dVar.f3815a.isEmpty()) {
            return null;
        }
        bo.c.a aVar = bo.c.Companion;
        String strB = dVar.i().b();
        l0.o(strB, "shortName().asString()");
        dp.c cVarE = dVar.l().e();
        l0.o(cVarE, "toSafe().parent()");
        return aVar.b(strB, cVarE);
    }

    @os.m
    public static final bo.c g(@os.l eo.m mVar) {
        l0.p(mVar, "<this>");
        if ((mVar instanceof eo.e) && h.z0(mVar)) {
            return f(lp.a.j(mVar));
        }
        return null;
    }

    @os.m
    public static final f0 h(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        m(f0Var);
        if (p(f0Var)) {
            return ((c1) h0.B2(f0Var.F0())).getType();
        }
        return null;
    }

    @os.l
    public static final f0 i(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        m(f0Var);
        f0 type = ((c1) h0.p3(f0Var.F0())).getType();
        l0.o(type, "arguments.last().type");
        return type;
    }

    @os.l
    public static final List<c1> j(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        m(f0Var);
        List<c1> listF0 = f0Var.F0();
        return listF0.subList(k(f0Var) ? 1 : 0, listF0.size() - 1);
    }

    public static final boolean k(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        return m(f0Var) && p(f0Var);
    }

    public static final boolean l(@os.l eo.m mVar) {
        l0.p(mVar, "<this>");
        bo.c cVarG = g(mVar);
        return cVarG == bo.c.Function || cVarG == bo.c.SuspendFunction;
    }

    public static final boolean m(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        eo.h hVarD = f0Var.G0().d();
        return hVarD != null && l(hVarD);
    }

    public static final boolean n(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        eo.h hVarD = f0Var.G0().d();
        return (hVarD == null ? null : g(hVarD)) == bo.c.Function;
    }

    public static final boolean o(@os.l f0 f0Var) {
        l0.p(f0Var, "<this>");
        eo.h hVarD = f0Var.G0().d();
        return (hVarD == null ? null : g(hVarD)) == bo.c.SuspendFunction;
    }

    public static final boolean p(f0 f0Var) {
        return f0Var.getAnnotations().d(k.a.C) != null;
    }

    @os.l
    public static final fo.g q(@os.l fo.g gVar, @os.l h hVar) {
        l0.p(gVar, "<this>");
        l0.p(hVar, "builtIns");
        dp.c cVar = k.a.C;
        return gVar.p(cVar) ? gVar : fo.g.f6167h.a(h0.B4(gVar, new fo.j(hVar, cVar, d1.z())));
    }
}
