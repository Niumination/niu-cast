package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class x0 extends c2 {
    private final t0 map;

    public x0(t0 t0Var) {
        this.map = t0Var;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // i4.c2
    public Object get(int i8) {
        return ((Map.Entry) this.map.entrySet().asList().get(i8)).getKey();
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // i4.s1, i4.a0
    public Object writeReplace() {
        return new w0(this.map);
    }

    @Override // i4.c2, i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return this.map.keyIterator();
    }
}
