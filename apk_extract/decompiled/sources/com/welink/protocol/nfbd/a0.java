package com.welink.protocol.nfbd;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.os.Parcelable;
import android.util.Log;
import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearDeviceDataParcel;
import com.welink.protocol.nfbd.TranConnectionController$EventInfo;
import com.welink.protocol.nfbd.TranConnectionController$P2pDeviceInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.Executor;
import k3.lb;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;
import se.g5;
import se.h1;
import se.h4;
import se.i2;
import se.m5;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends we.g {
    public final LinkedHashSet A;
    public int B;
    public final h4 C;
    public boolean D;
    public int E;
    public NearDevice F;
    public i2 G;
    public final ye.d H;
    public final h1 I;
    public final m5 J;
    public final m5 K;
    public final m5 L;
    public final m5 M;
    public final m5 N;
    public final m5 O;
    public final oe.a P;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f4034c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4035d;
    public g5 e;
    public BluetoothDevice f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap f4036g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f4037h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public DeviceInfo f4038i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public BluetoothGatt f4039j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4040k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4041l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4042m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f4043n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4044o;
    public int p;
    public int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4045r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final mg.b0 f4046s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public NearLaptopManager$TransferConnectInfo f4047t;
    public final LinkedHashMap u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinkedHashMap f4048v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final HashMap f4049w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public byte[] f4050x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f4051y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f4052z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Context mContext, h4 h4Var) {
        super(false, "TranFileReceiveControllerHandlerThread");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f4034c = mContext;
        this.f4036g = new LinkedHashMap();
        this.u = new LinkedHashMap();
        this.f4048v = new LinkedHashMap();
        this.f4049w = new HashMap();
        this.f4051y = new Object();
        this.A = new LinkedHashSet();
        this.H = new ye.d(mContext);
        this.f4046s = new mg.b0(mContext);
        this.C = h4Var;
        this.I = new h1(this, 1);
        this.J = new m5(this, 0);
        this.K = new m5(this, 4);
        this.L = new m5(this, 5);
        this.M = new m5(this, 6);
        this.N = new m5(this, 7);
        this.O = new m5(this, 8);
        this.P = new oe.a(this, 2);
    }

    public static final void j(a0 a0Var, byte[] data) {
        a0Var.getClass();
        Intrinsics.checkNotNullParameter(data, "data");
        StringBuilder sb2 = new StringBuilder();
        int length = data.length;
        int iE = 0;
        while (iE < length) {
            byte b9 = data[iE];
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            iE = h0.a.e(new Object[]{Byte.valueOf(b9)}, 1, "0x%02X ", "format(...)", sb2, iE, 1);
        }
        String string = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        we.h.h("TranFileReceiveController", string);
        if (data.length != 1 || data[0] != -1) {
            a0Var.s(data);
            return;
        }
        we.h.h("TranFileReceiveController", "PC CANCEL");
        a0Var.m();
        if (a0Var.A.isEmpty()) {
            return;
        }
        o(a0Var, 0, 0, 4, null, null, 448);
    }

    public static final void k(a0 a0Var, String str, String str2, WifiP2pDevice wifiP2pDevice, String str3, WifiP2pGroup wifiP2pGroup) {
        synchronized (a0Var) {
            try {
                i2 i2Var = a0Var.G;
                NearDevice nearDevice = i2Var != null ? i2Var.f9797g : null;
                if (nearDevice == null && a0Var.F == null) {
                    we.h.j("TranFileReceiveController", "P2p owner device or mNearDevice is null");
                    if (a0Var.u.isEmpty()) {
                        we.h.j("TranFileReceiveController", "Pending connect request is empty, ignore this event");
                        Unit unit = Unit.INSTANCE;
                    } else {
                        h4 h4Var = a0Var.C;
                        if (h4Var != null) {
                            h4Var.C();
                            Unit unit2 = Unit.INSTANCE;
                        }
                    }
                } else {
                    if (a0Var.c(a0Var.K)) {
                        a0Var.h(a0Var.K);
                    }
                    a0Var.f4035d = 4;
                    if (a0Var.A.isEmpty()) {
                        we.h.j("TranFileReceiveController", "Listeners is empty, ignore this event");
                    } else {
                        i2 i2Var2 = a0Var.G;
                        TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = new TranConnectionController$P2pDeviceInfo(i2Var2 != null ? i2Var2.f9793a : null, i2Var2 != null ? i2Var2.f9796d : null, i2Var2 != null ? i2Var2.f9795c : 0, str, str2, 0, 0, wifiP2pDevice, wifiP2pGroup);
                        Iterator it = a0Var.A.iterator();
                        while (it.hasNext()) {
                            ((se.w) it.next()).d(null, wifiP2pDevice, str3, tranConnectionController$P2pDeviceInfo.f3979d, tranConnectionController$P2pDeviceInfo.e, tranConnectionController$P2pDeviceInfo, nearDevice == null ? a0Var.F : nearDevice);
                        }
                        a0Var.u.clear();
                        a0Var.G = null;
                        a0Var.f4035d = 5;
                        a0Var.m();
                    }
                    Unit unit3 = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(final a0 a0Var, final int i8, final int i9, final int i10, final DeviceInfo deviceInfo, NearDeviceDataParcel nearDeviceDataParcel, int i11) {
        NearDevice nearDevice;
        T tQ = 0;
        tQ = 0;
        final NearDeviceDataParcel nearDeviceDataParcel2 = (i11 & 64) != 0 ? null : nearDeviceDataParcel;
        a0Var.getClass();
        final TranConnectionController$EventInfo tranConnectionController$EventInfo = new TranConnectionController$EventInfo(i10, (String) null, i8, 0, 0, 56);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        g5 g5Var = a0Var.e;
        if (g5Var != null && (nearDevice = g5Var.f9750g) != null) {
            tQ = q(nearDevice);
        }
        objectRef.element = tQ;
        final WifiP2pDevice wifiP2pDevice = null;
        final String str = null;
        a0Var.f(new Runnable() { // from class: se.n5
            /* JADX WARN: Code duplicated, block: B:109:0x01b1  */
            /* JADX WARN: Code duplicated, block: B:112:0x01bd  */
            /* JADX WARN: Code duplicated, block: B:116:0x01d0  */
            /* JADX WARN: Code duplicated, block: B:117:0x01d3  */
            /* JADX WARN: Code duplicated, block: B:259:0x01c7 A[SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:262:0x01b7 A[SYNTHETIC] */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v12, types: [android.bluetooth.BluetoothDevice] */
            /* JADX WARN: Type inference failed for: r1v6 */
            @Override // java.lang.Runnable
            public final void run() {
                T t3;
                String str2;
                String str3;
                NearDevice nearDevice2;
                T t8;
                g5 g5Var2;
                NearDevice nearDevice3;
                Map.Entry entry;
                Pair pair;
                NearDevice nearDevice4;
                NearDevice nearDevice5;
                int i12 = i10;
                Ref.ObjectRef objectRef2 = objectRef;
                com.welink.protocol.nfbd.a0 a0Var2 = a0Var;
                NearDeviceDataParcel nearDeviceDataParcel3 = nearDeviceDataParcel2;
                WifiP2pDevice wifiP2pDevice2 = wifiP2pDevice;
                TranConnectionController$EventInfo tranConnectionController$EventInfo2 = tranConnectionController$EventInfo;
                String str4 = str;
                int i13 = i8;
                int i14 = i9;
                DeviceInfo deviceInfo2 = deviceInfo;
                h0.a.u(i12, "Notify Active event: ", "TranFileReceiveController");
                boolean z2 = false;
                String str5 = null;
                if (i12 == 2) {
                    if (objectRef2.element == 0) {
                        Iterator it = a0Var2.u.entrySet().iterator();
                        do {
                            if (!it.hasNext()) {
                                t3 = 0;
                                break;
                            }
                            t3 = ((g2) ((Map.Entry) it.next()).getValue()).f9743a;
                        } while (t3 == 0);
                        objectRef2.element = t3;
                    }
                    TranConnectionController$P2pDeviceInfo tranConnectionController$P2pDeviceInfo = (TranConnectionController$P2pDeviceInfo) (nearDeviceDataParcel3 != null ? (Parcelable) nearDeviceDataParcel3.f3903a : null);
                    Pair pair2 = TuplesKt.to(objectRef2.element, wifiP2pDevice2);
                    HashMap map = a0Var2.f4049w;
                    g5 g5Var3 = a0Var2.e;
                    map.put(g5Var3 != null ? g5Var3.f9746a : null, pair2);
                    for (w wVar : a0Var2.A) {
                        BluetoothDevice bluetoothDevice = (BluetoothDevice) objectRef2.element;
                        if (bluetoothDevice != null && wifiP2pDevice2 != null) {
                            String str6 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.f3979d : str5;
                            String str7 = tranConnectionController$P2pDeviceInfo != null ? tranConnectionController$P2pDeviceInfo.e : str5;
                            g5 g5Var4 = a0Var2.e;
                            wVar.d(bluetoothDevice, wifiP2pDevice2, str4, str6, str7, tranConnectionController$P2pDeviceInfo, g5Var4 != null ? g5Var4.f9750g : str5);
                        }
                        z2 = z2;
                        str5 = null;
                    }
                    a0Var2.u.clear();
                    a0Var2.p(z2);
                    return;
                }
                if (i12 == 3) {
                    BluetoothDevice device = (BluetoothDevice) objectRef2.element;
                    if (device != null) {
                        g5 g5Var5 = a0Var2.e;
                        NearDevice nearDevice6 = g5Var5 != null ? g5Var5.f9750g : null;
                        String str8 = deviceInfo2 != null ? deviceInfo2.f4223d : null;
                        String str9 = a0Var2.f4041l;
                        String str10 = a0Var2.f4042m;
                        String str11 = a0Var2.f4043n;
                        int i15 = a0Var2.f4044o;
                        if (nearDevice6 == null || (str2 = nearDevice6.f3884b) == null) {
                            str2 = "Laptop";
                        }
                        String str12 = str2;
                        String str13 = deviceInfo2 != null ? deviceInfo2.f4223d : null;
                        byte b9 = UByte.MAX_VALUE;
                        byte b10 = deviceInfo2 != null ? deviceInfo2.f4220a : (byte) 255;
                        if (deviceInfo2 != null) {
                            b9 = deviceInfo2.f4221b;
                        }
                        byte b11 = b9;
                        if (deviceInfo2 == null || (str3 = deviceInfo2.f4222c) == null) {
                            str3 = "0001";
                        }
                        ConnectRequest connectRequest = new ConnectRequest("1.0", 0, 0, str8, 0, null, 0L, str9, str10, str11, i15, 0, i14, i13, 2, str12, str13, b10, b11, str3, deviceInfo2 != null ? deviceInfo2.f4226j : 0, deviceInfo2 != null ? deviceInfo2.f4227k : 0, 0, null, CollectionsKt.listOf((Object[]) new String[]{"2.4G", "5G", "P2P"}), null, null, 503316480);
                        for (w wVar2 : a0Var2.A) {
                            switch (wVar2.f10039a) {
                                case 0:
                                    Intrinsics.checkNotNullParameter(device, "device");
                                    Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                                    we.h.b("NearBleManager", "onConnectRequestReceived: " + device + ", " + connectRequest);
                                    break;
                                case 1:
                                    Intrinsics.checkNotNullParameter(device, "device");
                                    Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                                    we.h.b("NearBluetoothManager", "onConnectRequestReceived: " + device + ", " + connectRequest);
                                    break;
                                default:
                                    Intrinsics.checkNotNullParameter(device, "device");
                                    Intrinsics.checkNotNullParameter(connectRequest, "connectRequest");
                                    we.h.b("NearLaptopManager", "onConnectRequestReceived: " + device);
                                    for (Pair pair3 : ((a4) wVar2.f10040b).f9646h) {
                                        ((Executor) pair3.getFirst()).execute(new u(pair3, device, connectRequest, nearDevice6, 4));
                                    }
                                    break;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (i12 != 4) {
                    if (i12 == 10) {
                        we.h.h("TranFileReceiveController", "Notify Stop Scan event, ignore this event");
                        return;
                    }
                    if (i12 != 18) {
                        return;
                    }
                    for (w wVar3 : a0Var2.A) {
                        g5 g5Var6 = a0Var2.e;
                        if (g5Var6 != null && (nearDevice5 = g5Var6.f9750g) != null) {
                            T t10 = objectRef2.element;
                            if (t10 != 0) {
                                Intrinsics.checkNotNull(t10);
                                wVar3.a((BluetoothDevice) t10, nearDevice5);
                            } else {
                                Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                                Intrinsics.checkNotNullParameter("Bluetooth device is null, ignore it", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("TranFileReceiveController", "TransConnect:Bluetooth device is null, ignore it", null);
                                }
                            }
                        }
                    }
                    return;
                }
                int i16 = tranConnectionController$EventInfo2.f3966c;
                if (i16 != -3 && i16 != -2 && i16 != -1 && i16 != 0) {
                    if (i16 == 1 || i16 == 3) {
                        for (w wVar4 : a0Var2.A) {
                            t8 = objectRef2.element;
                            if (t8 != 0) {
                                Intrinsics.checkNotNull(t8);
                                BluetoothDevice bluetoothDevice2 = (BluetoothDevice) t8;
                                g5Var2 = a0Var2.e;
                                if (g5Var2 != null) {
                                    nearDevice3 = g5Var2.f9750g;
                                } else {
                                    nearDevice3 = null;
                                }
                                wVar4.b(tranConnectionController$EventInfo2.f3966c, bluetoothDevice2, nearDevice3);
                            }
                        }
                    } else if (i16 != 24) {
                        if (i16 == 5) {
                            a0Var2.getClass();
                            a0Var2.f(new m5(a0Var2, 3));
                            a0Var2.u.clear();
                            if (a0Var2.f4049w.isEmpty()) {
                                we.h.j("TranFileReceiveController", "Connected devices map is empty, p2p connect failed?");
                            } else {
                                synchronized (a0Var2.f4049w) {
                                    try {
                                        Iterator it2 = a0Var2.f4049w.entrySet().iterator();
                                        do {
                                            if (!it2.hasNext()) {
                                                entry = null;
                                                break;
                                            }
                                            entry = (Map.Entry) it2.next();
                                        } while (entry == null);
                                        for (w wVar5 : a0Var2.A) {
                                            if (objectRef2.element != 0) {
                                                if (((entry == null || (pair = (Pair) entry.getValue()) == null) ? null : (WifiP2pDevice) pair.getSecond()) != null) {
                                                    BluetoothDevice bluetoothDevice3 = (BluetoothDevice) objectRef2.element;
                                                    Object second = ((Pair) entry.getValue()).getSecond();
                                                    Intrinsics.checkNotNull(second);
                                                    WifiP2pDevice wifiP2pDevice3 = (WifiP2pDevice) second;
                                                    g5 g5Var7 = a0Var2.e;
                                                    wVar5.e(bluetoothDevice3, wifiP2pDevice3, true, g5Var7 != null ? g5Var7.f9750g : null);
                                                }
                                            }
                                        }
                                        g5 g5Var8 = a0Var2.e;
                                        if ((g5Var8 != null ? g5Var8.f9746a : null) != null) {
                                            a0Var2.f4049w.remove(g5Var8 != null ? g5Var8.f9746a : null);
                                        } else {
                                            a0Var2.f4049w.clear();
                                            Unit unit = Unit.INSTANCE;
                                        }
                                    } catch (Throwable th2) {
                                        throw th2;
                                    }
                                }
                            }
                            LinkedHashMap linkedHashMap = a0Var2.f4036g;
                            BluetoothDevice bluetoothDevice4 = (BluetoothDevice) objectRef2.element;
                            TypeIntrinsics.asMutableMap(linkedHashMap).remove(bluetoothDevice4 != null ? bluetoothDevice4.getAddress() : null);
                            return;
                        }
                        if (i16 != 6) {
                            switch (i16) {
                                case 9:
                                case 10:
                                case 12:
                                    while (r0.hasNext()) {
                                        t8 = objectRef2.element;
                                        if (t8 != 0) {
                                            Intrinsics.checkNotNull(t8);
                                            BluetoothDevice bluetoothDevice5 = (BluetoothDevice) t8;
                                            g5Var2 = a0Var2.e;
                                            if (g5Var2 != null) {
                                                nearDevice3 = g5Var2.f9750g;
                                            } else {
                                                nearDevice3 = null;
                                            }
                                            wVar4.b(tranConnectionController$EventInfo2.f3966c, bluetoothDevice5, nearDevice3);
                                        }
                                    }
                                    break;
                                case 14:
                                    for (w wVar6 : a0Var2.A) {
                                        g5 g5Var9 = a0Var2.e;
                                        if (g5Var9 != null && (nearDevice4 = g5Var9.f9750g) != null) {
                                            T t11 = objectRef2.element;
                                            if (t11 != 0) {
                                                Intrinsics.checkNotNull(t11);
                                                wVar6.b(tranConnectionController$EventInfo2.f3966c, (BluetoothDevice) t11, nearDevice4);
                                            } else {
                                                Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                                                Intrinsics.checkNotNullParameter("Bluetooth device is null, ignore it", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("TranFileReceiveController", "TransConnect:Bluetooth device is null, ignore it", null);
                                                }
                                            }
                                        }
                                    }
                                    LinkedHashMap linkedHashMap2 = a0Var2.f4036g;
                                    BluetoothDevice bluetoothDevice6 = (BluetoothDevice) objectRef2.element;
                                    TypeIntrinsics.asMutableMap(linkedHashMap2).remove(bluetoothDevice6 != null ? bluetoothDevice6.getAddress() : null);
                                    return;
                            }
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                    return;
                }
                for (w wVar7 : a0Var2.A) {
                    g5 g5Var10 = a0Var2.e;
                    if (g5Var10 != null && (nearDevice2 = g5Var10.f9750g) != null) {
                        T t12 = objectRef2.element;
                        if (t12 != 0) {
                            Intrinsics.checkNotNull(t12);
                            wVar7.b(tranConnectionController$EventInfo2.f3966c, (BluetoothDevice) t12, nearDevice2);
                        } else {
                            Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
                            Intrinsics.checkNotNullParameter("Bluetooth device is null, ignore it", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("TranFileReceiveController", "TransConnect:Bluetooth device is null, ignore it", null);
                            }
                        }
                    }
                }
                LinkedHashMap linkedHashMap3 = a0Var2.f4036g;
                BluetoothDevice bluetoothDevice7 = (BluetoothDevice) objectRef2.element;
                TypeIntrinsics.asMutableMap(linkedHashMap3).remove(bluetoothDevice7 != null ? bluetoothDevice7.getAddress() : null);
            }
        });
    }

    public static BluetoothDevice q(NearDevice nearDevice) {
        WirelessDevice wirelessDevice = nearDevice.f3896s;
        if (wirelessDevice instanceof WirelessDevice.Bluetooth) {
            return ((WirelessDevice.Bluetooth) wirelessDevice).f4011d;
        }
        return null;
    }

    public final void l(int i8) {
        int i9;
        h0.a.u(i8, "Receive cleanup, ", "TranFileReceiveController");
        int i10 = 0;
        if (i8 <= 3) {
            int i11 = this.f4035d;
            if (i11 > 2) {
                m5 m5Var = this.K;
                if (c(m5Var)) {
                    h(m5Var);
                }
                h4 h4Var = this.C;
                if (h4Var != null) {
                    h4Var.o();
                }
                g(WorkRequest.MIN_BACKOFF_MILLIS, this.L);
            } else if (i11 > 0) {
                if (i8 == 0) {
                    m();
                    g(500L, this.M);
                } else {
                    p(false);
                }
            }
            this.f4035d = 0;
        } else if (i8 == 4) {
            we.h.h("TranFileReceiveController", "Rcv Receive Adapter BT OFF Bypass event");
        } else {
            we.h.h("TranFileReceiveController", "Rcv Receive Unknown Cleanup Event");
        }
        if (this.A.isEmpty()) {
            return;
        }
        if (i8 != 0) {
            if (i8 == 1) {
                i10 = 10;
            } else if (i8 == 2) {
                i9 = 3;
            } else if (i8 == 3) {
                i10 = 9;
            } else if (i8 == 4) {
                i10 = 12;
            }
            i9 = i10;
        } else {
            i9 = 1;
        }
        o(this, i9, 0, 4, null, null, 384);
    }

    public final void m() {
        we.h.h("TranFileReceiveController", "closeBleConnect");
        this.f4045r = false;
        if (this.f4035d < 3) {
            this.f4035d = 0;
            h(this.K);
        }
        this.f = null;
        this.f4047t = null;
        this.f4036g.clear();
        p(true);
    }

    public final void n() {
        m();
        if (this.A.isEmpty()) {
            return;
        }
        o(this, -2, 0, 4, this.f4038i, null, 384);
    }

    public final void p(boolean z2) {
        synchronized (this.f4051y) {
            try {
                BluetoothGatt bluetoothGatt = this.f4039j;
                if (bluetoothGatt != null && bluetoothGatt != null) {
                    bluetoothGatt.disconnect();
                }
                if (z2) {
                    BluetoothGatt bluetoothGatt2 = this.f4039j;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.close();
                    }
                    this.f4039j = null;
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean r(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        BluetoothDevice bluetoothDeviceQ = q(device);
        if (bluetoothDeviceQ != null) {
            return this.f4036g.get(bluetoothDeviceQ.getAddress()) != null;
        }
        Intrinsics.checkNotNullParameter("TranFileReceiveController", "tag");
        Intrinsics.checkNotNullParameter("bluetoothDevice: device is null", "mes");
        if (lb.f6529c >= 1) {
            Log.e("TranFileReceiveController", "TransConnect:bluetoothDevice: device is null", null);
        }
        return false;
    }

    public final void s(byte[] bArr) {
        String str;
        NearDeviceDataParcel nearDeviceDataParcel;
        JSONObject jSONObject = new JSONObject(new String(bArr, Charsets.UTF_8));
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        we.h.h("TranFileReceiveController", string);
        this.f4041l = jSONObject.getString("Ssid");
        this.f4042m = jSONObject.getString("Pwd");
        this.p = jSONObject.getInt("FilePort");
        this.q = jSONObject.getInt("MessagePort");
        if (!jSONObject.isNull("Bssid")) {
            this.f4043n = jSONObject.getString("Bssid");
        }
        if (!jSONObject.isNull("Chan")) {
            int i8 = jSONObject.getInt("Chan");
            this.f4044o = i8;
            if (i8 < 1 || ((15 <= i8 && i8 < 36) || i8 > 165)) {
                this.f4044o = 0;
                we.h.j("TranFileReceiveController", "Invalid Channel number, force set to 0");
            }
        }
        String string2 = !jSONObject.isNull("DeviceName") ? jSONObject.getString("DeviceName") : null;
        String str2 = this.f4037h;
        if (str2 != null && str2.length() != 0) {
            string2 = this.f4037h;
        } else if ((string2 == null || string2.length() == 0) && ((str = this.f4037h) == null || str.length() == 0)) {
            string2 = "PC";
        }
        DeviceInfo deviceInfo = this.f4038i;
        if (deviceInfo != null) {
            we.h.b("TranFileReceiveController", "DeviceInfo Match Brand: " + Byte.valueOf(deviceInfo.f4221b));
            DeviceInfo deviceInfo2 = this.f4038i;
            Byte bValueOf = deviceInfo2 != null ? Byte.valueOf(deviceInfo2.f4221b) : null;
            if (bValueOf != null && bValueOf.byteValue() == 2) {
                we.h.b("TranFileReceiveController", "DeviceInfo Match ITEL Brand");
                Intrinsics.checkNotNull(string2);
                DeviceInfo deviceInfo3 = this.f4038i;
                Intrinsics.checkNotNull(deviceInfo3);
                String str3 = deviceInfo3.f4223d;
            } else if (bValueOf != null && bValueOf.byteValue() == 3) {
                we.h.b("TranFileReceiveController", "DeviceInfo Match TECNO Brand");
                Intrinsics.checkNotNull(string2);
                DeviceInfo deviceInfo4 = this.f4038i;
                Intrinsics.checkNotNull(deviceInfo4);
                String str4 = deviceInfo4.f4223d;
            } else if (bValueOf == null || bValueOf.byteValue() != 4) {
                we.h.b("TranFileReceiveController", "DeviceInfo Match Unknown Brand");
                Intrinsics.checkNotNull(string2);
                DeviceInfo deviceInfo5 = this.f4038i;
                Intrinsics.checkNotNull(deviceInfo5);
                String str5 = deviceInfo5.f4223d;
            } else {
                we.h.b("TranFileReceiveController", "DeviceInfo Match INFINIX Brand");
                Intrinsics.checkNotNull(string2);
                DeviceInfo deviceInfo6 = this.f4038i;
                Intrinsics.checkNotNull(deviceInfo6);
                String str6 = deviceInfo6.f4223d;
            }
        }
        LinkedHashMap linkedHashMap = this.f4036g;
        BluetoothDevice bluetoothDevice = this.f;
        ScanResult scanResult = (ScanResult) linkedHashMap.get(bluetoothDevice != null ? bluetoothDevice.getAddress() : null);
        if (scanResult != null) {
            g5 g5Var = this.e;
            nearDeviceDataParcel = new NearDeviceDataParcel(scanResult, g5Var != null ? g5Var.f9750g : null);
        } else {
            nearDeviceDataParcel = null;
        }
        if (this.A.isEmpty()) {
            return;
        }
        o(this, this.p, this.q, 3, this.f4038i, nearDeviceDataParcel, 384);
    }
}
