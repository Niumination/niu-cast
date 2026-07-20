package i4;

import java.util.NoSuchElementException;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends i5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5559b;

    public a(int i8, int i9) {
        v8.j(i9, i8);
        this.f5558a = i8;
        this.f5559b = i9;
    }

    public abstract Object a(int i8);

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f5559b < this.f5558a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f5559b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f5559b;
        this.f5559b = i8 + 1;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f5559b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f5559b - 1;
        this.f5559b = i8;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f5559b - 1;
    }
}
