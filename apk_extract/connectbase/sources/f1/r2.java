package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class r2<R, C, V> extends j2 implements z6<R, C, V> {
    public Set<z6.a<R, C, V>> cellSet() {
        return delegate().cellSet();
    }

    public void clear() {
        delegate().clear();
    }

    public Map<R, V> column(@m5 C columnKey) {
        return delegate().column(columnKey);
    }

    public Set<C> columnKeySet() {
        return delegate().columnKeySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        return delegate().columnMap();
    }

    @Override // f1.z6
    public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
        return delegate().contains(rowKey, columnKey);
    }

    @Override // f1.z6
    public boolean containsColumn(@gm.a Object columnKey) {
        return delegate().containsColumn(columnKey);
    }

    @Override // f1.z6
    public boolean containsRow(@gm.a Object rowKey) {
        return delegate().containsRow(rowKey);
    }

    @Override // f1.z6
    public boolean containsValue(@gm.a Object value) {
        return delegate().containsValue(value);
    }

    @Override // f1.j2
    public abstract z6<R, C, V> delegate();

    @Override // f1.z6
    public boolean equals(@gm.a Object obj) {
        return obj == this || delegate().equals(obj);
    }

    @Override // f1.z6
    @gm.a
    public V get(@gm.a Object rowKey, @gm.a Object columnKey) {
        return delegate().get(rowKey, columnKey);
    }

    @Override // f1.z6
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // f1.z6
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @gm.a
    @t1.a
    public V put(@m5 R rowKey, @m5 C columnKey, @m5 V value) {
        return delegate().put(rowKey, columnKey, value);
    }

    public void putAll(z6<? extends R, ? extends C, ? extends V> table) {
        delegate().putAll(table);
    }

    @gm.a
    @t1.a
    public V remove(@gm.a Object rowKey, @gm.a Object columnKey) {
        return delegate().remove(rowKey, columnKey);
    }

    public Map<C, V> row(@m5 R rowKey) {
        return delegate().row(rowKey);
    }

    public Set<R> rowKeySet() {
        return delegate().rowKeySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        return delegate().rowMap();
    }

    @Override // f1.z6
    public int size() {
        return delegate().size();
    }

    public Collection<V> values() {
        return delegate().values();
    }
}
