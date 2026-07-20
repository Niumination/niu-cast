package androidx.lifecycle;

import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface LifecycleEventObserver extends LifecycleObserver {
    void onStateChanged(@l LifecycleOwner lifecycleOwner, @l Lifecycle.Event event);
}
