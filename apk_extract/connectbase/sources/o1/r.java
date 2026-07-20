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
import kn.p1;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@f
public final class r extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12046a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final short f12047b = 16384;

    public enum a implements Comparator<short[]> {
        INSTANCE;

        public static /* synthetic */ a[] a() {
            return new a[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(short[] left, short[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int i11 = left[i10] - right[i10];
                if (i11 != 0) {
                    return i11;
                }
            }
            return left.length - right.length;
        }
    }

    @b1.b
    public static class b extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        public b(short[] array) {
            this(array, 0, array.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return (target instanceof Short) && r.n(this.array, ((Short) target).shortValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@gm.a Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof b)) {
                return super.equals(object);
            }
            b bVar = (b) object;
            int size = size();
            if (bVar.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != bVar.array[bVar.start + i10]) {
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
            if (!(target instanceof Short) || (iN = r.n(this.array, ((Short) target).shortValue(), this.start, this.end)) < 0) {
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
            if (!(target instanceof Short) || (iR = r.r(this.array, ((Short) target).shortValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iR - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int fromIndex, int toIndex) {
            h0.f0(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i10 = this.start;
            return new b(sArr, fromIndex + i10, i10 + toIndex);
        }

        public short[] toShortArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 6);
            sb2.append(ks.a.f9445d);
            sb2.append((int) this.array[this.start]);
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(", ");
                sb2.append((int) this.array[i10]);
            }
        }

        public b(short[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractList, java.util.List
        public Short get(int index) {
            h0.C(index, size());
            return Short.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Short set(int index, Short element) {
            h0.C(index, size());
            short[] sArr = this.array;
            int i10 = this.start;
            short s10 = sArr[i10 + index];
            element.getClass();
            sArr[i10 + index] = element.shortValue();
            return Short.valueOf(s10);
        }
    }

    public static final class c extends c1.i<String, Short> implements Serializable {
        static final c INSTANCE = new c();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }

        @Override // c1.i
        public String doBackward(Short value) {
            return value.toString();
        }

        @Override // c1.i
        public Short doForward(String value) {
            return Short.decode(value);
        }
    }

    public static void A(short[] array) {
        array.getClass();
        B(array, 0, array.length);
    }

    public static void B(short[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        w(array, fromIndex, toIndex);
    }

    public static c1.i<String, Short> C() {
        return c.INSTANCE;
    }

    public static short[] D(Collection<? extends Number> collection) {
        if (collection instanceof b) {
            return ((b) collection).toShortArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            sArr[i10] = ((Number) obj).shortValue();
        }
        return sArr;
    }

    @b1.c
    public static byte[] E(short value) {
        return new byte[]{(byte) (value >> 8), (byte) value};
    }

    public static List<Short> c(short... backingArray) {
        return backingArray.length == 0 ? Collections.emptyList() : new b(backingArray);
    }

    public static short d(long value) {
        short s10 = (short) value;
        h0.p(((long) s10) == value, "Out of range: %s", value);
        return s10;
    }

    public static int e(short a10, short b10) {
        return a10 - b10;
    }

    public static short[] f(short[]... arrays) {
        int length = 0;
        for (short[] sArr : arrays) {
            length += sArr.length;
        }
        short[] sArr2 = new short[length];
        int length2 = 0;
        for (short[] sArr3 : arrays) {
            System.arraycopy(sArr3, 0, sArr2, length2, sArr3.length);
            length2 += sArr3.length;
        }
        return sArr2;
    }

    public static short g(short value, short min, short max) {
        h0.m(min <= max, "min (%s) must be less than or equal to max (%s)", min, max);
        if (value < min) {
            return min;
        }
        return value < max ? value : max;
    }

    public static boolean h(short[] array, short target) {
        for (short s10 : array) {
            if (s10 == target) {
                return true;
            }
        }
        return false;
    }

    public static short[] i(short[] array, int minLength, int padding) {
        h0.k(minLength >= 0, "Invalid minLength: %s", minLength);
        h0.k(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    @b1.c
    public static short j(byte[] bytes) {
        h0.m(bytes.length >= 2, "array too small: %s < %s", bytes.length, 2);
        return k(bytes[0], bytes[1]);
    }

    @b1.c
    public static short k(byte b10, byte b11) {
        return (short) ((b10 << 8) | (b11 & 255));
    }

    public static int l(short value) {
        return value;
    }

    public static int m(short[] array, short target) {
        return n(array, target, 0, array.length);
    }

    public static int n(short[] array, short target, int start, int end) {
        while (start < end) {
            if (array[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int o(short[] array, short[] target) {
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

    public static String p(String separator, short... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 6);
        sb2.append((int) array[0]);
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append((int) array[i10]);
        }
        return sb2.toString();
    }

    public static int q(short[] array, short target) {
        return r(array, target, 0, array.length);
    }

    public static int r(short[] array, short target, int start, int end) {
        for (int i10 = end - 1; i10 >= start; i10--) {
            if (array[i10] == target) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<short[]> s() {
        return a.INSTANCE;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short t(short... array) {
        h0.d(array.length > 0);
        short s10 = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            short s11 = array[i10];
            if (s11 > s10) {
                s10 = s11;
            }
        }
        return s10;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short u(short... array) {
        h0.d(array.length > 0);
        short s10 = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            short s11 = array[i10];
            if (s11 < s10) {
                s10 = s11;
            }
        }
        return s10;
    }

    public static void v(short[] array) {
        array.getClass();
        w(array, 0, array.length);
    }

    public static void w(short[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = toIndex - 1; fromIndex < i10; i10--) {
            short s10 = array[fromIndex];
            array[fromIndex] = array[i10];
            array[i10] = s10;
            fromIndex++;
        }
    }

    public static void x(short[] array, int distance) {
        y(array, distance, 0, array.length);
    }

    public static void y(short[] array, int distance, int fromIndex, int toIndex) {
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

    public static short z(long value) {
        if (value > 32767) {
            return p1.f9333c;
        }
        return value < -32768 ? p1.f9332b : (short) value;
    }
}
