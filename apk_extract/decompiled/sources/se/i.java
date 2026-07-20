package se;

import android.util.Log;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.UByte;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
public abstract class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap f9786a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final HashMap f9787b = new HashMap();

    public static boolean a(String deviceAddr, byte[] value) {
        HashMap map;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(deviceAddr, "deviceAddr");
        Intrinsics.checkNotNullParameter(value, "value");
        while (true) {
            map = f9787b;
            if (!map.containsKey(deviceAddr) || (bArr = (byte[]) map.get(deviceAddr)) == null) {
                break;
            }
            value = ArraysKt.plus(bArr, value);
            map.remove(deviceAddr);
        }
        int iG = g(value);
        int iD = d(value);
        int iC = c(value);
        StringBuilder sbR = o.d.r(iG, iD, "totalChunks: ", ", curChunkIdx: ", ", curChunkSize: ");
        sbR.append(iC);
        we.h.b("EthernetPacketUtils", sbR.toString());
        int i8 = iC + 6;
        if (value.length < i8) {
            Log.w("EthernetPacketUtils", "The current chunk is incomplete, the remaining data will be saved.");
            map.put(deviceAddr, CollectionsKt.toByteArray(ArraysKt.slice(value, RangesKt.until(0, value.length))));
            return false;
        }
        byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.slice(value, RangesKt.until(6, i8)));
        byte[][] bArr2 = new byte[iG][];
        HashMap map2 = f9786a;
        if (map2.containsKey(deviceAddr)) {
            Object obj = map2.get(deviceAddr);
            Intrinsics.checkNotNull(obj);
            bArr2 = (byte[][]) obj;
        }
        bArr2[iD] = byteArray;
        map2.put(deviceAddr, bArr2);
        if (i8 < value.length) {
            Log.w("EthernetPacketUtils", "The current chunk has cascading packets, the remaining data will be saved.");
            map.put(deviceAddr, CollectionsKt.toByteArray(ArraysKt.slice(value, RangesKt.until(i8, value.length))));
        }
        Object obj2 = map2.get(deviceAddr);
        Intrinsics.checkNotNull(obj2);
        return iG == ((Object[]) obj2).length;
    }

    public static int b(byte[] bArr) {
        int iM177constructorimpl = (UByte.m177constructorimpl(bArr[0]) & UByte.MAX_VALUE) << 8;
        int iM177constructorimpl2 = UByte.m177constructorimpl(bArr[1]) & UByte.MAX_VALUE;
        int i8 = iM177constructorimpl + iM177constructorimpl2;
        return i8 < 0 ? iM177constructorimpl + 65536 + iM177constructorimpl2 : i8;
    }

    public static int c(byte[] bArr) {
        return b(CollectionsKt.toByteArray(ArraysKt.slice(bArr, new IntRange(4, 5))));
    }

    public static int d(byte[] bArr) {
        return b(CollectionsKt.toByteArray(ArraysKt.slice(bArr, new IntRange(2, 3))));
    }

    public static byte[] e(String deviceAddr) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(deviceAddr, "deviceAddr");
        HashMap map = f9787b;
        if (!map.containsKey(deviceAddr) || (bArr = (byte[]) map.get(deviceAddr)) == null || bArr.length <= 6) {
            return null;
        }
        g(bArr);
        d(bArr);
        int iC = c(bArr) + 6;
        if (bArr.length < iC) {
            return null;
        }
        List<Byte> listSlice = ArraysKt.slice(bArr, RangesKt.until(0, iC));
        if (bArr.length > iC) {
            map.put(deviceAddr, CollectionsKt.toByteArray(ArraysKt.slice(bArr, RangesKt.until(iC, bArr.length))));
        } else {
            map.remove(deviceAddr);
        }
        return CollectionsKt.toByteArray(listSlice);
    }

    public static byte[] f(String deviceAddr) {
        Intrinsics.checkNotNullParameter(deviceAddr, "deviceAddr");
        HashMap map = f9786a;
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

    public static int g(byte[] bArr) {
        return b(CollectionsKt.toByteArray(ArraysKt.slice(bArr, new IntRange(0, 1))));
    }

    public static boolean h(String deviceAddr) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(deviceAddr, "deviceAddr");
        HashMap map = f9787b;
        if (!map.containsKey(deviceAddr) || (bArr = (byte[]) map.get(deviceAddr)) == null || bArr.length <= 6) {
            return false;
        }
        g(bArr);
        d(bArr);
        return bArr.length >= c(bArr) + 6;
    }

    public static byte[][] i(byte[] byteArray) {
        Intrinsics.checkNotNullParameter(byteArray, "byteArray");
        List listChunked = CollectionsKt.chunked(ArraysKt.toList(byteArray), 1454);
        int size = listChunked.size();
        byte[][] bArr = new byte[size][];
        Log.d("EthernetPacketUtils", "totalChunks: " + size + ", chunkSize: 1454");
        byte[] bArr2 = {(byte) ((size >> 8) & 255), (byte) (size & 255)};
        for (int i8 = 0; i8 < size; i8++) {
            int size2 = ((List) listChunked.get(i8)).size();
            bArr[i8] = ArraysKt.plus(ArraysKt.plus(ArraysKt.plus(bArr2, new byte[]{(byte) ((i8 >> 8) & 255), (byte) (i8 & 255)}), new byte[]{(byte) ((size2 >> 8) & 255), (byte) (size2 & 255)}), (Collection<Byte>) listChunked.get(i8));
        }
        o.d.x(size, "parsedListByteArray: ", "EthernetPacketUtils");
        return bArr;
    }
}
