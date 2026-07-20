package nc;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.android.internal.annotations.VisibleForTesting;
import com.transsion.hubsdk.bluetooth.TranBluetoothA2dp;
import dc.e;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gf.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11441b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranBluetoothA2dp f11442a = new TranBluetoothA2dp();

    @Override // gf.a
    public BluetoothDevice a(BluetoothA2dp bluetoothA2dp) {
        TranBluetoothA2dp tranBluetoothA2dp = this.f11442a;
        if (tranBluetoothA2dp == null) {
            return null;
        }
        try {
            return tranBluetoothA2dp.getActiveDevice(bluetoothA2dp);
        } catch (RuntimeException e10) {
            e.c(f11441b, "getActiveDevice fail " + e10);
            return null;
        }
    }

    @Override // gf.a
    public Object b(BluetoothAdapter bluetoothAdapter, int i10) {
        TranBluetoothA2dp tranBluetoothA2dp = this.f11442a;
        if (tranBluetoothA2dp != null) {
            try {
                return Integer.valueOf(tranBluetoothA2dp.setScanMode(bluetoothAdapter, i10));
            } catch (RuntimeException e10) {
                e.c(f11441b, "setScanMode fail " + e10);
            }
        }
        return -1;
    }

    @Override // gf.a
    public boolean c(BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        TranBluetoothA2dp tranBluetoothA2dp = this.f11442a;
        if (tranBluetoothA2dp == null) {
            return false;
        }
        try {
            return tranBluetoothA2dp.connect(bluetoothA2dp, bluetoothDevice);
        } catch (RuntimeException e10) {
            e.c(f11441b, "connect fail " + e10);
            return false;
        }
    }

    @Override // gf.a
    public int d(BluetoothAdapter bluetoothAdapter) {
        return new TranBluetoothA2dp().getConnectionStateFromAdapter(bluetoothAdapter);
    }

    @VisibleForTesting
    public void e(TranBluetoothA2dp tranBluetoothA2dp) {
        this.f11442a = tranBluetoothA2dp;
    }
}
