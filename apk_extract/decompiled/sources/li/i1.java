package li;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: classes3.dex */
public final class i1 extends h1 implements q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f7458a;

    public i1(Executor executor) {
        this.f7458a = executor;
        if (executor instanceof ScheduledThreadPoolExecutor) {
            ((ScheduledThreadPoolExecutor) executor).setRemoveOnCancelPolicy(true);
        }
    }

    @Override // li.q0
    public final void c(long j8, l lVar) {
        Executor executor = this.f7458a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(new i2.e(1, this, lVar), j8, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationExceptionA = l0.a("The task was rejected", e);
                p1 p1Var = (p1) lVar.e.get(o1.f7483a);
                if (p1Var != null) {
                    p1Var.h(cancellationExceptionA);
                }
            }
        }
        if (scheduledFutureSchedule != null) {
            lVar.w(new h(scheduledFutureSchedule, 0));
        } else {
            m0.f7477j.c(j8, lVar);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Executor executor = this.f7458a;
        ExecutorService executorService = executor instanceof ExecutorService ? (ExecutorService) executor : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override // li.a0
    public final void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        try {
            this.f7458a.execute(runnable);
        } catch (RejectedExecutionException e) {
            CancellationException cancellationExceptionA = l0.a("The task was rejected", e);
            p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
            if (p1Var != null) {
                p1Var.h(cancellationExceptionA);
            }
            v0 v0Var = v0.f7498a;
            si.e.f10118a.dispatch(coroutineContext, runnable);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i1) && ((i1) obj).f7458a == this.f7458a;
    }

    @Override // li.q0
    public final x0 g(long j8, Runnable runnable, CoroutineContext coroutineContext) {
        Executor executor = this.f7458a;
        ScheduledFuture<?> scheduledFutureSchedule = null;
        ScheduledExecutorService scheduledExecutorService = executor instanceof ScheduledExecutorService ? (ScheduledExecutorService) executor : null;
        if (scheduledExecutorService != null) {
            try {
                scheduledFutureSchedule = scheduledExecutorService.schedule(runnable, j8, TimeUnit.MILLISECONDS);
            } catch (RejectedExecutionException e) {
                CancellationException cancellationExceptionA = l0.a("The task was rejected", e);
                p1 p1Var = (p1) coroutineContext.get(o1.f7483a);
                if (p1Var != null) {
                    p1Var.h(cancellationExceptionA);
                }
            }
        }
        return scheduledFutureSchedule != null ? new w0(scheduledFutureSchedule) : m0.f7477j.g(j8, runnable, coroutineContext);
    }

    public final int hashCode() {
        return System.identityHashCode(this.f7458a);
    }

    @Override // li.a0
    public final String toString() {
        return this.f7458a.toString();
    }
}
