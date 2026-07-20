package androidx.camera.core.impl;

import android.content.Context;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.InitializationException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface CameraDeviceSurfaceManager {

    public interface Provider {
        @NonNull
        CameraDeviceSurfaceManager newInstance(@NonNull Context context, @Nullable Object obj, @NonNull Set<String> set) throws InitializationException;
    }

    boolean checkSupported(@NonNull String str, @Nullable List<SurfaceConfig> list);

    @NonNull
    Map<UseCaseConfig<?>, StreamSpec> getSuggestedStreamSpecs(@NonNull String str, @NonNull List<AttachedSurfaceInfo> list, @NonNull List<UseCaseConfig<?>> list2);

    @Nullable
    SurfaceConfig transformSurfaceConfig(@NonNull String str, int i8, @NonNull Size size);
}
