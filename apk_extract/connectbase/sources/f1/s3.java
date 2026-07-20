package f1;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@x0
public final class s3<C extends Comparable> extends k<C> implements Serializable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s3<Comparable<?>> f5239c = new s3<>(i3.of());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s3<Comparable<?>> f5240d = new s3<>(i3.of(q5.all()));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient i3<q5<C>> f5241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient s3<C> f5242b;

    public class a extends i3<q5<C>> {
        final /* synthetic */ int val$fromIndex;
        final /* synthetic */ int val$length;
        final /* synthetic */ q5 val$range;

        public a(final int val$length, final int val$fromIndex, final q5 val$range) {
            this.val$length = val$length;
            this.val$fromIndex = val$fromIndex;
            this.val$range = val$range;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$length;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public q5<C> get(int index) {
            c1.h0.C(index, this.val$length);
            return (index == 0 || index == this.val$length + (-1)) ? ((q5) s3.this.f5241a.get(index + this.val$fromIndex)).intersection(this.val$range) : (q5) s3.this.f5241a.get(index + this.val$fromIndex);
        }
    }

    public final class b extends a4<C> {
        private final w0<C> domain;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @u1.b
        @gm.a
        public transient Integer f5243e;

        public class a extends f1.c<C> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<q5<C>> f5244c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Iterator<C> f5245d = h4.l.f4958e;

            public a() {
                this.f5244c = s3.this.f5241a.iterator();
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f5245d.hasNext()) {
                    if (!this.f5244c.hasNext()) {
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    this.f5245d = p0.create(this.f5244c.next(), b.this.domain).iterator();
                }
                return this.f5245d.next();
            }
        }

        /* JADX INFO: renamed from: f1.s3$b$b, reason: collision with other inner class name */
        public class C0121b extends f1.c<C> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Iterator<q5<C>> f5247c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Iterator<C> f5248d = h4.l.f4958e;

            public C0121b() {
                this.f5247c = s3.this.f5241a.reverse().iterator();
            }

            @Override // f1.c
            @gm.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public C a() {
                while (!this.f5248d.hasNext()) {
                    if (!this.f5247c.hasNext()) {
                        this.f4711a = f1.c.b.DONE;
                        return null;
                    }
                    this.f5248d = p0.create(this.f5247c.next(), b.this.domain).descendingIterator();
                }
                return this.f5248d.next();
            }
        }

        public b(w0<C> domain) {
            super(l5.natural());
            this.domain = domain;
        }

        @b1.d
        private void readObject(ObjectInputStream stream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        @Override // f1.e3, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@gm.a Object o10) {
            if (o10 == null) {
                return false;
            }
            try {
                return s3.this.contains((Comparable) o10);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        @Override // f1.a4
        public a4<C> createDescendingSet() {
            return new u0(this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // f1.a4
        public int indexOf(@gm.a Object target) {
            if (!contains(target)) {
                return -1;
            }
            Objects.requireNonNull(target);
            Comparable comparable = (Comparable) target;
            x7 it = s3.this.f5241a.iterator();
            long size = 0;
            while (it.hasNext()) {
                q5 q5Var = (q5) it.next();
                if (q5Var.contains(comparable)) {
                    return o1.l.z(size + ((long) p0.create(q5Var, this.domain).indexOf(comparable)));
                }
                size += (long) p0.create(q5Var, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return s3.this.f5241a.isPartialView();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer numValueOf = this.f5243e;
            if (numValueOf == null) {
                x7 it = s3.this.f5241a.iterator();
                long size = 0;
                while (it.hasNext()) {
                    size += (long) p0.create((q5) it.next(), this.domain).size();
                    if (size >= 2147483647L) {
                        break;
                    }
                }
                numValueOf = Integer.valueOf(o1.l.z(size));
                this.f5243e = numValueOf;
            }
            return numValueOf.intValue();
        }

        public a4<C> subSet(q5<C> range) {
            return s3.this.subRangeSet((q5) range).asSet(this.domain);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return s3.this.f5241a.toString();
        }

        @Override // f1.a4, f1.t3, f1.e3
        @b1.d
        public Object writeReplace() {
            return new c(s3.this.f5241a, this.domain);
        }

        @Override // f1.a4, java.util.NavigableSet
        @b1.c("NavigableSet")
        public x7<C> descendingIterator() {
            return new C0121b();
        }

        @Override // f1.a4
        public a4<C> headSetImpl(C toElement, boolean inclusive) {
            return subSet(q5.upTo(toElement, x.forBoolean(inclusive)));
        }

        @Override // f1.a4, f1.t3, f1.e3, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, f1.n6
        public x7<C> iterator() {
            return new a();
        }

        @Override // f1.a4
        public a4<C> subSetImpl(C fromElement, boolean fromInclusive, C toElement, boolean toInclusive) {
            return (fromInclusive || toInclusive || q5.compareOrThrow(fromElement, toElement) != 0) ? subSet(q5.range(fromElement, x.forBoolean(fromInclusive), toElement, x.forBoolean(toInclusive))) : a4.of();
        }

        @Override // f1.a4
        public a4<C> tailSetImpl(C fromElement, boolean inclusive) {
            return subSet(q5.downTo(fromElement, x.forBoolean(inclusive)));
        }
    }

    public static class c<C extends Comparable> implements Serializable {
        private final w0<C> domain;
        private final i3<q5<C>> ranges;

        public c(i3<q5<C>> ranges, w0<C> domain) {
            this.ranges = ranges;
            this.domain = domain;
        }

        public Object readResolve() {
            return new s3(this.ranges).asSet(this.domain);
        }
    }

    public static class d<C extends Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<q5<C>> f5250a = new ArrayList();

        @t1.a
        public d<C> a(q5<C> range) {
            c1.h0.u(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f5250a.add(range);
            return this;
        }

        @t1.a
        public d<C> b(t5<C> ranges) {
            return c(ranges.asRanges());
        }

        @t1.a
        public d<C> c(Iterable<q5<C>> ranges) {
            Iterator<q5<C>> it = ranges.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public s3<C> d() {
            i3.a aVar = new i3.a(this.f5250a.size());
            Collections.sort(this.f5250a, q5.rangeLexOrdering());
            n5 n5VarT = h4.T(this.f5250a.iterator());
            while (n5VarT.hasNext()) {
                q5 q5VarSpan = (q5) n5VarT.next();
                while (n5VarT.hasNext()) {
                    q5<C> q5Var = (q5) n5VarT.peek();
                    if (!q5VarSpan.isConnected(q5Var)) {
                        break;
                    }
                    c1.h0.y(q5VarSpan.intersection(q5Var).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", q5VarSpan, q5Var);
                    q5VarSpan = q5VarSpan.span((q5) n5VarT.next());
                }
                aVar.j(q5VarSpan);
            }
            i3 i3VarE = aVar.e();
            if (i3VarE.isEmpty()) {
                return s3.of();
            }
            return (i3VarE.size() == 1 && ((q5) g4.z(i3VarE)).equals(q5.all())) ? s3.all() : new s3<>(i3VarE);
        }

        @t1.a
        public d<C> e(d<C> builder) {
            c(builder.f5250a);
            return this;
        }
    }

    public final class e extends i3<q5<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        /* JADX WARN: Multi-variable type inference failed */
        public e() {
            boolean zHasLowerBound = ((q5) s3.this.f5241a.get(0)).hasLowerBound();
            this.positiveBoundedBelow = zHasLowerBound;
            boolean zHasUpperBound = ((q5) g4.w(s3.this.f5241a)).hasUpperBound();
            this.positiveBoundedAbove = zHasUpperBound;
            int size = s3.this.f5241a.size();
            size = zHasLowerBound ? size : size - 1;
            this.size = zHasUpperBound ? size + 1 : size;
        }

        @Override // f1.e3
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public q5<C> get(int i10) {
            r0<C> r0VarBelowAll;
            c1.h0.C(i10, this.size);
            if (this.positiveBoundedBelow) {
                r0VarBelowAll = i10 == 0 ? r0.belowAll() : ((q5) s3.this.f5241a.get(i10 - 1)).upperBound;
            } else {
                r0VarBelowAll = ((q5) s3.this.f5241a.get(i10)).upperBound;
            }
            return q5.create(r0VarBelowAll, (this.positiveBoundedAbove && i10 == this.size + (-1)) ? r0.aboveAll() : ((q5) s3.this.f5241a.get(i10 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound);
        }
    }

    public static final class f<C extends Comparable> implements Serializable {
        private final i3<q5<C>> ranges;

        public f(i3<q5<C>> ranges) {
            this.ranges = ranges;
        }

        public Object readResolve() {
            if (this.ranges.isEmpty()) {
                return s3.of();
            }
            return this.ranges.equals(i3.of(q5.all())) ? s3.all() : new s3(this.ranges);
        }
    }

    public s3(i3<q5<C>> ranges) {
        this.f5241a = ranges;
    }

    public static <C extends Comparable> s3<C> all() {
        return f5240d;
    }

    public static <C extends Comparable<?>> d<C> builder() {
        return new d<>();
    }

    public static <C extends Comparable<?>> s3<C> copyOf(Iterable<q5<C>> ranges) {
        return new d().c(ranges).d();
    }

    public static <C extends Comparable> s3<C> of() {
        return f5239c;
    }

    @b1.d
    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <C extends Comparable<?>> s3<C> unionOf(Iterable<q5<C>> ranges) {
        return copyOf(v7.create(ranges));
    }

    public final i3<q5<C>> a(final q5<C> range) {
        if (this.f5241a.isEmpty() || range.isEmpty()) {
            return i3.of();
        }
        if (range.encloses(span())) {
            return this.f5241a;
        }
        int iA = range.hasLowerBound() ? p6.a(this.f5241a, q5.upperBoundFn(), range.lowerBound, p6.c.FIRST_AFTER, p6.b.NEXT_HIGHER) : 0;
        int iA2 = (range.hasUpperBound() ? p6.a(this.f5241a, q5.lowerBoundFn(), range.upperBound, p6.c.FIRST_PRESENT, p6.b.NEXT_HIGHER) : this.f5241a.size()) - iA;
        return iA2 == 0 ? i3.of() : new a(iA2, iA, range);
    }

    @Override // f1.k, f1.t5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void add(q5<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.k, f1.t5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(t5<C> other) {
        throw new UnsupportedOperationException();
    }

    public a4<C> asSet(w0<C> domain) {
        domain.getClass();
        if (isEmpty()) {
            return a4.of();
        }
        q5<C> q5VarCanonical = span().canonical(domain);
        if (!q5VarCanonical.hasLowerBound()) {
            throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
        }
        if (!q5VarCanonical.hasUpperBound()) {
            try {
                domain.maxValue();
            } catch (NoSuchElementException unused) {
                throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
            }
        }
        return new b(domain);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean contains(Comparable value) {
        return super.contains(value);
    }

    public s3<C> difference(t5<C> other) {
        v7 v7VarCreate = v7.create(this);
        v7VarCreate.removeAll(other);
        return copyOf(v7VarCreate);
    }

    @Override // f1.k, f1.t5
    public boolean encloses(q5<C> otherRange) {
        int iB = p6.b(this.f5241a, q5.lowerBoundFn(), otherRange.lowerBound, l5.natural(), p6.c.ANY_PRESENT, p6.b.NEXT_LOWER);
        return iB != -1 && this.f5241a.get(iB).encloses(otherRange);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean enclosesAll(t5 other) {
        return super.enclosesAll(other);
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean equals(@gm.a Object obj) {
        return super.equals(obj);
    }

    public s3<C> intersection(t5<C> other) {
        v7 v7VarCreate = v7.create(this);
        v7VarCreate.removeAll(other.complement());
        return copyOf(v7VarCreate);
    }

    @Override // f1.k, f1.t5
    public boolean intersects(q5<C> otherRange) {
        int iB = p6.b(this.f5241a, q5.lowerBoundFn(), otherRange.lowerBound, l5.natural(), p6.c.ANY_PRESENT, p6.b.NEXT_HIGHER);
        if (iB < this.f5241a.size() && this.f5241a.get(iB).isConnected(otherRange) && !this.f5241a.get(iB).intersection(otherRange).isEmpty()) {
            return true;
        }
        if (iB > 0) {
            int i10 = iB - 1;
            if (this.f5241a.get(i10).isConnected(otherRange) && !this.f5241a.get(i10).intersection(otherRange).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // f1.k, f1.t5
    public boolean isEmpty() {
        return this.f5241a.isEmpty();
    }

    public boolean isPartialView() {
        return this.f5241a.isPartialView();
    }

    @Override // f1.k, f1.t5
    @gm.a
    public q5<C> rangeContaining(C value) {
        int iB = p6.b(this.f5241a, q5.lowerBoundFn(), r0.belowValue(value), l5.natural(), p6.c.ANY_PRESENT, p6.b.NEXT_LOWER);
        if (iB == -1) {
            return null;
        }
        q5<C> q5Var = this.f5241a.get(iB);
        if (q5Var.contains(value)) {
            return q5Var;
        }
        return null;
    }

    @Override // f1.k, f1.t5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void remove(q5<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.k, f1.t5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(t5<C> other) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.t5
    public q5<C> span() {
        if (this.f5241a.isEmpty()) {
            throw new NoSuchElementException();
        }
        r0<C> r0Var = this.f5241a.get(0).lowerBound;
        i3<q5<C>> i3Var = this.f5241a;
        return q5.create(r0Var, i3Var.get(i3Var.size() - 1).upperBound);
    }

    public s3<C> union(t5<C> other) {
        return unionOf(p1.g(asRanges(), other.asRanges()));
    }

    @b1.d
    public Object writeReplace() {
        return new f(this.f5241a);
    }

    public static <C extends Comparable> s3<C> copyOf(t5<C> rangeSet) {
        rangeSet.getClass();
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(q5.all())) {
            return all();
        }
        if (rangeSet instanceof s3) {
            s3<C> s3Var = (s3) rangeSet;
            if (!s3Var.isPartialView()) {
                return s3Var;
            }
        }
        return new s3<>(i3.copyOf((Collection) rangeSet.asRanges()));
    }

    public static <C extends Comparable> s3<C> of(q5<C> range) {
        range.getClass();
        if (range.isEmpty()) {
            return of();
        }
        return range.equals(q5.all()) ? all() : new s3<>(i3.of(range));
    }

    @Override // f1.k, f1.t5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(Iterable<q5<C>> other) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.t5
    public t3<q5<C>> asDescendingSetOfRanges() {
        return this.f5241a.isEmpty() ? t3.of() : new c6(this.f5241a.reverse(), q5.rangeLexOrdering().reverse());
    }

    @Override // f1.t5
    public t3<q5<C>> asRanges() {
        return this.f5241a.isEmpty() ? t3.of() : new c6(this.f5241a, q5.rangeLexOrdering());
    }

    @Override // f1.t5
    public s3<C> complement() {
        s3<C> s3Var = this.f5242b;
        if (s3Var != null) {
            return s3Var;
        }
        if (this.f5241a.isEmpty()) {
            s3<C> s3VarAll = all();
            this.f5242b = s3VarAll;
            return s3VarAll;
        }
        if (this.f5241a.size() == 1 && this.f5241a.get(0).equals(q5.all())) {
            s3<C> s3VarOf = of();
            this.f5242b = s3VarOf;
            return s3VarOf;
        }
        s3<C> s3Var2 = new s3<>(new e(), this);
        this.f5242b = s3Var2;
        return s3Var2;
    }

    @Override // f1.k, f1.t5
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable ranges) {
        return super.enclosesAll(ranges);
    }

    @Override // f1.k, f1.t5
    @t1.e("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(Iterable<q5<C>> other) {
        throw new UnsupportedOperationException();
    }

    @Override // f1.t5
    public s3<C> subRangeSet(q5<C> range) {
        if (!isEmpty()) {
            q5<C> q5VarSpan = span();
            if (range.encloses(q5VarSpan)) {
                return this;
            }
            if (range.isConnected(q5VarSpan)) {
                return new s3<>(a(range));
            }
        }
        return of();
    }

    public s3(i3<q5<C>> ranges, s3<C> complement) {
        this.f5241a = ranges;
        this.f5242b = complement;
    }
}
