package ho;

import eo.h1;
import eo.j1;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class l0 extends m0 implements h1 {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.l
    public static final a f7366x = new a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f7367g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f7368i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f7369n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f7370p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.m
    public final vp.f0 f7371v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final h1 f7372w;

    public static final class a {
        public a() {
        }

        @in.n
        @os.l
        public final l0 a(@os.l eo.a aVar, @os.m h1 h1Var, int i10, @os.l fo.g gVar, @os.l dp.f fVar, @os.l vp.f0 f0Var, boolean z10, boolean z11, boolean z12, @os.m vp.f0 f0Var2, @os.l z0 z0Var, @os.m jn.a<? extends List<? extends j1>> aVar2) {
            kn.l0.p(aVar, "containingDeclaration");
            kn.l0.p(gVar, "annotations");
            kn.l0.p(fVar, "name");
            kn.l0.p(f0Var, "outType");
            kn.l0.p(z0Var, "source");
            return aVar2 == null ? new l0(aVar, h1Var, i10, gVar, fVar, f0Var, z10, z11, z12, f0Var2, z0Var) : new b(aVar, h1Var, i10, gVar, fVar, f0Var, z10, z11, z12, f0Var2, z0Var, aVar2);
        }

        public a(kn.w wVar) {
        }
    }

    public static final class b extends l0 {

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @os.l
        public final lm.d0 f7373y;

        public static final class a extends kn.n0 implements jn.a<List<? extends j1>> {
            public a() {
                super(0);
            }

            @Override // jn.a
            @os.l
            public final List<? extends j1> invoke() {
                return b.this.I0();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@os.l eo.a aVar, @os.m h1 h1Var, int i10, @os.l fo.g gVar, @os.l dp.f fVar, @os.l vp.f0 f0Var, boolean z10, boolean z11, boolean z12, @os.m vp.f0 f0Var2, @os.l z0 z0Var, @os.l jn.a<? extends List<? extends j1>> aVar2) {
            super(aVar, h1Var, i10, gVar, fVar, f0Var, z10, z11, z12, f0Var2, z0Var);
            kn.l0.p(aVar, "containingDeclaration");
            kn.l0.p(gVar, "annotations");
            kn.l0.p(fVar, "name");
            kn.l0.p(f0Var, "outType");
            kn.l0.p(z0Var, "source");
            kn.l0.p(aVar2, "destructuringVariables");
            this.f7373y = lm.f0.b(aVar2);
        }

        @Override // ho.l0, eo.h1
        @os.l
        public h1 F(@os.l eo.a aVar, @os.l dp.f fVar, int i10) {
            kn.l0.p(aVar, "newOwner");
            kn.l0.p(fVar, "newName");
            fo.g annotations = getAnnotations();
            kn.l0.o(annotations, "annotations");
            vp.f0 type = getType();
            kn.l0.o(type, y0.a.f8215h);
            boolean zW0 = w0();
            boolean z10 = this.f7369n;
            boolean z11 = this.f7370p;
            vp.f0 f0Var = this.f7371v;
            z0 z0Var = z0.f4654a;
            kn.l0.o(z0Var, "NO_SOURCE");
            return new b(aVar, null, i10, annotations, fVar, type, zW0, z10, z11, f0Var, z0Var, new a());
        }

        @os.l
        public final List<j1> I0() {
            return (List) this.f7373y.getValue();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(@os.l eo.a aVar, @os.m h1 h1Var, int i10, @os.l fo.g gVar, @os.l dp.f fVar, @os.l vp.f0 f0Var, boolean z10, boolean z11, boolean z12, @os.m vp.f0 f0Var2, @os.l z0 z0Var) {
        super(aVar, gVar, fVar, f0Var, z0Var);
        kn.l0.p(aVar, "containingDeclaration");
        kn.l0.p(gVar, "annotations");
        kn.l0.p(fVar, "name");
        kn.l0.p(f0Var, "outType");
        kn.l0.p(z0Var, "source");
        this.f7367g = i10;
        this.f7368i = z10;
        this.f7369n = z11;
        this.f7370p = z12;
        this.f7371v = f0Var2;
        this.f7372w = h1Var == null ? this : h1Var;
    }

    @in.n
    @os.l
    public static final l0 F0(@os.l eo.a aVar, @os.m h1 h1Var, int i10, @os.l fo.g gVar, @os.l dp.f fVar, @os.l vp.f0 f0Var, boolean z10, boolean z11, boolean z12, @os.m vp.f0 f0Var2, @os.l z0 z0Var, @os.m jn.a<? extends List<? extends j1>> aVar2) {
        return f7366x.a(aVar, h1Var, i10, gVar, fVar, f0Var, z10, z11, z12, f0Var2, z0Var, aVar2);
    }

    @Override // eo.m
    public <R, D> R A(@os.l eo.o<R, D> oVar, D d10) {
        kn.l0.p(oVar, "visitor");
        return oVar.k(this, d10);
    }

    @Override // eo.h1
    @os.l
    public h1 F(@os.l eo.a aVar, @os.l dp.f fVar, int i10) {
        kn.l0.p(aVar, "newOwner");
        kn.l0.p(fVar, "newName");
        fo.g annotations = getAnnotations();
        kn.l0.o(annotations, "annotations");
        vp.f0 type = getType();
        kn.l0.o(type, y0.a.f8215h);
        boolean zW0 = w0();
        boolean zP0 = p0();
        boolean zN0 = n0();
        vp.f0 f0VarS0 = s0();
        z0 z0Var = z0.f4654a;
        kn.l0.o(z0Var, "NO_SOURCE");
        return new l0(aVar, null, i10, annotations, fVar, type, zW0, zP0, zN0, f0VarS0, z0Var);
    }

    @os.m
    public Void G0() {
        return null;
    }

    @Override // eo.b1
    @os.l
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public h1 c(@os.l vp.h1 h1Var) {
        kn.l0.p(h1Var, "substitutor");
        if (h1Var.k()) {
            return this;
        }
        throw new UnsupportedOperationException();
    }

    @Override // eo.j1
    public boolean Q() {
        return false;
    }

    @Override // ho.m0, eo.a
    @os.l
    public Collection<h1> d() {
        Collection<? extends eo.a> collectionD = b().d();
        kn.l0.o(collectionD, "containingDeclaration.overriddenDescriptors");
        Collection<? extends eo.a> collection = collectionD;
        ArrayList arrayList = new ArrayList(nm.z.b0(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(((eo.a) it.next()).h().get(f()));
        }
        return arrayList;
    }

    @Override // eo.h1
    public int f() {
        return this.f7367g;
    }

    @Override // eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        eo.u uVar = eo.t.f4634f;
        kn.l0.o(uVar, "LOCAL");
        return uVar;
    }

    @Override // eo.j1
    public /* bridge */ /* synthetic */ jp.g m0() {
        return (jp.g) G0();
    }

    @Override // eo.h1
    public boolean n0() {
        return this.f7370p;
    }

    @Override // eo.h1
    public boolean p0() {
        return this.f7369n;
    }

    @Override // eo.h1
    @os.m
    public vp.f0 s0() {
        return this.f7371v;
    }

    @Override // eo.j1
    public boolean u0() {
        return h1.a.a(this);
    }

    @Override // eo.h1
    public boolean w0() {
        return this.f7368i && ((eo.b) b()).getKind().isReal();
    }

    @Override // ho.k, eo.m
    @os.l
    public eo.a b() {
        return (eo.a) super.b();
    }

    @Override // ho.m0, ho.k
    @os.l
    public h1 a() {
        h1 h1Var = this.f7372w;
        return h1Var == this ? this : h1Var.a();
    }
}
