package eb;

import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pGroup;
import android.net.wifi.p2p.WifiP2pManager;
import java.util.Collection;
import k3.gc;
import kotlin.Result;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 implements WifiP2pManager.GroupInfoListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ li.l f4763a;

    public i0(li.l lVar) {
        this.f4763a = lVar;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.GroupInfoListener
    public final void onGroupInfoAvailable(WifiP2pGroup wifiP2pGroup) {
        Collection<WifiP2pDevice> clientList;
        gc.c("P2PTool", "requestGroupInfo: " + wifiP2pGroup);
        gc.c("P2PTool", "client list size: " + (wifiP2pGroup != null ? wifiP2pGroup.getClientList() : null) + " ");
        this.f4763a.resumeWith(Result.m159constructorimpl(Boolean.valueOf(((wifiP2pGroup == null || (clientList = wifiP2pGroup.getClientList()) == null) ? 0 : clientList.size()) > 0)));
    }
}
