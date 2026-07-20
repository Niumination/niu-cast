package androidx.camera.core.imagecapture;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
class SingleBundlingNode implements BundlingNode {
    private ProcessingNode.In mOutputEdge;
    ProcessingRequest mPendingRequest;

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void matchImageWithRequest(@NonNull ImageProxy imageProxy) {
        Threads.checkMainThread();
        Preconditions.checkState(this.mPendingRequest != null);
        Object tag = imageProxy.getImageInfo().getTagBundle().getTag(this.mPendingRequest.getTagBundleKey());
        Objects.requireNonNull(tag);
        Preconditions.checkState(((Integer) tag).intValue() == this.mPendingRequest.getStageIds().get(0).intValue());
        this.mOutputEdge.getEdge().accept(ProcessingNode.InputPacket.of(this.mPendingRequest, imageProxy));
        this.mPendingRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void trackIncomingRequest(@NonNull final ProcessingRequest processingRequest) {
        Threads.checkMainThread();
        Preconditions.checkState(processingRequest.getStageIds().size() == 1, "Cannot handle multi-image capture.");
        Preconditions.checkState(this.mPendingRequest == null, "Already has an existing request.");
        this.mPendingRequest = processingRequest;
        Futures.addCallback(processingRequest.getCaptureFuture(), new FutureCallback<Void>() { // from class: androidx.camera.core.imagecapture.SingleBundlingNode.1
            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onFailure(@NonNull Throwable th2) {
                Threads.checkMainThread();
                ProcessingRequest processingRequest2 = processingRequest;
                SingleBundlingNode singleBundlingNode = SingleBundlingNode.this;
                if (processingRequest2 == singleBundlingNode.mPendingRequest) {
                    singleBundlingNode.mPendingRequest = null;
                }
            }

            @Override // androidx.camera.core.impl.utils.futures.FutureCallback
            public void onSuccess(@Nullable Void r7) {
            }
        }, CameraXExecutors.directExecutor());
    }

    @Override // androidx.camera.core.processing.Node
    public void release() {
    }

    @Override // androidx.camera.core.processing.Node
    @NonNull
    public ProcessingNode.In transform(@NonNull CaptureNode.Out out) {
        final int i8 = 0;
        out.getImageEdge().setListener(new Consumer(this) { // from class: androidx.camera.core.imagecapture.e

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SingleBundlingNode f971b;

            {
                this.f971b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                int i9 = i8;
                SingleBundlingNode singleBundlingNode = this.f971b;
                switch (i9) {
                    case 0:
                        singleBundlingNode.matchImageWithRequest((ImageProxy) obj);
                        break;
                    default:
                        singleBundlingNode.trackIncomingRequest((ProcessingRequest) obj);
                        break;
                }
            }
        });
        final int i9 = 1;
        out.getRequestEdge().setListener(new Consumer(this) { // from class: androidx.camera.core.imagecapture.e

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ SingleBundlingNode f971b;

            {
                this.f971b = this;
            }

            @Override // androidx.core.util.Consumer
            public final void accept(Object obj) {
                int i10 = i9;
                SingleBundlingNode singleBundlingNode = this.f971b;
                switch (i10) {
                    case 0:
                        singleBundlingNode.matchImageWithRequest((ImageProxy) obj);
                        break;
                    default:
                        singleBundlingNode.trackIncomingRequest((ProcessingRequest) obj);
                        break;
                }
            }
        });
        ProcessingNode.In inOf = ProcessingNode.In.of(out.getFormat());
        this.mOutputEdge = inOf;
        return inOf;
    }
}
