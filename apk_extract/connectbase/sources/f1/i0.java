package f1;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class i0<T> extends l5<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<T> comparator;

    public i0(Comparator<T> comparator) {
        comparator.getClass();
        this.comparator = comparator;
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(@m5 T a10, @m5 T b10) {
        return this.comparator.compare(a10, b10);
    }

    @Override // java.util.Comparator
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof i0) {
            return this.comparator.equals(((i0) object).comparator);
        }
        return false;
    }

    public int hashCode() {
        return this.comparator.hashCode();
    }

    public String toString() {
        return this.comparator.toString();
    }
}
