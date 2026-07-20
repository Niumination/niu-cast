package com.welink.protocol.nfbd;

import af.r5;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Message;
import android.os.ext.SdkExtensions;
import android.provider.Settings;
import android.util.Log;
import com.welink.protocol.utils.LanNetworkInfo;
import java.io.IOException;
import java.net.Socket;
import java.nio.channels.ClosedChannelException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import k3.lb;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsJVMKt;
import li.v0;
import se.b3;
import se.b6;
import se.c3;
import se.d3;
import se.f1;
import se.g3;
import se.i3;
import se.j3;
import se.m2;
import se.n2;
import se.o2;
import se.p2;
import se.t2;
import se.t3;
import se.u0;
import se.u3;

/* JADX INFO: loaded from: classes3.dex */
public final class m extends we.g {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final u0 f4170t = new u0(n2.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f4171c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f4172d;
    public final ConnectivityManager e;
    public final b6 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f4173g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final d3 f4174h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList f4175i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f4176j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public List f4177k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public m2 f4178l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f4179m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4180n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f4181o;
    public boolean p;
    public boolean q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f4182r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final p2 f4183s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Context context) {
        super(false, "NearLanManager");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f4171c = new Object();
        this.f4175i = new ArrayList();
        this.f4179m = new LinkedHashSet();
        tj.w listener = new tj.w(this, 17);
        f1 listener2 = new f1(this, 1);
        b6 b6Var = (b6) b6.u.a(context, this);
        this.f = b6Var;
        p pVar = (p) p.f4184k.a(context, this);
        this.f4173g = pVar;
        d3 d3Var = (d3) d3.f9705n.a(context, this);
        this.f4174h = d3Var;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.e = (ConnectivityManager) systemService;
        if (b6Var != null) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            b6Var.q = listener;
        }
        if (pVar != null) {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            pVar.f4188h.add(listener2);
        }
        if (d3Var != null) {
            Intrinsics.checkNotNullParameter(listener2, "listener");
            d3Var.f9708g.add(listener2);
        }
        this.f4183s = new p2(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x006a A[RETURN, SYNTHETIC] */
    public static String m(String serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        switch (serviceType) {
            case "_tranCameraShare._tcp":
                return "CameraShare";
            case "_tranUcHo._tcp":
                return "UcHoService";
            case "_tranFile._tcp":
                return "FileTransfer";
            case "_tranKeyboardMouseShare._tcp":
                return "KeyboardMouseShare";
            case "_tran._tcp":
                return "All";
            case "_tranCallShare._tcp":
                return "CallShare";
            case "_tranCast._tcp":
                return "ScreenCast";
            case "_tranExtendCast._tcp":
                return "ExtendCast";
            default:
                return null;
        }
    }

    @Override // we.g
    public final void b(Message msg) {
        t2 t2Var;
        b3 b3Var;
        Intrinsics.checkNotNullParameter(msg, "msg");
        super.b(msg);
        int i8 = msg.what;
        b6 b6Var = this.f;
        p pVar = this.f4173g;
        switch (i8) {
            case 20480:
                int i9 = msg.arg1;
                ConnectivityManager connectivityManager = this.e;
                p2 p2Var = this.f4183s;
                if (i9 == 1) {
                    if (this.p) {
                        we.h.j("NearLanManager", "startNetworkMonitor: already started");
                        return;
                    }
                    we.h.b("NearLanManager", "startNetworkMonitor");
                    NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addTransportType(1).build();
                    if (connectivityManager != null) {
                        connectivityManager.requestNetwork(networkRequestBuild, p2Var);
                    }
                    if (connectivityManager != null) {
                        connectivityManager.registerNetworkCallback(networkRequestBuild, p2Var);
                    }
                    this.p = true;
                    return;
                }
                if (this.p) {
                    we.h.b("NearLanManager", "stopNetworkMonitor");
                    if (connectivityManager != null) {
                        connectivityManager.unregisterNetworkCallback(p2Var);
                    }
                    this.f4175i.clear();
                    this.p = false;
                } else {
                    we.h.j("NearLanManager", "stopNetworkMonitor: already stopped");
                }
                if (pVar != null) {
                    se.k kVar = p.f4184k;
                    o2 socketMethod = o2.WebSocket;
                    Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
                    int i10 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
                    LinkedHashMap linkedHashMap = pVar.f4189i;
                    LinkedHashSet linkedHashSet = pVar.f4187g;
                    if (i10 == 1) {
                        i3 i3Var = pVar.e;
                        if (i3Var != null) {
                            i3Var.n();
                            li.h0.b(i3Var.f9801c, null);
                        }
                        pVar.e = null;
                        linkedHashSet.clear();
                        linkedHashMap.clear();
                    } else {
                        if (i10 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        t3 t3Var = pVar.f;
                        if (t3Var != null) {
                            t3Var.f();
                            li.h0.b(t3Var.f10002c, new CancellationException("Server reset"));
                        }
                        pVar.f = null;
                        linkedHashSet.clear();
                        linkedHashMap.clear();
                    }
                }
                d3 d3Var = this.f4174h;
                if (d3Var != null) {
                    se.k kVar2 = d3.f9705n;
                    o2 socketMethod2 = o2.WebSocket;
                    Intrinsics.checkNotNullParameter(socketMethod2, "socketMethod");
                    int i11 = c3.$EnumSwitchMapping$0[socketMethod2.ordinal()];
                    if (i11 == 1) {
                        if (d3Var.f9710i.isEmpty() || (t2Var = d3Var.e) == null) {
                            return;
                        }
                        for (Map.Entry entry : t2Var.f9998a.entrySet()) {
                            String str = (String) entry.getKey();
                            Socket socket = (Socket) entry.getValue();
                            NearDevice nearDevice = (NearDevice) t2Var.f9999b.f9709h.get(str);
                            if (nearDevice != null) {
                                t2Var.b(nearDevice, socket);
                            }
                        }
                        return;
                    }
                    if (i11 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    if (d3Var.f9711j.isEmpty() || (b3Var = d3Var.f) == null) {
                        return;
                    }
                    for (Map.Entry entry2 : b3Var.f9656a.entrySet()) {
                        String str2 = (String) entry2.getKey();
                        uf.d dVar = (uf.d) entry2.getValue();
                        NearDevice nearDevice2 = (NearDevice) b3Var.f9659d.f9709h.get(str2);
                        if (nearDevice2 != null) {
                            b3Var.c(nearDevice2, dVar);
                        }
                    }
                    return;
                }
                return;
            case 20481:
                we.h.b("NearLanManager", "onServerStarted: port=" + msg.arg1);
                if (we.m.e(1280)) {
                    we.m.g(1280);
                    return;
                }
                return;
            case 20482:
                we.h.b("NearLanManager", "onServerStopped");
                if (we.m.e(1282)) {
                    we.m.g(1282);
                    return;
                }
                return;
            case 20483:
                if (we.m.e(1282)) {
                    if (pVar != null && p.l(pVar)) {
                        we.h.j("NearLanManager", "stopServer warning(readvertise): clients connected");
                        we.m.g(1282);
                        return;
                    } else {
                        if (pVar != null) {
                            p.w(pVar);
                            return;
                        }
                        return;
                    }
                }
                if (pVar != null && p.l(pVar)) {
                    we.h.j("NearLanManager", "stopServer warning: clients connected");
                } else if (pVar != null) {
                    p.w(pVar);
                }
                if (we.m.e(1280)) {
                    we.m.c(1280);
                    return;
                }
                return;
            case 20484:
                we.h.b("NearLanManager", "onNetworkChanged");
                if (b6Var != null) {
                    if (b6Var.f9669i.isEmpty() && !b6Var.f9667g) {
                        we.h.j("TranLanController", "isAdvertising: device isn't advertising");
                        return;
                    } else {
                        b6Var.r();
                        s();
                        return;
                    }
                }
                return;
            case 20485:
                we.h.b("NearLanManager", "onNetworkUnavailable");
                return;
            case 20486:
                we.h.b("NearLanManager", "onNetworkAvailable");
                if (b6Var != null) {
                    if (b6Var.f9669i.isEmpty() && !b6Var.f9667g) {
                        we.h.j("TranLanController", "isAdvertising: device isn't advertising");
                        return;
                    } else {
                        b6Var.r();
                        s();
                        return;
                    }
                }
                return;
            default:
                String strM = o.d.m("unknown message: ", "NearLanManager", "tag", "mes", i8);
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", strM, "NearLanManager", null);
                    return;
                }
                return;
        }
    }

    public final void j(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        d3 d3Var = this.f4174h;
        if (d3Var != null) {
            se.k kVar = d3.f9705n;
            o2 socketMethod = o2.WebSocket;
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
            NearDeviceExtension nearDeviceExtension = device.u;
            LanNetworkInfo lanNetworkInfo = nearDeviceExtension != null ? nearDeviceExtension.f3909h : null;
            if ((lanNetworkInfo != null ? lanNetworkInfo.f4247n : null) == null) {
                Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
                Intrinsics.checkNotNullParameter("wirelessNetworkInfo is null", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearLanTcpClient", "TransConnect:wirelessNetworkInfo is null", null);
                    return;
                }
                return;
            }
            String str = lanNetworkInfo.f4237a;
            h0.a.D("remoteIp: ", str, "NearLanTcpClient");
            List<Pair> list = lanNetworkInfo.f4247n;
            int iIntValue = 0;
            if (list != null) {
                for (Pair pair : list) {
                    if (StringsKt__StringsJVMKt.equals((String) pair.getFirst(), "HandShake", true)) {
                        iIntValue = ((Number) pair.getSecond()).intValue();
                        h0.a.u(iIntValue, "remotePort: ", "NearLanTcpClient");
                    }
                }
            }
            if (str != null && iIntValue > 0) {
                d3Var.f9709h.put(str, device);
                Message message = new Message();
                message.what = 28672;
                message.arg1 = socketMethod.ordinal();
                message.getData().putString("remoteAddress", str);
                d3Var.i(message);
                return;
            }
            String mes = "remoteIp is null or remotePort is 0, " + str + ", " + iIntValue;
            Intrinsics.checkNotNullParameter("NearLanTcpClient", "tag");
            Intrinsics.checkNotNullParameter(mes, "mes");
            if (lb.f6529c >= 1) {
                h0.a.x("TransConnect:", mes, "NearLanTcpClient", null);
            }
            d3Var.o(device, null, 13);
        }
    }

    public final void k(NearDevice device) {
        i3 i3Var;
        t3 t3Var;
        Intrinsics.checkNotNullParameter(device, "device");
        d3 d3Var = this.f4174h;
        if (d3Var != null) {
            se.k kVar = d3.f9705n;
            d3Var.l(device, null, o2.WebSocket);
        }
        p pVar = this.f4173g;
        if (pVar != null) {
            se.k kVar2 = p.f4184k;
            o2 socketMethod = o2.WebSocket;
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
            String address = device.s();
            int i8 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
            if (i8 == 1) {
                if (address == null || (i3Var = pVar.e) == null) {
                    return;
                }
                Intrinsics.checkNotNullParameter(address, "address");
                Socket socket = (Socket) i3Var.e.get(address);
                if (socket != null) {
                    try {
                        socket.close();
                        i3Var.m(address);
                        return;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                return;
            }
            if (i8 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (address == null || (t3Var = pVar.f) == null) {
                return;
            }
            p pVar2 = t3Var.f10004g;
            Intrinsics.checkNotNullParameter(address, "address");
            ConcurrentHashMap concurrentHashMap = t3Var.f10001b;
            yg.a aVar = (yg.a) concurrentHashMap.get(address);
            if (aVar == null) {
                String mes = "WebSocket session not found for address: ".concat(address);
                Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                Intrinsics.checkNotNullParameter(mes, "mes");
                if (lb.f6529c >= 1) {
                    h0.a.x("TransConnect:", mes, "NearLanTcpServer", null);
                    return;
                }
                return;
            }
            String strU = ((r5) ((yg.b) aVar).f11200a.g().g()).u();
            try {
                try {
                    v0 v0Var = v0.f7498a;
                    li.l0.p(li.h0.a(si.e.f10118a), null, null, new j3(aVar, null), 3);
                    concurrentHashMap.remove(strU);
                    pVar2.o(strU, socketMethod);
                } catch (IOException e4) {
                    e4.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                    concurrentHashMap.remove(strU);
                    pVar2.o(strU, o2.WebSocket);
                }
            } catch (Throwable th2) {
                concurrentHashMap.remove(strU);
                pVar2.o(strU, o2.WebSocket);
                throw th2;
            }
        }
    }

    public final void l(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        d3 d3Var = this.f4174h;
        if (d3Var != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            String strS = device.s();
            if (strS != null) {
                LinkedHashMap linkedHashMap = d3Var.f9709h;
                if (linkedHashMap.containsKey(strS)) {
                    linkedHashMap.remove(strS);
                }
            }
        }
        p pVar = this.f4173g;
        if (pVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            String strS2 = device.s();
            if (strS2 == null) {
                return;
            }
            LinkedHashMap linkedHashMap2 = pVar.f4189i;
            if (linkedHashMap2.containsKey(strS2)) {
                linkedHashMap2.remove(strS2);
            }
        }
    }

    public final void n(NearDevice device, boolean z2, int i8, int i9) {
        p pVar;
        Intrinsics.checkNotNullParameter(device, "device");
        WirelessDevice wirelessDevice = device.f3896s;
        if (wirelessDevice == null || !(wirelessDevice instanceof WirelessDevice.Wlan) || ((WirelessDevice.Wlan) wirelessDevice).f4025b == null || (pVar = this.f4173g) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(device, "device");
        se.k kVar = p.f4184k;
        pVar.v(device, z2 ? 1 : 0, false);
    }

    public final void o(List services) {
        Intrinsics.checkNotNullParameter(services, "services");
        this.f4177k = services;
    }

    public final void p(NearDevice device, boolean z2) {
        Intrinsics.checkNotNullParameter(device, "device");
        p pVar = this.f4173g;
        if (pVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            pVar.v(device, 2, z2);
        }
    }

    public final void q(NearDevice device) {
        Intrinsics.checkNotNullParameter(device, "device");
        p pVar = this.f4173g;
        if (pVar != null) {
            Intrinsics.checkNotNullParameter(device, "device");
            se.k kVar = p.f4184k;
            pVar.v(device, 3, false);
        }
    }

    public final void r(final String vendorId, final byte[] bArr, final String str, final int i8, final byte[] bArr2, final Integer num) {
        Intrinsics.checkNotNullParameter(vendorId, "vendorId");
        if (this.f4180n) {
            we.h.j("NearLanManager", "startAdvertisement: already started");
            return;
        }
        String string = Arrays.toString(bArr2);
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        we.h.b("NearLanManager", "startAdvertisement: vendorId=" + vendorId + ", deviceId=" + bArr + ", deviceName=" + str + ", serviceType=" + i8 + ", serviceList=" + string);
        this.f4176j = bArr2;
        this.f4178l = new m2(vendorId, bArr, str, i8, bArr2, num);
        Runnable runnable = new Runnable() { // from class: se.l2
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Code duplicated, block: B:100:0x0290  */
            /* JADX WARN: Code duplicated, block: B:102:0x0299  */
            /* JADX WARN: Code duplicated, block: B:103:0x029e  */
            /* JADX WARN: Code duplicated, block: B:105:0x02a8  */
            /* JADX WARN: Code duplicated, block: B:107:0x02c1 A[LOOP:7: B:106:0x02bf->B:107:0x02c1, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:110:0x02d1  */
            /* JADX WARN: Code duplicated, block: B:112:0x02da  */
            /* JADX WARN: Code duplicated, block: B:113:0x02df  */
            /* JADX WARN: Code duplicated, block: B:114:0x02e4  */
            /* JADX WARN: Code duplicated, block: B:116:0x02fd A[LOOP:8: B:115:0x02fb->B:116:0x02fd, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:119:0x030d  */
            /* JADX WARN: Code duplicated, block: B:121:0x0316  */
            /* JADX WARN: Code duplicated, block: B:122:0x031c  */
            /* JADX WARN: Code duplicated, block: B:123:0x0321  */
            /* JADX WARN: Code duplicated, block: B:125:0x033a A[LOOP:9: B:124:0x0338->B:125:0x033a, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:128:0x034a  */
            /* JADX WARN: Code duplicated, block: B:130:0x0353  */
            /* JADX WARN: Code duplicated, block: B:131:0x0359  */
            /* JADX WARN: Code duplicated, block: B:132:0x035f  */
            /* JADX WARN: Code duplicated, block: B:134:0x0382 A[LOOP:10: B:133:0x0380->B:134:0x0382, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:137:0x0398  */
            /* JADX WARN: Code duplicated, block: B:139:0x03a1  */
            /* JADX WARN: Code duplicated, block: B:141:0x03a9  */
            /* JADX WARN: Code duplicated, block: B:143:0x03b3  */
            /* JADX WARN: Code duplicated, block: B:151:0x03e5  */
            /* JADX WARN: Code duplicated, block: B:153:0x03ed  */
            /* JADX WARN: Code duplicated, block: B:162:0x0424  */
            /* JADX WARN: Code duplicated, block: B:164:0x0430  */
            /* JADX WARN: Code duplicated, block: B:165:0x0435  */
            /* JADX WARN: Code duplicated, block: B:169:0x043f A[LOOP:13: B:167:0x043c->B:169:0x043f, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:172:0x0450  */
            /* JADX WARN: Code duplicated, block: B:174:0x0459  */
            /* JADX WARN: Code duplicated, block: B:175:0x045f  */
            /* JADX WARN: Code duplicated, block: B:179:0x0468  */
            /* JADX WARN: Code duplicated, block: B:182:0x0470 A[LOOP:14: B:180:0x046d->B:182:0x0470, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:185:0x0481  */
            /* JADX WARN: Code duplicated, block: B:187:0x0488  */
            /* JADX WARN: Code duplicated, block: B:188:0x048e  */
            /* JADX WARN: Code duplicated, block: B:189:0x0494  */
            /* JADX WARN: Code duplicated, block: B:191:0x04b1 A[LOOP:15: B:190:0x04af->B:191:0x04b1, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:194:0x04c1  */
            /* JADX WARN: Code duplicated, block: B:196:0x04ca  */
            /* JADX WARN: Code duplicated, block: B:197:0x04d0  */
            /* JADX WARN: Code duplicated, block: B:201:0x04d9  */
            /* JADX WARN: Code duplicated, block: B:204:0x04e1 A[LOOP:16: B:202:0x04de->B:204:0x04e1, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:207:0x04f2  */
            /* JADX WARN: Code duplicated, block: B:209:0x04f9  */
            /* JADX WARN: Code duplicated, block: B:210:0x04ff  */
            /* JADX WARN: Code duplicated, block: B:211:0x0505  */
            /* JADX WARN: Code duplicated, block: B:213:0x0521 A[LOOP:17: B:212:0x051f->B:213:0x0521, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:216:0x0531  */
            /* JADX WARN: Code duplicated, block: B:218:0x053a  */
            /* JADX WARN: Code duplicated, block: B:219:0x0540  */
            /* JADX WARN: Code duplicated, block: B:220:0x0546  */
            /* JADX WARN: Code duplicated, block: B:222:0x0561 A[LOOP:18: B:221:0x055f->B:222:0x0561, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:225:0x0571  */
            /* JADX WARN: Code duplicated, block: B:227:0x057a  */
            /* JADX WARN: Code duplicated, block: B:228:0x0580  */
            /* JADX WARN: Code duplicated, block: B:229:0x0586  */
            /* JADX WARN: Code duplicated, block: B:231:0x05a1 A[LOOP:19: B:230:0x059f->B:231:0x05a1, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:234:0x05b1  */
            /* JADX WARN: Code duplicated, block: B:236:0x05b8  */
            /* JADX WARN: Code duplicated, block: B:237:0x05be  */
            /* JADX WARN: Code duplicated, block: B:238:0x05c3  */
            /* JADX WARN: Code duplicated, block: B:240:0x05de A[LOOP:20: B:239:0x05dc->B:240:0x05de, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:243:0x05ee  */
            /* JADX WARN: Code duplicated, block: B:245:0x05f7  */
            /* JADX WARN: Code duplicated, block: B:246:0x05fd  */
            /* JADX WARN: Code duplicated, block: B:251:0x061c  */
            /* JADX WARN: Code duplicated, block: B:253:0x064d A[LOOP:1: B:252:0x064b->B:253:0x064d, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:254:0x0655  */
            /* JADX WARN: Code duplicated, block: B:256:0x065f  */
            /* JADX WARN: Code duplicated, block: B:259:0x0671  */
            /* JADX WARN: Code duplicated, block: B:262:0x06af A[LOOP:2: B:261:0x06ad->B:262:0x06af, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:266:0x06ce A[LOOP:3: B:264:0x06c8->B:266:0x06ce, LOOP_END] */
            /* JADX WARN: Code duplicated, block: B:269:0x0775 A[ADDED_TO_REGION] */
            /* JADX WARN: Code duplicated, block: B:270:0x0777  */
            /* JADX WARN: Code duplicated, block: B:339:0x0954  */
            /* JADX WARN: Code duplicated, block: B:382:0x0ad2  */
            /* JADX WARN: Code duplicated, block: B:384:0x0adb  */
            /* JADX WARN: Code duplicated, block: B:385:0x0ae2  */
            /* JADX WARN: Code duplicated, block: B:388:0x0af2 A[Catch: all -> 0x0b03, Exception -> 0x0b06, IllegalArgumentException -> 0x0b08, TryCatch #4 {IllegalArgumentException -> 0x0b08, Exception -> 0x0b06, blocks: (B:386:0x0aeb, B:388:0x0af2, B:390:0x0af6, B:398:0x0b0b), top: B:414:0x0aeb, outer: #0 }] */
            /* JADX WARN: Code duplicated, block: B:390:0x0af6 A[Catch: all -> 0x0b03, Exception -> 0x0b06, IllegalArgumentException -> 0x0b08, TryCatch #4 {IllegalArgumentException -> 0x0b08, Exception -> 0x0b06, blocks: (B:386:0x0aeb, B:388:0x0af2, B:390:0x0af6, B:398:0x0b0b), top: B:414:0x0aeb, outer: #0 }] */
            /* JADX WARN: Code duplicated, block: B:398:0x0b0b A[Catch: all -> 0x0b03, Exception -> 0x0b06, IllegalArgumentException -> 0x0b08, TRY_LEAVE, TryCatch #4 {IllegalArgumentException -> 0x0b08, Exception -> 0x0b06, blocks: (B:386:0x0aeb, B:388:0x0af2, B:390:0x0af6, B:398:0x0b0b), top: B:414:0x0aeb, outer: #0 }] */
            /* JADX WARN: Code duplicated, block: B:408:0x0b22  */
            /* JADX WARN: Code duplicated, block: B:410:0x0b33  */
            /* JADX WARN: Code duplicated, block: B:453:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Code duplicated, block: B:49:0x012e  */
            /* JADX WARN: Code duplicated, block: B:82:0x0248  */
            /* JADX WARN: Code duplicated, block: B:84:0x024c  */
            /* JADX WARN: Code duplicated, block: B:86:0x024f  */
            /* JADX WARN: Code duplicated, block: B:88:0x0252  */
            /* JADX WARN: Code duplicated, block: B:90:0x025a  */
            /* JADX WARN: Code duplicated, block: B:92:0x025e  */
            /* JADX WARN: Code duplicated, block: B:93:0x0261  */
            /* JADX WARN: Code duplicated, block: B:95:0x0268  */
            /* JADX WARN: Code duplicated, block: B:97:0x0280 A[LOOP:6: B:96:0x027e->B:97:0x0280, LOOP_END] */
            /* JADX WARN: Failed to find 'out' block for switch in B:92:0x025e. Please report as an issue. */
            /* JADX WARN: Instruction removed from duplicated block: B:259:0x0671, please report this as an issue */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                int i9;
                List list;
                int i10;
                String str2;
                byte[] byteArray;
                int size;
                byte[] bytes;
                int length;
                int iA;
                StringBuilder sb2;
                Iterator it;
                String strJoinToString$default;
                int i11;
                String str3;
                String str4;
                String tag;
                String str5;
                b6 b6Var;
                NsdServiceInfo nsdServiceInfoM;
                boolean z2;
                NsdManager nsdManager;
                String str6;
                int i12;
                String str7;
                int length2;
                int iA2;
                byte b9;
                byte b10;
                byte b11;
                int i13;
                byte[] bArr3;
                int iA3;
                byte b12;
                int i14;
                byte[] bArr4;
                int iA4;
                int i15;
                int i16;
                byte[] bArr5;
                int iA5;
                int i17;
                byte[] bArr6;
                int iA6;
                Integer num2;
                int i18;
                byte[] bArr7;
                int iA7;
                byte[] bArrD;
                int iA8;
                byte[] bArr8;
                int i19;
                int iA9;
                byte[] bArrB;
                int iA10;
                byte[] bArrD2;
                int iA11;
                int i20;
                byte[] bArr9;
                int iA12;
                int i21;
                byte[] bArr10;
                int iA13;
                int i22;
                byte[] bArr11;
                int iA14;
                byte[] bArr12;
                int iA15;
                byte b13;
                we.h.b("NearLanManager", "startAdvertisement: start");
                com.welink.protocol.nfbd.m mVar = this.f9853a;
                com.welink.protocol.nfbd.p pVar = mVar.f4173g;
                if (pVar != null && com.welink.protocol.nfbd.p.m(pVar)) {
                    com.welink.protocol.nfbd.p pVar2 = mVar.f4173g;
                    if ((pVar2 != null ? Integer.valueOf(com.welink.protocol.nfbd.p.j(pVar2)) : null) != null) {
                        b6 b6Var2 = mVar.f;
                        if (b6Var2 != null) {
                            Intrinsics.checkNotNull(pVar2);
                            int iJ = com.welink.protocol.nfbd.p.j(pVar2);
                            List list2 = mVar.f4177k;
                            String vendorId2 = vendorId;
                            Intrinsics.checkNotNullParameter(vendorId2, "vendorId");
                            if (!b6Var2.f9669i.isEmpty() || b6Var2.f9667g) {
                                we.h.j("TranLanController", "startAdvertisement: device is advertising already");
                                return;
                            }
                            we.h.b("TranLanController", "startAdvertisement");
                            byte[] deviceId = bArr;
                            if (deviceId == null) {
                                BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
                                deviceId = new byte[6];
                                new Random().nextBytes(deviceId);
                            }
                            Context context = b6Var2.f9665c;
                            String deviceName = str;
                            if (deviceName == null) {
                                deviceName = Settings.Global.getString(context != null ? context.getContentResolver() : null, "device_name");
                            }
                            BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
                            if (deviceName == null) {
                                deviceName = "MdnsDevice";
                            }
                            Intrinsics.checkNotNullParameter(vendorId2, "vendorId");
                            Intrinsics.checkNotNullParameter(deviceId, "deviceId");
                            Intrinsics.checkNotNullParameter(deviceName, "deviceName");
                            ArrayList arrayList = new ArrayList();
                            byte b14 = (byte) 9;
                            int iM177constructorimpl = (UByte.m177constructorimpl((byte) 66) & UByte.MAX_VALUE) | ((UByte.m177constructorimpl(b14) & UByte.MAX_VALUE) << 8);
                            byte[] bArrG = m3.q.g(vendorId2);
                            ArrayList arrayList2 = new ArrayList();
                            arrayList2.add(Byte.valueOf(bArrG[1]));
                            arrayList2.add(Byte.valueOf(bArrG[3]));
                            arrayList2.add(Byte.valueOf(bArrG[7]));
                            arrayList2.add(Byte.valueOf(bArrG[8]));
                            byte b15 = bArrG[6];
                            int i23 = i8;
                            if (16 > b15 || b15 >= 255) {
                                we.h.g("Use Default Broadcast Version: " + ((int) b15));
                                arrayList2.add((byte) 16);
                            } else {
                                we.h.g("Add User Defined Broadcast Version: " + ((int) b15));
                                if (i23 == 0) {
                                    b13 = 17;
                                } else if (i23 == 1 || i23 == 4 || i23 == 5 || i23 == 8) {
                                    b13 = 19;
                                } else if (i23 != 251) {
                                    switch (i23) {
                                        case 10:
                                        case 11:
                                        case 12:
                                        case 13:
                                            b13 = 19;
                                            break;
                                        default:
                                            we.h.d("Unknown Scenario: " + i23 + ", use default version: " + ((int) bArrG[6]), null);
                                            b13 = bArrG[6];
                                            break;
                                    }
                                } else {
                                    b13 = 20;
                                }
                                arrayList2.add(Byte.valueOf(b13));
                            }
                            arrayList2.add((byte) 0);
                            arrayList.add(Byte.valueOf((byte) (arrayList2.size() + 3)));
                            arrayList.add(Byte.valueOf((byte) 255));
                            arrayList.add(Byte.valueOf((byte) (iM177constructorimpl & 255)));
                            arrayList.add(Byte.valueOf((byte) ((iM177constructorimpl >> 8) & 255)));
                            Iterator it2 = arrayList2.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(Byte.valueOf(((Number) it2.next()).byteValue()));
                            }
                            int iM177constructorimpl2 = ((UByte.m177constructorimpl((byte) 253) & UByte.MAX_VALUE) << 8) | (UByte.m177constructorimpl((byte) 53) & UByte.MAX_VALUE);
                            ArrayList arrayList3 = new ArrayList();
                            Byte b16 = (Byte) CollectionsKt.getOrNull(arrayList2, 4);
                            byte[] bArr13 = bArr2;
                            if (b16 != null) {
                                str2 = "TranLanController";
                                byte bByteValue = b16.byteValue();
                                list = list2;
                                if (bByteValue != 16) {
                                    if (17 <= bByteValue) {
                                        b9 = 20;
                                        if (bByteValue < 20) {
                                            int iA16 = 0;
                                            for (int length3 = deviceId.length; iA16 < length3; length3 = length3) {
                                                iA16 = h0.a.a(deviceId[iA16], arrayList3, iA16, 1);
                                            }
                                        }
                                    } else {
                                        b9 = 20;
                                    }
                                    if (b9 > bByteValue || bByteValue >= 256) {
                                        String mes = "Invalid protocol version: " + b16 + ", use default version: 0x11";
                                        Intrinsics.checkNotNullParameter(mes, "mes");
                                        b10 = 1;
                                        if (lb.f6529c >= 1) {
                                            Log.e("welinkBLE", mes, null);
                                        }
                                    } else {
                                        arrayList3.add((byte) -1);
                                        arrayList3.add((byte) 6);
                                        int iA17 = 0;
                                        for (int length4 = deviceId.length; iA17 < length4; length4 = length4) {
                                            iA17 = h0.a.a(deviceId[iA17], arrayList3, iA17, 1);
                                        }
                                    }
                                    if (i23 != 0) {
                                        i9 = i23;
                                        i10 = iJ;
                                        b11 = b10;
                                        byte bF = (byte) ne.b.f();
                                        bArr3 = new byte[4];
                                        bArr3[0] = 0;
                                        bArr3[b11] = 2;
                                        bArr3[2] = bF;
                                        bArr3[3] = 0;
                                        iA3 = 0;
                                        for (i13 = 4; iA3 < i13; i13 = 4) {
                                            iA3 = h0.a.a(bArr3[iA3], arrayList3, iA3, b11);
                                        }
                                        if (arrayList3.size() > 1456) {
                                            Intrinsics.checkNotNullParameter("Screen Cast Data Length is too long, it should be less than 1456", "mes");
                                            if (lb.f6529c >= b11) {
                                                Log.e("welinkBLE", "Screen Cast Data Length is too long, it should be less than 1456", null);
                                            }
                                        } else {
                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                        }
                                    } else if (i23 != b10) {
                                        if (i23 != 4) {
                                            i9 = i23;
                                            i10 = iJ;
                                            bArr5 = new byte[]{4, 2, (byte) ne.b.f(), 0};
                                            iA5 = 0;
                                            for (i16 = 4; iA5 < i16; i16 = 4) {
                                                iA5 = h0.a.a(bArr5[iA5], arrayList3, iA5, 1);
                                            }
                                            if (arrayList3.size() > 1456) {
                                                Intrinsics.checkNotNullParameter("Clipboard Share Data Length is too long, it should be less than 1456", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Clipboard Share Data Length is too long, it should be less than 1456", null);
                                                }
                                            } else {
                                                byteArray = CollectionsKt.toByteArray(arrayList3);
                                            }
                                        } else if (i23 != 5) {
                                            num2 = num;
                                            if (i23 != 8) {
                                                i9 = i23;
                                                i10 = iJ;
                                                bArr7 = new byte[]{8, 2, (byte) ne.b.f(), 0};
                                                iA7 = 0;
                                                for (i18 = 4; iA7 < i18; i18 = 4) {
                                                    iA7 = h0.a.a(bArr7[iA7], arrayList3, iA7, 1);
                                                }
                                                if (arrayList3.size() > 1456) {
                                                    Intrinsics.checkNotNullParameter("Air Cast Data Length is too long, it should be less than 1456", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("welinkBLE", "Air Cast Data Length is too long, it should be less than 1456", null);
                                                    }
                                                } else {
                                                    if (num2 != null || num2.intValue() != 0) {
                                                        bArrD = ne.b.d(num2);
                                                        for (iA8 = 0; iA8 < 4; iA8 = h0.a.a(bArrD[iA8], arrayList3, iA8, 1)) {
                                                        }
                                                        if (arrayList3.size() > 1456) {
                                                            Intrinsics.checkNotNullParameter("SubCapability Data Length is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 1) {
                                                                Log.e("welinkBLE", "SubCapability Data Length is too long, it should be less than 1456", null);
                                                            }
                                                        }
                                                    }
                                                    byteArray = CollectionsKt.toByteArray(arrayList3);
                                                }
                                            } else if (i23 != 251) {
                                                switch (i23) {
                                                    case 10:
                                                        bArr9 = new byte[]{10, 2, (byte) ne.b.f(), 0};
                                                        iA12 = 0;
                                                        for (i20 = 4; iA12 < i20; i20 = 4) {
                                                            iA12 = h0.a.a(bArr9[iA12], arrayList3, iA12, 1);
                                                        }
                                                        if (arrayList3.size() > 1456) {
                                                            Intrinsics.checkNotNullParameter("Audio Sink Data Length is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 1) {
                                                                Log.e("welinkBLE", "Audio Sink Data Length is too long, it should be less than 1456", null);
                                                            }
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        } else {
                                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        }
                                                        break;
                                                    case 11:
                                                        bArr10 = new byte[]{11, 2, (byte) ne.b.f(), 0};
                                                        iA13 = 0;
                                                        for (i21 = 4; iA13 < i21; i21 = 4) {
                                                            iA13 = h0.a.a(bArr10[iA13], arrayList3, iA13, 1);
                                                        }
                                                        if (arrayList3.size() > 1456) {
                                                            Intrinsics.checkNotNullParameter("Keyboard Mouse Share Data Length is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 1) {
                                                                Log.e("welinkBLE", "Keyboard Mouse Share Data Length is too long, it should be less than 1456", null);
                                                            }
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        } else {
                                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        }
                                                        break;
                                                    case 12:
                                                        bArr11 = new byte[]{12, 2, (byte) ne.b.f(), 0};
                                                        iA14 = 0;
                                                        for (i22 = 4; iA14 < i22; i22 = 4) {
                                                            iA14 = h0.a.a(bArr11[iA14], arrayList3, iA14, 1);
                                                        }
                                                        if (arrayList3.size() > 1456) {
                                                            Intrinsics.checkNotNullParameter("Call Share Data Length is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 1) {
                                                                Log.e("welinkBLE", "Call Share Data Length is too long, it should be less than 1456", null);
                                                            }
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        } else {
                                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        }
                                                        break;
                                                    case 13:
                                                        bArr12 = new byte[]{13, 2, (byte) ne.b.f(), 0};
                                                        iA15 = 0;
                                                        for (i15 = 4; iA15 < i15; i15 = 4) {
                                                            iA15 = h0.a.a(bArr12[iA15], arrayList3, iA15, 1);
                                                        }
                                                        if (arrayList3.size() > 1456) {
                                                            Intrinsics.checkNotNullParameter("Camera Share Data Length is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 1) {
                                                                Log.e("welinkBLE", "Camera Share Data Length is too long, it should be less than 1456", null);
                                                            }
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        } else {
                                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                                            i9 = i23;
                                                            i10 = iJ;
                                                        }
                                                        break;
                                                    default:
                                                        i9 = i23;
                                                        i10 = iJ;
                                                        break;
                                                }
                                            } else {
                                                byte[] bArrG2 = ne.b.g(bArr13);
                                                i10 = iJ;
                                                bArr8 = new byte[]{-5, 2, bArrG2[0], bArrG2[1]};
                                                iA9 = 0;
                                                for (i19 = 4; iA9 < i19; i19 = 4) {
                                                    iA9 = h0.a.a(bArr8[iA9], arrayList3, iA9, 1);
                                                    bArr8 = bArr8;
                                                }
                                                if (arrayList3.size() > 1456) {
                                                    Intrinsics.checkNotNullParameter("Capability Data Length is too long, it should be less than 1456", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("welinkBLE", "Capability Data Length is too long, it should be less than 1456", null);
                                                    }
                                                    i9 = i23;
                                                } else {
                                                    if (com.welink.protocol.nfbd.a.f4027k.c("1.0")) {
                                                        if (arrayList3.size() + 4 <= 1456 || bArr13 == null || !ArraysKt.contains(bArr13, (byte) 1)) {
                                                            Intrinsics.checkNotNullParameter("Air Parcel Data Length is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 2) {
                                                                Log.w("welinkBLE", "Air Parcel Data Length is too long, it should be less than 1456", null);
                                                            }
                                                        } else {
                                                            byte[] bArr14 = {1, 2, (byte) ne.b.f(), 0};
                                                            int iA18 = 0;
                                                            for (int i24 = 4; iA18 < i24; i24 = 4) {
                                                                iA18 = h0.a.a(bArr14[iA18], arrayList3, iA18, 1);
                                                            }
                                                        }
                                                        if (arrayList3.size() + 4 <= 1456 || bArr13 == null || !ArraysKt.contains(bArr13, (byte) 0)) {
                                                            i9 = i23;
                                                            Intrinsics.checkNotNullParameter("Screen Cast Data is too long, it should be less than 1456", "mes");
                                                            if (lb.f6529c >= 2) {
                                                                Log.w("welinkBLE", "Screen Cast Data is too long, it should be less than 1456", null);
                                                            }
                                                        } else {
                                                            i9 = i23;
                                                            byte[] bArr15 = {0, 2, (byte) ne.b.f(), 0};
                                                            int iA19 = 0;
                                                            for (int i25 = 4; iA19 < i25; i25 = 4) {
                                                                iA19 = h0.a.a(bArr15[iA19], arrayList3, iA19, 1);
                                                            }
                                                        }
                                                    } else {
                                                        i9 = i23;
                                                    }
                                                    bArrB = ne.b.b(context);
                                                    for (iA10 = 0; iA10 < 5; iA10 = h0.a.a(bArrB[iA10], arrayList3, iA10, 1)) {
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("Feature Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "Feature Data Length is too long, it should be less than 1456", null);
                                                        }
                                                    } else {
                                                        if (num2 != null || num2.intValue() != 0) {
                                                            bArrD2 = ne.b.d(num2);
                                                            for (iA11 = 0; iA11 < 4; iA11 = h0.a.a(bArrD2[iA11], arrayList3, iA11, 1)) {
                                                            }
                                                            if (arrayList3.size() > 1456) {
                                                                Intrinsics.checkNotNullParameter("SubCapability Data Length is too long, it should be less than 1456", "mes");
                                                                if (lb.f6529c >= 1) {
                                                                    Log.e("welinkBLE", "SubCapability Data Length is too long, it should be less than 1456", null);
                                                                }
                                                            }
                                                        }
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                    }
                                                }
                                            }
                                        } else {
                                            i9 = i23;
                                            i10 = iJ;
                                            bArr6 = new byte[]{5, 2, (byte) ne.b.f(), 0};
                                            iA6 = 0;
                                            for (i17 = 4; iA6 < i17; i17 = 4) {
                                                iA6 = h0.a.a(bArr6[iA6], arrayList3, iA6, 1);
                                            }
                                            if (arrayList3.size() > 1456) {
                                                Intrinsics.checkNotNullParameter("Handover Drop Data Length is too long, it should be less than 1456", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Handover Drop Data Length is too long, it should be less than 1456", null);
                                                }
                                            } else {
                                                byteArray = CollectionsKt.toByteArray(arrayList3);
                                            }
                                        }
                                    } else {
                                        i9 = i23;
                                        i10 = iJ;
                                        b12 = b10;
                                        byte bF2 = (byte) ne.b.f();
                                        bArr4 = new byte[4];
                                        bArr4[0] = b12;
                                        bArr4[b12] = 2;
                                        bArr4[2] = bF2;
                                        bArr4[3] = 0;
                                        iA4 = 0;
                                        for (i14 = 4; iA4 < i14; i14 = 4) {
                                            iA4 = h0.a.a(bArr4[iA4], arrayList3, iA4, b12);
                                        }
                                        if (arrayList3.size() > 1456) {
                                            Intrinsics.checkNotNullParameter("Air Parcel Data Length is too long, it should be less than 1456", "mes");
                                            if (lb.f6529c >= b12) {
                                                Log.e("welinkBLE", "Air Parcel Data Length is too long, it should be less than 1456", null);
                                            }
                                        } else {
                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                        }
                                    }
                                    if (byteArray != null) {
                                        arrayList.add(Byte.valueOf((byte) (byteArray.length + 3)));
                                        arrayList.add(Byte.valueOf((byte) 22));
                                        arrayList.add(Byte.valueOf((byte) (iM177constructorimpl2 & 255)));
                                        arrayList.add(Byte.valueOf((byte) ((iM177constructorimpl2 >> 8) & 255)));
                                        length2 = byteArray.length;
                                        for (iA2 = 0; iA2 < length2; iA2 = h0.a.a(byteArray[iA2], arrayList, iA2, 1)) {
                                        }
                                    } else {
                                        Intrinsics.checkNotNullParameter("Service Data is null, ignore it", "mes");
                                        if (lb.f6529c >= 1) {
                                            Log.e("welinkBLE", "Service Data is null, ignore it", null);
                                        }
                                    }
                                    size = arrayList.size();
                                    if (deviceName.length() > 120 - size) {
                                        int i26 = 118 - size;
                                        we.h.j("AdvertiseTool", "Device Name is too long, it should be less than " + i26);
                                        deviceName = deviceName.substring(0, i26);
                                        Intrinsics.checkNotNullExpressionValue(deviceName, "substring(...)");
                                    }
                                    bytes = deviceName.getBytes(Charsets.UTF_8);
                                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                    arrayList.add(Byte.valueOf((byte) (bytes.length + 1)));
                                    arrayList.add(Byte.valueOf(b14));
                                    length = bytes.length;
                                    for (iA = 0; iA < length; iA = h0.a.a(bytes[iA], arrayList, iA, 1)) {
                                    }
                                    int size2 = arrayList.size();
                                    Intrinsics.checkNotNullParameter(arrayList, "<this>");
                                    sb2 = new StringBuilder();
                                    it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        byte bByteValue2 = ((Number) it.next()).byteValue();
                                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                        String str8 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bByteValue2)}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                        sb2.append(str8);
                                    }
                                    String string2 = sb2.toString();
                                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                    we.h.b("AdvertiseTool", "Advertisement Data size: " + size2 + ", data: " + string2);
                                    byte[] byteArray2 = CollectionsKt.toByteArray(arrayList);
                                    Intrinsics.checkNotNullParameter(byteArray2, "<this>");
                                    Intrinsics.checkNotNullParameter("", "separator");
                                    strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(byteArray2, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
                                    String string3 = Arrays.toString(bArr13);
                                    Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                                    StringBuilder sb3 = new StringBuilder("startAdvertisement: ");
                                    i11 = i9;
                                    sb3.append(i11);
                                    sb3.append(", ");
                                    sb3.append(string3);
                                    sb3.append(", ");
                                    int i27 = i10;
                                    sb3.append(i27);
                                    sb3.append(", ");
                                    List list3 = list;
                                    sb3.append(list3);
                                    sb3.append(", ");
                                    sb3.append(strJoinToString$default);
                                    str3 = str2;
                                    we.h.b(str3, sb3.toString());
                                    we.h.b(str3, "createNsdServiceInfoList");
                                    if (i11 == -1 && bArr13 != null) {
                                        List list4 = list3;
                                        str5 = "mes";
                                        str4 = strJoinToString$default;
                                        String str9 = str3;
                                        String str10 = "KeyboardMouseShare";
                                        if (list4 == null || list4.isEmpty()) {
                                            b6Var = b6Var2;
                                            if (i11 == 0) {
                                                tag = str9;
                                                we.h.b(tag, "createNsdServiceInfoList: SCENARIO_TYPE_SCREEN_CAST");
                                                nsdServiceInfoM = b6Var.m("_tranCast._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("ScreenCast", 8900), new Pair("HandShake", Integer.valueOf(i27))}));
                                            } else if (i11 == 1) {
                                                tag = str9;
                                                nsdServiceInfoM = b6Var.m("_tranFile._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("FileTransfer", 50231), new Pair("FileTransfer", 50331), new Pair("HandShake", Integer.valueOf(i27))}));
                                            } else if (i11 == 4 || i11 == 5) {
                                                tag = str9;
                                                nsdServiceInfoM = b6Var.m("_tranUcHo._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("UcHoService", 8902), new Pair("HandShake", Integer.valueOf(i27))}));
                                            } else if (i11 != 251) {
                                                switch (i11) {
                                                    case 8:
                                                        tag = str9;
                                                        we.h.b(tag, "createNsdServiceInfoList: SCENARIO_TYPE_SCREEN_CAST");
                                                        nsdServiceInfoM = b6Var.m("_tranCast._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("ScreenCast", 8900), new Pair("HandShake", Integer.valueOf(i27))}));
                                                        break;
                                                    case 9:
                                                        nsdServiceInfoM = b6Var.m("_tranExtendCast._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("ExtendCast", 8903), new Pair("HandShake", Integer.valueOf(i27))}));
                                                        break;
                                                    case 10:
                                                        nsdServiceInfoM = b6Var.m("_tranAudioSink._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("AudioSink", 8904), new Pair("HandShake", Integer.valueOf(i27))}));
                                                        break;
                                                    case 11:
                                                        nsdServiceInfoM = b6Var.m("_tranKeyboardMouseShare._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("KeyboardMouseShare", 8905), new Pair("HandShake", Integer.valueOf(i27))}));
                                                        break;
                                                    case 12:
                                                        nsdServiceInfoM = b6Var.m("_tranCallShare._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("CallShare", 8906), new Pair("HandShake", Integer.valueOf(i27))}));
                                                        break;
                                                    case 13:
                                                        nsdServiceInfoM = b6Var.m("_tranCameraShare._tcp", CollectionsKt.listOf((Object[]) new Pair[]{new Pair("CameraShare", 8907), new Pair("HandShake", Integer.valueOf(i27))}));
                                                        break;
                                                    default:
                                                        tag = str9;
                                                        break;
                                                }
                                            } else {
                                                ArrayList arrayList4 = new ArrayList();
                                                arrayList4.add(new Pair("HandShake", Integer.valueOf(i27)));
                                                byte[] bArr16 = bArr13;
                                                int length5 = bArr16.length;
                                                int i28 = 0;
                                                while (i28 < length5) {
                                                    byte b17 = bArr16[i28];
                                                    if (b17 == 0 || b17 == 8) {
                                                        str6 = str9;
                                                        arrayList4.add(new Pair("ScreenCast", 8900));
                                                    } else {
                                                        if (b17 == 1) {
                                                            arrayList4.add(new Pair("FileTransfer", 8901));
                                                        } else if (b17 == 5 || b17 == 4) {
                                                            str6 = str9;
                                                            arrayList4.add(new Pair("UcHoService", 8902));
                                                        } else if (b17 == 9) {
                                                            arrayList4.add(new Pair("ExtendCast", 8903));
                                                        } else if (b17 == 10) {
                                                            arrayList4.add(new Pair("AudioSink", 8904));
                                                        } else if (b17 == 11) {
                                                            arrayList4.add(new Pair(str10, 8905));
                                                        } else if (b17 == 12) {
                                                            arrayList4.add(new Pair("CallShare", 8906));
                                                        } else if (b17 == 13) {
                                                            arrayList4.add(new Pair("CameraShare", 8907));
                                                            str6 = str9;
                                                        } else {
                                                            str6 = str9;
                                                            we.h.j(str6, "createNsdServiceInfoList: unknown service type: " + ((int) b17));
                                                        }
                                                        bArr16 = bArr16;
                                                        str10 = str10;
                                                        str6 = str9;
                                                        i12 = 1;
                                                        i28 += i12;
                                                        str9 = str6;
                                                        str10 = str10;
                                                        bArr16 = bArr16;
                                                    }
                                                    i12 = 1;
                                                    i28 += i12;
                                                    str9 = str6;
                                                    str10 = str10;
                                                    bArr16 = bArr16;
                                                }
                                                tag = str9;
                                                nsdServiceInfoM = b6Var.m("_tran._tcp", arrayList4);
                                            }
                                            if (nsdServiceInfoM == null) {
                                                Intrinsics.checkNotNullParameter(tag, "tag");
                                                Intrinsics.checkNotNullParameter("startAdvertisement: nsdServiceInfo is null", str5);
                                                if (lb.f6529c >= 1) {
                                                    Log.e(tag, "TransConnect:startAdvertisement: nsdServiceInfo is null", null);
                                                    return;
                                                }
                                                return;
                                            }
                                            we.h.b(tag, "startRegisterService");
                                            if (b6Var.f9667g) {
                                                we.h.b(tag, "Service already registered, ignore");
                                                return;
                                            }
                                            nsdServiceInfoM.setAttribute("advData", str4);
                                            try {
                                                try {
                                                    if (SdkExtensions.getExtensionVersion(33) >= 3) {
                                                        nsdManager = b6Var.e;
                                                        if (nsdManager != null) {
                                                            nsdManager.registerService(nsdServiceInfoM, 1, new we.i(b6Var), b6Var.f9678t);
                                                        }
                                                    } else {
                                                        we.h.c(tag, "registerService, this android version is too low, please update to tiramisu 3 or higher", null);
                                                    }
                                                    z2 = true;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    z2 = true;
                                                    b6Var.f9667g = z2;
                                                    throw th;
                                                }
                                            } catch (IllegalArgumentException e) {
                                                z2 = true;
                                                try {
                                                    e.printStackTrace();
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    b6Var.f9667g = z2;
                                                    throw th;
                                                }
                                            } catch (Exception e4) {
                                                e4.printStackTrace();
                                                z2 = true;
                                            }
                                            b6Var.f9667g = z2;
                                            return;
                                        }
                                        if (list3.size() == 1) {
                                            List listListOf = CollectionsKt.listOf((Object[]) new Pair[]{list3.get(0), new Pair("HandShake", Integer.valueOf(i27))});
                                            String str11 = (String) ((Pair) list3.get(0)).getFirst();
                                            switch (str11.hashCode()) {
                                                case -2102840471:
                                                    if (str11.equals("AudioSink")) {
                                                        str7 = "_tranAudioSink._tcp";
                                                    } else {
                                                        str7 = "_tran._tcp";
                                                    }
                                                    break;
                                                case -579374182:
                                                    str7 = !str11.equals("CameraShare") ? "_tran._tcp" : "_tranCameraShare._tcp";
                                                    break;
                                                case 86563233:
                                                    if (str11.equals("KeyboardMouseShare")) {
                                                        str7 = "_tranKeyboardMouseShare._tcp";
                                                    } else {
                                                        str7 = "_tran._tcp";
                                                    }
                                                    break;
                                                case 169045401:
                                                    if (str11.equals("ExtendCast")) {
                                                        str7 = "_tranExtendCast._tcp";
                                                    } else {
                                                        str7 = "_tran._tcp";
                                                    }
                                                    break;
                                                case 177154471:
                                                    str7 = !str11.equals("FileTransfer") ? "_tran._tcp" : "_tranFile._tcp";
                                                    break;
                                                case 946458625:
                                                    str7 = !str11.equals("CallShare") ? "_tran._tcp" : "_tranCallShare._tcp";
                                                    break;
                                                case 1575581163:
                                                    str7 = !str11.equals("ScreenCast") ? "_tran._tcp" : "_tranCast._tcp";
                                                    break;
                                                case 2142512288:
                                                    str7 = !str11.equals("UcHoService") ? "_tran._tcp" : "_tranUcHo._tcp";
                                                    break;
                                                default:
                                                    str7 = "_tran._tcp";
                                                    break;
                                            }
                                            nsdServiceInfoM = b6Var2.m(str7, listListOf);
                                        } else {
                                            b6Var2 = b6Var2;
                                            ArrayList arrayList5 = new ArrayList();
                                            arrayList5.add(new Pair("HandShake", Integer.valueOf(i27)));
                                            Iterator it3 = list3.iterator();
                                            while (it3.hasNext()) {
                                                arrayList5.add((Pair) it3.next());
                                            }
                                            nsdServiceInfoM = b6Var2.m("_tran._tcp", arrayList5);
                                        }
                                        b6Var = b6Var2;
                                        tag = str9;
                                        if (nsdServiceInfoM == null) {
                                            Intrinsics.checkNotNullParameter(tag, "tag");
                                            Intrinsics.checkNotNullParameter("startAdvertisement: nsdServiceInfo is null", str5);
                                            if (lb.f6529c >= 1) {
                                                Log.e(tag, "TransConnect:startAdvertisement: nsdServiceInfo is null", null);
                                                return;
                                            }
                                            return;
                                        }
                                        we.h.b(tag, "startRegisterService");
                                        if (b6Var.f9667g) {
                                            we.h.b(tag, "Service already registered, ignore");
                                            return;
                                        }
                                        nsdServiceInfoM.setAttribute("advData", str4);
                                        if (SdkExtensions.getExtensionVersion(33) >= 3) {
                                            nsdManager = b6Var.e;
                                            if (nsdManager != null) {
                                                nsdManager.registerService(nsdServiceInfoM, 1, new we.i(b6Var), b6Var.f9678t);
                                            }
                                        } else {
                                            we.h.c(tag, "registerService, this android version is too low, please update to tiramisu 3 or higher", null);
                                        }
                                        z2 = true;
                                        b6Var.f9667g = z2;
                                        return;
                                    }
                                    str4 = strJoinToString$default;
                                    tag = str3;
                                    str5 = "mes";
                                    b6Var = b6Var2;
                                    nsdServiceInfoM = null;
                                    if (nsdServiceInfoM == null) {
                                        Intrinsics.checkNotNullParameter(tag, "tag");
                                        Intrinsics.checkNotNullParameter("startAdvertisement: nsdServiceInfo is null", str5);
                                        if (lb.f6529c >= 1) {
                                            Log.e(tag, "TransConnect:startAdvertisement: nsdServiceInfo is null", null);
                                            return;
                                        }
                                        return;
                                    }
                                    we.h.b(tag, "startRegisterService");
                                    if (b6Var.f9667g) {
                                        we.h.b(tag, "Service already registered, ignore");
                                        return;
                                    }
                                    nsdServiceInfoM.setAttribute("advData", str4);
                                    if (SdkExtensions.getExtensionVersion(33) >= 3) {
                                        nsdManager = b6Var.e;
                                        if (nsdManager != null) {
                                            nsdManager.registerService(nsdServiceInfoM, 1, new we.i(b6Var), b6Var.f9678t);
                                        }
                                    } else {
                                        we.h.c(tag, "registerService, this android version is too low, please update to tiramisu 3 or higher", null);
                                    }
                                    z2 = true;
                                    b6Var.f9667g = z2;
                                    return;
                                }
                                we.h.g("Ignore protocol version 0x10, use 0x11 instead");
                                b10 = 1;
                                if (i23 != 0) {
                                    i9 = i23;
                                    i10 = iJ;
                                    b11 = b10;
                                    byte bF3 = (byte) ne.b.f();
                                    bArr3 = new byte[4];
                                    bArr3[0] = 0;
                                    bArr3[b11] = 2;
                                    bArr3[2] = bF3;
                                    bArr3[3] = 0;
                                    iA3 = 0;
                                    while (iA3 < i13) {
                                        iA3 = h0.a.a(bArr3[iA3], arrayList3, iA3, b11);
                                    }
                                    if (arrayList3.size() > 1456) {
                                        Intrinsics.checkNotNullParameter("Screen Cast Data Length is too long, it should be less than 1456", "mes");
                                        if (lb.f6529c >= b11) {
                                            Log.e("welinkBLE", "Screen Cast Data Length is too long, it should be less than 1456", null);
                                        }
                                    } else {
                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                    }
                                } else if (i23 != b10) {
                                    if (i23 != 4) {
                                        i9 = i23;
                                        i10 = iJ;
                                        bArr5 = new byte[]{4, 2, (byte) ne.b.f(), 0};
                                        iA5 = 0;
                                        while (iA5 < i16) {
                                            iA5 = h0.a.a(bArr5[iA5], arrayList3, iA5, 1);
                                        }
                                        if (arrayList3.size() > 1456) {
                                            Intrinsics.checkNotNullParameter("Clipboard Share Data Length is too long, it should be less than 1456", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("welinkBLE", "Clipboard Share Data Length is too long, it should be less than 1456", null);
                                            }
                                        } else {
                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                        }
                                    } else if (i23 != 5) {
                                        num2 = num;
                                        if (i23 != 8) {
                                            i9 = i23;
                                            i10 = iJ;
                                            bArr7 = new byte[]{8, 2, (byte) ne.b.f(), 0};
                                            iA7 = 0;
                                            while (iA7 < i18) {
                                                iA7 = h0.a.a(bArr7[iA7], arrayList3, iA7, 1);
                                            }
                                            if (arrayList3.size() > 1456) {
                                                Intrinsics.checkNotNullParameter("Air Cast Data Length is too long, it should be less than 1456", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Air Cast Data Length is too long, it should be less than 1456", null);
                                                }
                                            } else if (num2 != null) {
                                                bArrD = ne.b.d(num2);
                                                while (iA8 < 4) {
                                                }
                                                if (arrayList3.size() > 1456) {
                                                    Intrinsics.checkNotNullParameter("SubCapability Data Length is too long, it should be less than 1456", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("welinkBLE", "SubCapability Data Length is too long, it should be less than 1456", null);
                                                    }
                                                } else {
                                                    byteArray = CollectionsKt.toByteArray(arrayList3);
                                                }
                                            } else {
                                                bArrD = ne.b.d(num2);
                                                while (iA8 < 4) {
                                                }
                                                if (arrayList3.size() > 1456) {
                                                    Intrinsics.checkNotNullParameter("SubCapability Data Length is too long, it should be less than 1456", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("welinkBLE", "SubCapability Data Length is too long, it should be less than 1456", null);
                                                    }
                                                } else {
                                                    byteArray = CollectionsKt.toByteArray(arrayList3);
                                                }
                                            }
                                        } else if (i23 != 251) {
                                            switch (i23) {
                                                case 10:
                                                    bArr9 = new byte[]{10, 2, (byte) ne.b.f(), 0};
                                                    iA12 = 0;
                                                    while (iA12 < i20) {
                                                        iA12 = h0.a.a(bArr9[iA12], arrayList3, iA12, 1);
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("Audio Sink Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "Audio Sink Data Length is too long, it should be less than 1456", null);
                                                        }
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    } else {
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    }
                                                    break;
                                                case 11:
                                                    bArr10 = new byte[]{11, 2, (byte) ne.b.f(), 0};
                                                    iA13 = 0;
                                                    while (iA13 < i21) {
                                                        iA13 = h0.a.a(bArr10[iA13], arrayList3, iA13, 1);
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("Keyboard Mouse Share Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "Keyboard Mouse Share Data Length is too long, it should be less than 1456", null);
                                                        }
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    } else {
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    }
                                                    break;
                                                case 12:
                                                    bArr11 = new byte[]{12, 2, (byte) ne.b.f(), 0};
                                                    iA14 = 0;
                                                    while (iA14 < i22) {
                                                        iA14 = h0.a.a(bArr11[iA14], arrayList3, iA14, 1);
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("Call Share Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "Call Share Data Length is too long, it should be less than 1456", null);
                                                        }
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    } else {
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    }
                                                    break;
                                                case 13:
                                                    bArr12 = new byte[]{13, 2, (byte) ne.b.f(), 0};
                                                    iA15 = 0;
                                                    while (iA15 < i15) {
                                                        iA15 = h0.a.a(bArr12[iA15], arrayList3, iA15, 1);
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("Camera Share Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "Camera Share Data Length is too long, it should be less than 1456", null);
                                                        }
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    } else {
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                        i9 = i23;
                                                        i10 = iJ;
                                                    }
                                                    break;
                                                default:
                                                    i9 = i23;
                                                    i10 = iJ;
                                                    break;
                                            }
                                        } else {
                                            byte[] bArrG3 = ne.b.g(bArr13);
                                            i10 = iJ;
                                            bArr8 = new byte[]{-5, 2, bArrG3[0], bArrG3[1]};
                                            iA9 = 0;
                                            while (iA9 < i19) {
                                                iA9 = h0.a.a(bArr8[iA9], arrayList3, iA9, 1);
                                                bArr8 = bArr8;
                                            }
                                            if (arrayList3.size() > 1456) {
                                                Intrinsics.checkNotNullParameter("Capability Data Length is too long, it should be less than 1456", "mes");
                                                if (lb.f6529c >= 1) {
                                                    Log.e("welinkBLE", "Capability Data Length is too long, it should be less than 1456", null);
                                                }
                                                i9 = i23;
                                            } else {
                                                if (com.welink.protocol.nfbd.a.f4027k.c("1.0")) {
                                                    if (arrayList3.size() + 4 <= 1456) {
                                                        Intrinsics.checkNotNullParameter("Air Parcel Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 2) {
                                                            Log.w("welinkBLE", "Air Parcel Data Length is too long, it should be less than 1456", null);
                                                        }
                                                    } else {
                                                        Intrinsics.checkNotNullParameter("Air Parcel Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 2) {
                                                            Log.w("welinkBLE", "Air Parcel Data Length is too long, it should be less than 1456", null);
                                                        }
                                                    }
                                                    if (arrayList3.size() + 4 <= 1456) {
                                                        i9 = i23;
                                                        Intrinsics.checkNotNullParameter("Screen Cast Data is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 2) {
                                                            Log.w("welinkBLE", "Screen Cast Data is too long, it should be less than 1456", null);
                                                        }
                                                    } else {
                                                        i9 = i23;
                                                        Intrinsics.checkNotNullParameter("Screen Cast Data is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 2) {
                                                            Log.w("welinkBLE", "Screen Cast Data is too long, it should be less than 1456", null);
                                                        }
                                                    }
                                                } else {
                                                    i9 = i23;
                                                }
                                                bArrB = ne.b.b(context);
                                                while (iA10 < 5) {
                                                }
                                                if (arrayList3.size() > 1456) {
                                                    Intrinsics.checkNotNullParameter("Feature Data Length is too long, it should be less than 1456", "mes");
                                                    if (lb.f6529c >= 1) {
                                                        Log.e("welinkBLE", "Feature Data Length is too long, it should be less than 1456", null);
                                                    }
                                                } else if (num2 != null) {
                                                    bArrD2 = ne.b.d(num2);
                                                    while (iA11 < 4) {
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("SubCapability Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "SubCapability Data Length is too long, it should be less than 1456", null);
                                                        }
                                                    } else {
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                    }
                                                } else {
                                                    bArrD2 = ne.b.d(num2);
                                                    while (iA11 < 4) {
                                                    }
                                                    if (arrayList3.size() > 1456) {
                                                        Intrinsics.checkNotNullParameter("SubCapability Data Length is too long, it should be less than 1456", "mes");
                                                        if (lb.f6529c >= 1) {
                                                            Log.e("welinkBLE", "SubCapability Data Length is too long, it should be less than 1456", null);
                                                        }
                                                    } else {
                                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        i9 = i23;
                                        i10 = iJ;
                                        bArr6 = new byte[]{5, 2, (byte) ne.b.f(), 0};
                                        iA6 = 0;
                                        while (iA6 < i17) {
                                            iA6 = h0.a.a(bArr6[iA6], arrayList3, iA6, 1);
                                        }
                                        if (arrayList3.size() > 1456) {
                                            Intrinsics.checkNotNullParameter("Handover Drop Data Length is too long, it should be less than 1456", "mes");
                                            if (lb.f6529c >= 1) {
                                                Log.e("welinkBLE", "Handover Drop Data Length is too long, it should be less than 1456", null);
                                            }
                                        } else {
                                            byteArray = CollectionsKt.toByteArray(arrayList3);
                                        }
                                    }
                                } else {
                                    i9 = i23;
                                    i10 = iJ;
                                    b12 = b10;
                                    byte bF4 = (byte) ne.b.f();
                                    bArr4 = new byte[4];
                                    bArr4[0] = b12;
                                    bArr4[b12] = 2;
                                    bArr4[2] = bF4;
                                    bArr4[3] = 0;
                                    iA4 = 0;
                                    while (iA4 < i14) {
                                        iA4 = h0.a.a(bArr4[iA4], arrayList3, iA4, b12);
                                    }
                                    if (arrayList3.size() > 1456) {
                                        Intrinsics.checkNotNullParameter("Air Parcel Data Length is too long, it should be less than 1456", "mes");
                                        if (lb.f6529c >= b12) {
                                            Log.e("welinkBLE", "Air Parcel Data Length is too long, it should be less than 1456", null);
                                        }
                                    } else {
                                        byteArray = CollectionsKt.toByteArray(arrayList3);
                                    }
                                }
                                if (byteArray != null) {
                                    arrayList.add(Byte.valueOf((byte) (byteArray.length + 3)));
                                    arrayList.add(Byte.valueOf((byte) 22));
                                    arrayList.add(Byte.valueOf((byte) (iM177constructorimpl2 & 255)));
                                    arrayList.add(Byte.valueOf((byte) ((iM177constructorimpl2 >> 8) & 255)));
                                    length2 = byteArray.length;
                                    while (iA2 < length2) {
                                    }
                                } else {
                                    Intrinsics.checkNotNullParameter("Service Data is null, ignore it", "mes");
                                    if (lb.f6529c >= 1) {
                                        Log.e("welinkBLE", "Service Data is null, ignore it", null);
                                    }
                                }
                                size = arrayList.size();
                                if (deviceName.length() > 120 - size) {
                                    int i29 = 118 - size;
                                    we.h.j("AdvertiseTool", "Device Name is too long, it should be less than " + i29);
                                    deviceName = deviceName.substring(0, i29);
                                    Intrinsics.checkNotNullExpressionValue(deviceName, "substring(...)");
                                }
                                bytes = deviceName.getBytes(Charsets.UTF_8);
                                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                                arrayList.add(Byte.valueOf((byte) (bytes.length + 1)));
                                arrayList.add(Byte.valueOf(b14));
                                length = bytes.length;
                                while (iA < length) {
                                }
                                int size3 = arrayList.size();
                                Intrinsics.checkNotNullParameter(arrayList, "<this>");
                                sb2 = new StringBuilder();
                                it = arrayList.iterator();
                                while (it.hasNext()) {
                                    byte bByteValue3 = ((Number) it.next()).byteValue();
                                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                    String str12 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bByteValue3)}, 1));
                                    Intrinsics.checkNotNullExpressionValue(str12, "format(...)");
                                    sb2.append(str12);
                                }
                                String string4 = sb2.toString();
                                Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                                we.h.b("AdvertiseTool", "Advertisement Data size: " + size3 + ", data: " + string4);
                                byte[] byteArray3 = CollectionsKt.toByteArray(arrayList);
                                Intrinsics.checkNotNullParameter(byteArray3, "<this>");
                                Intrinsics.checkNotNullParameter("", "separator");
                                strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(byteArray3, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
                                String string5 = Arrays.toString(bArr13);
                                Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                                StringBuilder sb4 = new StringBuilder("startAdvertisement: ");
                                i11 = i9;
                                sb4.append(i11);
                                sb4.append(", ");
                                sb4.append(string5);
                                sb4.append(", ");
                                int i210 = i10;
                                sb4.append(i210);
                                sb4.append(", ");
                                List list5 = list;
                                sb4.append(list5);
                                sb4.append(", ");
                                sb4.append(strJoinToString$default);
                                str3 = str2;
                                we.h.b(str3, sb4.toString());
                                we.h.b(str3, "createNsdServiceInfoList");
                                if (i11 == -1) {
                                    str4 = strJoinToString$default;
                                    tag = str3;
                                    str5 = "mes";
                                    b6Var = b6Var2;
                                    nsdServiceInfoM = null;
                                } else {
                                    str4 = strJoinToString$default;
                                    tag = str3;
                                    str5 = "mes";
                                    b6Var = b6Var2;
                                    nsdServiceInfoM = null;
                                }
                                if (nsdServiceInfoM == null) {
                                    Intrinsics.checkNotNullParameter(tag, "tag");
                                    Intrinsics.checkNotNullParameter("startAdvertisement: nsdServiceInfo is null", str5);
                                    if (lb.f6529c >= 1) {
                                        Log.e(tag, "TransConnect:startAdvertisement: nsdServiceInfo is null", null);
                                        return;
                                    }
                                    return;
                                }
                                we.h.b(tag, "startRegisterService");
                                if (b6Var.f9667g) {
                                    we.h.b(tag, "Service already registered, ignore");
                                    return;
                                }
                                nsdServiceInfoM.setAttribute("advData", str4);
                                if (SdkExtensions.getExtensionVersion(33) >= 3) {
                                    nsdManager = b6Var.e;
                                    if (nsdManager != null) {
                                        nsdManager.registerService(nsdServiceInfoM, 1, new we.i(b6Var), b6Var.f9678t);
                                    }
                                } else {
                                    we.h.c(tag, "registerService, this android version is too low, please update to tiramisu 3 or higher", null);
                                }
                                z2 = true;
                                b6Var.f9667g = z2;
                                return;
                            }
                            i9 = i23;
                            list = list2;
                            i10 = iJ;
                            str2 = "TranLanController";
                            Intrinsics.checkNotNullParameter("Protocol Version is null, invalid manufacturer data", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("welinkBLE", "Protocol Version is null, invalid manufacturer data", null);
                            }
                            byteArray = null;
                            if (byteArray != null) {
                                arrayList.add(Byte.valueOf((byte) (byteArray.length + 3)));
                                arrayList.add(Byte.valueOf((byte) 22));
                                arrayList.add(Byte.valueOf((byte) (iM177constructorimpl2 & 255)));
                                arrayList.add(Byte.valueOf((byte) ((iM177constructorimpl2 >> 8) & 255)));
                                length2 = byteArray.length;
                                while (iA2 < length2) {
                                }
                            } else {
                                Intrinsics.checkNotNullParameter("Service Data is null, ignore it", "mes");
                                if (lb.f6529c >= 1) {
                                    Log.e("welinkBLE", "Service Data is null, ignore it", null);
                                }
                            }
                            size = arrayList.size();
                            if (deviceName.length() > 120 - size) {
                                int i211 = 118 - size;
                                we.h.j("AdvertiseTool", "Device Name is too long, it should be less than " + i211);
                                deviceName = deviceName.substring(0, i211);
                                Intrinsics.checkNotNullExpressionValue(deviceName, "substring(...)");
                            }
                            bytes = deviceName.getBytes(Charsets.UTF_8);
                            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                            arrayList.add(Byte.valueOf((byte) (bytes.length + 1)));
                            arrayList.add(Byte.valueOf(b14));
                            length = bytes.length;
                            while (iA < length) {
                            }
                            int size4 = arrayList.size();
                            Intrinsics.checkNotNullParameter(arrayList, "<this>");
                            sb2 = new StringBuilder();
                            it = arrayList.iterator();
                            while (it.hasNext()) {
                                byte bByteValue4 = ((Number) it.next()).byteValue();
                                StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                String str13 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(bByteValue4)}, 1));
                                Intrinsics.checkNotNullExpressionValue(str13, "format(...)");
                                sb2.append(str13);
                            }
                            String string6 = sb2.toString();
                            Intrinsics.checkNotNullExpressionValue(string6, "toString(...)");
                            we.h.b("AdvertiseTool", "Advertisement Data size: " + size4 + ", data: " + string6);
                            byte[] byteArray4 = CollectionsKt.toByteArray(arrayList);
                            Intrinsics.checkNotNullParameter(byteArray4, "<this>");
                            Intrinsics.checkNotNullParameter("", "separator");
                            strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(byteArray4, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
                            String string7 = Arrays.toString(bArr13);
                            Intrinsics.checkNotNullExpressionValue(string7, "toString(...)");
                            StringBuilder sb5 = new StringBuilder("startAdvertisement: ");
                            i11 = i9;
                            sb5.append(i11);
                            sb5.append(", ");
                            sb5.append(string7);
                            sb5.append(", ");
                            int i212 = i10;
                            sb5.append(i212);
                            sb5.append(", ");
                            List list6 = list;
                            sb5.append(list6);
                            sb5.append(", ");
                            sb5.append(strJoinToString$default);
                            str3 = str2;
                            we.h.b(str3, sb5.toString());
                            we.h.b(str3, "createNsdServiceInfoList");
                            if (i11 == -1) {
                                str4 = strJoinToString$default;
                                tag = str3;
                                str5 = "mes";
                                b6Var = b6Var2;
                                nsdServiceInfoM = null;
                            } else {
                                str4 = strJoinToString$default;
                                tag = str3;
                                str5 = "mes";
                                b6Var = b6Var2;
                                nsdServiceInfoM = null;
                            }
                            if (nsdServiceInfoM == null) {
                                Intrinsics.checkNotNullParameter(tag, "tag");
                                Intrinsics.checkNotNullParameter("startAdvertisement: nsdServiceInfo is null", str5);
                                if (lb.f6529c >= 1) {
                                    Log.e(tag, "TransConnect:startAdvertisement: nsdServiceInfo is null", null);
                                    return;
                                }
                                return;
                            }
                            we.h.b(tag, "startRegisterService");
                            if (b6Var.f9667g) {
                                we.h.b(tag, "Service already registered, ignore");
                                return;
                            }
                            nsdServiceInfoM.setAttribute("advData", str4);
                            if (SdkExtensions.getExtensionVersion(33) >= 3) {
                                nsdManager = b6Var.e;
                                if (nsdManager != null) {
                                    nsdManager.registerService(nsdServiceInfoM, 1, new we.i(b6Var), b6Var.f9678t);
                                }
                            } else {
                                we.h.c(tag, "registerService, this android version is too low, please update to tiramisu 3 or higher", null);
                            }
                            z2 = true;
                            b6Var.f9667g = z2;
                            return;
                        }
                        return;
                    }
                }
                we.h.c("NearLanManager", "startAdvertisement: tcp server not running", null);
            }
        };
        p pVar = this.f4173g;
        if (pVar != null && p.m(pVar)) {
            f(runnable);
            return;
        }
        if (pVar != null) {
            se.k kVar = p.f4184k;
            o2 socketMethod = o2.WebSocket;
            Intrinsics.checkNotNullParameter(socketMethod, "socketMethod");
            int i9 = u3.$EnumSwitchMapping$0[socketMethod.ordinal()];
            if (i9 == 1) {
                if (pVar.e == null) {
                    pVar.e = new i3(pVar, 80);
                }
                i3 i3Var = pVar.e;
                if (i3Var != null) {
                    i3Var.f9802d = li.l0.p(i3Var.f9801c, null, null, new g3(i3Var, null), 3);
                }
            } else {
                if (i9 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                if (pVar.f == null) {
                    pVar.f = new t3(pVar, 80);
                }
                try {
                    t3 t3Var = pVar.f;
                    if (t3Var != null) {
                        t3Var.e();
                    }
                } catch (ClosedChannelException e) {
                    String mes = "startWebSocketServer start failed: " + e;
                    Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                    Intrinsics.checkNotNullParameter(mes, "mes");
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", mes, "NearLanTcpServer", null);
                    }
                } catch (Exception e4) {
                    String mes2 = "WebSocket server start failed finally: " + e4;
                    Intrinsics.checkNotNullParameter("NearLanTcpServer", "tag");
                    Intrinsics.checkNotNullParameter(mes2, "mes");
                    if (lb.f6529c >= 1) {
                        h0.a.x("TransConnect:", mes2, "NearLanTcpServer", null);
                    }
                }
            }
        }
        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
        we.m.a(1280, 3000L, a(), runnable);
    }

    public final void s() {
        if (this.f4178l == null) {
            we.h.j("NearLanManager", "startAdvertisementTimer: no advertise params");
            return;
        }
        m.c cVar = new m.c(this, 10);
        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
        we.m.a(1282, 3000L, a(), cVar);
    }
}
