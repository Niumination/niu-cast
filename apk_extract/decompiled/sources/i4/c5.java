package i4;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class c5 extends o4 implements Serializable {
    private static final long serialVersionUID = 0;
    final o4 forwardOrder;

    public c5(o4 o4Var) {
        o4Var.getClass();
        this.forwardOrder = o4Var;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.forwardOrder.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c5) {
            return this.forwardOrder.equals(((c5) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // i4.o4
    public <E> E max(E e, E e4) {
        return (E) this.forwardOrder.min(e, e4);
    }

    @Override // i4.o4
    public <E> E min(E e, E e4) {
        return (E) this.forwardOrder.max(e, e4);
    }

    @Override // i4.o4
    public <S> o4 reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // i4.o4
    public <E> E max(E e, E e4, E e10, E... eArr) {
        return (E) this.forwardOrder.min(e, e4, e10, eArr);
    }

    @Override // i4.o4
    public <E> E min(E e, E e4, E e10, E... eArr) {
        return (E) this.forwardOrder.max(e, e4, e10, eArr);
    }

    @Override // i4.o4
    public <E> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // i4.o4
    public <E> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // i4.o4
    public <E> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // i4.o4
    public <E> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
