package r9;

import android.os.RemoteException;
import com.transsion.hubsdk.TranServiceManager;
import com.transsion.hubsdk.net.wifi.ITranWifiManager;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements ca.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ITranWifiManager f9385a = ITranWifiManager.Stub.asInterface(TranServiceManager.getServiceIBinder("wifi_manager"));

    @Override // ca.a
    public final int a() {
        ITranWifiManager iTranWifiManager = this.f9385a;
        if (iTranWifiManager == null) {
            return 0;
        }
        try {
            return iTranWifiManager.getWifiApState();
        } catch (RemoteException e) {
            j9.a.b("a", "getWifiApState fail " + e);
            return 0;
        }
    }
}
