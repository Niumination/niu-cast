package md;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f8016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RectF f8017b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f8018c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u8.b f8019d;
    public boolean e;

    public f(Context context, RectF rectF, int i8, float f) {
        Color.parseColor("#FE945F");
        this.e = false;
        this.f8017b = rectF;
        this.f8018c = f;
        Paint paint = new Paint();
        this.f8016a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i8);
        if (this.f8019d == null) {
            this.f8019d = new u8.b();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        boolean z2 = this.e;
        Paint paint = this.f8016a;
        RectF rectF = this.f8017b;
        if (z2 && j.s()) {
            if (paint == null || rectF == null) {
                return;
            }
            Path path = new Path();
            float f = this.f8018c;
            path.addRoundRect(rectF, new float[]{f, f, f, f, 0.0f, 0.0f, 0.0f, 0.0f}, Path.Direction.CW);
            canvas.drawPath(path, paint);
            return;
        }
        if (paint == null || rectF == null) {
            return;
        }
        u8.b bVar = this.f8019d;
        bVar.getClass();
        if (!bVar.b(l9.a.f7350k).c()) {
            float f4 = this.f8018c;
            canvas.drawRoundRect(rectF, f4, f4, paint);
            return;
        }
        u8.b bVar2 = this.f8019d;
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.right;
        float f13 = rectF.bottom;
        float f14 = this.f8018c;
        Paint paint2 = this.f8016a;
        bVar2.getClass();
        if (canvas == null) {
            throw new IllegalArgumentException("Illegal parameters canvas == null");
        }
        bVar2.b(l9.a.f7349j).g(canvas, f10, f11, f12, f13, f14 * 1.4f, paint2);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void setRadius(float f) {
        this.f8018c = f;
        invalidateSelf();
    }

    public f(Context context, RectF rectF, float f, Paint paint) {
        Color.parseColor("#FE945F");
        this.e = false;
        this.f8017b = rectF;
        this.f8016a = paint;
        this.f8018c = f;
        if (this.f8019d == null) {
            this.f8019d = new u8.b();
        }
    }
}
