package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class i4 extends o4 implements Serializable {
    private static final long serialVersionUID = 0;
    final o4 ordering;

    public i4(o4 o4Var) {
        this.ordering = o4Var;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return this.ordering.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i4) {
            return this.ordering.equals(((i4) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    @Override // i4.o4
    public <S> o4 nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // i4.o4
    public <S> o4 nullsLast() {
        return this;
    }

    @Override // i4.o4
    public <S> o4 reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        return this.ordering + ".nullsLast()";
    }
}
