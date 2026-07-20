package androidx.camera.core.impl;

import android.hardware.camera2.CaptureResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.camera.core.CameraInfo;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface SessionProcessor {

    public interface CaptureCallback {
        default void onCaptureCompleted(long j8, int i8, @NonNull Map<CaptureResult.Key, Object> map) {
        }

        default void onCaptureFailed(int i8) {
        }

        default void onCaptureProcessStarted(int i8) {
        }

        default void onCaptureSequenceAborted(int i8) {
        }

        default void onCaptureSequenceCompleted(int i8) {
        }

        default void onCaptureStarted(int i8, long j8) {
        }
    }

    void abortCapture(int i8);

    void deInitSession();

    @NonNull
    SessionConfig initSession(@NonNull CameraInfo cameraInfo, @NonNull OutputSurface outputSurface, @NonNull OutputSurface outputSurface2, @Nullable OutputSurface outputSurface3);

    void onCaptureSessionEnd();

    void onCaptureSessionStart(@NonNull RequestProcessor requestProcessor);

    void setParameters(@NonNull Config config);

    int startCapture(@NonNull CaptureCallback captureCallback);

    int startRepeating(@NonNull CaptureCallback captureCallback);

    default int startTrigger(@NonNull Config config, @NonNull CaptureCallback captureCallback) {
        return -1;
    }

    void stopRepeating();
}
