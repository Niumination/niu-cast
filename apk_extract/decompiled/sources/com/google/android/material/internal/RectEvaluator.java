package com.google.android.material.internal;

import android.animation.TypeEvaluator;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RectEvaluator implements TypeEvaluator<Rect> {
    private final Rect rect;

    public RectEvaluator(@NonNull Rect rect) {
        this.rect = rect;
    }

    @Override // android.animation.TypeEvaluator
    public Rect evaluate(float f, @NonNull Rect rect, @NonNull Rect rect2) {
        int i8 = rect.left;
        int i9 = i8 + ((int) ((rect2.left - i8) * f));
        int i10 = rect.top;
        int i11 = i10 + ((int) ((rect2.top - i10) * f));
        int i12 = rect.right;
        int i13 = i12 + ((int) ((rect2.right - i12) * f));
        int i14 = rect.bottom;
        this.rect.set(i9, i11, i13, i14 + ((int) ((rect2.bottom - i14) * f)));
        return this.rect;
    }
}
