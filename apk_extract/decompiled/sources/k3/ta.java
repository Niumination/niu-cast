package k3;

import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
public abstract class ta {
    public static int a(int i8, int i9, RoundingMode roundingMode) {
        roundingMode.getClass();
        if (i9 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i10 = i8 / i9;
        int i11 = i8 - (i9 * i10);
        if (i11 == 0) {
            return i10;
        }
        int i12 = ((i8 ^ i9) >> 31) | 1;
        switch (k4.a.f6765a[roundingMode.ordinal()]) {
            case 1:
                if (i11 == 0) {
                    return i10;
                }
                throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
            case 2:
                return i10;
            case 3:
                if (i12 >= 0) {
                    return i10;
                }
                break;
            case 4:
                break;
            case 5:
                if (i12 <= 0) {
                    return i10;
                }
                break;
            case 6:
            case 7:
            case 8:
                int iAbs = Math.abs(i11);
                int iAbs2 = iAbs - (Math.abs(i9) - iAbs);
                if (iAbs2 == 0) {
                    if (roundingMode != RoundingMode.HALF_UP) {
                        if (!((roundingMode == RoundingMode.HALF_EVEN) & ((i10 & 1) != 0))) {
                            return i10;
                        }
                    }
                } else if (iAbs2 <= 0) {
                    return i10;
                }
            default:
                throw new AssertionError();
        }
        return i10 + i12;
    }

    public static int b(int i8, RoundingMode roundingMode) {
        if (i8 <= 0) {
            throw new IllegalArgumentException(h0.a.h(i8, "x (", ") must be > 0"));
        }
        switch (k4.a.f6765a[roundingMode.ordinal()]) {
            case 1:
                if (!((i8 > 0) & (((i8 + (-1)) & i8) == 0))) {
                    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                }
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i8 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(i8);
                return (31 - iNumberOfLeadingZeros) + ((~(~(((-1257966797) >>> iNumberOfLeadingZeros) - i8))) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i8);
    }
}
