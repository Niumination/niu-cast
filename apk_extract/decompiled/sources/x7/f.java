package x7;

import android.util.Log;
import com.transsion.connectx.sdk.DeviceInfo;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.connectx.sdk.TCCPSourceApi;
import k3.gc;
import k3.pb;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Intrinsics;
import li.h0;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TCCPSourceApi f10882a = TCCPSourceApi.getInstance(pb.a());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f10883b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final qi.c f10884c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f10885d;
    public static final Object e;
    public static final ra.h f;

    static {
        v0 v0Var = v0.f7498a;
        f10884c = h0.a(si.e.f10118a);
        e = new Object();
        f = new ra.h(1);
    }

    public static void a() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("castAudio", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "castAudio");
        }
        f10882a.castAudio();
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("castExtendScreen", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "castExtendScreen");
        }
        f10882a.castExtendScreen();
    }

    public static void c() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("castMainScreen", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "castMainScreen");
        }
        f10882a.castMainScreen();
    }

    public static void d() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("closeMainScreen", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "closeMainScreen");
        }
        f10882a.closeMainScreen();
    }

    public static Object e(SuspendLambda suspendLambda) {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("ensureSourceServiceStarted", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "ensureSourceServiceStarted");
        }
        if (f10882a.isServiceAvailable()) {
            return Boxing.boxBoolean(true);
        }
        v0 v0Var = v0.f7498a;
        return l0.u(si.e.f10118a, new a(null), suspendLambda);
    }

    public static void f(String action, String param) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(param, "param");
        String log = "executeAction: " + action + ", " + param;
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), log);
        }
        f10882a.executeAction(action, param);
    }

    public static void g(j listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("registerServiceStateListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "registerServiceStateListener");
        }
        f10883b = listener;
    }

    public static void h(q7.d info) {
        Intrinsics.checkNotNullParameter(info, "info");
        String strB = info.getPid();
        String strC = info.getType();
        String strA = info.getName();
        StringBuilder sbP = h0.a.p("setConnectDeviceInfo pid: ", strB, ", type: ", strC, ", name: ");
        sbP.append(strA);
        String log = sbP.toString();
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), log);
        }
        f10882a.setConnectDeviceInfo(new DeviceInfo(info.toString()));
    }

    public static void i() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("startExtendScreen", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "startExtendScreen");
        }
        f10882a.startExtendScreen();
    }

    public static void j() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("castAudio", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "castAudio");
        }
        f10882a.stopAllCastAudio();
    }

    public static void k() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("stopTCCPServer", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "stopTCCPServer");
        }
        l0.p(f10884c, null, null, new d(null), 3);
    }

    public static void l(TCCPListener.Stub listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("unregisterMirrorCastListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "unregisterMirrorCastListener");
        }
        f10882a.unregisterCastExtendListener(listener);
    }

    public static void m(TCCPListener.Stub listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("unregisterMirrorCastListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "unregisterMirrorCastListener");
        }
        f10882a.unregisterVideoListener(listener);
    }

    public static void n() {
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("unregisterServiceStateListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "unregisterServiceStateListener");
        }
        f10883b = null;
    }
}
