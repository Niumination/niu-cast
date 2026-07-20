package af;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z4 f528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o2 f529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f530d;
    public p2 e;
    public ScheduledFuture f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f531g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final r2 f532h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final r2 f533i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f534j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f535k;

    static {
        TimeUnit.SECONDS.toNanos(10L);
        TimeUnit.MILLISECONDS.toNanos(10L);
    }

    public q2(o2 o2Var, ScheduledExecutorService scheduledExecutorService, long j8, long j10, boolean z2) {
        z4 z4Var = new z4(1);
        this.e = p2.IDLE;
        this.f532h = new r2(new m2(this, 0));
        this.f533i = new r2(new m2(this, 1));
        this.f529c = o2Var;
        v8.i(scheduledExecutorService, "scheduler");
        this.f527a = scheduledExecutorService;
        this.f528b = z4Var;
        this.f534j = j8;
        this.f535k = j10;
        this.f530d = z2;
        z4Var.f750b = false;
        z4Var.b();
    }

    public final synchronized void a() {
        try {
            z4 z4Var = this.f528b;
            z4Var.f750b = false;
            z4Var.b();
            p2 p2Var = this.e;
            p2 p2Var2 = p2.PING_SCHEDULED;
            if (p2Var == p2Var2) {
                this.e = p2.PING_DELAYED;
            } else if (p2Var == p2.PING_SENT || p2Var == p2.IDLE_AND_PING_SENT) {
                ScheduledFuture scheduledFuture = this.f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.e == p2.IDLE_AND_PING_SENT) {
                    this.e = p2.IDLE;
                } else {
                    this.e = p2Var2;
                    v8.n(this.f531g == null, "There should be no outstanding pingFuture");
                    this.f531g = this.f527a.schedule(this.f533i, this.f534j, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void b() {
        try {
            p2 p2Var = this.e;
            if (p2Var == p2.IDLE) {
                this.e = p2.PING_SCHEDULED;
                if (this.f531g == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f527a;
                    r2 r2Var = this.f533i;
                    long j8 = this.f534j;
                    z4 z4Var = this.f528b;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.f531g = scheduledExecutorService.schedule(r2Var, j8 - z4Var.a(timeUnit), timeUnit);
                }
            } else if (p2Var == p2.IDLE_AND_PING_SENT) {
                this.e = p2.PING_SENT;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void c() {
        try {
            p2 p2Var = this.e;
            p2 p2Var2 = p2.DISCONNECTED;
            if (p2Var != p2Var2) {
                this.e = p2Var2;
                ScheduledFuture scheduledFuture = this.f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture scheduledFuture2 = this.f531g;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f531g = null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
