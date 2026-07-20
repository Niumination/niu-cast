package se;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.util.Log;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import java.util.HashMap;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class o5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.b0 f9926b;

    public /* synthetic */ o5(com.welink.protocol.nfbd.b0 b0Var, int i8) {
        this.f9925a = i8;
        this.f9926b = b0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9925a) {
            case 0:
                com.welink.protocol.nfbd.b0 b0Var = this.f9926b;
                h0.a.C(b0Var.f4054d, "Connect request didn't found device, current state : ", "TranFileSendController");
                if (!b0Var.p.isEmpty()) {
                    com.welink.protocol.nfbd.b0.n(b0Var, 14, 4, 384);
                }
                break;
            case 1:
                we.h.b("TranFileSendController", "onTransferComplete");
                this.f9926b.k(2);
                break;
            case 2:
                Intrinsics.checkNotNullParameter("TranFileSendController", "tag");
                Intrinsics.checkNotNullParameter("Service discovery timer timeout, close the connection", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("TranFileSendController", "TransConnect:Service discovery timer timeout, close the connection", null);
                }
                this.f9926b.o(false);
                break;
            case 3:
                mg.b0 b0Var2 = this.f9926b.C;
                if (b0Var2 != null && b0Var2.f8046a) {
                    b0Var2.f8046a = false;
                    ((Context) b0Var2.f8047b).unregisterReceiver((TranP2pConnectHelper$mP2pStateReceiver$1) b0Var2.f);
                    break;
                }
                break;
            case 4:
                com.welink.protocol.nfbd.b0 b0Var3 = this.f9926b;
                we.h.b("TranFileSendController", "ble connect timeout current state : " + b0Var3.f4054d);
                b0Var3.s(0);
                break;
            case 5:
                com.welink.protocol.nfbd.b0 b0Var4 = this.f9926b;
                we.h.b("TranFileSendController", "connect timeout current state : " + b0Var4.f4054d);
                b0Var4.s(1);
                break;
            case 6:
                com.welink.protocol.nfbd.b0 b0Var5 = this.f9926b;
                we.h.b("TranFileSendController", "connect reject current state : " + b0Var5.f4054d);
                b0Var5.s(2);
                break;
            case 7:
                com.welink.protocol.nfbd.b0 b0Var6 = this.f9926b;
                h0.a.C(b0Var6.f4054d, "Active Disconnect timeout current state : ", "TranFileSendController");
                b0Var6.f4054d = 0;
                if (!b0Var6.p.isEmpty()) {
                    com.welink.protocol.nfbd.b0.n(b0Var6, 11, 4, 384);
                }
                break;
            case 8:
                com.welink.protocol.nfbd.b0 b0Var7 = this.f9926b;
                h0.a.C(b0Var7.f4054d, "Ble write characteristic timeout: ", "TranFileSendController");
                if (b0Var7.f4054d == 4 || b0Var7.f4054d == 5) {
                    we.h.b("TranFileSendController", "P2P connect success already ,ignore this event");
                } else {
                    b0Var7.f4054d = 0;
                    if (!b0Var7.p.isEmpty()) {
                        if (b0Var7.f4068w) {
                            com.welink.protocol.nfbd.b0.n(b0Var7, 17, 4, 384);
                        } else {
                            com.welink.protocol.nfbd.b0.n(b0Var7, 16, 4, 384);
                        }
                    }
                    b0Var7.l();
                }
                break;
            case 9:
                com.welink.protocol.nfbd.b0 b0Var8 = this.f9926b;
                h0.a.C(b0Var8.f4054d, "Active Terminate Current connection : ", "TranFileSendController");
                if (!b0Var8.p.isEmpty()) {
                    com.welink.protocol.nfbd.b0.n(b0Var8, 15, 4, 384);
                }
                break;
            case 10:
                com.welink.protocol.nfbd.b0 b0Var9 = this.f9926b;
                String str = b0Var9.f4059k;
                if (str != null) {
                    HashMap map = b0Var9.e;
                    if (map.get(str) != null) {
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) map.get(b0Var9.f4059k);
                        b0Var9.f4060l = bluetoothDevice != null ? bluetoothDevice.connectGatt(b0Var9.f4053c, false, b0Var9.P, 2) : null;
                    }
                }
                break;
            default:
                com.welink.protocol.nfbd.b0 b0Var10 = this.f9926b;
                we.h.b("TranFileSendController", "onTransferCancel");
                if (b0Var10.f4069x) {
                    b0Var10.t(b0Var10.f4060l);
                }
                if (b0Var10.f4060l != null) {
                    b0Var10.f4068w = true;
                }
                break;
        }
    }
}
