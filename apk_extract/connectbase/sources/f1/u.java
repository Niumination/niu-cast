package f1;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class u<R, C, V> extends q<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient u<R, C, V>.f f5376c;
    private final k3<C, Integer> columnKeyToIndex;
    private final i3<C> columnList;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient u<R, C, V>.h f5377d;
    private final k3<R, Integer> rowKeyToIndex;
    private final i3<R> rowList;

    public class a extends f1.b<z6.a<R, C, V>> {
        public a(int size) {
            super(size, 0);
        }

        @Override // f1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public z6.a<R, C, V> a(final int index) {
            return u.access$000(u.this, index);
        }
    }

    public class b extends m7.b<R, C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f5379a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5380b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f5381c;

        public b(final int val$index) {
            this.f5381c = val$index;
            this.f5379a = val$index / u.this.columnList.size();
            this.f5380b = val$index % u.this.columnList.size();
        }

        @Override // f1.z6.a
        public C getColumnKey() {
            return (C) u.this.columnList.get(this.f5380b);
        }

        @Override // f1.z6.a
        public R getRowKey() {
            return (R) u.this.rowList.get(this.f5379a);
        }

        @Override // f1.z6.a
        @gm.a
        public V getValue() {
            return (V) u.this.at(this.f5379a, this.f5380b);
        }
    }

    public class c extends f1.b<V> {
        public c(int size) {
            super(size, 0);
        }

        @Override // f1.b
        @gm.a
        public V a(int i10) {
            return (V) u.this.getValue(i10);
        }
    }

    public static abstract class d<K, V> extends t4.a0<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final k3<K, Integer> f5384a;

        public class a extends f1.g<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ int f5385a;

            public a(final int val$index) {
                this.f5385a = val$index;
            }

            @Override // f1.g, java.util.Map.Entry
            public K getKey() {
                return (K) d.this.d(this.f5385a);
            }

            @Override // f1.g, java.util.Map.Entry
            @m5
            public V getValue() {
                return (V) d.this.f(this.f5385a);
            }

            @Override // f1.g, java.util.Map.Entry
            @m5
            public V setValue(@m5 V v10) {
                return (V) d.this.g(this.f5385a, v10);
            }
        }

        public class b extends f1.b<Map.Entry<K, V>> {
            public b(int size) {
                super(size, 0);
            }

            @Override // f1.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a(final int index) {
                return d.this.c(index);
            }
        }

        public /* synthetic */ d(k3 k3Var, a aVar) {
            this(k3Var);
        }

        @Override // f1.t4.a0
        public Iterator<Map.Entry<K, V>> a() {
            return new b(size());
        }

        public Map.Entry<K, V> c(final int index) {
            c1.h0.C(index, size());
            return new a(index);
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@gm.a Object key) {
            return this.f5384a.containsKey(key);
        }

        public K d(int index) {
            return this.f5384a.keySet().asList().get(index);
        }

        public abstract String e();

        @m5
        public abstract V f(int index);

        @m5
        public abstract V g(int index, @m5 V newValue);

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            Integer num = this.f5384a.get(key);
            if (num == null) {
                return null;
            }
            return f(num.intValue());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            return this.f5384a.isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return this.f5384a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V put(K key, @m5 V value) {
            Integer num = this.f5384a.get(key);
            if (num != null) {
                return g(num.intValue(), value);
            }
            throw new IllegalArgumentException(e() + " " + key + " not in " + this.f5384a.keySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        @gm.a
        public V remove(@gm.a Object key) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.t4.a0, java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f5384a.size();
        }

        public d(k3<K, Integer> keyIndex) {
            this.f5384a = keyIndex;
        }
    }

    public class e extends d<R, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5388b;

        public e(int columnIndex) {
            super(u.this.rowKeyToIndex);
            this.f5388b = columnIndex;
        }

        @Override // f1.u.d
        public String e() {
            return "Row";
        }

        @Override // f1.u.d
        @gm.a
        public V f(int i10) {
            return (V) u.this.at(i10, this.f5388b);
        }

        @Override // f1.u.d
        @gm.a
        public V g(int i10, @gm.a V v10) {
            return (V) u.this.set(i10, this.f5388b, v10);
        }
    }

    public class f extends d<C, Map<R, V>> {
        public /* synthetic */ f(u uVar, a aVar) {
            this();
        }

        @Override // f1.u.d
        public String e() {
            return "Column";
        }

        @Override // f1.u.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<R, V> f(int index) {
            return new e(index);
        }

        @Override // f1.u.d, java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<R, V> put(C key, Map<R, V> value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.u.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map<R, V> g(int index, Map<R, V> newValue) {
            throw new UnsupportedOperationException();
        }

        public f() {
            super(u.this.columnKeyToIndex);
        }
    }

    public class g extends d<C, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f5391b;

        public g(int rowIndex) {
            super(u.this.columnKeyToIndex);
            this.f5391b = rowIndex;
        }

        @Override // f1.u.d
        public String e() {
            return "Column";
        }

        @Override // f1.u.d
        @gm.a
        public V f(int i10) {
            return (V) u.this.at(this.f5391b, i10);
        }

        @Override // f1.u.d
        @gm.a
        public V g(int i10, @gm.a V v10) {
            return (V) u.this.set(this.f5391b, i10, v10);
        }
    }

    public class h extends d<R, Map<C, V>> {
        public /* synthetic */ h(u uVar, a aVar) {
            this();
        }

        @Override // f1.u.d
        public String e() {
            return "Row";
        }

        @Override // f1.u.d
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Map<C, V> f(int index) {
            return new g(index);
        }

        @Override // f1.u.d, java.util.AbstractMap, java.util.Map
        @gm.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Map<C, V> put(R key, Map<C, V> value) {
            throw new UnsupportedOperationException();
        }

        @Override // f1.u.d
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Map<C, V> g(int index, Map<C, V> newValue) {
            throw new UnsupportedOperationException();
        }

        public h() {
            super(u.this.rowKeyToIndex);
        }
    }

    public u(Iterable<? extends R> iterable, Iterable<? extends C> iterable2) {
        i3<R> i3VarCopyOf = i3.copyOf(iterable);
        this.rowList = i3VarCopyOf;
        i3<C> i3VarCopyOf2 = i3.copyOf(iterable2);
        this.columnList = i3VarCopyOf2;
        c1.h0.d(i3VarCopyOf.isEmpty() == i3VarCopyOf2.isEmpty());
        this.rowKeyToIndex = t4.Q(i3VarCopyOf);
        this.columnKeyToIndex = t4.Q(i3VarCopyOf2);
        this.array = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, i3VarCopyOf.size(), i3VarCopyOf2.size()));
        eraseAll();
    }

    public static z6.a access$000(u uVar, int i10) {
        uVar.getClass();
        return new b(i10);
    }

    public static <R, C, V> u<R, C, V> create(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        return new u<>(rowKeys, columnKeys);
    }

    private z6.a<R, C, V> getCell(final int index) {
        return new b(index);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @gm.a
    public V getValue(int index) {
        return at(index / this.columnList.size(), index % this.columnList.size());
    }

    @gm.a
    public V at(int rowIndex, int columnIndex) {
        c1.h0.C(rowIndex, this.rowList.size());
        c1.h0.C(columnIndex, this.columnList.size());
        return this.array[rowIndex][columnIndex];
    }

    @Override // f1.q
    public Iterator<z6.a<R, C, V>> cellIterator() {
        return new a(size());
    }

    @Override // f1.q, f1.z6
    public Set<z6.a<R, C, V>> cellSet() {
        return super.cellSet();
    }

    @Override // f1.q, f1.z6
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // f1.z6
    public Map<R, V> column(C columnKey) {
        columnKey.getClass();
        Integer num = this.columnKeyToIndex.get(columnKey);
        return num == null ? Collections.emptyMap() : new e(num.intValue());
    }

    public i3<C> columnKeyList() {
        return this.columnList;
    }

    @Override // f1.z6
    public Map<C, Map<R, V>> columnMap() {
        u<R, C, V>.f fVar = this.f5376c;
        if (fVar != null) {
            return fVar;
        }
        u<R, C, V>.f fVar2 = new f();
        this.f5376c = fVar2;
        return fVar2;
    }

    @Override // f1.q, f1.z6
    public boolean contains(@gm.a Object rowKey, @gm.a Object columnKey) {
        return containsRow(rowKey) && containsColumn(columnKey);
    }

    @Override // f1.q, f1.z6
    public boolean containsColumn(@gm.a Object columnKey) {
        return this.columnKeyToIndex.containsKey(columnKey);
    }

    @Override // f1.q, f1.z6
    public boolean containsRow(@gm.a Object rowKey) {
        return this.rowKeyToIndex.containsKey(rowKey);
    }

    @Override // f1.q, f1.z6
    public boolean containsValue(@gm.a Object value) {
        for (V[] vArr : this.array) {
            for (V v10 : vArr) {
                if (c1.b0.a(value, v10)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object obj) {
        return super.equals(obj);
    }

    @gm.a
    @t1.a
    public V erase(@gm.a Object rowKey, @gm.a Object columnKey) {
        Integer num = this.rowKeyToIndex.get(rowKey);
        Integer num2 = this.columnKeyToIndex.get(columnKey);
        if (num == null || num2 == null) {
            return null;
        }
        return set(num.intValue(), num2.intValue(), null);
    }

    public void eraseAll() {
        for (V[] vArr : this.array) {
            Arrays.fill(vArr, (Object) null);
        }
    }

    @Override // f1.q, f1.z6
    @gm.a
    public V get(@gm.a Object rowKey, @gm.a Object columnKey) {
        Integer num = this.rowKeyToIndex.get(rowKey);
        Integer num2 = this.columnKeyToIndex.get(columnKey);
        if (num == null || num2 == null) {
            return null;
        }
        return at(num.intValue(), num2.intValue());
    }

    @Override // f1.q, f1.z6
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // f1.q, f1.z6
    public boolean isEmpty() {
        return this.rowList.isEmpty() || this.columnList.isEmpty();
    }

    @Override // f1.q, f1.z6
    @gm.a
    @t1.a
    public V put(R rowKey, C columnKey, @gm.a V value) {
        rowKey.getClass();
        columnKey.getClass();
        Integer num = this.rowKeyToIndex.get(rowKey);
        c1.h0.y(num != null, "Row %s not in %s", rowKey, this.rowList);
        Integer num2 = this.columnKeyToIndex.get(columnKey);
        c1.h0.y(num2 != null, "Column %s not in %s", columnKey, this.columnList);
        return set(num.intValue(), num2.intValue(), value);
    }

    @Override // f1.q, f1.z6
    public void putAll(z6<? extends R, ? extends C, ? extends V> table) {
        super.putAll(table);
    }

    @Override // f1.q, f1.z6
    @gm.a
    @t1.a
    @Deprecated
    @t1.e("Always throws UnsupportedOperationException")
    public V remove(@gm.a Object rowKey, @gm.a Object columnKey) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.z6
    public Map<C, V> row(R rowKey) {
        rowKey.getClass();
        Integer num = this.rowKeyToIndex.get(rowKey);
        return num == null ? Collections.emptyMap() : new g(num.intValue());
    }

    public i3<R> rowKeyList() {
        return this.rowList;
    }

    @Override // f1.z6
    public Map<R, Map<C, V>> rowMap() {
        u<R, C, V>.h hVar = this.f5377d;
        if (hVar != null) {
            return hVar;
        }
        u<R, C, V>.h hVar2 = new h();
        this.f5377d = hVar2;
        return hVar2;
    }

    @gm.a
    @t1.a
    public V set(int rowIndex, int columnIndex, @gm.a V value) {
        c1.h0.C(rowIndex, this.rowList.size());
        c1.h0.C(columnIndex, this.columnList.size());
        V[] vArr = this.array[rowIndex];
        V v10 = vArr[columnIndex];
        vArr[columnIndex] = value;
        return v10;
    }

    @Override // f1.z6
    public int size() {
        return this.columnList.size() * this.rowList.size();
    }

    @b1.c
    public V[][] toArray(Class<V> cls) {
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) cls, this.rowList.size(), this.columnList.size()));
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[] vArr2 = this.array[i10];
            System.arraycopy(vArr2, 0, vArr[i10], 0, vArr2.length);
        }
        return vArr;
    }

    @Override // f1.q
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // f1.q, f1.z6
    public Collection<V> values() {
        return super.values();
    }

    @Override // f1.q
    public Iterator<V> valuesIterator() {
        return new c(size());
    }

    public static <R, C, V> u<R, C, V> create(z6<R, C, ? extends V> table) {
        return table instanceof u ? new u<>((u) table) : new u<>(table);
    }

    @Override // f1.q, f1.z6
    public t3<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    @Override // f1.q, f1.z6
    public t3<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(z6<R, C, ? extends V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    public u(u<R, C, V> uVar) {
        i3<R> i3Var = uVar.rowList;
        this.rowList = i3Var;
        i3<C> i3Var2 = uVar.columnList;
        this.columnList = i3Var2;
        this.rowKeyToIndex = uVar.rowKeyToIndex;
        this.columnKeyToIndex = uVar.columnKeyToIndex;
        V[][] vArr = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, i3Var.size(), i3Var2.size()));
        this.array = vArr;
        for (int i10 = 0; i10 < this.rowList.size(); i10++) {
            V[] vArr2 = uVar.array[i10];
            System.arraycopy(vArr2, 0, vArr[i10], 0, vArr2.length);
        }
    }
}
