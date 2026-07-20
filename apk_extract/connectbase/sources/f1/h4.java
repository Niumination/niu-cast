package f1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public final class h4 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> extends x7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Enumeration f4939a;

        public a(final Enumeration val$enumeration) {
            this.f4939a = val$enumeration;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4939a.hasMoreElements();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            return (T) this.f4939a.nextElement();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements Enumeration<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f4940a;

        public b(final Iterator val$iterator) {
            this.f4940a = val$iterator;
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f4940a.hasNext();
        }

        @Override // java.util.Enumeration
        @m5
        public T nextElement() {
            return (T) this.f4940a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends x7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f4941a;

        public c(final Iterator val$iterator) {
            this.f4941a = val$iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4941a.hasNext();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            return (T) this.f4941a.next();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Iterator<T> f4942a = n.INSTANCE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f4943b;

        public d(final Iterable val$iterable) {
            this.f4943b = val$iterable;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4942a.hasNext() || this.f4943b.iterator().hasNext();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            if (!this.f4942a.hasNext()) {
                Iterator<T> it = this.f4943b.iterator();
                this.f4942a = it;
                if (!it.hasNext()) {
                    throw new NoSuchElementException();
                }
            }
            return this.f4942a.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f4942a.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [I] */
    public class e<I> extends x7<I> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4944a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterator[] f4945b;

        public e(final Iterator[] val$elements) {
            this.f4945b = val$elements;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TI; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Iterator next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator it = this.f4945b[this.f4944a];
            Objects.requireNonNull(it);
            Iterator it2 = it;
            Iterator[] itArr = this.f4945b;
            int i10 = this.f4944a;
            itArr[i10] = null;
            this.f4944a = i10 + 1;
            return it2;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4944a < this.f4945b.length;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class f<T> extends x7<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f4946a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4947b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f4948c;

        public f(final Iterator val$iterator, final int val$size, final boolean val$pad) {
            this.f4946a = val$iterator;
            this.f4947b = val$size;
            this.f4948c = val$pad;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object[] objArr = new Object[this.f4947b];
            int i10 = 0;
            while (i10 < this.f4947b && this.f4946a.hasNext()) {
                objArr[i10] = this.f4946a.next();
                i10++;
            }
            for (int i11 = i10; i11 < this.f4947b; i11++) {
                objArr[i11] = null;
            }
            List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
            return (this.f4948c || i10 == this.f4947b) ? listUnmodifiableList : listUnmodifiableList.subList(0, i10);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4946a.hasNext();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class g<T> extends f1.c<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f4949c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c1.i0 f4950d;

        public g(final Iterator val$unfiltered, final c1.i0 val$retainIfTrue) {
            this.f4949c = val$unfiltered;
            this.f4950d = val$retainIfTrue;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // f1.c
        @gm.a
        public T a() {
            while (this.f4949c.hasNext()) {
                T t10 = (T) this.f4949c.next();
                if (this.f4950d.apply(t10)) {
                    return t10;
                }
            }
            this.f4711a = f1.c.b.DONE;
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T, F] */
    public class h<F, T> extends o7<F, T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.t f4951b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Iterator backingIterator, final c1.t val$function) {
            super(backingIterator);
            this.f4951b = val$function;
        }

        @Override // f1.o7
        @m5
        public T a(@m5 F f10) {
            return (T) this.f4951b.apply(f10);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class i<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4952a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f4953b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Iterator f4954c;

        public i(final int val$limitSize, final Iterator val$iterator) {
            this.f4953b = val$limitSize;
            this.f4954c = val$iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4952a < this.f4953b && this.f4954c.hasNext();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f4952a++;
            return (T) this.f4954c.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f4954c.remove();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class j<T> extends x7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f4955a;

        public j(final Iterator val$iterator) {
            this.f4955a = val$iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4955a.hasNext();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            T t10 = (T) this.f4955a.next();
            this.f4955a.remove();
            return t10;
        }

        public String toString() {
            return "Iterators.consumingIterator(...)";
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class k<T> extends x7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f4956a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f4957b;

        public k(final Object val$value) {
            this.f4957b = val$value;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f4956a;
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            if (this.f4956a) {
                throw new NoSuchElementException();
            }
            this.f4956a = true;
            return (T) this.f4957b;
        }
    }

    public static final class l<T> extends f1.b<T> {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final y7<Object> f4958e = new l(new Object[0], 0, 0, 0);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final T[] f4959c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f4960d;

        public l(T[] array, int offset, int length, int index) {
            super(length, index);
            this.f4959c = array;
            this.f4960d = offset;
        }

        @Override // f1.b
        @m5
        public T a(int index) {
            return this.f4959c[this.f4960d + index];
        }
    }

    public static class m<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @gm.a
        public Iterator<? extends T> f4961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Iterator<? extends T> f4962b = l.f4958e;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public Iterator<? extends Iterator<? extends T>> f4963c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @gm.a
        public Deque<Iterator<? extends Iterator<? extends T>>> f4964d;

        public m(Iterator<? extends Iterator<? extends T>> metaIterator) {
            metaIterator.getClass();
            this.f4963c = metaIterator;
        }

        @gm.a
        public final Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f4963c;
                if (it != null && it.hasNext()) {
                    return this.f4963c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f4964d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f4963c = this.f4964d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (true) {
                Iterator<? extends T> it = this.f4962b;
                it.getClass();
                if (it.hasNext()) {
                    return true;
                }
                Iterator<? extends Iterator<? extends T>> itA = a();
                this.f4963c = itA;
                if (itA == null) {
                    return false;
                }
                Iterator<? extends T> next = itA.next();
                this.f4962b = next;
                if (next instanceof m) {
                    m mVar = (m) next;
                    this.f4962b = mVar.f4962b;
                    if (this.f4964d == null) {
                        this.f4964d = new ArrayDeque();
                    }
                    this.f4964d.addFirst(this.f4963c);
                    if (mVar.f4964d != null) {
                        while (!mVar.f4964d.isEmpty()) {
                            this.f4964d.addFirst(mVar.f4964d.removeLast());
                        }
                    }
                    this.f4963c = mVar.f4963c;
                }
            }
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends T> it = this.f4962b;
            this.f4961a = it;
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f4961a;
            if (it == null) {
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
            it.remove();
            this.f4961a = null;
        }
    }

    public enum n implements Iterator<Object> {
        INSTANCE;

        public static /* synthetic */ n[] a() {
            return new n[]{INSTANCE};
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            b0.e(false);
        }
    }

    public static class o<T> extends x7<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Queue<n5<T>> f4966a;

        public o(Iterable<? extends Iterator<? extends T>> iterators, final Comparator<? super T> itemComparator) {
            this.f4966a = new PriorityQueue(2, new Comparator() { // from class: f1.i4
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return h4.o.b(itemComparator, (n5) obj, (n5) obj2);
                }
            });
            for (Iterator<? extends T> it : iterators) {
                if (it.hasNext()) {
                    this.f4966a.add(h4.T(it));
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ int b(Comparator comparator, n5 n5Var, n5 n5Var2) {
            return comparator.compare(n5Var.peek(), n5Var2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f4966a.isEmpty();
        }

        @Override // java.util.Iterator
        @m5
        public T next() {
            n5<T> n5VarRemove = this.f4966a.remove();
            T next = n5VarRemove.next();
            if (n5VarRemove.hasNext()) {
                this.f4966a.add(n5VarRemove);
            }
            return next;
        }
    }

    public static class p<E> implements n5<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator<? extends E> f4967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f4968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @gm.a
        public E f4969c;

        public p(Iterator<? extends E> iterator) {
            iterator.getClass();
            this.f4967a = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f4968b || this.f4967a.hasNext();
        }

        @Override // f1.n5, java.util.Iterator
        @m5
        public E next() {
            if (!this.f4968b) {
                return this.f4967a.next();
            }
            E e10 = this.f4969c;
            this.f4968b = false;
            this.f4969c = null;
            return e10;
        }

        @Override // f1.n5
        @m5
        public E peek() {
            if (!this.f4968b) {
                this.f4969c = this.f4967a.next();
                this.f4968b = true;
            }
            return this.f4969c;
        }

        @Override // f1.n5, java.util.Iterator
        public void remove() {
            c1.h0.h0(!this.f4968b, "Can't remove after you've peeked at next");
            this.f4967a.remove();
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @gm.a
    public static <T> T A(Iterator<? extends T> it, c1.i0<? super T> i0Var, @gm.a T t10) {
        it.getClass();
        i0Var.getClass();
        while (it.hasNext()) {
            T next = it.next();
            if (i0Var.apply(next)) {
                return next;
            }
        }
        return t10;
    }

    @SafeVarargs
    public static <T> x7<T> B(T... array) {
        return C(array, 0, array.length, 0);
    }

    public static <T> y7<T> C(T[] tArr, int i10, int i11, int i12) {
        c1.h0.d(i11 >= 0);
        c1.h0.f0(i10, i10 + i11, tArr.length);
        c1.h0.d0(i12, i11);
        return i11 == 0 ? (y7<T>) l.f4958e : new l(tArr, i10, i11, i12);
    }

    public static <T> x7<T> D(Enumeration<T> enumeration) {
        enumeration.getClass();
        return new a(enumeration);
    }

    public static int E(Iterator<?> iterator, @gm.a Object element) {
        int i10 = 0;
        while (q(iterator, element)) {
            i10++;
        }
        return i10;
    }

    @m5
    public static <T> T F(Iterator<T> iterator, int position) {
        g(position);
        int iB = b(iterator, position);
        if (iterator.hasNext()) {
            return iterator.next();
        }
        throw new IndexOutOfBoundsException("position (" + position + ") must be less than the number of elements that remained (" + iB + ")");
    }

    @m5
    public static <T> T G(Iterator<? extends T> it, int i10, @m5 T t10) {
        g(i10);
        b(it, i10);
        return (T) J(it, t10);
    }

    @m5
    public static <T> T H(Iterator<T> iterator) {
        T next;
        do {
            next = iterator.next();
        } while (iterator.hasNext());
        return next;
    }

    @m5
    public static <T> T I(Iterator<? extends T> it, @m5 T t10) {
        return it.hasNext() ? (T) H(it) : t10;
    }

    @m5
    public static <T> T J(Iterator<? extends T> iterator, @m5 T defaultValue) {
        return iterator.hasNext() ? iterator.next() : defaultValue;
    }

    @m5
    public static <T> T K(Iterator<T> iterator) {
        T next = iterator.next();
        if (!iterator.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder("expected one element but was: <");
        sb2.append(next);
        for (int i10 = 0; i10 < 4 && iterator.hasNext(); i10++) {
            sb2.append(", ");
            sb2.append(iterator.next());
        }
        if (iterator.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append(jq.m0.f8868f);
        throw new IllegalArgumentException(sb2.toString());
    }

    @m5
    public static <T> T L(Iterator<? extends T> it, @m5 T t10) {
        return it.hasNext() ? (T) K(it) : t10;
    }

    public static <T> int M(Iterator<T> iterator, c1.i0<? super T> predicate) {
        c1.h0.F(predicate, "predicate");
        int i10 = 0;
        while (iterator.hasNext()) {
            if (predicate.apply(iterator.next())) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public static <T> Iterator<T> N(Iterator<T> iterator, int limitSize) {
        iterator.getClass();
        c1.h0.e(limitSize >= 0, "limit is negative");
        return new i(limitSize, iterator);
    }

    public static <T> x7<T> O(Iterable<? extends Iterator<? extends T>> iterators, Comparator<? super T> comparator) {
        c1.h0.F(iterators, "iterators");
        c1.h0.F(comparator, "comparator");
        return new o(iterators, comparator);
    }

    public static <T> x7<List<T>> P(Iterator<T> iterator, int size) {
        return R(iterator, size, true);
    }

    public static <T> x7<List<T>> Q(Iterator<T> iterator, int size) {
        return R(iterator, size, false);
    }

    public static <T> x7<List<T>> R(Iterator<T> iterator, int size, boolean pad) {
        iterator.getClass();
        c1.h0.d(size > 0);
        return new f(iterator, size, pad);
    }

    @Deprecated
    public static <T> n5<T> S(n5<T> iterator) {
        iterator.getClass();
        return iterator;
    }

    public static <T> n5<T> T(Iterator<? extends T> iterator) {
        return iterator instanceof p ? (p) iterator : new p(iterator);
    }

    @gm.a
    public static <T> T U(Iterator<T> iterator) {
        if (!iterator.hasNext()) {
            return null;
        }
        T next = iterator.next();
        iterator.remove();
        return next;
    }

    @t1.a
    public static boolean V(Iterator<?> removeFrom, Collection<?> elementsToRemove) {
        elementsToRemove.getClass();
        boolean z10 = false;
        while (removeFrom.hasNext()) {
            if (elementsToRemove.contains(removeFrom.next())) {
                removeFrom.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @t1.a
    public static <T> boolean W(Iterator<T> removeFrom, c1.i0<? super T> predicate) {
        predicate.getClass();
        boolean z10 = false;
        while (removeFrom.hasNext()) {
            if (predicate.apply(removeFrom.next())) {
                removeFrom.remove();
                z10 = true;
            }
        }
        return z10;
    }

    @t1.a
    public static boolean X(Iterator<?> removeFrom, Collection<?> elementsToRetain) {
        elementsToRetain.getClass();
        boolean z10 = false;
        while (removeFrom.hasNext()) {
            if (!elementsToRetain.contains(removeFrom.next())) {
                removeFrom.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> x7<T> Y(@m5 T value) {
        return new k(value);
    }

    public static int Z(Iterator<?> iterator) {
        long j10 = 0;
        while (iterator.hasNext()) {
            iterator.next();
            j10++;
        }
        return o1.l.z(j10);
    }

    @t1.a
    public static <T> boolean a(Collection<T> addTo, Iterator<? extends T> iterator) {
        addTo.getClass();
        iterator.getClass();
        boolean zAdd = false;
        while (iterator.hasNext()) {
            zAdd |= addTo.add(iterator.next());
        }
        return zAdd;
    }

    @b1.c
    public static <T> T[] a0(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) g4.Q(p4.s(it), cls);
    }

    @t1.a
    public static int b(Iterator<?> iterator, int numberToAdvance) {
        iterator.getClass();
        int i10 = 0;
        c1.h0.e(numberToAdvance >= 0, "numberToAdvance must be nonnegative");
        while (i10 < numberToAdvance && iterator.hasNext()) {
            iterator.next();
            i10++;
        }
        return i10;
    }

    public static String b0(Iterator<?> iterator) {
        StringBuilder sb2 = new StringBuilder("[");
        boolean z10 = true;
        while (iterator.hasNext()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(iterator.next());
            z10 = false;
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <T> boolean c(Iterator<T> iterator, c1.i0<? super T> predicate) {
        predicate.getClass();
        while (iterator.hasNext()) {
            if (!predicate.apply(iterator.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> c0(Iterator<F> fromIterator, c1.t<? super F, ? extends T> function) {
        function.getClass();
        return new h(fromIterator, function);
    }

    public static <T> boolean d(Iterator<T> iterator, c1.i0<? super T> predicate) {
        return M(iterator, predicate) != -1;
    }

    public static <T> c1.c0<T> d0(Iterator<T> iterator, c1.i0<? super T> predicate) {
        iterator.getClass();
        predicate.getClass();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.apply(next)) {
                return c1.c0.of(next);
            }
        }
        return c1.c0.absent();
    }

    public static <T> Enumeration<T> e(Iterator<T> iterator) {
        iterator.getClass();
        return new b(iterator);
    }

    @Deprecated
    public static <T> x7<T> e0(x7<T> iterator) {
        iterator.getClass();
        return iterator;
    }

    public static <T> ListIterator<T> f(Iterator<T> iterator) {
        return (ListIterator) iterator;
    }

    public static <T> x7<T> f0(Iterator<? extends T> iterator) {
        iterator.getClass();
        return iterator instanceof x7 ? (x7) iterator : new c(iterator);
    }

    public static void g(int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException(k.b.a("position (", position, ") must not be negative"));
        }
    }

    public static void h(Iterator<?> iterator) {
        iterator.getClass();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
    }

    public static <T> Iterator<T> i(Iterator<? extends Iterator<? extends T>> inputs) {
        return new m(inputs);
    }

    public static <T> Iterator<T> j(Iterator<? extends T> a10, Iterator<? extends T> b10) {
        a10.getClass();
        b10.getClass();
        return new m(new e(new Iterator[]{a10, b10}));
    }

    public static <T> Iterator<T> k(Iterator<? extends T> a10, Iterator<? extends T> b10, Iterator<? extends T> c10) {
        a10.getClass();
        b10.getClass();
        c10.getClass();
        return new m(new e(new Iterator[]{a10, b10, c10}));
    }

    public static <T> Iterator<T> l(Iterator<? extends T> a10, Iterator<? extends T> b10, Iterator<? extends T> c10, Iterator<? extends T> d10) {
        a10.getClass();
        b10.getClass();
        c10.getClass();
        d10.getClass();
        return new m(new e(new Iterator[]{a10, b10, c10, d10}));
    }

    public static <T> Iterator<T> m(Iterator<? extends T>... inputs) {
        return n((Iterator[]) Arrays.copyOf(inputs, inputs.length));
    }

    public static <T> Iterator<T> n(Iterator<? extends T>... inputs) {
        inputs.getClass();
        for (Iterator<? extends T> it : inputs) {
            it.getClass();
        }
        return new m(new e(inputs));
    }

    public static <I extends Iterator<?>> Iterator<I> o(I... elements) {
        return new e(elements);
    }

    public static <T> Iterator<T> p(Iterator<T> iterator) {
        iterator.getClass();
        return new j(iterator);
    }

    public static boolean q(Iterator<?> iterator, @gm.a Object element) {
        if (element == null) {
            while (iterator.hasNext()) {
                if (iterator.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (iterator.hasNext()) {
            if (element.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> r(Iterable<T> iterable) {
        iterable.getClass();
        return new d(iterable);
    }

    @SafeVarargs
    public static <T> Iterator<T> s(T... elements) {
        return r(p4.t(elements));
    }

    public static boolean t(Iterator<?> iterator1, Iterator<?> iterator2) {
        while (iterator1.hasNext()) {
            if (!iterator2.hasNext() || !c1.b0.a(iterator1.next(), iterator2.next())) {
                return false;
            }
        }
        return !iterator2.hasNext();
    }

    public static <T> x7<T> u() {
        return l.f4958e;
    }

    public static <T> y7<T> v() {
        return (y7<T>) l.f4958e;
    }

    public static <T> Iterator<T> w() {
        return n.INSTANCE;
    }

    public static <T> x7<T> x(Iterator<T> unfiltered, c1.i0<? super T> retainIfTrue) {
        unfiltered.getClass();
        retainIfTrue.getClass();
        return new g(unfiltered, retainIfTrue);
    }

    @b1.c
    public static <T> x7<T> y(Iterator<?> unfiltered, Class<T> desiredType) {
        return x(unfiltered, c1.j0.o(desiredType));
    }

    @m5
    public static <T> T z(Iterator<T> iterator, c1.i0<? super T> predicate) {
        iterator.getClass();
        predicate.getClass();
        while (iterator.hasNext()) {
            T next = iterator.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }
}
