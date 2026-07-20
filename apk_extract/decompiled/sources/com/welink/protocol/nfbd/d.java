package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.util.Log;
import androidx.lifecycle.CoroutineLiveDataKt;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;
import k3.lb;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import org.json.JSONException;
import org.json.JSONObject;
import se.h4;
import se.n0;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends we.g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final se.k f4092k = new se.k(se.m0.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f4093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f4094d;
    public final pe.d e;
    public final BluetoothManager f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final WifiManager f4095g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f4096h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final LinkedHashSet f4097i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4098j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, h4 h4Var) {
        List listEmptyList;
        super(false, "NearClassicBtHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4096h = new LinkedHashSet();
        this.f4097i = new LinkedHashSet();
        this.f4098j = 2;
        se.w listener = new se.w(this, 1);
        se.a0 listener2 = new se.a0(this, 1);
        o5.c cVar = new o5.c(this);
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        this.f = (BluetoothManager) systemService;
        Object systemService2 = context.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.f4095g = (WifiManager) systemService2;
        pe.d dVar = new pe.d(context);
        this.e = dVar;
        UUID uuidFromString = UUID.fromString("0000FD35-0000-1000-8000-00805f9b34fb");
        if (uuidFromString != null) {
            String string = uuidFromString.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            List<String> listSplit = new Regex("-").split(string, 0);
            if (!listSplit.isEmpty()) {
                ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                while (true) {
                    if (!listIterator.hasPrevious()) {
                        listEmptyList = CollectionsKt.emptyList();
                        break;
                    } else if (listIterator.previous().length() != 0) {
                        listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            } else {
                listEmptyList = CollectionsKt.emptyList();
                break;
            }
            if (((String[]) listEmptyList.toArray(new String[0])).length != 5) {
                throw new IllegalArgumentException(("Invalid UUID : " + uuidFromString).toString());
            }
            dVar.f8800d = uuidFromString;
        }
        dVar.q = CoroutineLiveDataKt.DEFAULT_TIMEOUT;
        dVar.p = true;
        se.l0 listener3 = new se.l0(this);
        Intrinsics.checkNotNullParameter(listener3, "listener");
        dVar.e.add(listener3);
        new pe.f(context).f8817g = cVar;
        se.g0 g0Var = c.f4072v;
        g0Var.getClass();
        c cVar2 = (c) g0Var.b(new Triple(context, this, h4Var));
        this.f4093c = cVar2;
        if (cVar2 != null) {
            cVar2.f = dVar;
        }
        if (cVar2 != null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            cVar2.f4077i.add(listener);
        }
        se.g0 g0Var2 = f.f4099r;
        g0Var2.getClass();
        f fVar = (f) g0Var2.b(new Triple(context, this, h4Var));
        this.f4094d = fVar;
        if (fVar != null) {
            fVar.e = dVar;
        }
        if (fVar != null) {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            fVar.f.add(listener2);
        }
    }

    public static final String j(d dVar, int i8) {
        dVar.getClass();
        if (i8 != 0) {
            return i8 != 1 ? "None" : "Server";
        }
        return "Client";
    }

    @Override // we.g
    public final void b(Message msg) {
        Intrinsics.checkNotNullParameter(msg, "msg");
        we.h.b("NearBluetoothManager", "handleThreadMessage: " + msg);
    }

    public final void k(NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(nearDevice, "device");
        WirelessDevice wirelessDevice = nearDevice.f3896s;
        BluetoothDevice device = wirelessDevice instanceof WirelessDevice.Bluetooth ? ((WirelessDevice.Bluetooth) wirelessDevice).f4011d : null;
        if (device == null) {
            Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
            Intrinsics.checkNotNullParameter("clientConnect: device is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothManager", "TransConnect:clientConnect: device is null", null);
                return;
            }
            return;
        }
        if (device.getBondState() != 12) {
            Intrinsics.checkNotNullParameter("NearBluetoothManager", "tag");
            Intrinsics.checkNotNullParameter("clientConnect: device not bonded", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearBluetoothManager", "TransConnect:clientConnect: device not bonded", null);
            }
            device.createBond();
            this.f4097i.add(TuplesKt.to(device, nearDevice));
            return;
        }
        c cVar = this.f4093c;
        if (cVar != null) {
            se.g0 g0Var = c.f4072v;
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
            pe.d dVar = cVar.f;
            if (dVar == null || cVar.f4073c == null) {
                Intrinsics.checkNotNullParameter("NearBluetoothClient", "tag");
                Intrinsics.checkNotNullParameter("connect failed, mBluetoothConnection or mNearWifiP2pManager is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothClient", "TransConnect:connect failed, mBluetoothConnection or mNearWifiP2pManager is null", null);
                    return;
                }
                return;
            }
            if (dVar.q()) {
                we.h.j("NearBluetoothClient", "connect failed, already connected");
                return;
            }
            Pair pair = TuplesKt.to(device, nearDevice);
            LinkedHashSet linkedHashSet = cVar.f4076h;
            if (linkedHashSet.contains(pair)) {
                we.h.j("NearBluetoothClient", "connect failed, already pending");
                return;
            }
            linkedHashSet.add(pair);
            cVar.f4078j.put(device.getAddress(), new se.e0(device, cVar.f, nearDevice));
            cVar.i(cVar.e(6402, 1, 0, device));
        }
    }

    public final void l(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        WirelessDevice wirelessDevice = device.f3896s;
        if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
            return;
        }
        BluetoothDevice bluetoothDevice = ((WirelessDevice.Bluetooth) wirelessDevice).f4011d;
        if (bluetoothDevice == null) {
            Intrinsics.checkNotNullParameter("disconnectClient: device is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "disconnectClient: device is null", null);
                return;
            }
            return;
        }
        c cVar = this.f4093c;
        if (cVar != null) {
            cVar.n(bluetoothDevice, device);
        }
        f fVar = this.f4094d;
        if (fVar != null) {
            fVar.n(bluetoothDevice);
        }
    }

    public final void m(NearDevice nearDevice) {
        c cVar = this.f4093c;
        if (cVar != null) {
            o.d.z("flushDevice, device: ", nearDevice != null ? nearDevice.f3883a : null, "NearBluetoothClient");
            int i8 = cVar.f4085s;
            if (i8 <= 0) {
                cVar.f4085s = 0;
            } else {
                int i9 = i8 - 1;
                cVar.f4085s = i9;
                if (i9 == 0) {
                    h4 h4Var = cVar.f4073c;
                    if (h4Var != null) {
                        h4Var.J(cVar.u, 320098819);
                    }
                    we.h.h("NearBluetoothClient", "unregisterNearP2pManagerListener done");
                } else {
                    we.h.j("NearBluetoothClient", "unregisterNearP2pManagerListener, remaining count: " + i9);
                }
            }
        }
        f fVar = this.f4094d;
        if (fVar != null) {
            o.d.z("Flush device: ", nearDevice != null ? nearDevice.f3883a : null, "NearBluetoothServer");
            int i10 = fVar.p;
            if (i10 <= 0) {
                fVar.p = 0;
                return;
            }
            int i11 = i10 - 1;
            fVar.p = i11;
            if (i11 != 0) {
                we.h.j("NearBluetoothServer", "unregisterNearP2pManagerListener, remaining count: " + i11);
            } else {
                h4 h4Var2 = fVar.f4100c;
                if (h4Var2 != null) {
                    h4Var2.J(fVar.q, 320098820);
                }
                we.h.h("NearBluetoothServer", "unregisterNearP2pManagerListener done");
            }
        }
    }

    public final byte[] n(int i8, NearDevice nearDevice, String version) {
        byte[] bArrG;
        byte[] bArrK;
        Intrinsics.checkNotNullParameter(version, "version");
        UInt uIntM248boximpl = nearDevice != null ? UInt.m248boximpl(UInt.m254constructorimpl((int) (nearDevice.f3888i & 4294967295L))) : null;
        if (i8 != 251) {
            String strH = o.d.h(i8, "getCapability: unknown service type: ", "mes");
            if (lb.f6529c < 1) {
                return null;
            }
            Log.e("welinkBLE", strH, null);
            return null;
        }
        if (m.f4170t.d(version)) {
            if (uIntM248boximpl == null || uIntM248boximpl.getData() == 0) {
                bArrK = ne.b.f8193m;
                if (bArrK != null) {
                    Intrinsics.checkNotNull(bArrK);
                } else {
                    bArrK = new byte[]{-1, -1};
                }
            } else {
                BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
                bArrK = ne.b.k(uIntM248boximpl.getData());
            }
            BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
            bArrG = ne.b.g(bArrK);
        } else {
            bArrG = ne.b.g(null);
        }
        return new byte[]{bArrG[0], bArrG[1]};
    }

    public final String o() {
        BluetoothAdapter adapter;
        BluetoothManager bluetoothManager = this.f;
        if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return null;
        }
        return adapter.getAddress();
    }

    public final String p() {
        BluetoothAdapter adapter;
        BluetoothManager bluetoothManager = this.f;
        if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return null;
        }
        return adapter.getAddress();
    }

    public final byte[] q(int i8) {
        if (i8 == 0) {
            byte[] bArr = new byte[12];
            BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
            bArr[0] = (byte) ne.b.f();
            bArr[1] = 17;
            return bArr;
        }
        if (i8 == 1) {
            BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
            return new byte[]{(byte) ne.b.f(), 0};
        }
        if (i8 == 4) {
            BluetoothAdapter bluetoothAdapter3 = ne.b.f8183a;
            return new byte[]{(byte) ne.b.f(), 0};
        }
        if (i8 == 5) {
            BluetoothAdapter bluetoothAdapter4 = ne.b.f8183a;
            return new byte[]{(byte) ne.b.f(), 0};
        }
        switch (i8) {
            case 8:
                BluetoothAdapter bluetoothAdapter5 = ne.b.f8183a;
                return new byte[]{(byte) ne.b.f(), 0};
            case 9:
                BluetoothAdapter bluetoothAdapter6 = ne.b.f8183a;
                return new byte[]{(byte) ne.b.f(), 0};
            case 10:
                BluetoothAdapter bluetoothAdapter7 = ne.b.f8183a;
                return new byte[]{(byte) ne.b.f(), 0};
            case 11:
                BluetoothAdapter bluetoothAdapter8 = ne.b.f8183a;
                return new byte[]{(byte) ne.b.f(), 0};
            case 12:
                BluetoothAdapter bluetoothAdapter9 = ne.b.f8183a;
                return new byte[]{(byte) ne.b.f(), 0};
            case 13:
                BluetoothAdapter bluetoothAdapter10 = ne.b.f8183a;
                return new byte[]{(byte) ne.b.f(), 0};
            default:
                String strH = o.d.h(i8, "getServiceData: unknown service type: ", "mes");
                if (lb.f6529c < 1) {
                    return null;
                }
                Log.e("welinkBLE", strH, null);
                return null;
        }
    }

    public final List r() {
        ArrayList arrayList = new ArrayList();
        WifiManager wifiManager = this.f4095g;
        if (wifiManager != null && wifiManager.is5GHzBandSupported()) {
            arrayList.add("5G");
        }
        if (wifiManager != null && wifiManager.is24GHzBandSupported()) {
            arrayList.add("2.4G");
        }
        if (wifiManager != null && wifiManager.is6GHzBandSupported()) {
            arrayList.add("6G");
        }
        if (wifiManager != null && wifiManager.is60GHzBandSupported()) {
            arrayList.add("60G");
        }
        if (wifiManager != null && wifiManager.isP2pSupported()) {
            arrayList.add("P2P");
        }
        o.d.z("getWifiBandInfo: ", CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null), "NearBluetoothManager");
        return arrayList;
    }

    public final void s(NearDevice device, boolean z2, int i8, int i9) throws JSONException {
        pe.d dVar;
        Intrinsics.checkNotNullParameter(device, "device");
        WirelessDevice wirelessDevice = device.f3896s;
        if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
            return;
        }
        if (((WirelessDevice.Bluetooth) wirelessDevice).f4011d == null) {
            Intrinsics.checkNotNullParameter("onExchangeRsp: device is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "onExchangeRsp: device is null", null);
                return;
            }
            return;
        }
        f fVar = this.f4094d;
        if (fVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            WirelessDevice wirelessDevice2 = device.f3896s;
            if (wirelessDevice2 instanceof WirelessDevice.Bluetooth) {
                BluetoothDevice device2 = ((WirelessDevice.Bluetooth) wirelessDevice2).f4011d;
                d dVar2 = fVar.f4101d;
                String version = device.f3894o;
                if (version == null) {
                    version = "1.0";
                    String str = dVar2 != null ? "1.0" : null;
                    if (str != null) {
                        version = str;
                    }
                }
                Map map = h.f4132a;
                int iD = h.d(device.e);
                String strO = dVar2 != null ? dVar2.o() : null;
                String strP = dVar2 != null ? dVar2.p() : null;
                if (device2 != null) {
                    Intrinsics.checkNotNullParameter(device2, "device");
                    Intrinsics.checkNotNullParameter(version, "version");
                    if (dVar2 == null || !fVar.f4109n.contains(device2) || (dVar = fVar.e) == null || !dVar.q()) {
                        Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                        Intrinsics.checkNotNullParameter("sendReadResponse failed, mNearBluetoothManager is null or device is not connected or mBluetoothConnection is null or not connected", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearBluetoothServer", "TransConnect:sendReadResponse failed, mNearBluetoothManager is null or device is not connected or mBluetoothConnection is null or not connected", null);
                        }
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("Version", version);
                        jSONObject.put("Encrypt", 0);
                        jSONObject.put("ReqType", (iD & 255) | 47872);
                        if (strO == null) {
                            strO = "";
                        }
                        jSONObject.put("DeviceId", strO);
                        if (strP == null) {
                            strP = "";
                        }
                        jSONObject.put("Mac", strP);
                        jSONObject.put("state", z2 ? 1 : 0);
                        int i10 = device.p;
                        if (i10 == 1) {
                            jSONObject.put("ServerP2pMode", 2);
                        } else if (i10 == 2) {
                            jSONObject.put("ServerP2pMode", 1);
                        } else {
                            jSONObject.put("ServerP2pMode", 0);
                        }
                        String string = jSONObject.toString();
                        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                        byte[] bytes = string.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                        fVar.t(device2, i9, bytes);
                    }
                    if (iD == 1 || iD == 251) {
                        we.h.h("NearBluetoothServer", "sendExchangeRsp: reqType is parcel drop");
                        if (device.p == 2) {
                            fVar.u(device2);
                        } else {
                            we.h.b("NearBluetoothServer", "sendExchangeRsp: non-gc mode will not start timer");
                        }
                    } else {
                        we.h.b("NearBluetoothServer", "sendExchangeRsp: reqType is not support");
                    }
                } else {
                    Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                    Intrinsics.checkNotNullParameter("Bluetooth device is null", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("NearBluetoothServer", "TransConnect:Bluetooth device is null", null);
                    }
                }
                if (device2 != null) {
                    fVar.f4108m.put(device2.getAddress(), device);
                }
            }
        }
    }

    public final void t(NearDevice device, ConnectRequest connectRequest) {
        Intrinsics.checkNotNullParameter(device, "device");
        WirelessDevice wirelessDevice = device.f3896s;
        if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
            return;
        }
        if (((WirelessDevice.Bluetooth) wirelessDevice).f4011d == null) {
            Intrinsics.checkNotNullParameter("onP2pInvitationAccept: device is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "onP2pInvitationAccept: device is null", null);
                return;
            }
            return;
        }
        c cVar = this.f4093c;
        if (cVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (device.p == 1 || cVar.f4083o.isEmpty()) {
                we.h.h("NearBluetoothClient", "sendP2pConnectRequest: Remote is GC or Gatt Server Mode, Ignore");
            } else {
                cVar.f(new a0.g(connectRequest, 5, cVar, device));
            }
        }
        f fVar = this.f4094d;
        if (fVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (device.p == 1 || fVar.f4102g.isEmpty()) {
                we.h.j("NearBluetoothServer", "sendP2pConnectRequest: Remote is GC, Local is GO or GATT client mode Ignore");
            } else {
                fVar.f(new a0.g(connectRequest, 6, fVar, device));
            }
        }
    }

    public final void u(NearDevice device, boolean z2) throws JSONException {
        int i8 = 1;
        Intrinsics.checkNotNullParameter(device, "device");
        f fVar = this.f4094d;
        if (fVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            WirelessDevice wirelessDevice = device.f3896s;
            if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
                return;
            }
            WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
            BluetoothDevice bluetoothDevice = bluetooth.f4011d;
            if (bluetoothDevice == null) {
                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                Intrinsics.checkNotNullParameter("sendAcceptNotify: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothServer", "TransConnect:sendAcceptNotify: device is null", null);
                    return;
                }
                return;
            }
            d dVar = fVar.f4101d;
            String str = device.f3894o;
            if (str == null) {
                str = "1.0";
                String str2 = dVar != null ? "1.0" : null;
                if (str2 != null) {
                    str = str2;
                }
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Version", str);
            Map map = h.f4132a;
            int iD = h.d(device.e);
            jSONObject.put("Encrypt", 0);
            jSONObject.put("ReqType", (iD & 255) | 47872);
            jSONObject.put("DeviceId", dVar != null ? dVar.o() : null);
            jSONObject.put("Mac", dVar != null ? dVar.p() : null);
            jSONObject.put("state", 2);
            if (a.f4027k.c(str)) {
                jSONObject.put("Trust", z2);
            }
            int i9 = device.p;
            if (i9 == 1) {
                jSONObject.put("ServerP2pMode", 2);
            } else if (i9 != 2) {
                jSONObject.put("ServerP2pMode", 0);
            } else {
                jSONObject.put("ServerP2pMode", 1);
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (fVar.f4109n.contains(bluetoothDevice)) {
                fVar.t(bluetoothDevice, bluetooth.f4012h, bytes);
                if (iD == 1 || iD == 8 || iD == 10 || iD == 251) {
                    int i10 = device.p;
                    if (i10 == 1) {
                        fVar.f(new n0(fVar, bluetoothDevice, device, i8));
                    } else if (i10 != 2) {
                        we.h.b("NearBluetoothServer", "sendAcceptNotify: client mode is not support");
                    } else {
                        fVar.u(bluetoothDevice);
                    }
                } else {
                    we.h.b("NearBluetoothServer", "sendAcceptNotify: reqType is not support");
                }
            } else {
                String strN = o.d.n("Device not registered for notifications: ", bluetoothDevice.getAddress(), "NearBluetoothServer", "tag", "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strN, "NearBluetoothServer", null);
                }
            }
            fVar.f4108m.put(bluetoothDevice.getAddress(), device);
        }
    }

    public final void v(NearDevice device, int i8) throws JSONException {
        int i9;
        Intrinsics.checkNotNullParameter(device, "device");
        f fVar = this.f4094d;
        if (fVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            WirelessDevice wirelessDevice = device.f3896s;
            if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
                return;
            }
            WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
            BluetoothDevice bluetoothDevice = bluetooth.f4011d;
            if (bluetoothDevice == null) {
                Intrinsics.checkNotNullParameter("NearBluetoothServer", "tag");
                Intrinsics.checkNotNullParameter("sendRejectNotify: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearBluetoothServer", "TransConnect:sendRejectNotify: device is null", null);
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            Map map = h.f4132a;
            int iD = h.d(device.e);
            d dVar = fVar.f4101d;
            String str = device.f3894o;
            if (str == null) {
                str = "1.0";
                String str2 = dVar != null ? "1.0" : null;
                if (str2 != null) {
                    str = str2;
                }
            }
            jSONObject.put("Version", str);
            jSONObject.put("Encrypt", 0);
            jSONObject.put("ReqType", (iD & 255) | 47872);
            jSONObject.put("DeviceId", dVar != null ? dVar.o() : null);
            jSONObject.put("Mac", dVar != null ? dVar.p() : null);
            if (i8 == 0) {
                i9 = 3;
            } else if (i8 != 1) {
                i9 = i8 != 2 ? 9 : 8;
            } else {
                i9 = 7;
            }
            jSONObject.put("state", i9);
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (fVar.f4109n.contains(bluetoothDevice)) {
                fVar.t(bluetoothDevice, bluetooth.f4012h, bytes);
                return;
            }
            String strN = o.d.n("Device not registered for notifications: ", bluetoothDevice.getAddress(), "NearBluetoothServer", "tag", "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", strN, "NearBluetoothServer", null);
            }
        }
    }

    public final void w(int i8) {
        we.h.b("NearBluetoothManager", "setClientP2pMode: ".concat(i8 == 1 ? "P2P_GC" : "P2P_GO"));
        this.f4098j = i8;
    }
}
