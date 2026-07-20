package f1;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class b2<E> extends z1<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    public void add(@m5 E element) {
        delegate().add(element);
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return delegate().hasPrevious();
    }

    @Override // f1.z1
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract ListIterator<E> delegate();

    @Override // java.util.ListIterator
    public int nextIndex() {
        return delegate().nextIndex();
    }

    @Override // java.util.ListIterator
    @t1.a
    @m5
    public E previous() {
        return delegate().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return delegate().previousIndex();
    }

    @Override // java.util.ListIterator
    public void set(@m5 E element) {
        delegate().set(element);
    }
}
