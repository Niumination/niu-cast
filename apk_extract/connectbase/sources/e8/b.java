package e8;

import android.content.Context;
import android.os.BatteryStatsManager;
import android.os.BatteryUsageStats;
import android.os.IBinder;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements pg.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f4097c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f4098a = bc.a.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BatteryStatsManager f4099b;

    @Override // pg.b
    public int a() {
        Class clsA = cc.a.a("android.os.ServiceManager");
        IBinder iBinder = (IBinder) cc.a.j(cc.a.g(clsA, "getService", String.class), clsA, "batterystats");
        String str = f4097c;
        dc.e.a(str, "binder is ".concat(iBinder == null ? d6.a.E : "not null"));
        Object objJ = cc.a.j(cc.a.g(cc.a.a("com.android.internal.app.IBatteryStats$Stub"), "asInterface", IBinder.class), null, iBinder);
        Object objJ2 = 0;
        if (objJ != null) {
            Method methodG = cc.a.g(objJ.getClass(), "getBatteryTemperature", new Class[0]);
            if (methodG == null) {
                return -1;
            }
            objJ2 = cc.a.j(methodG, objJ, new Object[0]);
            dc.e.a(str, objJ.getClass().getName() + " data: " + objJ2);
        }
        if (objJ2 == null) {
            return -1;
        }
        return ((Integer) objJ2).intValue();
    }

    @Override // pg.b
    public va.c b() {
        long jC = c();
        va.c cVar = new va.c(jC);
        dc.e.a(f4097c, "getBatteryUsageStats getBatteryTimeRemainingMs: " + jC);
        return cVar;
    }

    @b.a({"MissingPermission"})
    public final long c() {
        BatteryUsageStats batteryUsageStatsBuild;
        if (this.f4099b == null) {
            this.f4099b = (BatteryStatsManager) this.f4098a.getSystemService(BatteryStatsManager.class);
        }
        try {
            batteryUsageStatsBuild = this.f4099b.getBatteryUsageStats();
        } catch (RuntimeException e10) {
            dc.e.c(f4097c, "getBatteryUsageStats aosp fail:" + e10);
            batteryUsageStatsBuild = new BatteryUsageStats.Builder(new String[0]).build();
        }
        if (batteryUsageStatsBuild != null) {
            return batteryUsageStatsBuild.getBatteryTimeRemainingMs();
        }
        return 0L;
    }
}
