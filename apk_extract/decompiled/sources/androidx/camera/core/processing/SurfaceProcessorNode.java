package androidx.camera.core.processing;

import a0.g;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Size;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.Logger;
import androidx.camera.core.ProcessingException;
import androidx.camera.core.SurfaceOutput;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.StreamSpec;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.TransformUtils;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public class SurfaceProcessorNode implements Node<In, Out> {
    private static final String TAG = "SurfaceProcessorNode";

    @NonNull
    final CameraInternal mCameraInternal;

    @Nullable
    private In mInput;

    @Nullable
    private Out mOutput;

    @NonNull
    final SurfaceProcessorInternal mSurfaceProcessor;

    public static abstract class In {
        @NonNull
        public static In of(@NonNull SurfaceEdge surfaceEdge, @NonNull List<OutConfig> list) {
            return new AutoValue_SurfaceProcessorNode_In(surfaceEdge, list);
        }

        @NonNull
        public abstract List<OutConfig> getOutConfigs();

        @NonNull
        public abstract SurfaceEdge getSurfaceEdge();
    }

    public static class Out extends HashMap<OutConfig, SurfaceEdge> {
    }

    public SurfaceProcessorNode(@NonNull CameraInternal cameraInternal, @NonNull SurfaceProcessorInternal surfaceProcessorInternal) {
        this.mCameraInternal = cameraInternal;
        this.mSurfaceProcessor = surfaceProcessorInternal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: createAndSendSurfaceOutput, reason: merged with bridge method [inline-methods] */
    public void lambda$sendSurfaceOutputs$0(@NonNull SurfaceEdge surfaceEdge, Map.Entry<OutConfig, SurfaceEdge> entry) {
        Futures.addCallback(entry.getValue().createSurfaceOutputFuture(surfaceEdge.getStreamSpec().getResolution(), entry.getKey().getCropRect(), surfaceEdge.getRotationDegrees(), entry.getKey().getMirroring()), new FutureCallback<SurfaceOutput>() { // from class: androidx.camera.core.processing.SurfaceProcessorNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Logger.w(SurfaceProcessorNode.TAG, "Downstream node failed to provide Surface.", th2);
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable SurfaceOutput surfaceOutput) {
                Preconditions.checkNotNull(surfaceOutput);
                try {
                    SurfaceProcessorNode.this.mSurfaceProcessor.onOutputSurface(surfaceOutput);
                } catch (ProcessingException e) {
                    Logger.e(SurfaceProcessorNode.TAG, "Failed to send SurfaceOutput to SurfaceProcessor.", e);
                }
            }
        }, CameraXExecutors.mainThreadExecutor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$2() {
        Out out = this.mOutput;
        if (out != null) {
            Iterator<SurfaceEdge> it = out.values().iterator();
            while (it.hasNext()) {
                it.next().close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$setUpRotationUpdates$1(Collection collection, int i8, SurfaceRequest.TransformationInfo transformationInfo) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            SurfaceEdge surfaceEdge = (SurfaceEdge) it.next();
            int rotationDegrees = transformationInfo.getRotationDegrees() - i8;
            if (surfaceEdge.getMirroring()) {
                rotationDegrees = -rotationDegrees;
            }
            surfaceEdge.setRotationDegrees(TransformUtils.within360(rotationDegrees));
        }
    }

    private void sendSurfaceOutputs(@NonNull SurfaceEdge surfaceEdge, @NonNull Map<OutConfig, SurfaceEdge> map) {
        for (Map.Entry<OutConfig, SurfaceEdge> entry : map.entrySet()) {
            lambda$sendSurfaceOutputs$0(surfaceEdge, entry);
            entry.getValue().addOnInvalidatedListener(new g(this, 25, surfaceEdge, entry));
        }
    }

    private void sendSurfaceRequest(@NonNull SurfaceEdge surfaceEdge, @NonNull Collection<SurfaceEdge> collection) {
        SurfaceRequest surfaceRequestCreateSurfaceRequest = surfaceEdge.createSurfaceRequest(this.mCameraInternal);
        setUpRotationUpdates(surfaceRequestCreateSurfaceRequest, collection, surfaceEdge.getRotationDegrees());
        try {
            this.mSurfaceProcessor.onInputSurface(surfaceRequestCreateSurfaceRequest);
        } catch (ProcessingException e) {
            Logger.e(TAG, "Failed to send SurfaceRequest to SurfaceProcessor.", e);
        }
    }

    @NonNull
    private SurfaceEdge transformSingleOutput(@NonNull SurfaceEdge surfaceEdge, @NonNull OutConfig outConfig) {
        outConfig.getCropRect();
        int rotationDegrees = surfaceEdge.getRotationDegrees();
        boolean mirroring = outConfig.getMirroring();
        Matrix matrix = new Matrix(surfaceEdge.getSensorToBufferTransform());
        matrix.postConcat(TransformUtils.getRectToRect(TransformUtils.sizeToRectF(surfaceEdge.getStreamSpec().getResolution()), TransformUtils.sizeToRectF(outConfig.getSize()), rotationDegrees, mirroring));
        Preconditions.checkArgument(TransformUtils.isAspectRatioMatchingWithRoundingError(TransformUtils.getRotatedSize(outConfig.getCropRect(), rotationDegrees), outConfig.getSize()));
        return new SurfaceEdge(outConfig.getTargets(), StreamSpec.builder(outConfig.getSize()).setExpectedFrameRateRange(surfaceEdge.getStreamSpec().getExpectedFrameRateRange()).build(), matrix, false, TransformUtils.sizeToRect(outConfig.getSize()), 0, surfaceEdge.getMirroring() != mirroring);
    }

    @NonNull
    @VisibleForTesting
    public SurfaceProcessorInternal getSurfaceProcessor() {
        return this.mSurfaceProcessor;
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
        this.mSurfaceProcessor.release();
        CameraXExecutors.mainThreadExecutor().execute(new m.c(this, 13));
    }

    public void setUpRotationUpdates(@NonNull SurfaceRequest surfaceRequest, @NonNull Collection<SurfaceEdge> collection, int i8) {
        surfaceRequest.setTransformationInfoListener(CameraXExecutors.mainThreadExecutor(), new c4.a(collection, i8));
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    @MainThread
    public Out transform(@NonNull In in) {
        Threads.checkMainThread();
        this.mInput = in;
        this.mOutput = new Out();
        SurfaceEdge surfaceEdge = in.getSurfaceEdge();
        for (OutConfig outConfig : in.getOutConfigs()) {
            this.mOutput.put(outConfig, transformSingleOutput(surfaceEdge, outConfig));
        }
        sendSurfaceRequest(surfaceEdge, this.mOutput.values());
        sendSurfaceOutputs(surfaceEdge, this.mOutput);
        return this.mOutput;
    }

    public static abstract class OutConfig {
        @NonNull
        public static OutConfig of(@NonNull SurfaceEdge surfaceEdge) {
            return of(surfaceEdge.getTargets(), surfaceEdge.getCropRect(), TransformUtils.getRotatedSize(surfaceEdge.getCropRect(), surfaceEdge.getRotationDegrees()), surfaceEdge.getMirroring());
        }

        @NonNull
        public abstract Rect getCropRect();

        public abstract boolean getMirroring();

        @NonNull
        public abstract Size getSize();

        public abstract int getTargets();

        @NonNull
        public abstract UUID getUuid();

        @NonNull
        public static OutConfig of(int i8, @NonNull Rect rect, @NonNull Size size, boolean z2) {
            return new AutoValue_SurfaceProcessorNode_OutConfig(UUID.randomUUID(), i8, rect, size, z2);
        }
    }
}
