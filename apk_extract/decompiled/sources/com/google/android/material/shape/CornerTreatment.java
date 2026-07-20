package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes.dex */
public class CornerTreatment {
    @Deprecated
    public void getCornerPath(float f, float f4, @NonNull ShapePath shapePath) {
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, float f10) {
        getCornerPath(f, f4, shapePath);
    }

    public void getCornerPath(@NonNull ShapePath shapePath, float f, float f4, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        getCornerPath(shapePath, f, f4, cornerSize.getCornerSize(rectF));
    }
}
