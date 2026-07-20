package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.UInt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qg.y0;
import se.c6;
import se.e2;
import se.h4;
import se.w1;
import se.x1;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends we.g {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final se.k f4027k = new se.k(se.j.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l f4028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f4029d;
    public final BluetoothManager e;
    public final WifiManager f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f4030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LinkedHashSet f4031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f4032i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f4033j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, h4 h4Var) {
        super(false, "NearBluetoothHandler");
        Intrinsics.checkNotNullParameter(context, "context");
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        this.f4030g = mapSynchronizedMap;
        this.f4031h = new LinkedHashSet();
        this.f4032i = 2;
        se.a0 listener = new se.a0(this, 0);
        se.w listener2 = new se.w(this, 0);
        Object systemService = context.getSystemService("bluetooth");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
        BluetoothManager bluetoothManager = (BluetoothManager) systemService;
        this.e = bluetoothManager;
        Object systemService2 = context.getSystemService("wifi");
        Intrinsics.checkNotNull(systemService2, "null cannot be cast to non-null type android.net.wifi.WifiManager");
        this.f = (WifiManager) systemService2;
        se.g0 g0Var = l.A;
        g0Var.getClass();
        l lVar = (l) g0Var.b(new Triple(context, bluetoothManager, this));
        this.f4028c = lVar;
        se.g0 g0Var2 = j.f4133y;
        g0Var2.getClass();
        j jVar = (j) g0Var2.b(new Triple(context, bluetoothManager, this));
        this.f4029d = jVar;
        if (lVar != null) {
            lVar.f4164t = h4Var;
        }
        if (lVar != null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            lVar.f4157k.add(listener);
        }
        if (jVar != null) {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            jVar.f4136g.add(listener2);
        }
        if (jVar != null) {
            jVar.f4146s = h4Var;
        }
    }

    @Override // we.g
    public final void b(Message msg) {
        l lVar;
        Intrinsics.checkNotNullParameter(msg, "msg");
        we.h.b("NearBleManager", "handleThreadMessage: " + msg);
        if (msg.what != 2000) {
            Intrinsics.checkNotNullParameter(msg, "msg");
            return;
        }
        Object obj = msg.obj;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.bluetooth.BluetoothDevice");
        BluetoothDevice bluetoothDevice = (BluetoothDevice) obj;
        int i8 = msg.arg1;
        int i9 = msg.arg2;
        String address = bluetoothDevice.getAddress();
        Map map = this.f4030g;
        if (map.containsKey(address)) {
            ConnectRequest connectRequest = (ConnectRequest) map.get(bluetoothDevice.getAddress());
            map.remove(bluetoothDevice.getAddress());
            if (connectRequest == null || (lVar = this.f4028c) == null) {
                return;
            }
            String str = connectRequest.f3862a;
            if (str == null) {
                str = "1.0";
            }
            String str2 = str;
            se.g0 g0Var = l.A;
            lVar.t(bluetoothDevice, i8, i9, str2, connectRequest.f3863b, connectRequest.f3864c, connectRequest.f3865d, connectRequest.f3870l, 0, 187, null, null);
        }
    }

    public final void j(NearDevice nearDevice) {
        int i8 = 1;
        Intrinsics.checkNotNullParameter(nearDevice, "device");
        WirelessDevice wirelessDevice = nearDevice.f3896s;
        BluetoothDevice device = wirelessDevice instanceof WirelessDevice.Bluetooth ? ((WirelessDevice.Bluetooth) wirelessDevice).f4011d : null;
        if (device == null) {
            Intrinsics.checkNotNullParameter("clientConnect: device is null", "mes");
            if (lb.f6529c >= 1) {
                Log.e("welinkBLE", "clientConnect: device is null", null);
                return;
            }
            return;
        }
        j jVar = this.f4029d;
        if (jVar != null) {
            se.g0 g0Var = j.f4133y;
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(nearDevice, "nearDevice");
            String address = device.getAddress();
            Map map = jVar.f4134c;
            Object obj = map.get(address);
            LinkedHashSet linkedHashSet = jVar.f4136g;
            if (obj != null) {
                we.h.j("NearGattClient", "GattServer of device " + device.getName() + " was connected already");
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((se.w) it.next()).a(device, nearDevice);
                }
                return;
            }
            Context context = jVar.e;
            if (context == null || jVar.f4135d == null || jVar.f == null) {
                Intrinsics.checkNotNullParameter("NearGattClient", "tag");
                Intrinsics.checkNotNullParameter("Context or BluetoothManager or NearBleManager is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattClient", "TransConnect:Context or BluetoothManager or NearBleManager is null", null);
                }
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    ((se.w) it2.next()).b(FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN, device, nearDevice);
                }
                return;
            }
            BluetoothGatt bluetoothGattConnectGatt = device.connectGatt(context, false, jVar.f4150x, 2);
            if (bluetoothGattConnectGatt != null) {
                jVar.q = 0;
                map.put(device.getAddress(), new x1(device, bluetoothGattConnectGatt, nearDevice));
                w1 w1Var = new w1(jVar, device, i8);
                ConcurrentHashMap concurrentHashMap = we.m.f10734a;
                we.m.a(258, 3000L, jVar.a(), w1Var);
                return;
            }
            Intrinsics.checkNotNullParameter("NearGattClient", "tag");
            Intrinsics.checkNotNullParameter("connectGatt fail", "mes");
            if (lb.f6529c >= 1) {
                Log.e("NearGattClient", "TransConnect:connectGatt fail", null);
            }
            Iterator it3 = linkedHashSet.iterator();
            while (it3.hasNext()) {
                ((se.w) it3.next()).b(InputDeviceCompat.SOURCE_TOUCHSCREEN, device, nearDevice);
            }
        }
    }

    public final void k(NearDevice device) {
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
        l lVar = this.f4028c;
        if (lVar != null) {
            lVar.m(bluetoothDevice);
        }
        j jVar = this.f4029d;
        if (jVar != null) {
            jVar.l(bluetoothDevice, device);
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0032  */
    /* JADX WARN: Code duplicated, block: B:21:0x0037  */
    /* JADX WARN: Code duplicated, block: B:23:0x003d  */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003f, code lost:
    
        if (r9.f3886d == null) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(com.welink.protocol.nfbd.NearDevice r9) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb7
            java.lang.String r0 = r9.f3883a
            java.lang.String r1 = "unregisterNearP2pManagerListener done"
            java.lang.String r2 = "NearBleManager"
            java.lang.String r3 = "unregisterNearP2pManagerListener, remaining count: "
            r4 = 0
            java.lang.String r5 = "flushDevice: flush device "
            int r6 = r9.f3890k
            if (r6 == 0) goto L15
            r7 = 1
            if (r6 == r7) goto L15
            goto L42
        L15:
            com.welink.protocol.nfbd.WirelessDevice r6 = r9.f3896s
            boolean r7 = r6 instanceof com.welink.protocol.nfbd.WirelessDevice.Bluetooth
            if (r7 == 0) goto L32
            java.lang.String r7 = "null cannot be cast to non-null type com.welink.protocol.nfbd.WirelessDevice.Bluetooth"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r7)
            com.welink.protocol.nfbd.WirelessDevice$Bluetooth r6 = (com.welink.protocol.nfbd.WirelessDevice.Bluetooth) r6
            android.bluetooth.le.ScanResult r6 = r6.f4010c
            if (r6 != 0) goto L32
            java.lang.Integer r6 = r9.f3886d
            if (r6 != 0) goto L2b
            goto L32
        L2b:
            int r6 = r6.intValue()
            if (r6 != 0) goto L32
            goto L7d
        L32:
            java.lang.Integer r6 = r9.f3886d
            if (r6 != 0) goto L37
            goto L3d
        L37:
            int r6 = r6.intValue()
            if (r6 == 0) goto L7d
        L3d:
            java.lang.Integer r9 = r9.f3886d
            if (r9 != 0) goto L42
            goto L7d
        L42:
            java.lang.String r9 = "flushDevice: client mode device"
            we.h.b(r2, r9)
            com.welink.protocol.nfbd.j r8 = r8.f4029d
            if (r8 == 0) goto Lb7
            java.lang.String r9 = "NearGattClient"
            h0.a.D(r5, r0, r9)
            int r0 = r8.u
            if (r0 > 0) goto L57
            r8.u = r4
            goto Lb7
        L57:
            int r0 = r0 + (-1)
            r8.u = r0
            if (r0 != 0) goto L6d
            se.h4 r0 = r8.f4146s
            if (r0 == 0) goto L69
            se.a2 r8 = r8.f4149w
            r2 = 320098817(0x13145201, float:1.8720657E-27)
            r0.J(r8, r2)
        L69:
            we.h.h(r9, r1)
            goto Lb7
        L6d:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            we.h.j(r9, r8)
            goto Lb7
        L7d:
            java.lang.String r9 = "flushDevice: server mode device"
            we.h.b(r2, r9)
            com.welink.protocol.nfbd.l r8 = r8.f4028c
            if (r8 == 0) goto Lb7
            java.lang.String r9 = "NearGattService"
            h0.a.D(r5, r0, r9)
            int r0 = r8.f4166w
            if (r0 > 0) goto L92
            r8.f4166w = r4
            goto Lb7
        L92:
            int r0 = r0 + (-1)
            r8.f4166w = r0
            if (r0 != 0) goto La8
            se.h4 r0 = r8.f4164t
            if (r0 == 0) goto La4
            se.j2 r8 = r8.f4168y
            r2 = 320098818(0x13145202, float:1.872066E-27)
            r0.J(r8, r2)
        La4:
            we.h.h(r9, r1)
            goto Lb7
        La8:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r3)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            we.h.j(r9, r8)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.welink.protocol.nfbd.a.l(com.welink.protocol.nfbd.NearDevice):void");
    }

    public final byte[] m(int i8, NearDevice nearDevice, String version) {
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
        if (f4027k.c(version)) {
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
            BluetoothAdapter bluetoothAdapter3 = ne.b.f8183a;
            bArrG = ne.b.g(ne.b.f8193m);
        }
        return new byte[]{bArrG[0], bArrG[1]};
    }

    public final String n() {
        byte[] bArrM = ne.b.m();
        if (bArrM == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(bArrM, "<this>");
        Intrinsics.checkNotNullParameter(":", "separator");
        return ArraysKt___ArraysKt.joinToString$default(bArrM, (CharSequence) ":", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new y0(16), 30, (Object) null);
    }

    public final String o() {
        BluetoothAdapter adapter;
        BluetoothManager bluetoothManager = this.e;
        if (bluetoothManager == null || (adapter = bluetoothManager.getAdapter()) == null) {
            return null;
        }
        return adapter.getAddress();
    }

    public final String p() {
        try {
            byte[] bArr = this.f4033j;
            byte b9 = bArr != null ? bArr[7] : (byte) 0;
            byte b10 = bArr != null ? bArr[8] : (byte) 1;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b9)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            String str2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b10)}, 1));
            Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
            return str.concat(str2);
        } catch (Exception e) {
            String mes = "getProductCode: " + e;
            Intrinsics.checkNotNullParameter("NearBleManager", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c < 1) {
                return "0001";
            }
            h0.a.x("TransConnect:", mes, "NearBleManager", null);
            return "0001";
        }
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
                String strM = o.d.m("getServiceData: unknown service type: ", "NearBleManager", "tag", "mes", i8);
                if (lb.f6529c < 1) {
                    return null;
                }
                h0.a.x("TransConnect:", strM, "NearBleManager", null);
                return null;
        }
    }

    public final List r() {
        ArrayList arrayList = new ArrayList();
        WifiManager wifiManager = this.f;
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
        o.d.z("getWifiBandInfo: ", CollectionsKt___CollectionsKt.joinToString$default(arrayList, " ", null, null, 0, null, null, 62, null), "NearBleManager");
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003b A[PHI: r1
      0x003b: PHI (r1v8 java.lang.String) = (r1v7 java.lang.String), (r1v22 java.lang.String) binds: [B:13:0x0030, B:18:0x0039] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:46:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:49:0x00bc  */
    public final void s(NearDevice device, boolean z2, int i8, int i9) {
        String str;
        BluetoothDevice bluetoothDevice;
        BluetoothGattService service;
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
        l lVar = this.f4028c;
        if (lVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            WirelessDevice wirelessDevice2 = device.f3896s;
            if (wirelessDevice2 instanceof WirelessDevice.Bluetooth) {
                BluetoothDevice bluetoothDevice2 = ((WirelessDevice.Bluetooth) wirelessDevice2).f4011d;
                a aVar = lVar.f;
                String str2 = device.f3894o;
                if (str2 == null) {
                    str2 = "1.0";
                    str = aVar != null ? "1.0" : null;
                    if (str == null) {
                        str = str2;
                    }
                } else {
                    str = str2;
                }
                Map map = h.f4132a;
                int iD = h.d(device.e);
                String strN = aVar != null ? aVar.n() : null;
                String strO = aVar != null ? aVar.o() : null;
                BluetoothGattServer bluetoothGattServer = lVar.e;
                BluetoothGattCharacteristic characteristic = (bluetoothGattServer == null || (service = bluetoothGattServer.getService(c6.f9688a)) == null) ? null : service.getCharacteristic(c6.f9691d);
                if (bluetoothDevice2 == null || characteristic == null) {
                    bluetoothDevice = bluetoothDevice2;
                    if (bluetoothDevice == null) {
                        Intrinsics.checkNotNullParameter("NearGattService", "tag");
                        Intrinsics.checkNotNullParameter("Bluetooth device is null", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearGattService", "TransConnect:Bluetooth device is null", null);
                        }
                    } else {
                        Intrinsics.checkNotNullParameter("NearGattService", "tag");
                        Intrinsics.checkNotNullParameter("Characteristic was not found", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearGattService", "TransConnect:Characteristic was not found", null);
                        }
                    }
                } else {
                    lVar.t(bluetoothDevice2, i8, i9, str, 0, iD, strN, strO, z2 ? 1 : 0, 47872, characteristic, device);
                    if (iD != 1 && iD != 251 && iD != 4 && iD != 5) {
                        switch (iD) {
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                                we.h.h("NearGattService", "sendExchangeRsp: reqType is parcel drop");
                                if (device.p != 2) {
                                    bluetoothDevice = bluetoothDevice2;
                                    we.h.b("NearGattService", "sendExchangeRsp: non-gc mode will not start timer");
                                } else {
                                    bluetoothDevice = bluetoothDevice2;
                                    lVar.A(bluetoothDevice);
                                }
                                break;
                            default:
                                we.h.b("NearGattService", "sendExchangeRsp: reqType is not support");
                                bluetoothDevice = bluetoothDevice2;
                                break;
                        }
                    } else {
                        we.h.h("NearGattService", "sendExchangeRsp: reqType is parcel drop");
                        if (device.p != 2) {
                            bluetoothDevice = bluetoothDevice2;
                            lVar.A(bluetoothDevice);
                        } else {
                            bluetoothDevice = bluetoothDevice2;
                            we.h.b("NearGattService", "sendExchangeRsp: non-gc mode will not start timer");
                        }
                    }
                }
                if (bluetoothDevice != null) {
                    lVar.f4163s.put(bluetoothDevice.getAddress(), device);
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
        l lVar = this.f4028c;
        if (lVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (device.p == 1 || lVar.f4158l.isEmpty()) {
                we.h.j("NearGattService", "sendP2pConnectRequest: Remote is GC, Local is GO or GATT client mode Ignore");
            } else {
                lVar.f(new a0.g(connectRequest, 12, lVar, device));
            }
        }
        j jVar = this.f4029d;
        if (jVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            if (device.p == 1 || jVar.f4140k.isEmpty()) {
                we.h.h("NearGattClient", "sendP2pConnectRequest: Remote is GC or Gatt Server Mode, Ignore");
            } else {
                jVar.f(new a0.g(connectRequest, 10, jVar, device));
            }
        }
    }

    public final void u(List services) {
        Intrinsics.checkNotNullParameter(services, "services");
        l lVar = this.f4028c;
        if (lVar != null) {
            Intrinsics.checkNotNullParameter(services, "services");
            we.h.b("NearGattService", "setAdvertiseServiceAndPort: services: " + services);
            if (services.isEmpty()) {
                we.h.j("NearGattService", "setAdvertiseServiceAndPort: services is empty, ignore it");
                return;
            }
            lVar.f4167x = services;
            we.h.b("NearGattService", "setAdvertiseServiceAndPort: mBroadcastServices: " + services);
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x015b  */
    /* JADX WARN: Code duplicated, block: B:72:0x015f  */
    /* JADX WARN: Code duplicated, block: B:74:0x0162  */
    /* JADX WARN: Code duplicated, block: B:75:0x0168  */
    /* JADX WARN: Code duplicated, block: B:76:0x016c  */
    public final void v(NearDevice device, boolean z2) throws JSONException {
        int i8;
        BluetoothGattService service;
        int i9 = 1;
        Intrinsics.checkNotNullParameter(device, "device");
        l lVar = this.f4028c;
        if (lVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            WirelessDevice wirelessDevice = device.f3896s;
            if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
                return;
            }
            WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
            BluetoothDevice bluetoothDevice = bluetooth.f4011d;
            if (bluetoothDevice == null) {
                Intrinsics.checkNotNullParameter("NearGattService", "tag");
                Intrinsics.checkNotNullParameter("sendAcceptNotify: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattService", "TransConnect:sendAcceptNotify: device is null", null);
                    return;
                }
                return;
            }
            a aVar = lVar.f;
            String str = device.f3894o;
            if (str == null) {
                str = "1.0";
                String str2 = aVar != null ? "1.0" : null;
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
            jSONObject.put("DeviceId", aVar != null ? aVar.n() : null);
            jSONObject.put("Mac", aVar != null ? aVar.o() : null);
            jSONObject.put("state", 2);
            se.k kVar = f4027k;
            if (kVar.c(str)) {
                jSONObject.put("Trust", z2);
            }
            int i10 = device.p;
            if (i10 == 1) {
                jSONObject.put("ServerP2pMode", 2);
            } else if (i10 != 2) {
                jSONObject.put("ServerP2pMode", 0);
            } else {
                jSONObject.put("ServerP2pMode", 1);
            }
            if (kVar.c(str)) {
                we.h.h("NearGattService", "sendAcceptNotify: send broadcast services port information");
                List list = lVar.f4167x;
                if (list != null && !list.isEmpty()) {
                    we.h.b("NearGattService", "Found broadcast services: " + lVar.f4167x);
                    JSONArray jSONArray = new JSONArray();
                    List<Pair> list2 = lVar.f4167x;
                    if (list2 != null) {
                        for (Pair pair : list2) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("serviceName", pair.getFirst());
                            jSONObject2.put("port", ((Number) pair.getSecond()).intValue());
                            jSONArray.put(jSONObject2);
                        }
                    }
                    jSONObject.put("servicePortList", jSONArray);
                }
            }
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            byte[] bytes = string.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            if (lVar.f4156j.contains(bluetoothDevice)) {
                BluetoothGattServer bluetoothGattServer = lVar.e;
                lVar.v(bluetoothDevice, (bluetoothGattServer == null || (service = bluetoothGattServer.getService(c6.f9688a)) == null) ? null : service.getCharacteristic(c6.f9691d), bluetooth.e, bluetooth.f4012h, bytes);
                if (iD != 1 && iD != 8 && iD != 251 && iD != 4 && iD != 5) {
                    switch (iD) {
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                            i8 = device.p;
                            if (i8 != 1) {
                                lVar.f(new e2(lVar, bluetoothDevice, device, i9));
                            } else if (i8 != 2) {
                                we.h.b("NearGattService", "sendAcceptNotify: client mode is not support");
                            } else {
                                lVar.A(bluetoothDevice);
                            }
                            break;
                        default:
                            we.h.b("NearGattService", "sendAcceptNotify: reqType is not support");
                            break;
                    }
                } else {
                    i8 = device.p;
                    if (i8 != 1) {
                        lVar.f(new e2(lVar, bluetoothDevice, device, i9));
                    } else if (i8 != 2) {
                        we.h.b("NearGattService", "sendAcceptNotify: client mode is not support");
                    } else {
                        lVar.A(bluetoothDevice);
                    }
                }
            } else {
                String strN = o.d.n("Device not registered for notifications: ", bluetoothDevice.getAddress(), "NearGattService", "tag", "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strN, "NearGattService", null);
                }
            }
            lVar.f4163s.put(bluetoothDevice.getAddress(), device);
        }
    }

    public final void w(NearDevice device, int i8) throws JSONException {
        int i9;
        BluetoothGattService service;
        Intrinsics.checkNotNullParameter(device, "device");
        l lVar = this.f4028c;
        if (lVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            WirelessDevice wirelessDevice = device.f3896s;
            if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Bluetooth)) {
                return;
            }
            WirelessDevice.Bluetooth bluetooth = (WirelessDevice.Bluetooth) wirelessDevice;
            BluetoothDevice bluetoothDevice = bluetooth.f4011d;
            if (bluetoothDevice == null) {
                Intrinsics.checkNotNullParameter("NearGattService", "tag");
                Intrinsics.checkNotNullParameter("sendRejectNotify: device is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearGattService", "TransConnect:sendRejectNotify: device is null", null);
                    return;
                }
                return;
            }
            JSONObject jSONObject = new JSONObject();
            Map map = h.f4132a;
            int iD = h.d(device.e);
            a aVar = lVar.f;
            String str = device.f3894o;
            if (str == null) {
                str = "1.0";
                String str2 = aVar != null ? "1.0" : null;
                if (str2 != null) {
                    str = str2;
                }
            }
            jSONObject.put("Version", str);
            jSONObject.put("Encrypt", 0);
            jSONObject.put("ReqType", (iD & 255) | 47872);
            jSONObject.put("DeviceId", aVar != null ? aVar.n() : null);
            jSONObject.put("Mac", aVar != null ? aVar.o() : null);
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
            if (lVar.f4156j.contains(bluetoothDevice)) {
                BluetoothGattServer bluetoothGattServer = lVar.e;
                lVar.v(bluetoothDevice, (bluetoothGattServer == null || (service = bluetoothGattServer.getService(c6.f9688a)) == null) ? null : service.getCharacteristic(c6.f9691d), bluetooth.e, bluetooth.f4012h, bytes);
            } else {
                String strN = o.d.n("Device not registered for notifications: ", bluetoothDevice.getAddress(), "NearGattService", "tag", "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strN, "NearGattService", null);
                }
            }
        }
    }

    public final void x(int i8) {
        we.h.b("NearBleManager", "setClientP2pMode: ".concat(i8 == 1 ? "P2P_GC" : "P2P_GO"));
        this.f4032i = i8;
    }

    public final void y() {
        l lVar = this.f4028c;
        if (lVar == null || !lVar.f4153g) {
            return;
        }
        we.h.h("NearGattService", "Stopping GATT server");
        lVar.f(new m.c(lVar, 9));
    }
}
