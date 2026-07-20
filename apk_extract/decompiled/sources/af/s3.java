package af;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class s3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScheduledFuture f576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public r2 f577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ScheduledExecutorService f578d;
    public long e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f579g;

    public s3(long j8) {
        this.f575a = j8;
    }

    public final void a(cf.c0 c0Var, ScheduledExecutorService scheduledExecutorService) {
        this.f578d = scheduledExecutorService;
        long jNanoTime = System.nanoTime();
        long j8 = this.f575a;
        this.e = jNanoTime + j8;
        r2 r2Var = new r2(new m0(this, 3, scheduledExecutorService, c0Var));
        this.f577c = r2Var;
        this.f576b = scheduledExecutorService.schedule(r2Var, j8, TimeUnit.NANOSECONDS);
    }
}
