package f1;

import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.f("Use Iterators.peekingIterator")
public interface n5<E> extends Iterator<E> {
    @Override // java.util.Iterator
    @t1.a
    @m5
    E next();

    @m5
    E peek();

    @Override // java.util.Iterator
    void remove();
}
