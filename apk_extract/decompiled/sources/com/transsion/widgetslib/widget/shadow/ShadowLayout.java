package com.transsion.widgetslib.widget.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$styleable;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public class ShadowLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f3651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f3653d;
    public float e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Drawable f3654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Bitmap f3655i;

    public ShadowLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Bitmap bitmap = this.f3655i;
        if (bitmap != null && !bitmap.isRecycled()) {
            canvas.drawBitmap(this.f3655i, 0.0f, 0.0f, this.f3651b);
        }
        super.dispatchDraw(canvas);
    }

    public int getShadowColor() {
        return this.f3652c;
    }

    public float getShadowDistance() {
        return this.e;
    }

    public float getShadowRadius() {
        return this.f3653d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Bitmap bitmap = this.f3655i;
        if (bitmap != null) {
            bitmap.recycle();
            this.f3655i = null;
            this.f3654h = null;
        }
    }

    public void setShadowColor(int i8) {
        int iMin;
        this.f3652c = i8;
        this.f3654h.setTint(i8);
        Bitmap bitmap = this.f3655i;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Drawable drawable = this.f3654h;
        int dimensionPixelSize = (int) (((this.e + this.f3653d) * 2.0f) + this.f3650a.getResources().getDimensionPixelSize(R$dimen.os_fab_default_size));
        String[] strArr = j.f8764a;
        String[] strArr2 = hd.a.f5293a;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = dimensionPixelSize;
        }
        if (intrinsicHeight <= 0) {
            intrinsicHeight = dimensionPixelSize;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapCreateBitmap.compress(Bitmap.CompressFormat.WEBP, 100, byteArrayOutputStream);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            try {
                try {
                    try {
                        int i9 = byteArrayInputStream.read(bArr);
                        if (i9 == -1) {
                            break;
                        } else {
                            byteArrayOutputStream2.write(bArr, 0, i9);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayInputStream.close();
                        byteArrayOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                    throw th2;
                }
            } catch (IOException e10) {
                e10.printStackTrace();
                byteArrayInputStream.close();
                byteArrayOutputStream2.close();
            }
        }
        byteArrayInputStream.close();
        byteArrayOutputStream2.close();
        byte[] byteArray = byteArrayOutputStream2.toByteArray();
        BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        if (i10 > dimensionPixelSize || i11 > dimensionPixelSize) {
            float f = dimensionPixelSize;
            iMin = Math.min(Math.round(i10 / f), Math.round(i11 / f));
        } else {
            iMin = 1;
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (bitmapDecodeByteArray != null && iMin == 1 && (options.outWidth != dimensionPixelSize || options.outHeight != dimensionPixelSize)) {
            bitmapDecodeByteArray = Bitmap.createScaledBitmap(bitmapDecodeByteArray, dimensionPixelSize, dimensionPixelSize, true);
        }
        this.f3655i = bitmapDecodeByteArray;
        int i12 = (int) (this.e + this.f3653d);
        setPadding(i12, i12, i12, i12);
        requestLayout();
    }

    public void setShadowDistance(float f) {
        this.e = f;
        int i8 = (int) (f + this.f3653d);
        setPadding(i8, i8, i8, i8);
        requestLayout();
    }

    public void setShadowRadius(float f) {
        this.f3653d = Math.max(0.1f, f);
        if (isInEditMode()) {
            return;
        }
        int i8 = (int) (this.e + this.f3653d);
        setPadding(i8, i8, i8, i8);
        requestLayout();
    }

    public ShadowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i8, boolean z2) {
        super(context, attributeSet, i8);
        Paint paint = new Paint(1);
        this.f3651b = paint;
        this.f3650a = context;
        setWillNotDraw(false);
        setLayerType(2, paint);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ShadowLayout);
        try {
            try {
                setShadowRadius(typedArrayObtainStyledAttributes.getDimension(R$styleable.ShadowLayout_os_shadow_radius, TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics())));
                setShadowDistance(typedArrayObtainStyledAttributes.getDimension(R$styleable.ShadowLayout_os_shadow_distance, TypedValue.applyDimension(1, 3.3f, getResources().getDisplayMetrics())));
                this.f3654h = context.getDrawable(R$drawable.img_shadow);
                if (z2) {
                    setShadowColor(typedArrayObtainStyledAttributes.getColor(R$styleable.ShadowLayout_os_shadow_color, -2138535800));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public ShadowLayout(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, true);
    }
}
