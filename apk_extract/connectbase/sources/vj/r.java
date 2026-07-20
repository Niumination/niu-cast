package vj;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f17254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f17255b;

    public r(g gVar, d dVar) {
        this.f17254a = (g) c1.h0.F(gVar, "channelCreds");
        this.f17255b = (d) c1.h0.F(dVar, "callCreds");
    }

    public static g b(g gVar, d dVar) {
        return new r(gVar, dVar);
    }

    @Override // vj.g
    public g a() {
        return this.f17254a.a();
    }

    public d c() {
        return this.f17255b;
    }

    public g d() {
        return this.f17254a;
    }
}
