package k3;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class m extends AbstractCollection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f6530a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Collection f6531b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f6532c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Collection f6533d;
    public final /* synthetic */ p e;

    public m(p pVar, Object obj, List list, m mVar) {
        this.e = pVar;
        this.f6530a = obj;
        this.f6531b = list;
        this.f6532c = mVar;
        this.f6533d = mVar == null ? null : mVar.f6531b;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        f();
        boolean zIsEmpty = this.f6531b.isEmpty();
        boolean zAdd = this.f6531b.add(obj);
        if (zAdd) {
            this.e.e++;
            if (zIsEmpty) {
                e();
                return true;
            }
        }
        return zAdd;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zAddAll = this.f6531b.addAll(collection);
        if (zAddAll) {
            int size2 = this.f6531b.size();
            p pVar = this.e;
            pVar.e = (size2 - size) + pVar.e;
            if (size == 0) {
                e();
                return true;
            }
        }
        return zAddAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int size = size();
        if (size == 0) {
            return;
        }
        this.f6531b.clear();
        this.e.e -= size;
        g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        f();
        return this.f6531b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        f();
        return this.f6531b.containsAll(collection);
    }

    public final void e() {
        m mVar = this.f6532c;
        if (mVar != null) {
            mVar.e();
        } else {
            this.e.f6568d.put(this.f6530a, this.f6531b);
        }
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        f();
        return this.f6531b.equals(obj);
    }

    public final void f() {
        Collection collection;
        m mVar = this.f6532c;
        if (mVar != null) {
            mVar.f();
            if (mVar.f6531b != this.f6533d) {
                throw new ConcurrentModificationException();
            }
        } else {
            if (!this.f6531b.isEmpty() || (collection = (Collection) this.e.f6568d.get(this.f6530a)) == null) {
                return;
            }
            this.f6531b = collection;
        }
    }

    public final void g() {
        m mVar = this.f6532c;
        if (mVar != null) {
            mVar.g();
        } else if (this.f6531b.isEmpty()) {
            this.e.f6568d.remove(this.f6530a);
        }
    }

    @Override // java.util.Collection
    public final int hashCode() {
        f();
        return this.f6531b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        f();
        return new i(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        f();
        boolean zRemove = this.f6531b.remove(obj);
        if (zRemove) {
            this.e.e--;
            g();
        }
        return zRemove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean zRemoveAll = this.f6531b.removeAll(collection);
        if (zRemoveAll) {
            int size2 = this.f6531b.size();
            p pVar = this.e;
            pVar.e = (size2 - size) + pVar.e;
            g();
        }
        return zRemoveAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        collection.getClass();
        int size = size();
        boolean zRetainAll = this.f6531b.retainAll(collection);
        if (zRetainAll) {
            int size2 = this.f6531b.size();
            p pVar = this.e;
            pVar.e = (size2 - size) + pVar.e;
            g();
        }
        return zRetainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        f();
        return this.f6531b.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        f();
        return this.f6531b.toString();
    }
}
