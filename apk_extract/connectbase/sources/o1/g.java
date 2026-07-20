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

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@f
public final class g extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f12021a = 4;

    @b1.b
    public static class a extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        public a(float[] array) {
            this(array, 0, array.length);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return (target instanceof Float) && g.k(this.array, ((Float) target).floatValue(), this.start, this.end) != -1;
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
                i10 = (i10 * 31) + g.i(this.array[i11]);
            }
            return i10;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@gm.a Object target) {
            int iK;
            if (!(target instanceof Float) || (iK = g.k(this.array, ((Float) target).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iK - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@gm.a Object target) {
            int iP;
            if (!(target instanceof Float) || (iP = g.p(this.array, ((Float) target).floatValue(), this.start, this.end)) < 0) {
                return -1;
            }
            return iP - this.start;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int fromIndex, int toIndex) {
            h0.f0(fromIndex, toIndex, size());
            if (fromIndex == toIndex) {
                return Collections.emptyList();
            }
            float[] fArr = this.array;
            int i10 = this.start;
            return new a(fArr, fromIndex + i10, i10 + toIndex);
        }

        public float[] toFloatArray() {
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

        public a(float[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override // java.util.AbstractList, java.util.List
        public Float get(int index) {
            h0.C(index, size());
            return Float.valueOf(this.array[this.start + index]);
        }

        @Override // java.util.AbstractList, java.util.List
        public Float set(int index, Float element) {
            h0.C(index, size());
            float[] fArr = this.array;
            int i10 = this.start;
            float f10 = fArr[i10 + index];
            element.getClass();
            fArr[i10 + index] = element.floatValue();
            return Float.valueOf(f10);
        }
    }

    public static final class b extends c1.i<String, Float> implements Serializable {
        static final b INSTANCE = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        public String toString() {
            return "Floats.stringConverter()";
        }

        @Override // c1.i
        public String doBackward(Float value) {
            return value.toString();
        }

        @Override // c1.i
        public Float doForward(String value) {
            return Float.valueOf(value);
        }
    }

    public enum c implements Comparator<float[]> {
        INSTANCE;

        public static /* synthetic */ c[] a() {
            return new c[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }

        @Override // java.util.Comparator
        public int compare(float[] left, float[] right) {
            int iMin = Math.min(left.length, right.length);
            for (int i10 = 0; i10 < iMin; i10++) {
                int iCompare = Float.compare(left[i10], right[i10]);
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return left.length - right.length;
        }
    }

    public static float[] A(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).toFloatArray();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i10 = 0; i10 < length; i10++) {
            Object obj = array[i10];
            obj.getClass();
            fArr[i10] = ((Number) obj).floatValue();
        }
        return fArr;
    }

    @b1.c
    @gm.a
    @b1.d
    public static Float B(String string) {
        if (!d.f12019b.matcher(string).matches()) {
            return null;
        }
        try {
            return Float.valueOf(Float.parseFloat(string));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static List<Float> c(float... backingArray) {
        return backingArray.length == 0 ? Collections.emptyList() : new a(backingArray);
    }

    public static int d(float a10, float b10) {
        return Float.compare(a10, b10);
    }

    public static float[] e(float[]... arrays) {
        int length = 0;
        for (float[] fArr : arrays) {
            length += fArr.length;
        }
        float[] fArr2 = new float[length];
        int length2 = 0;
        for (float[] fArr3 : arrays) {
            System.arraycopy(fArr3, 0, fArr2, length2, fArr3.length);
            length2 += fArr3.length;
        }
        return fArr2;
    }

    public static float f(float value, float min, float max) {
        if (min <= max) {
            return Math.min(Math.max(value, min), max);
        }
        throw new IllegalArgumentException(p0.e("min (%s) must be less than or equal to max (%s)", Float.valueOf(min), Float.valueOf(max)));
    }

    public static boolean g(float[] array, float target) {
        for (float f10 : array) {
            if (f10 == target) {
                return true;
            }
        }
        return false;
    }

    public static float[] h(float[] array, int minLength, int padding) {
        h0.k(minLength >= 0, "Invalid minLength: %s", minLength);
        h0.k(padding >= 0, "Invalid padding: %s", padding);
        return array.length < minLength ? Arrays.copyOf(array, minLength + padding) : array;
    }

    public static int i(float value) {
        return Float.valueOf(value).hashCode();
    }

    public static int j(float[] array, float target) {
        return k(array, target, 0, array.length);
    }

    public static int k(float[] array, float target, int start, int end) {
        while (start < end) {
            if (array[start] == target) {
                return start;
            }
            start++;
        }
        return -1;
    }

    public static int l(float[] array, float[] target) {
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

    public static boolean m(float value) {
        return Float.NEGATIVE_INFINITY < value && value < Float.POSITIVE_INFINITY;
    }

    public static String n(String separator, float... array) {
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

    public static int o(float[] array, float target) {
        return p(array, target, 0, array.length);
    }

    public static int p(float[] array, float target, int start, int end) {
        for (int i10 = end - 1; i10 >= start; i10--) {
            if (array[i10] == target) {
                return i10;
            }
        }
        return -1;
    }

    public static Comparator<float[]> q() {
        return c.INSTANCE;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float r(float... array) {
        h0.d(array.length > 0);
        float fMax = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            fMax = Math.max(fMax, array[i10]);
        }
        return fMax;
    }

    @b1.c("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float s(float... array) {
        h0.d(array.length > 0);
        float fMin = array[0];
        for (int i10 = 1; i10 < array.length; i10++) {
            fMin = Math.min(fMin, array[i10]);
        }
        return fMin;
    }

    public static void t(float[] array) {
        array.getClass();
        u(array, 0, array.length);
    }

    public static void u(float[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        for (int i10 = toIndex - 1; fromIndex < i10; i10--) {
            float f10 = array[fromIndex];
            array[fromIndex] = array[i10];
            array[i10] = f10;
            fromIndex++;
        }
    }

    public static void v(float[] array, int distance) {
        w(array, distance, 0, array.length);
    }

    public static void w(float[] array, int distance, int fromIndex, int toIndex) {
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
        u(array, fromIndex, i12);
        u(array, i12, toIndex);
        u(array, fromIndex, toIndex);
    }

    public static void x(float[] array) {
        array.getClass();
        y(array, 0, array.length);
    }

    public static void y(float[] array, int fromIndex, int toIndex) {
        array.getClass();
        h0.f0(fromIndex, toIndex, array.length);
        Arrays.sort(array, fromIndex, toIndex);
        u(array, fromIndex, toIndex);
    }

    public static c1.i<String, Float> z() {
        return b.INSTANCE;
    }
}
