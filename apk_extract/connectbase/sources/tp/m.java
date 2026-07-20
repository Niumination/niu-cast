package tp;

import eo.d1;
import eo.e1;
import eo.f1;
import eo.u;
import eo.z0;
import fp.q;
import ho.i0;
import java.util.Collection;
import java.util.List;
import kn.l0;
import vp.f0;
import vp.g1;
import vp.h0;
import vp.h1;
import vp.n0;
import vp.o1;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends ho.d implements h {
    public n0 H;
    public List<? extends e1> I;
    public n0 J;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final up.n f16010i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final yo.a.r f16011n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final ap.c f16012p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @os.l
    public final ap.g f16013v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @os.l
    public final ap.h f16014w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @os.m
    public final g f16015x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Collection<? extends i0> f16016y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public n0 f16017z;

    /* JADX WARN: Illegal instructions before constructor call */
    public m(@os.l up.n nVar, @os.l eo.m mVar, @os.l fo.g gVar, @os.l dp.f fVar, @os.l u uVar, @os.l yo.a.r rVar, @os.l ap.c cVar, @os.l ap.g gVar2, @os.l ap.h hVar, @os.m g gVar3) {
        l0.p(nVar, "storageManager");
        l0.p(mVar, "containingDeclaration");
        l0.p(gVar, "annotations");
        l0.p(fVar, "name");
        l0.p(uVar, "visibility");
        l0.p(rVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar2, "typeTable");
        l0.p(hVar, "versionRequirementTable");
        z0 z0Var = z0.f4654a;
        l0.o(z0Var, "NO_SOURCE");
        super(mVar, gVar, fVar, z0Var, uVar);
        this.f16010i = nVar;
        this.f16011n = rVar;
        this.f16012p = cVar;
        this.f16013v = gVar2;
        this.f16014w = hVar;
        this.f16015x = gVar3;
    }

    @Override // ho.d
    @os.l
    public List<e1> G0() {
        List list = this.I;
        if (list != null) {
            return list;
        }
        l0.S("typeConstructorParameters");
        return null;
    }

    @Override // tp.h
    @os.l
    public ap.g H() {
        return this.f16013v;
    }

    @os.l
    public yo.a.r I0() {
        return this.f16011n;
    }

    @Override // eo.d1
    @os.l
    public n0 J() {
        n0 n0Var = this.H;
        if (n0Var != null) {
            return n0Var;
        }
        l0.S("expandedType");
        return null;
    }

    @os.l
    public ap.h J0() {
        return this.f16014w;
    }

    @Override // tp.h
    @os.l
    public ap.c K() {
        return this.f16012p;
    }

    public final void K0(@os.l List<? extends e1> list, @os.l n0 n0Var, @os.l n0 n0Var2) {
        l0.p(list, "declaredTypeParameters");
        l0.p(n0Var, "underlyingType");
        l0.p(n0Var2, "expandedType");
        H0(list);
        this.f16017z = n0Var;
        this.H = n0Var2;
        this.I = f1.d(this);
        this.J = B0();
        this.f16016y = F0();
    }

    @Override // tp.h
    @os.m
    public g L() {
        return this.f16015x;
    }

    @Override // eo.b1
    @os.l
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public d1 c(@os.l h1 h1Var) {
        l0.p(h1Var, "substitutor");
        if (h1Var.k()) {
            return this;
        }
        up.n nVar = this.f16010i;
        eo.m mVarB = b();
        l0.o(mVarB, "containingDeclaration");
        fo.g annotations = getAnnotations();
        l0.o(annotations, "annotations");
        dp.f name = getName();
        l0.o(name, "name");
        m mVar = new m(nVar, mVarB, annotations, name, this.f7321e, this.f16011n, this.f16012p, this.f16013v, this.f16014w, this.f16015x);
        List<e1> listR = r();
        n0 n0VarR0 = r0();
        o1 o1Var = o1.INVARIANT;
        f0 f0VarN = h1Var.n(n0VarR0, o1Var);
        l0.o(f0VarN, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        n0 n0VarA = g1.a(f0VarN);
        f0 f0VarN2 = h1Var.n(J(), o1Var);
        l0.o(f0VarN2, "substitutor.safeSubstitu…Type, Variance.INVARIANT)");
        mVar.K0(listR, n0VarA, g1.a(f0VarN2));
        return mVar;
    }

    @Override // ho.d
    @os.l
    public up.n P() {
        return this.f16010i;
    }

    @Override // tp.h
    public q d0() {
        return this.f16011n;
    }

    @Override // eo.h
    @os.l
    public n0 q() {
        n0 n0Var = this.J;
        if (n0Var != null) {
            return n0Var;
        }
        l0.S("defaultTypeImpl");
        return null;
    }

    @Override // eo.d1
    @os.l
    public n0 r0() {
        n0 n0Var = this.f16017z;
        if (n0Var != null) {
            return n0Var;
        }
        l0.S("underlyingType");
        return null;
    }

    @Override // eo.d1
    @os.m
    public eo.e v() {
        if (h0.a(J())) {
            return null;
        }
        eo.h hVarD = J().G0().d();
        if (hVarD instanceof eo.e) {
            return (eo.e) hVarD;
        }
        return null;
    }
}
