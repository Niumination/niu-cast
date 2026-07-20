package androidx.camera.core.concurrent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ConcurrentCameraConfig {

    @NonNull
    private List<SingleCameraConfig> mSingleCameraConfigs;

    public static class Builder {

        @NonNull
        private List<SingleCameraConfig> mSingleCameraConfigs;

        @NonNull
        public ConcurrentCameraConfig build() {
            return new ConcurrentCameraConfig(this.mSingleCameraConfigs);
        }

        @NonNull
        public Builder setCameraConfigs(@NonNull List<SingleCameraConfig> list) {
            this.mSingleCameraConfigs = list;
            return this;
        }
    }

    public ConcurrentCameraConfig(@NonNull List<SingleCameraConfig> list) {
        this.mSingleCameraConfigs = list;
    }

    @NonNull
    public List<SingleCameraConfig> getSingleCameraConfigs() {
        return this.mSingleCameraConfigs;
    }
}
