package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleController;
import androidx.lifecycle.LifecycleOwner;
import kn.l0;
import kn.r1;
import nq.l2;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nLifecycleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n1#1,70:1\n57#1,3:71\n57#1,3:74\n*S KotlinDebug\n*F\n+ 1 LifecycleController.kt\nandroidx/lifecycle/LifecycleController\n*L\n49#1:71,3\n36#1:74,3\n*E\n"})
@MainThread
public final class LifecycleController {

    @l
    private final DispatchQueue dispatchQueue;

    @l
    private final Lifecycle lifecycle;

    @l
    private final Lifecycle.State minState;

    @l
    private final LifecycleEventObserver observer;

    public LifecycleController(@l Lifecycle lifecycle, @l Lifecycle.State state, @l DispatchQueue dispatchQueue, @l final l2 l2Var) {
        l0.p(lifecycle, "lifecycle");
        l0.p(state, "minState");
        l0.p(dispatchQueue, "dispatchQueue");
        l0.p(l2Var, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: g0.d
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                LifecycleController.observer$lambda$0(this.f6343a, l2Var, lifecycleOwner, event);
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            l2.a.b(l2Var, null, 1, null);
            finish();
        }
    }

    private final void handleDestroy(l2 l2Var) {
        l2.a.b(l2Var, null, 1, null);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void observer$lambda$0(LifecycleController lifecycleController, l2 l2Var, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        l0.p(lifecycleController, "this$0");
        l0.p(l2Var, "$parentJob");
        l0.p(lifecycleOwner, "source");
        l0.p(event, "<anonymous parameter 1>");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            l2.a.b(l2Var, null, 1, null);
            lifecycleController.finish();
        } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(lifecycleController.minState) < 0) {
            lifecycleController.dispatchQueue.pause();
        } else {
            lifecycleController.dispatchQueue.resume();
        }
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
