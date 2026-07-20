package xq;

import java.util.concurrent.TimeUnit;
import vq.y0;
import vq.z0;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @in.f
    @os.l
    public static final String f20520a = z0.c("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @in.f
    public static final long f20521b = z0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000, 0, 0, 12, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @in.f
    public static final int f20522c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @in.f
    public static final int f20523d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @in.f
    public static final long f20524e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @in.f
    @os.l
    public static j f20525f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f20526g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f20527h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @in.f
    @os.l
    public static final l f20528i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @in.f
    @os.l
    public static final l f20529j;

    static {
        int iA = y0.a();
        f20522c = z0.e("kotlinx.coroutines.scheduler.core.pool.size", iA < 2 ? 2 : iA, 1, 0, 8, null);
        f20523d = z0.e("kotlinx.coroutines.scheduler.max.pool.size", a.N, 0, a.N, 4, null);
        f20524e = TimeUnit.SECONDS.toNanos(z0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null));
        f20525f = h.f20510a;
        f20528i = new m(0);
        f20529j = new m(1);
    }

    public static final boolean a(@os.l k kVar) {
        return kVar.f20517b.q() == 1;
    }
}
