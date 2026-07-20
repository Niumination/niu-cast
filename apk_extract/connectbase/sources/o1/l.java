package o1;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import c1.h0;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@f
public final class l extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12035a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f12036b = 1073741824;

    @b1.b
    public static class a extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        public a(int[] array) {
            this(array, 0, array.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return (target instanceof Integer) && l.n(this.array, ((Integer) target).intValue(), this.start, this.end) != -1;
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
            int i10 = 1;
            for (int i11 = this.start; i11 < this.end; i11++) {
                i10 = (i10 * 31) + this.array[i11];
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@gm.a Object target) {
            int iN;
            if (!(target instanceof Integer) || (iN = l.n(this.array, ((Integer) target).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iN - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@gm.a Object target) {
            int iR;
            if (!(target instanceof Integer) || (iR = l.r(this.array, ((Integer) target).intValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iR - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int fromIndex, int toIndex) {
            h0.f0(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i10 = this.start;
            return new a(iArr, fromIndex + i10, i10 + toIndex);
        }

        public int[] toIntArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 5);
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

        public a(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int index) {
            h0.C(index, size());
            return Integer.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer set(int index, Integer element) {
            h0.C(index, size());
            int[] iArr = this.array;
            int i10 = this.start;
            int i11 = iArr[i10 + index];
            element.getClass();
            iArr[i10 + index] = element.intValue();
            return Integer.valueOf(i11);
        }
    }

    public static final class b extends c1.i<String, Integer> implements Serializable {
        static final b INSTANCE = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Ints.stringConverter()";
        }

        @Override // c1.i
        public String doBackward(Integer value) {
            return value.toString();
        }

        @Override // c1.i
        public Integer doForward(String value) {
            return Integer.decode(value);
        }
    }

    public enum c implements Comparator<int[]> {
        INSTANCE;

        public static /* synthetic */ c[] a() {
            return new c[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(int[] left, int[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int iE = l.e(left[i10], right[i10]);
                if (iE != 0) {
                    return iE;
                }
            }
            return left.length - right.length;
        }
    }

    public static void A(int[] array) {
        array.getClass();
        B(array, 0, array.length);
    }

    public static void B(int[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        w(array, fromIndex, toIndex);
    }

    public static c1.i<String, Integer> C() {
        return b.INSTANCE;
    }

    public static int[] D(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).toIntArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            iArr[i10] = ((Number) obj).intValue();
        }
        return iArr;
    }

    public static byte[] E(int value) {
        return new byte[]{(byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value};
    }

    @gm.a
    public static Integer F(String string) {
        return G(string, 10);
    }

    @gm.a
    public static Integer G(String string, int radix) {
        Long lF = n.F(string, radix);
        if (lF == null || lF.longValue() != lF.intValue()) {
            return null;
        }
        return Integer.valueOf(lF.intValue());
    }

    public static List<Integer> c(int... backingArray) {
        return backingArray.length == 0 ? Collections.emptyList() : new a(backingArray);
    }

    public static int d(long value) {
        int i10 = (int) value;
        h0.p(((long) i10) == value, "Out of range: %s", value);
        return i10;
    }

    public static int e(int a10, int b10) {
        if (a10 < b10) {
            return -1;
        }
        return a10 > b10 ? 1 : 0;
    }

    public static int[] f(int[]... arrays) {
        int length = 0;
        for (int[] iArr : arrays) {
            length += iArr.length;
        }
        int[] iArr2 = new int[length];
        int length2 = 0;
        for (int[] iArr3 : arrays) {
            System.arraycopy(iArr3, 0, iArr2, length2, iArr3.length);
            length2 += iArr3.length;
        }
        return iArr2;
    }

    public static int g(int value, int min, int max) {
        h0.m(min <= max, "min (%s) must be less than or equal to max (%s)", min, max);
        return Math.min(Math.max(value, min), max);
    }

    public static boolean h(int[] array, int target) {
        for (int i10 : array) {
            if (i10 == target) {
                return true;
            }
        }
        return false;
    }

    public static int[] i(int[] array, int minLength, int padding) {
        h0.k(minLength >= 0, "Invalid minLength: %s", minLength);
        h0.k(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    public static int j(byte[] bytes) {
        h0.m(bytes.length >= 4, "array too small: %s < %s", bytes.length, 4);
        return k(bytes[0], bytes[1], bytes[2], bytes[3]);
    }

    public static int k(byte b10, byte b11, byte b12, byte b13) {
        return (b10 << c1.c.B) | ((b11 & 255) << 16) | ((b12 & 255) << 8) | (b13 & 255);
    }

    public static int l(int value) {
        return value;
    }

    public static int m(int[] array, int target) {
        return n(array, target, 0, array.length);
    }

    public static int n(int[] array, int target, int start, int end) {
        while (start < end) {
            if (array[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int o(int[] array, int[] target) {
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

    public static String p(String separator, int... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 5);
        sb2.append(array[0]);
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append(array[i10]);
        }
        return sb2.toString();
    }

    public static int q(int[] array, int target) {
        return r(array, target, 0, array.length);
    }

    public static int r(int[] array, int target, int start, int end) {
        for (int i10 = end - 1; i10 >= start; i10--) {
            if (array[i10] == target) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<int[]> s() {
        return c.INSTANCE;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int t(int... array) {
        h0.d(array.length > 0);
        int i10 = array[0];
        for (int i11 = 1; i11 < array.length; i11++) {
            int i12 = array[i11];
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int u(int... array) {
        h0.d(array.length > 0);
        int i10 = array[0];
        for (int i11 = 1; i11 < array.length; i11++) {
            int i12 = array[i11];
            if (i12 < i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    public static void v(int[] array) {
        array.getClass();
        w(array, 0, array.length);
    }

    public static void w(int[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = toIndex - 1; fromIndex < i10; i10--) {
            int i11 = array[fromIndex];
            array[fromIndex] = array[i10];
            array[i10] = i11;
            fromIndex++;
        }
    }

    public static void x(int[] array, int distance) {
        y(array, distance, 0, array.length);
    }

    public static void y(int[] array, int distance, int fromIndex, int toIndex) {
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
        w(array, fromIndex, i12);
        w(array, i12, toIndex);
        w(array, fromIndex, toIndex);
    }

    public static int z(long value) {
        if (value > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (value < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) value;
    }
}
