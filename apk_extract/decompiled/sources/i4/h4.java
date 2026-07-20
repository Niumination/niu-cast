package i4;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class h4 extends o4 implements Serializable {
    private static final long serialVersionUID = 0;
    final o4 ordering;

    public h4(o4 o4Var) {
        this.ordering = o4Var;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return this.ordering.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h4) {
            return this.ordering.equals(((h4) obj).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    @Override // i4.o4
    public <S> o4 nullsFirst() {
        return this;
    }

    @Override // i4.o4
    public <S> o4 nullsLast() {
        return this.ordering.nullsLast();
    }

    @Override // i4.o4
    public <S> o4 reverse() {
        return this.ordering.reverse().nullsLast();
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
