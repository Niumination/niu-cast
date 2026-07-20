package se;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import com.welink.protocol.wifi.P2pTool$mP2pReceiver$1;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f6 implements WifiP2pManager.DeviceInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9740a;

    @Override // android.net.wifi.p2p.WifiP2pManager.DeviceInfoListener
    public final void onDeviceInfoAvailable(WifiP2pDevice wifiP2pDevice) {
        switch (this.f9740a) {
            case 0:
                int i8 = TranP2pConnectHelper$mP2pStateReceiver$1.f3984b;
                we.h.g("requestDeviceInfo wifiP2pDevice: " + wifiP2pDevice);
                break;
            default:
                int i9 = P2pTool$mP2pReceiver$1.f4249b;
                we.h.g("requestDeviceInfo wifiP2pDevice: " + wifiP2pDevice);
                break;
        }
    }
}
