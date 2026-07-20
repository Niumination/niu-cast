package f1;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public class w6<R, C, V> extends x6<R, C, V> implements h6<R, C, V> {
    private static final long serialVersionUID = 0;

    public class b extends x6<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        public b() {
            super();
        }

        @Override // java.util.SortedMap
        @gm.a
        public Comparator<? super R> comparator() {
            return w6.access$100(w6.this).comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) w6.access$100(w6.this).firstKey();
        }

        @Override // f1.t4.r0
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> h() {
            return new t4.g0((Map) this);
        }

        @Override // f1.t4.r0, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public SortedSet<R> i() {
            return (SortedSet) super.i();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R toKey) {
            toKey.getClass();
            return new w6(w6.access$100(w6.this).headMap(toKey), w6.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) w6.access$100(w6.this).lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R fromKey, R toKey) {
            fromKey.getClass();
            toKey.getClass();
            return new w6(w6.access$100(w6.this).subMap(fromKey, toKey), w6.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R fromKey) {
            fromKey.getClass();
            return new w6(w6.access$100(w6.this).tailMap(fromKey), w6.this.factory).rowMap();
        }
    }

    public w6(SortedMap<R, Map<C, V>> backingMap, c1.q0<? extends Map<C, V>> factory) {
        super(backingMap, factory);
    }

    public static SortedMap access$100(w6 w6Var) {
        return (SortedMap) w6Var.backingMap;
    }

    public final SortedMap<R, Map<C, V>> e() {
        return (SortedMap) this.backingMap;
    }

    @Override // f1.x6
    public SortedMap<R, Map<C, V>> createRowMap() {
        return new b();
    }

    @Override // f1.x6, f1.q, f1.z6
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // f1.x6, f1.z6
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
