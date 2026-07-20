package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class q1 implements Iterator<Short>, ln.a {
    @os.l
    public final Short a() {
        return Short.valueOf(c());
    }

    public abstract short c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Short next() {
        return Short.valueOf(c());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
