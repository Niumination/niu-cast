package ho;

import eo.p0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kn.g1;
import kn.l1;
import kn.m1;

/* JADX INFO: loaded from: classes3.dex */
public class r extends j implements p0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ un.o<Object>[] f7437i;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final x f7438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final dp.c f7439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final up.i f7440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final up.i f7441f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final op.h f7442g;

    public static final class a extends kn.n0 implements jn.a<Boolean> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final Boolean invoke() {
            return Boolean.valueOf(eo.n0.b(r.this.x0().K0(), r.this.e()));
        }
    }

    public static final class b extends kn.n0 implements jn.a<List<? extends eo.k0>> {
        public b() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final List<? extends eo.k0> invoke() {
            return eo.n0.c(r.this.x0().K0(), r.this.e());
        }
    }

    public static final class c extends kn.n0 implements jn.a<op.h> {
        public c() {
            super(0);
        }

        @Override // jn.a
        @os.l
        public final op.h invoke() {
            if (r.this.isEmpty()) {
                return op.h.c.f12406b;
            }
            List<eo.k0> listG0 = r.this.g0();
            ArrayList arrayList = new ArrayList(nm.z.b0(listG0, 10));
            Iterator<T> it = listG0.iterator();
            while (it.hasNext()) {
                arrayList.add(((eo.k0) it.next()).o());
            }
            List listF4 = nm.h0.F4(arrayList, new h0(r.this.x0(), r.this.e()));
            return op.b.f12362d.a("package view scope for " + r.this.e() + " in " + r.this.x0().getName(), listF4);
        }
    }

    static {
        g1 g1Var = new g1(l1.d(r.class), "fragments", "getFragments()Ljava/util/List;");
        m1 m1Var = l1.f9319a;
        f7437i = new un.o[]{m1Var.n(g1Var), m1Var.n(new g1(m1Var.d(r.class), "empty", "getEmpty()Z"))};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(@os.l x xVar, @os.l dp.c cVar, @os.l up.n nVar) {
        super(fo.g.a.f6169b, cVar.h());
        kn.l0.p(xVar, "module");
        kn.l0.p(cVar, "fqName");
        kn.l0.p(nVar, "storageManager");
        fo.g.f6167h.getClass();
        this.f7438c = xVar;
        this.f7439d = cVar;
        this.f7440e = nVar.h(new b());
        this.f7441f = nVar.h(new a());
        this.f7442g = new op.g(nVar, new c());
    }

    @Override // eo.m
    public <R, D> R A(@os.l eo.o<R, D> oVar, D d10) {
        kn.l0.p(oVar, "visitor");
        return oVar.a(this, d10);
    }

    public final boolean B0() {
        return ((Boolean) up.m.a(this.f7441f, this, f7437i[1])).booleanValue();
    }

    @Override // eo.p0
    @os.l
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public x x0() {
        return this.f7438c;
    }

    @Override // eo.p0
    @os.l
    public dp.c e() {
        return this.f7439d;
    }

    public boolean equals(@os.m Object obj) {
        p0 p0Var = obj instanceof p0 ? (p0) obj : null;
        return p0Var != null && kn.l0.g(e(), p0Var.e()) && kn.l0.g(x0(), p0Var.x0());
    }

    @Override // eo.m
    @os.m
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public p0 b() {
        if (e().d()) {
            return null;
        }
        x xVarX0 = x0();
        dp.c cVarE = e().e();
        kn.l0.o(cVarE, "fqName.parent()");
        return xVarX0.o0(cVarE);
    }

    @Override // eo.p0
    @os.l
    public List<eo.k0> g0() {
        return (List) up.m.a(this.f7440e, this, f7437i[0]);
    }

    public int hashCode() {
        return e().hashCode() + (x0().hashCode() * 31);
    }

    @Override // eo.p0
    public boolean isEmpty() {
        return B0();
    }

    @Override // eo.p0
    @os.l
    public op.h o() {
        return this.f7442g;
    }
}
