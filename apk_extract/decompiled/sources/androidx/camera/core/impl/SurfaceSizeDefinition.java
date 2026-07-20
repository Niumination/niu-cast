package androidx.camera.core.impl;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class SurfaceSizeDefinition {
    @NonNull
    public static SurfaceSizeDefinition create(@NonNull Size size, @NonNull Size size2, @NonNull Size size3) {
        return new AutoValue_SurfaceSizeDefinition(size, size2, size3);
    }

    @NonNull
    public abstract Size getAnalysisSize();

    @NonNull
    public abstract Size getPreviewSize();

    @NonNull
    public abstract Size getRecordSize();
}
