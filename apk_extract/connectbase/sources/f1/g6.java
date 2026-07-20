package f1;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class g6<T> extends l5<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final l5<? super T> forwardOrder;

    public g6(l5<? super T> forwardOrder) {
        forwardOrder.getClass();
        this.forwardOrder = forwardOrder;
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(@m5 T a10, @m5 T b10) {
        return this.forwardOrder.compare(b10, a10);
    }

    @Override // java.util.Comparator
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof g6) {
            return this.forwardOrder.equals(((g6) object).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // f1.l5
    public <E extends T> E max(@m5 E e10, @m5 E e11) {
        return (E) this.forwardOrder.min(e10, e11);
    }

    @Override // f1.l5
    public <E extends T> E min(@m5 E e10, @m5 E e11) {
        return (E) this.forwardOrder.max(e10, e11);
    }

    @Override // f1.l5
    public <S extends T> l5<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // f1.l5
    public <E extends T> E max(@m5 E e10, @m5 E e11, @m5 E e12, E... eArr) {
        return (E) this.forwardOrder.min(e10, e11, e12, eArr);
    }

    @Override // f1.l5
    public <E extends T> E min(@m5 E e10, @m5 E e11, @m5 E e12, E... eArr) {
        return (E) this.forwardOrder.max(e10, e11, e12, eArr);
    }

    @Override // f1.l5
    public <E extends T> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // f1.l5
    public <E extends T> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // f1.l5
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // f1.l5
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
