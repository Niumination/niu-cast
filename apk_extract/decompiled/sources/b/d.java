package b;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.IntentSender;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import androidx.activity.ComponentActivity$activityResultRegistry$1;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.camera.camera2.internal.ExposureControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.view.PointerIconCompat;
import androidx.lifecycle.CoroutineLiveDataKt;
import androidx.profileinstaller.DeviceProfileWriter;
import com.transsion.widgetslib.widget.OSSegmentedTab;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.libspp.BluetoothController$discoveryBroadcast$1;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.j;
import com.welink.protocol.nfbd.y;
import com.welink.protocol.utils.DeviceInfo;
import hj.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.gc;
import k3.lb;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import m3.q;
import pe.f;
import se.q4;
import se.v1;
import se.w;
import se.x1;
import se.z0;
import se.z6;
import tj.x;
import we.h;
import we.m;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f1167d;

    public /* synthetic */ d(j jVar, BluetoothGatt bluetoothGatt, int i8, int i9) {
        this.f1164a = 5;
        this.f1165b = jVar;
        this.f1167d = bluetoothGatt;
        this.f1166c = i9;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:294:0x0957  */
    /* JADX WARN: Code duplicated, block: B:302:0x098d  */
    /* JADX WARN: Code duplicated, block: B:303:0x098f  */
    /* JADX WARN: Code duplicated, block: B:306:0x0995  */
    /* JADX WARN: Code duplicated, block: B:317:0x09c5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:328:0x09ff  */
    /* JADX WARN: Code duplicated, block: B:330:0x0a03  */
    /* JADX WARN: Code duplicated, block: B:331:0x0a0a  */
    /* JADX WARN: Code duplicated, block: B:333:0x0a1d  */
    /* JADX WARN: Code duplicated, block: B:335:0x0a23  */
    /* JADX WARN: Code duplicated, block: B:340:0x0a37  */
    /* JADX WARN: Code duplicated, block: B:342:0x0a63  */
    /* JADX WARN: Instruction removed from duplicated block: B:340:0x0a37, please report this as an issue */
    @Override // java.lang.Runnable
    public final void run() {
        String str;
        q4 q4Var;
        String str2;
        boolean z2;
        DeviceInfo deviceInfo;
        byte[] byteArray;
        byte[] byteArray2;
        String str3;
        String str4;
        DeviceInfo deviceInfo2;
        byte b9;
        int i8;
        byte[] bArr;
        ArrayList arrayList;
        String str5;
        int iCoerceAtLeast;
        p pVar;
        BluetoothDevice btDevice;
        Function2 function2;
        ArrayList arrayList2;
        String str6;
        boolean z3;
        int i9;
        boolean z5;
        int i10;
        String strG;
        BluetoothGatt bluetoothGatt;
        NearDevice nearDevice;
        NearDevice nearDevice2;
        se.e eVar;
        String str7 = ", ";
        String str8 = "mes";
        byte b10 = 0;
        Object obj = null;
        int i11 = 2;
        switch (this.f1164a) {
            case 0:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$0((ComponentActivity$activityResultRegistry$1) this.f1165b, this.f1166c, (ActivityResultContract.SynchronousResult) this.f1167d);
                break;
            case 1:
                ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1((ComponentActivity$activityResultRegistry$1) this.f1165b, this.f1166c, (IntentSender.SendIntentException) this.f1167d);
                break;
            case 2:
                ((ExposureControl) this.f1165b).lambda$setExposureCompensationIndex$1((CallbackToFutureAdapter.Completer) this.f1167d, this.f1166c);
                break;
            case 3:
                int i12 = BluetoothController$discoveryBroadcast$1.f3858b;
                x xVar = ((f) this.f1165b).f;
                if (xVar != null) {
                    BluetoothDevice bluetoothDevice = (BluetoothDevice) this.f1167d;
                    Intrinsics.checkNotNullParameter(bluetoothDevice, "device");
                    String name = bluetoothDevice.getName();
                    String str9 = "onDeviceDetected: ";
                    StringBuilder sb2 = new StringBuilder("onDeviceDetected: ");
                    sb2.append(bluetoothDevice);
                    sb2.append(", ");
                    sb2.append(name);
                    sb2.append(", ");
                    int i13 = this.f1166c;
                    sb2.append(i13);
                    String string = sb2.toString();
                    String str10 = "SmartBluetoothManager";
                    h.h("SmartBluetoothManager", string);
                    ParcelUuid[] uuids = bluetoothDevice.getUuids();
                    if (uuids != null) {
                        h.h("SmartBluetoothManager", "onDeviceDetected uuid: " + bluetoothDevice + ", " + i13 + ", " + uuids);
                    }
                    q4 q4Var2 = (q4) xVar.f10264a;
                    if (q4Var2.f9953d != null) {
                        p pVar2 = q4Var2.f9951b;
                        Intrinsics.checkNotNullParameter(bluetoothDevice, "bluetoothDevice");
                        String name2 = bluetoothDevice.getName();
                        String str11 = "TransConnect:";
                        if (name2.length() >= 4) {
                            Intrinsics.checkNotNull(name2);
                            byte[] bytes = name2.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            if (bytes[0] == 35 && bytes[1] == 42 && bytes[2] == 38 && bytes[3] == 36) {
                                byte[] byteArray3 = CollectionsKt.toByteArray(ArraysKt.drop(bytes, 4));
                                Intrinsics.checkNotNullParameter(byteArray3, "<this>");
                                int length = byteArray3.length;
                                String strB = "";
                                int i14 = 0;
                                while (true) {
                                    q4Var = q4Var2;
                                    if (i14 < length) {
                                        byte b11 = byteArray3[i14];
                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                        strB = h0.a.B(strB, o.d.q(new Object[]{Byte.valueOf(b11)}, 1, "%02x ", "format(...)"));
                                        i14++;
                                        length = length;
                                        q4Var2 = q4Var;
                                        str10 = str10;
                                    } else {
                                        str2 = str10;
                                        h.g(strB);
                                        try {
                                            byte[] bArrDecode = Base64.decode(byteArray3, 0);
                                            if (bArrDecode != null && bArrDecode[0] == 98 && bArrDecode[1] == 101 && bArrDecode[2] == 101 && bArrDecode[3] == 102) {
                                                byteArray = CollectionsKt.toByteArray(ArraysKt.drop(bArrDecode, 4));
                                            } else {
                                                Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                                Intrinsics.checkNotNullParameter("decodeClassicBtName: decryptData is null or not valid, return null", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("BluetoothScanTool", "TransConnect:decodeClassicBtName: decryptData is null or not valid, return null", null);
                                                }
                                                byteArray = null;
                                            }
                                        } catch (Exception unused) {
                                            Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                            Intrinsics.checkNotNullParameter("decodeClassicBtName: Base64 decode error, return null", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("BluetoothScanTool", "TransConnect:decodeClassicBtName: Base64 decode error, return null", null);
                                            }
                                        }
                                        if (byteArray == null) {
                                            Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                            Intrinsics.checkNotNullParameter("analysisDeviceInfo: decryptData is null, return", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("BluetoothScanTool", "TransConnect:analysisDeviceInfo: decryptData is null, return", null);
                                            }
                                            str = ", ";
                                        } else {
                                            h.h("BluetoothScanTool", "analysisDeviceInfo: data in byte array is :");
                                            Intrinsics.checkNotNullParameter(byteArray, "<this>");
                                            int length2 = byteArray.length;
                                            String strB2 = "";
                                            int i15 = 0;
                                            while (i15 < length2) {
                                                byte b12 = byteArray[i15];
                                                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                                strB2 = h0.a.B(strB2, o.d.q(new Object[]{Byte.valueOf(b12)}, 1, "%02x ", "format(...)"));
                                                i15++;
                                                length2 = length2;
                                                str7 = str7;
                                            }
                                            str = str7;
                                            h.g(strB2);
                                            if (byteArray.length == 0) {
                                                h.h("BluetoothScanTool", "analysisDeviceInfo: not our device, ignore");
                                            } else {
                                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                                int i16 = 0;
                                                while (true) {
                                                    if (i16 >= byteArray.length || (iCoerceAtLeast = RangesKt.coerceAtLeast(UByte.m177constructorimpl(byteArray[i16]) & UByte.MAX_VALUE, 0)) <= 0) {
                                                        bluetoothDevice = bluetoothDevice;
                                                        str9 = str9;
                                                    } else {
                                                        str9 = str9;
                                                        int iM177constructorimpl = UByte.m177constructorimpl(byteArray[i16 + 1]) & UByte.MAX_VALUE;
                                                        int i17 = i16 + iCoerceAtLeast + 1;
                                                        bluetoothDevice = bluetoothDevice;
                                                        if (i17 > byteArray.length) {
                                                            h.h("BluetoothScanTool", "Invalid EIR data, error length");
                                                        } else {
                                                            linkedHashMap.put(Integer.valueOf(iM177constructorimpl), ArraysKt.copyOfRange(byteArray, i16 + 2, i17));
                                                            i16 += iCoerceAtLeast + 1;
                                                            str9 = str9;
                                                            bluetoothDevice = bluetoothDevice;
                                                            i13 = i13;
                                                        }
                                                    }
                                                }
                                                if (linkedHashMap.isEmpty()) {
                                                    Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                                    Intrinsics.checkNotNullParameter("eirItems is empty, return null", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("BluetoothScanTool", "TransConnect:eirItems is empty, return null", null);
                                                    }
                                                    str8 = "mes";
                                                    str11 = "TransConnect:";
                                                    pVar2 = pVar2;
                                                } else {
                                                    int i18 = z6.f10086b;
                                                    Iterator it = linkedHashMap.entrySet().iterator();
                                                    while (true) {
                                                        if (it.hasNext()) {
                                                            Map.Entry entry = (Map.Entry) it.next();
                                                            if (((Number) entry.getKey()).intValue() == 22 && ((byte[]) entry.getValue()).length >= 2 && (((UByte.m177constructorimpl(((byte[]) entry.getValue())[1]) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl(((byte[]) entry.getValue())[0]) & UByte.MAX_VALUE)) == i18) {
                                                                byteArray2 = CollectionsKt.toByteArray(ArraysKt.drop((byte[]) entry.getValue(), 2));
                                                            }
                                                        } else {
                                                            byteArray2 = null;
                                                        }
                                                    }
                                                    Iterator it2 = linkedHashMap.entrySet().iterator();
                                                    while (true) {
                                                        if (it2.hasNext()) {
                                                            Map.Entry entry2 = (Map.Entry) it2.next();
                                                            if (((Number) entry2.getKey()).intValue() == 9) {
                                                                str3 = new String((byte[]) entry2.getValue(), Charsets.UTF_8);
                                                            }
                                                        } else {
                                                            str3 = null;
                                                        }
                                                    }
                                                    if (str3 == null) {
                                                        Iterator it3 = linkedHashMap.entrySet().iterator();
                                                        while (true) {
                                                            if (it3.hasNext()) {
                                                                Map.Entry entry3 = (Map.Entry) it3.next();
                                                                if (((Number) entry3.getKey()).intValue() == 8) {
                                                                    str5 = new String((byte[]) entry3.getValue(), Charsets.UTF_8);
                                                                }
                                                            } else {
                                                                str5 = null;
                                                            }
                                                        }
                                                        str4 = str5;
                                                    } else {
                                                        str4 = str3;
                                                    }
                                                    if (byteArray2 != null) {
                                                        h.b("BluetoothScanTool", "serviceData is :");
                                                        q.f(byteArray2);
                                                        byte[] bArr2 = new byte[6];
                                                        System.arraycopy(byteArray2, 0, bArr2, 0, 6);
                                                        String strC = q.c(bArr2);
                                                        if (byteArray2.length >= 13) {
                                                            byte b13 = byteArray2[12];
                                                            str11 = "TransConnect:";
                                                            if (b13 == 7 || b13 == 15) {
                                                                str8 = "mes";
                                                                pVar2 = pVar2;
                                                                h.h("BluetoothScanTool", "Device Found Event, addr = ".concat(strC));
                                                                if (byteArray2.length == 13 && byteArray2[12] == 7) {
                                                                    h.h("BluetoothScanTool", "PC/Laptop Connect Invite from ".concat(strC));
                                                                    deviceInfo2 = new DeviceInfo((byte) 10, (byte) -1, "0000", strC, Boolean.FALSE, (EarBudsInfo) null, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2097088);
                                                                    z2 = false;
                                                                } else {
                                                                    byte b14 = byteArray2[17];
                                                                    String str12 = ((UByte.m177constructorimpl(b14) & UByte.MAX_VALUE) >> 4) + "." + (UByte.m177constructorimpl((byte) (byteArray2[17] & 15)) & UByte.MAX_VALUE);
                                                                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                                                    h.b("BluetoothScanTool", h0.a.o(new Object[]{Byte.valueOf(b14)}, 1, "%02x", "format(...)", "broadcastVersionInByte is 0x"));
                                                                    h.b("BluetoothScanTool", "broadcastVersionInString is " + str12);
                                                                    if (b14 == 16) {
                                                                        byte[] byteArray4 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray2, 13));
                                                                        h.b("BluetoothScanTool", "shotPID is :");
                                                                        q.f(byteArray4);
                                                                        byte b15 = byteArray4[0];
                                                                        h.b("BluetoothScanTool", h0.a.o(new Object[]{Byte.valueOf(b15)}, 1, "%02x", "format(...)", "productSubType is 0x"));
                                                                        byte b16 = byteArray4[1];
                                                                        h.b("BluetoothScanTool", h0.a.o(new Object[]{Byte.valueOf(b16)}, 1, "%02x", "format(...)", "productBrandName is 0x"));
                                                                        byte[] byteArray5 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray4, 2));
                                                                        z2 = false;
                                                                        String strO = h0.a.o(new Object[]{Byte.valueOf(byteArray5[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray5[0])}, 1, "%02x", "format(...)"));
                                                                        if (b15 == 10) {
                                                                            deviceInfo2 = new DeviceInfo(b15, b16, strO, strC, Boolean.FALSE, (EarBudsInfo) null, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2096128);
                                                                        }
                                                                    } else {
                                                                        z2 = false;
                                                                    }
                                                                    deviceInfo2 = null;
                                                                }
                                                            } else {
                                                                if (b13 == -5 || b13 == 1) {
                                                                    byte b17 = byteArray2[17];
                                                                    pVar2 = pVar2;
                                                                    str8 = "mes";
                                                                    String str13 = ((UByte.m177constructorimpl(b17) & UByte.MAX_VALUE) >> 4) + "." + (UByte.m177constructorimpl((byte) (byteArray2[17] & 15)) & UByte.MAX_VALUE);
                                                                    StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                                                                    h.b("BluetoothScanTool", h0.a.o(new Object[]{Byte.valueOf(b17)}, 1, "%02x", "format(...)", "broadcastVersionInByte is 0x"));
                                                                    h.b("BluetoothScanTool", "broadcastVersionInString is " + str13);
                                                                    byte[] bArr3 = new byte[6];
                                                                    System.arraycopy(byteArray2, 6, bArr3, 0, 6);
                                                                    byte[] byteArray6 = CollectionsKt.toByteArray(ArraysKt___ArraysKt.dropLast(bArr3, 2));
                                                                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                                                    int length3 = byteArray6.length;
                                                                    BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
                                                                    if (length3 < 2) {
                                                                        b9 = 16;
                                                                        linkedHashMap2 = null;
                                                                    } else {
                                                                        int i19 = 0;
                                                                        while (true) {
                                                                            if (i19 < byteArray6.length) {
                                                                                BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
                                                                                int i20 = i19 + 2;
                                                                                if (i20 > byteArray6.length) {
                                                                                    h.h("BluetoothScanTool", "Invalid TLV data, error index");
                                                                                } else {
                                                                                    int i21 = i19 + 1;
                                                                                    byte b18 = byteArray6[i19];
                                                                                    int iCoerceAtLeast2 = RangesKt.coerceAtLeast(UByte.m177constructorimpl(byteArray6[i21]) & UByte.MAX_VALUE, 0);
                                                                                    if (iCoerceAtLeast2 < 0 || iCoerceAtLeast2 > 255) {
                                                                                        h.j("BluetoothScanTool", "Invalid length " + iCoerceAtLeast2 + " at type " + ((int) b18));
                                                                                        if (linkedHashMap2.isEmpty()) {
                                                                                            linkedHashMap2 = null;
                                                                                        }
                                                                                    } else {
                                                                                        int i22 = iCoerceAtLeast2 + i20;
                                                                                        if (i22 > byteArray6.length) {
                                                                                            h.h("BluetoothScanTool", "Invalid TLV data, error length");
                                                                                        } else {
                                                                                            linkedHashMap2.put(Byte.valueOf(b18), ArraysKt.copyOfRange(byteArray6, i20, i22));
                                                                                            i19 = i22;
                                                                                        }
                                                                                    }
                                                                                }
                                                                                b9 = 16;
                                                                                linkedHashMap2 = null;
                                                                            }
                                                                            b9 = 16;
                                                                        }
                                                                    }
                                                                    if (b17 == b9 || b17 == 17) {
                                                                        byte[] byteArray7 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray2, 13));
                                                                        h.b("BluetoothScanTool", "shotPID is :");
                                                                        Intrinsics.checkNotNullParameter(byteArray7, "<this>");
                                                                        String strB3 = "";
                                                                        for (byte b19 : byteArray7) {
                                                                            StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                                                                            strB3 = h0.a.B(strB3, o.d.q(new Object[]{Byte.valueOf(b19)}, 1, "%02x ", "format(...)"));
                                                                        }
                                                                        h.g(strB3);
                                                                        byte b20 = byteArray7[0];
                                                                        byte b21 = byteArray7[1];
                                                                        byte[] byteArray8 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray7, 2));
                                                                        StringCompanionObject stringCompanionObject6 = StringCompanionObject.INSTANCE;
                                                                        String strO2 = h0.a.o(new Object[]{Byte.valueOf(byteArray8[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray8[0])}, 1, "%02x", "format(...)"));
                                                                        if (b20 == 10) {
                                                                            if (linkedHashMap2 != null) {
                                                                                Iterator it4 = linkedHashMap2.entrySet().iterator();
                                                                                int i23 = 0;
                                                                                byte[] bArr4 = null;
                                                                                ArrayList arrayList3 = null;
                                                                                while (it4.hasNext()) {
                                                                                    Map.Entry entry4 = (Map.Entry) it4.next();
                                                                                    Iterator it5 = it4;
                                                                                    byte bByteValue = ((Number) entry4.getKey()).byteValue();
                                                                                    byte[] bArr5 = (byte[]) entry4.getValue();
                                                                                    BluetoothAdapter bluetoothAdapter3 = ne.b.f8183a;
                                                                                    int i24 = i23;
                                                                                    byte[] bArr6 = bArr4;
                                                                                    if (bByteValue == ((byte) 255) || bByteValue == ((byte) 254) || bByteValue == ((byte) 253) || bByteValue == ((byte) 252)) {
                                                                                        Intrinsics.checkNotNullParameter(bArr5, "<this>");
                                                                                        StringBuilder sb3 = new StringBuilder();
                                                                                        int length4 = bArr5.length;
                                                                                        int iE = 0;
                                                                                        while (iE < length4) {
                                                                                            byte b22 = bArr5[iE];
                                                                                            StringCompanionObject stringCompanionObject7 = StringCompanionObject.INSTANCE;
                                                                                            iE = h0.a.e(new Object[]{Byte.valueOf(b22)}, 1, "%02x ", "format(...)", sb3, iE, 1);
                                                                                        }
                                                                                        String string2 = sb3.toString();
                                                                                        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                                                                        h.b("BluetoothScanTool", "Device information is :" + string2);
                                                                                    } else if (bByteValue == ((byte) 8) || bByteValue == ((byte) 1) || bByteValue == ((byte) 5) || bByteValue == ((byte) 4) || bByteValue == ((byte) 11) || bByteValue == ((byte) 12) || bByteValue == ((byte) 13) || bByteValue == ((byte) 251)) {
                                                                                        int iM177constructorimpl2 = UByte.m177constructorimpl(bByteValue) & UByte.MAX_VALUE;
                                                                                        ArrayList arrayListU = ne.b.u(bArr5);
                                                                                        arrayList3 = arrayListU;
                                                                                        bArr4 = bArr5;
                                                                                        i23 = iM177constructorimpl2;
                                                                                        it4 = it5;
                                                                                    } else {
                                                                                        StringCompanionObject stringCompanionObject8 = StringCompanionObject.INSTANCE;
                                                                                        h.h("BluetoothScanTool", h0.a.o(new Object[]{Byte.valueOf(bByteValue)}, 1, "%02x", "format(...)", "Unknown TLV type: 0x"));
                                                                                    }
                                                                                    i23 = i24;
                                                                                    bArr4 = bArr6;
                                                                                    it4 = it5;
                                                                                }
                                                                                arrayList = arrayList3;
                                                                                i8 = i23;
                                                                                bArr = bArr4;
                                                                            } else {
                                                                                i8 = 0;
                                                                                bArr = null;
                                                                                arrayList = null;
                                                                            }
                                                                            int iM177constructorimpl3 = UByte.m177constructorimpl(b17) & UByte.MAX_VALUE;
                                                                            deviceInfo2 = new DeviceInfo(b20, b21, strO2, strC, Boolean.FALSE, (EarBudsInfo) null, 1, i8, 0, 1, (iM177constructorimpl3 != 16 && ((17 <= iM177constructorimpl3 && iM177constructorimpl3 < 20) || (20 <= iM177constructorimpl3 && iM177constructorimpl3 < 256))) ? "1.0" : null, bArr, arrayList, str4, (String) null, (byte) 0, 0, 0, 0, (String) null, 2080768);
                                                                        }
                                                                        z2 = false;
                                                                    }
                                                                }
                                                                z2 = false;
                                                                deviceInfo2 = null;
                                                            }
                                                        } else {
                                                            str11 = "TransConnect:";
                                                        }
                                                        pVar2 = pVar2;
                                                        z2 = false;
                                                        deviceInfo2 = null;
                                                    } else {
                                                        str11 = "TransConnect:";
                                                        pVar2 = pVar2;
                                                        z2 = false;
                                                        deviceInfo2 = null;
                                                    }
                                                    deviceInfo = deviceInfo2;
                                                    str8 = str8;
                                                }
                                                deviceInfo2 = null;
                                                z2 = false;
                                                deviceInfo = deviceInfo2;
                                                str8 = str8;
                                            }
                                        }
                                        deviceInfo = null;
                                    }
                                }
                            } else {
                                i13 = i13;
                                str = ", ";
                                str11 = "TransConnect:";
                                q4Var = q4Var2;
                                bluetoothDevice = bluetoothDevice;
                                pVar2 = pVar2;
                                str2 = "SmartBluetoothManager";
                                str9 = "onDeviceDetected: ";
                                z2 = false;
                                Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                str8 = "mes";
                                Intrinsics.checkNotNullParameter("analysisDeviceInfo: not valid classic bt name, return", str8);
                                if (lb.f6529c >= 1) {
                                    Log.e("BluetoothScanTool", "TransConnect:analysisDeviceInfo: not valid classic bt name, return", null);
                                }
                                deviceInfo = null;
                            }
                            if (pVar2 == null) {
                                pVar = null;
                            } else {
                                pVar = pVar2;
                            }
                            if (pVar != null) {
                                arrayList2 = pVar.f5471a;
                                if (arrayList2 == null && (!arrayList2.isEmpty())) {
                                    if ((deviceInfo != null ? Byte.valueOf(deviceInfo.f4220a) : null) != null) {
                                        ArrayList arrayList4 = pVar.f5471a;
                                        Intrinsics.checkNotNull(arrayList4);
                                        if (arrayList4.contains(Byte.valueOf(deviceInfo.f4220a))) {
                                            h.h("BluetoothScanTool", "analysisClassicBtDevice: SubTypeMatched");
                                            str6 = str11;
                                            z3 = true;
                                        }
                                    }
                                    String str14 = "analysisClassicBtDevice:productSubType:" + (deviceInfo != null ? Byte.valueOf(deviceInfo.f4220a) : null) + " not match";
                                    Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                    Intrinsics.checkNotNullParameter(str14, str8);
                                    if (lb.f6529c >= 1) {
                                        str6 = str11;
                                        h0.a.x(str6, str14, "BluetoothScanTool", null);
                                    } else {
                                        str6 = str11;
                                    }
                                    z3 = z2;
                                } else {
                                    str6 = str11;
                                    z3 = true;
                                }
                                i9 = pVar.f5472b;
                                if (i9 != -100) {
                                    i10 = i13;
                                    if (i10 >= i9) {
                                        h.h("BluetoothScanTool", "analysisClassicBtDevice: Rssi Matched");
                                        z5 = true;
                                    } else {
                                        strG = o.d.g(i10, i9, "analysisClassicBtDevice: rssi:", " minRssi:", " not match");
                                        Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                        Intrinsics.checkNotNullParameter(strG, str8);
                                        if (lb.f6529c >= 1) {
                                            h0.a.x(str6, strG, "BluetoothScanTool", null);
                                        }
                                        z5 = z2;
                                    }
                                } else {
                                    z5 = true;
                                }
                                if (z3 || !z5) {
                                    h.h("BluetoothScanTool", "analysisClassicBtDevice: isSubTypeMatched && isMacAddressMatched && isRssiMatched Matched");
                                    h.j("BluetoothScanTool", "analysisClassicBtDevice: Filter Not Matched, ignore");
                                }
                            }
                            h.h("BluetoothScanTool", "analysisClassicBtDevice: Filter All Matched, now call back mDiscoveryCallback");
                            btDevice = bluetoothDevice;
                            Intrinsics.checkNotNullParameter(btDevice, "btDevice");
                            if (deviceInfo != null) {
                                h.h(str2, str9 + btDevice + str + deviceInfo);
                                function2 = (Function2) q4Var.f9952c.get(UInt.m248boximpl(4));
                                if (function2 != null) {
                                    function2.invoke(btDevice, deviceInfo);
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } else {
                            String mes = "analysisDeviceInfo: name is null or length: " + Integer.valueOf(name2.length()) + " is error, return";
                            Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                            Intrinsics.checkNotNullParameter(mes, "mes");
                            if (lb.f6529c >= 1) {
                                h0.a.x("TransConnect:", mes, "BluetoothScanTool", null);
                            }
                            i13 = i13;
                            str = ", ";
                            deviceInfo = null;
                            q4Var = q4Var2;
                            str2 = "SmartBluetoothManager";
                        }
                        z2 = false;
                        if (pVar2 == null) {
                            pVar = null;
                        } else {
                            pVar = pVar2;
                        }
                        if (pVar != null) {
                            arrayList2 = pVar.f5471a;
                            if (arrayList2 == null) {
                                str6 = str11;
                                z3 = true;
                            } else {
                                str6 = str11;
                                z3 = true;
                            }
                            i9 = pVar.f5472b;
                            if (i9 != -100) {
                                i10 = i13;
                                if (i10 >= i9) {
                                    h.h("BluetoothScanTool", "analysisClassicBtDevice: Rssi Matched");
                                    z5 = true;
                                } else {
                                    strG = o.d.g(i10, i9, "analysisClassicBtDevice: rssi:", " minRssi:", " not match");
                                    Intrinsics.checkNotNullParameter("BluetoothScanTool", "tag");
                                    Intrinsics.checkNotNullParameter(strG, str8);
                                    if (lb.f6529c >= 1) {
                                        h0.a.x(str6, strG, "BluetoothScanTool", null);
                                    }
                                    z5 = z2;
                                }
                            } else {
                                z5 = true;
                            }
                            if (z3) {
                            }
                            h.h("BluetoothScanTool", "analysisClassicBtDevice: isSubTypeMatched && isMacAddressMatched && isRssiMatched Matched");
                            h.j("BluetoothScanTool", "analysisClassicBtDevice: Filter Not Matched, ignore");
                        }
                        h.h("BluetoothScanTool", "analysisClassicBtDevice: Filter All Matched, now call back mDiscoveryCallback");
                        btDevice = bluetoothDevice;
                        Intrinsics.checkNotNullParameter(btDevice, "btDevice");
                        if (deviceInfo != null) {
                            h.h(str2, str9 + btDevice + str + deviceInfo);
                            function2 = (Function2) q4Var.f9952c.get(UInt.m248boximpl(4));
                            if (function2 != null) {
                                function2.invoke(btDevice, deviceInfo);
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                break;
            case 4:
                q5.a aVar = ((z0) this.f1165b).f10076b;
                String error = (String) this.f1167d;
                Intrinsics.checkNotNullParameter(error, "error");
                String log = "onNearScanResult: " + this.f1166c + ", " + error;
                Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
                Intrinsics.checkNotNullParameter(log, "log");
                if (gc.f6462a <= 3) {
                    Log.d(gc.f6463b.concat("TranConnectManager"), log);
                }
                break;
            case 5:
                j jVar = (j) this.f1165b;
                jVar.getClass();
                if (m.e(258)) {
                    m.c(258);
                }
                jVar.q = 0;
                LinkedHashSet<w> linkedHashSet = jVar.f4136g;
                LinkedHashSet linkedHashSet2 = jVar.f4137h;
                Map map = jVar.f4134c;
                BluetoothGatt bluetoothGatt2 = (BluetoothGatt) this.f1167d;
                int i25 = this.f1166c;
                if (i25 == 0) {
                    x1 x1Var = (x1) map.get(bluetoothGatt2.getDevice().getAddress());
                    if (x1Var != null && (nearDevice = x1Var.f10057c) != null) {
                        nearDevice.f3899w = PointerIconCompat.TYPE_ALIAS;
                    }
                    map.remove(bluetoothGatt2.getDevice().getAddress());
                    linkedHashSet2.remove(bluetoothGatt2.getDevice());
                    for (w wVar : linkedHashSet) {
                        if (4096 != jVar.f4145r) {
                            BluetoothDevice device = bluetoothGatt2.getDevice();
                            Intrinsics.checkNotNullExpressionValue(device, "getDevice(...)");
                            wVar.b(jVar.f4145r, device, x1Var != null ? x1Var.f10057c : null);
                        } else {
                            BluetoothDevice device2 = bluetoothGatt2.getDevice();
                            Intrinsics.checkNotNullExpressionValue(device2, "getDevice(...)");
                            wVar.b(4096, device2, x1Var != null ? x1Var.f10057c : null);
                        }
                    }
                    jVar.f4145r = 4096;
                    if (x1Var != null && (bluetoothGatt = x1Var.f10056b) != null) {
                        bluetoothGatt.close();
                        break;
                    }
                } else if (i25 == 2) {
                    BluetoothDevice device3 = bluetoothGatt2.getDevice();
                    Intrinsics.checkNotNullExpressionValue(device3, "getDevice(...)");
                    linkedHashSet2.add(device3);
                    Object obj2 = map.get(bluetoothGatt2.getDevice().getAddress());
                    if (obj2 == null) {
                        Map map2 = com.welink.protocol.nfbd.h.f4132a;
                        BluetoothDevice device4 = bluetoothGatt2.getDevice();
                        Intrinsics.checkNotNullExpressionValue(device4, "getDevice(...)");
                        NearDevice nearDeviceA = com.welink.protocol.nfbd.h.a(device4);
                        BluetoothDevice device5 = bluetoothGatt2.getDevice();
                        Intrinsics.checkNotNullExpressionValue(device5, "getDevice(...)");
                        x1 x1Var2 = new x1(device5, bluetoothGatt2, nearDeviceA);
                        map.put(bluetoothGatt2.getDevice().getAddress(), x1Var2);
                        obj2 = x1Var2;
                    }
                    NearDevice nearDevice3 = ((x1) obj2).f10057c;
                    nearDevice3.A(PointerIconCompat.TYPE_HELP);
                    nearDevice3.f3899w = PointerIconCompat.TYPE_TEXT;
                    for (w wVar2 : linkedHashSet) {
                        BluetoothDevice device6 = bluetoothGatt2.getDevice();
                        Intrinsics.checkNotNullExpressionValue(device6, "getDevice(...)");
                        wVar2.a(device6, nearDevice3);
                    }
                    bluetoothGatt2.requestMtu(517);
                    v1 v1Var = new v1(jVar, bluetoothGatt2, i11, b10);
                    ConcurrentHashMap concurrentHashMap = m.f10734a;
                    m.a(259, CoroutineLiveDataKt.DEFAULT_TIMEOUT, jVar.a(), v1Var);
                    break;
                }
                break;
            case 6:
                y yVar = (y) this.f1165b;
                DeviceInfo deviceInfo3 = (DeviceInfo) this.f1167d;
                int i26 = this.f1166c;
                h.g("Notify disconnectFailed");
                NearDevice nearDeviceV = yVar.v(deviceInfo3);
                if (deviceInfo3 == null) {
                    ConcurrentHashMap.KeySetView<NearDevice> mNearDevices = yVar.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices, "mNearDevices");
                    nearDeviceV = null;
                    for (NearDevice nearDevice4 : mNearDevices) {
                        Integer num = nearDevice4.f3898v;
                        if (num != null && num.intValue() == 1004) {
                            nearDeviceV = nearDevice4;
                        }
                    }
                }
                if (nearDeviceV != null) {
                    ConcurrentHashMap.KeySetView mNearDevices2 = yVar.f4196j;
                    Intrinsics.checkNotNullExpressionValue(mNearDevices2, "mNearDevices");
                    for (Object obj3 : mNearDevices2) {
                        if (Intrinsics.areEqual((NearDevice) obj3, nearDeviceV)) {
                            obj = obj3;
                            nearDevice2 = (NearDevice) obj;
                            if (nearDevice2 != null) {
                                nearDevice2.A(PointerIconCompat.TYPE_CELL);
                            }
                            eVar = yVar.f4201o;
                            if (eVar != null) {
                                eVar.u(nearDeviceV, i26);
                            }
                            break;
                        }
                    }
                    nearDevice2 = (NearDevice) obj;
                    if (nearDevice2 != null) {
                        nearDevice2.A(PointerIconCompat.TYPE_CELL);
                    }
                    eVar = yVar.f4201o;
                    if (eVar != null) {
                        eVar.u(nearDeviceV, i26);
                    }
                } else {
                    Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                    Intrinsics.checkNotNullParameter("Current Disconnecting Device is null, ignore", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("SmartConnectWrapper", "TransConnect:Current Disconnecting Device is null, ignore", null);
                    }
                }
                break;
            case 7:
                ((DeviceProfileWriter) this.f1165b).lambda$result$0(this.f1166c, this.f1167d);
                break;
            default:
                int i27 = OSSegmentedTab.f3401n;
                View tab = (View) this.f1165b;
                Intrinsics.checkNotNullParameter(tab, "$tab");
                OSSegmentedTab this$0 = (OSSegmentedTab) this.f1167d;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                this$0.a(tab.getLeft() + this$0.f3406h, this.f1166c);
                break;
        }
    }

    public /* synthetic */ d(Object obj, int i8, Object obj2, int i9) {
        this.f1164a = i9;
        this.f1165b = obj;
        this.f1166c = i8;
        this.f1167d = obj2;
    }

    public /* synthetic */ d(Object obj, Object obj2, int i8, int i9) {
        this.f1164a = i9;
        this.f1165b = obj;
        this.f1167d = obj2;
        this.f1166c = i8;
    }
}
