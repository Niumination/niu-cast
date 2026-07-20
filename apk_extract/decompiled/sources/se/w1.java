package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class w1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.j f10045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothDevice f10046c;

    public /* synthetic */ w1(com.welink.protocol.nfbd.j jVar, BluetoothDevice bluetoothDevice, int i8) {
        this.f10044a = i8;
        this.f10045b = jVar;
        this.f10046c = bluetoothDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BluetoothGatt bluetoothGatt;
        BluetoothGatt bluetoothGatt2;
        int i8 = 1;
        BluetoothDevice bluetoothDevice = this.f10046c;
        com.welink.protocol.nfbd.j jVar = this.f10045b;
        switch (this.f10044a) {
            case 0:
                jVar.l(bluetoothDevice, jVar.n(bluetoothDevice.getAddress()));
                break;
            default:
                we.h.c("NearGattClient", "onGattConnectTimeout", null);
                x1 x1Var = (x1) jVar.f4134c.remove(bluetoothDevice.getAddress());
                if (x1Var != null && (bluetoothGatt2 = x1Var.f10056b) != null) {
                    bluetoothGatt2.disconnect();
                }
                if (x1Var != null && (bluetoothGatt = x1Var.f10056b) != null) {
                    bluetoothGatt.close();
                }
                int i9 = jVar.q + 1;
                jVar.q = i9;
                h0.a.C(i9, "Retry count: ", "NearGattClient");
                int i10 = jVar.q;
                LinkedHashSet linkedHashSet = jVar.f4136g;
                if (i10 < 3) {
                    if ((x1Var != null ? x1Var.f10057c : null) != null) {
                        BluetoothGatt bluetoothGattConnectGatt = bluetoothDevice.connectGatt(jVar.e, false, jVar.f4150x, 2);
                        if (bluetoothGattConnectGatt == null) {
                            jVar.q = 0;
                            Iterator it = linkedHashSet.iterator();
                            while (it.hasNext()) {
                                ((w) it.next()).b(InputDeviceCompat.SOURCE_TOUCHSCREEN, bluetoothDevice, x1Var.f10057c);
                            }
                        } else {
                            jVar.f4134c.put(bluetoothDevice.getAddress(), new x1(bluetoothDevice, bluetoothGattConnectGatt, x1Var.f10057c));
                            w1 w1Var = new w1(jVar, bluetoothDevice, i8);
                            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                            we.m.a(258, 3000L, jVar.a(), w1Var);
                        }
                    }
                }
                jVar.q = 0;
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((w) it2.next()).b(FragmentTransaction.TRANSIT_FRAGMENT_FADE, bluetoothDevice, x1Var != null ? x1Var.f10057c : null);
                }
                break;
        }
    }
}
