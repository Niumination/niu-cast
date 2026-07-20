package nm;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes3.dex */
@kn.r1({"SMAP\nAbstractList.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,170:1\n350#2,7:171\n378#2,7:178\n*S KotlinDebug\n*F\n+ 1 AbstractList.kt\nkotlin/collections/AbstractList\n*L\n27#1:171,7\n29#1:178,7\n*E\n"})
@lm.f1(version = "1.1")
public abstract class c<E> extends nm.a<E> implements List<E>, ln.a {

    @os.l
    public static final a Companion = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f11612a = 2147483639;

    public static final class a {
        public a() {
        }

        public final void a(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                StringBuilder sbA = i0.a.a("startIndex: ", i10, ", endIndex: ", i11, ", size: ");
                sbA.append(i12);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(e0.a.a("startIndex: ", i10, " > endIndex: ", i11));
            }
        }

        public final void b(int i10, int i11) {
            if (i10 < 0 || i10 >= i11) {
                throw new IndexOutOfBoundsException(e0.a.a("index: ", i10, ", size: ", i11));
            }
        }

        public final void c(int i10, int i11) {
            if (i10 < 0 || i10 > i11) {
                throw new IndexOutOfBoundsException(e0.a.a("index: ", i10, ", size: ", i11));
            }
        }

        public final void d(int i10, int i11, int i12) {
            if (i10 < 0 || i11 > i12) {
                StringBuilder sbA = i0.a.a("fromIndex: ", i10, ", toIndex: ", i11, ", size: ");
                sbA.append(i12);
                throw new IndexOutOfBoundsException(sbA.toString());
            }
            if (i10 > i11) {
                throw new IllegalArgumentException(e0.a.a("fromIndex: ", i10, " > toIndex: ", i11));
            }
        }

        public final int e(int i10, int i11) {
            int i12 = i10 + (i10 >> 1);
            if (i12 - i11 < 0) {
                i12 = i11;
            }
            if (i12 - 2147483639 > 0) {
                return i11 > 2147483639 ? Integer.MAX_VALUE : 2147483639;
            }
            return i12;
        }

        public final boolean f(@os.l Collection<?> collection, @os.l Collection<?> collection2) {
            kn.l0.p(collection, "c");
            kn.l0.p(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator<?> it = collection2.iterator();
            Iterator<?> it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!kn.l0.g(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int g(@os.l Collection<?> collection) {
            kn.l0.p(collection, "c");
            Iterator<?> it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public a(kn.w wVar) {
        }
    }

    public class b implements Iterator<E>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f11613a;

        public b() {
        }

        public final int a() {
            return this.f11613a;
        }

        public final void c(int i10) {
            this.f11613a = i10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11613a < c.this.size();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            c<E> cVar = c.this;
            int i10 = this.f11613a;
            this.f11613a = i10 + 1;
            return cVar.get(i10);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX INFO: renamed from: nm.c$c, reason: collision with other inner class name */
    public class C0298c extends c<E>.b implements ListIterator<E>, ln.a {
        public C0298c(int i10) {
            super();
            c.Companion.c(i10, c.this.size());
            this.f11613a = i10;
        }

        @Override // java.util.ListIterator
        public void add(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f11613a > 0;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f11613a;
        }

        @Override // java.util.ListIterator
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            c<E> cVar = c.this;
            int i10 = this.f11613a - 1;
            this.f11613a = i10;
            return cVar.get(i10);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f11613a - 1;
        }

        @Override // java.util.ListIterator
        public void set(E e10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d<E> extends c<E> implements RandomAccess {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @os.l
        public final c<E> f11616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f11617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f11618d;

        /* JADX WARN: Multi-variable type inference failed */
        public d(@os.l c<? extends E> cVar, int i10, int i11) {
            kn.l0.p(cVar, "list");
            this.f11616b = cVar;
            this.f11617c = i10;
            c.Companion.d(i10, i11, cVar.size());
            this.f11618d = i11 - i10;
        }

        @Override // nm.c, java.util.List
        public E get(int i10) {
            c.Companion.b(i10, this.f11618d);
            return this.f11616b.get(this.f11617c + i10);
        }

        @Override // nm.c, nm.a
        public int getSize() {
            return this.f11618d;
        }
    }

    @Override // java.util.List
    public void add(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@os.m Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return Companion.f(this, (Collection) obj);
        }
        return false;
    }

    public abstract E get(int i10);

    @Override // nm.a
    public abstract int getSize();

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return Companion.g(this);
    }

    public int indexOf(E e10) {
        Iterator<E> it = iterator();
        int i10 = 0;
        while (it.hasNext()) {
            if (kn.l0.g(it.next(), e10)) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    @Override // nm.a, java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<E> iterator() {
        return new b();
    }

    public int lastIndexOf(E e10) {
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (kn.l0.g(listIterator.previous(), e10)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // java.util.List
    @os.l
    public ListIterator<E> listIterator() {
        return new C0298c(0);
    }

    @Override // java.util.List
    public E remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public E set(int i10, E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @os.l
    public List<E> subList(int i10, int i11) {
        return new d(this, i10, i11);
    }

    @Override // java.util.List
    @os.l
    public ListIterator<E> listIterator(int i10) {
        return new C0298c(i10);
    }
}
