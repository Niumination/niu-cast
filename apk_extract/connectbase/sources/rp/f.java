package rp;

import eo.z0;
import kn.l0;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final ap.c f14714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final yo.a.c f14715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final ap.a f14716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @os.l
    public final z0 f14717d;

    public f(@os.l ap.c cVar, @os.l yo.a.c cVar2, @os.l ap.a aVar, @os.l z0 z0Var) {
        l0.p(cVar, "nameResolver");
        l0.p(cVar2, "classProto");
        l0.p(aVar, "metadataVersion");
        l0.p(z0Var, "sourceElement");
        this.f14714a = cVar;
        this.f14715b = cVar2;
        this.f14716c = aVar;
        this.f14717d = z0Var;
    }

    @os.l
    public final ap.c a() {
        return this.f14714a;
    }

    @os.l
    public final yo.a.c b() {
        return this.f14715b;
    }

    @os.l
    public final ap.a c() {
        return this.f14716c;
    }

    @os.l
    public final z0 d() {
        return this.f14717d;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return l0.g(this.f14714a, fVar.f14714a) && l0.g(this.f14715b, fVar.f14715b) && l0.g(this.f14716c, fVar.f14716c) && l0.g(this.f14717d, fVar.f14717d);
    }

    public int hashCode() {
        return this.f14717d.hashCode() + ((this.f14716c.hashCode() + ((this.f14715b.hashCode() + (this.f14714a.hashCode() * 31)) * 31)) * 31);
    }

    @os.l
    public String toString() {
        return "ClassData(nameResolver=" + this.f14714a + ", classProto=" + this.f14715b + ", metadataVersion=" + this.f14716c + ", sourceElement=" + this.f14717d + ')';
    }
}
