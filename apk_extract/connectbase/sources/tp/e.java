package tp;

import eo.c1;
import eo.e0;
import eo.e1;
import eo.f1;
import eo.h1;
import eo.j0;
import eo.t0;
import eo.u;
import eo.v;
import eo.x0;
import eo.y0;
import eo.z;
import eo.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kn.g0;
import kn.l0;
import kn.l1;
import nm.d0;
import nm.h0;
import nm.k0;
import nm.p1;
import nm.y;
import rp.a0;
import rp.b0;
import rp.q;
import rp.w;
import rp.x;
import vp.a1;
import vp.f0;
import vp.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends ho.a implements v {

    @os.l
    public final b H;

    @os.l
    public final x0<a> I;

    @os.m
    public final c J;

    @os.l
    public final eo.m K;

    @os.l
    public final up.j<eo.d> L;

    @os.l
    public final up.i<Collection<eo.d>> M;

    @os.l
    public final up.j<eo.e> N;

    @os.l
    public final up.i<Collection<eo.e>> O;

    @os.l
    public final up.j<z<n0>> P;

    @os.l
    public final rp.z.a Q;

    @os.l
    public final fo.g R;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final yo.a.c f15956g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final ap.a f15957i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final z0 f15958n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final dp.b f15959p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final e0 f15960v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final u f15961w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final eo.f f15962x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @os.l
    public final rp.l f15963y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @os.l
    public final op.i f15964z;

    public final class a extends tp.i {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @os.l
        public final wp.g f15965g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @os.l
        public final up.i<Collection<eo.m>> f15966h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @os.l
        public final up.i<Collection<f0>> f15967i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ e f15968j;

        /* JADX INFO: renamed from: tp.e$a$a, reason: collision with other inner class name */
        public static final class C0411a extends kn.n0 implements jn.a<List<? extends dp.f>> {
            final /* synthetic */ List<dp.f> $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0411a(List<dp.f> list) {
                super(0);
                this.$it = list;
            }

            @Override // jn.a
            @os.l
            public final List<? extends dp.f> invoke() {
                return this.$it;
            }
        }

        public static final class b extends kn.n0 implements jn.a<Collection<? extends eo.m>> {
            public b() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final Collection<? extends eo.m> invoke() {
                a aVar = a.this;
                op.d dVar = op.d.f12380o;
                op.h.f12403a.getClass();
                return aVar.l(dVar, op.h.a.f12405b, mo.d.WHEN_GET_ALL_DESCRIPTORS);
            }
        }

        public static final class c extends hp.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ List<D> f15969a;

            public c(List<D> list) {
                this.f15969a = list;
            }

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            @Override // hp.i
            public void a(@os.l eo.b bVar) {
                l0.p(bVar, "fakeOverride");
                hp.j.L(bVar, null);
                this.f15969a.add((D) bVar);
            }

            @Override // hp.h
            public void e(@os.l eo.b bVar, @os.l eo.b bVar2) {
                l0.p(bVar, "fromSuper");
                l0.p(bVar2, "fromCurrent");
            }
        }

        public static final class d extends kn.n0 implements jn.a<Collection<? extends f0>> {
            public d() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final Collection<? extends f0> invoke() {
                return a.this.f15965g.g(a.this.f15968j);
            }
        }

        public a(@os.l e eVar, wp.g gVar) {
            l0.p(eVar, "this$0");
            l0.p(gVar, "kotlinTypeRefiner");
            this.f15968j = eVar;
            rp.l lVar = eVar.f15963y;
            List<yo.a.i> functionList = eVar.f15956g.getFunctionList();
            l0.o(functionList, "classProto.functionList");
            List<yo.a.n> propertyList = eVar.f15956g.getPropertyList();
            l0.o(propertyList, "classProto.propertyList");
            List<yo.a.r> typeAliasList = eVar.f15956g.getTypeAliasList();
            l0.o(typeAliasList, "classProto.typeAliasList");
            List<Integer> nestedClassNameList = eVar.f15956g.getNestedClassNameList();
            l0.o(nestedClassNameList, "classProto.nestedClassNameList");
            List<Integer> list = nestedClassNameList;
            ap.c cVar = eVar.f15963y.f14749b;
            ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(x.b(cVar, ((Number) it.next()).intValue()));
            }
            super(lVar, functionList, propertyList, typeAliasList, new C0411a(arrayList));
            this.f15965g = gVar;
            this.f15966h = this.f15978b.f14748a.f14727a.h(new b());
            this.f15967i = this.f15978b.f14748a.f14727a.h(new d());
        }

        public static final e A(a aVar) {
            return aVar.f15968j;
        }

        public final <D extends eo.b> void C(dp.f fVar, Collection<? extends D> collection, List<D> list) {
            this.f15978b.f14748a.f14743q.a().w(fVar, collection, new ArrayList(list), this.f15968j, new c(list));
        }

        public final e D() {
            return this.f15968j;
        }

        @Override // tp.i, op.i, op.h, op.k
        @os.l
        public Collection<y0> a(@os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            g(fVar, bVar);
            return super.a(fVar, bVar);
        }

        @Override // tp.i, op.i, op.h
        @os.l
        public Collection<t0> c(@os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            g(fVar, bVar);
            return super.c(fVar, bVar);
        }

        @Override // op.i, op.k
        @os.l
        public Collection<eo.m> e(@os.l op.d dVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
            l0.p(dVar, "kindFilter");
            l0.p(lVar, "nameFilter");
            return this.f15966h.invoke();
        }

        @Override // tp.i, op.i, op.k
        @os.m
        public eo.h f(@os.l dp.f fVar, @os.l mo.b bVar) {
            eo.e eVarF;
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            g(fVar, bVar);
            c cVar = this.f15968j.J;
            return (cVar == null || (eVarF = cVar.f(fVar)) == null) ? super.f(fVar, bVar) : eVarF;
        }

        @Override // op.i, op.k
        public void g(@os.l dp.f fVar, @os.l mo.b bVar) {
            l0.p(fVar, "name");
            l0.p(bVar, "location");
            lo.a.a(this.f15978b.f14748a.f14735i, bVar, this.f15968j, fVar);
        }

        @Override // tp.i
        public void k(@os.l Collection<eo.m> collection, @os.l jn.l<? super dp.f, Boolean> lVar) {
            l0.p(collection, "result");
            l0.p(lVar, "nameFilter");
            c cVar = this.f15968j.J;
            Collection<eo.e> collectionD = cVar == null ? null : cVar.d();
            if (collectionD == null) {
                collectionD = k0.INSTANCE;
            }
            collection.addAll(collectionD);
        }

        @Override // tp.i
        public void m(@os.l dp.f fVar, @os.l List<y0> list) {
            l0.p(fVar, "name");
            l0.p(list, "functions");
            ArrayList arrayList = new ArrayList();
            Iterator<f0> it = this.f15967i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().o().a(fVar, mo.d.FOR_ALREADY_TRACKED));
            }
            list.addAll(this.f15978b.f14748a.f14740n.b(fVar, this.f15968j));
            C(fVar, arrayList, list);
        }

        @Override // tp.i
        public void n(@os.l dp.f fVar, @os.l List<t0> list) {
            l0.p(fVar, "name");
            l0.p(list, "descriptors");
            ArrayList arrayList = new ArrayList();
            Iterator<f0> it = this.f15967i.invoke().iterator();
            while (it.hasNext()) {
                arrayList.addAll(it.next().o().c(fVar, mo.d.FOR_ALREADY_TRACKED));
            }
            C(fVar, arrayList, list);
        }

        @Override // tp.i
        @os.l
        public dp.b o(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            dp.b bVarD = this.f15968j.f15959p.d(fVar);
            l0.o(bVarD, "classId.createNestedClassId(name)");
            return bVarD;
        }

        @Override // tp.i
        @os.m
        public Set<dp.f> u() {
            List<f0> listA = this.f15968j.H.a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                Set<dp.f> setH = ((f0) it.next()).o().h();
                if (setH == null) {
                    return null;
                }
                d0.r0(linkedHashSet, setH);
            }
            return linkedHashSet;
        }

        @Override // tp.i
        @os.l
        public Set<dp.f> v() {
            List<f0> listA = this.f15968j.H.a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                d0.r0(linkedHashSet, ((f0) it.next()).o().b());
            }
            linkedHashSet.addAll(this.f15978b.f14748a.f14740n.d(this.f15968j));
            return linkedHashSet;
        }

        @Override // tp.i
        @os.l
        public Set<dp.f> w() {
            List<f0> listA = this.f15968j.H.a();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                d0.r0(linkedHashSet, ((f0) it.next()).o().d());
            }
            return linkedHashSet;
        }

        @Override // tp.i
        public boolean z(@os.l y0 y0Var) {
            l0.p(y0Var, "function");
            return this.f15978b.f14748a.f14741o.c(this.f15968j, y0Var);
        }
    }

    public final class b extends vp.b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @os.l
        public final up.i<List<e1>> f15970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e f15971e;

        public static final class a extends kn.n0 implements jn.a<List<? extends e1>> {
            final /* synthetic */ e this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super(0);
                this.this$0 = eVar;
            }

            @Override // jn.a
            @os.l
            public final List<? extends e1> invoke() {
                return f1.d(this.this$0);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar) {
            super(eVar.f15963y.f14748a.f14727a);
            l0.p(eVar, "this$0");
            this.f15971e = eVar;
            this.f15970d = eVar.f15963y.f14748a.f14727a.h(new a(eVar));
        }

        @Override // vp.b, vp.m, vp.a1
        public eo.h d() {
            return this.f15971e;
        }

        @Override // vp.a1
        public boolean e() {
            return true;
        }

        @Override // vp.a1
        @os.l
        public List<e1> getParameters() {
            return this.f15970d.invoke();
        }

        @Override // vp.h
        @os.l
        public Collection<f0> k() {
            e eVar = this.f15971e;
            List<yo.a.q> listL = ap.f.l(eVar.f15956g, eVar.f15963y.f14751d);
            e eVar2 = this.f15971e;
            ArrayList arrayList = new ArrayList(nm.z.b0(listL, 10));
            Iterator<T> it = listL.iterator();
            while (it.hasNext()) {
                arrayList.add(eVar2.f15963y.f14755h.p((yo.a.q) it.next()));
            }
            e eVar3 = this.f15971e;
            List listE4 = h0.E4(arrayList, eVar3.f15963y.f14748a.f14740n.a(eVar3));
            ArrayList<j0.b> arrayList2 = new ArrayList();
            Iterator it2 = listE4.iterator();
            while (it2.hasNext()) {
                eo.h hVarD = ((f0) it2.next()).G0().d();
                j0.b bVar = hVarD instanceof j0.b ? (j0.b) hVarD : null;
                if (bVar != null) {
                    arrayList2.add(bVar);
                }
            }
            if (!arrayList2.isEmpty()) {
                e eVar4 = this.f15971e;
                q qVar = eVar4.f15963y.f14748a.f14734h;
                ArrayList arrayList3 = new ArrayList(nm.z.b0(arrayList2, 10));
                for (j0.b bVar2 : arrayList2) {
                    dp.b bVarH = lp.a.h(bVar2);
                    arrayList3.add(bVarH == null ? bVar2.getName().b() : bVarH.b().b());
                }
                qVar.a(eVar4, arrayList3);
            }
            return h0.V5(listE4);
        }

        @Override // vp.h
        @os.l
        public c1 p() {
            return c1.a.f4596a;
        }

        @os.l
        public String toString() {
            String str = this.f15971e.getName().f3820a;
            l0.o(str, "name.toString()");
            return str;
        }

        @Override // vp.b
        /* JADX INFO: renamed from: v */
        public eo.e d() {
            return this.f15971e;
        }

        @os.l
        public e w() {
            return this.f15971e;
        }
    }

    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Map<dp.f, yo.a.g> f15972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final up.h<dp.f, eo.e> f15973b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @os.l
        public final up.i<Set<dp.f>> f15974c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ e f15975d;

        public static final class a extends kn.n0 implements jn.l<dp.f, eo.e> {
            final /* synthetic */ e this$1;

            /* JADX INFO: renamed from: tp.e$c$a$a, reason: collision with other inner class name */
            public static final class C0412a extends kn.n0 implements jn.a<List<? extends fo.c>> {
                final /* synthetic */ yo.a.g $proto;
                final /* synthetic */ e this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0412a(e eVar, yo.a.g gVar) {
                    super(0);
                    this.this$0 = eVar;
                    this.$proto = gVar;
                }

                @Override // jn.a
                @os.l
                public final List<? extends fo.c> invoke() {
                    e eVar = this.this$0;
                    return h0.V5(eVar.f15963y.f14748a.f14731e.a(eVar.Q, this.$proto));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(e eVar) {
                super(1);
                this.this$1 = eVar;
            }

            @Override // jn.l
            @os.m
            public final eo.e invoke(@os.l dp.f fVar) {
                l0.p(fVar, "name");
                yo.a.g gVar = c.this.f15972a.get(fVar);
                if (gVar == null) {
                    return null;
                }
                e eVar = this.this$1;
                return ho.n.F0(eVar.f15963y.f14748a.f14727a, eVar, fVar, c.this.f15974c, new tp.b(eVar.f15963y.f14748a.f14727a, new C0412a(eVar, gVar)), z0.f4654a);
            }
        }

        public static final class b extends kn.n0 implements jn.a<Set<? extends dp.f>> {
            public b() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final Set<? extends dp.f> invoke() {
                return c.this.e();
            }
        }

        public c(e eVar) {
            l0.p(eVar, "this$0");
            this.f15975d = eVar;
            List<yo.a.g> enumEntryList = eVar.f15956g.getEnumEntryList();
            l0.o(enumEntryList, "classProto.enumEntryList");
            List<yo.a.g> list = enumEntryList;
            int iJ = nm.c1.j(nm.z.b0(list, 10));
            LinkedHashMap linkedHashMap = new LinkedHashMap(iJ < 16 ? 16 : iJ);
            for (Object obj : list) {
                linkedHashMap.put(x.b(eVar.f15963y.f14749b, ((yo.a.g) obj).getName()), obj);
            }
            this.f15972a = linkedHashMap;
            e eVar2 = this.f15975d;
            this.f15973b = eVar2.f15963y.f14748a.f14727a.f(new a(eVar2));
            this.f15974c = this.f15975d.f15963y.f14748a.f14727a.h(new b());
        }

        @os.l
        public final Collection<eo.e> d() {
            Set<dp.f> setKeySet = this.f15972a.keySet();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = setKeySet.iterator();
            while (it.hasNext()) {
                eo.e eVarF = f((dp.f) it.next());
                if (eVarF != null) {
                    arrayList.add(eVarF);
                }
            }
            return arrayList;
        }

        public final Set<dp.f> e() {
            HashSet hashSet = new HashSet();
            Iterator<f0> it = this.f15975d.H.a().iterator();
            while (it.hasNext()) {
                for (eo.m mVar : op.k.a.a(it.next().o(), null, null, 3, null)) {
                    if ((mVar instanceof y0) || (mVar instanceof t0)) {
                        hashSet.add(mVar.getName());
                    }
                }
            }
            List<yo.a.i> functionList = this.f15975d.f15956g.getFunctionList();
            l0.o(functionList, "classProto.functionList");
            e eVar = this.f15975d;
            Iterator<T> it2 = functionList.iterator();
            while (it2.hasNext()) {
                hashSet.add(x.b(eVar.f15963y.f14749b, ((yo.a.i) it2.next()).getName()));
            }
            List<yo.a.n> propertyList = this.f15975d.f15956g.getPropertyList();
            l0.o(propertyList, "classProto.propertyList");
            e eVar2 = this.f15975d;
            Iterator<T> it3 = propertyList.iterator();
            while (it3.hasNext()) {
                hashSet.add(x.b(eVar2.f15963y.f14749b, ((yo.a.n) it3.next()).getName()));
            }
            return p1.D(hashSet, hashSet);
        }

        @os.m
        public final eo.e f(@os.l dp.f fVar) {
            l0.p(fVar, "name");
            return this.f15973b.invoke(fVar);
        }
    }

    public static final class d extends kn.n0 implements jn.a<List<? extends fo.c>> {
        public d() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends fo.c> invoke() {
            e eVar = e.this;
            return h0.V5(eVar.f15963y.f14748a.f14731e.g(eVar.Q));
        }
    }

    /* JADX INFO: renamed from: tp.e$e, reason: collision with other inner class name */
    public static final class C0413e extends kn.n0 implements jn.a<eo.e> {
        public C0413e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final eo.e invoke() {
            return e.this.M0();
        }
    }

    public static final class f extends kn.n0 implements jn.a<Collection<? extends eo.d>> {
        public f() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Collection<? extends eo.d> invoke() {
            return e.this.N0();
        }
    }

    public static final class g extends kn.n0 implements jn.a<z<n0>> {
        public g() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final z<n0> invoke() {
            return e.this.O0();
        }
    }

    public /* synthetic */ class h extends g0 implements jn.l<wp.g, a> {
        public h(Object obj) {
            super(1, obj);
        }

        @Override // kn.q, un.c
        @os.l
        public final String getName() {
            return "<init>";
        }

        @Override // kn.q
        @os.l
        public final un.h getOwner() {
            return l1.d(a.class);
        }

        @Override // kn.q
        @os.l
        public final String getSignature() {
            return "<init>(Lorg/jetbrains/kotlin/serialization/deserialization/descriptors/DeserializedClassDescriptor;Lorg/jetbrains/kotlin/types/checker/KotlinTypeRefiner;)V";
        }

        @Override // jn.l
        @os.l
        public final a invoke(@os.l wp.g gVar) {
            l0.p(gVar, "p0");
            return new a((e) this.receiver, gVar);
        }
    }

    public static final class i extends kn.n0 implements jn.a<eo.d> {
        public i() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.m
        public final eo.d invoke() {
            return e.this.P0();
        }
    }

    public static final class j extends kn.n0 implements jn.a<Collection<? extends eo.e>> {
        public j() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final Collection<? extends eo.e> invoke() {
            return e.this.R0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@os.l rp.l lVar, @os.l yo.a.c cVar, @os.l ap.c cVar2, @os.l ap.a aVar, @os.l z0 z0Var) {
        fo.g oVar;
        super(lVar.f14748a.f14727a, x.a(cVar2, cVar.getFqName()).j());
        l0.p(lVar, "outerContext");
        l0.p(cVar, "classProto");
        l0.p(cVar2, "nameResolver");
        l0.p(aVar, "metadataVersion");
        l0.p(z0Var, "sourceElement");
        this.f15956g = cVar;
        this.f15957i = aVar;
        this.f15958n = z0Var;
        this.f15959p = x.a(cVar2, cVar.getFqName());
        a0 a0Var = a0.f14685a;
        this.f15960v = a0Var.b(ap.b.f643e.d(cVar.getFlags()));
        this.f15961w = b0.a(a0Var, ap.b.f642d.d(cVar.getFlags()));
        eo.f fVarA = a0Var.a(ap.b.f644f.d(cVar.getFlags()));
        this.f15962x = fVarA;
        List<yo.a.s> typeParameterList = cVar.getTypeParameterList();
        l0.o(typeParameterList, "classProto.typeParameterList");
        yo.a.t typeTable = cVar.getTypeTable();
        l0.o(typeTable, "classProto.typeTable");
        ap.g gVar = new ap.g(typeTable);
        ap.h.a aVar2 = ap.h.f672b;
        yo.a.w versionRequirementTable = cVar.getVersionRequirementTable();
        l0.o(versionRequirementTable, "classProto.versionRequirementTable");
        rp.l lVarA = lVar.a(this, typeParameterList, cVar2, gVar, aVar2.a(versionRequirementTable), aVar);
        this.f15963y = lVarA;
        eo.f fVar = eo.f.ENUM_CLASS;
        this.f15964z = fVarA == fVar ? new op.l(lVarA.f14748a.f14727a, this) : op.h.c.f12406b;
        this.H = new b(this);
        x0.a aVar3 = x0.f4646e;
        rp.j jVar = lVarA.f14748a;
        this.I = aVar3.a(this, jVar.f14727a, jVar.f14743q.d(), new h(this));
        this.J = fVarA == fVar ? new c(this) : null;
        eo.m mVar = lVar.f14750c;
        this.K = mVar;
        this.L = lVarA.f14748a.f14727a.g(new i());
        this.M = lVarA.f14748a.f14727a.h(new f());
        this.N = lVarA.f14748a.f14727a.g(new C0413e());
        this.O = lVarA.f14748a.f14727a.h(new j());
        this.P = lVarA.f14748a.f14727a.g(new g());
        ap.c cVar3 = lVarA.f14749b;
        ap.g gVar2 = lVarA.f14751d;
        e eVar = mVar instanceof e ? (e) mVar : null;
        this.Q = new rp.z.a(cVar, cVar3, gVar2, z0Var, eVar != null ? eVar.Q : null);
        if (ap.b.f641c.d(cVar.getFlags()).booleanValue()) {
            oVar = new o(lVarA.f14748a.f14727a, new d());
        } else {
            fo.g.f6167h.getClass();
            oVar = fo.g.a.f6169b;
        }
        this.R = oVar;
    }

    @Override // eo.e
    @os.m
    public eo.d G() {
        return this.L.invoke();
    }

    public final eo.e M0() {
        if (!this.f15956g.hasCompanionObjectName()) {
            return null;
        }
        eo.h hVarF = U0().f(x.b(this.f15963y.f14749b, this.f15956g.getCompanionObjectName()), mo.d.FROM_DESERIALIZATION);
        if (hVarF instanceof eo.e) {
            return (eo.e) hVarF;
        }
        return null;
    }

    public final Collection<eo.d> N0() {
        return h0.E4(h0.E4(Q0(), y.P(G())), this.f15963y.f14748a.f14740n.e(this));
    }

    public final z<n0> O0() {
        dp.f name;
        n0 n0VarN;
        Object obj = null;
        if (!hp.f.b(this)) {
            return null;
        }
        if (this.f15956g.hasInlineClassUnderlyingPropertyName()) {
            name = x.b(this.f15963y.f14749b, this.f15956g.getInlineClassUnderlyingPropertyName());
        } else {
            if (this.f15957i.c(1, 5, 1)) {
                throw new IllegalStateException(l0.C("Inline class has no underlying property name in metadata: ", this).toString());
            }
            eo.d dVarG = G();
            if (dVarG == null) {
                throw new IllegalStateException(l0.C("Inline class has no primary constructor: ", this).toString());
            }
            List<h1> listH = dVarG.h();
            l0.o(listH, "constructor.valueParameters");
            name = ((h1) h0.B2(listH)).getName();
            l0.o(name, "{\n                // Bef…irst().name\n            }");
        }
        yo.a.q qVarF = ap.f.f(this.f15956g, this.f15963y.f14751d);
        boolean z10 = false;
        if (qVarF == null) {
            Iterator<T> it = U0().c(name, mo.d.FROM_DESERIALIZATION).iterator();
            Object obj2 = null;
            while (true) {
                if (!it.hasNext()) {
                    if (!z10) {
                        break;
                    }
                    obj = obj2;
                    break;
                }
                Object next = it.next();
                if (((t0) next).R() == null) {
                    if (z10) {
                        break;
                    }
                    z10 = true;
                    obj2 = next;
                }
            }
            t0 t0Var = (t0) obj;
            if (t0Var == null) {
                throw new IllegalStateException(l0.C("Inline class has no underlying property: ", this).toString());
            }
            n0VarN = (n0) t0Var.getType();
        } else {
            n0VarN = rp.d0.n(this.f15963y.f14755h, qVarF, false, 2, null);
        }
        return new z<>(name, n0VarN);
    }

    public final eo.d P0() {
        Object next;
        if (this.f15962x.isSingleton()) {
            ho.f fVarI = hp.c.i(this, z0.f4654a);
            fVarI.a1(q());
            return fVarI;
        }
        List<yo.a.d> constructorList = this.f15956g.getConstructorList();
        l0.o(constructorList, "classProto.constructorList");
        Iterator<T> it = constructorList.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (ap.b.f651m.d(((yo.a.d) next).getFlags()).booleanValue());
        yo.a.d dVar = (yo.a.d) next;
        if (dVar == null) {
            return null;
        }
        return this.f15963y.f14756i.i(dVar, true);
    }

    public final List<eo.d> Q0() {
        List<yo.a.d> constructorList = this.f15956g.getConstructorList();
        l0.o(constructorList, "classProto.constructorList");
        ArrayList<yo.a.d> arrayList = new ArrayList();
        for (Object obj : constructorList) {
            Boolean boolD = ap.b.f651m.d(((yo.a.d) obj).getFlags());
            l0.o(boolD, "IS_SECONDARY.get(it.flags)");
            if (boolD.booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(nm.z.b0(arrayList, 10));
        for (yo.a.d dVar : arrayList) {
            w wVar = this.f15963y.f14756i;
            l0.o(dVar, "it");
            arrayList2.add(wVar.i(dVar, false));
        }
        return arrayList2;
    }

    public final Collection<eo.e> R0() {
        if (this.f15960v != e0.SEALED) {
            return k0.INSTANCE;
        }
        List<Integer> sealedSubclassFqNameList = this.f15956g.getSealedSubclassFqNameList();
        l0.o(sealedSubclassFqNameList, "fqNames");
        if (sealedSubclassFqNameList.isEmpty()) {
            return hp.a.f7475a.a(this, false);
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : sealedSubclassFqNameList) {
            rp.l lVar = this.f15963y;
            rp.j jVar = lVar.f14748a;
            ap.c cVar = lVar.f14749b;
            l0.o(num, "index");
            eo.e eVarB = jVar.b(x.a(cVar, num.intValue()));
            if (eVarB != null) {
                arrayList.add(eVarB);
            }
        }
        return arrayList;
    }

    @os.l
    public final rp.l S0() {
        return this.f15963y;
    }

    @os.l
    public final yo.a.c T0() {
        return this.f15956g;
    }

    public final a U0() {
        return (a) this.I.c(this.f15963y.f14748a.f14743q.d());
    }

    @os.l
    public final ap.a V0() {
        return this.f15957i;
    }

    @os.l
    public op.i W0() {
        return this.f15964z;
    }

    @os.l
    public final rp.z.a X0() {
        return this.Q;
    }

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    public final boolean Y0(@os.l dp.f fVar) {
        l0.p(fVar, "name");
        return U0().s().contains(fVar);
    }

    @Override // ho.t
    @os.l
    public op.h Z(@os.l wp.g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        return this.I.c(gVar);
    }

    @Override // eo.e
    public boolean a0() {
        return ap.b.f644f.d(this.f15956g.getFlags()) == yo.a.c.EnumC0567c.COMPANION_OBJECT;
    }

    @Override // eo.e, eo.n, eo.m
    @os.l
    public eo.m b() {
        return this.K;
    }

    @Override // eo.e
    @os.l
    public Collection<eo.d> g() {
        return this.M.invoke();
    }

    @Override // fo.a
    @os.l
    public fo.g getAnnotations() {
        return this.R;
    }

    @Override // eo.e
    @os.l
    public eo.f getKind() {
        return this.f15962x;
    }

    @Override // eo.p
    @os.l
    public z0 getSource() {
        return this.f15958n;
    }

    @Override // eo.e, eo.q, eo.d0
    @os.l
    public u getVisibility() {
        return this.f15961w;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        return this.H;
    }

    @Override // eo.d0
    public boolean i0() {
        Boolean boolD = ap.b.f648j.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_EXPECT_CLASS.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // eo.d0
    public boolean isExternal() {
        Boolean boolD = ap.b.f647i.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_EXTERNAL_CLASS.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // eo.e
    public boolean isInline() {
        Boolean boolD = ap.b.f649k.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_INLINE_CLASS.get(classProto.flags)");
        return boolD.booleanValue() && this.f15957i.e(1, 4, 1);
    }

    @Override // eo.e
    @os.l
    public Collection<eo.e> k() {
        return this.O.invoke();
    }

    @Override // eo.e
    public op.h k0() {
        return this.f15964z;
    }

    @Override // eo.i
    public boolean l() {
        Boolean boolD = ap.b.f645g.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_INNER.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // eo.e
    @os.m
    public eo.e l0() {
        return this.N.invoke();
    }

    @Override // eo.e, eo.i
    @os.l
    public List<e1> r() {
        return this.f15963y.f14755h.j();
    }

    @Override // eo.e, eo.d0
    @os.l
    public e0 s() {
        return this.f15960v;
    }

    @Override // eo.e
    public boolean t() {
        Boolean boolD = ap.b.f650l.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_FUN_INTERFACE.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @os.l
    public String toString() {
        StringBuilder sb2 = new StringBuilder("deserialized ");
        sb2.append(i0() ? "expect " : "");
        sb2.append("class ");
        sb2.append(getName());
        return sb2.toString();
    }

    @Override // eo.e
    public boolean u() {
        Boolean boolD = ap.b.f649k.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_INLINE_CLASS.get(classProto.flags)");
        return boolD.booleanValue() && this.f15957i.c(1, 4, 2);
    }

    @Override // eo.e
    public boolean x() {
        Boolean boolD = ap.b.f646h.d(this.f15956g.getFlags());
        l0.o(boolD, "IS_DATA.get(classProto.flags)");
        return boolD.booleanValue();
    }

    @Override // eo.e
    @os.m
    public z<n0> y() {
        return this.P.invoke();
    }
}
