package ro;

import eo.e0;
import eo.e1;
import eo.h1;
import eo.t0;
import eo.w0;
import eo.y0;
import ho.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kn.g1;
import kn.l0;
import kn.l1;
import kn.m1;
import kn.n0;
import kn.w;
import nm.c1;
import nm.d1;
import nm.h0;
import nm.k0;
import nm.s0;
import nm.z;
import un.o;
import uo.b0;
import uo.n;
import uo.r;
import uo.x;
import uo.y;
import vp.f0;
import vp.j1;
import wo.u;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j extends op.i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ o<Object>[] f14652m;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final qo.h f14653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final j f14654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.i<Collection<eo.m>> f14655d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.i<ro.b> f14656e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final up.g<dp.f, Collection<y0>> f14657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final up.h<dp.f, t0> f14658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final up.g<dp.f, Collection<y0>> f14659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final up.i f14660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final up.i f14661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public final up.i f14662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public final up.g<dp.f, List<t0>> f14663l;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final f0 f14664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.m
        public final f0 f14665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final List<h1> f14666c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final List<e1> f14667d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f14668e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @os.l
        public final List<String> f14669f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@os.l f0 f0Var, @os.m f0 f0Var2, @os.l List<? extends h1> list, @os.l List<? extends e1> list2, boolean z10, @os.l List<String> list3) {
            l0.p(f0Var, "returnType");
            l0.p(list, "valueParameters");
            l0.p(list2, "typeParameters");
            l0.p(list3, "errors");
            this.f14664a = f0Var;
            this.f14665b = f0Var2;
            this.f14666c = list;
            this.f14667d = list2;
            this.f14668e = z10;
            this.f14669f = list3;
        }

        @os.l
        public final List<String> a() {
            return this.f14669f;
        }

        public final boolean b() {
            return this.f14668e;
        }

        @os.m
        public final f0 c() {
            return this.f14665b;
        }

        @os.l
        public final f0 d() {
            return this.f14664a;
        }

        @os.l
        public final List<e1> e() {
            return this.f14667d;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return l0.g(this.f14664a, aVar.f14664a) && l0.g(this.f14665b, aVar.f14665b) && l0.g(this.f14666c, aVar.f14666c) && l0.g(this.f14667d, aVar.f14667d) && this.f14668e == aVar.f14668e && l0.g(this.f14669f, aVar.f14669f);
        }

        @os.l
        public final List<h1> f() {
            return this.f14666c;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            int iHashCode = this.f14664a.hashCode() * 31;
            f0 f0Var = this.f14665b;
            int iHashCode2 = (this.f14667d.hashCode() + ((this.f14666c.hashCode() + ((iHashCode + (f0Var == null ? 0 : f0Var.hashCode())) * 31)) * 31)) * 31;
            boolean z10 = this.f14668e;
            ?? r10 = z10;
            if (z10) {
                r10 = 1;
            }
            return this.f14669f.hashCode() + ((iHashCode2 + r10) * 31);
        }

        @os.l
        public String toString() {
            return "MethodSignatureData(returnType=" + this.f14664a + ", receiverType=" + this.f14665b + ", valueParameters=" + this.f14666c + ", typeParameters=" + this.f14667d + ", hasStableParameterNames=" + this.f14668e + ", errors=" + this.f14669f + ')';
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final List<h1> f14670a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f14671b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@os.l List<? extends h1> list, boolean z10) {
            l0.p(list, "descriptors");
            this.f14670a = list;
            this.f14671b = z10;
        }

        @os.l
        public final List<h1> a() {
            return this.f14670a;
        }

        public final boolean b() {
            return this.f14671b;
        }
    }

    public static final class c extends n0 implements jn.a<Collection<? extends eo.m>> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Collection<? extends eo.m> invoke() {
            j jVar = j.this;
            op.d dVar = op.d.f12380o;
            op.h.f12403a.getClass();
            return jVar.n(dVar, op.h.a.f12405b);
        }
    }

    public static final class d extends n0 implements jn.a<Set<? extends dp.f>> {
        public d() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Set<? extends dp.f> invoke() {
            return j.this.m(op.d.f12385t, null);
        }
    }

    public static final class e extends n0 implements jn.l<dp.f, t0> {
        public e() {
            super(1);
        }

        @Override // jn.l
        @os.m
        public final t0 invoke(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            j jVar = j.this;
            j jVar2 = jVar.f14654c;
            if (jVar2 != null) {
                return jVar2.f14658g.invoke(fVar);
            }
            n nVarB = jVar.f14656e.invoke().b(fVar);
            if (nVarB == null || nVarB.G()) {
                return null;
            }
            return j.this.K(nVarB);
        }
    }

    public static final class f extends n0 implements jn.l<dp.f, Collection<? extends y0>> {
        public f() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            j jVar = j.this.f14654c;
            if (jVar != null) {
                return jVar.f14657f.invoke(fVar);
            }
            ArrayList arrayList = new ArrayList();
            for (r rVar : j.this.f14656e.invoke().a(fVar)) {
                po.e eVarJ = j.this.J(rVar);
                if (j.this.H(eVarJ)) {
                    j.this.f14653b.f14088a.f14061g.b(rVar, eVarJ);
                    arrayList.add(eVarJ);
                }
            }
            j.this.p(arrayList, fVar);
            return arrayList;
        }
    }

    public static final class g extends n0 implements jn.a<ro.b> {
        public g() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final ro.b invoke() {
            return j.this.q();
        }
    }

    public static final class h extends n0 implements jn.a<Set<? extends dp.f>> {
        public h() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Set<? extends dp.f> invoke() {
            return j.this.o(op.d.f12387v, null);
        }
    }

    public static final class i extends n0 implements jn.l<dp.f, Collection<? extends y0>> {
        public i() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) j.this.f14657f.invoke(fVar));
            j.this.M(linkedHashSet);
            j.this.s(linkedHashSet, fVar);
            qo.h hVar = j.this.f14653b;
            return h0.V5(hVar.f14088a.f14072r.e(hVar, linkedHashSet));
        }
    }

    /* JADX INFO: renamed from: ro.j$j, reason: collision with other inner class name */
    public static final class C0362j extends n0 implements jn.l<dp.f, List<? extends t0>> {
        public C0362j() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final List<t0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            ArrayList arrayList = new ArrayList();
            eq.a.a(arrayList, j.this.f14658g.invoke(fVar));
            j.this.t(fVar, arrayList);
            if (hp.d.t(j.this.D())) {
                return h0.V5(arrayList);
            }
            qo.h hVar = j.this.f14653b;
            return h0.V5(hVar.f14088a.f14072r.e(hVar, arrayList));
        }
    }

    public static final class k extends n0 implements jn.a<Set<? extends dp.f>> {
        public k() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Set<? extends dp.f> invoke() {
            return j.this.u(op.d.f12388w, null);
        }
    }

    public static final class l extends n0 implements jn.a<jp.g<?>> {
        final /* synthetic */ n $field;
        final /* synthetic */ c0 $propertyDescriptor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(n nVar, c0 c0Var) {
            super(0);
            this.$field = nVar;
            this.$propertyDescriptor = c0Var;
        }

        @Override // jn.a
        @os.m
        public final jp.g<?> invoke() {
            return j.this.f14653b.f14088a.f14062h.a(this.$field, this.$propertyDescriptor);
        }
    }

    public static final class m extends n0 implements jn.l<y0, eo.a> {
        public static final m INSTANCE = new m();

        public m() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final eo.a invoke(@os.l y0 y0Var) {
            l0.p(y0Var, "$this$selectMostSpecificInEachOverridableGroup");
            return y0Var;
        }
    }

    static {
        g1 g1Var = new g1(l1.d(j.class), "functionNamesLazy", "getFunctionNamesLazy()Ljava/util/Set;");
        m1 m1Var = l1.f9319a;
        f14652m = new o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(j.class), "propertyNamesLazy", "getPropertyNamesLazy()Ljava/util/Set;")), m1Var.n(new g1(m1Var.d(j.class), "classNamesLazy", "getClassNamesLazy()Ljava/util/Set;"))};
    }

    public j(@os.l qo.h hVar, @os.m j jVar) {
        l0.p(hVar, "c");
        this.f14653b = hVar;
        this.f14654c = jVar;
        this.f14655d = hVar.f14088a.f14055a.i(new c(), k0.INSTANCE);
        this.f14656e = hVar.f14088a.f14055a.h(new g());
        this.f14657f = hVar.f14088a.f14055a.a(new f());
        this.f14658g = hVar.f14088a.f14055a.f(new e());
        this.f14659h = hVar.f14088a.f14055a.a(new i());
        this.f14660i = hVar.f14088a.f14055a.h(new h());
        this.f14661j = hVar.f14088a.f14055a.h(new k());
        this.f14662k = hVar.f14088a.f14055a.h(new d());
        this.f14663l = hVar.f14088a.f14055a.a(new C0362j());
    }

    @os.m
    public abstract w0 A();

    public final Set<dp.f> B() {
        return (Set) up.m.a(this.f14660i, this, f14652m[0]);
    }

    @os.m
    public final j C() {
        return this.f14654c;
    }

    @os.l
    public abstract eo.m D();

    public final Set<dp.f> E() {
        return (Set) up.m.a(this.f14661j, this, f14652m[1]);
    }

    public final f0 F(n nVar) {
        f0 f0VarO = this.f14653b.f14092e.o(nVar.getType(), so.d.d(oo.k.COMMON, false, null, 3, null));
        if ((!ao.h.q0(f0VarO) && !ao.h.t0(f0VarO)) || !G(nVar) || !nVar.L()) {
            return f0VarO;
        }
        f0 f0VarO2 = j1.o(f0VarO);
        l0.o(f0VarO2, "makeNotNullable(propertyType)");
        return f0VarO2;
    }

    public final boolean G(n nVar) {
        return nVar.isFinal() && nVar.k();
    }

    public boolean H(@os.l po.e eVar) {
        l0.p(eVar, "<this>");
        return true;
    }

    @os.l
    public abstract a I(@os.l r rVar, @os.l List<? extends e1> list, @os.l f0 f0Var, @os.l List<? extends h1> list2);

    @os.l
    public final po.e J(@os.l r rVar) {
        w0 w0VarF;
        l0.p(rVar, "method");
        po.e eVarJ1 = po.e.j1(D(), qo.f.a(this.f14653b, rVar), rVar.getName(), this.f14653b.f14088a.f14064j.a(rVar), this.f14656e.invoke().f(rVar.getName()) != null && rVar.h().isEmpty());
        l0.o(eVarJ1, "createJavaMethod(\n      …eters.isEmpty()\n        )");
        qo.h hVarF = qo.a.f(this.f14653b, eVarJ1, rVar, 0, 4, null);
        List<y> typeParameters = rVar.getTypeParameters();
        List<? extends e1> arrayList = new ArrayList<>(z.b0(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            e1 e1VarA = hVarF.f14089b.a((y) it.next());
            l0.m(e1VarA);
            arrayList.add(e1VarA);
        }
        b bVarL = L(hVarF, eVarJ1, rVar.h());
        a aVarI = I(rVar, arrayList, r(rVar, hVarF), bVarL.f14670a);
        f0 f0Var = aVarI.f14665b;
        if (f0Var == null) {
            w0VarF = null;
        } else {
            fo.g.f6167h.getClass();
            w0VarF = hp.c.f(eVarJ1, f0Var, fo.g.a.f6169b);
        }
        eVarJ1.i1(w0VarF, A(), aVarI.f14667d, aVarI.f14666c, aVarI.f14664a, e0.Companion.a(false, rVar.isAbstract(), !rVar.isFinal()), no.h0.c(rVar.getVisibility()), aVarI.f14665b != null ? c1.k(new lm.t0(po.e.X, h0.B2(bVarL.f14670a))) : d1.z());
        eVarJ1.m1(aVarI.f14668e, bVarL.f14671b);
        if (!aVarI.f14669f.isEmpty()) {
            hVarF.f14088a.f14059e.a(eVarJ1, aVarI.f14669f);
        }
        return eVarJ1;
    }

    public final t0 K(n nVar) {
        c0 c0VarV = v(nVar);
        c0VarV.P0(null, null, null, null);
        c0VarV.V0(F(nVar), k0.INSTANCE, A(), null);
        if (hp.d.K(c0VarV, c0VarV.getType())) {
            c0VarV.F0(this.f14653b.f14088a.f14055a.g(new l(nVar, c0VarV)));
        }
        this.f14653b.f14088a.f14061g.a(nVar, c0VarV);
        return c0VarV;
    }

    @os.l
    public final b L(@os.l qo.h hVar, @os.l eo.y yVar, @os.l List<? extends b0> list) {
        lm.t0 t0Var;
        dp.f name;
        qo.h hVar2 = hVar;
        l0.p(hVar2, "c");
        l0.p(yVar, "function");
        l0.p(list, "jValueParameters");
        Iterable<s0> iterableH6 = h0.h6(list);
        ArrayList arrayList = new ArrayList(z.b0(iterableH6, 10));
        boolean z10 = false;
        boolean z11 = false;
        for (s0 s0Var : iterableH6) {
            int i10 = s0Var.f11691a;
            b0 b0Var = (b0) s0Var.f11692b;
            fo.g gVarA = qo.f.a(hVar2, b0Var);
            so.a aVarD = so.d.d(oo.k.COMMON, z10, null, 3, null);
            if (b0Var.b()) {
                x type = b0Var.getType();
                uo.f fVar = type instanceof uo.f ? (uo.f) type : null;
                if (fVar == null) {
                    throw new AssertionError(l0.C("Vararg parameter should be an array: ", b0Var));
                }
                f0 f0VarK = hVar2.f14092e.k(fVar, aVarD, true);
                t0Var = new lm.t0(f0VarK, hVar2.f14088a.f14069o.n().k(f0VarK));
            } else {
                t0Var = new lm.t0(hVar2.f14092e.o(b0Var.getType(), aVarD), null);
            }
            f0 f0Var = (f0) t0Var.component1();
            f0 f0Var2 = (f0) t0Var.component2();
            if (l0.g(yVar.getName().b(), "equals") && list.size() == 1 && l0.g(hVar2.f14088a.f14069o.n().I(), f0Var)) {
                name = dp.f.k("other");
            } else {
                name = b0Var.getName();
                if (name == null) {
                    z11 = true;
                }
                if (name == null) {
                    name = dp.f.k(l0.C("p", Integer.valueOf(i10)));
                    l0.o(name, "identifier(\"p$index\")");
                }
            }
            boolean z12 = z11;
            dp.f fVar2 = name;
            l0.o(fVar2, "if (function.name.asStri…(\"p$index\")\n            }");
            to.a aVarA = hVar2.f14088a.f14064j.a(b0Var);
            ArrayList arrayList2 = arrayList;
            arrayList2.add(new ho.l0(yVar, null, i10, gVarA, fVar2, f0Var, false, false, false, f0Var2, aVarA));
            arrayList = arrayList2;
            z11 = z12;
            z10 = z10;
            hVar2 = hVar;
        }
        return new b(h0.V5(arrayList), z11);
    }

    public final void M(Set<y0> set) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : set) {
            String strC = u.c((y0) obj, false, false, 2, null);
            Object arrayList = linkedHashMap.get(strC);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strC, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        for (List list : linkedHashMap.values()) {
            if (list.size() != 1) {
                List list2 = list;
                Collection<? extends y0> collectionA = hp.l.a(list2, m.INSTANCE);
                set.removeAll(list2);
                set.addAll(collectionA);
            }
        }
    }

    @Override // op.i, op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return !b().contains(fVar) ? k0.INSTANCE : this.f14659h.invoke(fVar);
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> b() {
        return B();
    }

    @Override // op.i, op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return !d().contains(fVar) ? k0.INSTANCE : this.f14663l.invoke(fVar);
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> d() {
        return E();
    }

    @Override // op.i, op.k
    @os.l
    public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        return this.f14655d.invoke();
    }

    @Override // op.i, op.h
    @os.l
    public Set<dp.f> h() {
        return y();
    }

    @os.l
    public abstract Set<dp.f> m(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar);

    @os.l
    public final List<eo.m> n(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        l0.p(lVar, "nameFilter");
        mo.d dVar2 = mo.d.WHEN_GET_ALL_DESCRIPTORS;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        op.d.f12368c.getClass();
        if (dVar.a(op.d.f12377l)) {
            for (dp.f fVar : m(dVar, lVar)) {
                if (lVar.invoke(fVar).booleanValue()) {
                    eq.a.a(linkedHashSet, f(fVar, dVar2));
                }
            }
        }
        op.d.f12368c.getClass();
        if (dVar.a(op.d.f12374i) && !dVar.f12392a.contains(op.c.a.f12365a)) {
            for (dp.f fVar2 : o(dVar, lVar)) {
                if (lVar.invoke(fVar2).booleanValue()) {
                    linkedHashSet.addAll(a(fVar2, dVar2));
                }
            }
        }
        op.d.f12368c.getClass();
        if (dVar.a(op.d.f12375j) && !dVar.f12392a.contains(op.c.a.f12365a)) {
            for (dp.f fVar3 : u(dVar, lVar)) {
                if (lVar.invoke(fVar3).booleanValue()) {
                    linkedHashSet.addAll(c(fVar3, dVar2));
                }
            }
        }
        return h0.V5(linkedHashSet);
    }

    @os.l
    public abstract Set<dp.f> o(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar);

    public void p(@os.l Collection<y0> collection, @os.l dp.f fVar) {
        l0.p(collection, "result");
        l0.p(fVar, "name");
    }

    @os.l
    public abstract ro.b q();

    @os.l
    public final f0 r(@os.l r rVar, @os.l qo.h hVar) {
        l0.p(rVar, "method");
        l0.p(hVar, "c");
        return hVar.f14092e.o(rVar.getReturnType(), so.d.d(oo.k.COMMON, rVar.M().p(), null, 2, null));
    }

    public abstract void s(@os.l Collection<y0> collection, @os.l dp.f fVar);

    public abstract void t(@os.l dp.f fVar, @os.l Collection<t0> collection);

    @os.l
    public String toString() {
        return l0.C("Lazy scope for ", D());
    }

    @os.l
    public abstract Set<dp.f> u(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar);

    public final c0 v(n nVar) {
        po.f fVarX0 = po.f.X0(D(), qo.f.a(this.f14653b, nVar), e0.FINAL, no.h0.c(nVar.getVisibility()), !nVar.isFinal(), nVar.getName(), this.f14653b.f14088a.f14064j.a(nVar), G(nVar));
        l0.o(fVarX0, "create(\n            owne…d.isFinalStatic\n        )");
        return fVarX0;
    }

    @os.l
    public final up.i<Collection<eo.m>> w() {
        return this.f14655d;
    }

    @os.l
    public final qo.h x() {
        return this.f14653b;
    }

    public final Set<dp.f> y() {
        return (Set) up.m.a(this.f14662k, this, f14652m[2]);
    }

    @os.l
    public final up.i<ro.b> z() {
        return this.f14656e;
    }

    public /* synthetic */ j(qo.h hVar, j jVar, int i10, w wVar) {
        this(hVar, (i10 & 2) != 0 ? null : jVar);
    }
}
