package androidx.camera.core.internal;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.Size;
import android.view.Surface;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraEffect;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.UseCase;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.AttachedSurfaceInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraDeviceSurfaceManager;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.streamsharing.StreamSharing;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import r.a;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class CameraUseCaseAdapter implements Camera {
    private static final String TAG = "CameraUseCaseAdapter";
    private final CameraDeviceSurfaceManager mCameraDeviceSurfaceManager;

    @NonNull
    private final CameraInternal mCameraInternal;
    private final LinkedHashSet<CameraInternal> mCameraInternals;
    private final CameraId mId;

    @Nullable
    @GuardedBy("mLock")
    private UseCase mPlaceholderForExtensions;

    @Nullable
    @GuardedBy("mLock")
    private StreamSharing mStreamSharing;
    private final UseCaseConfigFactory mUseCaseConfigFactory;

    @Nullable
    @GuardedBy("mLock")
    private ViewPort mViewPort;

    @GuardedBy("mLock")
    private final List<UseCase> mAppUseCases = new ArrayList();

    @GuardedBy("mLock")
    private final List<UseCase> mCameraUseCases = new ArrayList();

    @NonNull
    @GuardedBy("mLock")
    private List<CameraEffect> mEffects = Collections.emptyList();

    @NonNull
    @GuardedBy("mLock")
    private CameraConfig mCameraConfig = CameraConfigs.emptyConfig();
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private boolean mAttached = true;

    @GuardedBy("mLock")
    private Config mInteropConfig = null;

    public static final class CameraException extends Exception {
        public CameraException() {
        }

        public CameraException(@NonNull String str) {
            super(str);
        }

        public CameraException(@NonNull Throwable th2) {
            super(th2);
        }
    }

    public static final class CameraId {
        private final List<String> mIds = new ArrayList();

        public CameraId(LinkedHashSet<CameraInternal> linkedHashSet) {
            Iterator<CameraInternal> it = linkedHashSet.iterator();
            while (it.hasNext()) {
                this.mIds.add(it.next().getCameraInfoInternal().getCameraId());
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof CameraId) {
                return this.mIds.equals(((CameraId) obj).mIds);
            }
            return false;
        }

        public int hashCode() {
            return this.mIds.hashCode() * 53;
        }
    }

    public static class ConfigPair {
        UseCaseConfig<?> mCameraConfig;
        UseCaseConfig<?> mExtendedConfig;

        public ConfigPair(UseCaseConfig<?> useCaseConfig, UseCaseConfig<?> useCaseConfig2) {
            this.mExtendedConfig = useCaseConfig;
            this.mCameraConfig = useCaseConfig2;
        }
    }

    public CameraUseCaseAdapter(@NonNull LinkedHashSet<CameraInternal> linkedHashSet, @NonNull CameraDeviceSurfaceManager cameraDeviceSurfaceManager, @NonNull UseCaseConfigFactory useCaseConfigFactory) {
        this.mCameraInternal = linkedHashSet.iterator().next();
        LinkedHashSet<CameraInternal> linkedHashSet2 = new LinkedHashSet<>(linkedHashSet);
        this.mCameraInternals = linkedHashSet2;
        this.mId = new CameraId(linkedHashSet2);
        this.mCameraDeviceSurfaceManager = cameraDeviceSurfaceManager;
        this.mUseCaseConfigFactory = useCaseConfigFactory;
    }

    private void cacheInteropConfig() {
        synchronized (this.mLock) {
            CameraControlInternal cameraControlInternal = this.mCameraInternal.getCameraControlInternal();
            this.mInteropConfig = cameraControlInternal.getInteropConfig();
            cameraControlInternal.clearInteropConfig();
        }
    }

    public static Collection<UseCase> calculateCameraUseCases(@NonNull Collection<UseCase> collection, @Nullable UseCase useCase, @Nullable StreamSharing streamSharing) {
        ArrayList arrayList = new ArrayList(collection);
        if (useCase != null) {
            arrayList.add(useCase);
        }
        if (streamSharing != null) {
            arrayList.add(streamSharing);
            arrayList.removeAll(streamSharing.getChildren());
        }
        return arrayList;
    }

    @NonNull
    private static Matrix calculateSensorToBufferTransformMatrix(@NonNull Rect rect, @NonNull Size size) {
        Preconditions.checkArgument(rect.width() > 0 && rect.height() > 0, "Cannot compute viewport crop rects zero sized sensor rect.");
        RectF rectF = new RectF(rect);
        Matrix matrix = new Matrix();
        matrix.setRectToRect(new RectF(0.0f, 0.0f, size.getWidth(), size.getHeight()), rectF, Matrix.ScaleToFit.CENTER);
        matrix.invert(matrix);
        return matrix;
    }

    private Map<UseCase, StreamSpec> calculateSuggestedStreamSpecs(@NonNull CameraInfoInternal cameraInfoInternal, @NonNull Collection<UseCase> collection, @NonNull Collection<UseCase> collection2, @NonNull Map<UseCase, ConfigPair> map) {
        ArrayList arrayList = new ArrayList();
        String cameraId = cameraInfoInternal.getCameraId();
        HashMap map2 = new HashMap();
        for (UseCase useCase : collection2) {
            arrayList.add(AttachedSurfaceInfo.create(this.mCameraDeviceSurfaceManager.transformSurfaceConfig(cameraId, useCase.getImageFormat(), useCase.getAttachedSurfaceResolution()), useCase.getImageFormat(), useCase.getAttachedSurfaceResolution(), useCase.getCurrentConfig().getTargetFramerate(null)));
            map2.put(useCase, useCase.getAttachedStreamSpec());
        }
        if (!collection.isEmpty()) {
            HashMap map3 = new HashMap();
            for (UseCase useCase2 : collection) {
                ConfigPair configPair = map.get(useCase2);
                map3.put(useCase2.mergeConfigs(cameraInfoInternal, configPair.mExtendedConfig, configPair.mCameraConfig), useCase2);
            }
            Map<UseCaseConfig<?>, StreamSpec> suggestedStreamSpecs = this.mCameraDeviceSurfaceManager.getSuggestedStreamSpecs(cameraId, arrayList, new ArrayList(map3.keySet()));
            for (Map.Entry entry : map3.entrySet()) {
                map2.put((UseCase) entry.getValue(), suggestedStreamSpecs.get(entry.getKey()));
            }
        }
        return map2;
    }

    private ImageCapture createExtraImageCapture() {
        return new ImageCapture.Builder().setTargetName("ImageCapture-Extra").build();
    }

    private Preview createExtraPreview() {
        Preview previewBuild = new Preview.Builder().setTargetName("Preview-Extra").build();
        previewBuild.setSurfaceProvider(new a());
        return previewBuild;
    }

    @Nullable
    private StreamSharing createOrReuseStreamSharing(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            try {
                Set<UseCase> streamSharingChildren = getStreamSharingChildren(collection);
                if (streamSharingChildren.size() < 2) {
                    return null;
                }
                StreamSharing streamSharing = this.mStreamSharing;
                if (streamSharing == null || !streamSharing.getChildren().equals(streamSharingChildren)) {
                    return new StreamSharing(this.mCameraInternal, streamSharingChildren, this.mUseCaseConfigFactory);
                }
                StreamSharing streamSharing2 = this.mStreamSharing;
                Objects.requireNonNull(streamSharing2);
                return streamSharing2;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @NonNull
    public static CameraId generateCameraId(@NonNull LinkedHashSet<CameraInternal> linkedHashSet) {
        return new CameraId(linkedHashSet);
    }

    private Map<UseCase, ConfigPair> getConfigs(Collection<UseCase> collection, UseCaseConfigFactory useCaseConfigFactory, UseCaseConfigFactory useCaseConfigFactory2) {
        HashMap map = new HashMap();
        for (UseCase useCase : collection) {
            map.put(useCase, new ConfigPair(useCase.getDefaultConfig(false, useCaseConfigFactory), useCase.getDefaultConfig(true, useCaseConfigFactory2)));
        }
        return map;
    }

    @NonNull
    private Set<UseCase> getStreamSharingChildren(@NonNull Collection<UseCase> collection) {
        HashSet hashSet = new HashSet();
        for (UseCase useCase : collection) {
            Preconditions.checkArgument(!isStreamSharing(useCase), "Only support one level of sharing for now.");
            if (isPrivateInputFormat(useCase)) {
                hashSet.add(useCase);
            }
        }
        return hashSet;
    }

    private boolean hasNoExtension() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = this.mCameraConfig == CameraConfigs.emptyConfig();
        }
        return z2;
    }

    private boolean isCoexistingPreviewImageCaptureRequired() {
        boolean z2;
        synchronized (this.mLock) {
            z2 = true;
            if (this.mCameraConfig.getUseCaseCombinationRequiredRule() != 1) {
                z2 = false;
            }
        }
        return z2;
    }

    private boolean isExtraImageCaptureRequired(@NonNull Collection<UseCase> collection) {
        boolean z2 = false;
        boolean z3 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase)) {
                z2 = true;
            } else if (isImageCapture(useCase)) {
                z3 = true;
            }
        }
        return z2 && !z3;
    }

    private boolean isExtraPreviewRequired(@NonNull Collection<UseCase> collection) {
        boolean z2 = false;
        boolean z3 = false;
        for (UseCase useCase : collection) {
            if (isPreview(useCase)) {
                z3 = true;
            } else if (isImageCapture(useCase)) {
                z2 = true;
            }
        }
        return z2 && !z3;
    }

    private static boolean isImageCapture(@Nullable UseCase useCase) {
        return useCase instanceof ImageCapture;
    }

    private static boolean isPreview(@Nullable UseCase useCase) {
        return useCase instanceof Preview;
    }

    private boolean isPrivateInputFormat(@NonNull UseCase useCase) {
        return useCase.mergeConfigs(this.mCameraInternal.getCameraInfoInternal(), null, useCase.getDefaultConfig(true, this.mUseCaseConfigFactory)).getInputFormat() == 34;
    }

    private static boolean isStreamSharing(@Nullable UseCase useCase) {
        return useCase instanceof StreamSharing;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$0(Surface surface, SurfaceTexture surfaceTexture, SurfaceRequest.Result result) {
        surface.release();
        surfaceTexture.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$createExtraPreview$1(SurfaceRequest surfaceRequest) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(surfaceRequest.getResolution().getWidth(), surfaceRequest.getResolution().getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        surfaceRequest.provideSurface(surface, CameraXExecutors.directExecutor(), new h1.a(1, surface, surfaceTexture));
    }

    private void restoreInteropConfig() {
        synchronized (this.mLock) {
            try {
                if (this.mInteropConfig != null) {
                    this.mCameraInternal.getCameraControlInternal().addInteropConfig(this.mInteropConfig);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @VisibleForTesting
    public static void updateEffects(@NonNull List<CameraEffect> list, @NonNull Collection<UseCase> collection) {
        HashMap map = new HashMap();
        for (CameraEffect cameraEffect : list) {
            map.put(Integer.valueOf(cameraEffect.getTargets()), cameraEffect);
        }
        for (UseCase useCase : collection) {
            if (useCase instanceof Preview) {
                useCase.setEffect((CameraEffect) map.get(1));
            } else if (useCase instanceof ImageCapture) {
                useCase.setEffect((CameraEffect) map.get(4));
            }
        }
    }

    private void updateViewPort(@NonNull Map<UseCase, StreamSpec> map, @NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            try {
                if (this.mViewPort != null) {
                    Map<UseCase, Rect> mapCalculateViewPortRects = ViewPorts.calculateViewPortRects(this.mCameraInternal.getCameraControlInternal().getSensorRect(), this.mCameraInternal.getCameraInfoInternal().getLensFacing() == 0, this.mViewPort.getAspectRatio(), this.mCameraInternal.getCameraInfoInternal().getSensorRotationDegrees(this.mViewPort.getRotation()), this.mViewPort.getScaleType(), this.mViewPort.getLayoutDirection(), map);
                    for (UseCase useCase : collection) {
                        useCase.setViewPortCropRect((Rect) Preconditions.checkNotNull(mapCalculateViewPortRects.get(useCase)));
                        useCase.setSensorToBufferTransformMatrix(calculateSensorToBufferTransformMatrix(this.mCameraInternal.getCameraControlInternal().getSensorRect(), ((StreamSpec) Preconditions.checkNotNull(map.get(useCase))).getResolution()));
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void addUseCases(@NonNull Collection<UseCase> collection) throws CameraException {
        synchronized (this.mLock) {
            try {
                ArrayList arrayList = new ArrayList(this.mAppUseCases);
                arrayList.removeAll(collection);
                arrayList.addAll(collection);
                try {
                    updateUseCases(arrayList);
                } catch (IllegalArgumentException e) {
                    throw new CameraException(e.getMessage());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void attachUseCases() {
        synchronized (this.mLock) {
            try {
                if (!this.mAttached) {
                    this.mCameraInternal.attachUseCases(this.mCameraUseCases);
                    restoreInteropConfig();
                    Iterator<UseCase> it = this.mCameraUseCases.iterator();
                    while (it.hasNext()) {
                        it.next().notifyState();
                    }
                    this.mAttached = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    @Nullable
    public UseCase calculatePlaceholderForExtensions(@NonNull Collection<UseCase> collection) {
        UseCase useCaseCreateExtraImageCapture;
        synchronized (this.mLock) {
            try {
                if (!isCoexistingPreviewImageCaptureRequired()) {
                    useCaseCreateExtraImageCapture = null;
                } else if (isExtraPreviewRequired(collection)) {
                    useCaseCreateExtraImageCapture = isPreview(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraPreview();
                } else if (isExtraImageCaptureRequired(collection)) {
                    useCaseCreateExtraImageCapture = isImageCapture(this.mPlaceholderForExtensions) ? this.mPlaceholderForExtensions : createExtraImageCapture();
                } else {
                    useCaseCreateExtraImageCapture = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return useCaseCreateExtraImageCapture;
    }

    public void detachUseCases() {
        synchronized (this.mLock) {
            try {
                if (this.mAttached) {
                    this.mCameraInternal.detachUseCases(new ArrayList(this.mCameraUseCases));
                    cacheInteropConfig();
                    this.mAttached = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraControl getCameraControl() {
        return this.mCameraInternal.getCameraControlInternal();
    }

    @NonNull
    public CameraId getCameraId() {
        return this.mId;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraInfo getCameraInfo() {
        return this.mCameraInternal.getCameraInfoInternal();
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public LinkedHashSet<CameraInternal> getCameraInternals() {
        return this.mCameraInternals;
    }

    @NonNull
    @VisibleForTesting
    public Collection<UseCase> getCameraUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mCameraUseCases);
        }
        return arrayList;
    }

    @Override // androidx.camera.core.Camera
    @NonNull
    public CameraConfig getExtendedConfig() {
        CameraConfig cameraConfig;
        synchronized (this.mLock) {
            cameraConfig = this.mCameraConfig;
        }
        return cameraConfig;
    }

    @NonNull
    public List<UseCase> getUseCases() {
        ArrayList arrayList;
        synchronized (this.mLock) {
            arrayList = new ArrayList(this.mAppUseCases);
        }
        return arrayList;
    }

    public boolean isEquivalent(@NonNull CameraUseCaseAdapter cameraUseCaseAdapter) {
        return this.mId.equals(cameraUseCaseAdapter.getCameraId());
    }

    @Override // androidx.camera.core.Camera
    public boolean isUseCasesCombinationSupported(@NonNull UseCase... useCaseArr) {
        synchronized (this.mLock) {
            try {
                try {
                    calculateSuggestedStreamSpecs(this.mCameraInternal.getCameraInfoInternal(), Arrays.asList(useCaseArr), Collections.emptyList(), getConfigs(Arrays.asList(useCaseArr), this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory));
                } catch (IllegalArgumentException unused) {
                    return false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return true;
    }

    public void removeUseCases(@NonNull Collection<UseCase> collection) {
        synchronized (this.mLock) {
            ArrayList arrayList = new ArrayList(this.mAppUseCases);
            arrayList.removeAll(collection);
            updateUseCases(arrayList);
        }
    }

    public void setActiveResumingMode(boolean z2) {
        this.mCameraInternal.setActiveResumingMode(z2);
    }

    public void setEffects(@Nullable List<CameraEffect> list) {
        synchronized (this.mLock) {
            this.mEffects = list;
        }
    }

    @Override // androidx.camera.core.Camera
    public void setExtendedConfig(@Nullable CameraConfig cameraConfig) {
        synchronized (this.mLock) {
            if (cameraConfig == null) {
                try {
                    cameraConfig = CameraConfigs.emptyConfig();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (!this.mAppUseCases.isEmpty() && !this.mCameraConfig.getCompatibilityId().equals(cameraConfig.getCompatibilityId())) {
                throw new IllegalStateException("Need to unbind all use cases before binding with extension enabled");
            }
            this.mCameraConfig = cameraConfig;
            this.mCameraInternal.setExtendedConfig(cameraConfig);
        }
    }

    public void setViewPort(@Nullable ViewPort viewPort) {
        synchronized (this.mLock) {
            this.mViewPort = viewPort;
        }
    }

    public void updateUseCases(@NonNull Collection<UseCase> collection) {
        updateUseCases(collection, false);
    }

    public void updateUseCases(@NonNull Collection<UseCase> collection, boolean z2) {
        synchronized (this.mLock) {
            try {
                UseCase useCaseCalculatePlaceholderForExtensions = calculatePlaceholderForExtensions(collection);
                StreamSharing streamSharingCreateOrReuseStreamSharing = z2 ? createOrReuseStreamSharing(collection) : null;
                Collection<UseCase> collectionCalculateCameraUseCases = calculateCameraUseCases(collection, useCaseCalculatePlaceholderForExtensions, streamSharingCreateOrReuseStreamSharing);
                ArrayList<UseCase> arrayList = new ArrayList(collectionCalculateCameraUseCases);
                arrayList.removeAll(this.mCameraUseCases);
                ArrayList arrayList2 = new ArrayList(collectionCalculateCameraUseCases);
                arrayList2.retainAll(this.mCameraUseCases);
                ArrayList arrayList3 = new ArrayList(this.mCameraUseCases);
                arrayList3.removeAll(collectionCalculateCameraUseCases);
                Map<UseCase, ConfigPair> configs = getConfigs(arrayList, this.mCameraConfig.getUseCaseConfigFactory(), this.mUseCaseConfigFactory);
                try {
                    Map<UseCase, StreamSpec> mapCalculateSuggestedStreamSpecs = calculateSuggestedStreamSpecs(this.mCameraInternal.getCameraInfoInternal(), arrayList, arrayList2, configs);
                    updateViewPort(mapCalculateSuggestedStreamSpecs, collectionCalculateCameraUseCases);
                    updateEffects(this.mEffects, collection);
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        ((UseCase) it.next()).unbindFromCamera(this.mCameraInternal);
                    }
                    this.mCameraInternal.detachUseCases(arrayList3);
                    for (UseCase useCase : arrayList) {
                        ConfigPair configPair = configs.get(useCase);
                        Objects.requireNonNull(configPair);
                        useCase.setHasCameraTransform(true);
                        useCase.bindToCamera(this.mCameraInternal, configPair.mExtendedConfig, configPair.mCameraConfig);
                        useCase.updateSuggestedStreamSpec((StreamSpec) Preconditions.checkNotNull(mapCalculateSuggestedStreamSpecs.get(useCase)));
                    }
                    if (this.mAttached) {
                        this.mCameraInternal.attachUseCases(arrayList);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        ((UseCase) it2.next()).notifyState();
                    }
                    this.mAppUseCases.clear();
                    this.mAppUseCases.addAll(collection);
                    this.mCameraUseCases.clear();
                    this.mCameraUseCases.addAll(collectionCalculateCameraUseCases);
                    this.mPlaceholderForExtensions = useCaseCalculatePlaceholderForExtensions;
                    this.mStreamSharing = streamSharingCreateOrReuseStreamSharing;
                } catch (IllegalArgumentException e) {
                    if (z2 || !hasNoExtension()) {
                        throw e;
                    }
                    updateUseCases(collection, true);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
