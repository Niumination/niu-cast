package x;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.video.VideoOutput;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e implements VideoOutput {
    @Override // androidx.camera.video.VideoOutput
    public final void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        surfaceRequest.willNotProvideSurface();
    }
}
