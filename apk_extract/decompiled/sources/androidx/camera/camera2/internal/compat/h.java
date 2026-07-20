package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraDevice;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f863a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CameraDeviceCompat.StateCallbackExecutorWrapper f864b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CameraDevice f865c;

    public /* synthetic */ h(CameraDeviceCompat.StateCallbackExecutorWrapper stateCallbackExecutorWrapper, CameraDevice cameraDevice, int i8) {
        this.f863a = i8;
        this.f864b = stateCallbackExecutorWrapper;
        this.f865c = cameraDevice;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f863a) {
            case 0:
                this.f864b.lambda$onClosed$3(this.f865c);
                break;
            case 1:
                this.f864b.lambda$onDisconnected$1(this.f865c);
                break;
            default:
                this.f864b.lambda$onOpened$0(this.f865c);
                break;
        }
    }
}
