package se;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import k3.lb;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class g4 implements WifiP2pManager.ChannelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h4 f9745a;

    public g4(h4 h4Var) {
        this.f9745a = h4Var;
    }

    public final void a(int i8) {
        String strM = o.d.m("onConnectFailed, ", "NearP2pManager", "tag", "mes", i8);
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", strM, "NearP2pManager", null);
        }
        h4 h4Var = this.f9745a;
        ka.d dVar = h4Var.f9766i;
        if (dVar != null) {
            dVar.p(i8);
        }
        h4.x(h4Var, i8, 28);
    }

    public final void b(String str, String str2) {
        we.h.b("NearP2pManager", "onConnected: serverIp:" + str + ", clientIp:" + str2);
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("NearP2pManager", "tag");
        Intrinsics.checkNotNullParameter("onCreateGroupFail", "mes");
        if (lb.f6529c >= 1) {
            Log.e("NearP2pManager", "TransConnect:onCreateGroupFail", null);
        }
        this.f9745a.y(false, null);
    }

    public final void d(boolean z2) {
        h4 h4Var = this.f9745a;
        synchronized (this) {
            try {
                if (z2) {
                    h4.x(h4Var, 104, 28);
                } else {
                    h4.x(h4Var, 0, 30);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e(int i8) {
        we.h.c("NearP2pManager", "onGroupRemoveFailed: reasonCode:" + i8, null);
        h4 h4Var = this.f9745a;
        if (h4Var.f9764g instanceof q6) {
            h4.x(h4Var, 0, 30);
        } else if (h4Var.f9765h instanceof q6) {
            h4.x(h4Var, 0, 30);
        } else {
            we.h.j("NearP2pManager", "Device is not in disconnecting State");
        }
    }

    public final void f() {
        int i8;
        we.h.h("NearP2pManager", "onGroupRemoveSucceeded");
        h4 h4Var = this.f9745a;
        synchronized (this) {
            i8 = h4Var.f9771n;
        }
        ConcurrentHashMap.KeySetView<Pair> keySetView = this.f9745a.f9767j;
        Intrinsics.checkNotNullExpressionValue(keySetView, "access$getExecutorListenerPairs$p(...)");
        for (Pair pair : keySetView) {
            ((Executor) pair.getFirst()).execute(new b0.b(i8, 4, pair));
        }
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ChannelListener
    public final void onChannelDisconnected() {
        we.h.h("NearP2pManager", "onChannelDisconnected");
    }
}
