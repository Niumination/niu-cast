package m1;

import c1.h0;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public abstract class p<X extends Number & Comparable<X>> {

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10359a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f10359a = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10359a[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10359a[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10359a[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10359a[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10359a[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10359a[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10359a[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public abstract X a(X a10, X b10);

    public final double b(X x10, RoundingMode mode) {
        Number numberE;
        double dNextUp;
        h0.F(x10, "x");
        h0.F(mode, "mode");
        double dC = c(x10);
        if (Double.isInfinite(dC)) {
            switch (a.f10359a[mode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return ((double) d(x10)) * Double.MAX_VALUE;
                case 5:
                    return dC == Double.POSITIVE_INFINITY ? Double.MAX_VALUE : Double.NEGATIVE_INFINITY;
                case 6:
                    return dC == Double.POSITIVE_INFINITY ? Double.POSITIVE_INFINITY : -1.7976931348623157E308d;
                case 7:
                    return dC;
                case 8:
                    throw new ArithmeticException(x10 + " cannot be represented precisely as a double");
            }
        }
        Number numberE2 = e(dC, RoundingMode.UNNECESSARY);
        int iCompareTo = ((Comparable) x10).compareTo(numberE2);
        int[] iArr = a.f10359a;
        switch (iArr[mode.ordinal()]) {
            case 1:
                if (d(x10) >= 0) {
                    return iCompareTo >= 0 ? dC : -Math.nextUp(-dC);
                }
                return iCompareTo <= 0 ? dC : Math.nextUp(dC);
            case 2:
            case 3:
            case 4:
                if (iCompareTo >= 0) {
                    dNextUp = Math.nextUp(dC);
                    if (dNextUp == Double.POSITIVE_INFINITY) {
                        return dC;
                    }
                    numberE = e(dNextUp, RoundingMode.CEILING);
                } else {
                    double d10 = -Math.nextUp(-dC);
                    if (d10 == Double.NEGATIVE_INFINITY) {
                        return dC;
                    }
                    Number numberE3 = e(d10, RoundingMode.FLOOR);
                    numberE = numberE2;
                    numberE2 = numberE3;
                    dNextUp = dC;
                    dC = d10;
                }
                int iCompareTo2 = ((Comparable) a(x10, numberE2)).compareTo(a(numberE, x10));
                if (iCompareTo2 < 0) {
                    return dC;
                }
                if (iCompareTo2 > 0) {
                    return dNextUp;
                }
                int i10 = iArr[mode.ordinal()];
                if (i10 == 2) {
                    return (Double.doubleToRawLongBits(dC) & 1) == 0 ? dC : dNextUp;
                }
                if (i10 == 3) {
                    return d(x10) >= 0 ? dC : dNextUp;
                }
                if (i10 == 4) {
                    return d(x10) >= 0 ? dNextUp : dC;
                }
                throw new AssertionError("impossible");
            case 5:
                return iCompareTo >= 0 ? dC : -Math.nextUp(-dC);
            case 6:
                return iCompareTo <= 0 ? dC : Math.nextUp(dC);
            case 7:
                if (d(x10) >= 0) {
                    return iCompareTo <= 0 ? dC : Math.nextUp(dC);
                }
                return iCompareTo >= 0 ? dC : -Math.nextUp(-dC);
            case 8:
                i.k(iCompareTo == 0);
                return dC;
            default:
                throw new AssertionError("impossible");
        }
    }

    public abstract double c(X x10);

    public abstract int d(X x10);

    public abstract X e(double d10, RoundingMode mode);
}
