package se;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class o6 implements n6 {
    @Override // se.n6
    public final void a(h4 nearWifiP2pManager, i2 p2pInfo, int i8, ka.d dVar) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        we.h.b("NearP2pManager", "TransConnectP2pCreatingGroupOwnerState connect, ignore");
    }

    @Override // se.n6
    public final void b(h4 nearWifiP2pManager) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        we.h.b("NearP2pManager", "TransConnectP2pCreatingGroupOwnerState stopP2p, ignore");
    }

    @Override // se.n6
    public final void c(h4 nearWifiP2pManager, int i8, ka.d dVar) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        we.h.b("NearP2pManager", "TransConnectP2pCreatingGroupOwnerState disconnect, ignore");
        if (dVar == null) {
            dVar = new ka.d(nearWifiP2pManager);
        }
        nearWifiP2pManager.p(i8, dVar);
    }
}
