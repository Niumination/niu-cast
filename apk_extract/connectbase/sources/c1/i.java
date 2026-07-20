package c1;

import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public abstract class i<A, B> implements t<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @u1.b
    @RetainedWith
    @gm.a
    public transient i<B, A> f1185a;
    private final boolean handleNullAutomatically;

    public class a implements Iterable<B> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterable f1186a;

        /* JADX INFO: renamed from: c1.i$a$a, reason: collision with other inner class name */
        public class C0051a implements Iterator<B> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Iterator<? extends A> f1188a;

            public C0051a() {
                this.f1188a = a.this.f1186a.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f1188a.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) i.this.convert(this.f1188a.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f1188a.remove();
            }
        }

        public a(final Iterable val$fromIterable) {
            this.f1186a = val$fromIterable;
        }

        @Override // java.lang.Iterable
        public Iterator<B> iterator() {
            return new C0051a();
        }
    }

    public static final class b<A, B, C> extends i<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        final i<A, B> first;
        final i<B, C> second;

        public b(i<A, B> first, i<B, C> second) {
            this.first = first;
            this.second = second;
        }

        @Override // c1.i
        @gm.a
        public A correctedDoBackward(@gm.a C c10) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c10));
        }

        @Override // c1.i
        @gm.a
        public C correctedDoForward(@gm.a A a10) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a10));
        }

        @Override // c1.i
        public A doBackward(C c10) {
            throw new AssertionError();
        }

        @Override // c1.i
        public C doForward(A a10) {
            throw new AssertionError();
        }

        @Override // c1.i, c1.t
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof b)) {
                return false;
            }
            b bVar = (b) object;
            return this.first.equals(bVar.first) && this.second.equals(bVar.second);
        }

        public int hashCode() {
            return this.second.hashCode() + (this.first.hashCode() * 31);
        }

        public String toString() {
            return this.first + ".andThen(" + this.second + ")";
        }
    }

    public static final class c<A, B> extends i<A, B> implements Serializable {
        private final t<? super B, ? extends A> backwardFunction;
        private final t<? super A, ? extends B> forwardFunction;

        public /* synthetic */ c(t tVar, t tVar2, a aVar) {
            this(tVar, tVar2);
        }

        @Override // c1.i
        public A doBackward(B b10) {
            return this.backwardFunction.apply(b10);
        }

        @Override // c1.i
        public B doForward(A a10) {
            return this.forwardFunction.apply(a10);
        }

        @Override // c1.i, c1.t
        public boolean equals(@gm.a Object object) {
            if (!(object instanceof c)) {
                return false;
            }
            c cVar = (c) object;
            return this.forwardFunction.equals(cVar.forwardFunction) && this.backwardFunction.equals(cVar.backwardFunction);
        }

        public int hashCode() {
            return this.backwardFunction.hashCode() + (this.forwardFunction.hashCode() * 31);
        }

        public String toString() {
            return "Converter.from(" + this.forwardFunction + ", " + this.backwardFunction + ")";
        }

        public c(t<? super A, ? extends B> forwardFunction, t<? super B, ? extends A> backwardFunction) {
            forwardFunction.getClass();
            this.forwardFunction = forwardFunction;
            backwardFunction.getClass();
            this.backwardFunction = backwardFunction;
        }
    }

    public static final class d<T> extends i<T, T> implements Serializable {
        static final d<?> INSTANCE = new d<>();
        private static final long serialVersionUID = 0;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // c1.i
        public <S> i<T, S> doAndThen(i<T, S> otherConverter) {
            return (i) h0.F(otherConverter, "otherConverter");
        }

        @Override // c1.i
        public T doBackward(T t10) {
            return t10;
        }

        @Override // c1.i
        public T doForward(T t10) {
            return t10;
        }

        public String toString() {
            return "Converter.identity()";
        }

        @Override // c1.i
        public d<T> reverse() {
            return this;
        }
    }

    public static final class e<A, B> extends i<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        final i<A, B> original;

        public e(i<A, B> original) {
            this.original = original;
        }

        @Override // c1.i
        @gm.a
        public B correctedDoBackward(@gm.a A a10) {
            return this.original.correctedDoForward(a10);
        }

        @Override // c1.i
        @gm.a
        public A correctedDoForward(@gm.a B b10) {
            return this.original.correctedDoBackward(b10);
        }

        @Override // c1.i
        public B doBackward(A a10) {
            throw new AssertionError();
        }

        @Override // c1.i
        public A doForward(B b10) {
            throw new AssertionError();
        }

        @Override // c1.i, c1.t
        public boolean equals(@gm.a Object object) {
            if (object instanceof e) {
                return this.original.equals(((e) object).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // c1.i
        public i<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            return this.original + ".reverse()";
        }
    }

    public i() {
        this(true);
    }

    public static <A, B> i<A, B> from(t<? super A, ? extends B> forwardFunction, t<? super B, ? extends A> backwardFunction) {
        return new c(forwardFunction, backwardFunction, null);
    }

    public static <T> i<T, T> identity() {
        return d.INSTANCE;
    }

    @gm.a
    public final A a(@gm.a B b10) {
        return doBackward(b10);
    }

    public final <C> i<A, C> andThen(i<B, C> secondConverter) {
        return doAndThen(secondConverter);
    }

    @Override // c1.t
    @t1.l(replacement = "this.convert(a)")
    @Deprecated
    public final B apply(A a10) {
        return convert(a10);
    }

    @gm.a
    public final B b(@gm.a A a10) {
        return doForward(a10);
    }

    @gm.a
    public final B convert(@gm.a A a10) {
        return correctedDoForward(a10);
    }

    public Iterable<B> convertAll(Iterable<? extends A> fromIterable) {
        h0.F(fromIterable, "fromIterable");
        return new a(fromIterable);
    }

    @gm.a
    public A correctedDoBackward(@gm.a B b10) {
        if (!this.handleNullAutomatically) {
            return doBackward(b10);
        }
        if (b10 == null) {
            return null;
        }
        A aDoBackward = doBackward(b10);
        aDoBackward.getClass();
        return aDoBackward;
    }

    @gm.a
    public B correctedDoForward(@gm.a A a10) {
        if (!this.handleNullAutomatically) {
            return doForward(a10);
        }
        if (a10 == null) {
            return null;
        }
        B bDoForward = doForward(a10);
        bDoForward.getClass();
        return bDoForward;
    }

    public <C> i<A, C> doAndThen(i<B, C> secondConverter) {
        secondConverter.getClass();
        return new b(this, secondConverter);
    }

    @t1.g
    public abstract A doBackward(B b10);

    @t1.g
    public abstract B doForward(A a10);

    @Override // c1.t
    public boolean equals(@gm.a Object object) {
        return super.equals(object);
    }

    @t1.b
    public i<B, A> reverse() {
        i<B, A> iVar = this.f1185a;
        if (iVar != null) {
            return iVar;
        }
        e eVar = new e(this);
        this.f1185a = eVar;
        return eVar;
    }

    public i(boolean handleNullAutomatically) {
        this.handleNullAutomatically = handleNullAutomatically;
    }
}
