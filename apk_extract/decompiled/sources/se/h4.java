package se;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Build;
import android.util.Log;
import androidx.work.WorkRequest;
import com.welink.protocol.nfbd.NearDevice;
import com.welink.protocol.wifi.P2pTool$mP2pReceiver$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import k3.lb;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class h4 extends we.g {
    public static final u0 q = new u0(f4.INSTANCE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ye.d f9762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i2 f9763d;
    public boolean e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n6 f9764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public n6 f9765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ka.d f9766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public a0.g f9769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap.KeySetView f9770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9771n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f9772o;
    public boolean p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h4(Context mContext) {
        super(false, "NearWifiP2pManager");
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f9764g = new p6();
        this.f9765h = new p6();
        this.f9767j = ConcurrentHashMap.newKeySet();
        this.f9768k = ConcurrentHashMap.newKeySet();
        this.f9770m = ConcurrentHashMap.newKeySet();
        this.f9771n = 320098816;
        g4 p2pActionListener = new g4(this);
        ye.d dVar = new ye.d(mContext);
        this.f9762c = dVar;
        Intrinsics.checkNotNullParameter(p2pActionListener, "p2pActionListener");
        if (dVar.f11174c == null) {
            dVar.f11174c = p2pActionListener;
            Object systemService = mContext.getSystemService("wifip2p");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
            WifiP2pManager wifiP2pManager = (WifiP2pManager) systemService;
            dVar.f11172a = wifiP2pManager;
            dVar.f11173b = wifiP2pManager != null ? wifiP2pManager.initialize(mContext, mContext.getMainLooper(), p2pActionListener) : null;
            P2pTool$mP2pReceiver$1 p2pTool$mP2pReceiver$1 = dVar.f11181l;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.wifi.p2p.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
            intentFilter.addAction("android.net.wifi.p2p.THIS_DEVICE_CHANGED");
            intentFilter.addAction("android.net.wifi.p2p.action.WIFI_P2P_PERSISTENT_GROUPS_CHANGED");
            mContext.registerReceiver(p2pTool$mP2pReceiver$1, intentFilter, 2);
        }
    }

    public static /* synthetic */ void F(h4 h4Var, BluetoothDevice bluetoothDevice, WifiP2pDevice wifiP2pDevice, NearDevice nearDevice, long j8, int i8) {
        if ((i8 & 8) != 0) {
            j8 = WorkRequest.MIN_BACKOFF_MILLIS;
        }
        h4Var.E(bluetoothDevice, wifiP2pDevice, nearDevice, j8, 100);
    }

    public static final void j(h4 h4Var, WifiP2pGroup wifiP2pGroup, WifiP2pInfo wifiP2pInfo, Collection collection) {
        h4Var.getClass();
        we.h.h("NearP2pManager", "reportOtherDeviceP2pConnectedNotify");
        ConcurrentHashMap.KeySetView executorListenerPairs = h4Var.f9767j;
        Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
        synchronized (executorListenerPairs) {
            try {
                ConcurrentHashMap.KeySetView executorListenerPairs2 = h4Var.f9767j;
                Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                if (executorListenerPairs2.isEmpty()) {
                    we.h.h("NearP2pManager", "Report Other Device P2P Connected Notify over monitored listener");
                    ConcurrentHashMap.KeySetView monitoredListenerPairs = h4Var.f9768k;
                    Intrinsics.checkNotNullExpressionValue(monitoredListenerPairs, "monitoredListenerPairs");
                    synchronized (monitoredListenerPairs) {
                        try {
                            ConcurrentHashMap.KeySetView<Pair> monitoredListenerPairs2 = h4Var.f9768k;
                            Intrinsics.checkNotNullExpressionValue(monitoredListenerPairs2, "monitoredListenerPairs");
                            for (Pair pair : monitoredListenerPairs2) {
                                ((Executor) pair.getFirst()).execute(new r(pair, wifiP2pGroup, wifiP2pInfo, collection, 4));
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } else {
                    ConcurrentHashMap.KeySetView<Pair> executorListenerPairs3 = h4Var.f9767j;
                    Intrinsics.checkNotNullExpressionValue(executorListenerPairs3, "executorListenerPairs");
                    for (Pair pair2 : executorListenerPairs3) {
                        ((Executor) pair2.getFirst()).execute(new r(pair2, wifiP2pGroup, wifiP2pInfo, collection, 3));
                    }
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static /* synthetic */ void x(h4 h4Var, int i8, int i9) {
        if ((i9 & 2) != 0) {
            i8 = -1;
        }
        h4Var.w(true, i8, null, null, null);
    }

    public final void A(i2 i2Var, ka.d dVar, int i8) {
        a0.b bVar = new a0.b(this, i2Var, dVar, i8, 3);
        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
        we.m.a(258, 1000L, a(), bVar);
    }

    public final void B(i2 p2pInfo, ka.d callback, int i8) {
        WifiP2pManager wifiP2pManager;
        WifiP2pManager wifiP2pManager2;
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f9766i = callback;
        ye.d dVar = this.f9762c;
        if (i8 != 1) {
            if (i8 != 2) {
                we.h.b("NearP2pManager", "startP2p: mode is not support");
                return;
            }
            we.h.h("NearP2pManager", "startP2p: start p2p go");
            NearDevice nearDevice = p2pInfo.f9797g;
            List list = nearDevice != null ? nearDevice.f3897t : null;
            this.e = true;
            this.f9763d = p2pInfo;
            if (p2pInfo.f9793a != null) {
                if (dVar != null) {
                    dVar.f11178i = list;
                    dVar.f11179j = p2pInfo;
                    WifiP2pManager.Channel channel = dVar.f11173b;
                    if (channel == null || (wifiP2pManager2 = dVar.f11172a) == null) {
                        return;
                    }
                    wifiP2pManager2.requestGroupInfo(channel, dVar.f11187t);
                    return;
                }
                return;
            }
            if (dVar != null) {
                dVar.f11178i = list;
                dVar.f11179j = null;
                WifiP2pManager.Channel channel2 = dVar.f11173b;
                if (channel2 == null || (wifiP2pManager = dVar.f11172a) == null) {
                    return;
                }
                wifiP2pManager.requestGroupInfo(channel2, dVar.f11187t);
                return;
            }
            return;
        }
        we.h.h("NearP2pManager", "startP2p: start p2p gc");
        if (Intrinsics.areEqual(p2pInfo, this.f9763d) && this.f) {
            we.h.j("NearP2pManager", "startP2p: p2pInfo is same, ignore it");
            return;
        }
        this.f9763d = p2pInfo;
        if (dVar != null && dVar.f11184o != 0) {
            dVar.f11184o = 0;
            dVar.f11180k = null;
            dVar.f11179j = null;
            dVar.p = null;
        }
        this.f = true;
        if (dVar != null) {
            String str = p2pInfo.f9793a;
            String str2 = p2pInfo.f9794b;
            String str3 = p2pInfo.f9796d;
            int i9 = p2pInfo.f9795c;
            int i10 = p2pInfo.f9798h;
            if (dVar.f11184o == 0) {
                qe.g gVar = dVar.p;
                if (!Intrinsics.areEqual(gVar != null ? gVar.f9018b : null, "02:00:00:00:00:00")) {
                    we.h.g("connectP2pDevice: now connect {" + str + "}");
                    dVar.e = str;
                    dVar.f11175d = str2;
                    dVar.f = str3;
                    dVar.f11176g = i9;
                    dVar.f11177h = i10;
                    WifiP2pManager wifiP2pManager3 = dVar.f11172a;
                    if (wifiP2pManager3 != null) {
                        WifiP2pManager.Channel channel3 = dVar.f11173b;
                        Intrinsics.checkNotNull(channel3);
                        wifiP2pManager3.requestGroupInfo(channel3, dVar.f11182m);
                    }
                    dVar.p = new qe.g("02:00:00:00:00:00", i10, "192.168.44.1", true);
                    return;
                }
            }
            we.h.g("connectP2pDevice: has connect this device before, do not need connect it again, ignore");
        }
    }

    public final void C() {
        b0.b bVar = new b0.b(101, 3, this);
        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
        we.m.a(256, 0L, a(), bVar);
    }

    public final void D(BluetoothDevice bluetoothDevice, WifiP2pDevice p2pOwnerDevice, NearDevice nearDevice) {
        Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
        E(bluetoothDevice, p2pOwnerDevice, nearDevice, 0L, 101);
    }

    public final void E(BluetoothDevice bluetoothDevice, WifiP2pDevice p2pOwnerDevice, NearDevice nearDevice, long j8, int i8) {
        Intrinsics.checkNotNullParameter(p2pOwnerDevice, "p2pOwnerDevice");
        e4 e4Var = new e4(this, i8, bluetoothDevice, p2pOwnerDevice, nearDevice, 0);
        ConcurrentHashMap concurrentHashMap = we.m.f10734a;
        we.m.a(257, j8, a(), e4Var);
    }

    public final boolean G() {
        if (this.f9769l == null) {
            we.h.b("NearP2pManager", "mP2pGroupOwnerRemoveRunnable is null, do nothing");
            return false;
        }
        Intrinsics.checkNotNullParameter("NearP2pManager", "tag");
        Intrinsics.checkNotNullParameter("triggerP2pGroupOwnerRemoveRunnable", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearP2pManager", "TransConnect:triggerP2pGroupOwnerRemoveRunnable", null);
        }
        this.f9772o = true;
        a0.g gVar = this.f9769l;
        if (gVar != null) {
            f(gVar);
        }
        return true;
    }

    public final boolean H(int i8, String moduleName) {
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        if (this.f9771n == i8) {
            we.h.j(moduleName, "onResetRecoveryState: P2p reset succeed over same moduleId");
            return false;
        }
        if (k()) {
            we.h.h(moduleName, "onResetRecoveryState: P2p reset succeed over cancelP2pOwnerConnectTimer");
            return true;
        }
        if (G()) {
            we.h.h(moduleName, "onResetRecoveryState: P2p reset succeed over triggerP2pGroupOwnerRemoveRunnable");
            return true;
        }
        we.h.j(moduleName, "onResetRecoveryState: Not found any p2p connection timer, do nothing");
        return false;
    }

    public final void I(int i8) {
        synchronized (this) {
            try {
                switch (i8) {
                    case 320098817:
                    case 320098818:
                    case 320098819:
                    case 320098820:
                    case 320098821:
                    case 320098822:
                    case 320098823:
                    case 320098824:
                        q.getClass();
                        we.h.b("NearP2pManager", "unSetModuleId: moduleId is ".concat(u0.c(i8)));
                        this.f9770m.remove(Integer.valueOf(i8));
                        break;
                    default:
                        Intrinsics.checkNotNullParameter("NearP2pManager", "tag");
                        Intrinsics.checkNotNullParameter("unSetModuleId: moduleId is not support", "mes");
                        if (lb.f6529c >= 1) {
                            Log.e("NearP2pManager", "TransConnect:unSetModuleId: moduleId is not support", null);
                        }
                        break;
                }
                if (this.f9770m.isEmpty()) {
                    this.f9771n = 320098816;
                    we.h.b("NearP2pManager", "unSetModuleId: all moduleId is unregistered, enter monitor mode");
                } else {
                    ConcurrentHashMap.KeySetView mModuleIdList = this.f9770m;
                    Intrinsics.checkNotNullExpressionValue(mModuleIdList, "mModuleIdList");
                    Iterator it = CollectionsKt.reversed(mModuleIdList).iterator();
                    if (it.hasNext()) {
                        int iIntValue = ((Number) it.next()).intValue();
                        this.f9771n = iIntValue;
                        q.getClass();
                        we.h.b("NearP2pManager", "unSetModuleId: set mCurrentModuleId to ".concat(u0.c(iIntValue)));
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void J(b4 listener, int i8) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConcurrentHashMap.KeySetView executorListenerPairs = this.f9767j;
        Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
        synchronized (executorListenerPairs) {
            try {
                this.f9767j.removeIf(new q1(1, new sb.a(listener, 3)));
                if (this.f9767j.isEmpty()) {
                    we.h.h("NearP2pManager", "unregisterListener: list empty and enter monitor mode, ignore it");
                }
                I(i8);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean k() {
        if (!we.m.e(257)) {
            we.h.j("NearP2pManager", "P2P_OWNER_CONNECT_TIMER is not running, do nothing");
            return false;
        }
        we.h.b("NearP2pManager", "Force trigger P2P_OWNER_CONNECT_TIMER timeout");
        this.f9772o = true;
        we.m.g(257);
        return true;
    }

    public final boolean l() {
        if (k()) {
            we.h.h("NearP2pManager", "cancelSuspendP2pConnectTimer: P2p reset succeed over cancelP2pOwnerConnectTimer");
            return true;
        }
        if (G()) {
            we.h.h("NearP2pManager", "cancelSuspendP2pConnectTimer: P2p reset succeed over triggerP2pGroupOwnerRemoveRunnable");
            return true;
        }
        we.h.j("NearP2pManager", "cancelSuspendP2pConnectTimer: Not found any p2p connection timer, do nothing");
        return false;
    }

    public final void m(i2 p2pInfo, int i8) {
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        if (i8 == 1) {
            this.f9764g.a(this, p2pInfo, 1, null);
        } else if (i8 != 2) {
            we.h.b("NearP2pManager", "connect: mode is not support");
        } else {
            this.f9765h.a(this, p2pInfo, 2, null);
        }
    }

    public final void n(i2 p2pInfo, int i8) {
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        if (i8 == 1) {
            n6 n6Var = this.f9765h;
            if (n6Var instanceof p6) {
                this.f9764g.a(this, p2pInfo, 1, null);
                return;
            } else {
                n6Var.a(this, p2pInfo, 1, null);
                return;
            }
        }
        if (i8 != 2) {
            we.h.b("NearP2pManager", "connect: mode is not support");
            return;
        }
        n6 n6Var2 = this.f9764g;
        if (n6Var2 instanceof p6) {
            this.f9765h.a(this, p2pInfo, 2, null);
        } else {
            n6Var2.a(this, p2pInfo, 2, null);
        }
    }

    public final void o() {
        n6 n6Var = this.f9765h;
        if (!(n6Var instanceof p6)) {
            n6Var.c(this, 2, null);
            return;
        }
        n6 n6Var2 = this.f9764g;
        if (n6Var2 instanceof p6) {
            we.h.b("NearP2pManager", "P2p device is not connected");
        } else {
            n6Var2.c(this, 1, null);
        }
    }

    public final void p(int i8, ka.d callback) {
        WifiP2pManager wifiP2pManager;
        int i9;
        h4 h4Var;
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f9766i = callback;
        if (i8 == 1) {
            we.h.h("NearP2pManager", "disconnectP2p: disconnect p2p gc");
            ka.d dVar = this.f9766i;
            if (dVar != null) {
                we.h.b((String) dVar.f6817b, "GroupClientDisconnectingResult result=true");
                h4 h4Var2 = (h4) dVar.f6816a;
                if (h4Var2 != null) {
                    q6 newState = new q6();
                    Intrinsics.checkNotNullParameter(newState, "newState");
                    h4Var2.f9764g = newState;
                }
            }
        } else if (i8 != 2) {
            we.h.b("NearP2pManager", "disconnectP2p: mode is not support");
        } else {
            we.h.h("NearP2pManager", "disconnectP2p: disconnect p2p go");
            ka.d dVar2 = this.f9766i;
            if (dVar2 != null && (h4Var = (h4) dVar2.f6816a) != null) {
                q6 newState2 = new q6();
                Intrinsics.checkNotNullParameter(newState2, "newState");
                h4Var.f9765h = newState2;
            }
        }
        if (i8 == 1 || i8 == 2) {
            ye.d dVar3 = this.f9762c;
            if (dVar3 == null || (i9 = dVar3.f11184o) != 2) {
                if (dVar3 == null || (wifiP2pManager = dVar3.f11172a) == null) {
                    return;
                }
                wifiP2pManager.removeGroup(dVar3.f11173b, new ye.b(dVar3, 6));
                return;
            }
            if (i9 == 2) {
                WifiP2pManager wifiP2pManager2 = dVar3.f11172a;
                if (wifiP2pManager2 != null) {
                    wifiP2pManager2.removeGroup(dVar3.f11173b, new ye.b(dVar3, 6));
                    return;
                }
                return;
            }
            WifiP2pManager.Channel channel = dVar3.f11173b;
            if (channel != null) {
                WifiP2pManager wifiP2pManager3 = dVar3.f11172a;
                if (wifiP2pManager3 != null) {
                    wifiP2pManager3.cancelConnect(channel, new ye.b(dVar3, 2));
                    return;
                }
                return;
            }
            if (i9 != 0) {
                Intrinsics.checkNotNullParameter("P2P may be disconnected already", "mes");
                if (lb.f6529c >= 2) {
                    Log.w("welinkBLE", "P2P may be disconnected already", null);
                }
                dVar3.f11184o = 0;
                dVar3.f11180k = null;
            }
        }
    }

    public final boolean q() {
        return ((this.f9765h instanceof p6) && (this.f9764g instanceof p6)) ? false : true;
    }

    public final boolean r() {
        return !(this.f9764g instanceof p6);
    }

    public final boolean s(b4 listener) {
        boolean z2;
        Intrinsics.checkNotNullParameter(listener, "listener");
        ConcurrentHashMap.KeySetView executorListenerPairs = this.f9767j;
        Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
        synchronized (executorListenerPairs) {
            try {
                ConcurrentHashMap.KeySetView executorListenerPairs2 = this.f9767j;
                Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                z2 = false;
                if (executorListenerPairs2 == null || !executorListenerPairs2.isEmpty()) {
                    Iterator it = executorListenerPairs2.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.areEqual(((Pair) it.next()).getSecond(), listener)) {
                            z2 = true;
                            break;
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z2;
    }

    public final void t(i2 p2pInfo, ka.d callback, int i8) {
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ye.d dVar = this.f9762c;
        if (i8 == 1) {
            if (this.f9764g instanceof l6) {
                this.p = true;
                if (dVar != null) {
                    dVar.f();
                }
                A(p2pInfo, callback, i8);
                return;
            }
            n6 n6Var = this.f9765h;
            if (!(n6Var instanceof l6) && !(n6Var instanceof m6)) {
                B(p2pInfo, callback, i8);
                we.h.b("NearP2pManager", "recoveryDisconnect: p2p device is not connected");
                return;
            } else {
                this.p = true;
                if (dVar != null) {
                    dVar.f();
                }
                A(p2pInfo, callback, i8);
                return;
            }
        }
        if (i8 != 2) {
            we.h.b("NearP2pManager", "recoveryConnect: mode is not support");
            return;
        }
        n6 n6Var2 = this.f9765h;
        if ((n6Var2 instanceof l6) || (n6Var2 instanceof m6)) {
            this.p = true;
            if (dVar != null) {
                dVar.f();
            }
            A(p2pInfo, callback, i8);
            return;
        }
        if (!(this.f9764g instanceof l6)) {
            B(p2pInfo, callback, i8);
            we.h.b("NearP2pManager", "recoveryDisconnect: p2p device is not connected");
        } else {
            this.p = true;
            if (dVar != null) {
                dVar.f();
            }
            A(p2pInfo, callback, i8);
        }
    }

    public final void u(we.i executor, b4 listener, int i8) {
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(listener, "listener");
        we.h.b("NearP2pManager", "registerListener: listener:" + listener);
        we.g gVar = executor.f10727a;
        we.h.b("NearP2pManager", "registerListener: isHandlerExecutor:true, handler:" + gVar);
        ConcurrentHashMap.KeySetView executorListenerPairs = this.f9767j;
        Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
        synchronized (executorListenerPairs) {
            try {
                ConcurrentHashMap.KeySetView executorListenerPairs2 = this.f9767j;
                Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                if (executorListenerPairs2 == null || !executorListenerPairs2.isEmpty()) {
                    Iterator it = executorListenerPairs2.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Pair pair = (Pair) it.next();
                            if (pair.getFirst() instanceof we.i) {
                                Object first = pair.getFirst();
                                Intrinsics.checkNotNull(first, "null cannot be cast to non-null type com.welink.protocol.utils.NearHandlerExecutor");
                                if (((we.i) first).f10727a == gVar && pair.getSecond() == listener) {
                                    we.h.b("NearP2pManager", "registerListener: pair already exists in executorListenerPairs");
                                    break;
                                }
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
                we.h.b("NearP2pManager", "registerListener: executorListenerPairs add new pair");
                this.f9767j.add(TuplesKt.to(executor, listener));
                z(i8);
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void v(WifiP2pInfo wifiP2pInfo, Collection collection) {
        we.h.h("NearP2pManager", "sendWifiDirectGroupClientConnectedNotify");
        if (Build.VERSION.SDK_INT >= 35 && wifiP2pInfo != null && wifiP2pInfo.groupFormed && wifiP2pInfo.isGroupOwner) {
            h0.a.u(collection.size(), "Group Owner get connected, start to check client online, total online client count ", "NearP2pManager");
            Iterator it = collection.iterator();
            int i8 = 0;
            while (it.hasNext()) {
                WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) it.next();
                if (wifiP2pDevice.getIpAddress() != null) {
                    i8++;
                    we.h.b("NearP2pManager", "Group Client IP address: " + wifiP2pDevice.getIpAddress() + ", MAC address: " + wifiP2pDevice.deviceAddress + ", count: " + i8);
                }
            }
            if (i8 < collection.size() || collection.isEmpty()) {
                we.h.j("NearP2pManager", "Group Client is not online all, wait for it");
                return;
            }
        }
        if (we.m.e(257)) {
            we.m.c(257);
            this.f9772o = false;
        }
        this.f9763d = null;
        this.e = false;
        ka.d dVar = this.f9766i;
        if (dVar != null) {
            we.h.b((String) dVar.f6817b, "GroupClientClientOnlineResult result=true");
            h4 h4Var = (h4) dVar.f6816a;
            if (h4Var != null) {
                l6 newState = new l6();
                Intrinsics.checkNotNullParameter(newState, "newState");
                h4Var.f9765h = newState;
            }
        }
        ConcurrentHashMap.KeySetView executorListenerPairs = this.f9767j;
        Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
        synchronized (executorListenerPairs) {
            try {
                ConcurrentHashMap.KeySetView<Pair> executorListenerPairs2 = this.f9767j;
                Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                for (Pair pair : executorListenerPairs2) {
                    ((Executor) pair.getFirst()).execute(new a0.g(pair, 17, wifiP2pInfo, collection));
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0016  */
    /* JADX WARN: Code duplicated, block: B:14:0x001a  */
    /* JADX WARN: Code duplicated, block: B:16:0x0020  */
    /* JADX WARN: Code duplicated, block: B:28:0x005c  */
    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:32:0x0071  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:36:0x0089  */
    /* JADX WARN: Code duplicated, block: B:38:0x008f  */
    /* JADX WARN: Code duplicated, block: B:40:0x009e  */
    /* JADX WARN: Code duplicated, block: B:42:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:45:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:50:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:51:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:59:0x00f6 A[Catch: all -> 0x0112, LOOP:0: B:57:0x00f0->B:59:0x00f6, LOOP_END, TryCatch #0 {all -> 0x0112, blocks: (B:56:0x00e5, B:57:0x00f0, B:59:0x00f6, B:62:0x0114), top: B:67:0x00e5 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0022, code lost:
    
        if ((r0 instanceof se.m6) == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(final boolean r11, int r12, final android.bluetooth.BluetoothDevice r13, final android.net.wifi.p2p.WifiP2pDevice r14, final com.welink.protocol.nfbd.NearDevice r15) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: se.h4.w(boolean, int, android.bluetooth.BluetoothDevice, android.net.wifi.p2p.WifiP2pDevice, com.welink.protocol.nfbd.NearDevice):void");
    }

    public final void y(boolean z2, WifiP2pGroup wifiP2pGroup) {
        synchronized (this) {
            try {
                ConcurrentHashMap.KeySetView executorListenerPairs = this.f9767j;
                Intrinsics.checkNotNullExpressionValue(executorListenerPairs, "executorListenerPairs");
                synchronized (executorListenerPairs) {
                    try {
                        ConcurrentHashMap.KeySetView<Pair> executorListenerPairs2 = this.f9767j;
                        Intrinsics.checkNotNullExpressionValue(executorListenerPairs2, "executorListenerPairs");
                        for (Pair pair : executorListenerPairs2) {
                            ((Executor) pair.getFirst()).execute(new d4(pair, 1));
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                this.e = false;
                ka.d dVar = this.f9766i;
                if (dVar != null) {
                    we.h.b((String) dVar.f6817b, "GroupOwnerCreateFailedResult result=true");
                    h4 h4Var = (h4) dVar.f6816a;
                    if (h4Var != null) {
                        p6 newState = new p6();
                        Intrinsics.checkNotNullParameter(newState, "newState");
                        h4Var.f9765h = newState;
                    }
                }
                this.f9765h.b(this);
                if (z2) {
                    if (wifiP2pGroup != null) {
                        wifiP2pGroup.getOwner();
                    }
                    WifiP2pDevice owner = wifiP2pGroup != null ? wifiP2pGroup.getOwner() : null;
                    i2 i2Var = this.f9763d;
                    w(true, 101, null, owner, i2Var != null ? i2Var.f9797g : null);
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public final void z(int i8) {
        switch (i8) {
            case 320098816:
                we.h.h("NearP2pManager", "setModuleId: monitor mode, ignore it");
                break;
            case 320098817:
            case 320098818:
            case 320098819:
            case 320098820:
            case 320098821:
            case 320098822:
            case 320098823:
            case 320098824:
                q.getClass();
                we.h.b("NearP2pManager", "setModuleId: moduleId is ".concat(u0.c(i8)));
                this.f9771n = i8;
                this.f9770m.add(Integer.valueOf(i8));
                break;
            default:
                Intrinsics.checkNotNullParameter("NearP2pManager", "tag");
                Intrinsics.checkNotNullParameter("setModuleId: moduleId is not support", "mes");
                if (lb.f6529c >= 1) {
                    Log.e("NearP2pManager", "TransConnect:setModuleId: moduleId is not support", null);
                }
                break;
        }
    }
}
