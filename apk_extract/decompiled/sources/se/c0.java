package se;

import android.bluetooth.BluetoothDevice;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9680a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.c f9681b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9682c;

    public /* synthetic */ c0(com.welink.protocol.nfbd.c cVar, BluetoothDevice bluetoothDevice, int i8) {
        this.f9680a = i8;
        this.f9681b = cVar;
        this.f9682c = bluetoothDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9680a) {
            case 0:
                we.h.b("NearBluetoothClient", "Bluetooth waiting go created notify timer timeout");
                this.f9681b.n(this.f9682c, null);
                break;
            default:
                com.welink.protocol.nfbd.c cVar = this.f9681b;
                LinkedHashMap linkedHashMap = cVar.p;
                BluetoothDevice bluetoothDevice = this.f9682c;
                linkedHashMap.put(bluetoothDevice.getAddress(), bluetoothDevice);
                i2 i2Var = new i2(0, cVar.o(bluetoothDevice.getAddress()), null, null, null);
                cVar.t();
                h4 h4Var = cVar.f4073c;
                if (h4Var != null && h4Var.q()) {
                    if (h4Var.r()) {
                        we.h.h("NearBluetoothClient", "P2p GO connect over group client recover directly");
                        h4Var.n(i2Var, 2);
                    } else {
                        h4Var.n(i2Var, 2);
                    }
                    cVar.e = true;
                } else if (h4Var != null) {
                    h4Var.m(i2Var, 2);
                }
                break;
        }
    }
}
