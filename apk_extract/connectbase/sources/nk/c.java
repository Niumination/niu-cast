package nk;

import kn.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.m
    public final ik.d f11511a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public final kl.d f11512b;

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static c d(c cVar, ik.d dVar, kl.d dVar2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            dVar = cVar.f11511a;
        }
        if ((i10 & 2) != 0) {
            dVar2 = cVar.f11512b;
        }
        cVar.getClass();
        return new c(dVar, dVar2);
    }

    @os.m
    public final ik.d a() {
        return this.f11511a;
    }

    @os.m
    public final kl.d b() {
        return this.f11512b;
    }

    @os.l
    public final c c(@os.m ik.d dVar, @os.m kl.d dVar2) {
        return new c(dVar, dVar2);
    }

    @os.m
    public final ik.d e() {
        return this.f11511a;
    }

    public boolean equals(@os.m Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return l0.g(this.f11511a, cVar.f11511a) && l0.g(this.f11512b, cVar.f11512b);
    }

    @os.m
    public final kl.d f() {
        return this.f11512b;
    }

    public int hashCode() {
        ik.d dVar = this.f11511a;
        int iHashCode = (dVar == null ? 0 : dVar.hashCode()) * 31;
        kl.d dVar2 = this.f11512b;
        return iHashCode + (dVar2 != null ? dVar2.hashCode() : 0);
    }

    @os.l
    public String toString() {
        return "CachingOptions(cacheControl=" + this.f11511a + ", expires=" + this.f11512b + ')';
    }

    public c(@os.m ik.d dVar, @os.m kl.d dVar2) {
        this.f11511a = dVar;
        this.f11512b = dVar2;
    }

    public /* synthetic */ c(ik.d dVar, kl.d dVar2, int i10, kn.w wVar) {
        this((i10 & 1) != 0 ? null : dVar, (i10 & 2) != 0 ? null : dVar2);
    }
}
