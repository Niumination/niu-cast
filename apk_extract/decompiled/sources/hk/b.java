package hk;

import ik.u;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f5479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentLinkedQueue f5481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qk.b f5482d;
    public final ScheduledExecutorService e;
    public final ScheduledFuture f;

    public b(u uVar, long j8, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool;
        ScheduledFuture<?> scheduledFutureScheduleWithFixedDelay;
        this.f5479a = uVar;
        long nanos = timeUnit != null ? timeUnit.toNanos(j8) : 0L;
        this.f5480b = nanos;
        this.f5481c = new ConcurrentLinkedQueue();
        this.f5482d = new qk.b();
        if (timeUnit != null) {
            scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, new a(uVar));
            m.e(scheduledExecutorServiceNewScheduledThreadPool);
            scheduledFutureScheduleWithFixedDelay = scheduledExecutorServiceNewScheduledThreadPool.scheduleWithFixedDelay(new af.f(this, 22), nanos, nanos, TimeUnit.NANOSECONDS);
        } else {
            scheduledExecutorServiceNewScheduledThreadPool = null;
            scheduledFutureScheduleWithFixedDelay = null;
        }
        this.e = scheduledExecutorServiceNewScheduledThreadPool;
        this.f = scheduledFutureScheduleWithFixedDelay;
    }

    public final void a() {
        qk.b bVar = this.f5482d;
        try {
            ScheduledFuture scheduledFuture = this.f;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.e;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        } finally {
            bVar.unsubscribe();
        }
    }
}
