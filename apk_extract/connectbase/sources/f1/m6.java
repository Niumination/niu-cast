package f1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public class m6<R, C, V> extends c4<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    public m6(R rowKey, C columnKey, V value) {
        rowKey.getClass();
        this.singleRowKey = rowKey;
        columnKey.getClass();
        this.singleColumnKey = columnKey;
        value.getClass();
        this.singleValue = value;
    }

    @Override // f1.c4
    public c4.b createSerializedForm() {
        return c4.b.create(this, new int[]{0}, new int[]{0});
    }

    @Override // f1.z6
    public int size() {
        return 1;
    }

    @Override // f1.c4, f1.z6
    public k3<R, V> column(C columnKey) {
        columnKey.getClass();
        return containsColumn(columnKey) ? k3.of(this.singleRowKey, (Object) this.singleValue) : k3.of();
    }

    @Override // f1.c4, f1.z6
    public k3<C, Map<R, V>> columnMap() {
        return k3.of(this.singleColumnKey, k3.of(this.singleRowKey, (Object) this.singleValue));
    }

    @Override // f1.c4, f1.q
    public t3<z6.a<R, C, V>> createCellSet() {
        return t3.of(c4.cellOf(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    @Override // f1.c4, f1.q
    public e3<V> createValues() {
        return t3.of(this.singleValue);
    }

    @Override // f1.c4, f1.z6
    public k3<R, Map<C, V>> rowMap() {
        return k3.of(this.singleRowKey, k3.of(this.singleColumnKey, (Object) this.singleValue));
    }

    public m6(z6.a<R, C, V> cell) {
        this(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }
}
