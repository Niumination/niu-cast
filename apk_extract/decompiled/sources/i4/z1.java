package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import k3.h9;
import k3.k9;
import k3.n9;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class z1 extends a2 implements NavigableSet, e5 {
    final transient Comparator<Object> comparator;
    transient z1 descendingSet;

    public z1(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> z1 construct(Comparator<? super E> comparator, int i8, E... eArr) {
        if (i8 == 0) {
            return emptySet(comparator);
        }
        k9.a(i8, eArr);
        Arrays.sort(eArr, 0, i8, comparator);
        int i9 = 1;
        for (int i10 = 1; i10 < i8; i10++) {
            a1.a aVar = (Object) eArr[i10];
            if (comparator.compare(aVar, (Object) eArr[i9 - 1]) != 0) {
                eArr[i9] = aVar;
                i9++;
            }
        }
        Arrays.fill(eArr, i9, i8, (Object) null);
        if (i9 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i9);
        }
        return new a5(h0.asImmutableList(eArr, i9), comparator);
    }

    public static <E extends Comparable<? super E>> z1 copyOf(E[] eArr) {
        return construct(o4.natural(), eArr.length, (Comparable[]) eArr.clone());
    }

    public static <E> z1 copyOfSorted(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            comparator = o4.natural();
        }
        h0 h0VarCopyOf = h0.copyOf((Collection) sortedSet);
        return h0VarCopyOf.isEmpty() ? emptySet(comparator) : new a5(h0VarCopyOf, comparator);
    }

    public static <E> a5 emptySet(Comparator<? super E> comparator) {
        return o4.natural().equals(comparator) ? a5.NATURAL_EMPTY_SET : new a5(h0.of(), comparator);
    }

    public static <E extends Comparable<?>> x1 naturalOrder() {
        return new x1(o4.natural());
    }

    public static <E> z1 of() {
        return a5.NATURAL_EMPTY_SET;
    }

    public static <E> x1 orderedBy(Comparator<E> comparator) {
        return new x1(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> x1 reverseOrder() {
        return new x1(Collections.reverseOrder());
    }

    public Object ceiling(Object obj) {
        Iterator<E> it = tailSet(obj, true).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    @Override // java.util.SortedSet
    public Comparator<Object> comparator() {
        return this.comparator;
    }

    public abstract z1 createDescendingSet();

    @Override // java.util.NavigableSet
    public abstract h5 descendingIterator();

    public Object first() {
        return iterator().next();
    }

    public Object floor(Object obj) {
        h5 h5VarDescendingIterator = headSet(obj, true).descendingIterator();
        if (h5VarDescendingIterator.hasNext()) {
            return h5VarDescendingIterator.next();
        }
        return null;
    }

    public abstract z1 headSetImpl(Object obj, boolean z2);

    public Object higher(Object obj) {
        Iterator<E> it = tailSet(obj, false).iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public abstract int indexOf(Object obj);

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract h5 iterator();

    public Object last() {
        return descendingIterator().next();
    }

    public Object lower(Object obj) {
        h5 h5VarDescendingIterator = headSet(obj, false).descendingIterator();
        if (h5VarDescendingIterator.hasNext()) {
            return h5VarDescendingIterator.next();
        }
        return null;
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    public abstract z1 subSetImpl(Object obj, boolean z2, Object obj2, boolean z3);

    public abstract z1 tailSetImpl(Object obj, boolean z2);

    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // i4.s1, i4.a0
    public Object writeReplace() {
        return new y1(this.comparator, toArray());
    }

    public static <E> z1 copyOf(Iterable<? extends E> iterable) {
        return copyOf(o4.natural(), iterable);
    }

    public static <E extends Comparable<? super E>> z1 of(E e) {
        return new a5(h0.of(e), o4.natural());
    }

    public static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    public z1 descendingSet() {
        z1 z1Var = this.descendingSet;
        if (z1Var != null) {
            return z1Var;
        }
        z1 z1VarCreateDescendingSet = createDescendingSet();
        this.descendingSet = z1VarCreateDescendingSet;
        z1VarCreateDescendingSet.descendingSet = this;
        return z1VarCreateDescendingSet;
    }

    public static <E extends Comparable<? super E>> z1 of(E e, E e4) {
        return construct(o4.natural(), 2, e, e4);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public z1 headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public z1 subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public z1 tailSet(Object obj) {
        return tailSet(obj, true);
    }

    public static <E> z1 copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) o4.natural(), (Collection) collection);
    }

    public static <E extends Comparable<? super E>> z1 of(E e, E e4, E e10) {
        return construct(o4.natural(), 3, e, e4, e10);
    }

    @Override // java.util.NavigableSet
    public z1 headSet(Object obj, boolean z2) {
        obj.getClass();
        return headSetImpl(obj, z2);
    }

    @Override // java.util.NavigableSet
    public z1 subSet(Object obj, boolean z2, Object obj2, boolean z3) {
        obj.getClass();
        obj2.getClass();
        v8.e(this.comparator.compare(obj, obj2) <= 0);
        return subSetImpl(obj, z2, obj2, z3);
    }

    @Override // java.util.NavigableSet
    public z1 tailSet(Object obj, boolean z2) {
        obj.getClass();
        return tailSetImpl(obj, z2);
    }

    public static <E extends Comparable<? super E>> z1 of(E e, E e4, E e10, E e11) {
        return construct(o4.natural(), 4, e, e4, e10, e11);
    }

    public static <E> z1 copyOf(Iterator<? extends E> it) {
        return copyOf(o4.natural(), it);
    }

    public static <E extends Comparable<? super E>> z1 of(E e, E e4, E e10, E e11, E e12) {
        return construct(o4.natural(), 5, e, e4, e10, e11, e12);
    }

    public static <E extends Comparable<? super E>> z1 of(E e, E e4, E e10, E e11, E e12, E e13, E... eArr) {
        int length = eArr.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e;
        comparableArr[1] = e4;
        comparableArr[2] = e10;
        comparableArr[3] = e11;
        comparableArr[4] = e12;
        comparableArr[5] = e13;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return construct(o4.natural(), length, comparableArr);
    }

    public static <E> z1 copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        x1 x1Var = new x1(comparator);
        it.getClass();
        while (it.hasNext()) {
            x1Var.d(it.next());
        }
        return x1Var.e();
    }

    public static <E> z1 copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E> z1 copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Collection collection;
        comparator.getClass();
        if (n9.a(comparator, iterable) && (iterable instanceof z1)) {
            z1 z1Var = (z1) iterable;
            if (!z1Var.isPartialView()) {
                return z1Var;
            }
        }
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h9.a(arrayList, it);
            collection = arrayList;
        }
        Object[] array = collection.toArray();
        return construct(comparator, array.length, array);
    }
}
