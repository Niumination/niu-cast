package f1;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class r extends l5<Object> implements Serializable {
    static final r INSTANCE = new r();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(@gm.a Object left, @gm.a Object right) {
        return 0;
    }

    @Override // f1.l5
    public <E> i3<E> immutableSortedCopy(Iterable<E> iterable) {
        return i3.copyOf(iterable);
    }

    @Override // f1.l5
    public <S> l5<S> reverse() {
        return this;
    }

    @Override // f1.l5
    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        return p4.r(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
