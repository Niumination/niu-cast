package c1;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@k
public final class d0<E, T extends E> extends m<Iterable<T>> implements Serializable {
    private static final long serialVersionUID = 1;
    final m<E> elementEquivalence;

    public d0(m<E> elementEquivalence) {
        elementEquivalence.getClass();
        this.elementEquivalence = elementEquivalence;
    }

    public boolean equals(@gm.a Object object) {
        if (object instanceof d0) {
            return this.elementEquivalence.equals(((d0) object).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    @Override // c1.m
    public boolean doEquivalent(Iterable<T> iterableA, Iterable<T> iterableB) {
        Iterator<T> it = iterableA.iterator();
        Iterator<T> it2 = iterableB.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // c1.m
    public int doHash(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        int iHash = 78721;
        while (it.hasNext()) {
            iHash = (iHash * 24943) + this.elementEquivalence.hash(it.next());
        }
        return iHash;
    }
}
