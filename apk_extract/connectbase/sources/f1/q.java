package f1;

import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class q<R, C, V> implements z6<R, C, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Set<z6.a<R, C, V>> f5202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient Collection<V> f5203b;

    public class a extends o7<z6.a<R, C, V>, V> {
        public a(final q this$0, Iterator backingIterator) {
            super(backingIterator);
        }

        @Override // f1.o7
        @m5
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public V a(z6.a<R, C, V> cell) {
            return cell.getValue();
        }
    }

    public class b extends AbstractSet<z6.a<R, C, V>> {
        public b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            q.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (!(o10 instanceof z6.a)) {
                return false;
            }
            z6.a aVar = (z6.a) o10;
            Map map = (Map) t4.p0(q.this.rowMap(), aVar.getRowKey());
            return map != null && c0.j(map.entrySet(), new f3(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<z6.a<R, C, V>> iterator() {
            return q.this.cellIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@gm.a Object o10) {
            if (!(o10 instanceof z6.a)) {
                return false;
            }
            z6.a aVar = (z6.a) o10;
            Map map = (Map) t4.p0(q.this.rowMap(), aVar.getRowKey());
            return map != null && c0.k(map.entrySet(), new f3(aVar.getColumnKey(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return q.this.size();
        }
    }

    public class c extends AbstractCollection<V> {
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            q.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object o10) {
            return q.this.containsValue(o10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return q.this.valuesIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return q.this.size();
        }
    }

    public abstract Iterator<z6.a<R, C, V>> cellIterator();

    @Override // f1.z6
    public Set<z6.a<R, C, V>> cellSet() {
        Set<z6.a<R, C, V>> set = this.f5202a;
        if (set != null) {
            return set;
        }
        Set<z6.a<R, C, V>> setCreateCellSet = createCellSet();
        this.f5202a = setCreateCellSet;
        return setCreateCellSet;
    }

    @Override // f1.z6
    public void clear() {
        h4.h(cellSet().iterator());
    }

    @Override // f1.z6
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // f1.z6
    public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
        Map map = (Map) t4.p0(rowMap(), rowKey);
        return map != null && t4.o0(map, columnKey);
    }

    @Override // f1.z6
    public boolean containsColumn(@gm.a Object columnKey) {
        return t4.o0(columnMap(), columnKey);
    }

    @Override // f1.z6
    public boolean containsRow(@gm.a Object rowKey) {
        return t4.o0(rowMap(), rowKey);
    }

    @Override // f1.z6
    public boolean containsValue(@gm.a Object value) {
        Iterator<Map<C, V>> it = rowMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().containsValue(value)) {
                return true;
            }
        }
        return false;
    }

    public Set<z6.a<R, C, V>> createCellSet() {
        return new b();
    }

    public Collection<V> createValues() {
        return new c();
    }

    @Override // f1.z6
    public boolean equals(@gm.a Object obj) {
        return m7.b(this, obj);
    }

    @Override // f1.z6
    @gm.a
    public V get(@gm.a Object obj, @gm.a Object obj2) {
        Map map = (Map) t4.p0(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) t4.p0(map, obj2);
    }

    @Override // f1.z6
    public int hashCode() {
        return cellSet().hashCode();
    }

    @Override // f1.z6
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // f1.z6
    @gm.a
    @t1.a
    public V put(@m5 R rowKey, @m5 C columnKey, @m5 V value) {
        return row(rowKey).put(columnKey, value);
    }

    @Override // f1.z6
    public void putAll(z6<? extends R, ? extends C, ? extends V> table) {
        for (z6.a<? extends R, ? extends C, ? extends V> aVar : table.cellSet()) {
            put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
        }
    }

    @Override // f1.z6
    @gm.a
    @t1.a
    public V remove(@gm.a Object obj, @gm.a Object obj2) {
        Map map = (Map) t4.p0(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) t4.q0(map, obj2);
    }

    @Override // f1.z6
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    @Override // f1.z6
    public Collection<V> values() {
        Collection<V> collection = this.f5203b;
        if (collection != null) {
            return collection;
        }
        Collection<V> collectionCreateValues = createValues();
        this.f5203b = collectionCreateValues;
        return collectionCreateValues;
    }

    public Iterator<V> valuesIterator() {
        return new a(cellSet().iterator());
    }
}
