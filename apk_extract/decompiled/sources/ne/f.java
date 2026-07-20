package ne;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.ParcelUuid;
import android.util.Log;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.utils.DeviceInfo;
import df.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import k3.zb;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import m3.q;
import m3.r6;
import se.h5;
import se.k;
import se.z6;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f8195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BluetoothAdapter f8196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final UUID f8197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f8198d;
    public m e;
    public BluetoothLeScanner f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public lc.a f8199g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public h5 f8200h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public oe.e f8201i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object f8202j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final e f8203k;

    public f(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f8195a = mContext;
        this.f8196b = BluetoothAdapter.getDefaultAdapter();
        UUID uuidFromString = UUID.fromString("0000FD35-0000-1000-8000-00805f9b34fb");
        Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(...)");
        this.f8197c = uuidFromString;
        this.f8198d = new ArrayList();
        new ScanSettings.Builder().setScanMode(2).build();
        this.f8202j = new Object();
        mContext.registerReceiver(new BroadcastReceiver() { // from class: com.welink.protocol.ble.BleScanTool$registerBleScanReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                if (StringsKt__StringsJVMKt.equals$default(intent.getAction(), "android.bluetooth.adapter.action.STATE_CHANGED", false, 2, null)) {
                    int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", Integer.MIN_VALUE);
                    int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                    h.h("BleScanTool", "BT state change " + intExtra + " -> " + intExtra2);
                    if (intExtra2 == 10) {
                        this.f3843a.f(1);
                    }
                }
            }
        }, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"), 2);
        Object systemService = mContext.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.f8196b = ((BluetoothManager) systemService).getAdapter();
        new se.g(this);
        this.f8203k = new e(this);
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0300  */
    /* JADX WARN: Code duplicated, block: B:124:0x0304  */
    /* JADX WARN: Code duplicated, block: B:129:0x0342  */
    /* JADX WARN: Code duplicated, block: B:255:0x068b  */
    /* JADX WARN: Code duplicated, block: B:258:0x06a7  */
    /* JADX WARN: Code duplicated, block: B:260:0x06ce  */
    /* JADX WARN: Code duplicated, block: B:262:0x06d3  */
    /* JADX WARN: Code duplicated, block: B:315:0x086f A[LOOP:5: B:314:0x086d->B:315:0x086f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:320:0x08c6  */
    /* JADX WARN: Code duplicated, block: B:323:0x08e2  */
    /* JADX WARN: Code duplicated, block: B:324:0x08eb  */
    /* JADX WARN: Code duplicated, block: B:327:0x08f3  */
    /* JADX WARN: Code duplicated, block: B:330:0x0900  */
    /* JADX WARN: Code duplicated, block: B:333:0x090a  */
    /* JADX WARN: Code duplicated, block: B:334:0x090d  */
    /* JADX WARN: Code duplicated, block: B:411:0x0ae6 A[PHI: r1
      0x0ae6: PHI (r1v46 java.lang.String) = (r1v43 java.lang.String), (r1v47 java.lang.String) binds: [B:416:0x0af5, B:409:0x0ae3] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:443:0x0bcc A[PHI: r1
      0x0bcc: PHI (r1v36 java.lang.String) = (r1v33 java.lang.String), (r1v37 java.lang.String) binds: [B:448:0x0bdb, B:441:0x0bc9] A[DONT_GENERATE, DONT_INLINE]] */
    public static DeviceInfo a(ScanResult scanResult) {
        byte b9;
        ScanRecord scanRecord;
        ScanRecord scanRecord2;
        String deviceName;
        String address;
        byte b10;
        byte b11;
        byte[] bArr;
        ArrayList arrayList;
        String deviceName2;
        String address2;
        ScanRecord scanRecord3;
        char c9;
        String str;
        String str2;
        int i8;
        LinkedHashMap linkedHashMap;
        String str3;
        String strC;
        int i9;
        LinkedHashMap linkedHashMapB;
        byte b12;
        String str4;
        String strO;
        String str5;
        String str6;
        String str7;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        byte b13;
        ConcurrentHashMap concurrentHashMap4;
        String str8;
        ArrayList arrayList2;
        int i10;
        byte[] bArrP;
        int i11;
        byte b14;
        k kVar;
        int iO;
        List listN;
        String str9;
        String str10;
        byte bByteValue;
        String str11;
        byte[] bArr2;
        String str12;
        String str13;
        String str14;
        StringBuilder sb2;
        int length;
        int iE;
        String str15;
        byte b15;
        String str16;
        String str17;
        int i12;
        int i13;
        byte b16;
        byte[] bArr3;
        ArrayList arrayList3;
        String str18;
        String str19;
        String deviceName3;
        String str20;
        String str21;
        ScanRecord scanRecord4;
        String str22 = "Unparsed Device Wireless Capability is :";
        byte[] manufacturerSpecificData = (scanResult == null || (scanRecord4 = scanResult.getScanRecord()) == null) ? null : scanRecord4.getManufacturerSpecificData((UByte.m177constructorimpl((byte) 66) & UByte.MAX_VALUE) | ((UByte.m177constructorimpl((byte) 9) & UByte.MAX_VALUE) << 8));
        String str23 = "Device information is :";
        if (manufacturerSpecificData == null || manufacturerSpecificData.length < 6) {
            byte[] serviceData = (scanResult == null || (scanRecord3 = scanResult.getScanRecord()) == null) ? null : scanRecord3.getServiceData(z6.f10087c);
            if (serviceData != null) {
                byte[] bArr4 = new byte[6];
                System.arraycopy(serviceData, 0, bArr4, 0, 6);
                String strC2 = q.c(bArr4);
                if (serviceData.length >= 13) {
                    byte b17 = serviceData[12];
                    if (b17 == 7 || b17 == 15) {
                        if (serviceData.length == 13 && b17 == 7) {
                            return new DeviceInfo((byte) 10, (byte) -1, "0000", strC2, Boolean.FALSE, (EarBudsInfo) null, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2097088);
                        }
                        if (serviceData.length < 18) {
                            h.h("BleScanTool", "serviceData size is less than 18, ignore it");
                            return null;
                        }
                        byte b18 = serviceData[17];
                        UByte.m177constructorimpl(b18);
                        UByte.m177constructorimpl((byte) (serviceData[17] & 15));
                        if (b18 == 16) {
                            byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.drop(serviceData, 13));
                            String strG = g(byteArray);
                            byte b19 = byteArray[0];
                            byte b20 = byteArray[1];
                            byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray, 2));
                            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                            String strO2 = h0.a.o(new Object[]{Byte.valueOf(byteArray2[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray2[0])}, 1, "%02x", "format(...)"));
                            if (b19 != 10) {
                                return null;
                            }
                            Boolean bool = Boolean.FALSE;
                            BluetoothDevice device = scanResult.getDevice();
                            if (device == null || (deviceName = device.getName()) == null) {
                                ScanRecord scanRecord5 = scanResult.getScanRecord();
                                deviceName = scanRecord5 != null ? scanRecord5.getDeviceName() : null;
                                if (deviceName == null) {
                                    BluetoothDevice device2 = scanResult.getDevice();
                                    address = device2 != null ? device2.getAddress() : null;
                                } else {
                                    address = deviceName;
                                }
                            } else {
                                address = deviceName;
                            }
                            return new DeviceInfo(b19, b20, strO2, strC2, bool, (EarBudsInfo) null, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, address, (String) null, (byte) 0, 0, 0, 0, (String) null, strG);
                        }
                    } else if (b17 == 1) {
                        if (serviceData.length < 18) {
                            h.h("BleScanTool", "serviceData size is less than 18, ignore it");
                            return null;
                        }
                        byte b21 = serviceData[17];
                        UByte.m177constructorimpl(b21);
                        UByte.m177constructorimpl((byte) (serviceData[17] & 15));
                        byte[] bArr5 = new byte[6];
                        System.arraycopy(serviceData, 6, bArr5, 0, 6);
                        LinkedHashMap linkedHashMapB2 = zb.b(CollectionsKt.toByteArray(ArraysKt___ArraysKt.dropLast(bArr5, 2)));
                        if (b21 == 16 || b21 == 17) {
                            byte[] byteArray3 = CollectionsKt.toByteArray(ArraysKt.drop(serviceData, 13));
                            String strG2 = g(byteArray3);
                            byte b22 = byteArray3[0];
                            byte b23 = byteArray3[1];
                            byte[] byteArray4 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray3, 2));
                            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                            String strO3 = h0.a.o(new Object[]{Byte.valueOf(byteArray4[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray4[0])}, 1, "%02x", "format(...)"));
                            if (b22 != 10) {
                                return null;
                            }
                            if (linkedHashMapB2 != null) {
                                Iterator it = linkedHashMapB2.entrySet().iterator();
                                byte[] bArr6 = null;
                                ArrayList arrayListU = null;
                                byte b24 = 0;
                                byte b25 = 0;
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    byte bByteValue2 = ((Number) entry.getKey()).byteValue();
                                    byte[] bArr7 = (byte[]) entry.getValue();
                                    BluetoothAdapter bluetoothAdapter = b.f8183a;
                                    Iterator it2 = it;
                                    byte[] bArr8 = bArr6;
                                    if (bByteValue2 == ((byte) 255) || bByteValue2 == ((byte) 254) || bByteValue2 == ((byte) 253) || bByteValue2 == ((byte) 252)) {
                                        Intrinsics.checkNotNullParameter(bArr7, "<this>");
                                        StringBuilder sb3 = new StringBuilder();
                                        int length2 = bArr7.length;
                                        int iE2 = 0;
                                        while (iE2 < length2) {
                                            byte b26 = bArr7[iE2];
                                            StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                            iE2 = h0.a.e(new Object[]{Byte.valueOf(b26)}, 1, "%02x ", "format(...)", sb3, iE2, 1);
                                        }
                                        String string = sb3.toString();
                                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                        h.b("BleScanTool", "Device information is :" + string);
                                    } else {
                                        if (bByteValue2 == ((byte) 8) || bByteValue2 == ((byte) 1) || bByteValue2 == ((byte) 10) || bByteValue2 == ((byte) 5) || bByteValue2 == ((byte) 4) || bByteValue2 == ((byte) 11) || bByteValue2 == ((byte) 12) || bByteValue2 == ((byte) 13)) {
                                            arrayListU = b.u(bArr7);
                                            bArr6 = bArr7;
                                            b24 = bByteValue2;
                                        } else if (bByteValue2 == ((byte) l5.a.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED)) {
                                            b25 = bArr7[0];
                                        } else {
                                            StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                                            h.h("BleScanTool", h0.a.o(new Object[]{Byte.valueOf(bByteValue2)}, 1, "%02x", "format(...)", "Unknown TLV type: 0x"));
                                        }
                                        it = it2;
                                    }
                                    bArr6 = bArr8;
                                    it = it2;
                                }
                                Unit unit = Unit.INSTANCE;
                                arrayList = arrayListU;
                                b10 = b24;
                                b11 = b25;
                                bArr = bArr6;
                            } else {
                                b10 = 0;
                                b11 = 0;
                                bArr = null;
                                arrayList = null;
                            }
                            String strA = zb.a(b21);
                            Boolean bool2 = Boolean.FALSE;
                            BluetoothDevice device3 = scanResult.getDevice();
                            if (device3 == null || (deviceName2 = device3.getName()) == null) {
                                ScanRecord scanRecord6 = scanResult.getScanRecord();
                                deviceName2 = scanRecord6 != null ? scanRecord6.getDeviceName() : null;
                                if (deviceName2 == null) {
                                    BluetoothDevice device4 = scanResult.getDevice();
                                    address2 = device4 != null ? device4.getAddress() : null;
                                } else {
                                    address2 = deviceName2;
                                }
                            } else {
                                address2 = deviceName2;
                            }
                            return new DeviceInfo(b22, b23, strO3, strC2, bool2, (EarBudsInfo) null, 0, b10, b11, 0, strA, bArr, arrayList, address2, (String) null, (byte) 0, 0, 0, 0, (String) null, strG2);
                        }
                    }
                }
            } else {
                List<ParcelUuid> serviceUuids = (scanResult == null || (scanRecord2 = scanResult.getScanRecord()) == null) ? null : scanRecord2.getServiceUuids();
                List<ParcelUuid> list = serviceUuids;
                if (list != null && !list.isEmpty() && serviceUuids.contains(z6.f10087c)) {
                    h.h("BleScanTool", "Apple serviceDate UUID : " + serviceUuids);
                    String deviceName4 = (scanResult == null || (scanRecord = scanResult.getScanRecord()) == null) ? null : scanRecord.getDeviceName();
                    h0.a.D("Apple serviceDate serviceName : ", deviceName4, "BleScanTool");
                    if (deviceName4 == null) {
                        h.b("BleScanTool", "Apple serviceDate name is null");
                        return null;
                    }
                    int length3 = deviceName4.length();
                    h0.a.u(length3, "Apple serviceDate size : ", "BleScanTool");
                    if (length3 >= 10) {
                        String strTake = StringsKt.take(deviceName4, 10);
                        if (!new Regex("^[0-9A-Fa-f]*$").matches(strTake)) {
                            h0.a.D("The first 10 characters contain non-hexadecimal characters: ", strTake, "BleScanTool");
                            return null;
                        }
                        String strSubstring = deviceName4.substring(0, 2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                        if (((Integer.parseInt(strSubstring, CharsKt.checkRadix(16)) & 248) >> 3) != 1) {
                            h.b("BleScanTool", "Apple serviceDate unknow version");
                            return null;
                        }
                        String strSubstring2 = deviceName4.substring(0, 2);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        byte b27 = (byte) (Integer.parseInt(strSubstring2, CharsKt.checkRadix(16)) & 7);
                        String strSubstring3 = deviceName4.substring(2, 4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                        byte b28 = (byte) (Integer.parseInt(strSubstring3, CharsKt.checkRadix(16)) & 15);
                        String strSubstring4 = deviceName4.substring(2, 4);
                        Intrinsics.checkNotNullExpressionValue(strSubstring4, "substring(...)");
                        byte b29 = (byte) ((Integer.parseInt(strSubstring4, CharsKt.checkRadix(16)) & 240) >> 4);
                        String strSubstring5 = deviceName4.substring(4, 6);
                        Intrinsics.checkNotNullExpressionValue(strSubstring5, "substring(...)");
                        int i14 = (Integer.parseInt(strSubstring5, CharsKt.checkRadix(16)) & 240) >> 4;
                        String strSubstring6 = deviceName4.substring(4, 6);
                        Intrinsics.checkNotNullExpressionValue(strSubstring6, "substring(...)");
                        byte b30 = (byte) (Integer.parseInt(strSubstring6, CharsKt.checkRadix(16)) & 15);
                        String strSubstring7 = deviceName4.substring(6, 8);
                        Intrinsics.checkNotNullExpressionValue(strSubstring7, "substring(...)");
                        byte b31 = (byte) Integer.parseInt(strSubstring7, CharsKt.checkRadix(16));
                        String strSubstring8 = deviceName4.substring(8, 10);
                        Intrinsics.checkNotNullExpressionValue(strSubstring8, "substring(...)");
                        String strC3 = q.c(new byte[]{b30, b31, (byte) Integer.parseInt(strSubstring8, CharsKt.checkRadix(16)), 0, 0, 0});
                        String strSubstring9 = deviceName4.substring(10, length3);
                        Intrinsics.checkNotNullExpressionValue(strSubstring9, "substring(...)");
                        if (b27 == 1) {
                            b9 = 22;
                        } else if (b27 == 2) {
                            b9 = 23;
                        } else {
                            if (b27 != 3) {
                                h.c("BleScanTool", "Apple serviceDate unknown subtype : " + ((int) b27), null);
                                return null;
                            }
                            b9 = 24;
                        }
                        byte b32 = b9;
                        if (b29 != 1) {
                            h.c("BleScanTool", "Apple serviceDate unknown action : " + ((int) b29), null);
                        }
                        if (b28 == 1) {
                            return new DeviceInfo(b32, (byte) -8, (String) null, strC3, Boolean.FALSE, (EarBudsInfo) null, 0, 1, 0, 0, "1.0", new byte[]{b28, 0}, (List) null, strSubstring9, (String) null, b29, i14, 0, 0, (String) null, 1966080);
                        }
                        h.c("BleScanTool", "Apple serviceDate unknown serviceId : " + ((int) b28), null);
                        return null;
                    }
                }
            }
        } else {
            byte b33 = manufacturerSpecificData[0];
            if (b33 == 16) {
                return c(manufacturerSpecificData);
            }
            if (b33 == 19) {
                byte[] byteArray5 = CollectionsKt.toByteArray(ArraysKt.take(manufacturerSpecificData, 4));
                byte b34 = byteArray5[0];
                if (b34 != 19) {
                    return null;
                }
                byte b35 = byteArray5[1];
                EarBudsInfo earBudsInfoB = b(manufacturerSpecificData);
                String string2 = Integer.toString(((UByte.m177constructorimpl(manufacturerSpecificData[2]) & UByte.MAX_VALUE) << 8) | (255 & UByte.m177constructorimpl(manufacturerSpecificData[3])), CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                String upperCase = string2.toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                return new DeviceInfo(b34, b35, upperCase, earBudsInfoB != null ? earBudsInfoB.p : null, Boolean.FALSE, earBudsInfoB, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2097088);
            }
            if (manufacturerSpecificData.length > 6) {
                str = new String(CollectionsKt.toByteArray(ArraysKt.takeLast(manufacturerSpecificData, manufacturerSpecificData.length - 6)), Charsets.UTF_8);
                c9 = 5;
            } else {
                c9 = 5;
                str = null;
            }
            if (manufacturerSpecificData[c9] == 0) {
                byte b36 = manufacturerSpecificData[4];
                UByte.m177constructorimpl(b36);
                UByte.m177constructorimpl((byte) (manufacturerSpecificData[4] & 15));
                int iM177constructorimpl = UByte.m177constructorimpl(b36) & UByte.MAX_VALUE;
                if (iM177constructorimpl == 16) {
                    byte[] byteArray6 = CollectionsKt.toByteArray(ArraysKt.take(manufacturerSpecificData, 4));
                    String strG3 = g(byteArray6);
                    byte b37 = byteArray6[0];
                    if ((b37 == 2 || b37 == 14) && manufacturerSpecificData.length < 8) {
                        return null;
                    }
                    byte b38 = byteArray6[1];
                    byte[] byteArray7 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray6, 2));
                    StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                    String strO4 = h0.a.o(new Object[]{Byte.valueOf(byteArray7[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray7[0])}, 1, "%02x", "format(...)"));
                    return ((b37 == 2 || b37 == 14) && manufacturerSpecificData.length >= 8) ? new DeviceInfo(b37, b38, strO4, (String) null, Boolean.TRUE, d(manufacturerSpecificData), 0, 15, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, strG3) : new DeviceInfo(b37, b38, strO4, (String) null, Boolean.FALSE, (EarBudsInfo) null, 0, 15, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, strG3);
                }
                if (17 <= iM177constructorimpl && iM177constructorimpl < 256) {
                    byte[] byteArray8 = CollectionsKt.toByteArray(ArraysKt.take(manufacturerSpecificData, 4));
                    String strG4 = g(byteArray8);
                    byte b39 = byteArray8[0];
                    if ((b39 == 2 || b39 == 14) && manufacturerSpecificData.length < 8) {
                        return null;
                    }
                    if (b39 == 13 || b39 == 18 || b39 == 15 || b39 == 21 || b39 == 10) {
                        ScanRecord scanRecord7 = scanResult.getScanRecord();
                        byte[] serviceData2 = scanRecord7 != null ? scanRecord7.getServiceData(new ParcelUuid(oe.c.f8449m)) : null;
                        if (serviceData2 != null) {
                            byte[] bArr9 = new byte[6];
                            str2 = "Unknown TLV type: 0x";
                            int iM177constructorimpl2 = UByte.m177constructorimpl(b36) & UByte.MAX_VALUE;
                            if (17 <= iM177constructorimpl2) {
                                i8 = 20;
                                if (iM177constructorimpl2 < 20) {
                                    if (serviceData2.length < 6) {
                                        BluetoothDevice device5 = scanResult.getDevice();
                                        if (device5 != null) {
                                            String address3 = device5.getAddress();
                                            Unit unit2 = Unit.INSTANCE;
                                            strC = address3;
                                            linkedHashMapB = null;
                                        } else {
                                            linkedHashMapB = null;
                                            strC = null;
                                        }
                                    } else {
                                        ArraysKt.copyInto(serviceData2, bArr9, 0, 0, 6);
                                        strC = q.c(bArr9);
                                        linkedHashMapB = zb.b(CollectionsKt.toByteArray(ArraysKt.drop(serviceData2, 6)));
                                        if (linkedHashMapB == null) {
                                            return null;
                                        }
                                        Unit unit3 = Unit.INSTANCE;
                                    }
                                    linkedHashMap = linkedHashMapB;
                                }
                                i9 = 1;
                                b12 = byteArray8[i9];
                                byte[] byteArray9 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray8, 2));
                                StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                                str4 = strC;
                                strO = h0.a.o(new Object[]{Byte.valueOf(byteArray9[i9])}, i9, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray9[0])}, i9, "%02x", "format(...)"));
                                if ((b39 == 2 && b39 != 14) || manufacturerSpecificData.length < 8) {
                                    str5 = "Device Feature is :";
                                    if (b39 == 13 && b39 != 18 && b39 != 15 && b39 != 21) {
                                        if (b39 != 10) {
                                            if (b39 == 0 || b39 == 1 || b39 == 20) {
                                                return new DeviceInfo(b39, b12, strO, (String) null, Boolean.FALSE, (EarBudsInfo) null, 0, 15, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, strG4);
                                            }
                                            return null;
                                        }
                                        String strA2 = zb.a(b36);
                                        if (linkedHashMap != null) {
                                            Iterator it3 = linkedHashMap.entrySet().iterator();
                                            String str24 = str4;
                                            String strC4 = null;
                                            byte[] bArr10 = null;
                                            ArrayList arrayListU2 = null;
                                            str17 = null;
                                            byte b40 = 0;
                                            int i15 = 0;
                                            int iM177constructorimpl3 = 251;
                                            while (it3.hasNext()) {
                                                Map.Entry entry2 = (Map.Entry) it3.next();
                                                byte bByteValue3 = ((Number) entry2.getKey()).byteValue();
                                                Iterator it4 = it3;
                                                byte[] bArr11 = (byte[]) entry2.getValue();
                                                BluetoothAdapter bluetoothAdapter2 = b.f8183a;
                                                String str25 = strO;
                                                byte b41 = b12;
                                                if (bByteValue3 == ((byte) 254) || bByteValue3 == ((byte) 253)) {
                                                    str20 = str2;
                                                    Intrinsics.checkNotNullParameter(bArr11, "<this>");
                                                    StringBuilder sb4 = new StringBuilder();
                                                    int length4 = bArr11.length;
                                                    int iE3 = 0;
                                                    while (iE3 < length4) {
                                                        byte b42 = bArr11[iE3];
                                                        StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
                                                        iE3 = h0.a.e(new Object[]{Byte.valueOf(b42)}, 1, "%02x ", "format(...)", sb4, iE3, 1);
                                                    }
                                                    String string3 = sb4.toString();
                                                    Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                                                    str21 = str23;
                                                    h.b("BleScanTool", str21 + string3);
                                                } else {
                                                    if (bByteValue3 == ((byte) 255)) {
                                                        String strC5 = q.c(bArr11);
                                                        if (!Intrinsics.areEqual(str24, strC5)) {
                                                            str24 = strC5;
                                                        }
                                                    } else if (bByteValue3 == ((byte) 252)) {
                                                        Intrinsics.checkNotNullParameter(bArr11, "<this>");
                                                        StringBuilder sb5 = new StringBuilder();
                                                        int length5 = bArr11.length;
                                                        int iE4 = 0;
                                                        while (iE4 < length5) {
                                                            byte b43 = bArr11[iE4];
                                                            StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
                                                            iE4 = h0.a.e(new Object[]{Byte.valueOf(b43)}, 1, "%02x ", "format(...)", sb5, iE4, 1);
                                                        }
                                                        String string4 = sb5.toString();
                                                        Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                                                        h.b("BleScanTool", "Device Feature is :" + string4);
                                                        if (bArr11.length != 0) {
                                                            h0.a.C(UByte.m177constructorimpl(bArr11[0]) & UByte.MAX_VALUE, "Device Wireless Capability is :", "BleScanTool");
                                                            if (bArr11.length > 1) {
                                                                byte[] byteArray10 = CollectionsKt.toByteArray(ArraysKt.drop(bArr11, 1));
                                                                arrayListU2 = b.u(byteArray10);
                                                                if (b.q(byteArray10)) {
                                                                    h.b("BleScanTool", "Device Wireless Type is Bluetooth EDR");
                                                                    i15 = 1;
                                                                }
                                                            }
                                                            if (bArr11.length > 3) {
                                                                h0.a.C(UByte.m177constructorimpl(bArr11[3]) & UByte.MAX_VALUE, "Unparsed Device Wireless Capability is :", "BleScanTool");
                                                            }
                                                        }
                                                    } else if (bByteValue3 == ((byte) 173)) {
                                                        h.b("BleScanTool", "Device Mac Address is :".concat(q.c(bArr11)));
                                                        strC4 = q.c(bArr11);
                                                    } else if (bByteValue3 == ((byte) 239)) {
                                                        String str26 = new String(bArr11, Charsets.UTF_8);
                                                        h.b("BleScanTool", "Device Name is :" + ((Object) str26));
                                                        str17 = str26;
                                                    } else if (bByteValue3 == ((byte) 0) || bByteValue3 == ((byte) 8) || bByteValue3 == ((byte) 1) || bByteValue3 == ((byte) 10) || bByteValue3 == ((byte) 5) || bByteValue3 == ((byte) 4) || bByteValue3 == ((byte) 11) || bByteValue3 == ((byte) 12) || bByteValue3 == ((byte) 13)) {
                                                        int iM177constructorimpl4 = UByte.m177constructorimpl(bByteValue3) & UByte.MAX_VALUE;
                                                        ArrayList arrayListU3 = b.u(bArr11);
                                                        bArr10 = bArr11;
                                                        iM177constructorimpl3 = iM177constructorimpl4;
                                                        arrayListU2 = arrayListU3;
                                                    } else if (bByteValue3 == ((byte) 251)) {
                                                        bArr10 = bArr11;
                                                        iM177constructorimpl3 = UByte.m177constructorimpl(bByteValue3) & UByte.MAX_VALUE;
                                                    } else if (bByteValue3 == ((byte) l5.a.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED)) {
                                                        b40 = byteArray9[0];
                                                    } else {
                                                        StringCompanionObject stringCompanionObject9 = StringCompanionObject.INSTANCE;
                                                        str20 = str2;
                                                        h.h("BleScanTool", h0.a.o(new Object[]{Byte.valueOf(bByteValue3)}, 1, "%02x", "format(...)", str20));
                                                        str21 = str23;
                                                    }
                                                    str21 = str23;
                                                    str20 = str2;
                                                }
                                                str23 = str21;
                                                byteArray9 = byteArray9;
                                                it3 = it4;
                                                b12 = b41;
                                                str2 = str20;
                                                strO = str25;
                                            }
                                            str15 = strO;
                                            b15 = b12;
                                            Unit unit4 = Unit.INSTANCE;
                                            str16 = str24;
                                            str18 = strC4;
                                            bArr3 = bArr10;
                                            arrayList3 = arrayListU2;
                                            b16 = b40;
                                            i12 = i15;
                                            i13 = iM177constructorimpl3;
                                        } else {
                                            str15 = strO;
                                            b15 = b12;
                                            str16 = str4;
                                            str17 = null;
                                            i12 = 0;
                                            i13 = 251;
                                            b16 = 0;
                                            bArr3 = null;
                                            arrayList3 = null;
                                            str18 = null;
                                        }
                                        if (str16 != null) {
                                            str19 = str16;
                                        } else if (str18 == null) {
                                            BluetoothDevice device6 = scanResult.getDevice();
                                            String address4 = device6 != null ? device6.getAddress() : null;
                                            str19 = address4 == null ? "0xC2:0x00:0x00:0x00:0x00:0x00" : address4;
                                        } else {
                                            str19 = str18;
                                        }
                                        Boolean bool3 = Boolean.FALSE;
                                        if (str17 == null) {
                                            BluetoothDevice device7 = scanResult.getDevice();
                                            String name = device7 != null ? device7.getName() : null;
                                            if (name == null) {
                                                ScanRecord scanRecord8 = scanResult.getScanRecord();
                                                deviceName3 = scanRecord8 != null ? scanRecord8.getDeviceName() : null;
                                            } else {
                                                deviceName3 = name;
                                            }
                                        } else {
                                            deviceName3 = str17;
                                        }
                                        return new DeviceInfo(b39, b15, str15, str19, bool3, (EarBudsInfo) null, i12, i13, b16, 0, strA2, bArr3, arrayList3, deviceName3, str18, (byte) 0, 0, 0, 0, (String) null, strG4);
                                    }
                                    str6 = str23;
                                    str7 = str2;
                                    concurrentHashMap = new ConcurrentHashMap();
                                    concurrentHashMap2 = new ConcurrentHashMap();
                                    concurrentHashMap3 = new ConcurrentHashMap();
                                    if (linkedHashMap != null) {
                                        str10 = str4;
                                        byte[] bArr12 = null;
                                        ArrayList arrayListU4 = null;
                                        int i16 = 0;
                                        byte b44 = 0;
                                        int i17 = 0;
                                        for (Map.Entry entry3 : linkedHashMap.entrySet()) {
                                            byte b45 = b36;
                                            bByteValue = ((Number) entry3.getKey()).byteValue();
                                            str11 = str6;
                                            bArr2 = (byte[]) entry3.getValue();
                                            BluetoothAdapter bluetoothAdapter3 = b.f8183a;
                                            str12 = str7;
                                            ConcurrentHashMap concurrentHashMap5 = concurrentHashMap3;
                                            if (bByteValue != ((byte) 254) || bByteValue == ((byte) 253)) {
                                                str13 = str10;
                                                str14 = str5;
                                                str12 = str12;
                                                Intrinsics.checkNotNullParameter(bArr2, "<this>");
                                                sb2 = new StringBuilder();
                                                length = bArr2.length;
                                                iE = 0;
                                                while (iE < length) {
                                                    byte b46 = bArr2[iE];
                                                    StringCompanionObject stringCompanionObject10 = StringCompanionObject.INSTANCE;
                                                    iE = h0.a.e(new Object[]{Byte.valueOf(b46)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                                                }
                                                String string5 = sb2.toString();
                                                Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                                                str11 = str11;
                                                h.b("BleScanTool", str11 + string5);
                                            } else {
                                                if (bByteValue == ((byte) 252)) {
                                                    Intrinsics.checkNotNullParameter(bArr2, "<this>");
                                                    StringBuilder sb6 = new StringBuilder();
                                                    int length6 = bArr2.length;
                                                    int iE5 = 0;
                                                    while (iE5 < length6) {
                                                        byte b47 = bArr2[iE5];
                                                        StringCompanionObject stringCompanionObject11 = StringCompanionObject.INSTANCE;
                                                        iE5 = h0.a.e(new Object[]{Byte.valueOf(b47)}, 1, "%02x ", "format(...)", sb6, iE5, 1);
                                                    }
                                                    String string6 = sb6.toString();
                                                    Intrinsics.checkNotNullExpressionValue(string6, "toString(...)");
                                                    h.b("BleScanTool", str5 + string6);
                                                    if (bArr2.length != 0) {
                                                        h0.a.C(UByte.m177constructorimpl(bArr2[0]) & UByte.MAX_VALUE, "Device Wireless Capability is :", "BleScanTool");
                                                        if (bArr2.length > 1) {
                                                            byte[] byteArray11 = CollectionsKt.toByteArray(ArraysKt.drop(bArr2, 1));
                                                            arrayListU4 = b.u(byteArray11);
                                                            if (b.q(byteArray11)) {
                                                                h.b("BleScanTool", "Device Wireless Type is Bluetooth EDR");
                                                                i17 = 1;
                                                            }
                                                        }
                                                        if (bArr2.length > 3) {
                                                            h0.a.C(UByte.m177constructorimpl(bArr2[3]) & UByte.MAX_VALUE, str22, "BleScanTool");
                                                        }
                                                        concurrentHashMap5 = concurrentHashMap5;
                                                        str14 = str5;
                                                        str22 = str22;
                                                    }
                                                    str13 = str10;
                                                    str14 = str5;
                                                    str11 = str11;
                                                    str12 = str12;
                                                } else {
                                                    if (bByteValue == ((byte) 255)) {
                                                        String strC6 = q.c(bArr2);
                                                        if (!Intrinsics.areEqual(str10, strC6)) {
                                                            str14 = str5;
                                                            str10 = strC6;
                                                            concurrentHashMap5 = concurrentHashMap5;
                                                        }
                                                        str13 = str10;
                                                        str14 = str5;
                                                        str11 = str11;
                                                        str12 = str12;
                                                    } else if (bByteValue == ((byte) 8) || bByteValue == ((byte) 1) || bByteValue == ((byte) 10) || bByteValue == ((byte) 5) || bByteValue == ((byte) 4) || bByteValue == ((byte) 11) || bByteValue == ((byte) 12) || bByteValue == ((byte) 13)) {
                                                        String str27 = str10;
                                                        str14 = str5;
                                                        str12 = str12;
                                                        int iM177constructorimpl5 = UByte.m177constructorimpl(bByteValue) & UByte.MAX_VALUE;
                                                        ArrayList arrayListU5 = b.u(bArr2);
                                                        str22 = str22;
                                                        concurrentHashMap.put(Byte.valueOf(bByteValue), Integer.valueOf(UByte.m177constructorimpl(bByteValue) & UByte.MAX_VALUE));
                                                        concurrentHashMap2.put(Byte.valueOf(bByteValue), bArr2);
                                                        concurrentHashMap5 = concurrentHashMap5;
                                                        concurrentHashMap5.put(Byte.valueOf(bByteValue), b.u(bArr2));
                                                        arrayListU4 = arrayListU5;
                                                        i16 = iM177constructorimpl5;
                                                        str11 = str11;
                                                        str10 = str27;
                                                        bArr12 = bArr2;
                                                    } else {
                                                        if (bByteValue == ((byte) 251)) {
                                                            int iM177constructorimpl6 = UByte.m177constructorimpl(bByteValue) & UByte.MAX_VALUE;
                                                            str13 = str10;
                                                            str14 = str5;
                                                            concurrentHashMap.put(Byte.valueOf(bByteValue), Integer.valueOf(UByte.m177constructorimpl(bByteValue) & UByte.MAX_VALUE));
                                                            concurrentHashMap2.put(Byte.valueOf(bByteValue), bArr2);
                                                            bArr12 = bArr2;
                                                            i16 = iM177constructorimpl6;
                                                        } else {
                                                            str13 = str10;
                                                            str14 = str5;
                                                            if (bByteValue == ((byte) l5.a.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED)) {
                                                                b44 = bArr2[0];
                                                            } else {
                                                                StringCompanionObject stringCompanionObject12 = StringCompanionObject.INSTANCE;
                                                                str12 = str12;
                                                                h.h("BleScanTool", h0.a.o(new Object[]{Byte.valueOf(bByteValue)}, 1, "%02x", "format(...)", str12));
                                                                str11 = str11;
                                                            }
                                                        }
                                                        str10 = str13;
                                                    }
                                                    str22 = str22;
                                                }
                                                concurrentHashMap3 = concurrentHashMap5;
                                                str6 = str11;
                                                b36 = b45;
                                                str22 = str22;
                                                str7 = str12;
                                                str5 = str14;
                                            }
                                            str10 = str13;
                                            concurrentHashMap3 = concurrentHashMap5;
                                            str6 = str11;
                                            b36 = b45;
                                            str22 = str22;
                                            str7 = str12;
                                            str5 = str14;
                                        }
                                        String str28 = str10;
                                        b13 = b36;
                                        concurrentHashMap4 = concurrentHashMap3;
                                        Unit unit5 = Unit.INSTANCE;
                                        bArrP = bArr12;
                                        arrayList2 = arrayListU4;
                                        i11 = i16;
                                        b14 = b44;
                                        i10 = i17;
                                        str8 = str28;
                                    } else {
                                        b13 = b36;
                                        concurrentHashMap4 = concurrentHashMap3;
                                        str8 = str4;
                                        arrayList2 = null;
                                        i10 = 0;
                                        bArrP = null;
                                        i11 = 0;
                                        b14 = 0;
                                    }
                                    String strA3 = zb.a(b13);
                                    kVar = com.welink.protocol.nfbd.a.f4027k;
                                    if (kVar.c("1.0")) {
                                        BluetoothAdapter bluetoothAdapter4 = b.f8183a;
                                        iO = b.o(concurrentHashMap, concurrentHashMap2);
                                    } else {
                                        iO = i11;
                                    }
                                    if (kVar.c("1.0")) {
                                        BluetoothAdapter bluetoothAdapter5 = b.f8183a;
                                        bArrP = b.p(concurrentHashMap, concurrentHashMap2);
                                    }
                                    listN = arrayList2;
                                    if (kVar.c("1.0")) {
                                        BluetoothAdapter bluetoothAdapter6 = b.f8183a;
                                        listN = b.n(concurrentHashMap4, arrayList2);
                                    }
                                    if (str8 == null) {
                                        str9 = r1;
                                    } else {
                                        str9 = str8;
                                    }
                                    return new DeviceInfo(b39, b12, strO, str9, Boolean.FALSE, (EarBudsInfo) null, i10, iO, b14, 0, strA3, bArrP, listN, str, (String) null, (byte) 0, 0, 0, 0, (String) null, strG4);
                                }
                            }
                            i8 = 20;
                            if (i8 <= iM177constructorimpl2 && iM177constructorimpl2 < 256) {
                                LinkedHashMap linkedHashMapB3 = zb.b(serviceData2);
                                if (linkedHashMapB3 != null) {
                                    Iterator it5 = linkedHashMapB3.entrySet().iterator();
                                    String strC7 = null;
                                    while (it5.hasNext()) {
                                        Map.Entry entry4 = (Map.Entry) it5.next();
                                        LinkedHashMap linkedHashMap2 = linkedHashMapB3;
                                        byte bByteValue4 = ((Number) entry4.getKey()).byteValue();
                                        byte[] bArr13 = (byte[]) entry4.getValue();
                                        BluetoothAdapter bluetoothAdapter7 = b.f8183a;
                                        Iterator it6 = it5;
                                        strC7 = bByteValue4 == ((byte) 255) ? q.c(bArr13) : strC7;
                                        linkedHashMapB3 = linkedHashMap2;
                                        it5 = it6;
                                    }
                                    linkedHashMap = linkedHashMapB3;
                                    str3 = strC7;
                                    Unit unit6 = Unit.INSTANCE;
                                } else {
                                    linkedHashMap = linkedHashMapB3;
                                    str3 = null;
                                }
                                strC = str3;
                                i9 = 1;
                            }
                            b12 = byteArray8[i9];
                            byte[] byteArray12 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray8, 2));
                            StringCompanionObject stringCompanionObject13 = StringCompanionObject.INSTANCE;
                            str4 = strC;
                            strO = h0.a.o(new Object[]{Byte.valueOf(byteArray12[i9])}, i9, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray12[0])}, i9, "%02x", "format(...)"));
                            return b39 == 2 ? new DeviceInfo(b39, b12, strO, (String) null, Boolean.TRUE, d(manufacturerSpecificData), 0, 15, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, strG4) : new DeviceInfo(b39, b12, strO, (String) null, Boolean.TRUE, d(manufacturerSpecificData), 0, 15, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, strG4);
                            str5 = "Device Feature is :";
                            if (b39 == 13) {
                            }
                            str6 = str23;
                            str7 = str2;
                            concurrentHashMap = new ConcurrentHashMap();
                            concurrentHashMap2 = new ConcurrentHashMap();
                            concurrentHashMap3 = new ConcurrentHashMap();
                            if (linkedHashMap != null) {
                                str10 = str4;
                                byte[] bArr14 = null;
                                ArrayList arrayListU6 = null;
                                int i18 = 0;
                                byte b48 = 0;
                                int i19 = 0;
                                while (r18.hasNext()) {
                                    byte b49 = b36;
                                    bByteValue = ((Number) entry3.getKey()).byteValue();
                                    str11 = str6;
                                    bArr2 = (byte[]) entry3.getValue();
                                    BluetoothAdapter bluetoothAdapter8 = b.f8183a;
                                    str12 = str7;
                                    ConcurrentHashMap concurrentHashMap6 = concurrentHashMap3;
                                    if (bByteValue != ((byte) 254)) {
                                        str13 = str10;
                                        str14 = str5;
                                        str12 = str12;
                                        Intrinsics.checkNotNullParameter(bArr2, "<this>");
                                        sb2 = new StringBuilder();
                                        length = bArr2.length;
                                        iE = 0;
                                        while (iE < length) {
                                            byte b410 = bArr2[iE];
                                            StringCompanionObject stringCompanionObject14 = StringCompanionObject.INSTANCE;
                                            iE = h0.a.e(new Object[]{Byte.valueOf(b410)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                                        }
                                        String string7 = sb2.toString();
                                        Intrinsics.checkNotNullExpressionValue(string7, "toString(...)");
                                        str11 = str11;
                                        h.b("BleScanTool", str11 + string7);
                                        str10 = str13;
                                    } else {
                                        str13 = str10;
                                        str14 = str5;
                                        str12 = str12;
                                        Intrinsics.checkNotNullParameter(bArr2, "<this>");
                                        sb2 = new StringBuilder();
                                        length = bArr2.length;
                                        iE = 0;
                                        while (iE < length) {
                                            byte b411 = bArr2[iE];
                                            StringCompanionObject stringCompanionObject15 = StringCompanionObject.INSTANCE;
                                            iE = h0.a.e(new Object[]{Byte.valueOf(b411)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                                        }
                                        String string8 = sb2.toString();
                                        Intrinsics.checkNotNullExpressionValue(string8, "toString(...)");
                                        str11 = str11;
                                        h.b("BleScanTool", str11 + string8);
                                        str10 = str13;
                                    }
                                    concurrentHashMap3 = concurrentHashMap6;
                                    str6 = str11;
                                    b36 = b49;
                                    str22 = str22;
                                    str7 = str12;
                                    str5 = str14;
                                }
                                String str29 = str10;
                                b13 = b36;
                                concurrentHashMap4 = concurrentHashMap3;
                                Unit unit7 = Unit.INSTANCE;
                                bArrP = bArr14;
                                arrayList2 = arrayListU6;
                                i11 = i18;
                                b14 = b48;
                                i10 = i19;
                                str8 = str29;
                            } else {
                                b13 = b36;
                                concurrentHashMap4 = concurrentHashMap3;
                                str8 = str4;
                                arrayList2 = null;
                                i10 = 0;
                                bArrP = null;
                                i11 = 0;
                                b14 = 0;
                            }
                            String strA4 = zb.a(b13);
                            kVar = com.welink.protocol.nfbd.a.f4027k;
                            if (kVar.c("1.0")) {
                                BluetoothAdapter bluetoothAdapter9 = b.f8183a;
                                iO = b.o(concurrentHashMap, concurrentHashMap2);
                            } else {
                                iO = i11;
                            }
                            if (kVar.c("1.0")) {
                                BluetoothAdapter bluetoothAdapter10 = b.f8183a;
                                bArrP = b.p(concurrentHashMap, concurrentHashMap2);
                            }
                            listN = arrayList2;
                            if (kVar.c("1.0")) {
                                BluetoothAdapter bluetoothAdapter11 = b.f8183a;
                                listN = b.n(concurrentHashMap4, arrayList2);
                            }
                            if (str8 == null) {
                                str9 = r1;
                            } else {
                                str9 = str8;
                            }
                            return new DeviceInfo(b39, b12, strO, str9, Boolean.FALSE, (EarBudsInfo) null, i10, iO, b14, 0, strA4, bArrP, listN, str, (String) null, (byte) 0, 0, 0, 0, (String) null, strG4);
                        }
                        str2 = "Unknown TLV type: 0x";
                    } else {
                        str2 = "Unknown TLV type: 0x";
                        str23 = "Device information is :";
                    }
                    i9 = 1;
                    strC = null;
                    linkedHashMap = null;
                    b12 = byteArray8[i9];
                    byte[] byteArray13 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray8, 2));
                    StringCompanionObject stringCompanionObject16 = StringCompanionObject.INSTANCE;
                    str4 = strC;
                    strO = h0.a.o(new Object[]{Byte.valueOf(byteArray13[i9])}, i9, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray13[0])}, i9, "%02x", "format(...)"));
                    if (b39 == 2) {
                    }
                    str5 = "Device Feature is :";
                    if (b39 == 13) {
                    }
                    str6 = str23;
                    str7 = str2;
                    concurrentHashMap = new ConcurrentHashMap();
                    concurrentHashMap2 = new ConcurrentHashMap();
                    concurrentHashMap3 = new ConcurrentHashMap();
                    if (linkedHashMap != null) {
                        str10 = str4;
                        byte[] bArr15 = null;
                        ArrayList arrayListU7 = null;
                        int i110 = 0;
                        byte b412 = 0;
                        int i111 = 0;
                        while (r18.hasNext()) {
                            byte b413 = b36;
                            bByteValue = ((Number) entry3.getKey()).byteValue();
                            str11 = str6;
                            bArr2 = (byte[]) entry3.getValue();
                            BluetoothAdapter bluetoothAdapter12 = b.f8183a;
                            str12 = str7;
                            ConcurrentHashMap concurrentHashMap7 = concurrentHashMap3;
                            if (bByteValue != ((byte) 254)) {
                                str13 = str10;
                                str14 = str5;
                                str12 = str12;
                                Intrinsics.checkNotNullParameter(bArr2, "<this>");
                                sb2 = new StringBuilder();
                                length = bArr2.length;
                                iE = 0;
                                while (iE < length) {
                                    byte b414 = bArr2[iE];
                                    StringCompanionObject stringCompanionObject17 = StringCompanionObject.INSTANCE;
                                    iE = h0.a.e(new Object[]{Byte.valueOf(b414)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                                }
                                String string9 = sb2.toString();
                                Intrinsics.checkNotNullExpressionValue(string9, "toString(...)");
                                str11 = str11;
                                h.b("BleScanTool", str11 + string9);
                                str10 = str13;
                            } else {
                                str13 = str10;
                                str14 = str5;
                                str12 = str12;
                                Intrinsics.checkNotNullParameter(bArr2, "<this>");
                                sb2 = new StringBuilder();
                                length = bArr2.length;
                                iE = 0;
                                while (iE < length) {
                                    byte b415 = bArr2[iE];
                                    StringCompanionObject stringCompanionObject18 = StringCompanionObject.INSTANCE;
                                    iE = h0.a.e(new Object[]{Byte.valueOf(b415)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                                }
                                String string10 = sb2.toString();
                                Intrinsics.checkNotNullExpressionValue(string10, "toString(...)");
                                str11 = str11;
                                h.b("BleScanTool", str11 + string10);
                                str10 = str13;
                            }
                            concurrentHashMap3 = concurrentHashMap7;
                            str6 = str11;
                            b36 = b413;
                            str22 = str22;
                            str7 = str12;
                            str5 = str14;
                        }
                        String str210 = str10;
                        b13 = b36;
                        concurrentHashMap4 = concurrentHashMap3;
                        Unit unit8 = Unit.INSTANCE;
                        bArrP = bArr15;
                        arrayList2 = arrayListU7;
                        i11 = i110;
                        b14 = b412;
                        i10 = i111;
                        str8 = str210;
                    } else {
                        b13 = b36;
                        concurrentHashMap4 = concurrentHashMap3;
                        str8 = str4;
                        arrayList2 = null;
                        i10 = 0;
                        bArrP = null;
                        i11 = 0;
                        b14 = 0;
                    }
                    String strA5 = zb.a(b13);
                    kVar = com.welink.protocol.nfbd.a.f4027k;
                    if (kVar.c("1.0")) {
                        BluetoothAdapter bluetoothAdapter13 = b.f8183a;
                        iO = b.o(concurrentHashMap, concurrentHashMap2);
                    } else {
                        iO = i11;
                    }
                    if (kVar.c("1.0")) {
                        BluetoothAdapter bluetoothAdapter14 = b.f8183a;
                        bArrP = b.p(concurrentHashMap, concurrentHashMap2);
                    }
                    listN = arrayList2;
                    if (kVar.c("1.0")) {
                        BluetoothAdapter bluetoothAdapter15 = b.f8183a;
                        listN = b.n(concurrentHashMap4, arrayList2);
                    }
                    if (str8 == null) {
                        str9 = r1;
                    } else {
                        str9 = str8;
                    }
                    return new DeviceInfo(b39, b12, strO, str9, Boolean.FALSE, (EarBudsInfo) null, i10, iO, b14, 0, strA5, bArrP, listN, str, (String) null, (byte) 0, 0, 0, 0, (String) null, strG4);
                }
            }
        }
        return null;
    }

    public static EarBudsInfo b(byte[] bArr) {
        int i8;
        boolean z2;
        boolean z3;
        boolean z5;
        byte bByteValue;
        int i9;
        String string;
        String str;
        byte b9 = bArr[0];
        byte b10 = bArr[1];
        boolean z10 = bArr[5] >= 1;
        int iM177constructorimpl = ((UByte.m177constructorimpl(bArr[7]) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(bArr[6]) & UByte.MAX_VALUE);
        if (z10) {
            h.h("BleScanTool", "Stylus pen/Keyboard found encrypted info, ignore it");
            return null;
        }
        UByte.m177constructorimpl((byte) (bArr[4] & (-16)));
        UByte.m177constructorimpl((byte) (bArr[4] & 15));
        Byte orNull = ArraysKt.getOrNull(bArr, 8);
        if ((iM177constructorimpl & 1) != 1 || orNull == null) {
            i8 = 0;
            z2 = false;
            z3 = false;
            z5 = false;
        } else {
            boolean z11 = ((byte) (orNull.byteValue() & 1)) == 1;
            boolean z12 = (((byte) (orNull.byteValue() & 2)) >> 1) == 1;
            z5 = (((byte) (orNull.byteValue() & 4)) >> 2) == 1;
            z2 = z11;
            z3 = z12;
            i8 = 1;
        }
        Byte orNull2 = ArraysKt.getOrNull(bArr, i8 + 8);
        if (((iM177constructorimpl & 4) >> 2) != 1 || orNull2 == null) {
            bByteValue = 0;
        } else {
            i8++;
            bByteValue = orNull2.byteValue();
        }
        int i10 = i8 + 8;
        Byte orNull3 = ArraysKt.getOrNull(bArr, i10);
        Byte orNull4 = ArraysKt.getOrNull(bArr, i8 + 13);
        if (((iM177constructorimpl & 32) >> 5) != 1 || orNull3 == null || orNull4 == null) {
            i9 = 8;
            string = null;
        } else {
            byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.toList(bArr).subList(i10, i8 + 14));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strQ = o.d.q(new Object[]{Byte.valueOf(byteArray[0])}, 1, "%02x", "format(...)");
            Locale locale = Locale.ROOT;
            String upperCase = strQ.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray[1])}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            String upperCase2 = str2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            String str3 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray[2])}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            String upperCase3 = str3.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
            String str4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray[3])}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            String upperCase4 = str4.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
            String str5 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray[4])}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            String upperCase5 = str5.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase5, "toUpperCase(...)");
            String str6 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray[5])}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            String upperCase6 = str6.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase6, "toUpperCase(...)");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(upperCase);
            sb2.append(":");
            sb2.append(upperCase2);
            o.d.A(sb2, ":", upperCase3, ":", upperCase4);
            sb2.append(":");
            sb2.append(upperCase5);
            sb2.append(":");
            sb2.append(upperCase6);
            i8 += 6;
            string = sb2.toString();
            i9 = 8;
        }
        Byte orNull5 = ArraysKt.getOrNull(bArr, i8 + i9);
        if (orNull5 != null) {
            str = ((UByte.m177constructorimpl((byte) (orNull5.byteValue() & (-16))) & UByte.MAX_VALUE) >> 4) + "." + (UByte.m177constructorimpl((byte) (orNull5.byteValue() & 15)) & UByte.MAX_VALUE);
        } else {
            str = null;
        }
        return new EarBudsInfo(z2, z3, z5, false, false, false, false, false, 0, 0, bByteValue, 0, false, string, str, false);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x002c  */
    public static DeviceInfo c(byte[] bArr) {
        Boolean bool;
        int i8;
        int i9;
        boolean z2;
        boolean z3;
        boolean z5;
        EarBudsInfo earBudsInfo;
        byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.take(bArr, 4));
        byte b9 = byteArray[0];
        if (b9 != 16) {
            return null;
        }
        byte b10 = byteArray[1];
        if (bArr.length < 13) {
            bool = null;
        } else {
            byte b11 = bArr[0];
            byte b12 = bArr[1];
            byte b13 = bArr[2];
            byte b14 = bArr[3];
            byte b15 = bArr[4];
            byte b16 = bArr[8];
            byte b17 = bArr[9];
            byte b18 = bArr[10];
            byte b19 = bArr[11];
            byte b20 = bArr[12];
            if (b13 == 48 && b14 == 10 && b15 == 16) {
                bool = Boolean.FALSE;
            } else if (b13 == -48 && b14 == 0 && b15 == 16) {
                bool = Boolean.FALSE;
            } else if (b11 == 16 && b12 == 16 && b18 == 0 && b19 == 5 && b20 == 0) {
                bool = Boolean.TRUE;
            } else {
                bool = null;
            }
        }
        if (bool == null) {
            h.h("BleScanTool", "Unknown manufacturerData");
            return null;
        }
        if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
            EarBudsInfo earBudsInfoB = b(bArr);
            String string = Integer.toString((UByte.m177constructorimpl(bArr[3]) & UByte.MAX_VALUE) | ((UByte.m177constructorimpl(bArr[2]) & UByte.MAX_VALUE) << 8), CharsKt.checkRadix(16));
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            return new DeviceInfo(b9, b10, upperCase, earBudsInfoB != null ? earBudsInfoB.p : null, Boolean.FALSE, earBudsInfoB, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2097088);
        }
        byte b21 = bArr[0];
        byte b22 = bArr[1];
        boolean z10 = bArr[10] >= 1;
        int iM177constructorimpl = ((UByte.m177constructorimpl(bArr[12]) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(bArr[11]) & UByte.MAX_VALUE);
        if (z10) {
            h.h("BleScanTool", "Stylus pen found encrypted info, ignore it");
            earBudsInfo = null;
        } else {
            byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.toList(bArr).subList(2, 8));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String strQ = o.d.q(new Object[]{Byte.valueOf(byteArray2[0])}, 1, "%02x", "format(...)");
            Locale locale = Locale.ROOT;
            String upperCase2 = strQ.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray2[1])}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String upperCase3 = str.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase3, "toUpperCase(...)");
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray2[2])}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            String upperCase4 = str2.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase4, "toUpperCase(...)");
            String str3 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray2[3])}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            String upperCase5 = str3.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase5, "toUpperCase(...)");
            String str4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray2[4])}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            String upperCase6 = str4.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase6, "toUpperCase(...)");
            String str5 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray2[5])}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            String upperCase7 = str5.toUpperCase(locale);
            Intrinsics.checkNotNullExpressionValue(upperCase7, "toUpperCase(...)");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(upperCase2);
            sb2.append(":");
            sb2.append(upperCase3);
            o.d.A(sb2, ":", upperCase4, ":", upperCase5);
            sb2.append(":");
            sb2.append(upperCase6);
            sb2.append(":");
            sb2.append(upperCase7);
            String string2 = sb2.toString();
            UByte.m177constructorimpl((byte) (bArr[8] & (-16)));
            UByte.m177constructorimpl((byte) (bArr[8] & 15));
            String str6 = ((UByte.m177constructorimpl((byte) (bArr[9] & (-16))) & UByte.MAX_VALUE) >> 4) + "." + (UByte.m177constructorimpl((byte) (bArr[9] & 15)) & UByte.MAX_VALUE);
            if ((iM177constructorimpl & 1) == 1) {
                byte b23 = bArr[13];
                boolean z11 = ((byte) (b23 & 1)) == 1;
                i8 = 2;
                boolean z12 = (((byte) (b23 & 2)) >> 1) == 1;
                z2 = z11;
                z5 = (((byte) (b23 & 4)) >> 2) == 1;
                z3 = z12;
                i9 = 1;
            } else {
                i8 = 2;
                i9 = 0;
                z2 = false;
                z3 = false;
                z5 = false;
            }
            earBudsInfo = new EarBudsInfo(z2, z3, z5, false, false, false, false, false, 0, 0, ((iM177constructorimpl & 4) >> i8) == 1 ? bArr[i9 + 13] : (byte) 0, 0, false, string2, str6, false);
        }
        return new DeviceInfo(b9, b10, "D000", earBudsInfo != null ? earBudsInfo.p : null, Boolean.FALSE, earBudsInfo, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2097088);
    }

    public static EarBudsInfo d(byte[] bArr) {
        int i8;
        boolean z2;
        boolean z3;
        boolean z5;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int iM177constructorimpl;
        int iM177constructorimpl2;
        int iM177constructorimpl3;
        int iM177constructorimpl4;
        boolean z16;
        String strN;
        byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.toList(bArr).subList(6, 8));
        Byte orNull = ArraysKt.getOrNull(bArr, 8);
        if (((byte) (byteArray[1] & 1)) != 1 || orNull == null) {
            i8 = 0;
            z2 = false;
            z3 = false;
            z5 = false;
            z10 = false;
        } else {
            boolean z17 = ((byte) (orNull.byteValue() & 1)) == 1;
            boolean z18 = (((byte) (orNull.byteValue() & 2)) >> 1) == 1;
            boolean z19 = (((byte) (orNull.byteValue() & 4)) >> 2) == 1;
            z10 = (((byte) (orNull.byteValue() & 8)) >> 3) == 1;
            z2 = z17;
            z3 = z18;
            z5 = z19;
            i8 = 1;
        }
        Byte orNull2 = ArraysKt.getOrNull(bArr, i8 + 8);
        if ((((byte) (byteArray[1] & 2)) >> 1) != 1 || orNull2 == null) {
            z11 = false;
            z12 = false;
            z13 = false;
            z14 = false;
            z15 = false;
        } else {
            boolean z20 = ((byte) (orNull2.byteValue() & 1)) == 1;
            z11 = (((byte) (orNull2.byteValue() & 2)) >> 1) == 1;
            boolean z21 = (((byte) (orNull2.byteValue() & 4)) >> 2) == 1;
            i8++;
            z14 = (((byte) (orNull2.byteValue() & 8)) >> 3) == 1;
            z15 = (((byte) (orNull2.byteValue() & 16)) >> 4) == 1;
            z12 = z20;
            z13 = z21;
        }
        int i9 = i8 + 8;
        Byte orNull3 = ArraysKt.getOrNull(bArr, i9);
        Byte orNull4 = ArraysKt.getOrNull(bArr, i8 + 10);
        if ((((byte) (byteArray[1] & 4)) >> 2) != 1 || orNull3 == null || orNull4 == null) {
            iM177constructorimpl = -1;
            iM177constructorimpl2 = -1;
            iM177constructorimpl3 = -1;
        } else {
            byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.toList(bArr).subList(i9, i8 + 11));
            byte b9 = byteArray2[0];
            byte b10 = (byte) 128;
            iM177constructorimpl = (((UByte.m177constructorimpl(b9) & UByte.m177constructorimpl(b10)) & 255) >> 7) == 1 ? UByte.m177constructorimpl(b9) & UByte.m177constructorimpl((byte) 127) & 255 : -1;
            byte b11 = byteArray2[1];
            iM177constructorimpl2 = (((UByte.m177constructorimpl(b11) & UByte.m177constructorimpl(b10)) & 255) >> 7) == 1 ? UByte.m177constructorimpl(b11) & UByte.m177constructorimpl((byte) 127) & 255 : -1;
            byte b12 = byteArray2[2];
            i8 += 3;
            iM177constructorimpl3 = (((UByte.m177constructorimpl(b12) & UByte.m177constructorimpl(b10)) & 255) >> 7) == 1 ? UByte.m177constructorimpl(b12) & UByte.m177constructorimpl((byte) 127) & 255 : -1;
        }
        Byte orNull5 = ArraysKt.getOrNull(bArr, i8 + 8);
        if ((((byte) (byteArray[1] & 8)) >> 3) != 1 || orNull5 == null) {
            iM177constructorimpl4 = -1;
        } else {
            i8++;
            iM177constructorimpl4 = UByte.m177constructorimpl(orNull5.byteValue()) & UByte.MAX_VALUE;
        }
        Byte orNull6 = ArraysKt.getOrNull(bArr, i8 + 8);
        if ((((byte) (byteArray[1] & 16)) >> 4) != 1 || orNull6 == null) {
            z16 = false;
        } else {
            z16 = (UByte.m177constructorimpl(orNull6.byteValue()) & UByte.MAX_VALUE) == 1;
            i8++;
        }
        int i10 = i8 + 8;
        Byte orNull7 = ArraysKt.getOrNull(bArr, i10);
        Byte orNull8 = ArraysKt.getOrNull(bArr, i8 + 13);
        String str = null;
        if ((((byte) (byteArray[1] & 32)) >> 5) != 1 || orNull7 == null || orNull8 == null) {
            strN = null;
        } else {
            byte[] byteArray3 = CollectionsKt.toByteArray(ArraysKt.toList(bArr).subList(i10, i8 + 14));
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray3[0])}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            String strC = r6.c(str2);
            String str3 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray3[1])}, 1));
            Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
            String strC2 = r6.c(str3);
            String str4 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray3[2])}, 1));
            Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
            String strC3 = r6.c(str4);
            String str5 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray3[3])}, 1));
            Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
            String strC4 = r6.c(str5);
            String str6 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray3[4])}, 1));
            Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
            String strC5 = r6.c(str6);
            String str7 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(byteArray3[5])}, 1));
            Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
            String strC6 = r6.c(str7);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strC);
            sb2.append(":");
            sb2.append(strC2);
            sb2.append(":");
            sb2.append(strC3);
            o.d.A(sb2, ":", strC4, ":", strC5);
            i8 += 6;
            strN = h0.a.n(sb2, ":", strC6);
        }
        Byte orNull9 = ArraysKt.getOrNull(bArr, i8 + 8);
        if ((((byte) (byteArray[1] & 64)) >> 6) == 1 && orNull9 != null) {
            str = ((UByte.m177constructorimpl((byte) (orNull9.byteValue() & (-16))) & UByte.MAX_VALUE) >> 4) + "." + (UByte.m177constructorimpl((byte) (orNull9.byteValue() & 15)) & UByte.MAX_VALUE);
        }
        byte b13 = byteArray[1];
        byte b14 = byteArray[0];
        return new EarBudsInfo(z2, z3, z5, z12, z11, z13, z14, z15, iM177constructorimpl, iM177constructorimpl2, iM177constructorimpl3, iM177constructorimpl4, z16, strN, str, z10);
    }

    public static String g(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        return h0.a.i("0x", ArraysKt___ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new ag.b(19), 30, (Object) null));
    }

    public final boolean e(DeviceInfo deviceInfo) {
        List list;
        if ((deviceInfo != null ? deviceInfo.f4230n : null) != null) {
            byte[] bArr = deviceInfo.f4230n;
            if (bArr.length >= 2 && bArr.length != 0 && deviceInfo.f4226j == 251) {
                ArrayList arrayList = new ArrayList();
                byte[] bArr2 = deviceInfo.f4230n;
                int iM254constructorimpl = UInt.m254constructorimpl(UInt.m254constructorimpl(UByte.m177constructorimpl(bArr2[0]) & UByte.MAX_VALUE) | UInt.m254constructorimpl(UInt.m254constructorimpl(UByte.m177constructorimpl(bArr2[1]) & UByte.MAX_VALUE) << 8));
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(1) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 1);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(2) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 8);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(4) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 9);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(32) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 10);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(16) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 5);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(8) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 4);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(64) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 11);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(128) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 12);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(256) & iM254constructorimpl) != 0) {
                    arrayList.add((byte) 13);
                }
                if (UInt.m254constructorimpl(UInt.m254constructorimpl(65024) & iM254constructorimpl) != 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    h.b("BleScanTool", h0.a.o(new Object[]{UInt.m248boximpl(iM254constructorimpl)}, 1, "%04x", "format(...)", "Reserved service flag is not supported, value: "));
                }
                if (iM254constructorimpl == UInt.m254constructorimpl(0) || arrayList.isEmpty()) {
                    Intrinsics.checkNotNullParameter("BleScanTool", "tag");
                    Intrinsics.checkNotNullParameter("No supported service found in service data", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("BleScanTool", "TransConnect:No supported service found in service data", null);
                    }
                    return false;
                }
                m mVar = this.e;
                if (mVar != null && (list = (List) mVar.f4458b) != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        byte bByteValue = ((Number) it.next()).byteValue();
                        if (arrayList.contains(Byte.valueOf(bByteValue))) {
                            h.b("BleScanTool", "Service " + (UByte.m177constructorimpl(bByteValue) & UByte.MAX_VALUE) + " is found in service data");
                            return true;
                        }
                    }
                }
                Intrinsics.checkNotNullParameter("BleScanTool", "tag");
                Intrinsics.checkNotNullParameter("No supported service found in filter", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("BleScanTool", "TransConnect:No supported service found in filter", null);
                }
                return false;
            }
        }
        Intrinsics.checkNotNullParameter("BleScanTool", "tag");
        Intrinsics.checkNotNullParameter("serviceData is null or size < 2 or empty or serviceType != SERVICE_GENERAL", "mes");
        if (lb.f6529c >= 1) {
            Log.e("BleScanTool", "TransConnect:serviceData is null or size < 2 or empty or serviceType != SERVICE_GENERAL", null);
        }
        return false;
    }

    public final void f(int i8) {
        BluetoothLeScanner bluetoothLeScanner;
        if (this.f != null) {
            h.h("BleScanTool", "now stop ble scan....");
            BluetoothAdapter bluetoothAdapter = this.f8196b;
            if (bluetoothAdapter != null && bluetoothAdapter.isEnabled() && i8 == 0 && (bluetoothLeScanner = this.f) != null) {
                bluetoothLeScanner.stopScan(this.f8203k);
            }
        }
        h.h("BleScanTool", "clearBuf......");
        synchronized (this.f8202j) {
            this.f8198d.clear();
            this.e = null;
            this.f = null;
            this.f8199g = null;
            this.f8201i = null;
            Unit unit = Unit.INSTANCE;
        }
    }
}
