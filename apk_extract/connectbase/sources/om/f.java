package om;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class f<E> extends nm.h<E> implements Set<E>, ln.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final d<E, ?> f12323a;

    public f(@l d<E, ?> dVar) {
        l0.p(dVar, "backing");
        this.f12323a = dVar;
    }

    @Override // nm.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@l Collection<? extends E> collection) {
        l0.p(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12323a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f12323a.containsKey(obj);
    }

    @Override // nm.h
    public int getSize() {
        return this.f12323a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12323a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @l
    public Iterator<E> iterator() {
        return this.f12323a.keysIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f12323a.removeKey$kotlin_stdlib(obj) >= 0;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        this.f12323a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        this.f12323a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
