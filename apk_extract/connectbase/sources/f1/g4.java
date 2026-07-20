package f1;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class g4 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4900b;

        public a(final Iterable val$iterable) {
            this.f4900b = val$iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.r(this.f4900b);
        }

        @Override // f1.p1
        public String toString() {
            return this.f4900b.toString() + " (cycled)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> extends p1<List<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4901b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4902c;

        public b(final Iterable val$iterable, final int val$size) {
            this.f4901b = val$iterable;
            this.f4902c = val$size;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return h4.R(this.f4901b.iterator(), this.f4902c, false);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends p1<List<T>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4903b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4904c;

        public c(final Iterable val$iterable, final int val$size) {
            this.f4903b = val$iterable;
            this.f4904c = val$size;
        }

        @Override // java.lang.Iterable
        public Iterator<List<T>> iterator() {
            return h4.R(this.f4903b.iterator(), this.f4904c, true);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4905b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c1.i0 f4906c;

        public d(final Iterable val$unfiltered, final c1.i0 val$retainIfTrue) {
            this.f4905b = val$unfiltered;
            this.f4906c = val$retainIfTrue;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.x(this.f4905b.iterator(), this.f4906c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4907b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c1.t f4908c;

        public e(final Iterable val$fromIterable, final c1.t val$function) {
            this.f4907b = val$fromIterable;
            this.f4908c = val$function;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.c0(this.f4907b.iterator(), this.f4908c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4909b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4910c;

        public class a implements Iterator<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public boolean f4911a = true;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Iterator f4912b;

            public a(final f this$0, final Iterator val$iterator) {
                this.f4912b = val$iterator;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f4912b.hasNext();
            }

            @Override // java.util.Iterator
            @m5
            public T next() {
                T t10 = (T) this.f4912b.next();
                this.f4911a = false;
                return t10;
            }

            @Override // java.util.Iterator
            public void remove() {
                b0.e(!this.f4911a);
                this.f4912b.remove();
            }
        }

        public f(final Iterable val$iterable, final int val$numberToSkip) {
            this.f4909b = val$iterable;
            this.f4910c = val$numberToSkip;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f4909b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f4910c), list.size()).iterator();
            }
            Iterator<T> it = iterable.iterator();
            h4.b(it, this.f4910c);
            return new a(this, it);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4913b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f4914c;

        public g(final Iterable val$iterable, final int val$limitSize) {
            this.f4913b = val$iterable;
            this.f4914c = val$limitSize;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.N(this.f4913b.iterator(), this.f4914c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class h<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4915b;

        public h(final Iterable val$iterable) {
            this.f4915b = val$iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f4915b;
            return iterable instanceof Queue ? new o0((Queue) iterable) : h4.p(iterable.iterator());
        }

        @Override // f1.p1
        public String toString() {
            return "Iterables.consumingIterable(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Comparator f4917c;

        public i(final Iterable val$iterables, final Comparator val$comparator) {
            this.f4916b = val$iterables;
            this.f4917c = val$comparator;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.O(g4.T(this.f4916b, new q1()), this.f4917c);
        }
    }

    public static final class j<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Iterable<? extends T> f4918b;

        public /* synthetic */ j(Iterable iterable, a aVar) {
            this(iterable);
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return h4.f0(this.f4918b.iterator());
        }

        @Override // f1.p1
        public String toString() {
            return this.f4918b.toString();
        }

        public j(Iterable<? extends T> iterable) {
            this.f4918b = iterable;
        }
    }

    @m5
    public static <T> T A(Iterable<? extends T> iterable, @m5 T t10) {
        return (T) h4.L(iterable.iterator(), t10);
    }

    public static <T> int B(Iterable<T> iterable, c1.i0<? super T> predicate) {
        return h4.M(iterable.iterator(), predicate);
    }

    public static boolean C(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> D(final Iterable<T> iterable, final int limitSize) {
        iterable.getClass();
        c1.h0.e(limitSize >= 0, "limit is negative");
        return new g(iterable, limitSize);
    }

    public static <T> Iterable<T> E(final Iterable<? extends Iterable<? extends T>> iterables, final Comparator<? super T> comparator) {
        c1.h0.F(iterables, "iterables");
        c1.h0.F(comparator, "comparator");
        return new j(new i(iterables, comparator));
    }

    public static <T> Iterable<List<T>> F(final Iterable<T> iterable, final int size) {
        iterable.getClass();
        c1.h0.d(size > 0);
        return new c(iterable, size);
    }

    public static <T> Iterable<List<T>> G(final Iterable<T> iterable, final int size) {
        iterable.getClass();
        c1.h0.d(size > 0);
        return new b(iterable, size);
    }

    @t1.a
    public static boolean H(Iterable<?> removeFrom, Collection<?> elementsToRemove) {
        if (!(removeFrom instanceof Collection)) {
            return h4.V(removeFrom.iterator(), elementsToRemove);
        }
        elementsToRemove.getClass();
        return ((Collection) removeFrom).removeAll(elementsToRemove);
    }

    @gm.a
    public static <T> T I(Iterable<T> removeFrom, c1.i0<? super T> predicate) {
        predicate.getClass();
        Iterator<T> it = removeFrom.iterator();
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                it.remove();
                return next;
            }
        }
        return null;
    }

    @t1.a
    public static <T> boolean J(Iterable<T> removeFrom, c1.i0<? super T> predicate) {
        if (!(removeFrom instanceof RandomAccess) || !(removeFrom instanceof List)) {
            return h4.W(removeFrom.iterator(), predicate);
        }
        predicate.getClass();
        return K((List) removeFrom, predicate);
    }

    public static <T> boolean K(List<T> list, c1.i0<? super T> predicate) {
        int i10 = 0;
        int i11 = 0;
        while (i10 < list.size()) {
            T t10 = list.get(i10);
            if (!predicate.apply(t10)) {
                if (i10 > i11) {
                    try {
                        list.set(i11, t10);
                    } catch (IllegalArgumentException unused) {
                        O(list, predicate, i11, i10);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        O(list, predicate, i11, i10);
                        return true;
                    }
                }
                i11++;
            }
            i10++;
        }
        list.subList(i11, list.size()).clear();
        return i10 != i11;
    }

    @t1.a
    public static boolean L(Iterable<?> removeFrom, Collection<?> elementsToRetain) {
        if (!(removeFrom instanceof Collection)) {
            return h4.X(removeFrom.iterator(), elementsToRetain);
        }
        elementsToRetain.getClass();
        return ((Collection) removeFrom).retainAll(elementsToRetain);
    }

    public static int M(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : h4.Z(iterable.iterator());
    }

    public static <T> Iterable<T> N(final Iterable<T> iterable, final int numberToSkip) {
        iterable.getClass();
        c1.h0.e(numberToSkip >= 0, "number to skip cannot be negative");
        return new f(iterable, numberToSkip);
    }

    public static <T> void O(List<T> list, c1.i0<? super T> predicate, int to2, int from) {
        for (int size = list.size() - 1; size > from; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i10 = from - 1; i10 >= to2; i10--) {
            list.remove(i10);
        }
    }

    public static Object[] P(Iterable<?> iterable) {
        return d(iterable).toArray();
    }

    @b1.c
    public static <T> T[] Q(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) R(iterable, (Object[]) Array.newInstance((Class<?>) cls, 0));
    }

    public static <T> T[] R(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) d(iterable).toArray(tArr);
    }

    public static String S(Iterable<?> iterable) {
        return h4.b0(iterable.iterator());
    }

    public static <F, T> Iterable<T> T(final Iterable<F> fromIterable, final c1.t<? super F, ? extends T> function) {
        fromIterable.getClass();
        function.getClass();
        return new e(fromIterable, function);
    }

    public static <T> c1.c0<T> U(Iterable<T> iterable, c1.i0<? super T> predicate) {
        return h4.d0(iterable.iterator(), predicate);
    }

    @Deprecated
    public static <E> Iterable<E> V(e3<E> iterable) {
        iterable.getClass();
        return iterable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Iterable<T> W(final Iterable<? extends T> iterable) {
        iterable.getClass();
        return ((iterable instanceof j) || (iterable instanceof e3)) ? iterable : new j(iterable);
    }

    @t1.a
    public static <T> boolean a(Collection<T> addTo, Iterable<? extends T> elementsToAdd) {
        if (elementsToAdd instanceof Collection) {
            return addTo.addAll((Collection) elementsToAdd);
        }
        elementsToAdd.getClass();
        return h4.a(addTo, elementsToAdd.iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, c1.i0<? super T> predicate) {
        return h4.c(iterable.iterator(), predicate);
    }

    public static <T> boolean c(Iterable<T> iterable, c1.i0<? super T> predicate) {
        return h4.d(iterable.iterator(), predicate);
    }

    public static <E> Collection<E> d(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : p4.s(iterable.iterator());
    }

    public static <T> Iterable<T> e(Iterable<? extends Iterable<? extends T>> inputs) {
        return p1.f(inputs);
    }

    public static <T> Iterable<T> f(Iterable<? extends T> a10, Iterable<? extends T> b10) {
        return p1.g(a10, b10);
    }

    public static <T> Iterable<T> g(Iterable<? extends T> a10, Iterable<? extends T> b10, Iterable<? extends T> c10) {
        return p1.i(a10, b10, c10);
    }

    public static <T> Iterable<T> h(Iterable<? extends T> a10, Iterable<? extends T> b10, Iterable<? extends T> c10, Iterable<? extends T> d10) {
        return p1.j(a10, b10, c10, d10);
    }

    @SafeVarargs
    public static <T> Iterable<T> i(Iterable<? extends T>... inputs) {
        return p1.k(inputs);
    }

    public static <T> Iterable<T> j(final Iterable<T> iterable) {
        iterable.getClass();
        return new h(iterable);
    }

    public static boolean k(Iterable<? extends Object> iterable, @gm.a Object element) {
        return iterable instanceof Collection ? c0.j((Collection) iterable, element) : h4.q(iterable.iterator(), element);
    }

    public static <T> Iterable<T> l(final Iterable<T> iterable) {
        iterable.getClass();
        return new a(iterable);
    }

    @SafeVarargs
    public static <T> Iterable<T> m(T... elements) {
        return l(p4.t(elements));
    }

    public static boolean n(Iterable<?> iterable1, Iterable<?> iterable2) {
        if ((iterable1 instanceof Collection) && (iterable2 instanceof Collection) && ((Collection) iterable1).size() != ((Collection) iterable2).size()) {
            return false;
        }
        return h4.t(iterable1.iterator(), iterable2.iterator());
    }

    public static <T> Iterable<T> o(final Iterable<T> unfiltered, final c1.i0<? super T> retainIfTrue) {
        unfiltered.getClass();
        retainIfTrue.getClass();
        return new d(unfiltered, retainIfTrue);
    }

    @b1.c
    public static <T> Iterable<T> p(final Iterable<?> unfiltered, final Class<T> desiredType) {
        unfiltered.getClass();
        desiredType.getClass();
        return o(unfiltered, c1.j0.o(desiredType));
    }

    @m5
    public static <T> T q(Iterable<T> iterable, c1.i0<? super T> i0Var) {
        return (T) h4.z(iterable.iterator(), i0Var);
    }

    @gm.a
    public static <T> T r(Iterable<? extends T> iterable, c1.i0<? super T> i0Var, @gm.a T t10) {
        return (T) h4.A(iterable.iterator(), i0Var, t10);
    }

    public static int s(Iterable<?> iterable, @gm.a Object obj) {
        if (iterable instanceof b5) {
            return ((b5) iterable).count(obj);
        }
        return iterable instanceof Set ? ((Set) iterable).contains(obj) ? 1 : 0 : h4.E(iterable.iterator(), obj);
    }

    @m5
    public static <T> T t(Iterable<T> iterable, int i10) {
        iterable.getClass();
        return iterable instanceof List ? (T) ((List) iterable).get(i10) : (T) h4.F(iterable.iterator(), i10);
    }

    @m5
    public static <T> T u(Iterable<? extends T> iterable, int i10, @m5 T t10) {
        iterable.getClass();
        h4.g(i10);
        if (iterable instanceof List) {
            List list = (List) iterable;
            return i10 < list.size() ? (T) list.get(i10) : t10;
        }
        Iterator<? extends T> it = iterable.iterator();
        h4.b(it, i10);
        return (T) h4.J(it, t10);
    }

    @m5
    public static <T> T v(Iterable<? extends T> iterable, @m5 T t10) {
        return (T) h4.J(iterable.iterator(), t10);
    }

    @m5
    public static <T> T w(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) h4.H(iterable.iterator());
        }
        List list = (List) iterable;
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        return (T) y(list);
    }

    @m5
    public static <T> T x(Iterable<? extends T> iterable, @m5 T t10) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t10;
            }
            if (iterable instanceof List) {
                return (T) y((List) iterable);
            }
        }
        return (T) h4.I(iterable.iterator(), t10);
    }

    @m5
    public static <T> T y(List<T> list) {
        return list.get(list.size() - 1);
    }

    @m5
    public static <T> T z(Iterable<T> iterable) {
        return (T) h4.K(iterable.iterator());
    }
}
