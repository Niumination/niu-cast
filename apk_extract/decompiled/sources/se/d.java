package se;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.service.quicksettings.TileService;
import android.util.Log;
import com.transsion.iotservice.multiscreen.pc.socket.TCCPHandshakeSocketServer;
import com.transsion.iotservice.multiscreen.pc.ui.guide.FunctionGuideActivity;
import com.welink.protocol.nfbd.ConnectRequest;
import com.welink.protocol.nfbd.NearDevice;
import java.util.LinkedHashMap;
import k3.gc;
import k3.pb;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements f, x7.j, fd.a, j5.b {
    public static void c(Context context, int i8) {
        int i9 = FunctionGuideActivity.f2774o;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!(context instanceof TileService)) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter("FunctionGuideActivity", "tag");
            Intrinsics.checkNotNullParameter("start guide activity", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("FunctionGuideActivity"), "start guide activity");
            }
            FunctionGuideActivity.f2774o = i8;
            Intent intent = new Intent(context, (Class<?>) FunctionGuideActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
            return;
        }
        TileService tileService = (TileService) context;
        Intrinsics.checkNotNullParameter(tileService, "tileService");
        Intrinsics.checkNotNullParameter("FunctionGuideActivity", "tag");
        Intrinsics.checkNotNullParameter("start guide activity", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("FunctionGuideActivity"), "start guide activity");
        }
        FunctionGuideActivity.f2774o = i8;
        Intent intent2 = new Intent(tileService, (Class<?>) FunctionGuideActivity.class);
        Intrinsics.checkNotNullParameter(tileService, "<this>");
        Intrinsics.checkNotNullParameter(intent2, "intent");
        lj.k.a(tileService, intent2);
    }

    @Override // j5.b
    public Object a(e5.j jVar) {
        return jVar.getId();
    }

    @Override // x7.j
    public void b(q7.f disconnectInfoBean) {
        Intrinsics.checkNotNullParameter(disconnectInfoBean, "disconnectInfoBean");
        String log = "on TCCP DisConnected: " + disconnectInfoBean;
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("SocketClientManager"), log);
        }
        eb.y1.a();
    }

    @Override // fd.a
    public void d() {
    }

    @Override // se.f
    public boolean e(NearDevice device, com.welink.protocol.nfbd.z manager, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        device.A(1005);
        device.f(manager, new a8.a(device), function1);
        Intrinsics.checkNotNullParameter(device, "device");
        h newState = new h();
        Intrinsics.checkNotNullParameter(newState, "newState");
        device.I = newState;
        return true;
    }

    @Override // se.f
    public boolean f(NearDevice device, com.welink.protocol.nfbd.z manager, ConnectRequest request, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(request, "request");
        return false;
    }

    @Override // se.f
    public boolean h(NearDevice device, com.welink.protocol.nfbd.z manager) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        Log.e("ConnectedState", "flushDevice not support in ConnectedState");
        return false;
    }

    @Override // se.f
    public boolean i(NearDevice device, com.welink.protocol.nfbd.z manager, g5 g5Var, Function1 function1) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        return true;
    }

    @Override // se.f
    public boolean j(NearDevice device, com.welink.protocol.nfbd.z manager, int i8, int i9, r6 r6Var) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(manager, "manager");
        return false;
    }

    @Override // x7.j
    public void k(q7.g error) {
        Intrinsics.checkNotNullParameter(error, "error");
        String log = "on TCCP error:" + error + " ";
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter(log, "log");
        if (gc.f6462a <= 6) {
            Log.e(gc.f6463b.concat("SocketClientManager"), log);
        }
        eb.y1.a();
    }

    @Override // x7.j
    public void onConnected() {
        Intrinsics.checkNotNullParameter("SocketClientManager", "tag");
        Intrinsics.checkNotNullParameter("Connect TCCP success init Ability complete", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("SocketClientManager"), "Connect TCCP success init Ability complete");
        }
        ta.b.a();
        eb.y.f4799a.n();
        li.g2 g2Var = eb.y1.f4827b;
        if (g2Var != null) {
            g2Var.h(null);
        }
        ta.b.a();
        k3.p1.a(pb.a());
        LinkedHashMap linkedHashMap = lb.a.f7355a;
        Uri uriFor = Settings.Global.getUriFor("multi_device_connection.share_call_phone");
        Intrinsics.checkNotNullExpressionValue(uriFor, "getUriFor(...)");
        h7.a aVar = new h7.a(new Handler(Looper.getMainLooper()), 2);
        lb.a.f7356b = aVar;
        pb.a().getContentResolver().registerContentObserver(uriFor, false, aVar);
        lb.a.f7357c = lb.a.a("multi_device_connection.share_call_phone");
        String strO = o.d.o("init phone call share:", lb.a.f7357c, "GlobalSettingsStore", "tag", "log");
        if (gc.f6462a <= 4) {
            Log.i(gc.f6463b.concat("GlobalSettingsStore"), strO);
        }
        TCCPHandshakeSocketServer tCCPHandshakeSocketServer = eb.l2.f4772a;
        eb.l2.g();
        ob.b.f8417b.k("success", System.currentTimeMillis() - eb.y1.e);
    }
}
