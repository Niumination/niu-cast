package androidx.camera.core.streamsharing;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.processing.SurfaceEdge;
import androidx.camera.core.processing.SurfaceProcessorNode;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
class VirtualCamera implements CameraInternal {
    private static final String UNSUPPORTED_MESSAGE = "Operation not supported by VirtualCamera.";

    @NonNull
    final Set<UseCase> mChildren;

    @NonNull
    private final CameraInternal mParentCamera;

    @NonNull
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @NonNull
    final Map<UseCase, SurfaceEdge> mChildrenEdges = new HashMap();

    @NonNull
    final Map<UseCase, Boolean> mChildrenActiveState = new HashMap();

    @NonNull
    private final CameraCaptureCallback mParentMetadataCallback = createCameraCaptureCallback();

    public VirtualCamera(@NonNull CameraInternal cameraInternal, @NonNull Set<UseCase> set, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this.mParentCamera = cameraInternal;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
        this.mChildren = set;
        Iterator<UseCase> it = set.iterator();
        while (it.hasNext()) {
            this.mChildrenActiveState.put(it.next(), Boolean.FALSE);
        }
    }

    private void forceSetProvider(@NonNull SurfaceEdge surfaceEdge, @NonNull DeferrableSurface deferrableSurface) {
        surfaceEdge.invalidate();
        try {
            surfaceEdge.setProvider(deferrableSurface);
        } catch (DeferrableSurface.SurfaceClosedException e) {
            throw new RuntimeException(e);
        }
    }

    @Nullable
    private static DeferrableSurface getChildRepeatingSurface(@NonNull UseCase useCase) {
        List<DeferrableSurface> surfaces = useCase.getSessionConfig().getRepeatingCaptureConfig().getSurfaces();
        Preconditions.checkState(surfaces.size() <= 1);
        if (surfaces.size() == 1) {
            return surfaces.get(0);
        }
        return null;
    }

    @NonNull
    private SurfaceEdge getUseCaseEdge(@NonNull UseCase useCase) {
        SurfaceEdge surfaceEdge = this.mChildrenEdges.get(useCase);
        Objects.requireNonNull(surfaceEdge);
        return surfaceEdge;
    }

    private boolean isUseCaseActive(@NonNull UseCase useCase) {
        Boolean bool = this.mChildrenActiveState.get(useCase);
        Objects.requireNonNull(bool);
        return bool.booleanValue();
    }

    public static void sendCameraCaptureResultToChild(@NonNull CameraCaptureResult cameraCaptureResult, @NonNull SessionConfig sessionConfig) {
        Iterator<CameraCaptureCallback> it = sessionConfig.getRepeatingCameraCaptureCallbacks().iterator();
        while (it.hasNext()) {
            it.next().onCaptureCompleted(new VirtualCameraCaptureResult(cameraCaptureResult, sessionConfig.getRepeatingCaptureConfig().getTagBundle()));
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void attachUseCases(@NonNull Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void bindChildren() {
        for (UseCase useCase : this.mChildren) {
            useCase.setHasCameraTransform(false);
            useCase.bindToCamera(this, null, useCase.getDefaultConfig(true, this.mUseCaseConfigFactory));
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void close() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public CameraCaptureCallback createCameraCaptureCallback() {
        return new CameraCaptureCallback() { // from class: androidx.camera.core.streamsharing.VirtualCamera.1
            @Override // androidx.camera.core.impl.CameraCaptureCallback
            public void onCaptureCompleted(@NonNull CameraCaptureResult cameraCaptureResult) {
                super.onCaptureCompleted(cameraCaptureResult);
                Iterator<UseCase> it = VirtualCamera.this.mChildren.iterator();
                while (it.hasNext()) {
                    VirtualCamera.sendCameraCaptureResultToChild(cameraCaptureResult, it.next().getSessionConfig());
                }
            }
        };
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void detachUseCases(@NonNull Collection<UseCase> collection) {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraControlInternal getCameraControlInternal() {
        return this.mParentCamera.getCameraControlInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public CameraInfoInternal getCameraInfoInternal() {
        return this.mParentCamera.getCameraInfoInternal();
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public Observable<CameraInternal.State> getCameraState() {
        return this.mParentCamera.getCameraState();
    }

    @NonNull
    public Set<UseCase> getChildren() {
        return this.mChildren;
    }

    @NonNull
    public Map<UseCase, SurfaceProcessorNode.OutConfig> getChildrenOutConfigs(@NonNull SurfaceEdge surfaceEdge) {
        HashMap map = new HashMap();
        for (UseCase useCase : this.mChildren) {
            boolean z2 = useCase instanceof Preview;
            boolean z3 = true;
            int i8 = z2 ? 1 : 2;
            if (!z2 || !isFrontFacing()) {
                z3 = false;
            }
            map.put(useCase, SurfaceProcessorNode.OutConfig.of(i8, surfaceEdge.getCropRect(), TransformUtils.rectToSize(surfaceEdge.getCropRect()), z3));
        }
        return map;
    }

    @NonNull
    public CameraCaptureCallback getParentMetadataCallback() {
        return this.mParentMetadataCallback;
    }

    public void mergeChildrenConfigs(@NonNull MutableConfig mutableConfig) {
        HashSet hashSet = new HashSet();
        for (UseCase useCase : this.mChildren) {
            hashSet.add(useCase.mergeConfigs(this.mParentCamera.getCameraInfoInternal(), null, useCase.getDefaultConfig(true, this.mUseCaseConfigFactory)));
        }
        mutableConfig.insertOption(ImageOutputConfig.OPTION_CUSTOM_ORDERED_RESOLUTIONS, ResolutionUtils.getMergedResolutions(new ArrayList(this.mParentCamera.getCameraInfoInternal().getSupportedResolutions(34)), TransformUtils.rectToSize(this.mParentCamera.getCameraControlInternal().getSensorRect()), hashSet));
    }

    public void notifyStateAttached() {
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onStateAttached();
        }
    }

    public void notifyStateDetached() {
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().onStateDetached();
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseActive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            return;
        }
        this.mChildrenActiveState.put(useCase, Boolean.TRUE);
        DeferrableSurface childRepeatingSurface = getChildRepeatingSurface(useCase);
        if (childRepeatingSurface != null) {
            forceSetProvider(getUseCaseEdge(useCase), childRepeatingSurface);
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseInactive(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            this.mChildrenActiveState.put(useCase, Boolean.FALSE);
            getUseCaseEdge(useCase).disconnect();
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseReset(@NonNull UseCase useCase) {
        DeferrableSurface childRepeatingSurface;
        Threads.checkMainThread();
        SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
        useCaseEdge.invalidate();
        if (isUseCaseActive(useCase) && (childRepeatingSurface = getChildRepeatingSurface(useCase)) != null) {
            forceSetProvider(useCaseEdge, childRepeatingSurface);
        }
    }

    @Override // androidx.camera.core.UseCase.StateChangeCallback
    @MainThread
    public void onUseCaseUpdated(@NonNull UseCase useCase) {
        Threads.checkMainThread();
        if (isUseCaseActive(useCase)) {
            SurfaceEdge useCaseEdge = getUseCaseEdge(useCase);
            DeferrableSurface childRepeatingSurface = getChildRepeatingSurface(useCase);
            if (childRepeatingSurface != null) {
                forceSetProvider(useCaseEdge, childRepeatingSurface);
            } else {
                useCaseEdge.disconnect();
            }
        }
    }

    @Override // androidx.camera.core.impl.CameraInternal
    public void open() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    @Override // androidx.camera.core.impl.CameraInternal
    @NonNull
    public l release() {
        throw new UnsupportedOperationException(UNSUPPORTED_MESSAGE);
    }

    public void setChildrenEdges(@NonNull Map<UseCase, SurfaceEdge> map) {
        this.mChildrenEdges.clear();
        this.mChildrenEdges.putAll(map);
        for (Map.Entry<UseCase, SurfaceEdge> entry : this.mChildrenEdges.entrySet()) {
            UseCase key = entry.getKey();
            SurfaceEdge value = entry.getValue();
            key.setViewPortCropRect(value.getCropRect());
            key.updateSuggestedStreamSpec(value.getStreamSpec());
            key.notifyState();
        }
    }

    public void unbindChildren() {
        Iterator<UseCase> it = this.mChildren.iterator();
        while (it.hasNext()) {
            it.next().unbindFromCamera(this);
        }
    }
}
