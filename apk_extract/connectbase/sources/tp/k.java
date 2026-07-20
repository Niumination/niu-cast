package tp;

import eo.e0;
import eo.t0;
import eo.u;
import eo.z0;
import fp.q;
import ho.c0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends c0 implements c {

    @os.l
    public final yo.a.n U;

    @os.l
    public final ap.c V;

    @os.l
    public final ap.g W;

    @os.l
    public final ap.h X;

    @os.m
    public final g Y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@os.l eo.m mVar, @os.m t0 t0Var, @os.l fo.g gVar, @os.l e0 e0Var, @os.l u uVar, boolean z10, @os.l dp.f fVar, @os.l eo.b.a aVar, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, @os.l yo.a.n nVar, @os.l ap.c cVar, @os.l ap.g gVar2, @os.l ap.h hVar, @os.m g gVar3) {
        super(mVar, t0Var, gVar, e0Var, uVar, z10, fVar, aVar, z0.f4654a, z11, z12, z15, false, z13, z14);
        l0.p(mVar, "containingDeclaration");
        l0.p(gVar, "annotations");
        l0.p(e0Var, "modality");
        l0.p(uVar, "visibility");
        l0.p(fVar, "name");
        l0.p(aVar, "kind");
        l0.p(nVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar2, "typeTable");
        l0.p(hVar, "versionRequirementTable");
        this.U = nVar;
        this.V = cVar;
        this.W = gVar2;
        this.X = hVar;
        this.Y = gVar3;
    }

    @Override // tp.h
    @os.l
    public ap.g H() {
        return this.W;
    }

    @Override // ho.c0
    @os.l
    public c0 J0(@os.l eo.m mVar, @os.l e0 e0Var, @os.l u uVar, @os.m t0 t0Var, @os.l eo.b.a aVar, @os.l dp.f fVar, @os.l z0 z0Var) {
        l0.p(mVar, "newOwner");
        l0.p(e0Var, "newModality");
        l0.p(uVar, "newVisibility");
        l0.p(aVar, "kind");
        l0.p(fVar, "newName");
        l0.p(z0Var, "source");
        return new k(mVar, t0Var, getAnnotations(), e0Var, uVar, this.f7395g, fVar, aVar, this.f7307z, this.H, isExternal(), this.L, this.I, this.U, this.V, this.W, this.X, this.Y);
    }

    @Override // tp.h
    @os.l
    public ap.c K() {
        return this.V;
    }

    @Override // tp.h
    @os.m
    public g L() {
        return this.Y;
    }

    @os.l
    public yo.a.n X0() {
        return this.U;
    }

    @os.l
    public ap.h Y0() {
        return this.X;
    }

    @Override // tp.h
    public q d0() {
        return this.U;
    }

    @Override // ho.c0, eo.d0
    public boolean isExternal() {
        Boolean boolD = ap.b.D.d(this.U.getFlags());
        l0.o(boolD, "IS_EXTERNAL_PROPERTY.get(proto.flags)");
        return boolD.booleanValue();
    }
}
