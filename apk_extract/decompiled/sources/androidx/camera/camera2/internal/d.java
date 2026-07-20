package androidx.camera.camera2.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Camera2CameraImpl f871b;

    public /* synthetic */ d(Camera2CameraImpl camera2CameraImpl, int i8) {
        this.f870a = i8;
        this.f871b = camera2CameraImpl;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public final Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        int i8 = this.f870a;
        Camera2CameraImpl camera2CameraImpl = this.f871b;
        switch (i8) {
            case 0:
                return camera2CameraImpl.lambda$release$3(completer);
            default:
                return camera2CameraImpl.lambda$getOrCreateUserReleaseFuture$4(completer);
        }
    }
}
