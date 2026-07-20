package androidx.camera.core.imagecapture;

import android.util.Size;
import android.view.Surface;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.camera.core.ForwardingImageProxy;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.MetadataImageReader;
import androidx.camera.core.SafeCloseImageReaderProxy;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImageReaderProxy;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.processing.Edge;
import androidx.camera.core.processing.Node;
import androidx.core.util.Preconditions;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import m4.l;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
class CaptureNode implements Node<In, Out> {

    @VisibleForTesting
    static final int MAX_IMAGES = 4;
    private static final String TAG = "CaptureNode";

    @Nullable
    private In mInputEdge;

    @Nullable
    private Out mOutputEdge;

    @Nullable
    SafeCloseImageReaderProxy mSafeCloseImageReaderProxy;

    @NonNull
    private final Set<Integer> mPendingStageIds = new HashSet();
    ProcessingRequest mCurrentRequest = null;

    public static abstract class In {
        private CameraCaptureCallback mCameraCaptureCallback;
        private DeferrableSurface mSurface;

        @NonNull
        public static In of(Size size, int i8) {
            return new AutoValue_CaptureNode_In(size, i8, new Edge(), new Edge());
        }

        public CameraCaptureCallback getCameraCaptureCallback() {
            return this.mCameraCaptureCallback;
        }

        @NonNull
        public abstract Edge<ImageCaptureException> getErrorEdge();

        public abstract int getFormat();

        @NonNull
        public abstract Edge<ProcessingRequest> getRequestEdge();

        public abstract Size getSize();

        @NonNull
        public DeferrableSurface getSurface() {
            return this.mSurface;
        }

        public void setCameraCaptureCallback(@NonNull CameraCaptureCallback cameraCaptureCallback) {
            this.mCameraCaptureCallback = cameraCaptureCallback;
        }

        public void setSurface(@NonNull Surface surface) {
            Preconditions.checkState(this.mSurface == null, "The surface is already set.");
            this.mSurface = new ImmediateSurface(surface);
        }
    }

    public static abstract class Out {
        public static Out of(int i8) {
            return new AutoValue_CaptureNode_Out(new Edge(), new Edge(), i8);
        }

        public abstract int getFormat();

        public abstract Edge<ImageProxy> getImageEdge();

        public abstract Edge<ProcessingRequest> getRequestEdge();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$transform$0(ImageReaderProxy imageReaderProxy) {
        try {
            ImageProxy imageProxyAcquireLatestImage = imageReaderProxy.acquireLatestImage();
            if (imageProxyAcquireLatestImage != null) {
                onImageProxyAvailable(imageProxyAcquireLatestImage);
            } else {
                sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", null));
            }
        } catch (IllegalStateException e) {
            sendCaptureError(new ImageCaptureException(2, "Failed to acquire latest image", e));
        }
    }

    private void matchAndPropagateImage(@NonNull ImageProxy imageProxy) {
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mCurrentRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        Integer num = (Integer) tag;
        int iIntValue = num.intValue();
        Preconditions.checkState(this.mPendingStageIds.contains(num), "Received an unexpected stage id" + iIntValue);
        this.mPendingStageIds.remove(num);
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getImageEdge().accept(imageProxy);
        if (this.mPendingStageIds.isEmpty()) {
            ProcessingRequest processingRequest = this.mCurrentRequest;
            this.mCurrentRequest = null;
            processingRequest.onImageCaptured();
        }
    }

    private void releaseInputResources(@NonNull In in, @NonNull SafeCloseImageReaderProxy safeCloseImageReaderProxy) {
        in.getSurface().close();
        l terminationFuture = in.getSurface().getTerminationFuture();
        Objects.requireNonNull(safeCloseImageReaderProxy);
        terminationFuture.addListener(new a4.c(safeCloseImageReaderProxy, 23), CameraXExecutors.mainThreadExecutor());
    }

    @MainThread
    public int getCapacity() {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        return this.mSafeCloseImageReaderProxy.getCapacity();
    }

    @NonNull
    @VisibleForTesting
    public In getInputEdge() {
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        return in;
    }

    @MainThread
    @VisibleForTesting
    public void onImageProxyAvailable(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        if (this.mCurrentRequest != null) {
            matchAndPropagateImage(imageProxy);
            return;
        }
        Logger.d(TAG, "Discarding ImageProxy which was inadvertently acquired: " + imageProxy);
        imageProxy.close();
    }

    @MainThread
    @VisibleForTesting
    public void onRequestAvailable(@NonNull final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        Preconditions.checkState(getCapacity() > 0, "Too many acquire images. Close image to be able to process next.");
        Preconditions.checkState(this.mCurrentRequest == null || this.mPendingStageIds.isEmpty(), "The previous request is not complete");
        this.mCurrentRequest = processingRequest;
        this.mPendingStageIds.addAll(processingRequest.getStageIds());
        Out out = this.mOutputEdge;
        Objects.requireNonNull(out);
        out.getRequestEdge().accept(processingRequest);
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.CaptureNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest2 = processingRequest;
                CaptureNode captureNode = CaptureNode.this;
                if (processingRequest2 == captureNode.mCurrentRequest) {
                    captureNode.mCurrentRequest = null;
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r7) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.processing.Node
    @MainThread
    public void release() {
        Threads.checkMainThread();
        In in = this.mInputEdge;
        Objects.requireNonNull(in);
        SafeCloseImageReaderProxy safeCloseImageReaderProxy = this.mSafeCloseImageReaderProxy;
        Objects.requireNonNull(safeCloseImageReaderProxy);
        releaseInputResources(in, safeCloseImageReaderProxy);
    }

    @MainThread
    public void sendCaptureError(@NonNull ImageCaptureException imageCaptureException) {
        Threads.checkMainThread();
        ProcessingRequest processingRequest = this.mCurrentRequest;
        if (processingRequest != null) {
            processingRequest.onCaptureFailure(imageCaptureException);
        }
    }

    @MainThread
    public void setOnImageCloseListener(ForwardingImageProxy.OnImageCloseListener onImageCloseListener) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mSafeCloseImageReaderProxy != null, "The ImageReader is not initialized.");
        this.mSafeCloseImageReaderProxy.setOnImageCloseListener(onImageCloseListener);
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    public Out transform(@NonNull In in) {
        Preconditions.checkState(this.mInputEdge == null && this.mSafeCloseImageReaderProxy == null, "CaptureNode does not support recreation yet.");
        this.mInputEdge = in;
        Size size = in.getSize();
        MetadataImageReader metadataImageReader = new MetadataImageReader(size.getWidth(), size.getHeight(), in.getFormat(), 4);
        this.mSafeCloseImageReaderProxy = new SafeCloseImageReaderProxy(metadataImageReader);
        in.setCameraCaptureCallback(metadataImageReader.getCameraCaptureCallback());
        Surface surface = metadataImageReader.getSurface();
        Objects.requireNonNull(surface);
        in.setSurface(surface);
        metadataImageReader.setOnImageAvailableListener(new ImageReaderProxy.OnImageAvailableListener() { // from class: androidx.camera.core.imagecapture.a
            @Override // androidx.camera.core.impl.ImageReaderProxy.OnImageAvailableListener
            public final void onImageAvailable(ImageReaderProxy imageReaderProxy) {
                this.f962a.lambda$transform$0(imageReaderProxy);
            }
        }, CameraXExecutors.mainThreadExecutor());
        in.getRequestEdge().setListener(new b(this, 0));
        in.getErrorEdge().setListener(new b(this, 1));
        Out outOf = Out.of(in.getFormat());
        this.mOutputEdge = outOf;
        return outOf;
    }
}
