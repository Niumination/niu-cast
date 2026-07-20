package i4;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import k3.n9;

/* JADX INFO: loaded from: classes.dex */
public final class a5 extends z1 {
    static final a5 NATURAL_EMPTY_SET = new a5(h0.of(), o4.natural());
    final transient h0 elements;

    public a5(h0 h0Var, Comparator<Object> comparator) {
        super(comparator);
        this.elements = h0Var;
    }

    @Override // i4.s1, i4.a0
    public h0 asList() {
        return this.elements;
    }

    @Override // i4.z1, java.util.NavigableSet
    public Object ceiling(Object obj) {
        int iTailIndex = tailIndex(obj, true);
        if (iTailIndex == size()) {
            return null;
        }
        return this.elements.get(iTailIndex);
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return Collections.binarySearch(this.elements, obj, unsafeComparator()) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof c4) {
            collection = ((c4) collection).elementSet();
        }
        if (!n9.a(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        h5 it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
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

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        return this.elements.copyIntoArray(objArr, i8);
    }

    @Override // i4.z1
    public z1 createDescendingSet() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.comparator);
        return isEmpty() ? z1.emptySet(comparatorReverseOrder) : new a5(this.elements.reverse(), comparatorReverseOrder);
    }

    @Override // i4.s1, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!n9.a(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            h5 it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 == null || unsafeCompare(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // i4.z1, java.util.SortedSet
    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(0);
    }

    @Override // i4.z1, java.util.NavigableSet
    public Object floor(Object obj) {
        int iHeadIndex = headIndex(obj, true) - 1;
        if (iHeadIndex == -1) {
            return null;
        }
        return this.elements.get(iHeadIndex);
    }

    public a5 getSubSet(int i8, int i9) {
        if (i8 == 0 && i9 == size()) {
            return this;
        }
        return i8 < i9 ? new a5(this.elements.subList(i8, i9), this.comparator) : z1.emptySet(this.comparator);
    }

    public int headIndex(Object obj, boolean z2) {
        h0 h0Var = this.elements;
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(h0Var, obj, comparator());
        if (iBinarySearch >= 0) {
            return z2 ? iBinarySearch + 1 : iBinarySearch;
        }
        return ~iBinarySearch;
    }

    @Override // i4.z1
    public z1 headSetImpl(Object obj, boolean z2) {
        return getSubSet(0, headIndex(obj, z2));
    }

    @Override // i4.z1, java.util.NavigableSet
    public Object higher(Object obj) {
        int iTailIndex = tailIndex(obj, false);
        if (iTailIndex == size()) {
            return null;
        }
        return this.elements.get(iTailIndex);
    }

    @Override // i4.z1
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int iBinarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
            if (iBinarySearch >= 0) {
                return iBinarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // i4.a0
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    @Override // i4.a0
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    @Override // i4.a0
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // i4.z1, java.util.SortedSet
    public Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.elements.get(size() - 1);
    }

    @Override // i4.z1, java.util.NavigableSet
    public Object lower(Object obj) {
        int iHeadIndex = headIndex(obj, false) - 1;
        if (iHeadIndex == -1) {
            return null;
        }
        return this.elements.get(iHeadIndex);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // i4.z1
    public z1 subSetImpl(Object obj, boolean z2, Object obj2, boolean z3) {
        return tailSetImpl(obj, z2).headSetImpl(obj2, z3);
    }

    public int tailIndex(Object obj, boolean z2) {
        h0 h0Var = this.elements;
        obj.getClass();
        int iBinarySearch = Collections.binarySearch(h0Var, obj, comparator());
        if (iBinarySearch >= 0) {
            return z2 ? iBinarySearch : iBinarySearch + 1;
        }
        return ~iBinarySearch;
    }

    @Override // i4.z1
    public z1 tailSetImpl(Object obj, boolean z2) {
        return getSubSet(tailIndex(obj, z2), size());
    }

    public Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    @Override // i4.z1, java.util.NavigableSet
    public h5 descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // i4.z1, i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return this.elements.iterator();
    }
}
