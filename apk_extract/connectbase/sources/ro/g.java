package ro;

import eo.e0;
import eo.e1;
import eo.h1;
import eo.t;
import eo.t0;
import eo.u0;
import eo.w0;
import eo.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.g0;
import kn.l0;
import kn.l1;
import kn.n0;
import kn.w;
import nm.c1;
import nm.d0;
import nm.h0;
import nm.k0;
import nm.p1;
import nm.x;
import nm.y;
import nm.z;
import no.o;
import no.s;
import uo.n;
import uo.q;
import uo.r;
import vp.f0;
import vp.j1;
import wo.u;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends ro.j {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final eo.e f14627n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public final uo.g f14628o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f14629p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public final up.i<List<eo.d>> f14630q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public final up.i<Set<dp.f>> f14631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public final up.i<Map<dp.f, n>> f14632s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public final up.h<dp.f, ho.g> f14633t;

    public static final class a extends n0 implements jn.l<q, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l q qVar) {
            l0.p(qVar, "it");
            return Boolean.valueOf(!qVar.k());
        }
    }

    public /* synthetic */ class b extends g0 implements jn.l<dp.f, Collection<? extends y0>> {
        public b(Object obj) {
            super(1, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "searchMethodsByNameWithoutBuiltinMagic";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(g.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "searchMethodsByNameWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "p0");
            return ((g) this.receiver).I0(fVar);
        }
    }

    public /* synthetic */ class c extends g0 implements jn.l<dp.f, Collection<? extends y0>> {
        public c(Object obj) {
            super(1, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(g.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "searchMethodsInSupertypesWithoutBuiltinMagic(Lorg/jetbrains/kotlin/name/Name;)Ljava/util/Collection;";
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "p0");
            return ((g) this.receiver).J0(fVar);
        }
    }

    public static final class d extends n0 implements jn.l<dp.f, Collection<? extends y0>> {
        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "it");
            return g.this.I0(fVar);
        }
    }

    public static final class e extends n0 implements jn.l<dp.f, Collection<? extends y0>> {
        public e() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "it");
            return g.this.J0(fVar);
        }
    }

    public static final class f extends n0 implements jn.a<List<? extends eo.d>> {
        final /* synthetic */ qo.h $c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(qo.h hVar) {
            super(0);
            this.$c = hVar;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // jn.a
        @os.l
        public final List<? extends eo.d> invoke() {
            Collection<uo.k> collectionG = g.this.f14628o.g();
            ArrayList arrayList = new ArrayList(collectionG.size());
            Iterator<uo.k> it = collectionG.iterator();
            while (it.hasNext()) {
                arrayList.add(g.this.G0(it.next()));
            }
            if (g.this.f14628o.r()) {
                eo.d dVarF0 = g.this.f0();
                String strC = u.c(dVarF0, false, false, 2, null);
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    do {
                        if (!it2.hasNext()) {
                            arrayList.add(dVarF0);
                            this.$c.f14088a.f14061g.e(g.this.f14628o, dVarF0);
                            break;
                        }
                    } while (!l0.g(u.c((eo.d) it2.next(), false, false, 2, null), strC));
                } else {
                    arrayList.add(dVarF0);
                    this.$c.f14088a.f14061g.e(g.this.f14628o, dVarF0);
                    break;
                }
            }
            this.$c.f14088a.f14078x.c(g.this.f14627n, arrayList);
            qo.h hVar = this.$c;
            vo.k kVar = hVar.f14088a.f14072r;
            g gVar = g.this;
            boolean zIsEmpty = arrayList.isEmpty();
            List listP = arrayList;
            if (zIsEmpty) {
                listP = y.P(gVar.e0());
            }
            return h0.V5(kVar.e(hVar, listP));
        }
    }

    /* JADX INFO: renamed from: ro.g$g, reason: collision with other inner class name */
    public static final class C0360g extends n0 implements jn.a<Map<dp.f, ? extends n>> {
        public C0360g() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Map<dp.f, ? extends n> invoke() {
            Collection<n> fields = g.this.f14628o.getFields();
            ArrayList arrayList = new ArrayList();
            for (Object obj : fields) {
                if (((n) obj).G()) {
                    arrayList.add(obj);
                }
            }
            int iJ = c1.j(z.b0(arrayList, 10));
            if (iJ < 16) {
                iJ = 16;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(iJ);
            for (Object obj2 : arrayList) {
                linkedHashMap.put(((n) obj2).getName(), obj2);
            }
            return linkedHashMap;
        }
    }

    public static final class h extends n0 implements jn.l<dp.f, Collection<? extends y0>> {
        final /* synthetic */ y0 $function;
        final /* synthetic */ g this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(y0 y0Var, g gVar) {
            super(1);
            this.$function = y0Var;
            this.this$0 = gVar;
        }

        @Override // jn.l
        @os.l
        public final Collection<y0> invoke(@os.l dp.f fVar) {
            l0.p(fVar, "accessorName");
            return l0.g(this.$function.getName(), fVar) ? x.k(this.$function) : h0.E4(this.this$0.I0(fVar), this.this$0.J0(fVar));
        }
    }

    public static final class i extends n0 implements jn.a<Set<? extends dp.f>> {
        public i() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Set<? extends dp.f> invoke() {
            return h0.a6(g.this.f14628o.z());
        }
    }

    public static final class j extends n0 implements jn.l<dp.f, ho.g> {
        final /* synthetic */ qo.h $c;

        public static final class a extends n0 implements jn.a<Set<? extends dp.f>> {
            final /* synthetic */ g this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(g gVar) {
                super(0);
                this.this$0 = gVar;
            }

            @Override // jn.a
            @os.l
            public final Set<? extends dp.f> invoke() {
                return p1.D(this.this$0.B(), this.this$0.E());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(qo.h hVar) {
            super(1);
            this.$c = hVar;
        }

        @Override // jn.l
        @os.m
        public final ho.g invoke(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            if (!((Set) g.this.f14631r.invoke()).contains(fVar)) {
                n nVar = g.this.f14632s.invoke().get(fVar);
                if (nVar == null) {
                    return null;
                }
                up.i iVarH = this.$c.f14088a.f14055a.h(new a(g.this));
                qo.h hVar = this.$c;
                return ho.n.F0(hVar.f14088a.f14055a, g.this.f14627n, fVar, iVarH, qo.f.a(hVar, nVar), this.$c.f14088a.f14064j.a(nVar));
            }
            o oVar = this.$c.f14088a.f14056b;
            dp.b bVarH = lp.a.h(g.this.f14627n);
            l0.m(bVarH);
            dp.b bVarD = bVarH.d(fVar);
            l0.o(bVarD, "ownerDescriptor.classId!…createNestedClassId(name)");
            uo.g gVarA = oVar.a(new o.a(bVarD, null, g.this.f14628o, 2, null));
            if (gVarA == null) {
                return null;
            }
            qo.h hVar2 = this.$c;
            ro.f fVar2 = new ro.f(hVar2, g.this.f14627n, gVarA, null, 8, null);
            hVar2.f14088a.f14073s.a(fVar2);
            return fVar2;
        }
    }

    public /* synthetic */ g(qo.h hVar, eo.e eVar, uo.g gVar, boolean z10, g gVar2, int i10, w wVar) {
        this(hVar, eVar, gVar, z10, (i10 & 16) != 0 ? null : gVar2);
    }

    public static /* synthetic */ po.f k0(g gVar, r rVar, f0 f0Var, e0 e0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f0Var = null;
        }
        return gVar.j0(rVar, f0Var, e0Var);
    }

    @Override // ro.j
    @os.m
    public w0 A() {
        return hp.d.l(this.f14627n);
    }

    public final Set<t0> A0(dp.f fVar) {
        Collection<f0> collectionC0 = c0();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = collectionC0.iterator();
        while (it.hasNext()) {
            Collection<? extends t0> collectionC = ((f0) it.next()).o().c(fVar, mo.d.WHEN_GET_SUPER_MEMBERS);
            ArrayList arrayList2 = new ArrayList(z.b0(collectionC, 10));
            Iterator<T> it2 = collectionC.iterator();
            while (it2.hasNext()) {
                arrayList2.add((t0) it2.next());
            }
            d0.r0(arrayList, arrayList2);
        }
        return h0.a6(arrayList);
    }

    public final boolean B0(y0 y0Var, eo.y yVar) {
        String strC = u.c(y0Var, false, false, 2, null);
        eo.y yVarA = yVar.a();
        l0.o(yVarA, "builtinWithErasedParameters.original");
        return l0.g(strC, u.c(yVarA, false, false, 2, null)) && !p0(y0Var, yVar);
    }

    public final boolean C0(y0 y0Var) {
        dp.f name = y0Var.getName();
        l0.o(name, "function.name");
        List<dp.f> listA = no.d0.a(name);
        if (!(listA instanceof Collection) || !listA.isEmpty()) {
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                Set<t0> setA0 = A0((dp.f) it.next());
                if (setA0 == null || !setA0.isEmpty()) {
                    for (t0 t0Var : setA0) {
                        if (o0(t0Var, new h(y0Var, this))) {
                            if (!t0Var.Q()) {
                                String strB = y0Var.getName().b();
                                l0.o(strB, "function.name.asString()");
                                if (!no.y.d(strB)) {
                                }
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return (q0(y0Var) || K0(y0Var) || s0(y0Var)) ? false : true;
    }

    @Override // ro.j
    public eo.m D() {
        return this.f14627n;
    }

    public final y0 D0(y0 y0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar, Collection<? extends y0> collection) {
        y0 y0VarH0;
        eo.y yVarK = no.f.k(y0Var);
        if (yVarK == null || (y0VarH0 = h0(yVarK, lVar)) == null) {
            return null;
        }
        if (!C0(y0VarH0)) {
            y0VarH0 = null;
        }
        if (y0VarH0 == null) {
            return null;
        }
        return g0(y0VarH0, yVarK, collection);
    }

    public final y0 E0(y0 y0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar, dp.f fVar, Collection<? extends y0> collection) {
        y0 y0Var2 = (y0) no.f0.d(y0Var);
        if (y0Var2 == null) {
            return null;
        }
        String strB = no.f0.b(y0Var2);
        l0.m(strB);
        dp.f fVarK = dp.f.k(strB);
        l0.o(fVarK, "identifier(nameInJava)");
        Iterator<? extends y0> it = lVar.invoke(fVarK).iterator();
        while (it.hasNext()) {
            y0 y0VarM0 = m0(it.next(), fVar);
            if (r0(y0Var2, y0VarM0)) {
                return g0(y0VarM0, y0Var2, collection);
            }
        }
        return null;
    }

    public final y0 F0(y0 y0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        if (!y0Var.isSuspend()) {
            return null;
        }
        dp.f name = y0Var.getName();
        l0.o(name, "descriptor.name");
        Iterator<T> it = lVar.invoke(name).iterator();
        while (it.hasNext()) {
            y0 y0VarN0 = n0((y0) it.next());
            if (y0VarN0 == null || !p0(y0VarN0, y0Var)) {
                y0VarN0 = null;
            }
            if (y0VarN0 != null) {
                return y0VarN0;
            }
        }
        return null;
    }

    public final po.b G0(uo.k kVar) {
        eo.e eVar = this.f14627n;
        po.b bVarM1 = po.b.m1(eVar, qo.f.a(this.f14653b, kVar), false, this.f14653b.f14088a.f14064j.a(kVar));
        l0.o(bVarM1, "createJavaConstructor(\n …ce(constructor)\n        )");
        qo.h hVarE = qo.a.e(this.f14653b, bVarM1, kVar, eVar.r().size());
        ro.j.b bVarL = L(hVarE, bVarM1, kVar.h());
        List<e1> listR = eVar.r();
        l0.o(listR, "classDescriptor.declaredTypeParameters");
        List<e1> list = listR;
        List<uo.y> typeParameters = kVar.getTypeParameters();
        ArrayList arrayList = new ArrayList(z.b0(typeParameters, 10));
        Iterator<T> it = typeParameters.iterator();
        while (it.hasNext()) {
            e1 e1VarA = hVarE.f14089b.a((uo.y) it.next());
            l0.m(e1VarA);
            arrayList.add(e1VarA);
        }
        bVarM1.k1(bVarL.f14670a, no.h0.c(kVar.getVisibility()), h0.E4(list, arrayList));
        bVarM1.S0(false);
        bVarM1.T0(bVarL.f14671b);
        bVarM1.a1(eVar.q());
        hVarE.f14088a.f14061g.e(kVar, bVarM1);
        return bVarM1;
    }

    @Override // ro.j
    public boolean H(@os.l po.e eVar) {
        l0.p(eVar, "<this>");
        if (this.f14628o.p()) {
            return false;
        }
        return C0(eVar);
    }

    public final po.e H0(uo.w wVar) {
        po.e eVarJ1 = po.e.j1(this.f14627n, qo.f.a(this.f14653b, wVar), wVar.getName(), this.f14653b.f14088a.f14064j.a(wVar), true);
        l0.o(eVarJ1, "createJavaMethod(\n      …omponent), true\n        )");
        f0 f0VarO = this.f14653b.f14092e.o(wVar.getType(), so.d.d(oo.k.COMMON, false, null, 2, null));
        w0 w0VarL = hp.d.l(this.f14627n);
        k0 k0Var = k0.INSTANCE;
        eVarJ1.i1(null, w0VarL, k0Var, k0Var, f0VarO, e0.Companion.a(false, false, true), t.f4633e, null);
        eVarJ1.m1(false, false);
        this.f14653b.f14088a.f14061g.b(wVar, eVarJ1);
        return eVarJ1;
    }

    @Override // ro.j
    @os.l
    public ro.j.a I(@os.l r rVar, @os.l List<? extends e1> list, @os.l f0 f0Var, @os.l List<? extends h1> list2) {
        l0.p(rVar, "method");
        l0.p(list, "methodTypeParameters");
        l0.p(f0Var, "returnType");
        l0.p(list2, "valueParameters");
        oo.j.b bVarB = this.f14653b.f14088a.f14059e.b(rVar, this.f14627n, f0Var, null, list2, list);
        l0.o(bVarB, "c.components.signaturePr…dTypeParameters\n        )");
        f0 f0VarD = bVarB.d();
        l0.o(f0VarD, "propagated.returnType");
        f0 f0VarC = bVarB.c();
        List<h1> listF = bVarB.f();
        l0.o(listF, "propagated.valueParameters");
        List<e1> listE = bVarB.e();
        l0.o(listE, "propagated.typeParameters");
        boolean zG = bVarB.g();
        List<String> listB = bVarB.b();
        l0.o(listB, "propagated.errors");
        return new ro.j.a(f0VarD, f0VarC, listF, listE, zG, listB);
    }

    public final Collection<y0> I0(dp.f fVar) {
        Collection<r> collectionA = this.f14656e.invoke().a(fVar);
        ArrayList arrayList = new ArrayList(z.b0(collectionA, 10));
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            arrayList.add(J((r) it.next()));
        }
        return arrayList;
    }

    public final Collection<y0> J0(dp.f fVar) {
        Set<y0> setY0 = y0(fVar);
        ArrayList arrayList = new ArrayList();
        for (Object obj : setY0) {
            y0 y0Var = (y0) obj;
            if (!no.f0.a(y0Var) && no.f.k(y0Var) == null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean K0(y0 y0Var) {
        no.f fVar = no.f.f11736n;
        dp.f name = y0Var.getName();
        l0.o(name, "name");
        if (!fVar.l(name)) {
            return false;
        }
        dp.f name2 = y0Var.getName();
        l0.o(name2, "name");
        Set<y0> setY0 = y0(name2);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setY0.iterator();
        while (it.hasNext()) {
            eo.y yVarK = no.f.k((y0) it.next());
            if (yVarK != null) {
                arrayList.add(yVarK);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (B0(y0Var, (eo.y) it2.next())) {
                return true;
            }
        }
        return false;
    }

    public final void V(List<h1> list, eo.l lVar, int i10, r rVar, f0 f0Var, f0 f0Var2) {
        fo.g.f6167h.getClass();
        fo.g gVar = fo.g.a.f6169b;
        dp.f name = rVar.getName();
        f0 f0VarO = j1.o(f0Var);
        l0.o(f0VarO, "makeNotNullable(returnType)");
        list.add(new ho.l0(lVar, null, i10, gVar, name, f0VarO, rVar.K(), false, false, f0Var2 == null ? null : j1.o(f0Var2), this.f14653b.f14088a.f14064j.a(rVar)));
    }

    public final void W(Collection<y0> collection, dp.f fVar, Collection<? extends y0> collection2, boolean z10) {
        eo.e eVar = this.f14627n;
        qo.c cVar = this.f14653b.f14088a;
        Collection<? extends y0> collectionD = oo.a.d(fVar, collection2, collection, eVar, cVar.f14060f, cVar.f14075u.a());
        l0.o(collectionD, "resolveOverridesForNonSt….overridingUtil\n        )");
        if (!z10) {
            collection.addAll(collectionD);
            return;
        }
        Collection<? extends y0> collection3 = collectionD;
        List listE4 = h0.E4(collection, collection3);
        ArrayList arrayList = new ArrayList(z.b0(collection3, 10));
        for (y0 y0VarG0 : collection3) {
            y0 y0Var = (y0) no.f0.e(y0VarG0);
            if (y0Var == null) {
                l0.o(y0VarG0, "resolvedOverride");
            } else {
                l0.o(y0VarG0, "resolvedOverride");
                y0VarG0 = g0(y0VarG0, y0Var, listE4);
            }
            arrayList.add(y0VarG0);
        }
        collection.addAll(arrayList);
    }

    public final void X(dp.f fVar, Collection<? extends y0> collection, Collection<? extends y0> collection2, Collection<y0> collection3, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        for (y0 y0Var : collection2) {
            eq.a.a(collection3, E0(y0Var, lVar, fVar, collection));
            eq.a.a(collection3, D0(y0Var, lVar, collection));
            eq.a.a(collection3, F0(y0Var, lVar));
        }
    }

    public final void Y(Set<? extends t0> set, Collection<t0> collection, Set<t0> set2, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        for (t0 t0Var : set) {
            po.f fVarI0 = i0(t0Var, lVar);
            if (fVarI0 != null) {
                collection.add(fVarI0);
                if (set2 == null) {
                    return;
                }
                set2.add(t0Var);
                return;
            }
        }
    }

    public final void Z(dp.f fVar, Collection<t0> collection) {
        r rVar = (r) h0.i5(this.f14656e.invoke().a(fVar));
        if (rVar == null) {
            return;
        }
        collection.add(k0(this, rVar, null, e0.FINAL, 2, null));
    }

    @Override // ro.j, op.i, op.h, op.k
    @os.l
    public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        return super.a(fVar, bVar);
    }

    @Override // ro.j
    @os.l
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public LinkedHashSet<dp.f> o(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        Collection<f0> collectionA = this.f14627n.i().a();
        l0.o(collectionA, "ownerDescriptor.typeConstructor.supertypes");
        LinkedHashSet<dp.f> linkedHashSet = new LinkedHashSet<>();
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            d0.r0(linkedHashSet, ((f0) it.next()).o().b());
        }
        linkedHashSet.addAll(this.f14656e.invoke().c());
        linkedHashSet.addAll(this.f14656e.invoke().d());
        linkedHashSet.addAll(m(dVar, lVar));
        linkedHashSet.addAll(this.f14653b.f14088a.f14078x.e(this.f14627n));
        return linkedHashSet;
    }

    @Override // ro.j
    @os.l
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public ro.a q() {
        return new ro.a(this.f14628o, a.INSTANCE);
    }

    @Override // ro.j, op.i, op.h
    @os.l
    public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        return super.c(fVar, bVar);
    }

    public final Collection<f0> c0() {
        if (!this.f14629p) {
            return this.f14653b.f14088a.f14075u.d().g(this.f14627n);
        }
        Collection<f0> collectionA = this.f14627n.i().a();
        l0.o(collectionA, "ownerDescriptor.typeConstructor.supertypes");
        return collectionA;
    }

    public final List<h1> d0(ho.f fVar) {
        lm.t0 t0Var;
        Collection<r> collectionA = this.f14628o.A();
        ArrayList arrayList = new ArrayList(collectionA.size());
        so.a aVarD = so.d.d(oo.k.COMMON, true, null, 2, null);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : collectionA) {
            if (l0.g(((r) obj).getName(), no.z.f11802c)) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        lm.t0 t0Var2 = new lm.t0(arrayList2, arrayList3);
        List list = (List) t0Var2.component1();
        List<r> list2 = (List) t0Var2.component2();
        list.size();
        r rVar = (r) h0.G2(list);
        if (rVar != null) {
            uo.x returnType = rVar.getReturnType();
            if (returnType instanceof uo.f) {
                uo.f fVar2 = (uo.f) returnType;
                t0Var = new lm.t0(this.f14653b.f14092e.k(fVar2, aVarD, true), this.f14653b.f14092e.o(fVar2.o(), aVarD));
            } else {
                t0Var = new lm.t0(this.f14653b.f14092e.o(returnType, aVarD), null);
            }
            V(arrayList, fVar, 0, rVar, (f0) t0Var.component1(), (f0) t0Var.component2());
        }
        int i10 = 0;
        int i11 = rVar == null ? 0 : 1;
        for (r rVar2 : list2) {
            V(arrayList, fVar, i10 + i11, rVar2, this.f14653b.f14092e.o(rVar2.getReturnType(), aVarD), null);
            i10++;
        }
        return arrayList;
    }

    public final eo.d e0() {
        boolean zP = this.f14628o.p();
        if ((this.f14628o.H() || !this.f14628o.s()) && !zP) {
            return null;
        }
        eo.e eVar = this.f14627n;
        fo.g.f6167h.getClass();
        po.b bVarM1 = po.b.m1(eVar, fo.g.a.f6169b, true, this.f14653b.f14088a.f14064j.a(this.f14628o));
        l0.o(bVarM1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<h1> listD0 = zP ? d0(bVarM1) : Collections.emptyList();
        bVarM1.T0(false);
        bVarM1.j1(listD0, w0(eVar));
        bVarM1.S0(true);
        bVarM1.a1(eVar.q());
        this.f14653b.f14088a.f14061g.e(this.f14628o, bVarM1);
        return bVarM1;
    }

    @Override // op.i, op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        g(fVar, bVar);
        g gVar = (g) this.f14654c;
        ho.g gVarInvoke = gVar == null ? null : gVar.f14633t.invoke(fVar);
        return gVarInvoke == null ? this.f14633t.invoke(fVar) : gVarInvoke;
    }

    public final eo.d f0() {
        eo.e eVar = this.f14627n;
        fo.g.f6167h.getClass();
        po.b bVarM1 = po.b.m1(eVar, fo.g.a.f6169b, true, this.f14653b.f14088a.f14064j.a(this.f14628o));
        l0.o(bVarM1, "createJavaConstructor(\n ….source(jClass)\n        )");
        List<h1> listL0 = l0(bVarM1);
        bVarM1.T0(false);
        bVarM1.j1(listL0, w0(eVar));
        bVarM1.S0(false);
        bVarM1.a1(eVar.q());
        return bVarM1;
    }

    @Override // op.i, op.k
    public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        lo.a.a(this.f14653b.f14088a.f14068n, bVar, this.f14627n, fVar);
    }

    public final y0 g0(y0 y0Var, eo.a aVar, Collection<? extends y0> collection) {
        Collection<? extends y0> collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return y0Var;
        }
        for (y0 y0Var2 : collection2) {
            if (!l0.g(y0Var, y0Var2) && y0Var2.q0() == null && p0(y0Var2, aVar)) {
                eo.y yVarBuild = y0Var.w().f().build();
                l0.m(yVarBuild);
                return (y0) yVarBuild;
            }
        }
        return y0Var;
    }

    public final y0 h0(eo.y yVar, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        Object next;
        dp.f name = yVar.getName();
        l0.o(name, "overridden.name");
        Iterator<T> it = lVar.invoke(name).iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!B0((y0) next, yVar));
        y0 y0Var = (y0) next;
        if (y0Var == null) {
            return null;
        }
        eo.y.a<? extends y0> aVarW = y0Var.w();
        List<h1> listH = yVar.h();
        l0.o(listH, "overridden.valueParameters");
        List<h1> list = listH;
        ArrayList arrayList = new ArrayList(z.b0(list, 10));
        for (h1 h1Var : list) {
            f0 type = h1Var.getType();
            l0.o(type, "it.type");
            arrayList.add(new po.i(type, h1Var.w0()));
        }
        List<h1> listH2 = y0Var.h();
        l0.o(listH2, "override.valueParameters");
        aVarW.c(po.h.a(arrayList, listH2, yVar));
        aVarW.t();
        aVarW.i();
        aVarW.h(po.e.Y, Boolean.TRUE);
        return (y0) aVarW.build();
    }

    public final po.f i0(t0 t0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        y0 y0VarV0;
        ho.e0 e0VarJ;
        if (!o0(t0Var, lVar)) {
            return null;
        }
        y0 y0VarU0 = u0(t0Var, lVar);
        l0.m(y0VarU0);
        if (t0Var.Q()) {
            y0VarV0 = v0(t0Var, lVar);
            l0.m(y0VarV0);
        } else {
            y0VarV0 = null;
        }
        if (y0VarV0 != null) {
            y0VarV0.s();
            y0VarU0.s();
        }
        po.d dVar = new po.d(this.f14627n, y0VarU0, y0VarV0, t0Var);
        f0 returnType = y0VarU0.getReturnType();
        l0.m(returnType);
        dVar.V0(returnType, k0.INSTANCE, hp.d.l(this.f14627n), null);
        ho.d0 d0VarH = hp.c.h(dVar, y0VarU0.getAnnotations(), false, false, false, y0VarU0.getSource());
        d0VarH.H0(y0VarU0);
        d0VarH.K0(dVar.getType());
        l0.o(d0VarH, "createGetter(\n          …escriptor.type)\n        }");
        if (y0VarV0 != null) {
            List<h1> listH = y0VarV0.h();
            l0.o(listH, "setterMethod.valueParameters");
            h1 h1Var = (h1) h0.G2(listH);
            if (h1Var == null) {
                throw new AssertionError(l0.C("No parameter found for ", y0VarV0));
            }
            e0VarJ = hp.c.j(dVar, y0VarV0.getAnnotations(), h1Var.getAnnotations(), false, false, false, y0VarV0.getVisibility(), y0VarV0.getSource());
            e0VarJ.H0(y0VarV0);
        } else {
            e0VarJ = null;
        }
        dVar.P0(d0VarH, e0VarJ, null, null);
        return dVar;
    }

    public final po.f j0(r rVar, f0 f0Var, e0 e0Var) {
        po.f fVarX0 = po.f.X0(this.f14627n, qo.f.a(this.f14653b, rVar), e0Var, no.h0.c(rVar.getVisibility()), false, rVar.getName(), this.f14653b.f14088a.f14064j.a(rVar), false);
        l0.o(fVarX0, "create(\n            owne…inal = */ false\n        )");
        fo.g.f6167h.getClass();
        ho.d0 d0VarB = hp.c.b(fVarX0, fo.g.a.f6169b);
        l0.o(d0VarB, "createDefaultGetter(prop…iptor, Annotations.EMPTY)");
        fVarX0.O0(d0VarB, null);
        f0 f0VarR = f0Var == null ? r(rVar, qo.a.f(this.f14653b, fVarX0, rVar, 0, 4, null)) : f0Var;
        fVarX0.V0(f0VarR, k0.INSTANCE, hp.d.l(this.f14627n), null);
        d0VarB.K0(f0VarR);
        return fVarX0;
    }

    public final List<h1> l0(ho.f fVar) {
        Collection<uo.w> collectionM = this.f14628o.m();
        ArrayList arrayList = new ArrayList(collectionM.size());
        f0 f0Var = null;
        so.a aVarD = so.d.d(oo.k.COMMON, false, null, 2, null);
        int i10 = 0;
        for (uo.w wVar : collectionM) {
            int i11 = i10 + 1;
            f0 f0VarO = this.f14653b.f14092e.o(wVar.getType(), aVarD);
            f0 f0VarK = wVar.b() ? this.f14653b.f14088a.f14069o.n().k(f0VarO) : f0Var;
            fo.g.f6167h.getClass();
            arrayList.add(new ho.l0(fVar, null, i10, fo.g.a.f6169b, wVar.getName(), f0VarO, false, false, false, f0VarK, this.f14653b.f14088a.f14064j.a(wVar)));
            i10 = i11;
            f0Var = null;
        }
        return arrayList;
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> m(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        return p1.D(this.f14631r.invoke(), this.f14632s.invoke().keySet());
    }

    public final y0 m0(y0 y0Var, dp.f fVar) {
        eo.y.a<? extends y0> aVarW = y0Var.w();
        aVarW.r(fVar);
        aVarW.t();
        aVarW.i();
        eo.y yVarBuild = aVarW.build();
        l0.m(yVarBuild);
        return (y0) yVarBuild;
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0012  */
    /* JADX WARN: Code duplicated, block: B:7:0x0022  */
    public final y0 n0(y0 y0Var) {
        dp.c cVarL;
        List<h1> listH = y0Var.h();
        l0.o(listH, "valueParameters");
        h1 h1Var = (h1) h0.v3(listH);
        if (h1Var != null) {
            eo.h hVarD = h1Var.getType().G0().d();
            if (hVarD == null) {
                cVarL = null;
            } else {
                dp.d dVarJ = lp.a.j(hVarD);
                if (!dVarJ.f()) {
                    dVarJ = null;
                }
                if (dVarJ == null) {
                    cVarL = null;
                } else {
                    cVarL = dVarJ.l();
                }
            }
            if (!l0.g(cVarL, ao.k.f560h)) {
                h1Var = null;
            }
        } else {
            h1Var = null;
        }
        if (h1Var == null) {
            return null;
        }
        eo.y.a<? extends y0> aVarW = y0Var.w();
        List<h1> listH2 = y0Var.h();
        l0.o(listH2, "valueParameters");
        y0 y0Var2 = (y0) aVarW.c(h0.d2(listH2, 1)).q(h1Var.getType().F0().get(0).getType()).build();
        ho.g0 g0Var = (ho.g0) y0Var2;
        if (g0Var != null) {
            g0Var.b1(true);
        }
        return y0Var2;
    }

    public final boolean o0(t0 t0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        if (ro.c.a(t0Var)) {
            return false;
        }
        y0 y0VarU0 = u0(t0Var, lVar);
        y0 y0VarV0 = v0(t0Var, lVar);
        if (y0VarU0 == null) {
            return false;
        }
        if (t0Var.Q()) {
            return y0VarV0 != null && y0VarV0.s() == y0VarU0.s();
        }
        return true;
    }

    @Override // ro.j
    public void p(@os.l Collection<y0> collection, @os.l dp.f fVar) {
        l0.p(collection, "result");
        l0.p(fVar, "name");
        if (this.f14628o.r() && this.f14656e.invoke().f(fVar) != null) {
            Collection<y0> collection2 = collection;
            if (collection2.isEmpty()) {
                uo.w wVarF = this.f14656e.invoke().f(fVar);
                l0.m(wVarF);
                collection.add(H0(wVarF));
            } else {
                Iterator<T> it = collection2.iterator();
                while (it.hasNext()) {
                    if (((y0) it.next()).h().isEmpty()) {
                    }
                }
                uo.w wVarF2 = this.f14656e.invoke().f(fVar);
                l0.m(wVarF2);
                collection.add(H0(wVarF2));
            }
        }
        this.f14653b.f14088a.f14078x.b(this.f14627n, fVar, collection);
    }

    public final boolean p0(eo.a aVar, eo.a aVar2) {
        hp.j.i.a aVarC = hp.j.f7490d.G(aVar2, aVar, true).c();
        l0.o(aVarC, "DEFAULT.isOverridableByW…iptor, this, true).result");
        return aVarC == hp.j.i.a.OVERRIDABLE && !s.f11775a.a(aVar2, aVar);
    }

    public final boolean q0(y0 y0Var) {
        no.g0.a aVar = no.g0.f11742a;
        dp.f name = y0Var.getName();
        l0.o(name, "name");
        List<dp.f> listB = aVar.b(name);
        if ((listB instanceof Collection) && listB.isEmpty()) {
            return false;
        }
        for (dp.f fVar : listB) {
            Set<y0> setY0 = y0(fVar);
            ArrayList arrayList = new ArrayList();
            for (Object obj : setY0) {
                if (no.f0.a((y0) obj)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                y0 y0VarM0 = m0(y0Var, fVar);
                if (arrayList.isEmpty()) {
                    continue;
                } else {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (r0((y0) it.next(), y0VarM0)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean r0(y0 y0Var, eo.y yVar) {
        if (no.e.f11734n.k(y0Var)) {
            yVar = yVar.a();
        }
        l0.o(yVar, "if (superDescriptor.isRe…iginal else subDescriptor");
        return p0(yVar, y0Var);
    }

    @Override // ro.j
    public void s(@os.l Collection<y0> collection, @os.l dp.f fVar) {
        l0.p(collection, "result");
        l0.p(fVar, "name");
        Set<y0> setY0 = y0(fVar);
        if (!no.g0.f11742a.k(fVar) && !no.f.f11736n.l(fVar)) {
            if (setY0 == null || !setY0.isEmpty()) {
                Iterator<T> it = setY0.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((eo.y) it.next()).isSuspend()) {
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj : setY0) {
                if (C0((y0) obj)) {
                    arrayList.add(obj);
                }
            }
            W(collection, fVar, arrayList, false);
            return;
        }
        eq.f fVarA = eq.f.f4674c.a();
        Collection<? extends y0> collectionD = oo.a.d(fVar, setY0, k0.INSTANCE, this.f14627n, rp.q.f14766a, this.f14653b.f14088a.f14075u.a());
        l0.o(collectionD, "resolveOverridesForNonSt….overridingUtil\n        )");
        X(fVar, collection, collectionD, collection, new b(this));
        X(fVar, collection, collectionD, fVarA, new c(this));
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : setY0) {
            if (C0((y0) obj2)) {
                arrayList2.add(obj2);
            }
        }
        W(collection, fVar, h0.E4(arrayList2, fVarA), true);
    }

    public final boolean s0(y0 y0Var) {
        y0 y0VarN0 = n0(y0Var);
        if (y0VarN0 == null) {
            return false;
        }
        dp.f name = y0Var.getName();
        l0.o(name, "name");
        Set<y0> setY0 = y0(name);
        if (setY0 != null && setY0.isEmpty()) {
            return false;
        }
        for (y0 y0Var2 : setY0) {
            if (y0Var2.isSuspend() && p0(y0VarN0, y0Var2)) {
                return true;
            }
        }
        return false;
    }

    @Override // ro.j
    public void t(@os.l dp.f fVar, @os.l Collection<t0> collection) {
        l0.p(fVar, "name");
        l0.p(collection, "result");
        if (this.f14628o.p()) {
            Z(fVar, collection);
        }
        Set<t0> setA0 = A0(fVar);
        if (setA0.isEmpty()) {
            return;
        }
        eq.f.b bVar = eq.f.f4674c;
        eq.f fVarA = bVar.a();
        eq.f fVarA2 = bVar.a();
        Y(setA0, collection, fVarA, new d());
        Y(p1.y(setA0, fVarA), fVarA2, null, new e());
        Set setD = p1.D(setA0, fVarA2);
        eo.e eVar = this.f14627n;
        qo.c cVar = this.f14653b.f14088a;
        Collection<? extends t0> collectionD = oo.a.d(fVar, setD, collection, eVar, cVar.f14060f, cVar.f14075u.a());
        l0.o(collectionD, "resolveOverridesForNonSt…rridingUtil\n            )");
        collection.addAll(collectionD);
    }

    public final y0 t0(t0 t0Var, String str, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        y0 y0Var;
        dp.f fVarK = dp.f.k(str);
        l0.o(fVarK, "identifier(getterName)");
        Iterator<T> it = lVar.invoke(fVarK).iterator();
        do {
            y0Var = null;
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var2 = (y0) it.next();
            if (y0Var2.h().size() == 0) {
                wp.e eVar = wp.e.f19851a;
                f0 returnType = y0Var2.getReturnType();
                if (returnType == null ? false : eVar.c(returnType, t0Var.getType())) {
                    y0Var = y0Var2;
                }
            }
        } while (y0Var == null);
        return y0Var;
    }

    @Override // ro.j
    @os.l
    public String toString() {
        return l0.C("Lazy Java member scope for ", this.f14628o.e());
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> u(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        if (this.f14628o.p()) {
            return B();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(this.f14656e.invoke().e());
        Collection<f0> collectionA = this.f14627n.i().a();
        l0.o(collectionA, "ownerDescriptor.typeConstructor.supertypes");
        Iterator<T> it = collectionA.iterator();
        while (it.hasNext()) {
            d0.r0(linkedHashSet, ((f0) it.next()).o().d());
        }
        return linkedHashSet;
    }

    public final y0 u0(t0 t0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        u0 getter = t0Var.getGetter();
        u0 u0Var = getter == null ? null : (u0) no.f0.d(getter);
        String strA = u0Var != null ? no.i.f11759a.a(u0Var) : null;
        if (strA != null && !no.f0.f(this.f14627n, u0Var)) {
            return t0(t0Var, strA, lVar);
        }
        String strB = t0Var.getName().b();
        l0.o(strB, "name.asString()");
        return t0(t0Var, no.y.b(strB), lVar);
    }

    public final y0 v0(t0 t0Var, jn.l<? super dp.f, ? extends Collection<? extends y0>> lVar) {
        y0 y0Var;
        f0 returnType;
        String strB = t0Var.getName().b();
        l0.o(strB, "name.asString()");
        dp.f fVarK = dp.f.k(no.y.e(strB));
        l0.o(fVarK, "identifier(JvmAbi.setterName(name.asString()))");
        Iterator<T> it = lVar.invoke(fVarK).iterator();
        do {
            y0Var = null;
            if (!it.hasNext()) {
                break;
            }
            y0 y0Var2 = (y0) it.next();
            if (y0Var2.h().size() == 1 && (returnType = y0Var2.getReturnType()) != null && ao.h.A0(returnType)) {
                wp.e eVar = wp.e.f19851a;
                List<h1> listH = y0Var2.h();
                l0.o(listH, "descriptor.valueParameters");
                if (eVar.b(((h1) h0.h5(listH)).getType(), t0Var.getType())) {
                    y0Var = y0Var2;
                }
            }
        } while (y0Var == null);
        return y0Var;
    }

    public final eo.u w0(eo.e eVar) {
        eo.u visibility = eVar.getVisibility();
        l0.o(visibility, "classDescriptor.visibility");
        if (!l0.g(visibility, no.r.f11772b)) {
            return visibility;
        }
        eo.u uVar = no.r.f11773c;
        l0.o(uVar, "PROTECTED_AND_PACKAGE");
        return uVar;
    }

    @os.l
    public final up.i<List<eo.d>> x0() {
        return this.f14630q;
    }

    public final Set<y0> y0(dp.f fVar) {
        Collection<f0> collectionC0 = c0();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<T> it = collectionC0.iterator();
        while (it.hasNext()) {
            d0.r0(linkedHashSet, ((f0) it.next()).o().a(fVar, mo.d.WHEN_GET_SUPER_MEMBERS));
        }
        return linkedHashSet;
    }

    @os.l
    public eo.e z0() {
        return this.f14627n;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@os.l qo.h hVar, @os.l eo.e eVar, @os.l uo.g gVar, boolean z10, @os.m g gVar2) {
        super(hVar, gVar2);
        l0.p(hVar, "c");
        l0.p(eVar, "ownerDescriptor");
        l0.p(gVar, "jClass");
        this.f14627n = eVar;
        this.f14628o = gVar;
        this.f14629p = z10;
        this.f14630q = hVar.f14088a.f14055a.h(new f(hVar));
        this.f14631r = hVar.f14088a.f14055a.h(new i());
        this.f14632s = hVar.f14088a.f14055a.h(new C0360g());
        this.f14633t = hVar.f14088a.f14055a.f(new j(hVar));
    }
}
