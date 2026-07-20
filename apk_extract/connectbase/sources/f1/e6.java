package f1;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class e6<R, C, V> extends c4<R, C, V> {

    public final class b extends d4<z6.a<R, C, V>> {
        public b() {
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object object) {
            if (!(object instanceof z6.a)) {
                return false;
            }
            z6.a aVar = (z6.a) object;
            Object obj = e6.this.get(aVar.getRowKey(), aVar.getColumnKey());
            return obj != null && obj.equals(aVar.getValue());
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e6.this.size();
        }

        @Override // f1.d4
        public z6.a<R, C, V> get(int index) {
            return e6.this.getCell(index);
        }
    }

    public final class c extends i3<V> {
        public c() {
        }

        @Override // java.util.List
        public V get(int i10) {
            return (V) e6.this.getValue(i10);
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return e6.this.size();
        }
    }

    public static <R, C, V> e6<R, C, V> b(Iterable<z6.a<R, C, V>> cells, @gm.a Comparator<? super R> rowComparator, @gm.a Comparator<? super C> columnComparator) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashSet linkedHashSet2 = new LinkedHashSet();
        i3 i3VarCopyOf = i3.copyOf(cells);
        for (z6.a<R, C, V> aVar : cells) {
            linkedHashSet.add(aVar.getRowKey());
            linkedHashSet2.add(aVar.getColumnKey());
        }
        return forOrderedComponents(i3VarCopyOf, rowComparator == null ? t3.copyOf((Collection) linkedHashSet) : t3.copyOf((Collection) i3.sortedCopyOf(rowComparator, linkedHashSet)), columnComparator == null ? t3.copyOf((Collection) linkedHashSet2) : t3.copyOf((Collection) i3.sortedCopyOf(columnComparator, linkedHashSet2)));
    }

    public static /* synthetic */ int c(Comparator comparator, Comparator comparator2, z6.a aVar, z6.a aVar2) {
        int iCompare = comparator == null ? 0 : comparator.compare(aVar.getRowKey(), aVar2.getRowKey());
        if (iCompare != 0) {
            return iCompare;
        }
        if (comparator2 == null) {
            return 0;
        }
        return comparator2.compare(aVar.getColumnKey(), aVar2.getColumnKey());
    }

    public static <R, C, V> e6<R, C, V> forCells(Iterable<z6.a<R, C, V>> cells) {
        return b(cells, null, null);
    }

    public static <R, C, V> e6<R, C, V> forOrderedComponents(i3<z6.a<R, C, V>> cellList, t3<R> rowSpace, t3<C> columnSpace) {
        return ((long) cellList.size()) > (((long) rowSpace.size()) * ((long) columnSpace.size())) / 2 ? new s0(cellList, rowSpace, columnSpace) : new v6(cellList, rowSpace, columnSpace);
    }

    public final void checkNoDuplicate(R rowKey, C columnKey, @gm.a V existingValue, V newValue) {
        c1.h0.A(existingValue == null, "Duplicate key: (row=%s, column=%s), values: [%s, %s].", rowKey, columnKey, newValue, existingValue);
    }

    public abstract z6.a<R, C, V> getCell(int iterationIndex);

    public abstract V getValue(int iterationIndex);

    public static <R, C, V> e6<R, C, V> forCells(List<z6.a<R, C, V>> cells, @gm.a final Comparator<? super R> rowComparator, @gm.a final Comparator<? super C> columnComparator) {
        cells.getClass();
        if (rowComparator != null || columnComparator != null) {
            Collections.sort(cells, new Comparator() { // from class: f1.d6
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return e6.c(rowComparator, columnComparator, (z6.a) obj, (z6.a) obj2);
                }
            });
        }
        return b(cells, rowComparator, columnComparator);
    }

    @Override // f1.c4, f1.q
    public final t3<z6.a<R, C, V>> createCellSet() {
        return isEmpty() ? t3.of() : new b();
    }

    @Override // f1.c4, f1.q
    public final e3<V> createValues() {
        return isEmpty() ? i3.of() : new c();
    }
}
