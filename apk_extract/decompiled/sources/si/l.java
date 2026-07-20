package si;

import java.util.concurrent.TimeUnit;
import kotlin.ranges.RangesKt;
import qi.y;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f10126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f10127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10129d;
    public static final long e;
    public static final h f;

    static {
        String property;
        int i8 = y.f9172a;
        try {
            property = System.getProperty("kotlinx.coroutines.scheduler.default.name");
        } catch (SecurityException unused) {
            property = null;
        }
        if (property == null) {
            property = "DefaultDispatcher";
        }
        f10126a = property;
        f10127b = qi.g.i(100000L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.resolution.ns");
        f10128c = qi.g.j("kotlinx.coroutines.scheduler.core.pool.size", RangesKt.coerceAtLeast(y.f9172a, 2), 1, 0, 8);
        f10129d = qi.g.j("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4);
        e = TimeUnit.SECONDS.toNanos(qi.g.i(60L, 1L, Long.MAX_VALUE, "kotlinx.coroutines.scheduler.keep.alive.sec"));
        f = h.f10121a;
    }
}
