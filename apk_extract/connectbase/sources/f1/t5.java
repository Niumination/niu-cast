package f1;

import java.lang.Comparable;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
@t1.f("Use ImmutableRangeSet or TreeRangeSet")
public interface t5<C extends Comparable> {
    void add(q5<C> range);

    void addAll(t5<C> other);

    void addAll(Iterable<q5<C>> ranges);

    Set<q5<C>> asDescendingSetOfRanges();

    Set<q5<C>> asRanges();

    void clear();

    t5<C> complement();

    boolean contains(C value);

    boolean encloses(q5<C> otherRange);

    boolean enclosesAll(t5<C> other);

    boolean enclosesAll(Iterable<q5<C>> other);

    boolean equals(@gm.a Object obj);

    int hashCode();

    boolean intersects(q5<C> otherRange);

    boolean isEmpty();

    @gm.a
    q5<C> rangeContaining(C value);

    void remove(q5<C> range);

    void removeAll(t5<C> other);

    void removeAll(Iterable<q5<C>> ranges);

    q5<C> span();

    t5<C> subRangeSet(q5<C> view);

    String toString();
}
