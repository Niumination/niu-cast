package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final c0 f6540a = new c0();

    @Override // gk.m
    @os.l
    public pl.n a(@os.l pl.n nVar, @os.l um.g gVar) {
        kn.l0.p(nVar, "writeChannel");
        kn.l0.p(gVar, "coroutineContext");
        return fl.f0.j(nVar, false, null, gVar, 2, null);
    }

    @Override // gk.m
    @os.l
    public pl.k b(@os.l pl.k kVar, @os.l um.g gVar) {
        kn.l0.p(kVar, "readChannel");
        kn.l0.p(gVar, "coroutineContext");
        return fl.f0.i(kVar, false, null, gVar, 2, null);
    }

    @Override // gk.m
    @os.m
    public Long c(long j10) {
        return m.a.c(this, j10);
    }
}
