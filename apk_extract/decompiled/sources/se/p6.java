package se;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class p6 implements n6 {
    @Override // se.n6
    public final void a(h4 nearWifiP2pManager, i2 p2pInfo, int i8, ka.d dVar) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        Intrinsics.checkNotNullParameter(p2pInfo, "p2pInfo");
        if (dVar == null) {
            dVar = new ka.d(nearWifiP2pManager);
        }
        nearWifiP2pManager.B(p2pInfo, dVar, i8);
    }

    @Override // se.n6
    public final void b(h4 nearWifiP2pManager) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        we.h.b("NearP2pManager", "TransConnectP2pDisconnectedState stopP2p");
        nearWifiP2pManager.getClass();
        if (we.m.e(258)) {
            we.h.j("NearP2pManager", "Incorrect Connected Mode Cancel P2P, recovery connect request timer");
            we.m.g(258);
        } else {
            ye.d dVar = nearWifiP2pManager.f9762c;
            if (dVar != null) {
                dVar.f();
            }
        }
    }

    @Override // se.n6
    public final void c(h4 nearWifiP2pManager, int i8, ka.d dVar) {
        Intrinsics.checkNotNullParameter(nearWifiP2pManager, "nearWifiP2pManager");
        we.h.b("NearP2pManager", "TransConnectP2pDisconnectedState disconnect, ignore");
    }
}
