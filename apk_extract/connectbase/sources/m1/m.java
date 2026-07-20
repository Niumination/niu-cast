package m1;

import c1.h0;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@e
@b1.d
public final class m {

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10349a;

        public c a(int index) {
            return new c(this.f10349a, index);
        }

        public d b(Collection<Integer> indexes) {
            return new d(this.f10349a, o1.l.D(indexes));
        }

        public d c(int... indexes) {
            return new d(this.f10349a, (int[]) indexes.clone());
        }

        public b(int scale) {
            h0.e(scale > 0, "Quantile scale must be positive");
            this.f10349a = scale;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f10351b;

        public double a(Collection<? extends Number> dataset) {
            return e(o1.d.B(dataset));
        }

        public double b(double... dataset) {
            return e((double[]) dataset.clone());
        }

        public double c(int... dataset) {
            return e(m.l(dataset));
        }

        public double d(long... dataset) {
            return e(m.m(dataset));
        }

        public double e(double... dataset) {
            h0.e(dataset.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (m.j(dataset)) {
                return Double.NaN;
            }
            long length = ((long) this.f10351b) * ((long) (dataset.length - 1));
            int iG = (int) h.g(length, this.f10350a, RoundingMode.DOWN);
            int i10 = (int) (length - (((long) iG) * ((long) this.f10350a)));
            m.u(iG, dataset, 0, dataset.length - 1);
            if (i10 == 0) {
                return dataset[iG];
            }
            int i11 = iG + 1;
            m.u(i11, dataset, i11, dataset.length - 1);
            return m.k(dataset[iG], dataset[i11], i10, this.f10350a);
        }

        public c(int scale, int index) {
            m.h(index, scale);
            this.f10350a = scale;
            this.f10351b = index;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10352a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f10353b;

        public Map<Integer, Double> a(Collection<? extends Number> dataset) {
            return e(o1.d.B(dataset));
        }

        public Map<Integer, Double> b(double... dataset) {
            return e((double[]) dataset.clone());
        }

        public Map<Integer, Double> c(int... dataset) {
            return e(m.l(dataset));
        }

        public Map<Integer, Double> d(long... dataset) {
            return e(m.m(dataset));
        }

        public Map<Integer, Double> e(double... dataset) {
            int i10 = 0;
            h0.e(dataset.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (m.j(dataset)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.f10353b;
                int length = iArr.length;
                while (i10 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i10]), Double.valueOf(Double.NaN));
                    i10++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.f10353b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int[] iArr6 = this.f10353b;
                if (i11 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i11]) * ((long) (dataset.length - 1));
                int iG = (int) h.g(length2, this.f10352a, RoundingMode.DOWN);
                int i13 = (int) (length2 - (((long) iG) * ((long) this.f10352a)));
                iArr3[i11] = iG;
                iArr4[i11] = i13;
                iArr5[i12] = iG;
                int i14 = i12 + 1;
                if (i13 != 0) {
                    iArr5[i14] = iG + 1;
                    i12 += 2;
                } else {
                    i12 = i14;
                }
                i11++;
            }
            Arrays.sort(iArr5, 0, i12);
            m.t(iArr5, 0, i12 - 1, dataset, 0, dataset.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.f10353b;
                if (i10 >= iArr7.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i15 = iArr3[i10];
                int i16 = iArr4[i10];
                if (i16 == 0) {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i10]), Double.valueOf(dataset[i15]));
                } else {
                    linkedHashMap2.put(Integer.valueOf(iArr7[i10]), Double.valueOf(m.k(dataset[i15], dataset[i15 + 1], i16, this.f10352a)));
                }
                i10++;
            }
        }

        public d(int scale, int[] indexes) {
            for (int i10 : indexes) {
                m.h(i10, scale);
            }
            h0.e(indexes.length > 0, "Indexes must be a non empty array");
            this.f10352a = scale;
            this.f10353b = indexes;
        }
    }

    public static void h(int index, int scale) {
        if (index < 0 || index > scale) {
            throw new IllegalArgumentException(h.a.a("Quantile indexes must be between 0 and the scale, which is ", scale));
        }
    }

    public static int i(int[] allRequired, int requiredFrom, int requiredTo, int from, int to2) {
        if (requiredFrom == requiredTo) {
            return requiredFrom;
        }
        int i10 = from + to2;
        int i11 = i10 >>> 1;
        while (requiredTo > requiredFrom + 1) {
            int i12 = (requiredFrom + requiredTo) >>> 1;
            int i13 = allRequired[i12];
            if (i13 > i11) {
                requiredTo = i12;
            } else {
                if (i13 >= i11) {
                    return i12;
                }
                requiredFrom = i12;
            }
        }
        return (i10 - allRequired[requiredFrom]) - allRequired[requiredTo] > 0 ? requiredTo : requiredFrom;
    }

    public static boolean j(double... dataset) {
        for (double d10 : dataset) {
            if (Double.isNaN(d10)) {
                return true;
            }
        }
        return false;
    }

    public static double k(double lower, double upper, double remainder, double scale) {
        if (lower == Double.NEGATIVE_INFINITY) {
            return upper == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (upper == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return (((upper - lower) * remainder) / scale) + lower;
    }

    public static double[] l(int[] ints) {
        int length = ints.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = ints[i10];
        }
        return dArr;
    }

    public static double[] m(long[] longs) {
        int length = longs.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            dArr[i10] = longs[i10];
        }
        return dArr;
    }

    public static c n() {
        return new b(2).a(1);
    }

    public static void o(double[] array, int from, int to2) {
        int i10 = (from + to2) >>> 1;
        double d10 = array[to2];
        double d11 = array[i10];
        boolean z10 = d10 < d11;
        double d12 = array[from];
        boolean z11 = d11 < d12;
        boolean z12 = d10 < d12;
        if (z10 == z11) {
            v(array, i10, from);
        } else if (z10 != z12) {
            v(array, from, to2);
        }
    }

    public static int p(double[] array, int from, int to2) {
        o(array, from, to2);
        double d10 = array[from];
        int i10 = to2;
        while (to2 > from) {
            if (array[to2] > d10) {
                v(array, i10, to2);
                i10--;
            }
            to2--;
        }
        v(array, from, i10);
        return i10;
    }

    public static b q() {
        return new b(100);
    }

    public static b r() {
        return new b(4);
    }

    public static b s(int scale) {
        return new b(scale);
    }

    public static void t(int[] allRequired, int requiredFrom, int requiredTo, double[] array, int from, int to2) {
        int i10 = i(allRequired, requiredFrom, requiredTo, from, to2);
        int i11 = allRequired[i10];
        u(i11, array, from, to2);
        int i12 = i10 - 1;
        while (i12 >= requiredFrom && allRequired[i12] == i11) {
            i12--;
        }
        if (i12 >= requiredFrom) {
            t(allRequired, requiredFrom, i12, array, from, i11 - 1);
        }
        int i13 = i10 + 1;
        while (i13 <= requiredTo && allRequired[i13] == i11) {
            i13++;
        }
        if (i13 <= requiredTo) {
            t(allRequired, i13, requiredTo, array, i11 + 1, to2);
        }
    }

    public static void u(int required, double[] array, int from, int to2) {
        if (required != from) {
            while (to2 > from) {
                int iP = p(array, from, to2);
                if (iP >= required) {
                    to2 = iP - 1;
                }
                if (iP <= required) {
                    from = iP + 1;
                }
            }
            return;
        }
        int i10 = from;
        for (int i11 = from + 1; i11 <= to2; i11++) {
            if (array[i10] > array[i11]) {
                i10 = i11;
            }
        }
        if (i10 != from) {
            v(array, i10, from);
        }
    }

    public static void v(double[] array, int i10, int j10) {
        double d10 = array[i10];
        array[i10] = array[j10];
        array[j10] = d10;
    }
}
