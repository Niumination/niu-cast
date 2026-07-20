package m9;

import android.bluetooth.BluetoothDevice;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10612c = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nc.b f10613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u6.b f10614b;

    public boolean a(BluetoothDevice bluetoothDevice) {
        if (bluetoothDevice != null) {
            return e(fc.b.a.f5999s).d(bluetoothDevice);
        }
        throw new NullPointerException("device cannot be null");
    }

    public boolean b(BluetoothDevice bluetoothDevice) {
        return e(fc.b.a.f5987g).e(bluetoothDevice);
    }

    public boolean c(BluetoothDevice bluetoothDevice, int i10) {
        return e(fc.b.a.f5988h).c(bluetoothDevice, i10);
    }

    public int d(BluetoothDevice bluetoothDevice) {
        return e(fc.b.a.f5987g).f(bluetoothDevice);
    }

    public gf.b e(String str) {
        if (fc.b.b(str)) {
            e.f(f10612c, "TranThubBluetoothDevice");
            nc.b bVar = this.f10613a;
            if (bVar != null) {
                return bVar;
            }
            nc.b bVar2 = new nc.b();
            this.f10613a = bVar2;
            return bVar2;
        }
        e.f(f10612c, "TranAospBluetoothDevice");
        u6.b bVar3 = this.f10614b;
        if (bVar3 != null) {
            return bVar3;
        }
        u6.b bVar4 = new u6.b();
        this.f10614b = bVar4;
        return bVar4;
    }

    public boolean f(BluetoothDevice bluetoothDevice) {
        return e(fc.b.a.f5985e).b(bluetoothDevice);
    }

    @yb.a(level = 1)
    public boolean g(BluetoothDevice bluetoothDevice) {
        return e(fc.b.a.f5987g).a(bluetoothDevice);
    }
}
