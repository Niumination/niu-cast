package j3;

import java.util.NoSuchElementException;
import k3.w9;

/* JADX INFO: loaded from: classes.dex */
public final class b extends p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f6061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f6062c;

    public b(d dVar, int i8) {
        int size = dVar.size();
        w9.b(i8, size);
        this.f6060a = size;
        this.f6061b = i8;
        this.f6062c = dVar;
    }

    public final Object a(int i8) {
        return this.f6062c.get(i8);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f6061b < this.f6060a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f6061b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f6061b;
        this.f6061b = i8 + 1;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f6061b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f6061b - 1;
        this.f6061b = i8;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f6061b - 1;
    }
}
