package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class q0 extends h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5680a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h5 f5681b;

    public q0(a1 a1Var) {
        this.f5681b = a1Var.map.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f5680a) {
            case 0:
                break;
        }
        return this.f5681b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f5680a) {
            case 0:
                return new p0((Map.Entry) this.f5681b.next());
            default:
                return ((Map.Entry) this.f5681b.next()).getValue();
        }
    }

    public q0(h5 h5Var) {
        this.f5681b = h5Var;
    }
}
