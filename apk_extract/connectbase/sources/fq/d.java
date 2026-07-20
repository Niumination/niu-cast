package fq;

/* JADX INFO: loaded from: classes3.dex */
public final class d<V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d<Object> f6337b = new d<>(c.f6331f);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c<V> f6338a;

    public d(c<V> cVar) {
        this.f6338a = cVar;
    }

    public static <V> d<V> a() {
        return (d<V>) f6337b;
    }

    public V b(int i10) {
        return this.f6338a.a(i10);
    }

    public d<V> c(int i10) {
        return e(this.f6338a.c(i10));
    }

    public d<V> d(int i10, V v10) {
        return e(this.f6338a.d(i10, v10));
    }

    public final d<V> e(c<V> cVar) {
        return cVar == this.f6338a ? this : new d<>(cVar);
    }
}
