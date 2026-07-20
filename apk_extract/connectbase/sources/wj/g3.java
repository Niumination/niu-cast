package wj;

/* JADX INFO: loaded from: classes2.dex */
public final class g3<T> implements z1<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f3.d<T> f18698a;

    public g3(f3.d<T> dVar) {
        this.f18698a = dVar;
    }

    public static <T> g3<T> c(f3.d<T> dVar) {
        return new g3<>(dVar);
    }

    @Override // wj.z1
    public T a() {
        return (T) f3.d(this.f18698a);
    }

    @Override // wj.z1
    public T b(Object obj) {
        f3.f(this.f18698a, obj);
        return null;
    }
}
