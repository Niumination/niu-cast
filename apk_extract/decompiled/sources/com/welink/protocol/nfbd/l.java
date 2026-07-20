package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.BatteryManager;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.work.WorkRequest;
import com.transsion.iotcardsdk.bean.DeviceType;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import k3.lb;
import kotlin.Pair;
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
import se.c6;
import se.d2;
import se.e2;
import se.f2;
import se.g2;
import se.h2;
import se.h4;
import se.i2;
import se.j2;
import se.k2;
import se.o0;
import se.z1;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends we.g {
    public static final se.g0 A = new se.g0(f2.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BluetoothManager f4151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Context f4152d;
    public BluetoothGattServer e;
    public final a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4153g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedBlockingQueue f4154h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f4155i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final LinkedHashSet f4156j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashSet f4157k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f4158l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f4159m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap f4160n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final LinkedHashMap f4161o;
    public final LinkedHashMap p;
    public final ye.d q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public i2 f4162r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final LinkedHashMap f4163s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h4 f4164t;
    public boolean u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final BatteryManager f4165v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4166w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f4167x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final j2 f4168y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final oe.b f4169z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, BluetoothManager bluetoothManager, a aVar) {
        super(false, "NearBluetoothHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4154h = new LinkedBlockingQueue();
        this.f4155i = new LinkedHashSet();
        this.f4156j = new LinkedHashSet();
        this.f4157k = new LinkedHashSet();
        this.f4158l = new LinkedHashMap();
        this.f4159m = new LinkedHashMap();
        this.f4160n = new LinkedHashMap();
        this.f4161o = new LinkedHashMap();
        this.p = new LinkedHashMap();
        this.f4163s = new LinkedHashMap();
        this.f4168y = new j2(this);
        this.f4152d = context;
        this.f4151c = bluetoothManager;
        this.f = aVar;
        this.q = new ye.d(context);
        Object systemService = context.getSystemService("batterymanager");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.BatteryManager");
        this.f4165v = (BatteryManager) systemService;
        this.f4169z = new oe.b(this, 1);
    }

    public static final void j(l lVar, BluetoothDevice bluetoothDevice, int i8, int i9) {
        lVar.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = i9 == 2 ? PointerIconCompat.TYPE_CONTEXT_MENU : 1000;
        messageObtain.arg1 = i8;
        messageObtain.arg2 = i9;
        messageObtain.obj = bluetoothDevice;
        Intrinsics.checkNotNull(messageObtain);
        lVar.i(messageObtain);
    }

    public static void s() {
        if (we.m.e(517)) {
            we.m.c(517);
            we.h.b("NearGattService", "GATT waiting response timer cancelled");
        }
    }

    public static void z(BluetoothDevice bluetoothDevice, l lVar) {
        lVar.getClass();
        d2 d2Var = new d2(bluetoothDevice, lVar);
        if (we.m.e(518)) {
            we.h.b("NearGattService", "Device handshake timer already running, updating timeout");
            we.m.h(518, 3000L, lVar.a(), d2Var);
        } else {
            we.h.b("NearGattService", "Starting device handshake timer");
            we.m.a(518, 3000L, lVar.a(), d2Var);
        }
    }

    public final void A(BluetoothDevice bluetoothDevice) {
        d2 d2Var = new d2(this, bluetoothDevice);
        if (we.m.e(517)) {
            we.h.b("NearGattService", "GATT waiting response timer already started, update timer");
            we.m.h(517, WorkRequest.MIN_BACKOFF_MILLIS, a(), d2Var);
        } else {
            we.h.b("NearGattService", "GATT waiting response timer started");
            we.m.a(517, WorkRequest.MIN_BACKOFF_MILLIS, a(), d2Var);
        }
    }

    public final void B(BluetoothDevice bluetoothDevice, NearDevice nearDevice) {
        NearDevice nearDeviceN;
        Integer num;
        int i8 = 0;
        we.h.h("NearGattService", "Terminated GATT server");
        if (bluetoothDevice != null) {
            if (nearDevice == null) {
                we.h.j("NearGattService", "NearDevice is null, find again");
                nearDeviceN = n(bluetoothDevice);
            } else {
                nearDeviceN = nearDevice;
            }
            LinkedHashSet linkedHashSet = this.f4157k;
            LinkedHashSet linkedHashSet2 = this.f4155i;
            if (nearDeviceN != null && (num = nearDeviceN.f3898v) != null && num.intValue() == 1004) {
                BluetoothGattServer bluetoothGattServer = this.e;
                if (bluetoothGattServer != null) {
                    bluetoothGattServer.cancelConnection(bluetoothDevice);
                }
                linkedHashSet2.remove(bluetoothDevice);
                this.f4163s.remove(bluetoothDevice.getAddress());
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((se.a0) it.next()).b(8192, bluetoothDevice, nearDeviceN);
                }
            } else {
                if (nearDeviceN != null && nearDeviceN.f3899w == 1008) {
                    we.h.b("NearGattService", "Device is still running connection, run stop timer");
                    e2 e2Var = new e2(this, bluetoothDevice, nearDevice, i8);
                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                    we.m.a(515, 1500L, a(), e2Var);
                    return;
                }
                we.h.b("NearGattService", "No connected device or server is not running, stop server");
                if (linkedHashSet2.contains(bluetoothDevice)) {
                    linkedHashSet2.remove(bluetoothDevice);
                    we.h.j("NearGattService", "Probably it is external device removed from connected devices");
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        ((se.a0) it2.next()).b(8194, bluetoothDevice, null);
                    }
                }
            }
        }
        BluetoothGattServer bluetoothGattServer2 = this.e;
        if (bluetoothGattServer2 != null) {
            bluetoothGattServer2.clearServices();
        }
        BluetoothGattServer bluetoothGattServer3 = this.e;
        if (bluetoothGattServer3 != null) {
            bluetoothGattServer3.close();
        }
        this.f4153g = false;
        this.f4167x = null;
    }

    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = msg.what;
        LinkedHashSet linkedHashSet = this.f4155i;
        LinkedHashSet<se.a0> linkedHashSet2 = this.f4157k;
        switch (i8) {
            case 1000:
                Object obj = msg.obj;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
                linkedHashSet.remove(bluetoothDevice);
                NearDevice nearDevice = (NearDevice) this.f4163s.remove(bluetoothDevice.getAddress());
                if (we.m.e(515)) {
                    we.m.c(515);
                    B(null, null);
                }
                Iterator it = linkedHashSet2.iterator();
                while (it.hasNext()) {
                    ((se.a0) it.next()).b(8192, bluetoothDevice, nearDevice);
                }
                break;
            case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) obj2;
                linkedHashSet.add(bluetoothDevice2);
                Iterator it2 = linkedHashSet2.iterator();
                while (it2.hasNext()) {
                    ((se.a0) it2.next()).a(bluetoothDevice2);
                }
                break;
            case PointerIconCompat.TYPE_HAND /* 1002 */:
                byte[] byteArray = msg.getData().getByteArray("value");
                Bundle data = msg.getData();
                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) ((Parcelable) data.getParcelable("device", BluetoothDevice.class));
                if (bluetoothDevice3 == null) {
                    Object obj3 = msg.obj;
                    Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                    bluetoothDevice3 = (BluetoothDevice) obj3;
                }
                String address = bluetoothDevice3.getAddress();
                String string = Arrays.toString(byteArray);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                we.h.b("NearGattService", "received data from client " + address + ": " + string);
                if (byteArray != null) {
                    o(bluetoothDevice3, byteArray);
                } else {
                    we.h.c("NearGattService", "value is null, ignore it", null);
                }
                break;
            case PointerIconCompat.TYPE_HELP /* 1003 */:
                Object obj4 = msg.obj;
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                final BluetoothDevice device = (BluetoothDevice) obj4;
                final int i9 = msg.arg1;
                final int i10 = msg.arg2;
                Bundle data2 = msg.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "getData(...)");
                for (se.a0 a0Var : linkedHashSet2) {
                    switch (a0Var.f9639a) {
                        case 0:
                            Intrinsics.checkNotNullParameter(device, "device");
                            we.h.h("NearBleManager", "onConnectReadRequest: " + device + ", " + i9 + ", " + i10);
                            for (final Pair pair : ((a) a0Var.f9640b).f4031h) {
                                final int i11 = 0;
                                ((Executor) pair.getFirst()).execute(new Runnable() { // from class: se.y
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i11) {
                                            case 0:
                                                ((e1) pair.getSecond()).a(device, i9, i10);
                                                break;
                                            default:
                                                ((e1) pair.getSecond()).a(device, i9, i10);
                                                break;
                                        }
                                    }
                                });
                            }
                            break;
                        default:
                            Intrinsics.checkNotNullParameter(device, "device");
                            we.h.h("NearBluetoothManager", "onConnectReadRequest: " + device + ", " + i9 + ", " + i10);
                            for (final Pair pair2 : ((d) a0Var.f9640b).f4096h) {
                                final int i12 = 1;
                                ((Executor) pair2.getFirst()).execute(new Runnable() { // from class: se.y
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i12) {
                                            case 0:
                                                ((e1) pair2.getSecond()).a(device, i9, i10);
                                                break;
                                            default:
                                                ((e1) pair2.getSecond()).a(device, i9, i10);
                                                break;
                                        }
                                    }
                                });
                            }
                            break;
                    }
                }
                break;
        }
        we.h.b("NearGattService", "handleMessage: msg: " + msg);
    }

    public final boolean k(BluetoothGattService bluetoothGattService) {
        while (true) {
            try {
                BluetoothGattServer bluetoothGattServer = this.e;
                if (bluetoothGattServer != null && bluetoothGattServer.addService(bluetoothGattService)) {
                    break;
                }
            } catch (Exception unused) {
                Intrinsics.checkNotNullParameter("NearGattService", "tag");
                Intrinsics.checkNotNullParameter("Adding Service failed", "mes");
                if (lb.f6529c < 1) {
                    return false;
                }
                Log.e("NearGattService", "TransConnect:Adding Service failed", null);
                return false;
            }
        }
        we.h.b("NearGattService", "Service: " + (bluetoothGattService != null ? bluetoothGattService.getUuid() : null) + " added.");
        return true;
    }

    public final byte[] l(int i8, NearDevice nearDevice, String str, String str2, String str3) {
        Object obj = this.f != null ? "1.0" : null;
        if (Intrinsics.areEqual(obj, "1.0")) {
            String string = p("1.0", nearDevice, str2, str3, i8, str).toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        }
        if (!Intrinsics.areEqual(obj, "2.0")) {
            return new byte[0];
        }
        String string2 = p("2.0", nearDevice, str2, str3, i8, str).toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        byte[] bytes2 = string2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes2, "getBytes(...)");
        return bytes2;
    }

    public final void m(BluetoothDevice device) {
        h4 h4Var;
        List<BluetoothDevice> connectedDevices;
        BluetoothGattServer bluetoothGattServer;
        Intrinsics.checkNotNullParameter(device, "device");
        LinkedHashSet linkedHashSet = this.f4155i;
        if (!linkedHashSet.contains(device)) {
            String strN = o.d.n("No connected device found for address: ", device.getAddress(), "NearGattService", "tag", "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", strN, "NearGattService", null);
            }
            BluetoothManager bluetoothManager = this.f4151c;
            if (bluetoothManager != null && (connectedDevices = bluetoothManager.getConnectedDevices(7)) != null) {
                for (BluetoothDevice bluetoothDevice : connectedDevices) {
                    if (Intrinsics.areEqual(bluetoothDevice.getAddress(), device.getAddress()) && (bluetoothGattServer = this.e) != null) {
                        bluetoothGattServer.cancelConnection(bluetoothDevice);
                    }
                }
            }
        } else if (linkedHashSet.contains(device)) {
            BluetoothGattServer bluetoothGattServer2 = this.e;
            if (bluetoothGattServer2 != null) {
                bluetoothGattServer2.cancelConnection(device);
            }
            linkedHashSet.remove(device);
        }
        we.h.h("NearGattService", "Disconnect P2p device");
        if (this.f4158l.isEmpty() && this.f4159m.isEmpty() && this.f4161o.isEmpty() && this.p.isEmpty() && this.f4160n.isEmpty()) {
            we.h.b("NearGattService", "P2p over Gatt server is not running");
            we.h.b("NearGattService", "No p2p business running ignore");
            return;
        }
        we.h.b("NearGattService", "P2p over Gatt server is running");
        h4 h4Var2 = this.f4164t;
        if (h4Var2 == null || h4Var2.l() || (h4Var = this.f4164t) == null) {
            return;
        }
        h4Var.o();
    }

    public final NearDevice n(BluetoothDevice bluetoothDevice) {
        NearDevice nearDevice;
        z1 z1Var;
        h2 h2Var;
        LinkedHashMap linkedHashMap = this.f4163s;
        NearDevice nearDevice2 = null;
        if (bluetoothDevice == null) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    nearDevice = null;
                    break;
                }
                NearDevice nearDevice3 = (NearDevice) ((Map.Entry) it.next()).getValue();
                if (nearDevice3 != null) {
                    nearDevice = nearDevice3;
                    break;
                }
            }
        } else {
            nearDevice = (NearDevice) linkedHashMap.get(bluetoothDevice.getAddress());
        }
        if (nearDevice != null) {
            return nearDevice;
        }
        i2 i2Var = this.f4162r;
        if ((i2Var != null ? i2Var.f9797g : null) == null) {
            LinkedHashMap linkedHashMap2 = this.f4159m;
            if (linkedHashMap2.isEmpty()) {
                LinkedHashMap linkedHashMap3 = this.f4160n;
                if (linkedHashMap3.isEmpty()) {
                    Intrinsics.checkNotNullParameter("NearGattService", "tag");
                    Intrinsics.checkNotNullParameter("No near device found", "mes");
                    if (lb.f6529c < 1) {
                        return nearDevice;
                    }
                    Log.e("NearGattService", "TransConnect:No near device found", null);
                    return nearDevice;
                }
                Iterator it2 = linkedHashMap3.entrySet().iterator();
                do {
                    if (!it2.hasNext()) {
                        z1Var = null;
                        break;
                    }
                    z1Var = (z1) ((Map.Entry) it2.next()).getValue();
                } while (z1Var == null);
                if (z1Var != null) {
                    nearDevice2 = z1Var.f10079c;
                }
            } else {
                Iterator it3 = linkedHashMap2.entrySet().iterator();
                do {
                    if (!it3.hasNext()) {
                        h2Var = null;
                        break;
                    }
                    h2Var = (h2) ((Map.Entry) it3.next()).getValue();
                } while (h2Var == null);
                if (h2Var != null) {
                    nearDevice2 = h2Var.f9761c;
                }
            }
        } else if (i2Var != null) {
            nearDevice2 = i2Var.f9797g;
        }
        return nearDevice2;
    }

    public final void o(BluetoothDevice bluetoothDevice, byte[] bArr) {
        int i8 = se.a.f9637a;
        String address = bluetoothDevice.getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        if (!se.a.a(address, bArr)) {
            o.d.z("Receiving partial data: ", se.a.b(bArr), "NearGattService");
            return;
        }
        String address2 = bluetoothDevice.getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
        byte[] bArrC = se.a.c(address2);
        if (bArrC == null || bArrC.length == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrC, Charsets.UTF_8));
            String string = jSONObject.getString("Version");
            int i9 = jSONObject.getInt("Encrypt");
            a aVar = this.f;
            CharSequence charSequence = aVar != null ? "1.0" : null;
            if (charSequence != null) {
                Intrinsics.checkNotNull(string);
                List listSplit$default = StringsKt__StringsKt.split$default(charSequence, new String[]{"."}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(CollectionsKt.i(listSplit$default));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(Integer.valueOf(Integer.parseInt((String) it.next())));
                }
                List listSplit$default2 = StringsKt__StringsKt.split$default(string, new String[]{"."}, false, 0, 6, (Object) null);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.i(listSplit$default2));
                Iterator it2 = listSplit$default2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(Integer.valueOf(Integer.parseInt((String) it2.next())));
                }
                if (((Number) arrayList.get(0)).intValue() > ((Number) arrayList2.get(0)).intValue() || (((Number) arrayList.get(0)).intValue() == ((Number) arrayList2.get(0)).intValue() && ((Number) arrayList.get(1)).intValue() >= ((Number) arrayList2.get(1)).intValue())) {
                    if (Intrinsics.areEqual(string, "1.0") && i9 == 0) {
                        o.d.z("Received connect request: version: ", string, "NearGattService");
                        q(jSONObject, string, i9, bluetoothDevice);
                        return;
                    }
                    if (Intrinsics.areEqual(string, "2.0") && i9 == 0) {
                        o.d.z("Received connect request: version: ", string, "NearGattService");
                        q(jSONObject, string, i9, bluetoothDevice);
                        return;
                    }
                    Intrinsics.checkNotNullParameter("NearGattService", "tag");
                    Intrinsics.checkNotNullParameter("Unsupported version or encrypt", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattService", "TransConnect:Unsupported version or encrypt", null);
                    }
                    CollectionsKt.emptyList();
                    o0 o0Var = new o0(this, bluetoothDevice, aVar != null ? "1.0" : null, i9, 6, 1);
                    ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                    we.m.a(516, 10L, a(), o0Var);
                    return;
                }
            }
            Intrinsics.checkNotNullParameter("NearGattService", "tag");
            Intrinsics.checkNotNullParameter("Unsupported version or encrypt", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearGattService", "TransConnect:Unsupported version or encrypt", null);
            }
            CollectionsKt.emptyList();
            o0 o0Var2 = new o0(this, bluetoothDevice, aVar != null ? "1.0" : null, i9, 5, 1);
            ConcurrentHashMap concurrentHashMap2 = we.m.f10734a;
            we.m.a(516, 10L, a(), o0Var2);
        } catch (Exception e) {
            String mes = "parseIncomingRequest: " + e;
            Intrinsics.checkNotNullParameter("NearGattService", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes, "NearGattService", null);
            }
        }
    }

    public final JSONObject p(String str, NearDevice nearDevice, String str2, String str3, int i8, String str4) throws JSONException {
        Byte bValueOf;
        Byte bValueOf2;
        int iD;
        BluetoothAdapter adapter;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", str);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", 48125);
        a aVar = this.f;
        jSONObject.put("DeviceId", aVar != null ? aVar.n() : null);
        BluetoothManager bluetoothManager = this.f4151c;
        jSONObject.put("DeviceName", (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) ? null : adapter.getName());
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
        jSONObject.put("DeviceMac", aVar != null ? aVar.o() : null);
        if (aVar != null) {
            byte[] bArr = aVar.f4033j;
            bValueOf = Byte.valueOf(bArr != null ? bArr[1] : (byte) 13);
        } else {
            bValueOf = null;
        }
        jSONObject.put("ProductSubType", bValueOf);
        if (aVar != null) {
            byte[] bArr2 = aVar.f4033j;
            bValueOf2 = Byte.valueOf(bArr2 != null ? bArr2[3] : (byte) -1);
        } else {
            bValueOf2 = null;
        }
        jSONObject.put("ProductBrandName", bValueOf2);
        jSONObject.put("ProductNameCode", aVar != null ? aVar.p() : null);
        if (nearDevice != null) {
            Map map = h.f4132a;
            iD = h.d(nearDevice.e);
        } else {
            iD = 0;
        }
        jSONObject.put("ServiceType", iD);
        jSONObject.put("SubCapability", nearDevice != null ? Integer.valueOf(nearDevice.f3887h) : null);
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
            byte[] bArrQ = aVar != null ? aVar.q(i9) : null;
            if (bArrQ != null) {
                jSONObject.put("ServiceData", Base64.encodeToString(bArrQ, 0));
            } else {
                byte[] bArrM = aVar != null ? aVar.m(i9, nearDevice, str) : null;
                if (bArrM != null) {
                    jSONObject.put("ServiceData", Base64.encodeToString(bArrM, 0));
                } else {
                    jSONObject.put("ServiceData", "");
                    we.h.j("NearGattService", "buildConnectRequest: serviceData and capability is null");
                }
            }
        }
        List listR = aVar != null ? aVar.r() : null;
        if (listR != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(listR, " ", null, null, 0, null, null, 62, null));
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:110:0x0215  */
    /* JADX WARN: Code duplicated, block: B:95:0x01c8  */
    public final void q(JSONObject jSONObject, String str, int i8, BluetoothDevice bluetoothDevice) throws JSONException {
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
        String str3;
        int i20;
        int i21;
        int i22;
        String str4;
        int i23;
        int i24;
        NearDevice nearDevice;
        WifiP2pDevice p2pOwnerDevice;
        String string9;
        Map.Entry entry;
        Map.Entry entry2;
        String string10 = "";
        int i25 = jSONObject.getInt("ReqType");
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
        int i26 = i10;
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
        int i27 = i14;
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
            string10 = jSONObject.getString("ProductNameCode");
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
            int iM254constructorimpl = UInt.m254constructorimpl((int) (jOptLong & 4294967295L));
            int iM254constructorimpl2 = UInt.m254constructorimpl((int) ((jOptLong >> 32) & 4294967295L));
            try {
                i23 = jSONObject.getInt("iPhoneRequestResult");
            } catch (Exception unused24) {
                i23 = 0;
            }
            LinkedHashMap linkedHashMap = this.f4161o;
            if (linkedHashMap.isEmpty()) {
                i24 = iM254constructorimpl;
            } else {
                Iterator it2 = linkedHashMap.entrySet().iterator();
                do {
                    if (!it2.hasNext()) {
                        entry2 = null;
                        break;
                    }
                    entry2 = (Map.Entry) it2.next();
                } while (entry2 == null);
                if (entry2 != null) {
                    Map map = (Map) entry2.getValue();
                    i24 = iM254constructorimpl;
                    nearDevice = Intrinsics.areEqual((BluetoothDevice) CollectionsKt.first(map.keySet()), bluetoothDevice) ? (NearDevice) CollectionsKt.first(map.values()) : null;
                } else {
                    i24 = iM254constructorimpl;
                }
            }
            LinkedHashMap linkedHashMap2 = this.p;
            if (linkedHashMap2.isEmpty()) {
                i22 = iM254constructorimpl2;
            } else {
                Iterator it3 = linkedHashMap2.entrySet().iterator();
                do {
                    if (!it3.hasNext()) {
                        entry = null;
                        break;
                    }
                    entry = (Map.Entry) it3.next();
                } while (entry == null);
                if (entry != null) {
                    Map map2 = (Map) entry.getValue();
                    i22 = iM254constructorimpl2;
                    p2pOwnerDevice = Intrinsics.areEqual((BluetoothDevice) CollectionsKt.first(map2.keySet()), bluetoothDevice) ? (WifiP2pDevice) CollectionsKt.first(map2.values()) : null;
                } else {
                    i22 = iM254constructorimpl2;
                }
            }
            str3 = "NearGattService";
            h0.a.C(i23, "Apple iPhoneRequestResult: ", str3);
            if (i23 != 4) {
                if (i23 == 5 && p2pOwnerDevice != null && nearDevice != null) {
                    nearDevice.E = i23;
                    Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
                    if (we.m.e(InputDeviceCompat.SOURCE_DPAD)) {
                        we.m.c(InputDeviceCompat.SOURCE_DPAD);
                    }
                    h4 h4Var = this.f4164t;
                    if (h4Var != null) {
                        h4Var.E(bluetoothDevice, p2pOwnerDevice, nearDevice, 0L, DeviceType.INFRARED_AIR_CONDITION);
                        return;
                    }
                    return;
                }
            } else if (p2pOwnerDevice != null && nearDevice != null) {
                nearDevice.E = i23;
                Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
                if (we.m.e(InputDeviceCompat.SOURCE_DPAD)) {
                    we.m.c(InputDeviceCompat.SOURCE_DPAD);
                }
                h4 h4Var2 = this.f4164t;
                if (h4Var2 != null) {
                    h4Var2.E(bluetoothDevice, p2pOwnerDevice, nearDevice, 0L, DeviceType.INFRARED_PROJECTOR);
                    return;
                }
                return;
            }
            try {
                string9 = jSONObject.getString("FileTypes");
            } catch (Exception unused25) {
                string9 = null;
            }
            o.d.z("FileTypes: ", string9, str3);
            i20 = i23;
            str4 = string9;
            i21 = i24;
        } else {
            str3 = "NearGattService";
            i20 = 0;
            i21 = 0;
            i22 = 0;
            str4 = null;
        }
        ConnectRequest connectRequest = new ConnectRequest(str, i8, i25, string, i9, arrayList, j8, string3, string4, string5, i26, i11, i12, i13, i27, string6, string7, i15, i16, string10, i17, i18, i19, bArrDecode, listSplit$default2, UInt.m248boximpl(i21), UInt.m248boximpl(i22), i20, str4);
        LinkedHashSet linkedHashSet = this.f4157k;
        if (i25 != 1 && i25 != 8 && i25 != 251) {
            if (i25 == 253) {
                we.h.b(str3, "Received connect Invite request: " + connectRequest);
                s();
                this.f4158l.put(bluetoothDevice.getAddress(), new g2(bluetoothDevice, connectRequest));
                NearDevice nearDeviceN = n(bluetoothDevice);
                Iterator it4 = linkedHashSet.iterator();
                while (it4.hasNext()) {
                    ((se.a0) it4.next()).h(bluetoothDevice, connectRequest, nearDeviceN);
                }
                return;
            }
            if (i25 != 4 && i25 != 5) {
                switch (i25) {
                }
                return;
            }
        }
        we.h.b(str3, "Received connect request: " + connectRequest);
        Iterator it5 = linkedHashSet.iterator();
        while (it5.hasNext()) {
            ((se.a0) it5.next()).i(bluetoothDevice, connectRequest);
        }
    }

    public final void r() {
        h4 h4Var = this.f4164t;
        if (h4Var != null) {
            h4Var.u(new we.i(this), this.f4168y, 320098818);
        }
        int i8 = this.f4166w + 1;
        this.f4166w = i8;
        h0.a.u(i8, "registerNearP2pManagerListener: count: ", "NearGattService");
    }

    public final void t(BluetoothDevice device, int i8, int i9, String version, int i10, int i11, String str, String str2, int i12, int i13, BluetoothGattCharacteristic bluetoothGattCharacteristic, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(version, "version");
        if (this.e == null) {
            Intrinsics.checkNotNullParameter("NearGattService", "tag");
            Intrinsics.checkNotNullParameter("BluetoothGattServer is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearGattService", "TransConnect:BluetoothGattServer is null", null);
                return;
            }
            return;
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", version);
        jSONObject.put("Encrypt", i10);
        if (i10 != 0) {
            Intrinsics.checkNotNullParameter("NearGattService", "tag");
            Intrinsics.checkNotNullParameter("Encrypt is not supported", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearGattService", "TransConnect:Encrypt is not supported", null);
                return;
            }
            return;
        }
        jSONObject.put("ReqType", i13 | (i11 & 255));
        jSONObject.put("DeviceId", str == null ? "" : str);
        jSONObject.put("Mac", str2 != null ? str2 : "");
        jSONObject.put("state", i12);
        Integer numValueOf = nearDevice != null ? Integer.valueOf(nearDevice.p) : null;
        if (numValueOf != null && numValueOf.intValue() == 1) {
            jSONObject.put("ServerP2pMode", 2);
        } else if (numValueOf != null && numValueOf.intValue() == 2) {
            jSONObject.put("ServerP2pMode", 1);
        } else {
            jSONObject.put("ServerP2pMode", 0);
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        v(device, bluetoothGattCharacteristic, i8, i9, bytes);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0076  */
    /* JADX WARN: Code duplicated, block: B:18:0x0097  */
    /* JADX WARN: Code duplicated, block: B:19:0x0099  */
    /* JADX WARN: Code duplicated, block: B:22:0x009d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:25:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:28:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c5 A[Catch: Exception -> 0x00e8, TryCatch #0 {Exception -> 0x00e8, blocks: (B:33:0x00c1, B:35:0x00c5, B:36:0x00e2), top: B:48:0x00c1 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0119 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x011a  */
    /* JADX WARN: Code duplicated, block: B:48:0x00c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x011a -> B:45:0x011d). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object u(android.bluetooth.BluetoothDevice r21, android.bluetooth.BluetoothGattCharacteristic r22, int r23, int r24, byte[] r25, int r26, kotlin.coroutines.jvm.internal.ContinuationImpl r27) {
        /*
            Method dump skipped, instruction units count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.l.u(android.bluetooth.BluetoothDevice, android.bluetooth.BluetoothGattCharacteristic, int, int, byte[], int, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void v(BluetoothDevice bluetoothDevice, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i8, int i9, byte[] bArr) {
        li.l0.p(li.h0.a(v0.f7499b), null, null, new k2(this, bluetoothDevice, bluetoothGattCharacteristic, i8, i9, bArr, 1, null), 3);
    }

    public final void w(String str, String str2, WifiP2pDevice wifiP2pDevice, String str3) {
        i2 i2Var = this.f4162r;
        NearDevice nearDevice = i2Var != null ? i2Var.f9797g : null;
        LinkedHashMap linkedHashMap = this.f4158l;
        if (nearDevice != null) {
            WirelessDevice wirelessDevice = nearDevice.f3896s;
            if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
                Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
                WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
                i2 i2Var2 = this.f4162r;
                TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var2 != null ? i2Var2.f9793a : null, i2Var2 != null ? i2Var2.f9796d : null, i2Var2 != null ? i2Var2.f9795c : 0, str, str2, i2Var2 != null ? i2Var2.e : 0, i2Var2 != null ? i2Var2.f : 0, wifiP2pDevice, null);
                for (se.a0 a0Var : this.f4157k) {
                    BluetoothDevice bluetoothDevice = bluetooth.f4011d;
                    if (bluetoothDevice != null) {
                        a0Var.d(bluetoothDevice, wifiP2pDevice, str3, str, str2, tranConnectionController$P2pDeviceInfo, nearDevice);
                    }
                }
                linkedHashMap.clear();
                this.f4162r = null;
                return;
            }
        }
        Intrinsics.checkNotNullParameter("NearGattService", "tag");
        Intrinsics.checkNotNullParameter("sendWifiDirectGroupClientAvailable: device not found", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearGattService", "TransConnect:sendWifiDirectGroupClientAvailable: device not found", null);
        }
        if (!linkedHashMap.isEmpty()) {
            h4 h4Var = this.f4164t;
            if (h4Var != null) {
                h4Var.C();
            }
            this.f4162r = null;
            return;
        }
        Intrinsics.checkNotNullParameter("NearGattService", "tag");
        Intrinsics.checkNotNullParameter("sendWifiDirectGroupClientAvailable: mP2pInfo is null, ignore", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearGattService", "TransConnect:sendWifiDirectGroupClientAvailable: mP2pInfo is null, ignore", null);
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x005b A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:4:0x0005, B:5:0x000f, B:7:0x0016, B:13:0x002a, B:15:0x0034, B:16:0x003c, B:18:0x0042, B:30:0x0061, B:31:0x0069, B:33:0x006f, B:39:0x0084, B:41:0x008c, B:43:0x0090, B:45:0x00b0, B:47:0x00ce, B:49:0x00d2, B:50:0x00d9, B:51:0x00df, B:53:0x00e5, B:54:0x00f7, B:56:0x0103, B:58:0x0111, B:60:0x0119, B:64:0x0137, B:61:0x011f, B:63:0x0132, B:46:0x00c7, B:65:0x014c, B:67:0x015f, B:68:0x0170, B:25:0x0057, B:27:0x005b), top: B:73:0x0005 }] */
    /* JADX WARN: Code duplicated, block: B:28:0x005e  */
    public final void x(WifiP2pDevice wifiP2pDevice, String str, String str2) {
        String str3;
        i2 i2Var;
        NearDevice nearDevice;
        NearDevice nearDevice2;
        BluetoothDevice bluetoothDevice;
        synchronized (this) {
            try {
                Iterator it = this.f4161o.entrySet().iterator();
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
                Map map = (Map) this.f4161o.get(str3);
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
                        i2Var = this.f4162r;
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
                    i2Var = this.f4162r;
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
                    Intrinsics.checkNotNullParameter("NearGattService", "tag");
                    Intrinsics.checkNotNullParameter("Bluetooth device or gatt client is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattService", "TransConnect:Bluetooth device or gatt client is null", null);
                    }
                    Unit unit = Unit.INSTANCE;
                } else {
                    nearDevice.f3900x = PointerIconCompat.TYPE_NO_DROP;
                    NearDeviceExtension nearDeviceExtension = nearDevice.u;
                    LanNetworkInfo lanNetworkInfo = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
                    LanNetworkInfo lanNetworkInfo2 = new LanNetworkInfo(str2, str, nearDevice.f3885c, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (List) null);
                    if (lanNetworkInfo != null) {
                        we.h.h("NearGattService", "Network info is available: " + lanNetworkInfo);
                    } else {
                        we.h.j("NearGattService", "Network info is not available");
                    }
                    NearDeviceExtension nearDeviceExtension2 = nearDevice.u;
                    if (nearDeviceExtension2 != null) {
                        Intrinsics.checkNotNullParameter(lanNetworkInfo2, "lanNetworkInfo");
                        nearDeviceExtension2.f3909h = lanNetworkInfo2;
                    }
                    Iterator it4 = this.f4157k.iterator();
                    while (it4.hasNext()) {
                        ((se.a0) it4.next()).c(bluetoothDevice, wifiP2pDevice, nearDevice, str, str2);
                    }
                    if (this.f4160n.get(bluetoothDevice.getAddress()) != null) {
                        z1 z1Var = (z1) this.f4160n.get(bluetoothDevice.getAddress());
                        if (z1Var != null && Intrinsics.areEqual(z1Var.f10077a, bluetoothDevice)) {
                            z1Var.f10078b.add(wifiP2pDevice);
                        }
                    } else {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(wifiP2pDevice);
                        z1 z1Var2 = new z1(bluetoothDevice, arrayList, nearDevice);
                        String address = bluetoothDevice.getAddress();
                        if (address != null) {
                            this.f4160n.put(address, z1Var2);
                        }
                    }
                    this.f4162r = null;
                    TypeIntrinsics.asMutableMap(this.p).remove(str3);
                    TypeIntrinsics.asMutableMap(this.f4161o).remove(str3);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean y(BluetoothDevice bluetoothDevice, NearDevice nearDevice, String str, String str2, String str3, int i8, WifiP2pDevice wifiP2pDevice) {
        String str4;
        NearDevice nearDevice2;
        BluetoothDevice bluetoothDevice2;
        BluetoothGattService service;
        synchronized (this) {
            try {
                Iterator it = this.f4161o.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        str4 = null;
                        break;
                    }
                    str4 = (String) ((Map.Entry) it.next()).getKey();
                } while (str4 == null);
                Map map = (Map) this.f4161o.get(str4);
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
                if (bluetoothDevice3 != null && this.f4156j.contains(bluetoothDevice3)) {
                    BluetoothGattServer bluetoothGattServer = this.e;
                    BluetoothGattCharacteristic characteristic = (bluetoothGattServer == null || (service = bluetoothGattServer.getService(c6.f9688a)) == null) ? null : service.getCharacteristic(c6.f9691d);
                    if (characteristic == null) {
                        Intrinsics.checkNotNullParameter("NearGattService", "tag");
                        Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: notifyCharacteristic is null", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearGattService", "TransConnect:sendWifiDirectGroupOwnerAvailable: notifyCharacteristic is null", null);
                        }
                        h4 h4Var = this.f4164t;
                        if (h4Var != null) {
                            h4Var.D(bluetoothDevice3, wifiP2pDevice, nearDevice);
                        }
                        return false;
                    }
                    byte[] bArrL = l(i8, nearDevice2, str, str2, str3);
                    if (bArrL.length == 0) {
                        Intrinsics.checkNotNullParameter("NearGattService", "tag");
                        Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearGattService", "TransConnect:sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", null);
                        }
                        s();
                        h4 h4Var2 = this.f4164t;
                        if (h4Var2 != null) {
                            h4Var2.D(bluetoothDevice3, wifiP2pDevice, nearDevice);
                        }
                        return false;
                    }
                    v(bluetoothDevice3, characteristic, 0, 0, bArrL);
                    Iterator it4 = this.f4157k.iterator();
                    while (it4.hasNext()) {
                        ((se.a0) it4.next()).f(bluetoothDevice3, wifiP2pDevice, nearDevice);
                    }
                    s();
                    if ((nearDevice == null || nearDevice.f3889j != 15) && ((nearDevice == null || nearDevice.f3889j != 16) && (nearDevice == null || nearDevice.f3889j != 17))) {
                        h4 h4Var3 = this.f4164t;
                        if (h4Var3 != null) {
                            h4.F(h4Var3, bluetoothDevice, wifiP2pDevice, nearDevice, 0L, 24);
                            Unit unit = Unit.INSTANCE;
                        }
                    } else {
                        we.h.b("NearGattService", "Apple device, start P2P connect timer with 90s");
                        h4 h4Var4 = this.f4164t;
                        if (h4Var4 != null) {
                            h4.F(h4Var4, bluetoothDevice, wifiP2pDevice, nearDevice, 90000L, 16);
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                    return true;
                }
                Intrinsics.checkNotNullParameter("NearGattService", "tag");
                Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable:  device is null or not registered", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattService", "TransConnect:sendWifiDirectGroupOwnerAvailable:  device is null or not registered", null);
                }
                this.p.clear();
                this.f4161o.clear();
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
