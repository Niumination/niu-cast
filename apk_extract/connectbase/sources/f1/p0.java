package f1;

import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class p0<C extends Comparable> extends a4<C> {
    final w0<C> domain;

    public p0(w0<C> domain) {
        super(l5.natural());
        this.domain = domain;
    }

    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public static <E> a4.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static p0<Integer> closed(int lower, int upper) {
        return create(q5.closed(Integer.valueOf(lower), Integer.valueOf(upper)), w0.integers());
    }

    public static p0<Integer> closedOpen(int lower, int upper) {
        return create(q5.closedOpen(Integer.valueOf(lower), Integer.valueOf(upper)), w0.integers());
    }

    public static <C extends Comparable> p0<C> create(q5<C> range, w0<C> domain) {
        range.getClass();
        domain.getClass();
        try {
            q5<C> q5VarIntersection = !range.hasLowerBound() ? range.intersection(q5.atLeast(domain.minValue())) : range;
            if (!range.hasUpperBound()) {
                q5VarIntersection = q5VarIntersection.intersection(q5.atMost(domain.maxValue()));
            }
            if (!q5VarIntersection.isEmpty()) {
                Comparable comparableLeastValueAbove = range.lowerBound.leastValueAbove(domain);
                Objects.requireNonNull(comparableLeastValueAbove);
                Comparable comparableGreatestValueBelow = range.upperBound.greatestValueBelow(domain);
                Objects.requireNonNull(comparableGreatestValueBelow);
                if (q5.compareOrThrow(comparableLeastValueAbove, comparableGreatestValueBelow) <= 0) {
                    return new u5(q5VarIntersection, domain);
                }
            }
            return new y0(domain);
        } catch (NoSuchElementException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // f1.a4
    @b1.c
    public a4<C> createDescendingSet() {
        return new u0(this);
    }

    @Override // f1.a4
    public abstract p0<C> headSetImpl(C toElement, boolean inclusive);

    public abstract p0<C> intersection(p0<C> other);

    public abstract q5<C> range();

    public abstract q5<C> range(x lowerBoundType, x upperBoundType);

    @Override // f1.a4
    public abstract p0<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive);

    @Override // f1.a4
    public abstract p0<C> tailSetImpl(C fromElement, boolean inclusive);

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    public static p0<Long> closed(long lower, long upper) {
        return create(q5.closed(Long.valueOf(lower), Long.valueOf(upper)), w0.longs());
    }

    public static p0<Long> closedOpen(long lower, long upper) {
        return create(q5.closedOpen(Long.valueOf(lower), Long.valueOf(upper)), w0.longs());
    }

    @Override // f1.a4, java.util.NavigableSet, java.util.SortedSet
    public p0<C> headSet(C toElement) {
        toElement.getClass();
        return headSetImpl((Comparable) toElement, false);
    }

    @Override // f1.a4, java.util.NavigableSet, java.util.SortedSet
    public p0<C> subSet(C fromElement, C toElement) {
        fromElement.getClass();
        toElement.getClass();
        c1.h0.d(comparator().compare(fromElement, toElement) <= 0);
        return subSetImpl((Comparable) fromElement, true, (Comparable) toElement, false);
    }

    @Override // f1.a4, java.util.NavigableSet, java.util.SortedSet
    public p0<C> tailSet(C fromElement) {
        fromElement.getClass();
        return tailSetImpl((Comparable) fromElement, true);
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c
    public p0<C> headSet(C toElement, boolean inclusive) {
        toElement.getClass();
        return headSetImpl((Comparable) toElement, inclusive);
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c
    public p0<C> tailSet(C fromElement, boolean inclusive) {
        fromElement.getClass();
        return tailSetImpl((Comparable) fromElement, inclusive);
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c
    public p0<C> subSet(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
        fromElement.getClass();
        toElement.getClass();
        c1.h0.d(comparator().compare(fromElement, toElement) <= 0);
        return subSetImpl((Comparable) fromElement, fromInclusive, (Comparable) toElement, toInclusive);
    }
}
