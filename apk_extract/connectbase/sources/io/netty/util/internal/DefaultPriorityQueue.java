package io.netty.util.internal;

import io.netty.util.internal.PriorityQueueNode;
import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes3.dex */
public final class DefaultPriorityQueue<T extends PriorityQueueNode> extends AbstractQueue<T> implements PriorityQueue<T> {
    private static final PriorityQueueNode[] EMPTY_ARRAY = new PriorityQueueNode[0];
    private final Comparator<T> comparator;
    private T[] queue;
    private int size;

    public final class PriorityQueueIterator implements Iterator<T> {
        private int index;

        private PriorityQueueIterator() {
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < DefaultPriorityQueue.this.size;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove");
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.index >= DefaultPriorityQueue.this.size) {
                throw new NoSuchElementException();
            }
            PriorityQueueNode[] priorityQueueNodeArr = DefaultPriorityQueue.this.queue;
            int i10 = this.index;
            this.index = i10 + 1;
            return (T) priorityQueueNodeArr[i10];
        }
    }

    public DefaultPriorityQueue(Comparator<T> comparator, int i10) {
        this.comparator = (Comparator) ObjectUtil.checkNotNull(comparator, "comparator");
        this.queue = (T[]) (i10 != 0 ? new PriorityQueueNode[i10] : EMPTY_ARRAY);
    }

    private void bubbleDown(int i10, T t10) {
        int i11 = this.size >>> 1;
        while (i10 < i11) {
            int i12 = i10 << 1;
            int i13 = i12 + 1;
            T[] tArr = this.queue;
            T t11 = tArr[i13];
            int i14 = i12 + 2;
            if (i14 >= this.size || this.comparator.compare(t11, tArr[i14]) <= 0) {
                i14 = i13;
            } else {
                t11 = this.queue[i14];
            }
            if (this.comparator.compare(t10, t11) <= 0) {
                break;
            }
            this.queue[i10] = t11;
            t11.priorityQueueIndex(this, i10);
            i10 = i14;
        }
        this.queue[i10] = t10;
        t10.priorityQueueIndex(this, i10);
    }

    private void bubbleUp(int i10, T t10) {
        while (i10 > 0) {
            int i11 = (i10 - 1) >>> 1;
            T t11 = this.queue[i11];
            if (this.comparator.compare(t10, t11) >= 0) {
                break;
            }
            this.queue[i10] = t11;
            t11.priorityQueueIndex(this, i10);
            i10 = i11;
        }
        this.queue[i10] = t10;
        t10.priorityQueueIndex(this, i10);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i10 = 0; i10 < this.size; i10++) {
            T t10 = this.queue[i10];
            if (t10 != null) {
                t10.priorityQueueIndex(this, -1);
                this.queue[i10] = null;
            }
        }
        this.size = 0;
    }

    @Override // io.netty.util.internal.PriorityQueue
    public void clearIgnoringIndexes() {
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof PriorityQueueNode)) {
            return false;
        }
        PriorityQueueNode priorityQueueNode = (PriorityQueueNode) obj;
        return contains(priorityQueueNode, priorityQueueNode.priorityQueueIndex(this));
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return new PriorityQueueIterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        try {
            return removeTyped((PriorityQueueNode) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        return Arrays.copyOf(this.queue, this.size);
    }

    @Override // io.netty.util.internal.PriorityQueue
    public boolean containsTyped(T t10) {
        return contains(t10, t10.priorityQueueIndex(this));
    }

    @Override // java.util.Queue
    public boolean offer(T t10) {
        if (t10.priorityQueueIndex(this) != -1) {
            throw new IllegalArgumentException("e.priorityQueueIndex(): " + t10.priorityQueueIndex(this) + " (expected: -1) + e: " + t10);
        }
        int i10 = this.size;
        T[] tArr = this.queue;
        if (i10 >= tArr.length) {
            this.queue = (T[]) ((PriorityQueueNode[]) Arrays.copyOf(tArr, tArr.length + (tArr.length < 64 ? tArr.length + 2 : tArr.length >>> 1)));
        }
        int i11 = this.size;
        this.size = i11 + 1;
        bubbleUp(i11, t10);
        return true;
    }

    @Override // java.util.Queue
    public T peek() {
        if (this.size == 0) {
            return null;
        }
        return this.queue[0];
    }

    @Override // java.util.Queue
    public T poll() {
        if (this.size == 0) {
            return null;
        }
        T t10 = this.queue[0];
        t10.priorityQueueIndex(this, -1);
        T[] tArr = this.queue;
        int i10 = this.size - 1;
        this.size = i10;
        T t11 = tArr[i10];
        tArr[i10] = null;
        if (i10 != 0) {
            bubbleDown(0, t11);
        }
        return t10;
    }

    @Override // io.netty.util.internal.PriorityQueue
    public void priorityChanged(T t10) {
        int iPriorityQueueIndex = t10.priorityQueueIndex(this);
        if (contains(t10, iPriorityQueueIndex)) {
            if (iPriorityQueueIndex == 0) {
                bubbleDown(iPriorityQueueIndex, t10);
                return;
            }
            if (this.comparator.compare(t10, this.queue[(iPriorityQueueIndex - 1) >>> 1]) < 0) {
                bubbleUp(iPriorityQueueIndex, t10);
            } else {
                bubbleDown(iPriorityQueueIndex, t10);
            }
        }
    }

    @Override // io.netty.util.internal.PriorityQueue
    public boolean removeTyped(T t10) {
        int iPriorityQueueIndex = t10.priorityQueueIndex(this);
        if (!contains(t10, iPriorityQueueIndex)) {
            return false;
        }
        t10.priorityQueueIndex(this, -1);
        int i10 = this.size - 1;
        this.size = i10;
        if (i10 == 0 || i10 == iPriorityQueueIndex) {
            this.queue[iPriorityQueueIndex] = null;
            return true;
        }
        T[] tArr = this.queue;
        T t11 = tArr[i10];
        tArr[iPriorityQueueIndex] = t11;
        tArr[i10] = null;
        if (this.comparator.compare(t10, t11) < 0) {
            bubbleDown(iPriorityQueueIndex, t11);
        } else {
            bubbleUp(iPriorityQueueIndex, t11);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public <X> X[] toArray(X[] xArr) {
        int length = xArr.length;
        int i10 = this.size;
        if (length < i10) {
            return (X[]) Arrays.copyOf(this.queue, i10, xArr.getClass());
        }
        System.arraycopy(this.queue, 0, xArr, 0, i10);
        int length2 = xArr.length;
        int i11 = this.size;
        if (length2 > i11) {
            xArr[i11] = null;
        }
        return xArr;
    }

    private boolean contains(PriorityQueueNode priorityQueueNode, int i10) {
        return i10 >= 0 && i10 < this.size && priorityQueueNode.equals(this.queue[i10]);
    }
}
