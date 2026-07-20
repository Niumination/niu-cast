package androidx.camera.camera2.internal;

import androidx.camera.core.impl.CaptureConfig;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CaptureConfig f823b;

    public /* synthetic */ a0(CaptureConfig captureConfig, int i8) {
        this.f822a = i8;
        this.f823b = captureConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f822a;
        CaptureConfig captureConfig = this.f823b;
        switch (i8) {
            case 0:
                ProcessingCaptureSession.AnonymousClass2.lambda$onCaptureSequenceCompleted$1(captureConfig);
                break;
            case 1:
                ProcessingCaptureSession.AnonymousClass2.lambda$onCaptureFailed$0(captureConfig);
                break;
            case 2:
                ProcessingCaptureSession.AnonymousClass3.lambda$onCaptureSequenceCompleted$1(captureConfig);
                break;
            default:
                ProcessingCaptureSession.AnonymousClass3.lambda$onCaptureFailed$0(captureConfig);
                break;
        }
    }
}
