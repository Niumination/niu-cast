package o;

import android.content.Context;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigProvider;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements CameraConfigProvider {
    @Override // androidx.camera.core.impl.CameraConfigProvider
    public final CameraConfig getConfig(CameraInfo cameraInfo, Context context) {
        return CameraConfigProvider.lambda$static$0(cameraInfo, context);
    }
}
