package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements CameraBurstCaptureCallback.CaptureSequenceCallback, CallbackToFutureAdapter.Resolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CaptureSession f911a;

    public /* synthetic */ p(CaptureSession captureSession) {
        this.f911a = captureSession;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        return this.f911a.lambda$release$1(completer);
    }

    @Override // androidx.camera.camera2.internal.CameraBurstCaptureCallback.CaptureSequenceCallback
    public void onCaptureSequenceCompletedOrAborted(CameraCaptureSession cameraCaptureSession, int i8, boolean z2) {
        this.f911a.lambda$issueBurstCaptureRequest$2(cameraCaptureSession, i8, z2);
    }
}
