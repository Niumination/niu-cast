package nq;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class y1 extends x1 implements c1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @os.l
    public final Executor f11994b;

    public y1(@os.l Executor executor) {
        this.f11994b = executor;
        vq.e.c(executor);
    }

    @Override // nq.c1
    @os.l
    public n1 E(long j10, @os.l Runnable runnable, @os.l um.g gVar) {
        Executor executor = this.f11994b;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        ScheduledFuture<?> scheduledFutureP0 = scheduledExecutorService != null ? p0(scheduledExecutorService, runnable, gVar, j10) : null;
        return scheduledFutureP0 != null ? new m1(scheduledFutureP0) : y0.f11985g.r2(j10, runnable);
    }

    @Override // nq.c1
    public void b0(long j10, @os.l p<? super lm.l2> pVar) {
        Executor executor = this.f11994b;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        ScheduledFuture<?> scheduledFutureP0 = scheduledExecutorService != null ? p0(scheduledExecutorService, new g3(this, pVar), pVar.getContext(), j10) : null;
        if (scheduledFutureP0 != null) {
            q2.a(pVar, scheduledFutureP0);
        } else {
            y0.f11985g.b0(j10, pVar);
        }
    }

    @Override // nq.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor executor = this.f11994b;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // nq.n0
    public void dispatch(@os.l um.g gVar, @os.l Runnable runnable) {
        Runnable runnableI;
        try {
            Executor executor = this.f11994b;
            b bVarB = c.b();
            if (bVarB == null || (runnableI = bVarB.i(runnable)) == null) {
                runnableI = runnable;
            }
            executor.execute(runnableI);
        } catch (RejectedExecutionException e10) {
            b bVarB2 = c.b();
            if (bVarB2 != null) {
                bVarB2.f();
            }
            j0(gVar, e10);
            k1.c().dispatch(gVar, runnable);
        }
    }

    public boolean equals(@os.m Object obj) {
        return (obj instanceof y1) && ((y1) obj).f11994b == this.f11994b;
    }

    @Override // nq.x1
    @os.l
    public Executor f0() {
        return this.f11994b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f11994b);
    }

    public final void j0(um.g gVar, RejectedExecutionException rejectedExecutionException) {
        r2.g(gVar, w1.a("The task was rejected", rejectedExecutionException));
    }

    @Override // nq.c1
    @os.m
    @lm.k(level = lm.m.ERROR, message = "Deprecated without replacement as an internal method never intended for public use")
    public Object n(long j10, @os.l um.d<? super lm.l2> dVar) {
        return c1.a.a(this, j10, dVar);
    }

    public final ScheduledFuture<?> p0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, um.g gVar, long j10) {
        try {
            return scheduledExecutorService.schedule(runnable, j10, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e10) {
            j0(gVar, e10);
            return null;
        }
    }

    @Override // nq.n0
    @os.l
    public String toString() {
        return this.f11994b.toString();
    }
}
