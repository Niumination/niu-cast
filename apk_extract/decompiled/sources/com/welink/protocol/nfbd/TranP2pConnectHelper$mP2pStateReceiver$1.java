package com.welink.protocol.nfbd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import se.e6;
import se.f6;
import se.g6;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/nfbd/TranP2pConnectHelper$mP2pStateReceiver$1", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nTranP2pConnectHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TranP2pConnectHelper.kt\ncom/welink/protocol/nfbd/TranP2pConnectHelper$mP2pStateReceiver$1\n+ 2 IntentExtension.kt\ncom/welink/protocol/utils/IntentExtensionKt\n*L\n1#1,281:1\n10#2,6:282\n*S KotlinDebug\n*F\n+ 1 TranP2pConnectHelper.kt\ncom/welink/protocol/nfbd/TranP2pConnectHelper$mP2pStateReceiver$1\n*L\n204#1:282,6\n*E\n"})
public final class TranP2pConnectHelper$mP2pStateReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3984b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ mg.b0 f3985a;

    public TranP2pConnectHelper$mP2pStateReceiver$1(mg.b0 b0Var) {
        this.f3985a = b0Var;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action;
        we.h.g("onReceive");
        if (intent == null || (action = intent.getAction()) == null) {
            return;
        }
        int iHashCode = action.hashCode();
        mg.b0 b0Var = this.f3985a;
        if (iHashCode == -1772632330) {
            if (action.equals("android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) {
                NetworkInfo networkInfo = (NetworkInfo) ((Parcelable) intent.getParcelableExtra("networkInfo", NetworkInfo.class));
                WifiP2pManager wifiP2pManager = (WifiP2pManager) b0Var.f8048c;
                WifiP2pManager.Channel channel = (WifiP2pManager.Channel) b0Var.f8049d;
                if (wifiP2pManager != null) {
                    Intrinsics.checkNotNull(channel);
                    wifiP2pManager.requestDeviceInfo(channel, new f6(0));
                }
                WifiP2pManager wifiP2pManager2 = (WifiP2pManager) b0Var.f8048c;
                if (wifiP2pManager2 != null) {
                    Intrinsics.checkNotNull(channel);
                    wifiP2pManager2.requestGroupInfo(channel, new g6(networkInfo, b0Var));
                    return;
                }
                return;
            }
            return;
        }
        if (iHashCode == -1394739139) {
            if (action.equals("android.net.wifi.p2p.PEERS_CHANGED")) {
                we.h.g("WIFI_P2P_PEERS_CHANGED_ACTION: onPeersAvailable");
                WifiP2pManager wifiP2pManager3 = (WifiP2pManager) b0Var.f8048c;
                if (wifiP2pManager3 != null) {
                    WifiP2pManager.Channel channel2 = (WifiP2pManager.Channel) b0Var.f8049d;
                    Intrinsics.checkNotNull(channel2);
                    wifiP2pManager3.requestPeers(channel2, new e6(b0Var, 0));
                    return;
                }
                return;
            }
            return;
        }
        if (iHashCode == -146023263 && action.equals("transsion.nfbd.transfer.action.NOTIFY")) {
            we.h.g("onReceive : " + intent.getStringExtra("dhcp_client_addr"));
            we.h.g("onReceive : " + intent.getStringExtra("dhcp_server_addr"));
            intent.getStringExtra("dhcp_server_addr");
            intent.getStringExtra("dhcp_client_addr");
            b0Var.getClass();
        }
    }
}
