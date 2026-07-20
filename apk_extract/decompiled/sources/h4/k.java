package h4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class k implements Serializable {
    private static final long serialVersionUID = 0;
    private final l equivalence;
    private final Object reference;

    public k(l lVar, Object obj, g gVar) {
        lVar.getClass();
        this.equivalence = lVar;
        this.reference = obj;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (this.equivalence.equals(kVar.equivalence)) {
            return this.equivalence.equivalent(this.reference, kVar.reference);
        }
        return false;
    }

    public Object get() {
        return this.reference;
    }

    public int hashCode() {
        return this.equivalence.hash(this.reference);
    }

    public String toString() {
        return this.equivalence + ".wrap(" + this.reference + ")";
    }
}
