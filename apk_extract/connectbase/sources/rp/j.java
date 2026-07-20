package rp;

import eo.h0;
import eo.j0;
import eo.k0;
import eo.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final up.n f14727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final h0 f14728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final k f14729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final g f14730d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final c<fo.c, jp.g<?>> f14731e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final l0 f14732f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.l
    public final u f14733g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final q f14734h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final mo.c f14735i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @os.l
    public final r f14736j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @os.l
    public final Iterable<go.b> f14737k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @os.l
    public final j0 f14738l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @os.l
    public final i f14739m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @os.l
    public final go.a f14740n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @os.l
    public final go.c f14741o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @os.l
    public final fp.g f14742p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @os.l
    public final wp.l f14743q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @os.l
    public final np.a f14744r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @os.l
    public final go.e f14745s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @os.l
    public final h f14746t;

    /* JADX WARN: Multi-variable type inference failed */
    public j(@os.l up.n nVar, @os.l h0 h0Var, @os.l k kVar, @os.l g gVar, @os.l c<? extends fo.c, ? extends jp.g<?>> cVar, @os.l l0 l0Var, @os.l u uVar, @os.l q qVar, @os.l mo.c cVar2, @os.l r rVar, @os.l Iterable<? extends go.b> iterable, @os.l j0 j0Var, @os.l i iVar, @os.l go.a aVar, @os.l go.c cVar3, @os.l fp.g gVar2, @os.l wp.l lVar, @os.l np.a aVar2, @os.l go.e eVar) {
        kn.l0.p(nVar, "storageManager");
        kn.l0.p(h0Var, "moduleDescriptor");
        kn.l0.p(kVar, "configuration");
        kn.l0.p(gVar, "classDataFinder");
        kn.l0.p(cVar, "annotationAndConstantLoader");
        kn.l0.p(l0Var, "packageFragmentProvider");
        kn.l0.p(uVar, "localClassifierTypeSettings");
        kn.l0.p(qVar, "errorReporter");
        kn.l0.p(cVar2, "lookupTracker");
        kn.l0.p(rVar, "flexibleTypeDeserializer");
        kn.l0.p(iterable, "fictitiousClassDescriptorFactories");
        kn.l0.p(j0Var, "notFoundClasses");
        kn.l0.p(iVar, "contractDeserializer");
        kn.l0.p(aVar, "additionalClassPartsProvider");
        kn.l0.p(cVar3, "platformDependentDeclarationFilter");
        kn.l0.p(gVar2, "extensionRegistryLite");
        kn.l0.p(lVar, "kotlinTypeChecker");
        kn.l0.p(aVar2, "samConversionResolver");
        kn.l0.p(eVar, "platformDependentTypeTransformer");
        this.f14727a = nVar;
        this.f14728b = h0Var;
        this.f14729c = kVar;
        this.f14730d = gVar;
        this.f14731e = cVar;
        this.f14732f = l0Var;
        this.f14733g = uVar;
        this.f14734h = qVar;
        this.f14735i = cVar2;
        this.f14736j = rVar;
        this.f14737k = iterable;
        this.f14738l = j0Var;
        this.f14739m = iVar;
        this.f14740n = aVar;
        this.f14741o = cVar3;
        this.f14742p = gVar2;
        this.f14743q = lVar;
        this.f14744r = aVar2;
        this.f14745s = eVar;
        this.f14746t = new h(this);
    }

    @os.l
    public final l a(@os.l k0 k0Var, @os.l ap.c cVar, @os.l ap.g gVar, @os.l ap.h hVar, @os.l ap.a aVar, @os.m tp.g gVar2) {
        kn.l0.p(k0Var, "descriptor");
        kn.l0.p(cVar, "nameResolver");
        kn.l0.p(gVar, "typeTable");
        kn.l0.p(hVar, "versionRequirementTable");
        kn.l0.p(aVar, "metadataVersion");
        return new l(this, cVar, k0Var, gVar, hVar, aVar, gVar2, null, nm.k0.INSTANCE);
    }

    @os.m
    public final eo.e b(@os.l dp.b bVar) {
        kn.l0.p(bVar, "classId");
        return h.e(this.f14746t, bVar, null, 2, null);
    }

    @os.l
    public final go.a c() {
        return this.f14740n;
    }

    @os.l
    public final c<fo.c, jp.g<?>> d() {
        return this.f14731e;
    }

    @os.l
    public final g e() {
        return this.f14730d;
    }

    @os.l
    public final h f() {
        return this.f14746t;
    }

    @os.l
    public final k g() {
        return this.f14729c;
    }

    @os.l
    public final i h() {
        return this.f14739m;
    }

    @os.l
    public final q i() {
        return this.f14734h;
    }

    @os.l
    public final fp.g j() {
        return this.f14742p;
    }

    @os.l
    public final Iterable<go.b> k() {
        return this.f14737k;
    }

    @os.l
    public final r l() {
        return this.f14736j;
    }

    @os.l
    public final wp.l m() {
        return this.f14743q;
    }

    @os.l
    public final u n() {
        return this.f14733g;
    }

    @os.l
    public final mo.c o() {
        return this.f14735i;
    }

    @os.l
    public final h0 p() {
        return this.f14728b;
    }

    @os.l
    public final j0 q() {
        return this.f14738l;
    }

    @os.l
    public final l0 r() {
        return this.f14732f;
    }

    @os.l
    public final go.c s() {
        return this.f14741o;
    }

    @os.l
    public final go.e t() {
        return this.f14745s;
    }

    @os.l
    public final up.n u() {
        return this.f14727a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public j(up.n nVar, h0 h0Var, k kVar, g gVar, c cVar, l0 l0Var, u uVar, q qVar, mo.c cVar2, r rVar, Iterable iterable, j0 j0Var, i iVar, go.a aVar, go.c cVar3, fp.g gVar2, wp.l lVar, np.a aVar2, go.e eVar, int i10, kn.w wVar) {
        wp.l lVar2;
        go.a aVar3 = (i10 & 8192) != 0 ? go.a.C0182a.f6752a : aVar;
        go.c cVar4 = (i10 & 16384) != 0 ? go.c.a.f6753a : cVar3;
        if ((65536 & i10) != 0) {
            wp.l.f19866b.getClass();
            lVar2 = wp.l.a.f19868b;
        } else {
            lVar2 = lVar;
        }
        this(nVar, h0Var, kVar, gVar, cVar, l0Var, uVar, qVar, cVar2, rVar, iterable, j0Var, iVar, aVar3, cVar4, gVar2, lVar2, aVar2, (i10 & 262144) != 0 ? go.e.a.f6756a : eVar);
    }
}
