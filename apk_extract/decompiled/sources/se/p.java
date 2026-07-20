package se;

import android.content.Intent;
import android.util.SparseArray;
import com.welink.protocol.nfbd.NearDevice;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class p implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Pair f9928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f9930d;

    public /* synthetic */ p(Pair pair, NearDevice nearDevice, boolean z2, int i8) {
        this.f9927a = i8;
        this.f9928b = pair;
        this.f9929c = nearDevice;
        this.f9930d = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9927a) {
            case 0:
                e1 e1Var = (e1) this.f9928b.getSecond();
                NearDevice device = this.f9929c;
                e1Var.getClass();
                Intrinsics.checkNotNullParameter(device, "device");
                com.welink.protocol.nfbd.g gVar = e1Var.f9726b;
                gVar.getClass();
                Intent intent = new Intent("com.welink.service.ACTION_NEAR_DEVICE_TRUSTED");
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device);
                intent.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_TRUSTED", this.f9930d);
                gVar.f4112b.j(intent);
                break;
            case 1:
                e1 e1Var2 = (e1) this.f9928b.getSecond();
                NearDevice device2 = this.f9929c;
                e1Var2.getClass();
                Intrinsics.checkNotNullParameter(device2, "device");
                com.welink.protocol.nfbd.g gVar2 = e1Var2.f9726b;
                gVar2.getClass();
                Intent intent2 = new Intent("com.welink.service.ACTION_NEAR_DEVICE_TRUSTED");
                intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device2);
                intent2.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_TRUSTED", this.f9930d);
                gVar2.f4112b.j(intent2);
                break;
            case 2:
                Pair pair = this.f9928b;
                NearDevice device3 = this.f9929c;
                boolean z2 = this.f9930d;
                u4 u4Var = (u4) pair.getSecond();
                u4Var.getClass();
                Intrinsics.checkNotNullParameter(device3, "device");
                u4Var.f10016a.f4196j.add(device3);
                e eVar = u4Var.f10016a.f4201o;
                if (eVar != null) {
                    Intrinsics.checkNotNullParameter(device3, "device");
                    b1 b1Var = (b1) eVar.f9720b;
                    b1Var.f9654b.add(device3);
                    we.h.b("NearConnectionManager", "device found: " + device3);
                    SparseArray sparseArray = b1Var.f9653a;
                    int size = sparseArray.size();
                    for (int i8 = 0; i8 < size; i8++) {
                        z0 z0Var = (z0) sparseArray.valueAt(i8);
                        z0Var.getClass();
                        Intrinsics.checkNotNullParameter(device3, "device");
                        int i9 = device3.f3890k;
                        if ((i9 == 11 || i9 == 10) && device3.e == 1) {
                            we.h.j("NearConnectionManager", "Ignore NFC/QR device found report for file transfer device");
                        } else {
                            z0Var.f10075a.execute(new w0(z0Var, device3, 5, (byte) 0));
                        }
                    }
                }
                if (z2) {
                    if (device3.e == 0 && device3.f3890k == 0) {
                        we.h.h("SmartConnectWrapper", h0.a.l("Invited Device Found: ", device3.f3883a, ", ", device3.f3884b, ", send screen cast request"));
                        com.welink.protocol.nfbd.y.o(u4Var.f10016a, device3);
                    } else {
                        we.h.h("SmartConnectWrapper", h0.a.l("Invited Device Found: ", device3.f3883a, ", ", device3.f3884b, ", send exchange request"));
                        e eVar2 = u4Var.f10016a.f4201o;
                        if (eVar2 != null) {
                            eVar2.w(device3);
                        }
                    }
                }
                break;
            default:
                e1 e1Var3 = (e1) this.f9928b.getSecond();
                NearDevice device4 = this.f9929c;
                e1Var3.getClass();
                Intrinsics.checkNotNullParameter(device4, "device");
                com.welink.protocol.nfbd.g gVar3 = e1Var3.f9726b;
                gVar3.getClass();
                Intent intent3 = new Intent("com.welink.service.ACTION_NEAR_DEVICE_TRUSTED");
                intent3.putExtra("com.welink.service.EXTRA_NEAR_DEVICE", device4);
                intent3.putExtra("com.welink.service.EXTRA_NEAR_DEVICE_TRUSTED", this.f9930d);
                gVar3.f4112b.j(intent3);
                break;
        }
    }
}
