package se;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.welink.protocol.nfbd.NearDevice;
import k3.lb;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class n0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.f f9882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ NearDevice f9884d;

    public /* synthetic */ n0(com.welink.protocol.nfbd.f fVar, BluetoothDevice bluetoothDevice, NearDevice nearDevice, int i8) {
        this.f9881a = i8;
        this.f9882b = fVar;
        this.f9883c = bluetoothDevice;
        this.f9884d = nearDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9881a) {
            case 0:
                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                Intrinsics.checkNotNullParameter("Stopping Rfcomm server time out", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothServer", "TransConnect:Stopping Rfcomm server time out", null);
                }
                this.f9882b.v(this.f9883c, this.f9884d);
                break;
            default:
                com.welink.protocol.nfbd.f fVar = this.f9882b;
                fVar.getClass();
                NearDevice nearDevice = this.f9884d;
                BluetoothDevice bluetoothDevice = this.f9883c;
                fVar.f4105j.put(bluetoothDevice.getAddress(), MapsKt.mutableMapOf(new Pair(bluetoothDevice, nearDevice)));
                i2 i2Var = new i2(0, nearDevice, null, null, null);
                fVar.f4107l = i2Var;
                fVar.q();
                h4 h4Var = fVar.f4100c;
                if (h4Var != null && h4Var.q()) {
                    if (h4Var.r()) {
                        we.h.h("NearBluetoothServer", "P2p GO connect over group client recover directly");
                        h4Var.n(i2Var, 2);
                    } else {
                        h4Var.n(i2Var, 2);
                    }
                    fVar.f4110o = true;
                } else if (h4Var != null) {
                    h4Var.m(i2Var, 2);
                }
                break;
        }
    }
}
