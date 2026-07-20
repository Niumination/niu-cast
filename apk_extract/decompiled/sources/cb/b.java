package cb;

import android.app.Application;
import android.content.Intent;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.bean.ConnectedDevice;
import com.transsion.pcconnect.invoke.bridge.Device;
import eb.g0;
import java.util.ArrayList;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import o.d;
import yc.f;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f1456a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f1457b = new a();

    public static void a(boolean z2) {
        String strO = d.o("changeMirrorState params: ", z2, "InvokeBridgeProvider", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("InvokeBridgeProvider"), strO);
        }
        g0 g0Var = g0.f4753a;
        Device device = g0.f;
        if (device != null) {
            b bVar = f1456a;
            d(bVar, device, "SERVICE_SCREEN_CAST", z2);
            d(bVar, device, "SERVICE_AIR_CAST", z2);
        }
        g0.a(ConnectedDevice.INSTANCE.getSUBTITLE_MIRROR_CAST(), z2);
    }

    public static void b(boolean z2) {
        String strO = d.o("changePhoneExtendState params: ", z2, "InvokeBridgeProvider", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("InvokeBridgeProvider"), strO);
        }
        g0 g0Var = g0.f4753a;
        Device device = g0.f;
        if (device != null) {
            d(f1456a, device, "SERIVCE_CAPABILITY_EXTEND_SINK", z2);
        }
        g0.a(ConnectedDevice.INSTANCE.getSUBTITLE_PHONE_EXTEND(), z2);
    }

    public static void c(final Device device, final String action, final boolean z2, final String str) {
        String log = "executeAction: " + action + ", " + z2 + ", " + str;
        Intrinsics.checkNotNullParameter("InvokeBridgeProvider", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("InvokeBridgeProvider"), log);
        }
        f fVar = f.f11122a;
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(action, "action");
        Log.d("ActionCommunicator", "Preparing to execute action: action=" + action + ", target=" + f.f11124c);
        if (f.e && f.f11125d != null) {
            f.a(device, action, z2, str);
            return;
        }
        ArrayList arrayList = f.f11126g;
        synchronized (arrayList) {
            arrayList.add(new Function0() { // from class: yc.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    f fVar2 = f.f11122a;
                    f.a(device, action, z2, str);
                    return Unit.INSTANCE;
                }
            });
        }
        if (f.e) {
            Log.d("ActionCommunicator", "Target service already bound: ".concat(f.f11124c));
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setClassName(f.f11124c, "com.transsion.pcconnect.invoke.bridge.IntegratedActionService");
            intent.setAction("com.transsion.pcconnect.ACTION_SERVICE");
            Application application = f.f11123b;
            if (application == null) {
                Intrinsics.throwUninitializedPropertyAccessException("context");
                application = null;
            }
            boolean zBindService = application.bindService(intent, f.f11128i, 1);
            Log.d("ActionCommunicator", "Binding to target service: " + f.f11124c + ", binding result: " + zBindService);
            if (zBindService) {
                return;
            }
            Log.e("ActionCommunicator", "Service binding failed, target app may not be installed or service doesn't exist");
        } catch (Exception e) {
            Log.e("ActionCommunicator", "Failed to bind target service: " + e.getMessage(), e);
        }
    }

    public static /* synthetic */ void d(b bVar, Device device, String str, boolean z2) {
        bVar.getClass();
        c(device, str, z2, "");
    }

    public final void e(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter("InvokeBridgeProvider", "tag");
        Intrinsics.checkNotNullParameter("onConnect", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("InvokeBridgeProvider"), "onConnect");
        }
        c(device, "CONNECT", true, "");
    }
}
