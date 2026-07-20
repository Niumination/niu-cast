package se;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.util.Log;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.CoroutineLiveDataKt;
import com.welink.protocol.nfbd.NearDevice;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class v1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.welink.protocol.nfbd.j f10027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BluetoothGatt f10028c;

    public /* synthetic */ v1(com.welink.protocol.nfbd.j jVar, BluetoothGatt bluetoothGatt, int i8) {
        this.f10026a = 3;
        this.f10027b = jVar;
        this.f10028c = bluetoothGatt;
    }

    @Override // java.lang.Runnable
    public final void run() {
        BluetoothGatt bluetoothGatt;
        BluetoothGatt bluetoothGatt2;
        byte b9 = 0;
        int i8 = 1;
        com.welink.protocol.nfbd.j jVar = this.f10027b;
        BluetoothGatt bluetoothGatt3 = this.f10028c;
        switch (this.f10026a) {
            case 0:
                Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                Intrinsics.checkNotNullParameter("enableCharacteristicNotificationTimer: enable notify time out", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattClient", "TransConnect:enableCharacteristicNotificationTimer: enable notify time out", null);
                }
                x1 x1Var = (x1) jVar.f4134c.remove(bluetoothGatt3.getDevice().getAddress());
                if (x1Var != null && (bluetoothGatt2 = x1Var.f10056b) != null) {
                    bluetoothGatt2.disconnect();
                }
                if (x1Var != null && (bluetoothGatt = x1Var.f10056b) != null) {
                    bluetoothGatt.close();
                }
                for (w wVar : jVar.f4136g) {
                    BluetoothDevice device = bluetoothGatt3.getDevice();
                    Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
                    wVar.b(FragmentTransaction.TRANSIT_FRAGMENT_OPEN, device, x1Var != null ? x1Var.f10057c : null);
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                Intrinsics.checkNotNullParameter("Service discovery timer timeout, close the connection", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattClient", "TransConnect:Service discovery timer timeout, close the connection", null);
                }
                jVar.getClass();
                bluetoothGatt3.disconnect();
                break;
            case 2:
                we.h.j("NearGattClient", "MTU request timer timeout, start service discovery directly");
                jVar.getClass();
                bluetoothGatt3.discoverServices();
                v1 v1Var = new v1(jVar, bluetoothGatt3, i8, b9);
                ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                we.m.a(260, CoroutineLiveDataKt.DEFAULT_TIMEOUT, jVar.a(), v1Var);
                break;
            case 3:
                jVar.getClass();
                if (we.m.e(260)) {
                    we.m.c(260);
                }
                UUID uuid = c6.e;
                BluetoothGattService bluetoothGattServiceM = com.welink.protocol.nfbd.j.m(bluetoothGatt3, uuid);
                if (bluetoothGattServiceM != null) {
                    BluetoothGattCharacteristic characteristic = bluetoothGattServiceM.getCharacteristic(uuid);
                    if (characteristic != null) {
                        if (jVar.f4134c.get(bluetoothGatt3.getDevice().getAddress()) != null) {
                            BluetoothGattDescriptor descriptor = characteristic.getDescriptor(c6.f);
                            if (descriptor != null) {
                                we.m.a(261, 1000L, jVar.a(), new v1(jVar, bluetoothGatt3, b9, b9));
                                bluetoothGatt3.setCharacteristicNotification(characteristic, true);
                                byte[] bArr = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
                                descriptor.setValue(bArr);
                                if (bArr == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("enableNotification");
                                    bArr = null;
                                }
                                int iWriteDescriptor = bluetoothGatt3.writeDescriptor(descriptor, bArr);
                                if (iWriteDescriptor == 0) {
                                    we.h.h("NearGattClient", "Enable characteristic notification success");
                                } else {
                                    we.h.b("NearGattClient", "writeDescriptor fail, error: " + iWriteDescriptor);
                                    if (we.m.e(261)) {
                                        we.m.c(261);
                                    }
                                    bluetoothGatt3.disconnect();
                                }
                            } else {
                                we.h.j("NearGattClient", "Get descriptor notification uuid 0x2902 failed");
                            }
                        } else {
                            we.h.j("NearGattClient", "GattServer of device " + bluetoothGatt3.getDevice().getName() + " was no found");
                        }
                        bluetoothGatt3.disconnect();
                        we.h.c("NearGattClient", "Enable characteristic notification failed", null);
                    } else {
                        List<BluetoothGattService> services = bluetoothGatt3.getServices();
                        if (services != null && (!services.isEmpty())) {
                            for (BluetoothGattService bluetoothGattService : services) {
                                if (Intrinsics.areEqual(bluetoothGattService.getUuid(), c6.f9688a)) {
                                    Iterator<BluetoothGattCharacteristic> it = bluetoothGattService.getCharacteristics().iterator();
                                    while (it.hasNext()) {
                                        we.h.h("NearGattClient", "dumpDiscoveredServiceCharacteristics: " + it.next().getUuid());
                                    }
                                }
                            }
                        }
                        bluetoothGatt3.disconnect();
                        String mes = "Read characteristic " + c6.e + " is null";
                        Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            h0.a.x("TransConnect:", mes, "NearGattClient", null);
                        }
                    }
                }
                break;
            default:
                we.h.b("NearGattClient", "GATT waiting go created notify timer timeout");
                NearDevice nearDeviceN = jVar.n(bluetoothGatt3.getDevice().getAddress());
                BluetoothDevice device2 = bluetoothGatt3.getDevice();
                Intrinsics.checkNotNullExpressionValue(device2, "getDevice(...)");
                jVar.l(device2, nearDeviceN);
                break;
        }
    }

    public /* synthetic */ v1(com.welink.protocol.nfbd.j jVar, BluetoothGatt bluetoothGatt, int i8, byte b9) {
        this.f10026a = i8;
        this.f10027b = jVar;
        this.f10028c = bluetoothGatt;
    }
}
