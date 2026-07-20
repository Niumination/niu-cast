package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class v implements Iterator<Character>, ln.a {
    @os.l
    public final Character a() {
        return Character.valueOf(c());
    }

    public abstract char c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Character next() {
        return Character.valueOf(c());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
