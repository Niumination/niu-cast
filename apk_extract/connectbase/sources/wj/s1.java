package wj;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class s1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final c f19258i = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f19259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f19260b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @gm.a
    public ScheduledFuture<?> f19261c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f19262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScheduledExecutorService f19263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f19264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f19265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f19266h;

    public class a implements c {
        @Override // wj.s1.c
        public long a() {
            return System.nanoTime();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ScheduledExecutorService f19267a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Runnable f19268b;

        public b(ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
            this.f19267a = scheduledExecutorService;
            this.f19268b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!s1.this.f19265g) {
                this.f19268b.run();
                s1.this.f19261c = null;
                return;
            }
            s1 s1Var = s1.this;
            if (s1Var.f19266h) {
                return;
            }
            s1Var.f19261c = this.f19267a.schedule(s1Var.f19262d, s1Var.f19264f - s1Var.f19260b.a(), TimeUnit.NANOSECONDS);
            s1.this.f19265g = false;
        }
    }

    @b1.e
    public interface c {
        long a();
    }

    public s1(long j10) {
        this(j10, f19258i);
    }

    public void h() {
        this.f19266h = true;
        this.f19265g = true;
    }

    public void i() {
        this.f19266h = false;
        ScheduledFuture<?> scheduledFuture = this.f19261c;
        if (scheduledFuture == null) {
            return;
        }
        if (!scheduledFuture.isDone()) {
            this.f19264f = this.f19260b.a() + this.f19259a;
        } else {
            this.f19265g = false;
            this.f19261c = this.f19263e.schedule(this.f19262d, this.f19259a, TimeUnit.NANOSECONDS);
        }
    }

    public void j() {
        ScheduledFuture<?> scheduledFuture = this.f19261c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.f19261c = null;
        }
    }

    public void k(Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        this.f19263e = scheduledExecutorService;
        this.f19264f = this.f19260b.a() + this.f19259a;
        k1 k1Var = new k1(new b(scheduledExecutorService, runnable));
        this.f19262d = k1Var;
        this.f19261c = scheduledExecutorService.schedule(k1Var, this.f19259a, TimeUnit.NANOSECONDS);
    }

    @b1.e
    public s1(long j10, c cVar) {
        this.f19259a = j10;
        this.f19260b = cVar;
    }
}
