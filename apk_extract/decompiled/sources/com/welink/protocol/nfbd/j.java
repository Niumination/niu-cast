package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.os.Bundle;
import android.os.Message;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import androidx.core.view.PointerIconCompat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.welink.protocol.utils.LanNetworkInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import k3.lb;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import li.v0;
import org.json.JSONException;
import org.json.JSONObject;
import se.a2;
import se.c2;
import se.c6;
import se.h4;
import se.i2;
import se.v1;
import se.w1;
import se.x1;
import se.y1;
import se.z1;

/* JADX INFO: loaded from: classes3.dex */
public final class j extends we.g {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final se.g0 f4133y = new se.g0(y1.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f4134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BluetoothManager f4135d;
    public final Context e;
    public final a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashSet f4136g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f4137h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ye.d f4138i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public i2 f4139j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedHashMap f4140k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedHashMap f4141l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashMap f4142m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final LinkedHashMap f4143n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Map f4144o;
    public CountDownLatch p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f4145r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public h4 f4146s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f4147t;
    public int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public ArrayList f4148v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a2 f4149w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final oe.a f4150x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, BluetoothManager bluetoothManager, a aVar) {
        super(false, "NearBluetoothHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        this.f4134c = mapSynchronizedMap;
        this.f4136g = new LinkedHashSet();
        this.f4137h = new LinkedHashSet();
        this.f4140k = new LinkedHashMap();
        this.f4141l = new LinkedHashMap();
        this.f4142m = new LinkedHashMap();
        this.f4143n = new LinkedHashMap();
        Map mapSynchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap2, "synchronizedMap(...)");
        this.f4144o = mapSynchronizedMap2;
        this.f4145r = 4096;
        this.f4149w = new a2(this);
        this.f4150x = new oe.a(this, 1);
        this.e = context;
        this.f4135d = bluetoothManager;
        this.f = aVar;
        this.f4138i = new ye.d(context);
    }

    public static final void j(j jVar) {
        jVar.getClass();
        if (we.m.e(265)) {
            we.m.c(265);
            we.h.b("NearGattClient", "BLE delay disconnect timer cancelled");
        }
    }

    public static BluetoothGattService m(BluetoothGatt bluetoothGatt, UUID uuid) {
        UUID uuid2 = c6.f9688a;
        List<BluetoothGattService> services = bluetoothGatt.getServices();
        if (services == null) {
            return null;
        }
        for (BluetoothGattService bluetoothGattService : services) {
            if (Intrinsics.areEqual(bluetoothGattService.getUuid(), uuid2) && bluetoothGattService.getCharacteristic(uuid) != null) {
                return bluetoothGattService;
            }
        }
        return null;
    }

    public static void t() {
        if (we.m.e(264)) {
            we.m.c(264);
            we.h.b("NearGattClient", "GATT waiting go created notify timer cancelled");
        }
    }

    @Override // we.g
    public final void b(Message msg) {
        BluetoothGatt bluetoothGatt;
        NearDevice nearDevice;
        Intrinsics.checkNotNullParameter(msg, "msg");
        int i8 = msg.what;
        LinkedHashSet linkedHashSet = this.f4136g;
        if (i8 == 2000) {
            Object obj = msg.obj;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
            this.f4137h.remove(bluetoothDevice);
            Iterator it = linkedHashSet.iterator();
            while (it.hasNext()) {
                ((se.w) it.next()).b(-255, bluetoothDevice, null);
            }
            return;
        }
        if (i8 == 2001) {
            Object obj2 = msg.obj;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
            return;
        }
        Map map = this.f4134c;
        switch (i8) {
            case PathInterpolatorCompat.MAX_NUM_POINTS /* 3000 */:
                Object obj3 = msg.obj;
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type android.bluetooth.BluetoothGatt");
                BluetoothGatt bluetoothGatt2 = (BluetoothGatt) obj3;
                Bundle data = msg.getData();
                Intrinsics.checkNotNull(data);
                BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) ((Parcelable) data.getParcelable("char", BluetoothGattCharacteristic.class));
                byte[] byteArray = data.getByteArray("value");
                if (bluetoothGattCharacteristic != null && byteArray != null) {
                    o(bluetoothGatt2, bluetoothGattCharacteristic, byteArray);
                    break;
                }
                break;
            case 3001:
                Object obj4 = msg.obj;
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) obj4;
                we.h.b("NearGattClient", "disconnect " + bluetoothDevice2.getAddress());
                x1 x1Var = (x1) map.get(bluetoothDevice2.getAddress());
                if (x1Var != null && (bluetoothGatt = x1Var.f10056b) != null) {
                    bluetoothGatt.disconnect();
                    break;
                }
                break;
            case 3002:
                Object obj5 = msg.obj;
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
                BluetoothDevice bluetoothDevice3 = (BluetoothDevice) obj5;
                h4 h4Var = this.f4146s;
                if (h4Var != null && !h4Var.k()) {
                    we.h.b("NearGattClient", "Not found P2P_OWNER_CONNECT_TIMER, use general disconnect function");
                    t();
                    w1 w1Var = new w1(this, bluetoothDevice3, 0);
                    if (!we.m.e(265)) {
                        we.h.b("NearGattClient", "BLE delay disconnect timer started");
                        we.m.a(265, 2500L, a(), w1Var);
                    } else {
                        we.h.b("NearGattClient", "BLE delay disconnect timer already started, update timer");
                        we.m.h(265, 2500L, a(), w1Var);
                    }
                    break;
                }
                break;
            case 3003:
                Object obj6 = msg.obj;
                Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type android.bluetooth.BluetoothGatt");
                Bundle data2 = msg.getData();
                String string = data2.getString("deviceId");
                boolean z2 = data2.getBoolean("trust");
                x1 x1Var2 = (x1) map.get(((BluetoothGatt) obj6).getDevice().getAddress());
                nearDevice = x1Var2 != null ? x1Var2.f10057c : null;
                if (nearDevice != null && Intrinsics.areEqual(nearDevice.f3885c, string) && z2) {
                    Iterator it2 = linkedHashSet.iterator();
                    while (it2.hasNext()) {
                        ((se.w) it2.next()).h(nearDevice, z2);
                    }
                    break;
                }
                break;
            case 3004:
                Object obj7 = msg.obj;
                Intrinsics.checkNotNull(obj7, "null cannot be cast to non-null type android.bluetooth.BluetoothGatt");
                String string2 = msg.getData().getString("deviceId");
                x1 x1Var3 = (x1) map.get(((BluetoothGatt) obj7).getDevice().getAddress());
                nearDevice = x1Var3 != null ? x1Var3.f10057c : null;
                if (nearDevice != null && Intrinsics.areEqual(nearDevice.f3885c, string2)) {
                    Iterator it3 = linkedHashSet.iterator();
                    while (it3.hasNext()) {
                        ((se.w) it3.next()).g(nearDevice);
                    }
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Code duplicated, block: B:10:0x001e  */
    /* JADX WARN: Code duplicated, block: B:12:0x0027  */
    /* JADX WARN: Code duplicated, block: B:13:0x0029  */
    public final byte[] k(String str, String str2, String str3, int i8, NearDevice nearDevice, BluetoothDevice bluetoothDevice) {
        String str4;
        if (bluetoothDevice == null) {
            we.h.b("NearGattClient", "getRemoteDeviceSupportedVersion, use default version");
            if (this.f != null) {
                str4 = "1.0";
            } else {
                str4 = null;
            }
        } else {
            x1 x1Var = (x1) this.f4134c.get(bluetoothDevice.getAddress());
            if ((x1Var != null ? x1Var.f10058d : null) != null) {
                str4 = x1Var.f10058d;
            } else {
                we.h.b("NearGattClient", "getRemoteDeviceSupportedVersion, use default version");
                if (this.f != null) {
                    str4 = "1.0";
                } else {
                    str4 = null;
                }
            }
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
        Intrinsics.checkNotNullParameter("NearGattClient", "tag");
        Intrinsics.checkNotNullParameter("buildWifiDirectGroupOwnerAvailable: remote version is not support", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearGattClient", "TransConnect:buildWifiDirectGroupOwnerAvailable: remote version is not support", null);
        }
        return new byte[0];
    }

    public final void l(BluetoothDevice device, NearDevice nearDevice) {
        h4 h4Var;
        Intrinsics.checkNotNullParameter(device, "device");
        x1 x1Var = (x1) this.f4134c.get(device.getAddress());
        if (x1Var != null) {
            x1Var.f10056b.disconnect();
            we.h.b("NearGattClient", "disconnect " + device.getName() + ", " + (nearDevice != null ? nearDevice.f3884b : null));
        }
        we.h.b("NearGattClient", "Disconnect P2p device");
        if (this.f4140k.isEmpty() && this.f4141l.isEmpty() && this.f4142m.isEmpty() && this.f4143n.isEmpty() && this.f4144o.isEmpty()) {
            we.h.b("NearGattClient", "P2p over Gatt server is not running");
            we.h.b("NearGattClient", "No p2p business running ignore");
            return;
        }
        we.h.b("NearGattClient", "P2p over Gatt server is running");
        h4 h4Var2 = this.f4146s;
        if (h4Var2 == null || h4Var2.l() || (h4Var = this.f4146s) == null) {
            return;
        }
        h4Var.o();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0030  */
    /* JADX WARN: Code duplicated, block: B:22:? A[RETURN, SYNTHETIC] */
    public final NearDevice n(String str) {
        x1 x1Var;
        Map map = this.f4134c;
        if (str != null) {
            x1 x1Var2 = (x1) map.get(str);
            if (x1Var2 != null) {
                return x1Var2.f10057c;
            }
            return null;
        }
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            x1Var = (x1) ((Map.Entry) it.next()).getValue();
            if (x1Var != null) {
                if (x1Var != null) {
                    return x1Var.f10057c;
                }
                return null;
            }
        }
        x1Var = null;
        if (x1Var != null) {
            return x1Var.f10057c;
        }
        return null;
    }

    public final void o(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        int i8 = se.a.f9637a;
        String address = bluetoothGatt.getDevice().getAddress();
        Intrinsics.checkNotNullExpressionValue(address, "getAddress(...)");
        if (!se.a.a(address, bArr)) {
            we.h.h("NearGattClient", "Received data is not completed, " + se.a.b(bArr) + ", wait for next packet");
            return;
        }
        String address2 = bluetoothGatt.getDevice().getAddress();
        Intrinsics.checkNotNullExpressionValue(address2, "getAddress(...)");
        byte[] bArrC = se.a.c(address2);
        if (bArrC != null) {
            try {
                JSONObject jSONObject = new JSONObject(new String(bArrC, Charsets.UTF_8));
                String strOptString = jSONObject.optString("Version");
                if (Intrinsics.areEqual(strOptString, "1.0")) {
                    we.h.h("NearGattClient", "parsePacketWithJson: 1.0, length: " + jSONObject.length());
                    we.h.b("NearGattClient", "parsePacketWithJson: " + jSONObject);
                    r(jSONObject, "1.0", bluetoothGatt, bluetoothGattCharacteristic);
                    return;
                }
                if (!Intrinsics.areEqual(strOptString, "2.0")) {
                    String strN = o.d.n("Unsupported version: ", jSONObject.optString("Version"), "NearGattClient", "tag", "mes");
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", strN, "NearGattClient", null);
                    }
                    bluetoothGatt.disconnect();
                    return;
                }
                we.h.h("NearGattClient", "parsePacketWithJson: 2.0, length: " + jSONObject.length());
                we.h.b("NearGattClient", "parsePacketWithJson: " + jSONObject);
                r(jSONObject, "2.0", bluetoothGatt, bluetoothGattCharacteristic);
            } catch (Exception e) {
                String mes = "parseIncomingRequest: " + e;
                Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes, "NearGattClient", null);
                }
            }
        }
    }

    public final JSONObject p(int i8, NearDevice nearDevice, String str) throws JSONException {
        Integer numValueOf;
        Byte bValueOf;
        Byte bValueOf2;
        String str2;
        BluetoothAdapter adapter;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", str);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", i8);
        a aVar = this.f;
        jSONObject.put("DeviceId", aVar != null ? aVar.n() : null);
        jSONObject.put("ClientP2pMode", aVar != null ? Integer.valueOf(aVar.f4032i) : null);
        if (aVar != null) {
            numValueOf = Integer.valueOf(aVar.f4032i == 1 ? 2 : 1);
        } else {
            numValueOf = null;
        }
        jSONObject.put("ServerP2pMode", numValueOf);
        jSONObject.put("FileCount", nearDevice.F);
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
        BluetoothManager bluetoothManager = this.f4135d;
        jSONObject.put("DeviceName", (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) ? null : adapter.getName());
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
        Map map = h.f4132a;
        int i9 = nearDevice.e;
        jSONObject.put("ServiceType", h.d(i9));
        jSONObject.put("SubCapability", nearDevice.f3887h);
        jSONObject.put("Protocol", 0);
        se.k kVar = a.f4027k;
        if (kVar.c(str) && (str2 = nearDevice.G) != null) {
            we.h.b("NearGattClient", "FileTypes : ".concat(str2));
            jSONObject.put("FileTypes", str2);
        }
        byte[] bArrQ = aVar != null ? aVar.q(i9) : null;
        if (bArrQ != null) {
            jSONObject.put("ServiceData", Base64.encodeToString(bArrQ, 0));
        } else {
            byte[] bArrM = aVar != null ? aVar.m(i9, nearDevice, str) : null;
            if (bArrM != null) {
                jSONObject.put("ServiceData", Base64.encodeToString(bArrM, 0));
            } else {
                jSONObject.put("ServiceData", "");
                we.h.j("NearGattClient", "buildConnectRequest: serviceData and capability is null");
                Unit unit = Unit.INSTANCE;
            }
        }
        List listR = aVar != null ? aVar.r() : null;
        if (listR != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(listR, " ", null, null, 0, null, null, 62, null));
        }
        if (kVar.c(str)) {
            long j8 = nearDevice.f3888i;
            if (j8 != 0) {
                jSONObject.put("TargetService", j8);
            }
        }
        return jSONObject;
    }

    public final JSONObject q(String str, NearDevice nearDevice, String str2, String str3, int i8, String str4) throws JSONException {
        Integer numValueOf;
        Byte bValueOf;
        Byte bValueOf2;
        int iD;
        byte[] bArrQ;
        BluetoothAdapter adapter;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Version", str);
        jSONObject.put("Encrypt", 0);
        jSONObject.put("ReqType", 253);
        a aVar = this.f;
        jSONObject.put("DeviceId", aVar != null ? aVar.n() : null);
        jSONObject.put("ClientP2pMode", aVar != null ? Integer.valueOf(aVar.f4032i) : null);
        if (aVar != null) {
            numValueOf = Integer.valueOf(aVar.f4032i == 1 ? 2 : 1);
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
        jSONObject.put("Chan", -1);
        jSONObject.put("Freq", i8);
        jSONObject.put("GoIpAddr", str4);
        jSONObject.put("Port", 0);
        jSONObject.put("MessagePort", 0);
        BluetoothManager bluetoothManager = this.f4135d;
        jSONObject.put("DeviceName", (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) ? null : adapter.getName());
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
        if (nearDevice != null && aVar != null && (bArrQ = aVar.q(nearDevice.e)) != null) {
            if (bArrQ.length == 0) {
                bArrQ = null;
            }
            if (bArrQ != null) {
                jSONObject.put("ServiceData", Base64.encodeToString(bArrQ, 0));
            }
        }
        List listR = aVar != null ? aVar.r() : null;
        if (listR != null) {
            jSONObject.put("BandSupport", CollectionsKt___CollectionsKt.joinToString$default(listR, " ", null, null, 0, null, null, 62, null));
        }
        return jSONObject;
    }

    /* JADX WARN: Code duplicated, block: B:131:0x0322  */
    /* JADX WARN: Code duplicated, block: B:132:0x0325  */
    /* JADX WARN: Code duplicated, block: B:134:0x0328  */
    /* JADX WARN: Code duplicated, block: B:135:0x032b  */
    /* JADX WARN: Code duplicated, block: B:148:0x0355  */
    /* JADX WARN: Code duplicated, block: B:150:0x0377  */
    /* JADX WARN: Code duplicated, block: B:151:0x0384  */
    /* JADX WARN: Code duplicated, block: B:152:0x038a  */
    /* JADX WARN: Code duplicated, block: B:157:0x03a1  */
    /* JADX WARN: Code duplicated, block: B:185:0x0401  */
    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r15v15 java.lang.String, still in use, count: 2, list:
          (r15v15 java.lang.String) from 0x0314: IF  (r15v15 java.lang.String) == (null java.lang.String)  -> B:304:? A[HIDDEN]
          (r15v15 java.lang.String) from 0x0318: PHI (r15 I:??) = (r15v7 java.lang.String), (r15v15 java.lang.String) binds: [B:128:0x0317, B:303:0x0318] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:132)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:67)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:50)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:96)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:36)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:44)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    public final void r(org.json.JSONObject r50, java.lang.String r51, android.bluetooth.BluetoothGatt r52, android.bluetooth.BluetoothGattCharacteristic r53) {
        /*
            Method dump skipped, instruction units count: 1582
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.j.r(org.json.JSONObject, java.lang.String, android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic):void");
    }

    public final void s() {
        h4 h4Var = this.f4146s;
        if (h4Var != null) {
            h4Var.u(new we.i(this), this.f4149w, 320098817);
        }
        int i8 = this.u + 1;
        this.u = i8;
        h0.a.u(i8, "registerNearP2pManagerListener: count: ", "NearGattClient");
    }

    /* JADX WARN: Code duplicated, block: B:16:0x006d  */
    /* JADX WARN: Code duplicated, block: B:18:0x0071  */
    /* JADX WARN: Code duplicated, block: B:20:0x008f  */
    /* JADX WARN: Code duplicated, block: B:23:0x00be A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:29:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:31:0x0102  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x00bf -> B:25:0x00c8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0100 -> B:32:0x0108). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0102 -> B:32:0x0108). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object u(android.bluetooth.BluetoothGatt r17, android.bluetooth.BluetoothGattCharacteristic r18, byte[] r19, kotlin.coroutines.jvm.internal.ContinuationImpl r20) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.j.u(android.bluetooth.BluetoothGatt, android.bluetooth.BluetoothGattCharacteristic, byte[], kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    public final void v(String str, String str2, WifiP2pDevice wifiP2pDevice, String str3) {
        i2 i2Var = this.f4139j;
        NearDevice nearDevice = i2Var != null ? i2Var.f9797g : null;
        LinkedHashMap linkedHashMap = this.f4140k;
        if (nearDevice != null) {
            WirelessDevice wirelessDevice = nearDevice.f3896s;
            if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
                Intrinsics.checkNotNull(wirelessDevice, "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth");
                WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
                i2 i2Var2 = this.f4139j;
                TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var2 != null ? i2Var2.f9793a : null, i2Var2 != null ? i2Var2.f9796d : null, i2Var2 != null ? i2Var2.f9795c : 0, str, str2, i2Var2 != null ? i2Var2.e : 0, i2Var2 != null ? i2Var2.f : 0, wifiP2pDevice, null);
                for (se.w wVar : this.f4136g) {
                    BluetoothDevice bluetoothDevice = bluetooth.f4011d;
                    if (bluetoothDevice != null) {
                        wVar.d(bluetoothDevice, wifiP2pDevice, str3, str, str2, tranConnectionController$P2pDeviceInfo, nearDevice);
                    }
                }
                linkedHashMap.clear();
                this.f4148v = null;
                this.f4139j = null;
                BluetoothDevice bluetoothDevice2 = bluetooth.f4011d;
                if (bluetoothDevice2 != null) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 3001;
                    messageObtain.obj = bluetoothDevice2;
                    Intrinsics.checkNotNull(messageObtain);
                    i(messageObtain);
                    return;
                }
                return;
            }
        }
        Intrinsics.checkNotNullParameter("NearGattClient", "tag");
        Intrinsics.checkNotNullParameter("sendWifiDirectGroupClientAvailable: device not found", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearGattClient", "TransConnect:sendWifiDirectGroupClientAvailable: device not found", null);
        }
        if (!linkedHashMap.isEmpty()) {
            h4 h4Var = this.f4146s;
            if (h4Var != null) {
                h4Var.C();
                return;
            }
            return;
        }
        Intrinsics.checkNotNullParameter("NearGattClient", "tag");
        Intrinsics.checkNotNullParameter("sendWifiDirectGroupClientAvailable: mP2pInfo is null, ignore", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearGattClient", "TransConnect:sendWifiDirectGroupClientAvailable: mP2pInfo is null, ignore", null);
        }
    }

    public final void w(WifiP2pDevice wifiP2pDevice, String str, String str2) {
        Object address;
        String str3;
        BluetoothDevice bluetoothDevice;
        BluetoothDevice bluetoothDevice2;
        BluetoothDevice bluetoothDevice3;
        BluetoothDevice bluetoothDevice4;
        NearDeviceExtension nearDeviceExtension;
        NearDeviceExtension nearDeviceExtension2;
        synchronized (this) {
            try {
                Iterator it = this.f4142m.entrySet().iterator();
                while (true) {
                    address = null;
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
                x1 x1Var = (x1) this.f4134c.get(str3);
                BluetoothDevice bluetoothDevice5 = x1Var != null ? x1Var.f10055a : null;
                NearDevice nearDevice = x1Var != null ? x1Var.f10057c : null;
                if (bluetoothDevice5 == null || this.f4134c.get(bluetoothDevice5.getAddress()) == null) {
                    Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                    Intrinsics.checkNotNullParameter("Bluetooth device or gatt client is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattClient", "TransConnect:Bluetooth device or gatt client is null", null);
                    }
                } else {
                    if (nearDevice != null) {
                        nearDevice.f3900x = PointerIconCompat.TYPE_NO_DROP;
                    }
                    ArrayList arrayList = this.f4148v;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        we.h.b("NearGattClient", "Remote service port list: " + this.f4148v);
                        LanNetworkInfo lanNetworkInfo = (nearDevice == null || (nearDeviceExtension2 = nearDevice.u) == null) ? null : nearDeviceExtension2.f3909h;
                        if (lanNetworkInfo != null) {
                            we.h.h("NearGattClient", "Network info is available: " + lanNetworkInfo);
                            lanNetworkInfo.f4247n = this.f4148v;
                        } else {
                            we.h.j("NearGattClient", "Network info is not available");
                            LanNetworkInfo lanNetworkInfo2 = new LanNetworkInfo(str2, str, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, this.f4148v);
                            if (nearDevice != null && (nearDeviceExtension = nearDevice.u) != null) {
                                Intrinsics.checkNotNullParameter(lanNetworkInfo2, "lanNetworkInfo");
                                nearDeviceExtension.f3909h = lanNetworkInfo2;
                            }
                        }
                    }
                    Iterator it2 = this.f4136g.iterator();
                    while (it2.hasNext()) {
                        ((se.w) it2.next()).c(bluetoothDevice5, wifiP2pDevice, nearDevice, str, str2);
                    }
                    x1 x1Var2 = (x1) this.f4134c.get(bluetoothDevice5.getAddress());
                    if (this.f4144o.get((x1Var2 == null || (bluetoothDevice4 = x1Var2.f10055a) == null) ? null : bluetoothDevice4.getAddress()) != null) {
                        z1 z1Var = (z1) this.f4144o.get((x1Var2 == null || (bluetoothDevice3 = x1Var2.f10055a) == null) ? null : bluetoothDevice3.getAddress());
                        if (z1Var != null) {
                            if (Intrinsics.areEqual(z1Var.f10077a, x1Var2 != null ? x1Var2.f10055a : null)) {
                                z1Var.f10078b.add(wifiP2pDevice);
                            }
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(wifiP2pDevice);
                        z1 z1Var2 = (x1Var2 == null || (bluetoothDevice2 = x1Var2.f10055a) == null) ? null : new z1(bluetoothDevice2, arrayList2, nearDevice);
                        if (x1Var2 != null && (bluetoothDevice = x1Var2.f10055a) != null) {
                            address = bluetoothDevice.getAddress();
                        }
                        if (address != null) {
                            Map map = this.f4144o;
                            Intrinsics.checkNotNull(z1Var2, "null cannot be cast to non-null type com.welink.protocol.nfbd.NearGattClient.MiscDeviceInfo");
                            map.put(address, z1Var2);
                        }
                    }
                    TypeIntrinsics.asMutableMap(this.f4143n).remove(str3);
                    TypeIntrinsics.asMutableMap(this.f4142m).remove(str3);
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 3001;
                    messageObtain.obj = bluetoothDevice5;
                    Intrinsics.checkNotNull(messageObtain);
                    i(messageObtain);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean x(String str, String str2, String str3, int i8, WifiP2pDevice wifiP2pDevice) {
        String str4;
        synchronized (this) {
            try {
                Iterator it = this.f4142m.entrySet().iterator();
                do {
                    if (!it.hasNext()) {
                        str4 = null;
                        break;
                    }
                    str4 = (String) ((Map.Entry) it.next()).getKey();
                } while (str4 == null);
                x1 x1Var = (x1) this.f4134c.get(str4);
                BluetoothGatt bluetoothGatt = x1Var != null ? x1Var.f10056b : null;
                BluetoothDevice bluetoothDevice = x1Var != null ? x1Var.f10055a : null;
                NearDevice nearDevice = x1Var != null ? x1Var.f10057c : null;
                if (bluetoothGatt == null) {
                    Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                    Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: connectGatt or device is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattClient", "TransConnect:sendWifiDirectGroupOwnerAvailable: connectGatt or device is null", null);
                    }
                    this.f4143n.clear();
                    this.f4142m.clear();
                    this.f4148v = null;
                    return false;
                }
                UUID uuid = c6.f9690c;
                BluetoothGattService bluetoothGattServiceM = m(bluetoothGatt, uuid);
                BluetoothGattCharacteristic characteristic = bluetoothGattServiceM != null ? bluetoothGattServiceM.getCharacteristic(uuid) : null;
                if (characteristic == null) {
                    Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                    Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: notifyCharacteristic is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattClient", "TransConnect:sendWifiDirectGroupOwnerAvailable: notifyCharacteristic is null", null);
                    }
                    h4 h4Var = this.f4146s;
                    if (h4Var != null) {
                        h4Var.D(bluetoothDevice, wifiP2pDevice, nearDevice);
                    }
                    return false;
                }
                byte[] bArrK = k(str, str2, str3, i8, nearDevice, bluetoothDevice);
                if (bArrK.length == 0) {
                    Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                    Intrinsics.checkNotNullParameter("sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearGattClient", "TransConnect:sendWifiDirectGroupOwnerAvailable: wifiDirectGroupOwnerAvailable is empty", null);
                    }
                    t();
                    h4 h4Var2 = this.f4146s;
                    if (h4Var2 != null) {
                        h4Var2.D(bluetoothDevice, wifiP2pDevice, nearDevice);
                    }
                    return false;
                }
                li.l0.p(li.h0.a(v0.f7499b), null, null, new c2(this, bluetoothGatt, characteristic, bArrK, null), 3);
                Iterator it2 = this.f4136g.iterator();
                while (it2.hasNext()) {
                    ((se.w) it2.next()).f(bluetoothDevice, wifiP2pDevice, nearDevice, null);
                }
                t();
                if ((nearDevice == null || nearDevice.f3889j != 15) && ((nearDevice == null || nearDevice.f3889j != 16) && (nearDevice == null || nearDevice.f3889j != 17))) {
                    h4 h4Var3 = this.f4146s;
                    if (h4Var3 != null) {
                        h4Var3.E(bluetoothDevice, wifiP2pDevice, nearDevice, 3000L, 100);
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    we.h.b("NearGattService", "Apple device client, start P2P connect timer with 90s");
                    h4 h4Var4 = this.f4146s;
                    if (h4Var4 != null) {
                        h4Var4.E(bluetoothDevice, wifiP2pDevice, nearDevice, 90000L, 100);
                        Unit unit2 = Unit.INSTANCE;
                    }
                }
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void y(BluetoothGatt bluetoothGatt, Long l4) {
        int i8;
        int i9;
        v1 v1Var = new v1(this, bluetoothGatt, 4, (byte) 0);
        if (we.m.e(264)) {
            we.h.b("NearGattClient", "GATT waiting go created notify timer already started, update timer");
            NearDevice nearDeviceN = n(bluetoothGatt.getDevice().getAddress());
            if (nearDeviceN == null || !((i9 = nearDeviceN.f3889j) == 15 || i9 == 16 || i9 == 17)) {
                we.m.h(264, l4 != null ? l4.longValue() : 3000L, a(), v1Var);
                return;
            } else {
                we.h.b("NearGattClient", "Apple device client , gattWaitingResponse adjust gatt timer 90s");
                we.m.h(264, 90000L, a(), v1Var);
                return;
            }
        }
        we.h.b("NearGattClient", "GATT waiting go created notify timer started");
        NearDevice nearDeviceN2 = n(bluetoothGatt.getDevice().getAddress());
        if (nearDeviceN2 == null || !((i8 = nearDeviceN2.f3889j) == 15 || i8 == 16 || i8 == 17)) {
            we.m.a(264, l4 != null ? l4.longValue() : 3000L, a(), v1Var);
        } else {
            we.h.b("NearGattClient", "Apple device client , gattWaitingResponse adjust gatt timer 90s");
            we.m.a(264, 90000L, a(), v1Var);
        }
    }
}
