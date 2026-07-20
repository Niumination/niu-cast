package q1;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@b1.b
@o0
public abstract class r<I, O, F, T> extends u0.a<O> implements Runnable {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @gm.a
    public s1<? extends I> f13691n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @gm.a
    public F f13692p;

    public static final class a<I, O> extends r<I, O, x<? super I, ? extends O>, s1<? extends O>> {
        public a(s1<? extends I> inputFuture, x<? super I, ? extends O> function) {
            super(inputFuture, function);
        }

        @Override // q1.r
        public void Q(Object result) {
            D((s1) result);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // q1.r
        /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
        public s1<? extends O> P(x<? super I, ? extends O> function, @c2 I input) throws Exception {
            s1<? extends O> s1VarApply = function.apply(input);
            c1.h0.V(s1VarApply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", function);
            return s1VarApply;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void S(s1<? extends O> result) {
            D(result);
        }
    }

    public static final class b<I, O> extends r<I, O, c1.t<? super I, ? extends O>, O> {
        public b(s1<? extends I> inputFuture, c1.t<? super I, ? extends O> function) {
            super(inputFuture, function);
        }

        @Override // q1.r
        @c2
        public Object P(Object function, @c2 Object input) throws Exception {
            return ((c1.t) function).apply(input);
        }

        @Override // q1.r
        public void Q(@c2 O result) {
            B(result);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @c2
        public O R(c1.t<? super I, ? extends O> function, @c2 I input) {
            return function.apply(input);
        }
    }

    public r(s1<? extends I> inputFuture, F function) {
        inputFuture.getClass();
        this.f13691n = inputFuture;
        function.getClass();
        this.f13692p = function;
    }

    public static <I, O> s1<O> N(s1<I> input, c1.t<? super I, ? extends O> function, Executor executor) {
        function.getClass();
        b bVar = new b((s1) input, function);
        input.addListener(bVar, z1.p(executor, bVar));
        return bVar;
    }

    public static <I, O> s1<O> O(s1<I> input, x<? super I, ? extends O> function, Executor executor) {
        executor.getClass();
        a aVar = new a((s1) input, function);
        input.addListener(aVar, z1.p(executor, aVar));
        return aVar;
    }

    @t1.g
    @c2
    public abstract T P(F function, @c2 I result) throws Exception;

    @t1.g
    public abstract void Q(@c2 T result);

    @Override // q1.f
    public final void m() {
        x(this.f13691n);
        this.f13691n = null;
        this.f13692p = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        s1<? extends I> s1Var = this.f13691n;
        F f10 = this.f13692p;
        if (((this.f13426a instanceof f.c) | (s1Var == null)) || (f10 == null)) {
            return;
        }
        this.f13691n = null;
        if (s1Var.isCancelled()) {
            D(s1Var);
            return;
        }
        try {
            try {
                Object objP = P(f10, h1.j(s1Var));
                this.f13692p = null;
                Q(objP);
            } catch (Throwable th2) {
                try {
                    e2.b(th2);
                    C(th2);
                } finally {
                    this.f13692p = null;
                }
            }
        } catch (Error e10) {
            C(e10);
        } catch (CancellationException unused) {
            cancel(false);
        } catch (RuntimeException e11) {
            C(e11);
        } catch (ExecutionException e12) {
            C(e12.getCause());
        }
    }

    @Override // q1.f
    @gm.a
    public String y() {
        String str;
        s1<? extends I> s1Var = this.f13691n;
        F f10 = this.f13692p;
        String strY = super.y();
        if (s1Var != null) {
            str = "inputFuture=[" + s1Var + "], ";
        } else {
            str = "";
        }
        if (f10 == null) {
            if (strY != null) {
                return j.a.a(str, strY);
            }
            return null;
        }
        return str + "function=[" + f10 + "]";
    }
}
