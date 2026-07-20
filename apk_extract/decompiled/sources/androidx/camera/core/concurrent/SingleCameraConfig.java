package androidx.camera.core.concurrent;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCaseGroup;
import androidx.lifecycle.LifecycleOwner;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class SingleCameraConfig {

    @NonNull
    private CameraSelector mCameraSelector;

    @NonNull
    private LifecycleOwner mLifecycleOwner;

    @NonNull
    private UseCaseGroup mUseCaseGroup;

    public static class Builder {

        @NonNull
        private CameraSelector mCameraSelector;

        @NonNull
        private LifecycleOwner mLifecycleOwner;

        @NonNull
        private UseCaseGroup mUseCaseGroup;

        @NonNull
        public SingleCameraConfig build() {
            return new SingleCameraConfig(this.mCameraSelector, this.mLifecycleOwner, this.mUseCaseGroup);
        }

        @NonNull
        public Builder setCameraSelector(@NonNull CameraSelector cameraSelector) {
            this.mCameraSelector = cameraSelector;
            return this;
        }

        @NonNull
        public Builder setLifecycleOwner(@NonNull LifecycleOwner lifecycleOwner) {
            this.mLifecycleOwner = lifecycleOwner;
            return this;
        }

        @NonNull
        public Builder setUseCaseGroup(@NonNull UseCaseGroup useCaseGroup) {
            this.mUseCaseGroup = useCaseGroup;
            return this;
        }
    }

    public SingleCameraConfig(@NonNull CameraSelector cameraSelector, @NonNull LifecycleOwner lifecycleOwner, @NonNull UseCaseGroup useCaseGroup) {
        this.mCameraSelector = cameraSelector;
        this.mLifecycleOwner = lifecycleOwner;
        this.mUseCaseGroup = useCaseGroup;
    }

    @NonNull
    public CameraSelector getCameraSelector() {
        return this.mCameraSelector;
    }

    @NonNull
    public LifecycleOwner getLifecycleOwner() {
        return this.mLifecycleOwner;
    }

    @NonNull
    public UseCaseGroup getUseCaseGroup() {
        return this.mUseCaseGroup;
    }
}
