package com.google.protobuf.kotlin;

import dc.d;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kn.l0;
import kn.v;
import ln.a;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public class UnmodifiableCollection<E> implements Collection<E>, a {

    @l
    private final Collection<E> delegate;

    /* JADX WARN: Multi-variable type inference failed */
    public UnmodifiableCollection(@l Collection<? extends E> collection) {
        l0.p(collection, "delegate");
        this.delegate = collection;
    }

    @Override // java.util.Collection
    public boolean add(E e10) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(E e10) {
        return this.delegate.contains(e10);
    }

    @Override // java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        return this.delegate.containsAll(collection);
    }

    public int getSize() {
        return this.delegate.size();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @l
    public Iterator<E> iterator() {
        return new UnmodifiableIterator(this.delegate.iterator());
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super E> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, d.f3685p);
        return (T[]) v.b(this, tArr);
    }
}
