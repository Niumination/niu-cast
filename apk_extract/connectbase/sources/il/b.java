package il;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.v;
import os.l;
import os.m;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class b<Key, Value> implements Set<Key>, ln.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final hl.e<Key, Value> f8241a;

    public static final class a implements Iterator<Key>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Iterator<Map.Entry<Key, Value>> f8242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ b<Key, Value> f8243b;

        public a(b<Key, Value> bVar) {
            this.f8243b = bVar;
            hl.e<Key, Value> eVar = bVar.f8241a;
            eVar.getClass();
            this.f8242a = new hl.e.h(eVar);
            e0.a(this);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8242a.hasNext();
        }

        @Override // java.util.Iterator
        @l
        public Key next() {
            return this.f8242a.next().getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f8242a.remove();
        }
    }

    public b(@l hl.e<Key, Value> eVar) {
        l0.p(eVar, "delegate");
        this.f8241a = eVar;
        e0.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(@l Key key) {
        l0.p(key, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@l Collection<? extends Key> collection) {
        l0.p(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f8241a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f8241a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(@m Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f8241a.containsKey(obj);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Collection<? extends Object> collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f8241a.size() == 0;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @l
    public Iterator<Key> iterator() {
        return new a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(@m Object obj) {
        return (obj == null || this.f8241a.remove(obj) == null) ? false : true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        a aVar = new a(this);
        boolean z10 = false;
        while (aVar.f8242a.hasNext()) {
            if (!collection.contains(aVar.next())) {
                aVar.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f8241a.size();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }
}
