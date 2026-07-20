package ra;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import k3.gc;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import x7.j;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9388a;

    public /* synthetic */ h(int i8) {
        this.f9388a = i8;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName name, IBinder service) {
        yc.c cVar;
        switch (this.f9388a) {
            case 0:
                Intrinsics.checkNotNullParameter("PCConnectApplication", "tag");
                Intrinsics.checkNotNullParameter("onServiceConnected", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PCConnectApplication"), "onServiceConnected");
                    return;
                }
                return;
            case 1:
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter(service, "service");
                Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                Intrinsics.checkNotNullParameter("onServiceConnected", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectSdkProxy"), "onServiceConnected");
                }
                j jVar = x7.f.f10883b;
                if (jVar != null) {
                    jVar.onConnected();
                    return;
                }
                return;
            default:
                Log.d("ActionCommunicator", "Successfully bound to target service: ".concat(yc.f.f11124c));
                int i8 = yc.d.f11117b;
                if (service == null) {
                    cVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = service.queryLocalInterface("com.transsion.pcconnect.invoke.bridge.IActionService");
                    if (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof yc.c)) {
                        yc.b bVar = new yc.b();
                        bVar.f11116b = service;
                        cVar = bVar;
                    } else {
                        cVar = (yc.c) iInterfaceQueryLocalInterface;
                    }
                }
                yc.f.f11125d = cVar;
                yc.f.e = true;
                ArrayList arrayList = yc.f.f11126g;
                synchronized (arrayList) {
                    try {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((Function0) it.next()).invoke();
                        }
                        yc.f.f11126g.clear();
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                return;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName name) {
        switch (this.f9388a) {
            case 0:
                Intrinsics.checkNotNullParameter("PCConnectApplication", "tag");
                Intrinsics.checkNotNullParameter("onServiceDisconnected", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("PCConnectApplication"), "onServiceDisconnected");
                }
                break;
            case 1:
                Intrinsics.checkNotNullParameter(name, "name");
                Intrinsics.checkNotNullParameter("ConnectSdkProxy", "tag");
                Intrinsics.checkNotNullParameter("onServiceDisconnected", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("ConnectSdkProxy"), "onServiceDisconnected");
                }
                j jVar = x7.f.f10883b;
                if (jVar != null) {
                    jVar.b(new q7.f(0));
                }
                break;
            default:
                o.d.B("Target service disconnected: ", yc.f.f11124c, "ActionCommunicator");
                yc.f.f11125d = null;
                yc.f.e = false;
                break;
        }
    }
}
