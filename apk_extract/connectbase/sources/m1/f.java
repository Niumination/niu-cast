package m1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import c1.h0;
import e8.w;
import java.math.RoundingMode;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@e
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @b1.e
    public static final int f10315a = 1073741824;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1.e
    public static final int f10316b = -1257966797;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @b1.e
    public static final int f10320f = 46340;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @b1.e
    public static final byte[] f10317c = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @b1.e
    public static final int[] f10318d = {1, 10, 100, 1000, 10000, w.f4155d, lq.g.f10254a, 10000000, 100000000, z0.h.f21762a};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @b1.e
    public static final int[] f10319e = {3, 31, TypedValues.AttributesType.TYPE_PATH_ROTATE, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f10321g = {1, 1, 2, 6, 24, 120, w4.c.f17970e, 5040, 40320, 362880, 3628800, 39916800, 479001600};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @b1.e
    public static int[] f10322h = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10323a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f10323a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10323a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10323a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10323a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10323a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10323a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10323a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10323a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int n10, int k10) {
        i.e(p6.n.f13005a, n10);
        i.e("k", k10);
        int i10 = 0;
        h0.m(k10 <= n10, "k (%s) > n (%s)", k10, n10);
        if (k10 > (n10 >> 1)) {
            k10 = n10 - k10;
        }
        int[] iArr = f10322h;
        if (k10 >= iArr.length || n10 > iArr[k10]) {
            return Integer.MAX_VALUE;
        }
        if (k10 == 0) {
            return 1;
        }
        if (k10 == 1) {
            return n10;
        }
        long j10 = 1;
        while (i10 < k10) {
            long j11 = j10 * ((long) (n10 - i10));
            i10++;
            j10 = j11 / ((long) i10);
        }
        return (int) j10;
    }

    public static int b(int x10) {
        i.h("x", x10);
        if (x10 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(x10 - 1));
        }
        throw new ArithmeticException(k.b.a("ceilingPowerOfTwo(", x10, ") not representable as an int"));
    }

    public static int c(int a10, int b10) {
        long j10 = ((long) a10) + ((long) b10);
        int i10 = (int) j10;
        i.b(j10 == ((long) i10), "checkedAdd", a10, b10);
        return i10;
    }

    public static int d(int a10, int b10) {
        long j10 = ((long) a10) * ((long) b10);
        int i10 = (int) j10;
        i.b(j10 == ((long) i10), "checkedMultiply", a10, b10);
        return i10;
    }

    public static int e(int b10, int k10) {
        i.e("exponent", k10);
        if (b10 == -2) {
            i.b(k10 < 32, "checkedPow", b10, k10);
            return (k10 & 1) == 0 ? 1 << k10 : (-1) << k10;
        }
        if (b10 == -1) {
            return (k10 & 1) == 0 ? 1 : -1;
        }
        if (b10 == 0) {
            return k10 == 0 ? 1 : 0;
        }
        if (b10 == 1) {
            return 1;
        }
        if (b10 == 2) {
            i.b(k10 < 31, "checkedPow", b10, k10);
            return 1 << k10;
        }
        int iD = 1;
        while (k10 != 0) {
            if (k10 == 1) {
                return d(iD, b10);
            }
            if ((k10 & 1) != 0) {
                iD = d(iD, b10);
            }
            k10 >>= 1;
            if (k10 > 0) {
                i.b((-46340 <= b10) & (b10 <= 46340), "checkedPow", b10, k10);
                b10 *= b10;
            }
        }
        return iD;
    }

    public static int f(int a10, int b10) {
        long j10 = ((long) a10) - ((long) b10);
        int i10 = (int) j10;
        i.b(j10 == ((long) i10), "checkedSubtract", a10, b10);
        return i10;
    }

    public static int g(int p10, int q10, RoundingMode mode) {
        mode.getClass();
        if (q10 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i10 = p10 / q10;
        int i11 = p10 - (q10 * i10);
        if (i11 == 0) {
            return i10;
        }
        int i12 = ((p10 ^ q10) >> 31) | 1;
        switch (a.f10323a[mode.ordinal()]) {
            case 1:
                i.k(i11 == 0);
                return i10;
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
                int iAbs2 = iAbs - (Math.abs(q10) - iAbs);
                if (iAbs2 == 0) {
                    if (mode != RoundingMode.HALF_UP) {
                        if (!((mode == RoundingMode.HALF_EVEN) & ((i10 & 1) != 0))) {
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

    public static int h(int n10) {
        i.e(p6.n.f13005a, n10);
        int[] iArr = f10321g;
        if (n10 < iArr.length) {
            return iArr[n10];
        }
        return Integer.MAX_VALUE;
    }

    public static int i(int x10) {
        i.h("x", x10);
        return Integer.highestOneBit(x10);
    }

    public static int j(int a10, int b10) {
        i.e("a", a10);
        i.e("b", b10);
        if (a10 == 0) {
            return b10;
        }
        if (b10 == 0) {
            return a10;
        }
        int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(a10);
        int iNumberOfTrailingZeros2 = a10 >> iNumberOfTrailingZeros;
        int iNumberOfTrailingZeros3 = Integer.numberOfTrailingZeros(b10);
        int i10 = b10 >> iNumberOfTrailingZeros3;
        while (iNumberOfTrailingZeros2 != i10) {
            int i11 = iNumberOfTrailingZeros2 - i10;
            int i12 = (i11 >> 31) & i11;
            int i13 = (i11 - i12) - i12;
            i10 += i12;
            iNumberOfTrailingZeros2 = i13 >> Integer.numberOfTrailingZeros(i13);
        }
        return iNumberOfTrailingZeros2 << Math.min(iNumberOfTrailingZeros, iNumberOfTrailingZeros3);
    }

    public static boolean k(int x10) {
        return (x10 > 0) & ((x10 & (x10 + (-1))) == 0);
    }

    @b1.c
    @b1.d
    public static boolean l(int n10) {
        return h.m(n10);
    }

    @b1.e
    public static int m(int x10, int y10) {
        return (~(~(x10 - y10))) >>> 31;
    }

    @b1.c
    @b1.d
    public static int n(int x10, RoundingMode mode) {
        int iM;
        i.h("x", x10);
        int iO = o(x10);
        int i10 = f10318d[iO];
        switch (a.f10323a[mode.ordinal()]) {
            case 1:
                i.k(x10 == i10);
            case 2:
            case 3:
                return iO;
            case 4:
            case 5:
                iM = m(i10, x10);
                return iM + iO;
            case 6:
            case 7:
            case 8:
                iM = m(f10319e[iO], x10);
                return iM + iO;
            default:
                throw new AssertionError();
        }
    }

    public static int o(int x10) {
        byte b10 = f10317c[Integer.numberOfLeadingZeros(x10)];
        return b10 - m(x10, f10318d[b10]);
    }

    public static int p(int x10, RoundingMode mode) {
        i.h("x", x10);
        switch (a.f10323a[mode.ordinal()]) {
            case 1:
                i.k(k(x10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(x10 - 1);
            case 6:
            case 7:
            case 8:
                int iNumberOfLeadingZeros = Integer.numberOfLeadingZeros(x10);
                return m(f10316b >>> iNumberOfLeadingZeros, x10) + (31 - iNumberOfLeadingZeros);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(x10);
    }

    public static int q(int x10, int y10) {
        return (x10 & y10) + ((x10 ^ y10) >> 1);
    }

    public static int r(int x10, int m10) {
        if (m10 <= 0) {
            throw new ArithmeticException(k.b.a("Modulus ", m10, " must be > 0"));
        }
        int i10 = x10 % m10;
        return i10 >= 0 ? i10 : i10 + m10;
    }

    @b1.c
    @b1.d
    public static int s(int b10, int k10) {
        i.e("exponent", k10);
        if (b10 == -2) {
            if (k10 < 32) {
                return (k10 & 1) == 0 ? 1 << k10 : -(1 << k10);
            }
            return 0;
        }
        if (b10 == -1) {
            return (k10 & 1) == 0 ? 1 : -1;
        }
        if (b10 == 0) {
            return k10 == 0 ? 1 : 0;
        }
        if (b10 == 1) {
            return 1;
        }
        if (b10 == 2) {
            if (k10 < 32) {
                return 1 << k10;
            }
            return 0;
        }
        int i10 = 1;
        while (k10 != 0) {
            if (k10 == 1) {
                return b10 * i10;
            }
            i10 *= (k10 & 1) == 0 ? 1 : b10;
            b10 *= b10;
            k10 >>= 1;
        }
        return i10;
    }

    public static int t(int a10, int b10) {
        return o1.l.z(((long) a10) + ((long) b10));
    }

    public static int u(int a10, int b10) {
        return o1.l.z(((long) a10) * ((long) b10));
    }

    public static int v(int b10, int k10) {
        i.e("exponent", k10);
        if (b10 == -2) {
            if (k10 >= 32) {
                return (k10 & 1) + Integer.MAX_VALUE;
            }
            return (k10 & 1) == 0 ? 1 << k10 : (-1) << k10;
        }
        if (b10 == -1) {
            return (k10 & 1) == 0 ? 1 : -1;
        }
        if (b10 == 0) {
            return k10 == 0 ? 1 : 0;
        }
        if (b10 == 1) {
            return 1;
        }
        if (b10 == 2) {
            if (k10 >= 31) {
                return Integer.MAX_VALUE;
            }
            return 1 << k10;
        }
        int i10 = ((b10 >>> 31) & k10 & 1) + Integer.MAX_VALUE;
        int iU = 1;
        while (k10 != 0) {
            if (k10 == 1) {
                return u(iU, b10);
            }
            if ((k10 & 1) != 0) {
                iU = u(iU, b10);
            }
            k10 >>= 1;
            if (k10 > 0) {
                if ((-46340 > b10) || (b10 > 46340)) {
                    return i10;
                }
                b10 *= b10;
            }
        }
        return iU;
    }

    public static int w(int a10, int b10) {
        return o1.l.z(((long) a10) - ((long) b10));
    }

    @b1.c
    public static int x(int x10, RoundingMode mode) {
        int iM;
        i.e("x", x10);
        int iSqrt = (int) Math.sqrt(x10);
        switch (a.f10323a[mode.ordinal()]) {
            case 1:
                i.k(iSqrt * iSqrt == x10);
            case 2:
            case 3:
                return iSqrt;
            case 4:
            case 5:
                iM = m(iSqrt * iSqrt, x10);
                return iM + iSqrt;
            case 6:
            case 7:
            case 8:
                iM = m((iSqrt * iSqrt) + iSqrt, x10);
                return iM + iSqrt;
            default:
                throw new AssertionError();
        }
    }

    public static int y(int x10) {
        return (int) Math.sqrt(x10);
    }
}
