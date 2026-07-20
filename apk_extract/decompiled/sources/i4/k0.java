package i4;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends h5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h5 f5617a;

    public k0(h5 h5Var) {
        this.f5617a = h5Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5617a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f5617a.next()).getKey();
    }
}
