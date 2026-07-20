package com.welink.protocol.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.p2p.WifiP2pDevice;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Parcelable;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import se.e6;
import se.f6;
import se.g4;
import se.g6;
import se.h4;
import we.h;
import ye.d;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/wifi/P2pTool$mP2pReceiver$1", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nP2pTool.kt\nKotlin\n*S Kotlin\n*F\n+ 1 P2pTool.kt\ncom/welink/protocol/wifi/P2pTool$mP2pReceiver$1\n+ 2 IntentExtension.kt\ncom/welink/protocol/utils/IntentExtensionKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,934:1\n10#2,6:935\n1863#3:941\n1864#3:943\n1#4:942\n*S KotlinDebug\n*F\n+ 1 P2pTool.kt\ncom/welink/protocol/wifi/P2pTool$mP2pReceiver$1\n*L\n91#1:935,6\n180#1:941\n180#1:943\n*E\n"})
public final class P2pTool$mP2pReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f4249b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f4250a;

    public P2pTool$mP2pReceiver$1(d dVar) {
        this.f4250a = dVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            boolean zAreEqual = Intrinsics.areEqual(action, "android.net.wifi.p2p.STATE_CHANGED");
            d dVar = this.f4250a;
            if (zAreEqual) {
                if (intent.getIntExtra("wifi_p2p_state", -100) == 2) {
                    h.g("WIFI_P2P_STATE_ENABLED ");
                    if (dVar.f11174c != null) {
                        h.b("NearP2pManager", "wifiP2pEnabled: true");
                        return;
                    }
                    return;
                }
                h.g("WIFI_P2P_STATE_DISABLED ");
                if (dVar.f11174c != null) {
                    h.b("NearP2pManager", "wifiP2pEnabled: false");
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(action, "android.net.wifi.p2p.PEERS_CHANGED")) {
                WifiP2pManager wifiP2pManager = dVar.f11172a;
                if (wifiP2pManager != null) {
                    wifiP2pManager.requestPeers(dVar.f11173b, new e6(dVar, 1));
                    return;
                }
                return;
            }
            if (Intrinsics.areEqual(action, "android.net.wifi.p2p.CONNECTION_STATE_CHANGE")) {
                h.g("==========WIFI_P2P_CONNECTION_CHANGED_ACTION================");
                NetworkInfo networkInfo = (NetworkInfo) ((Parcelable) intent.getParcelableExtra("networkInfo", NetworkInfo.class));
                WifiP2pManager wifiP2pManager2 = dVar.f11172a;
                if (wifiP2pManager2 != null) {
                    WifiP2pManager.Channel channel = dVar.f11173b;
                    Intrinsics.checkNotNull(channel);
                    wifiP2pManager2.requestDeviceInfo(channel, new f6(1));
                }
                WifiP2pManager wifiP2pManager3 = dVar.f11172a;
                if (wifiP2pManager3 != null) {
                    WifiP2pManager.Channel channel2 = dVar.f11173b;
                    Intrinsics.checkNotNull(channel2);
                    wifiP2pManager3.requestGroupInfo(channel2, new g6(dVar, networkInfo));
                    return;
                }
                return;
            }
            if (!Intrinsics.areEqual(action, "android.net.wifi.p2p.THIS_DEVICE_CHANGED")) {
                dVar.getClass();
                if (Intrinsics.areEqual(action, "android.net.wifi.p2p.action.WIFI_P2P_PERSISTENT_GROUPS_CHANGED")) {
                    h.g("ACTION_WIFI_P2P_PERSISTENT_GROUPS_CHANGED: 发现新的组");
                    return;
                }
                return;
            }
            h.g("WIFI_P2P_THIS_DEVICE_CHANGED_ACTION: 本设备状态发生变化，onSelfDeviceAvailable");
            WifiP2pDevice wifiP2pDevice = (WifiP2pDevice) intent.getParcelableExtra("wifiP2pDevice");
            g4 g4Var = dVar.f11174c;
            if (g4Var != null) {
                Integer numValueOf = wifiP2pDevice != null ? Integer.valueOf(wifiP2pDevice.status) : null;
                if (numValueOf != null && numValueOf.intValue() == 0) {
                    h.b("NearP2pManager", "This Device is GROUP Formatted");
                    return;
                }
                if (numValueOf != null && numValueOf.intValue() == 3) {
                    h.b("NearP2pManager", "This Device is in idle state");
                    h4 h4Var = g4Var.f9745a;
                    d dVar2 = h4Var.f9762c;
                    if ((dVar2 == null || dVar2.f11184o != 1) && !h4Var.f) {
                        return;
                    }
                    h.h("NearP2pManager", "Wifi P2p Client is available, start to connect to group owner");
                    ka.d dVar3 = h4Var.f9766i;
                    if (dVar3 != null) {
                        h.b((String) dVar3.f6817b, "GroupClientAvailableResult result=true");
                    }
                }
            }
        }
    }
}
