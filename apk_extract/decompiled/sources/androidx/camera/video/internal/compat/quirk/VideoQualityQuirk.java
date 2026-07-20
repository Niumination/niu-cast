package androidx.camera.video.internal.compat.quirk;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.Quirk;
import androidx.camera.video.Quality;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface VideoQualityQuirk extends Quirk {
    boolean isProblematicVideoQuality(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Quality quality);

    default boolean workaroundBySurfaceProcessing() {
        return false;
    }
}
