package f1;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class p7<F, T> extends o7<F, T> implements ListIterator<T> {
    public p7(ListIterator<? extends F> backingIterator) {
        super(backingIterator);
    }

    @Override // java.util.ListIterator
    public void add(@m5 T element) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<? extends F> b() {
        return (ListIterator) this.f5174a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return ((ListIterator) this.f5174a).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return ((ListIterator) this.f5174a).nextIndex();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ListIterator
    @m5
    public final T previous() {
        return (T) a(((ListIterator) this.f5174a).previous());
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return ((ListIterator) this.f5174a).previousIndex();
    }

    public void set(@m5 T element) {
        throw new UnsupportedOperationException();
    }
}
