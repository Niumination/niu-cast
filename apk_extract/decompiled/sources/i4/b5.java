package i4;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b5 extends o4 implements Serializable {
    static final b5 INSTANCE = new b5();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // i4.o4
    public <S extends Comparable<?>> o4 reverse() {
        return o4.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // java.util.Comparator
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E max(E e, E e4) {
        return (E) g4.INSTANCE.min(e, e4);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E min(E e, E e4) {
        return (E) g4.INSTANCE.max(e, e4);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E max(E e, E e4, E e10, E... eArr) {
        return (E) g4.INSTANCE.min(e, e4, e10, eArr);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E min(E e, E e4, E e10, E... eArr) {
        return (E) g4.INSTANCE.max(e, e4, e10, eArr);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E max(Iterator<E> it) {
        return (E) g4.INSTANCE.min(it);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E min(Iterator<E> it) {
        return (E) g4.INSTANCE.max(it);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E max(Iterable<E> iterable) {
        return (E) g4.INSTANCE.min(iterable);
    }

    @Override // i4.o4
    public <E extends Comparable<?>> E min(Iterable<E> iterable) {
        return (E) g4.INSTANCE.max(iterable);
    }
}
