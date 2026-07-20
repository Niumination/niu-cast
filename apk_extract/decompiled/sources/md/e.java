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
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.view.OSRadioButton;
import java.util.ArrayList;
import k3.jc;
import k3.z8;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends Drawable implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f8003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f8004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bitmap f8005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap f8006d;
    public final Path e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Path f8007h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8008i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f8010k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final float f8011l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f8012m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final float f8013n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final float f8014o;
    public float p = 1.0f;
    public final RectF q = new RectF();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final ValueAnimator f8015r;

    public e(Context context) {
        this.f8004b = context;
        Paint paint = new Paint();
        this.f8003a = paint;
        int iE = j.e(context, R$attr.os_fill_base, R$color.os_fill_base_hios);
        this.f8009j = iE;
        int iE2 = j.e(context, R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios);
        Path path = new Path();
        this.e = path;
        Path path2 = new Path();
        this.f8007h = path2;
        this.f8015r = ValueAnimator.ofFloat(new float[0]);
        Drawable drawable = ContextCompat.getDrawable(context, R$drawable.os_radio_drawable_start_unchecked);
        if (drawable != null) {
            drawable.setTint(iE);
            this.f8005c = jc.a(drawable);
            int i8 = OSRadioButton.f3185a;
            z8.f("OSRadioButton", "setBitmap, width--height: " + this.f8005c.getWidth() + "--" + this.f8005c.getHeight());
            int width = this.f8005c.getWidth();
            int height = this.f8005c.getHeight();
            float f = ((float) width) / 2.0f;
            float f4 = ((float) height) / 2.0f;
            this.f8011l = Math.min(f, f4) - TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics());
            this.f8006d = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.f8006d);
            Paint paint2 = new Paint(paint);
            paint2.setColor(iE2);
            canvas.drawCircle(f, f4, this.f8011l, paint2);
            float f10 = this.f8011l;
            this.f8013n = 0.7f * f10;
            this.f8014o = f10 * 0.45f;
        }
        this.f8008i = iE;
        this.f8010k = this.f8011l;
        this.f8012m = 0.0f;
        int i9 = OSRadioButton.f3185a;
        z8.f("OSRadioButton", "setChecked, mStrokeColor-mStartColor-mEndColor: (" + this.f8008i + ")-(" + iE + ")-(" + iE2 + "), checked: false, this: " + this);
        StringBuilder sb2 = new StringBuilder("setChecked, mOuterRadius-mStartRadius-mEndRadius: (");
        sb2.append(this.f8010k);
        sb2.append(")-(0.1)-(");
        sb2.append(this.f8011l);
        sb2.append(")");
        z8.f("OSRadioButton", sb2.toString());
        z8.f("OSRadioButton", "setChecked, mInnerRadius-mStartRadius-mEndRadius: (" + this.f8012m + ")-(" + (this.f8011l / 2.0f) + ")-(0)");
        path.reset();
        float f11 = this.f8010k;
        Path.Direction direction = Path.Direction.CCW;
        path.addCircle(0.0f, 0.0f, f11, direction);
        path2.reset();
        path2.addCircle(0.0f, 0.0f, this.f8012m, direction);
    }

    @Override // md.h
    public final void a(h hVar) {
        int i8;
        int i9;
        float f;
        int i10;
        float f4;
        int i11;
        PropertyValuesHolder propertyValuesHolderOfKeyframe;
        float f10 = this.f8013n;
        float f11 = this.f8011l;
        if (hVar instanceof e) {
            ((e) hVar).stop();
            e eVar = (e) hVar;
            int i12 = eVar.f8008i;
            float f12 = eVar.f8010k;
            float f13 = eVar.f8012m;
            float f14 = eVar.p;
            Rect bounds = getBounds();
            int iCenterX = bounds.centerX();
            int iCenterY = bounds.centerY();
            int i13 = OSRadioButton.f3185a;
            StringBuilder sbR = o.d.r(iCenterX, iCenterY, "startAnim, centerX: ", ", centerY: ", ", bounds: ");
            sbR.append(bounds.toShortString());
            sbR.append(", mChecked: false, execFraction: ");
            sbR.append(f14);
            sbR.append(", this:");
            sbR.append(this);
            z8.f("OSRadioButton", sbR.toString());
            int iRed = Color.red(i12);
            int iGreen = Color.green(i12);
            int iBlue = Color.blue(i12);
            ArrayList arrayList = new ArrayList();
            Keyframe keyframeOfFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe keyframeOfFloat2 = Keyframe.ofFloat(1.0f, 1.0f);
            Path path = this.e;
            this.f8008i = i12;
            int i14 = this.f8009j;
            int iRed2 = Color.red(i14) - iRed;
            int iGreen2 = Color.green(i14) - iGreen;
            int iBlue2 = Color.blue(i14) - iBlue;
            if (f14 > 0.16666667f) {
                path.reset();
                path.addCircle(0.0f, 0.0f, 0.1f, Path.Direction.CCW);
                i8 = 2;
            } else {
                i8 = 1;
            }
            if (f14 > 0.36666667f) {
                i9 = 1;
                i8++;
            } else {
                i9 = 1;
            }
            if (f14 > 0.56666666f) {
                i8 += i9;
            }
            if (f14 > 0.76666665f) {
                i8 += i9;
            }
            if (i8 != 5) {
                f = f14;
                i10 = i12;
                f4 = f13;
                i11 = i14;
                if (i8 == 4) {
                    float f15 = (((f - 0.16666667f) - 0.2f) - 0.2f) / f;
                    float f16 = 0.2f / f;
                    float f17 = f16 + f15;
                    float f18 = f16 + f17;
                    arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_inner_radius", Keyframe.ofFloat(0.0f, f4), Keyframe.ofFloat(f15, f10), Keyframe.ofFloat(f17, 0.0f), Keyframe.ofFloat(1.0f, 0.0f)));
                    arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_outer_radius", Keyframe.ofFloat(0.0f, f12), Keyframe.ofFloat(f17, f12), Keyframe.ofFloat(f18, f11), Keyframe.ofFloat(1.0f, f11)));
                    propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("pvh_stroke_color", keyframeOfFloat, Keyframe.ofFloat(f18, 0.0f), keyframeOfFloat2);
                } else if (i8 == 3) {
                    float f19 = ((f - 0.16666667f) - 0.2f) / f;
                    float f20 = (0.2f / f) + f19;
                    arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_inner_radius", Keyframe.ofFloat(0.0f, f4), Keyframe.ofFloat(f19, 0.0f), Keyframe.ofFloat(1.0f, 0.0f)));
                    arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_outer_radius", Keyframe.ofFloat(0.0f, f12), Keyframe.ofFloat(f19, f12), Keyframe.ofFloat(f20, f11), Keyframe.ofFloat(1.0f, f11)));
                    propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("pvh_stroke_color", keyframeOfFloat, Keyframe.ofFloat(f20, 0.0f), keyframeOfFloat2);
                } else if (i8 == 2) {
                    float f21 = (f - 0.16666667f) / f;
                    arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_outer_radius", Keyframe.ofFloat(0.0f, f12), Keyframe.ofFloat(f21, f11), Keyframe.ofFloat(1.0f, f11)));
                    propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("pvh_stroke_color", keyframeOfFloat, Keyframe.ofFloat(f21, 0.0f), keyframeOfFloat2);
                } else {
                    propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("pvh_stroke_color", keyframeOfFloat, keyframeOfFloat2);
                }
                arrayList.add(propertyValuesHolderOfKeyframe);
                z8.b("OSRadioButton", "unchecked anim, keyframeCount: " + i8 + ", startStrokeColor-endStrokeColor: (" + i10 + ")-(" + i11 + "), startOuterRadius-endOuterRadius: (" + f12 + "-" + f11 + "), startInnerRadius-endInnerRadius: (" + f4 + "-0)");
                PropertyValuesHolder[] propertyValuesHolderArr = (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]);
                ValueAnimator valueAnimator = this.f8015r;
                valueAnimator.setValues(propertyValuesHolderArr);
                valueAnimator.setDuration((long) (300.0f * f));
                d dVar = new d(this, iRed, iRed2, iGreen, iGreen2, iBlue, iBlue2);
                valueAnimator.addUpdateListener(dVar);
                valueAnimator.addListener(new b(this, dVar, 1));
                valueAnimator.start();
            }
            float f22 = ((((f14 - 0.16666667f) - 0.2f) - 0.2f) - 0.2f) / f14;
            float f23 = 0.2f / f14;
            i11 = i14;
            float f24 = f23 + f22;
            i10 = i12;
            float f25 = f23 + f24;
            f = f14;
            float f26 = f23 + f25;
            f4 = f13;
            arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_inner_radius", Keyframe.ofFloat(0.0f, f13), Keyframe.ofFloat(f22, this.f8014o), Keyframe.ofFloat(f24, f10), Keyframe.ofFloat(f25, 0.0f), Keyframe.ofFloat(1.0f, 0.0f)));
            arrayList.add(PropertyValuesHolder.ofKeyframe("pvh_outer_radius", Keyframe.ofFloat(0.0f, f12), Keyframe.ofFloat(f25, f12), Keyframe.ofFloat(f26, f11), Keyframe.ofFloat(1.0f, f11)));
            propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe("pvh_stroke_color", keyframeOfFloat, Keyframe.ofFloat(f26, 0.0f), keyframeOfFloat2);
            i8 = i8;
            arrayList.add(propertyValuesHolderOfKeyframe);
            z8.b("OSRadioButton", "unchecked anim, keyframeCount: " + i8 + ", startStrokeColor-endStrokeColor: (" + i10 + ")-(" + i11 + "), startOuterRadius-endOuterRadius: (" + f12 + "-" + f11 + "), startInnerRadius-endInnerRadius: (" + f4 + "-0)");
            PropertyValuesHolder[] propertyValuesHolderArr2 = (PropertyValuesHolder[]) arrayList.toArray(new PropertyValuesHolder[0]);
            ValueAnimator valueAnimator2 = this.f8015r;
            valueAnimator2.setValues(propertyValuesHolderArr2);
            valueAnimator2.setDuration((long) (300.0f * f));
            d dVar2 = new d(this, iRed, iRed2, iGreen, iGreen2, iBlue, iBlue2);
            valueAnimator2.addUpdateListener(dVar2);
            valueAnimator2.addListener(new b(this, dVar2, 1));
            valueAnimator2.start();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (this.f8005c == null || this.f8006d == null || bounds.isEmpty()) {
            return;
        }
        canvas.translate(bounds.centerX(), bounds.centerY());
        float f = (-bounds.width()) / 2.0f;
        float f4 = (-bounds.height()) / 2.0f;
        float fWidth = bounds.width() / 2.0f;
        float fHeight = bounds.height() / 2.0f;
        RectF rectF = this.q;
        rectF.set(f, f4, fWidth, fHeight);
        int i8 = this.f8008i;
        Paint paint = this.f8003a;
        paint.setColor(i8);
        canvas.drawBitmap(this.f8005c.extractAlpha(), (Rect) null, rectF, paint);
        int iSaveLayer = canvas.saveLayer(rectF, null, 31);
        canvas.clipPath(this.e, Region.Op.DIFFERENCE);
        canvas.drawBitmap(this.f8006d, (Rect) null, rectF, (Paint) null);
        canvas.clipPath(this.f8007h);
        canvas.drawColor(-1);
        canvas.restoreToCount(iSaveLayer);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.f8005c;
        return bitmap == null ? this.f8004b.getResources().getDimensionPixelSize(R$dimen.os_ctm_radio_btn_wh) : bitmap.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.f8005c;
        return bitmap == null ? this.f8004b.getResources().getDimensionPixelSize(R$dimen.os_ctm_radio_btn_wh) : bitmap.getWidth();
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

    @Override // md.h
    public final void stop() {
        ValueAnimator valueAnimator = this.f8015r;
        if (valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
    }
}
