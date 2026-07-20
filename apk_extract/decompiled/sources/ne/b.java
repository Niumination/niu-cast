package ne;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.AdvertiseData;
import android.bluetooth.le.AdvertiseSettings;
import android.bluetooth.le.BluetoothLeAdvertiser;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelUuid;
import android.util.Log;
import com.transsion.core.utils.EncoderUtil;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import m3.p;
import m3.q;
import se.g1;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BluetoothAdapter f8183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static BluetoothLeAdvertiser f8184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static a f8185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static byte[] f8186d;
    public static final LinkedHashSet e;
    public static String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f8187g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f8188h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static boolean f8189i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f8190j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static boolean f8191k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f8192l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static byte[] f8193m;

    static {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        Intrinsics.checkNotNullExpressionValue(defaultAdapter, "getDefaultAdapter(...)");
        f8183a = defaultAdapter;
        e = new LinkedHashSet();
        f8190j = "";
        f8192l = "";
    }

    public static final void a() {
        if (f8192l.length() <= 0 || Intrinsics.areEqual(f8183a.getName(), f8192l)) {
            return;
        }
        h.h("AdvertiseTool", "recoverDeviceName......");
        v(f8192l);
    }

    /* JADX WARN: Code duplicated, block: B:4:0x0009 A[PHI: r5
      0x0009: PHI (r5v22 java.lang.Boolean) = (r5v0 java.lang.Boolean), (r5v3 java.lang.Boolean) binds: [B:3:0x0007, B:9:0x001c] A[DONT_GENERATE, DONT_INLINE]] */
    public static byte[] b(Context context) {
        boolean zBooleanValue;
        Boolean boolValueOf = ye.h.f11193c;
        if (boolValueOf == null) {
            WifiManager wifiManager = ye.h.f11191a;
            boolValueOf = wifiManager != null ? Boolean.valueOf(wifiManager.is5GHzBandSupported()) : null;
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = boolValueOf.booleanValue();
        }
        boolean zHasSystemFeature = context != null ? context.getPackageManager().hasSystemFeature("android.hardware.nfc") : false;
        boolean zIsLeExtendedAdvertisingSupported = f8183a.isLeExtendedAdvertisingSupported();
        boolean zHasSystemFeature2 = context != null ? context.getPackageManager().hasSystemFeature("android.hardware.location.gps") : false;
        int i8 = zBooleanValue ? 64 : 0;
        if (zHasSystemFeature) {
            i8 |= 32;
        }
        if (zIsLeExtendedAdvertisingSupported) {
            i8 |= 8;
        }
        if (zHasSystemFeature2) {
            i8 |= 4;
        }
        byte[] bArr = {(byte) i8, (byte) (((byte) f()) | ((byte) 0)), 0};
        return new byte[]{-4, 3, bArr[0], bArr[1], bArr[2]};
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0076  */
    /* JADX WARN: Code duplicated, block: B:26:0x007c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0080 A[LOOP:18: B:27:0x007e->B:28:0x0080, LOOP_END] */
    public static AdvertiseData c(ArrayList arrayList, int i8, int i9, Context context, byte[] bArr) {
        int length;
        int iA;
        byte[] bArrI = i(CollectionsKt.toByteArray(arrayList));
        ArrayList arrayList2 = new ArrayList();
        if (bArrI == null) {
            return null;
        }
        Byte b9 = (Byte) CollectionsKt.getOrNull(arrayList, 4);
        if (b9 == null) {
            Intrinsics.checkNotNullParameter("Protocol Version is null, invalid manufacturer data", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            Log.e("welinkBLE", "Protocol Version is null, invalid manufacturer data", null);
            return null;
        }
        int iM177constructorimpl = UByte.m177constructorimpl(b9.byteValue()) & UByte.MAX_VALUE;
        if (iM177constructorimpl == 16) {
            h.g("Ignore protocol version 0x10, use 0x11 instead");
        } else if (17 <= iM177constructorimpl && iM177constructorimpl < 20) {
            if (i8 == -1 || i8 == 0) {
                h.j("AdvertiseTool", "Ignore protocol version 0x11-0x13 for Screen Cast, use 0x14 instead");
            } else if (i8 != 1 && i8 != 4 && i8 != 5 && i8 != 8 && i8 != 251) {
                switch (i8) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        if (!r(bArr)) {
                            length = bArrI.length;
                            for (iA = 0; iA < length; iA = h0.a.a(bArrI[iA], arrayList2, iA, 1)) {
                            }
                        }
                        break;
                    default:
                        h.j("AdvertiseTool", "Unknown scenario: " + i8 + ", use default advertising data");
                        break;
                }
            } else if (!r(bArr)) {
                length = bArrI.length;
                while (iA < length) {
                }
            }
        } else if (20 > iM177constructorimpl || iM177constructorimpl >= 256) {
            String mes = "Invalid protocol version: " + b9 + ", use default version: 0x11";
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", mes, null);
            }
        } else {
            arrayList2.add((byte) -1);
            arrayList2.add((byte) 6);
            int length2 = bArrI.length;
            for (int iA2 = 0; iA2 < length2; iA2 = h0.a.a(bArrI[iA2], arrayList2, iA2, 1)) {
            }
        }
        if (i8 == 0) {
            byte[] bArr2 = {0, 2, (byte) f(), 0};
            for (int iA3 = 0; iA3 < 4; iA3 = h0.a.a(bArr2[iA3], arrayList2, iA3, 1)) {
            }
            if (arrayList2.size() > 27) {
                String strH = o.d.h(27, "Screen Cast Data Length is too long, it should be less than ", "mes");
                if (lb.f6529c < 1) {
                    return null;
                }
                Log.e("welinkBLE", strH, null);
                return null;
            }
            String strA = f8192l;
            if (strA.length() > 0) {
                if (strA.length() > 21) {
                    strA = q.a(21, strA);
                }
                arrayList2.add(Byte.valueOf((byte) 239));
                arrayList2.add(Byte.valueOf((byte) strA.length()));
                byte[] bytes = strA.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                int length3 = bytes.length;
                for (int iA4 = 0; iA4 < length3; iA4 = h0.a.a(bytes[iA4], arrayList2, iA4, 1)) {
                }
            }
            return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
        }
        if (i8 == 1) {
            byte[] bArr3 = {1, 2, (byte) f(), 0};
            int iA5 = 0;
            for (int i10 = 4; iA5 < i10; i10 = 4) {
                iA5 = h0.a.a(bArr3[iA5], arrayList2, iA5, 1);
            }
            if (arrayList2.size() <= 27) {
                return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
            }
            String strH2 = o.d.h(27, "Air Parcel Data Length is too long, it should be less than ", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            Log.e("welinkBLE", strH2, null);
            return null;
        }
        if (i8 == 4) {
            byte[] bArr4 = {4, 2, (byte) f(), 0};
            int iA6 = 0;
            for (int i11 = 4; iA6 < i11; i11 = 4) {
                iA6 = h0.a.a(bArr4[iA6], arrayList2, iA6, 1);
            }
            if (arrayList2.size() <= 27) {
                return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
            }
            String strH3 = o.d.h(27, "Audio Sink Data Length is too long, it should be less than ", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            Log.e("welinkBLE", strH3, null);
            return null;
        }
        if (i8 == 5) {
            byte[] bArr5 = {5, 2, (byte) f(), 0};
            int iA7 = 0;
            for (int i12 = 4; iA7 < i12; i12 = 4) {
                iA7 = h0.a.a(bArr5[iA7], arrayList2, iA7, 1);
            }
            if (arrayList2.size() <= 27) {
                return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
            }
            String strH4 = o.d.h(27, "handoffData Data Length is too long, it should be less than ", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            Log.e("welinkBLE", strH4, null);
            return null;
        }
        if (i8 == 8) {
            byte[] bArr6 = {8, 2, (byte) f(), 0};
            int iA8 = 0;
            for (int i13 = 4; iA8 < i13; i13 = 4) {
                iA8 = h0.a.a(bArr6[iA8], arrayList2, iA8, 1);
            }
            if (arrayList2.size() > 27) {
                String strH5 = o.d.h(27, "Air Cast Data Length is too long, it should be less than ", "mes");
                if (lb.f6529c < 1) {
                    return null;
                }
                Log.e("welinkBLE", strH5, null);
                return null;
            }
            if (i9 != 0) {
                byte[] bArrD = d(Integer.valueOf(i9));
                int iA9 = 0;
                for (int i14 = 4; iA9 < i14; i14 = 4) {
                    iA9 = h0.a.a(bArrD[iA9], arrayList2, iA9, 1);
                }
                if (arrayList2.size() > 27) {
                    String strH6 = o.d.h(27, "Air Cast Data Length is too long, it should be less than ", "mes");
                    if (lb.f6529c < 1) {
                        return null;
                    }
                    Log.e("welinkBLE", strH6, null);
                    return null;
                }
            }
            return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
        }
        if (i8 != 251) {
            switch (i8) {
                case 10:
                    byte[] bArr7 = {10, 2, (byte) f(), 0};
                    for (int iA10 = 0; iA10 < 4; iA10 = h0.a.a(bArr7[iA10], arrayList2, iA10, 1)) {
                    }
                    if (arrayList2.size() <= 27) {
                        return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
                    }
                    String strH7 = o.d.h(27, "Audio Sink Data Length is too long, it should be less than ", "mes");
                    if (lb.f6529c < 1) {
                        return null;
                    }
                    Log.e("welinkBLE", strH7, null);
                    return null;
                case 11:
                    byte[] bArr8 = {11, 2, (byte) f(), 0};
                    for (int iA11 = 0; iA11 < 4; iA11 = h0.a.a(bArr8[iA11], arrayList2, iA11, 1)) {
                    }
                    if (arrayList2.size() <= 27) {
                        return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
                    }
                    String strH8 = o.d.h(27, "Audio Sink Data Length is too long, it should be less than ", "mes");
                    if (lb.f6529c < 1) {
                        return null;
                    }
                    Log.e("welinkBLE", strH8, null);
                    return null;
                case 12:
                    byte[] bArr9 = {12, 2, (byte) f(), 0};
                    for (int iA12 = 0; iA12 < 4; iA12 = h0.a.a(bArr9[iA12], arrayList2, iA12, 1)) {
                    }
                    if (arrayList2.size() <= 27) {
                        return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
                    }
                    String strH9 = o.d.h(27, "Audio Sink Data Length is too long, it should be less than ", "mes");
                    if (lb.f6529c < 1) {
                        return null;
                    }
                    Log.e("welinkBLE", strH9, null);
                    return null;
                case 13:
                    byte[] bArr10 = {13, 2, (byte) f(), 0};
                    for (int iA13 = 0; iA13 < 4; iA13 = h0.a.a(bArr10[iA13], arrayList2, iA13, 1)) {
                    }
                    if (arrayList2.size() <= 27) {
                        return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
                    }
                    String strH10 = o.d.h(27, "Audio Sink Data Length is too long, it should be less than ", "mes");
                    if (lb.f6529c < 1) {
                        return null;
                    }
                    Log.e("welinkBLE", strH10, null);
                    return null;
                default:
                    return null;
            }
        }
        if (com.welink.protocol.nfbd.a.f4027k.c("1.0")) {
            int i15 = (UByte.m177constructorimpl(b9.byteValue()) & UByte.MAX_VALUE) <= 19 ? 6 : 8;
            h.g("deviceHeaderLen is " + i15);
            if (arrayList2.size() + i15 <= 27 && bArr != null && ArraysKt.contains(bArr, (byte) 0)) {
                int iM177constructorimpl2 = UByte.m177constructorimpl(b9.byteValue()) & UByte.MAX_VALUE;
                if (17 <= iM177constructorimpl2 && iM177constructorimpl2 < 20) {
                    int length4 = bArrI.length;
                    for (int iA14 = 0; iA14 < length4; iA14 = h0.a.a(bArrI[iA14], arrayList2, iA14, 1)) {
                    }
                } else if (20 > iM177constructorimpl2 || iM177constructorimpl2 >= 256) {
                    h.d("Invalid protocol version: " + b9 + ", use default version: 0x11", null);
                } else {
                    arrayList2.add((byte) -1);
                    arrayList2.add((byte) 6);
                    int length5 = bArrI.length;
                    for (int iA15 = 0; iA15 < length5; iA15 = h0.a.a(bArrI[iA15], arrayList2, iA15, 1)) {
                    }
                }
            }
        }
        byte[] bArrG = g(bArr);
        byte[] bArr11 = {-5, 2, bArrG[0], bArrG[1]};
        int iA16 = 0;
        for (int i16 = 4; iA16 < i16; i16 = 4) {
            iA16 = h0.a.a(bArr11[iA16], arrayList2, iA16, 1);
        }
        if (arrayList2.size() > 27) {
            String strH11 = o.d.h(27, "Capability Data Length is too long, it should be less than ", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            Log.e("welinkBLE", strH11, null);
            return null;
        }
        if (i9 != 0) {
            byte[] bArrD2 = d(Integer.valueOf(i9));
            for (int iA17 = 0; iA17 < 4; iA17 = h0.a.a(bArrD2[iA17], arrayList2, iA17, 1)) {
            }
            if (arrayList2.size() > 27) {
                String strH12 = o.d.h(27, "SubCapability Data Length is too long, it should be less than ", "mes");
                if (lb.f6529c < 1) {
                    return null;
                }
                Log.e("welinkBLE", strH12, null);
                return null;
            }
        }
        if (com.welink.protocol.nfbd.a.f4027k.c("1.0")) {
            if (arrayList2.size() + 4 > 27 || bArr == null || !ArraysKt.contains(bArr, (byte) 1)) {
                String strH13 = o.d.h(27, "Air Parcel Data Length is too long, it should be less than ", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", strH13, null);
                }
            } else {
                byte[] bArr12 = {1, 2, (byte) f(), 0};
                int iA18 = 0;
                for (int i17 = 4; iA18 < i17; i17 = 4) {
                    iA18 = h0.a.a(bArr12[iA18], arrayList2, iA18, 1);
                }
            }
            if (arrayList2.size() + 4 > 27 || bArr == null || !ArraysKt.contains(bArr, (byte) 0)) {
                String strH14 = o.d.h(27, "Screen Cast Data is too long, it should be less than ", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", strH14, null);
                }
            } else {
                byte[] bArr13 = {0, 2, (byte) f(), 0};
                int iA19 = 0;
                for (int i18 = 4; iA19 < i18; i18 = 4) {
                    iA19 = h0.a.a(bArr13[iA19], arrayList2, iA19, 1);
                }
            }
        }
        byte[] bArrB = b(context);
        int iA20 = 0;
        for (int i19 = 5; iA20 < i19; i19 = 5) {
            iA20 = h0.a.a(bArrB[iA20], arrayList2, iA20, 1);
        }
        if (arrayList2.size() <= 27) {
            return new AdvertiseData.Builder().addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
        }
        String strH15 = o.d.h(27, "Feature Data Length is too long, it should be less than ", "mes");
        if (lb.f6529c < 1) {
            return null;
        }
        Log.e("welinkBLE", strH15, null);
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0033 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0036  */
    /* JADX WARN: Code duplicated, block: B:28:0x003f  */
    /* JADX WARN: Code duplicated, block: B:30:0x0042  */
    /* JADX WARN: Code duplicated, block: B:33:0x004a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0061  */
    /* JADX WARN: Instruction removed from duplicated block: B:33:0x004a, please report this as an issue */
    public static byte[] d(Integer num) {
        String mes;
        int i8;
        if (num != null && num.intValue() == 1) {
            i8 = 1;
        } else if (num != null && num.intValue() == 2) {
            i8 = 2;
        } else if (num != null && num.intValue() == 4) {
            i8 = 4;
        } else if (num != null) {
            i8 = 8;
            if (num.intValue() != 8) {
                if (num == null) {
                    i8 = 12;
                    if (num.intValue() != 12) {
                        if (num == null) {
                            mes = "Unknown subCapability type: " + num;
                            Intrinsics.checkNotNullParameter(mes, "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("welinkBLE", mes, null);
                            }
                            i8 = 0;
                        } else {
                            i8 = 3;
                        }
                    }
                } else if (num == null) {
                    mes = "Unknown subCapability type: " + num;
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", mes, null);
                    }
                    i8 = 0;
                } else {
                    i8 = 3;
                }
            }
        } else if (num == null) {
            i8 = 12;
            if (num.intValue() != 12) {
                if (num == null) {
                    mes = "Unknown subCapability type: " + num;
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", mes, null);
                    }
                    i8 = 0;
                } else {
                    i8 = 3;
                }
            }
        } else if (num == null && num.intValue() == 3) {
            i8 = 3;
        } else {
            mes = "Unknown subCapability type: " + num;
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", mes, null);
            }
            i8 = 0;
        }
        return new byte[]{-54, 2, (byte) i8, 0};
    }

    public static void e() {
        h.g("resetBuf......");
        f = null;
        f8187g = false;
        f8188h = 0;
        f8189i = false;
        f8190j = "";
        f8184b = null;
        f8185c = null;
        f8193m = null;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0021 A[PHI: r3
      0x0021: PHI (r3v8 java.lang.Boolean) = (r3v0 java.lang.Boolean), (r3v3 java.lang.Boolean) binds: [B:13:0x001f, B:19:0x0034] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:4:0x0006 A[PHI: r0
      0x0006: PHI (r0v8 java.lang.Boolean) = (r0v0 java.lang.Boolean), (r0v3 java.lang.Boolean) binds: [B:3:0x0004, B:9:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    public static int f() {
        boolean zBooleanValue;
        boolean zBooleanValue2;
        Boolean boolValueOf = ye.h.f11193c;
        boolean zBooleanValue3 = false;
        if (boolValueOf == null) {
            WifiManager wifiManager = ye.h.f11191a;
            boolValueOf = wifiManager != null ? Boolean.valueOf(wifiManager.is5GHzBandSupported()) : null;
            if (boolValueOf != null) {
                zBooleanValue = boolValueOf.booleanValue();
            } else {
                zBooleanValue = false;
            }
        } else {
            zBooleanValue = boolValueOf.booleanValue();
        }
        Boolean boolValueOf2 = ye.h.f;
        if (boolValueOf2 == null) {
            WifiManager wifiManager2 = ye.h.f11191a;
            boolValueOf2 = wifiManager2 != null ? Boolean.valueOf(wifiManager2.isP2pSupported()) : null;
            if (boolValueOf2 != null) {
                zBooleanValue2 = boolValueOf2.booleanValue();
            } else {
                zBooleanValue2 = true;
            }
        } else {
            zBooleanValue2 = boolValueOf2.booleanValue();
        }
        Boolean bool = ye.h.f11194d;
        if (bool != null) {
            zBooleanValue3 = bool.booleanValue();
        } else {
            WifiManager wifiManager3 = ye.h.f11191a;
            Boolean boolValueOf3 = wifiManager3 != null ? Boolean.valueOf(wifiManager3.is6GHzBandSupported()) : null;
            if (boolValueOf3 != null) {
                zBooleanValue3 = boolValueOf3.booleanValue();
            }
        }
        int i8 = zBooleanValue3 ? 160 : 32;
        if (zBooleanValue) {
            i8 |= 64;
        }
        return zBooleanValue2 ? i8 | 16 : i8;
    }

    public static byte[] g(byte[] bArr) {
        int i8;
        if (bArr == null) {
            i8 = 1;
        } else {
            i8 = 0;
            for (byte b9 : bArr) {
                if (b9 == 0) {
                    h.g("Screen Cast will be ignore here");
                } else if (b9 == 1) {
                    i8 |= 1;
                } else if (b9 == 8) {
                    i8 |= 2;
                } else if (b9 == 9) {
                    i8 |= 4;
                } else if (b9 == 4) {
                    i8 |= 8;
                } else if (b9 == 5) {
                    i8 |= 16;
                } else if (b9 == 10) {
                    i8 |= 32;
                } else if (b9 == 11) {
                    i8 |= 64;
                } else if (b9 == 12) {
                    i8 |= 128;
                } else if (b9 == 13) {
                    i8 |= 256;
                } else {
                    String strH = o.d.h(UByte.m177constructorimpl(b9) & UByte.MAX_VALUE, "Unknown service type: ", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", strH, null);
                    }
                }
            }
        }
        return new byte[]{(byte) (i8 & 255), (byte) ((((-65025) & i8) >> 8) & 255)};
    }

    public static String h(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("BluetoothNamePrefs", 0);
        String string = sharedPreferences != null ? sharedPreferences.getString("bluetooth_name_property", "") : null;
        if (string != null && string.length() != 0) {
            return string;
        }
        String name = f8183a.getName();
        return name == null ? f8192l : name;
    }

    public static byte[] i(byte[] bArr) {
        byte[] bArr2 = new byte[6];
        String address = f8183a.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        byte[] bArrD = q.d(address);
        byte[] bArr3 = new byte[6];
        byte[] bArr4 = f8186d;
        if (bArr4 != null) {
            ArraysKt.copyInto(bArr4, bArr3, 0, 0, 6);
        } else {
            ArraysKt.copyInto(bArrD, bArr3, 0, 0, 6);
        }
        h.h("AdvertiseTool", "macAddrByteArray is " + q.c(bArrD) + ", deviceRandomId is " + q.c(bArr3));
        Byte orNull = ArraysKt.getOrNull(bArr, 4);
        if (orNull == null) {
            return null;
        }
        if (orNull.byteValue() <= 16) {
            ArraysKt.copyInto(bArrD, bArr2, 0, 0, 6);
        } else {
            ArraysKt.copyInto(bArr3, bArr2, 0, 0, 6);
        }
        return bArr2;
    }

    public static int j(int i8, byte[] bArr) {
        if (i8 == 0) {
            return 20;
        }
        if (i8 == 1 || i8 == 8 || i8 == 10 || !r(bArr)) {
            return 13;
        }
        h.g("Screen Cast is contained in advertiseServices, fix length is 23");
        return 23;
    }

    public static byte[] k(int i8) {
        byte[] bArr = new byte[10];
        ArraysKt.fill(bArr, (byte) -1, 0, 10);
        for (int i9 = 0; i9 < 10; i9++) {
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(1 << i9) & i8) != UInt.m254constructorimpl(0)) {
                switch (i9) {
                    case 0:
                        bArr[0] = 0;
                        break;
                    case 1:
                        bArr[1] = 1;
                        break;
                    case 2:
                        bArr[2] = 4;
                        break;
                    case 3:
                        bArr[3] = 5;
                        break;
                    case 4:
                        bArr[4] = 8;
                        break;
                    case 5:
                        bArr[5] = 9;
                        break;
                    case 6:
                        bArr[6] = 10;
                        break;
                    case 7:
                        bArr[7] = 11;
                        break;
                    case 8:
                        bArr[8] = 12;
                        break;
                    case 9:
                        bArr[9] = 13;
                        break;
                }
            }
        }
        return bArr;
    }

    public static ArrayList l(byte[] bArr) {
        ArrayList arrayList = new ArrayList();
        if (bArr.length != 0 && bArr.length >= 2) {
            int iM254constructorimpl = UInt.m254constructorimpl(UInt.m254constructorimpl(UByte.m177constructorimpl(bArr[0]) & UByte.MAX_VALUE) | UInt.m254constructorimpl(UInt.m254constructorimpl(UByte.m177constructorimpl(bArr[1]) & UByte.MAX_VALUE) << 8));
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(1) & iM254constructorimpl) != 0) {
                arrayList.add(1);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(2) & iM254constructorimpl) != 0) {
                arrayList.add(8);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(4) & iM254constructorimpl) != 0) {
                arrayList.add(9);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(32) & iM254constructorimpl) != 0) {
                arrayList.add(10);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(8) & iM254constructorimpl) != 0) {
                arrayList.add(4);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(16) & iM254constructorimpl) != 0) {
                arrayList.add(5);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(64) & iM254constructorimpl) != 0) {
                arrayList.add(11);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(128) & iM254constructorimpl) != 0) {
                arrayList.add(12);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(256) & iM254constructorimpl) != 0) {
                arrayList.add(13);
            }
            if (UInt.m254constructorimpl(UInt.m254constructorimpl(65024) & iM254constructorimpl) != 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String mes = h0.a.o(new Object[]{UInt.m248boximpl(iM254constructorimpl)}, 1, "%04X", "format(...)", "Reserved service flag is not supported, ");
                Intrinsics.checkNotNullParameter("AdvertiseTool", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes, "AdvertiseTool", null);
                }
            }
        }
        return arrayList;
    }

    public static byte[] m() {
        byte[] bArr = f8186d;
        if (bArr != null) {
            return bArr;
        }
        UUID uuid = we.e.f10723a;
        MessageDigest messageDigest = MessageDigest.getInstance(EncoderUtil.ALGORITHM_SHA_256);
        String string = we.e.f10723a.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] bArrDigest = messageDigest.digest(bytes);
        Intrinsics.checkNotNull(bArrDigest);
        return CollectionsKt.toByteArray(ArraysKt.take(bArrDigest, RangesKt.coerceAtMost(6, bArrDigest.length)));
    }

    public static List n(ConcurrentHashMap bandInfoMap, ArrayList arrayList) {
        Intrinsics.checkNotNullParameter(bandInfoMap, "bandInfoMap");
        byte b9 = (byte) 251;
        if (bandInfoMap.containsKey(Byte.valueOf(b9))) {
            List arrayList2 = (List) bandInfoMap.get(Byte.valueOf(b9));
            if (arrayList2 == null) {
                arrayList2 = new ArrayList();
            }
            return !arrayList2.isEmpty() ? arrayList2 : arrayList;
        }
        List list = (List) bandInfoMap.get(Byte.valueOf((byte) 1));
        if (list != null) {
            return list;
        }
        List list2 = (List) bandInfoMap.get(Byte.valueOf((byte) 8));
        if (list2 != null) {
            return list2;
        }
        List list3 = (List) bandInfoMap.get(Byte.valueOf((byte) 10));
        if (list3 != null) {
            return list3;
        }
        List list4 = (List) bandInfoMap.get(Byte.valueOf((byte) 0));
        if (list4 != null) {
            return list4;
        }
        List list5 = (List) bandInfoMap.get(Byte.valueOf((byte) 5));
        if (list5 != null) {
            return list5;
        }
        List list6 = (List) bandInfoMap.get(Byte.valueOf((byte) 4));
        if (list6 != null) {
            return list6;
        }
        List list7 = (List) bandInfoMap.get(Byte.valueOf((byte) 11));
        if (list7 != null) {
            return list7;
        }
        List list8 = (List) bandInfoMap.get(Byte.valueOf((byte) 12));
        return list8 == null ? (List) bandInfoMap.get(Byte.valueOf((byte) 13)) : list8;
    }

    public static int o(ConcurrentHashMap serviceTypeMap, ConcurrentHashMap serviceValueMap) {
        Intrinsics.checkNotNullParameter(serviceTypeMap, "serviceTypeMap");
        Intrinsics.checkNotNullParameter(serviceValueMap, "serviceValueMap");
        byte b9 = (byte) 251;
        if (!serviceTypeMap.containsKey(Byte.valueOf(b9))) {
            Integer num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 1));
            if (num != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 8))) != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 10))) != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 0))) != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 5))) != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 4))) != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 11))) != null || (num = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 12))) != null) {
                return num.intValue();
            }
            Integer num2 = (Integer) serviceTypeMap.get(Byte.valueOf((byte) 13));
            if (num2 != null) {
                return num2.intValue();
            }
            return -1;
        }
        byte[] bArr = (byte[]) serviceValueMap.get(Byte.valueOf(b9));
        if (bArr == null) {
            bArr = new byte[0];
        }
        ArrayList arrayListL = l(bArr);
        if (!arrayListL.isEmpty()) {
            for (Map.Entry entry : serviceTypeMap.entrySet()) {
                if (arrayListL.contains(entry.getValue())) {
                    h.b("AdvertiseTool", "serviceType: " + entry.getValue() + " in General Service List");
                    Integer num3 = (Integer) serviceTypeMap.get(Byte.valueOf(b9));
                    if (num3 != null) {
                        return num3.intValue();
                    }
                    return -1;
                }
            }
        }
        Integer num4 = (Integer) serviceTypeMap.get(Byte.valueOf(b9));
        if (num4 != null) {
            return num4.intValue();
        }
        return -1;
    }

    public static byte[] p(ConcurrentHashMap serviceTypeMap, ConcurrentHashMap serviceValueMap) {
        Intrinsics.checkNotNullParameter(serviceTypeMap, "serviceTypeMap");
        Intrinsics.checkNotNullParameter(serviceValueMap, "serviceValueMap");
        byte b9 = (byte) 251;
        if (serviceTypeMap.containsKey(Byte.valueOf(b9))) {
            byte[] bArr = (byte[]) serviceValueMap.get(Byte.valueOf(b9));
            if (bArr == null) {
                bArr = new byte[0];
            }
            ArrayList arrayListL = l(bArr);
            if (arrayListL.isEmpty()) {
                return null;
            }
            h.b("AdvertiseTool", "serviceList is " + arrayListL);
            return bArr;
        }
        byte[] bArr2 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 1));
        if (bArr2 != null) {
            return bArr2;
        }
        byte[] bArr3 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 8));
        if (bArr3 != null) {
            return bArr3;
        }
        byte[] bArr4 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 10));
        if (bArr4 != null) {
            return bArr4;
        }
        byte[] bArr5 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 0));
        if (bArr5 != null) {
            return bArr5;
        }
        byte[] bArr6 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 5));
        if (bArr6 != null) {
            return bArr6;
        }
        byte[] bArr7 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 4));
        if (bArr7 != null) {
            return bArr7;
        }
        byte[] bArr8 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 11));
        if (bArr8 != null) {
            return bArr8;
        }
        byte[] bArr9 = (byte[]) serviceValueMap.get(Byte.valueOf((byte) 12));
        return bArr9 == null ? (byte[]) serviceValueMap.get(Byte.valueOf((byte) 13)) : bArr9;
    }

    public static boolean q(byte[] tlvData) {
        Intrinsics.checkNotNullParameter(tlvData, "tlvData");
        return (UByte.m177constructorimpl(tlvData[0]) & 1) == 1;
    }

    public static boolean r(byte[] bArr) {
        return com.welink.protocol.nfbd.a.f4027k.c("1.0") && bArr != null && ArraysKt.contains(bArr, (byte) 0);
    }

    public static void s(int i8) {
        Iterator it = e.iterator();
        while (it.hasNext()) {
            com.welink.protocol.nfbd.g gVar = ((g1) ((Pair) it.next()).getSecond()).f9742a;
            gVar.getClass();
            Intent intent = new Intent("com.welink.service.ACTION_NEAR_DEVICE_ADVERTISE_START_FAILED");
            intent.putExtra("com.welink.service.EXTRA_ADV_ERROR_CODE", i8);
            gVar.f4112b.j(intent);
        }
    }

    public static void t() {
        Iterator it = e.iterator();
        while (it.hasNext()) {
            com.welink.protocol.nfbd.g gVar = ((g1) ((Pair) it.next()).getSecond()).f9742a;
            gVar.getClass();
            gVar.f4112b.j(new Intent("com.welink.service.ACTION_NEAR_DEVICE_ADVERTISE_STOP_SUCCESS"));
        }
    }

    public static ArrayList u(byte[] tlvData) {
        Intrinsics.checkNotNullParameter(tlvData, "tlvData");
        byte bM177constructorimpl = UByte.m177constructorimpl(tlvData[0]);
        ArrayList arrayList = new ArrayList();
        if ((bM177constructorimpl & ByteCompanionObject.MIN_VALUE) != 0) {
            arrayList.add("6G");
        }
        if ((bM177constructorimpl & 64) != 0) {
            arrayList.add("5G");
            arrayList.add("2.4G");
        } else {
            arrayList.add("2.4G");
        }
        if ((bM177constructorimpl & 16) != 0) {
            arrayList.add("P2P");
        }
        if ((bM177constructorimpl & 32) != 0) {
            arrayList.add("STA");
        }
        if ((bM177constructorimpl & 8) != 0) {
            arrayList.add("NAN");
        }
        if ((bM177constructorimpl & 4) != 0) {
            arrayList.add("60G");
        }
        return arrayList;
    }

    public static void v(String adapterName) {
        Intrinsics.checkNotNullParameter(adapterName, "adapterName");
        BluetoothAdapter bluetoothAdapter = f8183a;
        boolean name = bluetoothAdapter.setName(adapterName);
        long jCurrentTimeMillis = System.currentTimeMillis();
        h.h("AdvertiseTool", "设置TV 蓝牙名称为：" + adapterName + "，执行返回(为true不代表真正设置下去了)：" + name);
        int iCurrentTimeMillis = 0;
        while (name && !Intrinsics.areEqual(bluetoothAdapter.getName(), adapterName) && iCurrentTimeMillis < 6) {
            iCurrentTimeMillis = (int) ((System.currentTimeMillis() - jCurrentTimeMillis) / ((long) 1000));
            h0.a.u(iCurrentTimeMillis, "等待蓝牙名称设置完成......waitTime is ", "AdvertiseTool");
        }
        if (Intrinsics.areEqual(bluetoothAdapter.getName(), adapterName) || iCurrentTimeMillis < 6) {
            h0.a.D("set name successs, TV 蓝牙名称为：", bluetoothAdapter.getName(), "AdvertiseTool");
        } else {
            h0.a.u(iCurrentTimeMillis, "设置蓝牙名称超时，waitTime is ", "AdvertiseTool");
        }
    }

    public static void w(byte[] uniqueId) {
        Intrinsics.checkNotNullParameter(uniqueId, "uniqueId");
        f8186d = uniqueId;
    }

    /* JADX WARN: Code duplicated, block: B:122:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:124:0x02af  */
    /* JADX WARN: Code duplicated, block: B:126:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:127:0x02d6  */
    /* JADX WARN: Code duplicated, block: B:130:0x02de  */
    /* JADX WARN: Code duplicated, block: B:132:0x02e9 A[LOOP:1: B:131:0x02e7->B:132:0x02e9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:135:0x030d  */
    /* JADX WARN: Code duplicated, block: B:137:0x0310  */
    /* JADX WARN: Code duplicated, block: B:138:0x0312  */
    /* JADX WARN: Code duplicated, block: B:142:0x0359 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:143:0x037f  */
    /* JADX WARN: Code duplicated, block: B:144:0x0394  */
    /* JADX WARN: Code duplicated, block: B:147:0x039e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:148:0x03a0  */
    /* JADX WARN: Code duplicated, block: B:150:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:152:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:154:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:156:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:158:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:159:0x03b4  */
    /* JADX WARN: Code duplicated, block: B:161:0x03cb  */
    /* JADX WARN: Code duplicated, block: B:162:0x03d1  */
    /* JADX WARN: Code duplicated, block: B:163:0x03d4  */
    /* JADX WARN: Code duplicated, block: B:164:0x03e0  */
    /* JADX WARN: Code duplicated, block: B:165:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:166:0x03f8  */
    /* JADX WARN: Code duplicated, block: B:167:0x03fa  */
    /* JADX WARN: Code duplicated, block: B:169:0x0410  */
    /* JADX WARN: Code duplicated, block: B:170:0x041c  */
    /* JADX WARN: Code duplicated, block: B:171:0x0428  */
    /* JADX WARN: Code duplicated, block: B:172:0x0434  */
    /* JADX WARN: Code duplicated, block: B:173:0x0440  */
    /* JADX WARN: Code duplicated, block: B:175:0x0457  */
    /* JADX WARN: Code duplicated, block: B:177:0x045e  */
    /* JADX WARN: Code duplicated, block: B:178:0x0461  */
    /* JADX WARN: Code duplicated, block: B:180:0x0465  */
    /* JADX WARN: Code duplicated, block: B:188:0x0567  */
    /* JADX WARN: Code duplicated, block: B:191:0x05cf  */
    /* JADX WARN: Code duplicated, block: B:194:0x05dd  */
    /* JADX WARN: Code duplicated, block: B:207:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:124:0x02af, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:143:0x037f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:159:0x03b4, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:173:0x0440, please report this as an issue */
    public static void x(String wholePid, boolean z2, int i8, boolean z3, int i9, int i10, Context context, byte[] bArr) {
        byte b9;
        char c9;
        byte b10;
        char c10;
        byte b11;
        AdvertiseData advertiseDataBuild;
        AdvertiseData advertiseDataC;
        AdvertiseSettings advertiseSettingsBuild;
        BluetoothLeAdvertiser bluetoothLeAdvertiser;
        boolean z5;
        byte[] bArrI;
        String strC;
        String mes;
        String mes2;
        int length;
        String strB;
        int i11;
        int i12;
        int length2;
        Intrinsics.checkNotNullParameter(wholePid, "wholePid");
        h.g("startAdvertisement......");
        f = wholePid;
        f8187g = z2;
        f8188h = i8;
        f8189i = z3;
        f8193m = bArr;
        String str = Build.DEVICE;
        h.g("localName is " + str);
        if (wholePid.length() < 18 || (z2 && str != null && str.length() > 32)) {
            h.d(o.d.g(wholePid.length(), str.length(), "startAdvertisement's param is wrong, wholePid.length:", " should be 18,localName.length:", " should <= 32"), null);
            s(-1);
            return;
        }
        if (!p.a()) {
            h.d("startGattServer: 蓝牙开启超时，退出！", null);
            s(-2);
            return;
        }
        if (i9 == -1) {
            h.d("startAdvertisement: scenario is invalid, exit!", null);
            s(-3);
            return;
        }
        int iM177constructorimpl = ((UByte.m177constructorimpl((byte) 9) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl((byte) 66) & UByte.MAX_VALUE);
        byte[] bArrG = q.g(wholePid);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Byte.valueOf(bArrG[1]));
        arrayList.add(Byte.valueOf(bArrG[3]));
        arrayList.add(Byte.valueOf(bArrG[7]));
        arrayList.add(Byte.valueOf(bArrG[8]));
        byte b12 = bArrG[6];
        if (16 > b12 || b12 >= 255) {
            h.g("Use Default Broadcast Version: " + ((int) b12));
            arrayList.add((byte) 16);
            b9 = 16;
        } else {
            h.g("Add User Defined Broadcast Version: " + ((int) b12));
            if (i9 == 0) {
                b9 = 17;
            } else if (i9 == 1 || i9 == 4 || i9 == 5 || i9 == 8) {
                b9 = 19;
            } else if (i9 != 251) {
                switch (i9) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        b9 = 19;
                        break;
                    default:
                        h.d("Unknown Scenario: " + i9 + ", use default version: " + ((int) bArrG[6]), null);
                        b9 = bArrG[6];
                        break;
                }
            } else {
                b9 = r(bArr) ? (byte) 19 : (byte) 20;
            }
            arrayList.add(Byte.valueOf(b9));
        }
        arrayList.add(Byte.valueOf((byte) 0));
        int iJ = 31 - j(i9, bArr);
        if (!z2 && f8190j.length() > 0 && i9 == 0 && b9 == 17) {
            byte[] bytes = f8190j.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] bArr2 = new byte[iJ];
            if (bytes.length > iJ) {
                ArraysKt.copyInto(bytes, bArr2, 0, 0, iJ);
                length2 = iJ;
            } else {
                length2 = bytes.length;
                ArraysKt.copyInto(bytes, bArr2, 0, 0, bytes.length);
            }
            for (int i13 = 0; i13 < iJ; i13++) {
                byte b13 = bArr2[i13];
                if (i13 < length2) {
                    arrayList.add(Byte.valueOf(b13));
                }
            }
            iJ -= length2;
        }
        h.g("manufacturerSpecificData is");
        q.f(CollectionsKt.toByteArray(arrayList));
        BluetoothAdapter bluetoothAdapter = f8183a;
        String name = bluetoothAdapter.getName();
        f8192l = name;
        String str2 = "";
        if (f8187g) {
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("BluetoothNamePrefs", 0);
                Regex regex = new Regex("^[^.]*\\.{3}[^.]*$");
                String string = sharedPreferences != null ? sharedPreferences.getString("bluetooth_name_property", "") : null;
                if (string != null && string.length() == 0) {
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("bluetooth_name_property", name);
                    editorEdit.apply();
                } else if (string != null && name != null && !Intrinsics.areEqual(name, string) && (!regex.matches(name) || name.length() > iJ)) {
                    h.d("Bluetooth name is not match, maybe changed by user, update it.", null);
                    SharedPreferences.Editor editorEdit2 = sharedPreferences.edit();
                    editorEdit2.putString("bluetooth_name_property", name);
                    editorEdit2.apply();
                }
                if (name != null && regex.matches(name) && name.length() <= iJ) {
                    h.g("Bluetooth name is already set, skip setAdapterName.");
                }
            } else {
                str2 = "";
            }
            if (!Intrinsics.areEqual(bluetoothAdapter.getName(), f8190j)) {
                v(f8190j);
            }
        } else {
            str2 = "";
        }
        String name2 = bluetoothAdapter.getName();
        int length3 = name2 != null ? name2.length() : 0;
        if (iJ <= 2 || length3 <= (i12 = iJ - 2) || !f8187g) {
            if (length3 <= 0) {
                c9 = 0;
                f8187g = false;
                if (r(bArr)) {
                    h.i("Bluetooth name will be null for misc mode", null);
                } else {
                    h.i("Bluetooth name is null, advertise data will not include device name.", null);
                }
            }
            b10 = bArrG[c9];
            if ((b10 == 6 || bArrG[1] != 13) && !((b10 == 6 && bArrG[1] == 18) || (b10 == 6 && bArrG[1] == 15))) {
                if (b10 != 6) {
                    c10 = 1;
                    b11 = 6;
                } else if (bArrG[1] == 21) {
                    h.d("RUN PHONE/PAD MODE, BT MAC" + bluetoothAdapter.getAddress(), null);
                    z5 = f8187g;
                    bArrI = i(CollectionsKt.toByteArray(arrayList));
                    if (bArrI != null) {
                        strC = q.c(bArrI);
                    } else {
                        strC = null;
                    }
                    h0.a.D("deviceRandomId is ", strC, "AdvertiseTool");
                    if (bArrI != null) {
                        Intrinsics.checkNotNullParameter(bArrI, "<this>");
                        strB = str2;
                        i11 = 0;
                        for (length = bArrI.length; i11 < length; length = length) {
                            byte b14 = bArrI[i11];
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b14)}, 1, "%02x ", "format(...)"));
                            i11++;
                        }
                        h.g(strB);
                    }
                    if (bArrI == null) {
                        advertiseDataBuild = null;
                    } else if (i9 == -1) {
                        advertiseDataBuild = (i9 == 0 || r(bArr)) ? new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z5).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceData(new ParcelUuid(oe.c.f8449m), bArrI).build() : new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z5).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).build();
                    } else {
                        h.d("Unknown Scenario: " + i9 + ", use default advertising data", null);
                        advertiseDataBuild = null;
                    }
                    if (i9 != -1) {
                        mes = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("welinkBLE", mes, null);
                        }
                    } else if (i9 != 0) {
                        h.g("RUN MODE, SCREEN CAST");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 1) {
                        h.g("RUN MODE, AIR PARCEL DROP");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 4) {
                        h.g("RUN MODE, CLIPBOARD SHARE");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 5) {
                        h.g("RUN MODE, HANDOFF DATA");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 == 8) {
                        h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 251) {
                        switch (i9) {
                            case 10:
                                h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 11:
                                h.g("RUN MODE, KEYBOARD MOUSE SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 12:
                                h.g("RUN MODE, CALL SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 13:
                                h.g("RUN MODE, CAMERA SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            default:
                                mes2 = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                                Intrinsics.checkNotNullParameter(mes2, "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("welinkBLE", mes2, null);
                                }
                                break;
                        }
                    } else {
                        h.g("RUN MODE, General Mode");
                        advertiseDataC = c(arrayList, i9, i10, context, bArr);
                    }
                    advertiseDataC = null;
                } else {
                    c10 = 1;
                    b11 = 6;
                }
                if (b10 == b11 || bArrG[c10] != 10) {
                    advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z2).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceUuid(new ParcelUuid(oe.c.f8449m)).build();
                } else {
                    h.d("RUN PC MODE", null);
                    ArrayList arrayList2 = new ArrayList();
                    String address = bluetoothAdapter.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    byte[] bArrD = q.d(address);
                    arrayList2.add(Byte.valueOf(bArrD[0]));
                    arrayList2.add(Byte.valueOf(bArrD[1]));
                    arrayList2.add(Byte.valueOf(bArrD[2]));
                    arrayList2.add(Byte.valueOf(bArrD[3]));
                    arrayList2.add(Byte.valueOf(bArrD[4]));
                    arrayList2.add(Byte.valueOf(bArrD[5]));
                    if (bArrG.length >= 16) {
                        arrayList2.add(Byte.valueOf(bArrG[9]));
                        arrayList2.add(Byte.valueOf(bArrG[10]));
                        arrayList2.add(Byte.valueOf(bArrG[11]));
                        arrayList2.add(Byte.valueOf(bArrG[12]));
                        arrayList2.add(Byte.valueOf(bArrG[13]));
                        arrayList2.add(Byte.valueOf(bArrG[14]));
                        arrayList2.add(Byte.valueOf(bArrG[15]));
                        if (bArrG[15] == 15) {
                            arrayList2.add(Byte.valueOf(bArrG[1]));
                            arrayList2.add(Byte.valueOf(bArrG[3]));
                            arrayList2.add(Byte.valueOf(bArrG[7]));
                            arrayList2.add(Byte.valueOf(bArrG[8]));
                            arrayList2.add((byte) 16);
                        }
                    }
                    advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z2).addServiceData(new ParcelUuid(oe.c.f8449m), CollectionsKt.toByteArray(arrayList2)).build();
                }
                advertiseDataC = null;
            } else {
                h.d("RUN PHONE/PAD MODE, BT MAC" + bluetoothAdapter.getAddress(), null);
                z5 = f8187g;
                bArrI = i(CollectionsKt.toByteArray(arrayList));
                if (bArrI != null) {
                    strC = q.c(bArrI);
                } else {
                    strC = null;
                }
                h0.a.D("deviceRandomId is ", strC, "AdvertiseTool");
                if (bArrI != null) {
                    Intrinsics.checkNotNullParameter(bArrI, "<this>");
                    strB = str2;
                    i11 = 0;
                    while (i11 < length) {
                        byte b15 = bArrI[i11];
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b15)}, 1, "%02x ", "format(...)"));
                        i11++;
                    }
                    h.g(strB);
                }
                if (bArrI == null) {
                    advertiseDataBuild = null;
                } else if (i9 == -1) {
                    h.d("Unknown Scenario: " + i9 + ", use default advertising data", null);
                    advertiseDataBuild = null;
                } else if (i9 == 0) {
                    advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z5).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceData(new ParcelUuid(oe.c.f8449m), bArrI).build();
                }
                if (i9 != -1) {
                    mes = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("welinkBLE", mes, null);
                    }
                } else if (i9 != 0) {
                    h.g("RUN MODE, SCREEN CAST");
                    advertiseDataC = c(arrayList, i9, i10, null, bArr);
                } else if (i9 != 1) {
                    h.g("RUN MODE, AIR PARCEL DROP");
                    advertiseDataC = c(arrayList, i9, i10, null, bArr);
                } else if (i9 != 4) {
                    h.g("RUN MODE, CLIPBOARD SHARE");
                    advertiseDataC = c(arrayList, i9, i10, null, bArr);
                } else if (i9 != 5) {
                    h.g("RUN MODE, HANDOFF DATA");
                    advertiseDataC = c(arrayList, i9, i10, null, bArr);
                } else if (i9 == 8) {
                    h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                    advertiseDataC = c(arrayList, i9, i10, null, bArr);
                } else if (i9 != 251) {
                    switch (i9) {
                        case 10:
                            h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                            advertiseDataC = c(arrayList, i9, i10, null, bArr);
                            break;
                        case 11:
                            h.g("RUN MODE, KEYBOARD MOUSE SHARE");
                            advertiseDataC = c(arrayList, i9, i10, null, bArr);
                            break;
                        case 12:
                            h.g("RUN MODE, CALL SHARE");
                            advertiseDataC = c(arrayList, i9, i10, null, bArr);
                            break;
                        case 13:
                            h.g("RUN MODE, CAMERA SHARE");
                            advertiseDataC = c(arrayList, i9, i10, null, bArr);
                            break;
                        default:
                            mes2 = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                            Intrinsics.checkNotNullParameter(mes2, "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("welinkBLE", mes2, null);
                            }
                            break;
                    }
                } else {
                    h.g("RUN MODE, General Mode");
                    advertiseDataC = c(arrayList, i9, i10, context, bArr);
                }
                advertiseDataC = null;
            }
            advertiseSettingsBuild = new AdvertiseSettings.Builder().setAdvertiseMode(i8).setTimeout(0).setConnectable(f8189i).setTxPowerLevel(3).build();
            Intrinsics.checkNotNullExpressionValue(advertiseSettingsBuild, "build(...)");
            BluetoothLeAdvertiser bluetoothLeAdvertiser2 = bluetoothAdapter.getBluetoothLeAdvertiser();
            f8184b = bluetoothLeAdvertiser2;
            h.g("startAdvertisement: with advertiser " + bluetoothLeAdvertiser2);
            if (f8185c == null) {
                f8185c = new a();
            }
            bluetoothAdapter.isLeExtendedAdvertisingSupported();
            bluetoothLeAdvertiser = f8184b;
            if (bluetoothLeAdvertiser != null) {
                bluetoothLeAdvertiser.startAdvertising(advertiseSettingsBuild, advertiseDataBuild, advertiseDataC, f8185c);
            }
        }
        h.i("Bluetooth name is too long, remaining room is " + i12, null);
        if (i12 < 4) {
            f8187g = false;
            h.d("Bluetooth name is too short, skip setAdapterName.", null);
        } else if (name2 != null && length3 > i12) {
            String strA = q.a(i12, name2);
            v(f8190j);
            h.j("AdvertiseTool", "Bluetooth name is abbreviated, new name is " + strA);
        }
        c9 = 0;
        b10 = bArrG[c9];
        if (b10 == 6) {
            if (b10 != 6) {
                if (bArrG[1] == 21) {
                    h.d("RUN PHONE/PAD MODE, BT MAC" + bluetoothAdapter.getAddress(), null);
                    z5 = f8187g;
                    bArrI = i(CollectionsKt.toByteArray(arrayList));
                    if (bArrI != null) {
                        strC = q.c(bArrI);
                    } else {
                        strC = null;
                    }
                    h0.a.D("deviceRandomId is ", strC, "AdvertiseTool");
                    if (bArrI != null) {
                        Intrinsics.checkNotNullParameter(bArrI, "<this>");
                        strB = str2;
                        i11 = 0;
                        while (i11 < length) {
                            byte b16 = bArrI[i11];
                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                            strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b16)}, 1, "%02x ", "format(...)"));
                            i11++;
                        }
                        h.g(strB);
                    }
                    if (bArrI == null) {
                        advertiseDataBuild = null;
                    } else if (i9 == -1) {
                        h.d("Unknown Scenario: " + i9 + ", use default advertising data", null);
                        advertiseDataBuild = null;
                    } else if (i9 == 0) {
                        advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z5).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceData(new ParcelUuid(oe.c.f8449m), bArrI).build();
                    }
                    if (i9 != -1) {
                        mes = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("welinkBLE", mes, null);
                        }
                    } else if (i9 != 0) {
                        h.g("RUN MODE, SCREEN CAST");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 1) {
                        h.g("RUN MODE, AIR PARCEL DROP");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 4) {
                        h.g("RUN MODE, CLIPBOARD SHARE");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 5) {
                        h.g("RUN MODE, HANDOFF DATA");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 == 8) {
                        h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 251) {
                        switch (i9) {
                            case 10:
                                h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 11:
                                h.g("RUN MODE, KEYBOARD MOUSE SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 12:
                                h.g("RUN MODE, CALL SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 13:
                                h.g("RUN MODE, CAMERA SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            default:
                                mes2 = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                                Intrinsics.checkNotNullParameter(mes2, "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("welinkBLE", mes2, null);
                                }
                                break;
                        }
                    } else {
                        h.g("RUN MODE, General Mode");
                        advertiseDataC = c(arrayList, i9, i10, context, bArr);
                    }
                } else {
                    c10 = 1;
                    b11 = 6;
                }
                advertiseSettingsBuild = new AdvertiseSettings.Builder().setAdvertiseMode(i8).setTimeout(0).setConnectable(f8189i).setTxPowerLevel(3).build();
                Intrinsics.checkNotNullExpressionValue(advertiseSettingsBuild, "build(...)");
                BluetoothLeAdvertiser bluetoothLeAdvertiser3 = bluetoothAdapter.getBluetoothLeAdvertiser();
                f8184b = bluetoothLeAdvertiser3;
                h.g("startAdvertisement: with advertiser " + bluetoothLeAdvertiser3);
                if (f8185c == null) {
                    f8185c = new a();
                }
                bluetoothAdapter.isLeExtendedAdvertisingSupported();
                bluetoothLeAdvertiser = f8184b;
                if (bluetoothLeAdvertiser != null) {
                    bluetoothLeAdvertiser.startAdvertising(advertiseSettingsBuild, advertiseDataBuild, advertiseDataC, f8185c);
                }
            }
            c10 = 1;
            b11 = 6;
            if (b10 == b11) {
                advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z2).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceUuid(new ParcelUuid(oe.c.f8449m)).build();
            } else {
                advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z2).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceUuid(new ParcelUuid(oe.c.f8449m)).build();
            }
        } else {
            if (b10 != 6) {
                if (bArrG[1] == 21) {
                    h.d("RUN PHONE/PAD MODE, BT MAC" + bluetoothAdapter.getAddress(), null);
                    z5 = f8187g;
                    bArrI = i(CollectionsKt.toByteArray(arrayList));
                    if (bArrI != null) {
                        strC = q.c(bArrI);
                    } else {
                        strC = null;
                    }
                    h0.a.D("deviceRandomId is ", strC, "AdvertiseTool");
                    if (bArrI != null) {
                        Intrinsics.checkNotNullParameter(bArrI, "<this>");
                        strB = str2;
                        i11 = 0;
                        while (i11 < length) {
                            byte b17 = bArrI[i11];
                            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                            strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b17)}, 1, "%02x ", "format(...)"));
                            i11++;
                        }
                        h.g(strB);
                    }
                    if (bArrI == null) {
                        advertiseDataBuild = null;
                    } else if (i9 == -1) {
                        h.d("Unknown Scenario: " + i9 + ", use default advertising data", null);
                        advertiseDataBuild = null;
                    } else if (i9 == 0) {
                        advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z5).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceData(new ParcelUuid(oe.c.f8449m), bArrI).build();
                    }
                    if (i9 != -1) {
                        mes = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                        Intrinsics.checkNotNullParameter(mes, "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("welinkBLE", mes, null);
                        }
                    } else if (i9 != 0) {
                        h.g("RUN MODE, SCREEN CAST");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 1) {
                        h.g("RUN MODE, AIR PARCEL DROP");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 4) {
                        h.g("RUN MODE, CLIPBOARD SHARE");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 5) {
                        h.g("RUN MODE, HANDOFF DATA");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 == 8) {
                        h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                        advertiseDataC = c(arrayList, i9, i10, null, bArr);
                    } else if (i9 != 251) {
                        switch (i9) {
                            case 10:
                                h.g("RUN MODE, NEW AIR CAST or Audio Sink");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 11:
                                h.g("RUN MODE, KEYBOARD MOUSE SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 12:
                                h.g("RUN MODE, CALL SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            case 13:
                                h.g("RUN MODE, CAMERA SHARE");
                                advertiseDataC = c(arrayList, i9, i10, null, bArr);
                                break;
                            default:
                                mes2 = "Unknown Scenario: " + i9 + ", in Mobile Phone Mode";
                                Intrinsics.checkNotNullParameter(mes2, "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("welinkBLE", mes2, null);
                                }
                                break;
                        }
                    } else {
                        h.g("RUN MODE, General Mode");
                        advertiseDataC = c(arrayList, i9, i10, context, bArr);
                    }
                } else {
                    c10 = 1;
                    b11 = 6;
                }
                advertiseSettingsBuild = new AdvertiseSettings.Builder().setAdvertiseMode(i8).setTimeout(0).setConnectable(f8189i).setTxPowerLevel(3).build();
                Intrinsics.checkNotNullExpressionValue(advertiseSettingsBuild, "build(...)");
                BluetoothLeAdvertiser bluetoothLeAdvertiser4 = bluetoothAdapter.getBluetoothLeAdvertiser();
                f8184b = bluetoothLeAdvertiser4;
                h.g("startAdvertisement: with advertiser " + bluetoothLeAdvertiser4);
                if (f8185c == null) {
                    f8185c = new a();
                }
                bluetoothAdapter.isLeExtendedAdvertisingSupported();
                bluetoothLeAdvertiser = f8184b;
                if (bluetoothLeAdvertiser != null) {
                    bluetoothLeAdvertiser.startAdvertising(advertiseSettingsBuild, advertiseDataBuild, advertiseDataC, f8185c);
                }
            }
            c10 = 1;
            b11 = 6;
            if (b10 == b11) {
                advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z2).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceUuid(new ParcelUuid(oe.c.f8449m)).build();
            } else {
                advertiseDataBuild = new AdvertiseData.Builder().setIncludeTxPowerLevel(false).setIncludeDeviceName(z2).addManufacturerData(iM177constructorimpl, CollectionsKt.toByteArray(arrayList)).addServiceUuid(new ParcelUuid(oe.c.f8449m)).build();
            }
        }
        advertiseDataC = null;
        advertiseSettingsBuild = new AdvertiseSettings.Builder().setAdvertiseMode(i8).setTimeout(0).setConnectable(f8189i).setTxPowerLevel(3).build();
        Intrinsics.checkNotNullExpressionValue(advertiseSettingsBuild, "build(...)");
        BluetoothLeAdvertiser bluetoothLeAdvertiser5 = bluetoothAdapter.getBluetoothLeAdvertiser();
        f8184b = bluetoothLeAdvertiser5;
        h.g("startAdvertisement: with advertiser " + bluetoothLeAdvertiser5);
        if (f8185c == null) {
            f8185c = new a();
        }
        bluetoothAdapter.isLeExtendedAdvertisingSupported();
        bluetoothLeAdvertiser = f8184b;
        if (bluetoothLeAdvertiser != null) {
            bluetoothLeAdvertiser.startAdvertising(advertiseSettingsBuild, advertiseDataBuild, advertiseDataC, f8185c);
        }
    }

    public static void y() {
        a aVar;
        if (!BluetoothAdapter.getDefaultAdapter().isEnabled()) {
            Intrinsics.checkNotNullParameter("stopBtDiscoverable: 蓝牙已关闭！", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "stopBtDiscoverable: 蓝牙已关闭！", null);
            }
            f8191k = false;
            e();
            t();
            return;
        }
        h.g("Stopping Advertising with advertiser " + f8184b);
        BluetoothLeAdvertiser bluetoothLeAdvertiser = f8184b;
        if (bluetoothLeAdvertiser != null && (aVar = f8185c) != null) {
            if (aVar != null) {
                bluetoothLeAdvertiser.stopAdvertising(aVar);
            }
            f8185c = null;
        }
        f8191k = false;
        e();
        t();
    }
}
