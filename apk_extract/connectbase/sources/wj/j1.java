package wj;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class j1 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f18754l = TimeUnit.SECONDS.toNanos(10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f18755m = TimeUnit.MILLISECONDS.toNanos(10);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f18756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hm.a("this")
    public final c1.o0 f18757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f18758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hm.a("this")
    public e f18760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hm.a("this")
    public ScheduledFuture<?> f18761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @hm.a("this")
    public ScheduledFuture<?> f18762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f18763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Runnable f18764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f18765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18766k;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (j1.this) {
                try {
                    e eVar = j1.this.f18760e;
                    e eVar2 = e.DISCONNECTED;
                    if (eVar != eVar2) {
                        j1.this.f18760e = eVar2;
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                j1.this.f18758c.b();
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            synchronized (j1.this) {
                try {
                    j1.this.f18762g = null;
                    j1 j1Var = j1.this;
                    e eVar = j1Var.f18760e;
                    e eVar2 = e.PING_SCHEDULED;
                    if (eVar == eVar2) {
                        j1Var.f18760e = e.PING_SENT;
                        j1Var.f18761f = j1Var.f18756a.schedule(j1Var.f18763h, j1Var.f18766k, TimeUnit.NANOSECONDS);
                        z10 = true;
                    } else {
                        if (eVar == e.PING_DELAYED) {
                            ScheduledExecutorService scheduledExecutorService = j1Var.f18756a;
                            Runnable runnable = j1Var.f18764i;
                            long j10 = j1Var.f18765j;
                            c1.o0 o0Var = j1Var.f18757b;
                            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                            j1Var.f18762g = scheduledExecutorService.schedule(runnable, j10 - o0Var.g(timeUnit), timeUnit);
                            j1.this.f18760e = eVar2;
                        }
                        z10 = false;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (z10) {
                j1.this.f18758c.a();
            }
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x f18769a;

        public class a implements u.a {
            public a() {
            }

            @Override // wj.u.a
            public void a(Throwable th2) {
                c.this.f18769a.a(vj.y2.f17563t.u("Keepalive failed. The connection is likely gone"));
            }

            @Override // wj.u.a
            public void b(long j10) {
            }
        }

        public c(x xVar) {
            this.f18769a = xVar;
        }

        @Override // wj.j1.d
        public void a() {
            this.f18769a.d(new a(), q1.n0.INSTANCE);
        }

        @Override // wj.j1.d
        public void b() {
            this.f18769a.a(vj.y2.f17563t.u("Keepalive failed. The connection is likely gone"));
        }
    }

    public interface d {
        void a();

        void b();
    }

    public enum e {
        IDLE,
        PING_SCHEDULED,
        PING_DELAYED,
        PING_SENT,
        IDLE_AND_PING_SENT,
        DISCONNECTED
    }

    public j1(d dVar, ScheduledExecutorService scheduledExecutorService, long j10, long j11, boolean z10) {
        this(dVar, scheduledExecutorService, new c1.o0(), j10, j11, z10);
    }

    public static long l(long j10) {
        return Math.max(j10, f18754l);
    }

    public static long m(long j10) {
        return Math.max(j10, f18755m);
    }

    public synchronized void n() {
        try {
            this.f18757b.j().k();
            e eVar = this.f18760e;
            e eVar2 = e.PING_SCHEDULED;
            if (eVar == eVar2) {
                this.f18760e = e.PING_DELAYED;
            } else if (eVar == e.PING_SENT || eVar == e.IDLE_AND_PING_SENT) {
                ScheduledFuture<?> scheduledFuture = this.f18761f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                if (this.f18760e == e.IDLE_AND_PING_SENT) {
                    this.f18760e = e.IDLE;
                } else {
                    this.f18760e = eVar2;
                    c1.h0.h0(this.f18762g == null, "There should be no outstanding pingFuture");
                    this.f18762g = this.f18756a.schedule(this.f18764i, this.f18765j, TimeUnit.NANOSECONDS);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void o() {
        try {
            e eVar = this.f18760e;
            if (eVar == e.IDLE) {
                this.f18760e = e.PING_SCHEDULED;
                if (this.f18762g == null) {
                    ScheduledExecutorService scheduledExecutorService = this.f18756a;
                    Runnable runnable = this.f18764i;
                    long j10 = this.f18765j;
                    c1.o0 o0Var = this.f18757b;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    this.f18762g = scheduledExecutorService.schedule(runnable, j10 - o0Var.g(timeUnit), timeUnit);
                }
            } else if (eVar == e.IDLE_AND_PING_SENT) {
                this.f18760e = e.PING_SENT;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void p() {
        try {
            if (this.f18759d) {
                return;
            }
            e eVar = this.f18760e;
            if (eVar == e.PING_SCHEDULED || eVar == e.PING_DELAYED) {
                this.f18760e = e.IDLE;
            }
            if (this.f18760e == e.PING_SENT) {
                this.f18760e = e.IDLE_AND_PING_SENT;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void q() {
        if (this.f18759d) {
            o();
        }
    }

    public synchronized void r() {
        try {
            e eVar = this.f18760e;
            e eVar2 = e.DISCONNECTED;
            if (eVar != eVar2) {
                this.f18760e = eVar2;
                ScheduledFuture<?> scheduledFuture = this.f18761f;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                }
                ScheduledFuture<?> scheduledFuture2 = this.f18762g;
                if (scheduledFuture2 != null) {
                    scheduledFuture2.cancel(false);
                    this.f18762g = null;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @b1.e
    public j1(d dVar, ScheduledExecutorService scheduledExecutorService, c1.o0 o0Var, long j10, long j11, boolean z10) {
        this.f18760e = e.IDLE;
        this.f18763h = new k1(new a());
        this.f18764i = new k1(new b());
        this.f18758c = (d) c1.h0.F(dVar, "keepAlivePinger");
        this.f18756a = (ScheduledExecutorService) c1.h0.F(scheduledExecutorService, "scheduler");
        this.f18757b = (c1.o0) c1.h0.F(o0Var, NotificationCompat.CATEGORY_STOPWATCH);
        this.f18765j = j10;
        this.f18766k = j11;
        this.f18759d = z10;
        o0Var.j().k();
    }
}
