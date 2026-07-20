package ep;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kn.l0;
import kn.v;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes3.dex */
public class c implements Collection<b>, ln.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final Set<b> f4657a;

    @Override // java.util.Collection
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(b bVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends b> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean c(@l b bVar) {
        l0.p(bVar, "element");
        return this.f4657a.contains(bVar);
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof b) {
            return c((b) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        return this.f4657a.containsAll(collection);
    }

    @l
    public final Set<b> e() {
        return this.f4657a;
    }

    @Override // java.util.Collection
    public boolean equals(@m Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && l0.g(this.f4657a, ((c) obj).f4657a);
    }

    public int f() {
        return this.f4657a.size();
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.f4657a.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f4657a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @l
    public Iterator<b> iterator() {
        return this.f4657a.iterator();
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
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @l
    public String toString() {
        return a.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }
}
