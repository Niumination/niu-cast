package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
public final class MaterialArcMotion extends PathMotion {
    private static PointF getControlPoint(float f, float f4, float f10, float f11) {
        return f4 > f11 ? new PointF(f10, f4) : new PointF(f, f11);
    }

    @Override // android.transition.PathMotion
    @NonNull
    public Path getPath(float f, float f4, float f10, float f11) {
        Path path = new Path();
        path.moveTo(f, f4);
        PointF controlPoint = getControlPoint(f, f4, f10, f11);
        path.quadTo(controlPoint.x, controlPoint.y, f10, f11);
        return path;
    }
}
