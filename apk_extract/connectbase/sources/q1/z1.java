package q1;

import f1.p4;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: classes.dex */
@b1.b(emulated = true)
@o0
public final class z1 {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BlockingQueue f13776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s1 f13777b;

        public a(final BlockingQueue val$queue, final s1 val$future) {
            this.f13776a = val$queue;
            this.f13777b = val$future;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13776a.add(this.f13777b);
        }
    }

    public class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f13778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.q0 f13779b;

        public b(final Executor val$executor, final c1.q0 val$nameSupplier) {
            this.f13778a = val$executor;
            this.f13779b = val$nameSupplier;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            this.f13778a.execute(g0.k(command, this.f13779b));
        }
    }

    public class c extends g3 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c1.q0 f13780b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ExecutorService delegate, final c1.q0 val$nameSupplier) {
            super(delegate);
            this.f13780b = val$nameSupplier;
        }

        @Override // q1.g3
        public Runnable c(Runnable command) {
            return g0.k(command, this.f13780b);
        }

        @Override // q1.g3
        public <T> Callable<T> d(Callable<T> callable) {
            return g0.l(callable, this.f13780b);
        }
    }

    public class d extends h3 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c1.q0 f13781c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ScheduledExecutorService delegate, final c1.q0 val$nameSupplier) {
            super(delegate);
            this.f13781c = val$nameSupplier;
        }

        @Override // q1.g3
        public Runnable c(Runnable command) {
            return g0.k(command, this.f13781c);
        }

        @Override // q1.g3
        public <T> Callable<T> d(Callable<T> callable) {
            return g0.l(callable, this.f13781c);
        }
    }

    public class e implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Executor f13782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q1.f f13783b;

        public e(final Executor val$delegate, final q1.f val$future) {
            this.f13782a = val$delegate;
            this.f13783b = val$future;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            try {
                this.f13782a.execute(command);
            } catch (RejectedExecutionException e10) {
                this.f13783b.C(e10);
            }
        }
    }

    @b1.c
    @b1.e
    @b1.d
    public static class f {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ExecutorService f13784a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f13785b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TimeUnit f13786c;

            public a(final f this$0, final ExecutorService val$service, final long val$terminationTimeout, final TimeUnit val$timeUnit) {
                this.f13784a = val$service;
                this.f13785b = val$terminationTimeout;
                this.f13786c = val$timeUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f13784a.shutdown();
                    this.f13784a.awaitTermination(this.f13785b, this.f13786c);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final void a(final ExecutorService service, final long terminationTimeout, final TimeUnit timeUnit) {
            service.getClass();
            timeUnit.getClass();
            b(z1.n("DelayedShutdownHook-for-" + service, new a(this, service, terminationTimeout, timeUnit)));
        }

        @b1.e
        public void b(Thread hook) {
            Runtime.getRuntime().addShutdownHook(hook);
        }

        public final ExecutorService c(ThreadPoolExecutor executor) {
            return d(executor, 120L, TimeUnit.SECONDS);
        }

        public final ExecutorService d(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
            z1.v(executor);
            ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(executor);
            a(executor, terminationTimeout, timeUnit);
            return executorServiceUnconfigurableExecutorService;
        }

        public final ScheduledExecutorService e(ScheduledThreadPoolExecutor executor) {
            return f(executor, 120L, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService f(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
            z1.v(executor);
            ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(executor);
            a(executor, terminationTimeout, timeUnit);
            return scheduledExecutorServiceUnconfigurableScheduledExecutorService;
        }
    }

    @b1.c
    @b1.d
    public static class h extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f13790a;

        public h(ExecutorService delegate) {
            delegate.getClass();
            this.f13790a = delegate;
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            return this.f13790a.awaitTermination(timeout, unit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable command) {
            this.f13790a.execute(command);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f13790a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f13790a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f13790a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f13790a.shutdownNow();
        }

        public final String toString() {
            return super.toString() + "[" + this.f13790a + "]";
        }
    }

    @b1.c
    @b1.d
    public static final class i extends h implements x1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledExecutorService f13791b;

        public static final class a<V> extends b1.a<V> implements u1<V> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ScheduledFuture<?> f13792b;

            public a(s1<V> listenableDelegate, ScheduledFuture<?> scheduledDelegate) {
                super(listenableDelegate);
                this.f13792b = scheduledDelegate;
            }

            @Override // q1.a1, java.util.concurrent.Future
            public boolean cancel(boolean mayInterruptIfRunning) {
                boolean zCancel = super.cancel(mayInterruptIfRunning);
                if (zCancel) {
                    this.f13792b.cancel(mayInterruptIfRunning);
                }
                return zCancel;
            }

            @Override // java.lang.Comparable
            public int compareTo(Delayed other) {
                return this.f13792b.compareTo(other);
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit unit) {
                return this.f13792b.getDelay(unit);
            }

            public int q(Delayed other) {
                return this.f13792b.compareTo(other);
            }
        }

        @b1.c
        @b1.d
        public static final class b extends q1.f.j<Void> implements Runnable {

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final Runnable f13793n;

            public b(Runnable delegate) {
                delegate.getClass();
                this.f13793n = delegate;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f13793n.run();
                } catch (Error | RuntimeException e10) {
                    C(e10);
                    throw e10;
                }
            }

            @Override // q1.f
            public String y() {
                return "task=[" + this.f13793n + "]";
            }
        }

        public i(ScheduledExecutorService delegate) {
            super(delegate);
            delegate.getClass();
            this.f13791b = delegate;
        }

        @Override // q1.x1, java.util.concurrent.ScheduledExecutorService
        public u1<?> scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit) {
            b bVar = new b(command);
            return new a(bVar, this.f13791b.scheduleAtFixedRate(bVar, initialDelay, period, unit));
        }

        @Override // q1.x1, java.util.concurrent.ScheduledExecutorService
        public u1<?> scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit) {
            b bVar = new b(command);
            return new a(bVar, this.f13791b.scheduleWithFixedDelay(bVar, initialDelay, delay, unit));
        }

        @Override // q1.x1, java.util.concurrent.ScheduledExecutorService
        public u1<?> schedule(Runnable command, long delay, TimeUnit unit) {
            a3 a3VarN = a3.N(command, null);
            return new a(a3VarN, this.f13791b.schedule(a3VarN, delay, unit));
        }

        @Override // q1.x1, java.util.concurrent.ScheduledExecutorService
        public <V> u1<V> schedule(Callable<V> callable, long delay, TimeUnit unit) {
            a3 a3VarO = a3.O(callable);
            return new a(a3VarO, this.f13791b.schedule(a3VarO, delay, unit));
        }
    }

    @b1.c
    @b1.d
    public static void b(ExecutorService service, long terminationTimeout, TimeUnit timeUnit) {
        new f().a(service, terminationTimeout, timeUnit);
    }

    public static Executor c() {
        return n0.INSTANCE;
    }

    @b1.c
    @b1.d
    public static ExecutorService d(ThreadPoolExecutor executor) {
        return new f().c(executor);
    }

    @b1.c
    @b1.d
    public static ExecutorService e(ThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
        return new f().d(executor, terminationTimeout, timeUnit);
    }

    @b1.c
    @b1.d
    public static ScheduledExecutorService f(ScheduledThreadPoolExecutor executor) {
        return new f().e(executor);
    }

    @b1.c
    @b1.d
    public static ScheduledExecutorService g(ScheduledThreadPoolExecutor executor, long terminationTimeout, TimeUnit timeUnit) {
        return new f().f(executor, terminationTimeout, timeUnit);
    }

    @b1.c
    @b1.d
    @c2
    public static <T> T h(w1 w1Var, Collection<? extends Callable<T>> collection, boolean z10, long j10, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long jNanoTime;
        long jNanoTime2;
        w1Var.getClass();
        timeUnit.getClass();
        int size = collection.size();
        c1.h0.d(size > 0);
        ArrayList arrayListU = p4.u(size);
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        long nanos = timeUnit.toNanos(j10);
        if (z10) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th2) {
                Iterator it = arrayListU.iterator();
                while (it.hasNext()) {
                    ((Future) it.next()).cancel(true);
                }
                throw th2;
            }
        } else {
            jNanoTime = 0;
        }
        Iterator<? extends Callable<T>> it2 = collection.iterator();
        arrayListU.add(u(w1Var, it2.next(), linkedBlockingQueue));
        int i10 = size - 1;
        int i11 = 1;
        ExecutionException executionException = null;
        while (true) {
            Future future = (Future) linkedBlockingQueue.poll();
            if (future != null) {
                jNanoTime2 = jNanoTime;
            } else {
                if (i10 > 0) {
                    i10--;
                    arrayListU.add(u(w1Var, it2.next(), linkedBlockingQueue));
                    i11++;
                } else {
                    if (i11 == 0) {
                        if (executionException == null) {
                            throw new ExecutionException((Throwable) null);
                        }
                        throw executionException;
                    }
                    if (z10) {
                        future = (Future) linkedBlockingQueue.poll(nanos, TimeUnit.NANOSECONDS);
                        if (future == null) {
                            throw new TimeoutException();
                        }
                        jNanoTime2 = System.nanoTime();
                        nanos -= jNanoTime2 - jNanoTime;
                    } else {
                        future = (Future) linkedBlockingQueue.take();
                    }
                }
                jNanoTime2 = jNanoTime;
            }
            long j11 = nanos;
            int i12 = i10;
            if (future != null) {
                i11--;
                try {
                    T t10 = (T) future.get();
                    Iterator it3 = arrayListU.iterator();
                    while (it3.hasNext()) {
                        ((Future) it3.next()).cancel(true);
                    }
                    return t10;
                } catch (RuntimeException e10) {
                    executionException = new ExecutionException(e10);
                    i10 = i12;
                    nanos = j11;
                    jNanoTime = jNanoTime2;
                } catch (ExecutionException e11) {
                    executionException = e11;
                    i10 = i12;
                    nanos = j11;
                    jNanoTime = jNanoTime2;
                }
            }
            i10 = i12;
            nanos = j11;
            jNanoTime = jNanoTime2;
        }
    }

    @b1.c
    @b1.d
    public static boolean i() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            Class.forName("com.google.appengine.api.utils.SystemProperty");
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", null).invoke(null, null) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @b1.c
    @b1.d
    public static w1 j(ExecutorService delegate) {
        if (delegate instanceof w1) {
            return (w1) delegate;
        }
        return delegate instanceof ScheduledExecutorService ? new i((ScheduledExecutorService) delegate) : new h(delegate);
    }

    @b1.c
    @b1.d
    public static x1 k(ScheduledExecutorService delegate) {
        return delegate instanceof x1 ? (x1) delegate : new i(delegate);
    }

    @b1.c
    @b1.d
    public static w1 l() {
        return new g();
    }

    @b1.c
    @b1.d
    public static Executor m(Executor delegate) {
        return new h2(delegate);
    }

    @b1.c
    @b1.d
    public static Thread n(String name, Runnable runnable) {
        name.getClass();
        runnable.getClass();
        Thread threadNewThread = o().newThread(runnable);
        Objects.requireNonNull(threadNewThread);
        try {
            threadNewThread.setName(name);
        } catch (SecurityException unused) {
        }
        return threadNewThread;
    }

    @b1.c
    @b1.d
    public static ThreadFactory o() {
        if (!i()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", null).invoke(null, null);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e12);
        } catch (InvocationTargetException e13) {
            throw c1.t0.q(e13.getCause());
        }
    }

    public static Executor p(final Executor delegate, final q1.f<?> future) {
        delegate.getClass();
        future.getClass();
        return delegate == n0.INSTANCE ? delegate : new e(delegate, future);
    }

    @b1.c
    @b1.d
    public static Executor q(final Executor executor, final c1.q0<String> nameSupplier) {
        executor.getClass();
        nameSupplier.getClass();
        return new b(executor, nameSupplier);
    }

    @b1.c
    @b1.d
    public static ExecutorService r(final ExecutorService service, final c1.q0<String> nameSupplier) {
        service.getClass();
        nameSupplier.getClass();
        return new c(service, nameSupplier);
    }

    @b1.c
    @b1.d
    public static ScheduledExecutorService s(final ScheduledExecutorService service, final c1.q0<String> nameSupplier) {
        service.getClass();
        nameSupplier.getClass();
        return new d(service, nameSupplier);
    }

    @b1.c
    @t1.a
    @b1.d
    public static boolean t(ExecutorService service, long timeout, TimeUnit unit) {
        long nanos = unit.toNanos(timeout) / 2;
        service.shutdown();
        try {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (!service.awaitTermination(nanos, timeUnit)) {
                service.shutdownNow();
                service.awaitTermination(nanos, timeUnit);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            service.shutdownNow();
        }
        return service.isTerminated();
    }

    @b1.c
    @b1.d
    public static <T> s1<T> u(w1 executorService, Callable<T> task, final BlockingQueue<Future<T>> queue) {
        s1<T> s1VarSubmit = executorService.submit((Callable) task);
        s1VarSubmit.addListener(new a(queue, s1VarSubmit), n0.INSTANCE);
        return s1VarSubmit;
    }

    @b1.c
    @b1.d
    public static void v(ThreadPoolExecutor executor) {
        x2 x2Var = new x2();
        x2Var.f13756b = Boolean.TRUE;
        ThreadFactory threadFactory = executor.getThreadFactory();
        threadFactory.getClass();
        x2Var.f13759e = threadFactory;
        executor.setThreadFactory(x2.c(x2Var));
    }

    @b1.c
    @b1.d
    public static final class g extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f13787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @u1.a("lock")
        public int f13788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @u1.a("lock")
        public boolean f13789c;

        public g() {
            this.f13787a = new Object();
            this.f13788b = 0;
            this.f13789c = false;
        }

        public final void a() {
            synchronized (this.f13787a) {
                try {
                    int i10 = this.f13788b - 1;
                    this.f13788b = i10;
                    if (i10 == 0) {
                        this.f13787a.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
            long nanos = unit.toNanos(timeout);
            synchronized (this.f13787a) {
                while (true) {
                    try {
                        if (this.f13789c && this.f13788b == 0) {
                            return true;
                        }
                        if (nanos <= 0) {
                            return false;
                        }
                        long jNanoTime = System.nanoTime();
                        TimeUnit.NANOSECONDS.timedWait(this.f13787a, nanos);
                        nanos -= System.nanoTime() - jNanoTime;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }

        public final void b() {
            synchronized (this.f13787a) {
                try {
                    if (this.f13789c) {
                        throw new RejectedExecutionException("Executor already shutdown");
                    }
                    this.f13788b++;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            b();
            try {
                command.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z10;
            synchronized (this.f13787a) {
                z10 = this.f13789c;
            }
            return z10;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z10;
            synchronized (this.f13787a) {
                try {
                    z10 = this.f13789c && this.f13788b == 0;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            return z10;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.f13787a) {
                try {
                    this.f13789c = true;
                    if (this.f13788b == 0) {
                        this.f13787a.notifyAll();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }
}
