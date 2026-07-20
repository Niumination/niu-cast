package f1;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class b<E> extends y7<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f4705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4706b;

    public b(int size, int position) {
        c1.h0.d0(position, size);
        this.f4705a = size;
        this.f4706b = position;
    }

    @m5
    public abstract E a(int index);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f4706b < this.f4705a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f4706b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    @m5
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f4706b;
        this.f4706b = i10 + 1;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f4706b;
    }

    @Override // java.util.ListIterator
    @m5
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i10 = this.f4706b - 1;
        this.f4706b = i10;
        return a(i10);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f4706b - 1;
    }

    public b(int size) {
        this(size, 0);
    }
}
