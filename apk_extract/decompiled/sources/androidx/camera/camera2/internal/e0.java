package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.params.SessionConfigurationCompat;
import androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e0 implements WaitForRepeatingRequestStart.SingleRepeatingRequest, ForceCloseCaptureSession.OnConfigured, WaitForRepeatingRequestStart.OpenCaptureSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SynchronizedCaptureSessionImpl f877a;

    public /* synthetic */ e0(SynchronizedCaptureSessionImpl synchronizedCaptureSessionImpl) {
        this.f877a = synchronizedCaptureSessionImpl;
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.SingleRepeatingRequest
    public int run(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        return this.f877a.lambda$setSingleRepeatingRequest$1(captureRequest, captureCallback);
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.WaitForRepeatingRequestStart.OpenCaptureSession
    public m4.l run(CameraDevice cameraDevice, SessionConfigurationCompat sessionConfigurationCompat, List list) {
        return this.f877a.lambda$openCaptureSession$0(cameraDevice, sessionConfigurationCompat, list);
    }

    @Override // androidx.camera.camera2.internal.compat.workaround.ForceCloseCaptureSession.OnConfigured
    public void run(SynchronizedCaptureSession synchronizedCaptureSession) {
        this.f877a.lambda$onConfigured$2(synchronizedCaptureSession);
    }
}
