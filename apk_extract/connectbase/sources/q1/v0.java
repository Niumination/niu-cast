package q1;

import java.util.Collection;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class v0<E> extends f1.u1<E> implements BlockingDeque<E> {
    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c10) {
        return delegate().drainTo(c10);
    }

    @Override // f1.u1
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public abstract BlockingDeque<E> delegate();

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public boolean offer(E e10, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offer(e10, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerFirst(E e10, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offerFirst(e10, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    public boolean offerLast(E e10, long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().offerLast(e10, timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    @gm.a
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().poll(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    @gm.a
    public E pollFirst(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().pollFirst(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque
    @gm.a
    public E pollLast(long timeout, TimeUnit unit) throws InterruptedException {
        return delegate().pollLast(timeout, unit);
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public void put(E e10) throws InterruptedException {
        delegate().put(e10);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putFirst(E e10) throws InterruptedException {
        delegate().putFirst(e10);
    }

    @Override // java.util.concurrent.BlockingDeque
    public void putLast(E e10) throws InterruptedException {
        delegate().putLast(e10);
    }

    @Override // java.util.concurrent.BlockingQueue
    public int remainingCapacity() {
        return delegate().remainingCapacity();
    }

    @Override // java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue
    public E take() throws InterruptedException {
        return delegate().take();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeFirst() throws InterruptedException {
        return delegate().takeFirst();
    }

    @Override // java.util.concurrent.BlockingDeque
    public E takeLast() throws InterruptedException {
        return delegate().takeLast();
    }

    @Override // java.util.concurrent.BlockingQueue
    public int drainTo(Collection<? super E> c10, int maxElements) {
        return delegate().drainTo(c10, maxElements);
    }
}
