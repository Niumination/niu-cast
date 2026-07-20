package f1;

import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class r0<C extends Comparable> implements Comparable<r0<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f5210a;

        static {
            int[] iArr = new int[x.values().length];
            f5210a = iArr;
            try {
                iArr[x.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5210a[x.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static final class b extends r0<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5211a = new b();
        private static final long serialVersionUID = 0;

        public b() {
            super("");
        }

        private Object readResolve() {
            return f5211a;
        }

        @Override // f1.r0
        public void describeAsLowerBound(StringBuilder sb2) {
            throw new AssertionError();
        }

        @Override // f1.r0
        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append("+∞)");
        }

        @Override // f1.r0
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // f1.r0
        public Comparable<?> greatestValueBelow(w0<Comparable<?>> domain) {
            return domain.maxValue();
        }

        @Override // f1.r0
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // f1.r0
        public boolean isLessThan(Comparable<?> value) {
            return false;
        }

        @Override // f1.r0
        public Comparable<?> leastValueAbove(w0<Comparable<?>> domain) {
            throw new AssertionError();
        }

        public String toString() {
            return "+∞";
        }

        @Override // f1.r0
        public x typeAsLowerBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // f1.r0
        public x typeAsUpperBound() {
            throw new IllegalStateException();
        }

        @Override // f1.r0
        public r0<Comparable<?>> withLowerBoundType(x boundType, w0<Comparable<?>> domain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // f1.r0
        public r0<Comparable<?>> withUpperBoundType(x boundType, w0<Comparable<?>> domain) {
            throw new IllegalStateException();
        }

        @Override // f1.r0, java.lang.Comparable
        public int compareTo(r0<Comparable<?>> o10) {
            return o10 == this ? 0 : 1;
        }
    }

    public static final class c<C extends Comparable> extends r0<C> {
        private static final long serialVersionUID = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(C endpoint) {
            super(endpoint);
            endpoint.getClass();
        }

        @Override // f1.r0
        public r0<C> canonical(w0<C> domain) {
            Comparable comparableLeastValueAbove = leastValueAbove(domain);
            return comparableLeastValueAbove != null ? r0.belowValue(comparableLeastValueAbove) : r0.aboveAll();
        }

        @Override // f1.r0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object that) {
            return super.compareTo((r0) that);
        }

        @Override // f1.r0
        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append('(');
            sb2.append(this.endpoint);
        }

        @Override // f1.r0
        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(']');
        }

        @Override // f1.r0
        public C greatestValueBelow(w0<C> domain) {
            return this.endpoint;
        }

        @Override // f1.r0
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // f1.r0
        public boolean isLessThan(C value) {
            return q5.compareOrThrow(this.endpoint, value) < 0;
        }

        @Override // f1.r0
        @gm.a
        public C leastValueAbove(w0<C> w0Var) {
            return (C) w0Var.next(this.endpoint);
        }

        public String toString() {
            return "/" + this.endpoint + "\\";
        }

        @Override // f1.r0
        public x typeAsLowerBound() {
            return x.OPEN;
        }

        @Override // f1.r0
        public x typeAsUpperBound() {
            return x.CLOSED;
        }

        @Override // f1.r0
        public r0<C> withLowerBoundType(x boundType, w0<C> domain) {
            int i10 = a.f5210a[boundType.ordinal()];
            if (i10 == 1) {
                Comparable next = domain.next(this.endpoint);
                return next == null ? r0.belowAll() : r0.belowValue(next);
            }
            if (i10 == 2) {
                return this;
            }
            throw new AssertionError();
        }

        @Override // f1.r0
        public r0<C> withUpperBoundType(x boundType, w0<C> domain) {
            int i10 = a.f5210a[boundType.ordinal()];
            if (i10 == 1) {
                return this;
            }
            if (i10 != 2) {
                throw new AssertionError();
            }
            Comparable next = domain.next(this.endpoint);
            return next == null ? r0.aboveAll() : r0.belowValue(next);
        }
    }

    public static final class d extends r0<Comparable<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f5212a = new d();
        private static final long serialVersionUID = 0;

        public d() {
            super("");
        }

        private Object readResolve() {
            return f5212a;
        }

        @Override // f1.r0
        public r0<Comparable<?>> canonical(w0<Comparable<?>> domain) {
            try {
                return r0.belowValue(domain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // f1.r0
        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append("(-∞");
        }

        @Override // f1.r0
        public void describeAsUpperBound(StringBuilder sb2) {
            throw new AssertionError();
        }

        @Override // f1.r0
        public Comparable<?> endpoint() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // f1.r0
        public Comparable<?> greatestValueBelow(w0<Comparable<?>> domain) {
            throw new AssertionError();
        }

        @Override // f1.r0
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // f1.r0
        public boolean isLessThan(Comparable<?> value) {
            return true;
        }

        @Override // f1.r0
        public Comparable<?> leastValueAbove(w0<Comparable<?>> domain) {
            return domain.minValue();
        }

        public String toString() {
            return "-∞";
        }

        @Override // f1.r0
        public x typeAsLowerBound() {
            throw new IllegalStateException();
        }

        @Override // f1.r0
        public x typeAsUpperBound() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // f1.r0
        public r0<Comparable<?>> withLowerBoundType(x boundType, w0<Comparable<?>> domain) {
            throw new IllegalStateException();
        }

        @Override // f1.r0
        public r0<Comparable<?>> withUpperBoundType(x boundType, w0<Comparable<?>> domain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // f1.r0, java.lang.Comparable
        public int compareTo(r0<Comparable<?>> o10) {
            return o10 == this ? 0 : -1;
        }
    }

    public static final class e<C extends Comparable> extends r0<C> {
        private static final long serialVersionUID = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C endpoint) {
            super(endpoint);
            endpoint.getClass();
        }

        @Override // f1.r0, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object that) {
            return super.compareTo((r0) that);
        }

        @Override // f1.r0
        public void describeAsLowerBound(StringBuilder sb2) {
            sb2.append(ks.a.f9445d);
            sb2.append(this.endpoint);
        }

        @Override // f1.r0
        public void describeAsUpperBound(StringBuilder sb2) {
            sb2.append(this.endpoint);
            sb2.append(')');
        }

        @Override // f1.r0
        @gm.a
        public C greatestValueBelow(w0<C> w0Var) {
            return (C) w0Var.previous(this.endpoint);
        }

        @Override // f1.r0
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // f1.r0
        public boolean isLessThan(C value) {
            return q5.compareOrThrow(this.endpoint, value) <= 0;
        }

        @Override // f1.r0
        public C leastValueAbove(w0<C> domain) {
            return this.endpoint;
        }

        public String toString() {
            return "\\" + this.endpoint + "/";
        }

        @Override // f1.r0
        public x typeAsLowerBound() {
            return x.CLOSED;
        }

        @Override // f1.r0
        public x typeAsUpperBound() {
            return x.OPEN;
        }

        @Override // f1.r0
        public r0<C> withLowerBoundType(x boundType, w0<C> domain) {
            int i10 = a.f5210a[boundType.ordinal()];
            if (i10 == 1) {
                return this;
            }
            if (i10 != 2) {
                throw new AssertionError();
            }
            Comparable comparablePrevious = domain.previous(this.endpoint);
            return comparablePrevious == null ? r0.belowAll() : new c(comparablePrevious);
        }

        @Override // f1.r0
        public r0<C> withUpperBoundType(x boundType, w0<C> domain) {
            int i10 = a.f5210a[boundType.ordinal()];
            if (i10 == 1) {
                Comparable comparablePrevious = domain.previous(this.endpoint);
                return comparablePrevious == null ? r0.aboveAll() : new c(comparablePrevious);
            }
            if (i10 == 2) {
                return this;
            }
            throw new AssertionError();
        }
    }

    public r0(C endpoint) {
        this.endpoint = endpoint;
    }

    public static <C extends Comparable> r0<C> aboveAll() {
        return b.f5211a;
    }

    public static <C extends Comparable> r0<C> aboveValue(C endpoint) {
        return new c(endpoint);
    }

    public static <C extends Comparable> r0<C> belowAll() {
        return d.f5212a;
    }

    public static <C extends Comparable> r0<C> belowValue(C endpoint) {
        return new e(endpoint);
    }

    public r0<C> canonical(w0<C> domain) {
        return this;
    }

    public abstract void describeAsLowerBound(StringBuilder sb2);

    public abstract void describeAsUpperBound(StringBuilder sb2);

    public C endpoint() {
        return this.endpoint;
    }

    public boolean equals(@gm.a Object obj) {
        if (!(obj instanceof r0)) {
            return false;
        }
        try {
            return compareTo((r0) obj) == 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @gm.a
    public abstract C greatestValueBelow(w0<C> domain);

    public abstract int hashCode();

    public abstract boolean isLessThan(C value);

    @gm.a
    public abstract C leastValueAbove(w0<C> domain);

    public abstract x typeAsLowerBound();

    public abstract x typeAsUpperBound();

    public abstract r0<C> withLowerBoundType(x boundType, w0<C> domain);

    public abstract r0<C> withUpperBoundType(x boundType, w0<C> domain);

    @Override // java.lang.Comparable
    public int compareTo(r0<C> that) {
        if (that == belowAll()) {
            return 1;
        }
        if (that == aboveAll()) {
            return -1;
        }
        int iCompareOrThrow = q5.compareOrThrow(this.endpoint, that.endpoint);
        return iCompareOrThrow != 0 ? iCompareOrThrow : o1.a.d(this instanceof c, that instanceof c);
    }
}
