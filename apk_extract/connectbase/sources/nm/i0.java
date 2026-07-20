package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i0 implements Iterator<Double>, ln.a {
    @os.l
    public final Double a() {
        return Double.valueOf(c());
    }

    public abstract double c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Double next() {
        return Double.valueOf(c());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
