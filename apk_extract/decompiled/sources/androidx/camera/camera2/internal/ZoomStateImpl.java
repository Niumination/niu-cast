package androidx.camera.camera2.internal;

import androidx.annotation.RequiresApi;
import androidx.camera.core.ZoomState;
import androidx.core.math.MathUtils;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ZoomStateImpl implements ZoomState {
    private float mLinearZoom;
    private final float mMaxZoomRatio;
    private final float mMinZoomRatio;
    private float mZoomRatio;

    public ZoomStateImpl(float f, float f4) {
        this.mMaxZoomRatio = f;
        this.mMinZoomRatio = f4;
    }

    private float getPercentageByRatio(float f) {
        float f4 = this.mMaxZoomRatio;
        float f10 = this.mMinZoomRatio;
        if (f4 == f10) {
            return 0.0f;
        }
        if (f == f4) {
            return 1.0f;
        }
        if (f == f10) {
            return 0.0f;
        }
        float f11 = 1.0f / f10;
        return ((1.0f / f) - f11) / ((1.0f / f4) - f11);
    }

    private float getRatioByPercentage(float f) {
        if (f == 1.0f) {
            return this.mMaxZoomRatio;
        }
        if (f == 0.0f) {
            return this.mMinZoomRatio;
        }
        float f4 = this.mMaxZoomRatio;
        float f10 = this.mMinZoomRatio;
        double d7 = 1.0f / f10;
        return (float) MathUtils.clamp(1.0d / (((((double) (1.0f / f4)) - d7) * ((double) f)) + d7), f10, f4);
    }

    @Override // androidx.camera.core.ZoomState
    public float getLinearZoom() {
        return this.mLinearZoom;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMaxZoomRatio() {
        return this.mMaxZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getMinZoomRatio() {
        return this.mMinZoomRatio;
    }

    @Override // androidx.camera.core.ZoomState
    public float getZoomRatio() {
        return this.mZoomRatio;
    }

    public void setLinearZoom(float f) throws IllegalArgumentException {
        if (f <= 1.0f && f >= 0.0f) {
            this.mLinearZoom = f;
            this.mZoomRatio = getRatioByPercentage(f);
        } else {
            throw new IllegalArgumentException("Requested linearZoom " + f + " is not within valid range [0..1]");
        }
    }

    public void setZoomRatio(float f) throws IllegalArgumentException {
        if (f <= this.mMaxZoomRatio && f >= this.mMinZoomRatio) {
            this.mZoomRatio = f;
            this.mLinearZoom = getPercentageByRatio(f);
            return;
        }
        throw new IllegalArgumentException("Requested zoomRatio " + f + " is not within valid range [" + this.mMinZoomRatio + " , " + this.mMaxZoomRatio + "]");
    }
}
