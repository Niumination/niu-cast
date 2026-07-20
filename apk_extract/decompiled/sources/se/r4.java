package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.util.Log;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import k3.lb;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r4 implements Function2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.y f9963b;

    public /* synthetic */ r4(com.welink.protocol.nfbd.y yVar, int i8) {
        this.f9962a = i8;
        this.f9963b = yVar;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object result, Object obj) {
        switch (this.f9962a) {
            case 0:
                DeviceInfo deviceInfo = (DeviceInfo) obj;
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(deviceInfo, "deviceInfo");
                if (result instanceof ScanResult) {
                    com.welink.protocol.nfbd.y yVar = this.f9963b;
                    yVar.getClass();
                    yVar.f(new a0.g(deviceInfo, 20, (ScanResult) result, yVar));
                } else {
                    Intrinsics.checkNotNullParameter("Incorrect scan result type, ignore", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", "Incorrect scan result type, ignore", null);
                    }
                }
                break;
            case 1:
                android.net.wifi.ScanResult result2 = (android.net.wifi.ScanResult) result;
                DeviceInfo deviceInfo2 = (DeviceInfo) obj;
                Intrinsics.checkNotNullParameter(result2, "result");
                Intrinsics.checkNotNullParameter(deviceInfo2, "deviceInfo");
                o.d.z("Found device addr = ", deviceInfo2.f4223d, "SmartConnectWrapper");
                com.welink.protocol.nfbd.y yVar2 = this.f9963b;
                yVar2.getClass();
                yVar2.f(new a0.g(deviceInfo2, 21, result2, yVar2));
                break;
            case 2:
                BluetoothDevice device = (BluetoothDevice) result;
                DeviceInfo deviceInfo3 = (DeviceInfo) obj;
                Intrinsics.checkNotNullParameter(device, "device");
                Intrinsics.checkNotNullParameter(deviceInfo3, "deviceInfo");
                o.d.z("Found device address = ", deviceInfo3.f4223d, "SmartConnectWrapper");
                com.welink.protocol.nfbd.y yVar3 = this.f9963b;
                yVar3.getClass();
                yVar3.f(new a0.g(deviceInfo3, 19, device, yVar3));
                break;
            default:
                TranConnectionController$MessageInfo msgInfo = (TranConnectionController$MessageInfo) result;
                boolean zBooleanValue = ((Boolean) obj).booleanValue();
                Intrinsics.checkNotNullParameter(msgInfo, "msgInfo");
                com.welink.protocol.nfbd.y yVar4 = this.f9963b;
                if (zBooleanValue) {
                    we.h.b("SmartConnectWrapper", "Found MDNS device, msgInfo = " + msgInfo);
                    yVar4.getClass();
                    yVar4.f(new s4(msgInfo, yVar4, 1));
                } else {
                    we.h.b("SmartConnectWrapper", "Lost MDNS device");
                    yVar4.getClass();
                    yVar4.f(new s4(msgInfo, yVar4, 0));
                }
                break;
        }
        return Unit.INSTANCE;
    }
}
