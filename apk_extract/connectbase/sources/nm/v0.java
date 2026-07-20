package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v0 implements Iterator<Integer>, ln.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Integer next() {
        return Integer.valueOf(nextInt());
    }

    public abstract int nextInt();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @os.l
    public final Integer next() {
        return Integer.valueOf(nextInt());
    }
}
