package u6;

import android.bluetooth.BluetoothDevice;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public class b implements gf.b {
    @Override // gf.b
    public boolean a(BluetoothDevice bluetoothDevice) {
        Object objJ = cc.a.j(cc.a.g(bluetoothDevice.getClass(), "removeBond", new Class[0]), bluetoothDevice, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // gf.b
    public boolean b(BluetoothDevice bluetoothDevice) {
        Object objJ = cc.a.j(cc.a.g(bluetoothDevice.getClass(), "isConnected", new Class[0]), bluetoothDevice, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // gf.b
    public boolean c(BluetoothDevice bluetoothDevice, int i10) {
        Object objJ = cc.a.j(cc.a.g(bluetoothDevice.getClass(), "createBond", Integer.TYPE), bluetoothDevice, Integer.valueOf(i10));
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // gf.b
    public boolean d(BluetoothDevice bluetoothDevice) {
        Method methodG = cc.a.g(bluetoothDevice.getClass(), "cancelBondProcess", new Class[0]);
        if (methodG == null) {
            return false;
        }
        Object objJ = cc.a.j(methodG, bluetoothDevice, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // gf.b
    public boolean e(BluetoothDevice bluetoothDevice) {
        Object objJ = cc.a.j(cc.a.g(bluetoothDevice.getClass(), "createBond", new Class[0]), bluetoothDevice, new Object[0]);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // gf.b
    public int f(BluetoothDevice bluetoothDevice) {
        Object objJ = cc.a.j(cc.a.g(bluetoothDevice.getClass(), "getBatteryLevel", new Class[0]), bluetoothDevice, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }
}
