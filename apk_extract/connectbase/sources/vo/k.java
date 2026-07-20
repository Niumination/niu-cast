package vo;

import eo.e1;
import eo.h1;
import eo.t0;
import eo.w0;
import eo.y;
import ho.d0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kn.g0;
import kn.l0;
import kn.l1;
import kn.n0;
import nm.k0;
import nm.z;
import no.a0;
import no.e0;
import no.h0;
import no.v;
import vp.b0;
import vp.c0;
import vp.c1;
import vp.f0;
import vp.j1;
import vp.m0;
import vp.n1;
import vp.o1;
import wo.t;
import wo.u;
import wo.w;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final no.c f17628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final v f17629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final vo.c f17630c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final f0 f17631a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17632b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17633c;

        public a(@os.l f0 f0Var, boolean z10, boolean z11) {
            l0.p(f0Var, y0.a.f8215h);
            this.f17631a = f0Var;
            this.f17632b = z10;
            this.f17633c = z11;
        }

        public final boolean a() {
            return this.f17633c;
        }

        @os.l
        public final f0 b() {
            return this.f17631a;
        }

        public final boolean c() {
            return this.f17632b;
        }
    }

    public static final class c extends n0 implements jn.l<eo.b, f0> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            w0 w0VarR = bVar.R();
            l0.m(w0VarR);
            f0 type = w0VarR.getType();
            l0.o(type, "it.extensionReceiverParameter!!.type");
            return type;
        }
    }

    public static final class d extends n0 implements jn.l<eo.b, f0> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            f0 returnType = bVar.getReturnType();
            l0.m(returnType);
            l0.o(returnType, "it.returnType!!");
            return returnType;
        }
    }

    public static final class e extends n0 implements jn.l<eo.b, f0> {
        final /* synthetic */ h1 $p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(h1 h1Var) {
            super(1);
            this.$p = h1Var;
        }

        @Override // jn.l
        @os.l
        public final f0 invoke(@os.l eo.b bVar) {
            l0.p(bVar, "it");
            f0 type = bVar.h().get(this.$p.f()).getType();
            l0.o(type, "it.valueParameters[p.index].type");
            return type;
        }
    }

    public static final class f extends n0 implements jn.l<n1, Boolean> {
        public static final f INSTANCE = new f();

        public f() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l n1 n1Var) {
            l0.p(n1Var, "it");
            return Boolean.valueOf(n1Var instanceof m0);
        }
    }

    public k(@os.l no.c cVar, @os.l v vVar, @os.l vo.c cVar2) {
        l0.p(cVar, "annotationTypeQualifierResolver");
        l0.p(vVar, "javaTypeEnhancementState");
        l0.p(cVar2, "typeEnhancement");
        this.f17628a = cVar;
        this.f17629b = vVar;
        this.f17630c = cVar2;
    }

    public final h c(dp.c cVar, fo.c cVar2, boolean z10) {
        e0 e0VarInvoke = this.f17629b.f11788b.invoke(cVar);
        if (e0VarInvoke.isIgnore()) {
            return null;
        }
        boolean z11 = e0VarInvoke.isWarning() || z10;
        if (a0.l().contains(cVar)) {
            return new h(g.NULLABLE, z11);
        }
        if (a0.f11708g.contains(cVar)) {
            return new h(g.NOT_NULL, z11);
        }
        if (l0.g(cVar, a0.f11702a)) {
            return new h(g.NULLABLE, z11);
        }
        if (l0.g(cVar, a0.f11703b)) {
            return new h(g.FORCE_FLEXIBILITY, z11);
        }
        if (l0.g(cVar, a0.f11706e)) {
            return j(cVar2, z11);
        }
        if (l0.g(cVar, a0.f11709h)) {
            return new h(g.NULLABLE, z11);
        }
        if (!l0.g(cVar, a0.f11710i) && !l0.g(cVar, a0.f11712k)) {
            if (l0.g(cVar, a0.f11711j)) {
                return new h(g.NULLABLE, z11);
            }
            return null;
        }
        return new h(g.NOT_NULL, z11);
    }

    /* JADX WARN: Code duplicated, block: B:110:0x019d A[RETURN] */
    public final <D extends eo.b> D d(D d10, qo.h hVar) {
        D d11;
        a aVarH;
        boolean z10;
        po.f fVar;
        d0 getter;
        if (!(d10 instanceof po.a)) {
            return d10;
        }
        po.a aVar = (po.a) d10;
        if (aVar.getKind() == eo.b.a.FAKE_OVERRIDE && aVar.a().d().size() == 1) {
            return d10;
        }
        qo.h hVarH = qo.a.h(hVar, k(d10, hVar));
        if (!(d10 instanceof po.f) || (getter = (fVar = (po.f) d10).getGetter()) == null || getter.I()) {
            d11 = d10;
        } else {
            d0 getter2 = fVar.getGetter();
            l0.m(getter2);
            l0.o(getter2, "getter!!");
            d11 = getter2;
        }
        int i10 = 0;
        if (aVar.R() != null) {
            y yVar = (y) (!(d11 instanceof y) ? null : d11);
            aVarH = b.h(m(d10, yVar == null ? null : (h1) yVar.j0(po.e.X), hVarH, c.INSTANCE), null, false, 3, null);
        } else {
            aVarH = null;
        }
        po.e eVar = d10 instanceof po.e ? (po.e) d10 : null;
        j jVar = eVar == null ? null : i.d().get(t.a(w.f19826a, (eo.e) eVar.b(), u.c(eVar, false, false, 3, null)));
        if (jVar != null) {
            jVar.f17627b.size();
            aVar.h().size();
        }
        boolean z11 = (h0.b(this.f17629b) || hVarH.f14088a.f14074t.b()) && h0.a(d10);
        List<h1> listH = d11.h();
        l0.o(listH, "annotationOwnerForMember.valueParameters");
        List<h1> list = listH;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (h1 h1Var : list) {
            arrayList.add(m(d10, h1Var, hVarH, new e(h1Var)).f(jVar == null ? null : (q) nm.h0.W2(jVar.f17627b, h1Var.f()), z11));
        }
        t0 t0Var = (t0) (!(d10 instanceof t0) ? null : d10);
        a aVarH2 = b.h(l(d10, d11, true, hVarH, (t0Var != null && ro.c.a(t0Var)) ? no.a.FIELD : no.a.METHOD_RETURN_TYPE, d.INSTANCE), jVar == null ? null : jVar.f17626a, false, 2, null);
        if ((aVarH != null && aVarH.f17633c) || aVarH2.f17633c) {
            z10 = true;
        } else {
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((a) it.next()).f17633c) {
                            z10 = true;
                        }
                    }
                }
            }
            z10 = false;
        }
        if ((aVarH == null || !aVarH.f17632b) && !aVarH2.f17632b) {
            if (!arrayList.isEmpty()) {
                Iterator it2 = arrayList.iterator();
                do {
                    if (!it2.hasNext()) {
                        if (z10) {
                            break;
                        }
                        return d10;
                    }
                } while (!((a) it2.next()).f17632b);
            } else if (z10) {
                return d10;
            }
        }
        lm.t0<eo.a.InterfaceC0106a<?>, ?> t0Var2 = z10 ? new lm.t0<>(kp.a.a(), new no.j(d10)) : null;
        f0 f0Var = aVarH != null ? aVarH.f17631a : null;
        ArrayList arrayList2 = new ArrayList(z.b0(arrayList, 10));
        for (Object obj : arrayList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                nm.y.Z();
            }
            arrayList2.add(new po.i(((a) obj).f17631a, d11.h().get(i10).w0()));
            i10 = i11;
        }
        return aVar.C0(f0Var, arrayList2, aVarH2.f17631a, t0Var2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @os.l
    public final <D extends eo.b> Collection<D> e(@os.l qo.h hVar, @os.l Collection<? extends D> collection) {
        l0.p(hVar, "c");
        l0.p(collection, "platformSignatures");
        Collection<? extends D> collection2 = collection;
        ArrayList arrayList = new ArrayList(z.b0(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(d((eo.b) it.next(), hVar));
        }
        return arrayList;
    }

    @os.l
    public final f0 f(@os.l f0 f0Var, @os.l qo.h hVar) {
        l0.p(f0Var, y0.a.f8215h);
        l0.p(hVar, "context");
        return b.h(new b(null, f0Var, k0.INSTANCE, false, hVar, no.a.TYPE_USE, false, true, 64, null), null, false, 3, null).f17631a;
    }

    @os.l
    public final List<f0> g(@os.l e1 e1Var, @os.l List<? extends f0> list, @os.l qo.h hVar) {
        l0.p(e1Var, "typeParameter");
        l0.p(list, "bounds");
        l0.p(hVar, "context");
        List<? extends f0> list2 = list;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        for (Iterator it = list2.iterator(); it.hasNext(); it = it) {
            f0 f0Var = (f0) it.next();
            if (!zp.a.b(f0Var, f.INSTANCE)) {
                f0Var = b.h(new b(e1Var, f0Var, k0.INSTANCE, false, hVar, no.a.TYPE_PARAMETER_BOUNDS, true, false, 128, null), null, false, 3, null).f17631a;
            }
            arrayList.add(f0Var);
        }
        return arrayList;
    }

    @os.m
    public final h h(@os.l fo.c cVar, boolean z10, boolean z11) {
        h hVarI;
        l0.p(cVar, "annotationDescriptor");
        h hVarI2 = i(cVar, z10, z11);
        if (hVarI2 != null) {
            return hVarI2;
        }
        fo.c cVarM = this.f17628a.m(cVar);
        if (cVarM == null) {
            return null;
        }
        e0 e0VarJ = this.f17628a.j(cVar);
        if (e0VarJ.isIgnore() || (hVarI = i(cVarM, z10, z11)) == null) {
            return null;
        }
        return h.b(hVarI, null, e0VarJ.isWarning(), 1, null);
    }

    public final h i(fo.c cVar, boolean z10, boolean z11) {
        dp.c cVarE = cVar.e();
        if (cVarE == null) {
            return null;
        }
        h hVarC = c(cVarE, cVar, (cVar instanceof ro.e) && (((ro.e) cVar).f14618h || z11) && !z10);
        if (hVarC == null) {
            return null;
        }
        return (!hVarC.f17621b && (cVar instanceof po.g) && ((po.g) cVar).j()) ? h.b(hVarC, null, true, 1, null) : hVarC;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final h j(fo.c cVar, boolean z10) {
        jp.g<?> gVarB = lp.a.b(cVar);
        jp.j jVar = gVarB instanceof jp.j ? (jp.j) gVarB : null;
        if (jVar == null) {
            return new h(g.NOT_NULL, z10);
        }
        String strB = jVar.f8777c.b();
        switch (strB.hashCode()) {
            case 73135176:
                if (!strB.equals("MAYBE")) {
                    return null;
                }
                break;
            case 74175084:
                if (!strB.equals("NEVER")) {
                    return null;
                }
                break;
            case 433141802:
                if (strB.equals("UNKNOWN")) {
                    return new h(g.FORCE_FLEXIBILITY, z10);
                }
                return null;
            case 1933739535:
                if (strB.equals("ALWAYS")) {
                    return new h(g.NOT_NULL, z10);
                }
                return null;
            default:
                return null;
        }
        return new h(g.NULLABLE, z10);
    }

    public final <D extends eo.b> fo.g k(D d10, qo.h hVar) {
        eo.h hVarA = eo.s.a(d10);
        if (hVarA == null) {
            return d10.getAnnotations();
        }
        ro.f fVar = hVarA instanceof ro.f ? (ro.f) hVarA : null;
        List<uo.a> listK0 = fVar != null ? fVar.K0() : null;
        List<uo.a> list = listK0;
        if (list == null || list.isEmpty()) {
            return d10.getAnnotations();
        }
        List<uo.a> list2 = listK0;
        ArrayList arrayList = new ArrayList(z.b0(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new ro.e(hVar, (uo.a) it.next(), true));
        }
        return fo.g.f6167h.a(nm.h0.A4(d10.getAnnotations(), arrayList));
    }

    public final b l(eo.b bVar, fo.a aVar, boolean z10, qo.h hVar, no.a aVar2, jn.l<? super eo.b, ? extends f0> lVar) {
        f0 f0VarInvoke = lVar.invoke(bVar);
        Collection<? extends eo.b> collectionD = bVar.d();
        l0.o(collectionD, "this.overriddenDescriptors");
        Collection<? extends eo.b> collection = collectionD;
        ArrayList arrayList = new ArrayList(z.b0(collection, 10));
        for (eo.b bVar2 : collection) {
            l0.o(bVar2, "it");
            arrayList.add(lVar.invoke(bVar2));
        }
        return new b(aVar, f0VarInvoke, arrayList, z10, qo.a.h(hVar, lVar.invoke(bVar).getAnnotations()), aVar2, false, false, 192, null);
    }

    public final b m(eo.b bVar, h1 h1Var, qo.h hVar, jn.l<? super eo.b, ? extends f0> lVar) {
        if (h1Var != null) {
            hVar = qo.a.h(hVar, h1Var.getAnnotations());
        }
        return l(bVar, h1Var, false, hVar, no.a.VALUE_PARAMETER, lVar);
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.m
        public final fo.a f17634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final f0 f17635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final Collection<f0> f17636c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f17637d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @os.l
        public final qo.h f17638e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final no.a f17639f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f17640g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f17641h;

        public static final class a extends n0 implements jn.l<Integer, vo.d> {
            final /* synthetic */ vo.d[] $computedResult;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(vo.d[] dVarArr) {
                super(1);
                this.$computedResult = dVarArr;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ vo.d invoke(Integer num) {
                return invoke(num.intValue());
            }

            @os.l
            public final vo.d invoke(int i10) {
                vo.d[] dVarArr = this.$computedResult;
                if (i10 >= 0 && i10 <= nm.r.we(dVarArr)) {
                    return dVarArr[i10];
                }
                vo.d.f17611e.getClass();
                return vo.d.f17612f;
            }
        }

        /* JADX INFO: renamed from: vo.k$b$b, reason: collision with other inner class name */
        public /* synthetic */ class C0460b extends g0 implements jn.l<n1, Boolean> {
            public static final C0460b INSTANCE = new C0460b();

            public C0460b() {
                super(1);
            }

            @Override // kn.q, un.c
            @os.l
            public final String getName() {
                return "containsFunctionN";
            }

            @Override // kn.q
            @os.l
            public final un.h getOwner() {
                return l1.d(l0.a.class);
            }

            @Override // kn.q
            @os.l
            public final String getSignature() {
                return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l n1 n1Var) {
                l0.p(n1Var, "p0");
                return Boolean.valueOf(b.g(n1Var));
            }
        }

        public static final class c extends n0 implements jn.l<f0, Boolean> {
            public static final c INSTANCE = new c();

            public c() {
                super(1);
            }

            @Override // jn.l
            public final Boolean invoke(f0 f0Var) {
                return Boolean.valueOf(f0Var instanceof m0);
            }
        }

        public /* synthetic */ class d extends g0 implements jn.l<n1, Boolean> {
            public static final d INSTANCE = new d();

            public d() {
                super(1);
            }

            @Override // kn.q, un.c
            @os.l
            public final String getName() {
                return "containsFunctionN";
            }

            @Override // kn.q
            @os.l
            public final un.h getOwner() {
                return l1.d(l0.a.class);
            }

            @Override // kn.q
            @os.l
            public final String getSignature() {
                return "enhance$containsFunctionN(Lorg/jetbrains/kotlin/types/UnwrappedType;)Z";
            }

            @Override // jn.l
            @os.l
            public final Boolean invoke(@os.l n1 n1Var) {
                l0.p(n1Var, "p0");
                return Boolean.valueOf(b.g(n1Var));
            }
        }

        public static final class e extends n0 implements jn.l<Integer, vo.d> {
            final /* synthetic */ q $predefined;
            final /* synthetic */ jn.l<Integer, vo.d> $qualifiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public e(q qVar, jn.l<? super Integer, vo.d> lVar) {
                super(1);
                this.$predefined = qVar;
                this.$qualifiers = lVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ vo.d invoke(Integer num) {
                return invoke(num.intValue());
            }

            @os.l
            public final vo.d invoke(int i10) {
                vo.d dVar = this.$predefined.f17655a.get(Integer.valueOf(i10));
                return dVar == null ? this.$qualifiers.invoke(Integer.valueOf(i10)) : dVar;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@os.m k kVar, @os.l fo.a aVar, @os.l f0 f0Var, Collection<? extends f0> collection, @os.l boolean z10, @os.l qo.h hVar, no.a aVar2, boolean z11, boolean z12) {
            l0.p(kVar, "this$0");
            l0.p(f0Var, "fromOverride");
            l0.p(collection, "fromOverridden");
            l0.p(hVar, "containerContext");
            l0.p(aVar2, "containerApplicabilityType");
            k.this = kVar;
            this.f17634a = aVar;
            this.f17635b = f0Var;
            this.f17636c = collection;
            this.f17637d = z10;
            this.f17638e = hVar;
            this.f17639f = aVar2;
            this.f17640g = z11;
            this.f17641h = z12;
        }

        public static final boolean g(n1 n1Var) {
            eo.h hVarD = n1Var.G0().d();
            if (hVarD == null) {
                return false;
            }
            dp.f name = hVarD.getName();
            co.c cVar = co.c.f1685a;
            cVar.getClass();
            dp.c cVar2 = co.c.f1691g;
            if (!l0.g(name, cVar2.g())) {
                return false;
            }
            dp.c cVarE = lp.a.e(hVarD);
            cVar.getClass();
            return l0.g(cVarE, cVar2);
        }

        public static /* synthetic */ a h(b bVar, q qVar, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                qVar = null;
            }
            if ((i10 & 2) != 0) {
                z10 = false;
            }
            return bVar.f(qVar, z10);
        }

        public static final <T> T l(List<dp.c> list, fo.g gVar, T t10) {
            List<dp.c> list2 = list;
            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                Iterator<T> it = list2.iterator();
                while (it.hasNext()) {
                    if (gVar.d((dp.c) it.next()) != null) {
                        return t10;
                    }
                }
            }
            return null;
        }

        public static final <T> T m(T t10, T t11) {
            if (t10 == null || t11 == null || l0.g(t10, t11)) {
                return t10 == null ? t11 : t10;
            }
            return null;
        }

        public static final void r(b bVar, ArrayList<n> arrayList, f0 f0Var, qo.h hVar, e1 e1Var) {
            qo.h hVarH = qo.a.h(hVar, f0Var.getAnnotations());
            no.w wVarB = hVarH.b();
            no.q qVarA = wVarB == null ? null : wVarB.a(bVar.f17640g ? no.a.TYPE_PARAMETER_BOUNDS : no.a.TYPE_USE);
            arrayList.add(new n(f0Var, qVarA, e1Var, false));
            if (bVar.f17641h && (f0Var instanceof m0)) {
                return;
            }
            List<c1> listF0 = f0Var.F0();
            List<e1> parameters = f0Var.G0().getParameters();
            l0.o(parameters, "type.constructor.parameters");
            for (lm.t0 t0Var : nm.h0.i6(listF0, parameters)) {
                c1 c1Var = (c1) t0Var.component1();
                e1 e1Var2 = (e1) t0Var.component2();
                if (c1Var.a()) {
                    f0 type = c1Var.getType();
                    l0.o(type, "arg.type");
                    arrayList.add(new n(type, qVarA, e1Var2, true));
                } else {
                    f0 type2 = c1Var.getType();
                    l0.o(type2, "arg.type");
                    r(bVar, arrayList, type2, hVarH, e1Var2);
                }
            }
        }

        public final h b(e1 e1Var) {
            g gVar;
            if (e1Var instanceof ro.m) {
                ro.m mVar = (ro.m) e1Var;
                List<f0> upperBounds = mVar.getUpperBounds();
                l0.o(upperBounds, "upperBounds");
                List<f0> list = upperBounds;
                if (!(list instanceof Collection) || !list.isEmpty()) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        if (!vp.h0.a((f0) it.next())) {
                            List<f0> upperBounds2 = mVar.getUpperBounds();
                            l0.o(upperBounds2, "upperBounds");
                            List<f0> list2 = upperBounds2;
                            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                Iterator<T> it2 = list2.iterator();
                                while (it2.hasNext()) {
                                    if (!m.b((f0) it2.next())) {
                                        List<f0> upperBounds3 = mVar.getUpperBounds();
                                        l0.o(upperBounds3, "upperBounds");
                                        List<f0> list3 = upperBounds3;
                                        if ((list3 instanceof Collection) && list3.isEmpty()) {
                                            gVar = g.NULLABLE;
                                        } else {
                                            for (f0 f0Var : list3) {
                                                l0.o(f0Var, "it");
                                                if (!vp.h0.b(f0Var)) {
                                                    gVar = g.NOT_NULL;
                                                }
                                            }
                                            gVar = g.NULLABLE;
                                        }
                                        return new h(gVar, false, 2, null);
                                    }
                                }
                            }
                            List<f0> upperBounds4 = mVar.getUpperBounds();
                            l0.o(upperBounds4, "upperBounds");
                            List<f0> list4 = upperBounds4;
                            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                                for (f0 f0Var2 : list4) {
                                    if ((f0Var2 instanceof b0) && !vp.h0.b(((b0) f0Var2).f17665e)) {
                                        return new h(g.NOT_NULL, true);
                                    }
                                }
                            }
                            List<f0> upperBounds5 = mVar.getUpperBounds();
                            l0.o(upperBounds5, "upperBounds");
                            List<f0> list5 = upperBounds5;
                            if (!(list5 instanceof Collection) || !list5.isEmpty()) {
                                for (f0 f0Var3 : list5) {
                                    if ((f0Var3 instanceof b0) && vp.h0.b(((b0) f0Var3).f17665e)) {
                                        return new h(g.NULLABLE, true);
                                    }
                                }
                                break;
                            }
                            break;
                        }
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Code duplicated, block: B:19:0x0062 A[EDGE_INSN: B:19:0x0062->B:20:0x0063 BREAK  A[LOOP:1: B:14:0x004a->B:44:?]] */
        public final jn.l<Integer, vo.d> c(boolean z10) {
            boolean z11;
            Collection<f0> collection = this.f17636c;
            ArrayList arrayList = new ArrayList(z.b0(collection, 10));
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(q((f0) it.next()));
            }
            List<n> listQ = q(this.f17635b);
            if (!this.f17637d) {
                z11 = false;
                break;
            }
            Collection<f0> collection2 = this.f17636c;
            if (!(collection2 instanceof Collection) || !collection2.isEmpty()) {
                Iterator<T> it2 = collection2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z11 = false;
                        break;
                    }
                    if (!wp.e.f19851a.b((f0) it2.next(), this.f17635b)) {
                        z11 = true;
                        break;
                    }
                }
            } else {
                z11 = false;
                break;
            }
            int size = z11 ? 1 : listQ.size();
            vo.d[] dVarArr = new vo.d[size];
            int i10 = 0;
            while (i10 < size) {
                boolean z12 = i10 == 0;
                n nVar = listQ.get(i10);
                f0 f0Var = nVar.f17650a;
                no.q qVar = nVar.f17651b;
                e1 e1Var = nVar.f17652c;
                boolean z13 = nVar.f17653d;
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    n nVar2 = (n) nm.h0.W2((List) it3.next(), i10);
                    f0 f0Var2 = nVar2 == null ? null : nVar2.f17650a;
                    if (f0Var2 != null) {
                        arrayList2.add(f0Var2);
                    }
                }
                int i11 = i10;
                dVarArr[i11] = e(f0Var, arrayList2, qVar, z12, e1Var, z13, z10);
                i10 = i11 + 1;
            }
            return new a(dVarArr);
        }

        public final h d(h hVar, no.q qVar, e1 e1Var) {
            h hVarB;
            h hVar2 = null;
            if (hVar == null) {
                hVar = qVar == null ? null : qVar.f11768a;
            }
            if (e1Var != null && (hVarB = b(e1Var)) != null) {
                if (hVarB.f17620a == g.NULLABLE) {
                    hVarB = h.b(hVarB, g.FORCE_FLEXIBILITY, false, 2, null);
                }
                hVar2 = hVarB;
            }
            return o(hVar2, hVar);
        }

        public final vo.d e(f0 f0Var, Collection<? extends f0> collection, no.q qVar, boolean z10, e1 e1Var, boolean z11, boolean z12) {
            boolean z13;
            Collection<? extends f0> collection2 = collection;
            ArrayList arrayList = new ArrayList(z.b0(collection2, 10));
            Iterator<T> it = collection2.iterator();
            while (it.hasNext()) {
                arrayList.add(j((f0) it.next()));
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                vo.e eVar = ((vo.d) it2.next()).f17614b;
                if (eVar != null) {
                    arrayList2.add(eVar);
                }
            }
            Set setA6 = nm.h0.a6(arrayList2);
            ArrayList arrayList3 = new ArrayList();
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                g gVar = ((vo.d) it3.next()).f17613a;
                if (gVar != null) {
                    arrayList3.add(gVar);
                }
            }
            Set setA7 = nm.h0.a6(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            Iterator<T> it4 = collection2.iterator();
            while (it4.hasNext()) {
                g gVar2 = j(vp.l1.d((f0) it4.next())).f17613a;
                if (gVar2 != null) {
                    arrayList4.add(gVar2);
                }
            }
            Set setA8 = nm.h0.a6(arrayList4);
            vo.d dVarK = k(f0Var, z10, qVar, e1Var, z11);
            g gVar3 = null;
            vo.d dVar = !dVarK.f17616d ? dVarK : null;
            g gVar4 = dVar == null ? null : dVar.f17613a;
            g gVar5 = dVarK.f17613a;
            boolean z14 = this.f17637d && z10;
            g gVarD = s.d(setA7, gVar4, z14);
            if (gVarD != null && !z12 && (!n() || !z10 || gVarD != g.NULLABLE)) {
                gVar3 = gVarD;
            }
            vo.e eVar2 = (vo.e) s.c(setA6, vo.e.MUTABLE, vo.e.READ_ONLY, dVarK.f17614b, z14);
            boolean z15 = (gVar5 == gVar4 && l0.g(setA8, setA7)) ? false : true;
            if (dVarK.f17615c) {
                z13 = true;
            } else {
                if (!arrayList.isEmpty()) {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            if (((vo.d) it5.next()).f17615c) {
                                z13 = true;
                            }
                        }
                    }
                }
                z13 = false;
            }
            if (gVar3 == null && z15) {
                return s.a(s.d(setA8, gVar5, z14), eVar2, true, z13);
            }
            return s.a(gVar3, eVar2, gVar3 == null, z13);
        }

        @os.l
        public final a f(@os.m q qVar, boolean z10) {
            jn.l<Integer, vo.d> lVarC = c(z10);
            e eVar = qVar == null ? null : new e(qVar, lVarC);
            boolean zE = this.f17641h ? j1.e(this.f17635b, C0460b.INSTANCE, c.INSTANCE) : j1.c(this.f17635b, d.INSTANCE);
            vo.c cVar = k.this.f17630c;
            f0 f0Var = this.f17635b;
            if (eVar != null) {
                lVarC = eVar;
            }
            f0 f0VarA = cVar.a(f0Var, lVarC, this.f17641h);
            return f0VarA == null ? new a(this.f17635b, false, zE) : new a(f0VarA, true, zE);
        }

        public final h i(fo.g gVar, boolean z10, boolean z11) {
            boolean z12;
            k kVar = k.this;
            Iterator<fo.c> it = gVar.iterator();
            h hVar = null;
            while (it.hasNext()) {
                h hVarH = kVar.h(it.next(), z10, z11);
                if (hVar != null) {
                    if (hVarH != null && !l0.g(hVarH, hVar) && (!(z12 = hVarH.f17621b) || hVar.f17621b)) {
                        if (z12 || !hVar.f17621b) {
                            return null;
                        }
                    }
                }
                hVar = hVarH;
            }
            return hVar;
        }

        /* JADX WARN: Code duplicated, block: B:16:0x0044  */
        /* JADX WARN: Code duplicated, block: B:17:0x0047  */
        /* JADX WARN: Code duplicated, block: B:19:0x004d  */
        /* JADX WARN: Code duplicated, block: B:20:0x0050  */
        /* JADX WARN: Code duplicated, block: B:28:0x0065  */
        public final vo.d j(f0 f0Var) {
            lm.t0 t0Var;
            g gVar;
            g gVar2;
            vo.e eVar;
            boolean z10;
            if (c0.b(f0Var)) {
                vp.z zVarA = c0.a(f0Var);
                t0Var = new lm.t0(zVarA.f17773b, zVarA.f17774c);
            } else {
                t0Var = new lm.t0(f0Var, f0Var);
            }
            f0 f0Var2 = (f0) t0Var.component1();
            f0 f0Var3 = (f0) t0Var.component2();
            co.d dVar = co.d.f1703a;
            if (!f0Var2.H0()) {
                if (f0Var3.H0()) {
                    gVar = null;
                } else {
                    gVar2 = g.NOT_NULL;
                }
                if (dVar.f(f0Var2)) {
                    eVar = vo.e.READ_ONLY;
                } else if (dVar.d(f0Var3)) {
                    eVar = vo.e.MUTABLE;
                } else {
                    eVar = null;
                }
                if (!(f0Var.J0() instanceof vo.f) || (f0Var.J0() instanceof vp.o)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                return new vo.d(gVar, eVar, z10, false, 8, null);
            }
            gVar2 = g.NULLABLE;
            gVar = gVar2;
            if (dVar.f(f0Var2)) {
                eVar = vo.e.READ_ONLY;
            } else if (dVar.d(f0Var3)) {
                eVar = vo.e.MUTABLE;
            } else {
                eVar = null;
            }
            if (f0Var.J0() instanceof vo.f) {
                z10 = true;
            } else {
                z10 = true;
            }
            return new vo.d(gVar, eVar, z10, false, 8, null);
        }

        public final vo.d k(f0 f0Var, boolean z10, no.q qVar, e1 e1Var, boolean z11) {
            fo.g annotations;
            fo.a aVar;
            fo.a aVar2;
            if (z11) {
                if ((e1Var == null ? null : e1Var.m()) == o1.IN_VARIANCE) {
                    vo.d.f17611e.getClass();
                    return vo.d.f17612f;
                }
            }
            boolean zC = this.f17638e.f14088a.f14074t.c();
            if (!z10 || (aVar2 = this.f17634a) == null || (aVar2 instanceof e1) || !zC) {
                annotations = (!z10 || (aVar = this.f17634a) == null) ? f0Var.getAnnotations() : fo.i.a(aVar.getAnnotations(), f0Var.getAnnotations());
            } else {
                fo.g annotations2 = aVar2.getAnnotations();
                k kVar = k.this;
                ArrayList arrayList = new ArrayList();
                for (fo.c cVar : annotations2) {
                    no.c.a aVarH = kVar.f17628a.h(cVar);
                    if (aVarH == null || !aVarH.b().contains(no.a.TYPE_USE)) {
                        arrayList.add(cVar);
                    }
                }
                annotations = fo.i.a(fo.g.f6167h.a(arrayList), f0Var.getAnnotations());
            }
            if (z10) {
                no.w wVarB = this.f17638e.b();
                qVar = wVarB == null ? null : wVarB.a(this.f17639f);
            }
            lm.t0<h, Boolean> t0VarP = p(f0Var);
            h hVarComponent1 = t0VarP.component1();
            boolean zBooleanValue = t0VarP.component2().booleanValue();
            h hVarI = i(annotations, zC, this.f17640g);
            if (hVarI == null || z11) {
                hVarI = null;
            }
            h hVarD = hVarI == null ? d(hVarComponent1, qVar, e1Var) : hVarI;
            boolean z12 = false;
            boolean z13 = hVarI == null ? zBooleanValue || (qVar != null && qVar.f11770c) : hVarI.f17620a == g.NOT_NULL;
            g gVar = hVarD != null ? hVarD.f17620a : null;
            vo.e eVar = (vo.e) m(l(a0.m(), annotations, vo.e.READ_ONLY), l(a0.f11715n, annotations, vo.e.MUTABLE));
            boolean z14 = z13 && zp.a.o(f0Var);
            if (hVarD != null && hVarD.f17621b) {
                z12 = true;
            }
            return new vo.d(gVar, eVar, z14, z12);
        }

        public final boolean n() {
            fo.a aVar = this.f17634a;
            if (!(aVar instanceof h1)) {
                aVar = null;
            }
            h1 h1Var = (h1) aVar;
            return (h1Var != null ? h1Var.s0() : null) != null;
        }

        public final h o(h hVar, h hVar2) {
            if (hVar == null) {
                return hVar2;
            }
            if (hVar2 == null) {
                return hVar;
            }
            boolean z10 = hVar.f17621b;
            if (z10 && !hVar2.f17621b) {
                return hVar2;
            }
            if (z10 || !hVar2.f17621b) {
                return (hVar.f17620a.compareTo(hVar2.f17620a) >= 0 && hVar.f17620a.compareTo(hVar2.f17620a) > 0) ? hVar : hVar2;
            }
            return hVar;
        }

        public final lm.t0<h, Boolean> p(f0 f0Var) {
            eo.h hVarD = f0Var.G0().d();
            e1 e1Var = hVarD instanceof e1 ? (e1) hVarD : null;
            h hVarB = e1Var == null ? null : b(e1Var);
            if (hVarB == null) {
                return new lm.t0<>(null, Boolean.FALSE);
            }
            g gVar = g.NOT_NULL;
            return new lm.t0<>(new h(gVar, hVarB.f17621b), Boolean.valueOf(hVarB.f17620a == gVar));
        }

        public final List<n> q(f0 f0Var) {
            ArrayList arrayList = new ArrayList(1);
            r(this, arrayList, f0Var, this.f17638e, null);
            return arrayList;
        }

        public /* synthetic */ b(fo.a aVar, f0 f0Var, Collection collection, boolean z10, qo.h hVar, no.a aVar2, boolean z11, boolean z12, int i10, kn.w wVar) {
            this(k.this, aVar, f0Var, collection, z10, hVar, aVar2, (i10 & 64) != 0 ? false : z11, (i10 & 128) != 0 ? false : z12);
        }
    }
}
