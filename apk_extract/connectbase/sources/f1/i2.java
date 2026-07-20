package f1;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public abstract class i2<E> extends p2<E> implements NavigableSet<E> {

    public class a extends k6.g<E> {
        public a(final i2 this$0) {
            super(this$0);
        }
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E ceiling(@m5 E e10) {
        return delegate().ceiling(e10);
    }

    @Override // java.util.NavigableSet
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> descendingSet() {
        return delegate().descendingSet();
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E floor(@m5 E e10) {
        return delegate().floor(e10);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> headSet(@m5 E toElement, boolean inclusive) {
        return delegate().headSet(toElement, inclusive);
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E higher(@m5 E e10) {
        return delegate().higher(e10);
    }

    @Override // f1.p2, f1.l2, f1.s1, f1.j2
    /* JADX INFO: renamed from: l */
    public abstract NavigableSet<E> delegate();

    @Override // java.util.NavigableSet
    @gm.a
    public E lower(@m5 E e10) {
        return delegate().lower(e10);
    }

    @gm.a
    public E m(@m5 E e10) {
        return (E) h4.J(tailSet(e10, true).iterator(), null);
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E pollLast() {
        return delegate().pollLast();
    }

    @m5
    public E q() {
        return iterator().next();
    }

    @gm.a
    public E r(@m5 E e10) {
        return (E) h4.J(headSet(e10, true).descendingIterator(), null);
    }

    public SortedSet<E> s(@m5 E toElement) {
        return headSet(toElement, false);
    }

    @Override // f1.p2
    public SortedSet<E> standardSubSet(@m5 E fromElement, @m5 E toElement) {
        return subSet(fromElement, true, toElement, false);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> subSet(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
        return delegate().subSet(fromElement, fromInclusive, toElement, toInclusive);
    }

    @gm.a
    public E t(@m5 E e10) {
        return (E) h4.J(tailSet(e10, false).iterator(), null);
    }

    @Override // java.util.NavigableSet
    public NavigableSet<E> tailSet(@m5 E fromElement, boolean inclusive) {
        return delegate().tailSet(fromElement, inclusive);
    }

    @m5
    public E u() {
        return descendingIterator().next();
    }

    @gm.a
    public E v(@m5 E e10) {
        return (E) h4.J(headSet(e10, false).descendingIterator(), null);
    }

    @gm.a
    public E w() {
        return (E) h4.U(iterator());
    }

    @gm.a
    public E x() {
        return (E) h4.U(descendingIterator());
    }

    public NavigableSet<E> y(@m5 E fromElement, boolean fromInclusive, @m5 E toElement, boolean toInclusive) {
        return tailSet(fromElement, fromInclusive).headSet(toElement, toInclusive);
    }

    public SortedSet<E> z(@m5 E fromElement) {
        return tailSet(fromElement, true);
    }
}
