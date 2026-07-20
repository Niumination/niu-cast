package vd;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.internal.app.ITranBatteryStats;

/* JADX INFO: loaded from: classes2.dex */
public class a implements pg.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16902b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranBatteryStats f16903a = ITranBatteryStats.Stub.asInterface(TranServiceManager.getServiceIBinder("battery_stats"));

    @Override // pg.a
    public long a() {
        ITranBatteryStats iTranBatteryStats = this.f16903a;
        if (iTranBatteryStats == null) {
            return 0L;
        }
        try {
            return iTranBatteryStats.computeBatteryTimeRemaining();
        } catch (RemoteException e10) {
            j7.b.a("computeBatteryTimeRemaining fail ", e10, f16902b);
            return 0L;
        }
    }
}
