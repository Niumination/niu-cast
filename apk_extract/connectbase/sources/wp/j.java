package wp;

import eo.e1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.l0;
import kn.n0;
import lm.d0;
import lm.f0;
import lm.h0;
import nm.k0;
import nm.z;
import vp.c1;
import vp.n1;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements ip.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final c1 f19861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public jn.a<? extends List<? extends n1>> f19862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.m
    public final j f19863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.m
    public final e1 f19864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final d0 f19865e;

    public static final class a extends n0 implements jn.a<List<? extends n1>> {
        final /* synthetic */ List<n1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(List<? extends n1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // jn.a
        @os.l
        public final List<? extends n1> invoke() {
            return this.$supertypes;
        }
    }

    public static final class b extends n0 implements jn.a<List<? extends n1>> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.m
        public final List<? extends n1> invoke() {
            jn.a<? extends List<? extends n1>> aVar = j.this.f19862b;
            if (aVar == null) {
                return null;
            }
            return aVar.invoke();
        }
    }

    public static final class c extends n0 implements jn.a<List<? extends n1>> {
        final /* synthetic */ List<n1> $supertypes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public c(List<? extends n1> list) {
            super(0);
            this.$supertypes = list;
        }

        @Override // jn.a
        @os.l
        public final List<? extends n1> invoke() {
            return this.$supertypes;
        }
    }

    public static final class d extends n0 implements jn.a<List<? extends n1>> {
        final /* synthetic */ g $kotlinTypeRefiner;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g gVar) {
            super(0);
            this.$kotlinTypeRefiner = gVar;
        }

        @Override // jn.a
        @os.l
        public final List<? extends n1> invoke() {
            List<n1> listA = j.this.a();
            g gVar = this.$kotlinTypeRefiner;
            ArrayList arrayList = new ArrayList(z.b0(listA, 10));
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                arrayList.add(((n1) it.next()).Q0(gVar));
            }
            return arrayList;
        }
    }

    public j(@os.l c1 c1Var, @os.m jn.a<? extends List<? extends n1>> aVar, @os.m j jVar, @os.m e1 e1Var) {
        l0.p(c1Var, "projection");
        this.f19861a = c1Var;
        this.f19862b = aVar;
        this.f19863c = jVar;
        this.f19864d = e1Var;
        this.f19865e = f0.c(h0.PUBLICATION, new b());
    }

    @Override // ip.b
    @os.l
    public c1 c() {
        return this.f19861a;
    }

    @Override // vp.a1
    @os.m
    public eo.h d() {
        return null;
    }

    @Override // vp.a1
    public boolean e() {
        return false;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!l0.g(j.class, obj == null ? null : obj.getClass())) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedTypeConstructor");
        }
        j jVar = (j) obj;
        j jVar2 = this.f19863c;
        if (jVar2 != null) {
            this = jVar2;
        }
        j jVar3 = jVar.f19863c;
        if (jVar3 != null) {
            jVar = jVar3;
        }
        return this == jVar;
    }

    @Override // vp.a1
    @os.l
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public List<n1> a() {
        List<n1> listH = h();
        return listH == null ? k0.INSTANCE : listH;
    }

    @Override // vp.a1
    @os.l
    public List<e1> getParameters() {
        return k0.INSTANCE;
    }

    public final List<n1> h() {
        return (List) this.f19865e.getValue();
    }

    public int hashCode() {
        j jVar = this.f19863c;
        return jVar == null ? super.hashCode() : jVar.hashCode();
    }

    public final void i(@os.l List<? extends n1> list) {
        l0.p(list, "supertypes");
        this.f19862b = new c(list);
    }

    @Override // vp.a1
    @os.l
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public j b(@os.l g gVar) {
        l0.p(gVar, "kotlinTypeRefiner");
        c1 c1VarB = this.f19861a.b(gVar);
        l0.o(c1VarB, "projection.refine(kotlinTypeRefiner)");
        d dVar = this.f19862b == null ? null : new d(gVar);
        j jVar = this.f19863c;
        if (jVar == null) {
            jVar = this;
        }
        return new j(c1VarB, dVar, jVar, this.f19864d);
    }

    @Override // vp.a1
    @os.l
    public ao.h n() {
        vp.f0 type = this.f19861a.getType();
        l0.o(type, "projection.type");
        return zp.a.h(type);
    }

    @os.l
    public String toString() {
        return "CapturedType(" + this.f19861a + ')';
    }

    public /* synthetic */ j(c1 c1Var, jn.a aVar, j jVar, e1 e1Var, int i10, kn.w wVar) {
        this(c1Var, (i10 & 2) != 0 ? null : aVar, (i10 & 4) != 0 ? null : jVar, (i10 & 8) != 0 ? null : e1Var);
    }

    public /* synthetic */ j(c1 c1Var, List list, j jVar, int i10, kn.w wVar) {
        this(c1Var, list, (i10 & 4) != 0 ? null : jVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(@os.l c1 c1Var, @os.l List<? extends n1> list, @os.m j jVar) {
        this(c1Var, new a(list), jVar, null, 8, null);
        l0.p(c1Var, "projection");
        l0.p(list, "supertypes");
    }
}
