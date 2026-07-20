package om;

import java.util.Collection;
import java.util.Iterator;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class g<V> extends nm.e<V> implements Collection<V>, ln.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final d<?, V> f12324a;

    public g(@l d<?, V> dVar) {
        l0.p(dVar, "backing");
        this.f12324a = dVar;
    }

    @Override // nm.e
    public int a() {
        return this.f12324a.size();
    }

    @Override // nm.e, java.util.AbstractCollection, java.util.Collection
    public boolean add(V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(@l Collection<? extends V> collection) {
        l0.p(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @l
    public final d<?, V> c() {
        return this.f12324a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f12324a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f12324a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f12324a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    @l
    public Iterator<V> iterator() {
        return this.f12324a.valuesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f12324a.removeValue$kotlin_stdlib(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        this.f12324a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        this.f12324a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
