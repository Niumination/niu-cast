package f1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public abstract class l5<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    @b1.e
    @b1.d
    public static class a extends l5<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f5087a = new AtomicInteger(0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap<Object, Integer> f5088b = o5.l(new r4()).i();

        public final Integer a(Object obj) {
            Integer num = this.f5088b.get(obj);
            if (num != null) {
                return num;
            }
            Integer numValueOf = Integer.valueOf(this.f5087a.getAndIncrement());
            Integer numPutIfAbsent = this.f5088b.putIfAbsent(obj, numValueOf);
            return numPutIfAbsent != null ? numPutIfAbsent : numValueOf;
        }

        public int b(Object object) {
            return System.identityHashCode(object);
        }

        @Override // f1.l5, java.util.Comparator
        public int compare(@gm.a Object left, @gm.a Object right) {
            if (left == right) {
                return 0;
            }
            if (left == null) {
                return -1;
            }
            if (right == null) {
                return 1;
            }
            int iB = b(left);
            int iB2 = b(right);
            if (iB != iB2) {
                return iB < iB2 ? -1 : 1;
            }
            int iCompareTo = a(left).compareTo(a(right));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    @b1.d
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l5<Object> f5089a = new a();
    }

    @b1.e
    public static class c extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        public c(Object value) {
            super(c0.a.a("Cannot compare value: ", value));
            this.value = value;
        }
    }

    @b1.b(serializable = true)
    public static l5<Object> allEqual() {
        return r.INSTANCE;
    }

    @b1.d
    public static l5<Object> arbitrary() {
        return b.f5089a;
    }

    @b1.b(serializable = true)
    public static <T> l5<T> explicit(List<T> valuesInOrder) {
        return new f1(valuesInOrder);
    }

    @b1.b(serializable = true)
    public static <T> l5<T> from(Comparator<T> comparator) {
        return comparator instanceof l5 ? (l5) comparator : new i0(comparator);
    }

    @b1.b(serializable = true)
    public static <C extends Comparable> l5<C> natural() {
        return e5.INSTANCE;
    }

    @b1.b(serializable = true)
    public static l5<Object> usingToString() {
        return a8.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> sortedList, @m5 T key) {
        return Collections.binarySearch(sortedList, key, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(@m5 T left, @m5 T right);

    @b1.b(serializable = true)
    public <U extends T> l5<U> compound(Comparator<? super U> secondaryComparator) {
        secondaryComparator.getClass();
        return new l0(this, secondaryComparator);
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int k10) {
        return reverse().leastOf(iterable, k10);
    }

    public <E extends T> i3<E> immutableSortedCopy(Iterable<E> elements) {
        return i3.sortedCopyOf(this, elements);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (!it.hasNext()) {
            return true;
        }
        T next = it.next();
        while (it.hasNext()) {
            T next2 = it.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int k10) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= ((long) k10) * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > k10) {
                    array = Arrays.copyOf(array, k10);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), k10);
    }

    @b1.b(serializable = true)
    public <S extends T> l5<Iterable<S>> lexicographical() {
        return new j4(this);
    }

    @m5
    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    @m5
    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    @b1.b(serializable = true)
    public <S extends T> l5<S> nullsFirst() {
        return new g5(this);
    }

    @b1.b(serializable = true)
    public <S extends T> l5<S> nullsLast() {
        return new h5(this);
    }

    public <T2 extends T> l5<Map.Entry<T2, ?>> onKeys() {
        return (l5<Map.Entry<T2, ?>>) onResultOf(t4.r.KEY);
    }

    @b1.b(serializable = true)
    public <F> l5<F> onResultOf(c1.t<F, ? extends T> function) {
        return new y(function, this);
    }

    @b1.b(serializable = true)
    public <S extends T> l5<S> reverse() {
        return new g6(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> elements) {
        Object[] objArrP = g4.P(elements);
        Arrays.sort(objArrP, this);
        return p4.r(Arrays.asList(objArrP));
    }

    @b1.b(serializable = true)
    public static <T> l5<T> explicit(T leastValue, T... remainingValuesInOrder) {
        return explicit(new p4.e(leastValue, remainingValuesInOrder));
    }

    public <E extends T> List<E> greatestOf(Iterator<E> iterator, int k10) {
        return reverse().leastOf(iterator, k10);
    }

    @b1.b(serializable = true)
    public static <T> l5<T> compound(Iterable<? extends Comparator<? super T>> comparators) {
        return new l0(comparators);
    }

    @b1.b(serializable = true)
    @Deprecated
    public static <T> l5<T> from(l5<T> ordering) {
        ordering.getClass();
        return ordering;
    }

    @m5
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    @m5
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m5
    public <E extends T> E max(@m5 E a10, @m5 E b10) {
        return compare(a10, b10) >= 0 ? a10 : b10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @m5
    public <E extends T> E min(@m5 E a10, @m5 E b10) {
        return compare(a10, b10) <= 0 ? a10 : b10;
    }

    @m5
    public <E extends T> E max(@m5 E e10, @m5 E e11, @m5 E e12, E... eArr) {
        E e13 = (E) max(max(e10, e11), e12);
        for (E e14 : eArr) {
            e13 = (E) max(e13, e14);
        }
        return e13;
    }

    @m5
    public <E extends T> E min(@m5 E e10, @m5 E e11, @m5 E e12, E... eArr) {
        E e13 = (E) min(min(e10, e11), e12);
        for (E e14 : eArr) {
            e13 = (E) min(e13, e14);
        }
        return e13;
    }

    public <E extends T> List<E> leastOf(Iterator<E> iterator, int k10) {
        iterator.getClass();
        b0.b(k10, "k");
        if (k10 == 0 || !iterator.hasNext()) {
            return Collections.emptyList();
        }
        if (k10 >= 1073741823) {
            ArrayList arrayListS = p4.s(iterator);
            Collections.sort(arrayListS, this);
            if (arrayListS.size() > k10) {
                arrayListS.subList(k10, arrayListS.size()).clear();
            }
            arrayListS.trimToSize();
            return Collections.unmodifiableList(arrayListS);
        }
        n7 n7Var = new n7(this, k10);
        n7Var.g(iterator);
        return n7Var.j();
    }
}
