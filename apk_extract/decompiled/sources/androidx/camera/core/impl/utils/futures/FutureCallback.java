package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface FutureCallback<V> {
    void onFailure(@NonNull Throwable th2);

    void onSuccess(@Nullable V v3);
}
