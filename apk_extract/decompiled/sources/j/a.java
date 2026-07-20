package j;

import androidx.camera.camera2.internal.Camera2CameraControlImpl;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5910a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControlImpl f5911b;

    public /* synthetic */ a(Camera2CameraControlImpl camera2CameraControlImpl, int i8) {
        this.f5910a = i8;
        this.f5911b = camera2CameraControlImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f5910a;
        Camera2CameraControlImpl camera2CameraControlImpl = this.f5911b;
        switch (i8) {
            case 0:
                camera2CameraControlImpl.lambda$new$0();
                break;
            default:
                camera2CameraControlImpl.updateSessionConfigSynchronous();
                break;
        }
    }
}
