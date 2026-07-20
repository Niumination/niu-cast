package com.transsion.iotservice.multiscreen.pc.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.constraintlayout.widget.ConstraintLayout;
import k3.n1;
import kb.a;
import kb.b;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import li.g0;
import li.g2;
import li.l0;
import qi.c;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/transsion/iotservice/multiscreen/pc/service/KeepLiveService;", "Landroid/app/Service;", "Lli/g0;", "<init>", "()V", "pc_phoneRelease"}, k = 1, mv = {2, 1, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
public final class KeepLiveService extends Service implements g0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static g2 f2675b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f2676a = n1.a();

    @Override // li.g0
    public final CoroutineContext getCoroutineContext() {
        return this.f2676a.f9137a;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return new Binder();
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Log.d("KeepLiveService", "onCreate");
        f2675b = l0.p(this, null, null, new b(this, null), 3);
        l0.p(this, null, null, new a(null), 3);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i8, int i9) {
        return 2;
    }
}
