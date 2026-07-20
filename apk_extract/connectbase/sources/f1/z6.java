package f1;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.f("Use ImmutableTable, HashBasedTable, or another implementation")
public interface z6<R, C, V> {

    public interface a<R, C, V> {
        boolean equals(@gm.a Object obj);

        @m5
        C getColumnKey();

        @m5
        R getRowKey();

        @m5
        V getValue();

        int hashCode();
    }

    Set<a<R, C, V>> cellSet();

    void clear();

    Map<R, V> column(@m5 C columnKey);

    Set<C> columnKeySet();

    Map<C, Map<R, V>> columnMap();

    boolean contains(@gm.a @t1.c("R") Object rowKey, @gm.a @t1.c("C") Object columnKey);

    boolean containsColumn(@gm.a @t1.c("C") Object columnKey);

    boolean containsRow(@gm.a @t1.c("R") Object rowKey);

    boolean containsValue(@gm.a @t1.c("V") Object value);

    boolean equals(@gm.a Object obj);

    @gm.a
    V get(@gm.a @t1.c("R") Object rowKey, @gm.a @t1.c("C") Object columnKey);

    int hashCode();

    boolean isEmpty();

    @gm.a
    @t1.a
    V put(@m5 R rowKey, @m5 C columnKey, @m5 V value);

    void putAll(z6<? extends R, ? extends C, ? extends V> table);

    @gm.a
    @t1.a
    V remove(@gm.a @t1.c("R") Object rowKey, @gm.a @t1.c("C") Object columnKey);

    Map<C, V> row(@m5 R rowKey);

    Set<R> rowKeySet();

    Map<R, Map<C, V>> rowMap();

    int size();

    Collection<V> values();
}
