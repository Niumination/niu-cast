package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.MutableConfig;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface ExtendableBuilder<T> {
    @NonNull
    T build();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    MutableConfig getMutableConfig();
}
