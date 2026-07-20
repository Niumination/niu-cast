package il;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kn.l0;
import kn.u1;
import kn.v;
import os.l;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class g<Key, Value> implements Set<Map.Entry<Key, Value>>, ln.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final hl.e<Key, Value> f8269a;

    public static final class a implements Iterator<Map.Entry<Key, Value>>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Iterator<Map.Entry<Key, Value>> f8270a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g<Key, Value> f8271b;

        public a(g<Key, Value> gVar) {
            this.f8271b = gVar;
            hl.e<Key, Value> eVar = gVar.f8269a;
            eVar.getClass();
            this.f8270a = new hl.e.h(eVar);
        }

        @Override // java.util.Iterator
        @l
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<Key, Value> next() {
            return this.f8270a.next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8270a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f8270a.remove();
        }
    }

    public g(@l hl.e<Key, Value> eVar) {
        l0.p(eVar, "delegate");
        this.f8269a = eVar;
        e0.a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(@l Collection<? extends Map.Entry<Key, Value>> collection) {
        l0.p(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (add((Map.Entry) it.next()) || z10) {
                    z10 = true;
                }
            }
            return z10;
        }
    }

    @Override // java.util.Set, java.util.Collection
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean add(@l Map.Entry<Key, Value> entry) {
        l0.p(entry, "element");
        return !l0.g(this.f8269a.put(entry.getKey(), entry.getValue()), entry.getValue());
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        this.f8269a.clear();
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (u1.I(obj)) {
            return e((Map.Entry) obj);
        }
        return false;
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
            if (!contains((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean e(@l Map.Entry<Key, Value> entry) {
        l0.p(entry, "element");
        return l0.g(this.f8269a.get(entry.getKey()), entry.getValue());
    }

    public int f() {
        return this.f8269a.size();
    }

    public boolean g(@l Map.Entry<Key, Value> entry) {
        l0.p(entry, "element");
        return this.f8269a.remove(entry.getKey()) != null;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        return this.f8269a.isEmpty();
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    @l
    public Iterator<Map.Entry<Key, Value>> iterator() {
        return new a(this);
    }

    @Override // java.util.Set, java.util.Collection
    public final /* bridge */ boolean remove(Object obj) {
        if (u1.I(obj)) {
            return g((Map.Entry) obj);
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        Iterator<T> it = collection.iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                if (remove((Map.Entry) it.next()) || z10) {
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
        while (aVar.f8270a.hasNext()) {
            if (!collection.contains(aVar.next())) {
                aVar.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        return this.f8269a.size();
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
