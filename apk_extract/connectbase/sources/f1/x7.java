package f1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class x7<E> implements Iterator<E> {
    @Override // java.util.Iterator
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
