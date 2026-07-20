package f1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class a2<E> extends s1<E> implements List<E> {
    @Override // java.util.List
    public void add(int index, @m5 E element) {
        delegate().add(index, element);
    }

    @Override // java.util.List
    @t1.a
    public boolean addAll(int index, Collection<? extends E> elements) {
        return delegate().addAll(index, elements);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@gm.a Object object) {
        return object == this || delegate().equals(object);
    }

    @Override // java.util.List
    @m5
    public E get(int index) {
        return delegate().get(index);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.List
    public int indexOf(@gm.a Object element) {
        return delegate().indexOf(element);
    }

    @Override // f1.s1, f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract List<E> delegate();

    @Override // java.util.List
    public int lastIndexOf(@gm.a Object element) {
        return delegate().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    public boolean m(int index, Iterable<? extends E> elements) {
        return p4.a(this, index, elements);
    }

    public int q(@gm.a Object element) {
        return p4.l(this, element);
    }

    public int r(@gm.a Object element) {
        return p4.n(this, element);
    }

    @Override // java.util.List
    @t1.a
    @m5
    public E remove(int index) {
        return delegate().remove(index);
    }

    public ListIterator<E> s() {
        return listIterator(0);
    }

    @Override // java.util.List
    @t1.a
    @m5
    public E set(int index, @m5 E element) {
        return delegate().set(index, element);
    }

    public boolean standardAdd(@m5 E element) {
        add(size(), element);
        return true;
    }

    public boolean standardEquals(@gm.a Object object) {
        return p4.j(this, object);
    }

    public int standardHashCode() {
        return p4.k(this);
    }

    public Iterator<E> standardIterator() {
        return listIterator();
    }

    @Override // java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        return delegate().subList(fromIndex, toIndex);
    }

    public ListIterator<E> t(int start) {
        return p4.p(this, start);
    }

    public List<E> u(int fromIndex, int toIndex) {
        return p4.C(this, fromIndex, toIndex);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int index) {
        return delegate().listIterator(index);
    }
}
