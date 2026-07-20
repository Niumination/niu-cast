package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class w0 implements Iterator<Long>, ln.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Long next() {
        return Long.valueOf(nextLong());
    }

    public abstract long nextLong();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @os.l
    public final Long next() {
        return Long.valueOf(nextLong());
    }
}
