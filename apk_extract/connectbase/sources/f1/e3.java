package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
@t1.f("Use ImmutableList.of or another implementation")
public abstract class e3<E> extends AbstractCollection<E> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object[] f4851a = new Object[0];

    public static abstract class a<E> extends b<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object[] f4852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4854d;

        public a(int initialCapacity) {
            b0.b(initialCapacity, "initialCapacity");
            this.f4852b = new Object[initialCapacity];
            this.f4853c = 0;
        }

        @Override // f1.e3.b
        @t1.a
        public b<E> b(E... elements) {
            h(elements, elements.length);
            return this;
        }

        @Override // f1.e3.b
        @t1.a
        public b<E> c(Iterable<? extends E> elements) {
            if (elements instanceof Collection) {
                Collection collection = (Collection) elements;
                i(collection.size() + this.f4853c);
                if (collection instanceof e3) {
                    this.f4853c = ((e3) collection).copyIntoArray(this.f4852b, this.f4853c);
                    return this;
                }
            }
            super.c(elements);
            return this;
        }

        @Override // f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public a<E> a(E element) {
            element.getClass();
            i(this.f4853c + 1);
            Object[] objArr = this.f4852b;
            int i10 = this.f4853c;
            this.f4853c = i10 + 1;
            objArr[i10] = element;
            return this;
        }

        public final void h(Object[] elements, int n10) {
            i5.c(elements, n10);
            i(this.f4853c + n10);
            System.arraycopy(elements, 0, this.f4852b, this.f4853c, n10);
            this.f4853c += n10;
        }

        public final void i(int minCapacity) {
            Object[] objArr = this.f4852b;
            if (objArr.length < minCapacity) {
                this.f4852b = Arrays.copyOf(objArr, b.f(objArr.length, minCapacity));
                this.f4854d = false;
            } else if (this.f4854d) {
                this.f4852b = (Object[]) objArr.clone();
                this.f4854d = false;
            }
        }
    }

    @t1.f
    public static abstract class b<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f4855a = 4;

        public static int f(int oldCapacity, int minCapacity) {
            if (minCapacity < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = oldCapacity + (oldCapacity >> 1) + 1;
            if (iHighestOneBit < minCapacity) {
                iHighestOneBit = Integer.highestOneBit(minCapacity - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        @t1.a
        public abstract b<E> a(E element);

        @t1.a
        public b<E> b(E... elements) {
            for (E e10 : elements) {
                a(e10);
            }
            return this;
        }

        @t1.a
        public b<E> c(Iterable<? extends E> elements) {
            Iterator<? extends E> it = elements.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @t1.a
        public b<E> d(Iterator<? extends E> elements) {
            while (elements.hasNext()) {
                a(elements.next());
            }
            return this;
        }

        public abstract e3<E> e();
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean addAll(Collection<? extends E> newElements) {
        throw new UnsupportedOperationException();
    }

    public i3<E> asList() {
        return isEmpty() ? i3.of() : i3.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public abstract boolean contains(@gm.a Object object);

    @t1.a
    public int copyIntoArray(Object[] dst, int offset) {
        x7<E> it = iterator();
        while (it.hasNext()) {
            dst[offset] = it.next();
            offset++;
        }
        return offset;
    }

    @gm.a
    public Object[] internalArray() {
        return null;
    }

    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public abstract x7<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean remove(@gm.a Object object) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean removeAll(Collection<?> oldElements) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean retainAll(Collection<?> elementsToKeep) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @b1.d
    public final Object[] toArray() {
        return toArray(f4851a);
    }

    @b1.d
    public Object writeReplace() {
        return new i3.d(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @t1.a
    public final <T> T[] toArray(T[] tArr) {
        tArr.getClass();
        int size = size();
        if (tArr.length < size) {
            Object[] objArrInternalArray = internalArray();
            if (objArrInternalArray != null) {
                return (T[]) o5.a(objArrInternalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) o5.c(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
