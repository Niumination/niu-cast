package f1;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class e1<E> extends k2<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;

    @b1.e
    final int maxSize;

    public e1(int maxSize) {
        c1.h0.k(maxSize >= 0, "maxSize (%s) must >= 0", maxSize);
        this.delegate = new ArrayDeque(maxSize);
        this.maxSize = maxSize;
    }

    public static <E> e1<E> create(int maxSize) {
        return new e1<>(maxSize);
    }

    @Override // f1.s1, java.util.Collection, f1.b5
    @t1.a
    public boolean add(E e10) {
        e10.getClass();
        if (this.maxSize == 0) {
            return true;
        }
        if (size() == this.maxSize) {
            this.delegate.remove();
        }
        this.delegate.add(e10);
        return true;
    }

    @Override // f1.s1, java.util.Collection
    @t1.a
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return standardAddAll(collection);
        }
        clear();
        return g4.a(this, g4.N(collection, size - this.maxSize));
    }

    @Override // f1.k2, java.util.Queue
    @t1.a
    public boolean offer(E e10) {
        return add(e10);
    }

    public int remainingCapacity() {
        return this.maxSize - size();
    }

    @Override // f1.s1, java.util.Collection, java.util.Set
    @b1.d
    public Object[] toArray() {
        return super.toArray();
    }

    @Override // f1.k2, f1.s1, f1.j2
    public Queue<E> delegate() {
        return this.delegate;
    }
}
