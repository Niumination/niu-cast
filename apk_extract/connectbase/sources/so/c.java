package so;

import eo.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import nm.h0;
import nm.s0;
import nm.z;
import oo.k;
import os.l;
import os.m;
import qo.h;
import uo.a0;
import uo.c0;
import uo.i;
import uo.j;
import uo.v;
import uo.y;
import vp.a1;
import vp.c1;
import vp.f0;
import vp.g0;
import vp.i0;
import vp.o1;
import vp.x;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final h f15180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public final qo.l f15181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public final g f15182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @l
    public final e f15183d;

    public static final class a extends n0 implements jn.a<f0> {
        final /* synthetic */ so.a $attr;
        final /* synthetic */ a1 $constructor;
        final /* synthetic */ j $javaType;
        final /* synthetic */ e1 $parameter;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e1 e1Var, j jVar, so.a aVar, a1 a1Var) {
            super(0);
            this.$parameter = e1Var;
            this.$javaType = jVar;
            this.$attr = aVar;
            this.$constructor = a1Var;
        }

        @Override // jn.a
        @l
        public final f0 invoke() {
            g gVar = c.this.f15182c;
            e1 e1Var = this.$parameter;
            boolean zT = this.$javaType.t();
            so.a aVar = this.$attr;
            eo.h hVarD = this.$constructor.d();
            f0 f0VarC = gVar.c(e1Var, zT, aVar.h(hVarD == null ? null : hVarD.q()));
            l0.o(f0VarC, "typeParameterUpperBoundE…efaultType)\n            )");
            return f0VarC;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(@l h hVar, @l qo.l lVar) {
        l0.p(hVar, "c");
        l0.p(lVar, "typeParameterResolver");
        this.f15180a = hVar;
        this.f15181b = lVar;
        g gVar = new g(null, 1, 0 == true ? 1 : 0);
        this.f15182c = gVar;
        this.f15183d = new e(gVar);
    }

    public static /* synthetic */ f0 l(c cVar, uo.f fVar, so.a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return cVar.k(fVar, aVar, z10);
    }

    public static final vp.n0 n(j jVar) {
        vp.n0 n0VarJ = x.j(l0.C("Unresolved java class ", jVar.D()));
        l0.o(n0VarJ, "createErrorType(\"Unresol…vaType.presentableText}\")");
        return n0VarJ;
    }

    public final boolean b(j jVar, eo.e eVar) {
        if (!a0.a((uo.x) h0.v3(jVar.y()))) {
            return false;
        }
        List<e1> parameters = co.d.f1703a.b(eVar).i().getParameters();
        l0.o(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        e1 e1Var = (e1) h0.v3(parameters);
        if (e1Var == null) {
            return false;
        }
        o1 o1VarM = e1Var.m();
        l0.o(o1VarM, "JavaToKotlinClassMapper.….variance ?: return false");
        return o1VarM != o1.OUT_VARIANCE;
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    public final List<c1> c(j jVar, so.a aVar, a1 a1Var) {
        boolean z10;
        if (!jVar.t()) {
            if (jVar.y().isEmpty()) {
                List<e1> parameters = a1Var.getParameters();
                l0.o(parameters, "constructor.parameters");
                z10 = parameters.isEmpty() ? false : true;
            }
        }
        List<e1> parameters2 = a1Var.getParameters();
        l0.o(parameters2, "constructor.parameters");
        if (z10) {
            return d(jVar, parameters2, a1Var, aVar);
        }
        if (parameters2.size() != jVar.y().size()) {
            List<e1> list = parameters2;
            ArrayList arrayList = new ArrayList(z.b0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new vp.e1(x.j(((e1) it.next()).getName().b())));
            }
            return h0.V5(arrayList);
        }
        Iterable<s0> iterableH6 = h0.h6(jVar.y());
        ArrayList arrayList2 = new ArrayList(z.b0(iterableH6, 10));
        for (s0 s0Var : iterableH6) {
            int i10 = s0Var.f11691a;
            uo.x xVar = (uo.x) s0Var.f11692b;
            parameters2.size();
            e1 e1Var = parameters2.get(i10);
            so.a aVarD = d.d(k.COMMON, false, null, 3, null);
            l0.o(e1Var, "parameter");
            arrayList2.add(p(xVar, aVarD, e1Var));
        }
        return h0.V5(arrayList2);
    }

    public final List<c1> d(j jVar, List<? extends e1> list, a1 a1Var, so.a aVar) {
        c1 c1VarJ;
        List<? extends e1> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        for (e1 e1Var : list2) {
            if (zp.a.k(e1Var, null, aVar.f15177d)) {
                c1VarJ = d.b(e1Var, aVar);
            } else {
                c1VarJ = this.f15183d.j(e1Var, jVar.t() ? aVar : aVar.i(b.INFLEXIBLE), new i0(this.f15180a.f14088a.f14055a, new a(e1Var, jVar, aVar, a1Var)));
            }
            arrayList.add(c1VarJ);
        }
        return arrayList;
    }

    public final vp.n0 e(j jVar, so.a aVar, vp.n0 n0Var) {
        fo.g annotations;
        if (n0Var == null) {
            annotations = new qo.e(this.f15180a, jVar, false, 4, null);
        } else {
            annotations = n0Var.getAnnotations();
        }
        a1 a1VarF = f(jVar, aVar);
        if (a1VarF == null) {
            return null;
        }
        boolean zI = i(aVar);
        if (l0.g(n0Var != null ? n0Var.G0() : null, a1VarF) && !jVar.t() && zI) {
            return n0Var.N0(true);
        }
        return g0.j(annotations, a1VarF, c(jVar, aVar, a1VarF), zI, null, 16, null);
    }

    public final a1 f(j jVar, so.a aVar) {
        i iVarI = jVar.i();
        if (iVarI == null) {
            return g(jVar);
        }
        if (!(iVarI instanceof uo.g)) {
            if (!(iVarI instanceof y)) {
                throw new IllegalStateException(l0.C("Unknown classifier kind: ", iVarI));
            }
            e1 e1VarA = this.f15181b.a((y) iVarI);
            if (e1VarA == null) {
                return null;
            }
            return e1VarA.i();
        }
        uo.g gVar = (uo.g) iVarI;
        dp.c cVarE = gVar.e();
        if (cVarE == null) {
            throw new AssertionError(l0.C("Class type should have a FQ name: ", iVarI));
        }
        eo.e eVarJ = j(jVar, aVar, cVarE);
        if (eVarJ == null) {
            eVarJ = this.f15180a.f14088a.f14065k.a(gVar);
        }
        return eVarJ == null ? g(jVar) : eVarJ.i();
    }

    public final a1 g(j jVar) {
        dp.b bVarM = dp.b.m(new dp.c(jVar.F()));
        l0.o(bVarM, "topLevel(FqName(javaType.classifierQualifiedName))");
        a1 a1VarI = this.f15180a.f14088a.f14058d.e().f14738l.d(bVarM, nm.x.k(0)).i();
        l0.o(a1VarI, "c.components.deserialize…istOf(0)).typeConstructor");
        return a1VarI;
    }

    public final boolean h(o1 o1Var, e1 e1Var) {
        return (e1Var.m() == o1.INVARIANT || o1Var == e1Var.m()) ? false : true;
    }

    public final boolean i(so.a aVar) {
        return (aVar.f15175b == b.FLEXIBLE_LOWER_BOUND || aVar.f15176c || aVar.f15174a == k.SUPERTYPE) ? false : true;
    }

    public final eo.e j(j jVar, so.a aVar, dp.c cVar) {
        if (aVar.f15176c && l0.g(cVar, d.f15184a)) {
            return this.f15180a.f14088a.f14070p.c();
        }
        co.d dVar = co.d.f1703a;
        eo.e eVarH = co.d.h(dVar, cVar, this.f15180a.f14088a.f14069o.n(), null, 4, null);
        if (eVarH == null) {
            return null;
        }
        return (dVar.e(eVarH) && (aVar.f15175b == b.FLEXIBLE_LOWER_BOUND || aVar.f15174a == k.SUPERTYPE || b(jVar, eVarH))) ? dVar.b(eVarH) : eVarH;
    }

    @l
    public final f0 k(@l uo.f fVar, @l so.a aVar, boolean z10) {
        l0.p(fVar, "arrayType");
        l0.p(aVar, dc.d.f3681l);
        uo.x xVarO = fVar.o();
        v vVar = xVarO instanceof v ? (v) xVarO : null;
        ao.i type = vVar == null ? null : vVar.getType();
        qo.e eVar = new qo.e(this.f15180a, fVar, true);
        if (type != null) {
            vp.n0 n0VarO = this.f15180a.f14088a.f14069o.n().O(type);
            l0.o(n0VarO, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            n0VarO.O0(fo.g.f6167h.a(h0.A4(eVar, n0VarO.getAnnotations())));
            return aVar.f15176c ? n0VarO : g0.d(n0VarO, n0VarO.N0(true));
        }
        f0 f0VarO = o(xVarO, d.d(k.COMMON, aVar.f15176c, null, 2, null));
        if (aVar.f15176c) {
            vp.n0 n0VarM = this.f15180a.f14088a.f14069o.n().m(z10 ? o1.OUT_VARIANCE : o1.INVARIANT, f0VarO, eVar);
            l0.o(n0VarM, "c.module.builtIns.getArr…mponentType, annotations)");
            return n0VarM;
        }
        vp.n0 n0VarM2 = this.f15180a.f14088a.f14069o.n().m(o1.INVARIANT, f0VarO, eVar);
        l0.o(n0VarM2, "c.module.builtIns.getArr…mponentType, annotations)");
        return g0.d(n0VarM2, this.f15180a.f14088a.f14069o.n().m(o1.OUT_VARIANCE, f0VarO, eVar).N0(true));
    }

    public final f0 m(j jVar, so.a aVar) {
        vp.n0 n0VarE;
        boolean z10 = (aVar.f15176c || aVar.f15174a == k.SUPERTYPE) ? false : true;
        boolean zT = jVar.t();
        if (!zT && !z10) {
            vp.n0 n0VarE2 = e(jVar, aVar, null);
            return n0VarE2 == null ? n(jVar) : n0VarE2;
        }
        vp.n0 n0VarE3 = e(jVar, aVar.i(b.FLEXIBLE_LOWER_BOUND), null);
        if (n0VarE3 != null && (n0VarE = e(jVar, aVar.i(b.FLEXIBLE_UPPER_BOUND), n0VarE3)) != null) {
            return zT ? new f(n0VarE3, n0VarE) : g0.d(n0VarE3, n0VarE);
        }
        return n(jVar);
    }

    @l
    public final f0 o(@m uo.x xVar, @l so.a aVar) {
        l0.p(aVar, dc.d.f3681l);
        if (xVar instanceof v) {
            ao.i type = ((v) xVar).getType();
            vp.n0 n0VarR = type != null ? this.f15180a.f14088a.f14069o.n().R(type) : this.f15180a.f14088a.f14069o.n().Z();
            l0.o(n0VarR, "{\n                val pr…ns.unitType\n            }");
            return n0VarR;
        }
        if (xVar instanceof j) {
            return m((j) xVar, aVar);
        }
        if (xVar instanceof uo.f) {
            return l(this, (uo.f) xVar, aVar, false, 4, null);
        }
        if (!(xVar instanceof c0)) {
            if (xVar != null) {
                throw new UnsupportedOperationException(l0.C("Unsupported type: ", xVar));
            }
            vp.n0 n0VarY = this.f15180a.f14088a.f14069o.n().y();
            l0.o(n0VarY, "c.module.builtIns.defaultBound");
            return n0VarY;
        }
        uo.x xVarX = ((c0) xVar).x();
        if (xVarX != null) {
            return o(xVarX, aVar);
        }
        vp.n0 n0VarY2 = this.f15180a.f14088a.f14069o.n().y();
        l0.o(n0VarY2, "c.module.builtIns.defaultBound");
        return n0VarY2;
    }

    public final c1 p(uo.x xVar, so.a aVar, e1 e1Var) {
        if (!(xVar instanceof c0)) {
            return new vp.e1(o1.INVARIANT, o(xVar, aVar));
        }
        c0 c0Var = (c0) xVar;
        uo.x xVarX = c0Var.x();
        o1 o1Var = c0Var.J() ? o1.OUT_VARIANCE : o1.IN_VARIANCE;
        return (xVarX == null || h(o1Var, e1Var)) ? d.b(e1Var, aVar) : zp.a.e(o(xVarX, d.d(k.COMMON, false, null, 3, null)), o1Var, e1Var);
    }
}
