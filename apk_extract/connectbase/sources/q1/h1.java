package q1;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
public final class h1 extends n1 {

    /* JADX INFO: Add missing generic type declarations: [O] */
    public class a<O> implements Future<O> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Future f13469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.t f13470b;

        public a(final Future val$input, final c1.t val$function) {
            this.f13469a = val$input;
            this.f13470b = val$function;
        }

        public final O a(I i10) throws ExecutionException {
            try {
                return (O) this.f13470b.apply(i10);
            } catch (Error | RuntimeException e10) {
                throw new ExecutionException(e10);
            }
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean mayInterruptIfRunning) {
            return this.f13469a.cancel(mayInterruptIfRunning);
        }

        @Override // java.util.concurrent.Future
        public O get() throws ExecutionException, InterruptedException {
            return a(this.f13469a.get());
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f13469a.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f13469a.isDone();
        }

        @Override // java.util.concurrent.Future
        public O get(long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
            return a(this.f13469a.get(timeout, unit));
        }
    }

    public static final class b<V> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<V> f13471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final e1<? super V> f13472b;

        public b(Future<V> future, e1<? super V> callback) {
            this.f13471a = future;
            this.f13472b = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable thA;
            Future<V> future = this.f13471a;
            if ((future instanceof r1.a) && (thA = ((r1.a) future).a()) != null) {
                this.f13472b.a(thA);
                return;
            }
            try {
                this.f13472b.b(h1.j(this.f13471a));
            } catch (Error | RuntimeException e10) {
                this.f13472b.a(e10);
            } catch (ExecutionException e11) {
                this.f13472b.a(e11.getCause());
            }
        }

        public String toString() {
            c1.z.b bVarC = c1.z.c(this);
            bVarC.h().f1270b = this.f13472b;
            return bVarC.toString();
        }
    }

    @b1.b
    public static final class c<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f13473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f1.i3<s1<? extends V>> f13474b;

        public class a implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Runnable f13475a;

            public a(final c this$0, final Runnable val$combiner) {
                this.f13475a = val$combiner;
            }

            @Override // java.util.concurrent.Callable
            @gm.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                this.f13475a.run();
                return null;
            }
        }

        public /* synthetic */ c(boolean z10, f1.i3 i3Var, a aVar) {
            this(z10, i3Var);
        }

        public <C> s1<C> a(Callable<C> combiner, Executor executor) {
            return new l0(this.f13474b, this.f13473a, executor, combiner);
        }

        public <C> s1<C> b(w<C> combiner, Executor executor) {
            return new l0(this.f13474b, this.f13473a, executor, combiner);
        }

        public s1<?> c(final Runnable combiner, Executor executor) {
            return a(new a(this, combiner), executor);
        }

        public c(boolean allMustSucceed, f1.i3<s1<? extends V>> futures) {
            this.f13473a = allMustSucceed;
            this.f13474b = futures;
        }
    }

    public static final class e<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f13477a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f13478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicInteger f13479c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final s1<? extends T>[] f13480d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile int f13481e;

        public /* synthetic */ e(s1[] s1VarArr, a aVar) {
            this(s1VarArr);
        }

        public final void e() {
            if (this.f13479c.decrementAndGet() == 0 && this.f13477a) {
                for (s1<? extends T> s1Var : this.f13480d) {
                    if (s1Var != null) {
                        s1Var.cancel(this.f13478b);
                    }
                }
            }
        }

        public final void f(f1.i3<q1.f<T>> delegates, int inputFutureIndex) {
            s1<? extends T> s1Var = this.f13480d[inputFutureIndex];
            Objects.requireNonNull(s1Var);
            s1<? extends T> s1Var2 = s1Var;
            this.f13480d[inputFutureIndex] = null;
            for (int i10 = this.f13481e; i10 < delegates.size(); i10++) {
                if (delegates.get(i10).D(s1Var2)) {
                    e();
                    this.f13481e = i10 + 1;
                    return;
                }
            }
            this.f13481e = delegates.size();
        }

        public final void g(boolean interruptIfRunning) {
            this.f13477a = true;
            if (!interruptIfRunning) {
                this.f13478b = false;
            }
            e();
        }

        public e(s1<? extends T>[] inputFutures) {
            this.f13477a = false;
            this.f13478b = true;
            this.f13481e = 0;
            this.f13480d = inputFutures;
            this.f13479c = new AtomicInteger(inputFutures.length);
        }
    }

    public static final class f<V> extends q1.f.j<V> implements Runnable {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @gm.a
        public s1<V> f13482n;

        public f(final s1<V> delegate) {
            this.f13482n = delegate;
        }

        @Override // q1.f
        public void m() {
            this.f13482n = null;
        }

        @Override // java.lang.Runnable
        public void run() {
            s1<V> s1Var = this.f13482n;
            if (s1Var != null) {
                D(s1Var);
            }
        }

        @Override // q1.f
        @gm.a
        public String y() {
            s1<V> s1Var = this.f13482n;
            if (s1Var == null) {
                return null;
            }
            return "delegate=[" + s1Var + "]";
        }
    }

    @SafeVarargs
    public static <V> s1<List<V>> A(s1<? extends V>... futures) {
        return new k0.a(f1.i3.copyOf(futures), false);
    }

    public static <I, O> s1<O> B(s1<I> input, c1.t<? super I, ? extends O> function, Executor executor) {
        return r.N(input, function, executor);
    }

    public static <I, O> s1<O> C(s1<I> input, x<? super I, ? extends O> function, Executor executor) {
        return r.O(input, function, executor);
    }

    public static <V> c<V> D(Iterable<? extends s1<? extends V>> futures) {
        return new c<>(false, f1.i3.copyOf(futures));
    }

    @SafeVarargs
    public static <V> c<V> E(s1<? extends V>... futures) {
        return new c<>(false, f1.i3.copyOf(futures));
    }

    public static <V> c<V> F(Iterable<? extends s1<? extends V>> futures) {
        return new c<>(true, f1.i3.copyOf(futures));
    }

    @SafeVarargs
    public static <V> c<V> G(s1<? extends V>... futures) {
        return new c<>(true, f1.i3.copyOf(futures));
    }

    @b1.c
    @b1.d
    public static <V> s1<V> H(s1<V> delegate, long time, TimeUnit unit, ScheduledExecutorService scheduledExecutor) {
        return delegate.isDone() ? delegate : z2.Q(delegate, time, unit, scheduledExecutor);
    }

    public static void I(Throwable cause) {
        if (!(cause instanceof Error)) {
            throw new c3(cause);
        }
        throw new p0((Error) cause);
    }

    public static <V> void c(final s1<V> future, final e1<? super V> callback, Executor executor) {
        callback.getClass();
        future.addListener(new b(future, callback), executor);
    }

    public static <V> s1<List<V>> d(Iterable<? extends s1<? extends V>> futures) {
        return new k0.a(f1.i3.copyOf(futures), true);
    }

    @SafeVarargs
    public static <V> s1<List<V>> e(s1<? extends V>... futures) {
        return new k0.a(f1.i3.copyOf(futures), true);
    }

    @d2.a("AVAILABLE but requires exceptionType to be Throwable.class")
    @b1.d
    public static <V, X extends Throwable> s1<V> f(s1<? extends V> input, Class<X> exceptionType, c1.t<? super X, ? extends V> fallback, Executor executor) {
        return q1.a.N(input, exceptionType, fallback, executor);
    }

    @d2.a("AVAILABLE but requires exceptionType to be Throwable.class")
    @b1.d
    public static <V, X extends Throwable> s1<V> g(s1<? extends V> input, Class<X> exceptionType, x<? super X, ? extends V> fallback, Executor executor) {
        return q1.a.O(input, exceptionType, fallback, executor);
    }

    @b1.c
    @t1.a
    @b1.d
    @c2
    public static <V, X extends Exception> V h(Future<V> future, Class<X> cls) throws Exception {
        return (V) l1.f(future, cls);
    }

    @b1.c
    @t1.a
    @b1.d
    @c2
    public static <V, X extends Exception> V i(Future<V> future, Class<X> cls, long j10, TimeUnit timeUnit) throws Exception {
        return (V) l1.g(future, cls, j10, timeUnit);
    }

    @t1.a
    @c2
    public static <V> V j(Future<V> future) throws ExecutionException {
        c1.h0.x0(future.isDone(), "Future was expected to be done: %s", future);
        return (V) e3.f(future);
    }

    @t1.a
    @c2
    public static <V> V k(Future<V> future) {
        future.getClass();
        try {
            return (V) e3.f(future);
        } catch (ExecutionException e10) {
            I(e10.getCause());
            throw new AssertionError();
        }
    }

    public static <T> s1<? extends T>[] l(Iterable<? extends s1<? extends T>> futures) {
        return (s1[]) (futures instanceof Collection ? (Collection) futures : f1.i3.copyOf(futures)).toArray(new s1[0]);
    }

    public static <V> s1<V> m() {
        o1.a<Object> aVar = o1.a.f13643n;
        return aVar != null ? aVar : new o1.a();
    }

    public static <V> s1<V> n(Throwable throwable) {
        throwable.getClass();
        return new o1.b(throwable);
    }

    public static <V> s1<V> o(@c2 V v10) {
        return v10 == null ? (s1<V>) o1.f13640b : new o1(v10);
    }

    public static s1<Void> p() {
        return o1.f13640b;
    }

    public static <T> f1.i3<s1<T>> q(Iterable<? extends s1<? extends T>> futures) {
        s1[] s1VarArrL = l(futures);
        final e eVar = new e(s1VarArrL);
        f1.i3.a aVarBuilderWithExpectedSize = f1.i3.builderWithExpectedSize(s1VarArrL.length);
        for (int i10 = 0; i10 < s1VarArrL.length; i10++) {
            aVarBuilderWithExpectedSize.j(new d(eVar));
        }
        final f1.i3<s1<T>> i3VarE = aVarBuilderWithExpectedSize.e();
        for (final int i11 = 0; i11 < s1VarArrL.length; i11++) {
            s1VarArrL[i11].addListener(new Runnable() { // from class: q1.f1
                @Override // java.lang.Runnable
                public final void run() {
                    eVar.f(i3VarE, i11);
                }
            }, n0.INSTANCE);
        }
        return i3VarE;
    }

    @b1.c
    @b1.d
    public static <I, O> Future<O> t(final Future<I> input, final c1.t<? super I, ? extends O> function) {
        input.getClass();
        function.getClass();
        return new a(input, function);
    }

    public static <V> s1<V> u(s1<V> future) {
        if (future.isDone()) {
            return future;
        }
        f fVar = new f(future);
        future.addListener(fVar, n0.INSTANCE);
        return fVar;
    }

    @b1.c
    @b1.d
    public static <O> s1<O> v(w<O> callable, long delay, TimeUnit timeUnit, ScheduledExecutorService executorService) {
        a3 a3VarP = a3.P(callable);
        final ScheduledFuture<?> scheduledFutureSchedule = executorService.schedule(a3VarP, delay, timeUnit);
        a3VarP.addListener(new Runnable() { // from class: q1.g1
            @Override // java.lang.Runnable
            public final void run() {
                scheduledFutureSchedule.cancel(false);
            }
        }, n0.INSTANCE);
        return a3VarP;
    }

    public static s1<Void> w(Runnable runnable, Executor executor) {
        a3 a3VarN = a3.N(runnable, null);
        executor.execute(a3VarN);
        return a3VarN;
    }

    public static <O> s1<O> x(Callable<O> callable, Executor executor) {
        a3 a3VarO = a3.O(callable);
        executor.execute(a3VarO);
        return a3VarO;
    }

    public static <O> s1<O> y(w<O> callable, Executor executor) {
        a3 a3VarP = a3.P(callable);
        executor.execute(a3VarP);
        return a3VarP;
    }

    public static <V> s1<List<V>> z(Iterable<? extends s1<? extends V>> futures) {
        return new k0.a(f1.i3.copyOf(futures), false);
    }

    public static final class d<T> extends q1.f<T> {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @gm.a
        public e<T> f13476n;

        public d(e<T> state) {
            this.f13476n = state;
        }

        @Override // q1.f, java.util.concurrent.Future
        public boolean cancel(boolean interruptIfRunning) {
            e<T> eVar = this.f13476n;
            if (!super.cancel(interruptIfRunning)) {
                return false;
            }
            Objects.requireNonNull(eVar);
            eVar.g(interruptIfRunning);
            return true;
        }

        @Override // q1.f
        public void m() {
            this.f13476n = null;
        }

        @Override // q1.f
        @gm.a
        public String y() {
            e<T> eVar = this.f13476n;
            if (eVar == null) {
                return null;
            }
            return "inputCount=[" + eVar.f13480d.length + "], remaining=[" + eVar.f13479c.get() + "]";
        }

        public /* synthetic */ d(e eVar, a aVar) {
            this(eVar);
        }
    }
}
