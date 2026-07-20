package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public abstract class y3<E> extends z3<E> implements r6<E> {

    @u1.b
    @gm.a
    transient y3<E> descendingMultiset;

    public static class a<E> extends p3.b<E> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Comparator<? super E> f5601e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @b1.e
        public E[] f5602f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int[] f5603g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f5604h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f5605i;

        public a(Comparator<? super E> comparator) {
            super(true);
            comparator.getClass();
            this.f5601e = comparator;
            this.f5602f = (E[]) new Object[4];
            this.f5603g = new int[4];
        }

        @Override // f1.p3.b
        @t1.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<E> a(E element) {
            return k(element, 1);
        }

        @Override // f1.p3.b
        @t1.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a<E> b(E... elements) {
            for (E e10 : elements) {
                a(e10);
            }
            return this;
        }

        @Override // f1.p3.b
        @t1.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public a<E> c(Iterable<? extends E> elements) {
            if (elements instanceof b5) {
                for (b5.a<E> aVar : ((b5) elements).entrySet()) {
                    k(aVar.getElement(), aVar.getCount());
                }
            } else {
                Iterator<? extends E> it = elements.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            }
            return this;
        }

        @Override // f1.p3.b
        @t1.a
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public a<E> d(Iterator<? extends E> elements) {
            while (elements.hasNext()) {
                a(elements.next());
            }
            return this;
        }

        @Override // f1.p3.b
        @t1.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public a<E> k(E element, int occurrences) {
            element.getClass();
            b0.b(occurrences, "occurrences");
            if (occurrences == 0) {
                return this;
            }
            w();
            E[] eArr = this.f5602f;
            int i10 = this.f5604h;
            eArr[i10] = element;
            this.f5603g[i10] = occurrences;
            this.f5604h = i10 + 1;
            return this;
        }

        @Override // f1.p3.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public y3<E> e() {
            v();
            int i10 = this.f5604h;
            if (i10 == 0) {
                return y3.emptyMultiset(this.f5601e);
            }
            c6 c6Var = (c6) a4.construct(this.f5601e, i10, this.f5602f);
            long[] jArr = new long[this.f5604h + 1];
            int i11 = 0;
            while (i11 < this.f5604h) {
                int i12 = i11 + 1;
                jArr[i12] = jArr[i11] + ((long) this.f5603g[i11]);
                i11 = i12;
            }
            this.f5605i = true;
            return new b6(c6Var, jArr, 0, this.f5604h);
        }

        public final void u(boolean z10) {
            int i10 = this.f5604h;
            if (i10 == 0) {
                return;
            }
            Object[] objArr = (E[]) Arrays.copyOf(this.f5602f, i10);
            Arrays.sort(objArr, this.f5601e);
            int i11 = 1;
            for (int i12 = 1; i12 < objArr.length; i12++) {
                if (this.f5601e.compare((Object) objArr[i11 - 1], (Object) objArr[i12]) < 0) {
                    objArr[i11] = objArr[i12];
                    i11++;
                }
            }
            Arrays.fill(objArr, i11, this.f5604h, (Object) null);
            if (z10) {
                int i13 = i11 * 4;
                int i14 = this.f5604h;
                if (i13 > i14 * 3) {
                    objArr = (E[]) Arrays.copyOf(objArr, m1.f.t(i14, (i14 / 2) + 1));
                }
            }
            int[] iArr = new int[objArr.length];
            for (int i15 = 0; i15 < this.f5604h; i15++) {
                int iBinarySearch = Arrays.binarySearch(objArr, 0, i11, this.f5602f[i15], this.f5601e);
                int i16 = this.f5603g[i15];
                if (i16 >= 0) {
                    iArr[iBinarySearch] = iArr[iBinarySearch] + i16;
                } else {
                    iArr[iBinarySearch] = ~i16;
                }
            }
            this.f5602f = (E[]) objArr;
            this.f5603g = iArr;
            this.f5604h = i11;
        }

        public final void v() {
            u(false);
            int i10 = 0;
            int i11 = 0;
            while (true) {
                int i12 = this.f5604h;
                if (i10 >= i12) {
                    Arrays.fill(this.f5602f, i11, i12, (Object) null);
                    Arrays.fill(this.f5603g, i11, this.f5604h, 0);
                    this.f5604h = i11;
                    return;
                }
                int[] iArr = this.f5603g;
                int i13 = iArr[i10];
                if (i13 > 0) {
                    E[] eArr = this.f5602f;
                    eArr[i11] = eArr[i10];
                    iArr[i11] = i13;
                    i11++;
                }
                i10++;
            }
        }

        public final void w() {
            int i10 = this.f5604h;
            E[] eArr = this.f5602f;
            if (i10 == eArr.length) {
                u(true);
            } else if (this.f5605i) {
                this.f5602f = (E[]) Arrays.copyOf(eArr, eArr.length);
            }
            this.f5605i = false;
        }

        @Override // f1.p3.b
        @t1.a
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public a<E> m(E element, int count) {
            element.getClass();
            b0.b(count, "count");
            w();
            E[] eArr = this.f5602f;
            int i10 = this.f5604h;
            eArr[i10] = element;
            this.f5603g[i10] = ~count;
            this.f5604h = i10 + 1;
            return this;
        }
    }

    @b1.d
    public static final class b<E> implements Serializable {
        final Comparator<? super E> comparator;
        final int[] counts;
        final E[] elements;

        public b(r6<E> r6Var) {
            this.comparator = r6Var.comparator();
            int size = r6Var.entrySet().size();
            this.elements = (E[]) new Object[size];
            this.counts = new int[size];
            int i10 = 0;
            for (b5.a<E> aVar : r6Var.entrySet()) {
                this.elements[i10] = aVar.getElement();
                this.counts[i10] = aVar.getCount();
                i10++;
            }
        }

        public Object readResolve() {
            int length = this.elements.length;
            a aVar = new a(this.comparator);
            for (int i10 = 0; i10 < length; i10++) {
                aVar.k(this.elements[i10], this.counts[i10]);
            }
            return aVar.e();
        }
    }

    public static <E> y3<E> c(Comparator<? super E> comparator, Collection<b5.a<E>> entries) {
        if (entries.isEmpty()) {
            return emptyMultiset(comparator);
        }
        i3.a aVar = new i3.a(entries.size());
        long[] jArr = new long[entries.size() + 1];
        int i10 = 0;
        for (b5.a<E> aVar2 : entries) {
            aVar.j(aVar2.getElement());
            int i11 = i10 + 1;
            jArr[i11] = jArr[i10] + ((long) aVar2.getCount());
            i10 = i11;
        }
        return new b6(new c6(aVar.e(), comparator), jArr, 0, entries.size());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lf1/y3<TE;>; */
    public static y3 copyOf(Comparable[] elements) {
        return copyOf(l5.natural(), Arrays.asList(elements));
    }

    public static <E> y3<E> copyOfSorted(r6<E> sortedMultiset) {
        return c(sortedMultiset.comparator(), p4.r(sortedMultiset.entrySet()));
    }

    public static <E> y3<E> emptyMultiset(Comparator<? super E> comparator) {
        return l5.natural().equals(comparator) ? (y3<E>) b6.NATURAL_EMPTY_MULTISET : new b6(comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(l5.natural());
    }

    public static <E> y3<E> of() {
        return (y3<E>) b6.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(l5.natural().reverse());
    }

    @Override // f1.r6, f1.n6
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // f1.p3, f1.b5, f1.r6, f1.s6
    public abstract a4<E> elementSet();

    @Override // f1.r6
    public abstract y3<E> headMultiset(E upperBound, x boundType);

    @Override // f1.r6
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final b5.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.r6
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final b5.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.r6
    public abstract y3<E> tailMultiset(E lowerBound, x boundType);

    @Override // f1.p3, f1.e3
    @b1.d
    public Object writeReplace() {
        return new b(this);
    }

    public static <E> y3<E> copyOf(Iterable<? extends E> elements) {
        return copyOf(l5.natural(), elements);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lf1/y3<TE;>; */
    public static y3 of(Comparable element) {
        return new b6((c6) a4.of(element), new long[]{0, 1}, 0, 1);
    }

    @Override // f1.r6
    public y3<E> descendingMultiset() {
        y3<E> y3VarEmptyMultiset = this.descendingMultiset;
        if (y3VarEmptyMultiset == null) {
            y3VarEmptyMultiset = isEmpty() ? emptyMultiset(l5.from(comparator()).reverse()) : new t0<>(this);
            this.descendingMultiset = y3VarEmptyMultiset;
        }
        return y3VarEmptyMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.r6
    public y3<E> subMultiset(E lowerBound, x lowerBoundType, E upperBound, x upperBoundType) {
        c1.h0.y(comparator().compare(lowerBound, upperBound) <= 0, "Expected lowerBound <= upperBound but %s > %s", lowerBound, upperBound);
        return tailMultiset((Object) lowerBound, lowerBoundType).headMultiset((Object) upperBound, upperBoundType);
    }

    public static <E> y3<E> copyOf(Iterator<? extends E> elements) {
        return copyOf(l5.natural(), elements);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lf1/y3<TE;>; */
    public static y3 of(Comparable e10, Comparable e11) {
        return copyOf(l5.natural(), Arrays.asList(e10, e11));
    }

    public static <E> y3<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> elements) {
        if (elements instanceof y3) {
            y3<E> y3Var = (y3) elements;
            if (comparator.equals(y3Var.comparator())) {
                return y3Var.isPartialView() ? c(comparator, y3Var.entrySet().asList()) : y3Var;
            }
        }
        return new a(comparator).c(elements).e();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lf1/y3<TE;>; */
    public static y3 of(Comparable e10, Comparable e11, Comparable e12) {
        return copyOf(l5.natural(), Arrays.asList(e10, e11, e12));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lf1/y3<TE;>; */
    public static y3 of(Comparable e10, Comparable e11, Comparable e12, Comparable e13) {
        return copyOf(l5.natural(), Arrays.asList(e10, e11, e12, e13));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lf1/y3<TE;>; */
    public static y3 of(Comparable e10, Comparable e11, Comparable e12, Comparable e13, Comparable e14) {
        return copyOf(l5.natural(), Arrays.asList(e10, e11, e12, e13, e14));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lf1/y3<TE;>; */
    public static y3 of(Comparable e10, Comparable e11, Comparable e12, Comparable e13, Comparable e14, Comparable e15, Comparable... remaining) {
        ArrayList arrayListU = p4.u(remaining.length + 6);
        Collections.addAll(arrayListU, e10, e11, e12, e13, e14, e15);
        Collections.addAll(arrayListU, remaining);
        return copyOf(l5.natural(), arrayListU);
    }

    public static <E> y3<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> elements) {
        comparator.getClass();
        return new a(comparator).d(elements).e();
    }
}
