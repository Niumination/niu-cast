package mc;

import ag.q;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;
import androidx.core.content.ContextCompat;
import bb.s;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.nfbd.NearNetworkElement;
import com.welink.protocol.nfbd.WirelessDevice;
import com.welink.protocol.nfbd.c0;
import com.welink.protocol.nfbd.g;
import com.welink.protocol.nfbd.m;
import com.welink.protocol.nfbd.y;
import com.welink.protocol.nfbd.z;
import hj.p;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.gc;
import k3.lb;
import k3.pb;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import pe.e;
import pe.f;
import se.b1;
import se.b5;
import se.b6;
import se.h5;
import se.k6;
import se.q4;
import se.r4;
import se.r6;
import se.s6;
import se.u6;
import se.w6;
import se.x6;
import se.y4;
import se.y6;
import se.z0;
import we.h;
import we.i;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static NearDevice f7959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static lc.a f7960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Function2 f7961d;
    public static Function2 e;
    public static Function2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static q f7962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q f7963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ag.b f7964i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static NearNetworkElement.Wifi f7966k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static ag.b f7968m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static boolean f7969n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f7958a = LazyKt.lazy(new s(21));

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HashMap f7965j = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AtomicBoolean f7967l = new AtomicBoolean(false);

    static {
        a aVar = new a(true, "PCConnect");
        q5.a aVar2 = new q5.a();
        b1 b1VarE = e();
        i iVar = new i(aVar);
        b1VarE.getClass();
        synchronized (b1VarE.f9653a) {
            int iIdentityHashCode = System.identityHashCode(aVar2);
            if (b1VarE.f9653a.contains(iIdentityHashCode)) {
                Intrinsics.checkNotNullParameter("listener already registered", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("welinkBLE", "listener already registered", null);
                }
            } else {
                b1VarE.f9653a.put(iIdentityHashCode, new z0(iVar, aVar2));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public static final void a(NearDevice nearDevice) {
        int i8;
        String str = nearDevice.f3885c;
        if (str == null || (i8 = nearDevice.f3890k) == 11 || i8 == 10) {
            return;
        }
        f7965j.put(str, nearDevice);
        lc.a aVar = f7960c;
        if (aVar != null) {
            aVar.invoke(nearDevice, Boolean.FALSE);
        }
    }

    public static void b() {
        z zVar;
        NearDevice nearDevice = f7959b;
        if (nearDevice != null) {
            y yVar = e().f9655c;
            if (!yVar.f4196j.contains(nearDevice) && !yVar.f4197k.contains(nearDevice)) {
                Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                Intrinsics.checkNotNullParameter("Not found any device in list", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("SmartConnectWrapper", "TransConnect:Not found any device in list", null);
                    return;
                }
                return;
            }
            Integer num = nearDevice.f3898v;
            if ((num == null || num.intValue() != 1003) && nearDevice.f3900x != 1011 && nearDevice.f3899w != 1007) {
                h.b("SmartConnectWrapper", "cancelConnect: Device is not connecting, ignore");
                return;
            }
            int i8 = nearDevice.e;
            if (i8 != 0 && i8 != 1 && i8 != 4 && i8 != 5 && i8 != 8 && i8 != 251) {
                switch (i8) {
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                        break;
                    default:
                        h.b("SmartConnectWrapper", "Not implemented yet");
                        break;
                }
            }
            c0 c0Var = yVar.f4191c;
            if (c0Var == null || (zVar = c0Var.f4090c) == null) {
                return;
            }
            nearDevice.C(zVar, new r6(c0Var, 2));
        }
    }

    /* JADX WARN: Code duplicated, block: B:127:0x0203 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #0 {, blocks: (B:22:0x009b, B:24:0x00a0, B:31:0x00ae, B:33:0x00b2, B:38:0x00be, B:47:0x00d1, B:48:0x00d4, B:50:0x00e6, B:51:0x00eb, B:56:0x00f4, B:60:0x00fc, B:61:0x00ff, B:63:0x0111, B:66:0x0118, B:68:0x011e, B:70:0x0130, B:73:0x0137, B:75:0x013b, B:78:0x0148, B:80:0x014e, B:82:0x0160, B:85:0x0167, B:87:0x016b, B:90:0x0178, B:92:0x017c, B:95:0x0189, B:99:0x0191, B:100:0x0194, B:102:0x01a6, B:105:0x01ae, B:107:0x01bb, B:110:0x01c5, B:112:0x01c9, B:115:0x01d5, B:117:0x01db, B:119:0x01ed, B:122:0x01f5, B:124:0x01f9, B:127:0x0203, B:129:0x020e, B:132:0x0219, B:133:0x022c), top: B:143:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:129:0x020e A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #0 {, blocks: (B:22:0x009b, B:24:0x00a0, B:31:0x00ae, B:33:0x00b2, B:38:0x00be, B:47:0x00d1, B:48:0x00d4, B:50:0x00e6, B:51:0x00eb, B:56:0x00f4, B:60:0x00fc, B:61:0x00ff, B:63:0x0111, B:66:0x0118, B:68:0x011e, B:70:0x0130, B:73:0x0137, B:75:0x013b, B:78:0x0148, B:80:0x014e, B:82:0x0160, B:85:0x0167, B:87:0x016b, B:90:0x0178, B:92:0x017c, B:95:0x0189, B:99:0x0191, B:100:0x0194, B:102:0x01a6, B:105:0x01ae, B:107:0x01bb, B:110:0x01c5, B:112:0x01c9, B:115:0x01d5, B:117:0x01db, B:119:0x01ed, B:122:0x01f5, B:124:0x01f9, B:127:0x0203, B:129:0x020e, B:132:0x0219, B:133:0x022c), top: B:143:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00f4 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #0 {, blocks: (B:22:0x009b, B:24:0x00a0, B:31:0x00ae, B:33:0x00b2, B:38:0x00be, B:47:0x00d1, B:48:0x00d4, B:50:0x00e6, B:51:0x00eb, B:56:0x00f4, B:60:0x00fc, B:61:0x00ff, B:63:0x0111, B:66:0x0118, B:68:0x011e, B:70:0x0130, B:73:0x0137, B:75:0x013b, B:78:0x0148, B:80:0x014e, B:82:0x0160, B:85:0x0167, B:87:0x016b, B:90:0x0178, B:92:0x017c, B:95:0x0189, B:99:0x0191, B:100:0x0194, B:102:0x01a6, B:105:0x01ae, B:107:0x01bb, B:110:0x01c5, B:112:0x01c9, B:115:0x01d5, B:117:0x01db, B:119:0x01ed, B:122:0x01f5, B:124:0x01f9, B:127:0x0203, B:129:0x020e, B:132:0x0219, B:133:0x022c), top: B:143:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0178 A[Catch: all -> 0x00f1, TRY_ENTER, TryCatch #0 {, blocks: (B:22:0x009b, B:24:0x00a0, B:31:0x00ae, B:33:0x00b2, B:38:0x00be, B:47:0x00d1, B:48:0x00d4, B:50:0x00e6, B:51:0x00eb, B:56:0x00f4, B:60:0x00fc, B:61:0x00ff, B:63:0x0111, B:66:0x0118, B:68:0x011e, B:70:0x0130, B:73:0x0137, B:75:0x013b, B:78:0x0148, B:80:0x014e, B:82:0x0160, B:85:0x0167, B:87:0x016b, B:90:0x0178, B:92:0x017c, B:95:0x0189, B:99:0x0191, B:100:0x0194, B:102:0x01a6, B:105:0x01ae, B:107:0x01bb, B:110:0x01c5, B:112:0x01c9, B:115:0x01d5, B:117:0x01db, B:119:0x01ed, B:122:0x01f5, B:124:0x01f9, B:127:0x0203, B:129:0x020e, B:132:0x0219, B:133:0x022c), top: B:143:0x009b }] */
    /* JADX WARN: Code duplicated, block: B:92:0x017c A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #0 {, blocks: (B:22:0x009b, B:24:0x00a0, B:31:0x00ae, B:33:0x00b2, B:38:0x00be, B:47:0x00d1, B:48:0x00d4, B:50:0x00e6, B:51:0x00eb, B:56:0x00f4, B:60:0x00fc, B:61:0x00ff, B:63:0x0111, B:66:0x0118, B:68:0x011e, B:70:0x0130, B:73:0x0137, B:75:0x013b, B:78:0x0148, B:80:0x014e, B:82:0x0160, B:85:0x0167, B:87:0x016b, B:90:0x0178, B:92:0x017c, B:95:0x0189, B:99:0x0191, B:100:0x0194, B:102:0x01a6, B:105:0x01ae, B:107:0x01bb, B:110:0x01c5, B:112:0x01c9, B:115:0x01d5, B:117:0x01db, B:119:0x01ed, B:122:0x01f5, B:124:0x01f9, B:127:0x0203, B:129:0x020e, B:132:0x0219, B:133:0x022c), top: B:143:0x009b }] */
    public static void c() {
        z zVar;
        int i8;
        z zVar2;
        int i9 = 8;
        String log = "disconnect mCurDevice:" + f7959b;
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), log);
        }
        NearDevice device = f7959b;
        if (device != null) {
            y yVar = e().f9655c;
            if (yVar.z()) {
                boolean z2 = true;
                Boolean boolValueOf = null;
                if (!yVar.f4196j.contains(device) && !yVar.f4197k.contains(device)) {
                    Intrinsics.checkNotNullParameter("SmartConnectWrapper", "tag");
                    Intrinsics.checkNotNullParameter("Device not found, ignore", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("SmartConnectWrapper", "TransConnect:Device not found, ignore", null);
                        return;
                    }
                    return;
                }
                h.b("SmartConnectWrapper", "Disconnecting Device, " + device.f3883a + ", " + device.f3884b);
                c0 c0Var = yVar.f4191c;
                if (c0Var != null) {
                    sb.a aVar = yVar.p;
                    Intrinsics.checkNotNullParameter(device, "device");
                    synchronized (c0Var.f4088a) {
                        Integer num = device.f3898v;
                        if ((num != null ? num.intValue() : -1) == -1) {
                            h.b("TransSmartConnect", "TransSmartConnect, Device start disconnect busy, state: " + c0.c(c0Var.f) + ", wirelessType: " + device.f3890k);
                            z2 = false;
                        } else {
                            Integer num2 = device.f3898v;
                            int iIntValue = num2 != null ? num2.intValue() : -1;
                            if (iIntValue == 1005 || iIntValue == 1013) {
                                h.b("TransSmartConnect", "TransSmartConnect: Device is disconnecting, state: " + iIntValue);
                                h.b("TransSmartConnect", "TransSmartConnect, Device start disconnect busy, state: " + c0.c(c0Var.f) + ", wirelessType: " + device.f3890k);
                                z2 = false;
                            } else {
                                int i10 = device.e;
                                if (i10 == 0) {
                                    int i11 = device.f3890k;
                                    if (i11 == 0 || i11 == 1) {
                                        h.h("TransSmartConnect", "Start Disconnect Device");
                                        zVar = c0Var.f4090c;
                                        if (zVar != null) {
                                            device.C(zVar, new s6(c0Var, aVar, 6));
                                        }
                                    } else if (i11 != 14) {
                                        switch (i11) {
                                            case 10:
                                            case 11:
                                                h.h("TransSmartConnect", "Start Disconnect P2P Device");
                                                if (!(device.f3896s instanceof WirelessDevice.P2p)) {
                                                    h.c("TransSmartConnect", "Error: Invalid P2P Device", null);
                                                    z2 = false;
                                                } else {
                                                    z zVar3 = c0Var.f4090c;
                                                    if (zVar3 != null) {
                                                        device.C(zVar3, new s6(c0Var, aVar, 7));
                                                    }
                                                }
                                                break;
                                            case 12:
                                                h.h("TransSmartConnect", "Start Disconnect Device");
                                                zVar = c0Var.f4090c;
                                                if (zVar != null) {
                                                    device.C(zVar, new s6(c0Var, aVar, 6));
                                                }
                                                break;
                                            default:
                                                Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                                Intrinsics.checkNotNullParameter("Error: Invalid wireless type", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("TransSmartConnect", "TransConnect:Error: Invalid wireless type", null);
                                                }
                                                z2 = false;
                                                break;
                                        }
                                    } else if (device.f3896s instanceof WirelessDevice.Wlan) {
                                        z zVar4 = c0Var.f4090c;
                                        if (zVar4 != null) {
                                            device.C(zVar4, new s6(c0Var, aVar, i9));
                                        }
                                    } else {
                                        Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                        Intrinsics.checkNotNullParameter("Error: Invalid Wlan Device", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("TransSmartConnect", "TransConnect:Error: Invalid Wlan Device", null);
                                        }
                                        z2 = false;
                                    }
                                } else if (i10 != 1 && i10 != 4 && i10 != 5 && i10 != 8 && i10 != 251) {
                                    switch (i10) {
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                            i8 = device.f3890k;
                                            if (i8 == 0) {
                                                zVar2 = c0Var.f4090c;
                                                if (zVar2 != null) {
                                                    device.C(zVar2, new s6(c0Var, aVar, 9));
                                                }
                                            } else {
                                                zVar2 = c0Var.f4090c;
                                                if (zVar2 != null) {
                                                    device.C(zVar2, new s6(c0Var, aVar, 9));
                                                }
                                            }
                                            break;
                                        default:
                                            Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                            Intrinsics.checkNotNullParameter("Unsupported ", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("TransSmartConnect", "TransConnect:Unsupported ", null);
                                            }
                                            Unit unit = Unit.INSTANCE;
                                            z2 = false;
                                            break;
                                    }
                                } else {
                                    i8 = device.f3890k;
                                    if (i8 == 0 || i8 == 1) {
                                        zVar2 = c0Var.f4090c;
                                        if (zVar2 != null) {
                                            device.C(zVar2, new s6(c0Var, aVar, 9));
                                        }
                                    } else if (i8 != 14) {
                                        switch (i8) {
                                            case 10:
                                            case 11:
                                                if (!(device.f3896s instanceof WirelessDevice.P2p)) {
                                                    Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                                    Intrinsics.checkNotNullParameter("Error: Invalid P2P Device", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("TransSmartConnect", "TransConnect:Error: Invalid P2P Device", null);
                                                    }
                                                    z2 = false;
                                                } else {
                                                    z zVar5 = c0Var.f4090c;
                                                    if (zVar5 != null) {
                                                        device.C(zVar5, new s6(c0Var, aVar, 10));
                                                    }
                                                }
                                                break;
                                            case 12:
                                                zVar2 = c0Var.f4090c;
                                                if (zVar2 != null) {
                                                    device.C(zVar2, new s6(c0Var, aVar, 9));
                                                }
                                                break;
                                            default:
                                                Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                                Intrinsics.checkNotNullParameter("Error: Invalid wireless type", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("TransSmartConnect", "TransConnect:Error: Invalid wireless type", null);
                                                }
                                                z2 = false;
                                                break;
                                        }
                                    } else if (device.f3896s instanceof WirelessDevice.Wlan) {
                                        z zVar6 = c0Var.f4090c;
                                        if (zVar6 != null) {
                                            device.C(zVar6, new s6(c0Var, aVar, 11));
                                        }
                                    } else {
                                        Intrinsics.checkNotNullParameter("TransSmartConnect", "tag");
                                        Intrinsics.checkNotNullParameter("Error: Invalid Wlan Device", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("TransSmartConnect", "TransConnect:Error: Invalid Wlan Device", null);
                                        }
                                        z2 = false;
                                    }
                                }
                            }
                        }
                    }
                    boolValueOf = Boolean.valueOf(z2);
                }
                if (Intrinsics.areEqual(boolValueOf, Boolean.FALSE)) {
                    h.b("SmartConnectWrapper", "Disconnect Device Failed, " + device.f3883a + ", " + device.f3884b);
                }
            }
        }
    }

    public static void d() {
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("enableSmartConnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), "enableSmartConnect");
        }
        b1 b1VarE = e();
        b1VarE.getClass();
        h.b("NearConnectionManager", "enableSmartConnect async mode");
        y yVar = b1VarE.f9655c;
        c0 c0Var = yVar.f4191c;
        Integer numValueOf = c0Var != null ? Integer.valueOf(c0Var.d()) : null;
        if (numValueOf != null && numValueOf.intValue() == 0) {
            h.b("SmartConnectWrapper", "Smart Connect is not enabled, enable it");
            yVar.T();
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 1) {
            h.b("SmartConnectWrapper", "Smart Connect is already enabled, ignore");
            return;
        }
        if (numValueOf != null && numValueOf.intValue() == 2) {
            h.b("SmartConnectWrapper", "Smart Connect is already enabled, but the bt off ignore");
        } else if (numValueOf != null && numValueOf.intValue() == 3) {
            h.b("SmartConnectWrapper", "Smart Connect is already enabled, but the wifi off ignore");
        } else {
            h.b("SmartConnectWrapper", "Service is not enabled, ignore");
        }
    }

    public static b1 e() {
        return (b1) f7958a.getValue();
    }

    public static void f() {
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("releaseConnCallback", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), "releaseConnCallback");
        }
        f7961d = null;
        e = null;
        f = null;
    }

    public static void g() {
        f7967l.set(false);
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("reset isPcRequestConn", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), "reset isPcRequestConn");
        }
    }

    public static void h(Function2 function2, Function2 function3, Function2 function4) {
        f7961d = function2;
        e = function3;
        f = function4;
        String log = "setConnCallback, connectCallback:" + function2 + ", disconnectCallback:" + function3 + ", rejectCallback:" + function4;
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("TranConnectManager"), log);
        }
    }

    /* JADX WARN: Code duplicated, block: B:117:0x0262  */
    /* JADX WARN: Code duplicated, block: B:120:0x0268  */
    /* JADX WARN: Code duplicated, block: B:123:0x027f  */
    /* JADX WARN: Code duplicated, block: B:125:0x0294  */
    /* JADX WARN: Code duplicated, block: B:127:0x029d  */
    /* JADX WARN: Code duplicated, block: B:137:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:158:0x035c  */
    /* JADX WARN: Code duplicated, block: B:228:0x04a3  */
    /* JADX WARN: Code duplicated, block: B:230:0x04af  */
    /* JADX WARN: Code duplicated, block: B:280:0x02a5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static void i(lc.a scanCallback) {
        Throwable th2;
        boolean zIsDiscovering;
        boolean zIsDiscovering2;
        Byte bValueOf;
        Boolean boolValueOf;
        r4 r4Var;
        z zVar;
        lc.a scanResultCallBack;
        g gVar;
        Intent intent;
        g gVar2;
        h5 h5Var;
        Boolean boolValueOf2;
        h5 h5Var2;
        h5 h5Var3;
        int i8;
        int i9 = 0;
        int i10 = 1;
        Intrinsics.checkNotNullParameter(scanCallback, "scanCallback");
        f7960c = scanCallback;
        if (ContextCompat.checkSelfPermission(pb.a(), "android.permission.BLUETOOTH_SCAN") != 0 || ContextCompat.checkSelfPermission(pb.a(), "android.permission.BLUETOOTH_CONNECT") != 0) {
            return;
        }
        Intrinsics.checkNotNullParameter("TranConnectManager", "tag");
        Intrinsics.checkNotNullParameter("startScan>", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("TranConnectManager"), "startScan>");
        }
        b1 b1VarE = e();
        int iM254constructorimpl = UInt.m254constructorimpl(65);
        y yVar = b1VarE.f9655c;
        if (!yVar.z()) {
            h.b("SmartConnectWrapper", "Smart Config is not enabled, ignore");
            return;
        }
        boolean z2 = UInt.m254constructorimpl(iM254constructorimpl & 1) != UInt.m254constructorimpl(0);
        boolean z3 = UInt.m254constructorimpl(iM254constructorimpl & 2) != UInt.m254constructorimpl(0);
        boolean z5 = UInt.m254constructorimpl(iM254constructorimpl & 4) != UInt.m254constructorimpl(0);
        boolean z10 = UInt.m254constructorimpl(iM254constructorimpl & 8) != UInt.m254constructorimpl(0);
        boolean z11 = UInt.m254constructorimpl(iM254constructorimpl & 16) != UInt.m254constructorimpl(0);
        boolean z12 = UInt.m254constructorimpl(iM254constructorimpl & 32) != UInt.m254constructorimpl(0);
        boolean z13 = UInt.m254constructorimpl(iM254constructorimpl & 64) != UInt.m254constructorimpl(0);
        boolean z14 = UInt.m254constructorimpl(iM254constructorimpl & 256) != UInt.m254constructorimpl(0);
        boolean z15 = UInt.m254constructorimpl(iM254constructorimpl & 128) != UInt.m254constructorimpl(0);
        ConcurrentHashMap.KeySetView keySetView = yVar.f4195i.e;
        keySetView.clear();
        int i11 = 0;
        while (true) {
            int i12 = 11;
            if (i11 >= 11) {
                h.b("NearDeviceTableFusion", "Discovery Service List: " + keySetView);
                if (z2) {
                    h.b("SmartConnectWrapper", "Start BLE Discovery");
                    byte[] service = y.w(1, false, true);
                    int i13 = 0;
                    while (true) {
                        if (i13 >= i12) {
                            bValueOf = null;
                        } else {
                            byte b9 = service[i13];
                            if (b9 != -1) {
                                bValueOf = Byte.valueOf(b9);
                            } else {
                                i13++;
                                i12 = 11;
                            }
                        }
                    }
                    if (bValueOf == null) {
                        h.b("SmartConnectWrapper", "Not support BLE Discovery for this service");
                    } else if (yVar.z()) {
                        c0 c0Var = yVar.f4191c;
                        if (c0Var != null) {
                            r4 r4Var2 = new r4(yVar, i9);
                            Intrinsics.checkNotNullParameter(service, "service");
                            h.h("TransSmartConnect", "Device start search LE, state: ".concat(c0.c(c0Var.f)));
                            Intrinsics.checkNotNullParameter(service, "service");
                            h.h("TransSmartConnect", "Device start search, state: ".concat(c0.c(c0Var.f)));
                            if (Intrinsics.areEqual(c0Var.f, u6.f10019a) || Intrinsics.areEqual(c0Var.f, w6.f10047a) || Intrinsics.areEqual(c0Var.f, y6.f10070a) || Intrinsics.areEqual(c0Var.f, x6.f10059a)) {
                                h.j("TransSmartConnect", "Device is inactive state: " + c0.c(c0Var.f) + ", search is forbidden");
                                h.j("TransSmartConnect", "Scan is forbidden, ignore");
                            } else {
                                z zVar2 = c0Var.f4090c;
                                if (zVar2 != null) {
                                    g gVar3 = zVar2.f4207i;
                                    boolValueOf = Boolean.valueOf((gVar3 == null || (h5Var3 = gVar3.f4115g) == null) ? false : h5Var3.f9780k);
                                } else {
                                    boolValueOf = null;
                                }
                                Boolean bool = Boolean.TRUE;
                                if (Intrinsics.areEqual(boolValueOf, bool)) {
                                    z zVar3 = c0Var.f4090c;
                                    if (zVar3 != null) {
                                        g gVar4 = zVar3.f4207i;
                                        boolValueOf2 = Boolean.valueOf((gVar4 == null || (h5Var2 = gVar4.f4115g) == null) ? false : h5Var2.f9774c);
                                    } else {
                                        boolValueOf2 = null;
                                    }
                                    if (Intrinsics.areEqual(boolValueOf2, bool)) {
                                        h.j("TransSmartConnect", "StartScan, Scan is running already");
                                    } else {
                                        r4Var = c0Var.f4091d;
                                        if (r4Var != null) {
                                            c0Var.f4091d = r4Var2;
                                        } else {
                                            c0Var.f4091d = r4Var2;
                                        }
                                        h.h("TransSmartConnect", "Device activate search, state: ".concat(c0.c(c0Var.f)));
                                        zVar = c0Var.f4090c;
                                        if (zVar != null) {
                                            scanResultCallBack = new lc.a(c0Var, 8);
                                            Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
                                            Intrinsics.checkNotNullParameter(service, "service");
                                            gVar = zVar.f4207i;
                                            if (gVar != null) {
                                                Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
                                                h5Var = gVar.f4115g;
                                                if (h5Var != null) {
                                                    Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
                                                    synchronized (h5Var.f9783n) {
                                                        h5Var.f9775d = scanResultCallBack;
                                                        h5Var.f9782m++;
                                                    }
                                                }
                                            }
                                            intent = new Intent();
                                            intent.setAction("com.welink.protocol.nfbd.action.START_SCAN_DEVICE");
                                            intent.putExtra("com.welink.protocol.nfbd.extra.service", service);
                                            gVar2 = zVar.f4207i;
                                            if (gVar2 != null) {
                                                gVar2.w(intent, 0);
                                            }
                                        }
                                    }
                                } else {
                                    r4Var = c0Var.f4091d;
                                    if (r4Var != null || r4Var != r4Var2) {
                                        c0Var.f4091d = r4Var2;
                                    }
                                    h.h("TransSmartConnect", "Device activate search, state: ".concat(c0.c(c0Var.f)));
                                    zVar = c0Var.f4090c;
                                    if (zVar != null) {
                                        scanResultCallBack = new lc.a(c0Var, 8);
                                        Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
                                        Intrinsics.checkNotNullParameter(service, "service");
                                        gVar = zVar.f4207i;
                                        if (gVar != null) {
                                            Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
                                            h5Var = gVar.f4115g;
                                            if (h5Var != null) {
                                                Intrinsics.checkNotNullParameter(scanResultCallBack, "scanResultCallBack");
                                                synchronized (h5Var.f9783n) {
                                                    h5Var.f9775d = scanResultCallBack;
                                                    h5Var.f9782m++;
                                                }
                                            }
                                        }
                                        intent = new Intent();
                                        intent.setAction("com.welink.protocol.nfbd.action.START_SCAN_DEVICE");
                                        intent.putExtra("com.welink.protocol.nfbd.extra.service", service);
                                        gVar2 = zVar.f4207i;
                                        if (gVar2 != null) {
                                            gVar2.w(intent, 0);
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        h.b("SmartConnectWrapper", "Smart Config is not enabled, ignore");
                    }
                }
                if (z3) {
                    Intrinsics.checkNotNullParameter("Not support BLE Mesh Discovery", "mes");
                    if (lb.f6529c >= 2) {
                        Log.w("welinkBLE", "Not support BLE Mesh Discovery", null);
                    }
                }
                if (z5) {
                    if (yVar.z()) {
                        p pVar = new p();
                        pVar.f5472b = -100;
                        pVar.f5471a = CollectionsKt.arrayListOf((byte) 10);
                        pVar.f5472b = -200;
                        q4 q4Var = yVar.f;
                        if (q4Var != null) {
                            r4 scanResultCallBack2 = new r4(yVar, 2);
                            Intrinsics.checkNotNullParameter(scanResultCallBack2, "scanResultCallBack");
                            f fVar = q4Var.f9950a;
                            if (fVar == null) {
                                h.j("SmartBluetoothManager", "startBluetoothDiscovery failed, mBluetoothController is null or isDiscovering");
                            } else {
                                if (f.f8814m) {
                                    BluetoothAdapter bluetoothAdapter = f.f8813l;
                                    Intrinsics.checkNotNull(bluetoothAdapter);
                                    zIsDiscovering2 = bluetoothAdapter.isDiscovering();
                                } else {
                                    zIsDiscovering2 = false;
                                }
                                if (zIsDiscovering2) {
                                    h.j("SmartBluetoothManager", "startBluetoothDiscovery failed, mBluetoothController is null or isDiscovering");
                                }
                            }
                            q4Var.f9951b = pVar;
                            q4Var.f9952c.put(UInt.m248boximpl(4), scanResultCallBack2);
                            if (fVar != null && f.f8814m) {
                                e eVar = fVar.f8819i;
                                fVar.h(eVar);
                                try {
                                    if (f.f8814m) {
                                        BluetoothAdapter bluetoothAdapter2 = f.f8813l;
                                        Intrinsics.checkNotNull(bluetoothAdapter2);
                                        zIsDiscovering = bluetoothAdapter2.isDiscovering();
                                    } else {
                                        zIsDiscovering = false;
                                    }
                                    if (zIsDiscovering) {
                                        BluetoothAdapter bluetoothAdapter3 = f.f8813l;
                                        Intrinsics.checkNotNull(bluetoothAdapter3);
                                        bluetoothAdapter3.cancelDiscovery();
                                    }
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                                fVar.g(500L, eVar);
                            }
                        }
                    } else {
                        h.b("SmartConnectWrapper", "Smart Config is not enabled, ignore");
                    }
                }
                BluetoothAdapter bluetoothAdapter4 = yVar.f4193g;
                if (bluetoothAdapter4 != null && !bluetoothAdapter4.isEnabled()) {
                    h.j("SmartConnectWrapper", "Bluetooth is not enabled");
                }
                WifiManager wifiManager = yVar.f4194h;
                if (wifiManager != null) {
                    int i14 = 1;
                    if (wifiManager.isWifiEnabled()) {
                        if (z10) {
                            h.i("Not support Wi-Fi STA Discovery", null);
                            b5 b5Var = yVar.f4192d;
                            if (b5Var != null) {
                                r4 r4Var3 = new r4(yVar, i14);
                                Integer num = (Integer) b5Var.f9664d.get(UInt.m248boximpl(8));
                                if (num != null && num.intValue() == 1) {
                                    Intrinsics.checkNotNullParameter("Device is scanning already", "mes");
                                    if (lb.f6529c >= 2) {
                                        Log.w("welinkBLE", "Device is scanning already", null);
                                    }
                                } else {
                                    b5Var.e.put(UInt.m248boximpl(8), r4Var3);
                                    Integer num2 = (Integer) b5Var.f9664d.get(UInt.m248boximpl(8));
                                    if (num2 != null && num2.intValue() == 0) {
                                        b5Var.f9664d.put(UInt.m248boximpl(8), 1);
                                    }
                                    h.g("Device activate search, state: " + b5Var.f9664d.get(UInt.m248boximpl(8)));
                                    z zVar4 = b5Var.f9662b;
                                    if (zVar4 != null) {
                                        lc.a scanResultCallBack3 = new lc.a(b5Var, 7);
                                        Intrinsics.checkNotNullParameter(scanResultCallBack3, "scanResultCallBack");
                                        k6 k6Var = zVar4.e;
                                        if (k6Var != null) {
                                            synchronized (k6Var.f9846d) {
                                                k6Var.f9845c = scanResultCallBack3;
                                                Unit unit = Unit.INSTANCE;
                                            }
                                        }
                                        Intent intent2 = new Intent();
                                        intent2.setAction("com.welink.protocol.nfbd.action.START_SCAN_WIFI_DEVICE");
                                        g gVar5 = zVar4.f4207i;
                                        if (gVar5 != null) {
                                            gVar5.w(intent2, 0);
                                        }
                                    }
                                }
                            }
                        }
                        WifiManager wifiManager2 = yVar.f4194h;
                        if (wifiManager2 != null && wifiManager2.isP2pSupported()) {
                            if (z11) {
                                Intrinsics.checkNotNullParameter("Not support Wi-Fi P2P Discovery", "mes");
                                if (lb.f6529c >= 2) {
                                    Log.w("welinkBLE", "Not support Wi-Fi P2P Discovery", null);
                                }
                            }
                            if (z12) {
                                Intrinsics.checkNotNullParameter("Not support Wi-Fi NAN Discovery", "mes");
                                if (lb.f6529c >= 2) {
                                    Log.w("welinkBLE", "Not support Wi-Fi NAN Discovery", null);
                                }
                            }
                        }
                    } else {
                        Intrinsics.checkNotNullParameter("Wi-Fi is not enabled, ignore", "mes");
                        if (lb.f6529c >= 2) {
                            th2 = null;
                            Log.w("welinkBLE", "Wi-Fi is not enabled, ignore", null);
                        }
                    }
                    th2 = null;
                } else {
                    Intrinsics.checkNotNullParameter("Wi-Fi is not enabled, ignore", "mes");
                    if (lb.f6529c >= 2) {
                        th2 = null;
                        Log.w("welinkBLE", "Wi-Fi is not enabled, ignore", null);
                    } else {
                        th2 = null;
                    }
                }
                if (z13) {
                    h.i("Start MDNS Discovery", th2);
                    byte[] service2 = y.x(yVar, 1, true, 4);
                    y4 y4Var = yVar.e;
                    if (y4Var != null) {
                        r4 r4Var4 = new r4(yVar, 3);
                        Intrinsics.checkNotNullParameter(service2, "service");
                        z zVar5 = y4Var.f10069a;
                        if (zVar5 != null) {
                            lc.a scanResultCallBack4 = new lc.a(r4Var4, y4Var);
                            Intrinsics.checkNotNullParameter(service2, "service");
                            Intrinsics.checkNotNullParameter(scanResultCallBack4, "scanResultCallBack");
                            h5 h5Var4 = zVar5.f4203c;
                            if (h5Var4 == null || !h5Var4.f9781l) {
                                m mVar = zVar5.f4204d;
                                if (mVar != null) {
                                    synchronized (mVar.f4171c) {
                                        b6 b6Var = mVar.f;
                                        if (b6Var != null) {
                                            synchronized (b6Var.f9668h) {
                                                b6Var.f = scanResultCallBack4;
                                                Unit unit2 = Unit.INSTANCE;
                                            }
                                        }
                                    }
                                }
                                Intent intent3 = new Intent();
                                intent3.setAction("com.welink.protocol.nfbd.action.START_LAN_DISCOVERY");
                                intent3.putExtra("com.welink.protocol.nfbd.extra.scan_mode", 64);
                                intent3.putExtra("com.welink.protocol.nfbd.extra.service", service2);
                                g gVar6 = zVar5.f4207i;
                                if (gVar6 != null) {
                                    gVar6.w(intent3, 0);
                                }
                            } else {
                                h.j("TranConnectionManager", "LanDiscovery is running already");
                            }
                        }
                    }
                }
                if (z14) {
                    Intrinsics.checkNotNullParameter("Not support MQTT Discovery", "mes");
                    if (lb.f6529c >= 2) {
                        Log.w("welinkBLE", "Not support MQTT Discovery", null);
                    }
                }
                if (z15) {
                    Intrinsics.checkNotNullParameter("Not support CoAP Discovery", "mes");
                    if (lb.f6529c >= 2) {
                        Log.w("welinkBLE", "Not support CoAP Discovery", null);
                    }
                }
                h.b("SmartConnectWrapper", "Start Discovery");
                return;
            }
            if (UInt.m254constructorimpl(i10 & UInt.m254constructorimpl(i10 << i11)) != UInt.m254constructorimpl(0)) {
                switch (i11) {
                    case 0:
                        i8 = 1;
                        keySetView.add(0);
                        continue;
                    case 1:
                        i8 = 1;
                        keySetView.add(1);
                        continue;
                    case 2:
                        keySetView.add(4);
                        break;
                    case 3:
                        keySetView.add(5);
                        break;
                    case 4:
                        keySetView.add(8);
                        break;
                    case 5:
                        keySetView.add(9);
                        break;
                    case 6:
                        keySetView.add(10);
                        break;
                    case 7:
                        keySetView.add(11);
                        break;
                    case 8:
                        keySetView.add(12);
                        break;
                    case 9:
                        keySetView.add(13);
                        break;
                    case 10:
                        keySetView.add(15);
                        break;
                }
                i8 = 1;
            } else {
                i8 = 1;
            }
            i11 += i8;
            i10 = i8;
        }
    }
}
