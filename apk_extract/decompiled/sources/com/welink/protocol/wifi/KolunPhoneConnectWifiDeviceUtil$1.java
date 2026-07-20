package com.welink.protocol.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import we.h;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/wifi/KolunPhoneConnectWifiDeviceUtil$1", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KolunPhoneConnectWifiDeviceUtil$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f4248a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual("android.net.wifi.WIFI_AP_STATE_CHANGED", intent.getAction())) {
            int intExtra = intent.getIntExtra("wifi_state", 0);
            if (intExtra == 11) {
                h.g("BroadcastReceiver 热点已关闭");
                return;
            }
            if (intExtra != 13) {
                return;
            }
            String strD = ye.h.d();
            h.g("BroadcastReceiver 热点已开启  获取热点IP：" + ye.h.d());
            if (Intrinsics.areEqual(strD, "0.0.0.0")) {
                throw null;
            }
            ye.h.d();
            throw null;
        }
    }
}
