package com.transsion.widgetslistitemlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class OSRoundImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f3811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f3812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f3813c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3814d;
    public boolean e;

    public OSRoundImageView(Context context) {
        super(context);
        this.f3811a = new Path();
        this.f3812b = new RectF();
        this.f3813c = new float[8];
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OSRoundImageView);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i8 = 0; i8 < indexCount; i8++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                if (index == R$styleable.OSRoundImageView_os_riv_radius) {
                    this.f3814d = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        float f = this.f3814d;
        boolean z2 = f > 0.0f;
        this.e = z2;
        if (z2) {
            Arrays.fill(this.f3813c, f);
        }
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.e) {
            Path path = this.f3811a;
            path.reset();
            float width = getWidth();
            float height = getHeight();
            RectF rectF = this.f3812b;
            rectF.set(0.0f, 0.0f, width, height);
            path.addRoundRect(rectF, this.f3813c, Path.Direction.CCW);
            canvas.clipPath(path);
        }
        super.draw(canvas);
    }

    public void setRadius(float f) {
        if (f < 0.0f) {
            return;
        }
        this.e = true;
        this.f3814d = f;
        Arrays.fill(this.f3813c, f);
        invalidate();
    }

    public OSRoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3811a = new Path();
        this.f3812b = new RectF();
        this.f3813c = new float[8];
        a(context, attributeSet);
    }

    public OSRoundImageView(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3811a = new Path();
        this.f3812b = new RectF();
        this.f3813c = new float[8];
        a(context, attributeSet);
    }
}
