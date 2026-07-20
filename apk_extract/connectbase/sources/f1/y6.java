package f1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class y6 {

    public static class b<K, V> extends k<K, Collection<V>> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;

        @gm.a
        transient Collection<Collection<V>> asMapValues;

        public b(Map<K, Collection<V>> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.y6.k, java.util.Map
        public boolean containsValue(@gm.a Object o10) {
            return values().contains(o10);
        }

        @Override // f1.y6.k, java.util.Map
        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.mutex) {
                try {
                    if (this.asMapEntrySet == null) {
                        this.asMapEntrySet = new c(delegate().entrySet(), this.mutex);
                    }
                    set = this.asMapEntrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // f1.y6.k, java.util.Map
        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.mutex) {
                try {
                    if (this.asMapValues == null) {
                        this.asMapValues = new d(delegate().values(), this.mutex);
                    }
                    collection = this.asMapValues;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // f1.y6.k, java.util.Map
        @gm.a
        public Collection<V> get(@gm.a Object key) {
            Collection<V> collectionA;
            synchronized (this.mutex) {
                Collection collection = (Collection) super.get(key);
                collectionA = collection == null ? null : y6.A(collection, this.mutex);
            }
            return collectionA;
        }
    }

    public static class d<V> extends f<Collection<V>> {
        private static final long serialVersionUID = 0;

        public class a extends o7<Collection<V>, Collection<V>> {
            public a(Iterator backingIterator) {
                super(backingIterator);
            }

            @Override // f1.o7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Collection<V> a(Collection<V> from) {
                return y6.A(from, d.this.mutex);
            }
        }

        public d(Collection<Collection<V>> delegate, @gm.a Object mutex) {
            super(delegate, mutex, null);
        }

        @Override // f1.y6.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Collection<V>> iterator() {
            return new a(super.iterator());
        }
    }

    @b1.e
    public static class e<K, V> extends k<K, V> implements f1.w<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public transient Set<V> f5636a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @RetainedWith
        @gm.a
        public transient f1.w<V, K> f5637b;

        @Override // f1.w
        @gm.a
        public V forcePut(@m5 K key, @m5 V value) {
            V vForcePut;
            synchronized (this.mutex) {
                vForcePut = delegate().forcePut(key, value);
            }
            return vForcePut;
        }

        @Override // f1.w
        public f1.w<V, K> inverse() {
            f1.w<V, K> wVar;
            synchronized (this.mutex) {
                try {
                    if (this.f5637b == null) {
                        this.f5637b = new e(delegate().inverse(), this.mutex, this);
                    }
                    wVar = this.f5637b;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return wVar;
        }

        public e(f1.w<K, V> delegate, @gm.a Object mutex, @gm.a f1.w<V, K> inverse) {
            super(delegate, mutex);
            this.f5637b = inverse;
        }

        @Override // f1.y6.k, java.util.Map
        public Set<V> values() {
            Set<V> set;
            synchronized (this.mutex) {
                try {
                    if (this.f5636a == null) {
                        this.f5636a = new s(delegate().values(), this.mutex);
                    }
                    set = this.f5636a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // f1.y6.k, f1.y6.p
        public f1.w<K, V> delegate() {
            return (f1.w) super.delegate();
        }
    }

    @b1.e
    public static class f<E> extends p implements Collection<E> {
        private static final long serialVersionUID = 0;

        public f(Collection<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.Collection
        public boolean add(E e10) {
            boolean zAdd;
            synchronized (this.mutex) {
                zAdd = delegate().add(e10);
            }
            return zAdd;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends E> c10) {
            boolean zAddAll;
            synchronized (this.mutex) {
                zAddAll = delegate().addAll(c10);
            }
            return zAddAll;
        }

        @Override // java.util.Collection
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        public boolean contains(@gm.a Object o10) {
            boolean zContains;
            synchronized (this.mutex) {
                zContains = delegate().contains(o10);
            }
            return zContains;
        }

        public boolean containsAll(Collection<?> c10) {
            boolean zContainsAll;
            synchronized (this.mutex) {
                zContainsAll = delegate().containsAll(c10);
            }
            return zContainsAll;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        public Iterator<E> iterator() {
            return delegate().iterator();
        }

        public boolean remove(@gm.a Object o10) {
            boolean zRemove;
            synchronized (this.mutex) {
                zRemove = delegate().remove(o10);
            }
            return zRemove;
        }

        public boolean removeAll(Collection<?> c10) {
            boolean zRemoveAll;
            synchronized (this.mutex) {
                zRemoveAll = delegate().removeAll(c10);
            }
            return zRemoveAll;
        }

        public boolean retainAll(Collection<?> c10) {
            boolean zRetainAll;
            synchronized (this.mutex) {
                zRetainAll = delegate().retainAll(c10);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.mutex) {
                array = delegate().toArray();
            }
            return array;
        }

        public f(Collection collection, Object obj, a aVar) {
            super(collection, obj);
        }

        @Override // f1.y6.p
        public Collection<E> delegate() {
            return (Collection) super.delegate();
        }

        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) delegate().toArray(tArr);
            }
            return tArr2;
        }
    }

    @b1.c
    public static class h<K, V> extends p implements Map.Entry<K, V> {
        private static final long serialVersionUID = 0;

        public h(Map.Entry<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.Map.Entry
        public boolean equals(@gm.a Object obj) {
            boolean zEquals;
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            K key;
            synchronized (this.mutex) {
                key = delegate().getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            V value;
            synchronized (this.mutex) {
                value = delegate().getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map.Entry
        public V setValue(V value) {
            V value2;
            synchronized (this.mutex) {
                value2 = delegate().setValue(value);
            }
            return value2;
        }

        @Override // f1.y6.p
        public Map.Entry<K, V> delegate() {
            return (Map.Entry) super.delegate();
        }
    }

    public static class i<E> extends f<E> implements List<E> {
        private static final long serialVersionUID = 0;

        public i(List<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex, null);
        }

        @Override // java.util.List
        public void add(int index, E element) {
            synchronized (this.mutex) {
                delegate().add(index, element);
            }
        }

        @Override // java.util.List
        public boolean addAll(int index, Collection<? extends E> c10) {
            boolean zAddAll;
            synchronized (this.mutex) {
                zAddAll = delegate().addAll(index, c10);
            }
            return zAddAll;
        }

        @Override // java.util.Collection, java.util.List
        public boolean equals(@gm.a Object o10) {
            boolean zEquals;
            if (o10 == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(o10);
            }
            return zEquals;
        }

        @Override // java.util.List
        public E get(int index) {
            E e10;
            synchronized (this.mutex) {
                e10 = delegate().get(index);
            }
            return e10;
        }

        @Override // java.util.Collection, java.util.List
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.List
        public int indexOf(@gm.a Object o10) {
            int iIndexOf;
            synchronized (this.mutex) {
                iIndexOf = delegate().indexOf(o10);
            }
            return iIndexOf;
        }

        @Override // java.util.List
        public int lastIndexOf(@gm.a Object o10) {
            int iLastIndexOf;
            synchronized (this.mutex) {
                iLastIndexOf = delegate().lastIndexOf(o10);
            }
            return iLastIndexOf;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator() {
            return delegate().listIterator();
        }

        @Override // java.util.List
        public E remove(int index) {
            E eRemove;
            synchronized (this.mutex) {
                eRemove = delegate().remove(index);
            }
            return eRemove;
        }

        @Override // java.util.List
        public E set(int index, E element) {
            E e10;
            synchronized (this.mutex) {
                e10 = delegate().set(index, element);
            }
            return e10;
        }

        @Override // java.util.List
        public List<E> subList(int fromIndex, int toIndex) {
            List<E> listJ;
            synchronized (this.mutex) {
                listJ = y6.j(delegate().subList(fromIndex, toIndex), this.mutex);
            }
            return listJ;
        }

        @Override // java.util.List
        public ListIterator<E> listIterator(int index) {
            return delegate().listIterator(index);
        }

        @Override // f1.y6.f, f1.y6.p
        public List<E> delegate() {
            return (List) super.delegate();
        }
    }

    public static class j<K, V> extends l<K, V> implements o4<K, V> {
        private static final long serialVersionUID = 0;

        public j(o4<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.y6.l, f1.v4, f1.o4
        public List<V> get(K key) {
            List<V> listJ;
            synchronized (this.mutex) {
                listJ = y6.j(delegate().get((Object) key), this.mutex);
            }
            return listJ;
        }

        @Override // f1.y6.l, f1.v4, f1.o4
        public List<V> removeAll(@gm.a Object key) {
            List<V> listRemoveAll;
            synchronized (this.mutex) {
                listRemoveAll = delegate().removeAll(key);
            }
            return listRemoveAll;
        }

        @Override // f1.y6.l, f1.v4, f1.o4
        public List<V> replaceValues(K key, Iterable<? extends V> values) {
            List<V> listReplaceValues;
            synchronized (this.mutex) {
                listReplaceValues = delegate().replaceValues((Object) key, (Iterable) values);
            }
            return listReplaceValues;
        }

        @Override // f1.y6.l, f1.y6.p
        public o4<K, V> delegate() {
            return (o4) super.delegate();
        }
    }

    public static class k<K, V> extends p implements Map<K, V> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient Set<Map.Entry<K, V>> entrySet;

        @gm.a
        transient Set<K> keySet;

        @gm.a
        transient Collection<V> values;

        public k(Map<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.Map
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // java.util.Map
        public boolean containsKey(@gm.a Object key) {
            boolean zContainsKey;
            synchronized (this.mutex) {
                zContainsKey = delegate().containsKey(key);
            }
            return zContainsKey;
        }

        public boolean containsValue(@gm.a Object value) {
            boolean zContainsValue;
            synchronized (this.mutex) {
                zContainsValue = delegate().containsValue(value);
            }
            return zContainsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = new s(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public boolean equals(@gm.a Object o10) {
            boolean zEquals;
            if (o10 == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(o10);
            }
            return zEquals;
        }

        @gm.a
        public V get(@gm.a Object key) {
            V v10;
            synchronized (this.mutex) {
                v10 = delegate().get(key);
            }
            return v10;
        }

        @Override // java.util.Map
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = new s(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // java.util.Map
        @gm.a
        public V put(K key, V value) {
            V vPut;
            synchronized (this.mutex) {
                vPut = delegate().put(key, value);
            }
            return vPut;
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.mutex) {
                delegate().putAll(map);
            }
        }

        @Override // java.util.Map
        @gm.a
        public V remove(@gm.a Object key) {
            V vRemove;
            synchronized (this.mutex) {
                vRemove = delegate().remove(key);
            }
            return vRemove;
        }

        @Override // java.util.Map
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.values == null) {
                        this.values = y6.h(delegate().values(), this.mutex);
                    }
                    collection = this.values;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // f1.y6.p
        public Map<K, V> delegate() {
            return (Map) super.delegate();
        }
    }

    public static class l<K, V> extends p implements v4<K, V> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient Map<K, Collection<V>> asMap;

        @gm.a
        transient Collection<Map.Entry<K, V>> entries;

        @gm.a
        transient Set<K> keySet;

        @gm.a
        transient b5<K> keys;

        @gm.a
        transient Collection<V> valuesCollection;

        public l(v4<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.v4, f1.j6
        public Map<K, Collection<V>> asMap() {
            Map<K, Collection<V>> map;
            synchronized (this.mutex) {
                try {
                    if (this.asMap == null) {
                        this.asMap = new b(delegate().asMap(), this.mutex);
                    }
                    map = this.asMap;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return map;
        }

        @Override // f1.v4
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // f1.v4
        public boolean containsEntry(@gm.a Object key, @gm.a Object value) {
            boolean zContainsEntry;
            synchronized (this.mutex) {
                zContainsEntry = delegate().containsEntry(key, value);
            }
            return zContainsEntry;
        }

        @Override // f1.v4
        public boolean containsKey(@gm.a Object key) {
            boolean zContainsKey;
            synchronized (this.mutex) {
                zContainsKey = delegate().containsKey(key);
            }
            return zContainsKey;
        }

        @Override // f1.v4
        public boolean containsValue(@gm.a Object value) {
            boolean zContainsValue;
            synchronized (this.mutex) {
                zContainsValue = delegate().containsValue(value);
            }
            return zContainsValue;
        }

        @Override // f1.v4
        public Collection<Map.Entry<K, V>> entries() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.mutex) {
                try {
                    if (this.entries == null) {
                        this.entries = y6.A(delegate().entries(), this.mutex);
                    }
                    collection = this.entries;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // f1.v4, f1.o4
        public boolean equals(@gm.a Object o10) {
            boolean zEquals;
            if (o10 == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(o10);
            }
            return zEquals;
        }

        public Collection<V> get(@m5 K key) {
            Collection<V> collectionA;
            synchronized (this.mutex) {
                collectionA = y6.A(delegate().get(key), this.mutex);
            }
            return collectionA;
        }

        @Override // f1.v4
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // f1.v4
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // f1.v4
        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.mutex) {
                try {
                    if (this.keySet == null) {
                        this.keySet = y6.B(delegate().keySet(), this.mutex);
                    }
                    set = this.keySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // f1.v4
        public b5<K> keys() {
            b5<K> b5Var;
            synchronized (this.mutex) {
                try {
                    if (this.keys == null) {
                        this.keys = y6.n(delegate().keys(), this.mutex);
                    }
                    b5Var = this.keys;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return b5Var;
        }

        @Override // f1.v4
        public boolean put(@m5 K key, @m5 V value) {
            boolean zPut;
            synchronized (this.mutex) {
                zPut = delegate().put(key, value);
            }
            return zPut;
        }

        @Override // f1.v4
        public boolean putAll(@m5 K key, Iterable<? extends V> values) {
            boolean zPutAll;
            synchronized (this.mutex) {
                zPutAll = delegate().putAll(key, values);
            }
            return zPutAll;
        }

        @Override // f1.v4
        public boolean remove(@gm.a Object key, @gm.a Object value) {
            boolean zRemove;
            synchronized (this.mutex) {
                zRemove = delegate().remove(key, value);
            }
            return zRemove;
        }

        public Collection<V> removeAll(@gm.a Object key) {
            Collection<V> collectionRemoveAll;
            synchronized (this.mutex) {
                collectionRemoveAll = delegate().removeAll(key);
            }
            return collectionRemoveAll;
        }

        public Collection<V> replaceValues(@m5 K key, Iterable<? extends V> values) {
            Collection<V> collectionReplaceValues;
            synchronized (this.mutex) {
                collectionReplaceValues = delegate().replaceValues(key, values);
            }
            return collectionReplaceValues;
        }

        @Override // f1.v4
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // f1.v4
        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.mutex) {
                try {
                    if (this.valuesCollection == null) {
                        this.valuesCollection = y6.h(delegate().values(), this.mutex);
                    }
                    collection = this.valuesCollection;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return collection;
        }

        @Override // f1.y6.p
        public v4<K, V> delegate() {
            return (v4) super.delegate();
        }

        @Override // f1.v4
        public boolean putAll(v4<? extends K, ? extends V> multimap) {
            boolean zPutAll;
            synchronized (this.mutex) {
                zPutAll = delegate().putAll(multimap);
            }
            return zPutAll;
        }
    }

    public static class p implements Serializable {

        @b1.c
        @b1.d
        private static final long serialVersionUID = 0;
        final Object delegate;
        final Object mutex;

        public p(Object delegate, @gm.a Object mutex) {
            delegate.getClass();
            this.delegate = delegate;
            this.mutex = mutex == null ? this : mutex;
        }

        @b1.c
        @b1.d
        private void writeObject(ObjectOutputStream stream) throws IOException {
            synchronized (this.mutex) {
                stream.defaultWriteObject();
            }
        }

        public Object delegate() {
            return this.delegate;
        }

        public String toString() {
            String string;
            synchronized (this.mutex) {
                string = this.delegate.toString();
            }
            return string;
        }
    }

    public static class r<E> extends i<E> implements RandomAccess {
        private static final long serialVersionUID = 0;

        public r(List<E> list, @gm.a Object mutex) {
            super(list, mutex);
        }
    }

    public static class t<K, V> extends l<K, V> implements j6<K, V> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient Set<Map.Entry<K, V>> entrySet;

        public t(j6<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.y6.l, f1.v4
        public Set<Map.Entry<K, V>> entries() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = new s(delegate().entries(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // f1.y6.l, f1.v4, f1.o4
        public Set<V> get(K key) {
            s sVar;
            synchronized (this.mutex) {
                sVar = new s(delegate().get((Object) key), this.mutex);
            }
            return sVar;
        }

        @Override // f1.y6.l, f1.v4, f1.o4
        public Set<V> removeAll(@gm.a Object key) {
            Set<V> setRemoveAll;
            synchronized (this.mutex) {
                setRemoveAll = delegate().removeAll(key);
            }
            return setRemoveAll;
        }

        @Override // f1.y6.l, f1.v4, f1.o4
        public Set<V> replaceValues(K key, Iterable<? extends V> values) {
            Set<V> setReplaceValues;
            synchronized (this.mutex) {
                setReplaceValues = delegate().replaceValues((Object) key, (Iterable) values);
            }
            return setReplaceValues;
        }

        @Override // f1.y6.l, f1.y6.p
        public j6<K, V> delegate() {
            return (j6) super.delegate();
        }
    }

    public static final class x<R, C, V> extends p implements z6<R, C, V> {

        public class a implements c1.t<Map<C, V>, Map<C, V>> {
            public a() {
            }

            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<C, V> apply(Map<C, V> t10) {
                return new k(t10, x.this.mutex);
            }
        }

        public class b implements c1.t<Map<R, V>, Map<R, V>> {
            public b() {
            }

            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<R, V> apply(Map<R, V> t10) {
                return new k(t10, x.this.mutex);
            }
        }

        public x(z6<R, C, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.z6
        public Set<z6.a<R, C, V>> cellSet() {
            s sVar;
            synchronized (this.mutex) {
                sVar = new s(delegate().cellSet(), this.mutex);
            }
            return sVar;
        }

        @Override // f1.z6
        public void clear() {
            synchronized (this.mutex) {
                delegate().clear();
            }
        }

        @Override // f1.z6
        public Map<R, V> column(@m5 C columnKey) {
            k kVar;
            synchronized (this.mutex) {
                kVar = new k(delegate().column(columnKey), this.mutex);
            }
            return kVar;
        }

        @Override // f1.z6
        public Set<C> columnKeySet() {
            s sVar;
            synchronized (this.mutex) {
                sVar = new s(delegate().columnKeySet(), this.mutex);
            }
            return sVar;
        }

        @Override // f1.z6
        public Map<C, Map<R, V>> columnMap() {
            k kVar;
            synchronized (this.mutex) {
                kVar = new k(t4.B0(delegate().columnMap(), new b()), this.mutex);
            }
            return kVar;
        }

        @Override // f1.z6
        public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
            boolean zContains;
            synchronized (this.mutex) {
                zContains = delegate().contains(rowKey, columnKey);
            }
            return zContains;
        }

        @Override // f1.z6
        public boolean containsColumn(@gm.a Object columnKey) {
            boolean zContainsColumn;
            synchronized (this.mutex) {
                zContainsColumn = delegate().containsColumn(columnKey);
            }
            return zContainsColumn;
        }

        @Override // f1.z6
        public boolean containsRow(@gm.a Object rowKey) {
            boolean zContainsRow;
            synchronized (this.mutex) {
                zContainsRow = delegate().containsRow(rowKey);
            }
            return zContainsRow;
        }

        @Override // f1.z6
        public boolean containsValue(@gm.a Object value) {
            boolean zContainsValue;
            synchronized (this.mutex) {
                zContainsValue = delegate().containsValue(value);
            }
            return zContainsValue;
        }

        @Override // f1.z6
        public boolean equals(@gm.a Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(obj);
            }
            return zEquals;
        }

        @Override // f1.z6
        @gm.a
        public V get(@gm.a Object rowKey, @gm.a Object columnKey) {
            V v10;
            synchronized (this.mutex) {
                v10 = delegate().get(rowKey, columnKey);
            }
            return v10;
        }

        @Override // f1.z6
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // f1.z6
        public boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.mutex) {
                zIsEmpty = delegate().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // f1.z6
        @gm.a
        public V put(@m5 R rowKey, @m5 C columnKey, @m5 V value) {
            V vPut;
            synchronized (this.mutex) {
                vPut = delegate().put(rowKey, columnKey, value);
            }
            return vPut;
        }

        @Override // f1.z6
        public void putAll(z6<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.mutex) {
                delegate().putAll(table);
            }
        }

        @Override // f1.z6
        @gm.a
        public V remove(@gm.a Object rowKey, @gm.a Object columnKey) {
            V vRemove;
            synchronized (this.mutex) {
                vRemove = delegate().remove(rowKey, columnKey);
            }
            return vRemove;
        }

        @Override // f1.z6
        public Map<C, V> row(@m5 R rowKey) {
            k kVar;
            synchronized (this.mutex) {
                kVar = new k(delegate().row(rowKey), this.mutex);
            }
            return kVar;
        }

        @Override // f1.z6
        public Set<R> rowKeySet() {
            s sVar;
            synchronized (this.mutex) {
                sVar = new s(delegate().rowKeySet(), this.mutex);
            }
            return sVar;
        }

        @Override // f1.z6
        public Map<R, Map<C, V>> rowMap() {
            k kVar;
            synchronized (this.mutex) {
                kVar = new k(t4.B0(delegate().rowMap(), new a()), this.mutex);
            }
            return kVar;
        }

        @Override // f1.z6
        public int size() {
            int size;
            synchronized (this.mutex) {
                size = delegate().size();
            }
            return size;
        }

        @Override // f1.z6
        public Collection<V> values() {
            Collection<V> collectionH;
            synchronized (this.mutex) {
                collectionH = y6.h(delegate().values(), this.mutex);
            }
            return collectionH;
        }

        @Override // f1.y6.p
        public z6<R, C, V> delegate() {
            return (z6) super.delegate();
        }
    }

    public static <E> Collection<E> A(Collection<E> collection, @gm.a Object mutex) {
        if (collection instanceof SortedSet) {
            return new v((SortedSet) collection, mutex);
        }
        if (collection instanceof Set) {
            return new s((Set) collection, mutex);
        }
        return collection instanceof List ? j((List) collection, mutex) : h(collection, mutex);
    }

    public static <E> Set<E> B(Set<E> set, @gm.a Object mutex) {
        return set instanceof SortedSet ? new v((SortedSet) set, mutex) : new s(set, mutex);
    }

    public static SortedSet a(SortedSet sortedSet, Object obj) {
        return new v(sortedSet, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <K, V> f1.w<K, V> g(f1.w<K, V> wVar, @gm.a Object obj) {
        return ((wVar instanceof e) || (wVar instanceof c3)) ? wVar : new e(wVar, obj, null);
    }

    public static <E> Collection<E> h(Collection<E> collection, @gm.a Object mutex) {
        return new f(collection, mutex, null);
    }

    public static <E> Deque<E> i(Deque<E> deque, @gm.a Object mutex) {
        return new g(deque, mutex);
    }

    public static <E> List<E> j(List<E> list, @gm.a Object mutex) {
        return list instanceof RandomAccess ? new r(list, mutex) : new i(list, mutex);
    }

    public static <K, V> o4<K, V> k(o4<K, V> multimap, @gm.a Object mutex) {
        return ((multimap instanceof j) || (multimap instanceof f1.v)) ? multimap : new j(multimap, mutex);
    }

    @b1.e
    public static <K, V> Map<K, V> l(Map<K, V> map, @gm.a Object mutex) {
        return new k(map, mutex);
    }

    public static <K, V> v4<K, V> m(v4<K, V> multimap, @gm.a Object mutex) {
        return ((multimap instanceof l) || (multimap instanceof f1.v)) ? multimap : new l(multimap, mutex);
    }

    public static <E> b5<E> n(b5<E> multiset, @gm.a Object mutex) {
        return ((multiset instanceof m) || (multiset instanceof p3)) ? multiset : new m(multiset, mutex);
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> o(NavigableMap<K, V> navigableMap) {
        return new n(navigableMap, null);
    }

    @b1.c
    public static <K, V> NavigableMap<K, V> p(NavigableMap<K, V> navigableMap, @gm.a Object mutex) {
        return new n(navigableMap, mutex);
    }

    @b1.c
    public static <E> NavigableSet<E> q(NavigableSet<E> navigableSet) {
        return new o(navigableSet, null);
    }

    @b1.c
    public static <E> NavigableSet<E> r(NavigableSet<E> navigableSet, @gm.a Object mutex) {
        return new o(navigableSet, mutex);
    }

    @b1.c
    @gm.a
    public static <K, V> Map.Entry<K, V> s(@gm.a Map.Entry<K, V> entry, @gm.a Object mutex) {
        if (entry == null) {
            return null;
        }
        return new h(entry, mutex);
    }

    public static <E> Queue<E> t(Queue<E> queue, @gm.a Object mutex) {
        return queue instanceof q ? queue : new q(queue, mutex);
    }

    @b1.e
    public static <E> Set<E> u(Set<E> set, @gm.a Object mutex) {
        return new s(set, mutex);
    }

    public static <K, V> j6<K, V> v(j6<K, V> multimap, @gm.a Object mutex) {
        return ((multimap instanceof t) || (multimap instanceof f1.v)) ? multimap : new t(multimap, mutex);
    }

    public static <K, V> SortedMap<K, V> w(SortedMap<K, V> sortedMap, @gm.a Object mutex) {
        return new u(sortedMap, mutex);
    }

    public static <E> SortedSet<E> x(SortedSet<E> set, @gm.a Object mutex) {
        return new v(set, mutex);
    }

    public static <K, V> u6<K, V> y(u6<K, V> multimap, @gm.a Object mutex) {
        return multimap instanceof w ? multimap : new w(multimap, mutex);
    }

    public static <R, C, V> z6<R, C, V> z(z6<R, C, V> table, @gm.a Object mutex) {
        return new x(table, mutex);
    }

    public static class m<E> extends f<E> implements b5<E> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient Set<E> elementSet;

        @gm.a
        transient Set<b5.a<E>> entrySet;

        public m(b5<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex, null);
        }

        @Override // f1.b5
        public int add(@m5 E e10, int n10) {
            int iAdd;
            synchronized (this.mutex) {
                iAdd = delegate().add(e10, n10);
            }
            return iAdd;
        }

        @Override // f1.b5
        public int count(@gm.a Object o10) {
            int iCount;
            synchronized (this.mutex) {
                iCount = delegate().count(o10);
            }
            return iCount;
        }

        @Override // f1.b5, f1.r6, f1.s6
        public Set<E> elementSet() {
            Set<E> set;
            synchronized (this.mutex) {
                try {
                    if (this.elementSet == null) {
                        this.elementSet = y6.B(delegate().elementSet(), this.mutex);
                    }
                    set = this.elementSet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // f1.b5
        public Set<b5.a<E>> entrySet() {
            Set<b5.a<E>> set;
            synchronized (this.mutex) {
                try {
                    if (this.entrySet == null) {
                        this.entrySet = y6.B(delegate().entrySet(), this.mutex);
                    }
                    set = this.entrySet;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return set;
        }

        @Override // java.util.Collection, f1.b5
        public boolean equals(@gm.a Object o10) {
            boolean zEquals;
            if (o10 == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(o10);
            }
            return zEquals;
        }

        @Override // java.util.Collection, f1.b5
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // f1.b5
        public int remove(@gm.a Object o10, int n10) {
            int iRemove;
            synchronized (this.mutex) {
                iRemove = delegate().remove(o10, n10);
            }
            return iRemove;
        }

        @Override // f1.b5
        public int setCount(@m5 E element, int count) {
            int count2;
            synchronized (this.mutex) {
                count2 = delegate().setCount(element, count);
            }
            return count2;
        }

        @Override // f1.y6.f, f1.y6.p
        public b5<E> delegate() {
            return (b5) super.delegate();
        }

        @Override // f1.b5
        public boolean setCount(@m5 E element, int oldCount, int newCount) {
            boolean count;
            synchronized (this.mutex) {
                count = delegate().setCount(element, oldCount, newCount);
            }
            return count;
        }
    }

    public static class q<E> extends f<E> implements Queue<E> {
        private static final long serialVersionUID = 0;

        public q(Queue<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex, null);
        }

        @Override // java.util.Queue
        public E element() {
            E eElement;
            synchronized (this.mutex) {
                eElement = delegate().element();
            }
            return eElement;
        }

        @Override // java.util.Queue
        public boolean offer(E e10) {
            boolean zOffer;
            synchronized (this.mutex) {
                zOffer = delegate().offer(e10);
            }
            return zOffer;
        }

        @Override // java.util.Queue
        @gm.a
        public E peek() {
            E ePeek;
            synchronized (this.mutex) {
                ePeek = delegate().peek();
            }
            return ePeek;
        }

        @Override // java.util.Queue
        @gm.a
        public E poll() {
            E ePoll;
            synchronized (this.mutex) {
                ePoll = delegate().poll();
            }
            return ePoll;
        }

        @Override // java.util.Queue
        public E remove() {
            E eRemove;
            synchronized (this.mutex) {
                eRemove = delegate().remove();
            }
            return eRemove;
        }

        @Override // f1.y6.f, f1.y6.p
        public Queue<E> delegate() {
            return (Queue) super.delegate();
        }
    }

    public static class s<E> extends f<E> implements Set<E> {
        private static final long serialVersionUID = 0;

        public s(Set<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex, null);
        }

        public boolean equals(@gm.a Object o10) {
            boolean zEquals;
            if (o10 == this) {
                return true;
            }
            synchronized (this.mutex) {
                zEquals = delegate().equals(o10);
            }
            return zEquals;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            int iHashCode;
            synchronized (this.mutex) {
                iHashCode = delegate().hashCode();
            }
            return iHashCode;
        }

        @Override // f1.y6.f, f1.y6.p
        public Set<E> delegate() {
            return (Set) super.delegate();
        }
    }

    public static class u<K, V> extends k<K, V> implements SortedMap<K, V> {
        private static final long serialVersionUID = 0;

        public u(SortedMap<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            K kFirstKey;
            synchronized (this.mutex) {
                kFirstKey = delegate().firstKey();
            }
            return kFirstKey;
        }

        public SortedMap<K, V> headMap(K toKey) {
            u uVar;
            synchronized (this.mutex) {
                uVar = new u(delegate().headMap(toKey), this.mutex);
            }
            return uVar;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            K kLastKey;
            synchronized (this.mutex) {
                kLastKey = delegate().lastKey();
            }
            return kLastKey;
        }

        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            u uVar;
            synchronized (this.mutex) {
                uVar = new u(delegate().subMap(fromKey, toKey), this.mutex);
            }
            return uVar;
        }

        public SortedMap<K, V> tailMap(K fromKey) {
            u uVar;
            synchronized (this.mutex) {
                uVar = new u(delegate().tailMap(fromKey), this.mutex);
            }
            return uVar;
        }

        @Override // f1.y6.k, f1.y6.p
        public SortedMap<K, V> delegate() {
            return (SortedMap) super.delegate();
        }
    }

    public static class w<K, V> extends t<K, V> implements u6<K, V> {
        private static final long serialVersionUID = 0;

        public w(u6<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.u6
        @gm.a
        public Comparator<? super V> valueComparator() {
            Comparator<? super V> comparatorValueComparator;
            synchronized (this.mutex) {
                comparatorValueComparator = delegate().valueComparator();
            }
            return comparatorValueComparator;
        }

        @Override // f1.y6.t, f1.y6.l, f1.v4, f1.o4
        public SortedSet<V> get(K key) {
            v vVar;
            synchronized (this.mutex) {
                vVar = new v(delegate().get((Object) key), this.mutex);
            }
            return vVar;
        }

        @Override // f1.y6.t, f1.y6.l, f1.v4, f1.o4
        public SortedSet<V> removeAll(@gm.a Object key) {
            SortedSet<V> sortedSetRemoveAll;
            synchronized (this.mutex) {
                sortedSetRemoveAll = delegate().removeAll(key);
            }
            return sortedSetRemoveAll;
        }

        @Override // f1.y6.t, f1.y6.l, f1.v4, f1.o4
        public SortedSet<V> replaceValues(K key, Iterable<? extends V> values) {
            SortedSet<V> sortedSetReplaceValues;
            synchronized (this.mutex) {
                sortedSetReplaceValues = delegate().replaceValues((Object) key, (Iterable) values);
            }
            return sortedSetReplaceValues;
        }

        @Override // f1.y6.t, f1.y6.l, f1.y6.p
        public u6<K, V> delegate() {
            return (u6) super.delegate();
        }
    }

    public static class c<K, V> extends s<Map.Entry<K, Collection<V>>> {
        private static final long serialVersionUID = 0;

        public class a extends o7<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>> {

            /* JADX INFO: renamed from: f1.y6$c$a$a, reason: collision with other inner class name */
            public class C0135a extends e2<K, Collection<V>> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Map.Entry f5633a;

                public C0135a(final Map.Entry val$entry) {
                    this.f5633a = val$entry;
                }

                @Override // f1.e2, f1.j2
                /* JADX INFO: renamed from: l */
                public Map.Entry<K, Collection<V>> delegate() {
                    return this.f5633a;
                }

                @Override // f1.e2, java.util.Map.Entry
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public Collection<V> getValue() {
                    return y6.A((Collection) this.f5633a.getValue(), c.this.mutex);
                }
            }

            public a(Iterator backingIterator) {
                super(backingIterator);
            }

            @Override // f1.o7
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, Collection<V>> a(final Map.Entry<K, Collection<V>> entry) {
                return new C0135a(entry);
            }
        }

        public c(Set<Map.Entry<K, Collection<V>>> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            boolean zP;
            synchronized (this.mutex) {
                zP = t4.p(delegate(), o10);
            }
            return zP;
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> c10) {
            boolean zB;
            synchronized (this.mutex) {
                zB = c0.b(delegate(), c10);
            }
            return zB;
        }

        @Override // f1.y6.s, java.util.Collection, java.util.Set
        public boolean equals(@gm.a Object o10) {
            boolean zG;
            if (o10 == this) {
                return true;
            }
            synchronized (this.mutex) {
                zG = k6.g(delegate(), o10);
            }
            return zG;
        }

        @Override // f1.y6.f, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new a(super.iterator());
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            boolean zK0;
            synchronized (this.mutex) {
                zK0 = t4.k0(delegate(), o10);
            }
            return zK0;
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> c10) {
            boolean zV;
            synchronized (this.mutex) {
                zV = h4.V(delegate().iterator(), c10);
            }
            return zV;
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> c10) {
            boolean zX;
            synchronized (this.mutex) {
                zX = h4.X(delegate().iterator(), c10);
            }
            return zX;
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public Object[] toArray() {
            Object[] objArrL;
            synchronized (this.mutex) {
                objArrL = i5.l(delegate());
            }
            return objArrL;
        }

        @Override // f1.y6.f, java.util.Collection, java.util.Set
        public <T> T[] toArray(T[] tArr) {
            T[] tArr2;
            synchronized (this.mutex) {
                tArr2 = (T[]) i5.m(delegate(), tArr);
            }
            return tArr2;
        }
    }

    public static final class g<E> extends q<E> implements Deque<E> {
        private static final long serialVersionUID = 0;

        public g(Deque<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.Deque
        public void addFirst(E e10) {
            synchronized (this.mutex) {
                delegate().addFirst(e10);
            }
        }

        @Override // java.util.Deque
        public void addLast(E e10) {
            synchronized (this.mutex) {
                delegate().addLast(e10);
            }
        }

        @Override // java.util.Deque
        public Iterator<E> descendingIterator() {
            Iterator<E> itDescendingIterator;
            synchronized (this.mutex) {
                itDescendingIterator = delegate().descendingIterator();
            }
            return itDescendingIterator;
        }

        @Override // java.util.Deque
        public E getFirst() {
            E first;
            synchronized (this.mutex) {
                first = delegate().getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public E getLast() {
            E last;
            synchronized (this.mutex) {
                last = delegate().getLast();
            }
            return last;
        }

        @Override // java.util.Deque
        public boolean offerFirst(E e10) {
            boolean zOfferFirst;
            synchronized (this.mutex) {
                zOfferFirst = delegate().offerFirst(e10);
            }
            return zOfferFirst;
        }

        @Override // java.util.Deque
        public boolean offerLast(E e10) {
            boolean zOfferLast;
            synchronized (this.mutex) {
                zOfferLast = delegate().offerLast(e10);
            }
            return zOfferLast;
        }

        @Override // java.util.Deque
        @gm.a
        public E peekFirst() {
            E ePeekFirst;
            synchronized (this.mutex) {
                ePeekFirst = delegate().peekFirst();
            }
            return ePeekFirst;
        }

        @Override // java.util.Deque
        @gm.a
        public E peekLast() {
            E ePeekLast;
            synchronized (this.mutex) {
                ePeekLast = delegate().peekLast();
            }
            return ePeekLast;
        }

        @Override // java.util.Deque
        @gm.a
        public E pollFirst() {
            E ePollFirst;
            synchronized (this.mutex) {
                ePollFirst = delegate().pollFirst();
            }
            return ePollFirst;
        }

        @Override // java.util.Deque
        @gm.a
        public E pollLast() {
            E ePollLast;
            synchronized (this.mutex) {
                ePollLast = delegate().pollLast();
            }
            return ePollLast;
        }

        @Override // java.util.Deque
        public E pop() {
            E ePop;
            synchronized (this.mutex) {
                ePop = delegate().pop();
            }
            return ePop;
        }

        @Override // java.util.Deque
        public void push(E e10) {
            synchronized (this.mutex) {
                delegate().push(e10);
            }
        }

        @Override // java.util.Deque
        public E removeFirst() {
            E eRemoveFirst;
            synchronized (this.mutex) {
                eRemoveFirst = delegate().removeFirst();
            }
            return eRemoveFirst;
        }

        @Override // java.util.Deque
        public boolean removeFirstOccurrence(@gm.a Object o10) {
            boolean zRemoveFirstOccurrence;
            synchronized (this.mutex) {
                zRemoveFirstOccurrence = delegate().removeFirstOccurrence(o10);
            }
            return zRemoveFirstOccurrence;
        }

        @Override // java.util.Deque
        public E removeLast() {
            E eRemoveLast;
            synchronized (this.mutex) {
                eRemoveLast = delegate().removeLast();
            }
            return eRemoveLast;
        }

        @Override // java.util.Deque
        public boolean removeLastOccurrence(@gm.a Object o10) {
            boolean zRemoveLastOccurrence;
            synchronized (this.mutex) {
                zRemoveLastOccurrence = delegate().removeLastOccurrence(o10);
            }
            return zRemoveLastOccurrence;
        }

        @Override // f1.y6.q, f1.y6.f, f1.y6.p
        public Deque<E> delegate() {
            return (Deque) super.delegate();
        }
    }

    @b1.c
    @b1.e
    public static class n<K, V> extends u<K, V> implements NavigableMap<K, V> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient NavigableSet<K> descendingKeySet;

        @gm.a
        transient NavigableMap<K, V> descendingMap;

        @gm.a
        transient NavigableSet<K> navigableKeySet;

        public n(NavigableMap<K, V> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> ceilingEntry(K key) {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().ceilingEntry(key), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K ceilingKey(K key) {
            K kCeilingKey;
            synchronized (this.mutex) {
                kCeilingKey = delegate().ceilingKey(key);
            }
            return kCeilingKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.descendingKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    o oVar = new o(delegate().descendingKeySet(), this.mutex);
                    this.descendingKeySet = oVar;
                    return oVar;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            synchronized (this.mutex) {
                try {
                    NavigableMap<K, V> navigableMap = this.descendingMap;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    n nVar = new n(delegate().descendingMap(), this.mutex);
                    this.descendingMap = nVar;
                    return nVar;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().firstEntry(), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> floorEntry(K key) {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().floorEntry(key), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K floorKey(K key) {
            K kFloorKey;
            synchronized (this.mutex) {
                kFloorKey = delegate().floorKey(key);
            }
            return kFloorKey;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K toKey, boolean inclusive) {
            n nVar;
            synchronized (this.mutex) {
                nVar = new n(delegate().headMap(toKey, inclusive), this.mutex);
            }
            return nVar;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> higherEntry(K key) {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().higherEntry(key), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K higherKey(K key) {
            K kHigherKey;
            synchronized (this.mutex) {
                kHigherKey = delegate().higherKey(key);
            }
            return kHigherKey;
        }

        @Override // f1.y6.k, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().lastEntry(), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> lowerEntry(K key) {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().lowerEntry(key), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public K lowerKey(K key) {
            K kLowerKey;
            synchronized (this.mutex) {
                kLowerKey = delegate().lowerKey(key);
            }
            return kLowerKey;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<K> navigableSet = this.navigableKeySet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    o oVar = new o(delegate().navigableKeySet(), this.mutex);
                    this.navigableKeySet = oVar;
                    return oVar;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().pollFirstEntry(), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        @gm.a
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> entryS;
            synchronized (this.mutex) {
                entryS = y6.s(delegate().pollLastEntry(), this.mutex);
            }
            return entryS;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive) {
            n nVar;
            synchronized (this.mutex) {
                nVar = new n(delegate().subMap(fromKey, fromInclusive, toKey, toInclusive), this.mutex);
            }
            return nVar;
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive) {
            n nVar;
            synchronized (this.mutex) {
                nVar = new n(delegate().tailMap(fromKey, inclusive), this.mutex);
            }
            return nVar;
        }

        @Override // f1.y6.u, f1.y6.k, f1.y6.p
        public NavigableMap<K, V> delegate() {
            return (NavigableMap) super.delegate();
        }

        @Override // f1.y6.u, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> headMap(K toKey) {
            return headMap(toKey, false);
        }

        @Override // f1.y6.u, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> subMap(K fromKey, K toKey) {
            return subMap(fromKey, true, toKey, false);
        }

        @Override // f1.y6.u, java.util.SortedMap, java.util.NavigableMap
        public SortedMap<K, V> tailMap(K fromKey) {
            return tailMap(fromKey, true);
        }
    }

    public static class v<E> extends s<E> implements SortedSet<E> {
        private static final long serialVersionUID = 0;

        public v(SortedSet<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.SortedSet
        @gm.a
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.mutex) {
                comparator = delegate().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public E first() {
            E eFirst;
            synchronized (this.mutex) {
                eFirst = delegate().first();
            }
            return eFirst;
        }

        public SortedSet<E> headSet(E toElement) {
            v vVar;
            synchronized (this.mutex) {
                vVar = new v(delegate().headSet(toElement), this.mutex);
            }
            return vVar;
        }

        @Override // java.util.SortedSet
        public E last() {
            E eLast;
            synchronized (this.mutex) {
                eLast = delegate().last();
            }
            return eLast;
        }

        public SortedSet<E> subSet(E fromElement, E toElement) {
            v vVar;
            synchronized (this.mutex) {
                vVar = new v(delegate().subSet(fromElement, toElement), this.mutex);
            }
            return vVar;
        }

        public SortedSet<E> tailSet(E fromElement) {
            v vVar;
            synchronized (this.mutex) {
                vVar = new v(delegate().tailSet(fromElement), this.mutex);
            }
            return vVar;
        }

        @Override // f1.y6.s, f1.y6.f, f1.y6.p
        public SortedSet<E> delegate() {
            return (SortedSet) super.delegate();
        }
    }

    @b1.c
    @b1.e
    public static class o<E> extends v<E> implements NavigableSet<E> {
        private static final long serialVersionUID = 0;

        @gm.a
        transient NavigableSet<E> descendingSet;

        public o(NavigableSet<E> delegate, @gm.a Object mutex) {
            super(delegate, mutex);
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E ceiling(E e10) {
            E eCeiling;
            synchronized (this.mutex) {
                eCeiling = delegate().ceiling(e10);
            }
            return eCeiling;
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return delegate().descendingIterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            synchronized (this.mutex) {
                try {
                    NavigableSet<E> navigableSet = this.descendingSet;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    o oVar = new o(delegate().descendingSet(), this.mutex);
                    this.descendingSet = oVar;
                    return oVar;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E floor(E e10) {
            E eFloor;
            synchronized (this.mutex) {
                eFloor = delegate().floor(e10);
            }
            return eFloor;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E toElement, boolean inclusive) {
            o oVar;
            synchronized (this.mutex) {
                oVar = new o(delegate().headSet(toElement, inclusive), this.mutex);
            }
            return oVar;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E higher(E e10) {
            E eHigher;
            synchronized (this.mutex) {
                eHigher = delegate().higher(e10);
            }
            return eHigher;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E lower(E e10) {
            E eLower;
            synchronized (this.mutex) {
                eLower = delegate().lower(e10);
            }
            return eLower;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollFirst() {
            E ePollFirst;
            synchronized (this.mutex) {
                ePollFirst = delegate().pollFirst();
            }
            return ePollFirst;
        }

        @Override // java.util.NavigableSet
        @gm.a
        public E pollLast() {
            E ePollLast;
            synchronized (this.mutex) {
                ePollLast = delegate().pollLast();
            }
            return ePollLast;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive) {
            o oVar;
            synchronized (this.mutex) {
                oVar = new o(delegate().subSet(fromElement, fromInclusive, toElement, toInclusive), this.mutex);
            }
            return oVar;
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E fromElement, boolean inclusive) {
            o oVar;
            synchronized (this.mutex) {
                oVar = new o(delegate().tailSet(fromElement, inclusive), this.mutex);
            }
            return oVar;
        }

        @Override // f1.y6.v, f1.y6.s, f1.y6.f, f1.y6.p
        public NavigableSet<E> delegate() {
            return (NavigableSet) super.delegate();
        }

        @Override // f1.y6.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> headSet(E toElement) {
            return headSet(toElement, false);
        }

        @Override // f1.y6.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> subSet(E fromElement, E toElement) {
            return subSet(fromElement, true, toElement, false);
        }

        @Override // f1.y6.v, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<E> tailSet(E fromElement) {
            return tailSet(fromElement, true);
        }
    }
}
