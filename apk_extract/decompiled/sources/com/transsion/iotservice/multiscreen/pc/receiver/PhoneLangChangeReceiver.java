package com.transsion.iotservice.multiscreen.pc.receiver;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import bb.t;
import bb.v;
import com.transsion.iotservice.multiscreen.pc.helper.IconService;
import k3.gc;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/receiver/PhoneLangChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class PhoneLangChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (Intrinsics.areEqual(intent.getAction(), "android.intent.action.LOCALE_CHANGED")) {
            Intrinsics.checkNotNullParameter("PhoneLangChangeReceiver", "tag");
            Intrinsics.checkNotNullParameter("current lang is changed", "log");
            if (gc.f6462a <= 4) {
                Log.i(gc.f6463b.concat("PhoneLangChangeReceiver"), "current lang is changed");
            }
            context.startService(new Intent(context, (Class<?>) IconService.class));
            NotificationManager notificationManager = v.f1256a;
            ((Handler) v.f1260g.getValue()).post(new t(0));
        }
    }
}
