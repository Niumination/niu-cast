package aq;

import ao.h;
import gp.f;
import ik.y0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jn.l;
import kn.l0;
import kn.n0;
import lm.i0;
import lm.l2;
import lm.t0;
import nm.h0;
import nm.z;
import os.m;
import vp.a1;
import vp.b1;
import vp.c0;
import vp.c1;
import vp.e1;
import vp.f0;
import vp.g0;
import vp.g1;
import vp.h1;
import vp.j1;
import vp.l1;
import vp.n1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f677a;

        static {
            int[] iArr = new int[o1.values().length];
            iArr[o1.INVARIANT.ordinal()] = 1;
            iArr[o1.IN_VARIANCE.ordinal()] = 2;
            iArr[o1.OUT_VARIANCE.ordinal()] = 3;
            f677a = iArr;
        }
    }

    /* JADX INFO: renamed from: aq.b$b, reason: collision with other inner class name */
    public static final class C0020b extends n0 implements l<n1, Boolean> {
        public static final C0020b INSTANCE = new C0020b();

        public C0020b() {
            super(1);
        }

        @Override // jn.l
        public final Boolean invoke(n1 n1Var) {
            l0.o(n1Var, "it");
            return Boolean.valueOf(ip.d.d(n1Var));
        }
    }

    public static final class c extends b1 {
        @Override // vp.b1
        @m
        public c1 k(@os.l a1 a1Var) {
            l0.p(a1Var, cb.b.c.f1408o);
            ip.b bVar = a1Var instanceof ip.b ? (ip.b) a1Var : null;
            if (bVar == null) {
                return null;
            }
            return bVar.c().a() ? new e1(o1.OUT_VARIANCE, bVar.c().getType()) : bVar.c();
        }
    }

    public static final class d extends n0 implements l<f, l2> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(f fVar) {
            invoke2(fVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l f fVar) {
            l0.p(fVar, "$this$withOptions");
            fVar.d(gp.b.a.f6758a);
        }
    }

    @os.l
    public static final aq.a<f0> a(@os.l f0 f0Var) {
        Object objE;
        l0.p(f0Var, y0.a.f8215h);
        if (c0.b(f0Var)) {
            aq.a<f0> aVarA = a(c0.c(f0Var));
            aq.a<f0> aVarA2 = a(c0.d(f0Var));
            return new aq.a<>(l1.b(g0.d(c0.c(aVarA.f675a), c0.d(aVarA2.f675a)), f0Var), l1.b(g0.d(c0.c(aVarA.f676b), c0.d(aVarA2.f676b)), f0Var));
        }
        a1 a1VarG0 = f0Var.G0();
        if (ip.d.d(f0Var)) {
            c1 c1VarC = ((ip.b) a1VarG0).c();
            f0 type = c1VarC.getType();
            l0.o(type, "typeProjection.type");
            f0 f0VarB = b(type, f0Var);
            int i10 = a.f677a[c1VarC.c().ordinal()];
            if (i10 == 2) {
                vp.n0 n0VarI = zp.a.h(f0Var).I();
                l0.o(n0VarI, "type.builtIns.nullableAnyType");
                return new aq.a<>(f0VarB, n0VarI);
            }
            if (i10 != 3) {
                throw new AssertionError(l0.C("Only nontrivial projections should have been captured, not: ", c1VarC));
            }
            vp.n0 n0VarH = zp.a.h(f0Var).H();
            l0.o(n0VarH, "type.builtIns.nothingType");
            return new aq.a<>(b(n0VarH, f0Var), f0VarB);
        }
        if (f0Var.F0().isEmpty() || f0Var.F0().size() != a1VarG0.getParameters().size()) {
            return new aq.a<>(f0Var, f0Var);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List<c1> listF0 = f0Var.F0();
        List<eo.e1> parameters = a1VarG0.getParameters();
        l0.o(parameters, "typeConstructor.parameters");
        for (t0 t0Var : h0.i6(listF0, parameters)) {
            c1 c1Var = (c1) t0Var.component1();
            eo.e1 e1Var = (eo.e1) t0Var.component2();
            l0.o(e1Var, "typeParameter");
            aq.c cVarG = g(c1Var, e1Var);
            if (c1Var.a()) {
                arrayList.add(cVarG);
                arrayList2.add(cVarG);
            } else {
                aq.a<aq.c> aVarD = d(cVarG);
                aq.c cVar = aVarD.f675a;
                aq.c cVar2 = aVarD.f676b;
                arrayList.add(cVar);
                arrayList2.add(cVar2);
            }
        }
        boolean z10 = false;
        if (!arrayList.isEmpty()) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (!((aq.c) it.next()).d()) {
                    z10 = true;
                    break;
                }
            }
        }
        if (z10) {
            objE = zp.a.h(f0Var).H();
            l0.o(objE, "type.builtIns.nothingType");
        } else {
            objE = e(f0Var, arrayList);
        }
        return new aq.a<>(objE, e(f0Var, arrayList2));
    }

    public static final f0 b(f0 f0Var, f0 f0Var2) {
        f0 f0VarR = j1.r(f0Var, f0Var2.H0());
        l0.o(f0VarR, "makeNullableIfNeeded(this, type.isMarkedNullable)");
        return f0VarR;
    }

    @m
    public static final c1 c(@m c1 c1Var, boolean z10) {
        if (c1Var == null) {
            return null;
        }
        if (c1Var.a()) {
            return c1Var;
        }
        f0 type = c1Var.getType();
        l0.o(type, "typeProjection.type");
        if (!j1.c(type, C0020b.INSTANCE)) {
            return c1Var;
        }
        o1 o1VarC = c1Var.c();
        l0.o(o1VarC, "typeProjection.projectionKind");
        if (o1VarC == o1.OUT_VARIANCE) {
            return new e1(o1VarC, a(type).f676b);
        }
        return z10 ? new e1(o1VarC, a(type).f675a) : f(c1Var);
    }

    public static final aq.a<aq.c> d(aq.c cVar) {
        aq.a<f0> aVarA = a(cVar.f679b);
        f0 f0Var = aVarA.f675a;
        f0 f0Var2 = aVarA.f676b;
        aq.a<f0> aVarA2 = a(cVar.f680c);
        return new aq.a<>(new aq.c(cVar.f678a, f0Var2, aVarA2.f675a), new aq.c(cVar.f678a, f0Var, aVarA2.f676b));
    }

    public static final f0 e(f0 f0Var, List<aq.c> list) {
        f0Var.F0().size();
        list.size();
        List<aq.c> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(h((aq.c) it.next()));
        }
        return g1.e(f0Var, arrayList, null, null, 6, null);
    }

    public static final c1 f(c1 c1Var) {
        h1 h1VarG = h1.g(new c());
        l0.o(h1VarG, "create(object : TypeCons…ojection\n        }\n    })");
        return h1VarG.t(c1Var);
    }

    public static final aq.c g(c1 c1Var, eo.e1 e1Var) {
        int i10 = a.f677a[h1.c(e1Var.m(), c1Var).ordinal()];
        if (i10 == 1) {
            f0 type = c1Var.getType();
            l0.o(type, y0.a.f8215h);
            f0 type2 = c1Var.getType();
            l0.o(type2, y0.a.f8215h);
            return new aq.c(e1Var, type, type2);
        }
        if (i10 == 2) {
            f0 type3 = c1Var.getType();
            l0.o(type3, y0.a.f8215h);
            vp.n0 n0VarI = lp.a.g(e1Var).I();
            l0.o(n0VarI, "typeParameter.builtIns.nullableAnyType");
            return new aq.c(e1Var, type3, n0VarI);
        }
        if (i10 != 3) {
            throw new i0();
        }
        vp.n0 n0VarH = lp.a.g(e1Var).H();
        l0.o(n0VarH, "typeParameter.builtIns.nothingType");
        f0 type4 = c1Var.getType();
        l0.o(type4, y0.a.f8215h);
        return new aq.c(e1Var, n0VarH, type4);
    }

    public static final c1 h(aq.c cVar) {
        cVar.d();
        if (!l0.g(cVar.f679b, cVar.f680c)) {
            o1 o1VarM = cVar.f678a.m();
            o1 o1Var = o1.IN_VARIANCE;
            if (o1VarM != o1Var) {
                if ((!h.l0(cVar.f679b) || cVar.f678a.m() == o1Var) && h.n0(cVar.f680c)) {
                    return new e1(i(cVar, o1Var), cVar.f679b);
                }
                return new e1(i(cVar, o1.OUT_VARIANCE), cVar.f680c);
            }
        }
        return new e1(cVar.f679b);
    }

    public static final o1 i(aq.c cVar, o1 o1Var) {
        return o1Var == cVar.f678a.m() ? o1.INVARIANT : o1Var;
    }
}
