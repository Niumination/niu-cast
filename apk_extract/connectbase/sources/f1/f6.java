package f1;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class f6 extends l5<Comparable<?>> implements Serializable {
    static final f6 INSTANCE = new f6();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // f1.l5
    public <S extends Comparable<?>> l5<S> reverse() {
        return l5.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(Comparable<?> left, Comparable<?> right) {
        left.getClass();
        if (left == right) {
            return 0;
        }
        return right.compareTo(left);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E max(E a10, E b10) {
        return (E) e5.INSTANCE.min(a10, b10);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E min(E a10, E b10) {
        return (E) e5.INSTANCE.max(a10, b10);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E max(E a10, E b10, E c10, E... rest) {
        return (E) e5.INSTANCE.min(a10, b10, c10, rest);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E min(E a10, E b10, E c10, E... rest) {
        return (E) e5.INSTANCE.max(a10, b10, c10, rest);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E max(Iterator<E> iterator) {
        return (E) e5.INSTANCE.min(iterator);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E min(Iterator<E> iterator) {
        return (E) e5.INSTANCE.max(iterator);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E max(Iterable<E> iterable) {
        return (E) e5.INSTANCE.min(iterable);
    }

    @Override // f1.l5
    public <E extends Comparable<?>> E min(Iterable<E> iterable) {
        return (E) e5.INSTANCE.max(iterable);
    }
}
