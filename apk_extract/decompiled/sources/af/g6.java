package af;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import k3.v8;

/* JADX INFO: loaded from: classes3.dex */
public final class g6 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final g6 f297d = new g6(new k2(20));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IdentityHashMap f298a = new IdentityHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k2 f299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ScheduledExecutorService f300c;

    public g6(k2 k2Var) {
        this.f299b = k2Var;
    }

    public static Object a(f6 f6Var) {
        Object obj;
        g6 g6Var = f297d;
        synchronized (g6Var) {
            try {
                e6 e6Var = (e6) g6Var.f298a.get(f6Var);
                if (e6Var == null) {
                    e6Var = new e6(f6Var.b());
                    g6Var.f298a.put(f6Var, e6Var);
                }
                ScheduledFuture scheduledFuture = e6Var.f251c;
                if (scheduledFuture != null) {
                    scheduledFuture.cancel(false);
                    e6Var.f251c = null;
                }
                e6Var.f250b++;
                obj = e6Var.f249a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    public static void b(f6 f6Var, Object obj) {
        g6 g6Var = f297d;
        synchronized (g6Var) {
            try {
                e6 e6Var = (e6) g6Var.f298a.get(f6Var);
                if (e6Var == null) {
                    throw new IllegalArgumentException("No cached instance found for " + f6Var);
                }
                v8.c("Releasing the wrong instance", obj == e6Var.f249a);
                v8.n(e6Var.f250b > 0, "Refcount has already reached zero");
                int i8 = e6Var.f250b - 1;
                e6Var.f250b = i8;
                if (i8 == 0) {
                    v8.n(e6Var.f251c == null, "Destroy task already scheduled");
                    if (g6Var.f300c == null) {
                        g6Var.f299b.getClass();
                        g6Var.f300c = Executors.newSingleThreadScheduledExecutor(l1.f("grpc-shared-destroyer-%d"));
                    }
                    e6Var.f251c = g6Var.f300c.schedule(new r2(new a(3, g6Var, e6Var, f6Var, obj)), 1L, TimeUnit.SECONDS);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
