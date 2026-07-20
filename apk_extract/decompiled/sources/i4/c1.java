package i4;

/* JADX INFO: loaded from: classes.dex */
public final class c1 extends h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h5 f5571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h5 f5572b = e2.f5579d;

    public c1(j1 j1Var) {
        this.f5571a = j1Var.map.values().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5572b.hasNext() || this.f5571a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f5572b.hasNext()) {
            this.f5572b = ((a0) this.f5571a.next()).iterator();
        }
        return this.f5572b.next();
    }
}
