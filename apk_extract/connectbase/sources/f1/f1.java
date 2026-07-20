package f1;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class f1<T> extends l5<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final k3<T, Integer> rankMap;

    public f1(List<T> valuesInOrder) {
        this(t4.Q(valuesInOrder));
    }

    public final int a(T value) {
        Integer num = this.rankMap.get(value);
        if (num != null) {
            return num.intValue();
        }
        throw new l5.c(value);
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(T left, T right) {
        return a(left) - a(right);
    }

    @Override // java.util.Comparator
    public boolean equals(@gm.a Object object) {
        if (object instanceof f1) {
            return this.rankMap.equals(((f1) object).rankMap);
        }
        return false;
    }

    public int hashCode() {
        return this.rankMap.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.rankMap.keySet() + ")";
    }

    public f1(k3<T, Integer> rankMap) {
        this.rankMap = rankMap;
    }
}
