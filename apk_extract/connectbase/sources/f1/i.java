package f1;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class i<E> extends AbstractCollection<E> implements b5<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<E> f4970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<b5.a<E>> f4971b;

    public class a extends c5.h<E> {
        public a() {
        }

        @Override // f1.c5.h
        public b5<E> a() {
            return i.this;
        }

        @Override // f1.c5.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return i.this.elementIterator();
        }
    }

    public class b extends c5.i<E> {
        public b() {
        }

        @Override // f1.c5.i
        public b5<E> a() {
            return i.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<b5.a<E>> iterator() {
            return i.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return i.this.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    @t1.a
    public final boolean add(@m5 E element) {
        add(element, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    public final boolean addAll(Collection<? extends E> elementsToAdd) {
        return c5.c(this, elementsToAdd);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    public boolean contains(@gm.a Object element) {
        return count(element) > 0;
    }

    public Set<E> createElementSet() {
        return new a();
    }

    public Set<b5.a<E>> createEntrySet() {
        return new b();
    }

    public abstract int distinctElements();

    public abstract Iterator<E> elementIterator();

    public Set<E> elementSet() {
        Set<E> set = this.f4970a;
        if (set != null) {
            return set;
        }
        Set<E> setCreateElementSet = createElementSet();
        this.f4970a = setCreateElementSet;
        return setCreateElementSet;
    }

    public abstract Iterator<b5.a<E>> entryIterator();

    public Set<b5.a<E>> entrySet() {
        Set<b5.a<E>> set = this.f4971b;
        if (set != null) {
            return set;
        }
        Set<b5.a<E>> setCreateEntrySet = createEntrySet();
        this.f4971b = setCreateEntrySet;
        return setCreateEntrySet;
    }

    @Override // java.util.Collection, f1.b5
    public final boolean equals(@gm.a Object object) {
        return c5.i(this, object);
    }

    @Override // java.util.Collection, f1.b5
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    @t1.a
    public final boolean remove(@gm.a Object element) {
        return remove(element, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    @t1.a
    public final boolean removeAll(Collection<?> elementsToRemove) {
        return c5.p(this, elementsToRemove);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, f1.b5
    @t1.a
    public final boolean retainAll(Collection<?> elementsToRetain) {
        return c5.s(this, elementsToRetain);
    }

    @t1.a
    public int setCount(@m5 E element, int count) {
        return c5.v(this, element, count);
    }

    @Override // java.util.AbstractCollection, f1.b5
    public final String toString() {
        return entrySet().toString();
    }

    @t1.a
    public int add(@m5 E element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    @t1.a
    public int remove(@gm.a Object element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    @t1.a
    public boolean setCount(@m5 E element, int oldCount, int newCount) {
        return c5.w(this, element, oldCount, newCount);
    }
}
