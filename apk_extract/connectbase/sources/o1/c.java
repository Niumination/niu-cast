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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12016a = 2;

    @b1.b
    public static class a extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        public a(char[] array) {
            this(array, 0, array.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return (target instanceof Character) && c.n(this.array, ((Character) target).charValue(), this.start, this.end) != -1;
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
            if (!(target instanceof Character) || (iN = c.n(this.array, ((Character) target).charValue(), this.start, this.end)) < 0) {
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
            if (!(target instanceof Character) || (iR = c.r(this.array, ((Character) target).charValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iR - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int fromIndex, int toIndex) {
            h0.f0(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i10 = this.start;
            return new a(cArr, fromIndex + i10, i10 + toIndex);
        }

        public char[] toCharArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 3);
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

        public a(char[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractList, java.util.List
        public Character get(int index) {
            h0.C(index, size());
            return Character.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Character set(int index, Character element) {
            h0.C(index, size());
            char[] cArr = this.array;
            int i10 = this.start;
            char c10 = cArr[i10 + index];
            element.getClass();
            cArr[i10 + index] = element.charValue();
            return Character.valueOf(c10);
        }
    }

    public enum b implements Comparator<char[]> {
        INSTANCE;

        public static /* synthetic */ b[] a() {
            return new b[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(char[] left, char[] right) {
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

    public static void A(char[] array) {
        array.getClass();
        B(array, 0, array.length);
    }

    public static void B(char[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        w(array, fromIndex, toIndex);
    }

    public static char[] C(Collection<Character> collection) {
        if (collection instanceof a) {
            return ((a) collection).toCharArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            cArr[i10] = ((Character) obj).charValue();
        }
        return cArr;
    }

    @b1.c
    public static byte[] D(char value) {
        return new byte[]{(byte) (value >> '\b'), (byte) value};
    }

    public static List<Character> c(char... backingArray) {
        return backingArray.length == 0 ? Collections.emptyList() : new a(backingArray);
    }

    public static char d(long value) {
        char c10 = (char) value;
        h0.p(((long) c10) == value, "Out of range: %s", value);
        return c10;
    }

    public static int e(char a10, char b10) {
        return a10 - b10;
    }

    public static char[] f(char[]... arrays) {
        int length = 0;
        for (char[] cArr : arrays) {
            length += cArr.length;
        }
        char[] cArr2 = new char[length];
        int length2 = 0;
        for (char[] cArr3 : arrays) {
            System.arraycopy(cArr3, 0, cArr2, length2, cArr3.length);
            length2 += cArr3.length;
        }
        return cArr2;
    }

    public static char g(char value, char min, char max) {
        h0.g(min <= max, "min (%s) must be less than or equal to max (%s)", min, max);
        if (value < min) {
            return min;
        }
        return value < max ? value : max;
    }

    public static boolean h(char[] array, char target) {
        for (char c10 : array) {
            if (c10 == target) {
                return true;
            }
        }
        return false;
    }

    public static char[] i(char[] array, int minLength, int padding) {
        h0.k(minLength >= 0, "Invalid minLength: %s", minLength);
        h0.k(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    @b1.c
    public static char j(byte[] bytes) {
        h0.m(bytes.length >= 2, "array too small: %s < %s", bytes.length, 2);
        return k(bytes[0], bytes[1]);
    }

    @b1.c
    public static char k(byte b10, byte b11) {
        return (char) ((b10 << 8) | (b11 & 255));
    }

    public static int l(char value) {
        return value;
    }

    public static int m(char[] array, char target) {
        return n(array, target, 0, array.length);
    }

    public static int n(char[] array, char target, int start, int end) {
        while (start < end) {
            if (array[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int o(char[] array, char[] target) {
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

    public static String p(String separator, char... array) {
        separator.getClass();
        int length = array.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(((length - 1) * separator.length()) + length);
        sb2.append(array[0]);
        for (int i10 = 1; i10 < length; i10++) {
            sb2.append(separator);
            sb2.append(array[i10]);
        }
        return sb2.toString();
    }

    public static int q(char[] array, char target) {
        return r(array, target, 0, array.length);
    }

    public static int r(char[] array, char target, int start, int end) {
        for (int i10 = end - 1; i10 >= start; i10--) {
            if (array[i10] == target) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<char[]> s() {
        return b.INSTANCE;
    }

    public static char t(char... array) {
        h0.d(array.length > 0);
        char c10 = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            char c11 = array[i10];
            if (c11 > c10) {
                c10 = c11;
            }
        }
        return c10;
    }

    public static char u(char... array) {
        h0.d(array.length > 0);
        char c10 = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            char c11 = array[i10];
            if (c11 < c10) {
                c10 = c11;
            }
        }
        return c10;
    }

    public static void v(char[] array) {
        array.getClass();
        w(array, 0, array.length);
    }

    public static void w(char[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = toIndex - 1; fromIndex < i10; i10--) {
            char c10 = array[fromIndex];
            array[fromIndex] = array[i10];
            array[i10] = c10;
            fromIndex++;
        }
    }

    public static void x(char[] array, int distance) {
        y(array, distance, 0, array.length);
    }

    public static void y(char[] array, int distance, int fromIndex, int toIndex) {
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

    public static char z(long value) {
        if (value > 65535) {
            return kn.r.f9345c;
        }
        if (value < 0) {
            return (char) 0;
        }
        return (char) value;
    }
}
