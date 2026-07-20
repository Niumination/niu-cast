package m9;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import dc.e;
import gm.i;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f10609c = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nc.a f10610a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public u6.a f10611b;

    @yb.a(level = 1)
    public boolean a(@i BluetoothA2dp bluetoothA2dp, @i BluetoothDevice bluetoothDevice) {
        if (bluetoothA2dp == null || bluetoothDevice == null) {
            throw new IllegalArgumentException("parameter must not be null.");
        }
        return d(fc.b.a.f5987g).c(bluetoothA2dp, bluetoothDevice);
    }

    @yb.a(level = 1)
    public BluetoothDevice b(BluetoothA2dp bluetoothA2dp) {
        return d(fc.b.a.f5987g).a(bluetoothA2dp);
    }

    public int c(BluetoothAdapter bluetoothAdapter) {
        return d(fc.b.a.f5987g).d(bluetoothAdapter);
    }

    public gf.a d(String str) {
        if (fc.b.b(str)) {
            e.f(f10609c, "TranThubBluetoothA2dp");
            nc.a aVar = this.f10610a;
            if (aVar != null) {
                return aVar;
            }
            nc.a aVar2 = new nc.a();
            this.f10610a = aVar2;
            return aVar2;
        }
        e.f(f10609c, "TranAospBluetoothA2dp");
        u6.a aVar3 = this.f10611b;
        if (aVar3 != null) {
            return aVar3;
        }
        u6.a aVar4 = new u6.a();
        this.f10611b = aVar4;
        return aVar4;
    }

    @yb.a(level = 1)
    public Object e(BluetoothAdapter bluetoothAdapter, int i10) {
        return d(fc.b.a.f5989i).b(bluetoothAdapter, i10);
    }
}
