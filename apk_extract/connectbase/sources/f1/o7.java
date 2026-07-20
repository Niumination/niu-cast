package f1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class o7<F, T> implements Iterator<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator<? extends F> f5174a;

    public o7(Iterator<? extends F> backingIterator) {
        backingIterator.getClass();
        this.f5174a = backingIterator;
    }

    @m5
    public abstract T a(@m5 F from);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5174a.hasNext();
    }

    @Override // java.util.Iterator
    @m5
    public final T next() {
        return a(this.f5174a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5174a.remove();
    }
}
