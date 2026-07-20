package j7;

import android.bluetooth.BluetoothDevice;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.video.VideoCapture;
import androidx.camera.video.impl.VideoCaptureConfig;
import com.transsion.atomiccore.hostsdk.utils.AtomicCoreUtils;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import com.welink.protocol.nfbd.h;
import com.welink.protocol.nfbd.z;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import se.e1;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f6128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6130d;
    public final /* synthetic */ Object e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6131h;

    public /* synthetic */ a(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, int i8) {
        this.f6127a = i8;
        this.f6128b = obj;
        this.f6129c = obj2;
        this.f6130d = obj3;
        this.e = obj4;
        this.f6131h = obj5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceInfo deviceInfo;
        String name;
        String name2;
        String address;
        Object obj = this.f6131h;
        Object obj2 = this.e;
        Object obj3 = this.f6128b;
        Object obj4 = this.f6130d;
        Object obj5 = this.f6129c;
        switch (this.f6127a) {
            case 0:
                AtomicCoreUtils.updateAllCardData$lambda$35((f7.a) obj3, (JSONObject) obj5, (JSONObject) obj4, (Bundle) obj2, (String) obj);
                break;
            case 1:
                ((e1) ((Pair) obj3).getSecond()).i((BluetoothDevice) obj5, (WifiP2pDevice) obj4, (NearDevice) obj2, (TranConnectionController$P2pDeviceInfo) obj);
                break;
            case 2:
                WifiP2pDevice p2pDevice = (WifiP2pDevice) obj3;
                if (p2pDevice != null) {
                    z zVar = (z) obj5;
                    zVar.getClass();
                    Intrinsics.checkNotNullParameter(p2pDevice, "p2pDevice");
                    NearDevice nearDevice = (NearDevice) obj2;
                    TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 20, 0, 0, 0, new NearDeviceDataParcel(p2pDevice, nearDevice));
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) obj4;
                    int i8 = bluetoothDevice != null ? 0 : 3;
                    if (nearDevice != null) {
                        Map map = h.f4132a;
                        byte bE = h.e(nearDevice.f3889j);
                        byte bG = h.g(nearDevice.h());
                        if ((bluetoothDevice == null || (name2 = bluetoothDevice.getName()) == null) && (name2 = p2pDevice.deviceName) == null) {
                            name2 = nearDevice.f3884b;
                        }
                        String str = name2;
                        if ((bluetoothDevice == null || (address = bluetoothDevice.getAddress()) == null) && (address = p2pDevice.deviceAddress) == null) {
                            address = nearDevice.f3883a;
                        }
                        deviceInfo = new DeviceInfo(bE, bG, str, address, (Boolean) null, (EarBudsInfo) null, i8, h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    } else {
                        deviceInfo = new DeviceInfo((byte) 0, (byte) 0, p2pDevice.deviceName, p2pDevice.deviceAddress, (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                    }
                    DeviceInfo deviceInfo2 = deviceInfo;
                    if ((bluetoothDevice == null || (name = bluetoothDevice.getName()) == null) && (name = p2pDevice.deviceName) == null) {
                        name = nearDevice != null ? nearDevice.f3884b : null;
                    }
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, name, 20, deviceInfo2, tranConnectionController$EventInfo, bluetoothDevice != null ? new NearDeviceDataParcel(bluetoothDevice, nearDevice) : new NearDeviceDataParcel(p2pDevice, (TranConnectionController$P2pDeviceInfo) obj));
                    we.h.h("TranConnectionManager", "P2p owner available");
                    zVar.q(tranConnectionController$MessageInfo, nearDevice);
                }
                break;
            default:
                ((VideoCapture) obj3).lambda$createPipeline$1((SurfaceEdge) obj5, (CameraInternal) obj4, (VideoCaptureConfig) obj2, (Timebase) obj);
                break;
        }
    }
}
