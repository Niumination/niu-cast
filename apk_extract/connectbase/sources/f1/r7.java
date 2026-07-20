package f1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public class r7<R, C, V> extends w6<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    public class a extends f1.c<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public C f5227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Iterator f5228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Comparator f5229e;

        public a(final r7 this$0, final Iterator val$merged, final Comparator val$comparator) {
            this.f5228d = val$merged;
            this.f5229e = val$comparator;
        }

        @Override // f1.c
        @gm.a
        public C a() {
            while (this.f5228d.hasNext()) {
                C c10 = (C) this.f5228d.next();
                C c11 = this.f5227c;
                if (c11 == null || this.f5229e.compare(c10, c11) != 0) {
                    this.f5227c = c10;
                    return c10;
                }
            }
            this.f5227c = null;
            this.f4711a = f1.c.b.DONE;
            return null;
        }
    }

    public static class b<C, V> implements c1.q0<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        public b(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        @Override // c1.q0
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    public class c extends x6<R, C, V>.g implements SortedMap<C, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public final C f5230d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @gm.a
        public final C f5231e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @gm.a
        public transient SortedMap<C, V> f5232f;

        public c(final r7 this$0, R rowKey) {
            this(rowKey, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return r7.this.columnComparator();
        }

        @Override // f1.x6.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return j(key) && super.containsKey(key);
        }

        @Override // f1.x6.g
        public void d() {
            l();
            SortedMap<C, V> sortedMap = this.f5232f;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            r7.this.backingMap.remove(this.f5591a);
            this.f5232f = null;
            this.f5592b = null;
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            e();
            Map<C, V> map = this.f5592b;
            if (map != null) {
                return (C) ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        public int g(Object a10, Object b10) {
            return comparator().compare(a10, b10);
        }

        @Override // f1.x6.g
        @gm.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedMap<C, V> c() {
            l();
            SortedMap<C, V> sortedMapTailMap = this.f5232f;
            if (sortedMapTailMap == null) {
                return null;
            }
            C c10 = this.f5230d;
            if (c10 != null) {
                sortedMapTailMap = sortedMapTailMap.tailMap(c10);
            }
            C c11 = this.f5231e;
            return c11 != null ? sortedMapTailMap.headMap(c11) : sortedMapTailMap;
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C toKey) {
            toKey.getClass();
            c1.h0.d(j(toKey));
            return new c(this.f5591a, this.f5230d, toKey);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedSet<C> keySet() {
            return new t4.g0((Map) this);
        }

        public boolean j(@gm.a Object o10) {
            C c10;
            C c11;
            return o10 != null && ((c10 = this.f5230d) == null || g(c10, o10) <= 0) && ((c11 = this.f5231e) == null || g(c11, o10) > 0);
        }

        public void l() {
            SortedMap<C, V> sortedMap = this.f5232f;
            if (sortedMap == null || (sortedMap.isEmpty() && r7.this.backingMap.containsKey(this.f5591a))) {
                this.f5232f = (SortedMap) r7.this.backingMap.get(this.f5591a);
            }
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            e();
            Map<C, V> map = this.f5592b;
            if (map != null) {
                return (C) ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // f1.x6.g, java.util.AbstractMap, java.util.Map
        @gm.a
        public V put(C c10, V v10) {
            c10.getClass();
            c1.h0.d(j(c10));
            return (V) super.put(c10, v10);
        }

        /* JADX WARN: Code duplicated, block: B:7:0x0014  */
        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C fromKey, C toKey) {
            boolean z10;
            fromKey.getClass();
            if (j(fromKey)) {
                toKey.getClass();
                if (j(toKey)) {
                    z10 = true;
                } else {
                    z10 = false;
                }
            } else {
                z10 = false;
            }
            c1.h0.d(z10);
            return new c(this.f5591a, fromKey, toKey);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C fromKey) {
            fromKey.getClass();
            c1.h0.d(j(fromKey));
            return new c(this.f5591a, fromKey, this.f5231e);
        }

        public c(@gm.a R rowKey, @gm.a C lowerBound, C upperBound) {
            super(rowKey);
            this.f5230d = lowerBound;
            this.f5231e = upperBound;
            c1.h0.d(lowerBound == null || upperBound == null || g(lowerBound, upperBound) <= 0);
        }
    }

    public r7(Comparator<? super R> rowComparator, Comparator<? super C> columnComparator) {
        super(new TreeMap(rowComparator), new b(columnComparator));
        this.columnComparator = columnComparator;
    }

    public static <R extends Comparable, C extends Comparable, V> r7<R, C, V> create() {
        return new r7<>(l5.natural(), l5.natural());
    }

    public static /* synthetic */ Iterator g(Map map) {
        return map.keySet().iterator();
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

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
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

    @Override // f1.x6
    public Iterator<C> createColumnKeyIterator() {
        Comparator<? super C> comparatorColumnComparator = columnComparator();
        return new a(this, h4.O(g4.T(this.backingMap.values(), new q7()), comparatorColumnComparator), comparatorColumnComparator);
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

    @Deprecated
    public Comparator<? super R> rowComparator() {
        Comparator<? super R> comparator = rowKeySet().comparator();
        Objects.requireNonNull(comparator);
        return comparator;
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

    public static <R, C, V> r7<R, C, V> create(r7<R, C, ? extends V> table) {
        r7<R, C, V> r7Var = new r7<>(table.rowComparator(), table.columnComparator());
        r7Var.putAll(table);
        return r7Var;
    }

    @Override // f1.x6, f1.z6
    public SortedMap<C, V> row(R rowKey) {
        return new c(rowKey, null, null);
    }

    @Override // f1.w6, f1.x6, f1.q, f1.z6
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // f1.w6, f1.x6, f1.z6
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> r7<R, C, V> create(Comparator<? super R> rowComparator, Comparator<? super C> columnComparator) {
        rowComparator.getClass();
        columnComparator.getClass();
        return new r7<>(rowComparator, columnComparator);
    }
}
