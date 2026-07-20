package f1;

import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public abstract class j<K, V> extends t4.a0<K, V> implements NavigableMap<K, V> {

    public final class b extends t4.q<K, V> {
        public b() {
        }

        @Override // f1.t4.q
        public Iterator<Map.Entry<K, V>> m() {
            return j.this.c();
        }

        @Override // f1.t4.q
        public NavigableMap<K, V> q() {
            return j.this;
        }
    }

    public abstract Iterator<Map.Entry<K, V>> c();

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> ceilingEntry(@m5 K key) {
        return tailMap(key, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K ceilingKey(@m5 K k10) {
        return (K) t4.T(ceilingEntry(k10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new b();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) h4.J(a(), null);
    }

    @Override // java.util.SortedMap
    @m5
    public K firstKey() {
        Map.Entry<K, V> entryFirstEntry = firstEntry();
        if (entryFirstEntry != null) {
            return entryFirstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> floorEntry(@m5 K key) {
        return headMap(key, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K floorKey(@m5 K k10) {
        return (K) t4.T(floorEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map
    @gm.a
    public abstract V get(@gm.a Object key);

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(@m5 K toKey) {
        return headMap(toKey, false);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> higherEntry(@m5 K key) {
        return tailMap(key, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K higherKey(@m5 K k10) {
        return (K) t4.T(higherEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) h4.J(c(), null);
    }

    @Override // java.util.SortedMap
    @m5
    public K lastKey() {
        Map.Entry<K, V> entryLastEntry = lastEntry();
        if (entryLastEntry != null) {
            return entryLastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> lowerEntry(@m5 K key) {
        return headMap(key, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    @gm.a
    public K lowerKey(@m5 K k10) {
        return (K) t4.T(lowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new t4.e0((Map) this);
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) h4.U(a());
    }

    @Override // java.util.NavigableMap
    @gm.a
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) h4.U(c());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(@m5 K fromKey, @m5 K toKey) {
        return subMap(fromKey, true, toKey, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(@m5 K fromKey) {
        return tailMap(fromKey, true);
    }
}
