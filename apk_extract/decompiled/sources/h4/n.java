package h4;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class n extends l implements Serializable {
    private static final long serialVersionUID = 0;
    private final m function;
    private final l resultEquivalence;

    public n(m mVar, l lVar) {
        mVar.getClass();
        this.function = mVar;
        lVar.getClass();
        this.resultEquivalence = lVar;
    }

    @Override // h4.l
    public boolean doEquivalent(Object obj, Object obj2) {
        return this.resultEquivalence.equivalent(this.function.apply(obj), this.function.apply(obj2));
    }

    @Override // h4.l
    public int doHash(Object obj) {
        return this.resultEquivalence.hash(this.function.apply(obj));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.function.equals(nVar.function) && this.resultEquivalence.equals(nVar.resultEquivalence);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.resultEquivalence});
    }

    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
