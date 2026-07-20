package af;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: classes3.dex */
public final class p4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ze.v2 f505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2 f506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z4 f507d;
    public long e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ScheduledFuture f508g;

    public p4(u2 u2Var, ze.v2 v2Var, ScheduledExecutorService scheduledExecutorService, z4 z4Var) {
        this.f506c = u2Var;
        this.f505b = v2Var;
        this.f504a = scheduledExecutorService;
        this.f507d = z4Var;
        z4Var.b();
    }
}
