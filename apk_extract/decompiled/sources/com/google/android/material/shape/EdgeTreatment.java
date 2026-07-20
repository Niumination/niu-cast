package com.google.android.material.shape;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class EdgeTreatment {
    public boolean forceIntersection() {
        return false;
    }

    @Deprecated
    public void getEdgePath(float f, float f4, @NonNull ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f4, shapePath);
    }

    public void getEdgePath(float f, float f4, float f10, @NonNull ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
