package com.transsion.iotservice.multiscreen.pc.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import ib.a;
import k3.gc;
import k3.n1;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.l0;
import qi.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/receiver/HomeKeyReceiver;", "Landroid/content/BroadcastReceiver;", "Lli/g0;", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class HomeKeyReceiver extends BroadcastReceiver implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f2673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f2674c;

    public HomeKeyReceiver(Function0 homeKeyCallback) {
        Intrinsics.checkNotNullParameter(homeKeyCallback, "homeKeyCallback");
        this.f2672a = n1.a();
        this.f2673b = homeKeyCallback;
    }

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f2672a.f9137a;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter("HomeKeyReceiver", "tag");
        Intrinsics.checkNotNullParameter("onReceive", "log");
        if (gc.f6462a <= 3) {
            Log.d(gc.f6463b.concat("HomeKeyReceiver"), "onReceive");
        }
        if (Intrinsics.areEqual("android.intent.action.CLOSE_SYSTEM_DIALOGS", intent != null ? intent.getAction() : null)) {
            l0.p(this, null, null, new a(intent, this, null), 3);
        }
    }
}
