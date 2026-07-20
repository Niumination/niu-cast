package tp;

import eo.y;
import eo.y0;
import eo.z0;
import fp.q;
import ho.g0;
import ho.p;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends g0 implements c {

    @os.l
    public final yo.a.i V;

    @os.l
    public final ap.c W;

    @os.l
    public final ap.g X;

    @os.l
    public final ap.h Y;

    @os.m
    public final g Z;

    public /* synthetic */ l(eo.m mVar, y0 y0Var, fo.g gVar, dp.f fVar, eo.b.a aVar, yo.a.i iVar, ap.c cVar, ap.g gVar2, ap.h hVar, g gVar3, z0 z0Var, int i10, w wVar) {
        this(mVar, y0Var, gVar, fVar, aVar, iVar, cVar, gVar2, hVar, gVar3, (i10 & 1024) != 0 ? null : z0Var);
    }

    @Override // ho.g0, ho.p
    @os.l
    public p F0(@os.l eo.m mVar, @os.m y yVar, @os.l eo.b.a aVar, @os.m dp.f fVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        dp.f fVar2;
        l0.p(mVar, "newOwner");
        l0.p(aVar, "kind");
        l0.p(gVar, "annotations");
        l0.p(z0Var, "source");
        y0 y0Var = (y0) yVar;
        if (fVar == null) {
            dp.f name = getName();
            l0.o(name, "name");
            fVar2 = name;
        } else {
            fVar2 = fVar;
        }
        l lVar = new l(mVar, y0Var, gVar, fVar2, aVar, this.V, this.W, this.X, this.Y, this.Z, z0Var);
        lVar.N = this.N;
        return lVar;
    }

    @Override // tp.h
    @os.l
    public ap.g H() {
        return this.X;
    }

    @Override // tp.h
    @os.l
    public ap.c K() {
        return this.W;
    }

    @Override // tp.h
    @os.m
    public g L() {
        return this.Z;
    }

    @Override // tp.h
    public q d0() {
        return this.V;
    }

    @os.l
    public yo.a.i j1() {
        return this.V;
    }

    @os.l
    public ap.h k1() {
        return this.Y;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(@os.l eo.m mVar, @os.m y0 y0Var, @os.l fo.g gVar, @os.l dp.f fVar, @os.l eo.b.a aVar, @os.l yo.a.i iVar, @os.l ap.c cVar, @os.l ap.g gVar2, @os.l ap.h hVar, @os.m g gVar3, @os.m z0 z0Var) {
        super(mVar, y0Var, gVar, fVar, aVar, z0Var == null ? z0.f4654a : z0Var);
        l0.p(mVar, "containingDeclaration");
        l0.p(gVar, "annotations");
        l0.p(fVar, "name");
        l0.p(aVar, "kind");
        l0.p(iVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar2, "typeTable");
        l0.p(hVar, "versionRequirementTable");
        this.V = iVar;
        this.W = cVar;
        this.X = gVar2;
        this.Y = hVar;
        this.Z = gVar3;
    }
}
