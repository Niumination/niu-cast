package l;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControl f7074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.Completer f7075c;

    public /* synthetic */ b(Camera2CameraControl camera2CameraControl, CallbackToFutureAdapter.Completer completer, int i8) {
        this.f7073a = i8;
        this.f7074b = camera2CameraControl;
        this.f7075c = completer;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7073a) {
            case 0:
                this.f7074b.lambda$addCaptureRequestOptions$3(this.f7075c);
                break;
            case 1:
                this.f7074b.lambda$setCaptureRequestOptions$1(this.f7075c);
                break;
            default:
                this.f7074b.lambda$clearCaptureRequestOptions$5(this.f7075c);
                break;
        }
    }
}
