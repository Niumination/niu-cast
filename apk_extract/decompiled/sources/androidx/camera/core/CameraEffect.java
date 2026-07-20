package androidx.camera.core;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.camera.core.processing.SurfaceProcessorInternal;
import androidx.camera.core.processing.SurfaceProcessorWithExecutor;
import androidx.core.util.Preconditions;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public abstract class CameraEffect {
    public static final int IMAGE_CAPTURE = 4;
    public static final int PREVIEW = 1;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final int VIDEO_CAPTURE = 2;

    @NonNull
    private final Executor mExecutor;

    @Nullable
    private final ImageProcessor mImageProcessor;

    @Nullable
    private final SurfaceProcessor mSurfaceProcessor;
    private final int mTargets;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public @interface Targets {
    }

    public CameraEffect(int i8, @NonNull Executor executor, @NonNull ImageProcessor imageProcessor) {
        Preconditions.checkArgument(i8 == 4, "Currently ImageProcessor can only target IMAGE_CAPTURE.");
        this.mTargets = i8;
        this.mExecutor = executor;
        this.mSurfaceProcessor = null;
        this.mImageProcessor = imageProcessor;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public SurfaceProcessorInternal createSurfaceProcessorInternal() {
        SurfaceProcessor surfaceProcessor = getSurfaceProcessor();
        Objects.requireNonNull(surfaceProcessor);
        return new SurfaceProcessorWithExecutor(surfaceProcessor, getExecutor());
    }

    @NonNull
    public Executor getExecutor() {
        return this.mExecutor;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ImageProcessor getImageProcessor() {
        return this.mImageProcessor;
    }

    @Nullable
    public SurfaceProcessor getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    public int getTargets() {
        return this.mTargets;
    }

    public CameraEffect(int i8, @NonNull Executor executor, @NonNull SurfaceProcessor surfaceProcessor) {
        Preconditions.checkArgument(i8 == 1, "Currently SurfaceProcessor can only target PREVIEW.");
        this.mTargets = i8;
        this.mExecutor = executor;
        this.mSurfaceProcessor = surfaceProcessor;
        this.mImageProcessor = null;
    }
}
