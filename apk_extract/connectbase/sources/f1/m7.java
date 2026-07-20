package f1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class m7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1.t<? extends Map<?, ?>, ? extends Map<?, ?>> f5095a = new a();

    public class a implements c1.t<Map<Object, Object>, Map<Object, Object>> {
        @Override // c1.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map<Object, Object> apply(Map<Object, Object> input) {
            return Collections.unmodifiableMap(input);
        }
    }

    public static abstract class b<R, C, V> implements z6.a<R, C, V> {
        @Override // f1.z6.a
        public boolean equals(@gm.a Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof z6.a)) {
                return false;
            }
            z6.a aVar = (z6.a) obj;
            return c1.b0.a(getRowKey(), aVar.getRowKey()) && c1.b0.a(getColumnKey(), aVar.getColumnKey()) && c1.b0.a(getValue(), aVar.getValue());
        }

        @Override // f1.z6.a
        public int hashCode() {
            return Arrays.hashCode(new Object[]{getRowKey(), getColumnKey(), getValue()});
        }

        public String toString() {
            return "(" + getRowKey() + ks.g.f9491d + getColumnKey() + ")=" + getValue();
        }
    }

    public static final class c<R, C, V> extends b<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;

        @m5
        private final C columnKey;

        @m5
        private final R rowKey;

        @m5
        private final V value;

        public c(@m5 R rowKey, @m5 C columnKey, @m5 V value) {
            this.rowKey = rowKey;
            this.columnKey = columnKey;
            this.value = value;
        }

        @Override // f1.z6.a
        @m5
        public C getColumnKey() {
            return this.columnKey;
        }

        @Override // f1.z6.a
        @m5
        public R getRowKey() {
            return this.rowKey;
        }

        @Override // f1.z6.a
        @m5
        public V getValue() {
            return this.value;
        }
    }

    public static class d<R, C, V1, V2> extends q<R, C, V2> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z6<R, C, V1> f5096c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c1.t<? super V1, V2> f5097d;

        public class a implements c1.t<z6.a<R, C, V1>, z6.a<R, C, V2>> {
            public a() {
            }

            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public z6.a<R, C, V2> apply(z6.a<R, C, V1> cell) {
                return m7.c(cell.getRowKey(), cell.getColumnKey(), d.this.f5097d.apply(cell.getValue()));
            }
        }

        public class b implements c1.t<Map<C, V1>, Map<C, V2>> {
            public b() {
            }

            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<C, V2> apply(Map<C, V1> row) {
                return t4.B0(row, d.this.f5097d);
            }
        }

        public class c implements c1.t<Map<R, V1>, Map<R, V2>> {
            public c() {
            }

            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map<R, V2> apply(Map<R, V1> column) {
                return t4.B0(column, d.this.f5097d);
            }
        }

        public d(z6<R, C, V1> fromTable, c1.t<? super V1, V2> function) {
            fromTable.getClass();
            this.f5096c = fromTable;
            function.getClass();
            this.f5097d = function;
        }

        public c1.t<z6.a<R, C, V1>, z6.a<R, C, V2>> a() {
            return new a();
        }

        @Override // f1.q
        public Iterator<z6.a<R, C, V2>> cellIterator() {
            return h4.c0(this.f5096c.cellSet().iterator(), a());
        }

        @Override // f1.q, f1.z6
        public void clear() {
            this.f5096c.clear();
        }

        @Override // f1.z6
        public Map<R, V2> column(@m5 C columnKey) {
            return t4.B0(this.f5096c.column(columnKey), this.f5097d);
        }

        @Override // f1.q, f1.z6
        public Set<C> columnKeySet() {
            return this.f5096c.columnKeySet();
        }

        @Override // f1.z6
        public Map<C, Map<R, V2>> columnMap() {
            return t4.B0(this.f5096c.columnMap(), new c());
        }

        @Override // f1.q, f1.z6
        public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
            return this.f5096c.contains(rowKey, columnKey);
        }

        @Override // f1.q
        public Collection<V2> createValues() {
            return new c0.f(this.f5096c.values(), this.f5097d);
        }

        @Override // f1.q, f1.z6
        @gm.a
        public V2 get(@gm.a Object obj, @gm.a Object obj2) {
            if (contains(obj, obj2)) {
                return this.f5097d.apply(this.f5096c.get(obj, obj2));
            }
            return null;
        }

        @Override // f1.q, f1.z6
        @gm.a
        public V2 put(@m5 R rowKey, @m5 C columnKey, @m5 V2 value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.q, f1.z6
        public void putAll(z6<? extends R, ? extends C, ? extends V2> table) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.q, f1.z6
        @gm.a
        public V2 remove(@gm.a Object obj, @gm.a Object obj2) {
            if (contains(obj, obj2)) {
                return this.f5097d.apply(this.f5096c.remove(obj, obj2));
            }
            return null;
        }

        @Override // f1.z6
        public Map<C, V2> row(@m5 R rowKey) {
            return t4.B0(this.f5096c.row(rowKey), this.f5097d);
        }

        @Override // f1.q, f1.z6
        public Set<R> rowKeySet() {
            return this.f5096c.rowKeySet();
        }

        @Override // f1.z6
        public Map<R, Map<C, V2>> rowMap() {
            return t4.B0(this.f5096c.rowMap(), new b());
        }

        @Override // f1.z6
        public int size() {
            return this.f5096c.size();
        }
    }

    public static class e<C, R, V> extends q<C, R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c1.t f5101d = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final z6<R, C, V> f5102c;

        public class a implements c1.t<z6.a<?, ?, ?>, z6.a<?, ?, ?>> {
            @Override // c1.t
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public z6.a<?, ?, ?> apply(z6.a<?, ?, ?> cell) {
                return m7.c(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
            }
        }

        public e(z6<R, C, V> original) {
            original.getClass();
            this.f5102c = original;
        }

        @Override // f1.q
        public Iterator<z6.a<C, R, V>> cellIterator() {
            return h4.c0(this.f5102c.cellSet().iterator(), f5101d);
        }

        @Override // f1.q, f1.z6
        public void clear() {
            this.f5102c.clear();
        }

        @Override // f1.z6
        public Map<C, V> column(@m5 R columnKey) {
            return this.f5102c.row(columnKey);
        }

        @Override // f1.q, f1.z6
        public Set<R> columnKeySet() {
            return this.f5102c.rowKeySet();
        }

        @Override // f1.z6
        public Map<R, Map<C, V>> columnMap() {
            return this.f5102c.rowMap();
        }

        @Override // f1.q, f1.z6
        public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
            return this.f5102c.contains(columnKey, rowKey);
        }

        @Override // f1.q, f1.z6
        public boolean containsColumn(@gm.a Object columnKey) {
            return this.f5102c.containsRow(columnKey);
        }

        @Override // f1.q, f1.z6
        public boolean containsRow(@gm.a Object rowKey) {
            return this.f5102c.containsColumn(rowKey);
        }

        @Override // f1.q, f1.z6
        public boolean containsValue(@gm.a Object value) {
            return this.f5102c.containsValue(value);
        }

        @Override // f1.q, f1.z6
        @gm.a
        public V get(@gm.a Object rowKey, @gm.a Object columnKey) {
            return this.f5102c.get(columnKey, rowKey);
        }

        @Override // f1.q, f1.z6
        @gm.a
        public V put(@m5 C rowKey, @m5 R columnKey, @m5 V value) {
            return this.f5102c.put(columnKey, rowKey, value);
        }

        @Override // f1.q, f1.z6
        public void putAll(z6<? extends C, ? extends R, ? extends V> table) {
            this.f5102c.putAll(m7.g(table));
        }

        @Override // f1.q, f1.z6
        @gm.a
        public V remove(@gm.a Object rowKey, @gm.a Object columnKey) {
            return this.f5102c.remove(columnKey, rowKey);
        }

        @Override // f1.z6
        public Map<R, V> row(@m5 C rowKey) {
            return this.f5102c.column(rowKey);
        }

        @Override // f1.q, f1.z6
        public Set<C> rowKeySet() {
            return this.f5102c.columnKeySet();
        }

        @Override // f1.z6
        public Map<C, Map<R, V>> rowMap() {
            return this.f5102c.columnMap();
        }

        @Override // f1.z6
        public int size() {
            return this.f5102c.size();
        }

        @Override // f1.q, f1.z6
        public Collection<V> values() {
            return this.f5102c.values();
        }
    }

    public static final class f<R, C, V> extends g<R, C, V> implements h6<R, C, V> {
        private static final long serialVersionUID = 0;

        public f(h6<R, ? extends C, ? extends V> delegate) {
            super(delegate);
        }

        @Override // f1.m7.g, f1.r2, f1.z6
        public SortedSet<R> rowKeySet() {
            return Collections.unmodifiableSortedSet(delegate().rowKeySet());
        }

        @Override // f1.m7.g, f1.r2, f1.z6
        public SortedMap<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableSortedMap(t4.D0(delegate().rowMap(), m7.a()));
        }

        @Override // f1.m7.g, f1.r2, f1.j2
        public h6<R, C, V> delegate() {
            return (h6) super.delegate();
        }
    }

    public static class g<R, C, V> extends r2<R, C, V> implements Serializable {
        private static final long serialVersionUID = 0;
        final z6<? extends R, ? extends C, ? extends V> delegate;

        public g(z6<? extends R, ? extends C, ? extends V> delegate) {
            delegate.getClass();
            this.delegate = delegate;
        }

        @Override // f1.r2, f1.z6
        public Set<z6.a<R, C, V>> cellSet() {
            return Collections.unmodifiableSet(super.cellSet());
        }

        @Override // f1.r2, f1.z6
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // f1.r2, f1.z6
        public Map<R, V> column(@m5 C columnKey) {
            return Collections.unmodifiableMap(super.column(columnKey));
        }

        @Override // f1.r2, f1.z6
        public Set<C> columnKeySet() {
            return Collections.unmodifiableSet(super.columnKeySet());
        }

        @Override // f1.r2, f1.z6
        public Map<C, Map<R, V>> columnMap() {
            return Collections.unmodifiableMap(t4.B0(super.columnMap(), m7.a()));
        }

        @Override // f1.r2, f1.z6
        @gm.a
        public V put(@m5 R rowKey, @m5 C columnKey, @m5 V value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.r2, f1.z6
        public void putAll(z6<? extends R, ? extends C, ? extends V> table) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.r2, f1.z6
        @gm.a
        public V remove(@gm.a Object rowKey, @gm.a Object columnKey) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.r2, f1.z6
        public Map<C, V> row(@m5 R rowKey) {
            return Collections.unmodifiableMap(super.row(rowKey));
        }

        @Override // f1.r2, f1.z6
        public Set<R> rowKeySet() {
            return Collections.unmodifiableSet(super.rowKeySet());
        }

        @Override // f1.r2, f1.z6
        public Map<R, Map<C, V>> rowMap() {
            return Collections.unmodifiableMap(t4.B0(super.rowMap(), m7.a()));
        }

        @Override // f1.r2, f1.z6
        public Collection<V> values() {
            return Collections.unmodifiableCollection(super.values());
        }

        @Override // f1.r2, f1.j2
        public z6<R, C, V> delegate() {
            return this.delegate;
        }
    }

    public static c1.t a() {
        return f5095a;
    }

    public static boolean b(z6<?, ?, ?> table, @gm.a Object obj) {
        if (obj == table) {
            return true;
        }
        if (obj instanceof z6) {
            return table.cellSet().equals(((z6) obj).cellSet());
        }
        return false;
    }

    public static <R, C, V> z6.a<R, C, V> c(@m5 R rowKey, @m5 C columnKey, @m5 V value) {
        return new c(rowKey, columnKey, value);
    }

    public static <R, C, V> z6<R, C, V> d(Map<R, Map<C, V>> backingMap, c1.q0<? extends Map<C, V>> factory) {
        c1.h0.d(backingMap.isEmpty());
        factory.getClass();
        return new x6(backingMap, factory);
    }

    public static <R, C, V> z6<R, C, V> e(z6<R, C, V> table) {
        return new y6.x(table, null);
    }

    public static <R, C, V1, V2> z6<R, C, V2> f(z6<R, C, V1> fromTable, c1.t<? super V1, V2> function) {
        return new d(fromTable, function);
    }

    public static <R, C, V> z6<C, R, V> g(z6<R, C, V> z6Var) {
        return z6Var instanceof e ? ((e) z6Var).f5102c : new e(z6Var);
    }

    public static <R, C, V> h6<R, C, V> h(h6<R, ? extends C, ? extends V> table) {
        return new f(table);
    }

    public static <R, C, V> z6<R, C, V> i(z6<? extends R, ? extends C, ? extends V> table) {
        return new g(table);
    }

    public static <K, V> c1.t<Map<K, V>, Map<K, V>> j() {
        return (c1.t<Map<K, V>, Map<K, V>>) f5095a;
    }
}
