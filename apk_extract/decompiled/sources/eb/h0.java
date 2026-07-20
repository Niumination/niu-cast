package eb;

import android.net.wifi.p2p.WifiP2pManager;
import android.util.Log;
import k3.gc;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h0 implements WifiP2pManager.ChannelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4762a;

    @Override // android.net.wifi.p2p.WifiP2pManager.ChannelListener
    public final void onChannelDisconnected() {
        switch (this.f4762a) {
            case 0:
                Intrinsics.checkNotNullParameter("P2PTool", "tag");
                Intrinsics.checkNotNullParameter("onChannelDisconnected: ", "log");
                if (gc.f6462a <= 4) {
                    Log.i(gc.f6463b.concat("P2PTool"), "onChannelDisconnected: ");
                }
                break;
            default:
                we.h.g("onChannelDisconnected");
                break;
        }
    }
}
