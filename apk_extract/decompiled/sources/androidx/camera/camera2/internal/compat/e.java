package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AutoCloseable f856d;

    public /* synthetic */ e(Object obj, AutoCloseable autoCloseable, int i8, int i9) {
        this.f853a = i9;
        this.f855c = obj;
        this.f856d = autoCloseable;
        this.f854b = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f853a) {
            case 0:
                ((CameraCaptureSessionCompat.CaptureCallbackExecutorWrapper) this.f855c).lambda$onCaptureSequenceAborted$5((CameraCaptureSession) this.f856d, this.f854b);
                break;
            default:
                ((CameraDeviceCompat.StateCallbackExecutorWrapper) this.f855c).lambda$onError$2((CameraDevice) this.f856d, this.f854b);
                break;
        }
    }
}
