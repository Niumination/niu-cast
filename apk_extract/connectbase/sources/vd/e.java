package vd;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.os.ITranChargeManager;

/* JADX INFO: loaded from: classes2.dex */
public class e implements pg.d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16919b = "TranThubChargeManager";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ITranChargeManager f16920a = ITranChargeManager.Stub.asInterface(TranServiceManager.getServiceIBinder("trancharge"));

    @Override // pg.d
    public boolean a(String str) {
        try {
            ITranChargeManager iTranChargeManager = this.f16920a;
            if (iTranChargeManager != null) {
                return iTranChargeManager.updateSysNodeValue(str);
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("updateSysNodeValue fail: e = ", e10, f16919b);
            return false;
        }
    }

    @Override // pg.d
    public boolean b(int i10, String str) {
        try {
            ITranChargeManager iTranChargeManager = this.f16920a;
            if (iTranChargeManager != null) {
                return iTranChargeManager.setSysNodeConfig(i10, str);
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("setSysNodeConfig fail: e = ", e10, f16919b);
            return false;
        }
    }

    @Override // pg.d
    public boolean c() {
        try {
            ITranChargeManager iTranChargeManager = this.f16920a;
            if (iTranChargeManager != null) {
                return iTranChargeManager.isOtgPluginedNow();
            }
            return false;
        } catch (RemoteException e10) {
            j7.b.a("isOtgPluginedNow fail: e = ", e10, f16919b);
            return false;
        }
    }
}
