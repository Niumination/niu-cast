package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    public TriangleEdgeTreatment(float f10, boolean z10) {
        this.size = f10;
        this.inside = z10;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f10, float f11, float f12, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f11 - (this.size * f12), 0.0f);
        shapePath.lineTo(f11, (this.inside ? this.size : -this.size) * f12);
        shapePath.lineTo((this.size * f12) + f11, 0.0f);
        shapePath.lineTo(f10, 0.0f);
    }
}
