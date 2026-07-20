package vp;

import java.util.Collection;
import java.util.List;
import lm.l2;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final up.i<b> f17696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17697c;

    public final class a implements a1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final wp.g f17698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final lm.d0 f17699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f17700c;

        /* JADX INFO: renamed from: vp.h$a$a, reason: collision with other inner class name */
        public static final class C0463a extends kn.n0 implements jn.a<List<? extends f0>> {
            final /* synthetic */ h this$1;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0463a(h hVar) {
                super(0);
                this.this$1 = hVar;
            }

            @Override // jn.a
            @os.l
            public final List<? extends f0> invoke() {
                return wp.h.b(a.this.f17698a, this.this$1.a());
            }
        }

        public a(@os.l h hVar, wp.g gVar) {
            kn.l0.p(hVar, "this$0");
            kn.l0.p(gVar, "kotlinTypeRefiner");
            this.f17700c = hVar;
            this.f17698a = gVar;
            this.f17699b = lm.f0.c(lm.h0.PUBLICATION, new C0463a(hVar));
        }

        @Override // vp.a1
        public Collection a() {
            return g();
        }

        @Override // vp.a1
        @os.l
        public a1 b(@os.l wp.g gVar) {
            kn.l0.p(gVar, "kotlinTypeRefiner");
            return this.f17700c.b(gVar);
        }

        @Override // vp.a1
        @os.l
        public eo.h d() {
            return this.f17700c.d();
        }

        @Override // vp.a1
        public boolean e() {
            return this.f17700c.e();
        }

        public boolean equals(@os.m Object obj) {
            return this.f17700c.equals(obj);
        }

        public final List<f0> g() {
            return (List) this.f17699b.getValue();
        }

        @Override // vp.a1
        @os.l
        public List<eo.e1> getParameters() {
            List<eo.e1> parameters = this.f17700c.getParameters();
            kn.l0.o(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        @os.l
        public List<f0> h() {
            return g();
        }

        public int hashCode() {
            return this.f17700c.hashCode();
        }

        @Override // vp.a1
        @os.l
        public ao.h n() {
            ao.h hVarN = this.f17700c.n();
            kn.l0.o(hVarN, "this@AbstractTypeConstructor.builtIns");
            return hVarN;
        }

        @os.l
        public String toString() {
            return this.f17700c.toString();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final Collection<f0> f17701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public List<? extends f0> f17702b;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@os.l Collection<? extends f0> collection) {
            kn.l0.p(collection, "allSupertypes");
            this.f17701a = collection;
            this.f17702b = nm.x.k(x.f17762c);
        }

        @os.l
        public final Collection<f0> a() {
            return this.f17701a;
        }

        @os.l
        public final List<f0> b() {
            return this.f17702b;
        }

        public final void c(@os.l List<? extends f0> list) {
            kn.l0.p(list, "<set-?>");
            this.f17702b = list;
        }
    }

    public static final class c extends kn.n0 implements jn.a<b> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final b invoke() {
            return new b(h.this.k());
        }
    }

    public static final class d extends kn.n0 implements jn.l<Boolean, b> {
        public static final d INSTANCE = new d();

        public d() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ b invoke(Boolean bool) {
            return invoke(bool.booleanValue());
        }

        @os.l
        public final b invoke(boolean z10) {
            return new b(nm.x.k(x.f17762c));
        }
    }

    public static final class e extends kn.n0 implements jn.l<b, l2> {

        public static final class a extends kn.n0 implements jn.l<a1, Iterable<? extends f0>> {
            final /* synthetic */ h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(h hVar) {
                super(1);
                this.this$0 = hVar;
            }

            @Override // jn.l
            @os.l
            public final Iterable<f0> invoke(@os.l a1 a1Var) {
                kn.l0.p(a1Var, "it");
                return this.this$0.j(a1Var, true);
            }
        }

        public static final class b extends kn.n0 implements jn.l<f0, l2> {
            final /* synthetic */ h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(h hVar) {
                super(1);
                this.this$0 = hVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(f0 f0Var) {
                invoke2(f0Var);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l f0 f0Var) {
                kn.l0.p(f0Var, "it");
                this.this$0.s(f0Var);
            }
        }

        public static final class c extends kn.n0 implements jn.l<a1, Iterable<? extends f0>> {
            final /* synthetic */ h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(h hVar) {
                super(1);
                this.this$0 = hVar;
            }

            @Override // jn.l
            @os.l
            public final Iterable<f0> invoke(@os.l a1 a1Var) {
                kn.l0.p(a1Var, "it");
                return this.this$0.j(a1Var, false);
            }
        }

        public static final class d extends kn.n0 implements jn.l<f0, l2> {
            final /* synthetic */ h this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(h hVar) {
                super(1);
                this.this$0 = hVar;
            }

            @Override // jn.l
            public /* bridge */ /* synthetic */ l2 invoke(f0 f0Var) {
                invoke2(f0Var);
                return l2.f10208a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@os.l f0 f0Var) {
                kn.l0.p(f0Var, "it");
                this.this$0.t(f0Var);
            }
        }

        public e() {
            super(1);
        }

        @Override // jn.l
        public /* bridge */ /* synthetic */ l2 invoke(b bVar) {
            invoke2(bVar);
            return l2.f10208a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@os.l b bVar) {
            kn.l0.p(bVar, "supertypes");
            eo.c1 c1VarP = h.this.p();
            h hVar = h.this;
            List listA = c1VarP.a(hVar, bVar.f17701a, new c(hVar), new d(h.this));
            if (listA.isEmpty()) {
                f0 f0VarL = h.this.l();
                List listK = f0VarL == null ? null : nm.x.k(f0VarL);
                if (listK == null) {
                    listK = nm.k0.INSTANCE;
                }
                listA = listK;
            }
            if (h.this.o()) {
                eo.c1 c1VarP2 = h.this.p();
                h hVar2 = h.this;
                c1VarP2.a(hVar2, listA, new a(hVar2), new b(h.this));
            }
            h hVar3 = h.this;
            List<f0> listV5 = listA instanceof List ? (List) listA : null;
            if (listV5 == null) {
                listV5 = nm.h0.V5(listA);
            }
            bVar.c(hVar3.r(listV5));
        }
    }

    public h(@os.l up.n nVar) {
        kn.l0.p(nVar, "storageManager");
        this.f17696b = nVar.d(new c(), d.INSTANCE, new e());
    }

    @Override // vp.a1
    @os.l
    public a1 b(@os.l wp.g gVar) {
        kn.l0.p(gVar, "kotlinTypeRefiner");
        return new a(this, gVar);
    }

    public final Collection<f0> j(a1 a1Var, boolean z10) {
        h hVar = a1Var instanceof h ? (h) a1Var : null;
        if (hVar != null) {
            return nm.h0.E4(hVar.f17696b.invoke().f17701a, hVar.m(z10));
        }
        Collection<f0> collectionA = a1Var.a();
        kn.l0.o(collectionA, "supertypes");
        return collectionA;
    }

    @os.l
    public abstract Collection<f0> k();

    @os.m
    public f0 l() {
        return null;
    }

    @os.l
    public Collection<f0> m(boolean z10) {
        return nm.k0.INSTANCE;
    }

    public boolean o() {
        return this.f17697c;
    }

    @os.l
    public abstract eo.c1 p();

    @Override // vp.a1
    @os.l
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public List<f0> a() {
        return this.f17696b.invoke().f17702b;
    }

    @os.l
    public List<f0> r(@os.l List<f0> list) {
        kn.l0.p(list, "supertypes");
        return list;
    }

    public void s(@os.l f0 f0Var) {
        kn.l0.p(f0Var, ik.y0.a.f8215h);
    }

    public void t(@os.l f0 f0Var) {
        kn.l0.p(f0Var, ik.y0.a.f8215h);
    }
}
