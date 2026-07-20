package vq;

import nq.n3;

/* JADX INFO: loaded from: classes3.dex */
public final class b1<T> implements n3<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f17802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final ThreadLocal<T> f17803b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @os.l
    public final um.g.c<?> f17804c;

    public b1(T t10, @os.l ThreadLocal<T> threadLocal) {
        this.f17802a = t10;
        this.f17803b = threadLocal;
        this.f17804c = new c1(threadLocal);
    }

    @Override // nq.n3
    public void D1(@os.l um.g gVar, T t10) {
        this.f17803b.set(t10);
    }

    @Override // um.g.b, um.g
    public <R> R fold(R r10, @os.l jn.p<? super R, ? super um.g.b, ? extends R> pVar) {
        return (R) um.g.b.a.a(this, r10, pVar);
    }

    @Override // um.g.b, um.g
    @os.m
    public <E extends um.g.b> E get(@os.l um.g.c<E> cVar) {
        if (!kn.l0.g(this.f17804c, cVar)) {
            return null;
        }
        kn.l0.n(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // um.g.b
    @os.l
    public um.g.c<?> getKey() {
        return this.f17804c;
    }

    @Override // um.g.b, um.g
    @os.l
    public um.g minusKey(@os.l um.g.c<?> cVar) {
        return kn.l0.g(this.f17804c, cVar) ? um.i.INSTANCE : this;
    }

    @Override // um.g
    @os.l
    public um.g plus(@os.l um.g gVar) {
        return um.g.b.a.d(this, gVar);
    }

    @os.l
    public String toString() {
        return "ThreadLocal(value=" + this.f17802a + ", threadLocal = " + this.f17803b + ')';
    }

    @Override // nq.n3
    public T u0(@os.l um.g gVar) {
        T t10 = this.f17803b.get();
        this.f17803b.set(this.f17802a);
        return t10;
    }
}
