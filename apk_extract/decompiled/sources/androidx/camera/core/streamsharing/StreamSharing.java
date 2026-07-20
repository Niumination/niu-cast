package androidx.camera.core.streamsharing;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.processing.DefaultSurfaceProcessor;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import m.b;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public class StreamSharing extends UseCase {

    @NonNull
    private static final StreamSharingConfig DEFAULT_CONFIG;

    @Nullable
    private SurfaceEdge mCameraEdge;

    @Nullable
    private SurfaceProcessorNode mNode;

    @NonNull
    private final VirtualCamera mVirtualCamera;

    static {
        MutableConfig mutableConfig = new StreamSharingBuilder().getMutableConfig();
        mutableConfig.insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, 34);
        DEFAULT_CONFIG = new StreamSharingConfig(OptionsBundle.from(mutableConfig));
    }

    public StreamSharing(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this(new VirtualCamera(cameraInternal, set, useCaseConfigFactory));
    }

    private void addCameraErrorListener(@NonNull SessionConfig.Builder builder, @NonNull String str, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull StreamSpec streamSpec) {
        builder.addErrorListener(new b(this, str, useCaseConfig, streamSpec, 2));
    }

    private void clearPipeline() {
        SurfaceEdge surfaceEdge = this.mCameraEdge;
        if (surfaceEdge != null) {
            surfaceEdge.close();
            this.mCameraEdge = null;
        }
        SurfaceProcessorNode surfaceProcessorNode = this.mNode;
        if (surfaceProcessorNode != null) {
            surfaceProcessorNode.release();
            this.mNode = null;
        }
    }

    @NonNull
    @MainThread
    private SessionConfig createPipelineAndUpdateChildrenSpecs(@NonNull String str, @NonNull UseCaseConfig<?> useCaseConfig, @NonNull StreamSpec streamSpec) {
        Threads.checkMainThread();
        CameraInternal cameraInternal = (CameraInternal) Preconditions.checkNotNull(getCamera());
        Matrix sensorToBufferTransformMatrix = getSensorToBufferTransformMatrix();
        boolean hasCameraTransform = getHasCameraTransform();
        Rect cropRect = getCropRect(streamSpec.getResolution());
        Objects.requireNonNull(cropRect);
        this.mCameraEdge = new SurfaceEdge(3, streamSpec, sensorToBufferTransformMatrix, hasCameraTransform, cropRect, 0, false);
        this.mNode = new SurfaceProcessorNode(cameraInternal, DefaultSurfaceProcessor.Factory.newInstance());
        Map<UseCase, SurfaceProcessorNode.OutConfig> childrenOutConfigs = this.mVirtualCamera.getChildrenOutConfigs(this.mCameraEdge);
        SurfaceProcessorNode.Out outTransform = this.mNode.transform(SurfaceProcessorNode.In.of(this.mCameraEdge, new ArrayList(childrenOutConfigs.values())));
        HashMap map = new HashMap();
        for (Map.Entry<UseCase, SurfaceProcessorNode.OutConfig> entry : childrenOutConfigs.entrySet()) {
            map.put(entry.getKey(), outTransform.get(entry.getValue()));
        }
        this.mVirtualCamera.setChildrenEdges(map);
        SessionConfig.Builder builderCreateFrom = SessionConfig.Builder.createFrom(useCaseConfig);
        builderCreateFrom.addSurface(this.mCameraEdge.getDeferrableSurface());
        builderCreateFrom.addRepeatingCameraCaptureCallback(this.mVirtualCamera.getParentMetadataCallback());
        addCameraErrorListener(builderCreateFrom, str, useCaseConfig, streamSpec);
        return builderCreateFrom.build();
    }

    @Nullable
    private Rect getCropRect(@NonNull Size size) {
        return getViewPortCropRect() != null ? getViewPortCropRect() : new Rect(0, 0, size.getWidth(), size.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$addCameraErrorListener$0(String str, UseCaseConfig useCaseConfig, StreamSpec streamSpec, SessionConfig sessionConfig, SessionConfig.SessionError sessionError) {
        clearPipeline();
        if (isCurrentCamera(str)) {
            updateSessionConfig(createPipelineAndUpdateChildrenSpecs(str, useCaseConfig, streamSpec));
            notifyReset();
        }
    }

    @Nullable
    @VisibleForTesting
    public SurfaceEdge getCameraEdge() {
        return this.mCameraEdge;
    }

    @NonNull
    public Set<UseCase> getChildren() {
        return this.mVirtualCamera.getChildren();
    }

    @Override // androidx.camera.core.UseCase
    @Nullable
    public UseCaseConfig<?> getDefaultConfig(boolean z2, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        Config config = useCaseConfigFactory.getConfig(UseCaseConfigFactory.CaptureType.VIDEO_CAPTURE, 1);
        if (z2) {
            config = Config.mergeConfigs(config, DEFAULT_CONFIG.getConfig());
        }
        if (config == null) {
            return null;
        }
        return getUseCaseConfigBuilder(config).getUseCaseConfig();
    }

    @Nullable
    @VisibleForTesting
    public SurfaceProcessorNode getNode() {
        return this.mNode;
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig.Builder<?, ?, ?> getUseCaseConfigBuilder(@NonNull Config config) {
        return new StreamSharingBuilder(MutableOptionsBundle.from(config));
    }

    @Override // androidx.camera.core.UseCase
    public void onBind() {
        super.onBind();
        this.mVirtualCamera.bindChildren();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public UseCaseConfig<?> onMergeConfig(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull UseCaseConfig.Builder<?, ?, ?> builder) {
        this.mVirtualCamera.mergeChildrenConfigs(builder.getMutableConfig());
        return builder.getUseCaseConfig();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateAttached() {
        super.onStateAttached();
        this.mVirtualCamera.notifyStateAttached();
    }

    @Override // androidx.camera.core.UseCase
    public void onStateDetached() {
        super.onStateDetached();
        this.mVirtualCamera.notifyStateDetached();
    }

    @Override // androidx.camera.core.UseCase
    @NonNull
    public StreamSpec onSuggestedStreamSpecUpdated(@NonNull StreamSpec streamSpec) {
        updateSessionConfig(createPipelineAndUpdateChildrenSpecs(getCameraId(), getCurrentConfig(), streamSpec));
        notifyActive();
        return streamSpec;
    }

    @Override // androidx.camera.core.UseCase
    public void onUnbind() {
        super.onUnbind();
        clearPipeline();
        this.mVirtualCamera.unbindChildren();
    }

    public StreamSharing(@NonNull VirtualCamera virtualCamera) {
        super(DEFAULT_CONFIG);
        this.mVirtualCamera = virtualCamera;
    }
}
