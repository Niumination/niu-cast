package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f, boolean z2) {
        this.size = f;
        this.inside = z2;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f4, float f10, @NonNull ShapePath shapePath) {
        if (!this.inside) {
            float f11 = this.size;
            shapePath.lineTo(f4 - (f11 * f10), 0.0f, f4, (-f11) * f10);
            shapePath.lineTo((this.size * f10) + f4, 0.0f, f, 0.0f);
        } else {
            shapePath.lineTo(f4 - (this.size * f10), 0.0f);
            float f12 = this.size;
            shapePath.lineTo(f4, f12 * f10, (f12 * f10) + f4, 0.0f);
            shapePath.lineTo(f, 0.0f);
        }
    }
}
