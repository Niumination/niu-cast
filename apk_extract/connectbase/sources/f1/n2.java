package f1;

import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class n2<K, V> extends d2<K, V> implements SortedMap<K, V> {

    public class a extends t4.g0<K, V> {
        public a(final n2 this$0) {
            super((Map) this$0);
        }
    }

    public static int unsafeCompare(@gm.a Comparator<?> comparator, @gm.a Object o10, @gm.a Object o11) {
        return comparator == null ? ((Comparable) o10).compareTo(o11) : comparator.compare(o10, o11);
    }

    @Override // java.util.SortedMap
    @gm.a
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    @Override // f1.d2, f1.j2
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    @m5
    public K firstKey() {
        return delegate().firstKey();
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(@m5 K toKey) {
        return delegate().headMap(toKey);
    }

    @Override // java.util.SortedMap
    @m5
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.d2
    public boolean standardContainsKey(@gm.a Object key) {
        try {
            return unsafeCompare(comparator(), tailMap(key).firstKey(), key) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    public SortedMap<K, V> standardSubMap(K fromKey, K toKey) {
        c1.h0.e(unsafeCompare(comparator(), fromKey, toKey) <= 0, "fromKey must be <= toKey");
        return tailMap(fromKey).headMap(toKey);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(@m5 K fromKey, @m5 K toKey) {
        return delegate().subMap(fromKey, toKey);
    }

    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(@m5 K fromKey) {
        return delegate().tailMap(fromKey);
    }
}
