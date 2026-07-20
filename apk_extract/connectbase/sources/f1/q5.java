package f1;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
@t1.j(containerOf = {"C"})
public final class q5<C extends Comparable> extends r5 implements c1.i0<C>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q5<Comparable> f5206a = new q5<>(r0.belowAll(), r0.aboveAll());
    private static final long serialVersionUID = 0;
    final r0<C> lowerBound;
    final r0<C> upperBound;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5207a;

        static {
            int[] iArr = new int[x.values().length];
            f5207a = iArr;
            try {
                iArr[x.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5207a[x.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class b implements c1.t<q5, r0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5208a = new b();

        @Override // c1.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r0 apply(q5 range) {
            return range.lowerBound;
        }
    }

    public static class c extends l5<q5<?>> implements Serializable {
        static final l5<q5<?>> INSTANCE = new c();
        private static final long serialVersionUID = 0;

        @Override // f1.l5, java.util.Comparator
        public int compare(q5<?> left, q5<?> right) {
            return k0.n().i(left.lowerBound, right.lowerBound).i(left.upperBound, right.upperBound).m();
        }
    }

    public static class d implements c1.t<q5, r0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5209a = new d();

        @Override // c1.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public r0 apply(q5 range) {
            return range.upperBound;
        }
    }

    public q5(r0<C> lowerBound, r0<C> upperBound) {
        lowerBound.getClass();
        this.lowerBound = lowerBound;
        upperBound.getClass();
        this.upperBound = upperBound;
        if (lowerBound.compareTo((r0) upperBound) > 0 || lowerBound == r0.aboveAll() || upperBound == r0.belowAll()) {
            throw new IllegalArgumentException("Invalid range: " + a(lowerBound, upperBound));
        }
    }

    public static String a(r0<?> lowerBound, r0<?> upperBound) {
        StringBuilder sb2 = new StringBuilder(16);
        lowerBound.describeAsLowerBound(sb2);
        sb2.append("..");
        upperBound.describeAsUpperBound(sb2);
        return sb2.toString();
    }

    public static <C extends Comparable<?>> q5<C> all() {
        return (q5<C>) f5206a;
    }

    public static <C extends Comparable<?>> q5<C> atLeast(C endpoint) {
        return create(r0.belowValue(endpoint), r0.aboveAll());
    }

    public static <C extends Comparable<?>> q5<C> atMost(C endpoint) {
        return create(r0.belowAll(), r0.aboveValue(endpoint));
    }

    public static <C extends Comparable<?>> q5<C> closed(C lower, C upper) {
        return create(r0.belowValue(lower), r0.aboveValue(upper));
    }

    public static <C extends Comparable<?>> q5<C> closedOpen(C lower, C upper) {
        return create(r0.belowValue(lower), r0.belowValue(upper));
    }

    public static int compareOrThrow(Comparable left, Comparable right) {
        return left.compareTo(right);
    }

    public static <C extends Comparable<?>> q5<C> create(r0<C> lowerBound, r0<C> upperBound) {
        return new q5<>(lowerBound, upperBound);
    }

    public static <C extends Comparable<?>> q5<C> downTo(C endpoint, x boundType) {
        int i10 = a.f5207a[boundType.ordinal()];
        if (i10 == 1) {
            return greaterThan(endpoint);
        }
        if (i10 == 2) {
            return atLeast(endpoint);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> q5<C> encloseAll(Iterable<C> values) {
        values.getClass();
        if (values instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) values;
            Comparator comparator = sortedSet.comparator();
            if (l5.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = values.iterator();
        C next = it.next();
        next.getClass();
        Comparable comparable = next;
        while (it.hasNext()) {
            C next2 = it.next();
            next2.getClass();
            next = (Comparable) l5.natural().min(next, next2);
            comparable = (Comparable) l5.natural().max(comparable, next2);
        }
        return closed(next, comparable);
    }

    public static <C extends Comparable<?>> q5<C> greaterThan(C endpoint) {
        return create(r0.aboveValue(endpoint), r0.aboveAll());
    }

    public static <C extends Comparable<?>> q5<C> lessThan(C endpoint) {
        return create(r0.belowAll(), r0.belowValue(endpoint));
    }

    public static <C extends Comparable<?>> c1.t<q5<C>, r0<C>> lowerBoundFn() {
        return b.f5208a;
    }

    public static <C extends Comparable<?>> q5<C> open(C lower, C upper) {
        return create(r0.aboveValue(lower), r0.belowValue(upper));
    }

    public static <C extends Comparable<?>> q5<C> openClosed(C lower, C upper) {
        return create(r0.aboveValue(lower), r0.aboveValue(upper));
    }

    public static <C extends Comparable<?>> q5<C> range(C lower, x lowerType, C upper, x upperType) {
        lowerType.getClass();
        upperType.getClass();
        x xVar = x.OPEN;
        return create(lowerType == xVar ? r0.aboveValue(lower) : r0.belowValue(lower), upperType == xVar ? r0.belowValue(upper) : r0.aboveValue(upper));
    }

    public static <C extends Comparable<?>> l5<q5<C>> rangeLexOrdering() {
        return (l5<q5<C>>) c.INSTANCE;
    }

    public static <C extends Comparable<?>> q5<C> singleton(C value) {
        return closed(value, value);
    }

    public static <C extends Comparable<?>> q5<C> upTo(C endpoint, x boundType) {
        int i10 = a.f5207a[boundType.ordinal()];
        if (i10 == 1) {
            return lessThan(endpoint);
        }
        if (i10 == 2) {
            return atMost(endpoint);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> c1.t<q5<C>, r0<C>> upperBoundFn() {
        return d.f5209a;
    }

    public q5<C> canonical(w0<C> domain) {
        domain.getClass();
        r0<C> r0VarCanonical = this.lowerBound.canonical(domain);
        r0<C> r0VarCanonical2 = this.upperBound.canonical(domain);
        return (r0VarCanonical == this.lowerBound && r0VarCanonical2 == this.upperBound) ? this : create(r0VarCanonical, r0VarCanonical2);
    }

    public boolean contains(C value) {
        value.getClass();
        return this.lowerBound.isLessThan(value) && !this.upperBound.isLessThan(value);
    }

    public boolean containsAll(Iterable<? extends C> values) {
        if (g4.C(values)) {
            return true;
        }
        if (values instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) values;
            Comparator comparator = sortedSet.comparator();
            if (l5.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last());
            }
        }
        Iterator<? extends C> it = values.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(q5<C> other) {
        return this.lowerBound.compareTo((r0) other.lowerBound) <= 0 && this.upperBound.compareTo((r0) other.upperBound) >= 0;
    }

    @Override // c1.i0
    public boolean equals(@gm.a Object object) {
        if (!(object instanceof q5)) {
            return false;
        }
        q5 q5Var = (q5) object;
        return this.lowerBound.equals(q5Var.lowerBound) && this.upperBound.equals(q5Var.upperBound);
    }

    public q5<C> gap(q5<C> otherRange) {
        if (this.lowerBound.compareTo((r0) otherRange.upperBound) >= 0 || otherRange.lowerBound.compareTo((r0) this.upperBound) >= 0) {
            boolean z10 = this.lowerBound.compareTo((r0) otherRange.lowerBound) < 0;
            q5<C> q5Var = z10 ? this : otherRange;
            if (z10) {
                this = otherRange;
            }
            return create(q5Var.upperBound, this.lowerBound);
        }
        throw new IllegalArgumentException("Ranges have a nonempty intersection: " + this + ", " + otherRange);
    }

    public boolean hasLowerBound() {
        return this.lowerBound != r0.belowAll();
    }

    public boolean hasUpperBound() {
        return this.upperBound != r0.aboveAll();
    }

    public int hashCode() {
        return this.upperBound.hashCode() + (this.lowerBound.hashCode() * 31);
    }

    public q5<C> intersection(q5<C> connectedRange) {
        int iCompareTo = this.lowerBound.compareTo((r0) connectedRange.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo((r0) connectedRange.upperBound);
        if (iCompareTo >= 0 && iCompareTo2 <= 0) {
            return this;
        }
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return connectedRange;
        }
        r0<C> r0Var = iCompareTo >= 0 ? this.lowerBound : connectedRange.lowerBound;
        r0<C> r0Var2 = iCompareTo2 <= 0 ? this.upperBound : connectedRange.upperBound;
        c1.h0.y(r0Var.compareTo((r0) r0Var2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, connectedRange);
        return create(r0Var, r0Var2);
    }

    public boolean isConnected(q5<C> other) {
        return this.lowerBound.compareTo((r0) other.upperBound) <= 0 && other.lowerBound.compareTo((r0) this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public x lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public C lowerEndpoint() {
        return (C) this.lowerBound.endpoint();
    }

    public Object readResolve() {
        return equals(f5206a) ? all() : this;
    }

    public q5<C> span(q5<C> other) {
        int iCompareTo = this.lowerBound.compareTo((r0) other.lowerBound);
        int iCompareTo2 = this.upperBound.compareTo((r0) other.upperBound);
        if (iCompareTo <= 0 && iCompareTo2 >= 0) {
            return this;
        }
        if (iCompareTo < 0 || iCompareTo2 > 0) {
            return create(iCompareTo <= 0 ? this.lowerBound : other.lowerBound, iCompareTo2 >= 0 ? this.upperBound : other.upperBound);
        }
        return other;
    }

    public String toString() {
        return a(this.lowerBound, this.upperBound);
    }

    public x upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public C upperEndpoint() {
        return (C) this.upperBound.endpoint();
    }

    @Override // c1.i0
    @Deprecated
    public boolean apply(C input) {
        return contains(input);
    }
}
