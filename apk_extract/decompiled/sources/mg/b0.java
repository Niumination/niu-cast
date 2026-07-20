package mg;

import android.content.Context;
import android.net.wifi.p2p.WifiP2pManager;
import com.google.android.gms.common.ConnectionResult;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import eb.h0;
import java.util.ArrayList;
import java.util.List;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import se.d6;

/* JADX INFO: loaded from: classes3.dex */
public final class b0 implements u2.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f8048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f8049d;
    public Object e;
    public final Object f;

    public b0(r2.c cVar, q2.c cVar2, r2.a aVar) {
        this.f = cVar;
        this.f8049d = null;
        this.e = null;
        this.f8046a = false;
        this.f8047b = cVar2;
        this.f8048c = aVar;
    }

    @Override // u2.b
    public void a(ConnectionResult connectionResult) {
        ((r2.c) this.f).f9334o.post(new i2.e(this, 13, connectionResult, false));
    }

    public void b(ConnectionResult connectionResult) {
        r2.l lVar = (r2.l) ((r2.c) this.f).f9331l.get((r2.a) this.f8048c);
        if (lVar != null) {
            u2.l.b(lVar.f9350n.f9334o);
            q2.c cVar = lVar.f9341c;
            cVar.disconnect("onSignInFailed for " + cVar.getClass().getName() + " with " + String.valueOf(connectionResult));
            lVar.n(connectionResult, null);
        }
    }

    public b0(Context mContext) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f8047b = mContext;
        new d6(this, 1);
        this.e = new d6(this, 0);
        this.f = new TranP2pConnectHelper$mP2pStateReceiver$1(this);
        Object systemService = mContext.getSystemService("wifip2p");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.wifi.p2p.WifiP2pManager");
        WifiP2pManager wifiP2pManager = (WifiP2pManager) systemService;
        this.f8048c = wifiP2pManager;
        this.f8049d = wifiP2pManager != null ? wifiP2pManager.initialize(mContext, mContext.getMainLooper(), new h0(1)) : null;
    }

    public b0(qg.b environment, ArrayList modules, List watchPaths, String rootPath, boolean z2, CoroutineContext parentCoroutineContext) {
        Intrinsics.checkNotNullParameter(environment, "environment");
        Intrinsics.checkNotNullParameter(modules, "modules");
        Intrinsics.checkNotNullParameter(watchPaths, "watchPaths");
        Intrinsics.checkNotNullParameter(rootPath, "rootPath");
        Intrinsics.checkNotNullParameter(parentCoroutineContext, "parentCoroutineContext");
        this.f8047b = environment;
        this.f8048c = modules;
        this.f8049d = watchPaths;
        this.e = rootPath;
        this.f8046a = z2;
        Intrinsics.checkNotNullParameter(this, "rootConfig");
        Intrinsics.checkNotNullParameter(parentCoroutineContext, "parentCoroutineContext");
        if (this.f8046a && !((List) this.f8049d).isEmpty()) {
            parentCoroutineContext = parentCoroutineContext.plus(j.f8067a);
        }
        this.f = parentCoroutineContext;
    }
}
