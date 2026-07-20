package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSessionCompat.StateCallbackExecutorWrapper f858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraCaptureSession f859c;

    public /* synthetic */ f(CameraCaptureSessionCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraCaptureSession cameraCaptureSession, int i8) {
        this.f857a = i8;
        this.f858b = stateCallbackExecutorWrapper;
        this.f859c = cameraCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f857a) {
            case 0:
                this.f858b.lambda$onActive$3(this.f859c);
                break;
            case 1:
                this.f858b.lambda$onClosed$5(this.f859c);
                break;
            case 2:
                this.f858b.lambda$onCaptureQueueEmpty$4(this.f859c);
                break;
            case 3:
                this.f858b.lambda$onConfigured$0(this.f859c);
                break;
            case 4:
                this.f858b.lambda$onReady$2(this.f859c);
                break;
            default:
                this.f858b.lambda$onConfigureFailed$1(this.f859c);
                break;
        }
    }
}
