package androidx.lifecycle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.CallSuper;
import kn.l0;
import lm.k;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public class LifecycleService extends Service implements LifecycleOwner {

    @l
    private final ServiceLifecycleDispatcher dispatcher = new ServiceLifecycleDispatcher(this);

    @Override // androidx.lifecycle.LifecycleOwner
    @l
    public Lifecycle getLifecycle() {
        return this.dispatcher.getLifecycle();
    }

    @Override // android.app.Service
    @m
    @CallSuper
    public IBinder onBind(@l Intent intent) {
        l0.p(intent, "intent");
        this.dispatcher.onServicePreSuperOnBind();
        return null;
    }

    @Override // android.app.Service
    @CallSuper
    public void onCreate() {
        this.dispatcher.onServicePreSuperOnCreate();
        super.onCreate();
    }

    @Override // android.app.Service
    @CallSuper
    public void onDestroy() {
        this.dispatcher.onServicePreSuperOnDestroy();
        super.onDestroy();
    }

    @Override // android.app.Service
    @k(message = "Deprecated in Java")
    @CallSuper
    public void onStart(@m Intent intent, int i10) {
        this.dispatcher.onServicePreSuperOnStart();
        super.onStart(intent, i10);
    }

    @Override // android.app.Service
    @CallSuper
    public int onStartCommand(@m Intent intent, int i10, int i11) {
        return super.onStartCommand(intent, i10, i11);
    }
}
