package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ContrastCurve {
    private final double high;
    private final double low;
    private final double medium;
    private final double normal;

    public ContrastCurve(double d7, double d10, double d11, double d12) {
        this.low = d7;
        this.normal = d10;
        this.medium = d11;
        this.high = d12;
    }

    public double getContrast(double d7) {
        if (d7 <= -1.0d) {
            return this.low;
        }
        if (d7 < 0.0d) {
            return MathUtils.lerp(this.low, this.normal, (d7 - (-1.0d)) / 1.0d);
        }
        if (d7 < 0.5d) {
            return MathUtils.lerp(this.normal, this.medium, (d7 - 0.0d) / 0.5d);
        }
        return d7 < 1.0d ? MathUtils.lerp(this.medium, this.high, (d7 - 0.5d) / 0.5d) : this.high;
    }
}
