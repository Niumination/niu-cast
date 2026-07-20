package vd;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranBatteryStatsManager;
import com.transsion.hubsdk.os.TranBatteryUsageStats;

/* JADX INFO: loaded from: classes2.dex */
public class c implements pg.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16913b = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranBatteryStatsManager f16914a = ITranBatteryStatsManager.Stub.asInterface(TranServiceManager.getServiceIBinder("battery_stats_manager"));

    @Override // pg.b
    public int a() {
        return ((Integer) new zb.f().c(new zb.f.b() { // from class: vd.b
            @Override // zb.f.b
            public final Object run() {
                return this.f16906a.d();
            }
        }, "package")).intValue();
    }

    @Override // pg.b
    public va.c b() {
        TranBatteryUsageStats batteryUsageStats;
        ITranBatteryStatsManager iTranBatteryStatsManager = this.f16914a;
        if (iTranBatteryStatsManager == null) {
            return null;
        }
        try {
            batteryUsageStats = iTranBatteryStatsManager.getBatteryUsageStats();
        } catch (RemoteException e10) {
            j7.b.a("getBatteryUsageStats fail ", e10, f16913b);
            batteryUsageStats = null;
        }
        if (batteryUsageStats != null) {
            return new va.c(batteryUsageStats.getBatteryTimeRemainingMs());
        }
        return null;
    }

    public final /* synthetic */ Object d() throws RemoteException {
        ITranBatteryStatsManager iTranBatteryStatsManager = this.f16914a;
        if (iTranBatteryStatsManager != null) {
            try {
                return Integer.valueOf(iTranBatteryStatsManager.getBatteryTemperature());
            } catch (RemoteException e10) {
                j7.b.a("getBatteryTemperature fail ", e10, f16913b);
            }
        }
        return -1;
    }
}
