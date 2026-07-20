package ho;

import eo.d1;
import eo.e1;
import eo.z0;
import ik.y0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import vp.a1;
import vp.j1;
import vp.n1;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends k implements d1 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final eo.u f7321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<? extends e1> f7322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final c f7323g;

    public static final class a extends kn.n0 implements jn.l<wp.g, vp.n0> {
        public a() {
            super(1);
        }

        @Override // jn.l
        public final vp.n0 invoke(wp.g gVar) {
            eo.h hVarF = gVar.f(d.this);
            if (hVarF == null) {
                return null;
            }
            return hVarF.q();
        }
    }

    public static final class b extends kn.n0 implements jn.l<n1, Boolean> {
        public b() {
            super(1);
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0027  */
        @Override // jn.l
        public final Boolean invoke(n1 n1Var) {
            boolean z10;
            kn.l0.o(n1Var, y0.a.f8215h);
            if (vp.h0.a(n1Var)) {
                z10 = false;
            } else {
                d dVar = d.this;
                eo.h hVarD = n1Var.G0().d();
                if (!(hVarD instanceof e1) || kn.l0.g(((e1) hVarD).b(), dVar)) {
                    z10 = false;
                } else {
                    z10 = true;
                }
            }
            return Boolean.valueOf(z10);
        }
    }

    public static final class c implements a1 {
        public c() {
        }

        @Override // vp.a1
        @os.l
        public Collection<vp.f0> a() {
            Collection<vp.f0> collectionA = d.this.r0().G0().a();
            kn.l0.o(collectionA, "declarationDescriptor.un…pe.constructor.supertypes");
            return collectionA;
        }

        @Override // vp.a1
        @os.l
        public a1 b(@os.l wp.g gVar) {
            kn.l0.p(gVar, "kotlinTypeRefiner");
            return this;
        }

        @Override // vp.a1
        public eo.h d() {
            return d.this;
        }

        @Override // vp.a1
        public boolean e() {
            return true;
        }

        @os.l
        public d1 f() {
            return d.this;
        }

        @Override // vp.a1
        @os.l
        public List<e1> getParameters() {
            return d.this.G0();
        }

        @Override // vp.a1
        @os.l
        public ao.h n() {
            return lp.a.g(d.this);
        }

        @os.l
        public String toString() {
            return "[typealias " + d.this.getName().b() + ']';
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l z0 z0Var, @os.l eo.u uVar) {
        super(mVar, gVar, fVar, z0Var);
        kn.l0.p(mVar, "containingDeclaration");
        kn.l0.p(gVar, "annotations");
        kn.l0.p(fVar, "name");
        kn.l0.p(z0Var, "sourceElement");
        kn.l0.p(uVar, "visibilityImpl");
        this.f7321e = uVar;
        this.f7323g = new c();
    }

    @Override // eo.m
    public <R, D> R A(@os.l eo.o<R, D> oVar, D d10) {
        kn.l0.p(oVar, "visitor");
        return oVar.i(this, d10);
    }

    @os.l
    public final vp.n0 B0() {
        eo.e eVarV = v();
        vp.n0 n0VarU = j1.u(this, eVarV == null ? op.h.c.f12406b : eVarV.X(), new a());
        kn.l0.o(n0VarU, "@OptIn(TypeRefinement::c…s)?.defaultType\n        }");
        return n0VarU;
    }

    @Override // ho.k
    @os.l
    /* JADX INFO: renamed from: E0, reason: merged with bridge method [inline-methods] */
    public d1 a() {
        return this;
    }

    @os.l
    public final Collection<i0> F0() {
        eo.e eVarV = v();
        if (eVarV == null) {
            return nm.k0.INSTANCE;
        }
        Collection<eo.d> collectionG = eVarV.g();
        kn.l0.o(collectionG, "classDescriptor.constructors");
        ArrayList arrayList = new ArrayList();
        for (eo.d dVar : collectionG) {
            j0.a aVar = j0.Z;
            up.n nVarP = P();
            kn.l0.o(dVar, "it");
            i0 i0VarB = aVar.b(nVarP, this, dVar);
            if (i0VarB != null) {
                arrayList.add(i0VarB);
            }
        }
        return arrayList;
    }

    @os.l
    public abstract List<e1> G0();

    public final void H0(@os.l List<? extends e1> list) {
        kn.l0.p(list, "declaredTypeParameters");
        this.f7322f = list;
    }

    @os.l
    public abstract up.n P();

    @Override // eo.d0
    public boolean Y() {
        return false;
    }

    @Override // eo.q, eo.d0
    @os.l
    public eo.u getVisibility() {
        return this.f7321e;
    }

    @Override // eo.h
    @os.l
    public a1 i() {
        return this.f7323g;
    }

    @Override // eo.d0
    public boolean i0() {
        return false;
    }

    @Override // eo.d0
    public boolean isExternal() {
        return false;
    }

    @Override // eo.i
    public boolean l() {
        return j1.c(r0(), new b());
    }

    @Override // eo.i
    @os.l
    public List<e1> r() {
        List list = this.f7322f;
        if (list != null) {
            return list;
        }
        kn.l0.S("declaredTypeParametersImpl");
        return null;
    }

    @Override // eo.d0
    @os.l
    public eo.e0 s() {
        return eo.e0.FINAL;
    }

    @Override // ho.j
    @os.l
    public String toString() {
        return kn.l0.C("typealias ", getName().b());
    }
}
