package androidx.camera.core.impl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.Config;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface ConfigProvider<C extends Config> {
    @NonNull
    C getConfig();
}
