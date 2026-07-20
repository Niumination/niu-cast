package af;

import java.util.concurrent.TimeUnit;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class l2 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final long f427g = TimeUnit.HOURS.toNanos(2);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2 f429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f431d;
    public boolean e;
    public int f;

    public l2(long j8, TimeUnit timeUnit) {
        k2 k2Var = k2.f376b;
        v8.f(j8 >= 0, "minTime must be non-negative: %s", j8);
        this.f428a = Math.min(timeUnit.toNanos(j8), f427g);
        this.f429b = k2Var;
        long jNanoTime = System.nanoTime();
        this.f430c = jNanoTime;
        this.f431d = jNanoTime;
    }
}
