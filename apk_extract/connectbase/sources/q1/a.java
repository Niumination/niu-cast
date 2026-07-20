package q1;

import java.lang.Throwable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public abstract class a<V, X extends Throwable, F, T> extends u0.a<V> implements Runnable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @gm.a
    public s1<? extends V> f13400n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @gm.a
    public Class<X> f13401p;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @gm.a
    public F f13402v;

    /* JADX INFO: renamed from: q1.a$a, reason: collision with other inner class name */
    public static final class C0336a<V, X extends Throwable> extends a<V, X, x<? super X, ? extends V>, s1<? extends V>> {
        public C0336a(s1<? extends V> input, Class<X> exceptionType, x<? super X, ? extends V> fallback) {
            super(input, exceptionType, fallback);
        }

        @Override // q1.a
        public void Q(Object result) {
            D((s1) result);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // q1.a
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public s1<? extends V> P(x<? super X, ? extends V> fallback, X cause) throws Exception {
            s1<? extends V> s1VarApply = fallback.apply(cause);
            c1.h0.V(s1VarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", fallback);
            return s1VarApply;
        }

        public void S(s1<? extends V> result) {
            D(result);
        }
    }

    public static final class b<V, X extends Throwable> extends a<V, X, c1.t<? super X, ? extends V>, V> {
        public b(s1<? extends V> input, Class<X> exceptionType, c1.t<? super X, ? extends V> fallback) {
            super(input, exceptionType, fallback);
        }

        @Override // q1.a
        @c2
        public Object P(Object fallback, Throwable cause) throws Exception {
            return ((c1.t) fallback).apply(cause);
        }

        @Override // q1.a
        public void Q(@c2 V result) {
            B(result);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @c2
        public V R(c1.t<? super X, ? extends V> fallback, X cause) throws Exception {
            return fallback.apply(cause);
        }
    }

    public a(s1<? extends V> inputFuture, Class<X> exceptionType, F fallback) {
        inputFuture.getClass();
        this.f13400n = inputFuture;
        exceptionType.getClass();
        this.f13401p = exceptionType;
        fallback.getClass();
        this.f13402v = fallback;
    }

    public static <V, X extends Throwable> s1<V> N(s1<? extends V> input, Class<X> exceptionType, c1.t<? super X, ? extends V> fallback, Executor executor) {
        b bVar = new b((s1) input, (Class) exceptionType, fallback);
        input.addListener(bVar, z1.p(executor, bVar));
        return bVar;
    }

    public static <X extends Throwable, V> s1<V> O(s1<? extends V> input, Class<X> exceptionType, x<? super X, ? extends V> fallback, Executor executor) {
        C0336a c0336a = new C0336a((s1) input, (Class) exceptionType, fallback);
        input.addListener(c0336a, z1.p(executor, c0336a));
        return c0336a;
    }

    @t1.g
    @c2
    public abstract T P(F fallback, X throwable) throws Exception;

    @t1.g
    public abstract void Q(@c2 T result);

    @Override // q1.f
    public final void m() {
        x(this.f13400n);
        this.f13400n = null;
        this.f13401p = null;
        this.f13402v = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [F, java.lang.Class<X extends java.lang.Throwable>] */
    @Override // java.lang.Runnable
    public final void run() {
        Throwable e10;
        Object objJ;
        s1<? extends V> s1Var = this.f13400n;
        Class<X> cls = this.f13401p;
        F f10 = this.f13402v;
        if (((f10 == null) || ((s1Var == 0) | (cls == null))) || (this.f13426a instanceof f.c)) {
            return;
        }
        ?? r10 = (Class<X>) null;
        this.f13400n = null;
        try {
            e10 = s1Var instanceof r1.a ? ((r1.a) s1Var).a() : null;
            objJ = e10 == null ? h1.j(s1Var) : null;
        } catch (Error | RuntimeException e11) {
            e10 = e11;
        } catch (ExecutionException e12) {
            Throwable cause = e12.getCause();
            if (cause == null) {
                cause = new NullPointerException("Future type " + s1Var.getClass() + " threw " + e12.getClass() + " without a cause");
            }
            e10 = cause;
        }
        if (e10 == null) {
            B(objJ);
            return;
        }
        if (!cls.isInstance(e10)) {
            D(s1Var);
            return;
        }
        try {
            Object objP = P(f10, e10);
            this.f13401p = null;
            this.f13402v = null;
            Q(objP);
        } catch (Throwable th2) {
            try {
                e2.b(th2);
                C(th2);
            } finally {
                this.f13401p = null;
                this.f13402v = null;
            }
        }
    }

    @Override // q1.f
    @gm.a
    public String y() {
        String str;
        s1<? extends V> s1Var = this.f13400n;
        Class<X> cls = this.f13401p;
        F f10 = this.f13402v;
        String strY = super.y();
        if (s1Var != null) {
            str = "inputFuture=[" + s1Var + "], ";
        } else {
            str = "";
        }
        if (cls == null || f10 == null) {
            if (strY != null) {
                return j.a.a(str, strY);
            }
            return null;
        }
        return str + "exceptionType=[" + cls + "], fallback=[" + f10 + "]";
    }
}
