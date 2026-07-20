package eb;

import android.app.NotificationManager;
import android.os.PowerManager;
import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketClient;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.config.TccpConfig;
import com.transsion.iotservice.multiscreen.pc.socket.tccp.pack.bean.TccpDisConnectSocketBean;
import java.util.LinkedHashMap;
import k3.gc;
import k3.pb;
import k3.sb;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class y1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static TCCPHandshakeSocketClient f4826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static li.g2 f4827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f4828c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static li.g2 f4829d;
    public static long e;
    public static String f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ph.c f4830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final bb.s f4831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v1 f4832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final s1 f4833j;

    static {
        li.v0 v0Var = li.v0.f7498a;
        f4828c = li.h0.a(si.e.f10118a);
        f = "???";
        f4830g = new ph.c();
        f4831h = new bb.s(7);
        f4832i = new v1();
        f4833j = new s1();
    }

    public static final void a() {
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
        x7.i iVar = x7.i.f10886a;
        Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("unRegisterMirrorCastListener", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SourceServiceConnectHelper"), "unRegisterMirrorCastListener");
        }
        TCCPListener.Stub stub = x7.i.f10888c;
        if (stub != null) {
            x7.f.m(stub);
        }
        x7.i.f10888c = null;
        TCCPListener.Stub stub2 = x7.i.f10889d;
        if (stub2 != null) {
            x7.f.l(stub2);
        }
        x7.i.f10889d = null;
        LinkedHashMap linkedHashMap = lb.a.f7355a;
        Intrinsics.checkNotNullParameter("GlobalSettingsStore", "tag");
        Intrinsics.checkNotNullParameter("unregisterPhoneCallShareObserver", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GlobalSettingsStore"), "unregisterPhoneCallShareObserver");
        }
        h7.a aVar = lb.a.f7356b;
        if (aVar != null) {
            pb.a().getContentResolver().unregisterContentObserver(aVar);
        }
        lb.a.f7356b = null;
        y yVar = y.f4799a;
        y.h();
        c();
        x7.f.n();
    }

    public static Object b(String str, ContinuationImpl continuationImpl) {
        Object objConnect;
        li.g2 g2Var;
        String log = "connectMainSocketServer:ip:" + str + ",port:" + ((Object) null);
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), log);
        }
        li.g2 g2Var2 = f4829d;
        if (g2Var2 != null) {
            g2Var2.h(null);
        }
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = new TCCPHandshakeSocketClient();
        f4826a = tCCPHandshakeSocketClient;
        tCCPHandshakeSocketClient.setEventListener(f4830g);
        li.g2 g2Var3 = f4827b;
        if (g2Var3 != null && g2Var3.a() && (g2Var = f4827b) != null) {
            g2Var.h(null);
        }
        f4827b = li.l0.p(f4828c, null, null, new x1(null), 3);
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient2 = f4826a;
        return (tCCPHandshakeSocketClient2 == null || (objConnect = tCCPHandshakeSocketClient2.connect(str, TCCPHandshakeSocketClient.MAIN_SOCKET_PORT, continuationImpl)) != IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? Unit.INSTANCE : objConnect;
    }

    public static void c() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("disconnectMainSocketServer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "disconnectMainSocketServer");
        }
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = f4826a;
        if (tCCPHandshakeSocketClient != null) {
            tCCPHandshakeSocketClient.disconnect();
        }
        li.g2 g2Var = f4827b;
        if (g2Var != null) {
            g2Var.h(null);
        }
        f4826a = null;
        g0 g0Var = g0.f4753a;
        g0.g();
        a.d();
        NotificationManager notificationManager = bb.v.f1256a;
        bb.v.a();
    }

    public static void d(String str) {
        String log = "executeDisconnect reason:".concat(str);
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), log);
        }
        li.g2 g2Var = f4829d;
        if (g2Var != null) {
            g2Var.h(null);
        }
        li.l0.p(f4828c, null, null, new t1(str, null), 3);
    }

    public static void e() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("requestDisconnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "requestDisconnect");
        }
        li.g2 g2Var = f4829d;
        if (g2Var != null) {
            g2Var.h(null);
        }
        li.v0 v0Var = li.v0.f7498a;
        f4829d = li.l0.p(f4828c, si.e.f10118a, null, new w1(null), 2);
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = f4826a;
        if (tCCPHandshakeSocketClient != null) {
            tCCPHandshakeSocketClient.sendRequest(TccpConfig.INSTANCE.getDISCONNECT_SOCKET(), new TccpDisConnectSocketBean(true));
        }
    }

    public static void f() {
        boolean zC = sb.c(pb.a());
        String strO = o.d.o("syncWifiInfo:", zC, "SocketClientManager", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), strO);
        }
        TCCPHandshakeSocketClient tCCPHandshakeSocketClient = f4826a;
        if (tCCPHandshakeSocketClient != null) {
            tCCPHandshakeSocketClient.sendRequest(TccpConfig.INSTANCE.getWIFI_FREQUENCY_STATE(), Boolean.valueOf(zC));
        }
    }
}
