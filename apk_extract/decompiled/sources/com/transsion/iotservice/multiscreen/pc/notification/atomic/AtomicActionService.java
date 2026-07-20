package com.transsion.iotservice.multiscreen.pc.notification.atomic;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.constraintlayout.widget.ConstraintLayout;
import k3.gc;
import kotlin.Metadata;
import xa.i;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/notification/atomic/AtomicActionService;", "Landroid/app/Service;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class AtomicActionService extends Service {
    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i8, int i9) {
        Bundle extras;
        gc.c("Atomic-AtomicActionService", "onStartCommand");
        if (intent != null && (extras = intent.getExtras()) != null) {
            String string = extras.getString("clickAction");
            gc.c("Atomic-AtomicActionService", "onStartCommand clickAction: " + string);
            if (TextUtils.equals("pcconnect.intent.dynamic.ACTION_CANCEL_TRANSFER", string)) {
                i.c(null, true, 1);
            }
        }
        return 1;
    }
}
