package m3;

import java.util.NoSuchElementException;
import k3.gb;

/* JADX INFO: loaded from: classes.dex */
public final class ta extends b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final va f7868c;

    public ta(va vaVar, int i8) {
        int size = vaVar.size();
        if (i8 < 0 || i8 > size) {
            throw new IndexOutOfBoundsException(gb.c(i8, size, "index"));
        }
        this.f7866a = size;
        this.f7867b = i8;
        this.f7868c = vaVar;
    }

    public final Object a(int i8) {
        return this.f7868c.get(i8);
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f7867b < this.f7866a;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7867b > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f7867b;
        this.f7867b = i8 + 1;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7867b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i8 = this.f7867b - 1;
        this.f7867b = i8;
        return a(i8);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7867b - 1;
    }
}
