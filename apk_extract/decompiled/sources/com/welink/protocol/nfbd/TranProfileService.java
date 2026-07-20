package com.welink.protocol.nfbd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/welink/protocol/nfbd/TranProfileService;", "Landroid/app/Service;", "<init>", "()V", "welinkSDK_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public abstract class TranProfileService extends Service {
    public abstract void a();

    public abstract void b();

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i8, int i9) {
        we.h.a("onStartCommand");
        if (intent == null) {
            we.h.g("onStartCommand ignoring null intent.");
            return 1;
        }
        String stringExtra = intent.getStringExtra("action");
        if (stringExtra != null && Intrinsics.areEqual("com.android.bluetooth.btservice.action.STATE_CHANGED", stringExtra)) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
            if (intExtra == 10) {
                intent.getIntExtra("smart_state", 0);
                b();
            } else if (intExtra == 12) {
                intent.getIntExtra("smart_state", 1);
                a();
            }
        }
        return 1;
    }
}
