package se;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pDeviceList;
import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import com.welink.protocol.wifi.P2pTool$mP2pReceiver$1;
import java.util.Collection;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e6 implements WifiP2pManager.PeerListListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9737b;

    public /* synthetic */ e6(Object obj, int i8) {
        this.f9736a = i8;
        this.f9737b = obj;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.PeerListListener
    public final void onPeersAvailable(WifiP2pDeviceList wifiP2pDeviceList) {
        Object obj = this.f9737b;
        switch (this.f9736a) {
            case 0:
                int i8 = TranP2pConnectHelper$mP2pStateReceiver$1.f3984b;
                if (wifiP2pDeviceList != null) {
                    Collection<WifiP2pDevice> deviceList = wifiP2pDeviceList.getDeviceList();
                    Intrinsics.checkNotNullExpressionValue(deviceList, "getDeviceList(...)");
                    if (!deviceList.isEmpty()) {
                        we.h.g("WIFI_P2P_PEERS_CHANGED_ACTION: peers is " + wifiP2pDeviceList);
                        ((mg.b0) obj).getClass();
                    }
                }
                Intrinsics.checkNotNullParameter("WIFI_P2P_PEERS_CHANGED_ACTION: peers is empty", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", "WIFI_P2P_PEERS_CHANGED_ACTION: peers is empty", null);
                }
                break;
            default:
                int i9 = P2pTool$mP2pReceiver$1.f4249b;
                if (wifiP2pDeviceList != null) {
                    Collection<WifiP2pDevice> deviceList2 = wifiP2pDeviceList.getDeviceList();
                    Intrinsics.checkNotNullExpressionValue(deviceList2, "getDeviceList(...)");
                    if (!deviceList2.isEmpty()) {
                        we.h.g("WIFI_P2P_PEERS_CHANGED_ACTION: peers is " + wifiP2pDeviceList);
                        if (((ye.d) obj).f11174c != null) {
                            Intrinsics.checkNotNullParameter(wifiP2pDeviceList, "wifiP2pDeviceList");
                            Collection<WifiP2pDevice> deviceList3 = wifiP2pDeviceList.getDeviceList();
                            Intrinsics.checkNotNullExpressionValue(deviceList3, "getDeviceList(...)");
                            for (WifiP2pDevice wifiP2pDevice : deviceList3) {
                                int i10 = wifiP2pDevice.status;
                                if (i10 == 0) {
                                    we.h.b("NearP2pManager", "WIFI_P2P_PEERS_CHANGED_ACTION:  Device Name:" + wifiP2pDevice.deviceName + ", Device Address:" + wifiP2pDevice.deviceAddress);
                                } else {
                                    StringBuilder sbP = h0.a.p("WIFI_P2P_PEERS_CHANGED_ACTION:  Device Name:", wifiP2pDevice.deviceName, ", Device Address:", wifiP2pDevice.deviceAddress, ", Status:");
                                    sbP.append(i10);
                                    we.h.b("NearP2pManager", sbP.toString());
                                }
                            }
                        }
                    }
                }
                we.h.g("WIFI_P2P_PEERS_CHANGED_ACTION: peers is null");
                break;
        }
    }
}
