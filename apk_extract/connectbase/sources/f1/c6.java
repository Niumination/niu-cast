package f1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public final class c6<E> extends a4<E> {
    static final c6<Comparable> NATURAL_EMPTY_SET = new c6<>(i3.of(), l5.natural());

    @b1.e
    final transient i3<E> elements;

    public c6(i3<E> elements, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = elements;
    }

    @Override // f1.t3, f1.e3
    public i3<E> asList() {
        return this.elements;
    }

    public final int c(Object key) throws ClassCastException {
        return Collections.binarySearch(this.elements, key, unsafeComparator());
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E ceiling(E element) {
        int iTailIndex = tailIndex(element, true);
        if (iTailIndex == size()) {
            return null;
        }
        return this.elements.get(iTailIndex);
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object o10) {
        if (o10 == null) {
            return false;
        }
        try {
            return c(o10) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> targets) {
        if (targets instanceof b5) {
            targets = ((b5) targets).elementSet();
        }
        if (!o6.b(comparator(), targets) || targets.size() <= 1) {
            return super.containsAll(targets);
        }
        x7<E> it = iterator();
        Iterator<?> it2 = targets.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int iUnsafeCompare = unsafeCompare(next2, next);
                if (iUnsafeCompare < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iUnsafeCompare == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iUnsafeCompare > 0) {
                    return false;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }

    @Override // f1.e3
    public int copyIntoArray(Object[] dst, int offset) {
        return this.elements.copyIntoArray(dst, offset);
    }

    @Override // f1.a4
    public a4<E> createDescendingSet() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.comparator);
        return isEmpty() ? a4.emptySet(comparatorReverseOrder) : new c6(this.elements.reverse(), comparatorReverseOrder);
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Set)) {
            return false;
        }
        Set set = (Set) object;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!o6.b(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            x7<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || unsafeCompare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // f1.a4, java.util.SortedSet
    public E first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(0);
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E floor(E element) {
        int iHeadIndex = headIndex(element, true) - 1;
        if (iHeadIndex == -1) {
            return null;
        }
        return this.elements.get(iHeadIndex);
    }

    public c6<E> getSubSet(int newFromIndex, int newToIndex) {
        if (newFromIndex == 0 && newToIndex == size()) {
            return this;
        }
        return newFromIndex < newToIndex ? new c6<>(this.elements.subList(newFromIndex, newToIndex), this.comparator) : a4.emptySet(this.comparator);
    }

    public int headIndex(E toElement, boolean inclusive) {
        i3<E> i3Var = this.elements;
        toElement.getClass();
        int iBinarySearch = Collections.binarySearch(i3Var, toElement, comparator());
        if (iBinarySearch >= 0) {
            return inclusive ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    @Override // f1.a4
    public a4<E> headSetImpl(E toElement, boolean inclusive) {
        return getSubSet(0, headIndex(toElement, inclusive));
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E higher(E element) {
        int iTailIndex = tailIndex(element, false);
        if (iTailIndex == size()) {
            return null;
        }
        return this.elements.get(iTailIndex);
    }

    @Override // f1.a4
    public int indexOf(@gm.a Object target) {
        if (target == null) {
            return -1;
        }
        try {
            int iBinarySearch = Collections.binarySearch(this.elements, target, unsafeComparator());
            if (iBinarySearch >= 0) {
                return iBinarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // f1.e3
    @gm.a
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    @Override // f1.e3
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    @Override // f1.e3
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // f1.a4, java.util.SortedSet
    public E last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(size() - 1);
    }

    @Override // f1.a4, java.util.NavigableSet
    @gm.a
    public E lower(E element) {
        int iHeadIndex = headIndex(element, false) - 1;
        if (iHeadIndex == -1) {
            return null;
        }
        return this.elements.get(iHeadIndex);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // f1.a4
    public a4<E> subSetImpl(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        return tailSetImpl(fromElement, fromInclusive).headSetImpl(toElement, toInclusive);
    }

    public int tailIndex(E fromElement, boolean inclusive) {
        i3<E> i3Var = this.elements;
        fromElement.getClass();
        int iBinarySearch = Collections.binarySearch(i3Var, fromElement, comparator());
        if (iBinarySearch >= 0) {
            return inclusive ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    @Override // f1.a4
    public a4<E> tailSetImpl(E fromElement, boolean inclusive) {
        return getSubSet(tailIndex(fromElement, inclusive), size());
    }

    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c
    public x7<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // f1.a4, f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return this.elements.iterator();
    }
}
