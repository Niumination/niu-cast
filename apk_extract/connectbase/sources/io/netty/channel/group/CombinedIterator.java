package io.netty.channel.group;

import io.netty.util.internal.ObjectUtil;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
final class CombinedIterator<E> implements Iterator<E> {
    private Iterator<E> currentIterator;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    private final Iterator<E> f8296i1;

    /* JADX INFO: renamed from: i2, reason: collision with root package name */
    private final Iterator<E> f8297i2;

    public CombinedIterator(Iterator<E> it, Iterator<E> it2) {
        this.f8296i1 = (Iterator) ObjectUtil.checkNotNull(it, "i1");
        this.f8297i2 = (Iterator) ObjectUtil.checkNotNull(it2, "i2");
        this.currentIterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (!this.currentIterator.hasNext()) {
            if (this.currentIterator != this.f8296i1) {
                return false;
            }
            this.currentIterator = this.f8297i2;
        }
        return true;
    }

    @Override // java.util.Iterator
    public E next() {
        while (true) {
            try {
                return this.currentIterator.next();
            } catch (NoSuchElementException e10) {
                if (this.currentIterator != this.f8296i1) {
                    throw e10;
                }
                this.currentIterator = this.f8297i2;
            }
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        this.currentIterator.remove();
    }
}
