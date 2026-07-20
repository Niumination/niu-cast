package f1;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public class u2<R, C, V> extends x6<R, C, V> {
    private static final long serialVersionUID = 0;

    public static class a<C, V> implements c1.q0<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final int expectedSize;

        public a(int expectedSize) {
            this.expectedSize = expectedSize;
        }

        @Override // c1.q0
        public Map<C, V> get() {
            return t4.e0(this.expectedSize);
        }
    }

    public u2(Map<R, Map<C, V>> backingMap, a<C, V> factory) {
        super(backingMap, factory);
    }

    public static <R, C, V> u2<R, C, V> create() {
        return new u2<>(new LinkedHashMap(), new a(0));
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.x6, f1.z6
    public /* bridge */ /* synthetic */ Map column(Object columnKey) {
        return super.column(columnKey);
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // f1.x6, f1.z6
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
        return super.contains(rowKey, columnKey);
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean containsColumn(@gm.a Object columnKey) {
        return super.containsColumn(columnKey);
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean containsRow(@gm.a Object rowKey) {
        return super.containsRow(rowKey);
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean containsValue(@gm.a Object value) {
        return super.containsValue(value);
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object obj) {
        return super.equals(obj);
    }

    @Override // f1.x6, f1.q, f1.z6
    @gm.a
    public /* bridge */ /* synthetic */ Object get(@gm.a Object rowKey, @gm.a Object columnKey) {
        return super.get(rowKey, columnKey);
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.x6, f1.q, f1.z6
    @gm.a
    @t1.a
    public /* bridge */ /* synthetic */ Object put(Object rowKey, Object columnKey, Object value) {
        return super.put(rowKey, columnKey, value);
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ void putAll(z6 table) {
        super.putAll(table);
    }

    @Override // f1.x6, f1.q, f1.z6
    @gm.a
    @t1.a
    public /* bridge */ /* synthetic */ Object remove(@gm.a Object rowKey, @gm.a Object columnKey) {
        return super.remove(rowKey, columnKey);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.x6, f1.z6
    public /* bridge */ /* synthetic */ Map row(Object rowKey) {
        return super.row(rowKey);
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // f1.x6, f1.z6
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
    }

    @Override // f1.x6, f1.z6
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // f1.q
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // f1.x6, f1.q, f1.z6
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> u2<R, C, V> create(int expectedRows, int expectedCellsPerRow) {
        b0.b(expectedCellsPerRow, "expectedCellsPerRow");
        return new u2<>(t4.e0(expectedRows), new a(expectedCellsPerRow));
    }

    public static <R, C, V> u2<R, C, V> create(z6<? extends R, ? extends C, ? extends V> table) {
        u2<R, C, V> u2VarCreate = create();
        u2VarCreate.putAll(table);
        return u2VarCreate;
    }
}
