package md;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.view.OSCheckBox;
import k3.jc;
import k3.z8;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends Drawable implements h {
    public final float A;
    public final boolean G;
    public int L;
    public int M;
    public int N;
    public boolean P;
    public final float Q;
    public final float R;
    public final Bitmap S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ValueAnimator f7978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f7979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap f7980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f7981d;
    public Bitmap e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Bitmap f7982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f7983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f7984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f7985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f7986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f7987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f7988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f7989o;
    public float p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final float f7990r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Paint f7991s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Path f7992t;
    public final Path u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final PathMeasure f7993v;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final PathMeasure f7996y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f7997z;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final float[] f7994w = new float[2];

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final float[] f7995x = new float[2];
    public final float[] B = new float[2];
    public final float[] C = new float[2];
    public float D = 1.0f;
    public final RectF E = new RectF();
    public final RectF F = new RectF();
    public int H = -1;
    public final Paint I = new Paint(1);
    public int J = 0;
    public int K = Color.alpha(0);
    public int O = -1;

    public c(Context context, boolean z2) {
        this.f7979b = context;
        this.G = j.z(context);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Paint paint = new Paint(3);
        this.f7991s = paint;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeWidth(TypedValue.applyDimension(1, 2.0f, displayMetrics));
        paint.setColor(this.O);
        this.f7978a = ValueAnimator.ofFloat(new float[0]);
        this.f7992t = new Path();
        this.u = new Path();
        PathMeasure pathMeasure = new PathMeasure();
        this.f7993v = pathMeasure;
        Path path = new Path();
        PathMeasure pathMeasure2 = new PathMeasure();
        this.f7996y = pathMeasure2;
        this.f7989o = TypedValue.applyDimension(1, 4.0f, displayMetrics);
        int color = context.getColor(R$color.os_fill_quaternary_color);
        this.L = color;
        this.M = Color.alpha(color);
        this.N = j.e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
        float fApplyDimension = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.Q = fApplyDimension;
        float fApplyDimension2 = TypedValue.applyDimension(1, 4.3f, displayMetrics);
        this.R = fApplyDimension2;
        Drawable drawable = ContextCompat.getDrawable(context, R$drawable.os_checked_drawable_unchecked);
        if (drawable != null) {
            this.f7980c = jc.a(drawable);
            this.f7981d = jc.a(ContextCompat.getDrawable(context, R$drawable.os_checkbox_checked_bg));
            Bitmap bitmapA = jc.a(ContextCompat.getDrawable(context, R$drawable.os_checked_drawable_shadow));
            float f = fApplyDimension * 2.2f;
            int intrinsicWidth = (int) (getIntrinsicWidth() - f);
            int intrinsicHeight = (int) (getIntrinsicHeight() - f);
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, config);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint2 = new Paint();
            paint2.setColor(-1);
            canvas.drawRoundRect(0.0f, 0.0f, intrinsicWidth, intrinsicHeight, fApplyDimension2, fApplyDimension2, paint2);
            this.S = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), config);
            Canvas canvas2 = new Canvas(this.S);
            Paint paint3 = new Paint(1);
            canvas2.drawBitmap(bitmapA, 0.0f, 0.0f, paint3);
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            canvas2.drawBitmap(bitmapCreateBitmap, (this.S.getWidth() - bitmapCreateBitmap.getWidth()) / 2.0f, (this.S.getHeight() - bitmapCreateBitmap.getHeight()) / 2.0f, paint3);
            paint3.setXfermode(null);
            bitmapCreateBitmap.recycle();
        }
        Path path2 = new Path();
        path2.moveTo(-TypedValue.applyDimension(1, 6.0f, displayMetrics), -TypedValue.applyDimension(1, 2.33f, displayMetrics));
        path2.lineTo(-TypedValue.applyDimension(1, 1.0f, displayMetrics), TypedValue.applyDimension(1, 2.67f, displayMetrics));
        path2.lineTo(TypedValue.applyDimension(1, 5.67f, displayMetrics), -TypedValue.applyDimension(1, 4.67f, displayMetrics));
        pathMeasure.setPath(path2, false);
        float fApplyDimension3 = TypedValue.applyDimension(1, 2.33f, displayMetrics);
        this.f7990r = fApplyDimension3;
        path.reset();
        pathMeasure.getSegment(0.0f, TypedValue.applyDimension(1, 1.5f, displayMetrics) + fApplyDimension3, path, true);
        this.A = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        pathMeasure2.setPath(path, false);
        b(z2);
    }

    @Override // md.h
    public final void a(h hVar) {
        int i8;
        float f;
        int i9;
        if (hVar instanceof c) {
            ValueAnimator valueAnimator = this.f7978a;
            valueAnimator.cancel();
            c cVar = (c) hVar;
            int i10 = cVar.f7984j;
            int i11 = cVar.f7985k;
            float f4 = cVar.p;
            float f10 = cVar.q;
            float f11 = cVar.f7997z;
            float f12 = cVar.D;
            Rect bounds = getBounds();
            RectF rectF = this.E;
            rectF.set((-bounds.width()) / 2.0f, (-bounds.height()) / 2.0f, bounds.width() / 2.0f, bounds.height() / 2.0f);
            int iCenterX = (int) rectF.centerX();
            int iCenterY = (int) rectF.centerY();
            int i12 = OSCheckBox.f3137i;
            StringBuilder sbR = o.d.r(iCenterX, iCenterY, "startAnim, centerX: ", ", centerY: ", ", mRectF: ");
            sbR.append(rectF.toShortString());
            sbR.append(", mChecked: ");
            sbR.append(this.f7983i);
            sbR.append(", execFraction: ");
            sbR.append(f12);
            sbR.append(", this:");
            sbR.append(this);
            z8.f("OSCheckBox", sbR.toString());
            z8.f("OSCheckBox", "startAnim, tickLength: " + f10 + ", startLength: " + f11);
            if (this.f7983i) {
                valueAnimator.setValues(PropertyValuesHolder.ofKeyframe("pvh_border_scale", Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.333f, 0.0f), Keyframe.ofFloat(1.0f, 1.0f)), PropertyValuesHolder.ofKeyframe("pvh_frame_scale", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.333f, 1.2f), Keyframe.ofFloat(1.0f, 1.0f)));
                f = -f4;
                i9 = iCenterX - i10;
                i8 = iCenterY - i11;
            } else {
                int i13 = (int) (rectF.left - i10);
                i8 = (int) (rectF.top - i11);
                f = this.f7989o - f4;
                valueAnimator.setValues(PropertyValuesHolder.ofKeyframe("pvh_border_scale", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.333f, 1.2f), Keyframe.ofFloat(1.0f, 0.0f)), PropertyValuesHolder.ofKeyframe("pvh_frame_scale", Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.333f, 1.2f), Keyframe.ofFloat(1.0f, 1.0f)));
                i9 = i13;
            }
            valueAnimator.setDuration((long) (f12 * 300.0f));
            a aVar = new a(this, i10, i9, i11, i8, f4, f);
            valueAnimator.addUpdateListener(aVar);
            valueAnimator.setInterpolator(new FastOutSlowInInterpolator());
            valueAnimator.addListener(new b(this, aVar, 0));
            valueAnimator.start();
        }
    }

    public final void b(boolean z2) {
        this.f7983i = z2;
        this.f7984j = z2 ? 0 : (-getIntrinsicWidth()) / 2;
        this.f7985k = z2 ? 0 : (-getIntrinsicHeight()) / 2;
        this.f7986l = z2 ? 255 : 0;
        this.f7987m = z2 ? 1.0f : 0.0f;
        this.f7988n = 1.0f;
        this.p = z2 ? 0.0f : this.f7989o;
        Path path = this.f7992t;
        path.reset();
        if (!z2) {
            int i8 = this.f7984j;
            float f = this.f7985k;
            float intrinsicWidth = getIntrinsicWidth() + i8;
            float intrinsicHeight = getIntrinsicHeight() + this.f7985k;
            float f4 = this.p;
            path.addRoundRect(i8, f, intrinsicWidth, intrinsicHeight, f4, f4, Path.Direction.CCW);
        }
        PathMeasure pathMeasure = this.f7993v;
        float f10 = this.f7990r;
        this.q = z2 ? pathMeasure.getLength() - f10 : 0.0f;
        Path path2 = this.u;
        path2.reset();
        if (z2) {
            pathMeasure.getSegment(f10, this.q, path2, true);
        }
        this.f7997z = z2 ? this.f7996y.getLength() - this.A : 0.0f;
    }

    public final void c(boolean z2, boolean z3) {
        Context context = this.f7979b;
        if (z3) {
            if (z2) {
                setUncheckedBorderColor(context.getColor(R$color.os_color_white100));
                setUncheckedFillColor(context.getColor(R$color.os_color_black30));
            } else {
                setUncheckedBorderColor(j.e(context, R$attr.os_fill_base, R$color.os_fill_base_hios));
                setUncheckedFillColor(0);
            }
        } else if (z2) {
            setUncheckedBorderColor(context.getColor(R$color.os_uncheck_box_pic_border_color));
            this.J = context.getColor(R$color.os_color_gray80);
            this.K = 128;
        } else {
            setUncheckedBorderColor(j.e(context, R$attr.os_fill_weaker, R$color.os_fill_weaker_hios));
            setUncheckedFillColor(0);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.f7980c == null || this.f7981d == null || bounds.isEmpty()) {
            return;
        }
        canvas.translate(bounds.centerX(), bounds.centerY());
        if (this.G) {
            canvas.scale(1.2220833f, 1.2220833f);
        }
        float f = ((-bounds.width()) / 2.0f) * this.f7988n;
        float f4 = ((-bounds.height()) / 2.0f) * this.f7988n;
        float fWidth = (bounds.width() / 2.0f) * this.f7988n;
        float fHeight = (bounds.height() / 2.0f) * this.f7988n;
        RectF rectF = this.F;
        rectF.set(f, f4, fWidth, fHeight);
        float f10 = ((-bounds.width()) / 2.0f) * this.f7987m;
        float f11 = ((-bounds.height()) / 2.0f) * this.f7987m;
        float fWidth2 = (bounds.width() / 2.0f) * this.f7987m;
        float fHeight2 = (bounds.height() / 2.0f) * this.f7987m;
        RectF rectF2 = this.E;
        rectF2.set(f10, f11, fWidth2, fHeight2);
        if (this.P) {
            canvas.drawBitmap(this.S, (Rect) null, rectF, (Paint) null);
        }
        int i8 = this.J;
        Paint paint = this.I;
        paint.setColor(i8);
        int i9 = this.H;
        int i10 = this.K;
        if (i9 != -1) {
            i10 = (i10 * i9) / 255;
        }
        paint.setAlpha(i10);
        float f12 = rectF.left;
        float f13 = this.Q;
        float f14 = rectF.top + f13;
        float f15 = rectF.right - f13;
        float f16 = rectF.bottom - f13;
        float f17 = this.R;
        canvas.drawRoundRect(f12 + f13, f14, f15, f16, f17, f17, this.I);
        paint.setColor(this.L);
        int i11 = this.H;
        int i12 = this.M;
        if (i11 != -1) {
            i12 = (i12 * i11) / 255;
        }
        paint.setAlpha(i12);
        if (this.e == null) {
            this.e = this.f7980c.extractAlpha();
        }
        canvas.drawBitmap(this.e, (Rect) null, rectF, paint);
        int iSaveLayerAlpha = canvas.saveLayerAlpha(rectF2, this.f7986l, 31);
        canvas.clipPath(this.f7992t, Region.Op.DIFFERENCE);
        paint.setColor(this.N);
        int i13 = this.H;
        int i14 = i13 != -1 ? i13 : 255;
        paint.setAlpha(i14);
        if (this.f7982h == null) {
            this.f7982h = this.f7981d.extractAlpha();
        }
        canvas.drawBitmap(this.f7982h, (Rect) null, rectF2, paint);
        canvas.restoreToCount(iSaveLayerAlpha);
        float f18 = this.f7987m;
        canvas.scale(f18, f18);
        int i15 = this.O;
        Paint paint2 = this.f7991s;
        paint2.setColor(i15);
        paint2.setAlpha(i14);
        canvas.drawPath(this.u, paint2);
    }

    public final void finalize() throws Throwable {
        Bitmap bitmap = this.e;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.e.recycle();
            this.e = null;
        }
        Bitmap bitmap2 = this.f7982h;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            this.f7982h.recycle();
            this.f7982h = null;
        }
        super.finalize();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.f7980c;
        return bitmap == null ? this.f7979b.getResources().getDimensionPixelSize(R$dimen.os_ctm_checked_box_wh) : bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.f7980c;
        return bitmap == null ? this.f7979b.getResources().getDimensionPixelSize(R$dimen.os_ctm_checked_box_wh) : bitmap.getWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i8) {
        this.H = i8;
    }

    public void setCheckedFillColor(@ColorInt int i8) {
        this.N = i8;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }

    public void setPictureMode(boolean z2) {
        c(z2, true);
    }

    public void setShowBorderShadow(boolean z2) {
        this.P = z2;
    }

    public void setTickColor(@ColorInt int i8) {
        this.O = i8;
    }

    public void setUncheckedBorderColor(@ColorInt int i8) {
        this.L = i8;
        this.M = Color.alpha(i8);
    }

    public void setUncheckedFillColor(@ColorInt int i8) {
        this.J = i8;
        this.K = Color.alpha(i8);
    }

    @Override // md.h
    public final void stop() {
        ValueAnimator valueAnimator = this.f7978a;
        if (valueAnimator.isRunning()) {
            valueAnimator.cancel();
            b(this.f7983i);
        }
    }
}
