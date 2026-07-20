package androidx.camera.core;

import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public interface ZoomState {
    float getLinearZoom();

    float getMaxZoomRatio();

    float getMinZoomRatio();

    float getZoomRatio();
}
