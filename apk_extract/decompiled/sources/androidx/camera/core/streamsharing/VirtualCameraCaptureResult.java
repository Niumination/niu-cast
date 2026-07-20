package androidx.camera.core.streamsharing;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 21)
public class VirtualCameraCaptureResult implements CameraCaptureResult {

    @NonNull
    private final CameraCaptureResult mBaseCameraCaptureResult;

    @NonNull
    private final TagBundle mTagBundle;

    public VirtualCameraCaptureResult(@NonNull CameraCaptureResult cameraCaptureResult, @NonNull TagBundle tagBundle) {
        this.mBaseCameraCaptureResult = cameraCaptureResult;
        this.mTagBundle = tagBundle;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AeState getAeState() {
        return this.mBaseCameraCaptureResult.getAeState();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfMode getAfMode() {
        return this.mBaseCameraCaptureResult.getAfMode();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AfState getAfState() {
        return this.mBaseCameraCaptureResult.getAfState();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.AwbState getAwbState() {
        return this.mBaseCameraCaptureResult.getAwbState();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public CameraCaptureMetaData.FlashState getFlashState() {
        return this.mBaseCameraCaptureResult.getFlashState();
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    @NonNull
    public TagBundle getTagBundle() {
        return this.mTagBundle;
    }

    @Override // androidx.camera.core.impl.CameraCaptureResult
    public long getTimestamp() {
        return this.mBaseCameraCaptureResult.getTimestamp();
    }
}
