package se;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pDevice;
import androidx.core.view.PointerIconCompat;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import com.welink.protocol.utils.DeviceData;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f9725a = new LinkedHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.g f9726b;

    public e1(com.welink.protocol.nfbd.g gVar) {
        this.f9726b = gVar;
    }

    public final void a(BluetoothDevice device, int i8, int i9) {
        Intrinsics.checkNotNullParameter(device, "device");
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_BLE_CONNECTED_EXCHANGE_NOTIFY");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", device);
        intent.putExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST_ID", i8);
        intent.putExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST_OFFSET", i9);
        gVar.f4112b.j(intent);
    }

    public final void b(BluetoothDevice device, ConnectRequest connectRequest, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_INVITATION_RECEIVED");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", device);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        intent.putExtra("com.welink.service.EXTRA_BLE_CONNECTED_EXCHANGE_REQUEST", connectRequest);
        gVar.f4112b.j(intent);
    }

    public final void c(BluetoothDevice device, ConnectRequest connectRequest, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
        com.welink.protocol.nfbd.g.a(this.f9726b, new DeviceData(we.c.BLUETOOTH_LE, device.getName(), null, device, 240), connectRequest, PointerIconCompat.TYPE_TEXT, nearDevice);
    }

    public final void d(BluetoothDevice bluetoothDevice, WifiP2pDevice p2pDevice, NearDevice nearDevice, String str, String str2) {
        Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_GC_CONNECTED");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", bluetoothDevice);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_DEVICE", p2pDevice);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_HOST_ADDRESS", str);
        if (str2 == null) {
            str2 = "";
        }
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_CLIENT_ADDRESS", str2);
        gVar.f4112b.j(intent);
        com.welink.protocol.nfbd.m mVar = gVar.f4117i;
        if (mVar != null) {
            mVar.f4182r = true;
        }
    }

    public final void e(BluetoothDevice bluetoothDevice, WifiP2pDevice owner, String str, String str2, String str3, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_CLIENT_CONNECTED");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", bluetoothDevice);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_DEVICE", owner);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_NETWORK_INFO", str);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_HOST_ADDRESS", str2);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_CLIENT_ADDRESS", str3);
        intent.putExtra("com.welink.service.EXTRA_P2P_DEVICE_INFO", tranConnectionController$P2pDeviceInfo);
        gVar.f4112b.j(intent);
        com.welink.protocol.nfbd.m mVar = gVar.f4117i;
        if (mVar != null) {
            mVar.q = true;
        }
    }

    public final void f(BluetoothDevice device, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.f9726b.p(new DeviceData(we.c.BLUETOOTH_LE, device.getName(), null, device, 240), nearDevice, PointerIconCompat.TYPE_TEXT, -255);
    }

    public final void g(int i8, BluetoothDevice device, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        this.f9725a.remove(device.getAddress());
        we.h.b("NearConnectionService", "onClientDeviceDisconnected, device: " + device);
        this.f9726b.p(new DeviceData(we.c.BLUETOOTH_LE, device.getName(), null, device, 240), nearDevice, PointerIconCompat.TYPE_ALIAS, i8);
    }

    public final void h(BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, boolean z2, NearDevice nearDevice) {
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_CLIENT_DISCONNECTED");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", bluetoothDevice);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_DEVICE", wifiP2pDevice);
        intent.putExtra("com.welink.protocol.nfbd.extra.isSelf", z2);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        gVar.f4112b.j(intent);
        com.welink.protocol.nfbd.m mVar = gVar.f4117i;
        if (mVar != null) {
            mVar.q = false;
            mVar.f4182r = false;
        }
    }

    public final void i(BluetoothDevice bluetoothDevice, WifiP2pDevice p2pDevice, NearDevice nearDevice, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo) {
        Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_OWNER_AVAILABLE");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", bluetoothDevice);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_DEVICE", p2pDevice);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        intent.putExtra("com.welink.service.EXTRA_P2P_DEVICE_INFO", tranConnectionController$P2pDeviceInfo);
        gVar.f4112b.j(intent);
    }

    public final void j(BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, int i8, NearDevice nearDevice) {
        com.welink.protocol.nfbd.g gVar = this.f9726b;
        gVar.getClass();
        Intent intent = new Intent("com.welink.service.ACTION_P2P_CONNECTION_FAILED");
        intent.putExtra("com.welink.service.EXTRA_BLUETOOTH_DEVICE", bluetoothDevice);
        intent.putExtra("com.welink.service.EXTRA_WIFI_P2P_DEVICE", wifiP2pDevice);
        intent.putExtra("com.welink.service.EXTRA_P2P_CONNECTION_FAILED_REASON", i8);
        intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", nearDevice);
        gVar.f4112b.j(intent);
    }
}
