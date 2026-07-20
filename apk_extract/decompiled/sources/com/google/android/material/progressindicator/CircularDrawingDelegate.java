package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.math.MathUtils;

/* JADX INFO: loaded from: classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private boolean useStrokeCap;

    public CircularDrawingDelegate(@NonNull CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
    }

    private void drawArc(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, @ColorInt int i8, @Px int i9, @Px int i10) {
        float f10 = f4 >= f ? f4 - f : (f4 + 1.0f) - f;
        float f11 = f % 1.0f;
        if (this.totalTrackLengthFraction < 1.0f) {
            float f12 = f11 + f10;
            if (f12 > 1.0f) {
                drawArc(canvas, paint, f11, 1.0f, i8, i9, 0);
                drawArc(canvas, paint, 1.0f, f12, i8, 0, i10);
                return;
            }
        }
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        if (f11 == 0.0f && f10 >= 0.99f) {
            f10 += (((degrees * 2.0f) / 360.0f) * (f10 - 0.99f)) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
        }
        float fLerp = MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f11);
        float fLerp2 = MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f10);
        float degrees2 = (float) Math.toDegrees(i9 / this.adjustedRadius);
        float degrees3 = ((fLerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i10 / this.adjustedRadius));
        float f13 = (fLerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        paint.setAntiAlias(true);
        paint.setColor(i8);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f14 = degrees * 2.0f;
        if (degrees3 < f14) {
            float f15 = degrees3 / f14;
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, (degrees * f15) + f13, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness, f15);
            return;
        }
        float f16 = this.adjustedRadius;
        RectF rectF = new RectF(-f16, -f16, f16, f16);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f17 = f13 + degrees;
        canvas.drawArc(rectF, f17, degrees3 - f14, false, paint);
        if (this.useStrokeCap || this.displayedCornerRadius <= 0.0f) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        drawRoundedBlock(canvas, paint, f17, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
        drawRoundedBlock(canvas, paint, (f13 + degrees3) - degrees, this.displayedCornerRadius * 2.0f, this.displayedTrackThickness);
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, float f10) {
        drawRoundedBlock(canvas, paint, f, f4, f10, 1.0f);
    }

    private int getSize() {
        S s2 = this.spec;
        return (((CircularProgressIndicatorSpec) s2).indicatorInset * 2) + ((CircularProgressIndicatorSpec) s2).indicatorSize;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, boolean z2, boolean z3) {
        float fWidth = rect.width() / getPreferredWidth();
        float fHeight = rect.height() / getPreferredHeight();
        S s2 = this.spec;
        float f4 = (((CircularProgressIndicatorSpec) s2).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) s2).indicatorInset;
        canvas.translate((f4 * fWidth) + rect.left, (f4 * fHeight) + rect.top);
        canvas.rotate(-90.0f);
        canvas.scale(fWidth, fHeight);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
        }
        float f10 = -f4;
        canvas.clipRect(f10, f10, f4, f4);
        S s3 = this.spec;
        this.useStrokeCap = ((CircularProgressIndicatorSpec) s3).trackThickness / 2 <= ((CircularProgressIndicatorSpec) s3).trackCornerRadius;
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) s3).trackThickness * f;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) s3).trackThickness / 2, ((CircularProgressIndicatorSpec) s3).trackCornerRadius) * f;
        S s10 = this.spec;
        float f11 = (((CircularProgressIndicatorSpec) s10).indicatorSize - ((CircularProgressIndicatorSpec) s10).trackThickness) / 2.0f;
        this.adjustedRadius = f11;
        if (z2 || z3) {
            if ((z2 && ((CircularProgressIndicatorSpec) s10).showAnimationBehavior == 2) || (z3 && ((CircularProgressIndicatorSpec) s10).hideAnimationBehavior == 1)) {
                this.adjustedRadius = (((1.0f - f) * ((CircularProgressIndicatorSpec) s10).trackThickness) / 2.0f) + f11;
            } else if ((z2 && ((CircularProgressIndicatorSpec) s10).showAnimationBehavior == 1) || (z3 && ((CircularProgressIndicatorSpec) s10).hideAnimationBehavior == 2)) {
                this.adjustedRadius = f11 - (((1.0f - f) * ((CircularProgressIndicatorSpec) s10).trackThickness) / 2.0f);
            }
        }
        if (z3 && ((CircularProgressIndicatorSpec) s10).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9) {
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i8) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i8);
        float f = activeIndicator.startFraction;
        float f4 = activeIndicator.endFraction;
        int i9 = activeIndicator.gapSize;
        drawArc(canvas, paint, f, f4, iCompositeARGBWithAlpha, i9, i9);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, @ColorInt int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9, int i10) {
        drawArc(canvas, paint, f, f4, MaterialColors.compositeARGBWithAlpha(i8, i9), i10, i10);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, float f10, float f11) {
        float fMin = (int) Math.min(f10, this.displayedTrackThickness);
        float f12 = f4 / 2.0f;
        float fMin2 = Math.min(f12, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-fMin) / 2.0f, (-f4) / 2.0f, fMin / 2.0f, f12);
        canvas.save();
        double d7 = f;
        canvas.translate((float) (Math.cos(Math.toRadians(d7)) * ((double) this.adjustedRadius)), (float) (Math.sin(Math.toRadians(d7)) * ((double) this.adjustedRadius)));
        canvas.rotate(f);
        canvas.scale(f11, f11);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }
}
