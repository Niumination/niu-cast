package vj;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@hm.d
public final class c3 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Thread.UncaughtExceptionHandler f17064a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Queue<Runnable> f17065b = new ConcurrentLinkedQueue();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference<Thread> f17066c = new AtomicReference<>();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f17068b;

        public a(c cVar, Runnable runnable) {
            this.f17067a = cVar;
            this.f17068b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            c3.this.execute(this.f17067a);
        }

        public String toString() {
            return this.f17068b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f17070a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f17071b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f17072c;

        public b(c cVar, Runnable runnable, long j10) {
            this.f17070a = cVar;
            this.f17071b = runnable;
            this.f17072c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            c3.this.execute(this.f17070a);
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f17071b.toString());
            sb2.append("(scheduled in SynchronizationContext with delay of ");
            return k.d.a(sb2, this.f17072c, ")");
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f17074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17076c;

        public c(Runnable runnable) {
            this.f17074a = (Runnable) c1.h0.F(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f17075b) {
                return;
            }
            this.f17076c = true;
            this.f17074a.run();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f17077a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ScheduledFuture<?> f17078b;

        public /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f17077a.f17075b = true;
            this.f17078b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f17077a;
            return (cVar.f17076c || cVar.f17075b) ? false : true;
        }

        public d(c cVar, ScheduledFuture<?> scheduledFuture) {
            this.f17077a = (c) c1.h0.F(cVar, "runnable");
            this.f17078b = (ScheduledFuture) c1.h0.F(scheduledFuture, "future");
        }
    }

    public c3(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f17064a = (Thread.UncaughtExceptionHandler) c1.h0.F(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (g0.e.a(this.f17066c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable runnablePoll = this.f17065b.poll();
                    if (runnablePoll == null) {
                        break;
                    }
                    try {
                        runnablePoll.run();
                    } catch (Throwable th2) {
                        this.f17064a.uncaughtException(Thread.currentThread(), th2);
                    }
                } catch (Throwable th3) {
                    this.f17066c.set(null);
                    throw th3;
                }
            }
            this.f17066c.set(null);
            if (this.f17065b.isEmpty()) {
                return;
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f17065b.add((Runnable) c1.h0.F(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j10, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j10, timeUnit));
    }

    public final d d(Runnable runnable, long j10, long j11, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j11), j10, j11, timeUnit));
    }

    public void e() {
        c1.h0.h0(Thread.currentThread() == this.f17066c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
