package androidx.lifecycle;

import android.os.Handler;
import androidx.core.app.NotificationCompat;
import kn.l0;
import os.l;
import os.m;

/* JADX INFO: loaded from: classes.dex */
public class ServiceLifecycleDispatcher {

    @l
    private final Handler handler;

    @m
    private DispatchRunnable lastDispatchRunnable;

    @l
    private final LifecycleRegistry registry;

    public static final class DispatchRunnable implements Runnable {

        @l
        private final Lifecycle.Event event;

        @l
        private final LifecycleRegistry registry;
        private boolean wasExecuted;

        public DispatchRunnable(@l LifecycleRegistry lifecycleRegistry, @l Lifecycle.Event event) {
            l0.p(lifecycleRegistry, "registry");
            l0.p(event, NotificationCompat.CATEGORY_EVENT);
            this.registry = lifecycleRegistry;
            this.event = event;
        }

        @l
        public final Lifecycle.Event getEvent() {
            return this.event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wasExecuted) {
                return;
            }
            this.registry.handleLifecycleEvent(this.event);
            this.wasExecuted = true;
        }
    }

    public ServiceLifecycleDispatcher(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "provider");
        this.registry = new LifecycleRegistry(lifecycleOwner);
        this.handler = new Handler();
    }

    private final void postDispatchRunnable(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.lastDispatchRunnable;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.registry, event);
        this.lastDispatchRunnable = dispatchRunnable2;
        Handler handler = this.handler;
        l0.m(dispatchRunnable2);
        handler.postAtFrontOfQueue(dispatchRunnable2);
    }

    @l
    public Lifecycle getLifecycle() {
        return this.registry;
    }

    public void onServicePreSuperOnBind() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }

    public void onServicePreSuperOnCreate() {
        postDispatchRunnable(Lifecycle.Event.ON_CREATE);
    }

    public void onServicePreSuperOnDestroy() {
        postDispatchRunnable(Lifecycle.Event.ON_STOP);
        postDispatchRunnable(Lifecycle.Event.ON_DESTROY);
    }

    public void onServicePreSuperOnStart() {
        postDispatchRunnable(Lifecycle.Event.ON_START);
    }
}
