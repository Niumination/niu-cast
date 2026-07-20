package f1;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class l<T> extends x7<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gm.a
    public T f5084a;

    public l(@gm.a T firstOrNull) {
        this.f5084a = firstOrNull;
    }

    @gm.a
    public abstract T a(T previous);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5084a != null;
    }

    @Override // java.util.Iterator
    public final T next() {
        T t10 = this.f5084a;
        if (t10 == null) {
            throw new NoSuchElementException();
        }
        this.f5084a = a(t10);
        return t10;
    }
}
