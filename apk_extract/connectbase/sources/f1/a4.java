package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public abstract class a4<E> extends b4<E> implements NavigableSet<E>, n6<E> {
    final transient Comparator<? super E> comparator;

    @b1.c
    @u1.b
    @gm.a
    transient a4<E> descendingSet;

    public static final class a<E> extends t3.a<E> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Comparator<? super E> f4700g;

        public a(Comparator<? super E> comparator) {
            super(4);
            comparator.getClass();
            this.f4700g = comparator;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.t3.a, f1.e3.a, f1.e3.b
        @t1.a
        public e3.b a(Object element) {
            super.a(element);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.t3.a, f1.e3.a, f1.e3.b
        @t1.a
        public e3.b b(Object[] elements) {
            super.b(elements);
            return this;
        }

        @Override // f1.t3.a, f1.e3.a, f1.e3.b
        @t1.a
        public e3.b c(Iterable elements) {
            super.c(elements);
            return this;
        }

        @Override // f1.t3.a, f1.e3.b
        @t1.a
        public e3.b d(Iterator elements) {
            super.d(elements);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.t3.a, f1.e3.a
        @t1.a
        /* JADX INFO: renamed from: g */
        public e3.a a(Object element) {
            super.a(element);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.t3.a
        @t1.a
        /* JADX INFO: renamed from: j */
        public t3.a a(Object element) {
            super.a(element);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.t3.a
        @t1.a
        /* JADX INFO: renamed from: k */
        public t3.a b(Object[] elements) {
            super.b(elements);
            return this;
        }

        @Override // f1.t3.a
        @t1.a
        /* JADX INFO: renamed from: l */
        public t3.a c(Iterable elements) {
            super.c(elements);
            return this;
        }

        @Override // f1.t3.a
        @t1.a
        /* JADX INFO: renamed from: m */
        public t3.a d(Iterator elements) {
            super.d(elements);
            return this;
        }

        @Override // f1.t3.a
        @t1.a
        public t3.a p(t3.a builder) {
            super.p(builder);
            return this;
        }

        @t1.a
        public a<E> q(E element) {
            super.a(element);
            return this;
        }

        @t1.a
        public a<E> r(E... elements) {
            super.b(elements);
            return this;
        }

        @t1.a
        public a<E> s(Iterable<? extends E> elements) {
            super.c(elements);
            return this;
        }

        @t1.a
        public a<E> t(Iterator<? extends E> elements) {
            super.d(elements);
            return this;
        }

        @Override // f1.t3.a
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public a4<E> e() {
            a4<E> a4VarConstruct = a4.construct(this.f4700g, this.f4853c, this.f4852b);
            this.f4853c = a4VarConstruct.size();
            this.f4854d = true;
            return a4VarConstruct;
        }

        @t1.a
        public a<E> v(t3.a<E> builder) {
            super.p(builder);
            return this;
        }
    }

    @b1.d
    public static class b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public b(Comparator<? super E> comparator, Object[] elements) {
            this.comparator = comparator;
            this.elements = elements;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Object readResolve() {
            return new a(this.comparator).r(this.elements).e();
        }
    }

    public a4(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <E> a4<E> construct(Comparator<? super E> comparator, int i10, E... eArr) {
        if (i10 == 0) {
            return emptySet(comparator);
        }
        i5.c(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            a1.e eVar = (Object) eArr[i12];
            if (comparator.compare(eVar, (Object) eArr[i11 - 1]) != 0) {
                eArr[i11] = eVar;
                i11++;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        if (i11 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i11);
        }
        return new c6(i3.asImmutableList(eArr, i11), comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lf1/a4<TE;>; */
    public static a4 copyOf(Comparable[] elements) {
        return construct(l5.natural(), elements.length, (Comparable[]) elements.clone());
    }

    public static <E> a4<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator comparatorA = o6.a(sortedSet);
        i3 i3VarCopyOf = i3.copyOf((Collection) sortedSet);
        return i3VarCopyOf.isEmpty() ? emptySet(comparatorA) : new c6(i3VarCopyOf, comparatorA);
    }

    public static <E> c6<E> emptySet(Comparator<? super E> comparator) {
        return l5.natural().equals(comparator) ? (c6<E>) c6.NATURAL_EMPTY_SET : new c6<>(i3.of(), comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(l5.natural());
    }

    public static <E> a4<E> of() {
        return c6.NATURAL_EMPTY_SET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    @b1.d
    private void readObject(ObjectInputStream unused) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Collections.reverseOrder());
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E ceiling(E e10) {
        return (E) g4.v(tailSet((Object) e10, true), null);
    }

    @Override // java.util.SortedSet, f1.n6
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @b1.c
    public abstract a4<E> createDescendingSet();

    @Override // java.util.NavigableSet
    @b1.c
    public abstract x7<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    @gm.a
    public E floor(E e10) {
        return (E) h4.J(headSet((Object) e10, true).descendingIterator(), null);
    }

    public abstract a4<E> headSetImpl(E toElement, boolean inclusive);

    @Override // java.util.NavigableSet
    @b1.c
    @gm.a
    public E higher(E e10) {
        return (E) g4.v(tailSet((Object) e10, false), null);
    }

    public abstract int indexOf(@gm.a Object target);

    @Override // f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public abstract x7<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @b1.c
    @gm.a
    public E lower(E e10) {
        return (E) h4.J(headSet((Object) e10, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @b1.c
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @b1.c
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public abstract a4<E> subSetImpl(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive);

    public abstract a4<E> tailSetImpl(E fromElement, boolean inclusive);

    public int unsafeCompare(Object a10, @gm.a Object b10) {
        return unsafeCompare(this.comparator, a10, b10);
    }

    @Override // f1.t3, f1.e3
    @b1.d
    public Object writeReplace() {
        return new b(this.comparator, toArray());
    }

    public static <E> a4<E> copyOf(Iterable<? extends E> elements) {
        return copyOf(l5.natural(), elements);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lf1/a4<TE;>; */
    public static a4 of(Comparable element) {
        return new c6(i3.of(element), l5.natural());
    }

    public static int unsafeCompare(Comparator<?> comparator, Object a10, @gm.a Object b10) {
        return comparator.compare(a10, b10);
    }

    @Override // java.util.NavigableSet
    @b1.c
    public a4<E> descendingSet() {
        a4<E> a4Var = this.descendingSet;
        if (a4Var != null) {
            return a4Var;
        }
        a4<E> a4VarCreateDescendingSet = createDescendingSet();
        this.descendingSet = a4VarCreateDescendingSet;
        a4VarCreateDescendingSet.descendingSet = this;
        return a4VarCreateDescendingSet;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lf1/a4<TE;>; */
    public static a4 of(Comparable e10, Comparable e11) {
        return construct(l5.natural(), 2, e10, e11);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public a4<E> headSet(E toElement) {
        return headSet((Object) toElement, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public a4<E> subSet(E fromElement, E toElement) {
        return subSet((Object) fromElement, true, (Object) toElement, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public a4<E> tailSet(E fromElement) {
        return tailSet((Object) fromElement, true);
    }

    public static <E> a4<E> copyOf(Collection<? extends E> elements) {
        return copyOf((Comparator) l5.natural(), (Collection) elements);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lf1/a4<TE;>; */
    public static a4 of(Comparable e10, Comparable e11, Comparable e12) {
        return construct(l5.natural(), 3, e10, e11, e12);
    }

    @Override // java.util.NavigableSet
    public a4<E> headSet(E toElement, boolean inclusive) {
        toElement.getClass();
        return headSetImpl(toElement, inclusive);
    }

    @Override // java.util.NavigableSet
    @b1.c
    public a4<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
        fromElement.getClass();
        toElement.getClass();
        c1.h0.d(this.comparator.compare(fromElement, toElement) <= 0);
        return subSetImpl(fromElement, fromInclusive, toElement, toInclusive);
    }

    @Override // java.util.NavigableSet
    public a4<E> tailSet(E fromElement, boolean inclusive) {
        fromElement.getClass();
        return tailSetImpl(fromElement, inclusive);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lf1/a4<TE;>; */
    public static a4 of(Comparable e10, Comparable e11, Comparable e12, Comparable e13) {
        return construct(l5.natural(), 4, e10, e11, e12, e13);
    }

    public static <E> a4<E> copyOf(Iterator<? extends E> elements) {
        return copyOf(l5.natural(), elements);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lf1/a4<TE;>; */
    public static a4 of(Comparable e10, Comparable e11, Comparable e12, Comparable e13, Comparable e14) {
        return construct(l5.natural(), 5, e10, e11, e12, e13, e14);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lf1/a4<TE;>; */
    public static a4 of(Comparable e10, Comparable e11, Comparable e12, Comparable e13, Comparable e14, Comparable e15, Comparable... remaining) {
        int length = remaining.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e10;
        comparableArr[1] = e11;
        comparableArr[2] = e12;
        comparableArr[3] = e13;
        comparableArr[4] = e14;
        comparableArr[5] = e15;
        System.arraycopy(remaining, 0, comparableArr, 6, remaining.length);
        return construct(l5.natural(), length, comparableArr);
    }

    public static <E> a4<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> elements) {
        return new a(comparator).t(elements).e();
    }

    public static <E> a4<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> elements) {
        return copyOf((Comparator) comparator, (Iterable) elements);
    }

    public static <E> a4<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> elements) {
        comparator.getClass();
        if (o6.b(comparator, elements) && (elements instanceof a4)) {
            a4<E> a4Var = (a4) elements;
            if (!a4Var.isPartialView()) {
                return a4Var;
            }
        }
        Object[] objArrP = g4.P(elements);
        return construct(comparator, objArrP.length, objArrP);
    }
}
