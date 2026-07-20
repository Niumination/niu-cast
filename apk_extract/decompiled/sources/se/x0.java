package se;

import android.bluetooth.BluetoothDevice;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import k3.gc;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class x0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f10052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10053c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10054d;
    public final /* synthetic */ Object e;

    public /* synthetic */ x0(int i8, Object obj, Object obj2, int i9, int i10) {
        this.f10051a = i10;
        this.f10054d = obj;
        this.e = obj2;
        this.f10052b = i8;
        this.f10053c = i9;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String error;
        Object obj = this.e;
        Object obj2 = this.f10054d;
        switch (this.f10051a) {
            case 0:
                q5.a aVar = ((z0) obj2).f10076b;
                int i8 = this.f10052b;
                if (i8 == 1) {
                    error = "BLUETOOTH_DISCONNECTED";
                } else if (i8 != 2) {
                    error = i8 != 11 ? "Unknown reason" : "LAN_DISCONNECTED";
                } else {
                    error = "WIFI_P2P_DISCONNECTED";
                }
                NearDevice device = (NearDevice) obj;
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(error, "error");
                gc.c("TranConnectManager", "onNearDeviceDisconnected: mP2pConnecting:" + mc.b.f7969n + ", deviceName:" + device.f3884b + ", " + i8 + ", " + this.f10053c + ", " + error + ", rejectCallback:" + mc.b.f + "disconnectCallback:" + mc.b.e + ", pcDisconnectCallback:" + mc.b.f7963h);
                if (!mc.b.f7969n) {
                    Lazy lazy = mc.b.f7958a;
                    mc.b.g();
                    ag.b bVar = mc.b.f7968m;
                    if (bVar != null) {
                        bVar.invoke(Boolean.TRUE);
                    }
                    mc.b.f7966k = null;
                    mc.b.f7959b = null;
                    Function2 function2 = mc.b.f;
                    if (function2 != null) {
                        function2.invoke(device, Integer.valueOf(i8));
                    }
                    if (mc.b.f == null) {
                        Function2 function3 = mc.b.e;
                        if (function3 != null) {
                            function3.invoke(device, Integer.valueOf(i8));
                        }
                        if (mc.b.e == null) {
                            gc.c("TranConnectManager", "isPcRequestConn3333:true");
                            ag.q qVar = mc.b.f7963h;
                            if (qVar != null) {
                                qVar.invoke(device, Integer.valueOf(i8));
                            }
                        }
                    }
                    break;
                }
                break;
            default:
                BluetoothDevice device2 = (BluetoothDevice) obj2;
                if (device2 != null) {
                    com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) obj;
                    zVar.getClass();
                    Intrinsics.checkNotNullParameter(device2, "device");
                    TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, 0, 0, device2.getName(), 15, new DeviceInfo((byte) 0, (byte) 0, (String) null, device2.getAddress(), (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128), new TranConnectionController$EventInfo(15, (String) null, 0, this.f10052b, this.f10053c, 32), new NearDeviceDataParcel(device2, null));
                    we.h.h("TranConnectionManager", "Receive remote connect request notify");
                    zVar.q(tranConnectionController$MessageInfo, null);
                }
                break;
        }
    }
}
