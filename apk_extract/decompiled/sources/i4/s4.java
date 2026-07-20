package i4;

/* JADX INFO: loaded from: classes.dex */
public final class s4 extends s1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient t0 f5689c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient h0 f5690d;

    public s4(t0 t0Var, h0 h0Var) {
        this.f5689c = t0Var;
        this.f5690d = h0Var;
    }

    @Override // i4.s1, i4.a0
    public h0 asList() {
        return this.f5690d;
    }

    @Override // i4.a0, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f5689c.get(obj) != null;
    }

    @Override // i4.a0
    public int copyIntoArray(Object[] objArr, int i8) {
        return asList().copyIntoArray(objArr, i8);
    }

    @Override // i4.a0
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f5689c.size();
    }

    @Override // i4.s1, i4.a0, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public h5 iterator() {
        return asList().iterator();
    }
}
