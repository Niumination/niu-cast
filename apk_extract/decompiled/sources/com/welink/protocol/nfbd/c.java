package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import k3.lb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import li.v0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import se.g2;
import se.h4;
import se.i2;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends we.g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final se.g0 f4072v = new se.g0(se.f0.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h4 f4073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f4074d;
    public boolean e;
    public pe.d f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f4075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f4076h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f4077i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f4078j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public CountDownLatch f4079k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4080l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ye.d f4081m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public i2 f4082n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashMap f4083o;
    public final LinkedHashMap p;
    public final LinkedHashMap q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final LinkedHashMap f4084r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f4085s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ArrayList f4086t;
    public final se.i0 u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, d dVar, h4 h4Var) {
        super(false, "NearBluetoothClient");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4075g = new LinkedHashSet();
        this.f4076h = new LinkedHashSet();
        this.f4077i = new LinkedHashSet();
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        this.f4078j = mapSynchronizedMap;
        this.f4080l = 12288;
        this.f4083o = new LinkedHashMap();
        this.p = new LinkedHashMap();
        this.q = new LinkedHashMap();
        this.f4084r = new LinkedHashMap();
        this.u = new se.i0(this);
        this.f4073c = h4Var;
        this.f4074d = dVar;
        this.f4081m = new ye.d(context);
    }

    public static final void j(c cVar, String str, String str2, WifiP2pDevice wifiP2pDevice, String str3) {
        i2 i2Var = cVar.f4082n;
        NearDevice nearDevice = i2Var != null ? i2Var.f9797g : null;
        if (nearDevice != null) {
            WirelessDevice wirelessDevice = nearDevice.f3896s;
            if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
                Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
                WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
                i2 i2Var2 = cVar.f4082n;
                TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var2 != null ? i2Var2.f9793a : null, i2Var2 != null ? i2Var2.f9796d : null, i2Var2 != null ? i2Var2.f9795c : 0, str, str2, i2Var2 != null ? i2Var2.e : 0, i2Var2 != null ? i2Var2.f : 0, wifiP2pDevice, null);
                for (se.w wVar : cVar.f4077i) {
                    BluetoothDevice bluetoothDevice = bluetooth.f4011d;
                    if (bluetoothDevice != null) {
                        wVar.d(bluetoothDevice, wifiP2pDevice, str3, str, str2, tranConnectionController$P2pDeviceInfo, nearDevice);
                    }
                }
                cVar.f4083o.clear();
                cVar.f4086t = null;
                cVar.f4082n = null;
                BluetoothDevice bluetoothDevice2 = bluetooth.f4011d;
                if (bluetoothDevice2 != null) {
                    cVar.m(bluetoothDevice2);
                    return;
                }
                return;
            }
        }
        Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
        Intrinsics.checkNotNullParameter("sendWifiDirectGroupClientAvailable: device not found", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearBluetoothClient", "TransConnect:sendWifiDirectGroupClientAvailable: device not found", null);
        }
        h4 h4Var = cVar.f4073c;
        if (h4Var != null) {
            h4Var.C();
        }
    }

    public static final void k(c cVar, BluetoothDevice bluetoothDevice, String str, String str2, String str3, int i8, WifiP2pDevice wifiP2pDevice) {
        String str4;
        synchronized (cVar) {
            try {
                Iterator it = cVar.p.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        str4 = null;
                        break;
                    }
                    str4 = (String) ((Map.Entry) it.next()).getKey();
                } while (str4 == null);
                se.e0 e0Var = (se.e0) cVar.f4078j.get(str4);
                BluetoothDevice bluetoothDevice2 = e0Var != null ? e0Var.f9721a : bluetoothDevice;
                NearDevice nearDevice = e0Var != null ? e0Var.f9723c : null;
                if (bluetoothDevice2 == null) {
                    Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                    Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: connectGatt or device is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothClient", "TransConnect:sendWifiDirectGroupOwnerAvailable: connectGatt or device is null", null);
                    }
                    cVar.p.clear();
                    cVar.f4086t = null;
                    return;
                }
                pe.d dVar = cVar.f;
                if (dVar != null && dVar.q()) {
                    byte[] bArrL = cVar.l(str, str2, str3, i8, nearDevice, bluetoothDevice2);
                    if (bArrL.length != 0) {
                        li.l0.p(li.h0.a(v0.f7499b), null, null, new se.k0(cVar, bluetoothDevice2, bArrL, null), 3);
                        Iterator it2 = cVar.f4077i.iterator();
                        while (it2.hasNext()) {
                            ((se.w) it2.next()).f(bluetoothDevice2, wifiP2pDevice, nearDevice, null);
                        }
                        u();
                        h4 h4Var = cVar.f4073c;
                        if (h4Var != null) {
                            h4.F(h4Var, bluetoothDevice2, wifiP2pDevice, nearDevice, 0L, 24);
                            Unit unit = Unit.INSTANCE;
                        }
                        return;
                    }
                    Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                    Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothClient", "TransConnect:sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", null);
                    }
                    u();
                    h4 h4Var2 = cVar.f4073c;
                    if (h4Var2 != null) {
                        h4Var2.D(bluetoothDevice2, wifiP2pDevice, nearDevice);
                    }
                    return;
                }
                Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: mBluetoothConnection is null or not connected", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothClient", "TransConnect:sendWifiDirectGroupOwnerAvailable: mBluetoothConnection is null or not connected", null);
                }
                h4 h4Var3 = cVar.f4073c;
                if (h4Var3 != null) {
                    h4Var3.D(bluetoothDevice2, wifiP2pDevice, nearDevice);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static void u() {
        if (we.m.e(776)) {
            we.m.c(776);
            we.h.b("NearBluetoothClient", "GATT waiting go created notify timer cancelled");
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:106:0x0311  */
    /* JADX WARN: Code duplicated, block: B:110:0x035f A[LOOP:4: B:108:0x0359->B:110:0x035f, LOOP_END] */
    @Override // we.g
    public final void b(Message msg) throws JSONException {
        String str;
        Pair pair;
        Iterator it;
        NearDevice nearDevice;
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = msg.what;
        LinkedHashSet<se.w> linkedHashSet = this.f4077i;
        Object obj = null;
        switch (i8) {
            case 6401:
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) obj2;
                int i9 = msg.arg1;
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
                we.h.b("NearBluetoothClient", "onConnectionStateChanged: device=" + bluetoothDevice + ", state=" + str);
                LinkedHashSet linkedHashSet2 = this.f4075g;
                Map map = this.f4078j;
                switch (i9) {
                    case 101:
                        we.h.b("NearBluetoothClient", "onConnectionStateChanged: connecting");
                        break;
                    case 102:
                        LinkedHashSet linkedHashSet3 = this.f4076h;
                        for (Object obj3 : linkedHashSet3) {
                            if (Intrinsics.areEqual(((Pair) obj3).getFirst(), bluetoothDevice)) {
                                obj = obj3;
                                pair = (Pair) obj;
                                if (pair != null) {
                                    linkedHashSet3.remove(pair);
                                    linkedHashSet2.add(pair);
                                    if (((se.e0) map.get(bluetoothDevice.getAddress())) == null) {
                                        Map map2 = h.f4132a;
                                        map.put(bluetoothDevice.getAddress(), new se.e0(bluetoothDevice, this.f, h.a(bluetoothDevice)));
                                    }
                                    we.h.b("NearBluetoothClient", "onConnectionStateChanged: connected, device=" + pair.getFirst() + ", nearDevice=" + pair.getSecond());
                                    NearDevice nearDevice2 = (NearDevice) pair.getSecond();
                                    nearDevice2.A(PointerIconCompat.TYPE_HELP);
                                    nearDevice2.f3899w = PointerIconCompat.TYPE_TEXT;
                                    it = linkedHashSet.iterator();
                                    while (it.hasNext()) {
                                        ((se.w) it.next()).a((BluetoothDevice) pair.getFirst(), (NearDevice) pair.getSecond());
                                    }
                                    BluetoothDevice bluetoothDevice2 = (BluetoothDevice) pair.getFirst();
                                    se.a.f9637a = PointerIconCompat.TYPE_GRAB;
                                    i(e(6403, 0, 0, bluetoothDevice2));
                                }
                                break;
                            }
                        }
                        pair = (Pair) obj;
                        if (pair != null) {
                            linkedHashSet3.remove(pair);
                            linkedHashSet2.add(pair);
                            if (((se.e0) map.get(bluetoothDevice.getAddress())) == null) {
                                Map map3 = h.f4132a;
                                map.put(bluetoothDevice.getAddress(), new se.e0(bluetoothDevice, this.f, h.a(bluetoothDevice)));
                            }
                            we.h.b("NearBluetoothClient", "onConnectionStateChanged: connected, device=" + pair.getFirst() + ", nearDevice=" + pair.getSecond());
                            NearDevice nearDevice3 = (NearDevice) pair.getSecond();
                            nearDevice3.A(PointerIconCompat.TYPE_HELP);
                            nearDevice3.f3899w = PointerIconCompat.TYPE_TEXT;
                            it = linkedHashSet.iterator();
                            while (it.hasNext()) {
                                ((se.w) it.next()).a((BluetoothDevice) pair.getFirst(), (NearDevice) pair.getSecond());
                            }
                            BluetoothDevice bluetoothDevice3 = (BluetoothDevice) pair.getFirst();
                            se.a.f9637a = PointerIconCompat.TYPE_GRAB;
                            i(e(6403, 0, 0, bluetoothDevice3));
                        }
                        break;
                    case DeviceType.INFRARED_TV_BOX /* 103 */:
                        se.e0 e0Var = (se.e0) map.get(bluetoothDevice.getAddress());
                        if (e0Var != null && (nearDevice = e0Var.f9723c) != null) {
                            nearDevice.f3899w = PointerIconCompat.TYPE_ALIAS;
                        }
                        map.remove(bluetoothDevice.getAddress());
                        CollectionsKt__MutableCollectionsKt.removeAll(linkedHashSet2, new se.b0(bluetoothDevice, 0));
                        for (se.w wVar : linkedHashSet) {
                            int i10 = this.f4080l;
                            if (12288 != i10) {
                                wVar.b(i10, bluetoothDevice, e0Var != null ? e0Var.f9723c : null);
                            } else {
                                wVar.b(12288, bluetoothDevice, e0Var != null ? e0Var.f9723c : null);
                            }
                        }
                        this.f4080l = 12288;
                        break;
                }
                break;
            case 6402:
                Object obj4 = msg.obj;
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice4 = (BluetoothDevice) obj4;
                boolean z2 = msg.arg1 == 1;
                we.h.b("NearBluetoothClient", "onConnectionCommandConnect: device=" + bluetoothDevice4 + ", isSecure=" + z2);
                pe.d dVar = this.f;
                if (dVar != null) {
                    dVar.l(bluetoothDevice4, z2);
                }
                break;
            case 6403:
                Object obj5 = msg.obj;
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice5 = (BluetoothDevice) obj5;
                we.h.b("NearBluetoothClient", "onConnectionSendConnectRequest: device=" + bluetoothDevice5);
                v(bluetoothDevice5, null);
                break;
            case 6404:
                we.h.h("NearBluetoothClient", "onConnectionMessageSent, " + msg.arg1 + " bytes sent");
                CountDownLatch countDownLatch = this.f4079k;
                if (countDownLatch != null) {
                    countDownLatch.countDown();
                }
                break;
            case 6405:
                Bundle data = msg.getData();
                byte[] byteArray = data.getByteArray("receiveData");
                Intrinsics.checkNotNull(data);
                BluetoothDevice bluetoothDevice6 = (BluetoothDevice) ((Parcelable) data.getParcelable("device", BluetoothDevice.class));
                int i11 = msg.arg1;
                we.h.h("NearBluetoothClient", "onConnectionMessageReceived, " + i11 + " bytes received");
                if (bluetoothDevice6 == null || byteArray == null || i11 <= 0) {
                    we.h.c("NearBluetoothClient", "onConnectionMessageReceived, device or data is null, ignore it", null);
                } else {
                    int i12 = se.a.f9637a;
                    String address = bluetoothDevice6.getAddress();
                    Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
                    if (!se.a.a(address, byteArray)) {
                        we.h.h("NearBluetoothClient", "Received data is not completed, " + se.a.b(byteArray) + ", wait for next packet");
                    } else {
                        String address2 = bluetoothDevice6.getAddress();
                        Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
                        byte[] bArrC = se.a.c(address2);
                        if (bArrC != null) {
                            try {
                                JSONObject jSONObject = new JSONObject(new String(bArrC, Charsets.UTF_8));
                                String strOptString = jSONObject.optString("Version");
                                if (Intrinsics.areEqual(strOptString, "1.0")) {
                                    h0.a.C(jSONObject.length(), "parsePacketWithJson: 1.0, length: ", "NearBluetoothClient");
                                    s(jSONObject, "1.0", bluetoothDevice6);
                                } else if (Intrinsics.areEqual(strOptString, "2.0")) {
                                    h0.a.C(jSONObject.length(), "parsePacketWithJson: 2.0, length: ", "NearBluetoothClient");
                                    s(jSONObject, "2.0", bluetoothDevice6);
                                } else {
                                    String strN = o.d.n("Unsupported version: ", jSONObject.optString("Version"), "NearBluetoothClient", "tag", "mes");
                                    if (lb.f6529c >= 1) {
                                        h0.a.x("TransConnect:", strN, "NearBluetoothClient", null);
                                    }
                                    m(bluetoothDevice6);
                                }
                            } catch (Exception e) {
                                String mes = "parseIncomingRequest: " + e;
                                Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                                Intrinsics.checkNotNullParameter(mes, "mes");
                                if (lb.f6529c >= 1) {
                                    h0.a.x("TransConnect:", mes, "NearBluetoothClient", null);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                break;
            case 6406:
                Object obj6 = msg.obj;
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice7 = (BluetoothDevice) obj6;
                h4 h4Var = this.f4073c;
                if (h4Var != null && !h4Var.k()) {
                    we.h.b("NearBluetoothClient", "Not found P2P_OWNER_CONNECT_TIMER, use general disconnect function");
                    u();
                    n(bluetoothDevice7, null);
                    break;
                }
                break;
            case 6407:
                Object obj7 = msg.obj;
                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice8 = (BluetoothDevice) obj7;
                Bundle data2 = msg.getData();
                String string = data2.getString("deviceId");
                boolean z3 = data2.getBoolean("trust");
                we.h.b("NearBluetoothClient", "onDeviceTrustNotification: device=" + bluetoothDevice8 + ", deviceId=" + string + ", isTrusted=" + z3);
                NearDevice nearDeviceO = o(bluetoothDevice8.getAddress());
                if (nearDeviceO != null && Intrinsics.areEqual(nearDeviceO.f3885c, string) && z3) {
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        ((se.w) it2.next()).h(nearDeviceO, true);
                    }
                    break;
                }
                break;
            case 6408:
                Object obj8 = msg.obj;
                Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice9 = (BluetoothDevice) obj8;
                String string2 = msg.getData().getString("deviceId");
                we.h.b("NearBluetoothClient", "onDeviceRejectNotification: device=" + bluetoothDevice9 + ", deviceId=" + string2);
                NearDevice nearDeviceO2 = o(bluetoothDevice9.getAddress());
                if (nearDeviceO2 != null && Intrinsics.areEqual(nearDeviceO2.f3885c, string2)) {
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        ((se.w) it3.next()).g(nearDeviceO2);
                    }
                    break;
                }
                break;
            default:
                String strM = o.d.m("unknown message: what=", "NearBluetoothClient", "tag", "mes", i8);
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strM, "NearBluetoothClient", null);
                }
                break;
        }
    }

    public final byte[] l(String str, String str2, String str3, int i8, NearDevice nearDevice, BluetoothDevice bluetoothDevice) {
        String str4;
        se.e0 e0Var = (se.e0) this.f4078j.get(bluetoothDevice.getAddress());
        if ((e0Var != null ? e0Var.f9724d : null) != null) {
            str4 = e0Var.f9724d;
        } else {
            we.h.b("NearBluetoothClient", "getRemoteDeviceSupportedVersion, use default version");
            str4 = this.f4074d != null ? "1.0" : null;
        }
        if (Intrinsics.areEqual(str4, "1.0")) {
            String string = q(str4, nearDevice, str2, str3, i8, str).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        if (Intrinsics.areEqual(str4, "2.0")) {
            String string2 = q(str4, nearDevice, str2, str3, i8, str).toString();
            Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
            byte[] bytes2 = string2.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
            return bytes2;
        }
        Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
        Intrinsics.checkNotNullParameter("buildWifiDirectGroupOwnerAvailable: remote version is not support", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearBluetoothClient", "TransConnect:buildWifiDirectGroupOwnerAvailable: remote version is not support", null);
        }
        return new byte[0];
    }

    public final void m(BluetoothDevice bluetoothDevice) {
        pe.d dVar = this.f;
        if (dVar != null) {
            dVar.n(bluetoothDevice);
        }
    }

    public final void n(BluetoothDevice device, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        pe.d dVar = this.f;
        if (dVar == null || !dVar.q()) {
            Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
            Intrinsics.checkNotNullParameter("disconnect failed, mBluetoothConnection is null or not connected", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothClient", "TransConnect:disconnect failed, mBluetoothConnection is null or not connected", null);
                return;
            }
            return;
        }
        if (((se.e0) this.f4078j.get(device.getAddress())) != null) {
            pe.d dVar2 = this.f;
            if (dVar2 != null) {
                dVar2.n(device);
            }
            we.h.b("NearBluetoothClient", "disconnect " + device.getName() + ", " + (nearDevice != null ? nearDevice.f3884b : null));
        }
        we.h.b("NearBluetoothClient", "Disconnect P2p device");
        if (this.f4083o.isEmpty() && this.q.isEmpty() && this.p.isEmpty() && this.f4084r.isEmpty()) {
            we.h.b("NearBluetoothClient", "P2p over Gatt server is not running");
            we.h.b("NearBluetoothClient", "No p2p business running ignore");
            return;
        }
        we.h.b("NearBluetoothClient", "P2p over Gatt server is running");
        h4 h4Var = this.f4073c;
        if (h4Var == null || h4Var.l()) {
            return;
        }
        h4Var.o();
    }

    /* JADX WARN: Code duplicated, block: B:31:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:? A[RETURN, SYNTHETIC] */
    public final NearDevice o(String str) {
        se.e0 e0Var;
        Object next;
        Map map = this.f4078j;
        if (str != null) {
            se.e0 e0Var2 = (se.e0) map.get(str);
            NearDevice nearDevice = e0Var2 != null ? e0Var2.f9723c : null;
            if (nearDevice != null) {
                return nearDevice;
            }
            LinkedHashSet linkedHashSet = this.f4075g;
            if (linkedHashSet.size() > 0) {
                Iterator it = linkedHashSet.iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.areEqual(((BluetoothDevice) ((Pair) next).getFirst()).getAddress(), str));
                Pair pair = (Pair) next;
                if (pair != null) {
                    return (NearDevice) pair.getSecond();
                }
            }
        }
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            e0Var = (se.e0) ((Map.Entry) it2.next()).getValue();
            if (e0Var != null) {
                if (e0Var != null) {
                    return e0Var.f9723c;
                }
                return null;
            }
        }
        e0Var = null;
        if (e0Var != null) {
            return e0Var.f9723c;
        }
        return null;
    }

    public final JSONObject p(int i8, NearDevice nearDevice, String str) throws JSONException {
        Integer numValueOf;
        BluetoothManager bluetoothManager;
        BluetoothAdapter adapter;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", str);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", i8);
        d dVar = this.f4074d;
        jSONObject.put("DeviceId", dVar != null ? dVar.o() : null);
        jSONObject.put("ClientP2pMode", dVar != null ? Integer.valueOf(dVar.f4098j) : null);
        if (dVar != null) {
            numValueOf = Integer.valueOf(dVar.f4098j == 1 ? 2 : 1);
        } else {
            numValueOf = null;
        }
        jSONObject.put("ServerP2pMode", numValueOf);
        jSONObject.put("FileCount", 0);
        jSONObject.put("FileName", "");
        jSONObject.put("TotalFileSize", 0);
        jSONObject.put("Ssid", "");
        jSONObject.put("Pwd", "");
        jSONObject.put("Mac", "");
        jSONObject.put("Chan", -1);
        jSONObject.put("Freq", 0);
        jSONObject.put("GoIpAddr", "");
        jSONObject.put("Port", 0);
        jSONObject.put("MessagePort", 0);
        jSONObject.put("DeviceName", (dVar == null || (bluetoothManager = dVar.f) == null || (adapter = bluetoothManager.getAdapter()) == null) ? null : adapter.getName());
        jSONObject.put("DeviceMac", dVar != null ? dVar.p() : null);
        Map map = h.f4132a;
        jSONObject.put("ProductSubType", Byte.valueOf(h.e(nearDevice.f3889j)));
        jSONObject.put("ProductBrandName", Byte.valueOf(h.g(nearDevice.h())));
        jSONObject.put("ProductNameCode", nearDevice.r());
        int i9 = nearDevice.e;
        jSONObject.put("ServiceType", h.d(i9));
        jSONObject.put("Protocol", 0);
        byte[] bArrQ = dVar != null ? dVar.q(i9) : null;
        if (bArrQ != null) {
            jSONObject.put("ServiceData", Base64.encodeToString(bArrQ, 0));
        } else {
            byte[] bArrN = dVar != null ? dVar.n(i9, nearDevice, str) : null;
            if (bArrN != null) {
                jSONObject.put("ServiceData", Base64.encodeToString(bArrN, 0));
            } else {
                jSONObject.put("ServiceData", "");
                we.h.j("NearBluetoothClient", "buildConnectRequest: serviceData and capability is null");
                Unit unit = Unit.INSTANCE;
            }
        }
        List listR = dVar != null ? dVar.r() : null;
        if (listR != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(listR, " ", null, null, 0, null, null, 62, null));
        }
        return jSONObject;
    }

    public final JSONObject q(String str, NearDevice nearDevice, String str2, String str3, int i8, String str4) throws JSONException {
        Integer numValueOf;
        byte bE;
        int iD;
        BluetoothManager bluetoothManager;
        BluetoothAdapter adapter;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", str);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", 253);
        d dVar = this.f4074d;
        jSONObject.put("DeviceId", dVar != null ? dVar.o() : null);
        jSONObject.put("ClientP2pMode", dVar != null ? Integer.valueOf(dVar.f4098j) : null);
        if (dVar != null) {
            numValueOf = Integer.valueOf(dVar.f4098j == 1 ? 2 : 1);
        } else {
            numValueOf = null;
        }
        jSONObject.put("ServerP2pMode", numValueOf);
        jSONObject.put("FileCount", 0);
        jSONObject.put("FileName", "P2P Connect Notification");
        jSONObject.put("TotalFileSize", 0);
        jSONObject.put("Ssid", str2);
        jSONObject.put("Pwd", str3);
        jSONObject.put("Mac", "02:00:00:00:00:00");
        byte bG = -1;
        jSONObject.put("Chan", -1);
        jSONObject.put("Freq", i8);
        jSONObject.put("GoIpAddr", str4);
        jSONObject.put("Port", 0);
        jSONObject.put("MessagePort", 0);
        jSONObject.put("DeviceName", (dVar == null || (bluetoothManager = dVar.f) == null || (adapter = bluetoothManager.getAdapter()) == null) ? null : adapter.getName());
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
                    we.h.j("NearBluetoothClient", "buildConnectRequest: serviceData and capability is null");
                }
            }
        }
        List listR = dVar != null ? dVar.r() : null;
        if (listR != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(listR, " ", null, null, 0, null, null, 62, null));
        }
        return jSONObject;
    }

    public final void r(BluetoothDevice device, int i8, int i9) {
        Intrinsics.checkNotNullParameter(device, "device");
        i(e(6401, i8, i9, device));
    }

    public final void s(JSONObject jSONObject, final String str, final BluetoothDevice bluetoothDevice) throws JSONException {
        int i8;
        String string;
        long j8;
        String string2;
        String string3;
        String string4;
        int i9;
        int i10;
        int i11;
        int i12;
        String string5;
        String string6;
        int i13;
        int i14;
        String string7;
        int i15;
        int i16;
        int i17;
        String string8;
        String str2;
        int iOptInt = jSONObject.optInt("ReqType");
        int iOptInt2 = jSONObject.optInt("state");
        int iOptInt3 = jSONObject.optInt("ServerP2pMode");
        int i18 = iOptInt & 255;
        int i19 = 65280 & iOptInt;
        if (i19 != 43520 && i19 != 47872) {
            if (i19 != 52224) {
                return;
            }
            we.h.b("NearBluetoothClient", "reserved for future use, indicate token,");
            return;
        }
        switch (iOptInt2) {
            case 0:
                we.h.h("NearBluetoothClient", "Server Device idle response, send connection request");
                if (i18 == 1 || i18 == 8 || i18 == 10 || i18 == 251) {
                    we.h.b("NearBluetoothClient", "Air parcel drop scenario");
                    if (iOptInt3 == 0) {
                        we.h.b("NearBluetoothClient", "Server mode is no P2P");
                        Unit unit = Unit.INSTANCE;
                    } else if (iOptInt3 == 1) {
                        we.h.b("NearBluetoothClient", "Server mode is P2P GC");
                        Unit unit2 = Unit.INSTANCE;
                    } else if (iOptInt3 != 2) {
                        h0.a.C(iOptInt3, "Unsupported server p2p mode: ", "NearBluetoothClient");
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        we.h.b("NearBluetoothClient", "Server mode is P2P GO");
                        Unit unit4 = Unit.INSTANCE;
                    }
                } else {
                    u();
                    m(bluetoothDevice);
                    we.h.b("NearBluetoothClient", "Unsupported request type: " + i18);
                    Unit unit5 = Unit.INSTANCE;
                }
                break;
            case 1:
                we.h.b("NearBluetoothClient", "Device is busy, ignore the request");
                u();
                m(bluetoothDevice);
                break;
            case 2:
                we.h.b("NearBluetoothClient", "Device accept the request, send connection response");
                if (i18 == 1 || i18 == 8 || i18 == 10 || i18 == 251) {
                    we.h.b("NearBluetoothClient", "Air parcel drop scenario");
                    if (iOptInt3 == 0) {
                        we.h.b("NearBluetoothClient", "Server mode is no P2P");
                        Unit unit6 = Unit.INSTANCE;
                    } else if (iOptInt3 == 1) {
                        we.h.b("NearBluetoothClient", "Server mode is P2P GC");
                        u();
                        f(new se.c0(this, bluetoothDevice, 1));
                        Unit unit7 = Unit.INSTANCE;
                    } else if (iOptInt3 != 2) {
                        h0.a.C(iOptInt3, "Unsupported server p2p mode: ", "NearBluetoothClient");
                        Unit unit8 = Unit.INSTANCE;
                    } else {
                        we.h.b("NearBluetoothClient", "Server mode is P2P GO");
                        y(bluetoothDevice);
                        Unit unit9 = Unit.INSTANCE;
                    }
                    if (a.f4027k.c(str)) {
                        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("servicePortList");
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            int length = jSONArrayOptJSONArray.length();
                            for (int i20 = 0; i20 < length; i20++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i20);
                                arrayList.add(new Pair(jSONObject2.optString("serviceName"), Integer.valueOf(jSONObject2.optInt("port"))));
                            }
                            Unit unit10 = Unit.INSTANCE;
                        }
                        this.f4086t = arrayList;
                        boolean zOptBoolean = jSONObject.optBoolean("Trust");
                        final String strOptString = jSONObject.optString("DeviceId");
                        if (zOptBoolean) {
                            we.h.b("NearBluetoothClient", "Device is trusted, send notification to upper layer");
                            Intrinsics.checkNotNull(strOptString);
                            final int i21 = 1;
                            f(new Runnable(this) { // from class: se.d0

                                /* JADX INFO: renamed from: b, reason: collision with root package name */
                                public final /* synthetic */ com.welink.protocol.nfbd.c f9698b;

                                {
                                    this.f9698b = this;
                                }

                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i21) {
                                        case 0:
                                            this.f9698b.v(bluetoothDevice, strOptString);
                                            break;
                                        case 1:
                                            String address = bluetoothDevice.getAddress();
                                            com.welink.protocol.nfbd.c cVar = this.f9698b;
                                            NearDevice nearDeviceO = cVar.o(address);
                                            if (nearDeviceO != null) {
                                                String str3 = nearDeviceO.f3885c;
                                                String str4 = strOptString;
                                                if (Intrinsics.areEqual(str3, str4)) {
                                                    o.d.z("Device trusted by remote device: ", str4, "NearBluetoothClient");
                                                    Iterator it = cVar.f4077i.iterator();
                                                    while (it.hasNext()) {
                                                        ((w) it.next()).h(nearDeviceO, true);
                                                    }
                                                }
                                            }
                                            break;
                                        default:
                                            String address2 = bluetoothDevice.getAddress();
                                            com.welink.protocol.nfbd.c cVar2 = this.f9698b;
                                            NearDevice nearDeviceO2 = cVar2.o(address2);
                                            if (nearDeviceO2 != null) {
                                                String str5 = nearDeviceO2.f3885c;
                                                String str6 = strOptString;
                                                if (Intrinsics.areEqual(str5, str6)) {
                                                    o.d.z("Device reject by remote device: ", str6, "NearBluetoothClient");
                                                    Iterator it2 = cVar2.f4077i.iterator();
                                                    while (it2.hasNext()) {
                                                        ((w) it2.next()).g(nearDeviceO2);
                                                    }
                                                }
                                            }
                                            break;
                                    }
                                }
                            });
                        }
                    }
                } else {
                    u();
                    m(bluetoothDevice);
                    we.h.b("NearBluetoothClient", "Unsupported request type: " + i18);
                    Unit unit11 = Unit.INSTANCE;
                }
                break;
            case 3:
                we.h.h("NearBluetoothClient", "Device reject the request due to user, close the connection");
                u();
                this.f4080l = 12293;
                m(bluetoothDevice);
                final String strOptString2 = jSONObject.optString("DeviceId");
                Intrinsics.checkNotNull(strOptString2);
                final int i22 = 2;
                f(new Runnable(this) { // from class: se.d0

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public final /* synthetic */ com.welink.protocol.nfbd.c f9698b;

                    {
                        this.f9698b = this;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        switch (i22) {
                            case 0:
                                this.f9698b.v(bluetoothDevice, strOptString2);
                                break;
                            case 1:
                                String address = bluetoothDevice.getAddress();
                                com.welink.protocol.nfbd.c cVar = this.f9698b;
                                NearDevice nearDeviceO = cVar.o(address);
                                if (nearDeviceO != null) {
                                    String str3 = nearDeviceO.f3885c;
                                    String str4 = strOptString2;
                                    if (Intrinsics.areEqual(str3, str4)) {
                                        o.d.z("Device trusted by remote device: ", str4, "NearBluetoothClient");
                                        Iterator it = cVar.f4077i.iterator();
                                        while (it.hasNext()) {
                                            ((w) it.next()).h(nearDeviceO, true);
                                        }
                                    }
                                }
                                break;
                            default:
                                String address2 = bluetoothDevice.getAddress();
                                com.welink.protocol.nfbd.c cVar2 = this.f9698b;
                                NearDevice nearDeviceO2 = cVar2.o(address2);
                                if (nearDeviceO2 != null) {
                                    String str5 = nearDeviceO2.f3885c;
                                    String str6 = strOptString2;
                                    if (Intrinsics.areEqual(str5, str6)) {
                                        o.d.z("Device reject by remote device: ", str6, "NearBluetoothClient");
                                        Iterator it2 = cVar2.f4077i.iterator();
                                        while (it2.hasNext()) {
                                            ((w) it2.next()).g(nearDeviceO2);
                                        }
                                    }
                                }
                                break;
                        }
                    }
                });
                break;
            case 4:
                if (i18 != 253) {
                    Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                    Intrinsics.checkNotNullParameter("P2P information notify, invalid token", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothClient", "TransConnect:P2P information notify, invalid token", null);
                    }
                } else {
                    u();
                    we.h.b("NearBluetoothClient", "P2P information notify, remote is GO");
                    int iOptInt4 = jSONObject.optInt("Encrypt");
                    String strOptString3 = jSONObject.optString("DeviceId");
                    try {
                        i8 = jSONObject.getInt("FileCount");
                    } catch (Exception unused) {
                        i8 = 0;
                    }
                    try {
                        string = jSONObject.getString("FileName");
                    } catch (Exception unused2) {
                        string = "";
                    }
                    Intrinsics.checkNotNull(string);
                    List listSplit$default = StringsKt__StringsKt.split$default(string, new String[]{","}, false, 0, 6, (Object) null);
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default));
                    Iterator it = listSplit$default.iterator();
                    while (it.hasNext()) {
                        arrayList2.add(StringsKt__StringsKt.trim((CharSequence) ((String) it.next())).toString());
                    }
                    try {
                        j8 = jSONObject.getLong("TotalFileSize");
                    } catch (Exception unused3) {
                        j8 = 0;
                    }
                    try {
                        string2 = jSONObject.getString("Ssid");
                    } catch (Exception unused4) {
                        string2 = "";
                    }
                    try {
                        string3 = jSONObject.getString("Pwd");
                    } catch (Exception unused5) {
                        string3 = "";
                    }
                    try {
                        string4 = jSONObject.getString("Mac");
                    } catch (Exception unused6) {
                        string4 = "";
                    }
                    try {
                        jSONObject.getString("GoIpAddr");
                        break;
                    } catch (Exception unused7) {
                    }
                    try {
                        i9 = jSONObject.getInt("Chan");
                    } catch (Exception unused8) {
                        i9 = -1;
                    }
                    int i23 = i9;
                    try {
                        i10 = jSONObject.getInt("Freq");
                    } catch (Exception unused9) {
                        i10 = 0;
                    }
                    try {
                        i11 = jSONObject.getInt("Port");
                    } catch (Exception unused10) {
                        i11 = 8100;
                    }
                    try {
                        i12 = jSONObject.getInt("MessagePort");
                    } catch (Exception unused11) {
                        i12 = 8100;
                    }
                    try {
                        string5 = jSONObject.getString("DeviceName");
                    } catch (Exception unused12) {
                        string5 = "";
                    }
                    try {
                        string6 = jSONObject.getString("DeviceMac");
                    } catch (Exception unused13) {
                        string6 = "";
                    }
                    try {
                        i13 = jSONObject.getInt("ProductSubType");
                    } catch (Exception unused14) {
                        i13 = 0;
                    }
                    try {
                        i14 = jSONObject.getInt("ProductBrandName");
                    } catch (Exception unused15) {
                        i14 = 0;
                    }
                    try {
                        string7 = jSONObject.getString("ProductNameCode");
                    } catch (Exception unused16) {
                        string7 = "";
                    }
                    try {
                        i15 = jSONObject.getInt("ServiceType");
                    } catch (Exception unused17) {
                        i15 = 0;
                    }
                    try {
                        i16 = jSONObject.getInt("SubCapability");
                    } catch (Exception unused18) {
                        i16 = 0;
                    }
                    try {
                        i17 = jSONObject.getInt("Protocol");
                    } catch (Exception unused19) {
                        i17 = 0;
                    }
                    try {
                        string8 = jSONObject.getString("ServiceData");
                    } catch (Exception unused20) {
                        string8 = null;
                    }
                    byte[] bArrDecode = string8 != null ? Base64.decode(string8, 0) : null;
                    try {
                        str2 = jSONObject.getString("BandSupport");
                    } catch (Exception unused21) {
                        str2 = new String();
                    }
                    Intrinsics.checkNotNull(str2);
                    ConnectRequest connectRequest = new ConnectRequest(str, iOptInt4, iOptInt, strOptString3, i8, arrayList2, j8, string2, string3, string4, i23, i10, i11, i12, iOptInt3, string5, string6, i13, i14, string7, i15, i16, i17, bArrDecode, StringsKt__StringsKt.split$default(new Regex("\\s+").replace(str2, " "), new String[]{" "}, false, 0, 6, (Object) null), null, null, 503316480);
                    this.f4083o.put(bluetoothDevice.getAddress(), new g2(bluetoothDevice, connectRequest));
                    NearDevice nearDeviceO = o(bluetoothDevice.getAddress());
                    Iterator it2 = this.f4077i.iterator();
                    while (it2.hasNext()) {
                        ((se.w) it2.next()).j(bluetoothDevice, connectRequest, nearDeviceO);
                    }
                }
                break;
            case 5:
                we.h.j("NearBluetoothClient", "Remote device support max version is ".concat(str));
                u();
                String str3 = this.f4074d != null ? "1.0" : null;
                if (str3 != null) {
                    List listSplit$default2 = StringsKt__StringsKt.split$default(str3, new String[]{"."}, false, 0, 6, (Object) null);
                    ArrayList arrayList3 = new ArrayList(CollectionsKt.i(listSplit$default2));
                    Iterator it3 = listSplit$default2.iterator();
                    while (it3.hasNext()) {
                        arrayList3.add(Integer.valueOf(Integer.parseInt((String) it3.next())));
                    }
                    List listSplit$default3 = StringsKt__StringsKt.split$default(str, new String[]{"."}, false, 0, 6, (Object) null);
                    ArrayList arrayList4 = new ArrayList(CollectionsKt.i(listSplit$default3));
                    Iterator it4 = listSplit$default3.iterator();
                    while (it4.hasNext()) {
                        arrayList4.add(Integer.valueOf(Integer.parseInt((String) it4.next())));
                    }
                    if (((Number) arrayList3.get(0)).intValue() > ((Number) arrayList4.get(0)).intValue() || (((Number) arrayList3.get(0)).intValue() == ((Number) arrayList4.get(0)).intValue() && ((Number) arrayList3.get(1)).intValue() >= ((Number) arrayList4.get(1)).intValue())) {
                        we.h.b("NearBluetoothClient", "Remote device support max version, send connection request");
                        final int i24 = 0;
                        Runnable runnable = new Runnable(this) { // from class: se.d0

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            public final /* synthetic */ com.welink.protocol.nfbd.c f9698b;

                            {
                                this.f9698b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i24) {
                                    case 0:
                                        this.f9698b.v(bluetoothDevice, str);
                                        break;
                                    case 1:
                                        String address = bluetoothDevice.getAddress();
                                        com.welink.protocol.nfbd.c cVar = this.f9698b;
                                        NearDevice nearDeviceO2 = cVar.o(address);
                                        if (nearDeviceO2 != null) {
                                            String str4 = nearDeviceO2.f3885c;
                                            String str5 = str;
                                            if (Intrinsics.areEqual(str4, str5)) {
                                                o.d.z("Device trusted by remote device: ", str5, "NearBluetoothClient");
                                                Iterator it5 = cVar.f4077i.iterator();
                                                while (it5.hasNext()) {
                                                    ((w) it5.next()).h(nearDeviceO2, true);
                                                }
                                            }
                                        }
                                        break;
                                    default:
                                        String address2 = bluetoothDevice.getAddress();
                                        com.welink.protocol.nfbd.c cVar2 = this.f9698b;
                                        NearDevice nearDeviceO3 = cVar2.o(address2);
                                        if (nearDeviceO3 != null) {
                                            String str6 = nearDeviceO3.f3885c;
                                            String str7 = str;
                                            if (Intrinsics.areEqual(str6, str7)) {
                                                o.d.z("Device reject by remote device: ", str7, "NearBluetoothClient");
                                                Iterator it6 = cVar2.f4077i.iterator();
                                                while (it6.hasNext()) {
                                                    ((w) it6.next()).g(nearDeviceO3);
                                                }
                                            }
                                        }
                                        break;
                                }
                            }
                        };
                        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                        we.m.a(774, 50L, a(), runnable);
                    }
                }
                we.h.j("NearBluetoothClient", "Unsupported version, close the connection");
                m(bluetoothDevice);
                break;
            case 6:
                we.h.j("NearBluetoothClient", "Remote device is not recognized, close the connection");
                u();
                m(bluetoothDevice);
                break;
            case 7:
                we.h.h("NearBluetoothClient", "Device reject the request due to timeout, close the connection");
                this.f4080l = 12294;
                m(bluetoothDevice);
                break;
            case 8:
                we.h.h("NearBluetoothClient", "Device reject the request due to unavailable, close the connection");
                this.f4080l = 12295;
                m(bluetoothDevice);
                break;
            case 9:
                we.h.h("NearBluetoothClient", "Device reject the request due to unknown, close the connection");
                this.f4080l = 12296;
                m(bluetoothDevice);
                break;
        }
    }

    public final void t() {
        h4 h4Var = this.f4073c;
        if (h4Var != null) {
            h4Var.u(new we.i(this), this.u, 320098819);
        }
        int i8 = this.f4085s + 1;
        this.f4085s = i8;
        h0.a.u(i8, "registerNearP2pManagerListener: count: ", "NearBluetoothClient");
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:53:0x0108  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111  */
    public final void v(BluetoothDevice bluetoothDevice, String str) {
        Object next;
        byte[] bytes;
        Object next2;
        String str2;
        se.e0 e0Var;
        LinkedHashSet linkedHashSet = this.f4075g;
        Iterator it = linkedHashSet.iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!Intrinsics.areEqual(((Pair) next).getFirst(), bluetoothDevice));
        if (next != null) {
            Iterator it2 = linkedHashSet.iterator();
            do {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
            } while (!Intrinsics.areEqual(((Pair) next2).getFirst(), bluetoothDevice));
            Pair pair = (Pair) next2;
            NearDevice nearDevice = pair != null ? (NearDevice) pair.getSecond() : null;
            if (nearDevice != null) {
                Map map = h.f4132a;
                int iD = h.d(nearDevice.e);
                if (str == null) {
                    str2 = this.f4074d != null ? "1.0" : null;
                } else {
                    str2 = str;
                }
                if (str != null && (e0Var = (se.e0) this.f4078j.get(bluetoothDevice.getAddress())) != null) {
                    e0Var.f9724d = str;
                    we.h.h("NearBluetoothClient", "updateRemoteDeviceSupportedVersion: ".concat(str));
                }
                if (Intrinsics.areEqual(str2, "1.0")) {
                    String string = p(iD, nearDevice, str2).toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    bytes = string.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                } else if (Intrinsics.areEqual(str2, "2.0")) {
                    String string2 = p(iD, nearDevice, str2).toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    bytes = string2.getBytes(Charsets.UTF_8);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                } else {
                    Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                    Intrinsics.checkNotNullParameter("buildConnectRequest: matchedVersion is not support", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothClient", "TransConnect:buildConnectRequest: matchedVersion is not support", null);
                    }
                }
                if (bytes == null) {
                    y(bluetoothDevice);
                    li.l0.p(li.h0.a(v0.f7499b), null, null, new se.k0(this, bluetoothDevice, bytes, null), 3);
                    return;
                }
                Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                Intrinsics.checkNotNullParameter("sendCreateConnectionRequest: connectRequest is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothClient", "TransConnect:sendCreateConnectionRequest: connectRequest is null", null);
                }
                m(bluetoothDevice);
            }
            Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
            Intrinsics.checkNotNullParameter("buildConnectRequest: nearDevice is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothClient", "TransConnect:buildConnectRequest: nearDevice is null", null);
            }
        } else {
            Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
            Intrinsics.checkNotNullParameter("buildConnectRequest: mBluetoothGatt[device.address] is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothClient", "TransConnect:buildConnectRequest: mBluetoothGatt[device.address] is null", null);
            }
        }
        bytes = null;
        if (bytes == null) {
            y(bluetoothDevice);
            li.l0.p(li.h0.a(v0.f7499b), null, null, new se.k0(this, bluetoothDevice, bytes, null), 3);
            return;
        }
        Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
        Intrinsics.checkNotNullParameter("sendCreateConnectionRequest: connectRequest is null", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearBluetoothClient", "TransConnect:sendCreateConnectionRequest: connectRequest is null", null);
        }
        m(bluetoothDevice);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0066  */
    /* JADX WARN: Code duplicated, block: B:18:0x006a  */
    /* JADX WARN: Code duplicated, block: B:20:0x008d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0091  */
    /* JADX WARN: Code duplicated, block: B:25:0x0099  */
    /* JADX WARN: Code duplicated, block: B:29:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c4 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:40:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:41:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:43:0x010a  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c5 -> B:33:0x00cc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0108 -> B:44:0x010f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x010a -> B:44:0x010f). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object w(android.bluetooth.BluetoothDevice r17, byte[] r18, kotlin.coroutines.jvm.internal.ContinuationImpl r19) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.c.w(android.bluetooth.BluetoothDevice, byte[], kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void x(WifiP2pDevice wifiP2pDevice, String str, String str2) {
        String str3;
        NearDeviceExtension nearDeviceExtension;
        NearDeviceExtension nearDeviceExtension2;
        synchronized (this) {
            try {
                Iterator it = this.p.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str3 = null;
                        break;
                    }
                    String str4 = (String) ((Map.Entry) it.next()).getKey();
                    if (str4 != null) {
                        str3 = str4;
                        break;
                    }
                }
                se.e0 e0Var = (se.e0) this.f4078j.get(str3);
                BluetoothDevice bluetoothDevice = e0Var != null ? e0Var.f9721a : null;
                NearDevice nearDevice = e0Var != null ? e0Var.f9723c : null;
                if (bluetoothDevice == null || this.f4078j.get(bluetoothDevice.getAddress()) == null) {
                    Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                    Intrinsics.checkNotNullParameter("Bluetooth device or gatt client is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothClient", "TransConnect:Bluetooth device or gatt client is null", null);
                    }
                } else {
                    if (nearDevice != null) {
                        nearDevice.f3900x = PointerIconCompat.TYPE_NO_DROP;
                    }
                    ArrayList arrayList = this.f4086t;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        we.h.b("NearBluetoothClient", "Remote service port list: " + this.f4086t);
                        LanNetworkInfo lanNetworkInfo = (nearDevice == null || (nearDeviceExtension2 = nearDevice.u) == null) ? null : nearDeviceExtension2.f3909h;
                        if (lanNetworkInfo != null) {
                            we.h.h("NearBluetoothClient", "Network info is available: " + lanNetworkInfo);
                            lanNetworkInfo.f4247n = this.f4086t;
                        } else {
                            we.h.j("NearBluetoothClient", "Network info is not available");
                            LanNetworkInfo lanNetworkInfo2 = new LanNetworkInfo(str2, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, this.f4086t);
                            if (nearDevice != null && (nearDeviceExtension = nearDevice.u) != null) {
                                Intrinsics.checkNotNullParameter(lanNetworkInfo2, "lanNetworkInfo");
                                nearDeviceExtension.f3909h = lanNetworkInfo2;
                            }
                        }
                    }
                    Iterator it2 = this.f4077i.iterator();
                    while (it2.hasNext()) {
                        ((se.w) it2.next()).c(bluetoothDevice, wifiP2pDevice, nearDevice, str, str2);
                    }
                    if (this.f4084r.get(e0Var != null ? e0Var.f9721a.getAddress() : null) != null) {
                        se.h0 h0Var = (se.h0) this.f4084r.get(e0Var != null ? e0Var.f9721a.getAddress() : null);
                        if (h0Var != null) {
                            if (Intrinsics.areEqual(h0Var.f9754a, e0Var != null ? e0Var.f9721a : null)) {
                                h0Var.f9755b.add(wifiP2pDevice);
                            }
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(wifiP2pDevice);
                        se.h0 h0Var2 = e0Var != null ? new se.h0(e0Var.f9721a, arrayList2, nearDevice) : null;
                        Object address = e0Var != null ? e0Var.f9721a.getAddress() : null;
                        if (address != null) {
                            LinkedHashMap linkedHashMap = this.f4084r;
                            Intrinsics.checkNotNull(h0Var2, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearBluetoothClient.MiscDeviceInfo");
                            linkedHashMap.put(address, h0Var2);
                        }
                    }
                    TypeIntrinsics.asMutableMap(this.p).remove(str3);
                    m(bluetoothDevice);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void y(BluetoothDevice bluetoothDevice) {
        se.c0 c0Var = new se.c0(this, bluetoothDevice, 0);
        if (we.m.e(776)) {
            we.h.b("NearBluetoothClient", "Bluetooth waiting go created notify timer already started, update timer");
            we.m.h(776, 3000L, a(), c0Var);
        } else {
            we.h.b("NearBluetoothClient", "Bluetooth waiting go created notify timer started");
            we.m.a(776, 3000L, a(), c0Var);
        }
    }
}
