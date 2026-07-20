package eb;

import android.app.NotificationManager;
import android.os.PowerManager;
import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.iotservice.multiscreen.pc.socket.HeartbeatManager;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpDisConnectSocketBean;
import com.transsion.iotservice.multiscreen.pc.state.DeviceConnectState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.gc;
import k3.rb;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TCCPHandshakeSocketServer f4772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static li.g2 f4773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f4774c = li.h0.a(li.v0.f7499b);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableLiveData f4775d = new MutableLiveData();
    public static final ArrayList e = new ArrayList();
    public static li.g2 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final oi.g0 f4776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final oi.g0 f4777h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f4778i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final HeartbeatManager f4779j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final se.g f4780k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final j3.z f4781l;

    static {
        oi.g0 g0VarA = oi.j.a();
        f4776g = g0VarA;
        f4777h = g0VarA;
        f4779j = new HeartbeatManager(22000L, 5, new bb.t(6), new bb.t(5));
        f4780k = new se.g(1);
        f4781l = new j3.z();
    }

    public static void a(boolean z2) {
        String log = "acceptConnection:" + z2 + ". on confirm phase:false";
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), log);
        }
        f4775d.setValue(new n7.c());
    }

    public static final void b() {
        PowerManager.WakeLock wakeLock = k3.p1.f6571a;
        if (wakeLock != null && wakeLock.isHeld()) {
            Intrinsics.checkNotNullParameter("WakeLockHelper", "tag");
            Intrinsics.checkNotNullParameter("release power wake lock", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("WakeLockHelper"), "release power wake lock");
            }
            wakeLock.release();
        }
        k3.p1.f6571a = null;
        y yVar = y.f4799a;
        y.h();
        f();
        x7.f.n();
    }

    public static void c() {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("castScreen", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SocketServerManager"), "castScreen");
        }
        List list = a.f4742a;
        o7.c cVarB = o7.a.b("com.transsion.video");
        if (cVarB != null) {
            cVarB.start();
            o7.c cVarB2 = o7.a.b("com.transsion.audio");
            if (cVarB2 != null) {
                cVarB2.start();
            }
        }
        TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
        k1 k1Var = k1.f4765a;
        hc.c cVar = k1.e;
        String str3 = "";
        if (cVar == null || (str = cVar.f5286a) == null) {
            str = "";
        }
        hc.c cVar2 = k1.e;
        String strValueOf = String.valueOf(cVar2 != null ? Integer.valueOf(cVar2.f) : null);
        hc.c cVar3 = k1.e;
        if (cVar3 != null && (str2 = cVar3.f5287b) != null) {
            str3 = str2;
        }
        x7.f.h(new q7.d(str, strValueOf, str3));
        DeviceConnectState.INSTANCE.refreshCastState(3);
    }

    public static void d() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("connect success task clear", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SocketServerManager"), "connect success task clear");
        }
        e.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void e() {
        li.g2 g2Var;
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("createMainSocketServer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "createMainSocketServer");
        }
        li.g2 g2Var2 = f;
        if (g2Var2 != null) {
            g2Var2.h(null);
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = f4772a;
        if (tCCPHandshakeSocketServer != null) {
            tCCPHandshakeSocketServer.releaseServer(true);
        }
        n7.c cVar = (n7.c) f4775d.getValue();
        if (cVar != null && !cVar.f8126a) {
            cVar.f8126a = true;
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer2 = new TCCPHandshakeSocketServer();
        f4772a = tCCPHandshakeSocketServer2;
        tCCPHandshakeSocketServer2.startServer(TCCPHandshakeSocketClient.MAIN_SOCKET_PORT);
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer3 = f4772a;
        if (tCCPHandshakeSocketServer3 != null) {
            tCCPHandshakeSocketServer3.setEventListener(f4780k);
        }
        li.g2 g2Var3 = f4773b;
        if (g2Var3 != null && g2Var3.a() && (g2Var = f4773b) != null) {
            g2Var.h(null);
        }
        f4773b = li.l0.p(f4774c, null, null, new k2(null), 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void f() {
        gc.c("SocketServerManager", "disconnectMainSocket");
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = f4772a;
        if (tCCPHandshakeSocketServer == null) {
            gc.c("SocketServerManager", "disconnectMainSocket:socket already closed");
            return;
        }
        tCCPHandshakeSocketServer.releaseServer(true);
        f4772a = null;
        f4779j.cancel();
        x7.i.f10887b = null;
        TCCPSourceApi tCCPSourceApi = x7.f.f10882a;
        x7.g listener = x7.i.f10890g;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("unregisterTCCPListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "unregisterTCCPListener");
        }
        x7.f.f10882a.unregisterTCCPListener(listener);
        rb.b();
        a.d();
        DeviceConnectState.INSTANCE.refreshCastState(0);
        n7.c cVar = (n7.c) f4775d.getValue();
        if (cVar != null && !cVar.f8126a) {
            cVar.f8126a = true;
        }
        li.g2 g2Var = f4773b;
        if (g2Var != null) {
            g2Var.h(null);
        }
        NotificationManager notificationManager = bb.v.f1256a;
        bb.v.a();
        wa.c.a();
        g0 g0Var = g0.f4753a;
        g0.g();
        f4778i = null;
    }

    public static void g() {
        ArrayList arrayList = e;
        String strM = o.d.m("executeConnectedTask: size ", "SocketServerManager", "tag", "log", arrayList.size());
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SocketServerManager"), strM);
        }
        Iterator it = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            ((Runnable) next).run();
        }
        d();
    }

    public static void h(String str) {
        String log = "executeDisconnect reason:".concat(str);
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), log);
        }
        li.g2 g2Var = f;
        if (g2Var != null) {
            g2Var.h(null);
        }
        li.l0.p(f4774c, null, null, new a2(str, null), 3);
    }

    public static void i(boolean z2) {
        f();
        synchronized (y.f4799a) {
            y.i("sendHandshakeRejectedEvent:fromPeer:" + z2);
            k1 k1Var = k1.f4765a;
            hc.c cVar = k1.e;
            ob.b.f8417b.n(cVar != null ? cVar.f5288c : null, cVar != null ? cVar.f5286a : null);
            li.l0.p(y.f4800b, null, null, new o(null), 3);
        }
    }

    public static void j() {
        Intrinsics.checkNotNullParameter("SocketServerManager", "tag");
        Intrinsics.checkNotNullParameter("requestDisconnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketServerManager"), "requestDisconnect");
        }
        li.g2 g2Var = f;
        if (g2Var != null) {
            g2Var.h(null);
        }
        f = li.l0.p(f4774c, si.e.f10118a, null, new j2(null), 2);
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = f4772a;
        if (tCCPHandshakeSocketServer != null) {
            tCCPHandshakeSocketServer.sendRequest(TccpConfig.INSTANCE.getREQUEST_DISCONNECT(), new TccpDisConnectSocketBean(true));
        }
    }

    public static void k(String str, String str2) {
        hc.c cVar;
        k1 k1Var = k1.f4765a;
        hc.c cVar2 = k1.e;
        if (cVar2 != null) {
            if (str == null) {
                str = "";
            }
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            cVar2.f5287b = str;
        }
        if (str2 == null || (cVar = k1.e) == null) {
            return;
        }
        Intrinsics.checkNotNullParameter(str2, "<set-?>");
        cVar.f5288c = str2;
    }
}
