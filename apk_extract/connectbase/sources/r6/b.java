package r6;

import android.app.usage.UsageEvents;
import android.app.usage.UsageStats;
import android.os.Bundle;
import android.os.IBinder;
import dc.e;
import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class b implements df.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f14288a = "b";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Class<?> f14289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f14290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static IBinder f14291d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Class<?> f14292e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Method f14293f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Object f14294g;

    static {
        Class<?> clsA = cc.a.a("android.os.ServiceManager");
        f14289b = clsA;
        Method methodG = cc.a.g(clsA, "getService", String.class);
        f14290c = methodG;
        f14291d = (IBinder) cc.a.j(methodG, f14289b, "usagestats");
        Class<?> clsA2 = cc.a.a("android.app.usage.IUsageStatsManager$Stub");
        f14292e = clsA2;
        Method methodG2 = cc.a.g(clsA2, "asInterface", IBinder.class);
        f14293f = methodG2;
        f14294g = cc.a.j(methodG2, f14292e, f14291d);
    }

    @Override // df.b
    public long a() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // df.b
    public int b(UsageStats usageStats) {
        Method methodG = cc.a.g(usageStats.getClass(), "getAppLaunchCount", new Class[0]);
        if (methodG != null) {
            return ((Integer) cc.a.j(methodG, usageStats, new Object[0])).intValue();
        }
        return 0;
    }

    @Override // df.b
    public UsageEvents c(long j10, long j11, int i10, String str, String str2) {
        Class<?> cls = f14294g.getClass();
        Class cls2 = Long.TYPE;
        UsageEvents usageEvents = (UsageEvents) cc.a.j(cc.a.g(cls, "queryEventsForPackageForUser", cls2, cls2, Integer.TYPE, String.class, String.class), f14294g, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10), str, str2);
        e.a(f14288a, "queryEventsForPackageForUser usageEvents = " + usageEvents);
        return usageEvents;
    }

    @Override // df.b
    public void d(j9.e.b bVar) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // df.b
    public Bundle e() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // df.b
    public List<j9.b> f(long j10) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // df.b
    public UsageEvents g(long j10, long j11, int i10, String str) {
        Class<?> cls = f14294g.getClass();
        Class cls2 = Long.TYPE;
        UsageEvents usageEvents = (UsageEvents) cc.a.j(cc.a.g(cls, "queryEventsForUser", cls2, cls2, Integer.TYPE, String.class), f14294g, Long.valueOf(j10), Long.valueOf(j11), Integer.valueOf(i10), str);
        e.a(f14288a, "queryEventsForUser usageEvents = " + usageEvents);
        return usageEvents;
    }

    @Override // df.b
    public List<j9.a> h(long j10) throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }

    @Override // df.b
    public void i() throws ac.a {
        throw new ac.a("Non-native interface, please implement it yourself");
    }
}
