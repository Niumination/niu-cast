package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class c4<R, C, V> extends q<R, C, V> implements Serializable {
    private static final long serialVersionUID = 912559;

    @t1.f
    public static final class a<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<z6.a<R, C, V>> f4729a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public Comparator<? super R> f4730b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public Comparator<? super C> f4731c;

        public c4<R, C, V> a() {
            return b();
        }

        public c4<R, C, V> b() {
            int size = this.f4729a.size();
            if (size != 0) {
                return size != 1 ? e6.forCells(this.f4729a, this.f4730b, this.f4731c) : new m6((z6.a) g4.z(this.f4729a));
            }
            return c4.of();
        }

        @t1.a
        public a<R, C, V> c(a<R, C, V> other) {
            this.f4729a.addAll(other.f4729a);
            return this;
        }

        @t1.a
        public a<R, C, V> d(Comparator<? super C> columnComparator) {
            this.f4731c = (Comparator) c1.h0.F(columnComparator, "columnComparator");
            return this;
        }

        @t1.a
        public a<R, C, V> e(Comparator<? super R> rowComparator) {
            this.f4730b = (Comparator) c1.h0.F(rowComparator, "rowComparator");
            return this;
        }

        @t1.a
        public a<R, C, V> f(z6.a<? extends R, ? extends C, ? extends V> cell) {
            if (cell instanceof m7.c) {
                c1.h0.F(cell.getRowKey(), "row");
                c1.h0.F(cell.getColumnKey(), "column");
                c1.h0.F(cell.getValue(), "value");
                this.f4729a.add(cell);
            } else {
                g(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
            }
            return this;
        }

        @t1.a
        public a<R, C, V> g(R rowKey, C columnKey, V value) {
            this.f4729a.add(c4.cellOf(rowKey, columnKey, value));
            return this;
        }

        @t1.a
        public a<R, C, V> h(z6<? extends R, ? extends C, ? extends V> table) {
            Iterator<z6.a<? extends R, ? extends C, ? extends V>> it = table.cellSet().iterator();
            while (it.hasNext()) {
                f(it.next());
            }
            return this;
        }
    }

    public static final class b implements Serializable {
        private static final long serialVersionUID = 0;
        private final int[] cellColumnIndices;
        private final int[] cellRowIndices;
        private final Object[] cellValues;
        private final Object[] columnKeys;
        private final Object[] rowKeys;

        public b(Object[] rowKeys, Object[] columnKeys, Object[] cellValues, int[] cellRowIndices, int[] cellColumnIndices) {
            this.rowKeys = rowKeys;
            this.columnKeys = columnKeys;
            this.cellValues = cellValues;
            this.cellRowIndices = cellRowIndices;
            this.cellColumnIndices = cellColumnIndices;
        }

        public static b create(c4<?, ?, ?> table, int[] cellRowIndices, int[] cellColumnIndices) {
            return new b(table.rowKeySet().toArray(), table.columnKeySet().toArray(), table.values().toArray(), cellRowIndices, cellColumnIndices);
        }

        public Object readResolve() {
            Object[] objArr = this.cellValues;
            if (objArr.length == 0) {
                return c4.of();
            }
            int i10 = 0;
            if (objArr.length == 1) {
                return c4.of(this.rowKeys[0], this.columnKeys[0], objArr[0]);
            }
            i3.a aVar = new i3.a(objArr.length);
            while (true) {
                Object[] objArr2 = this.cellValues;
                if (i10 >= objArr2.length) {
                    return e6.forOrderedComponents(aVar.e(), t3.copyOf(this.rowKeys), t3.copyOf(this.columnKeys));
                }
                aVar.j(c4.cellOf(this.rowKeys[this.cellRowIndices[i10]], this.columnKeys[this.cellColumnIndices[i10]], objArr2[i10]));
                i10++;
            }
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> z6.a<R, C, V> cellOf(R rowKey, C columnKey, V value) {
        return m7.c(c1.h0.F(rowKey, "rowKey"), c1.h0.F(columnKey, "columnKey"), c1.h0.F(value, "value"));
    }

    public static <R, C, V> c4<R, C, V> copyOf(z6<? extends R, ? extends C, ? extends V> table) {
        return table instanceof c4 ? (c4) table : copyOf(table.cellSet());
    }

    public static <R, C, V> c4<R, C, V> of() {
        return (c4<R, C, V>) v6.EMPTY;
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.q, f1.z6
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.z6
    public abstract k3<C, Map<R, V>> columnMap();

    @Override // f1.q, f1.z6
    public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
        return get(rowKey, columnKey) != null;
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean containsColumn(@gm.a Object columnKey) {
        return super.containsColumn(columnKey);
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean containsRow(@gm.a Object rowKey) {
        return super.containsRow(rowKey);
    }

    @Override // f1.q, f1.z6
    public boolean containsValue(@gm.a Object value) {
        return values().contains(value);
    }

    @Override // f1.q
    public abstract t3<z6.a<R, C, V>> createCellSet();

    public abstract b createSerializedForm();

    @Override // f1.q
    public abstract e3<V> createValues();

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object obj) {
        return super.equals(obj);
    }

    @Override // f1.q, f1.z6
    @gm.a
    public /* bridge */ /* synthetic */ Object get(@gm.a Object rowKey, @gm.a Object columnKey) {
        return super.get(rowKey, columnKey);
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // f1.q, f1.z6
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final V put(R rowKey, C columnKey, V value) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.q, f1.z6
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(z6<? extends R, ? extends C, ? extends V> table) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.q, f1.z6
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public final V remove(@gm.a Object rowKey, @gm.a Object columnKey) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.z6
    public abstract k3<R, Map<C, V>> rowMap();

    @Override // f1.q
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // f1.q
    public final Iterator<V> valuesIterator() {
        throw new AssertionError("should never be called");
    }

    public final Object writeReplace() {
        return createSerializedForm();
    }

    public static <R, C, V> c4<R, C, V> of(R rowKey, C columnKey, V value) {
        return new m6(rowKey, columnKey, value);
    }

    @Override // f1.q
    public final x7<z6.a<R, C, V>> cellIterator() {
        throw new AssertionError("should never be called");
    }

    @Override // f1.q, f1.z6
    public t3<z6.a<R, C, V>> cellSet() {
        return (t3) super.cellSet();
    }

    @Override // f1.z6
    public k3<R, V> column(C columnKey) {
        c1.h0.F(columnKey, "columnKey");
        return (k3) c1.z.a((k3) columnMap().get(columnKey), k3.of());
    }

    @Override // f1.q, f1.z6
    public t3<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // f1.z6
    public k3<C, V> row(R rowKey) {
        c1.h0.F(rowKey, "rowKey");
        return (k3) c1.z.a((k3) rowMap().get(rowKey), k3.of());
    }

    @Override // f1.q, f1.z6
    public t3<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // f1.q, f1.z6
    public e3<V> values() {
        return (e3) super.values();
    }

    public static <R, C, V> c4<R, C, V> copyOf(Iterable<? extends z6.a<? extends R, ? extends C, ? extends V>> cells) {
        a aVarBuilder = builder();
        Iterator<? extends z6.a<? extends R, ? extends C, ? extends V>> it = cells.iterator();
        while (it.hasNext()) {
            aVarBuilder.f(it.next());
        }
        return aVarBuilder.b();
    }
}
