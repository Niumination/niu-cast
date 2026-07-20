package k3;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f6502a;

    public j0(Iterator it) {
        it.getClass();
        this.f6502a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f6502a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f6502a.next()).getValue();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f6502a.remove();
    }
}
