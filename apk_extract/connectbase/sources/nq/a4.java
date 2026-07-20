package nq;

/* JADX INFO: loaded from: classes3.dex */
public final class a4 implements um.g.b, um.g.c<a4> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public static final a4 f11824a = new a4();

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) um.g.b.a.a(this, r10, pVar);
    }

    @Override // um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        return (E) um.g.b.a.b(this, cVar);
    }

    @Override // um.g.b
    @os.l
    public um.g.c<?> getKey() {
        return this;
    }

    @Override // um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return um.g.b.a.c(this, cVar);
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        return um.g.b.a.d(this, gVar);
    }
}
