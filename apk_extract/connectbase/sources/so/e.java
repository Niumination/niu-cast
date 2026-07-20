package so;

import ao.h;
import eo.e1;
import java.util.ArrayList;
import java.util.List;
import kn.l0;
import kn.n0;
import kn.w;
import lm.i0;
import lm.t0;
import nm.x;
import nm.z;
import oo.k;
import os.l;
import os.m;
import vp.a1;
import vp.c0;
import vp.c1;
import vp.f0;
import vp.f1;
import vp.g0;
import vp.h0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends f1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public static final a f15185d = new a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public static final so.a f15186e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public static final so.a f15187f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final g f15188c;

    public static final class a {
        public a() {
        }

        public a(w wVar) {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15189a;

        static {
            int[] iArr = new int[so.b.values().length];
            iArr[so.b.FLEXIBLE_LOWER_BOUND.ordinal()] = 1;
            iArr[so.b.FLEXIBLE_UPPER_BOUND.ordinal()] = 2;
            iArr[so.b.INFLEXIBLE.ordinal()] = 3;
            f15189a = iArr;
        }
    }

    public static final class c extends n0 implements jn.l<wp.g, vp.n0> {
        final /* synthetic */ so.a $attr;
        final /* synthetic */ eo.e $declaration;
        final /* synthetic */ vp.n0 $type;
        final /* synthetic */ e this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(eo.e eVar, e eVar2, vp.n0 n0Var, so.a aVar) {
            super(1);
            this.$declaration = eVar;
            this.this$0 = eVar2;
            this.$type = n0Var;
            this.$attr = aVar;
        }

        @Override // jn.l
        @m
        public final vp.n0 invoke(@l wp.g gVar) {
            eo.e eVarB;
            l0.p(gVar, "kotlinTypeRefiner");
            eo.e eVar = this.$declaration;
            if (eVar == null) {
                eVar = null;
            }
            dp.b bVarH = eVar == null ? null : lp.a.h(eVar);
            if (bVarH == null || (eVarB = gVar.b(bVarH)) == null || l0.g(eVarB, this.$declaration)) {
                return null;
            }
            return (vp.n0) this.this$0.l(this.$type, eVarB, this.$attr).getFirst();
        }
    }

    static {
        k kVar = k.COMMON;
        f15186e = d.d(kVar, false, null, 3, null).i(so.b.FLEXIBLE_LOWER_BOUND);
        f15187f = d.d(kVar, false, null, 3, null).i(so.b.FLEXIBLE_UPPER_BOUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ c1 k(e eVar, e1 e1Var, so.a aVar, f0 f0Var, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            f0Var = eVar.f15188c.c(e1Var, true, aVar);
            l0.o(f0Var, "fun computeProjection(\n …er, attr)\n        }\n    }");
        }
        return eVar.j(e1Var, aVar, f0Var);
    }

    public static /* synthetic */ f0 n(e eVar, f0 f0Var, so.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new so.a(k.COMMON, null, false, null, null, 30, null);
        }
        return eVar.m(f0Var, aVar);
    }

    @Override // vp.f1
    public boolean f() {
        return false;
    }

    @l
    public final c1 j(@l e1 e1Var, @l so.a aVar, @l f0 f0Var) {
        l0.p(e1Var, "parameter");
        l0.p(aVar, dc.d.f3681l);
        l0.p(f0Var, "erasedUpperBound");
        int i10 = b.f15189a[aVar.f15175b.ordinal()];
        if (i10 == 1) {
            return new vp.e1(o1.INVARIANT, f0Var);
        }
        if (i10 != 2 && i10 != 3) {
            throw new i0();
        }
        if (!e1Var.m().getAllowsOutPosition()) {
            return new vp.e1(o1.INVARIANT, lp.a.g(e1Var).H());
        }
        List<e1> parameters = f0Var.G0().getParameters();
        l0.o(parameters, "erasedUpperBound.constructor.parameters");
        return !parameters.isEmpty() ? new vp.e1(o1.OUT_VARIANCE, f0Var) : d.b(e1Var, aVar);
    }

    public final t0<vp.n0, Boolean> l(vp.n0 n0Var, eo.e eVar, so.a aVar) {
        if (n0Var.G0().getParameters().isEmpty()) {
            return new t0<>(n0Var, Boolean.FALSE);
        }
        if (h.c0(n0Var)) {
            c1 c1Var = n0Var.F0().get(0);
            o1 o1VarC = c1Var.c();
            f0 type = c1Var.getType();
            l0.o(type, "componentTypeProjection.type");
            return new t0<>(g0.j(n0Var.getAnnotations(), n0Var.G0(), x.k(new vp.e1(o1VarC, m(type, aVar))), n0Var.H0(), null, 16, null), Boolean.FALSE);
        }
        if (h0.a(n0Var)) {
            vp.n0 n0VarJ = vp.x.j(l0.C("Raw error type: ", n0Var.G0()));
            l0.o(n0VarJ, "createErrorType(\"Raw err…pe: ${type.constructor}\")");
            return new t0<>(n0VarJ, Boolean.FALSE);
        }
        op.h hVarN = eVar.N(this);
        l0.o(hVarN, "declaration.getMemberScope(this)");
        fo.g annotations = n0Var.getAnnotations();
        a1 a1VarI = eVar.i();
        l0.o(a1VarI, "declaration.typeConstructor");
        List<e1> parameters = eVar.i().getParameters();
        l0.o(parameters, "declaration.typeConstructor.parameters");
        List<e1> list = parameters;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (e1 e1Var : list) {
            l0.o(e1Var, "parameter");
            arrayList.add(k(this, e1Var, aVar, null, 4, null));
        }
        return new t0<>(g0.m(annotations, a1VarI, arrayList, n0Var.H0(), hVarN, new c(eVar, this, n0Var, aVar)), Boolean.TRUE);
    }

    public final f0 m(f0 f0Var, so.a aVar) {
        eo.h hVarD = f0Var.G0().d();
        if (hVarD instanceof e1) {
            f0 f0VarC = this.f15188c.c((e1) hVarD, true, aVar);
            l0.o(f0VarC, "typeParameterUpperBoundE…tion, isRaw = true, attr)");
            return m(f0VarC, aVar);
        }
        if (!(hVarD instanceof eo.e)) {
            throw new IllegalStateException(l0.C("Unexpected declaration kind: ", hVarD).toString());
        }
        eo.h hVarD2 = c0.d(f0Var).G0().d();
        if (hVarD2 instanceof eo.e) {
            t0<vp.n0, Boolean> t0VarL = l(c0.c(f0Var), (eo.e) hVarD, f15186e);
            vp.n0 n0VarComponent1 = t0VarL.component1();
            boolean zBooleanValue = t0VarL.component2().booleanValue();
            t0<vp.n0, Boolean> t0VarL2 = l(c0.d(f0Var), (eo.e) hVarD2, f15187f);
            vp.n0 n0VarComponent2 = t0VarL2.component1();
            return (zBooleanValue || t0VarL2.component2().booleanValue()) ? new f(n0VarComponent1, n0VarComponent2) : g0.d(n0VarComponent1, n0VarComponent2);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + hVarD2 + "\" while for lower it's \"" + hVarD + '\"').toString());
    }

    @Override // vp.f1
    @l
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public vp.e1 e(@l f0 f0Var) {
        l0.p(f0Var, cb.b.c.f1408o);
        return new vp.e1(n(this, f0Var, null, 2, null));
    }

    public e(@m g gVar) {
        this.f15188c = gVar == null ? new g(this) : gVar;
    }

    public /* synthetic */ e(g gVar, int i10, w wVar) {
        this((i10 & 1) != 0 ? null : gVar);
    }
}
