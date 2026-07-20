package se;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.p2p.WifiP2pConfig;
import android.net.wifi.p2p.WifiP2pManager;
import com.welink.protocol.nfbd.TranP2pConnectHelper$mP2pStateReceiver$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class d6 implements WifiP2pManager.ActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ mg.b0 f9718b;

    public /* synthetic */ d6(mg.b0 b0Var, int i8) {
        this.f9717a = i8;
        this.f9718b = b0Var;
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onFailure(int i8) {
        switch (this.f9717a) {
            case 0:
                we.h.g("p2p connect request onFailure");
                this.f9718b.getClass();
                break;
            default:
                we.h.g("removeGroup onFailure");
                this.f9718b.getClass();
                break;
        }
    }

    @Override // android.net.wifi.p2p.WifiP2pManager.ActionListener
    public final void onSuccess() {
        switch (this.f9717a) {
            case 0:
                we.h.g("p2p connect request onSuccess");
                this.f9718b.getClass();
                break;
            default:
                we.h.g("removeGroup onSuccess");
                mg.b0 b0Var = this.f9718b;
                b0Var.getClass();
                int iA = ye.h.a(0);
                WifiP2pConfig.Builder builder = new WifiP2pConfig.Builder();
                Intrinsics.checkNotNull(null);
                WifiP2pConfig.Builder networkName = builder.setNetworkName(null);
                Intrinsics.checkNotNull(null);
                WifiP2pConfig wifiP2pConfigBuild = networkName.setPassphrase(null).setDeviceAddress(null).setGroupOperatingFrequency(iA).build();
                Intrinsics.checkNotNullExpressionValue(wifiP2pConfigBuild, "build(...)");
                if (!b0Var.f8046a) {
                    b0Var.f8046a = true;
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("transsion.nfbd.transfer.action.NOTIFY");
                    intentFilter.addAction("android.net.wifi.p2p.CONNECTION_STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.p2p.PEERS_CHANGED");
                    ((Context) b0Var.f8047b).registerReceiver((TranP2pConnectHelper$mP2pStateReceiver$1) b0Var.f, intentFilter, 2);
                }
                WifiP2pManager wifiP2pManager = (WifiP2pManager) b0Var.f8048c;
                if (wifiP2pManager != null) {
                    WifiP2pManager.Channel channel = (WifiP2pManager.Channel) b0Var.f8049d;
                    Intrinsics.checkNotNull(channel);
                    wifiP2pManager.connect(channel, wifiP2pConfigBuild, (d6) b0Var.e);
                }
                break;
        }
    }
}
