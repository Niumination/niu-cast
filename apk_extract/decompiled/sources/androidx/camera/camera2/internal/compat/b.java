package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper f842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CaptureRequest f844d;
    public final /* synthetic */ Object e;

    public /* synthetic */ b(CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper captureCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Object obj, int i8) {
        this.f841a = i8;
        this.f842b = captureCallbackExecutorWrapper;
        this.f843c = cameraCaptureSession;
        this.f844d = captureRequest;
        this.e = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f841a) {
            case 0:
                this.f842b.lambda$onCaptureCompleted$2(this.f843c, this.f844d, (TotalCaptureResult) this.e);
                break;
            case 1:
                this.f842b.lambda$onCaptureProgressed$1(this.f843c, this.f844d, (CaptureResult) this.e);
                break;
            default:
                this.f842b.lambda$onCaptureFailed$3(this.f843c, this.f844d, (CaptureFailure) this.e);
                break;
        }
    }
}
