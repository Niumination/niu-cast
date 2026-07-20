package f1;

import java.util.NoSuchElementException;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class k2<E> extends s1<E> implements Queue<E> {
    @Override // f1.s1, f1.j2
    public abstract Queue<E> delegate();

    @Override // java.util.Queue
    @m5
    public E element() {
        return delegate().element();
    }

    @t1.a
    public boolean offer(@m5 E o10) {
        return delegate().offer(o10);
    }

    @Override // java.util.Queue
    @gm.a
    public E peek() {
        return delegate().peek();
    }

    @Override // java.util.Queue
    @gm.a
    @t1.a
    public E poll() {
        return delegate().poll();
    }

    @Override // java.util.Queue
    @t1.a
    @m5
    public E remove() {
        return delegate().remove();
    }

    public boolean standardOffer(@m5 E e10) {
        try {
            return add(e10);
        } catch (IllegalStateException unused) {
            return false;
        }
    }

    @gm.a
    public E standardPeek() {
        try {
            return element();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }

    @gm.a
    public E standardPoll() {
        try {
            return remove();
        } catch (NoSuchElementException unused) {
            return null;
        }
    }
}
