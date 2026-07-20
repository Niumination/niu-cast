package eo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import nm.n1;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final up.n f4601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h0 f4602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.g<dp.c, k0> f4603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final up.g<a, e> f4604d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final dp.b f4605a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final List<Integer> f4606b;

        public a(@os.l dp.b bVar, @os.l List<Integer> list) {
            kn.l0.p(bVar, "classId");
            kn.l0.p(list, "typeParametersCount");
            this.f4605a = bVar;
            this.f4606b = list;
        }

        @os.l
        public final dp.b a() {
            return this.f4605a;
        }

        @os.l
        public final List<Integer> b() {
            return this.f4606b;
        }

        public boolean equals(@os.m Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kn.l0.g(this.f4605a, aVar.f4605a) && kn.l0.g(this.f4606b, aVar.f4606b);
        }

        public int hashCode() {
            return this.f4606b.hashCode() + (this.f4605a.hashCode() * 31);
        }

        @os.l
        public String toString() {
            return "ClassRequest(classId=" + this.f4605a + ", typeParametersCount=" + this.f4606b + ')';
        }
    }

    public static final class b extends ho.g {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public final boolean f4607p;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @os.l
        public final List<e1> f4608v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        @os.l
        public final vp.l f4609w;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l up.n nVar, @os.l m mVar, @os.l dp.f fVar, boolean z10, int i10) {
            super(nVar, mVar, fVar, z0.f4654a, false);
            kn.l0.p(nVar, "storageManager");
            kn.l0.p(mVar, "container");
            kn.l0.p(fVar, "name");
            this.f4607p = z10;
            tn.l lVarW1 = tn.u.W1(0, i10);
            ArrayList arrayList = new ArrayList(nm.z.b0(lVarW1, 10));
            Iterator<Integer> it = lVarW1.iterator();
            while (it.hasNext()) {
                int iNextInt = ((nm.v0) it).nextInt();
                fo.g.f6167h.getClass();
                arrayList.add(ho.k0.L0(this, fo.g.a.f6169b, false, o1.INVARIANT, dp.f.k(kn.l0.C("T", Integer.valueOf(iNextInt))), iNextInt, nVar));
            }
            this.f4608v = arrayList;
            this.f4609w = new vp.l(this, f1.d(this), n1.f(lp.a.l(this).n().i()), nVar);
        }

        @os.l
        public op.h.c E0() {
            return op.h.c.f12406b;
        }

        @os.l
        public vp.l F0() {
            return this.f4609w;
        }

        @Override // eo.e
        @os.m
        public eo.d G() {
            return null;
        }

        @Override // ho.t
        @os.l
        /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
        public op.h.c Z(@os.l wp.g gVar) {
            kn.l0.p(gVar, "kotlinTypeRefiner");
            return op.h.c.f12406b;
        }

        @Override // eo.d0
        public boolean Y() {
            return false;
        }

        @Override // eo.e
        public boolean a0() {
            return false;
        }

        @Override // eo.e
        @os.l
        public Collection<eo.d> g() {
            return nm.m0.INSTANCE;
        }

        @Override // fo.a
        @os.l
        public fo.g getAnnotations() {
            fo.g.f6167h.getClass();
            return fo.g.a.f6169b;
        }

        @Override // eo.e
        @os.l
        public f getKind() {
            return f.CLASS;
        }

        @Override // eo.e, eo.q, eo.d0
        @os.l
        public u getVisibility() {
            u uVar = t.f4633e;
            kn.l0.o(uVar, "PUBLIC");
            return uVar;
        }

        @Override // eo.h
        public vp.a1 i() {
            return this.f4609w;
        }

        @Override // eo.d0
        public boolean i0() {
            return false;
        }

        @Override // ho.g, eo.d0
        public boolean isExternal() {
            return false;
        }

        @Override // eo.e
        public boolean isInline() {
            return false;
        }

        @Override // eo.e
        @os.l
        public Collection<e> k() {
            return nm.k0.INSTANCE;
        }

        @Override // eo.e
        public op.h k0() {
            return op.h.c.f12406b;
        }

        @Override // eo.i
        public boolean l() {
            return this.f4607p;
        }

        @Override // eo.e
        @os.m
        public e l0() {
            return null;
        }

        @Override // eo.e, eo.i
        @os.l
        public List<e1> r() {
            return this.f4608v;
        }

        @Override // eo.e, eo.d0
        @os.l
        public e0 s() {
            return e0.FINAL;
        }

        @Override // eo.e
        public boolean t() {
            return false;
        }

        @os.l
        public String toString() {
            return "class " + getName() + " (not found)";
        }

        @Override // eo.e
        public boolean u() {
            return false;
        }

        @Override // eo.e
        public boolean x() {
            return false;
        }

        @Override // eo.e
        @os.m
        public z<vp.n0> y() {
            return null;
        }
    }

    public static final class c extends kn.n0 implements jn.l<a, e> {
        public c() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final e invoke(@os.l a aVar) {
            k0 k0VarD;
            kn.l0.p(aVar, "$dstr$classId$typeParametersCount");
            dp.b bVar = aVar.f4605a;
            List<Integer> list = aVar.f4606b;
            if (bVar.f3808c) {
                throw new UnsupportedOperationException(kn.l0.C("Unresolved local class: ", bVar));
            }
            dp.b bVarG = bVar.g();
            if (bVarG == null) {
                up.g<dp.c, k0> gVar = j0.this.f4603c;
                dp.c cVarH = bVar.h();
                kn.l0.o(cVarH, "classId.packageFqName");
                k0VarD = gVar.invoke(cVarH);
            } else {
                k0VarD = j0.this.d(bVarG, nm.h0.c2(list, 1));
            }
            m mVar = k0VarD;
            boolean zL = bVar.l();
            up.n nVar = j0.this.f4601a;
            dp.f fVarJ = bVar.j();
            kn.l0.o(fVarJ, "classId.shortClassName");
            Integer num = (Integer) nm.h0.G2(list);
            return new b(nVar, mVar, fVarJ, zL, num == null ? 0 : num.intValue());
        }
    }

    public static final class d extends kn.n0 implements jn.l<dp.c, k0> {
        public d() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final k0 invoke(@os.l dp.c cVar) {
            kn.l0.p(cVar, "fqName");
            return new ho.m(j0.this.f4602b, cVar);
        }
    }

    public j0(@os.l up.n nVar, @os.l h0 h0Var) {
        kn.l0.p(nVar, "storageManager");
        kn.l0.p(h0Var, "module");
        this.f4601a = nVar;
        this.f4602b = h0Var;
        this.f4603c = nVar.a(new d());
        this.f4604d = nVar.a(new c());
    }

    @os.l
    public final e d(@os.l dp.b bVar, @os.l List<Integer> list) {
        kn.l0.p(bVar, "classId");
        kn.l0.p(list, "typeParametersCount");
        return this.f4604d.invoke(new a(bVar, list));
    }
}
