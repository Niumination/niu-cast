package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class t implements Iterator<Boolean>, ln.a {
    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }

    public abstract boolean nextBoolean();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Iterator
    @os.l
    public final Boolean next() {
        return Boolean.valueOf(nextBoolean());
    }
}
