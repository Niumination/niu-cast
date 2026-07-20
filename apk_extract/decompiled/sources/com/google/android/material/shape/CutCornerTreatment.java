package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, float f10) {
        shapePath.reset(0.0f, f10 * f4, 180.0f, 180.0f - f);
        double d7 = f10;
        double d10 = f4;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(f)) * d7 * d10), (float) (Math.sin(Math.toRadians(90.0f - f)) * d7 * d10));
    }

    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }
}
