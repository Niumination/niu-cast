package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public class MutableStateObservable<T> extends StateObservable<T> {
    private MutableStateObservable(@Nullable Object obj, boolean z2) {
        super(obj, z2);
    }

    @NonNull
    public static <T> MutableStateObservable<T> withInitialError(@NonNull Throwable th2) {
        return new MutableStateObservable<>(th2, true);
    }

    @NonNull
    public static <T> MutableStateObservable<T> withInitialState(@Nullable T t3) {
        return new MutableStateObservable<>(t3, false);
    }

    public void setError(@NonNull Throwable th2) {
        updateStateAsError(th2);
    }

    public void setState(@Nullable T t3) {
        updateState(t3);
    }
}
