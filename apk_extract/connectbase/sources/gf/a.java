package gf;

import android.bluetooth.BluetoothA2dp;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

/* JADX INFO: loaded from: classes2.dex */
public interface a {
    BluetoothDevice a(BluetoothA2dp bluetoothA2dp);

    Object b(BluetoothAdapter bluetoothAdapter, int i10);

    boolean c(BluetoothA2dp bluetoothA2dp, BluetoothDevice bluetoothDevice);

    int d(BluetoothAdapter bluetoothAdapter);
}
