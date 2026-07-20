package i4;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class j extends o4 implements Serializable {
    private static final long serialVersionUID = 0;
    final h4.m function;
    final o4 ordering;

    public j(h4.m mVar, o4 o4Var) {
        mVar.getClass();
        this.function = mVar;
        o4Var.getClass();
        this.ordering = o4Var;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.ordering.compare(this.function.apply(obj), this.function.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.function.equals(jVar.function) && this.ordering.equals(jVar.ordering);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
