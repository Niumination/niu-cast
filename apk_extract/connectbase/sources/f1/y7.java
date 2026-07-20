package f1;

import java.util.ListIterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class y7<E> extends x7<E> implements ListIterator<E> {
    @Override // java.util.ListIterator
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(@m5 E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public final void set(@m5 E e10) {
        throw new UnsupportedOperationException();
    }
}
