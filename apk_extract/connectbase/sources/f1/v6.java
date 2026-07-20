package f1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.j(containerOf = {"R", "C", "V"})
public final class v6<R, C, V> extends e6<R, C, V> {
    static final c4<Object, Object, Object> EMPTY = new v6(i3.of(), t3.of(), t3.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final k3<C, k3<R, V>> columnMap;
    private final k3<R, k3<C, V>> rowMap;

    /* JADX WARN: Multi-variable type inference failed */
    public v6(i3<z6.a<R, C, V>> i3Var, t3<R> t3Var, t3<C> t3Var2) {
        k3 k3VarQ = t4.Q(t3Var);
        LinkedHashMap linkedHashMapC0 = t4.c0();
        x7<R> it = t3Var.iterator();
        while (it.hasNext()) {
            linkedHashMapC0.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap linkedHashMapC1 = t4.c0();
        x7<C> it2 = t3Var2.iterator();
        while (it2.hasNext()) {
            linkedHashMapC1.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[i3Var.size()];
        int[] iArr2 = new int[i3Var.size()];
        for (int i10 = 0; i10 < i3Var.size(); i10++) {
            z6.a<R, C, V> aVar = i3Var.get(i10);
            R rowKey = aVar.getRowKey();
            C columnKey = aVar.getColumnKey();
            V value = aVar.getValue();
            Integer num = (Integer) k3VarQ.get(rowKey);
            Objects.requireNonNull(num);
            iArr[i10] = num.intValue();
            Map map = (Map) linkedHashMapC0.get(rowKey);
            Objects.requireNonNull(map);
            Map map2 = map;
            iArr2[i10] = map2.size();
            checkNoDuplicate(rowKey, columnKey, map2.put(columnKey, value), value);
            Map map3 = (Map) linkedHashMapC1.get(columnKey);
            Objects.requireNonNull(map3);
            map3.put(rowKey, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        k3.b bVar = new k3.b(linkedHashMapC0.size());
        for (Map.Entry entry : linkedHashMapC0.entrySet()) {
            bVar.i(entry.getKey(), k3.copyOf((Map) entry.getValue()));
        }
        this.rowMap = bVar.d();
        k3.b bVar2 = new k3.b(linkedHashMapC1.size());
        for (Map.Entry entry2 : linkedHashMapC1.entrySet()) {
            bVar2.i(entry2.getKey(), k3.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = bVar2.d();
    }

    @Override // f1.c4
    public c4.b createSerializedForm() {
        k3 k3VarQ = t4.Q(columnKeySet());
        int[] iArr = new int[cellSet().size()];
        x7<z6.a<R, C, V>> it = cellSet().iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Integer num = (Integer) k3VarQ.get(it.next().getColumnKey());
            Objects.requireNonNull(num);
            iArr[i10] = num.intValue();
            i10++;
        }
        return c4.b.create(this, this.cellRowIndices, iArr);
    }

    @Override // f1.e6
    public z6.a<R, C, V> getCell(int index) {
        Map.Entry<R, k3<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[index]);
        k3<C, V> value = entry.getValue();
        Map.Entry<C, V> entry2 = value.entrySet().asList().get(this.cellColumnInRowIndices[index]);
        return c4.cellOf(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // f1.e6
    public V getValue(int index) {
        k3<C, V> k3Var = this.rowMap.values().asList().get(this.cellRowIndices[index]);
        return k3Var.values().asList().get(this.cellColumnInRowIndices[index]);
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
