package il;

import fl.t0;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.UnaryOperator;
import kn.l0;
import kn.v;
import os.l;
import os.m;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
@t0
public final class i<T> implements List<T>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public /* synthetic */ AtomicReferenceArray f8280b;

    public static final class a implements ListIterator<T>, ln.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f8281c = AtomicIntegerFieldUpdater.newUpdater(a.class, "currentIndex");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f8282a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i<T> f8283b;

        @l
        private volatile /* synthetic */ int currentIndex;

        public a(int i10, i<T> iVar) {
            this.f8282a = i10;
            this.f8283b = iVar;
            this.currentIndex = i10;
            e0.a(this);
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.currentIndex < this.f8283b.f8279a;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.currentIndex > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        @m
        public T next() {
            if (!hasNext()) {
                throw new IllegalStateException("Check failed.");
            }
            return (T) this.f8283b.f8280b.get(f8281c.getAndIncrement(this));
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            if (hasNext()) {
                return this.currentIndex + 1;
            }
            throw new IllegalStateException("Check failed.");
        }

        @Override // java.util.ListIterator
        @m
        public T previous() {
            if (!hasPrevious()) {
                throw new IllegalStateException("Check failed.");
            }
            return (T) this.f8283b.f8280b.get(f8281c.getAndDecrement(this));
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            if (hasPrevious()) {
                return this.currentIndex - 1;
            }
            throw new IllegalStateException("Check failed.");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public void set(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public i(int i10) {
        this.f8279a = i10;
        this.f8280b = new AtomicReferenceArray(i10);
        e0.a(this);
    }

    public int a() {
        return this.f8279a;
    }

    @Override // java.util.List
    public void add(int i10, T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i10, Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final void c(int i10, @m T t10) {
        this.f8280b.set(i10, t10);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(@m Object obj) {
        int i10 = this.f8279a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i11 + 1;
            if (l0.g(this.f8280b.get(i11), obj)) {
                return true;
            }
            i11 = i12;
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    @m
    public T get(int i10) {
        return (T) this.f8280b.get(i10);
    }

    @Override // java.util.List
    public int indexOf(@m Object obj) {
        int i10 = this.f8279a;
        int i11 = 0;
        while (i11 < i10) {
            int i12 = i11 + 1;
            if (l0.g(this.f8280b.get(i11), obj)) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f8279a == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    @l
    public Iterator<T> iterator() {
        return new a(0, this);
    }

    @Override // java.util.List
    public int lastIndexOf(@m Object obj) {
        return nm.e0.a1(this).indexOf(obj);
    }

    @Override // java.util.List
    @l
    public ListIterator<T> listIterator() {
        return new a(0, this);
    }

    @Override // java.util.List
    public T remove(int i10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<T> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public T set(int i10, T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return this.f8279a;
    }

    @Override // java.util.List
    public void sort(Comparator<? super T> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.List
    @l
    public List<T> subList(int i10, int i11) {
        i iVar = new i(i11 - i10);
        for (int i12 = i10; i12 < i11; i12++) {
            iVar.c(i12 - i10, this.f8280b.get(i12));
        }
        return iVar;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T t10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    @l
    public ListIterator<T> listIterator(int i10) {
        return new a(i10, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }
}
