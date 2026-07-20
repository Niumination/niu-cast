package f1;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@x0
public final class c0 {

    public static class a<E> extends AbstractCollection<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<E> f4715a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c1.i0<? super E> f4716b;

        public a(Collection<E> unfiltered, c1.i0<? super E> predicate) {
            this.f4715a = unfiltered;
            this.f4716b = predicate;
        }

        public a<E> a(c1.i0<? super E> newPredicate) {
            return new a<>(this.f4715a, c1.j0.d(this.f4716b, newPredicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@m5 E element) {
            c1.h0.d(this.f4716b.apply(element));
            return this.f4715a.add(element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                c1.h0.d(this.f4716b.apply(it.next()));
            }
            return this.f4715a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            g4.J(this.f4715a, this.f4716b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object element) {
            if (c0.j(this.f4715a, element)) {
                return this.f4716b.apply(element);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return c0.b(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !g4.c(this.f4715a, this.f4716b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return h4.x(this.f4715a.iterator(), this.f4716b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@gm.a Object element) {
            return contains(element) && this.f4715a.remove(element);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(final Collection<?> collection) {
            Iterator<E> it = this.f4715a.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f4716b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(final Collection<?> collection) {
            Iterator<E> it = this.f4715a.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f4716b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z10 = true;
                }
            }
            return z10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            Iterator<E> it = this.f4715a.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                if (this.f4716b.apply(it.next())) {
                    i10++;
                }
            }
            return i10;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return p4.s(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) p4.s(iterator()).toArray(tArr);
        }
    }

    public static final class b<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i3<E> f4717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Comparator<? super E> f4718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f4719c;

        public b(Iterable<E> input, Comparator<? super E> comparator) {
            i3<E> i3VarSortedCopyOf = i3.sortedCopyOf(comparator, input);
            this.f4717a = i3VarSortedCopyOf;
            this.f4718b = comparator;
            this.f4719c = a(i3VarSortedCopyOf, comparator);
        }

        public static <E> int a(List<E> sortedInputList, Comparator<? super E> comparator) {
            int i10 = 1;
            int iU = 1;
            int i11 = 1;
            while (i10 < sortedInputList.size()) {
                if (comparator.compare(sortedInputList.get(i10 - 1), sortedInputList.get(i10)) < 0) {
                    iU = m1.f.u(iU, m1.f.a(i10, i11));
                    if (iU == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i11 = 0;
                }
                i10++;
                i11++;
            }
            return m1.f.u(iU, m1.f.a(i10, i11));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return c0.e(this.f4717a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new c(this.f4717a, this.f4718b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f4719c;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.f4717a + ")";
        }
    }

    public static final class c<E> extends f1.c<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public List<E> f4720c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Comparator<? super E> f4721d;

        public c(List<E> list, Comparator<? super E> comparator) {
            this.f4720c = p4.r(list);
            this.f4721d = comparator;
        }

        public void d() {
            int iF = f();
            if (iF == -1) {
                this.f4720c = null;
                return;
            }
            Objects.requireNonNull(this.f4720c);
            Collections.swap(this.f4720c, iF, g(iF));
            Collections.reverse(this.f4720c.subList(iF + 1, this.f4720c.size()));
        }

        @Override // f1.c
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<E> a() {
            List<E> list = this.f4720c;
            if (list == null) {
                this.f4711a = f1.c.b.DONE;
                return null;
            }
            i3 i3VarCopyOf = i3.copyOf((Collection) list);
            d();
            return i3VarCopyOf;
        }

        public int f() {
            Objects.requireNonNull(this.f4720c);
            for (int size = this.f4720c.size() - 2; size >= 0; size--) {
                if (this.f4721d.compare(this.f4720c.get(size), this.f4720c.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        public int g(int i10) {
            Objects.requireNonNull(this.f4720c);
            E e10 = this.f4720c.get(i10);
            for (int size = this.f4720c.size() - 1; size > i10; size--) {
                if (this.f4721d.compare(e10, this.f4720c.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    public static final class d<E> extends AbstractCollection<List<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i3<E> f4722a;

        public d(i3<E> input) {
            this.f4722a = input;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@gm.a Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return c0.e(this.f4722a, (List) obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new e(this.f4722a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return m1.f.h(this.f4722a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.f4722a + ")";
        }
    }

    public static class e<E> extends f1.c<List<E>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List<E> f4723c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f4724d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f4725e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4726f;

        public e(List<E> list) {
            this.f4723c = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f4724d = iArr;
            int[] iArr2 = new int[size];
            this.f4725e = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.f4726f = Integer.MAX_VALUE;
        }

        public void d() {
            int size = this.f4723c.size() - 1;
            this.f4726f = size;
            if (size == -1) {
                return;
            }
            int i10 = 0;
            while (true) {
                int[] iArr = this.f4724d;
                int i11 = this.f4726f;
                int i12 = iArr[i11];
                int i13 = this.f4725e[i11] + i12;
                if (i13 < 0) {
                    f();
                } else if (i13 != i11 + 1) {
                    Collections.swap(this.f4723c, (i11 - i12) + i10, (i11 - i13) + i10);
                    this.f4724d[this.f4726f] = i13;
                    return;
                } else {
                    if (i11 == 0) {
                        return;
                    }
                    i10++;
                    f();
                }
            }
        }

        @Override // f1.c
        @gm.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public List<E> a() {
            if (this.f4726f <= 0) {
                this.f4711a = f1.c.b.DONE;
                return null;
            }
            i3 i3VarCopyOf = i3.copyOf((Collection) this.f4723c);
            d();
            return i3VarCopyOf;
        }

        public void f() {
            int[] iArr = this.f4725e;
            int i10 = this.f4726f;
            iArr[i10] = -iArr[i10];
            this.f4726f = i10 - 1;
        }
    }

    public static class f<F, T> extends AbstractCollection<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Collection<F> f4727a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c1.t<? super F, ? extends T> f4728b;

        public f(Collection<F> fromCollection, c1.t<? super F, ? extends T> function) {
            fromCollection.getClass();
            this.f4727a = fromCollection;
            function.getClass();
            this.f4728b = function;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f4727a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f4727a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.c0(this.f4727a.iterator(), this.f4728b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f4727a.size();
        }
    }

    public static boolean b(Collection<?> self, Collection<?> c10) {
        Iterator<?> it = c10.iterator();
        while (it.hasNext()) {
            if (!self.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <E> j5<E> c(Collection<E> collection) {
        j5<E> j5Var = new j5<>();
        for (E e10 : collection) {
            j5Var.v(e10, j5Var.g(e10) + 1);
        }
        return j5Var;
    }

    public static <E> Collection<E> d(Collection<E> unfiltered, c1.i0<? super E> predicate) {
        if (unfiltered instanceof a) {
            return ((a) unfiltered).a(predicate);
        }
        unfiltered.getClass();
        predicate.getClass();
        return new a(unfiltered, predicate);
    }

    public static boolean e(List<?> first, List<?> second) {
        if (first.size() != second.size()) {
            return false;
        }
        j5 j5VarC = c(first);
        j5 j5VarC2 = c(second);
        if (first.size() != second.size()) {
            return false;
        }
        for (int i10 = 0; i10 < first.size(); i10++) {
            if (j5VarC.l(i10) != j5VarC2.g(j5VarC.j(i10))) {
                return false;
            }
        }
        return true;
    }

    public static StringBuilder f(int size) {
        b0.b(size, ik.f.b.f7973h);
        return new StringBuilder((int) Math.min(((long) size) * 8, 1073741824L));
    }

    public static <E extends Comparable<? super E>> Collection<List<E>> g(Iterable<E> elements) {
        return new b(elements, l5.natural());
    }

    public static <E> Collection<List<E>> h(Iterable<E> elements, Comparator<? super E> comparator) {
        return new b(elements, comparator);
    }

    public static <E> Collection<List<E>> i(Collection<E> elements) {
        return new d(i3.copyOf((Collection) elements));
    }

    public static boolean j(Collection<?> collection, @gm.a Object object) {
        collection.getClass();
        try {
            return collection.contains(object);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static boolean k(Collection<?> collection, @gm.a Object object) {
        collection.getClass();
        try {
            return collection.remove(object);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static String l(final Collection<?> collection) {
        StringBuilder sbF = f(collection.size());
        sbF.append(ks.a.f9445d);
        boolean z10 = true;
        for (Object obj : collection) {
            if (!z10) {
                sbF.append(", ");
            }
            if (obj == collection) {
                sbF.append("(this Collection)");
            } else {
                sbF.append(obj);
            }
            z10 = false;
        }
        sbF.append(']');
        return sbF.toString();
    }

    public static <F, T> Collection<T> m(Collection<F> fromCollection, c1.t<? super F, T> function) {
        return new f(fromCollection, function);
    }
}
