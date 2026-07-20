package i6;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class m implements e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f7733c = Runtime.getRuntime().availableProcessors() + 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f7734a = new ScheduledThreadPoolExecutor(f7733c, new k());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f7735b = new ConcurrentLinkedQueue<>();

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7736a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f7737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Runnable f7738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f7739d;

        public a(int i10, Runnable runnable, Runnable runnable2) {
            this.f7737b = i10;
            this.f7738c = runnable;
            this.f7739d = runnable2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = this.f7736a + 1;
            this.f7736a = i10;
            if (i10 <= this.f7737b) {
                this.f7738c.run();
                return;
            }
            Runnable runnable = this.f7739d;
            if (runnable != null) {
                runnable.run();
            }
            m.this.e(this.f7738c);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f7741a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ScheduledFuture<?> f7742b;

        public b(Runnable runnable, ScheduledFuture<?> scheduledFuture) {
            this.f7741a = runnable;
            this.f7742b = scheduledFuture;
        }
    }

    public static /* synthetic */ boolean o(ScheduledFuture scheduledFuture, b bVar) {
        return bVar.f7742b == scheduledFuture;
    }

    public static /* synthetic */ boolean p(Runnable runnable, b bVar) {
        return bVar.f7741a == runnable;
    }

    public static /* synthetic */ Thread q(Runnable runnable) {
        return new Thread(runnable, "ThreadPoolScheduledExecutor");
    }

    public static /* synthetic */ boolean r(Runnable runnable, b bVar) {
        return runnable == bVar.f7741a;
    }

    public static /* synthetic */ boolean t(Runnable runnable, b bVar) {
        return runnable == bVar.f7741a;
    }

    public static /* synthetic */ boolean u(Runnable runnable, b bVar) {
        return runnable == bVar.f7741a;
    }

    @Override // i6.e
    public void a() {
        if (this.f7734a.isShutdown()) {
            return;
        }
        this.f7734a.shutdownNow();
    }

    @Override // i6.e
    public void b(final Runnable runnable, long j10) {
        if (runnable != null && i6.b.c(this.f7735b, new i6.b.InterfaceC0215b() { // from class: i6.h
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return m.r(runnable, (m.b) obj);
            }
        }) == null) {
            this.f7735b.add(new b(runnable, this.f7734a.schedule(new Runnable() { // from class: i6.i
                @Override // java.lang.Runnable
                public final void run() {
                    this.f7729a.s(runnable);
                }
            }, j10, TimeUnit.MILLISECONDS)));
        }
    }

    @Override // i6.e
    public void c(Runnable runnable, int i10, long j10, int i11) {
        f(runnable, null, i10, j10, i11);
    }

    @Override // i6.e
    public void d(final ScheduledFuture<?> scheduledFuture) {
        if (scheduledFuture == null || scheduledFuture.isDone() || scheduledFuture.isCancelled()) {
            return;
        }
        scheduledFuture.cancel(true);
        b bVar = (b) i6.b.c(this.f7735b, new i6.b.InterfaceC0215b() { // from class: i6.l
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return m.o(scheduledFuture, (m.b) obj);
            }
        });
        if (bVar != null) {
            this.f7735b.remove(bVar);
        }
    }

    @Override // i6.e
    public void e(final Runnable runnable) {
        b bVar;
        if (runnable == null || (bVar = (b) i6.b.c(this.f7735b, new i6.b.InterfaceC0215b() { // from class: i6.j
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return m.p(runnable, (m.b) obj);
            }
        })) == null) {
            return;
        }
        d(bVar.f7742b);
    }

    @Override // i6.e
    public void f(final Runnable runnable, Runnable runnable2, int i10, long j10, int i11) {
        if (runnable != null && i6.b.c(this.f7735b, new i6.b.InterfaceC0215b() { // from class: i6.f
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return m.u(runnable, (m.b) obj);
            }
        }) == null) {
            this.f7735b.add(new b(runnable, this.f7734a.scheduleWithFixedDelay(new a(i11, runnable, runnable2), i10, j10, TimeUnit.MILLISECONDS)));
        }
    }

    @Override // i6.e
    public void g(final Runnable runnable, long j10, long j11) {
        if (runnable != null && i6.b.c(this.f7735b, new i6.b.InterfaceC0215b() { // from class: i6.g
            @Override // i6.b.InterfaceC0215b
            public final boolean a(Object obj) {
                return m.t(runnable, (m.b) obj);
            }
        }) == null) {
            this.f7735b.add(new b(runnable, this.f7734a.scheduleWithFixedDelay(runnable, j10, j11, TimeUnit.MILLISECONDS)));
        }
    }

    public final /* synthetic */ void s(Runnable runnable) {
        runnable.run();
        e(runnable);
    }
}
