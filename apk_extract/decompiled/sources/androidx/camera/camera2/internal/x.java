package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class x implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f931a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ProcessingCaptureSession f932b;

    public /* synthetic */ x(ProcessingCaptureSession processingCaptureSession, int i8) {
        this.f931a = i8;
        this.f932b = processingCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f931a;
        ProcessingCaptureSession processingCaptureSession = this.f932b;
        switch (i8) {
            case 0:
                processingCaptureSession.lambda$open$0();
                break;
            default:
                processingCaptureSession.lambda$release$4();
                break;
        }
    }
}
