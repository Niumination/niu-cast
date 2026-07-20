package q1;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
@b1.c
@o0
@b1.d
public abstract class m implements i2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Logger f13592b = Logger.getLogger(m.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f13593a = new g();

    public class a extends i2.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledExecutorService f13594a;

        public a(final m this$0, final ScheduledExecutorService val$executor) {
            this.f13594a = val$executor;
        }

        @Override // q1.i2.a
        public void a(i2.b from, Throwable failure) {
            this.f13594a.shutdown();
        }

        @Override // q1.i2.a
        public void e(i2.b from) {
            this.f13594a.shutdown();
        }
    }

    public class b implements ThreadFactory {
        public b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return z1.n(m.this.n(), runnable);
        }
    }

    public interface c {
        void cancel(boolean mayInterruptIfRunning);

        boolean isCancelled();
    }

    public static abstract class d extends f {

        public final class a implements Callable<Void> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Runnable f13596a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ScheduledExecutorService f13597b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final q f13598c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final ReentrantLock f13599d = new ReentrantLock();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            @gm.a
            @u1.a("lock")
            public c f13600e;

            public a(q service, ScheduledExecutorService executor, Runnable runnable) {
                this.f13596a = runnable;
                this.f13597b = executor;
                this.f13598c = service;
            }

            @Override // java.util.concurrent.Callable
            @gm.a
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Void call() throws Exception {
                this.f13596a.run();
                c();
                return null;
            }

            @u1.a("lock")
            public final c b(b schedule) {
                c cVar = this.f13600e;
                if (cVar == null) {
                    c cVar2 = new c(this.f13599d, d(schedule));
                    this.f13600e = cVar2;
                    return cVar2;
                }
                if (!cVar.f13605b.isCancelled()) {
                    this.f13600e.f13605b = d(schedule);
                }
                return this.f13600e;
            }

            @t1.a
            public c c() {
                Throwable th2;
                c eVar;
                try {
                    b bVarD = d.this.d();
                    this.f13599d.lock();
                    try {
                        try {
                            eVar = b(bVarD);
                            this.f13599d.unlock();
                            th2 = null;
                        } catch (Throwable th3) {
                            this.f13599d.unlock();
                            throw th3;
                        }
                    } catch (Error | RuntimeException e10) {
                        th2 = e10;
                        eVar = new e(h1.m());
                        this.f13599d.unlock();
                    }
                    if (th2 != null) {
                        this.f13598c.t(th2);
                    }
                    return eVar;
                } catch (Throwable th4) {
                    e2.b(th4);
                    this.f13598c.t(th4);
                    return new e(h1.m());
                }
            }

            public final ScheduledFuture<Void> d(b schedule) {
                return this.f13597b.schedule(this, schedule.f13602a, schedule.f13603b);
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final long f13602a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final TimeUnit f13603b;

            public b(long delay, TimeUnit unit) {
                this.f13602a = delay;
                unit.getClass();
                this.f13603b = unit;
            }
        }

        public static final class c implements c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ReentrantLock f13604a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            @u1.a("lock")
            public Future<Void> f13605b;

            public c(ReentrantLock lock, Future<Void> currentFuture) {
                this.f13604a = lock;
                this.f13605b = currentFuture;
            }

            @Override // q1.m.c
            public void cancel(boolean mayInterruptIfRunning) {
                this.f13604a.lock();
                try {
                    this.f13605b.cancel(mayInterruptIfRunning);
                } finally {
                    this.f13604a.unlock();
                }
            }

            @Override // q1.m.c
            public boolean isCancelled() {
                this.f13604a.lock();
                try {
                    return this.f13605b.isCancelled();
                } finally {
                    this.f13604a.unlock();
                }
            }
        }

        @Override // q1.m.f
        public final c c(q service, ScheduledExecutorService executor, Runnable runnable) {
            return new a(service, executor, runnable).c();
        }

        public abstract b d() throws Exception;
    }

    public static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<?> f13606a;

        public e(Future<?> delegate) {
            this.f13606a = delegate;
        }

        @Override // q1.m.c
        public void cancel(boolean mayInterruptIfRunning) {
            this.f13606a.cancel(mayInterruptIfRunning);
        }

        @Override // q1.m.c
        public boolean isCancelled() {
            return this.f13606a.isCancelled();
        }
    }

    public static abstract class f {

        public class a extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f13607a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f13608b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TimeUnit f13609c;

            public a(final long val$initialDelay, final long val$delay, final TimeUnit val$unit) {
                this.f13607a = val$initialDelay;
                this.f13608b = val$delay;
                this.f13609c = val$unit;
            }

            @Override // q1.m.f
            public c c(q service, ScheduledExecutorService executor, Runnable task) {
                return new e(executor.scheduleWithFixedDelay(task, this.f13607a, this.f13608b, this.f13609c));
            }
        }

        public class b extends f {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f13610a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ long f13611b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ TimeUnit f13612c;

            public b(final long val$initialDelay, final long val$period, final TimeUnit val$unit) {
                this.f13610a = val$initialDelay;
                this.f13611b = val$period;
                this.f13612c = val$unit;
            }

            @Override // q1.m.f
            public c c(q service, ScheduledExecutorService executor, Runnable task) {
                return new e(executor.scheduleAtFixedRate(task, this.f13610a, this.f13611b, this.f13612c));
            }
        }

        public f() {
        }

        public static f a(final long initialDelay, final long delay, final TimeUnit unit) {
            unit.getClass();
            c1.h0.p(delay > 0, "delay must be > 0, found %s", delay);
            return new a(initialDelay, delay, unit);
        }

        public static f b(final long initialDelay, final long period, final TimeUnit unit) {
            unit.getClass();
            c1.h0.p(period > 0, "period must be > 0, found %s", period);
            return new b(initialDelay, period, unit);
        }

        public abstract c c(q service, ScheduledExecutorService executor, Runnable runnable);

        public f(a aVar) {
        }
    }

    @Override // q1.i2
    public final void a(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13593a.a(timeout, unit);
    }

    @Override // q1.i2
    public final void b(long timeout, TimeUnit unit) throws TimeoutException {
        this.f13593a.b(timeout, unit);
    }

    @Override // q1.i2
    public final void c() {
        this.f13593a.c();
    }

    @Override // q1.i2
    @t1.a
    public final i2 d() {
        this.f13593a.d();
        return this;
    }

    @Override // q1.i2
    public final void e(i2.a listener, Executor executor) {
        this.f13593a.e(listener, executor);
    }

    @Override // q1.i2
    public final void f() {
        this.f13593a.f();
    }

    @Override // q1.i2
    public final Throwable g() {
        return this.f13593a.f13671g.b();
    }

    @Override // q1.i2
    @t1.a
    public final i2 h() {
        this.f13593a.h();
        return this;
    }

    @Override // q1.i2
    public final boolean isRunning() {
        return this.f13593a.isRunning();
    }

    public ScheduledExecutorService k() {
        ScheduledExecutorService scheduledExecutorServiceNewSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor(new b());
        e(new a(this, scheduledExecutorServiceNewSingleThreadScheduledExecutor), n0.INSTANCE);
        return scheduledExecutorServiceNewSingleThreadScheduledExecutor;
    }

    public abstract void l() throws Exception;

    public abstract f m();

    public String n() {
        return getClass().getSimpleName();
    }

    public void o() throws Exception {
    }

    public void p() throws Exception {
    }

    @Override // q1.i2
    public final i2.b state() {
        return this.f13593a.f13671g.a();
    }

    public String toString() {
        return n() + " [" + state() + "]";
    }

    public final class g extends q {

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        @gm.a
        public volatile c f13613p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        @gm.a
        public volatile ScheduledExecutorService f13614q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public final ReentrantLock f13615r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public final Runnable f13616s;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g gVar;
                g.this.f13615r.lock();
                try {
                    c cVar = g.this.f13613p;
                    Objects.requireNonNull(cVar);
                    if (cVar.isCancelled()) {
                        g.this.f13615r.unlock();
                        return;
                    } else {
                        m.this.l();
                        gVar = g.this;
                    }
                } catch (Throwable th2) {
                    try {
                        e2.b(th2);
                        try {
                            m.this.o();
                        } catch (Exception e10) {
                            e2.b(e10);
                            m.f13592b.log(Level.WARNING, "Error while attempting to shut down the service after failure.", (Throwable) e10);
                        }
                        g.this.t(th2);
                        c cVar2 = g.this.f13613p;
                        Objects.requireNonNull(cVar2);
                        cVar2.cancel(false);
                        gVar = g.this;
                    } catch (Throwable th3) {
                        g.this.f13615r.unlock();
                        throw th3;
                    }
                }
                gVar.f13615r.unlock();
            }
        }

        public g() {
            this.f13615r = new ReentrantLock();
            this.f13616s = new a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String D() {
            return m.this.n() + " " + this.f13671g.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void E() {
            this.f13615r.lock();
            try {
                m.this.p();
                Objects.requireNonNull(this.f13614q);
                this.f13613p = m.this.m().c(m.this.f13593a, this.f13614q, this.f13616s);
                u();
            } catch (Throwable th2) {
                try {
                    e2.b(th2);
                    t(th2);
                    if (this.f13613p != null) {
                        this.f13613p.cancel(false);
                    }
                } finally {
                    this.f13615r.unlock();
                }
            }
        }

        public final void F() {
            try {
                this.f13615r.lock();
                try {
                    if (this.f13671g.a() != i2.b.STOPPING) {
                        this.f13615r.unlock();
                        return;
                    }
                    m.this.o();
                    this.f13615r.unlock();
                    v();
                } catch (Throwable th2) {
                    this.f13615r.unlock();
                    throw th2;
                }
            } catch (Throwable th3) {
                e2.b(th3);
                t(th3);
            }
        }

        @Override // q1.q
        public final void m() {
            this.f13614q = z1.s(m.this.k(), new c1.q0() { // from class: q1.n
                @Override // c1.q0
                public final Object get() {
                    return this.f13631a.D();
                }
            });
            this.f13614q.execute(new Runnable() { // from class: q1.o
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13639a.E();
                }
            });
        }

        @Override // q1.q
        public final void n() {
            Objects.requireNonNull(this.f13613p);
            Objects.requireNonNull(this.f13614q);
            this.f13613p.cancel(false);
            this.f13614q.execute(new Runnable() { // from class: q1.p
                @Override // java.lang.Runnable
                public final void run() {
                    this.f13653a.F();
                }
            });
        }

        @Override // q1.q
        public String toString() {
            return m.this.toString();
        }

        public /* synthetic */ g(m mVar, a aVar) {
            this();
        }
    }
}
