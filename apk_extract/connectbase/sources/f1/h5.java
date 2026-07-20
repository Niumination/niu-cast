package f1;

import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class h5<T> extends l5<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final l5<? super T> ordering;

    public h5(l5<? super T> ordering) {
        this.ordering = ordering;
    }

    @Override // f1.l5, java.util.Comparator
    public int compare(@gm.a T left, @gm.a T right) {
        if (left == right) {
            return 0;
        }
        if (left == null) {
            return 1;
        }
        if (right == null) {
            return -1;
        }
        return this.ordering.compare(left, right);
    }

    @Override // java.util.Comparator
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof h5) {
            return this.ordering.equals(((h5) object).ordering);
        }
        return false;
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ (-921210296);
    }

    @Override // f1.l5
    public <S extends T> l5<S> nullsFirst() {
        return this.ordering.nullsFirst();
    }

    @Override // f1.l5
    public <S extends T> l5<S> nullsLast() {
        return this;
    }

    @Override // f1.l5
    public <S extends T> l5<S> reverse() {
        return this.ordering.reverse().nullsFirst();
    }

    public String toString() {
        return this.ordering + ".nullsLast()";
    }
}
