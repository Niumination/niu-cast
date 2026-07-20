package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public abstract class i3<E> extends e3<E> implements List<E>, RandomAccess {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final y7<Object> f4974b = new b(x5.EMPTY, 0);

    public static final class a<E> extends e3.a<E> {
        public a() {
            super(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.e3.a, f1.e3.b
        @t1.a
        public e3.b a(Object element) {
            super.a(element);
            return this;
        }

        @Override // f1.e3.a, f1.e3.b
        @t1.a
        public e3.b b(Object[] elements) {
            h(elements, elements.length);
            return this;
        }

        @Override // f1.e3.a, f1.e3.b
        @t1.a
        public e3.b c(Iterable elements) {
            super.c(elements);
            return this;
        }

        @Override // f1.e3.b
        @t1.a
        public e3.b d(Iterator elements) {
            super.d(elements);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.e3.a
        @t1.a
        /* JADX INFO: renamed from: g */
        public e3.a a(Object element) {
            super.a(element);
            return this;
        }

        @t1.a
        public a<E> j(E element) {
            super.a(element);
            return this;
        }

        @t1.a
        public a<E> k(E... elements) {
            h(elements, elements.length);
            return this;
        }

        @t1.a
        public a<E> l(Iterable<? extends E> elements) {
            super.c(elements);
            return this;
        }

        @t1.a
        public a<E> m(Iterator<? extends E> elements) {
            super.d(elements);
            return this;
        }

        @Override // f1.e3.b
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public i3<E> e() {
            this.f4854d = true;
            return i3.asImmutableList(this.f4852b, this.f4853c);
        }

        @t1.a
        public a<E> o(a<E> other) {
            h(other.f4852b, other.f4853c);
            return this;
        }

        public a(int capacity) {
            super(capacity);
        }
    }

    public static class b<E> extends f1.b<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i3<E> f4975c;

        public b(i3<E> list, int index) {
            super(list.size(), index);
            this.f4975c = list;
        }

        @Override // f1.b
        public E a(int index) {
            return this.f4975c.get(index);
        }
    }

    public static class c<E> extends i3<E> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final transient i3<E> f4976c;

        public c(i3<E> backingList) {
            this.f4976c = backingList;
        }

        public final int b(int index) {
            return (size() - 1) - index;
        }

        public final int c(int index) {
            return size() - index;
        }

        @Override // f1.i3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            return this.f4976c.contains(object);
        }

        @Override // java.util.List
        public E get(int index) {
            c1.h0.C(index, size());
            return this.f4976c.get(b(index));
        }

        @Override // f1.i3, java.util.List
        public int indexOf(@gm.a Object object) {
            int iLastIndexOf = this.f4976c.lastIndexOf(object);
            if (iLastIndexOf >= 0) {
                return b(iLastIndexOf);
            }
            return -1;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return this.f4976c.isPartialView();
        }

        @Override // f1.i3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // f1.i3, java.util.List
        public int lastIndexOf(@gm.a Object object) {
            int iIndexOf = this.f4976c.indexOf(object);
            if (iIndexOf >= 0) {
                return b(iIndexOf);
            }
            return -1;
        }

        @Override // f1.i3, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // f1.i3
        public i3<E> reverse() {
            return this.f4976c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f4976c.size();
        }

        @Override // f1.i3, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int index) {
            return super.listIterator(index);
        }

        @Override // f1.i3, java.util.List
        public i3<E> subList(int fromIndex, int toIndex) {
            c1.h0.f0(fromIndex, toIndex, size());
            return this.f4976c.subList(size() - toIndex, size() - fromIndex).reverse();
        }
    }

    @b1.d
    public static class d implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public d(Object[] elements) {
            this.elements = elements;
        }

        public Object readResolve() {
            return i3.copyOf(this.elements);
        }
    }

    public class e extends i3<E> {
        final transient int length;
        final transient int offset;

        public e(int offset, int length) {
            this.offset = offset;
            this.length = length;
        }

        @Override // java.util.List
        public E get(int index) {
            c1.h0.C(index, this.length);
            return i3.this.get(index + this.offset);
        }

        @Override // f1.e3
        @gm.a
        public Object[] internalArray() {
            return i3.this.internalArray();
        }

        @Override // f1.e3
        public int internalArrayEnd() {
            return i3.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // f1.e3
        public int internalArrayStart() {
            return i3.this.internalArrayStart() + this.offset;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // f1.i3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // f1.i3, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // f1.i3, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int index) {
            return super.listIterator(index);
        }

        @Override // f1.i3, java.util.List
        public i3<E> subList(int fromIndex, int toIndex) {
            c1.h0.f0(fromIndex, toIndex, this.length);
            i3 i3Var = i3.this;
            int i10 = this.offset;
            return i3Var.subList(fromIndex + i10, toIndex + i10);
        }
    }

    public static <E> i3<E> a(Object... elements) {
        i5.c(elements, elements.length);
        return asImmutableList(elements);
    }

    public static <E> i3<E> asImmutableList(Object[] elements) {
        return asImmutableList(elements, elements.length);
    }

    public static <E> a<E> builder() {
        return new a<>(4);
    }

    public static <E> a<E> builderWithExpectedSize(int expectedSize) {
        b0.b(expectedSize, "expectedSize");
        return new a<>(expectedSize);
    }

    public static <E> i3<E> copyOf(Collection<? extends E> elements) {
        if (!(elements instanceof e3)) {
            return a(elements.toArray());
        }
        i3<E> i3VarAsList = ((e3) elements).asList();
        return i3VarAsList.isPartialView() ? asImmutableList(i3VarAsList.toArray()) : i3VarAsList;
    }

    public static <E> i3<E> of() {
        return (i3<E>) x5.EMPTY;
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> i3<E> sortedCopyOf(Iterable<? extends E> elements) {
        Comparable[] comparableArr = (Comparable[]) g4.R(elements, new Comparable[0]);
        i5.c(comparableArr, comparableArr.length);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    @Override // java.util.List
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean addAll(int index, Collection<? extends E> newElements) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.e3
    @t1.l(replacement = "this")
    @Deprecated
    public final i3<E> asList() {
        return this;
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return indexOf(object) >= 0;
    }

    @Override // f1.e3
    public int copyIntoArray(Object[] dst, int offset) {
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            dst[offset + i10] = get(i10);
        }
        return offset + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@gm.a Object obj) {
        return p4.j(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~(get(i11).hashCode() + (i10 * 31)));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(@gm.a Object object) {
        if (object == null) {
            return -1;
        }
        return p4.l(this, object);
    }

    @Override // java.util.List
    public int lastIndexOf(@gm.a Object object) {
        if (object == null) {
            return -1;
        }
        return p4.n(this, object);
    }

    @Override // java.util.List
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final E remove(int index) {
        throw new UnsupportedOperationException();
    }

    public i3<E> reverse() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final E set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public i3<E> subListUnchecked(int fromIndex, int toIndex) {
        return new e(fromIndex, toIndex - fromIndex);
    }

    @Override // f1.e3
    @b1.d
    public Object writeReplace() {
        return new d(toArray());
    }

    public static <E> i3<E> asImmutableList(Object[] elements, int length) {
        return length == 0 ? of() : new x5(elements, length);
    }

    public static <E> i3<E> of(E element) {
        return a(element);
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public i3<E> subList(int fromIndex, int toIndex) {
        c1.h0.f0(fromIndex, toIndex, size());
        int i10 = toIndex - fromIndex;
        if (i10 == size()) {
            return this;
        }
        return i10 == 0 ? of() : subListUnchecked(fromIndex, toIndex);
    }

    public static <E> i3<E> of(E e10, E e11) {
        return a(e10, e11);
    }

    @Override // java.util.List
    public y7<E> listIterator() {
        return listIterator(0);
    }

    public static <E> i3<E> of(E e10, E e11, E e12) {
        return a(e10, e11, e12);
    }

    @Override // java.util.List
    public y7<E> listIterator(int i10) {
        c1.h0.d0(i10, size());
        if (isEmpty()) {
            return (y7<E>) f4974b;
        }
        return new b(this, i10);
    }

    public static <E> i3<E> copyOf(Iterator<? extends E> elements) {
        if (!elements.hasNext()) {
            return of();
        }
        E next = elements.next();
        if (!elements.hasNext()) {
            return of((Object) next);
        }
        return new a(4).j(next).m(elements).e();
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13) {
        return a(e10, e11, e12, e13);
    }

    public static <E> i3<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> elements) {
        comparator.getClass();
        Object[] objArrP = g4.P(elements);
        i5.c(objArrP, objArrP.length);
        Arrays.sort(objArrP, comparator);
        return asImmutableList(objArrP);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14) {
        return a(e10, e11, e12, e13, e14);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15) {
        return a(e10, e11, e12, e13, e14, e15);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return a(e10, e11, e12, e13, e14, e15, e16);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        return a(e10, e11, e12, e13, e14, e15, e16, e17);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        return a(e10, e11, e12, e13, e14, e15, e16, e17, e18);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19) {
        return a(e10, e11, e12, e13, e14, e15, e16, e17, e18, e19);
    }

    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e110) {
        return a(e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e110);
    }

    public static <E> i3<E> copyOf(E[] elements) {
        if (elements.length == 0) {
            return of();
        }
        return a((Object[]) elements.clone());
    }

    @SafeVarargs
    public static <E> i3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e110, E e111, E... others) {
        c1.h0.e(others.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[others.length + 12];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        objArr[6] = e16;
        objArr[7] = e17;
        objArr[8] = e18;
        objArr[9] = e19;
        objArr[10] = e110;
        objArr[11] = e111;
        System.arraycopy(others, 0, objArr, 12, others.length);
        return a(objArr);
    }

    public static <E> i3<E> copyOf(Iterable<? extends E> elements) {
        elements.getClass();
        if (elements instanceof Collection) {
            return copyOf((Collection) elements);
        }
        return copyOf(elements.iterator());
    }
}
