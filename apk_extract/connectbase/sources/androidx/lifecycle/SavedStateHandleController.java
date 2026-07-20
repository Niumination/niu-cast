package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.savedstate.SavedStateRegistry;
import cb.b;
import kn.l0;
import kn.r1;
import os.l;

/* JADX INFO: loaded from: classes.dex */
@r1({"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
public final class SavedStateHandleController implements LifecycleEventObserver {

    @l
    private final SavedStateHandle handle;
    private boolean isAttached;

    @l
    private final String key;

    public SavedStateHandleController(@l String str, @l SavedStateHandle savedStateHandle) {
        l0.p(str, b.c.f1408o);
        l0.p(savedStateHandle, "handle");
        this.key = str;
        this.handle = savedStateHandle;
    }

    public final void attachToLifecycle(@l SavedStateRegistry savedStateRegistry, @l Lifecycle lifecycle) {
        l0.p(savedStateRegistry, "registry");
        l0.p(lifecycle, "lifecycle");
        if (this.isAttached) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.isAttached = true;
        lifecycle.addObserver(this);
        savedStateRegistry.registerSavedStateProvider(this.key, this.handle.savedStateProvider());
    }

    @l
    public final SavedStateHandle getHandle() {
        return this.handle;
    }

    public final boolean isAttached() {
        return this.isAttached;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
        l0.p(lifecycleOwner, "source");
        l0.p(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_DESTROY) {
            this.isAttached = false;
            lifecycleOwner.getLifecycle().removeObserver(this);
        }
    }
}
