package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.DeferrableSurface;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f825b;

    public /* synthetic */ b(Object obj, int i8) {
        this.f824a = i8;
        this.f825b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f824a;
        Object obj = this.f825b;
        switch (i8) {
            case 0:
                ((CameraCaptureCallback) obj).onCaptureCancelled();
                break;
            case 1:
                ((Camera2CameraImpl.StateCallback.ScheduledReopen) obj).lambda$run$0();
                break;
            case 2:
                ((Camera2CapturePipeline.PipelineTask) obj).postCapture();
                break;
            case 3:
                CaptureSessionRepository.forceOnClosed((LinkedHashSet) obj);
                break;
            case 4:
                ProcessingCaptureSession.lambda$open$1((DeferrableSurface) obj);
                break;
            case 5:
                ((SynchronizedCaptureSessionBaseImpl) obj).lambda$close$2();
                break;
            default:
                ((SynchronizedCaptureSessionImpl) obj).lambda$close$3();
                break;
        }
    }
}
