package se;

import android.os.Parcelable;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$MessageInfo;
import com.welink.protocol.utils.DeviceInfo;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class s4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TranConnectionController$MessageInfo f9974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.y f9975c;

    public /* synthetic */ s4(com.welink.protocol.nfbd.y yVar, TranConnectionController$MessageInfo tranConnectionController$MessageInfo) {
        this.f9973a = 2;
        this.f9975c = yVar;
        this.f9974b = tranConnectionController$MessageInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TranConnectionController$MessageInfo tranConnectionController$MessageInfo = this.f9974b;
        com.welink.protocol.nfbd.y yVar = this.f9975c;
        switch (this.f9973a) {
            case 0:
                we.h.h("SmartConnectWrapper", "Notify lanScanResults Lost");
                TranConnectionController$EventInfo tranConnectionController$EventInfo = tranConnectionController$MessageInfo.f3974i;
                DeviceInfo deviceInfo = tranConnectionController$MessageInfo.f3973h;
                if (deviceInfo != null && tranConnectionController$EventInfo != null) {
                    NearDeviceDataParcel nearDeviceDataParcel = tranConnectionController$EventInfo.f3968h;
                    if ((nearDeviceDataParcel != null ? (Parcelable) nearDeviceDataParcel.f3903a : null) instanceof LanNetworkInfo) {
                        Object obj = nearDeviceDataParcel.f3903a;
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.welink.protocol.utils.LanNetworkInfo");
                        Map map = com.welink.protocol.nfbd.h.f4132a;
                        NearDevice nearDeviceB = com.welink.protocol.nfbd.h.b(deviceInfo, null, null, tranConnectionController$MessageInfo.f3972d, (LanNetworkInfo) obj);
                        t4 t4Var = t4.LE_DEVICE;
                        yVar.f4195i.G(nearDeviceB, true);
                    }
                    break;
                }
                break;
            case 1:
                we.h.h("SmartConnectWrapper", "Notify lanScanResults");
                TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$MessageInfo.f3974i;
                DeviceInfo deviceInfo2 = tranConnectionController$MessageInfo.f3973h;
                if (deviceInfo2 != null && tranConnectionController$EventInfo2 != null) {
                    NearDeviceDataParcel nearDeviceDataParcel2 = tranConnectionController$EventInfo2.f3968h;
                    if ((nearDeviceDataParcel2 != null ? (Parcelable) nearDeviceDataParcel2.f3903a : null) instanceof LanNetworkInfo) {
                        Object obj2 = nearDeviceDataParcel2.f3903a;
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.welink.protocol.utils.LanNetworkInfo");
                        Map map2 = com.welink.protocol.nfbd.h.f4132a;
                        NearDevice nearDeviceB2 = com.welink.protocol.nfbd.h.b(deviceInfo2, null, null, tranConnectionController$MessageInfo.f3972d, (LanNetworkInfo) obj2);
                        if (tranConnectionController$MessageInfo.f3974i.f3966c != 1) {
                            t4 t4Var2 = t4.LE_DEVICE;
                            yVar.f4195i.G(nearDeviceB2, true);
                        } else {
                            yVar.f4195i.k(nearDeviceB2, t4.MDNS_DEVICE, true, false);
                        }
                    }
                    break;
                }
                break;
            default:
                yVar.B(tranConnectionController$MessageInfo);
                break;
        }
    }

    public /* synthetic */ s4(TranConnectionController$MessageInfo tranConnectionController$MessageInfo, com.welink.protocol.nfbd.y yVar, int i8) {
        this.f9973a = i8;
        this.f9974b = tranConnectionController$MessageInfo;
        this.f9975c = yVar;
    }
}
