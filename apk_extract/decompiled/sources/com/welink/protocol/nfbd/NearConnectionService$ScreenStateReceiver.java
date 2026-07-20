package com.welink.protocol.nfbd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.constraintlayout.widget.ConstraintLayout;
import k3.lb;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/welink/protocol/nfbd/NearConnectionService$ScreenStateReceiver", "Landroid/content/BroadcastReceiver;", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class NearConnectionService$ScreenStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g f3882a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        String strN = o.d.n("onReceive : ", action, "NearConnectionService", "tag", "mes");
        if (lb.f6529c >= 1) {
            h0.a.x("TransConnect:", strN, "NearConnectionService", null);
        }
        boolean zAreEqual = Intrinsics.areEqual(action, "android.intent.action.SCREEN_ON");
        g gVar = this.f3882a;
        if (zAreEqual) {
            se.k kVar = g.L;
            gVar.m(true);
        } else if (Intrinsics.areEqual(action, "android.intent.action.SCREEN_OFF")) {
            se.k kVar2 = g.L;
            gVar.l(true);
        }
    }
}
