package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public final class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    @l
    private final GeneratedAdapter generatedAdapter;

    public SingleGeneratedAdapterObserver(@l GeneratedAdapter generatedAdapter) {
        l0.p(generatedAdapter, "generatedAdapter");
        this.generatedAdapter = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event) {
        l0.p(lifecycleOwner, "source");
        l0.p(event, NotificationCompat.CATEGORY_EVENT);
        this.generatedAdapter.callMethods(lifecycleOwner, event, false, null);
        this.generatedAdapter.callMethods(lifecycleOwner, event, true, null);
    }
}
