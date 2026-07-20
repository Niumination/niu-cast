package up;

/* JADX INFO: loaded from: classes3.dex */
public class l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f16394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Thread f16395b = Thread.currentThread();

    public l(T t10) {
        this.f16394a = t10;
    }

    public T a() {
        if (b()) {
            return this.f16394a;
        }
        throw new IllegalStateException("No value in this thread (hasValue should be checked before)");
    }

    public boolean b() {
        return this.f16395b == Thread.currentThread();
    }
}
