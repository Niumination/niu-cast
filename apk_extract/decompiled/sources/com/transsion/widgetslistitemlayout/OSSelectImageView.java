package com.transsion.widgetslistitemlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import hd.a;
import java.util.Arrays;
import pd.j;

/* JADX INFO: loaded from: classes3.dex */
public class OSSelectImageView extends OSRoundImageView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Paint f3815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RectF f3816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3818k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3819l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3820m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3821n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3822o;
    public boolean p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Path f3824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final RectF f3825t;
    public final float[] u;

    public OSSelectImageView(Context context) {
        super(context);
        this.f3824s = new Path();
        this.f3825t = new RectF();
        this.u = new float[8];
        init(context, null);
    }

    public int getBorderColor() {
        return this.f3820m;
    }

    public float getBorderInset() {
        return this.f3819l;
    }

    public float getBorderRadius() {
        return this.f3818k;
    }

    public float getBorderWidth() {
        return this.f3817j;
    }

    public float getRadius() {
        return this.q;
    }

    public float getUnSelectBorderWidth() {
        return this.f3822o;
    }

    public int getUnSelectedBorderColor() {
        return this.f3821n;
    }

    public final void init(Context context, AttributeSet attributeSet) {
        this.f3815h = new Paint(1);
        this.f3820m = j.e(context, R$attr.os_brand_primary, R$color.os_brand_primary_hios);
        this.f3821n = j.d(R$attr.os_fill_weaker, context.getColor(R$color.os_fill_weaker_hios), context);
        this.f3822o = a.a(context, 1);
        this.f3817j = a.a(context, 2);
        this.f3818k = a.a(context, 16);
        this.f3819l = a.a(context, 2);
        this.f3816i = new RectF();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSSelectImageView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.OSSelectImageView_os_siv_selected) {
                    this.f3823r = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSSelectImageView_os_siv_border_width) {
                    this.f3817j = typedArrayObtainStyledAttributes.getDimension(index, this.f3817j);
                } else if (index == R$styleable.OSSelectImageView_os_siv_border_radius) {
                    this.f3818k = typedArrayObtainStyledAttributes.getDimension(index, this.f3818k);
                } else if (index == R$styleable.OSSelectImageView_os_siv_border_inset) {
                    this.f3819l = typedArrayObtainStyledAttributes.getDimension(index, this.f3819l);
                } else if (index == R$styleable.OSSelectImageView_os_siv_radius) {
                    this.q = typedArrayObtainStyledAttributes.getDimension(index, this.q);
                } else if (index == R$styleable.OSSelectImageView_os_siv_need_unselected_border) {
                    this.p = typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R$styleable.OSSelectImageView_os_siv_border_color) {
                    this.f3820m = typedArrayObtainStyledAttributes.getColor(index, this.f3820m);
                } else if (index == R$styleable.OSSelectImageView_os_siv_unselected_border_color) {
                    this.f3821n = typedArrayObtainStyledAttributes.getColor(index, this.f3821n);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        float f = this.q;
        if (f != 0.0f) {
            Arrays.fill(this.u, f);
        }
    }

    @Override // android.view.View
    public final boolean isSelected() {
        return this.f3823r;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas canvas) {
        float f = (this.f3817j + this.f3819l) * 2.0f;
        float width = (getWidth() - f) / getWidth();
        float height = (getHeight() - f) / getHeight();
        int iSave = canvas.save();
        canvas.scale(width, height, getWidth() / 2.0f, getHeight() / 2.0f);
        if (this.q != 0.0f) {
            Path path = this.f3824s;
            path.reset();
            float width2 = getWidth();
            float height2 = getHeight();
            RectF rectF = this.f3825t;
            rectF.set(0.0f, 0.0f, width2, height2);
            path.addRoundRect(rectF, this.u, Path.Direction.CCW);
            canvas.clipPath(path);
        }
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
        if (this.f3823r || this.p) {
            RectF rectF2 = this.f3816i;
            float f4 = this.f3817j;
            rectF2.left = f4 / 2.0f;
            rectF2.top = f4 / 2.0f;
            rectF2.right = getWidth() - (this.f3817j / 2.0f);
            this.f3816i.bottom = getHeight() - (this.f3817j / 2.0f);
            this.f3815h.setStyle(Paint.Style.STROKE);
            this.f3815h.setColor(this.f3820m);
            this.f3815h.setStrokeWidth(this.f3817j);
            if (!this.f3823r && this.p) {
                this.f3815h.setColor(this.f3821n);
                this.f3815h.setStrokeWidth(this.f3822o);
            }
            RectF rectF3 = this.f3816i;
            float f10 = this.f3818k;
            canvas.drawRoundRect(rectF3, f10, f10, this.f3815h);
        }
    }

    public void setBorderColor(int i8) {
        this.f3820m = i8;
    }

    public void setBorderInset(float f) {
        this.f3819l = f;
    }

    public void setBorderRadius(float f) {
        this.f3818k = f;
    }

    public void setBorderWidth(float f) {
        this.f3817j = f;
    }

    public void setNeedUnSelectedBorder(boolean z2) {
        this.p = z2;
    }

    @Override // com.transsion.widgetslistitemlayout.OSRoundImageView
    public void setRadius(float f) {
        this.q = f;
    }

    @Override // android.widget.ImageView, android.view.View
    public void setSelected(boolean z2) {
        this.f3823r = z2;
        invalidate();
    }

    public void setUnSelectBorderWidth(float f) {
        this.f3822o = f;
    }

    public void setUnSelectedBorderColor(int i8) {
        this.f3821n = i8;
    }

    public OSSelectImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3824s = new Path();
        this.f3825t = new RectF();
        this.u = new float[8];
        init(context, attributeSet);
    }

    public OSSelectImageView(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3824s = new Path();
        this.f3825t = new RectF();
        this.u = new float[8];
        init(context, attributeSet);
    }
}
