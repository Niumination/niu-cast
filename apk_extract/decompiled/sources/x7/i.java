package x7;

import android.app.Application;
import android.util.Log;
import com.transsion.connectx.sdk.TCCPListener;
import com.transsion.connectx.sdk.TCCPSourceApi;
import k3.gc;
import kotlin.ResultKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import li.l0;
import li.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static j f10887b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static TCCPListener.Stub f10888c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static TCCPListener.Stub f10889d = null;
    public static String e = "";
    public static boolean f = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f10886a = new i();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final g f10890g = new g();

    public static void a(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("disconnectService", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "disconnectService");
        }
        f.f10882a.disconnectService(context);
    }

    public static void b() {
        Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
        Intrinsics.checkNotNullParameter("disconnectTCCP", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SourceServiceConnectHelper"), "disconnectTCCP");
        }
        f.k();
    }

    public static void c(TCCPListener.Stub listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        f10889d = listener;
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("registerMirrorCastListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "registerMirrorCastListener");
        }
        f.f10882a.registerCastExtendListener(listener);
    }

    public static void d(TCCPListener.Stub listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        f10888c = listener;
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("registerMirrorCastListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "registerMirrorCastListener");
        }
        f.f10882a.registerVideoListener(listener);
    }

    public static void e(String packageName, j connectListener) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(connectListener, "connectListener");
        f10887b = connectListener;
        e = packageName;
        TCCPSourceApi tCCPSourceApi = f.f10882a;
        String packageName2 = e;
        Intrinsics.checkNotNullParameter(packageName2, "packageName");
        g listener = f10890g;
        Intrinsics.checkNotNullParameter(listener, "listener");
        Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
        Intrinsics.checkNotNullParameter("registerTCCPListener", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("ConnectSdkProxy"), "registerTCCPListener");
        }
        f.f10882a.registerTCCPListener(packageName2, listener);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object f(int i8, String str, ContinuationImpl continuationImpl) throws Throwable {
        h hVar;
        if (continuationImpl instanceof h) {
            hVar = (h) continuationImpl;
            int i9 = hVar.label;
            if ((i9 & Integer.MIN_VALUE) != 0) {
                hVar.label = i9 - Integer.MIN_VALUE;
            } else {
                hVar = new h(this, continuationImpl);
            }
        } else {
            hVar = new h(this, continuationImpl);
        }
        Object objU = hVar.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i10 = hVar.label;
        if (i10 == 0) {
            ResultKt.throwOnFailure(objU);
            int tCCPStatus = f.f10882a.getTCCPStatus();
            boolean z2 = tCCPStatus == 1 || tCCPStatus == 2 || tCCPStatus == 4;
            String log = "isConnectedTCCP:" + z2 + ":";
            Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
            Intrinsics.checkNotNullParameter(log, "log");
            if (gc.f6462a <= 3) {
                Log.d(gc.f6463b.concat("SourceServiceConnectHelper"), log);
            }
            if (z2) {
                f = false;
                b();
            }
            hVar.L$0 = str;
            hVar.label = 1;
            Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
            Intrinsics.checkNotNullParameter("startTCCPServer", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("ConnectSdkProxy"), "startTCCPServer");
            }
            v0 v0Var = v0.f7498a;
            objU = l0.u(si.e.f10118a, new c(i8, null), hVar);
            if (objU == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) hVar.L$0;
            ResultKt.throwOnFailure(objU);
        }
        int iIntValue = ((Number) objU).intValue();
        String log2 = "startTCCPServer : IP:" + str + ",port:" + iIntValue;
        Intrinsics.checkNotNullParameter("SourceServiceConnectHelper", "tag");
        Intrinsics.checkNotNullParameter(log2, "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("SourceServiceConnectHelper"), log2);
        }
        return new q7.e(iIntValue);
    }
}
