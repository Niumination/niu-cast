package se;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.icu.text.SimpleDateFormat;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Message;
import android.os.ext.SdkExtensions;
import android.util.Log;
import com.welink.protocol.ble.EarBudsInfo;
import com.welink.protocol.utils.DeviceInfo;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import k3.lb;
import k3.zb;
import kotlin.Pair;
import kotlin.UByte;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b6 extends we.g {
    public static final k u = new k(q5.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9665c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.welink.protocol.nfbd.m f9666d;
    public final NsdManager e;
    public lc.a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9667g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f9668h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map f9669i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map f9670j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Set f9671k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f9672l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentLinkedQueue f9673m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f9674n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9675o;
    public final Map p;
    public tj.w q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final z5 f9676r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Map f9677s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final a6 f9678t;

    public b6(Context context, com.welink.protocol.nfbd.m mVar) {
        super(false, "NearLanManager");
        this.f9665c = context;
        this.f9668h = new Object();
        Map mapSynchronizedMap = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap, "synchronizedMap(...)");
        this.f9669i = mapSynchronizedMap;
        Map mapSynchronizedMap2 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap2, "synchronizedMap(...)");
        this.f9670j = mapSynchronizedMap2;
        Set setSynchronizedSet = Collections.synchronizedSet(new LinkedHashSet());
        Intrinsics.checkNotNullExpressionValue(setSynchronizedSet, "synchronizedSet(...)");
        this.f9671k = setSynchronizedSet;
        this.f9673m = new ConcurrentLinkedQueue();
        Map mapSynchronizedMap3 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap3, "synchronizedMap(...)");
        this.p = mapSynchronizedMap3;
        Map mapSynchronizedMap4 = Collections.synchronizedMap(new LinkedHashMap());
        Intrinsics.checkNotNullExpressionValue(mapSynchronizedMap4, "synchronizedMap(...)");
        this.f9677s = mapSynchronizedMap4;
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.welink.protocol.nfbd.TranLanController$mBroadcastReceiver$1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context2, Intent intent) {
                we.h.b("TranLanController", "onReceive");
                if (Intrinsics.areEqual(intent != null ? intent.getAction() : null, "android.net.nsd.STATE_CHANGED")) {
                    int intExtra = intent.getIntExtra("nsd_state", -1);
                    if (intExtra == 1) {
                        we.h.b("TranLanController", "NsdManager is disabled");
                    } else if (intExtra != 2) {
                        we.h.b("TranLanController", "NsdManager state is unknown");
                    } else {
                        we.h.b("TranLanController", "NsdManager is enabled");
                    }
                }
            }
        };
        this.f9678t = new a6(this);
        we.h.b("TranLanController", "init");
        this.f9666d = mVar;
        Object systemService = context != null ? context.getSystemService("servicediscovery") : null;
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.nsd.NsdManager");
        this.e = (NsdManager) systemService;
        if (context != null) {
            context.registerReceiver(broadcastReceiver, new IntentFilter("android.net.nsd.STATE_CHANGED"), 2);
        }
        this.f9676r = new z5(this);
    }

    public static final void j(b6 b6Var, NsdServiceInfo nsdServiceInfo) {
        b6Var.getClass();
        Message messageObtain = Message.obtain();
        messageObtain.what = 7937;
        messageObtain.obj = nsdServiceInfo;
        Intrinsics.checkNotNull(messageObtain);
        b6Var.i(messageObtain);
    }

    public static final void k(b6 b6Var) {
        if (b6Var.f9674n || b6Var.f9673m.isEmpty()) {
            return;
        }
        synchronized (b6Var.f9673m) {
            v5 v5Var = (v5) b6Var.f9673m.poll();
            if (v5Var == null) {
                return;
            }
            b6Var.f9674n = true;
            synchronized (b6Var.p) {
                try {
                    if (b6Var.p.containsKey(Integer.valueOf(v5Var.hashCode()))) {
                        we.h.j("TranLanController", "Service Request already registered");
                    } else {
                        b6Var.p.put(Integer.valueOf(v5Var.hashCode()), v5Var);
                        we.h.b("TranLanController", "Service Request registered, hashCode: " + v5Var.hashCode());
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            we.h.b("TranLanController", "Resolving Service: " + v5Var.f10034a.getServiceName());
            b6Var.q(v5Var, false);
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:25:0x00f9  */
    @Override // we.g
    public final void b(Message msg) {
        z5 z5Var;
        z5 z5Var2;
        String serviceName;
        Map map;
        r5 r5Var;
        lc.a aVar;
        Intrinsics.checkNotNullParameter(msg, "msg");
        h0.a.C(msg.what, "handleThreadMessage, what: ", "TranLanController");
        int i8 = msg.what;
        Object obj = null;
        switch (i8) {
            case 7936:
                Object obj2 = msg.obj;
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type android.net.nsd.NsdServiceInfo");
                NsdServiceInfo nsdServiceInfo = (NsdServiceInfo) obj2;
                we.h.b("TranLanController", "Device Discovered Attributes: " + CollectionsKt___CollectionsKt.joinToString$default(nsdServiceInfo.getAttributes().keySet(), ",", null, null, 0, null, null, 62, null));
                int iN = n(nsdServiceInfo);
                if (iN == 3 || iN == 4) {
                    we.h.b("TranLanController", "Service is duplicate or p2p network: " + nsdServiceInfo.getServiceName() + ", Service hashCode: " + nsdServiceInfo.hashCode() + ", ignore");
                    return;
                }
                p(nsdServiceInfo);
                for (v5 v5Var : this.p.values()) {
                    we.h.b("TranLanController", "Service DiscoveredRequest Dump: " + v5Var.f10034a.getServiceName() + ", Req hashCode: " + v5Var.hashCode() + ", Found hashCode: " + nsdServiceInfo.hashCode());
                }
                if (nsdServiceInfo.getAttributes().containsKey("advData") || nsdServiceInfo.getAttributes().containsKey("cmbSvc") || nsdServiceInfo.getAttributes().containsKey("cmdSvc")) {
                    we.h.b("TranLanController", "Device Discovered: " + nsdServiceInfo.getServiceName() + ", mRegisteredRequest size: " + this.p.size());
                    synchronized (this.p) {
                        try {
                            for (v5 v5Var2 : this.p.values()) {
                                String serviceType = v5Var2.f10034a.getServiceType();
                                Intrinsics.checkNotNullExpressionValue(serviceType, "getServiceType(...)");
                                String strReplace = new Regex("^\\.|\\.$").replace(serviceType, "");
                                String serviceType2 = nsdServiceInfo.getServiceType();
                                Intrinsics.checkNotNullExpressionValue(serviceType2, "getServiceType(...)");
                                if (StringsKt__StringsJVMKt.equals(strReplace, new Regex("^\\.|\\.$").replace(serviceType2, ""), true) && Intrinsics.areEqual(v5Var2.f10034a.getServiceName(), nsdServiceInfo.getServiceName())) {
                                    we.h.b("TranLanController", "Service Request Found: " + v5Var2.f10034a.getServiceName() + ", Req hashCode: " + v5Var2.hashCode() + ", Found hashCode: " + nsdServiceInfo.hashCode());
                                    if (iN == 1 && (z5Var = this.f9676r) != null) {
                                        String serviceName2 = nsdServiceInfo.getServiceName();
                                        Intrinsics.checkNotNullExpressionValue(serviceName2, "getServiceName(...)");
                                        z5Var.h(serviceName2);
                                    }
                                    z5 z5Var3 = this.f9676r;
                                    if (z5Var3 != null) {
                                        z5Var3.a(nsdServiceInfo);
                                    }
                                    z5 z5Var4 = this.f9676r;
                                    if (z5Var4 != null) {
                                        z5Var4.b(v5Var2);
                                    }
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                o(nsdServiceInfo);
                return;
            case 7937:
                NsdServiceInfo service = (NsdServiceInfo) msg.obj;
                if (service != null) {
                    we.h.b("TranLanController", "Device Lost: " + service.getServiceName() + ", Service hashCode: " + service.hashCode());
                    z5 z5Var5 = this.f9676r;
                    if (z5Var5 != null) {
                        Intrinsics.checkNotNullParameter(service, "service");
                        for (Object obj3 : z5Var5.f10081b) {
                            if (Intrinsics.areEqual(((NsdServiceInfo) obj3).getServiceName(), service.getServiceName())) {
                                obj = obj3;
                                if (obj != null) {
                                    z5Var2 = this.f9676r;
                                    if (z5Var2 != null) {
                                        String serviceName3 = service.getServiceName();
                                        Intrinsics.checkNotNullExpressionValue(serviceName3, "getServiceName(...)");
                                        z5Var2.h(serviceName3);
                                    }
                                    serviceName = service.getServiceName();
                                    map = this.f9677s;
                                    if (map.containsKey(serviceName) && (r5Var = (r5) map.remove(service.getServiceName())) != null && (aVar = this.f) != null) {
                                        aVar.invoke(r5Var, Boolean.FALSE);
                                    }
                                }
                            }
                        }
                        if (obj != null) {
                            z5Var2 = this.f9676r;
                            if (z5Var2 != null) {
                                String serviceName4 = service.getServiceName();
                                Intrinsics.checkNotNullExpressionValue(serviceName4, "getServiceName(...)");
                                z5Var2.h(serviceName4);
                            }
                            serviceName = service.getServiceName();
                            map = this.f9677s;
                            if (map.containsKey(serviceName)) {
                                aVar.invoke(r5Var, Boolean.FALSE);
                            }
                        }
                    }
                    synchronized (this.p) {
                        try {
                            LinkedHashSet<v5> linkedHashSet = new LinkedHashSet();
                            for (v5 v5Var3 : this.p.values()) {
                                we.h.b("TranLanController", "Service Lost Request Dump: " + v5Var3.f10034a.getServiceName() + ", Req hashCode: " + v5Var3.hashCode() + ", Found hashCode: " + service.hashCode());
                                String serviceType3 = v5Var3.f10034a.getServiceType();
                                Intrinsics.checkNotNullExpressionValue(serviceType3, "getServiceType(...)");
                                String strReplace2 = new Regex("^\\.|\\.$").replace(serviceType3, "");
                                String serviceType4 = service.getServiceType();
                                Intrinsics.checkNotNullExpressionValue(serviceType4, "getServiceType(...)");
                                if (StringsKt__StringsJVMKt.equals(strReplace2, new Regex("^\\.|\\.$").replace(serviceType4, ""), true) && Intrinsics.areEqual(v5Var3.f10034a.getServiceName(), service.getServiceName())) {
                                    z5 z5Var6 = this.f9676r;
                                    if (z5Var6 != null) {
                                        z5Var6.f(service);
                                    }
                                    z5 z5Var7 = this.f9676r;
                                    if (z5Var7 != null) {
                                        z5Var7.g(v5Var3);
                                    }
                                    linkedHashSet.add(v5Var3);
                                }
                            }
                            for (v5 v5Var4 : linkedHashSet) {
                                s(v5Var4);
                                this.p.remove(Integer.valueOf(v5Var4.hashCode()));
                            }
                            Unit unit2 = Unit.INSTANCE;
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
                we.h.b("TranLanController", "Device Lost");
                return;
            case 7938:
                Object obj4 = msg.obj;
                Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type android.net.nsd.NsdServiceInfo");
                o.d.z("Service Registered: ", ((NsdServiceInfo) obj4).getServiceName(), "TranLanController");
                tj.w wVar = this.q;
                if (wVar != null) {
                    we.h.b("NearLanManager", "onAdvertiseStarted");
                    ((com.welink.protocol.nfbd.m) wVar.f10262b).f4180n = true;
                    return;
                }
                return;
            case 7939:
                we.h.b("TranLanController", "Service Unregistered");
                tj.w wVar2 = this.q;
                if (wVar2 != null) {
                    we.h.b("NearLanManager", "onAdvertiseStopped");
                    com.welink.protocol.nfbd.m mVar = (com.welink.protocol.nfbd.m) wVar2.f10262b;
                    mVar.f4180n = false;
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 20483;
                    Intrinsics.checkNotNull(messageObtain);
                    mVar.i(messageObtain);
                    return;
                }
                return;
            case 7940:
                Object obj5 = msg.obj;
                Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type android.net.nsd.NsdServiceInfo");
                NsdServiceInfo nsdServiceInfo2 = (NsdServiceInfo) obj5;
                we.h.b("TranLanController", "Service Update: " + nsdServiceInfo2.getServiceName());
                o(nsdServiceInfo2);
                return;
            default:
                we.h.c("TranLanController", "Unknown message: " + i8, null);
                return;
        }
    }

    public final void l() {
        s5 s5Var = new s5(this, "_tran._tcp");
        NsdManager nsdManager = this.e;
        if (nsdManager != null) {
            nsdManager.discoverServices("_tran._tcp", 1, s5Var);
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public final NsdServiceInfo m(String str, List list) throws JSONException {
        String strJoinToString$default;
        we.h.b("TranLanController", "createNsdServiceList");
        NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
        String str2 = new SimpleDateFormat("ddHHmmss", Locale.getDefault()).format(new Date());
        BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
        byte[] bArrM = ne.b.m();
        if (bArrM != null) {
            Intrinsics.checkNotNullParameter(bArrM, "<this>");
            Intrinsics.checkNotNullParameter("", "separator");
            strJoinToString$default = ArraysKt___ArraysKt.joinToString$default(bArrM, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new qg.y0(16), 30, (Object) null);
        } else {
            strJoinToString$default = null;
        }
        nsdServiceInfo.setServiceName("transConnectService-" + strJoinToString$default + "-" + str2);
        nsdServiceInfo.setServiceType(str);
        if (Intrinsics.areEqual(str, "_tran._tcp")) {
            nsdServiceInfo.setPort(9999);
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str3 = (String) pair.component1();
                int iIntValue = ((Number) pair.component2()).intValue();
                switch (str3.hashCode()) {
                    case -2102840471:
                        if (!str3.equals("AudioSink")) {
                        }
                        break;
                    case -579374182:
                        if (!str3.equals("CameraShare")) {
                        }
                        break;
                    case 86563233:
                        if (!str3.equals("KeyboardMouseShare")) {
                        }
                        break;
                    case 169045401:
                        if (!str3.equals("ExtendCast")) {
                        }
                        break;
                    case 177154471:
                        if (!str3.equals("FileTransfer")) {
                        }
                        break;
                    case 946458625:
                        if (!str3.equals("CallShare")) {
                        }
                        break;
                    case 1575581163:
                        if (!str3.equals("ScreenCast")) {
                        }
                        break;
                    case 2142512288:
                        if (!str3.equals("UcHoService")) {
                        }
                        break;
                    default:
                        continue;
                }
                nsdServiceInfo.setPort(iIntValue);
            }
        }
        JSONObject jSONObject = new JSONObject();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Pair pair2 = (Pair) it2.next();
            jSONObject.put((String) pair2.component1(), ((Number) pair2.component2()).intValue());
        }
        String string = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        nsdServiceInfo.setAttribute("cmbSvc", string);
        return nsdServiceInfo;
    }

    public final int n(NsdServiceInfo nsdServiceInfo) {
        List<InetAddress> listListOf;
        List listSplit$default;
        boolean zContainsKey = this.f9677s.containsKey(nsdServiceInfo.getServiceName());
        if (SdkExtensions.getExtensionVersion(33) >= 7) {
            listListOf = nsdServiceInfo.getHostAddresses();
            Intrinsics.checkNotNull(listListOf);
        } else {
            listListOf = CollectionsKt.listOf(nsdServiceInfo.getHost());
        }
        com.welink.protocol.nfbd.m mVar = this.f9666d;
        if (mVar != null && (mVar.q || mVar.f4182r)) {
            for (InetAddress inetAddress : listListOf) {
                if (inetAddress instanceof Inet6Address) {
                    Inet6Address inet6Address = (Inet6Address) inetAddress;
                    if (inet6Address.isLinkLocalAddress()) {
                        String hostAddress = inet6Address.getHostAddress();
                        String str = (hostAddress == null || (listSplit$default = StringsKt__StringsKt.split$default(hostAddress, new String[]{"%"}, false, 0, 6, (Object) null)) == null) ? null : (String) CollectionsKt.getOrNull(listSplit$default, 1);
                        NetworkInterface scopedInterface = inet6Address.getScopedInterface();
                        String name = scopedInterface != null ? scopedInterface.getName() : null;
                        if (name != null && StringsKt__StringsJVMKt.startsWith$default(name, "p2p", false, 2, null)) {
                            we.h.b("TranLanController", "Found p2p interface from scopedInterface: ".concat(name));
                            return zContainsKey ? 3 : 4;
                        }
                        if (str != null && StringsKt__StringsJVMKt.startsWith$default(str, "p2p", false, 2, null)) {
                            we.h.b("TranLanController", "Found p2p interface from interfaceName: ".concat(str));
                            return zContainsKey ? 3 : 4;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return zContainsKey ? 1 : 2;
    }

    public final void o(NsdServiceInfo nsdServiceInfo) {
        r5 r5Var;
        lc.a aVar;
        synchronized (this.f9677s) {
            try {
                if (this.f9677s.containsKey(nsdServiceInfo.getServiceName()) && (r5Var = (r5) this.f9677s.get(nsdServiceInfo.getServiceName())) != null && (aVar = this.f) != null) {
                    aVar.invoke(r5Var, Boolean.TRUE);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:126:0x035b  */
    /* JADX WARN: Code duplicated, block: B:228:0x06ca  */
    /* JADX WARN: Code duplicated, block: B:25:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:277:0x07c5 A[PHI: r2 r50 r51 r52 r53
      0x07c5: PHI (r2v7 java.lang.Throwable) = (r2v6 java.lang.Throwable), (r2v8 java.lang.Throwable) binds: [B:275:0x07c2, B:272:0x07b0] A[DONT_GENERATE, DONT_INLINE]
      0x07c5: PHI (r50v3 java.util.Iterator<java.util.Map$Entry<java.lang.String, byte[]>>) = 
      (r50v2 java.util.Iterator<java.util.Map$Entry<java.lang.String, byte[]>>)
      (r50v4 java.util.Iterator<java.util.Map$Entry<java.lang.String, byte[]>>)
     binds: [B:275:0x07c2, B:272:0x07b0] A[DONT_GENERATE, DONT_INLINE]
      0x07c5: PHI (r51v4 java.lang.String) = (r51v3 java.lang.String), (r51v5 java.lang.String) binds: [B:275:0x07c2, B:272:0x07b0] A[DONT_GENERATE, DONT_INLINE]
      0x07c5: PHI (r52v3 int) = (r52v2 int), (r52v4 int) binds: [B:275:0x07c2, B:272:0x07b0] A[DONT_GENERATE, DONT_INLINE]
      0x07c5: PHI (r53v3 int) = (r53v2 int), (r53v4 int) binds: [B:275:0x07c2, B:272:0x07b0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:280:0x07eb A[LOOP:6: B:278:0x07e5->B:280:0x07eb, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:69:0x020a  */
    /* JADX WARN: Instruction removed from duplicated block: B:280:0x07eb, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v64, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.welink.protocol.utils.DeviceInfo] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v42, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v44 */
    /* JADX WARN: Type inference failed for: r6v45 */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.LinkedHashMap, java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v13, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v41 */
    public final void p(NsdServiceInfo nsdServiceInfo) {
        List<InetAddress> listListOf;
        String strM;
        int i8;
        int i9;
        Throwable th2;
        JSONObject jSONObject;
        Iterator<String> itKeys;
        DeviceInfo deviceInfo;
        int i10;
        LinkedHashMap linkedHashMapB;
        String strC;
        String strC2;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        byte b9;
        String str;
        ArrayList arrayList;
        int iO;
        byte[] bArr;
        byte b10;
        String str2;
        int i11;
        String str3;
        ConcurrentHashMap concurrentHashMap3;
        byte b11;
        ConcurrentHashMap concurrentHashMap4;
        ConcurrentHashMap concurrentHashMap5;
        ConcurrentHashMap concurrentHashMap6;
        int i12 = 2;
        int i13 = 10;
        we.h.b("TranLanController", "processServiceInfo");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        String serviceName = nsdServiceInfo.getServiceName();
        String serviceType = nsdServiceInfo.getServiceType();
        int port = nsdServiceInfo.getPort();
        if (SdkExtensions.getExtensionVersion(33) >= 7) {
            listListOf = nsdServiceInfo.getHostAddresses();
            Intrinsics.checkNotNull(listListOf);
        } else {
            listListOf = CollectionsKt.listOf(nsdServiceInfo.getHost());
        }
        Throwable th3 = null;
        if (this.f9666d != null) {
            Intrinsics.checkNotNull(serviceType);
            strM = com.welink.protocol.nfbd.m.m(serviceType);
        } else {
            strM = null;
        }
        if (strM != null && !Intrinsics.areEqual(strM, "All")) {
            we.h.b("TranLanController", "Found Service: ".concat(strM));
            linkedHashSet.add(new Pair(strM, Integer.valueOf(port)));
        }
        String strJoinToString$default = CollectionsKt___CollectionsKt.joinToString$default(listListOf, ",", null, null, 0, null, new qg.y0(i13), 30, null);
        StringBuilder sbP = h0.a.p("Service Name: ", serviceName, ", Type: ", serviceType, ", Host: ");
        sbP.append(strJoinToString$default);
        sbP.append(", Port: ");
        sbP.append(port);
        we.h.b("TranLanController", sbP.toString());
        Map<String, byte[]> attributes = nsdServiceInfo.getAttributes();
        Intrinsics.checkNotNullExpressionValue(attributes, "getAttributes(...)");
        Iterator<Map.Entry<String, byte[]>> it = attributes.entrySet().iterator();
        ?? r7 = 0;
        while (it.hasNext()) {
            Map.Entry<String, byte[]> next = it.next();
            we.h.b("TranLanController", "Service Attribute: " + ((Object) next.getKey()) + " = " + next.getValue());
            String key = next.getKey();
            if (key == null) {
                i8 = i12;
                i9 = i13;
                serviceName = serviceName;
                it = it;
                th2 = th3;
            } else {
                int iHashCode = key.hashCode();
                if (iHashCode == -1357014520) {
                    i8 = i12;
                    i9 = i13;
                    serviceName = serviceName;
                    it = it;
                    th2 = th3;
                    if (key.equals("cmbSvc")) {
                        byte[] value = next.getValue();
                        Intrinsics.checkNotNullExpressionValue(value, "<get-value>(...)");
                        jSONObject = new JSONObject(new String(value, Charsets.UTF_8));
                        itKeys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                        while (itKeys.hasNext()) {
                            String next2 = itKeys.next();
                            int iOptInt = jSONObject.optInt(next2, 0);
                            linkedHashSet.add(new Pair(next2, Integer.valueOf(iOptInt)));
                            we.h.b("TranLanController", "Service: " + next2 + ", Port: " + iOptInt);
                        }
                    }
                } else if (iHashCode == -1356954938) {
                    i8 = i12;
                    i9 = i13;
                    serviceName = serviceName;
                    it = it;
                    th2 = th3;
                    if (key.equals("cmdSvc")) {
                        byte[] value2 = next.getValue();
                        Intrinsics.checkNotNullExpressionValue(value2, "<get-value>(...)");
                        jSONObject = new JSONObject(new String(value2, Charsets.UTF_8));
                        itKeys = jSONObject.keys();
                        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
                        while (itKeys.hasNext()) {
                            String next3 = itKeys.next();
                            int iOptInt2 = jSONObject.optInt(next3, 0);
                            linkedHashSet.add(new Pair(next3, Integer.valueOf(iOptInt2)));
                            we.h.b("TranLanController", "Service: " + next3 + ", Port: " + iOptInt2);
                        }
                    }
                } else if (iHashCode == -1132442883 && key.equals("advData")) {
                    byte[] value3 = next.getValue();
                    Intrinsics.checkNotNullExpressionValue(value3, "<get-value>(...)");
                    String advertisementStringData = new String(value3, Charsets.UTF_8);
                    BluetoothAdapter bluetoothAdapter = ne.b.f8183a;
                    Intrinsics.checkNotNullParameter(advertisementStringData, "advertisementStringData");
                    byte[] bArrB = m3.q.b(advertisementStringData);
                    ?? linkedHashMap = new LinkedHashMap();
                    if (bArrB.length < i12) {
                        linkedHashMap = th3;
                    } else {
                        int i14 = 0;
                        while (i14 < bArrB.length) {
                            int i15 = i14 + 1;
                            int iM177constructorimpl = UByte.m177constructorimpl(bArrB[i14]) & UByte.MAX_VALUE;
                            if (i15 + iM177constructorimpl > bArrB.length) {
                                we.h.j("WLAN-ELAN", "Invalid Bluetooth SIG data, error length, return parsed result");
                                break;
                            }
                            int i16 = i14 + i12;
                            byte b12 = bArrB[i15];
                            byte[] bArrCopyOfRange = ArraysKt.copyOfRange(bArrB, i16, (i16 + iM177constructorimpl) - 1);
                            i14 = i16 + (iM177constructorimpl - 1);
                            linkedHashMap.put(Byte.valueOf(b12), bArrCopyOfRange);
                        }
                    }
                    if (linkedHashMap == 0) {
                        Intrinsics.checkNotNullParameter("WLAN-ELAN", "tag");
                        Intrinsics.checkNotNullParameter("Invalid Bluetooth SIG data, return", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("WLAN-ELAN", "TransConnect:Invalid Bluetooth SIG data, return", th3);
                        }
                        i8 = i12;
                        serviceName = serviceName;
                        it = it;
                        th2 = th3;
                        r7 = th2;
                        i9 = 10;
                    } else {
                        byte b13 = (byte) 255;
                        if (linkedHashMap.containsKey(Byte.valueOf(b13))) {
                            byte[] bArr2 = (byte[]) linkedHashMap.get(Byte.valueOf(b13));
                            byte[] bArr3 = (byte[]) linkedHashMap.get(Byte.valueOf((byte) 22));
                            byte[] bArr4 = (byte[]) linkedHashMap.get(Byte.valueOf((byte) 9));
                            if (bArr2 == null) {
                                i8 = i12;
                                i9 = 10;
                            } else if (bArr2[0] == 66 && bArr2[1] == 9 && bArr3 != null && bArr3[0] == 53 && bArr3[1] == -3) {
                                byte[] byteArray = CollectionsKt.toByteArray(ArraysKt.drop(bArr2, 2));
                                byte[] byteArray2 = CollectionsKt.toByteArray(ArraysKt.drop(bArr3, 2));
                                String str4 = bArr4 != null ? new String(bArr4, Charsets.UTF_8) : null;
                                if (byteArray.length >= 6) {
                                    we.h.h("WLAN-ELAN", "manufacturerData is :");
                                    m3.q.f(byteArray);
                                    byte b14 = byteArray[0];
                                    if (b14 == 16) {
                                        i9 = 10;
                                        i8 = 2;
                                        deviceInfo = null;
                                    } else if (b14 != 2) {
                                        if (b14 != 14 && byteArray[5] == 0) {
                                            byte b15 = byteArray[4];
                                            int iM177constructorimpl2 = UByte.m177constructorimpl(b15) & UByte.MAX_VALUE;
                                            if (iM177constructorimpl2 == 16) {
                                                byte[] byteArray3 = CollectionsKt.toByteArray(ArraysKt.take(byteArray, 4));
                                                byte b16 = byteArray3[0];
                                                if ((b16 == 2 || b16 == 14) && byteArray.length < 8) {
                                                    serviceName = serviceName;
                                                    it = it;
                                                    i8 = 2;
                                                    deviceInfo = null;
                                                    i9 = 10;
                                                } else {
                                                    byte b17 = byteArray3[1];
                                                    byte[] byteArray4 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray3, 2));
                                                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                                    deviceInfo = new DeviceInfo(b16, b17, h0.a.o(new Object[]{Byte.valueOf(byteArray4[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray4[0])}, 1, "%02x", "format(...)")), (String) null, Boolean.FALSE, (EarBudsInfo) null, 0, 0, 0, 0, (String) null, (byte[]) null, (List) null, (String) null, (String) null, (byte) 0, 0, 0, 0, (String) null, 2097088);
                                                    i9 = 10;
                                                    i8 = 2;
                                                }
                                            } else if (17 <= iM177constructorimpl2 && iM177constructorimpl2 < 256) {
                                                byte[] byteArray5 = CollectionsKt.toByteArray(ArraysKt.take(byteArray, 4));
                                                byte b18 = byteArray5[0];
                                                if (b18 == 13 || b18 == 18 || b18 == 15 || b18 == 21 || b18 == 10) {
                                                    byte[] bArr5 = new byte[6];
                                                    int iM177constructorimpl3 = UByte.m177constructorimpl(b15) & UByte.MAX_VALUE;
                                                    if (17 > iM177constructorimpl3) {
                                                        i10 = 20;
                                                    } else if (iM177constructorimpl3 < 20) {
                                                        if (byteArray2.length < 6) {
                                                            we.h.c("WLAN-ELAN", "Invalid service data length, return", null);
                                                        } else {
                                                            ArraysKt.copyInto(byteArray2, bArr5, 0, 0, 6);
                                                            strC2 = m3.q.c(bArr5);
                                                            linkedHashMapB = zb.b(CollectionsKt.toByteArray(ArraysKt.drop(byteArray2, 6)));
                                                            if (linkedHashMapB == null) {
                                                            }
                                                        }
                                                        deviceInfo = null;
                                                        i9 = 10;
                                                        i8 = 2;
                                                    } else {
                                                        i10 = 20;
                                                    }
                                                    if (i10 > iM177constructorimpl3 || iM177constructorimpl3 >= 256) {
                                                        linkedHashMapB = null;
                                                        strC2 = null;
                                                    } else {
                                                        linkedHashMapB = zb.b(byteArray2);
                                                        if (linkedHashMapB != null) {
                                                            strC = null;
                                                            for (Map.Entry entry : linkedHashMapB.entrySet()) {
                                                                byte bByteValue = ((Number) entry.getKey()).byteValue();
                                                                byte[] bArr6 = (byte[]) entry.getValue();
                                                                if (bByteValue == b13) {
                                                                    strC = m3.q.c(bArr6);
                                                                }
                                                            }
                                                            Unit unit = Unit.INSTANCE;
                                                        } else {
                                                            strC = null;
                                                        }
                                                        strC2 = strC;
                                                    }
                                                } else {
                                                    linkedHashMapB = null;
                                                    strC2 = null;
                                                }
                                                byte b19 = byteArray5[1];
                                                byte[] byteArray6 = CollectionsKt.toByteArray(ArraysKt.drop(byteArray5, 2));
                                                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                                String strO = h0.a.o(new Object[]{Byte.valueOf(byteArray6[1])}, 1, "%02x", "format(...)", o.d.q(new Object[]{Byte.valueOf(byteArray6[0])}, 1, "%02x", "format(...)"));
                                                if (b18 == 13 || b18 == 18 || b18 == 15 || b18 == 21 || b18 == 10) {
                                                    ConcurrentHashMap concurrentHashMap7 = new ConcurrentHashMap();
                                                    ConcurrentHashMap concurrentHashMap8 = new ConcurrentHashMap();
                                                    byte b20 = b18;
                                                    ConcurrentHashMap concurrentHashMap9 = new ConcurrentHashMap();
                                                    String str5 = str4 == null ? "" : str4;
                                                    if (linkedHashMapB != null) {
                                                        Iterator it2 = linkedHashMapB.entrySet().iterator();
                                                        String str6 = str5;
                                                        int i17 = 0;
                                                        byte b21 = 0;
                                                        bArr = null;
                                                        ArrayList arrayListU = null;
                                                        String strC3 = null;
                                                        while (it2.hasNext()) {
                                                            Map.Entry entry2 = (Map.Entry) it2.next();
                                                            Iterator it3 = it2;
                                                            byte bByteValue2 = ((Number) entry2.getKey()).byteValue();
                                                            ConcurrentHashMap concurrentHashMap10 = concurrentHashMap9;
                                                            byte[] bArr7 = (byte[]) entry2.getValue();
                                                            Iterator<Map.Entry<String, byte[]>> it4 = it;
                                                            String str7 = serviceName;
                                                            ConcurrentHashMap concurrentHashMap11 = concurrentHashMap8;
                                                            if (bByteValue2 == ((byte) 254) || bByteValue2 == ((byte) 253)) {
                                                                str4 = str4;
                                                                byte[] bArr8 = bArr7;
                                                                concurrentHashMap3 = concurrentHashMap10;
                                                                ConcurrentHashMap concurrentHashMap12 = concurrentHashMap11;
                                                                b11 = b20;
                                                                Intrinsics.checkNotNullParameter(bArr8, "<this>");
                                                                StringBuilder sb2 = new StringBuilder();
                                                                int length = bArr8.length;
                                                                int iE = 0;
                                                                while (iE < length) {
                                                                    byte b22 = bArr8[iE];
                                                                    StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
                                                                    iE = h0.a.e(new Object[]{Byte.valueOf(b22)}, 1, "%02x ", "format(...)", sb2, iE, 1);
                                                                    concurrentHashMap12 = concurrentHashMap12;
                                                                    length = length;
                                                                    bArr8 = bArr8;
                                                                }
                                                                concurrentHashMap4 = concurrentHashMap12;
                                                                String string = sb2.toString();
                                                                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                                                                we.h.b("WLAN-ELAN", "Device information is :" + string);
                                                            } else if (bByteValue2 == b13) {
                                                                String strC4 = m3.q.c(bArr7);
                                                                if (!Intrinsics.areEqual(strC2, strC4)) {
                                                                    strC2 = strC4;
                                                                }
                                                                str4 = str4;
                                                                concurrentHashMap3 = concurrentHashMap10;
                                                                concurrentHashMap4 = concurrentHashMap11;
                                                                b11 = b20;
                                                            } else {
                                                                byte b23 = (byte) 252;
                                                                BluetoothAdapter bluetoothAdapter2 = ne.b.f8183a;
                                                                if (bByteValue2 == b23) {
                                                                    Intrinsics.checkNotNullParameter(bArr7, "<this>");
                                                                    StringBuilder sb3 = new StringBuilder();
                                                                    int length2 = bArr7.length;
                                                                    int iE2 = 0;
                                                                    while (iE2 < length2) {
                                                                        byte b24 = bArr7[iE2];
                                                                        StringCompanionObject stringCompanionObject4 = StringCompanionObject.INSTANCE;
                                                                        iE2 = h0.a.e(new Object[]{Byte.valueOf(b24)}, 1, "%02x ", "format(...)", sb3, iE2, 1);
                                                                        bArr7 = bArr7;
                                                                        b20 = b20;
                                                                        length2 = length2;
                                                                        concurrentHashMap11 = concurrentHashMap11;
                                                                        concurrentHashMap10 = concurrentHashMap10;
                                                                    }
                                                                    byte[] bArr9 = bArr7;
                                                                    concurrentHashMap5 = concurrentHashMap10;
                                                                    concurrentHashMap6 = concurrentHashMap11;
                                                                    b11 = b20;
                                                                    String string2 = sb3.toString();
                                                                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                                                                    we.h.b("WLAN-ELAN", "Device Feature is :" + string2);
                                                                    if (bArr9.length != 0) {
                                                                        h0.a.C(UByte.m177constructorimpl(bArr9[0]) & UByte.MAX_VALUE, "Device Wireless Capability is :", "WLAN-ELAN");
                                                                        if (bArr9.length > 1) {
                                                                            byte[] byteArray7 = CollectionsKt.toByteArray(ArraysKt.drop(bArr9, 1));
                                                                            arrayListU = ne.b.u(byteArray7);
                                                                            if (ne.b.q(byteArray7)) {
                                                                                we.h.b("WLAN-ELAN", "Device Wireless Type is Bluetooth EDR");
                                                                            }
                                                                        }
                                                                        if (bArr9.length > 3) {
                                                                            h0.a.C(UByte.m177constructorimpl(bArr9[3]) & UByte.MAX_VALUE, "Unparsed Device Wireless Capability is :", "WLAN-ELAN");
                                                                        }
                                                                    }
                                                                } else {
                                                                    concurrentHashMap5 = concurrentHashMap10;
                                                                    concurrentHashMap6 = concurrentHashMap11;
                                                                    b11 = b20;
                                                                    if (bByteValue2 == ((byte) 173)) {
                                                                        we.h.b("WLAN-ELAN", "Device Mac Address is :".concat(m3.q.c(bArr7)));
                                                                        strC3 = m3.q.c(bArr7);
                                                                    } else if (bByteValue2 == ((byte) 239)) {
                                                                        String str8 = new String(bArr7, Charsets.UTF_8);
                                                                        if ((str4 == null || str8.length() <= str4.length()) && str4 != null && str4.length() != 0) {
                                                                            str8 = str6;
                                                                        }
                                                                        we.h.b("WLAN-ELAN", "Device Name is :" + ((Object) str8));
                                                                        str6 = str8;
                                                                    } else if (bByteValue2 == ((byte) 1) || bByteValue2 == ((byte) 0) || bByteValue2 == ((byte) 8) || bByteValue2 == ((byte) 10) || bByteValue2 == ((byte) 5) || bByteValue2 == ((byte) 4) || bByteValue2 == ((byte) 11) || bByteValue2 == ((byte) 12) || bByteValue2 == ((byte) 13)) {
                                                                        int iM177constructorimpl4 = UByte.m177constructorimpl(bByteValue2) & UByte.MAX_VALUE;
                                                                        ArrayList arrayListU2 = ne.b.u(bArr7);
                                                                        str4 = str4;
                                                                        concurrentHashMap7.put(Byte.valueOf(bByteValue2), Integer.valueOf(UByte.m177constructorimpl(bByteValue2) & UByte.MAX_VALUE));
                                                                        concurrentHashMap6.put(Byte.valueOf(bByteValue2), bArr7);
                                                                        concurrentHashMap3 = concurrentHashMap5;
                                                                        concurrentHashMap3.put(Byte.valueOf(bByteValue2), ne.b.u(bArr7));
                                                                        bArr = bArr7;
                                                                        concurrentHashMap4 = concurrentHashMap6;
                                                                        arrayListU = arrayListU2;
                                                                        i17 = iM177constructorimpl4;
                                                                    } else {
                                                                        if (bByteValue2 == ((byte) 251)) {
                                                                            int iM177constructorimpl5 = UByte.m177constructorimpl(bByteValue2) & UByte.MAX_VALUE;
                                                                            concurrentHashMap7.put(Byte.valueOf(bByteValue2), Integer.valueOf(UByte.m177constructorimpl(bByteValue2) & UByte.MAX_VALUE));
                                                                            concurrentHashMap6.put(Byte.valueOf(bByteValue2), bArr7);
                                                                            bArr = bArr7;
                                                                            concurrentHashMap4 = concurrentHashMap6;
                                                                            i17 = iM177constructorimpl5;
                                                                        } else {
                                                                            if (bByteValue2 == ((byte) l5.a.CODE_SCANNER_CAMERA_PERMISSION_NOT_GRANTED)) {
                                                                                b21 = bArr7[0];
                                                                            } else {
                                                                                StringCompanionObject stringCompanionObject5 = StringCompanionObject.INSTANCE;
                                                                                we.h.j("WLAN-ELAN", h0.a.o(new Object[]{Byte.valueOf(bByteValue2)}, 1, "%02x", "format(...)", "Unknown TLV type: 0x"));
                                                                            }
                                                                            concurrentHashMap4 = concurrentHashMap6;
                                                                        }
                                                                        concurrentHashMap3 = concurrentHashMap5;
                                                                    }
                                                                }
                                                                concurrentHashMap4 = concurrentHashMap6;
                                                                concurrentHashMap3 = concurrentHashMap5;
                                                            }
                                                            concurrentHashMap8 = concurrentHashMap4;
                                                            concurrentHashMap9 = concurrentHashMap3;
                                                            str4 = str4;
                                                            it2 = it3;
                                                            b20 = b11;
                                                            it = it4;
                                                            serviceName = str7;
                                                        }
                                                        serviceName = serviceName;
                                                        it = it;
                                                        concurrentHashMap = concurrentHashMap8;
                                                        concurrentHashMap2 = concurrentHashMap9;
                                                        b9 = b20;
                                                        i9 = 10;
                                                        i8 = 2;
                                                        Unit unit2 = Unit.INSTANCE;
                                                        iO = i17;
                                                        b10 = b21;
                                                        str = str6;
                                                        arrayList = arrayListU;
                                                        str2 = strC3;
                                                    } else {
                                                        serviceName = serviceName;
                                                        it = it;
                                                        concurrentHashMap = concurrentHashMap8;
                                                        concurrentHashMap2 = concurrentHashMap9;
                                                        b9 = b20;
                                                        i9 = 10;
                                                        i8 = 2;
                                                        str = str5;
                                                        arrayList = null;
                                                        iO = 0;
                                                        bArr = null;
                                                        b10 = 0;
                                                        str2 = null;
                                                    }
                                                    int iM177constructorimpl6 = UByte.m177constructorimpl(b15) & UByte.MAX_VALUE;
                                                    if (iM177constructorimpl6 != 16) {
                                                        if (17 <= iM177constructorimpl6) {
                                                            i11 = 20;
                                                            if (iM177constructorimpl6 >= 20) {
                                                            }
                                                            str3 = "1.0";
                                                        } else {
                                                            i11 = 20;
                                                        }
                                                        if (i11 > iM177constructorimpl6 || iM177constructorimpl6 >= 256) {
                                                            str3 = null;
                                                        } else {
                                                            str3 = "1.0";
                                                        }
                                                    } else {
                                                        str3 = null;
                                                    }
                                                    k kVar = com.welink.protocol.nfbd.a.f4027k;
                                                    if (kVar.c("1.0")) {
                                                        iO = ne.b.o(concurrentHashMap7, concurrentHashMap);
                                                    }
                                                    int i18 = iO;
                                                    byte[] bArrP = kVar.c("1.0") ? ne.b.p(concurrentHashMap7, concurrentHashMap) : bArr;
                                                    List listN = arrayList;
                                                    if (kVar.c("1.0")) {
                                                        listN = ne.b.n(concurrentHashMap2, arrayList);
                                                    }
                                                    List list = listN;
                                                    deviceInfo = new DeviceInfo(b9, b19, strO, strC2 == null ? str2 == null ? "0xC2:0x00:0x00:0x00:0x00:0x00" : str2 : strC2, Boolean.FALSE, (EarBudsInfo) null, 10, i18, b10, 0, str3, bArrP, list, str, str2, (byte) 0, 0, 0, 0, (String) null, 2064384);
                                                } else {
                                                    serviceName = serviceName;
                                                    it = it;
                                                    i9 = 10;
                                                    deviceInfo = null;
                                                    i8 = 2;
                                                }
                                            }
                                        }
                                        i9 = 10;
                                        i8 = 2;
                                        deviceInfo = null;
                                    } else {
                                        i8 = 2;
                                        i9 = 10;
                                        deviceInfo = null;
                                    }
                                } else {
                                    i9 = 10;
                                    i8 = 2;
                                    deviceInfo = null;
                                }
                                r7 = deviceInfo;
                                th2 = null;
                            } else {
                                i9 = 10;
                                i8 = 2;
                            }
                            Intrinsics.checkNotNullParameter("WLAN-ELAN", "tag");
                            Intrinsics.checkNotNullParameter("Invalid manufacturer data, return", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("WLAN-ELAN", "TransConnect:Invalid manufacturer data, return", null);
                            }
                            th2 = null;
                            r7 = 0;
                        } else {
                            i8 = i12;
                            serviceName = serviceName;
                            it = it;
                            i9 = 10;
                            Intrinsics.checkNotNullParameter("WLAN-ELAN", "tag");
                            Intrinsics.checkNotNullParameter("No manufacturer data, return", "mes");
                            if (lb.f6529c >= 1) {
                                th2 = null;
                                Log.e("WLAN-ELAN", "TransConnect:No manufacturer data, return", null);
                            } else {
                                th2 = null;
                            }
                            r7 = th2;
                        }
                    }
                    we.h.b("TranLanController", "Device Info: " + r7);
                } else {
                    i8 = i12;
                    i9 = i13;
                    serviceName = serviceName;
                    it = it;
                    th2 = th3;
                }
            }
            th3 = th2;
            it = it;
            serviceName = serviceName;
            i13 = i9;
            i12 = i8;
            r7 = r7;
        }
        String str9 = serviceName;
        if (r7 == 0 && linkedHashSet.isEmpty()) {
            return;
        }
        synchronized (this.f9668h) {
            this.f9677s.put(str9, new r5(r7, CollectionsKt.toList(linkedHashSet), listListOf));
            Unit unit3 = Unit.INSTANCE;
        }
    }

    public final void q(v5 v5Var, boolean z2) {
        synchronized (v5Var) {
            try {
                if (Build.VERSION.SDK_INT < 34 || z2) {
                    if (v5Var.f10035b == null) {
                        v5Var.f10035b = new t5(this);
                    }
                    t5 t5Var = v5Var.f10035b;
                    if (t5Var != null) {
                        if (SdkExtensions.getExtensionVersion(33) >= 3) {
                            NsdManager nsdManager = this.e;
                            if (nsdManager != null) {
                                nsdManager.resolveService(v5Var.f10034a, new we.i(this), t5Var);
                            }
                            v5Var.f10037d = true;
                            we.h.b("TranLanController", "Request Service Resolve: " + v5Var.f10034a.getServiceName() + ", listener hashCode: " + t5Var.hashCode());
                        } else {
                            Intrinsics.checkNotNullParameter("TranLanController", "tag");
                            Intrinsics.checkNotNullParameter("Request Service Resolve is not supported in this version of Android", "mes");
                            if (lb.f6529c >= 1) {
                                Log.e("TranLanController", "TransConnect:Request Service Resolve is not supported in this version of Android", null);
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                } else {
                    if (v5Var.f10036c == null) {
                        v5Var.f10036c = new u5(this, v5Var.f10034a);
                    }
                    we.h.b("TranLanController", "Start Register Service Info Callback for resolving: " + v5Var.f10034a.getServiceName());
                    u5 u5Var = v5Var.f10036c;
                    if (u5Var != null) {
                        we.h.b("TranLanController", "Request Service Info Callback: " + v5Var.f10034a.getServiceName());
                        NsdManager nsdManager2 = this.e;
                        if (nsdManager2 != null) {
                            nsdManager2.registerServiceInfoCallback(v5Var.f10034a, new we.i(this), kotlin.reflect.jvm.internal.a.a(u5Var));
                        }
                        we.h.b("TranLanController", "Request Service Info Callback: " + v5Var.f10034a.getServiceName());
                    }
                    v5Var.f10037d = true;
                    Unit unit2 = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void r() {
        if (this.f9669i.isEmpty() && !this.f9667g) {
            we.h.j("TranLanController", "stopAdvertisement: device isn't advertising");
            return;
        }
        we.h.b("TranLanController", "stopRegisterService");
        if (!this.f9667g) {
            we.h.b("TranLanController", "Service not registered, ignore");
        }
        try {
            try {
                NsdManager nsdManager = this.e;
                if (nsdManager != null) {
                    nsdManager.unregisterService(this.f9678t);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            this.f9667g = false;
        }
    }

    public final void s(v5 v5Var) {
        if (v5Var.f10037d) {
            int i8 = Build.VERSION.SDK_INT;
            NsdManager nsdManager = this.e;
            if (i8 >= 34) {
                u5 u5Var = v5Var.f10036c;
                if (u5Var != null) {
                    if (nsdManager != null) {
                        nsdManager.unregisterServiceInfoCallback(kotlin.reflect.jvm.internal.a.a(u5Var));
                    }
                    v5Var.f10037d = false;
                    return;
                }
                return;
            }
            t5 t5Var = v5Var.f10035b;
            if (t5Var != null) {
                if (SdkExtensions.getExtensionVersion(33) < 7) {
                    Intrinsics.checkNotNullParameter("TranLanController", "tag");
                    Intrinsics.checkNotNullParameter("removeServiceRequest: stopServiceResolution is not supported in this version of Android", "mes");
                    if (lb.f6529c >= 1) {
                        Log.e("TranLanController", "TransConnect:removeServiceRequest: stopServiceResolution is not supported in this version of Android", null);
                        return;
                    }
                    return;
                }
                we.h.b("TranLanController", "removeServiceRequest: stopServiceResolution, " + v5Var.f10034a.getServiceName() + ", listener hashCode: " + t5Var.hashCode());
                if (nsdManager != null) {
                    nsdManager.stopServiceResolution(t5Var);
                }
                v5Var.f10037d = false;
            }
        }
    }
}
