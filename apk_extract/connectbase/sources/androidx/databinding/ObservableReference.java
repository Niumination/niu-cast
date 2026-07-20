package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
interface ObservableReference<T> {
    void addListener(T t10);

    WeakListener<T> getListener();

    void removeListener(T t10);

    void setLifecycleOwner(LifecycleOwner lifecycleOwner);
}
