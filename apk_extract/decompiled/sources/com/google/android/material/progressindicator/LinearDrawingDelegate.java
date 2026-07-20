package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ScatterMapKt;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.color.utilities.Contrast;

/* JADX INFO: loaded from: classes.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float displayedCornerRadius;
    private float displayedTrackThickness;

    @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN)
    private float totalTrackLengthFraction;
    private float trackLength;
    private boolean useStrokeCap;

    public LinearDrawingDelegate(@NonNull LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
    }

    private void drawLine(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, @ColorInt int i8, @Px int i9, @Px int i10) {
        float fClamp = MathUtils.clamp(f, 0.0f, 1.0f);
        float fClamp2 = MathUtils.clamp(f4, 0.0f, 1.0f);
        float fLerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp);
        float fLerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, fClamp2);
        int iClamp = (int) ((MathUtils.clamp(fLerp, 0.0f, 0.01f) * i9) / 0.01f);
        float fClamp3 = 1.0f - MathUtils.clamp(fLerp2, 0.99f, 1.0f);
        float f10 = this.trackLength;
        int i11 = (int) ((fLerp * f10) + iClamp);
        int i12 = (int) ((fLerp2 * f10) - ((int) ((fClamp3 * i10) / 0.01f)));
        float f11 = (-f10) / 2.0f;
        if (i11 <= i12) {
            float f12 = this.displayedCornerRadius;
            float f13 = i11 + f12;
            float f14 = i12 - f12;
            float f15 = f12 * 2.0f;
            paint.setColor(i8);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            if (f13 >= f14) {
                drawRoundedBlock(canvas, paint, new PointF(f13 + f11, 0.0f), new PointF(f14 + f11, 0.0f), f15, this.displayedTrackThickness);
                return;
            }
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(this.useStrokeCap ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            float f16 = f13 + f11;
            float f17 = f14 + f11;
            canvas.drawLine(f16, 0.0f, f17, 0.0f, paint);
            if (this.useStrokeCap || this.displayedCornerRadius <= 0.0f) {
                return;
            }
            paint.setStyle(Paint.Style.FILL);
            if (f13 > 0.0f) {
                drawRoundedBlock(canvas, paint, new PointF(f16, 0.0f), f15, this.displayedTrackThickness);
            }
            if (f14 < this.trackLength) {
                drawRoundedBlock(canvas, paint, new PointF(f17, 0.0f), f15, this.displayedTrackThickness);
            }
        }
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, float f, float f4) {
        drawRoundedBlock(canvas, paint, pointF, null, f, f4);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void adjustCanvas(@NonNull Canvas canvas, @NonNull Rect rect, @FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f, boolean z2, boolean z3) {
        this.trackLength = rect.width();
        float f4 = ((LinearProgressIndicatorSpec) this.spec).trackThickness;
        canvas.translate((rect.width() / 2.0f) + rect.left, Math.max(0.0f, (rect.height() - f4) / 2.0f) + (rect.height() / 2.0f) + rect.top);
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f10 = this.trackLength / 2.0f;
        float f11 = f4 / 2.0f;
        canvas.clipRect(-f10, -f11, f10, f11);
        S s2 = this.spec;
        this.useStrokeCap = ((LinearProgressIndicatorSpec) s2).trackThickness / 2 == ((LinearProgressIndicatorSpec) s2).trackCornerRadius;
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) s2).trackThickness * f;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) s2).trackThickness / 2, ((LinearProgressIndicatorSpec) s2).trackCornerRadius) * f;
        if (z2 || z3) {
            if ((z2 && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z3 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z2 || (z3 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, ((1.0f - f) * ((LinearProgressIndicatorSpec) this.spec).trackThickness) / 2.0f);
            }
        }
        if (z3 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @ColorInt int i8, @IntRange(from = 0, to = ScatterMapKt.Sentinel) int i9) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i8, i9);
        if (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize <= 0 || iCompositeARGBWithAlpha == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(iCompositeARGBWithAlpha);
        PointF pointF = new PointF((this.trackLength / 2.0f) - (this.displayedTrackThickness / 2.0f), 0.0f);
        S s2 = this.spec;
        drawRoundedBlock(canvas, paint, pointF, ((LinearProgressIndicatorSpec) s2).trackStopIndicatorSize, ((LinearProgressIndicatorSpec) s2).trackStopIndicatorSize);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull DrawingDelegate.ActiveIndicator activeIndicator, int i8) {
        int iCompositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i8);
        float f = activeIndicator.startFraction;
        float f4 = activeIndicator.endFraction;
        int i9 = activeIndicator.gapSize;
        drawLine(canvas, paint, f, f4, iCompositeARGBWithAlpha, i9, i9);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(@NonNull Canvas canvas, @NonNull Paint paint, float f, float f4, int i8, int i9, @Px int i10) {
        drawLine(canvas, paint, f, f4, MaterialColors.compositeARGBWithAlpha(i8, i9), i10, i10);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness;
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    private void drawRoundedBlock(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull PointF pointF, @Nullable PointF pointF2, float f, float f4) {
        float fMin = Math.min(f4, this.displayedTrackThickness);
        float f10 = f / 2.0f;
        float fMin2 = Math.min(f10, (this.displayedCornerRadius * fMin) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-fMin) / 2.0f, f10, fMin / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pointF2 != null) {
            canvas.translate(pointF2.x, pointF2.y);
            Path path = new Path();
            path.addRoundRect(rectF, fMin2, fMin2, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.translate(-pointF2.x, -pointF2.y);
        }
        canvas.translate(pointF.x, pointF.y);
        canvas.drawRoundRect(rectF, fMin2, fMin2, paint);
        canvas.restore();
    }
}
