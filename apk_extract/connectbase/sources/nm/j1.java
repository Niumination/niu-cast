package nm;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public final class j1<T> extends f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final List<T> f11639a;

    public static final class a implements ListIterator<T>, ln.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ListIterator<T> f11640a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ j1<T> f11641b;

        public a(j1<T> j1Var, int i10) {
            this.f11641b = j1Var;
            this.f11640a = j1Var.f11639a.listIterator(e0.e1(j1Var, i10));
        }

        @os.l
        public final ListIterator<T> a() {
            return this.f11640a;
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            this.f11640a.add(t10);
            this.f11640a.previous();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f11640a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f11640a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f11640a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            j1<T> j1Var = this.f11641b;
            return y.J(j1Var) - this.f11640a.previousIndex();
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f11640a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            j1<T> j1Var = this.f11641b;
            return y.J(j1Var) - this.f11640a.nextIndex();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f11640a.remove();
        }

        @Override // java.util.ListIterator
        public void set(T t10) {
            this.f11640a.set(t10);
        }
    }

    public j1(@os.l List<T> list) {
        kn.l0.p(list, "delegate");
        this.f11639a = list;
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        this.f11639a.add(e0.e1(this, i10), t10);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        this.f11639a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        return this.f11639a.get(e0.c1(this, i10));
    }

    @Override // nm.f
    public int getSize() {
        return this.f11639a.size();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    @os.l
    public Iterator<T> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    @os.l
    public ListIterator<T> listIterator() {
        return new a(this, 0);
    }

    @Override // nm.f
    public T removeAt(int i10) {
        return this.f11639a.remove(e0.c1(this, i10));
    }

    @Override // nm.f, java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        return this.f11639a.set(e0.c1(this, i10), t10);
    }

    @Override // java.util.AbstractList, java.util.List
    @os.l
    public ListIterator<T> listIterator(int i10) {
        return new a(this, i10);
    }
}
