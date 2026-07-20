package com.google.android.material.transition;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.transition.PathMotion;

/* JADX INFO: loaded from: classes.dex */
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f, float f4, float f10, float f11) {
        return f4 > f11 ? new PointF(f10, f4) : new PointF(f, f11);
    }

    @Override // androidx.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f4, float f10, float f11) {
        Path path = new Path();
        path.moveTo(f, f4);
        PointF controlPoint = getControlPoint(f, f4, f10, f11);
        path.quadTo(controlPoint.x, controlPoint.y, f10, f11);
        return path;
    }
}
