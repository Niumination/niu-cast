package f1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class l0<T> extends l5<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator<? super T>[] comparators;

    public l0(Comparator<? super T> primary, Comparator<? super T> secondary) {
        this.comparators = new Comparator[]{primary, secondary};
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(@m5 T left, @m5 T right) {
        int i10 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.comparators;
            if (i10 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i10].compare(left, right);
            if (iCompare != 0) {
                return iCompare;
            }
            i10++;
        }
    }

    @Override // java.util.Comparator
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof l0) {
            return Arrays.equals(this.comparators, ((l0) object).comparators);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.comparators);
    }

    public String toString() {
        return j.c.a(new StringBuilder("Ordering.compound("), Arrays.toString(this.comparators), ")");
    }

    public l0(Iterable<? extends Comparator<? super T>> comparators) {
        this.comparators = (Comparator[]) g4.R(comparators, new Comparator[0]);
    }
}
