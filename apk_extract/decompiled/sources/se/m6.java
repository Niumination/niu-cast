package se;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class m6 implements n6 {
    @Override // se.n6
    public final void a(h4 nearWifiP2pManager, i2 p2pInfo, int i8, ka.d dVar) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        we.h.b("NearP2pManager", "TransConnectP2pConnectingState connect, duplicate connection");
        if (dVar == null) {
            dVar = new ka.d(nearWifiP2pManager);
        }
        nearWifiP2pManager.t(p2pInfo, dVar, i8);
    }

    @Override // se.n6
    public final void b(h4 nearWifiP2pManager) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        we.h.b("NearP2pManager", "TransConnectP2pConnectingState stopP2p, ignore");
    }

    @Override // se.n6
    public final void c(h4 nearWifiP2pManager, int i8, ka.d dVar) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        we.h.b("NearP2pManager", "TransConnectP2pConnectingState disconnect, disconnect p2p");
        if (dVar == null) {
            dVar = new ka.d(nearWifiP2pManager);
        }
        nearWifiP2pManager.p(i8, dVar);
    }
}
