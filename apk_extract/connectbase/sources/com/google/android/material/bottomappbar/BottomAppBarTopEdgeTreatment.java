package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;
import g.a;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f10, float f11, float f12) {
        this.fabMargin = f10;
        this.roundedCornerRadius = f11;
        setCradleVerticalOffset(f12);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        float f13;
        float f14;
        float f15 = this.fabDiameter;
        if (f15 == 0.0f) {
            shapePath.lineTo(f10, 0.0f);
            return;
        }
        float f16 = ((this.fabMargin * 2.0f) + f15) / 2.0f;
        float f17 = f12 * this.roundedCornerRadius;
        float f18 = f11 + this.horizontalOffset;
        float fA = a.a(1.0f, f12, f16, this.cradleVerticalOffset * f12);
        if (fA / f16 >= 1.0f) {
            shapePath.lineTo(f10, 0.0f);
            return;
        }
        float f19 = this.fabCornerSize;
        float f20 = f19 * f12;
        boolean z10 = f19 == -1.0f || Math.abs((f19 * 2.0f) - f15) < 0.1f;
        if (z10) {
            f13 = fA;
            f14 = 0.0f;
        } else {
            f14 = ROUNDED_CORNER_FAB_OFFSET;
            f13 = 0.0f;
        }
        float f21 = f16 + f17;
        float f22 = f13 + f17;
        float fSqrt = (float) Math.sqrt((f21 * f21) - (f22 * f22));
        float f23 = f18 - fSqrt;
        float f24 = f18 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f22));
        float f25 = (90.0f - degrees) + f14;
        shapePath.lineTo(f23, 0.0f);
        float f26 = f17 * 2.0f;
        shapePath.addArc(f23 - f17, 0.0f, f23 + f17, f26, 270.0f, degrees);
        if (z10) {
            shapePath.addArc(f18 - f16, (-f16) - f13, f18 + f16, f16 - f13, 180.0f - f25, (f25 * 2.0f) - 180.0f);
        } else {
            float f27 = this.fabMargin;
            float f28 = f20 * 2.0f;
            float f29 = f18 - f16;
            shapePath.addArc(f29, -(f20 + f27), f29 + f27 + f28, f27 + f20, 180.0f - f25, ((f25 * 2.0f) - 180.0f) / 2.0f);
            float f30 = f18 + f16;
            float f31 = this.fabMargin;
            shapePath.lineTo(f30 - ((f31 / 2.0f) + f20), f31 + f20);
            float f32 = this.fabMargin;
            shapePath.addArc(f30 - (f28 + f32), -(f20 + f32), f30, f32 + f20, 90.0f, f25 - 90.0f);
        }
        shapePath.addArc(f24 - f17, 0.0f, f24 + f17, f26, 270.0f - degrees, degrees);
        shapePath.lineTo(f10, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getFabDiameter() {
        return this.fabDiameter;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f10) {
        if (f10 < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f10;
    }

    public void setFabCornerSize(float f10) {
        this.fabCornerSize = f10;
    }

    public void setFabCradleMargin(float f10) {
        this.fabMargin = f10;
    }

    public void setFabCradleRoundedCornerRadius(float f10) {
        this.roundedCornerRadius = f10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f10) {
        this.fabDiameter = f10;
    }

    public void setHorizontalOffset(float f10) {
        this.horizontalOffset = f10;
    }
}
