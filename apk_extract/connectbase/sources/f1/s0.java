package f1;

import java.lang.reflect.Array;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.j(containerOf = {"R", "C", "V"})
public final class s0<R, C, V> extends e6<R, C, V> {
    private final int[] cellColumnIndices;
    private final int[] cellRowIndices;
    private final int[] columnCounts;
    private final k3<C, Integer> columnKeyToIndex;
    private final k3<C, k3<R, V>> columnMap;
    private final int[] rowCounts;
    private final k3<R, Integer> rowKeyToIndex;
    private final k3<R, k3<C, V>> rowMap;
    private final V[][] values;

    public final class b extends d<R, V> {
        private final int columnIndex;

        public b(int columnIndex) {
            super(s0.this.columnCounts[columnIndex]);
            this.columnIndex = columnIndex;
        }

        @Override // f1.s0.d
        @gm.a
        public V getValue(int i10) {
            return (V) s0.this.values[i10][this.columnIndex];
        }

        @Override // f1.k3
        public boolean isPartialView() {
            return true;
        }

        @Override // f1.s0.d
        public k3<R, Integer> keyToIndex() {
            return s0.this.rowKeyToIndex;
        }
    }

    public final class c extends d<C, k3<R, V>> {
        @Override // f1.k3
        public boolean isPartialView() {
            return false;
        }

        @Override // f1.s0.d
        public k3<C, Integer> keyToIndex() {
            return s0.this.columnKeyToIndex;
        }

        public c() {
            super(s0.this.columnCounts.length);
        }

        @Override // f1.s0.d
        public k3<R, V> getValue(int keyIndex) {
            return new b(keyIndex);
        }
    }

    public static abstract class d<K, V> extends k3.c<K, V> {
        private final int size;

        public class a extends f1.c<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f5235c = -1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f5236d;

            public a() {
                this.f5236d = d.this.keyToIndex().size();
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry<K, V> a() {
                int i10 = this.f5235c;
                while (true) {
                    this.f5235c = i10 + 1;
                    int i11 = this.f5235c;
                    if (i11 >= this.f5236d) {
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    Object value = d.this.getValue(i11);
                    if (value != null) {
                        return new f3(d.this.getKey(this.f5235c), value);
                    }
                    i10 = this.f5235c;
                }
            }
        }

        public d(int size) {
            this.size = size;
        }

        public final boolean a() {
            return this.size == keyToIndex().size();
        }

        @Override // f1.k3.c, f1.k3
        public t3<K> createKeySet() {
            return a() ? keyToIndex().keySet() : super.createKeySet();
        }

        @Override // f1.k3.c
        public x7<Map.Entry<K, V>> entryIterator() {
            return new a();
        }

        @Override // f1.k3, java.util.Map
        @gm.a
        public V get(@gm.a Object key) {
            Integer num = keyToIndex().get(key);
            if (num == null) {
                return null;
            }
            return getValue(num.intValue());
        }

        public K getKey(int index) {
            return keyToIndex().keySet().asList().get(index);
        }

        @gm.a
        public abstract V getValue(int keyIndex);

        public abstract k3<K, Integer> keyToIndex();

        @Override // java.util.Map
        public int size() {
            return this.size;
        }
    }

    public final class e extends d<C, V> {
        private final int rowIndex;

        public e(int rowIndex) {
            super(s0.this.rowCounts[rowIndex]);
            this.rowIndex = rowIndex;
        }

        @Override // f1.s0.d
        @gm.a
        public V getValue(int i10) {
            return (V) s0.this.values[this.rowIndex][i10];
        }

        @Override // f1.k3
        public boolean isPartialView() {
            return true;
        }

        @Override // f1.s0.d
        public k3<C, Integer> keyToIndex() {
            return s0.this.columnKeyToIndex;
        }
    }

    public final class f extends d<R, k3<C, V>> {
        @Override // f1.k3
        public boolean isPartialView() {
            return false;
        }

        @Override // f1.s0.d
        public k3<R, Integer> keyToIndex() {
            return s0.this.rowKeyToIndex;
        }

        public f() {
            super(s0.this.rowCounts.length);
        }

        @Override // f1.s0.d
        public k3<C, V> getValue(int keyIndex) {
            return new e(keyIndex);
        }
    }

    public s0(i3<z6.a<R, C, V>> i3Var, t3<R> t3Var, t3<C> t3Var2) {
        this.values = (V[][]) ((Object[][]) Array.newInstance((Class<?>) Object.class, t3Var.size(), t3Var2.size()));
        k3<R, Integer> k3VarQ = t4.Q(t3Var);
        this.rowKeyToIndex = k3VarQ;
        k3<C, Integer> k3VarQ2 = t4.Q(t3Var2);
        this.columnKeyToIndex = k3VarQ2;
        this.rowCounts = new int[k3VarQ.size()];
        this.columnCounts = new int[k3VarQ2.size()];
        int[] iArr = new int[i3Var.size()];
        int[] iArr2 = new int[i3Var.size()];
        for (int i10 = 0; i10 < i3Var.size(); i10++) {
            z6.a<R, C, V> aVar = i3Var.get(i10);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            Integer num = this.rowKeyToIndex.get(rowKey);
            Objects.requireNonNull(num);
            int iIntValue = num.intValue();
            Integer num2 = this.columnKeyToIndex.get(columnKey);
            Objects.requireNonNull(num2);
            int iIntValue2 = num2.intValue();
            checkNoDuplicate(rowKey, columnKey, this.values[iIntValue][iIntValue2], aVar.getValue());
            this.values[iIntValue][iIntValue2] = aVar.getValue();
            int[] iArr3 = this.rowCounts;
            iArr3[iIntValue] = iArr3[iIntValue] + 1;
            int[] iArr4 = this.columnCounts;
            iArr4[iIntValue2] = iArr4[iIntValue2] + 1;
            iArr[i10] = iIntValue;
            iArr2[i10] = iIntValue2;
        }
        this.cellRowIndices = iArr;
        this.cellColumnIndices = iArr2;
        this.rowMap = new f();
        this.columnMap = new c();
    }

    @Override // f1.c4
    public c4.b createSerializedForm() {
        return c4.b.create(this, this.cellRowIndices, this.cellColumnIndices);
    }

    @Override // f1.c4, f1.q, f1.z6
    @gm.a
    public V get(@gm.a Object rowKey, @gm.a Object columnKey) {
        Integer num = this.rowKeyToIndex.get(rowKey);
        Integer num2 = this.columnKeyToIndex.get(columnKey);
        if (num == null || num2 == null) {
            return null;
        }
        return this.values[num.intValue()][num2.intValue()];
    }

    @Override // f1.e6
    public z6.a<R, C, V> getCell(int index) {
        int i10 = this.cellRowIndices[index];
        int i11 = this.cellColumnIndices[index];
        R r10 = rowKeySet().asList().get(i10);
        C c10 = columnKeySet().asList().get(i11);
        V v10 = this.values[i10][i11];
        Objects.requireNonNull(v10);
        return c4.cellOf(r10, c10, v10);
    }

    @Override // f1.e6
    public V getValue(int index) {
        V v10 = this.values[this.cellRowIndices[index]][this.cellColumnIndices[index]];
        Objects.requireNonNull(v10);
        return v10;
    }

    @Override // f1.z6
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // f1.c4, f1.z6
    public k3<C, Map<R, V>> columnMap() {
        return k3.copyOf((Map) this.columnMap);
    }

    @Override // f1.c4, f1.z6
    public k3<R, Map<C, V>> rowMap() {
        return k3.copyOf((Map) this.rowMap);
    }
}
