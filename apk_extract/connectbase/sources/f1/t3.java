package f1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public abstract class t3<E> extends e3<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final double f5290c = 0.7d;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f5291d = 751619276;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient i3<E> f5292b;

    public static class a<E> extends e3.a<E> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        @b1.e
        public Object[] f5293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5294f;

        public a() {
            super(4);
        }

        @Override // f1.e3.a
        @t1.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public a<E> a(E element) {
            element.getClass();
            if (this.f5293e != null && t3.chooseTableSize(this.f4853c) <= this.f5293e.length) {
                n(element);
                return this;
            }
            this.f5293e = null;
            super.a(element);
            return this;
        }

        @Override // f1.e3.a, f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public a<E> b(E... elements) {
            if (this.f5293e != null) {
                for (E e10 : elements) {
                    a(e10);
                }
            } else {
                h(elements, elements.length);
            }
            return this;
        }

        @Override // f1.e3.a, f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public a<E> c(Iterable<? extends E> elements) {
            elements.getClass();
            if (this.f5293e != null) {
                Iterator<? extends E> it = elements.iterator();
                while (it.hasNext()) {
                    a(it.next());
                }
            } else {
                super.c(elements);
            }
            return this;
        }

        @Override // f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<E> d(Iterator<? extends E> elements) {
            elements.getClass();
            while (elements.hasNext()) {
                a(elements.next());
            }
            return this;
        }

        public final void n(E element) {
            Objects.requireNonNull(this.f5293e);
            int length = this.f5293e.length - 1;
            int iHashCode = element.hashCode();
            int iC = z2.c(iHashCode);
            while (true) {
                int i10 = iC & length;
                Object[] objArr = this.f5293e;
                Object obj = objArr[i10];
                if (obj == null) {
                    objArr[i10] = element;
                    this.f5294f += iHashCode;
                    super.a(element);
                    return;
                } else if (obj.equals(element)) {
                    return;
                } else {
                    iC = i10 + 1;
                }
            }
        }

        @Override // f1.e3.b
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public t3<E> e() {
            t3<E> t3VarA;
            int i10 = this.f4853c;
            if (i10 == 0) {
                return t3.of();
            }
            if (i10 == 1) {
                Object obj = this.f4852b[0];
                Objects.requireNonNull(obj);
                return t3.of(obj);
            }
            if (this.f5293e == null || t3.chooseTableSize(i10) != this.f5293e.length) {
                t3VarA = t3.a(this.f4853c, this.f4852b);
                this.f4853c = t3VarA.size();
            } else {
                Object[] objArrCopyOf = t3.b(this.f4853c, this.f4852b.length) ? Arrays.copyOf(this.f4852b, this.f4853c) : this.f4852b;
                int i11 = this.f5294f;
                Object[] objArr = this.f5293e;
                t3VarA = new a6<>(objArrCopyOf, i11, objArr, objArr.length - 1, this.f4853c);
            }
            this.f4854d = true;
            this.f5293e = null;
            return t3VarA;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @t1.a
        public a<E> p(a<E> other) {
            if (this.f5293e != null) {
                for (int i10 = 0; i10 < other.f4853c; i10++) {
                    Object obj = other.f4852b[i10];
                    Objects.requireNonNull(obj);
                    a(obj);
                }
            } else {
                h(other.f4852b, other.f4853c);
            }
            return this;
        }

        public a(int capacity) {
            super(capacity);
            this.f5293e = new Object[t3.chooseTableSize(capacity)];
        }
    }

    @b1.d
    public static class b implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        public b(Object[] elements) {
            this.elements = elements;
        }

        public Object readResolve() {
            return t3.copyOf(this.elements);
        }
    }

    public static <E> t3<E> a(int n10, Object... elements) {
        if (n10 == 0) {
            return of();
        }
        if (n10 == 1) {
            Object obj = elements[0];
            Objects.requireNonNull(obj);
            return of(obj);
        }
        int iChooseTableSize = chooseTableSize(n10);
        Object[] objArr = new Object[iChooseTableSize];
        int i10 = iChooseTableSize - 1;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < n10; i13++) {
            Object objA = i5.a(elements[i13], i13);
            int iHashCode = objA.hashCode();
            int iC = z2.c(iHashCode);
            while (true) {
                int i14 = iC & i10;
                Object obj2 = objArr[i14];
                if (obj2 == null) {
                    elements[i12] = objA;
                    objArr[i14] = objA;
                    i11 += iHashCode;
                    i12++;
                    break;
                }
                if (obj2.equals(objA)) {
                    break;
                }
                iC++;
            }
        }
        Arrays.fill(elements, i12, n10, (Object) null);
        if (i12 == 1) {
            Object obj3 = elements[0];
            Objects.requireNonNull(obj3);
            return new l6(obj3);
        }
        if (chooseTableSize(i12) < iChooseTableSize / 2) {
            return a(i12, elements);
        }
        if (b(i12, elements.length)) {
            elements = Arrays.copyOf(elements, i12);
        }
        return new a6(elements, i11, objArr, i10, i12);
    }

    public static boolean b(int actualUnique, int expectedUnique) {
        return actualUnique < (expectedUnique >> 1) + (expectedUnique >> 2);
    }

    public static <E> a<E> builder() {
        return new a<>(4);
    }

    public static <E> a<E> builderWithExpectedSize(int expectedSize) {
        b0.b(expectedSize, "expectedSize");
        return new a<>(expectedSize);
    }

    @b1.e
    public static int chooseTableSize(int setSize) {
        int iMax = Math.max(setSize, 2);
        if (iMax >= 751619276) {
            c1.h0.e(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (((double) iHighestOneBit) * 0.7d < iMax) {
            iHighestOneBit <<= 1;
        }
        return iHighestOneBit;
    }

    public static <E> t3<E> copyOf(Collection<? extends E> elements) {
        if ((elements instanceof t3) && !(elements instanceof SortedSet)) {
            t3<E> t3Var = (t3) elements;
            if (!t3Var.isPartialView()) {
                return t3Var;
            }
        }
        Object[] array = elements.toArray();
        return a(array.length, array);
    }

    public static <E> t3<E> of() {
        return a6.EMPTY;
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.e3
    public i3<E> asList() {
        i3<E> i3Var = this.f5292b;
        if (i3Var != null) {
            return i3Var;
        }
        i3<E> i3VarCreateAsList = createAsList();
        this.f5292b = i3VarCreateAsList;
        return i3VarCreateAsList;
    }

    public i3<E> createAsList() {
        return i3.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if ((object instanceof t3) && isHashCodeFast() && ((t3) object).isHashCodeFast() && hashCode() != object.hashCode()) {
            return false;
        }
        return k6.g(this, object);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return k6.k(this);
    }

    public boolean isHashCodeFast() {
        return false;
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public abstract x7<E> iterator();

    @Override // f1.e3
    @b1.d
    public Object writeReplace() {
        return new b(toArray());
    }

    public static <E> t3<E> of(E element) {
        return new l6(element);
    }

    public static <E> t3<E> of(E e10, E e11) {
        return a(2, e10, e11);
    }

    public static <E> t3<E> of(E e10, E e11, E e12) {
        return a(3, e10, e11, e12);
    }

    public static <E> t3<E> of(E e10, E e11, E e12, E e13) {
        return a(4, e10, e11, e12, e13);
    }

    public static <E> t3<E> copyOf(Iterable<? extends E> elements) {
        if (elements instanceof Collection) {
            return copyOf((Collection) elements);
        }
        return copyOf(elements.iterator());
    }

    public static <E> t3<E> of(E e10, E e11, E e12, E e13, E e14) {
        return a(5, e10, e11, e12, e13, e14);
    }

    @SafeVarargs
    public static <E> t3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... others) {
        c1.h0.e(others.length <= 2147483641, "the total number of elements must fit in an int");
        int length = others.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        System.arraycopy(others, 0, objArr, 6, others.length);
        return a(length, objArr);
    }

    public static <E> t3<E> copyOf(Iterator<? extends E> elements) {
        if (!elements.hasNext()) {
            return of();
        }
        E next = elements.next();
        if (!elements.hasNext()) {
            return of((Object) next);
        }
        return new a(4).a(next).d(elements).e();
    }

    public static <E> t3<E> copyOf(E[] elements) {
        int length = elements.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return a(elements.length, (Object[]) elements.clone());
        }
        return of((Object) elements[0]);
    }
}
