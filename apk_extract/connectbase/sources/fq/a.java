package fq;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class a<E> implements Iterable<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a<Object> f6323d = new a<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f6324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a<E> f6325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6326c;

    /* JADX INFO: renamed from: fq.a$a, reason: collision with other inner class name */
    public static class C0151a<E> implements Iterator<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public a<E> f6327a;

        public C0151a(a<E> aVar) {
            this.f6327a = aVar;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6327a.f6326c > 0;
        }

        @Override // java.util.Iterator
        public E next() {
            a<E> aVar = this.f6327a;
            E e10 = aVar.f6324a;
            this.f6327a = aVar.f6325b;
            return e10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public a() {
        this.f6326c = 0;
        this.f6324a = null;
        this.f6325b = null;
    }

    public static <E> a<E> b() {
        return (a<E>) f6323d;
    }

    public final Iterator<E> c(int i10) {
        return new C0151a(i(i10));
    }

    public a<E> e(int i10) {
        return f(get(i10));
    }

    public final a<E> f(Object obj) {
        if (this.f6326c == 0) {
            return this;
        }
        if (this.f6324a.equals(obj)) {
            return this.f6325b;
        }
        a<E> aVarF = this.f6325b.f(obj);
        return aVarF == this.f6325b ? this : new a<>(this.f6324a, aVarF);
    }

    public a<E> g(E e10) {
        return new a<>(e10, this);
    }

    public E get(int i10) {
        if (i10 < 0 || i10 > this.f6326c) {
            throw new IndexOutOfBoundsException();
        }
        try {
            return c(i10).next();
        } catch (NoSuchElementException unused) {
            throw new IndexOutOfBoundsException(h.a.a("Index: ", i10));
        }
    }

    public final a<E> i(int i10) {
        if (i10 < 0 || i10 > this.f6326c) {
            throw new IndexOutOfBoundsException();
        }
        return i10 == 0 ? this : this.f6325b.i(i10 - 1);
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return c(0);
    }

    public int size() {
        return this.f6326c;
    }

    public a(E e10, a<E> aVar) {
        this.f6324a = e10;
        this.f6325b = aVar;
        this.f6326c = aVar.f6326c + 1;
    }
}
