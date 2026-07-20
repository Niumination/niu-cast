package androidx.camera.core;

import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.impl.SizeCoordinate;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ResolutionSelector {
    private final boolean mIsHighResolutionEnabled;

    @Nullable
    private final Size mMaxResolution;
    private final int mPreferredAspectRatio;

    @Nullable
    private final Size mPreferredResolution;
    private final SizeCoordinate mSizeCoordinate;

    public ResolutionSelector(int i8, @Nullable Size size, @NonNull SizeCoordinate sizeCoordinate, @Nullable Size size2, boolean z2) {
        this.mPreferredAspectRatio = i8;
        this.mPreferredResolution = size;
        this.mSizeCoordinate = sizeCoordinate;
        this.mMaxResolution = size2;
        this.mIsHighResolutionEnabled = z2;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size getMaxResolution() {
        return this.mMaxResolution;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getPreferredAspectRatio() {
        return this.mPreferredAspectRatio;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Size getPreferredResolution() {
        return this.mPreferredResolution;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SizeCoordinate getSizeCoordinate() {
        return this.mSizeCoordinate;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isHighResolutionEnabled() {
        return this.mIsHighResolutionEnabled;
    }

    public static final class Builder {
        private boolean mIsHighResolutionEnabled;

        @Nullable
        private Size mMaxResolution;
        private int mPreferredAspectRatio;

        @Nullable
        private Size mPreferredResolution;

        @NonNull
        private SizeCoordinate mSizeCoordinate;

        public Builder() {
            this.mPreferredAspectRatio = 0;
            this.mPreferredResolution = null;
            this.mSizeCoordinate = SizeCoordinate.CAMERA_SENSOR;
            this.mMaxResolution = null;
            this.mIsHighResolutionEnabled = false;
        }

        @NonNull
        public static Builder fromSelector(@NonNull ResolutionSelector resolutionSelector) {
            return new Builder(resolutionSelector);
        }

        @NonNull
        public ResolutionSelector build() {
            return new ResolutionSelector(this.mPreferredAspectRatio, this.mPreferredResolution, this.mSizeCoordinate, this.mMaxResolution, this.mIsHighResolutionEnabled);
        }

        @NonNull
        public Builder setHighResolutionEnabled(boolean z2) {
            this.mIsHighResolutionEnabled = z2;
            return this;
        }

        @NonNull
        public Builder setMaxResolution(@NonNull Size size) {
            this.mMaxResolution = size;
            return this;
        }

        @NonNull
        public Builder setPreferredAspectRatio(int i8) {
            this.mPreferredAspectRatio = i8;
            return this;
        }

        @NonNull
        public Builder setPreferredResolution(@NonNull Size size) {
            this.mPreferredResolution = size;
            this.mSizeCoordinate = SizeCoordinate.CAMERA_SENSOR;
            return this;
        }

        @NonNull
        public Builder setPreferredResolutionByViewSize(@NonNull Size size) {
            this.mPreferredResolution = size;
            this.mSizeCoordinate = SizeCoordinate.ANDROID_VIEW;
            return this;
        }

        private Builder(@NonNull ResolutionSelector resolutionSelector) {
            this.mPreferredAspectRatio = 0;
            this.mPreferredResolution = null;
            this.mSizeCoordinate = SizeCoordinate.CAMERA_SENSOR;
            this.mMaxResolution = null;
            this.mIsHighResolutionEnabled = false;
            this.mPreferredAspectRatio = resolutionSelector.getPreferredAspectRatio();
            this.mPreferredResolution = resolutionSelector.getPreferredResolution();
            this.mSizeCoordinate = resolutionSelector.getSizeCoordinate();
            this.mMaxResolution = resolutionSelector.getMaxResolution();
            this.mIsHighResolutionEnabled = resolutionSelector.isHighResolutionEnabled();
        }
    }
}
