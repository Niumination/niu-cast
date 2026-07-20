package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class CanvasCompat {

    public interface CanvasOperation {
        void run(@NonNull Canvas canvas);
    }

    private CanvasCompat() {
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, @Nullable RectF rectF, int i8) {
        return canvas.saveLayerAlpha(rectF, i8);
    }

    public static int saveLayerAlpha(@NonNull Canvas canvas, float f, float f4, float f10, float f11, int i8) {
        return canvas.saveLayerAlpha(f, f4, f10, f11, i8);
    }
}
