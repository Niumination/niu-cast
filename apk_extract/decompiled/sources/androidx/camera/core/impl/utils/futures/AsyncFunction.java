package androidx.camera.core.impl.utils.futures;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@FunctionalInterface
@RequiresApi(21)
public interface AsyncFunction<I, O> {
    @NonNull
    l apply(@Nullable I i8) throws Exception;
}
