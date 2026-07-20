package f1;

import java.util.Deque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@b1.d
public abstract class u1<E> extends k2<E> implements Deque<E> {
    @Override // java.util.Deque
    public void addFirst(@m5 E e10) {
        delegate().addFirst(e10);
    }

    @Override // java.util.Deque
    public void addLast(@m5 E e10) {
        delegate().addLast(e10);
    }

    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    @Override // java.util.Deque
    @m5
    public E getFirst() {
        return delegate().getFirst();
    }

    @Override // java.util.Deque
    @m5
    public E getLast() {
        return delegate().getLast();
    }

    @Override // f1.k2, f1.s1, f1.j2
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public abstract Deque<E> delegate();

    @Override // java.util.Deque
    @t1.a
    public boolean offerFirst(@m5 E e10) {
        return delegate().offerFirst(e10);
    }

    @Override // java.util.Deque
    @t1.a
    public boolean offerLast(@m5 E e10) {
        return delegate().offerLast(e10);
    }

    @Override // java.util.Deque
    @gm.a
    public E peekFirst() {
        return delegate().peekFirst();
    }

    @Override // java.util.Deque
    @gm.a
    public E peekLast() {
        return delegate().peekLast();
    }

    @Override // java.util.Deque
    @gm.a
    @t1.a
    public E pollFirst() {
        return delegate().pollFirst();
    }

    @Override // java.util.Deque
    @gm.a
    @t1.a
    public E pollLast() {
        return delegate().pollLast();
    }

    @Override // java.util.Deque
    @t1.a
    @m5
    public E pop() {
        return delegate().pop();
    }

    @Override // java.util.Deque
    public void push(@m5 E e10) {
        delegate().push(e10);
    }

    @Override // java.util.Deque
    @t1.a
    @m5
    public E removeFirst() {
        return delegate().removeFirst();
    }

    @Override // java.util.Deque
    @t1.a
    public boolean removeFirstOccurrence(@gm.a Object o10) {
        return delegate().removeFirstOccurrence(o10);
    }

    @Override // java.util.Deque
    @t1.a
    @m5
    public E removeLast() {
        return delegate().removeLast();
    }

    @Override // java.util.Deque
    @t1.a
    public boolean removeLastOccurrence(@gm.a Object o10) {
        return delegate().removeLastOccurrence(o10);
    }
}
