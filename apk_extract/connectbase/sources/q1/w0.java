package q1;

import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class w0<E> extends f1.k2<E> implements BlockingQueue<E> {
    @Override // java.util.concurrent.BlockingQueue
    @t1.a
    public int drainTo(Collection<? super E> c10, int maxElements) {
        return delegate().drainTo(c10, maxElements);
    }

    @Override // f1.k2, f1.s1, f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract BlockingQueue<E> delegate();

    @Override // java.util.concurrent.BlockingQueue
    @t1.a
    public boolean offer(E e10, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offer(e10, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    @gm.a
    @t1.a
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().poll(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingQueue
    public void put(E e10) throws InterruptedException {
        delegate().put(e10);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingQueue
    @t1.a
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingQueue
    @t1.a
    public int drainTo(Collection<? super E> c10) {
        return delegate().drainTo(c10);
    }
}
