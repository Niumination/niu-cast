package f1;

import java.lang.Comparable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public abstract class k<C extends Comparable> implements t5<C> {
    @Override // f1.t5
    public void add(q5<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.t5
    public void addAll(t5<C> other) {
        addAll(other.asRanges());
    }

    @Override // f1.t5
    public void clear() {
        remove(q5.all());
    }

    @Override // f1.t5
    public boolean contains(C value) {
        return rangeContaining(value) != null;
    }

    @Override // f1.t5
    public abstract boolean encloses(q5<C> otherRange);

    @Override // f1.t5
    public boolean enclosesAll(t5<C> other) {
        return enclosesAll(other.asRanges());
    }

    @Override // f1.t5
    public boolean equals(@gm.a Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t5) {
            return asRanges().equals(((t5) obj).asRanges());
        }
        return false;
    }

    @Override // f1.t5
    public final int hashCode() {
        return asRanges().hashCode();
    }

    @Override // f1.t5
    public boolean intersects(q5<C> otherRange) {
        return !subRangeSet(otherRange).isEmpty();
    }

    @Override // f1.t5
    public boolean isEmpty() {
        return asRanges().isEmpty();
    }

    @Override // f1.t5
    @gm.a
    public abstract q5<C> rangeContaining(C value);

    @Override // f1.t5
    public void remove(q5<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.t5
    public void removeAll(t5<C> other) {
        removeAll(other.asRanges());
    }

    @Override // f1.t5
    public final String toString() {
        return asRanges().toString();
    }

    @Override // f1.t5
    public void addAll(Iterable<q5<C>> ranges) {
        Iterator<q5<C>> it = ranges.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    @Override // f1.t5
    public boolean enclosesAll(Iterable<q5<C>> ranges) {
        Iterator<q5<C>> it = ranges.iterator();
        while (it.hasNext()) {
            if (!encloses(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // f1.t5
    public void removeAll(Iterable<q5<C>> ranges) {
        Iterator<q5<C>> it = ranges.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }
}
