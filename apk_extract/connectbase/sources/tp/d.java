package tp;

import eo.y;
import eo.z0;
import fp.q;
import kn.l0;
import kn.w;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends ho.f implements c {

    @os.l
    public final yo.a.d X;

    @os.l
    public final ap.c Y;

    @os.l
    public final ap.g Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    @os.l
    public final ap.h f15954a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    @os.m
    public final g f15955b0;

    public /* synthetic */ d(eo.e eVar, eo.l lVar, fo.g gVar, boolean z10, eo.b.a aVar, yo.a.d dVar, ap.c cVar, ap.g gVar2, ap.h hVar, g gVar3, z0 z0Var, int i10, w wVar) {
        this(eVar, lVar, gVar, z10, aVar, dVar, cVar, gVar2, hVar, gVar3, (i10 & 1024) != 0 ? null : z0Var);
    }

    @Override // ho.p, eo.y
    public boolean D() {
        return false;
    }

    @Override // tp.h
    @os.l
    public ap.g H() {
        return this.Z;
    }

    @Override // tp.h
    @os.l
    public ap.c K() {
        return this.Y;
    }

    @Override // tp.h
    @os.m
    public g L() {
        return this.f15955b0;
    }

    @Override // tp.h
    public q d0() {
        return this.X;
    }

    @Override // ho.p, eo.d0
    public boolean isExternal() {
        return false;
    }

    @Override // ho.p, eo.y
    public boolean isInline() {
        return false;
    }

    @Override // ho.p, eo.y
    public boolean isSuspend() {
        return false;
    }

    @Override // ho.f
    @os.l
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public d F0(@os.l eo.m mVar, @os.m y yVar, @os.l eo.b.a aVar, @os.m dp.f fVar, @os.l fo.g gVar, @os.l z0 z0Var) {
        l0.p(mVar, "newOwner");
        l0.p(aVar, "kind");
        l0.p(gVar, "annotations");
        l0.p(z0Var, "source");
        d dVar = new d((eo.e) mVar, (eo.l) yVar, gVar, this.V, aVar, this.X, this.Y, this.Z, this.f15954a0, this.f15955b0, z0Var);
        dVar.N = this.N;
        return dVar;
    }

    @os.l
    public yo.a.d m1() {
        return this.X;
    }

    @os.l
    public ap.h n1() {
        return this.f15954a0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@os.l eo.e eVar, @os.m eo.l lVar, @os.l fo.g gVar, boolean z10, @os.l eo.b.a aVar, @os.l yo.a.d dVar, @os.l ap.c cVar, @os.l ap.g gVar2, @os.l ap.h hVar, @os.m g gVar3, @os.m z0 z0Var) {
        super(eVar, lVar, gVar, z10, aVar, z0Var == null ? z0.f4654a : z0Var);
        l0.p(eVar, "containingDeclaration");
        l0.p(gVar, "annotations");
        l0.p(aVar, "kind");
        l0.p(dVar, "proto");
        l0.p(cVar, "nameResolver");
        l0.p(gVar2, "typeTable");
        l0.p(hVar, "versionRequirementTable");
        this.X = dVar;
        this.Y = cVar;
        this.Z = gVar2;
        this.f15954a0 = hVar;
        this.f15955b0 = gVar3;
    }
}
