package se;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f9637a = 23;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f9638b = new HashMap();

    public static boolean a(String deviceAddr, byte[] value) {
        Intrinsics.checkNotNullParameter(deviceAddr, "deviceAddr");
        Intrinsics.checkNotNullParameter(value, "value");
        byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.slice(value, new IntRange(0, 1)));
        int i8 = byteArray[0] << 8;
        int i9 = byteArray[1];
        int i10 = i8 + i9;
        if (i10 < 0) {
            i10 = i8 + 65536 + i9;
        }
        byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.slice(value, new IntRange(2, 3)));
        int i11 = byteArray2[0] << 8;
        byte b9 = byteArray2[1];
        int i12 = i11 + b9;
        if (i12 < 0) {
            i12 = i11 + 65536 + b9;
        }
        byte[] byteArray3 = CollectionsKt.toByteArray(ArraysKt.slice(value, RangesKt.until(4, value.length)));
        byte[][] bArr = new byte[i10][];
        HashMap map = f9638b;
        if (map.containsKey(deviceAddr)) {
            Object obj = map.get(deviceAddr);
            Intrinsics.checkNotNull(obj);
            bArr = (byte[][]) obj;
        }
        bArr[i12] = byteArray3;
        map.put(deviceAddr, bArr);
        return i10 == ArraysKt.filterNotNull(bArr).size();
    }

    public static String b(byte[] bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.slice(bytes, new IntRange(0, 1)));
        int i8 = byteArray[0] << 8;
        byte b9 = byteArray[1];
        int i9 = i8 + b9;
        if (i9 < 0) {
            i9 = i8 + 65536 + b9;
        }
        byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.slice(bytes, new IntRange(2, 3)));
        int i10 = byteArray2[0] << 8;
        byte b10 = byteArray2[1];
        int i11 = i10 + b10;
        if (i11 < 0) {
            i11 = i10 + 65536 + b10;
        }
        String str = i9 == i11 + 1 ? "complete" : "incomplete";
        StringBuilder sbR = o.d.r(i11, i9, "Current chunk: ", "/", ", Status: ");
        sbR.append(str);
        return sbR.toString();
    }

    public static byte[] c(String deviceAddr) {
        Intrinsics.checkNotNullParameter(deviceAddr, "deviceAddr");
        HashMap map = f9638b;
        byte[][] bArr = (byte[][]) map.get(deviceAddr);
        if (bArr == null) {
            return null;
        }
        byte[] bArrPlus = new byte[0];
        for (byte[] bArr2 : bArr) {
            if (bArr2 != null) {
                bArrPlus = ArraysKt.plus(bArrPlus, bArr2);
            }
        }
        map.remove(deviceAddr);
        return bArrPlus;
    }

    public static byte[][] d(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        int i8 = f9637a - 20;
        List listChunked = CollectionsKt.chunked(ArraysKt.toList(byteArray), i8);
        int size = listChunked.size();
        byte[][] bArr = new byte[size][];
        Log.d("BlePacketUtils", "totalChunks: " + size + ", chunkSize: " + i8);
        byte[] bArr2 = {(byte) ((size >> 8) & 255), (byte) (size & 255)};
        for (int i9 = 0; i9 < size; i9++) {
            bArr[i9] = ArraysKt.plus(ArraysKt.plus(bArr2, new byte[]{(byte) ((i9 >> 8) & 255), (byte) (i9 & 255)}), (Collection<Byte>) listChunked.get(i9));
        }
        o.d.x(size, "parsedListByteArray: ", "BlePacketUtils");
        return bArr;
    }
}
