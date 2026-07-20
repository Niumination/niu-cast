package f1;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@x0
public abstract class p1<E> implements Iterable<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1.c0<Iterable<E>> f5175a;

    public class a extends p1<E> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f5176b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Iterable iterable, final Iterable val$iterable) {
            super(iterable);
            this.f5176b = val$iterable;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f5176b.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f5177b;

        public b(final Iterable val$inputs) {
            this.f5177b = val$inputs;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new h4.m(h4.c0(this.f5177b.iterator(), new q1()));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> extends p1<T> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable[] f5178b;

        public class a extends f1.b<Iterator<? extends T>> {
            public a(int size) {
                super(size, 0);
            }

            @Override // f1.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Iterator<? extends T> a(int i10) {
                return c.this.f5178b[i10].iterator();
            }
        }

        public c(final Iterable[] val$inputs) {
            this.f5178b = val$inputs;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return new h4.m(new a(this.f5178b.length));
        }
    }

    public static class d<E> implements c1.t<Iterable<E>, p1<E>> {
        @Override // c1.t
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public p1<E> apply(Iterable<E> fromObject) {
            return p1.u(fromObject);
        }
    }

    public p1() {
        this.f5175a = c1.c0.absent();
    }

    public static <E> p1<E> B() {
        return u(Collections.emptyList());
    }

    public static <E> p1<E> C(@m5 E element, E... elements) {
        return u(new p4.e(element, elements));
    }

    public static <T> p1<T> f(final Iterable<? extends Iterable<? extends T>> inputs) {
        inputs.getClass();
        return new b(inputs);
    }

    public static <T> p1<T> g(Iterable<? extends T> a10, Iterable<? extends T> b10) {
        return l(a10, b10);
    }

    public static <T> p1<T> i(Iterable<? extends T> a10, Iterable<? extends T> b10, Iterable<? extends T> c10) {
        return l(a10, b10, c10);
    }

    public static <T> p1<T> j(Iterable<? extends T> a10, Iterable<? extends T> b10, Iterable<? extends T> c10, Iterable<? extends T> d10) {
        return l(a10, b10, c10, d10);
    }

    public static <T> p1<T> k(Iterable<? extends T>... inputs) {
        return l((Iterable[]) Arrays.copyOf(inputs, inputs.length));
    }

    public static <T> p1<T> l(final Iterable<? extends T>... inputs) {
        for (Iterable<? extends T> iterable : inputs) {
            iterable.getClass();
        }
        return new c(inputs);
    }

    @t1.l(replacement = "checkNotNull(iterable)", staticImports = {"com.google.common.base.Preconditions.checkNotNull"})
    @Deprecated
    public static <E> p1<E> t(p1<E> iterable) {
        iterable.getClass();
        return iterable;
    }

    public static <E> p1<E> u(final Iterable<E> iterable) {
        return iterable instanceof p1 ? (p1) iterable : new a(iterable, iterable);
    }

    public static <E> p1<E> v(E[] elements) {
        return u(Arrays.asList(elements));
    }

    public final p1<E> A(int maxSize) {
        return u(g4.D(w(), maxSize));
    }

    public final p1<E> D(int numberToSkip) {
        return u(g4.N(w(), numberToSkip));
    }

    @b1.c
    public final E[] E(Class<E> cls) {
        return (E[]) g4.Q(w(), cls);
    }

    public final i3<E> F() {
        return i3.copyOf(w());
    }

    public final <V> k3<E, V> G(c1.t<? super E, V> valueFunction) {
        return t4.u0(w(), valueFunction);
    }

    public final p3<E> H() {
        return p3.copyOf(w());
    }

    public final t3<E> I() {
        return t3.copyOf(w());
    }

    public final i3<E> J(Comparator<? super E> comparator) {
        return l5.from(comparator).immutableSortedCopy(w());
    }

    public final a4<E> K(Comparator<? super E> comparator) {
        return a4.copyOf(comparator, w());
    }

    public final <T> p1<T> L(c1.t<? super E, T> function) {
        return u(g4.T(w(), function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> p1<T> M(c1.t<? super E, ? extends Iterable<? extends T>> function) {
        return f(L(function));
    }

    public final <K> k3<K, E> N(c1.t<? super E, K> keyFunction) {
        return t4.E0(w(), keyFunction);
    }

    public final boolean a(c1.i0<? super E> predicate) {
        return g4.b(w(), predicate);
    }

    public final boolean b(c1.i0<? super E> predicate) {
        return g4.c(w(), predicate);
    }

    public final p1<E> c(Iterable<? extends E> other) {
        return g(w(), other);
    }

    public final boolean contains(@gm.a Object target) {
        return g4.k(w(), target);
    }

    public final p1<E> e(E... elements) {
        return g(w(), Arrays.asList(elements));
    }

    @m5
    public final E get(int i10) {
        return (E) g4.t(w(), i10);
    }

    public final boolean isEmpty() {
        return !w().iterator().hasNext();
    }

    @t1.a
    public final <C extends Collection<? super E>> C m(C collection) {
        collection.getClass();
        Iterable<E> iterableW = w();
        if (iterableW instanceof Collection) {
            collection.addAll((Collection) iterableW);
        } else {
            Iterator<E> it = iterableW.iterator();
            while (it.hasNext()) {
                collection.add(it.next());
            }
        }
        return collection;
    }

    public final p1<E> n() {
        return u(g4.l(w()));
    }

    public final p1<E> o(c1.i0<? super E> predicate) {
        return u(g4.o(w(), predicate));
    }

    @b1.c
    public final <T> p1<T> q(Class<T> type) {
        return u(g4.p(w(), type));
    }

    public final c1.c0<E> r() {
        Iterator<E> it = w().iterator();
        return it.hasNext() ? c1.c0.of(it.next()) : c1.c0.absent();
    }

    public final c1.c0<E> s(c1.i0<? super E> predicate) {
        return g4.U(w(), predicate);
    }

    public final int size() {
        return g4.M(w());
    }

    public String toString() {
        return g4.S(w());
    }

    public final Iterable<E> w() {
        return this.f5175a.or(this);
    }

    public final <K> j3<K, E> x(c1.t<? super E, K> keyFunction) {
        return y4.r(w(), keyFunction);
    }

    public final String y(c1.y joiner) {
        return joiner.k(this);
    }

    public final c1.c0<E> z() {
        E next;
        Iterable<E> iterableW = w();
        if (iterableW instanceof List) {
            List list = (List) iterableW;
            return list.isEmpty() ? c1.c0.absent() : c1.c0.of(list.get(list.size() - 1));
        }
        Iterator<E> it = iterableW.iterator();
        if (!it.hasNext()) {
            return c1.c0.absent();
        }
        if (iterableW instanceof SortedSet) {
            return c1.c0.of(((SortedSet) iterableW).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return c1.c0.of(next);
    }

    public p1(Iterable<E> iterable) {
        this.f5175a = c1.c0.of(iterable);
    }
}
