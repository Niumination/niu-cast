package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final k0 f6659a = new k0();

    @Override // gk.m
    @os.l
    public pl.n a(@os.l pl.n nVar, @os.l um.g gVar) {
        kn.l0.p(nVar, "writeChannel");
        kn.l0.p(gVar, "coroutineContext");
        return nVar;
    }

    @Override // gk.m
    @os.l
    public pl.k b(@os.l pl.k kVar, @os.l um.g gVar) {
        kn.l0.p(kVar, "readChannel");
        kn.l0.p(gVar, "coroutineContext");
        return kVar;
    }

    @Override // gk.m
    @os.l
    public Long c(long j10) {
        return Long.valueOf(j10);
    }
}
