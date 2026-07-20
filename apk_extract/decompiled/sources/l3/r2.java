package l3;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class r2 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f7290a;

    public r2(s2 s2Var) {
        this.f7290a = s2Var.f7293a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7290a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return (String) this.f7290a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
