package com.transsion.pcconnect.invoke.bridge;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import yc.d;
import yc.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/transsion/pcconnect/invoke/bridge/IntegratedActionService;", "Landroid/app/Service;", "<init>", "()V", "invoke_bridge_release"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class IntegratedActionService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f2951b = f.f11122a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f2952a;

    public IntegratedActionService() {
        d dVar = new d();
        dVar.attachInterface(dVar, "com.transsion.pcconnect.invoke.bridge.IActionService");
        this.f2952a = dVar;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        o.d.B("onBind called with action: ", intent.getAction(), "IntegratedActionService");
        return this.f2952a;
    }

    @Override // android.app.Service
    public final boolean onUnbind(Intent intent) {
        Log.d("IntegratedActionService", "onUnbind called");
        return super.onUnbind(intent);
    }
}
