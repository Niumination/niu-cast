package wo;

import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements rp.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final n f19788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final f f19789b;

    public g(@os.l n nVar, @os.l f fVar) {
        l0.p(nVar, "kotlinClassFinder");
        l0.p(fVar, "deserializedDescriptorResolver");
        this.f19788a = nVar;
        this.f19789b = fVar;
    }

    @Override // rp.g
    @os.m
    public rp.f a(@os.l dp.b bVar) {
        l0.p(bVar, "classId");
        p pVarA = o.a(this.f19788a, bVar);
        if (pVarA == null) {
            return null;
        }
        l0.g(pVarA.f(), bVar);
        return this.f19789b.j(pVarA);
    }
}
