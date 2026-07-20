package androidx.camera.camera2.internal;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f886a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f887b;

    public /* synthetic */ h(Camera2CameraImpl camera2CameraImpl, int i8) {
        this.f886a = i8;
        this.f887b = camera2CameraImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f886a;
        Camera2CameraImpl camera2CameraImpl = this.f887b;
        switch (i8) {
            case 0:
                camera2CameraImpl.openInternal();
                break;
            default:
                camera2CameraImpl.closeInternal();
                break;
        }
    }
}
