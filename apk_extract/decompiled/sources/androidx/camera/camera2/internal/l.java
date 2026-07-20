package androidx.camera.camera2.internal;

import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.internal.utils.RingBuffer;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l implements Camera2CapturePipeline.ResultListener.Checker, RingBuffer.OnRemoveCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f903a;

    public /* synthetic */ l(int i8) {
        this.f903a = i8;
    }

    @Override // androidx.camera.camera2.internal.Camera2CapturePipeline.ResultListener.Checker
    public boolean check(TotalCaptureResult totalCaptureResult) {
        switch (this.f903a) {
            case 0:
                return Camera2CapturePipeline.Pipeline.lambda$executeCapture$1(totalCaptureResult);
            default:
                return Camera2CapturePipeline.TorchTask.lambda$preCapture$1(totalCaptureResult);
        }
    }

    @Override // androidx.camera.core.internal.utils.RingBuffer.OnRemoveCallback
    public void onRemove(Object obj) {
        ((ImageProxy) obj).close();
    }
}
