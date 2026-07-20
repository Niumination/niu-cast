package se;

import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class r1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f9960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ we.g f9961d;

    public /* synthetic */ r1(we.g gVar, NearDevice nearDevice, boolean z2, int i8) {
        this.f9958a = i8;
        this.f9961d = gVar;
        this.f9959b = nearDevice;
        this.f9960c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DeviceInfo deviceInfo;
        NearDevice nearDevice = this.f9959b;
        we.g gVar = this.f9961d;
        switch (this.f9958a) {
            case 0:
                t1 t1Var = (t1) gVar;
                t1Var.getClass();
                t4 t4VarW = t1.w(nearDevice);
                NearDevice nearDeviceV = t1Var.v(nearDevice, t4VarW);
                if (nearDeviceV == null) {
                    we.h.j("NearDeviceTableFusion", "No device found matching the in table list");
                } else {
                    t1Var.H(nearDeviceV, t4VarW, false, this.f9960c);
                }
                break;
            default:
                com.welink.protocol.nfbd.z zVar = (com.welink.protocol.nfbd.z) gVar;
                zVar.getClass();
                TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo((String) null, 39, 0, 0, 0, nearDevice != null ? new NearDeviceDataParcel(nearDevice, null) : null);
                if (nearDevice != null) {
                    Map map = com.welink.protocol.nfbd.h.f4132a;
                    deviceInfo = new DeviceInfo(com.welink.protocol.nfbd.h.e(nearDevice.f3889j), com.welink.protocol.nfbd.h.g(nearDevice.h()), nearDevice.r(), (String) null, (Boolean) null, (EarBudsInfo) null, com.welink.protocol.nfbd.h.h(nearDevice.f3890k), com.welink.protocol.nfbd.h.d(nearDevice.e), nearDevice.f3887h, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                } else {
                    deviceInfo = new DeviceInfo((byte) 0, (byte) 0, (String) null, (String) null, (Boolean) null, (EarBudsInfo) null, 0, 1, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                }
                TranConnectionController$MessageInfo tranConnectionController$MessageInfo = new TranConnectionController$MessageInfo(null, this.f9960c ? 1 : 0, 0, null, 39, deviceInfo, tranConnectionController$EventInfo, nearDevice != null ? new NearDeviceDataParcel(nearDevice, null) : null);
                we.h.h("TranConnectionManager", "Near device trusted state changed");
                zVar.q(tranConnectionController$MessageInfo, nearDevice);
                break;
        }
    }
}
