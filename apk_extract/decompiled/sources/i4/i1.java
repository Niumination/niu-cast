package i4;

/* JADX INFO: loaded from: classes.dex */
public final class i1 extends a0 {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient j1 f5606b;

    public i1(j1 j1Var) {
        this.f5606b = j1Var;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f5606b.containsValue(obj);
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        h5 it = this.f5606b.map.values().iterator();
        while (it.hasNext()) {
            i8 = ((a0) it.next()).copyIntoArray(objArr, i8);
        }
        return i8;
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f5606b.size();
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return this.f5606b.m153valueIterator();
    }
}
