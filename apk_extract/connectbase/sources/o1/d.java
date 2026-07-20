package o1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import c1.h0;
import c1.p0;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@f
public final class d extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12018a = 8;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @b1.c
    @b1.d
    public static final Pattern f12019b = i();

    @b1.b
    public static class a extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        public a(double[] array) {
            this(array, 0, array.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return (target instanceof Double) && d.l(this.array, ((Double) target).doubleValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@gm.a Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof a)) {
                return super.equals(object);
            }
            a aVar = (a) object;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != aVar.array[aVar.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iJ = 1;
            for (int i10 = this.start; i10 < this.end; i10++) {
                iJ = (iJ * 31) + d.j(this.array[i10]);
            }
            return iJ;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@gm.a Object target) {
            int iL;
            if (!(target instanceof Double) || (iL = d.l(this.array, ((Double) target).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iL - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@gm.a Object target) {
            int iQ;
            if (!(target instanceof Double) || (iQ = d.q(this.array, ((Double) target).doubleValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iQ - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int fromIndex, int toIndex) {
            h0.f0(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i10 = this.start;
            return new a(dArr, fromIndex + i10, i10 + toIndex);
        }

        public double[] toDoubleArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 12);
            sb2.append(ks.a.f9445d);
            sb2.append(this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append(this.array[i10]);
            }
        }

        public a(double[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int index) {
            h0.C(index, size());
            return Double.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Double set(int index, Double element) {
            h0.C(index, size());
            double[] dArr = this.array;
            int i10 = this.start;
            double d10 = dArr[i10 + index];
            element.getClass();
            dArr[i10 + index] = element.doubleValue();
            return Double.valueOf(d10);
        }
    }

    public static final class b extends c1.i<String, Double> implements Serializable {
        static final b INSTANCE = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }

        @Override // c1.i
        public String doBackward(Double value) {
            return value.toString();
        }

        @Override // c1.i
        public Double doForward(String value) {
            return Double.valueOf(value);
        }
    }

    public enum c implements Comparator<double[]> {
        INSTANCE;

        public static /* synthetic */ c[] a() {
            return new c[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(double[] left, double[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int iCompare = Double.compare(left[i10], right[i10]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return left.length - right.length;
        }
    }

    public static c1.i<String, Double> A() {
        return b.INSTANCE;
    }

    public static double[] B(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).toDoubleArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            dArr[i10] = ((Number) obj).doubleValue();
        }
        return dArr;
    }

    @b1.c
    @gm.a
    @b1.d
    public static Double C(String string) {
        if (!f12019b.matcher(string).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(string));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static List<Double> c(double... backingArray) {
        return backingArray.length == 0 ? Collections.emptyList() : new a(backingArray);
    }

    public static int d(double a10, double b10) {
        return Double.compare(a10, b10);
    }

    public static double[] e(double[]... arrays) {
        int length = 0;
        for (double[] dArr : arrays) {
            length += dArr.length;
        }
        double[] dArr2 = new double[length];
        int length2 = 0;
        for (double[] dArr3 : arrays) {
            System.arraycopy(dArr3, 0, dArr2, length2, dArr3.length);
            length2 += dArr3.length;
        }
        return dArr2;
    }

    public static double f(double value, double min, double max) {
        if (min <= max) {
            return Math.min(Math.max(value, min), max);
        }
        throw new IllegalArgumentException(p0.e("min (%s) must be less than or equal to max (%s)", Double.valueOf(min), Double.valueOf(max)));
    }

    public static boolean g(double[] array, double target) {
        for (double d10 : array) {
            if (d10 == target) {
                return true;
            }
        }
        return false;
    }

    public static double[] h(double[] array, int minLength, int padding) {
        h0.k(minLength >= 0, "Invalid minLength: %s", minLength);
        h0.k(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    @b1.c
    public static Pattern i() {
        return Pattern.compile("[+-]?(?:NaN|Infinity|(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?|0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?)".replace("#", ps.d.ANY_NON_NULL_MARKER));
    }

    public static int j(double value) {
        return Double.valueOf(value).hashCode();
    }

    public static int k(double[] array, double target) {
        return l(array, target, 0, array.length);
    }

    public static int l(double[] array, double target, int start, int end) {
        while (start < end) {
            if (array[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int m(double[] array, double[] target) {
        h0.F(array, dc.d.f3685p);
        h0.F(target, TypedValues.AttributesType.S_TARGET);
        if (target.length == 0) {
            return 0;
        }
        for (int i10 = 0; i10 < (array.length - target.length) + 1; i10++) {
            for (int i11 = 0; i11 < target.length; i11++) {
                if (array[i10 + i11] != target[i11]) {
                }
            }
            return i10;
        }
        return -1;
    }

    public static boolean n(double value) {
        return Double.NEGATIVE_INFINITY < value && value < Double.POSITIVE_INFINITY;
    }

    public static String o(String separator, double... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 12);
        sb2.append(array[0]);
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append(array[i10]);
        }
        return sb2.toString();
    }

    public static int p(double[] array, double target) {
        return q(array, target, 0, array.length);
    }

    public static int q(double[] array, double target, int start, int end) {
        for (int i10 = end - 1; i10 >= start; i10--) {
            if (array[i10] == target) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<double[]> r() {
        return c.INSTANCE;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double s(double... array) {
        h0.d(array.length > 0);
        double dMax = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            dMax = Math.max(dMax, array[i10]);
        }
        return dMax;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double t(double... array) {
        h0.d(array.length > 0);
        double dMin = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            dMin = Math.min(dMin, array[i10]);
        }
        return dMin;
    }

    public static void u(double[] array) {
        array.getClass();
        v(array, 0, array.length);
    }

    public static void v(double[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = toIndex - 1; fromIndex < i10; i10--) {
            double d10 = array[fromIndex];
            array[fromIndex] = array[i10];
            array[i10] = d10;
            fromIndex++;
        }
    }

    public static void w(double[] array, int distance) {
        x(array, distance, 0, array.length);
    }

    public static void x(double[] array, int distance, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        if (array.length <= 1) {
            return;
        }
        int i10 = toIndex - fromIndex;
        int i11 = (-distance) % i10;
        if (i11 < 0) {
            i11 += i10;
        }
        int i12 = i11 + fromIndex;
        if (i12 == fromIndex) {
            return;
        }
        v(array, fromIndex, i12);
        v(array, i12, toIndex);
        v(array, fromIndex, toIndex);
    }

    public static void y(double[] array) {
        array.getClass();
        z(array, 0, array.length);
    }

    public static void z(double[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        v(array, fromIndex, toIndex);
    }
}
