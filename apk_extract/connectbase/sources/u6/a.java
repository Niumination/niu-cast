package u6;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public class a implements gf.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f16209a = cc.a.a("android.app.BluetoothA2dp");

    @Override // gf.a
    public BluetoothDevice a(BluetoothA2dp bluetoothA2dp) {
        Object objJ = cc.a.j(cc.a.g(f16209a, "getActiveDevice", new Class[0]), bluetoothA2dp, new Object[0]);
        if (objJ instanceof BluetoothDevice) {
            return (BluetoothDevice) objJ;
        }
        return null;
    }

    @Override // gf.a
    public Object b(BluetoothAdapter bluetoothAdapter, int i10) {
        return cc.a.j(cc.a.g(bluetoothAdapter.getClass(), "setScanMode", Integer.TYPE), bluetoothAdapter, Integer.valueOf(i10));
    }

    @Override // gf.a
    public boolean c(BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice) {
        Object objJ = cc.a.j(cc.a.g(f16209a, "connect", new Class[0]), bluetoothA2dp, bluetoothDevice);
        if (objJ instanceof Boolean) {
            return ((Boolean) objJ).booleanValue();
        }
        return false;
    }

    @Override // gf.a
    public int d(BluetoothAdapter bluetoothAdapter) {
        Object objJ = cc.a.j(cc.a.g(bluetoothAdapter.getClass(), "getConnectionState", new Class[0]), bluetoothAdapter, new Object[0]);
        if (objJ instanceof Integer) {
            return ((Integer) objJ).intValue();
        }
        return 0;
    }
}
