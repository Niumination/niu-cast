package androidx.core.util;

import android.util.Range;
import androidx.annotation.RequiresApi;
import b.a;
import kn.l0;
import os.l;
import tn.g;

/* JADX INFO: loaded from: classes.dex */
@a({"ClassVerificationFailure"})
public final class RangeKt {
    @RequiresApi(21)
    @l
    public static final <T extends Comparable<? super T>> Range<T> and(@l Range<T> range, @l Range<T> range2) {
        l0.p(range, "<this>");
        l0.p(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        l0.o(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    @l
    public static final <T extends Comparable<? super T>> Range<T> plus(@l Range<T> range, @l T t10) {
        l0.p(range, "<this>");
        l0.p(t10, "value");
        Range<T> rangeExtend = range.extend(t10);
        l0.o(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    @l
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(@l T t10, @l T t11) {
        l0.p(t10, "<this>");
        l0.p(t11, "that");
        return new Range<>(t10, t11);
    }

    @RequiresApi(21)
    @l
    public static final <T extends Comparable<? super T>> g<T> toClosedRange(@l final Range<T> range) {
        l0.p(range, "<this>");
        return (g<T>) new g<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            @Override // tn.g
            public boolean contains(@l Comparable comparable) {
                return g.a.a(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // tn.g
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // tn.g
            public Comparable getStart() {
                return range.getLower();
            }

            @Override // tn.g
            public boolean isEmpty() {
                return g.a.b(this);
            }
        };
    }

    @RequiresApi(21)
    @l
    public static final <T extends Comparable<? super T>> Range<T> toRange(@l g<T> gVar) {
        l0.p(gVar, "<this>");
        return new Range<>(gVar.getStart(), gVar.getEndInclusive());
    }

    @RequiresApi(21)
    @l
    public static final <T extends Comparable<? super T>> Range<T> plus(@l Range<T> range, @l Range<T> range2) {
        l0.p(range, "<this>");
        l0.p(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        l0.o(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}
