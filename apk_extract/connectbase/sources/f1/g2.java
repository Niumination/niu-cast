package f1;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class g2<E> extends s1<E> implements b5<E> {

    public class a extends c5.h<E> {
        public a() {
        }

        @Override // f1.c5.h
        public b5<E> a() {
            return g2.this;
        }

        @Override // f1.c5.h, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return new c5.e(a().entrySet().iterator());
        }
    }

    @t1.a
    public int add(@m5 E element, int occurrences) {
        return delegate().add(element, occurrences);
    }

    @Override // f1.b5
    public int count(@gm.a Object element) {
        return delegate().count(element);
    }

    @Override // f1.s1, f1.j2
    public abstract b5<E> delegate();

    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    public Set<b5.a<E>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Collection, f1.b5
    public boolean equals(@gm.a Object object) {
        return object == this || delegate().equals(object);
    }

    @Override // java.util.Collection, f1.b5
    public int hashCode() {
        return delegate().hashCode();
    }

    @t1.a
    public int remove(@gm.a Object element, int occurrences) {
        return delegate().remove(element, occurrences);
    }

    @t1.a
    public int setCount(@m5 E element, int count) {
        return delegate().setCount(element, count);
    }

    public boolean standardAdd(@m5 E element) {
        add(element, 1);
        return true;
    }

    @Override // f1.s1
    public boolean standardAddAll(Collection<? extends E> elementsToAdd) {
        return c5.c(this, elementsToAdd);
    }

    @Override // f1.s1
    public void standardClear() {
        h4.h(entrySet().iterator());
    }

    @Override // f1.s1
    public boolean standardContains(@gm.a Object object) {
        return count(object) > 0;
    }

    public int standardCount(@gm.a Object object) {
        for (b5.a<E> aVar : entrySet()) {
            if (c1.b0.a(aVar.getElement(), object)) {
                return aVar.getCount();
            }
        }
        return 0;
    }

    public boolean standardEquals(@gm.a Object object) {
        return c5.i(this, object);
    }

    public int standardHashCode() {
        return entrySet().hashCode();
    }

    public Iterator<E> standardIterator() {
        return c5.n(this);
    }

    @Override // f1.s1
    public boolean standardRemove(@gm.a Object element) {
        return remove(element, 1) > 0;
    }

    @Override // f1.s1
    public boolean standardRemoveAll(Collection<?> elementsToRemove) {
        return c5.p(this, elementsToRemove);
    }

    @Override // f1.s1
    public boolean standardRetainAll(Collection<?> elementsToRetain) {
        return c5.s(this, elementsToRetain);
    }

    public int standardSetCount(@m5 E element, int count) {
        return c5.v(this, element, count);
    }

    public int standardSize() {
        return c5.o(this);
    }

    @Override // f1.s1
    public String standardToString() {
        return entrySet().toString();
    }

    @t1.a
    public boolean setCount(@m5 E element, int oldCount, int newCount) {
        return delegate().setCount(element, oldCount, newCount);
    }

    public boolean standardSetCount(@m5 E element, int oldCount, int newCount) {
        return c5.w(this, element, oldCount, newCount);
    }
}
