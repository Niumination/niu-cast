package f1;

import io.netty.util.internal.StringUtil;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
@b1.b(serializable = true)
@x0
public final class s2<T> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @gm.a
    public transient s2<T> f5238a;
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final x lowerBoundType;

    @gm.a
    private final T lowerEndpoint;
    private final x upperBoundType;

    @gm.a
    private final T upperEndpoint;

    /* JADX WARN: Multi-variable type inference failed */
    public s2(Comparator<? super T> comparator, boolean hasLowerBound, @gm.a T lowerEndpoint, x lowerBoundType, boolean hasUpperBound, @gm.a T upperEndpoint, x upperBoundType) {
        comparator.getClass();
        this.comparator = comparator;
        this.hasLowerBound = hasLowerBound;
        this.hasUpperBound = hasUpperBound;
        this.lowerEndpoint = lowerEndpoint;
        lowerBoundType.getClass();
        this.lowerBoundType = lowerBoundType;
        this.upperEndpoint = upperEndpoint;
        upperBoundType.getClass();
        this.upperBoundType = upperBoundType;
        if (hasLowerBound) {
            comparator.compare(lowerEndpoint, lowerEndpoint);
        }
        if (hasUpperBound) {
            comparator.compare(upperEndpoint, upperEndpoint);
        }
        if (hasLowerBound && hasUpperBound) {
            int iCompare = comparator.compare(lowerEndpoint, upperEndpoint);
            c1.h0.y(iCompare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", lowerEndpoint, upperEndpoint);
            if (iCompare == 0) {
                x xVar = x.OPEN;
                c1.h0.d((lowerBoundType == xVar && upperBoundType == xVar) ? false : true);
            }
        }
    }

    public static <T> s2<T> all(Comparator<? super T> comparator) {
        x xVar = x.OPEN;
        return new s2<>(comparator, false, null, xVar, false, null, xVar);
    }

    public static <T> s2<T> downTo(Comparator<? super T> comparator, @m5 T endpoint, x boundType) {
        return new s2<>(comparator, true, endpoint, boundType, false, null, x.OPEN);
    }

    public static <T extends Comparable> s2<T> from(q5<T> range) {
        return new s2<>(l5.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : x.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : x.OPEN);
    }

    public static <T> s2<T> range(Comparator<? super T> comparator, @m5 T lower, x lowerType, @m5 T upper, x upperType) {
        return new s2<>(comparator, true, lower, lowerType, true, upper, upperType);
    }

    public static <T> s2<T> upTo(Comparator<? super T> comparator, @m5 T endpoint, x boundType) {
        return new s2<>(comparator, false, null, x.OPEN, true, endpoint, boundType);
    }

    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    public boolean contains(@m5 T t10) {
        return (tooLow(t10) || tooHigh(t10)) ? false : true;
    }

    public boolean equals(@gm.a Object obj) {
        if (!(obj instanceof s2)) {
            return false;
        }
        s2 s2Var = (s2) obj;
        return this.comparator.equals(s2Var.comparator) && this.hasLowerBound == s2Var.hasLowerBound && this.hasUpperBound == s2Var.hasUpperBound && getLowerBoundType().equals(s2Var.getLowerBoundType()) && getUpperBoundType().equals(s2Var.getUpperBoundType()) && c1.b0.a(getLowerEndpoint(), s2Var.getLowerEndpoint()) && c1.b0.a(getUpperEndpoint(), s2Var.getUpperEndpoint());
    }

    public x getLowerBoundType() {
        return this.lowerBoundType;
    }

    @gm.a
    public T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    public x getUpperBoundType() {
        return this.upperBoundType;
    }

    @gm.a
    public T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    public boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    public boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType()});
    }

    public s2<T> intersect(s2<T> other) {
        int iCompare;
        int iCompare2;
        T t10;
        x xVar;
        x xVar2;
        int iCompare3;
        x xVar3;
        other.getClass();
        c1.h0.d(this.comparator.equals(other.comparator));
        boolean z10 = this.hasLowerBound;
        T lowerEndpoint = getLowerEndpoint();
        x lowerBoundType = getLowerBoundType();
        if (!hasLowerBound()) {
            z10 = other.hasLowerBound;
            lowerEndpoint = other.getLowerEndpoint();
            lowerBoundType = other.getLowerBoundType();
        } else if (other.hasLowerBound() && ((iCompare = this.comparator.compare(getLowerEndpoint(), other.getLowerEndpoint())) < 0 || (iCompare == 0 && other.getLowerBoundType() == x.OPEN))) {
            lowerEndpoint = other.getLowerEndpoint();
            lowerBoundType = other.getLowerBoundType();
        }
        boolean z11 = z10;
        boolean z12 = this.hasUpperBound;
        T upperEndpoint = getUpperEndpoint();
        x upperBoundType = getUpperBoundType();
        if (!hasUpperBound()) {
            z12 = other.hasUpperBound;
            upperEndpoint = other.getUpperEndpoint();
            upperBoundType = other.getUpperBoundType();
        } else if (other.hasUpperBound() && ((iCompare2 = this.comparator.compare(getUpperEndpoint(), other.getUpperEndpoint())) > 0 || (iCompare2 == 0 && other.getUpperBoundType() == x.OPEN))) {
            upperEndpoint = other.getUpperEndpoint();
            upperBoundType = other.getUpperBoundType();
        }
        boolean z13 = z12;
        T t11 = upperEndpoint;
        if (z11 && z13 && ((iCompare3 = this.comparator.compare(lowerEndpoint, t11)) > 0 || (iCompare3 == 0 && lowerBoundType == (xVar3 = x.OPEN) && upperBoundType == xVar3))) {
            xVar = x.OPEN;
            xVar2 = x.CLOSED;
            t10 = t11;
        } else {
            t10 = lowerEndpoint;
            xVar = lowerBoundType;
            xVar2 = upperBoundType;
        }
        return new s2<>(this.comparator, z11, t10, xVar, z13, t11, xVar2);
    }

    public boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    public s2<T> reverse() {
        s2<T> s2Var = this.f5238a;
        if (s2Var != null) {
            return s2Var;
        }
        s2<T> s2Var2 = new s2<>(l5.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        s2Var2.f5238a = this;
        this.f5238a = s2Var2;
        return s2Var2;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.comparator);
        sb2.append(":");
        x xVar = this.lowerBoundType;
        x xVar2 = x.CLOSED;
        sb2.append(xVar == xVar2 ? ks.a.f9445d : '(');
        sb2.append(this.hasLowerBound ? this.lowerEndpoint : "-∞");
        sb2.append(StringUtil.COMMA);
        sb2.append(this.hasUpperBound ? this.upperEndpoint : "∞");
        sb2.append(this.upperBoundType == xVar2 ? ']' : ')');
        return sb2.toString();
    }

    public boolean tooHigh(@m5 T t10) {
        if (!hasUpperBound()) {
            return false;
        }
        int iCompare = this.comparator.compare(t10, getUpperEndpoint());
        return ((iCompare == 0) & (getUpperBoundType() == x.OPEN)) | (iCompare > 0);
    }

    public boolean tooLow(@m5 T t10) {
        if (!hasLowerBound()) {
            return false;
        }
        int iCompare = this.comparator.compare(t10, getLowerEndpoint());
        return ((iCompare == 0) & (getLowerBoundType() == x.OPEN)) | (iCompare < 0);
    }
}
