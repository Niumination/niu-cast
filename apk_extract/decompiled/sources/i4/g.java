package i4;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import k3.h9;
import k3.j9;

/* JADX INFO: loaded from: classes.dex */
public abstract class g extends AbstractCollection implements c4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Set f5596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Set f5597b;

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        ((d) this).add(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection<Object> collection) {
        collection.getClass();
        if (!(collection instanceof c4)) {
            if (collection.isEmpty()) {
                return false;
            }
            return h9.a(this, collection.iterator());
        }
        c4 c4Var = (c4) collection;
        if (c4Var instanceof d) {
            d dVar = (d) c4Var;
            if (dVar.isEmpty()) {
                return false;
            }
            dVar.addTo(this);
        } else {
            if (c4Var.isEmpty()) {
                return false;
            }
            for (b4 b4Var : c4Var.entrySet()) {
                ((d) this).add(b4Var.getElement(), b4Var.getCount());
            }
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return ((d) this).count(obj) > 0;
    }

    public Set<Object> createElementSet() {
        return new f(this, 0);
    }

    public Set<b4> createEntrySet() {
        return new f(this, 1);
    }

    public abstract int distinctElements();

    public abstract Iterator elementIterator();

    @Override // i4.c4
    public Set<Object> elementSet() {
        Set<Object> set = this.f5596a;
        if (set != null) {
            return set;
        }
        Set<Object> setCreateElementSet = createElementSet();
        this.f5596a = setCreateElementSet;
        return setCreateElementSet;
    }

    public abstract Iterator entryIterator();

    @Override // i4.c4
    public Set<b4> entrySet() {
        Set<b4> set = this.f5597b;
        if (set != null) {
            return set;
        }
        Set<b4> setCreateEntrySet = createEntrySet();
        this.f5597b = setCreateEntrySet;
        return setCreateEntrySet;
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        return j9.a(this, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        return ((d) this).remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        if (collection instanceof c4) {
            collection = ((c4) collection).elementSet();
        }
        return elementSet().removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        collection.getClass();
        if (collection instanceof c4) {
            collection = ((c4) collection).elementSet();
        }
        return elementSet().retainAll(collection);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}
