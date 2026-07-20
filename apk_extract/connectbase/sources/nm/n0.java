package nm;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public abstract class n0 implements Iterator<Float>, ln.a {
    @os.l
    public final Float a() {
        return Float.valueOf(c());
    }

    public abstract float c();

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Float next() {
        return Float.valueOf(c());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
