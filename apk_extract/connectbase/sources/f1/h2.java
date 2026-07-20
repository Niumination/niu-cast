package f1;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public abstract class h2<K, V> extends n2<K, V> implements NavigableMap<K, V> {

    public class a extends t4.q<K, V> {

        /* JADX INFO: renamed from: f1.h2$a$a, reason: collision with other inner class name */
        public class C0114a implements Iterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            @gm.a
            public Map.Entry<K, V> f4934a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @gm.a
            public Map.Entry<K, V> f4935b;

            public C0114a() {
                this.f4935b = a.this.q().lastEntry();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> next() {
                Map.Entry<K, V> entry = this.f4935b;
                if (entry == null) {
                    throw new NoSuchElementException();
                }
                this.f4934a = entry;
                this.f4935b = a.this.q().lowerEntry(this.f4935b.getKey());
                return entry;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4935b != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.f4934a == null) {
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
                a.this.q().remove(this.f4934a.getKey());
                this.f4934a = null;
            }
        }

        public a() {
        }

        @Override // f1.t4.q
        public Iterator<Map.Entry<K, V>> m() {
            return new C0114a();
        }

        @Override // f1.t4.q
        public NavigableMap<K, V> q() {
            return h2.this;
        }
    }

    public class b extends t4.e0<K, V> {
        public b(final h2 this$0) {
            super((Map) this$0);
        }
    }

    public K A() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @gm.a
    public Map.Entry<K, V> B(@m5 K key) {
        return headMap(key, false).lastEntry();
    }

    @gm.a
    public K C(@m5 K k10) {
        return (K) t4.T(lowerEntry(k10));
    }

    @gm.a
    public Map.Entry<K, V> D() {
        return (Map.Entry) h4.U(entrySet().iterator());
    }

    @gm.a
    public Map.Entry<K, V> E() {
        return (Map.Entry) h4.U(descendingMap().entrySet().iterator());
    }

    public SortedMap<K, V> F(@m5 K fromKey) {
        return tailMap(fromKey, true);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> ceilingEntry(@m5 K key) {
        return delegate().ceilingEntry(key);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K ceilingKey(@m5 K key) {
        return delegate().ceilingKey(key);
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> floorEntry(@m5 K key) {
        return delegate().floorEntry(key);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K floorKey(@m5 K key) {
        return delegate().floorKey(key);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(@m5 K toKey, boolean inclusive) {
        return delegate().headMap(toKey, inclusive);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> higherEntry(@m5 K key) {
        return delegate().higherEntry(key);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K higherKey(@m5 K key) {
        return delegate().higherKey(key);
    }

    @Override // f1.n2, f1.d2, f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract NavigableMap<K, V> delegate();

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> lowerEntry(@m5 K key) {
        return delegate().lowerEntry(key);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K lowerKey(@m5 K key) {
        return delegate().lowerKey(key);
    }

    @gm.a
    public Map.Entry<K, V> m(@m5 K key) {
        return tailMap(key, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    @gm.a
    public K q(@m5 K k10) {
        return (K) t4.T(ceilingEntry(k10));
    }

    public NavigableSet<K> r() {
        return descendingMap().navigableKeySet();
    }

    @gm.a
    public Map.Entry<K, V> s() {
        return (Map.Entry) g4.v(entrySet(), null);
    }

    @Override // f1.n2
    public SortedMap<K, V> standardSubMap(@m5 K fromKey, @m5 K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(@m5 K fromKey, boolean fromInclusive, @m5 K toKey, boolean toInclusive) {
        return delegate().subMap(fromKey, fromInclusive, toKey, toInclusive);
    }

    public K t() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(@m5 K fromKey, boolean inclusive) {
        return delegate().tailMap(fromKey, inclusive);
    }

    @gm.a
    public Map.Entry<K, V> u(@m5 K key) {
        return headMap(key, true).lastEntry();
    }

    @gm.a
    public K v(@m5 K k10) {
        return (K) t4.T(floorEntry(k10));
    }

    public SortedMap<K, V> w(@m5 K toKey) {
        return headMap(toKey, false);
    }

    @gm.a
    public Map.Entry<K, V> x(@m5 K key) {
        return tailMap(key, false).firstEntry();
    }

    @gm.a
    public K y(@m5 K k10) {
        return (K) t4.T(higherEntry(k10));
    }

    @gm.a
    public Map.Entry<K, V> z() {
        return (Map.Entry) g4.v(descendingMap().entrySet(), null);
    }
}
