package se;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import java.util.Map;
import k3.lb;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.l f9728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9729c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9730d;

    public /* synthetic */ e2(com.welink.protocol.nfbd.l lVar, BluetoothDevice bluetoothDevice, NearDevice nearDevice, int i8) {
        this.f9727a = i8;
        this.f9728b = lVar;
        this.f9729c = bluetoothDevice;
        this.f9730d = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9727a) {
            case 0:
                Intrinsics.checkNotNullParameter("NearGattService", "tag");
                Intrinsics.checkNotNullParameter("Stopping GATT server time out", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattService", "TransConnect:Stopping GATT server time out", null);
                }
                this.f9728b.B(this.f9729c, this.f9730d);
                break;
            default:
                com.welink.protocol.nfbd.l lVar = this.f9728b;
                lVar.getClass();
                NearDevice nearDevice = this.f9730d;
                BluetoothDevice bluetoothDevice = this.f9729c;
                Map mapMutableMapOf = MapsKt.mutableMapOf(new Pair(bluetoothDevice, nearDevice));
                Map mapMutableMapOf2 = MapsKt.mutableMapOf(new Pair(bluetoothDevice, null));
                lVar.f4161o.put(bluetoothDevice.getAddress(), mapMutableMapOf);
                lVar.p.put(bluetoothDevice.getAddress(), mapMutableMapOf2);
                i2 i2Var = new i2(0, nearDevice, null, null, null);
                lVar.f4162r = i2Var;
                lVar.r();
                h4 h4Var = lVar.f4164t;
                if (h4Var != null && h4Var.q()) {
                    h4 h4Var2 = lVar.f4164t;
                    if (h4Var2 == null || !h4Var2.r()) {
                        h4 h4Var3 = lVar.f4164t;
                        if (h4Var3 != null) {
                            h4Var3.n(i2Var, 2);
                        }
                    } else {
                        we.h.h("NearGattService", "P2p GO connect over group client recover directly");
                        h4 h4Var4 = lVar.f4164t;
                        if (h4Var4 != null) {
                            h4Var4.n(i2Var, 2);
                        }
                    }
                    lVar.u = true;
                } else {
                    h4 h4Var5 = lVar.f4164t;
                    if (h4Var5 != null) {
                        h4Var5.m(i2Var, 2);
                    }
                }
                break;
        }
    }
}
