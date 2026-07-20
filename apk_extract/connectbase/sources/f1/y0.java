package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class y0<C extends Comparable> extends p0<C> {

    @b1.c
    @b1.d
    public static final class b<C extends Comparable> implements Serializable {
        private static final long serialVersionUID = 0;
        private final w0<C> domain;

        private Object readResolve() {
            return new y0(this.domain);
        }

        public b(w0<C> domain) {
            this.domain = domain;
        }
    }

    public y0(w0<C> domain) {
        super(domain);
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.t3, f1.e3
    public i3<C> asList() {
        return i3.of();
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return false;
    }

    @Override // f1.p0, f1.a4
    @b1.c
    public a4<C> createDescendingSet() {
        return a4.emptySet(l5.natural().reverse());
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public boolean equals(@gm.a Object object) {
        if (object instanceof Set) {
            return ((Set) object).isEmpty();
        }
        return false;
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public int hashCode() {
        return 0;
    }

    @Override // f1.a4
    @b1.c
    public int indexOf(@gm.a Object target) {
        return -1;
    }

    @Override // f1.p0
    public p0<C> intersection(p0<C> other) {
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    @Override // f1.t3
    @b1.c
    public boolean isHashCodeFast() {
        return true;
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // f1.p0
    public q5<C> range() {
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 0;
    }

    @Override // f1.p0, java.util.AbstractCollection
    public String toString() {
        return "[]";
    }

    @Override // f1.a4, f1.t3, f1.e3
    @b1.c
    @b1.d
    public Object writeReplace() {
        return new b(this.domain);
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c
    public x7<C> descendingIterator() {
        return h4.l.f4958e;
    }

    @Override // f1.a4, java.util.SortedSet
    public C first() {
        throw new NoSuchElementException();
    }

    @Override // f1.p0, f1.a4
    public p0<C> headSetImpl(C toElement, boolean inclusive) {
        return this;
    }

    @Override // f1.a4, f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<C> iterator() {
        return h4.l.f4958e;
    }

    @Override // f1.a4, java.util.SortedSet
    public C last() {
        throw new NoSuchElementException();
    }

    @Override // f1.p0
    public q5<C> range(x lowerBoundType, x upperBoundType) {
        throw new NoSuchElementException();
    }

    @Override // f1.p0, f1.a4
    public p0<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
        return this;
    }

    @Override // f1.p0, f1.a4
    public p0<C> tailSetImpl(C fromElement, boolean fromInclusive) {
        return this;
    }
}
