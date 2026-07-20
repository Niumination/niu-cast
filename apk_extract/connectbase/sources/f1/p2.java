package f1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class p2<E> extends l2<E> implements SortedSet<E> {
    @gm.a
    public Comparator<? super E> comparator() {
        return delegate().comparator();
    }

    @Override // f1.l2, f1.s1, f1.j2
    public abstract SortedSet<E> delegate();

    @m5
    public E first() {
        return delegate().first();
    }

    public SortedSet<E> headSet(@m5 E toElement) {
        return delegate().headSet(toElement);
    }

    @m5
    public E last() {
        return delegate().last();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.s1
    public boolean standardContains(@gm.a Object object) {
        try {
            return n2.unsafeCompare(comparator(), tailSet(object).first(), object) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // f1.s1
    public boolean standardRemove(@gm.a Object object) {
        try {
            Iterator<E> it = tailSet(object).iterator();
            if (it.hasNext()) {
                if (n2.unsafeCompare(comparator(), it.next(), object) == 0) {
                    it.remove();
                    return true;
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public SortedSet<E> standardSubSet(@m5 E fromElement, @m5 E toElement) {
        return tailSet(fromElement).headSet(toElement);
    }

    public SortedSet<E> subSet(@m5 E fromElement, @m5 E toElement) {
        return delegate().subSet(fromElement, toElement);
    }

    public SortedSet<E> tailSet(@m5 E fromElement) {
        return delegate().tailSet(fromElement);
    }
}
