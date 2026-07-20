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
public final class k implements Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f12031b = new k(new long[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient int f12032a;
    private final long[] array;
    private final int end;

    public static class b extends AbstractList<Long> implements RandomAccess, Serializable {
        private final k parent;

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
            int i10 = this.parent.f12032a;
            for (Object obj : list) {
                if (obj instanceof Long) {
                    int i11 = i10 + 1;
                    if (this.parent.array[i10] == ((Long) obj).longValue()) {
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
            if (target instanceof Long) {
                return this.parent.indexOf(((Long) target).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@gm.a Object target) {
            if (target instanceof Long) {
                return this.parent.lastIndexOf(((Long) target).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int fromIndex, int toIndex) {
            return this.parent.subArray(fromIndex, toIndex).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        public b(k parent) {
            this.parent = parent;
        }

        @Override // java.util.AbstractList, java.util.List
        public Long get(int index) {
            return Long.valueOf(this.parent.get(index));
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long[] f12033a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f12034b = 0;

        public c(int initialCapacity) {
            this.f12033a = new long[initialCapacity];
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
        public c a(long value) {
            g(1);
            long[] jArr = this.f12033a;
            int i10 = this.f12034b;
            jArr[i10] = value;
            this.f12034b = i10 + 1;
            return this;
        }

        @t1.a
        public c b(Iterable<Long> values) {
            if (values instanceof Collection) {
                return c((Collection) values);
            }
            Iterator<Long> it = values.iterator();
            while (it.hasNext()) {
                a(it.next().longValue());
            }
            return this;
        }

        @t1.a
        public c c(Collection<Long> values) {
            g(values.size());
            for (Long l10 : values) {
                long[] jArr = this.f12033a;
                int i10 = this.f12034b;
                this.f12034b = i10 + 1;
                jArr[i10] = l10.longValue();
            }
            return this;
        }

        @t1.a
        public c d(k values) {
            g(values.length());
            System.arraycopy(values.array, values.f12032a, this.f12033a, this.f12034b, values.length());
            this.f12034b = values.length() + this.f12034b;
            return this;
        }

        @t1.a
        public c e(long[] values) {
            g(values.length);
            System.arraycopy(values, 0, this.f12033a, this.f12034b, values.length);
            this.f12034b += values.length;
            return this;
        }

        public k f() {
            if (this.f12034b == 0) {
                return k.f12031b;
            }
            return new k(this.f12033a, 0, this.f12034b);
        }

        public final void g(int numberToAdd) {
            int i10 = this.f12034b + numberToAdd;
            long[] jArr = this.f12033a;
            if (i10 > jArr.length) {
                this.f12033a = Arrays.copyOf(jArr, h(jArr.length, i10));
            }
        }
    }

    public static c builder(int initialCapacity) {
        h0.k(initialCapacity >= 0, "Invalid initialCapacity: %s", initialCapacity);
        return new c(initialCapacity);
    }

    public static k copyOf(long[] values) {
        return values.length == 0 ? f12031b : new k(Arrays.copyOf(values, values.length));
    }

    public static k of() {
        return f12031b;
    }

    public final boolean a() {
        return this.f12032a > 0 || this.end < this.array.length;
    }

    public List<Long> asList() {
        return new b();
    }

    public boolean contains(long target) {
        return indexOf(target) >= 0;
    }

    public boolean equals(@gm.a Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof k)) {
            return false;
        }
        k kVar = (k) object;
        if (length() != kVar.length()) {
            return false;
        }
        for (int i10 = 0; i10 < length(); i10++) {
            if (get(i10) != kVar.get(i10)) {
                return false;
            }
        }
        return true;
    }

    public long get(int index) {
        h0.C(index, length());
        return this.array[this.f12032a + index];
    }

    public int hashCode() {
        int iL = 1;
        for (int i10 = this.f12032a; i10 < this.end; i10++) {
            iL = (iL * 31) + n.l(this.array[i10]);
        }
        return iL;
    }

    public int indexOf(long target) {
        for (int i10 = this.f12032a; i10 < this.end; i10++) {
            if (this.array[i10] == target) {
                return i10 - this.f12032a;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.end == this.f12032a;
    }

    public int lastIndexOf(long target) {
        int i10;
        int i11 = this.end;
        do {
            i11--;
            i10 = this.f12032a;
            if (i11 < i10) {
                return -1;
            }
        } while (this.array[i11] != target);
        return i11 - i10;
    }

    public int length() {
        return this.end - this.f12032a;
    }

    public Object readResolve() {
        return isEmpty() ? f12031b : this;
    }

    public k subArray(int startIndex, int endIndex) {
        h0.f0(startIndex, endIndex, length());
        if (startIndex == endIndex) {
            return f12031b;
        }
        long[] jArr = this.array;
        int i10 = this.f12032a;
        return new k(jArr, startIndex + i10, i10 + endIndex);
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.array, this.f12032a, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb2 = new StringBuilder(length() * 5);
        sb2.append(ks.a.f9445d);
        sb2.append(this.array[this.f12032a]);
        int i10 = this.f12032a;
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

    public k trimmed() {
        return a() ? new k(toArray()) : this;
    }

    public Object writeReplace() {
        return trimmed();
    }

    public k(long[] array) {
        this(array, 0, array.length);
    }

    public static k of(long e10) {
        return new k(new long[]{e10});
    }

    public k(long[] array, int start, int end) {
        this.array = array;
        this.f12032a = start;
        this.end = end;
    }

    public static c builder() {
        return new c(10);
    }

    public static k of(long e10, long e11) {
        return new k(new long[]{e10, e11});
    }

    public static k copyOf(Collection<Long> values) {
        return values.isEmpty() ? f12031b : new k(n.C(values));
    }

    public static k of(long e10, long e11, long e12) {
        return new k(new long[]{e10, e11, e12});
    }

    public static k copyOf(Iterable<Long> values) {
        if (values instanceof Collection) {
            return copyOf((Collection<Long>) values);
        }
        return builder().b(values).f();
    }

    public static k of(long e10, long e11, long e12, long e13) {
        return new k(new long[]{e10, e11, e12, e13});
    }

    public static k of(long e10, long e11, long e12, long e13, long e14) {
        return new k(new long[]{e10, e11, e12, e13, e14});
    }

    public static k of(long e10, long e11, long e12, long e13, long e14, long e15) {
        return new k(new long[]{e10, e11, e12, e13, e14, e15});
    }

    public static k of(long first, long... rest) {
        h0.e(rest.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr = new long[rest.length + 1];
        jArr[0] = first;
        System.arraycopy(rest, 0, jArr, 1, rest.length);
        return new k(jArr);
    }
}
