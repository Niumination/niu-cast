package androidx.camera.camera2.internal.compat;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f866a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraManagerCompat.AvailabilityCallbackExecutorWrapper f867b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f868c;

    public /* synthetic */ i(CameraManagerCompat.AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper, String str, int i8) {
        this.f866a = i8;
        this.f867b = availabilityCallbackExecutorWrapper;
        this.f868c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f866a) {
            case 0:
                this.f867b.lambda$onCameraAvailable$1(this.f868c);
                break;
            default:
                this.f867b.lambda$onCameraUnavailable$2(this.f868c);
                break;
        }
    }
}
