package com.google.android.material.bottomappbar;

import a1.a;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

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

    public BottomAppBarTopEdgeTreatment(float f, float f4, float f10) {
        this.fabMargin = f;
        this.roundedCornerRadius = f4;
        setCradleVerticalOffset(f10);
        this.horizontalOffset = 0.0f;
    }

    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f4, float f10, @NonNull ShapePath shapePath) {
        float f11;
        float f12;
        float f13 = this.fabDiameter;
        if (f13 == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f14 = ((this.fabMargin * 2.0f) + f13) / 2.0f;
        float f15 = f10 * this.roundedCornerRadius;
        float f16 = f4 + this.horizontalOffset;
        float fB = a.b(1.0f, f10, f14, this.cradleVerticalOffset * f10);
        if (fB / f14 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f17 = this.fabCornerSize;
        float f18 = f17 * f10;
        boolean z2 = f17 == -1.0f || Math.abs((f17 * 2.0f) - f13) < 0.1f;
        if (z2) {
            f11 = fB;
            f12 = 0.0f;
        } else {
            f12 = ROUNDED_CORNER_FAB_OFFSET;
            f11 = 0.0f;
        }
        float f19 = f14 + f15;
        float f20 = f11 + f15;
        float fSqrt = (float) Math.sqrt((f19 * f19) - (f20 * f20));
        float f21 = f16 - fSqrt;
        float f22 = f16 + fSqrt;
        float degrees = (float) Math.toDegrees(Math.atan(fSqrt / f20));
        float f23 = (90.0f - degrees) + f12;
        shapePath.lineTo(f21, 0.0f);
        float f24 = f15 * 2.0f;
        shapePath.addArc(f21 - f15, 0.0f, f21 + f15, f24, 270.0f, degrees);
        if (z2) {
            shapePath.addArc(f16 - f14, (-f14) - f11, f16 + f14, f14 - f11, 180.0f - f23, (f23 * 2.0f) - 180.0f);
        } else {
            float f25 = this.fabMargin;
            float f26 = f18 * 2.0f;
            float f27 = f16 - f14;
            shapePath.addArc(f27, -(f18 + f25), f27 + f25 + f26, f25 + f18, 180.0f - f23, ((f23 * 2.0f) - 180.0f) / 2.0f);
            float f28 = f16 + f14;
            float f29 = this.fabMargin;
            shapePath.lineTo(f28 - ((f29 / 2.0f) + f18), f29 + f18);
            float f30 = this.fabMargin;
            shapePath.addArc(f28 - (f26 + f30), -(f18 + f30), f28, f30 + f18, 90.0f, f23 - 90.0f);
        }
        shapePath.addArc(f22 - f15, 0.0f, f22 + f15, f24, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
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

    public void setCradleVerticalOffset(@FloatRange(from = 0.0d) float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f;
    }

    public void setFabCornerSize(float f) {
        this.fabCornerSize = f;
    }

    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
