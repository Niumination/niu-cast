package wj;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f18791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Runnable f18792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c1.o0 f18793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f18794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f18795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture<?> f18796g;

    public final class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l2 l2Var = l2.this;
            if (!l2Var.f18795f) {
                l2Var.f18796g = null;
                return;
            }
            long jK = l2Var.k();
            l2 l2Var2 = l2.this;
            if (l2Var2.f18794e - jK > 0) {
                l2Var2.f18796g = l2Var2.f18790a.schedule(l2Var2.new c(), l2.this.f18794e - jK, TimeUnit.NANOSECONDS);
                return;
            }
            l2Var2.f18795f = false;
            l2Var2.f18796g = null;
            l2Var2.f18792c.run();
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        public static boolean a(c cVar) {
            return l2.this.f18795f;
        }

        public final boolean b() {
            return l2.this.f18795f;
        }

        @Override // java.lang.Runnable
        public void run() {
            l2 l2Var = l2.this;
            l2Var.f18791b.execute(l2Var.new b());
        }
    }

    public l2(Runnable runnable, Executor executor, ScheduledExecutorService scheduledExecutorService, c1.o0 o0Var) {
        this.f18792c = runnable;
        this.f18791b = executor;
        this.f18790a = scheduledExecutorService;
        this.f18793d = o0Var;
        o0Var.k();
    }

    @b1.e
    public static boolean j(Runnable runnable) {
        return l2.this.f18795f;
    }

    public void i(boolean z10) {
        ScheduledFuture<?> scheduledFuture;
        this.f18795f = false;
        if (!z10 || (scheduledFuture = this.f18796g) == null) {
            return;
        }
        scheduledFuture.cancel(false);
        this.f18796g = null;
    }

    public final long k() {
        return this.f18793d.g(TimeUnit.NANOSECONDS);
    }

    public void l(long j10, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j10);
        long jK = k() + nanos;
        this.f18795f = true;
        if (jK - this.f18794e < 0 || this.f18796g == null) {
            ScheduledFuture<?> scheduledFuture = this.f18796g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.f18796g = this.f18790a.schedule(new c(), nanos, TimeUnit.NANOSECONDS);
        }
        this.f18794e = jK;
    }
}
