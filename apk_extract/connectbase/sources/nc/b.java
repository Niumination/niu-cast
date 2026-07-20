package nc;

import android.bluetooth.BluetoothDevice;
import com.transsion.hubsdk.bluetooth.TranBluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public class b implements gf.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f11443b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TranBluetoothDevice f11444a = new TranBluetoothDevice();

    @Override // gf.b
    public boolean a(BluetoothDevice bluetoothDevice) {
        return this.f11444a.removeBond(bluetoothDevice);
    }

    @Override // gf.b
    public boolean b(BluetoothDevice bluetoothDevice) {
        return this.f11444a.isConnected(bluetoothDevice);
    }

    @Override // gf.b
    public boolean c(BluetoothDevice bluetoothDevice, int i10) {
        return this.f11444a.createBond(bluetoothDevice, i10);
    }

    @Override // gf.b
    public boolean d(BluetoothDevice bluetoothDevice) {
        return this.f11444a.cancelBondProcess(bluetoothDevice);
    }

    @Override // gf.b
    public boolean e(BluetoothDevice bluetoothDevice) {
        return this.f11444a.createBond(bluetoothDevice);
    }

    @Override // gf.b
    public int f(BluetoothDevice bluetoothDevice) {
        return this.f11444a.getBatteryLevel(bluetoothDevice);
    }
}
