package bi;

/* JADX INFO: loaded from: classes2.dex */
public class i<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<? extends T> f859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f860b;

    public i(Class<? extends T> cls) {
        this.f859a = cls;
    }

    public synchronized T a() throws IllegalAccessException, InstantiationException {
        try {
            if (this.f860b == null) {
                this.f860b = this.f859a.newInstance();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f860b;
    }
}
