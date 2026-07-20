package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import com.welink.protocol.nfbd.NearDevice;
import java.util.Collection;

/* JADX INFO: loaded from: classes3.dex */
public interface b4 {
    void a(int i8);

    void b(boolean z2, int i8, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice);

    void c(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo);

    void d();

    void e();

    void f(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection collection);

    void g();

    void h(WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection collection);

    void i();
}
