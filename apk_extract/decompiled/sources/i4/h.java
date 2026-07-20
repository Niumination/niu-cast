package i4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import k3.h9;

/* JADX INFO: loaded from: classes.dex */
public final class h extends o4 implements Serializable {
    static final h INSTANCE = new h();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // i4.o4
    public <E> h0 immutableSortedCopy(Iterable<E> iterable) {
        return h0.copyOf(iterable);
    }

    @Override // i4.o4
    public <S> o4 reverse() {
        return this;
    }

    @Override // i4.o4
    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        iterable.getClass();
        if (iterable instanceof Collection) {
            return new ArrayList((Collection) iterable);
        }
        Iterator<E> it = iterable.iterator();
        ArrayList arrayList = new ArrayList();
        h9.a(arrayList, it);
        return arrayList;
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
