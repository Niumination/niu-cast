package se;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class m5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.a0 f9875b;

    public /* synthetic */ m5(com.welink.protocol.nfbd.a0 a0Var, int i8) {
        this.f9874a = i8;
        this.f9875b = a0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h4 h4Var;
        switch (this.f9874a) {
            case 0:
                com.welink.protocol.nfbd.a0 a0Var = this.f9875b;
                h0.a.C(a0Var.f4035d, "Connect has conflict with current device, current state : ", "TranFileReceiveController");
                if (!a0Var.A.isEmpty()) {
                    com.welink.protocol.nfbd.a0.o(a0Var, 13, 0, 4, null, null, 384);
                }
                break;
            case 1:
                com.welink.protocol.nfbd.a0 a0Var2 = this.f9875b;
                BluetoothDevice bluetoothDevice = a0Var2.f;
                a0Var2.f4039j = bluetoothDevice != null ? bluetoothDevice.connectGatt(a0Var2.f4034c, false, a0Var2.P, 2) : null;
                a0Var2.g(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, a0Var2.K);
                a0Var2.f4035d = 1;
                a0Var2.f4040k = 0;
                break;
            case 2:
                Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                Intrinsics.checkNotNullParameter("Service discovery timer timeout, close the connection", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("TranFileReceiveController", "TransConnect:Service discovery timer timeout, close the connection", null);
                }
                this.f9875b.p(false);
                break;
            case 3:
                mg.b0 b0Var = this.f9875b.f4046s;
                if (b0Var != null && b0Var.f8046a) {
                    b0Var.f8046a = false;
                    ((Context) b0Var.f8047b).unregisterReceiver((TranP2pConnectHelper$mP2pStateReceiver$1) b0Var.f);
                    break;
                }
                break;
            case 4:
                we.h.h("TranFileReceiveController", "connect timeout");
                com.welink.protocol.nfbd.a0 a0Var3 = this.f9875b;
                if (a0Var3.f4035d != 0) {
                    a0Var3.m();
                    if (a0Var3.f4035d > 2 && (h4Var = a0Var3.C) != null) {
                        h4Var.o();
                    }
                    a0Var3.f4035d = 0;
                    if (!a0Var3.A.isEmpty()) {
                        com.welink.protocol.nfbd.a0.o(a0Var3, 6, 0, 4, null, null, 384);
                    }
                } else {
                    we.h.h("TranFileReceiveController", "BLE is in idle state, ignore it");
                }
                break;
            case 5:
                com.welink.protocol.nfbd.a0 a0Var4 = this.f9875b;
                h0.a.C(a0Var4.f4035d, "Passive Disconnect timeout current state : ", "TranFileReceiveController");
                a0Var4.f4035d = 0;
                if (!a0Var4.A.isEmpty()) {
                    com.welink.protocol.nfbd.a0.o(a0Var4, 11, 0, 4, null, null, 384);
                }
                break;
            case 6:
                com.welink.protocol.nfbd.a0 a0Var5 = this.f9875b;
                h0.a.C(a0Var5.f4035d, "Passive Terminate Current connection : ", "TranFileReceiveController");
                if (!a0Var5.A.isEmpty()) {
                    com.welink.protocol.nfbd.a0.o(a0Var5, 15, 0, 4, null, null, 448);
                }
                break;
            case 7:
                com.welink.protocol.nfbd.a0 a0Var6 = this.f9875b;
                we.h.b("TranFileReceiveController", "Ble write characteristic timeout: " + a0Var6.f4035d + ", accept: " + a0Var6.f4045r);
                int i8 = a0Var6.f4035d;
                if (i8 == 4 || i8 == 5) {
                    we.h.b("TranFileReceiveController", "P2P connect success already ,ignore this event");
                } else {
                    a0Var6.f4035d = 0;
                    if (!a0Var6.A.isEmpty()) {
                        if (!a0Var6.f4045r) {
                            com.welink.protocol.nfbd.a0.o(a0Var6, 17, 0, 4, null, null, 448);
                        } else {
                            com.welink.protocol.nfbd.a0.o(a0Var6, 16, 0, 4, null, null, 448);
                        }
                    }
                }
                break;
            case 8:
                com.welink.protocol.nfbd.a0 a0Var7 = this.f9875b;
                BluetoothDevice bluetoothDevice2 = a0Var7.f;
                a0Var7.f4039j = bluetoothDevice2 != null ? bluetoothDevice2.connectGatt(a0Var7.f4034c, false, a0Var7.P, 2) : null;
                break;
            default:
                we.h.h("TranFileReceiveController", "onTransferComplete");
                this.f9875b.l(2);
                break;
        }
    }
}
