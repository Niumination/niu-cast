package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface MutableConfig extends Config {
    <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @NonNull Config.OptionPriority optionPriority, @Nullable ValueT valuet);

    <ValueT> void insertOption(@NonNull Config.Option<ValueT> option, @Nullable ValueT valuet);

    @Nullable
    <ValueT> ValueT removeOption(@NonNull Config.Option<ValueT> option);
}
