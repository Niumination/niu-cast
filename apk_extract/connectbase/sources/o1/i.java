package o1;

import c1.h0;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@f
@t1.j
public final class i implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f12023b = new i(new double[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f12024a;
    private final double[] array;
    private final int end;

    public static class b extends AbstractList<Double> implements RandomAccess, Serializable {
        private final i parent;

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@gm.a Object target) {
            return indexOf(target) >= 0;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@gm.a Object object) {
            if (object instanceof b) {
                return this.parent.equals(((b) object).parent);
            }
            if (!(object instanceof List)) {
                return false;
            }
            List list = (List) object;
            if (size() != list.size()) {
                return false;
            }
            int i10 = this.parent.f12024a;
            for (Object obj : list) {
                if (obj instanceof Double) {
                    int i11 = i10 + 1;
                    if (i.a(this.parent.array[i10], ((Double) obj).doubleValue())) {
                        i10 = i11;
                    }
                }
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@gm.a Object target) {
            if (target instanceof Double) {
                return this.parent.indexOf(((Double) target).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@gm.a Object target) {
            if (target instanceof Double) {
                return this.parent.lastIndexOf(((Double) target).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int fromIndex, int toIndex) {
            return this.parent.subArray(fromIndex, toIndex).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        public b(i parent) {
            this.parent = parent;
        }

        @Override // java.util.AbstractList, java.util.List
        public Double get(int index) {
            return Double.valueOf(this.parent.get(index));
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public double[] f12025a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12026b = 0;

        public c(int initialCapacity) {
            this.f12025a = new double[initialCapacity];
        }

        public static int h(int oldCapacity, int minCapacity) {
            if (minCapacity < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = oldCapacity + (oldCapacity >> 1) + 1;
            if (iHighestOneBit < minCapacity) {
                iHighestOneBit = Integer.highestOneBit(minCapacity - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }

        @t1.a
        public c a(double value) {
            g(1);
            double[] dArr = this.f12025a;
            int i10 = this.f12026b;
            dArr[i10] = value;
            this.f12026b = i10 + 1;
            return this;
        }

        @t1.a
        public c b(Iterable<Double> values) {
            if (values instanceof Collection) {
                return c((Collection) values);
            }
            Iterator<Double> it = values.iterator();
            while (it.hasNext()) {
                a(it.next().doubleValue());
            }
            return this;
        }

        @t1.a
        public c c(Collection<Double> values) {
            g(values.size());
            for (Double d10 : values) {
                double[] dArr = this.f12025a;
                int i10 = this.f12026b;
                this.f12026b = i10 + 1;
                dArr[i10] = d10.doubleValue();
            }
            return this;
        }

        @t1.a
        public c d(i values) {
            g(values.length());
            System.arraycopy(values.array, values.f12024a, this.f12025a, this.f12026b, values.length());
            this.f12026b = values.length() + this.f12026b;
            return this;
        }

        @t1.a
        public c e(double[] values) {
            g(values.length);
            System.arraycopy(values, 0, this.f12025a, this.f12026b, values.length);
            this.f12026b += values.length;
            return this;
        }

        public i f() {
            if (this.f12026b == 0) {
                return i.f12023b;
            }
            return new i(this.f12025a, 0, this.f12026b);
        }

        public final void g(int numberToAdd) {
            int i10 = this.f12026b + numberToAdd;
            double[] dArr = this.f12025a;
            if (i10 > dArr.length) {
                this.f12025a = Arrays.copyOf(dArr, h(dArr.length, i10));
            }
        }
    }

    public static boolean a(double a10, double b10) {
        return Double.doubleToLongBits(a10) == Double.doubleToLongBits(b10);
    }

    public static c builder(int initialCapacity) {
        h0.k(initialCapacity >= 0, "Invalid initialCapacity: %s", initialCapacity);
        return new c(initialCapacity);
    }

    public static i copyOf(double[] values) {
        return values.length == 0 ? f12023b : new i(Arrays.copyOf(values, values.length));
    }

    public static i of() {
        return f12023b;
    }

    public List<Double> asList() {
        return new b();
    }

    public final boolean b() {
        return this.f12024a > 0 || this.end < this.array.length;
    }

    public boolean contains(double target) {
        return indexOf(target) >= 0;
    }

    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof i)) {
            return false;
        }
        i iVar = (i) object;
        if (length() != iVar.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (!a(get(i10), iVar.get(i10))) {
                return false;
            }
        }
        return true;
    }

    public double get(int index) {
        h0.C(index, length());
        return this.array[this.f12024a + index];
    }

    public int hashCode() {
        int iJ = 1;
        for (int i10 = this.f12024a; i10 < this.end; i10++) {
            iJ = (iJ * 31) + d.j(this.array[i10]);
        }
        return iJ;
    }

    public int indexOf(double target) {
        for (int i10 = this.f12024a; i10 < this.end; i10++) {
            if (a(this.array[i10], target)) {
                return i10 - this.f12024a;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.f12024a;
    }

    public int lastIndexOf(double target) {
        int i10 = this.end;
        do {
            i10--;
            if (i10 < this.f12024a) {
                return -1;
            }
        } while (!a(this.array[i10], target));
        return i10 - this.f12024a;
    }

    public int length() {
        return this.end - this.f12024a;
    }

    public Object readResolve() {
        return isEmpty() ? f12023b : this;
    }

    public i subArray(int startIndex, int endIndex) {
        h0.f0(startIndex, endIndex, length());
        if (startIndex == endIndex) {
            return f12023b;
        }
        double[] dArr = this.array;
        int i10 = this.f12024a;
        return new i(dArr, startIndex + i10, i10 + endIndex);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.f12024a, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
        sb2.append(ks.a.f9445d);
        sb2.append(this.array[this.f12024a]);
        int i10 = this.f12024a;
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

    public i trimmed() {
        return b() ? new i(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public i(double[] array) {
        this(array, 0, array.length);
    }

    public static i of(double e10) {
        return new i(new double[]{e10});
    }

    public i(double[] array, int start, int end) {
        this.array = array;
        this.f12024a = start;
        this.end = end;
    }

    public static c builder() {
        return new c(10);
    }

    public static i of(double e10, double e11) {
        return new i(new double[]{e10, e11});
    }

    public static i copyOf(Collection<Double> values) {
        return values.isEmpty() ? f12023b : new i(d.B(values));
    }

    public static i of(double e10, double e11, double e12) {
        return new i(new double[]{e10, e11, e12});
    }

    public static i copyOf(Iterable<Double> values) {
        if (values instanceof Collection) {
            return copyOf((Collection<Double>) values);
        }
        return builder().b(values).f();
    }

    public static i of(double e10, double e11, double e12, double e13) {
        return new i(new double[]{e10, e11, e12, e13});
    }

    public static i of(double e10, double e11, double e12, double e13, double e14) {
        return new i(new double[]{e10, e11, e12, e13, e14});
    }

    public static i of(double e10, double e11, double e12, double e13, double e14, double e15) {
        return new i(new double[]{e10, e11, e12, e13, e14, e15});
    }

    public static i of(double first, double... rest) {
        h0.e(rest.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr = new double[rest.length + 1];
        dArr[0] = first;
        System.arraycopy(rest, 0, dArr, 1, rest.length);
        return new i(dArr);
    }
}
