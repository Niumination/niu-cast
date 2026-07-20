package se;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9981a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f9982b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9983c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ WifiP2pDevice f9984d;
    public final /* synthetic */ String e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ String f9985h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ String f9986i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ TranConnectionController$P2pDeviceInfo f9987j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9988k;

    public /* synthetic */ t(WifiP2pDevice wifiP2pDevice, com.welink.protocol.nfbd.z zVar, BluetoothDevice bluetoothDevice, String str, String str2, String str3, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo, NearDevice nearDevice) {
        this.f9981a = 5;
        this.f9984d = wifiP2pDevice;
        this.f9982b = zVar;
        this.f9983c = bluetoothDevice;
        this.e = str;
        this.f9985h = str2;
        this.f9986i = str3;
        this.f9987j = tranConnectionController$P2pDeviceInfo;
        this.f9988k = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceInfo deviceInfo;
        String name;
        String name2;
        String address;
        Object obj = this.f9982b;
        switch (this.f9981a) {
            case 0:
                ((e1) ((Pair) obj).getSecond()).e(this.f9983c, this.f9984d, this.e, this.f9985h, this.f9986i, this.f9987j, this.f9988k);
                break;
            case 1:
                ((e1) ((Pair) obj).getSecond()).e(this.f9983c, this.f9984d, this.e, this.f9985h, this.f9986i, this.f9987j, this.f9988k);
                break;
            case 2:
                ((e1) ((Pair) obj).getSecond()).e(this.f9983c, this.f9984d, this.e, this.f9985h, this.f9986i, this.f9987j, this.f9988k);
                break;
            case 3:
                ((e1) ((Pair) obj).getSecond()).e(this.f9983c, this.f9984d, this.e, this.f9985h, this.f9986i, this.f9987j, this.f9988k);
                break;
            case 4:
                ((e1) ((Pair) obj).getSecond()).e(this.f9983c, this.f9984d, this.e, this.f9985h, this.f9986i, this.f9987j, this.f9988k);
                break;
            default:
                WifiP2pDevice p2pDevice = this.f9984d;
                if (p2pDevice != null) {
                    com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) obj;
                    zVar.getClass();
                    Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                    TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = this.f9987j;
                    NearDevice nearDevice = this.f9988k;
                    TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo(this.f9986i, 21, 0, 0, 0, tranConnectionController$P2pDeviceInfo != null ? new NearDeviceDataParcel(tranConnectionController$P2pDeviceInfo, nearDevice) : null);
                    BluetoothDevice bluetoothDevice = this.f9983c;
                    int i8 = bluetoothDevice != null ? 0 : 3;
                    String str = this.e;
                    if (nearDevice != null) {
                        Map map = com.welink.protocol.nfbd.h.f4132a;
                        byte bE = com.welink.protocol.nfbd.h.e(nearDevice.f3889j);
                        byte bG = com.welink.protocol.nfbd.h.g(nearDevice.h());
                        String str2 = ((bluetoothDevice == null || (name2 = bluetoothDevice.getName()) == null) && (name2 = nearDevice.f3884b) == null) ? str : name2;
                        if (bluetoothDevice == null || (address = bluetoothDevice.getAddress()) == null) {
                            address = nearDevice.f3883a;
                        }
                        deviceInfo = new DeviceInfo(bE, bG, str2, address, (Boolean) null, (EarBudsInfo) null, i8, com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    } else {
                        String str3 = p2pDevice.deviceName;
                        deviceInfo = new DeviceInfo((byte) 0, (byte) 0, str3 == null ? str : str3, p2pDevice.deviceAddress, (Boolean) null, (EarBudsInfo) null, 3, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    }
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(this.f9985h, 0, 0, ((bluetoothDevice == null || (name = bluetoothDevice.getName()) == null) && (name = p2pDevice.deviceName) == null) ? str : name, 21, deviceInfo, tranConnectionController$EventInfo, bluetoothDevice != null ? new NearDeviceDataParcel(bluetoothDevice, p2pDevice) : new NearDeviceDataParcel(p2pDevice, nearDevice));
                    we.h.h("TranConnectionManager", "P2p client connected");
                    zVar.q(tranConnectionController$MessageInfo, nearDevice);
                }
                break;
        }
    }

    public /* synthetic */ t(Pair pair, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, String str, String str2, String str3, TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo, NearDevice nearDevice, int i8) {
        this.f9981a = i8;
        this.f9982b = pair;
        this.f9983c = bluetoothDevice;
        this.f9984d = wifiP2pDevice;
        this.e = str;
        this.f9985h = str2;
        this.f9986i = str3;
        this.f9987j = tranConnectionController$P2pDeviceInfo;
        this.f9988k = nearDevice;
    }
}
