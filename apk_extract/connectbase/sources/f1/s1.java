package f1;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class s1<E> extends j2 implements Collection<E> {
    @t1.a
    public boolean add(@m5 E element) {
        return delegate().add(element);
    }

    @t1.a
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    public void clear() {
        delegate().clear();
    }

    public boolean contains(@gm.a Object object) {
        return delegate().contains(object);
    }

    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    @Override // f1.j2
    public abstract Collection<E> delegate();

    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    @t1.a
    public boolean remove(@gm.a Object object) {
        return delegate().remove(object);
    }

    @t1.a
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    @t1.a
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    public boolean standardAddAll(Collection<? extends E> collection) {
        return h4.a(this, collection.iterator());
    }

    public void standardClear() {
        h4.h(iterator());
    }

    public boolean standardContains(@gm.a Object object) {
        return h4.q(iterator(), object);
    }

    public boolean standardContainsAll(Collection<?> collection) {
        return c0.b(this, collection);
    }

    public boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    public boolean standardRemove(@gm.a Object object) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (c1.b0.a(it.next(), object)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean standardRemoveAll(Collection<?> collection) {
        return h4.V(iterator(), collection);
    }

    public boolean standardRetainAll(Collection<?> collection) {
        return h4.X(iterator(), collection);
    }

    public Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    public String standardToString() {
        return c0.l(this);
    }

    public Object[] toArray() {
        return delegate().toArray();
    }

    @t1.a
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    public <T> T[] standardToArray(T[] tArr) {
        return (T[]) i5.m(this, tArr);
    }
}
