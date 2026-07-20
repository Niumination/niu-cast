package f1;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class h<K, V> implements v4<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Collection<Map.Entry<K, V>> f4920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<K> f4921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient b5<K> f4922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Collection<V> f4923d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Map<K, Collection<V>> f4924e;

    public class a extends y4.f<K, V> {
        public a() {
        }

        @Override // f1.y4.f
        public v4<K, V> a() {
            return h.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return h.this.entryIterator();
        }
    }

    public class b extends h<K, V>.a implements Set<Map.Entry<K, V>> {
        public b(final h this$0) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object obj) {
            return k6.g(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return k6.k(this);
        }
    }

    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            h.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object o10) {
            return h.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return h.this.valueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return h.this.size();
        }
    }

    @Override // f1.v4, f1.j6
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.f4924e;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapCreateAsMap = createAsMap();
        this.f4924e = mapCreateAsMap;
        return mapCreateAsMap;
    }

    @Override // f1.v4
    public boolean containsEntry(@gm.a Object key, @gm.a Object value) {
        Collection<V> collection = asMap().get(key);
        return collection != null && collection.contains(value);
    }

    @Override // f1.v4
    public boolean containsValue(@gm.a Object value) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(value)) {
                return true;
            }
        }
        return false;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract b5<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // f1.v4
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.f4920a;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> collectionCreateEntries = createEntries();
        this.f4920a = collectionCreateEntries;
        return collectionCreateEntries;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // f1.v4, f1.o4
    public boolean equals(@gm.a Object object) {
        return y4.g(this, object);
    }

    @Override // f1.v4
    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // f1.v4
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // f1.v4
    public Set<K> keySet() {
        Set<K> set = this.f4921b;
        if (set != null) {
            return set;
        }
        Set<K> setCreateKeySet = createKeySet();
        this.f4921b = setCreateKeySet;
        return setCreateKeySet;
    }

    @Override // f1.v4
    public b5<K> keys() {
        b5<K> b5Var = this.f4922c;
        if (b5Var != null) {
            return b5Var;
        }
        b5<K> b5VarCreateKeys = createKeys();
        this.f4922c = b5VarCreateKeys;
        return b5VarCreateKeys;
    }

    @Override // f1.v4
    @t1.a
    public boolean put(@m5 K key, @m5 V value) {
        return get(key).add(value);
    }

    @Override // f1.v4
    @t1.a
    public boolean putAll(v4<? extends K, ? extends V> multimap) {
        boolean zPut = false;
        for (Map.Entry<? extends K, ? extends V> entry : multimap.entries()) {
            zPut |= put(entry.getKey(), entry.getValue());
        }
        return zPut;
    }

    @Override // f1.v4
    @t1.a
    public boolean remove(@gm.a Object key, @gm.a Object value) {
        Collection<V> collection = asMap().get(key);
        return collection != null && collection.remove(value);
    }

    @Override // f1.v4, f1.o4
    @t1.a
    public Collection<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
        values.getClass();
        Collection<V> collectionRemoveAll = removeAll(key);
        putAll(key, values);
        return collectionRemoveAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Iterator<V> valueIterator() {
        return new t4.f(entries().iterator());
    }

    @Override // f1.v4
    public Collection<V> values() {
        Collection<V> collection = this.f4923d;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.f4923d = collectionCreateValues;
        return collectionCreateValues;
    }

    @Override // f1.v4
    @t1.a
    public boolean putAll(@m5 K key, Iterable<? extends V> values) {
        values.getClass();
        if (values instanceof Collection) {
            Collection<? extends V> collection = (Collection) values;
            return !collection.isEmpty() && get(key).addAll(collection);
        }
        Iterator<? extends V> it = values.iterator();
        return it.hasNext() && h4.a(get(key), it);
    }
}
