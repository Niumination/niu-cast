package f1;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class y<F, T> extends l5<F> implements Serializable {
    private static final long serialVersionUID = 0;
    final c1.t<F, ? extends T> function;
    final l5<T> ordering;

    public y(c1.t<F, ? extends T> function, l5<T> ordering) {
        function.getClass();
        this.function = function;
        ordering.getClass();
        this.ordering = ordering;
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(@m5 F f10, @m5 F f11) {
        return this.ordering.compare(this.function.apply(f10), this.function.apply(f11));
    }

    @Override // java.util.Comparator
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof y)) {
            return false;
        }
        y yVar = (y) object;
        return this.function.equals(yVar.function) && this.ordering.equals(yVar.ordering);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.function, this.ordering});
    }

    public String toString() {
        return this.ordering + ".onResultOf(" + this.function + ")";
    }
}
