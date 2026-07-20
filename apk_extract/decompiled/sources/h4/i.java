package h4;

import java.io.Serializable;
import java.util.Arrays;
import k3.u8;

/* JADX INFO: loaded from: classes.dex */
public final class i implements r, Serializable {
    private static final long serialVersionUID = 0;
    private final l equivalence;
    private final Object target;

    public i(l lVar, Object obj) {
        lVar.getClass();
        this.equivalence = lVar;
        this.target = obj;
    }

    public boolean apply(Object obj) {
        return this.equivalence.equivalent(obj, this.target);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.equivalence.equals(iVar.equivalence) && u8.a(this.target, iVar.target);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.equivalence, this.target});
    }

    public String toString() {
        return this.equivalence + ".equivalentTo(" + this.target + ")";
    }
}
