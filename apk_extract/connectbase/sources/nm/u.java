package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u implements Iterator<Byte>, ln.a {
    @os.l
    public final Byte a() {
        return Byte.valueOf(nextByte());
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Byte next() {
        return Byte.valueOf(nextByte());
    }

    public abstract byte nextByte();

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
