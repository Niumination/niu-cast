package nm;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes3.dex */
public class k1<T> extends c<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final List<T> f11648b;

    public static final class a implements ListIterator<T>, ln.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @os.l
        public final ListIterator<T> f11649a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k1<T> f11650b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(k1<? extends T> k1Var, int i10) {
            this.f11650b = k1Var;
            this.f11649a = k1Var.f11648b.listIterator(e0.e1(k1Var, i10));
        }

        @os.l
        public final ListIterator<T> a() {
            return this.f11649a;
        }

        @Override // java.util.ListIterator
        public void add(T t10) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f11649a.hasPrevious();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f11649a.hasNext();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public T next() {
            return this.f11649a.previous();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            k1<T> k1Var = this.f11650b;
            return y.J(k1Var) - this.f11649a.previousIndex();
        }

        @Override // java.util.ListIterator
        public T previous() {
            return this.f11649a.next();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            k1<T> k1Var = this.f11650b;
            return y.J(k1Var) - this.f11649a.nextIndex();
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

    /* JADX WARN: Multi-variable type inference failed */
    public k1(@os.l List<? extends T> list) {
        kn.l0.p(list, "delegate");
        this.f11648b = list;
    }

    @Override // nm.c, java.util.List
    public T get(int i10) {
        return this.f11648b.get(e0.c1(this, i10));
    }

    @Override // nm.c, nm.a
    public int getSize() {
        return this.f11648b.size();
    }

    @Override // nm.c, nm.a, java.util.Collection, java.lang.Iterable
    @os.l
    public Iterator<T> iterator() {
        return listIterator(0);
    }

    @Override // nm.c, java.util.List
    @os.l
    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    @Override // nm.c, java.util.List
    @os.l
    public ListIterator<T> listIterator(int i10) {
        return new a(this, i10);
    }
}
