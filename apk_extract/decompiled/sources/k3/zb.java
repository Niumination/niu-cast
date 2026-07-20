package k3;

import android.bluetooth.BluetoothAdapter;
import java.util.LinkedHashMap;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes.dex */
public abstract class zb {
    public static String a(byte b9) {
        int iM177constructorimpl = UByte.m177constructorimpl(b9) & UByte.MAX_VALUE;
        if (iM177constructorimpl == 16) {
            return null;
        }
        if ((17 > iM177constructorimpl || iM177constructorimpl >= 20) && (20 > iM177constructorimpl || iM177constructorimpl >= 256)) {
            return null;
        }
        return "1.0";
    }

    public static LinkedHashMap b(byte[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = data.length;
        BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
        if (length < 2) {
            return null;
        }
        int i8 = 0;
        while (i8 < data.length) {
            BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
            int i9 = i8 + 2;
            if (i9 >= data.length) {
                we.h.j("BleScanTool", "Invalid TLV data, error index");
                if (linkedHashMap.isEmpty()) {
                    return null;
                }
                return linkedHashMap;
            }
            int i10 = i8 + 1;
            byte b9 = data[i8];
            int iCoerceAtLeast = RangesKt.coerceAtLeast(UByte.m177constructorimpl(data[i10]) & UByte.MAX_VALUE, 0);
            if (iCoerceAtLeast < 0 || iCoerceAtLeast > 255) {
                we.h.j("BleScanTool", "Invalid length " + iCoerceAtLeast + " at type " + ((int) b9));
                if (linkedHashMap.isEmpty()) {
                    return null;
                }
                return linkedHashMap;
            }
            int i11 = iCoerceAtLeast + i9;
            if (i11 > data.length) {
                we.h.j("BleScanTool", "Invalid TLV data, error length");
                if (linkedHashMap.isEmpty()) {
                    return null;
                }
                return linkedHashMap;
            }
            linkedHashMap.put(Byte.valueOf(b9), ArraysKt.copyOfRange(data, i9, i11));
            i8 = i11;
        }
        return linkedHashMap;
    }
}
