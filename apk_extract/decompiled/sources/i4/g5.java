package i4;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class g5 implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Iterator f5600a;

    public g5(Iterator it) {
        it.getClass();
        this.f5600a = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f5600a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f5600a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f5600a.remove();
    }
}
