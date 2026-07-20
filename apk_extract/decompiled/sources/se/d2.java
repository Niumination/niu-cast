package se;

import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9702a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.l f9703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f9704c;

    public /* synthetic */ d2(BluetoothDevice bluetoothDevice, com.welink.protocol.nfbd.l lVar) {
        this.f9704c = bluetoothDevice;
        this.f9703b = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f9702a) {
            case 0:
                StringBuilder sb2 = new StringBuilder("Device handshake timer expired, disconnecting device: ");
                BluetoothDevice bluetoothDevice = this.f9704c;
                sb2.append(bluetoothDevice);
                we.h.b("NearGattService", sb2.toString());
                this.f9703b.m(bluetoothDevice);
                break;
            default:
                we.h.b("NearGattService", "GATT waiting response timer timeout");
                this.f9703b.m(this.f9704c);
                break;
        }
    }

    public /* synthetic */ d2(com.welink.protocol.nfbd.l lVar, BluetoothDevice bluetoothDevice) {
        this.f9703b = lVar;
        this.f9704c = bluetoothDevice;
    }
}
