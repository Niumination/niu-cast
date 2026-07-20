package kn;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class h<T> implements Iterator<T>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @os.l
    public final T[] f9307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9308b;

    public h(@os.l T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        this.f9307a = tArr;
    }

    @os.l
    public final T[] a() {
        return this.f9307a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f9308b < this.f9307a.length;
    }

    @Override // java.util.Iterator
    public T next() {
        try {
            T[] tArr = this.f9307a;
            int i10 = this.f9308b;
            this.f9308b = i10 + 1;
            return tArr[i10];
        } catch (ArrayIndexOutOfBoundsException e10) {
            this.f9308b--;
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
