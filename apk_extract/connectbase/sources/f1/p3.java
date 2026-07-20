package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true, serializable = true)
@x0
public abstract class p3<E> extends q3<E> implements b5<E> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient i3<E> f5180b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient t3<b5.a<E>> f5181c;

    public class a extends x7<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public E f5183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f5184c;

        public a(final p3 this$0, final Iterator val$entryIterator) {
            this.f5184c = val$entryIterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f5182a > 0 || this.f5184c.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (this.f5182a <= 0) {
                b5.a aVar = (b5.a) this.f5184c.next();
                this.f5183b = (E) aVar.getElement();
                this.f5182a = aVar.getCount();
            }
            this.f5182a--;
            E e10 = this.f5183b;
            Objects.requireNonNull(e10);
            return e10;
        }
    }

    public final class c extends d4<b5.a<E>> {

        @b1.d
        private static final long serialVersionUID = 0;

        public c() {
        }

        @b1.c
        @b1.d
        private void readObject(ObjectInputStream stream) throws InvalidObjectException {
            throw new InvalidObjectException("Use EntrySetSerializedForm");
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof b5.a)) {
                return false;
            }
            b5.a aVar = (b5.a) o10;
            return aVar.getCount() > 0 && p3.this.count(aVar.getElement()) == aVar.getCount();
        }

        @Override // f1.t3, java.util.Collection, java.util.Set
        public int hashCode() {
            return p3.this.hashCode();
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return p3.this.isPartialView();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return p3.this.elementSet().size();
        }

        @Override // f1.t3, f1.e3
        @b1.c
        @b1.d
        public Object writeReplace() {
            return new d(p3.this);
        }

        public /* synthetic */ c(p3 p3Var, a aVar) {
            this();
        }

        @Override // f1.d4
        public b5.a<E> get(int index) {
            return p3.this.getEntry(index);
        }
    }

    @b1.c
    @b1.d
    public static class d<E> implements Serializable {
        final p3<E> multiset;

        public d(p3<E> multiset) {
            this.multiset = multiset;
        }

        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    public static <E> p3<E> a(E... elements) {
        return new b(4).b(elements).e();
    }

    private t3<b5.a<E>> b() {
        return isEmpty() ? t3.of() : new c(this, null);
    }

    public static <E> b<E> builder() {
        return new b<>(4);
    }

    public static <E> p3<E> copyFromEntries(Collection<? extends b5.a<? extends E>> entries) {
        b bVar = new b(entries.size());
        for (b5.a<? extends E> aVar : entries) {
            bVar.k(aVar.getElement(), aVar.getCount());
        }
        return bVar.e();
    }

    public static <E> p3<E> copyOf(E[] elements) {
        return a(elements);
    }

    public static <E> p3<E> of() {
        return z5.EMPTY;
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.b5
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final int add(E element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.e3
    public i3<E> asList() {
        i3<E> i3Var = this.f5180b;
        if (i3Var != null) {
            return i3Var;
        }
        i3<E> i3VarAsList = super.asList();
        this.f5180b = i3VarAsList;
        return i3VarAsList;
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        return count(object) > 0;
    }

    @Override // f1.e3
    @b1.c
    public int copyIntoArray(Object[] dst, int offset) {
        x7<b5.a<E>> it = entrySet().iterator();
        while (it.hasNext()) {
            b5.a<E> next = it.next();
            Arrays.fill(dst, offset, next.getCount() + offset, next.getElement());
            offset += next.getCount();
        }
        return offset;
    }

    public abstract t3<E> elementSet();

    @Override // java.util.Collection, f1.b5
    public boolean equals(@gm.a Object object) {
        return c5.i(this, object);
    }

    public abstract b5.a<E> getEntry(int index);

    @Override // java.util.Collection, f1.b5
    public int hashCode() {
        return k6.k(entrySet());
    }

    @Override // f1.b5
    @t1.a
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final int remove(@gm.a Object element, int occurrences) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.b5
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final int setCount(E element, int count) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, f1.b5
    public String toString() {
        return entrySet().toString();
    }

    @Override // f1.e3
    @b1.c
    @b1.d
    public abstract Object writeReplace();

    public static <E> p3<E> copyOf(Iterable<? extends E> elements) {
        if (elements instanceof p3) {
            p3<E> p3Var = (p3) elements;
            if (!p3Var.isPartialView()) {
                return p3Var;
            }
        }
        b bVar = new b(c5.l(elements));
        bVar.c(elements);
        return bVar.e();
    }

    public static <E> p3<E> of(E element) {
        return a(element);
    }

    @Override // f1.b5
    public t3<b5.a<E>> entrySet() {
        t3<b5.a<E>> t3Var = this.f5181c;
        if (t3Var != null) {
            return t3Var;
        }
        t3<b5.a<E>> t3VarB = b();
        this.f5181c = t3VarB;
        return t3VarB;
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<E> iterator() {
        return new a(this, entrySet().iterator());
    }

    @Override // f1.b5
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final boolean setCount(E element, int oldCount, int newCount) {
        throw new UnsupportedOperationException();
    }

    public static <E> p3<E> of(E e10, E e11) {
        return a(e10, e11);
    }

    public static <E> p3<E> of(E e10, E e11, E e12) {
        return a(e10, e11, e12);
    }

    public static class b<E> extends e3.b<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public j5<E> f5185b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5186c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5187d;

        public b(int estimatedDistinct) {
            this.f5186c = false;
            this.f5187d = false;
            this.f5185b = new j5<>(estimatedDistinct);
        }

        @gm.a
        public static <T> j5<T> n(Iterable<T> iterable) {
            if (iterable instanceof z5) {
                return ((z5) iterable).contents;
            }
            if (iterable instanceof f) {
                return ((f) iterable).backingMap;
            }
            return null;
        }

        @Override // f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public b<E> a(E element) {
            return k(element, 1);
        }

        @Override // f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public b<E> b(E... elements) {
            super.b(elements);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public b<E> c(Iterable<? extends E> elements) {
            Objects.requireNonNull(this.f5185b);
            if (elements instanceof b5) {
                b5 b5Var = (b5) elements;
                j5 j5VarN = n(b5Var);
                if (j5VarN != null) {
                    j5<E> j5Var = this.f5185b;
                    j5Var.e(Math.max(j5Var.D(), j5VarN.D()));
                    for (int iF = j5VarN.f(); iF >= 0; iF = j5VarN.t(iF)) {
                        k(j5VarN.j(iF), j5VarN.l(iF));
                    }
                } else {
                    Set<b5.a<E>> setEntrySet = b5Var.entrySet();
                    j5<E> j5Var2 = this.f5185b;
                    j5Var2.e(Math.max(j5Var2.D(), setEntrySet.size()));
                    for (b5.a<E> aVar : b5Var.entrySet()) {
                        k(aVar.getElement(), aVar.getCount());
                    }
                }
            } else {
                super.c(elements);
            }
            return this;
        }

        @Override // f1.e3.b
        @t1.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b<E> d(Iterator<? extends E> elements) {
            super.d(elements);
            return this;
        }

        @t1.a
        public b<E> k(E element, int occurrences) {
            Objects.requireNonNull(this.f5185b);
            if (occurrences == 0) {
                return this;
            }
            if (this.f5186c) {
                this.f5185b = new j5<>(this.f5185b);
                this.f5187d = false;
            }
            this.f5186c = false;
            element.getClass();
            j5<E> j5Var = this.f5185b;
            j5Var.v(element, j5Var.g(element) + occurrences);
            return this;
        }

        @Override // f1.e3.b
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public p3<E> e() {
            Objects.requireNonNull(this.f5185b);
            if (this.f5185b.D() == 0) {
                return p3.of();
            }
            if (this.f5187d) {
                this.f5185b = new j5<>(this.f5185b);
                this.f5187d = false;
            }
            this.f5186c = true;
            return new z5(this.f5185b);
        }

        @t1.a
        public b<E> m(E element, int count) {
            Objects.requireNonNull(this.f5185b);
            if (count == 0 && !this.f5187d) {
                this.f5185b = new k5(this.f5185b);
                this.f5187d = true;
            } else if (this.f5186c) {
                this.f5185b = new j5<>(this.f5185b);
                this.f5187d = false;
            }
            this.f5186c = false;
            element.getClass();
            if (count == 0) {
                this.f5185b.w(element);
            } else {
                this.f5185b.v(element, count);
            }
            return this;
        }

        public b(boolean forSubtype) {
            this.f5186c = false;
            this.f5187d = false;
            this.f5185b = null;
        }

        public b() {
            this(4);
        }
    }

    public static <E> p3<E> of(E e10, E e11, E e12, E e13) {
        return a(e10, e11, e12, e13);
    }

    public static <E> p3<E> of(E e10, E e11, E e12, E e13, E e14) {
        return a(e10, e11, e12, e13, e14);
    }

    public static <E> p3<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E... others) {
        return new b(4).k(e10, 1).a(e11).a(e12).a(e13).a(e14).a(e15).b(others).e();
    }

    public static <E> p3<E> copyOf(Iterator<? extends E> elements) {
        return new b(4).d(elements).e();
    }
}
