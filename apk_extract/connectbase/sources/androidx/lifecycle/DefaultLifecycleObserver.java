package androidx.lifecycle;

import kn.l0;
import os.l;

/* JADX INFO: loaded from: classes.dex */
public interface DefaultLifecycleObserver extends LifecycleObserver {
    default void onCreate(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "owner");
    }

    default void onDestroy(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "owner");
    }

    default void onPause(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "owner");
    }

    default void onResume(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "owner");
    }

    default void onStart(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "owner");
    }

    default void onStop(@l LifecycleOwner lifecycleOwner) {
        l0.p(lifecycleOwner, "owner");
    }
}
