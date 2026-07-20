package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WifiP2pDevice f9864d;
    public final /* synthetic */ NearDevice e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f9865h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f9866i;

    public /* synthetic */ m(WifiP2pDevice wifiP2pDevice, com.welink.protocol.nfbd.z zVar, BluetoothDevice bluetoothDevice, NearDevice nearDevice, String str, String str2) {
        this.f9861a = 5;
        this.f9864d = wifiP2pDevice;
        this.f9862b = zVar;
        this.f9863c = bluetoothDevice;
        this.e = nearDevice;
        this.f9865h = str;
        this.f9866i = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceInfo deviceInfo;
        String name;
        String name2;
        String address;
        Object obj = this.f9862b;
        switch (this.f9861a) {
            case 0:
                ((e1) ((Pair) obj).getSecond()).d(this.f9863c, this.f9864d, this.e, this.f9865h, this.f9866i);
                break;
            case 1:
                ((e1) ((Pair) obj).getSecond()).d(this.f9863c, this.f9864d, this.e, this.f9865h, this.f9866i);
                break;
            case 2:
                ((e1) ((Pair) obj).getSecond()).d(this.f9863c, this.f9864d, this.e, this.f9865h, this.f9866i);
                break;
            case 3:
                ((e1) ((Pair) obj).getSecond()).d(this.f9863c, this.f9864d, this.e, this.f9865h, this.f9866i);
                break;
            case 4:
                ((e1) ((Pair) obj).getSecond()).d(this.f9863c, this.f9864d, this.e, this.f9865h, this.f9866i);
                break;
            default:
                WifiP2pDevice p2pDevice = this.f9864d;
                if (p2pDevice != null) {
                    com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) obj;
                    zVar.getClass();
                    Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                    NearDevice nearDevice = this.e;
                    TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo(this.f9866i, 21, 0, 0, 0, new NearDeviceDataParcel(p2pDevice, nearDevice));
                    BluetoothDevice bluetoothDevice = this.f9863c;
                    int i8 = bluetoothDevice != null ? 0 : 3;
                    if (nearDevice != null) {
                        Map map = com.welink.protocol.nfbd.h.f4132a;
                        byte bE = com.welink.protocol.nfbd.h.e(nearDevice.f3889j);
                        byte bG = com.welink.protocol.nfbd.h.g(nearDevice.h());
                        if ((bluetoothDevice == null || (name2 = bluetoothDevice.getName()) == null) && (name2 = p2pDevice.deviceName) == null) {
                            name2 = nearDevice.f3884b;
                        }
                        String str = name2;
                        if ((bluetoothDevice == null || (address = bluetoothDevice.getAddress()) == null) && (address = p2pDevice.deviceAddress) == null) {
                            address = nearDevice.f3883a;
                        }
                        deviceInfo = new DeviceInfo(bE, bG, str, address, (Boolean) null, (EarBudsInfo) null, i8, com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    } else {
                        deviceInfo = new DeviceInfo((byte) 0, (byte) 0, p2pDevice.deviceName, p2pDevice.deviceAddress, (Boolean) null, (EarBudsInfo) null, 3, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    }
                    DeviceInfo deviceInfo2 = deviceInfo;
                    if (bluetoothDevice == null || (name = bluetoothDevice.getName()) == null) {
                        name = p2pDevice.deviceName;
                    }
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(this.f9865h, 0, 0, name, 21, deviceInfo2, tranConnectionController$EventInfo, bluetoothDevice != null ? new NearDeviceDataParcel(bluetoothDevice, nearDevice) : new NearDeviceDataParcel(p2pDevice, nearDevice));
                    we.h.g("on P2p Connected");
                    zVar.q(tranConnectionController$MessageInfo, nearDevice);
                }
                break;
        }
    }

    public /* synthetic */ m(Pair pair, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice, String str, String str2, int i8) {
        this.f9861a = i8;
        this.f9862b = pair;
        this.f9863c = bluetoothDevice;
        this.f9864d = wifiP2pDevice;
        this.e = nearDevice;
        this.f9865h = str;
        this.f9866i = str2;
    }
}
