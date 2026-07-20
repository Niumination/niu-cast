package c1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@k
public final class r0 {

    @b1.e
    public static class a<T> implements q0<T>, Serializable {
        private static final long serialVersionUID = 0;
        final q0<T> delegate;
        final long durationNanos;
        volatile transient long expirationNanos;

        @gm.a
        volatile transient T value;

        public a(q0<T> delegate, long duration, TimeUnit unit) {
            delegate.getClass();
            this.delegate = delegate;
            this.durationNanos = unit.toNanos(duration);
            h0.t(duration > 0, "duration (%s %s) must be > 0", duration, unit);
        }

        @Override // c1.q0
        @e0
        public T get() {
            long j10 = this.expirationNanos;
            long jNanoTime = System.nanoTime();
            if (j10 == 0 || jNanoTime - j10 >= 0) {
                synchronized (this) {
                    try {
                        if (j10 == this.expirationNanos) {
                            T t10 = this.delegate.get();
                            this.value = t10;
                            long j11 = jNanoTime + this.durationNanos;
                            if (j11 == 0) {
                                j11 = 1;
                            }
                            this.expirationNanos = j11;
                            return t10;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder("Suppliers.memoizeWithExpiration(");
            sb2.append(this.delegate);
            sb2.append(", ");
            return k.d.a(sb2, this.durationNanos, ", NANOS)");
        }
    }

    @b1.e
    public static class b<T> implements q0<T>, Serializable {
        private static final long serialVersionUID = 0;
        final q0<T> delegate;
        volatile transient boolean initialized;

        @gm.a
        transient T value;

        public b(q0<T> delegate) {
            delegate.getClass();
            this.delegate = delegate;
        }

        @Override // c1.q0
        @e0
        public T get() {
            if (!this.initialized) {
                synchronized (this) {
                    try {
                        if (!this.initialized) {
                            T t10 = this.delegate.get();
                            this.value = t10;
                            this.initialized = true;
                            return t10;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return this.value;
        }

        public String toString() {
            return j.e.a(new StringBuilder("Suppliers.memoize("), this.initialized ? j.e.a(new StringBuilder("<supplier that returned "), this.value, ">") : this.delegate, ")");
        }
    }

    @b1.e
    public static class c<T> implements q0<T> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final q0<Void> f1239c = new s0();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile q0<T> f1240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @gm.a
        public T f1241b;

        public c(q0<T> delegate) {
            delegate.getClass();
            this.f1240a = delegate;
        }

        public static /* synthetic */ Void a() {
            throw new IllegalStateException();
        }

        public static /* synthetic */ Void b() {
            throw new IllegalStateException();
        }

        @Override // c1.q0
        @e0
        public T get() {
            q0<T> q0Var = this.f1240a;
            q0<T> q0Var2 = (q0<T>) f1239c;
            if (q0Var != q0Var2) {
                synchronized (this) {
                    try {
                        if (this.f1240a != q0Var2) {
                            T t10 = this.f1240a.get();
                            this.f1241b = t10;
                            this.f1240a = q0Var2;
                            return t10;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return this.f1241b;
        }

        public String toString() {
            Object objA = this.f1240a;
            StringBuilder sb2 = new StringBuilder("Suppliers.memoize(");
            if (objA == f1239c) {
                objA = j.e.a(new StringBuilder("<supplier that returned "), this.f1241b, ">");
            }
            return j.e.a(sb2, objA, ")");
        }
    }

    public static class d<F, T> implements q0<T>, Serializable {
        private static final long serialVersionUID = 0;
        final t<? super F, T> function;
        final q0<F> supplier;

        public d(t<? super F, T> function, q0<F> supplier) {
            function.getClass();
            this.function = function;
            supplier.getClass();
            this.supplier = supplier;
        }

        public boolean equals(@gm.a Object obj) {
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.function.equals(dVar.function) && this.supplier.equals(dVar.supplier);
        }

        @Override // c1.q0
        @e0
        public T get() {
            return this.function.apply(this.supplier.get());
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.function, this.supplier});
        }

        public String toString() {
            return "Suppliers.compose(" + this.function + ", " + this.supplier + ")";
        }
    }

    public interface e<T> extends t<q0<T>, T> {
    }

    public enum f implements e<Object> {
        INSTANCE;

        public static /* synthetic */ f[] a() {
            return new f[]{INSTANCE};
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Suppliers.supplierFunction()";
        }

        @Override // c1.t
        @gm.a
        public Object apply(q0<Object> input) {
            return input.get();
        }
    }

    public static class g<T> implements q0<T>, Serializable {
        private static final long serialVersionUID = 0;

        @e0
        final T instance;

        public g(@e0 T instance) {
            this.instance = instance;
        }

        public boolean equals(@gm.a Object obj) {
            if (obj instanceof g) {
                return b0.a(this.instance, ((g) obj).instance);
            }
            return false;
        }

        @Override // c1.q0
        @e0
        public T get() {
            return this.instance;
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.instance});
        }

        public String toString() {
            return j.e.a(new StringBuilder("Suppliers.ofInstance("), this.instance, ")");
        }
    }

    public static class h<T> implements q0<T>, Serializable {
        private static final long serialVersionUID = 0;
        final q0<T> delegate;

        public h(q0<T> delegate) {
            delegate.getClass();
            this.delegate = delegate;
        }

        @Override // c1.q0
        @e0
        public T get() {
            T t10;
            synchronized (this.delegate) {
                t10 = this.delegate.get();
            }
            return t10;
        }

        public String toString() {
            return "Suppliers.synchronizedSupplier(" + this.delegate + ")";
        }
    }

    public static <F, T> q0<T> a(t<? super F, T> function, q0<F> supplier) {
        return new d(function, supplier);
    }

    public static <T> q0<T> b(q0<T> delegate) {
        if ((delegate instanceof c) || (delegate instanceof b)) {
            return delegate;
        }
        return delegate instanceof Serializable ? new b(delegate) : new c(delegate);
    }

    public static <T> q0<T> c(q0<T> delegate, long duration, TimeUnit unit) {
        return new a(delegate, duration, unit);
    }

    public static <T> q0<T> d(@e0 T instance) {
        return new g(instance);
    }

    public static <T> t<q0<T>, T> e() {
        return f.INSTANCE;
    }

    public static <T> q0<T> f(q0<T> delegate) {
        return new h(delegate);
    }
}
