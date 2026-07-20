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
public final class j implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f12027b = new j(new int[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f12028a;
    private final int[] array;
    private final int end;

    public static class b extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final j parent;

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
            int i10 = this.parent.f12028a;
            for (Object obj : list) {
                if (obj instanceof Integer) {
                    int i11 = i10 + 1;
                    if (this.parent.array[i10] == ((Integer) obj).intValue()) {
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
            if (target instanceof Integer) {
                return this.parent.indexOf(((Integer) target).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@gm.a Object target) {
            if (target instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) target).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int fromIndex, int toIndex) {
            return this.parent.subArray(fromIndex, toIndex).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        public b(j parent) {
            this.parent = parent;
        }

        @Override // java.util.AbstractList, java.util.List
        public Integer get(int index) {
            return Integer.valueOf(this.parent.get(index));
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f12029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12030b = 0;

        public c(int initialCapacity) {
            this.f12029a = new int[initialCapacity];
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
        public c a(int value) {
            g(1);
            int[] iArr = this.f12029a;
            int i10 = this.f12030b;
            iArr[i10] = value;
            this.f12030b = i10 + 1;
            return this;
        }

        @t1.a
        public c b(Iterable<Integer> values) {
            if (values instanceof Collection) {
                return c((Collection) values);
            }
            Iterator<Integer> it = values.iterator();
            while (it.hasNext()) {
                a(it.next().intValue());
            }
            return this;
        }

        @t1.a
        public c c(Collection<Integer> values) {
            g(values.size());
            for (Integer num : values) {
                int[] iArr = this.f12029a;
                int i10 = this.f12030b;
                this.f12030b = i10 + 1;
                iArr[i10] = num.intValue();
            }
            return this;
        }

        @t1.a
        public c d(j values) {
            g(values.length());
            System.arraycopy(values.array, values.f12028a, this.f12029a, this.f12030b, values.length());
            this.f12030b = values.length() + this.f12030b;
            return this;
        }

        @t1.a
        public c e(int[] values) {
            g(values.length);
            System.arraycopy(values, 0, this.f12029a, this.f12030b, values.length);
            this.f12030b += values.length;
            return this;
        }

        public j f() {
            if (this.f12030b == 0) {
                return j.f12027b;
            }
            return new j(this.f12029a, 0, this.f12030b);
        }

        public final void g(int numberToAdd) {
            int i10 = this.f12030b + numberToAdd;
            int[] iArr = this.f12029a;
            if (i10 > iArr.length) {
                this.f12029a = Arrays.copyOf(iArr, h(iArr.length, i10));
            }
        }
    }

    public static c builder(int initialCapacity) {
        h0.k(initialCapacity >= 0, "Invalid initialCapacity: %s", initialCapacity);
        return new c(initialCapacity);
    }

    public static j copyOf(int[] values) {
        return values.length == 0 ? f12027b : new j(Arrays.copyOf(values, values.length));
    }

    public static j of() {
        return f12027b;
    }

    public final boolean a() {
        return this.f12028a > 0 || this.end < this.array.length;
    }

    public List<Integer> asList() {
        return new b();
    }

    public boolean contains(int target) {
        return indexOf(target) >= 0;
    }

    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof j)) {
            return false;
        }
        j jVar = (j) object;
        if (length() != jVar.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (get(i10) != jVar.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public int get(int index) {
        h0.C(index, length());
        return this.array[this.f12028a + index];
    }

    public int hashCode() {
        int i10 = 1;
        for (int i11 = this.f12028a; i11 < this.end; i11++) {
            i10 = (i10 * 31) + this.array[i11];
        }
        return i10;
    }

    public int indexOf(int target) {
        for (int i10 = this.f12028a; i10 < this.end; i10++) {
            if (this.array[i10] == target) {
                return i10 - this.f12028a;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.f12028a;
    }

    public int lastIndexOf(int target) {
        int i10;
        int i11 = this.end;
        do {
            i11--;
            i10 = this.f12028a;
            if (i11 < i10) {
                return -1;
            }
        } while (this.array[i11] != target);
        return i11 - i10;
    }

    public int length() {
        return this.end - this.f12028a;
    }

    public Object readResolve() {
        return isEmpty() ? f12027b : this;
    }

    public j subArray(int startIndex, int endIndex) {
        h0.f0(startIndex, endIndex, length());
        if (startIndex == endIndex) {
            return f12027b;
        }
        int[] iArr = this.array;
        int i10 = this.f12028a;
        return new j(iArr, startIndex + i10, i10 + endIndex);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.f12028a, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
        sb2.append(ks.a.f9445d);
        sb2.append(this.array[this.f12028a]);
        int i10 = this.f12028a;
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

    public j trimmed() {
        return a() ? new j(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public j(int[] array) {
        this(array, 0, array.length);
    }

    public static j copyOf(Collection<Integer> values) {
        return values.isEmpty() ? f12027b : new j(l.D(values));
    }

    public static j of(int e10) {
        return new j(new int[]{e10});
    }

    public j(int[] array, int start, int end) {
        this.array = array;
        this.f12028a = start;
        this.end = end;
    }

    public static c builder() {
        return new c(10);
    }

    public static j copyOf(Iterable<Integer> values) {
        if (values instanceof Collection) {
            return copyOf((Collection<Integer>) values);
        }
        return builder().b(values).f();
    }

    public static j of(int e10, int e11) {
        return new j(new int[]{e10, e11});
    }

    public static j of(int e10, int e11, int e12) {
        return new j(new int[]{e10, e11, e12});
    }

    public static j of(int e10, int e11, int e12, int e13) {
        return new j(new int[]{e10, e11, e12, e13});
    }

    public static j of(int e10, int e11, int e12, int e13, int e14) {
        return new j(new int[]{e10, e11, e12, e13, e14});
    }

    public static j of(int e10, int e11, int e12, int e13, int e14, int e15) {
        return new j(new int[]{e10, e11, e12, e13, e14, e15});
    }

    public static j of(int first, int... rest) {
        h0.e(rest.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr = new int[rest.length + 1];
        iArr[0] = first;
        System.arraycopy(rest, 0, iArr, 1, rest.length);
        return new j(iArr);
    }
}
