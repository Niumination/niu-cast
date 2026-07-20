package gk;

/* JADX INFO: loaded from: classes2.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final jn.a<T> f6518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.m
    public T f6519b;

    /* JADX WARN: Multi-variable type inference failed */
    public a(@os.l jn.a<? extends T> aVar) {
        kn.l0.p(aVar, "property");
        this.f6518a = aVar;
    }

    @os.l
    public final jn.a<T> a() {
        return this.f6518a;
    }

    @os.l
    public final T b(@os.l Object obj, @os.l un.o<?> oVar) {
        kn.l0.p(obj, "thisRef");
        kn.l0.p(oVar, "property");
        T t10 = this.f6519b;
        return t10 == null ? this.f6518a.invoke() : t10;
    }

    public final void c(@os.l Object obj, @os.l un.o<?> oVar, @os.l T t10) {
        kn.l0.p(obj, "thisRef");
        kn.l0.p(oVar, "property");
        kn.l0.p(t10, "value");
        this.f6519b = t10;
    }
}
