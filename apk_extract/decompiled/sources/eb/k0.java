package eb;

import android.net.wifi.p2p.WifiP2pInfo;
import android.net.wifi.p2p.WifiP2pManager;
import k3.gc;
import kotlin.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 implements WifiP2pManager.ConnectionInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ li.l f4764a;

    public k0(li.l lVar) {
        this.f4764a = lVar;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ConnectionInfoListener
    public final void onConnectionInfoAvailable(WifiP2pInfo wifiP2pInfo) {
        boolean z2;
        gc.c("P2PTool", "requestConnectionInfo: " + wifiP2pInfo);
        li.l lVar = this.f4764a;
        if (wifiP2pInfo == null || !(z2 = wifiP2pInfo.groupFormed)) {
            Result.Companion companion = Result.INSTANCE;
            lVar.resumeWith(Result.m159constructorimpl(Boolean.FALSE));
        } else {
            if (wifiP2pInfo.isGroupOwner) {
                li.l0.p(k1.f, null, null, new j0(lVar, null), 3);
                return;
            }
            gc.c("P2PTool", "isConnectGO: " + z2);
            lVar.resumeWith(Result.m159constructorimpl(Boolean.valueOf(z2)));
        }
    }
}
