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
@b1.b
@f
public final class a {

    /* JADX INFO: renamed from: o1.a$a, reason: collision with other inner class name */
    @b1.b
    public static class C0306a extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        public C0306a(boolean[] array) {
            this(array, 0, array.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return (target instanceof Boolean) && a.l(this.array, ((Boolean) target).booleanValue(), this.start, this.end) != -1;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@gm.a Object object) {
            if (object == this) {
                return true;
            }
            if (!(object instanceof C0306a)) {
                return super.equals(object);
            }
            C0306a c0306a = (C0306a) object;
            int size = size();
            if (c0306a.size() != size) {
                return false;
            }
            for (int i10 = 0; i10 < size; i10++) {
                if (this.array[this.start + i10] != c0306a.array[c0306a.start + i10]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int iJ = 1;
            for (int i10 = this.start; i10 < this.end; i10++) {
                iJ = (iJ * 31) + a.j(this.array[i10]);
            }
            return iJ;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@gm.a Object target) {
            int iL;
            if (!(target instanceof Boolean) || (iL = a.l(this.array, ((Boolean) target).booleanValue(), this.start, this.end)) < 0) {
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
            int iP;
            if (!(target instanceof Boolean) || (iP = a.p(this.array, ((Boolean) target).booleanValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iP - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int fromIndex, int toIndex) {
            h0.f0(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i10 = this.start;
            return new C0306a(zArr, fromIndex + i10, i10 + toIndex);
        }

        public boolean[] toBooleanArray() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb2 = new StringBuilder(size() * 7);
            sb2.append(this.array[this.start] ? "[true" : "[false");
            int i10 = this.start;
            while (true) {
                i10++;
                if (i10 >= this.end) {
                    sb2.append(']');
                    return sb2.toString();
                }
                sb2.append(this.array[i10] ? ", true" : ", false");
            }
        }

        public C0306a(boolean[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean get(int index) {
            h0.C(index, size());
            return Boolean.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Boolean set(int index, Boolean element) {
            h0.C(index, size());
            boolean[] zArr = this.array;
            int i10 = this.start;
            boolean z10 = zArr[i10 + index];
            element.getClass();
            zArr[i10 + index] = element.booleanValue();
            return Boolean.valueOf(z10);
        }
    }

    public enum b implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");

        private final String toString;
        private final int trueValue;

        b(int trueValue, String toString) {
            this.trueValue = trueValue;
            this.toString = toString;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }

        @Override // java.util.Comparator
        public int compare(Boolean a10, Boolean b10) {
            return (b10.booleanValue() ? this.trueValue : 0) - (a10.booleanValue() ? this.trueValue : 0);
        }
    }

    public enum c implements Comparator<boolean[]> {
        INSTANCE;

        public static /* synthetic */ c[] a() {
            return new c[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(boolean[] left, boolean[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int iD = a.d(left[i10], right[i10]);
                if (iD != 0) {
                    return iD;
                }
            }
            return left.length - right.length;
        }
    }

    public static List<Boolean> c(boolean... backingArray) {
        return backingArray.length == 0 ? Collections.emptyList() : new C0306a(backingArray);
    }

    public static int d(boolean a10, boolean b10) {
        if (a10 == b10) {
            return 0;
        }
        return a10 ? 1 : -1;
    }

    public static boolean[] e(boolean[]... arrays) {
        int length = 0;
        for (boolean[] zArr : arrays) {
            length += zArr.length;
        }
        boolean[] zArr2 = new boolean[length];
        int length2 = 0;
        for (boolean[] zArr3 : arrays) {
            System.arraycopy(zArr3, 0, zArr2, length2, zArr3.length);
            length2 += zArr3.length;
        }
        return zArr2;
    }

    public static boolean f(boolean[] array, boolean target) {
        for (boolean z10 : array) {
            if (z10 == target) {
                return true;
            }
        }
        return false;
    }

    public static int g(boolean... values) {
        int i10 = 0;
        for (boolean z10 : values) {
            if (z10) {
                i10++;
            }
        }
        return i10;
    }

    public static boolean[] h(boolean[] array, int minLength, int padding) {
        h0.k(minLength >= 0, "Invalid minLength: %s", minLength);
        h0.k(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    public static Comparator<Boolean> i() {
        return b.FALSE_FIRST;
    }

    public static int j(boolean value) {
        return value ? 1231 : 1237;
    }

    public static int k(boolean[] array, boolean target) {
        return l(array, target, 0, array.length);
    }

    public static int l(boolean[] array, boolean target, int start, int end) {
        while (start < end) {
            if (array[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int m(boolean[] array, boolean[] target) {
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

    public static String n(String separator, boolean... array) {
        separator.getClass();
        if (array.length == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder(array.length * 7);
        sb2.append(array[0]);
        for (int i10 = 1; i10 < array.length; i10++) {
            sb2.append(separator);
            sb2.append(array[i10]);
        }
        return sb2.toString();
    }

    public static int o(boolean[] array, boolean target) {
        return p(array, target, 0, array.length);
    }

    public static int p(boolean[] array, boolean target, int start, int end) {
        for (int i10 = end - 1; i10 >= start; i10--) {
            if (array[i10] == target) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<boolean[]> q() {
        return c.INSTANCE;
    }

    public static void r(boolean[] array) {
        array.getClass();
        s(array, 0, array.length);
    }

    public static void s(boolean[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = toIndex - 1; fromIndex < i10; i10--) {
            boolean z10 = array[fromIndex];
            array[fromIndex] = array[i10];
            array[i10] = z10;
            fromIndex++;
        }
    }

    public static void t(boolean[] array, int distance) {
        u(array, distance, 0, array.length);
    }

    public static void u(boolean[] array, int distance, int fromIndex, int toIndex) {
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
        s(array, fromIndex, i12);
        s(array, i12, toIndex);
        s(array, fromIndex, toIndex);
    }

    public static boolean[] v(Collection<Boolean> collection) {
        if (collection instanceof C0306a) {
            return ((C0306a) collection).toBooleanArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            zArr[i10] = ((Boolean) obj).booleanValue();
        }
        return zArr;
    }

    public static Comparator<Boolean> w() {
        return b.TRUE_FIRST;
    }
}
