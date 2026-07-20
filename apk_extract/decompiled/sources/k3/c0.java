package k3;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
public final class c0 extends s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e0 f6392c;

    public c0(e0 e0Var, int i8) {
        int size = e0Var.size();
        if (i8 < 0 || i8 > size) {
            throw new IndexOutOfBoundsException(na.d(i8, size, "index"));
        }
        this.f6390a = size;
        this.f6391b = i8;
        this.f6392c = e0Var;
    }

    public final Object a(int i8) {
        return this.f6392c.get(i8);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f6391b < this.f6390a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f6391b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f6391b;
        this.f6391b = i8 + 1;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f6391b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f6391b - 1;
        this.f6391b = i8;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f6391b - 1;
    }
}
