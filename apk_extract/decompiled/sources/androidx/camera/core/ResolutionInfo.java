package androidx.camera.core;

import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class ResolutionInfo {
    @NonNull
    public static ResolutionInfo create(@NonNull Size size, @NonNull Rect rect, int i8) {
        return new AutoValue_ResolutionInfo(size, rect, i8);
    }

    @NonNull
    public abstract Rect getCropRect();

    @NonNull
    public abstract Size getResolution();

    public abstract int getRotationDegrees();
}
