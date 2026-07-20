package i4;

import k3.h9;

/* JADX INFO: loaded from: classes.dex */
public final class a1 extends a0 {
    private final t0 map;

    public a1(t0 t0Var) {
        this.map = t0Var;
    }

    @Override // i4.a0
    public h0 asList() {
        return new y0(this, this.map.entrySet().asList());
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return obj != null && h9.b(iterator(), obj);
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.map.size();
    }

    @Override // i4.a0
    public Object writeReplace() {
        return new z0(this.map);
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return new q0(this);
    }
}
