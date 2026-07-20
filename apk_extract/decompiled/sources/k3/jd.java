package k3;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class jd {
    public static byte[] a(String address) {
        Intrinsics.checkNotNullParameter(address, "address");
        byte[] bArr = new byte[6];
        int i8 = 0;
        int i9 = 0;
        while (i8 < address.length()) {
            if (address.charAt(i8) != ':') {
                String strSubstring = address.substring(i8, i8 + 2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                bArr[i9] = (byte) Integer.parseInt(strSubstring, CharsKt.checkRadix(16));
                i9++;
                i8++;
            }
            i8++;
        }
        return bArr;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0051  */
    /* JADX WARN: Code duplicated, block: B:22:0x005d  */
    /* JADX WARN: Code duplicated, block: B:27:0x0075 A[EDGE_INSN: B:27:0x0075->B:28:0x0076 BREAK  A[LOOP:2: B:20:0x0057->B:52:0x0057]] */
    /* JADX WARN: Code duplicated, block: B:49:0x0075 A[SYNTHETIC] */
    public static BluetoothGattCharacteristic b(BluetoothGatt bluetoothGatt, UUID uuid) {
        BluetoothGattService bluetoothGattService;
        Iterator<T> it;
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        if (bluetoothGatt == null) {
            we.h.g("GATT NULL");
            return null;
        }
        UUID uuid2 = se.z6.f10087c.getUuid();
        Intrinsics.checkNotNullExpressionValue(uuid2, "getUuid(...)");
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        if (services == null) {
            if (services != null) {
                bluetoothGattService = null;
                break;
            }
            it = services.iterator();
            while (true) {
                if (it.hasNext()) {
                    bluetoothGattService = null;
                    break;
                }
                bluetoothGattService = (BluetoothGattService) it.next();
                if (!Intrinsics.areEqual(bluetoothGattService.getUuid(), uuid2)) {
                }
            }
        } else {
            Iterator<T> it2 = services.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    if (services != null) {
                        bluetoothGattService = null;
                        break;
                    }
                    it = services.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            bluetoothGattService = null;
                            break;
                        }
                        bluetoothGattService = (BluetoothGattService) it.next();
                        if (!Intrinsics.areEqual(bluetoothGattService.getUuid(), uuid2) && bluetoothGattService.getCharacteristic(uuid) != null) {
                            break;
                        }
                    }
                } else {
                    bluetoothGattService = (BluetoothGattService) it2.next();
                    if (!Intrinsics.areEqual(bluetoothGattService.getUuid(), uuid2) || bluetoothGattService.getCharacteristic(uuid) == null || bluetoothGattService.getCharacteristics().size() > 3) {
                    }
                }
            }
        }
        if (bluetoothGattService == null) {
            we.h.g("GATT Service NULL");
            return null;
        }
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
        for (BluetoothGattCharacteristic bluetoothGattCharacteristic : characteristics) {
            we.h.g("characteristic : " + bluetoothGattCharacteristic.getUuid());
            if (Intrinsics.areEqual(bluetoothGattCharacteristic.getUuid(), uuid)) {
                return bluetoothGattCharacteristic;
            }
        }
        return null;
    }
}
