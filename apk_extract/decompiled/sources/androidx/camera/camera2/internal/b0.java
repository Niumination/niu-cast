package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSessionBaseImpl f827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSession f828c;

    public /* synthetic */ b0(SynchronizedCaptureSessionBaseImpl synchronizedCaptureSessionBaseImpl, SynchronizedCaptureSession synchronizedCaptureSession, int i8) {
        this.f826a = i8;
        this.f827b = synchronizedCaptureSessionBaseImpl;
        this.f828c = synchronizedCaptureSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f826a) {
            case 0:
                this.f827b.lambda$onSessionFinished$4(this.f828c);
                break;
            default:
                this.f827b.lambda$onClosed$3(this.f828c);
                break;
        }
    }
}
