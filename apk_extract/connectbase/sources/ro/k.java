package ro;

import eo.t0;
import eo.y0;
import gq.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.n0;
import lm.l2;
import nm.d0;
import nm.h0;
import nm.m0;
import nm.x;
import nm.y;
import nm.z;
import uo.q;
import vp.f0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends l {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final uo.g f14672n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public final f f14673o;

    public static final class a extends n0 implements jn.l<q, Boolean> {
        public static final a INSTANCE = new a();

        public a() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Boolean invoke(@os.l q qVar) {
            l0.p(qVar, "it");
            return Boolean.valueOf(qVar.k());
        }
    }

    public static final class b extends n0 implements jn.l<op.h, Collection<? extends t0>> {
        final /* synthetic */ dp.f $name;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(dp.f fVar) {
            super(1);
            this.$name = fVar;
        }

        @Override // jn.l
        @os.l
        public final Collection<? extends t0> invoke(@os.l op.h hVar) {
            l0.p(hVar, "it");
            return hVar.c(this.$name, mo.d.WHEN_GET_SUPER_MEMBERS);
        }
    }

    public static final class c extends n0 implements jn.l<op.h, Collection<? extends dp.f>> {
        public static final c INSTANCE = new c();

        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final Collection<dp.f> invoke(@os.l op.h hVar) {
            l0.p(hVar, "it");
            return hVar.d();
        }
    }

    public static final class d<N> implements eq.b.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d<N> f14674a = new d<>();

        public static final class a extends n0 implements jn.l<f0, eo.e> {
            public static final a INSTANCE = new a();

            public a() {
                super(1);
            }

            @Override // jn.l
            @os.m
            public final eo.e invoke(f0 f0Var) {
                eo.h hVarD = f0Var.G0().d();
                if (hVarD instanceof eo.e) {
                    return (eo.e) hVarD;
                }
                return null;
            }
        }

        @Override // eq.b.d
        @os.l
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Iterable<eo.e> a(eo.e eVar) {
            Collection<f0> collectionA = eVar.i().a();
            l0.o(collectionA, "it.typeConstructor.supertypes");
            return v.N(v.p1(h0.A1(collectionA), a.INSTANCE));
        }
    }

    public static final class e extends eq.b.AbstractC0107b<eo.e, l2> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ eo.e f14675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Set<R> f14676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ jn.l<op.h, Collection<R>> f14677c;

        /* JADX WARN: Multi-variable type inference failed */
        public e(eo.e eVar, Set<R> set, jn.l<? super op.h, ? extends Collection<? extends R>> lVar) {
            this.f14675a = eVar;
            this.f14676b = set;
            this.f14677c = lVar;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // eq.b.AbstractC0107b, eq.b.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean b(@os.l eo.e eVar) {
            l0.p(eVar, "current");
            if (eVar == this.f14675a) {
                return true;
            }
            op.h hVarK0 = eVar.k0();
            l0.o(hVarK0, "current.staticScope");
            if (!(hVarK0 instanceof l)) {
                return true;
            }
            this.f14676b.addAll((Collection<? extends R>) ((Collection) this.f14677c.invoke(hVarK0)));
            return false;
        }

        public void d() {
        }

        @Override // eq.b.e
        public Object result() {
            return l2.f10208a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@os.l qo.h hVar, @os.l uo.g gVar, @os.l f fVar) {
        super(hVar);
        l0.p(hVar, "c");
        l0.p(gVar, "jClass");
        l0.p(fVar, "ownerDescriptor");
        this.f14672n = gVar;
        this.f14673o = fVar;
    }

    @Override // ro.j
    public eo.m D() {
        return this.f14673o;
    }

    @Override // ro.j
    @os.l
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public ro.a q() {
        return new ro.a(this.f14672n, a.INSTANCE);
    }

    public final <R> Set<R> O(eo.e eVar, Set<R> set, jn.l<? super op.h, ? extends Collection<? extends R>> lVar) {
        eq.b.b(x.k(eVar), d.f14674a, new e(eVar, set, lVar));
        return set;
    }

    @os.l
    public f P() {
        return this.f14673o;
    }

    public final t0 Q(t0 t0Var) {
        if (t0Var.getKind().isReal()) {
            return t0Var;
        }
        Collection<? extends t0> collectionD = t0Var.d();
        l0.o(collectionD, "this.overriddenDescriptors");
        Collection<? extends t0> collection = collectionD;
        ArrayList arrayList = new ArrayList(z.b0(collection, 10));
        for (t0 t0Var2 : collection) {
            l0.o(t0Var2, "it");
            arrayList.add(Q(t0Var2));
        }
        return (t0) h0.h5(h0.a2(arrayList));
    }

    public final Set<y0> R(dp.f fVar, eo.e eVar) {
        k kVarB = po.h.b(eVar);
        return kVarB == null ? m0.INSTANCE : h0.a6(kVarB.a(fVar, mo.d.WHEN_GET_SUPER_MEMBERS));
    }

    @Override // op.i, op.k
    @os.m
    public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
        l0.p(fVar, "name");
        l0.p(bVar, "location");
        return null;
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> m(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        return m0.INSTANCE;
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> o(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        Set<dp.f> setZ5 = h0.Z5(this.f14656e.invoke().c());
        k kVarB = po.h.b(this.f14673o);
        Set<dp.f> setB = kVarB == null ? null : kVarB.B();
        if (setB == null) {
            setB = m0.INSTANCE;
        }
        setZ5.addAll(setB);
        if (this.f14672n.w()) {
            setZ5.addAll(y.O(ao.k.f555c, ao.k.f554b));
        }
        setZ5.addAll(this.f14653b.f14088a.f14078x.a(this.f14673o));
        return setZ5;
    }

    @Override // ro.j
    public void p(@os.l Collection<y0> collection, @os.l dp.f fVar) {
        l0.p(collection, "result");
        l0.p(fVar, "name");
        this.f14653b.f14088a.f14078x.d(this.f14673o, fVar, collection);
    }

    @Override // ro.j
    public void s(@os.l Collection<y0> collection, @os.l dp.f fVar) {
        l0.p(collection, "result");
        l0.p(fVar, "name");
        Set<y0> setR = R(fVar, this.f14673o);
        f fVar2 = this.f14673o;
        qo.c cVar = this.f14653b.f14088a;
        Collection<? extends y0> collectionE = oo.a.e(fVar, setR, collection, fVar2, cVar.f14060f, cVar.f14075u.a());
        l0.o(collectionE, "resolveOverridesForStati….overridingUtil\n        )");
        collection.addAll(collectionE);
        if (this.f14672n.w()) {
            if (l0.g(fVar, ao.k.f555c)) {
                y0 y0VarD = hp.c.d(this.f14673o);
                l0.o(y0VarD, "createEnumValueOfMethod(ownerDescriptor)");
                collection.add(y0VarD);
            } else if (l0.g(fVar, ao.k.f554b)) {
                y0 y0VarE = hp.c.e(this.f14673o);
                l0.o(y0VarE, "createEnumValuesMethod(ownerDescriptor)");
                collection.add(y0VarE);
            }
        }
    }

    @Override // ro.l, ro.j
    public void t(@os.l dp.f fVar, @os.l Collection<t0> collection) {
        l0.p(fVar, "name");
        l0.p(collection, "result");
        Set setO = O(this.f14673o, new LinkedHashSet(), new b(fVar));
        if (!collection.isEmpty()) {
            f fVar2 = this.f14673o;
            qo.c cVar = this.f14653b.f14088a;
            Collection<? extends t0> collectionE = oo.a.e(fVar, setO, collection, fVar2, cVar.f14060f, cVar.f14075u.a());
            l0.o(collectionE, "resolveOverridesForStati…ingUtil\n                )");
            collection.addAll(collectionE);
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : setO) {
            t0 t0VarQ = Q((t0) obj);
            Object arrayList = linkedHashMap.get(t0VarQ);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(t0VarQ, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Collection collection2 = (Collection) ((Map.Entry) it.next()).getValue();
            f fVar3 = this.f14673o;
            qo.c cVar2 = this.f14653b.f14088a;
            Collection collectionE2 = oo.a.e(fVar, collection2, collection, fVar3, cVar2.f14060f, cVar2.f14075u.a());
            l0.o(collectionE2, "resolveOverridesForStati…ingUtil\n                )");
            d0.r0(arrayList2, collectionE2);
        }
        collection.addAll(arrayList2);
    }

    @Override // ro.j
    @os.l
    public Set<dp.f> u(@os.l op.d dVar, @os.m jn.l<? super dp.f, Boolean> lVar) {
        l0.p(dVar, "kindFilter");
        Set<dp.f> setZ5 = h0.Z5(this.f14656e.invoke().e());
        O(this.f14673o, setZ5, c.INSTANCE);
        return setZ5;
    }
}
