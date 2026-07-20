package com.transsion.widgetslib.widget.timepicker.wheel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.SoundPool;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.OvershootInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.material.color.utilities.Contrast;
import com.google.android.material.timepicker.TimeModel;
import com.transsion.connectx.sdk.TCCPSourceApi;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$dimen;
import com.transsion.widgetslib.R$drawable;
import com.transsion.widgetslib.R$string;
import com.transsion.widgetslib.widget.timepicker.OSDateTimePicker;
import hd.a;
import ie.c;
import ie.d;
import ie.e;
import ie.f;
import ie.g;
import ie.h;
import ie.i;
import ie.k;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import pd.j;
import tj.w;

/* JADX INFO: loaded from: classes2.dex */
public class WheelView<T> extends View {
    public static final float I0 = TypedValue.applyDimension(1, 2.0f, Resources.getSystem().getDisplayMetrics());
    public static final float J0;
    public static boolean K0;
    public boolean A;
    public InputMethodManager A0;
    public Typeface B;
    public volatile boolean B0;
    public Typeface C;
    public String C0;
    public List D;
    public boolean D0;
    public boolean E;
    public boolean E0;
    public VelocityTracker F;
    public final d F0;
    public final int G;
    public ValueAnimator G0;
    public final int H;
    public h H0;
    public final c I;
    public int J;
    public int K;
    public float L;
    public float M;
    public float N;
    public float O;
    public float P;
    public long Q;
    public int R;
    public int S;
    public k T;
    public boolean U;
    public int V;
    public int W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f3745a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f3746a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f3747b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f3748b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f3749c;
    public int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Paint.FontMetrics f3750d;
    public int d0;
    public int e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f3751e0;
    public boolean f0;
    public boolean g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f3752h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public boolean f3753h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3754i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public boolean f3755i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3756j;
    public boolean j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f3757k;
    public List k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3758l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f3759l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3760m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3761m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3762n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public boolean f3763n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f3764o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f3765o0;
    public Paint.Cap p;
    public boolean p0;
    public int q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f3766q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f3767r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public float f3768r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Rect f3769s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public boolean f3770s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f3771t;
    public float t0;
    public final Camera u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public float f3772u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Matrix f3773v;
    public AudioManager v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f3774w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public float f3775w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f3776x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final int f3777x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f3778y;
    public int y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3779z;
    public String z0;

    static {
        TypedValue.applyDimension(2, 15.0f, Resources.getSystem().getDisplayMetrics());
        J0 = TypedValue.applyDimension(1, 1.0f, Resources.getSystem().getDisplayMetrics());
        K0 = false;
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private int getCurrentPosition() {
        float f;
        int iE;
        if (this.D.isEmpty()) {
            return -1;
        }
        float f4 = this.L;
        if (f4 < 0.0f) {
            f = f4 - (this.d0 / 2);
            iE = e();
        } else {
            f = f4 + (this.d0 / 2);
            iE = e();
        }
        int i8 = (int) (f / iE);
        if (this.f3754i) {
            int size = i8 % this.D.size();
            return size < 0 ? size + this.D.size() : size;
        }
        if (i8 < 0) {
            return 0;
        }
        return i8 > this.D.size() + (-1) ? this.D.size() - 1 : i8;
    }

    private String getCurrentSelectedValue() {
        int i8;
        Object obj;
        List list = this.D;
        if (list == null || (i8 = this.R) < 0 || i8 >= list.size() || (obj = this.D.get(this.R)) == null) {
            return null;
        }
        return obj.toString();
    }

    public final void a() {
        c cVar = this.I;
        if (!cVar.f5775o) {
            cVar.f5768h = cVar.f5766d;
            cVar.f5769i = cVar.e;
            cVar.f5775o = true;
        }
        SpringAnimation springAnimation = cVar.f5779v;
        if (springAnimation == null || !springAnimation.isRunning()) {
            return;
        }
        this.I.f5779v.cancel();
    }

    public final void b() {
        int i8 = this.f3756j;
        if (i8 == 0) {
            getPaddingLeft();
        } else if (i8 != 2) {
            getWidth();
        } else {
            getWidth();
            getPaddingRight();
        }
        Paint.FontMetrics fontMetrics = this.f3750d;
        float f = fontMetrics.ascent;
        float f4 = fontMetrics.descent;
    }

    public final void c() {
        boolean z2 = this.f3754i;
        this.J = z2 ? Integer.MIN_VALUE : 0;
        this.K = z2 ? Integer.MAX_VALUE : (this.D.size() - 1) * this.d0;
    }

    public final void d() {
        float f = this.W;
        Paint paint = this.f3745a;
        paint.setTextSize(f);
        this.f3750d = paint.getFontMetrics();
    }

    public final int e() {
        int i8 = this.d0;
        if (i8 > 0) {
            return i8;
        }
        return 1;
    }

    public final void f(float f) {
        float f4 = this.L + f;
        this.L = f4;
        if (this.f3754i) {
            return;
        }
        int i8 = this.J;
        if (f4 < i8) {
            this.L = i8;
            return;
        }
        int i9 = this.K;
        if (f4 > i9) {
            this.L = i9;
        }
    }

    public final void g(Canvas canvas, Paint paint, int i8, float f, float f4, int i9, float f10) {
        float fMin;
        String strK = k(i8);
        if (strK == null) {
            return;
        }
        if (this.B0 && this.f3774w && i9 == 0) {
            Paint paint2 = new Paint();
            paint2.setColor(j.e(getContext(), R$attr.os_platform_basic_color, R$color.os_platform_basic_color_hios));
            paint2.setAlpha(a.c(getContext()) ? 76 : 38);
            Paint.Style style = Paint.Style.FILL;
            paint2.setStyle(style);
            paint2.setStyle(style);
            float fMeasureText = paint.measureText(strK);
            float textSize = paint.getTextSize();
            float f11 = ((f4 - textSize) * 0.5f) + f + textSize;
            float fAscent = paint.ascent() + f11;
            float fDescent = paint.descent() + f11;
            float fA = a.a(getContext(), 2);
            float width = ((getWidth() - fMeasureText) / 2.0f) - fA;
            canvas.drawRect(width, fAscent - fA, (fA * 2.0f) + fMeasureText + width, fDescent + fA, paint2);
        }
        if (this.B0 && i9 == 0 && i8 == this.R) {
            String str = this.C0;
            if (str == null) {
                str = "";
            }
            Paint paint3 = new Paint(this.f3749c);
            paint3.setColor(this.f3746a0);
            paint3.setTextSize(this.W);
            float textSize2 = paint3.getTextSize();
            float f12 = (f4 - textSize2) * 0.5f;
            float width2 = getWidth() - paint3.measureText(str);
            canvas.drawText(str, width2 > 0.0f ? width2 * 0.5f : 0.0f, f + f12 + textSize2, paint3);
            return;
        }
        float textSize3 = paint.getTextSize();
        float fMeasureText2 = paint.measureText(strK);
        float f13 = (f4 - textSize3) * 0.5f;
        float width3 = getWidth() - fMeasureText2;
        if (width3 < 0.0f) {
            strK = TextUtils.ellipsize(strK, new TextPaint(paint), getWidth(), TextUtils.TruncateAt.END).toString();
            width3 = getWidth() - fMeasureText2;
        }
        float f14 = width3 > 0.0f ? width3 * 0.5f : 0.0f;
        float f15 = f + f13 + textSize3;
        if (this.f3774w) {
            float f16 = this.f3775w0;
            if (f16 != 0.0f) {
                float f17 = 1.0f - (f10 / f16);
                int iAbs = Math.abs(i9);
                int i10 = this.f3777x0;
                int i11 = i10 / 2;
                if (iAbs == 0) {
                    fMin = (0 - i11) + ((int) (i10 * f17));
                } else if (iAbs == 1) {
                    int i12 = i9 == -1 ? i10 : -i10;
                    int i13 = (int) (i10 * f17);
                    fMin = i9 == -1 ? Math.min(i12 - i13, i11) : Math.max(i12 + i13, -i11);
                } else {
                    fMin = 0.0f;
                }
                float f18 = f15 - fMin;
                float width4 = getWidth() / 2.0f;
                float fAscent2 = ((paint.ascent() + paint.descent()) / 2.0f) + f18;
                float f19 = iAbs * 0.2f;
                float f20 = i9 <= 0 ? f19 - 0.1f : f19 + 0.1f;
                float f21 = 0.2f * f17;
                float f22 = i9 <= 0 ? f20 + f21 : f20 - f21;
                float fAbs = Math.abs(420.0f * f22);
                float f23 = i9 <= 0 ? 140.0f : -140.0f;
                this.u.save();
                this.u.translate(0.0f, 0.0f, fAbs);
                this.u.rotateX(f22 * f23);
                this.u.getMatrix(this.f3773v);
                this.u.restore();
                this.f3773v.preTranslate((-getWidth()) / 2.0f, -fAscent2);
                this.f3773v.postTranslate(width4, fAscent2);
                canvas.save();
                canvas.concat(this.f3773v);
                int i14 = iAbs * 84;
                int i15 = i9 <= 0 ? 297 - i14 : 213 - i14;
                int i16 = (int) (f17 * 84.0f);
                int iMin = Math.min(i9 <= 0 ? i15 - i16 : i15 + i16, 255);
                if (iMin <= 75) {
                    iMin = 0;
                }
                int i17 = 255 & this.f3746a0;
                int i18 = i17 - (((i17 - 153) / 2) * iAbs);
                paint.setColor(Color.argb(iMin, i18, i18, i18));
                boolean z2 = (paint.getColor() & ViewCompat.MEASURED_SIZE_MASK) == 0;
                if (this.A) {
                    this.f3747b.setFakeBoldText(z2);
                }
                this.f3747b.setTypeface(z2 ? this.B : this.C);
                canvas.drawText(strK, f14, f18, paint);
                canvas.restore();
                return;
            }
        }
        canvas.drawText(strK, f14, f15, paint);
    }

    @Override // android.view.View
    public CharSequence getContentDescription() {
        if (!TextUtils.isEmpty(this.z0)) {
            return this.z0;
        }
        int selectedItemPosition = getSelectedItemPosition();
        return (!this.D.isEmpty() && selectedItemPosition >= 0 && selectedItemPosition <= this.D.size() + (-1)) ? k(getSelectedItemPosition()) : super.getContentDescription();
    }

    public int getCurvedArcDirection() {
        return this.f3776x;
    }

    public float getCurvedArcDirectionFactor() {
        return this.f3778y;
    }

    public Typeface getCurvedBoldForSelectedItemTypeface() {
        return this.B;
    }

    public Typeface getCurvedNormalItemTypeface() {
        return this.C;
    }

    @Deprecated
    public float getCurvedRefractRatio() {
        return this.f3779z;
    }

    public String getCustomContentDescription() {
        return this.z0;
    }

    public List<T> getData() {
        return this.D;
    }

    public Paint.Cap getDividerCap() {
        return this.p;
    }

    public int getDividerColor() {
        return this.f3758l;
    }

    public float getDividerHeight() {
        return this.f3760m;
    }

    public float getDividerPaddingForWrap() {
        return this.f3764o;
    }

    public int getDividerType() {
        return this.f3762n;
    }

    public float getLineSpacing() {
        return this.f3752h;
    }

    public i getOnItemSelectedListener() {
        return null;
    }

    public ie.j getOnWheelChangedListener() {
        return null;
    }

    public float getPlayVolume() {
        k kVar = this.T;
        if (kVar == null) {
            return 0.0f;
        }
        return kVar.f5789c;
    }

    public float getRefractRatio() {
        return this.f3779z;
    }

    public Paint getSecondPaint() {
        return this.f3747b;
    }

    public T getSelectedItemData() {
        int i8 = this.R;
        if (i8 >= 0 && i8 < this.D.size()) {
            return (T) this.D.get(i8);
        }
        if (this.D.size() > 0 && i8 >= this.D.size()) {
            return (T) a1.a.j(1, this.D);
        }
        if (this.D.size() <= 0 || i8 >= 0) {
            return null;
        }
        return (T) this.D.get(0);
    }

    public int getSelectedItemPosition() {
        return this.R;
    }

    public Paint getSelectedPaint() {
        return this.f3749c;
    }

    public int getSelectedRectColor() {
        return this.q;
    }

    public int getTextAlign() {
        return this.f3756j;
    }

    public float getTextBoundaryMargin() {
        return this.f3771t;
    }

    public int getTextSecondColor() {
        return this.f3748b0;
    }

    public int getTextSelectColor() {
        return this.f3746a0;
    }

    public int getTextSizeSecond() {
        return this.V;
    }

    public int getTextSizeSelect() {
        return this.W;
    }

    public Typeface getTypeface() {
        return this.f3745a.getTypeface();
    }

    public int getVisibleItems() {
        return this.e;
    }

    public int getWheelHeight() {
        return this.d0;
    }

    public final int h(String str) {
        List list;
        if (str != null && (list = this.D) != null && !list.isEmpty()) {
            for (int i8 = 0; i8 < this.D.size(); i8++) {
                if (str.equals(l(this.D.get(i8)))) {
                    return i8;
                }
            }
        }
        return -1;
    }

    public final void i() {
        if (this.B0) {
            InputMethodManager inputMethodManager = this.A0;
            if (inputMethodManager != null && this.E0) {
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 2);
            }
            this.E0 = false;
            K0 = false;
            clearFocus();
            setFocusableInTouchMode(false);
            this.B0 = false;
            this.C0 = "";
            this.j0 = true;
            invalidate();
        }
    }

    public final void j() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                View childAt = viewGroup.getChildAt(i8);
                if ((childAt instanceof WheelView) && childAt != this) {
                    WheelView wheelView = (WheelView) childAt;
                    if (wheelView.B0 && wheelView.B0) {
                        wheelView.clearFocus();
                        wheelView.setFocusableInTouchMode(false);
                        wheelView.B0 = false;
                        wheelView.C0 = "";
                        wheelView.j0 = true;
                        wheelView.invalidate();
                    }
                }
            }
        }
    }

    public final String k(int i8) {
        int size = this.D.size();
        if (size == 0) {
            return null;
        }
        if (this.f3754i) {
            int i9 = i8 % size;
            if (i9 < 0) {
                i9 += size;
            }
            return l(this.D.get(i9));
        }
        if (i8 < 0 || i8 >= size) {
            return null;
        }
        return l(this.D.get(i8));
    }

    public final String l(Object obj) {
        if (obj == null) {
            return "";
        }
        if (!(obj instanceof Integer)) {
            return obj instanceof String ? (String) obj : obj.toString();
        }
        Integer num = (Integer) obj;
        boolean z2 = this.f3751e0;
        String str = TimeModel.NUMBER_FORMAT;
        if (!z2 ? this.f0 : this.f3755i0) {
            str = TimeModel.ZERO_LEADING_NUMBER_FORMAT;
        }
        return String.format(Locale.getDefault(), str, num).concat("");
    }

    public final void m(char c9) {
        int i8 = c9 - '0';
        if (this.f0) {
            if (this.C0.isEmpty()) {
                this.C0 = String.valueOf(i8);
            } else {
                int i9 = ((Integer.parseInt(this.C0) % 10) * 10) + i8;
                if (i9 <= 59) {
                    this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i9));
                } else {
                    this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
                }
            }
        } else if (this.f3753h0) {
            if (this.j0) {
                this.C0 = "";
                this.j0 = false;
            }
            if (!this.C0.isEmpty()) {
                String str = this.C0 + i8;
                if (w(str)) {
                    this.C0 = str;
                }
            } else if (i8 >= 1 && i8 <= 9) {
                this.C0 = String.valueOf(i8);
            }
        } else if (this.g0) {
            if (this.j0) {
                this.C0 = "";
                this.j0 = false;
            }
            if (this.C0.isEmpty()) {
                if (w(String.valueOf(i8))) {
                    this.C0 = String.valueOf(i8);
                }
            } else if (this.C0.length() >= 4) {
                r();
            } else {
                String str2 = this.C0 + i8;
                if (w(str2)) {
                    this.C0 = str2;
                }
            }
        } else if (this.f3751e0) {
            if (this.f3755i0) {
                if (this.C0.isEmpty()) {
                    if (i8 <= 2) {
                        this.C0 = String.valueOf(i8);
                    } else {
                        this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
                        p(0, false);
                    }
                } else if (this.C0.length() == 1) {
                    int i10 = Integer.parseInt(this.C0);
                    int i11 = (i10 * 10) + i8;
                    if (!this.f3755i0 ? !(i11 < 1 || i11 > 12) : !(i11 < 0 || i11 > 23)) {
                        this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i10));
                        p(i8, true);
                    } else {
                        this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i11));
                        p(0, false);
                    }
                } else if (i8 <= 2) {
                    this.C0 = String.valueOf(i8);
                } else {
                    this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
                    p(0, false);
                }
            } else if (this.C0.isEmpty()) {
                if (i8 <= 1) {
                    this.C0 = String.valueOf(i8);
                } else {
                    this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
                    p(0, false);
                }
            } else if (!this.j0 && this.C0.length() == 1) {
                int i12 = Integer.parseInt(this.C0);
                int i13 = (i12 * 10) + i8;
                if (i13 == 0) {
                    this.C0 = "12";
                    p(0, false);
                } else if (!this.f3755i0 ? !(i13 < 1 || i13 > 12) : !(i13 < 0 || i13 > 23)) {
                    this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i12));
                    p(i8, true);
                } else {
                    this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i13));
                    p(0, false);
                }
            } else if (i8 <= 1) {
                this.j0 = false;
                this.C0 = String.valueOf(i8);
            } else {
                this.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
                p(0, false);
            }
        }
        v();
        invalidate();
    }

    public final void n() {
        float f = this.L;
        if (f != this.M) {
            this.M = f;
            s();
            invalidate();
        }
    }

    public final boolean o() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            for (int i8 = 0; i8 < viewGroup.getChildCount(); i8++) {
                View childAt = viewGroup.getChildAt(i8);
                if ((childAt instanceof WheelView) && childAt != this && ((WheelView) childAt).B0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        editorInfo.inputType = 2;
        editorInfo.imeOptions = 268435462;
        return new f(this, this);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        SoundPool soundPool;
        super.onDetachedFromWindow();
        k kVar = this.T;
        if (kVar != null && (soundPool = kVar.f5787a) != null) {
            soundPool.release();
            kVar.f5787a = null;
        }
        if (this.B0) {
            i();
        }
        this.A0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int i8;
        int i9;
        float f;
        WheelView<T> wheelView = this;
        super.onDraw(canvas);
        int i10 = wheelView.f3759l0;
        if (i10 != 0) {
            canvas.drawColor(i10);
        }
        int iE = e();
        float f4 = iE;
        int i11 = (int) (wheelView.L / f4);
        float height = getHeight();
        float f10 = height * 0.5f;
        int i12 = ((int) (height / f4)) + 4;
        int i13 = i11 - (i12 >> 1);
        float f11 = i12 + i13;
        float f12 = f4 * 0.5f;
        float f13 = (f10 - f12) - wheelView.L;
        boolean z2 = wheelView.f3774w;
        Paint paint = wheelView.f3747b;
        if (z2) {
            int i14 = i13;
            while (true) {
                if (i14 < f11) {
                    float f14 = (i14 * iE) + f13;
                    if (Math.abs((f10 - f14) - f12) < f12) {
                        if (wheelView.y0 == 0) {
                            wheelView.y0 = (int) (f14 - f12);
                        }
                        int i15 = wheelView.y0;
                        if (i15 != 0) {
                            float f15 = (f14 - i15) / i15;
                            if (wheelView.f3775w0 == 0.0f) {
                                wheelView.f3775w0 = 2.0f * f15;
                            }
                            i9 = i14;
                            f = f15;
                            break;
                        }
                    } else {
                        i14++;
                    }
                } else {
                    i14 = -1;
                }
                i9 = i14;
                f = 0.0f;
                break;
            }
            while (i13 < f11) {
                g(canvas, paint, i13, f13 + (i13 * iE), f4, i13 - i9, f);
                i13++;
                paint = paint;
            }
            return;
        }
        int i16 = i13;
        while (i16 < f11) {
            float f16 = f13 + (i16 * iE);
            float fAbs = Math.abs((f10 - f16) - f12);
            if (fAbs < f12) {
                float f17 = 1.0f - (fAbs / f12);
                int i17 = wheelView.W;
                int i18 = wheelView.V;
                Paint paint2 = wheelView.f3749c;
                paint2.setTextSize((((((i17 - i18) * 1.0f) / i18) * f17) + 1.0f) * i18);
                int i19 = wheelView.f3748b0;
                int i20 = wheelView.f3746a0;
                if (i19 != i20) {
                    int i21 = (i19 & ViewCompat.MEASURED_STATE_MASK) >>> 24;
                    int i22 = (i19 & 16711680) >>> 16;
                    int i23 = (i19 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
                    int i24 = i19 & 255;
                    i20 = (((int) (((((i20 & ViewCompat.MEASURED_STATE_MASK) >>> 24) - i21) * f17) + i21)) << 24) | (((int) (((((i20 & 16711680) >>> 16) - i22) * f17) + i22)) << 16) | (((int) (((((i20 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8) - i23) * f17) + i23)) << 8) | ((int) ((((i20 & 255) - i24) * f17) + i24));
                }
                paint2.setColor(i20);
                i8 = i16;
                g(canvas, paint2, i16, f16, f4, 0, 0.0f);
            } else {
                i8 = i16;
                g(canvas, paint, i8, f16, f4, 0, 0.0f);
            }
            i16 = i8 + 1;
            wheelView = this;
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i8, KeyEvent keyEvent) {
        if (!this.B0) {
            return super.onKeyDown(i8, keyEvent);
        }
        if (i8 != 67) {
            if (i8 < 7 || i8 > 16) {
                return super.onKeyDown(i8, keyEvent);
            }
            m((char) (i8 + 41));
            return true;
        }
        if (this.C0.length() <= 0) {
            return true;
        }
        String str = this.C0;
        this.C0 = str.substring(0, str.length() - 1);
        invalidate();
        return true;
    }

    @Override // android.view.View
    public final boolean onKeyPreIme(int i8, KeyEvent keyEvent) {
        if (i8 != 4 || keyEvent.getAction() != 0 || !this.B0) {
            return super.onKeyPreIme(i8, keyEvent);
        }
        i();
        return true;
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        setMeasuredDimension(View.resolveSizeAndState((int) ((this.f3771t * 2.0f) + getPaddingRight() + getPaddingLeft() + this.c0), i8, 0), View.resolveSizeAndState(getPaddingBottom() + getPaddingTop() + (this.d0 * this.e), i9, 0));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        this.f3769s.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.f3769s.centerX();
        this.f3767r = this.f3769s.centerY();
        getPaddingLeft();
        getPaddingTop();
        getWidth();
        getPaddingRight();
        getHeight();
        getPaddingBottom();
        b();
        c();
        int i12 = (int) ((this.R * this.d0) - this.L);
        if (i12 > 0) {
            f(i12);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:103:0x0235  */
    /* JADX WARN: Code duplicated, block: B:105:0x023d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0246  */
    /* JADX WARN: Code duplicated, block: B:92:0x0193  */
    /* JADX WARN: Code duplicated, block: B:93:0x0196  */
    /* JADX WARN: Code duplicated, block: B:95:0x019a  */
    /* JADX WARN: Code duplicated, block: B:96:0x019d  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e6  */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02f5, code lost:
    
        if (java.lang.Math.abs(r2) > (r20.d0 / 2)) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
    
        if (r1 != 3) goto L25;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r21) {
        /*
            Method dump skipped, instruction units count: 914
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.widgetslib.widget.timepicker.wheel.WheelView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i8) {
        super.onVisibilityChanged(view, i8);
        if (i8 == 0) {
            Context context = getContext();
            String[] strArr = j.f8764a;
            String[] strArr2 = a.f5293a;
            int i9 = context.getResources().getConfiguration().fontWeightAdjustment;
            Paint paint = this.f3749c;
            Paint paint2 = this.f3747b;
            if (i9 == 300) {
                Typeface typeface = Typeface.DEFAULT_BOLD;
                paint2.setTypeface(typeface);
                paint.setTypeface(typeface);
            } else {
                Typeface typeface2 = Typeface.DEFAULT;
                paint2.setTypeface(typeface2);
                paint.setTypeface(typeface2);
            }
        }
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            return;
        }
        a();
        setSelectedItemPosition(getSelectedItemPosition());
    }

    public final void p(int i8, boolean z2) {
        v();
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            for (int i9 = 0; i9 < viewGroup.getChildCount(); i9++) {
                View childAt = viewGroup.getChildAt(i9);
                if (childAt instanceof WheelView) {
                    WheelView wheelView = (WheelView) childAt;
                    if (wheelView.f0) {
                        K0 = true;
                        this.E0 = true;
                        if (z2) {
                            if (wheelView.B0) {
                                return;
                            }
                            wheelView.j();
                            wheelView.B0 = true;
                            wheelView.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
                            wheelView.setFocusable(true);
                            wheelView.setFocusableInTouchMode(true);
                            wheelView.requestFocus();
                            wheelView.u();
                            wheelView.v();
                            wheelView.invalidate();
                            return;
                        }
                        if (wheelView.B0) {
                            return;
                        }
                        wheelView.j();
                        wheelView.B0 = true;
                        String currentSelectedValue = wheelView.getCurrentSelectedValue();
                        if (currentSelectedValue != null) {
                            wheelView.C0 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt(currentSelectedValue)));
                        } else {
                            wheelView.C0 = "00";
                        }
                        wheelView.setFocusable(true);
                        wheelView.setFocusableInTouchMode(true);
                        wheelView.requestFocus();
                        wheelView.u();
                        wheelView.invalidate();
                        return;
                    }
                }
            }
        }
    }

    public final float q(boolean z2, float f) {
        float f4;
        float fE = (this.L + f) % e();
        float fAbs = Math.abs(fE);
        int i8 = this.d0;
        if (fAbs > i8 / 2) {
            f4 = (this.L < 0.0f ? -i8 : i8) - fE;
        } else {
            f4 = -fE;
        }
        float f10 = f + f4;
        boolean z3 = f10 < 0.0f && this.L + f10 >= ((float) this.J);
        boolean z5 = f10 > 0.0f && this.L + f10 <= ((float) this.K);
        if (!z3 && !z5) {
            return 0.0f;
        }
        if (z2) {
            c cVar = this.I;
            int i9 = (int) this.L;
            int i10 = (int) f10;
            cVar.f5764b = 0;
            cVar.f5775o = false;
            cVar.f5771k = 350;
            cVar.f5770j = AnimationUtils.currentAnimationTimeMillis();
            cVar.f5765c = i9;
            cVar.f5766d = 0;
            cVar.e = i9 + i10;
            cVar.f5773m = 0;
            cVar.f5774n = i10;
            cVar.f5772l = 1.0f / cVar.f5771k;
            cVar.f5778t = 0.0f;
        }
        return f10;
    }

    public final void r() {
        CharSequence text;
        h hVar = this.H0;
        if (hVar != null) {
            int i8 = OSDateTimePicker.f3736l;
            OSDateTimePicker oSDateTimePicker = (OSDateTimePicker) ((w) hVar).f10262b;
            oSDateTimePicker.getClass();
            int i9 = oSDateTimePicker.f3739c;
            Context context = oSDateTimePicker.f3738b;
            if (i9 == 1) {
                text = context.getText(R$string.os_date_time_future_limit);
            } else {
                text = i9 == 2 ? context.getText(R$string.os_date_time_past_limit) : context.getText(R$string.os_date_time_valid_limit);
            }
            Toast toast = new Toast(context);
            TextView textView = new TextView(context);
            textView.setText(text);
            textView.setTextColor(oSDateTimePicker.getResources().getColor(R$color.os_toast_text_color));
            String[] strArr = j.f8764a;
            textView.setCompoundDrawablePadding(a.a(context, 8));
            try {
                Drawable applicationIcon = context.getPackageManager().getApplicationIcon(context.getApplicationInfo());
                int dimensionPixelSize = oSDateTimePicker.getContext().getResources().getDimensionPixelSize(R$dimen.os_fontsize_icon);
                applicationIcon.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                textView.setCompoundDrawables(applicationIcon, null, null, null);
            } catch (Exception unused) {
            }
            textView.setBackgroundResource(R$drawable.os_toast_background);
            toast.setView(textView);
            toast.setDuration(0);
            toast.show();
        }
    }

    public final void s() {
        int i8;
        int i9 = this.S;
        int currentPosition = getCurrentPosition();
        if (i9 != currentPosition) {
            if (this.T != null && this.U) {
                t();
                k kVar = this.T;
                SoundPool soundPool = kVar.f5787a;
                if (soundPool != null && (i8 = kVar.f5788b) != 0) {
                    float f = kVar.f5789c;
                    soundPool.play(i8, f, f, 1, 0, 1.0f);
                }
            }
            this.S = currentPosition;
            this.R = currentPosition;
            setContentDescription(getContentDescription());
            if (this.f3765o0) {
                announceForAccessibility(getContentDescription());
            }
        }
    }

    public void set24HoursFormat(boolean z2) {
        this.f3755i0 = z2;
    }

    public void setAmPmWheel(boolean z2) {
        this.p0 = z2;
        setNeedMaxPullLimit(z2);
    }

    public void setAutoFitTextSize(boolean z2) {
        invalidate();
    }

    public void setCurved(boolean z2) {
        if (this.f3774w == z2) {
            return;
        }
        this.f3774w = z2;
        d();
        requestLayout();
        invalidate();
    }

    public void setCurvedArcDirection(int i8) {
        if (this.f3776x == i8) {
            return;
        }
        this.f3776x = i8;
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000c A[PHI: r0
      0x000c: PHI (r0v4 float) = (r0v2 float), (r0v3 float) binds: [B:6:0x000a, B:9:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    public void setCurvedArcDirectionFactor(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        if (this.f3778y == f) {
            return;
        }
        float f4 = 0.0f;
        if (f < 0.0f) {
            f = f4;
        } else {
            f4 = 1.0f;
            if (f > 1.0f) {
                f = f4;
            }
        }
        this.f3778y = f;
        invalidate();
    }

    public void setCurvedBoldForSelectedItem(boolean z2) {
        this.A = z2;
    }

    public void setCurvedBoldForSelectedItemTypeface(Typeface typeface) {
        this.B = typeface;
    }

    public void setCurvedNormalItemTypeface(Typeface typeface) {
        this.C = typeface;
    }

    @Deprecated
    public void setCurvedRefractRatio(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        setRefractRatio(f);
    }

    public void setCustomContentDescription(String str) {
        this.z0 = str;
    }

    public void setCyclic(boolean z2) {
        if (this.f3754i == z2) {
            return;
        }
        this.f3754i = z2;
        c cVar = this.I;
        if (!cVar.f5775o) {
            cVar.f5775o = true;
        }
        c();
        this.L = this.R * this.d0;
        invalidate();
    }

    public void setData(List<T> list) {
        if (list == null) {
            return;
        }
        if (!this.f3765o0) {
            this.D = list;
            if (this.E || list.size() <= 0) {
                this.R = 0;
                this.S = 0;
            } else if (this.R >= this.D.size()) {
                int size = this.D.size() - 1;
                this.R = size;
                this.S = size;
            }
            d();
            c();
            this.L = this.R * this.d0;
            requestLayout();
            invalidate();
            return;
        }
        int size2 = this.D.size();
        float f = (this.N - this.O) + this.P;
        this.P = f;
        float fE = f - (e() / 2);
        this.P = fE;
        float fE2 = fE % (e() * size2);
        this.P = fE2;
        float fE3 = fE2 + (e() * size2);
        this.P = fE3;
        float fE4 = fE3 % (e() * size2);
        this.P = fE4;
        float fE5 = fE4 + (e() / 2);
        this.P = fE5;
        this.L = fE5;
        this.N = this.O;
        this.S = getCurrentPosition();
        this.R = getCurrentPosition();
        s();
        if (Math.abs((int) ((Math.abs(this.L) + (this.d0 / 2)) / e())) >= list.size()) {
            float f4 = (this.N - this.O) + this.P;
            this.P = f4;
            float fE6 = f4 % e();
            this.P = fE6;
            float f10 = fE6 + (fE6 > 0.0f ? -e() : 0.0f);
            this.P = f10;
            float fE7 = f10 + (e() * (-1));
            this.P = fE7;
            this.L = fE7;
            this.N = this.O;
            this.S = getCurrentPosition();
            this.R = getCurrentPosition();
            s();
        }
        this.D = list;
        d();
        c();
        requestLayout();
        invalidate();
    }

    public void setDayWheel(boolean z2) {
        this.f3753h0 = z2;
    }

    public void setDividerCap(Paint.Cap cap) {
        if (this.p == cap) {
            return;
        }
        this.p = cap;
        invalidate();
    }

    public void setDividerColor(@ColorInt int i8) {
        if (this.f3758l == i8) {
            return;
        }
        this.f3758l = i8;
        invalidate();
    }

    public void setDividerColorRes(@ColorRes int i8) {
        setDividerColor(ContextCompat.getColor(getContext(), i8));
    }

    public void setDividerHeight(float f) {
        float f4 = this.f3760m;
        this.f3760m = f;
        if (f4 == f) {
            return;
        }
        invalidate();
    }

    public void setDividerPaddingForWrap(float f) {
        float f4 = this.f3764o;
        this.f3764o = f;
        if (f4 == f) {
            return;
        }
        invalidate();
    }

    public void setDividerType(int i8) {
        if (this.f3762n == i8) {
            return;
        }
        this.f3762n = i8;
        invalidate();
    }

    public void setDrawSelectedRect(boolean z2) {
        invalidate();
    }

    public void setEditingEnabled(boolean z2) {
        this.D0 = z2;
    }

    public void setHourWheel(boolean z2) {
        this.f3751e0 = z2;
    }

    public void setLineSpacing(float f) {
        float f4 = this.f3752h;
        this.f3752h = f;
        if (f4 == f) {
            return;
        }
        this.L = 0.0f;
        d();
        requestLayout();
        invalidate();
    }

    public void setMinuteWheel(boolean z2) {
        this.f0 = z2;
    }

    public void setMonthList(List<String> list) {
        this.k0 = list;
    }

    public void setNeedMaxPullLimit(boolean z2) {
        this.f3770s0 = z2;
    }

    public void setOnDialogDismissListener(g gVar) {
    }

    public void setOnInputInvalidListener(h hVar) {
        this.H0 = hVar;
    }

    public void setOnItemSelectedListener(i iVar) {
    }

    public void setOnWheelChangedListener(ie.j jVar) {
    }

    public void setPlayVolume(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        k kVar = this.T;
        if (kVar != null) {
            kVar.f5789c = f;
        }
    }

    public void setRefractRatio(@FloatRange(from = 0.0d, to = Contrast.RATIO_MIN) float f) {
        float f4 = this.f3779z;
        this.f3779z = f;
        if (f > 1.0f || f < 0.0f) {
            this.f3779z = 1.0f;
        }
        if (f4 == this.f3779z) {
            return;
        }
        invalidate();
    }

    public void setResetSelectedPosition(boolean z2) {
        this.E = z2;
    }

    public void setSelectedItemPosition(int i8) {
        int i9;
        if (i8 < 0 || i8 >= this.D.size() || (i9 = (int) ((this.d0 * i8) - this.L)) == 0) {
            return;
        }
        if (!this.f3765o0) {
            a();
        }
        f(i9);
        this.R = i8;
        this.D.get(i8);
        n();
    }

    public void setSelectedRectColor(@ColorInt int i8) {
        this.q = i8;
        invalidate();
    }

    public void setSelectedRectColorRes(@ColorRes int i8) {
        setSelectedRectColor(ContextCompat.getColor(getContext(), i8));
    }

    public void setShowDivider(boolean z2) {
        if (this.f3757k == z2) {
            return;
        }
        this.f3757k = z2;
        invalidate();
    }

    public void setSoundEffect(boolean z2) {
        if (z2 && !this.U && this.T == null) {
            k kVar = new k();
            kVar.f5787a = new SoundPool.Builder().build();
            this.T = kVar;
            Context context = getContext();
            if (this.v0 == null) {
                this.v0 = (AudioManager) context.getSystemService("audio");
            }
            t();
        }
        this.U = z2;
    }

    public void setSoundEffectResource(@RawRes int i8) {
        k kVar = this.T;
        if (kVar != null) {
            Context context = getContext();
            SoundPool soundPool = kVar.f5787a;
            if (soundPool != null) {
                kVar.f5788b = soundPool.load(context, i8, 1);
            }
        }
    }

    public void setTextAlign(int i8) {
        if (this.f3756j == i8) {
            return;
        }
        this.f3756j = i8;
        Paint paint = this.f3745a;
        if (i8 == 0) {
            paint.setTextAlign(Paint.Align.LEFT);
        } else if (i8 != 2) {
            paint.setTextAlign(Paint.Align.CENTER);
        } else {
            paint.setTextAlign(Paint.Align.RIGHT);
        }
        b();
        invalidate();
    }

    public void setTextBoundaryMargin(float f) {
        float f4 = this.f3771t;
        this.f3771t = f;
        if (f4 == f) {
            return;
        }
        requestLayout();
        invalidate();
    }

    public void setTextSecondColor(int i8) {
        this.f3748b0 = i8;
        this.f3747b.setColor(i8);
        invalidate();
    }

    public void setTextSelectColor(int i8) {
        this.f3746a0 = i8;
        invalidate();
    }

    public void setTextSizeSecond(int i8) {
        this.V = i8;
        boolean z2 = this.f3774w;
        Paint paint = this.f3747b;
        if (z2) {
            paint.setTextSize(i8 * 1.37f);
        } else {
            paint.setTextSize(i8);
        }
        invalidate();
    }

    public void setTextSizeSelect(int i8) {
        this.W = i8;
        this.f3749c.setTextSize(i8);
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != null) {
            Paint paint = this.f3745a;
            if (paint.getTypeface() == typeface) {
                return;
            }
            c cVar = this.I;
            if (!cVar.f5775o) {
                cVar.f5775o = true;
            }
            paint.setTypeface(typeface);
            d();
            b();
            this.L = this.R * this.d0;
            c();
            requestLayout();
            invalidate();
        }
    }

    public void setVisibleItems(int i8) {
        if (this.e == i8) {
            return;
        }
        this.e = Math.abs(((i8 / 2) * 2) + 1);
        this.L = 0.0f;
        requestLayout();
        invalidate();
    }

    public void setWheelBackgroundColor(int i8) {
        this.f3759l0 = i8;
    }

    public void setWheelHeight(int i8) {
        this.d0 = i8;
        invalidate();
    }

    public void setWheelWidth(int i8) {
        this.c0 = i8;
        invalidate();
    }

    public void setYearWheel(boolean z2) {
        this.g0 = z2;
    }

    public final void t() {
        AudioManager audioManager = this.v0;
        if (audioManager == null) {
            this.T.f5789c = 0.3f;
            return;
        }
        this.T.f5789c = (audioManager.getStreamVolume(2) * 1.0f) / this.v0.getStreamMaxVolume(2);
    }

    public final void u() {
        if (K0 && this.E0) {
            return;
        }
        this.E0 = true;
        K0 = true;
        postDelayed(new a4.c(this, 22), 50L);
    }

    public final void v() {
        List list;
        int iH;
        int iH2;
        if (this.C0.isEmpty() || (list = this.D) == null || list.isEmpty()) {
            return;
        }
        int i8 = Integer.parseInt(this.C0);
        if (!this.f3751e0) {
            if (!this.f0) {
                if (this.f3753h0 || this.g0) {
                    iH = 0;
                    while (true) {
                        if (iH < this.D.size()) {
                            if (Integer.parseInt(l(this.D.get(iH))) == i8) {
                                break;
                            } else {
                                iH++;
                            }
                        }
                    }
                } else {
                    if (i8 < 1 || i8 > this.D.size()) {
                        break;
                    }
                    iH2 = i8 - 1;
                    iH = iH2;
                }
                iH = -1;
                break;
            }
            iH = h(String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8)));
            if (iH < 0) {
                iH2 = h(String.valueOf(i8));
                iH = iH2;
            }
        } else {
            String str = String.format(Locale.getDefault(), TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i8));
            String strValueOf = String.valueOf(i8);
            iH = h(str);
            if (iH < 0) {
                iH = h(strValueOf);
            }
        }
        if (iH < 0 || iH >= this.D.size() || iH == this.R) {
            return;
        }
        this.R = iH;
        this.L = iH * this.d0;
        invalidate();
    }

    public final boolean w(String str) {
        int i8;
        try {
            int i9 = Integer.parseInt(str);
            if (!this.g0) {
                if (!this.f3753h0) {
                    return true;
                }
                List list = this.D;
                if (list == null || list.isEmpty() || i9 <= this.D.size()) {
                    return true;
                }
                String.valueOf(i9);
                r();
                return false;
            }
            int i10 = OSDateTimePicker.f3736l;
            int length = str.length();
            int i11 = 2;
            if (length == 1) {
                i8 = 1;
            } else if (length == 2) {
                i8 = 19;
            } else if (length != 3) {
                i8 = length != 4 ? Integer.MIN_VALUE : 1900;
            } else {
                i8 = 190;
            }
            int length2 = str.length();
            if (length2 != 1) {
                if (length2 == 2) {
                    i11 = 21;
                } else if (length2 != 3) {
                    i11 = length2 != 4 ? Integer.MAX_VALUE : 2100;
                } else {
                    i11 = 210;
                }
            }
            if (i9 >= i8 && i9 <= i11) {
                return true;
            }
            r();
            return false;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public WheelView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelView(Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3745a = new Paint(1);
        Paint paint = new Paint(1);
        this.f3747b = paint;
        Paint paint2 = new Paint(1);
        this.f3749c = paint2;
        this.p = Paint.Cap.ROUND;
        this.f3774w = true;
        this.D = new ArrayList(1);
        this.E = false;
        this.L = 0.0f;
        this.M = 0.0f;
        this.U = false;
        this.j0 = true;
        new ArrayList();
        new Matrix();
        new TextPaint(1);
        this.f3763n0 = false;
        this.p0 = false;
        this.f3775w0 = 0.0f;
        this.f3777x0 = 24;
        this.y0 = 0;
        this.B0 = false;
        this.C0 = "";
        this.D0 = true;
        this.E0 = false;
        this.F0 = new d(this, 1);
        j.v();
        this.f3756j = 1;
        this.f3771t = 0.0f;
        Locale.getDefault();
        Resources resources = context.getResources();
        this.f3746a0 = ContextCompat.getColor(context, R$color.os_wheel_text_select_color);
        ContextCompat.getColor(context, R$color.os_text_quaternary_color);
        this.f3748b0 = j.d(R$attr.os_text_info, context.getColor(R$color.os_text_info_hios), context);
        j.d(R$attr.os_text_info, context.getColor(R$color.os_text_info_hios), context);
        this.f3759l0 = ContextCompat.getColor(context, R$color.os_altitude_secondary_color);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R$attr.wheelWidth});
        this.c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(R$dimen.picker_wheel_width_hour));
        this.d0 = resources.getDimensionPixelSize(R$dimen.picker_wheel_item_height);
        typedArrayObtainStyledAttributes.recycle();
        resources.getDimensionPixelSize(R$dimen.picker_wheel_text_first);
        this.V = resources.getDimensionPixelSize(R$dimen.picker_wheel_text_first);
        this.W = resources.getDimensionPixelSize(R$dimen.picker_wheel_text_select);
        resources.getDimensionPixelSize(R$dimen.picker_wheel_item_height);
        resources.getDimensionPixelSize(R$dimen.picker_wheel_item_height_select);
        if (this.f3774w) {
            paint.setTextSize(this.V * 1.37f);
        } else {
            paint.setTextSize(this.V);
        }
        paint.setColor(this.f3748b0);
        paint2.setTextSize(this.V);
        this.f3752h = I0;
        this.e = 5;
        this.e = Math.abs(5);
        this.R = 0;
        this.S = 0;
        this.f3754i = false;
        this.f3757k = false;
        this.f3762n = 0;
        this.f3760m = J0;
        this.f3758l = this.f3746a0;
        this.f3764o = 0.0f;
        this.q = 0;
        this.f3776x = 1;
        this.f3778y = 0.75f;
        this.f3779z = 1.0f;
        float f = context.getResources().getDisplayMetrics().density;
        this.f3777x0 = (int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics());
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.G = viewConfiguration.getScaledMaximumFlingVelocity();
        this.H = viewConfiguration.getScaledMinimumFlingVelocity();
        this.I = new c(context, new OvershootInterpolator(2.0f));
        this.f3769s = new Rect();
        this.u = new Camera();
        this.f3773v = new Matrix();
        float f4 = context.getResources().getDisplayMetrics().density;
        d();
        int i9 = this.f3756j;
        Paint paint3 = this.f3745a;
        if (i9 == 0) {
            paint3.setTextAlign(Paint.Align.LEFT);
        } else if (i9 != 2) {
            paint3.setTextAlign(Paint.Align.CENTER);
        } else {
            paint3.setTextAlign(Paint.Align.RIGHT);
        }
        this.A0 = (InputMethodManager) context.getSystemService(TCCPSourceApi.KEY_FEATURE_INPUT_METHOD);
        post(new d(this, 0));
        setFocusable(true);
        this.I.f5779v.addUpdateListener(new e(this));
    }
}
