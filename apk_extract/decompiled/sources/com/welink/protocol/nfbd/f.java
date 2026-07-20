package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import li.v0;
import org.json.JSONException;
import org.json.JSONObject;
import se.g2;
import se.h2;
import se.h4;
import se.i2;
import se.n0;
import se.o0;
import se.p0;
import se.q0;
import se.r0;
import se.z1;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends we.g {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final se.g0 f4099r = new se.g0(p0.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h4 f4100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f4101d;
    public pe.d e;
    public final LinkedHashSet f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4102g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashMap f4103h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashMap f4104i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashMap f4105j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ye.d f4106k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public i2 f4107l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f4108m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashSet f4109n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4110o;
    public int p;
    public final q0 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, d dVar, h4 h4Var) {
        super(false, "NearBluetoothServer");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = new LinkedHashSet();
        this.f4102g = new LinkedHashMap();
        this.f4103h = new LinkedHashMap();
        this.f4104i = new LinkedHashMap();
        this.f4105j = new LinkedHashMap();
        this.f4108m = new LinkedHashMap();
        this.f4109n = new LinkedHashSet();
        this.q = new q0(this);
        this.f4100c = h4Var;
        this.f4101d = dVar;
        this.f4106k = new ye.d(context);
    }

    public static final void j(f fVar, String str, String str2, WifiP2pDevice wifiP2pDevice, String str3) {
        i2 i2Var = fVar.f4107l;
        NearDevice nearDevice = i2Var != null ? i2Var.f9797g : null;
        if (nearDevice != null) {
            WirelessDevice wirelessDevice = nearDevice.f3896s;
            if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
                Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
                WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
                i2 i2Var2 = fVar.f4107l;
                TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var2 != null ? i2Var2.f9793a : null, i2Var2 != null ? i2Var2.f9796d : null, i2Var2 != null ? i2Var2.f9795c : 0, str, str2, i2Var2 != null ? i2Var2.e : 0, i2Var2 != null ? i2Var2.f : 0, wifiP2pDevice, null);
                for (se.a0 a0Var : fVar.f) {
                    BluetoothDevice bluetoothDevice = bluetooth.f4011d;
                    if (bluetoothDevice != null) {
                        a0Var.d(bluetoothDevice, wifiP2pDevice, str3, str, str2, tranConnectionController$P2pDeviceInfo, nearDevice);
                    }
                }
                fVar.f4102g.clear();
                fVar.f4107l = null;
                return;
            }
        }
        Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
        Intrinsics.checkNotNullParameter("sendWifiDirectGroupClientAvailable: device not found", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearBluetoothServer", "TransConnect:sendWifiDirectGroupClientAvailable: device not found", null);
        }
        h4 h4Var = fVar.f4100c;
        if (h4Var != null) {
            h4Var.C();
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0056 A[Catch: all -> 0x0021, TryCatch #0 {all -> 0x0021, blocks: (B:3:0x0001, B:4:0x000b, B:6:0x0012, B:12:0x0025, B:14:0x002f, B:15:0x0037, B:17:0x003d, B:29:0x005c, B:30:0x0064, B:32:0x006a, B:38:0x007f, B:39:0x0089, B:41:0x008f, B:42:0x009e, B:44:0x00aa, B:46:0x00b8, B:48:0x00c0, B:52:0x00de, B:49:0x00c6, B:51:0x00d9, B:53:0x00ea, B:55:0x00fd, B:56:0x010e, B:24:0x0052, B:26:0x0056), top: B:61:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0059  */
    public static final void k(f fVar, WifiP2pDevice wifiP2pDevice, String str) {
        String str2;
        i2 i2Var;
        NearDevice nearDevice;
        NearDevice nearDevice2;
        BluetoothDevice bluetoothDevice;
        synchronized (fVar) {
            try {
                Iterator it = fVar.f4105j.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        str2 = null;
                        break;
                    }
                    str2 = (String) ((Map.Entry) it.next()).getKey();
                } while (str2 == null);
                Map map = (Map) fVar.f4105j.get(str2);
                if (map != null) {
                    Iterator it2 = map.entrySet().iterator();
                    do {
                        if (!it2.hasNext()) {
                            nearDevice2 = null;
                            break;
                        }
                        nearDevice2 = (NearDevice) ((Map.Entry) it2.next()).getValue();
                    } while (nearDevice2 == null);
                    if (nearDevice2 == null) {
                        i2Var = fVar.f4107l;
                        if (i2Var != null) {
                            nearDevice2 = i2Var.f9797g;
                            nearDevice = nearDevice2;
                        } else {
                            nearDevice = null;
                        }
                    } else {
                        nearDevice = nearDevice2;
                    }
                } else {
                    i2Var = fVar.f4107l;
                    if (i2Var != null) {
                        nearDevice2 = i2Var.f9797g;
                        nearDevice = nearDevice2;
                    } else {
                        nearDevice = null;
                    }
                }
                if (map == null) {
                    bluetoothDevice = null;
                    break;
                }
                Iterator it3 = map.entrySet().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        bluetoothDevice = null;
                        break;
                    }
                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) ((Map.Entry) it3.next()).getKey();
                    if (bluetoothDevice2 != null) {
                        bluetoothDevice = bluetoothDevice2;
                        break;
                    }
                }
                if (bluetoothDevice == null || nearDevice == null) {
                    Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                    Intrinsics.checkNotNullParameter("Bluetooth device or gatt client is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothServer", "TransConnect:Bluetooth device or gatt client is null", null);
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    nearDevice.f3900x = PointerIconCompat.TYPE_NO_DROP;
                    Iterator it4 = fVar.f.iterator();
                    while (it4.hasNext()) {
                        ((se.a0) it4.next()).c(bluetoothDevice, wifiP2pDevice, nearDevice, str, null);
                    }
                    if (fVar.f4104i.get(bluetoothDevice.getAddress()) != null) {
                        z1 z1Var = (z1) fVar.f4104i.get(bluetoothDevice.getAddress());
                        if (z1Var != null && Intrinsics.areEqual(z1Var.f10077a, bluetoothDevice)) {
                            z1Var.f10078b.add(wifiP2pDevice);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(wifiP2pDevice);
                        z1 z1Var2 = new z1(bluetoothDevice, arrayList, nearDevice);
                        String address = bluetoothDevice.getAddress();
                        if (address != null) {
                            fVar.f4104i.put(address, z1Var2);
                        }
                    }
                    fVar.f4107l = null;
                    TypeIntrinsics.asMutableMap(fVar.f4105j).remove(str2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final void l(f fVar, BluetoothDevice bluetoothDevice, NearDevice nearDevice, String str, String str2, String str3, int i8, WifiP2pDevice wifiP2pDevice) {
        String str4;
        NearDevice nearDevice2;
        BluetoothDevice bluetoothDevice2;
        synchronized (fVar) {
            try {
                Iterator it = fVar.f4105j.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        str4 = null;
                        break;
                    }
                    str4 = (String) ((Map.Entry) it.next()).getKey();
                } while (str4 == null);
                Map map = (Map) fVar.f4105j.get(str4);
                if (map == null) {
                    nearDevice2 = null;
                    break;
                }
                Iterator it2 = map.entrySet().iterator();
                do {
                    if (!it2.hasNext()) {
                        nearDevice2 = null;
                        break;
                    }
                    nearDevice2 = (NearDevice) ((Map.Entry) it2.next()).getValue();
                } while (nearDevice2 == null);
                if (map == null) {
                    bluetoothDevice2 = null;
                    break;
                }
                Iterator it3 = map.entrySet().iterator();
                do {
                    if (!it3.hasNext()) {
                        bluetoothDevice2 = null;
                        break;
                    }
                    bluetoothDevice2 = (BluetoothDevice) ((Map.Entry) it3.next()).getKey();
                } while (bluetoothDevice2 == null);
                BluetoothDevice bluetoothDevice3 = bluetoothDevice == null ? bluetoothDevice2 : bluetoothDevice;
                if (nearDevice != null) {
                    nearDevice2 = nearDevice;
                }
                if (bluetoothDevice3 != null && fVar.f4109n.contains(bluetoothDevice3)) {
                    pe.d dVar = fVar.e;
                    if (dVar != null && dVar.q()) {
                        byte[] bArrM = fVar.m(i8, nearDevice2, str, str2, str3);
                        if (bArrM.length != 0) {
                            fVar.t(bluetoothDevice3, 0, bArrM);
                            Iterator it4 = fVar.f.iterator();
                            while (it4.hasNext()) {
                                ((se.a0) it4.next()).f(bluetoothDevice3, wifiP2pDevice, nearDevice);
                            }
                            r();
                            h4 h4Var = fVar.f4100c;
                            if (h4Var != null) {
                                h4.F(h4Var, bluetoothDevice, wifiP2pDevice, nearDevice, 0L, 24);
                                Unit unit = Unit.INSTANCE;
                            }
                            return;
                        }
                        Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                        Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearBluetoothServer", "TransConnect:sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", null);
                        }
                        r();
                        h4 h4Var2 = fVar.f4100c;
                        if (h4Var2 != null) {
                            h4Var2.D(bluetoothDevice3, wifiP2pDevice, nearDevice);
                        }
                        return;
                    }
                    Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                    Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: notifyCharacteristic is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothServer", "TransConnect:sendWifiDirectGroupOwnerAvailable: notifyCharacteristic is null", null);
                    }
                    h4 h4Var3 = fVar.f4100c;
                    if (h4Var3 != null) {
                        h4Var3.D(bluetoothDevice3, wifiP2pDevice, nearDevice);
                    }
                    return;
                }
                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable:  device is null or not registered", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothServer", "TransConnect:sendWifiDirectGroupOwnerAvailable:  device is null or not registered", null);
                }
                fVar.f4105j.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void r() {
        if (we.m.e(1029)) {
            we.m.c(1029);
            we.h.b("NearBluetoothServer", "GATT waiting response timer cancelled");
        }
    }

    @Override // we.g
    public final void b(Message msg) throws JSONException {
        String str;
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = msg.what;
        LinkedHashSet linkedHashSet = this.f4109n;
        switch (i8) {
            case 8193:
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                int i9 = msg.arg1;
                if (i9 != 0) {
                    LinkedHashSet linkedHashSet2 = this.f;
                    switch (i9) {
                        case 102:
                            linkedHashSet.add(bluetoothDevice);
                            Iterator it = linkedHashSet2.iterator();
                            while (it.hasNext()) {
                                ((se.a0) it.next()).a(bluetoothDevice);
                            }
                            break;
                        case DeviceType.INFRARED_TV_BOX /* 103 */:
                            linkedHashSet.remove(bluetoothDevice);
                            NearDevice nearDevice = (NearDevice) this.f4108m.remove(bluetoothDevice.getAddress());
                            if (we.m.e(1027)) {
                                we.m.c(1027);
                                v(null, null);
                            }
                            Iterator it2 = linkedHashSet2.iterator();
                            while (it2.hasNext()) {
                                ((se.a0) it2.next()).b(16384, bluetoothDevice, nearDevice);
                            }
                            break;
                        case 104:
                            we.h.b("NearBluetoothServer", "BluetoothConnection.STATE_LISTENING");
                            break;
                        default:
                            if (i9 != 0) {
                                switch (i9) {
                                    case 101:
                                        str = "CONNECTING";
                                        break;
                                    case 102:
                                        str = "CONNECTED";
                                        break;
                                    case DeviceType.INFRARED_TV_BOX /* 103 */:
                                        str = "DISCONNECTED";
                                        break;
                                    case 104:
                                        str = "LISTEN";
                                        break;
                                    case DeviceType.INFRARED_AIR_CONDITION /* 105 */:
                                        str = "ACL_DISCONNECTED";
                                        break;
                                    default:
                                        str = "UNKNOWN";
                                        break;
                                }
                            } else {
                                str = "NONE";
                            }
                            we.h.b("NearBluetoothServer", "BluetoothConnection.STATE_UNKNOWN: ".concat(str));
                            break;
                    }
                } else {
                    we.h.b("NearBluetoothServer", "BluetoothConnection.STATE_NONE");
                    break;
                }
                break;
            case 8194:
                we.h.b("NearBluetoothServer", "MSG_CONNECTION_MESSAGE_SENT, " + msg.arg1 + " bytes");
                break;
            case 8195:
                Bundle data = msg.getData();
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) data.getParcelable("device", BluetoothDevice.class);
                byte[] byteArray = data.getByteArray("receiveData");
                if (byteArray == null || bluetoothDevice2 == null || !linkedHashSet.contains(bluetoothDevice2)) {
                    Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                    Intrinsics.checkNotNullParameter("handleReceivedData, data or device is null or not connected", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothServer", "TransConnect:handleReceivedData, data or device is null or not connected", null);
                    }
                    break;
                } else {
                    int i10 = se.a.f9637a;
                    String address = bluetoothDevice2.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    if (!se.a.a(address, byteArray)) {
                        o.d.z("Receiving partial data: ", se.a.b(byteArray), "NearBluetoothServer");
                        break;
                    } else {
                        String address2 = bluetoothDevice2.getAddress();
                        Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                        byte[] bArrC = se.a.c(address2);
                        if (bArrC != null && bArrC.length != 0) {
                            try {
                                JSONObject jSONObject = new JSONObject(new String(bArrC, Charsets.UTF_8));
                                String string = jSONObject.getString("Version");
                                int i11 = jSONObject.getInt("Encrypt");
                                d dVar = this.f4101d;
                                CharSequence charSequence = dVar != null ? "1.0" : null;
                                if (charSequence != null) {
                                    Intrinsics.checkNotNull(string);
                                    List listSplit$default = StringsKt__StringsKt.split$default(charSequence, new String[]{"."}, false, 0, 6, (Object) null);
                                    ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
                                    Iterator it3 = listSplit$default.iterator();
                                    while (it3.hasNext()) {
                                        arrayList.add(Integer.valueOf(Integer.parseInt((String) it3.next())));
                                    }
                                    List listSplit$default2 = StringsKt__StringsKt.split$default(string, new String[]{"."}, false, 0, 6, (Object) null);
                                    ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default2));
                                    Iterator it4 = listSplit$default2.iterator();
                                    while (it4.hasNext()) {
                                        arrayList2.add(Integer.valueOf(Integer.parseInt((String) it4.next())));
                                    }
                                    if (((Number) arrayList.get(0)).intValue() > ((Number) arrayList2.get(0)).intValue() || (((Number) arrayList.get(0)).intValue() == ((Number) arrayList2.get(0)).intValue() && ((Number) arrayList.get(1)).intValue() >= ((Number) arrayList2.get(1)).intValue())) {
                                        if (Intrinsics.areEqual(string, "1.0") && i11 == 0) {
                                            o.d.z("Received connect request: version: ", string, "NearBluetoothServer");
                                            p(jSONObject, string, i11, bluetoothDevice2);
                                        } else if (Intrinsics.areEqual(string, "2.0") && i11 == 0) {
                                            o.d.z("Received connect request: version: ", string, "NearBluetoothServer");
                                            p(jSONObject, string, i11, bluetoothDevice2);
                                        } else {
                                            Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                                            Intrinsics.checkNotNullParameter("Unsupported version or encrypt", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("NearBluetoothServer", "TransConnect:Unsupported version or encrypt", null);
                                            }
                                            CollectionsKt.emptyList();
                                            o0 o0Var = new o0(this, bluetoothDevice2, dVar != null ? "1.0" : null, i11, 6, 0);
                                            ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                                            we.m.a(1028, 10L, a(), o0Var);
                                        }
                                    }
                                }
                                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                                Intrinsics.checkNotNullParameter("Unsupported version or encrypt", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearBluetoothServer", "TransConnect:Unsupported version or encrypt", null);
                                }
                                CollectionsKt.emptyList();
                                o0 o0Var2 = new o0(this, bluetoothDevice2, dVar != null ? "1.0" : null, i11, 5, 0);
                                ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
                                we.m.a(1028, 10L, a(), o0Var2);
                            } catch (Exception e) {
                                String mes = "parseIncomingRequest: " + e;
                                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                                Intrinsics.checkNotNullParameter(mes, "mes");
                                if (lb.f6529c >= 1) {
                                    h0.a.x("TransConnect:", mes, "NearBluetoothServer", null);
                                    return;
                                }
                                return;
                            }
                            break;
                        }
                    }
                }
                break;
        }
    }

    public final byte[] m(int i8, NearDevice nearDevice, String str, String str2, String str3) {
        Object obj = this.f4101d != null ? "1.0" : null;
        if (Intrinsics.areEqual(obj, "1.0")) {
            String string = o("1.0", nearDevice, str2, str3, i8, str).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        if (!Intrinsics.areEqual(obj, "2.0")) {
            return new byte[0];
        }
        String string2 = o("2.0", nearDevice, str2, str3, i8, str).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        byte[] bytes2 = string2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return bytes2;
    }

    public final void n(BluetoothDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        pe.d dVar = this.e;
        if (dVar == null || !dVar.q()) {
            Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
            Intrinsics.checkNotNullParameter("disconnect failed, mBluetoothConnection is null or not connected", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothServer", "TransConnect:disconnect failed, mBluetoothConnection is null or not connected", null);
                return;
            }
            return;
        }
        LinkedHashSet linkedHashSet = this.f4109n;
        if (!linkedHashSet.contains(device)) {
            String strN = o.d.n("No connected device found for address: ", device.getAddress(), "NearBluetoothServer", "tag", "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", strN, "NearBluetoothServer", null);
                return;
            }
            return;
        }
        if (linkedHashSet.contains(device)) {
            pe.d dVar2 = this.e;
            if (dVar2 != null) {
                dVar2.n(device);
            }
            linkedHashSet.remove(device);
        }
        we.h.h("NearBluetoothServer", "Disconnect P2p device");
        if (this.f4102g.isEmpty() && this.f4103h.isEmpty() && this.f4105j.isEmpty() && this.f4104i.isEmpty()) {
            we.h.b("NearBluetoothServer", "P2p over Gatt server is not running");
            we.h.b("NearBluetoothServer", "No p2p business running ignore");
            return;
        }
        we.h.b("NearBluetoothServer", "P2p over Gatt server is running");
        h4 h4Var = this.f4100c;
        if (h4Var == null || h4Var.l()) {
            return;
        }
        h4Var.o();
    }

    public final JSONObject o(String str, NearDevice nearDevice, String str2, String str3, int i8, String str4) throws JSONException {
        byte bE;
        byte bG;
        int iD;
        BluetoothManager bluetoothManager;
        BluetoothAdapter adapter;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", str);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", 48125);
        d dVar = this.f4101d;
        jSONObject.put("DeviceId", dVar != null ? dVar.o() : null);
        jSONObject.put("DeviceName", (dVar == null || (bluetoothManager = dVar.f) == null || (adapter = bluetoothManager.getAdapter()) == null) ? null : adapter.getName());
        jSONObject.put("FileCount", 0);
        jSONObject.put("FileName", "Connect Notification");
        jSONObject.put("TotalFileSize", 0);
        jSONObject.put("Ssid", str2);
        jSONObject.put("Pwd", str3);
        jSONObject.put("Mac", "02:00:00:00:00:00");
        jSONObject.put("GoIpAddr", str4);
        jSONObject.put("Chan", 0);
        jSONObject.put("Freq", i8);
        jSONObject.put("Port", 0);
        jSONObject.put("MessagePort", 0);
        jSONObject.put("DeviceMac", dVar != null ? dVar.p() : null);
        if (nearDevice != null) {
            Map map = h.f4132a;
            bE = h.e(nearDevice.f3889j);
        } else {
            bE = 0;
        }
        jSONObject.put("ProductSubType", Byte.valueOf(bE));
        if (nearDevice != null) {
            Map map2 = h.f4132a;
            bG = h.g(nearDevice.h());
        } else {
            bG = -1;
        }
        jSONObject.put("ProductBrandName", Byte.valueOf(bG));
        jSONObject.put("ProductNameCode", nearDevice != null ? nearDevice.r() : "0000");
        if (nearDevice != null) {
            Map map3 = h.f4132a;
            iD = h.d(nearDevice.e);
        } else {
            iD = 0;
        }
        jSONObject.put("ServiceType", iD);
        jSONObject.put("Protocol", 0);
        jSONObject.put("state", 4);
        Integer numValueOf = nearDevice != null ? Integer.valueOf(nearDevice.p) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            jSONObject.put("ServerP2pMode", 2);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            jSONObject.put("ServerP2pMode", 1);
        } else {
            jSONObject.put("ServerP2pMode", 0);
        }
        if (nearDevice != null) {
            int i9 = nearDevice.e;
            byte[] bArrQ = dVar != null ? dVar.q(i9) : null;
            if (bArrQ != null) {
                jSONObject.put("ServiceData", Base64.encodeToString(bArrQ, 0));
            } else {
                byte[] bArrN = dVar != null ? dVar.n(i9, nearDevice, str) : null;
                if (bArrN != null) {
                    jSONObject.put("ServiceData", Base64.encodeToString(bArrN, 0));
                } else {
                    jSONObject.put("ServiceData", "");
                    we.h.j("NearBluetoothServer", "buildConnectRequest: serviceData and capability is null");
                }
            }
        }
        List listR = dVar != null ? dVar.r() : null;
        if (listR != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(listR, " ", null, null, 0, null, null, 62, null));
        }
        return jSONObject;
    }

    public final void p(JSONObject jSONObject, String str, int i8, BluetoothDevice bluetoothDevice) throws JSONException {
        String string;
        int i9;
        String string2;
        long j8;
        String string3;
        String string4;
        String string5;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String string6;
        String string7;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        String string8;
        String str2;
        int iM254constructorimpl;
        int i20;
        String string9 = "";
        int i21 = jSONObject.getInt("ReqType");
        try {
            string = jSONObject.getString("DeviceId");
        } catch (Exception unused) {
            string = "";
        }
        try {
            i9 = jSONObject.getInt("FileCount");
        } catch (Exception unused2) {
            i9 = 0;
        }
        try {
            string2 = jSONObject.getString("FileName");
        } catch (Exception unused3) {
            string2 = "";
        }
        Intrinsics.checkNotNull(string2);
        List listSplit$default = StringsKt__StringsKt.split$default(string2, new String[]{","}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
        Iterator it = listSplit$default.iterator();
        while (it.hasNext()) {
            arrayList.add(StringsKt__StringsKt.trim((CharSequence) ((String) it.next())).toString());
        }
        try {
            j8 = jSONObject.getLong("TotalFileSize");
        } catch (Exception unused4) {
            j8 = 0;
        }
        try {
            string3 = jSONObject.getString("Ssid");
        } catch (Exception unused5) {
            string3 = "";
        }
        try {
            string4 = jSONObject.getString("Pwd");
        } catch (Exception unused6) {
            string4 = "";
        }
        try {
            string5 = jSONObject.getString("Mac");
        } catch (Exception unused7) {
            string5 = "";
        }
        try {
            jSONObject.getString("GoIpAddr");
        } catch (Exception unused8) {
        }
        try {
            i10 = jSONObject.getInt("Chan");
        } catch (Exception unused9) {
            i10 = -1;
        }
        int i22 = i10;
        try {
            i11 = jSONObject.getInt("Freq");
        } catch (Exception unused10) {
            i11 = 0;
        }
        try {
            i12 = jSONObject.getInt("Port");
        } catch (Exception unused11) {
            i12 = 8100;
        }
        try {
            i13 = jSONObject.getInt("MessagePort");
        } catch (Exception unused12) {
            i13 = 8100;
        }
        try {
            i14 = jSONObject.getInt("ClientP2pMode");
        } catch (Exception unused13) {
            i14 = 2;
        }
        int i23 = i14;
        try {
            string6 = jSONObject.getString("DeviceName");
        } catch (Exception unused14) {
            string6 = "";
        }
        try {
            string7 = jSONObject.getString("DeviceMac");
        } catch (Exception unused15) {
            string7 = "";
        }
        try {
            i15 = jSONObject.getInt("ProductSubType");
        } catch (Exception unused16) {
            i15 = 0;
        }
        try {
            i16 = jSONObject.getInt("ProductBrandName");
        } catch (Exception unused17) {
            i16 = 0;
        }
        try {
            string9 = jSONObject.getString("ProductNameCode");
        } catch (Exception unused18) {
        }
        try {
            i17 = jSONObject.getInt("ServiceType");
        } catch (Exception unused19) {
            i17 = 0;
        }
        try {
            i18 = jSONObject.getInt("SubCapability");
        } catch (Exception unused20) {
            i18 = 0;
        }
        try {
            i19 = jSONObject.getInt("Protocol");
        } catch (Exception unused21) {
            i19 = 0;
        }
        try {
            string8 = jSONObject.getString("ServiceData");
        } catch (Exception unused22) {
            string8 = null;
        }
        byte[] bArrDecode = string8 != null ? Base64.decode(string8, 0) : null;
        try {
            str2 = jSONObject.getString("BandSupport");
        } catch (Exception unused23) {
            str2 = new String();
        }
        Intrinsics.checkNotNull(str2);
        List listSplit$default2 = StringsKt__StringsKt.split$default(new Regex("\\s+").replace(str2, " "), new String[]{" "}, false, 0, 6, (Object) null);
        if (a.f4027k.c(str)) {
            long jOptLong = jSONObject.optLong("TargetService", 0L);
            int iM254constructorimpl2 = UInt.m254constructorimpl((int) (jOptLong & 4294967295L));
            iM254constructorimpl = UInt.m254constructorimpl((int) ((jOptLong >> 32) & 4294967295L));
            i20 = iM254constructorimpl2;
        } else {
            iM254constructorimpl = 0;
            i20 = 0;
        }
        ConnectRequest connectRequest = new ConnectRequest(str, i8, i21, string, i9, arrayList, j8, string3, string4, string5, i22, i11, i12, i13, i23, string6, string7, i15, i16, string9, i17, i18, i19, bArrDecode, listSplit$default2, UInt.m248boximpl(i20), UInt.m248boximpl(iM254constructorimpl), 402653184);
        LinkedHashSet linkedHashSet = this.f;
        if (i21 != 1 && i21 != 251) {
            if (i21 == 253) {
                we.h.b("NearBluetoothServer", "Received connect Invite request: " + connectRequest);
                r();
                this.f4102g.put(bluetoothDevice.getAddress(), new g2(bluetoothDevice, connectRequest));
                NearDevice nearDevice = (NearDevice) this.f4108m.get(bluetoothDevice.getAddress());
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((se.a0) it2.next()).h(bluetoothDevice, connectRequest, nearDevice);
                }
                return;
            }
            if (i21 != 4 && i21 != 5) {
                return;
            }
        }
        we.h.b("NearBluetoothServer", "Received connect request: " + connectRequest);
        Iterator it3 = linkedHashSet.iterator();
        while (it3.hasNext()) {
            ((se.a0) it3.next()).i(bluetoothDevice, connectRequest);
        }
    }

    public final void q() {
        h4 h4Var = this.f4100c;
        if (h4Var != null) {
            h4Var.u(new we.i(this), this.q, 320098820);
        }
        int i8 = this.p + 1;
        this.p = i8;
        h0.a.u(i8, "registerNearP2pManagerListener: count: ", "NearBluetoothServer");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0050  */
    /* JADX WARN: Code duplicated, block: B:18:0x0070  */
    /* JADX WARN: Code duplicated, block: B:19:0x0072  */
    /* JADX WARN: Code duplicated, block: B:22:0x0076  */
    /* JADX WARN: Code duplicated, block: B:27:0x0086  */
    /* JADX WARN: Code duplicated, block: B:29:0x008a  */
    /* JADX WARN: Code duplicated, block: B:34:0x009a A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:32:0x0096, B:34:0x009a, B:35:0x00a3), top: B:47:0x0096 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00d3 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:43:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:47:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00d4 -> B:44:0x00d6). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object s(byte[] r9, int r10, kotlin.coroutines.jvm.internal.ContinuationImpl r11) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.f.s(byte[], int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void t(BluetoothDevice bluetoothDevice, int i8, byte[] bArr) {
        li.l0.p(li.h0.a(v0.f7499b), null, null, new r0(this, bluetoothDevice, i8, bArr, 1, null), 3);
    }

    public final void u(BluetoothDevice bluetoothDevice) {
        o.e eVar = new o.e(5, this, bluetoothDevice);
        if (we.m.e(1029)) {
            we.h.b("NearBluetoothServer", "GATT waiting response timer already started, update timer");
            we.m.h(1029, 2000L, a(), eVar);
        } else {
            we.h.b("NearBluetoothServer", "GATT waiting response timer started");
            we.m.a(1029, 2000L, a(), eVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0032  */
    public final void v(BluetoothDevice bluetoothDevice, NearDevice nearDevice) {
        NearDevice nearDevice2;
        Integer num;
        z1 z1Var;
        h2 h2Var;
        int i8 = 0;
        we.h.h("NearBluetoothServer", "Terminated Rfcomm Socket Server");
        if (bluetoothDevice != null) {
            if (nearDevice == null) {
                we.h.j("NearBluetoothServer", "NearDevice is null, find again");
                nearDevice2 = (NearDevice) this.f4108m.get(bluetoothDevice.getAddress());
                if (nearDevice2 == null) {
                    i2 i2Var = this.f4107l;
                    if ((i2Var != null ? i2Var.f9797g : null) == null) {
                        LinkedHashMap linkedHashMap = this.f4103h;
                        if (linkedHashMap.isEmpty()) {
                            LinkedHashMap linkedHashMap2 = this.f4104i;
                            if (linkedHashMap2.isEmpty()) {
                                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                                Intrinsics.checkNotNullParameter("No near device found", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("NearBluetoothServer", "TransConnect:No near device found", null);
                                }
                            } else {
                                Iterator it = linkedHashMap2.entrySet().iterator();
                                do {
                                    if (!it.hasNext()) {
                                        z1Var = null;
                                        break;
                                    }
                                    z1Var = (z1) ((Map.Entry) it.next()).getValue();
                                } while (z1Var == null);
                                if (z1Var != null) {
                                    nearDevice2 = z1Var.f10079c;
                                } else {
                                    nearDevice2 = null;
                                }
                            }
                        } else {
                            Iterator it2 = linkedHashMap.entrySet().iterator();
                            do {
                                if (!it2.hasNext()) {
                                    h2Var = null;
                                    break;
                                }
                                h2Var = (h2) ((Map.Entry) it2.next()).getValue();
                            } while (h2Var == null);
                            if (h2Var != null) {
                                nearDevice2 = h2Var.f9761c;
                            } else {
                                nearDevice2 = null;
                            }
                        }
                    } else if (i2Var != null) {
                        nearDevice2 = i2Var.f9797g;
                    } else {
                        nearDevice2 = null;
                    }
                }
            } else {
                nearDevice2 = nearDevice;
            }
            if (nearDevice2 != null && (num = nearDevice2.f3898v) != null && num.intValue() == 1004) {
                pe.d dVar = this.e;
                if (dVar != null) {
                    dVar.n(bluetoothDevice);
                }
                this.f4109n.remove(bluetoothDevice);
                this.f4108m.remove(bluetoothDevice.getAddress());
                Iterator it3 = this.f.iterator();
                while (it3.hasNext()) {
                    ((se.a0) it3.next()).b(8192, bluetoothDevice, nearDevice2);
                }
            } else {
                if (nearDevice2 != null && nearDevice2.f3899w == 1008) {
                    we.h.b("NearBluetoothServer", "Device is still running connection, run stop timer");
                    n0 n0Var = new n0(this, bluetoothDevice, nearDevice, i8);
                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                    we.m.a(1027, 1500L, a(), n0Var);
                    return;
                }
                we.h.b("NearBluetoothServer", "No connected device or server is not running, stop server");
                if (this.f4109n.contains(bluetoothDevice)) {
                    this.f4109n.remove(bluetoothDevice);
                    we.h.j("NearBluetoothServer", "Probably it is external device removed from connected devices");
                    Iterator it4 = this.f.iterator();
                    while (it4.hasNext()) {
                        ((se.a0) it4.next()).b(8194, bluetoothDevice, null);
                    }
                }
            }
        }
        pe.d dVar2 = this.e;
        if (dVar2 != null) {
            synchronized (dVar2) {
                try {
                    we.h.b("BluetoothConnection", "stop");
                    pe.b bVar = dVar2.f8802h;
                    if (bVar != null) {
                        Intrinsics.checkNotNull(bVar);
                        bVar.f8794h.h(bVar.e);
                        bVar.a();
                        dVar2.f8802h = null;
                    }
                    pe.c cVar = dVar2.f8803i;
                    if (cVar != null) {
                        Intrinsics.checkNotNull(cVar);
                        cVar.a();
                        dVar2.f8803i = null;
                    }
                    pe.a aVar = dVar2.f;
                    if (aVar != null) {
                        Intrinsics.checkNotNull(aVar);
                        aVar.a();
                        dVar2.f = null;
                    }
                    pe.a aVar2 = dVar2.f8801g;
                    if (aVar2 != null) {
                        Intrinsics.checkNotNull(aVar2);
                        aVar2.a();
                        dVar2.f8801g = null;
                    }
                    dVar2.w();
                    dVar2.u(0);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            dVar2.f8809o = false;
        }
    }
}
