package f1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class z1<T> extends j2 implements Iterator<T> {
    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    @Override // f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract Iterator<T> delegate();

    @t1.a
    @m5
    public T next() {
        return delegate().next();
    }

    public void remove() {
        delegate().remove();
    }
}
