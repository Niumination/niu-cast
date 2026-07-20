package rp;

import java.util.List;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final j f14748a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ap.c f14749b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final eo.m f14750c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final ap.g f14751d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @os.l
    public final ap.h f14752e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @os.l
    public final ap.a f14753f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @os.m
    public final tp.g f14754g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @os.l
    public final d0 f14755h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @os.l
    public final w f14756i;

    public l(@os.l j jVar, @os.l ap.c cVar, @os.l eo.m mVar, @os.l ap.g gVar, @os.l ap.h hVar, @os.l ap.a aVar, @os.m tp.g gVar2, @os.m d0 d0Var, @os.l List<yo.a.s> list) {
        l0.p(jVar, "components");
        l0.p(cVar, "nameResolver");
        l0.p(mVar, "containingDeclaration");
        l0.p(gVar, "typeTable");
        l0.p(hVar, "versionRequirementTable");
        l0.p(aVar, "metadataVersion");
        l0.p(list, "typeParameters");
        this.f14748a = jVar;
        this.f14749b = cVar;
        this.f14750c = mVar;
        this.f14751d = gVar;
        this.f14752e = hVar;
        this.f14753f = aVar;
        this.f14754g = gVar2;
        this.f14755h = new d0(this, d0Var, list, "Deserializer for \"" + mVar.getName() + '\"', gVar2 == null ? "[container not found]" : gVar2.a());
        this.f14756i = new w(this);
    }

    public static /* synthetic */ l b(l lVar, eo.m mVar, List list, ap.c cVar, ap.g gVar, ap.h hVar, ap.a aVar, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            cVar = lVar.f14749b;
        }
        ap.c cVar2 = cVar;
        if ((i10 & 8) != 0) {
            gVar = lVar.f14751d;
        }
        ap.g gVar2 = gVar;
        if ((i10 & 16) != 0) {
            hVar = lVar.f14752e;
        }
        ap.h hVar2 = hVar;
        if ((i10 & 32) != 0) {
            aVar = lVar.f14753f;
        }
        return lVar.a(mVar, list, cVar2, gVar2, hVar2, aVar);
    }

    @os.l
    public final l a(@os.l eo.m mVar, @os.l List<yo.a.s> list, @os.l ap.c cVar, @os.l ap.g gVar, @os.l ap.h hVar, @os.l ap.a aVar) {
        l0.p(mVar, "descriptor");
        l0.p(list, "typeParameterProtos");
        l0.p(cVar, "nameResolver");
        l0.p(gVar, "typeTable");
        ap.h hVar2 = hVar;
        l0.p(hVar2, "versionRequirementTable");
        l0.p(aVar, "metadataVersion");
        j jVar = this.f14748a;
        if (!ap.i.b(aVar)) {
            hVar2 = this.f14752e;
        }
        return new l(jVar, cVar, mVar, gVar, hVar2, aVar, this.f14754g, this.f14755h, list);
    }

    @os.l
    public final j c() {
        return this.f14748a;
    }

    @os.m
    public final tp.g d() {
        return this.f14754g;
    }

    @os.l
    public final eo.m e() {
        return this.f14750c;
    }

    @os.l
    public final w f() {
        return this.f14756i;
    }

    @os.l
    public final ap.c g() {
        return this.f14749b;
    }

    @os.l
    public final up.n h() {
        return this.f14748a.f14727a;
    }

    @os.l
    public final d0 i() {
        return this.f14755h;
    }

    @os.l
    public final ap.g j() {
        return this.f14751d;
    }

    @os.l
    public final ap.h k() {
        return this.f14752e;
    }
}
