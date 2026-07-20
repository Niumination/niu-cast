package c1;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public abstract class m<T> {

    public static final class b extends m<Object> implements Serializable {
        static final b INSTANCE = new b();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // c1.m
        public boolean doEquivalent(Object a10, Object b10) {
            return a10.equals(b10);
        }

        @Override // c1.m
        public int doHash(Object o10) {
            return o10.hashCode();
        }
    }

    public static final class c<T> implements i0<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final m<T> equivalence;

        @gm.a
        private final T target;

        public c(m<T> equivalence, @gm.a T target) {
            equivalence.getClass();
            this.equivalence = equivalence;
            this.target = target;
        }

        @Override // c1.i0
        public boolean apply(@gm.a T input) {
            return this.equivalence.equivalent(input, this.target);
        }

        @Override // c1.i0
        public boolean equals(@gm.a Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.equivalence.equals(cVar.equivalence) && b0.a(this.target, cVar.target);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.equivalence, this.target});
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.equivalence);
            sb2.append(".equivalentTo(");
            return j.e.a(sb2, this.target, ")");
        }
    }

    public static final class d extends m<Object> implements Serializable {
        static final d INSTANCE = new d();
        private static final long serialVersionUID = 1;

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // c1.m
        public boolean doEquivalent(Object a10, Object b10) {
            return false;
        }

        @Override // c1.m
        public int doHash(Object o10) {
            return System.identityHashCode(o10);
        }
    }

    public static final class e<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final m<? super T> equivalence;

        @e0
        private final T reference;

        public boolean equals(@gm.a Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.equivalence.equals(eVar.equivalence)) {
                return this.equivalence.equivalent(this.reference, eVar.reference);
            }
            return false;
        }

        @e0
        public T get() {
            return this.reference;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.equivalence);
            sb2.append(".wrap(");
            return j.e.a(sb2, this.reference, ")");
        }

        public e(m<? super T> equivalence, @e0 T reference) {
            equivalence.getClass();
            this.equivalence = equivalence;
            this.reference = reference;
        }
    }

    public static m<Object> equals() {
        return b.INSTANCE;
    }

    public static m<Object> identity() {
        return d.INSTANCE;
    }

    @t1.g
    public abstract boolean doEquivalent(T a10, T b10);

    @t1.g
    public abstract int doHash(T t10);

    public final boolean equivalent(@gm.a T a10, @gm.a T b10) {
        if (a10 == b10) {
            return true;
        }
        if (a10 == null || b10 == null) {
            return false;
        }
        return doEquivalent(a10, b10);
    }

    public final i0<T> equivalentTo(@gm.a T target) {
        return new c(this, target);
    }

    public final int hash(@gm.a T t10) {
        if (t10 == null) {
            return 0;
        }
        return doHash(t10);
    }

    public final <F> m<F> onResultOf(t<? super F, ? extends T> function) {
        return new u(function, this);
    }

    @b1.b(serializable = true)
    public final <S extends T> m<Iterable<S>> pairwise() {
        return new d0(this);
    }

    public final <S extends T> e<S> wrap(@e0 S reference) {
        return new e<>(reference);
    }
}
