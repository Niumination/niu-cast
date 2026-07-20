package i4;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import k3.d9;
import k3.h9;
import k3.k9;
import k3.u8;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 extends a0 implements List, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0 f5601b = new d0(p4.EMPTY, 0);

    public static <E> h0 asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> c0 builder() {
        return new c0(4);
    }

    public static <E> c0 builderWithExpectedSize(int i8) {
        d9.b(i8, "expectedSize");
        return new c0(i8);
    }

    public static <E> h0 copyOf(Collection<? extends E> collection) {
        if (collection instanceof a0) {
            h0 h0VarAsList = ((a0) collection).asList();
            return h0VarAsList.isPartialView() ? asImmutableList(h0VarAsList.toArray()) : h0VarAsList;
        }
        Object[] array = collection.toArray();
        k9.a(array.length, array);
        return asImmutableList(array);
    }

    public static <E> h0 of() {
        return p4.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> h0 sortedCopyOf(Iterable<? extends E> iterable) {
        Collection collection;
        Comparable[] comparableArr = new Comparable[0];
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h9.a(arrayList, it);
            collection = arrayList;
        }
        Comparable[] comparableArr2 = (Comparable[]) collection.toArray(comparableArr);
        k9.a(comparableArr2.length, comparableArr2);
        Arrays.sort(comparableArr2);
        return asImmutableList(comparableArr2);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i8, Collection<Object> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // i4.a0
    @Deprecated
    public final h0 asList() {
        return this;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        int size = size();
        for (int i9 = 0; i9 < size; i9++) {
            objArr[i8 + i9] = get(i9);
        }
        return i8 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (list instanceof RandomAccess) {
                    for (int i8 = 0; i8 < size; i8++) {
                        if (u8.a(get(i8), list.get(i8))) {
                        }
                    }
                    return true;
                }
                Iterator it = iterator();
                Iterator it2 = list.iterator();
                while (it.hasNext()) {
                    if (it2.hasNext() && u8.a(it.next(), it2.next())) {
                    }
                }
                return !it2.hasNext();
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i8 = 1;
        for (int i9 = 0; i9 < size; i9++) {
            i8 = ~(~(get(i9).hashCode() + (i8 * 31)));
        }
        return i8;
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i8 = 0; i8 < size; i8++) {
            if (obj.equals(get(i8))) {
                return i8;
            }
        }
        return -1;
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i8) {
        throw new UnsupportedOperationException();
    }

    public h0 reverse() {
        return size() <= 1 ? this : new e0(this);
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i8, Object obj) {
        throw new UnsupportedOperationException();
    }

    public h0 subListUnchecked(int i8, int i9) {
        return new g0(this, i8, i9 - i8);
    }

    @Override // i4.a0
    public Object writeReplace() {
        return new f0(toArray());
    }

    public static <E> h0 asImmutableList(Object[] objArr, int i8) {
        return i8 == 0 ? of() : new p4(objArr, i8);
    }

    public static <E> h0 of(E e) {
        Object[] objArr = {e};
        k9.a(1, objArr);
        return asImmutableList(objArr);
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public h0 subList(int i8, int i9) {
        v8.k(i8, i9, size());
        int i10 = i9 - i8;
        if (i10 == size()) {
            return this;
        }
        return i10 == 0 ? of() : subListUnchecked(i8, i9);
    }

    @Override // java.util.List
    public i5 listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public i5 listIterator(int i8) {
        v8.j(i8, size());
        if (isEmpty()) {
            return f5601b;
        }
        return new d0(this, i8);
    }

    public static <E> h0 of(E e, E e4) {
        Object[] objArr = {e, e4};
        k9.a(2, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        c0 c0Var = new c0(4);
        c0Var.b(next);
        while (it.hasNext()) {
            c0Var.b(it.next());
        }
        c0Var.f5714c = true;
        return asImmutableList(c0Var.f5712a, c0Var.f5713b);
    }

    public static <E> h0 of(E e, E e4, E e10) {
        Object[] objArr = {e, e4, e10};
        k9.a(3, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11) {
        Object[] objArr = {e, e4, e10, e11};
        k9.a(4, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Collection collection;
        comparator.getClass();
        if (iterable instanceof Collection) {
            collection = (Collection) iterable;
        } else {
            Iterator<? extends E> it = iterable.iterator();
            ArrayList arrayList = new ArrayList();
            h9.a(arrayList, it);
            collection = arrayList;
        }
        Object[] array = collection.toArray();
        k9.a(array.length, array);
        Arrays.sort(array, comparator);
        return asImmutableList(array);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12) {
        Object[] objArr = {e, e4, e10, e11, e12};
        k9.a(5, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13) {
        Object[] objArr = {e, e4, e10, e11, e12, e13};
        k9.a(6, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        Object[] objArr = (Object[]) eArr.clone();
        k9.a(objArr.length, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13, E e14) {
        Object[] objArr = {e, e4, e10, e11, e12, e13, e14};
        k9.a(7, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13, E e14, E e15) {
        Object[] objArr = {e, e4, e10, e11, e12, e13, e14, e15};
        k9.a(8, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 copyOf(Iterable<? extends E> iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        Object[] objArr = {e, e4, e10, e11, e12, e13, e14, e15, e16};
        k9.a(9, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        Object[] objArr = {e, e4, e10, e11, e12, e13, e14, e15, e16, e17};
        k9.a(10, objArr);
        return asImmutableList(objArr);
    }

    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        Object[] objArr = {e, e4, e10, e11, e12, e13, e14, e15, e16, e17, e18};
        k9.a(11, objArr);
        return asImmutableList(objArr);
    }

    @SafeVarargs
    public static <E> h0 of(E e, E e4, E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E... eArr) {
        v8.c("the total number of elements must fit in an int", eArr.length <= 2147483635);
        int length = eArr.length + 12;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e4;
        objArr[2] = e10;
        objArr[3] = e11;
        objArr[4] = e12;
        objArr[5] = e13;
        objArr[6] = e14;
        objArr[7] = e15;
        objArr[8] = e16;
        objArr[9] = e17;
        objArr[10] = e18;
        objArr[11] = e19;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        k9.a(length, objArr);
        return asImmutableList(objArr);
    }
}
