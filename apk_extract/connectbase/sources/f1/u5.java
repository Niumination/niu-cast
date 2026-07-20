package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class u5<C extends Comparable> extends p0<C> {
    private static final long serialVersionUID = 0;
    private final q5<C> range;

    public class a extends l<C> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C f5425b;

        public a(Comparable comparable) {
            super(comparable);
            this.f5425b = (C) u5.this.last();
        }

        @Override // f1.l
        @gm.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(C c10) {
            if (u5.c(c10, this.f5425b)) {
                return null;
            }
            return (C) u5.this.domain.next(c10);
        }
    }

    public class b extends l<C> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C f5427b;

        public b(Comparable comparable) {
            super(comparable);
            this.f5427b = (C) u5.this.first();
        }

        @Override // f1.l
        @gm.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C a(C c10) {
            if (u5.c(c10, this.f5427b)) {
                return null;
            }
            return (C) u5.this.domain.previous(c10);
        }
    }

    public class c extends b3<C> {
        public c() {
        }

        @Override // f1.b3
        public a4<C> delegateCollection() {
            return u5.this;
        }

        @Override // java.util.List
        public C get(int i10) {
            c1.h0.C(i10, size());
            u5 u5Var = u5.this;
            return (C) u5Var.domain.offset(u5Var.first(), i10);
        }
    }

    @b1.c
    @b1.d
    public static final class d<C extends Comparable> implements Serializable {
        final w0<C> domain;
        final q5<C> range;

        public /* synthetic */ d(q5 q5Var, w0 w0Var, a aVar) {
            this(q5Var, w0Var);
        }

        private Object readResolve() {
            return new u5(this.range, this.domain);
        }

        public d(q5<C> range, w0<C> domain) {
            this.range = range;
            this.domain = domain;
        }
    }

    public u5(q5<C> range, w0<C> domain) {
        super(domain);
        this.range = range;
    }

    public static boolean c(Comparable<?> left, @gm.a Comparable<?> right) {
        return right != null && q5.compareOrThrow(left, right) == 0;
    }

    @b1.c
    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@gm.a Object object) {
        if (object == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) object);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> targets) {
        return c0.b(this, targets);
    }

    @Override // f1.t3
    public i3<C> createAsList() {
        return this.domain.supportsFastOffset ? new c() : super.createAsList();
    }

    public final p0<C> e(q5<C> other) {
        return this.range.isConnected(other) ? p0.create(this.range.intersection(other), this.domain) : new y0(this.domain);
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof u5) {
            u5 u5Var = (u5) object;
            if (this.domain.equals(u5Var.domain)) {
                return first().equals(u5Var.first()) && last().equals(u5Var.last());
            }
        }
        return super.equals(object);
    }

    @Override // f1.t3, java.util.Collection, java.util.Set
    public int hashCode() {
        return k6.k(this);
    }

    @Override // f1.a4
    @b1.c
    public int indexOf(@gm.a Object target) {
        if (!contains(target)) {
            return -1;
        }
        w0<C> w0Var = this.domain;
        Comparable comparableFirst = first();
        Objects.requireNonNull(target);
        return (int) w0Var.distance(comparableFirst, (Comparable) target);
    }

    @Override // f1.p0
    public p0<C> intersection(p0<C> other) {
        other.getClass();
        c1.h0.d(this.domain.equals(other.domain));
        if (other.isEmpty()) {
            return other;
        }
        Comparable comparable = (Comparable) l5.natural().max(first(), other.first());
        Comparable comparable2 = (Comparable) l5.natural().min(last(), other.last());
        return comparable.compareTo(comparable2) <= 0 ? p0.create(q5.closed(comparable, comparable2), this.domain) : new y0(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // f1.e3
    public boolean isPartialView() {
        return false;
    }

    @Override // f1.p0
    public q5<C> range() {
        x xVar = x.CLOSED;
        return range(xVar, xVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long jDistance = this.domain.distance(first(), last());
        if (jDistance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) jDistance) + 1;
    }

    @Override // f1.a4, f1.t3, f1.e3
    @b1.c
    @b1.d
    public Object writeReplace() {
        return new d(this.range, this.domain, null);
    }

    @Override // f1.a4, java.util.NavigableSet
    @b1.c
    public x7<C> descendingIterator() {
        return new b(last());
    }

    @Override // f1.a4, java.util.SortedSet
    public C first() {
        Comparable comparableLeastValueAbove = this.range.lowerBound.leastValueAbove(this.domain);
        Objects.requireNonNull(comparableLeastValueAbove);
        return (C) comparableLeastValueAbove;
    }

    @Override // f1.p0, f1.a4
    public p0<C> headSetImpl(C toElement, boolean inclusive) {
        return e(q5.upTo(toElement, x.forBoolean(inclusive)));
    }

    @Override // f1.a4, f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
    public x7<C> iterator() {
        return new a(first());
    }

    @Override // f1.a4, java.util.SortedSet
    public C last() {
        Comparable comparableGreatestValueBelow = this.range.upperBound.greatestValueBelow(this.domain);
        Objects.requireNonNull(comparableGreatestValueBelow);
        return (C) comparableGreatestValueBelow;
    }

    @Override // f1.p0
    public q5<C> range(x lowerBoundType, x upperBoundType) {
        return q5.create(this.range.lowerBound.withLowerBoundType(lowerBoundType, this.domain), this.range.upperBound.withUpperBoundType(upperBoundType, this.domain));
    }

    @Override // f1.p0, f1.a4
    public p0<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
        return (fromElement.compareTo(toElement) != 0 || fromInclusive || toInclusive) ? e(q5.range(fromElement, x.forBoolean(fromInclusive), toElement, x.forBoolean(toInclusive))) : new y0(this.domain);
    }

    @Override // f1.p0, f1.a4
    public p0<C> tailSetImpl(C fromElement, boolean inclusive) {
        return e(q5.downTo(fromElement, x.forBoolean(inclusive)));
    }
}
