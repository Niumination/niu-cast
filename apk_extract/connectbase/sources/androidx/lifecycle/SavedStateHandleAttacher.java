package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class SavedStateHandleAttacher implements LifecycleEventObserver {

    @l
    private final SavedStateHandlesProvider provider;

    public SavedStateHandleAttacher(@l SavedStateHandlesProvider savedStateHandlesProvider) {
        l0.p(savedStateHandlesProvider, "provider");
        this.provider = savedStateHandlesProvider;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
        l0.p(lifecycleOwner, "source");
        l0.p(event, NotificationCompat.CATEGORY_EVENT);
        if (event == Lifecycle.Event.ON_CREATE) {
            lifecycleOwner.getLifecycle().removeObserver(this);
            this.provider.performRestore();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
