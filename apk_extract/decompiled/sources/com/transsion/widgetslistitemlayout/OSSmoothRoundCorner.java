package com.transsion.widgetslistitemlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import u8.a;
import u8.b;

/* JADX INFO: loaded from: classes3.dex */
public class OSSmoothRoundCorner extends AppCompatImageView {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Path f3826l = new Path();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f3827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3830d;
    public int e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f3831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3833j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public b f3834k;

    public OSSmoothRoundCorner(Context context) {
        super(context);
        this.f3828b = 16.0f;
        this.f3829c = 0.6f;
        this.f3830d = false;
        this.e = getResources().getColor(R$color.os_stroke_color);
        this.f3831h = 0.9f;
        a(context, null);
    }

    private Path getSmoothRoundPath() {
        f3826l.reset();
        throw null;
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSSmoothRoundCorner);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.OSSmoothRoundCorner_os_smooth_radius) {
                    this.f3828b = typedArrayObtainStyledAttributes.getDimension(index, this.f3828b);
                } else if (index == R$styleable.OSSmoothRoundCorner_os_smooth_stroke_color) {
                    this.e = typedArrayObtainStyledAttributes.getColor(index, context.getColor(R$color.os_stroke_color));
                } else if (index == R$styleable.OSSmoothRoundCorner_os_smooth_smoothness) {
                    this.f3829c = typedArrayObtainStyledAttributes.getFloat(index, this.f3829c);
                } else if (index == R$styleable.OSSmoothRoundCorner_os_smooth_is_clip_path) {
                    this.f3830d = typedArrayObtainStyledAttributes.getBoolean(index, false);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        Paint paint = new Paint();
        this.f3827a = paint;
        paint.setAntiAlias(true);
        this.f3827a.setStyle(Paint.Style.STROKE);
        this.f3827a.setStrokeWidth(this.f3831h);
        this.f3827a.setColor(this.e);
        if (this.f3834k == null) {
            this.f3834k = new b();
        }
    }

    public int getStrokeColor() {
        return this.e;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        this.f3827a.setColor(getStrokeColor());
        if (this.f3830d) {
            this.f3834k.a(canvas, this.f3832i, this.f3833j, this.f3828b, a.ALL);
        } else {
            b bVar = this.f3834k;
            float f = this.f3832i;
            float f4 = this.f3833j;
            float f10 = this.f3828b;
            Paint paint = this.f3827a;
            bVar.getClass();
            if (canvas == null) {
                throw new IllegalArgumentException("Illegal parameters canvas == null");
            }
            bVar.b(l9.a.f7349j).g(canvas, 0.0f, 0.0f, f, f4, f10 * 1.4f, paint);
        }
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i8, int i9) {
        super.onMeasure(i8, i9);
        this.f3832i = getMeasuredWidth();
        this.f3833j = getMeasuredHeight();
    }

    public void setClipCorner(float f) {
        this.f3828b = f;
        invalidate();
    }

    public void setIsClipPath(boolean z2) {
        this.f3830d = z2;
        invalidate();
    }

    public void setStrokeColor(int i8) {
        this.e = i8;
    }

    public OSSmoothRoundCorner(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3828b = 16.0f;
        this.f3829c = 0.6f;
        this.f3830d = false;
        this.e = getResources().getColor(R$color.os_stroke_color);
        this.f3831h = 0.9f;
        a(context, attributeSet);
    }

    public OSSmoothRoundCorner(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3828b = 16.0f;
        this.f3829c = 0.6f;
        this.f3830d = false;
        this.e = getResources().getColor(R$color.os_stroke_color);
        this.f3831h = 0.9f;
        a(context, attributeSet);
    }
}
