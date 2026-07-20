package i4;

import java.util.Iterator;
import java.util.ListIterator;
import k3.v8;

/* JADX INFO: loaded from: classes.dex */
public final class e0 extends h0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient h0 f5578c;

    public e0(h0 h0Var) {
        this.f5578c = h0Var;
    }

    @Override // i4.h0, i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f5578c.contains(obj);
    }

    @Override // java.util.List
    public Object get(int i8) {
        v8.h(i8, size());
        return this.f5578c.get((size() - 1) - i8);
    }

    @Override // i4.h0, java.util.List
    public int indexOf(Object obj) {
        int iLastIndexOf = this.f5578c.lastIndexOf(obj);
        if (iLastIndexOf >= 0) {
            return (size() - 1) - iLastIndexOf;
        }
        return -1;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return this.f5578c.isPartialView();
    }

    @Override // i4.h0, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @Override // i4.h0, java.util.List
    public int lastIndexOf(Object obj) {
        int iIndexOf = this.f5578c.indexOf(obj);
        if (iIndexOf >= 0) {
            return (size() - 1) - iIndexOf;
        }
        return -1;
    }

    @Override // i4.h0, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return super.listIterator();
    }

    @Override // i4.h0
    public h0 reverse() {
        return this.f5578c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f5578c.size();
    }

    @Override // i4.h0, java.util.List
    public /* bridge */ /* synthetic */ ListIterator listIterator(int i8) {
        return super.listIterator(i8);
    }

    @Override // i4.h0, java.util.List
    public h0 subList(int i8, int i9) {
        v8.k(i8, i9, size());
        return this.f5578c.subList(size() - i9, size() - i8).reverse();
    }
}
