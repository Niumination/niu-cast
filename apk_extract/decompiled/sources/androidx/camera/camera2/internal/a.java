package androidx.camera.camera2.internal;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.SessionConfig;
import androidx.concurrent.futures.CallbackToFutureAdapter;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f821c;

    public /* synthetic */ a(int i8, Object obj, Object obj2) {
        this.f819a = i8;
        this.f820b = obj;
        this.f821c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f819a) {
            case 0:
                ((CameraCaptureCallback) this.f820b).onCaptureCompleted((CameraCaptureResult) this.f821c);
                break;
            case 1:
                ((CameraCaptureCallback) this.f820b).onCaptureFailed((CameraCaptureFailure) this.f821c);
                break;
            case 2:
                ((Camera2CameraControlImpl.CameraControlSessionCallback) this.f820b).lambda$onCaptureCompleted$0((TotalCaptureResult) this.f821c);
                break;
            case 3:
                Camera2CameraImpl.lambda$postSurfaceClosedError$14((SessionConfig.ErrorListener) this.f820b, (SessionConfig) this.f821c);
                break;
            case 4:
                ((Camera2CameraImpl) this.f820b).lambda$release$2((CallbackToFutureAdapter.Completer) this.f821c);
                break;
            case 5:
                Camera2CameraImpl.lambda$configAndClose$0((Surface) this.f820b, (SurfaceTexture) this.f821c);
                break;
            case 6:
                ((Camera2CameraImpl) this.f820b).lambda$onUseCaseInactive$6((String) this.f821c);
                break;
            default:
                ((FocusMeteringControl) this.f820b).lambda$cancelFocusAndMetering$7((CallbackToFutureAdapter.Completer) this.f821c);
                break;
        }
    }
}
