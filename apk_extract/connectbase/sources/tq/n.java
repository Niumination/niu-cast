package tq;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements um.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public final Throwable f16056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ um.g f16057b;

    public n(@os.l Throwable th2, @os.l um.g gVar) {
        this.f16056a = th2;
        this.f16057b = gVar;
    }

    @Override // um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) this.f16057b.fold(r10, pVar);
    }

    @Override // um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        return (E) this.f16057b.get(cVar);
    }

    @Override // um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return this.f16057b.minusKey(cVar);
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        return this.f16057b.plus(gVar);
    }
}
