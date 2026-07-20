package om;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes3.dex */
public final class e<K, V> extends a<Map.Entry<K, V>, K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final d<K, V> f12322a;

    public e(@l d<K, V> dVar) {
        l0.p(dVar, "backing");
        this.f12322a = dVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(@l Collection<? extends Map.Entry<K, V>> collection) {
        l0.p(collection, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // om.a
    public boolean c(@l Map.Entry<? extends K, ? extends V> entry) {
        l0.p(entry, "element");
        return this.f12322a.containsEntry$kotlin_stdlib(entry);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f12322a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        return this.f12322a.containsAllEntries$kotlin_stdlib(collection);
    }

    @Override // om.a
    public boolean e(@l Map.Entry entry) {
        l0.p(entry, "element");
        return this.f12322a.removeEntry$kotlin_stdlib(entry);
    }

    @Override // nm.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean add(@l Map.Entry<K, V> entry) {
        l0.p(entry, "element");
        throw new UnsupportedOperationException();
    }

    @l
    public final d<K, V> g() {
        return this.f12322a;
    }

    @Override // nm.h
    public int getSize() {
        return this.f12322a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f12322a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    @l
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f12322a.entriesIterator$kotlin_stdlib();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        this.f12322a.checkIsMutable$kotlin_stdlib();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        this.f12322a.checkIsMutable$kotlin_stdlib();
        return super.retainAll(collection);
    }
}
