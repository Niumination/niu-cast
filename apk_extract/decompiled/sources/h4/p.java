package h4;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class p extends l implements Serializable {
    private static final long serialVersionUID = 1;
    final l elementEquivalence;

    public p(l lVar) {
        lVar.getClass();
        this.elementEquivalence = lVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof p) {
            return this.elementEquivalence.equals(((p) obj).elementEquivalence);
        }
        return false;
    }

    public int hashCode() {
        return this.elementEquivalence.hashCode() ^ 1185147655;
    }

    public String toString() {
        return this.elementEquivalence + ".pairwise()";
    }

    @Override // h4.l
    public boolean doEquivalent(Iterable<Object> iterable, Iterable<Object> iterable2) {
        Iterator<Object> it = iterable.iterator();
        Iterator<Object> it2 = iterable2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            if (!this.elementEquivalence.equivalent(it.next(), it2.next())) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    @Override // h4.l
    public int doHash(Iterable<Object> iterable) {
        Iterator<Object> it = iterable.iterator();
        int iHash = 78721;
        while (it.hasNext()) {
            iHash = (iHash * 24943) + this.elementEquivalence.hash(it.next());
        }
        return iHash;
    }
}
