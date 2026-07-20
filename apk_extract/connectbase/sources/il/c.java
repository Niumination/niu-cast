package il;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kn.l0;
import kn.v;
import os.l;
import os.m;
import pl.e0;

/* JADX INFO: loaded from: classes2.dex */
public final class c<Key, Value> implements Collection<Value>, ln.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final hl.e<Key, Value> f8244a;

    public static final class a implements Iterator<Value>, ln.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @l
        public final Iterator<Map.Entry<Key, Value>> f8245a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c<Key, Value> f8246b;

        public a(c<Key, Value> cVar) {
            this.f8246b = cVar;
            hl.e<Key, Value> eVar = cVar.f8244a;
            eVar.getClass();
            this.f8245a = new hl.e.h(eVar);
            e0.a(this);
        }

        @l
        public final Iterator<Map.Entry<Key, Value>> a() {
            return this.f8245a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f8245a.hasNext();
        }

        @Override // java.util.Iterator
        @l
        public Value next() {
            return this.f8245a.next().getValue();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f8245a.remove();
        }
    }

    public c(@l hl.e<Key, Value> eVar) {
        l0.p(eVar, "delegate");
        this.f8244a = eVar;
        e0.a(this);
    }

    @Override // java.util.Collection
    public boolean add(@l Value value) {
        l0.p(value, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean addAll(@l Collection<? extends Value> collection) {
        l0.p(collection, "elements");
        throw new UnsupportedOperationException();
    }

    public int c() {
        return this.f8244a.size();
    }

    @Override // java.util.Collection
    public void clear() {
        this.f8244a.clear();
    }

    @Override // java.util.Collection
    public boolean contains(@m Object obj) {
        if (obj == null) {
            return false;
        }
        return this.f8244a.containsValue(obj);
    }

    @Override // java.util.Collection
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

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f8244a.size() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    @l
    public Iterator<Value> iterator() {
        return new a(this);
    }

    @Override // java.util.Collection
    public boolean remove(@m Object obj) {
        boolean z10 = false;
        if (obj == null) {
            return false;
        }
        a aVar = new a(this);
        while (aVar.f8245a.hasNext()) {
            if (!l0.g(aVar.next(), obj)) {
                aVar.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection
    public boolean removeAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        a aVar = new a(this);
        boolean z10 = false;
        while (aVar.f8245a.hasNext()) {
            if (collection.contains(aVar.next())) {
                aVar.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @Override // java.util.Collection
    public boolean retainAll(@l Collection<? extends Object> collection) {
        l0.p(collection, "elements");
        throw new IllegalStateException("Common concurrent map doesn't support this operation yet.");
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f8244a.size();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return v.a(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        l0.p(tArr, dc.d.f3685p);
        return (T[]) v.b(this, tArr);
    }
}
