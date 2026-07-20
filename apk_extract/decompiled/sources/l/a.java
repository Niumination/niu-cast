package l;

import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraControl f7072b;

    public /* synthetic */ a(Camera2CameraControl camera2CameraControl, int i8) {
        this.f7071a = i8;
        this.f7072b = camera2CameraControl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f7071a;
        Camera2CameraControl camera2CameraControl = this.f7072b;
        switch (i8) {
            case 0:
                return camera2CameraControl.lambda$addCaptureRequestOptions$4(completer);
            case 1:
                return camera2CameraControl.lambda$setCaptureRequestOptions$2(completer);
            default:
                return camera2CameraControl.lambda$clearCaptureRequestOptions$6(completer);
        }
    }
}
