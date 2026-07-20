package com.transsion.iotservice.multiscreen.pc.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/notification/CancelTransferReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class CancelTransferReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter("CancelTransferReceiver", "tag");
        Intrinsics.checkNotNullParameter("receive cancel notification", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("CancelTransferReceiver"), "receive cancel notification");
        }
        i.c(null, true, 1);
    }
}
