package ho;

import eo.p0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import nm.d1;

/* JADX INFO: loaded from: classes3.dex */
public final class x extends j implements eo.h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final up.n f7456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final ao.h f7457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.m
    public final ep.c f7458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.m
    public final dp.f f7459f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final Map<eo.g0<?>, Object> f7460g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final a0 f7461i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.m
    public v f7462n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.m
    public eo.l0 f7463p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f7464v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final up.g<dp.c, p0> f7465w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public final lm.d0 f7466x;

    public static final class a extends kn.n0 implements jn.a<i> {
        public a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // jn.a
        @os.l
        public final i invoke() {
            x xVar = x.this;
            v vVar = xVar.f7462n;
            if (vVar == null) {
                throw new AssertionError("Dependencies of module " + xVar.J0() + " were not set before querying module content");
            }
            List<x> listA = vVar.a();
            x.this.I0();
            listA.contains(x.this);
            List<x> list = listA;
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((x) it.next()).N0();
            }
            ArrayList arrayList = new ArrayList(nm.z.b0(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                eo.l0 l0Var = ((x) it2.next()).f7463p;
                kn.l0.m(l0Var);
                arrayList.add(l0Var);
            }
            return new i(arrayList, kn.l0.C("CompositeProvider@ModuleDescriptor for ", x.this.getName()));
        }
    }

    public static final class b extends kn.n0 implements jn.l<dp.c, p0> {
        public b() {
            super(1);
        }

        @Override // jn.l
        @os.l
        public final p0 invoke(@os.l dp.c cVar) {
            kn.l0.p(cVar, "fqName");
            x xVar = x.this;
            return xVar.f7461i.a(xVar, cVar, xVar.f7456c);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @in.j
    public x(@os.l dp.f fVar, @os.l up.n nVar, @os.l ao.h hVar, @os.m ep.c cVar) {
        this(fVar, nVar, hVar, cVar, null, null, 48, null);
        kn.l0.p(fVar, "moduleName");
        kn.l0.p(nVar, "storageManager");
        kn.l0.p(hVar, "builtIns");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N0() {
        return this.f7463p != null;
    }

    @Override // eo.m
    public <R, D> R A(@os.l eo.o<R, D> oVar, D d10) {
        return (R) eo.h0.a.a(this, oVar, d10);
    }

    @Override // eo.h0
    public boolean E(@os.l eo.h0 h0Var) {
        kn.l0.p(h0Var, "targetModule");
        if (kn.l0.g(this, h0Var)) {
            return true;
        }
        v vVar = this.f7462n;
        kn.l0.m(vVar);
        return nm.h0.W1(vVar.c(), h0Var) || v0().contains(h0Var) || h0Var.v0().contains(this);
    }

    public void I0() {
        if (this.f7464v) {
            return;
        }
        eo.b0.a(this);
    }

    public final String J0() {
        String str = getName().f3820a;
        kn.l0.o(str, "name.toString()");
        return str;
    }

    @os.l
    public final eo.l0 K0() {
        I0();
        return L0();
    }

    public final i L0() {
        return (i) this.f7466x.getValue();
    }

    @Override // eo.h0
    @os.m
    public <T> T M(@os.l eo.g0<T> g0Var) {
        kn.l0.p(g0Var, "capability");
        return (T) this.f7460g.get(g0Var);
    }

    public final void M0(@os.l eo.l0 l0Var) {
        kn.l0.p(l0Var, "providerForModuleContent");
        N0();
        this.f7463p = l0Var;
    }

    public boolean O0() {
        return this.f7464v;
    }

    public final void P0(@os.l v vVar) {
        kn.l0.p(vVar, "dependencies");
        this.f7462n = vVar;
    }

    public final void Q0(@os.l List<x> list) {
        kn.l0.p(list, "descriptors");
        R0(list, nm.m0.INSTANCE);
    }

    public final void R0(@os.l List<x> list, @os.l Set<x> set) {
        kn.l0.p(list, "descriptors");
        kn.l0.p(set, "friends");
        P0(new w(list, set, nm.k0.INSTANCE, nm.m0.INSTANCE));
    }

    public final void S0(@os.l x... xVarArr) {
        kn.l0.p(xVarArr, "descriptors");
        Q0(nm.r.Ky(xVarArr));
    }

    @Override // eo.m
    @os.m
    public eo.m b() {
        return eo.h0.a.b(this);
    }

    @Override // eo.h0
    @os.l
    public ao.h n() {
        return this.f7457d;
    }

    @Override // eo.h0
    @os.l
    public p0 o0(@os.l dp.c cVar) {
        kn.l0.p(cVar, "fqName");
        I0();
        return this.f7465w.invoke(cVar);
    }

    @Override // eo.h0
    @os.l
    public Collection<dp.c> p(@os.l dp.c cVar, @os.l jn.l<? super dp.f, Boolean> lVar) {
        kn.l0.p(cVar, "fqName");
        kn.l0.p(lVar, "nameFilter");
        I0();
        return K0().p(cVar, lVar);
    }

    @Override // eo.h0
    @os.l
    public List<eo.h0> v0() {
        v vVar = this.f7462n;
        if (vVar != null) {
            return vVar.b();
        }
        throw new AssertionError("Dependencies of module " + J0() + " were not set");
    }

    public /* synthetic */ x(dp.f fVar, up.n nVar, ao.h hVar, ep.c cVar, Map map, dp.f fVar2, int i10, kn.w wVar) {
        this(fVar, nVar, hVar, (i10 & 8) != 0 ? null : cVar, (i10 & 16) != 0 ? d1.z() : map, (i10 & 32) != 0 ? null : fVar2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @in.j
    public x(@os.l dp.f fVar, @os.l up.n nVar, @os.l ao.h hVar, @os.m ep.c cVar, @os.l Map<eo.g0<?>, ? extends Object> map, @os.m dp.f fVar2) {
        super(fo.g.a.f6169b, fVar);
        kn.l0.p(fVar, "moduleName");
        kn.l0.p(nVar, "storageManager");
        kn.l0.p(hVar, "builtIns");
        kn.l0.p(map, "capabilities");
        fo.g.f6167h.getClass();
        this.f7456c = nVar;
        this.f7457d = hVar;
        this.f7458e = cVar;
        this.f7459f = fVar2;
        if (fVar.f3821b) {
            this.f7460g = map;
            a0.f7289a.getClass();
            a0 a0Var = (a0) M(a0.a.f7291b);
            this.f7461i = a0Var == null ? a0.b.f7292b : a0Var;
            this.f7464v = true;
            this.f7465w = nVar.a(new b());
            this.f7466x = lm.f0.b(new a());
            return;
        }
        throw new IllegalArgumentException(kn.l0.C("Module name must be special: ", fVar));
    }
}
