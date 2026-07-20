package com.transsion.widgetslib.widget.timepicker.wheel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.OvershootInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.timepicker.TimeModel;
import com.transsion.widgetslib.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class WheelView<T> extends View {
    public static final int A1 = 2;
    public static final float B1 = 0.75f;
    public static final int C1 = 0;
    public static final int D1 = 1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public static final String f3248h1 = "WheelView";

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public static final float f3251k1 = 0.0f;

    /* JADX INFO: renamed from: m1, reason: collision with root package name */
    public static final int f3253m1 = 5;

    /* JADX INFO: renamed from: n1, reason: collision with root package name */
    public static final int f3254n1 = 250;

    /* JADX INFO: renamed from: o1, reason: collision with root package name */
    public static final int f3255o1 = 350;

    /* JADX INFO: renamed from: p1, reason: collision with root package name */
    public static final long f3256p1 = 120;

    /* JADX INFO: renamed from: q1, reason: collision with root package name */
    public static final String f3257q1 = "%2d";

    /* JADX INFO: renamed from: r1, reason: collision with root package name */
    public static final float f3258r1 = 1.0f;

    /* JADX INFO: renamed from: s1, reason: collision with root package name */
    public static final int f3259s1 = 0;

    /* JADX INFO: renamed from: t1, reason: collision with root package name */
    public static final int f3260t1 = 1;

    /* JADX INFO: renamed from: u1, reason: collision with root package name */
    public static final int f3261u1 = 2;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public static final int f3262v1 = 0;

    /* JADX INFO: renamed from: w1, reason: collision with root package name */
    public static final int f3263w1 = 1;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    public static final int f3264x1 = 2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    public static final int f3265y1 = 0;

    /* JADX INFO: renamed from: z1, reason: collision with root package name */
    public static final int f3266z1 = 1;
    public boolean A0;
    public int B0;
    public int C0;
    public int D0;
    public int E0;
    public int F0;
    public int G0;
    public Paint.Cap H;
    public int H0;
    public float I;
    public int I0;
    public boolean J;
    public int J0;
    public int K;
    public int K0;
    public int L;
    public int L0;
    public int M;
    public boolean M0;
    public int N;
    public boolean N0;
    public int O;
    public boolean O0;
    public int P;
    public boolean P0;
    public int Q;
    public Calendar Q0;
    public int R;
    public Calendar R0;
    public int S;
    public List<String> S0;
    public int T;
    public boolean T0;
    public Rect U;
    public int U0;
    public float V;
    public Matrix V0;
    public Camera W;
    public TextPaint W0;
    public float X0;
    public float Y0;
    public float Z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f3267a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public Matrix f3268a0;

    /* JADX INFO: renamed from: a1, reason: collision with root package name */
    public int f3269a1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Paint f3270b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f3271b0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public boolean f3272b1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Paint f3273c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f3274c0;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public boolean f3275c1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3276d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public float f3277d0;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public float f3278d1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Paint.FontMetrics f3279e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f3280e0;

    /* JADX INFO: renamed from: e1, reason: collision with root package name */
    public float f3281e1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3282f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    @NonNull
    public List<T> f3283f0;

    /* JADX INFO: renamed from: f1, reason: collision with root package name */
    public Runnable f3284f1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3285g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public boolean f3286g0;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public ValueAnimator f3287g1;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public VelocityTracker f3288h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3289i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f3290i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f3291j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public pj.d f3292k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public int f3293l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f3294m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f3295n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public float f3296n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public float f3297o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3298p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public float f3299p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public float f3300q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public long f3301r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public int f3302s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f3303t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public boolean f3304u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3305v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public Typeface f3306v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3307w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public Typeface f3308w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f3309x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public f<T> f3310x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f3311y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public g f3312y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f3313z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public h f3314z0;

    /* JADX INFO: renamed from: i1, reason: collision with root package name */
    public static final float f3249i1 = u(2.0f);

    /* JADX INFO: renamed from: j1, reason: collision with root package name */
    public static final float f3250j1 = m0(15.0f);

    /* JADX INFO: renamed from: l1, reason: collision with root package name */
    public static final float f3252l1 = u(1.0f);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            String strY;
            if (WheelView.this.f3275c1) {
                WheelView wheelView = WheelView.this;
                if (wheelView.f3295n || (strY = wheelView.y(0)) == null || strY.isEmpty()) {
                    return;
                }
                Paint.FontMetrics fontMetrics = WheelView.this.f3273c.getFontMetrics();
                float height = WheelView.this.getHeight();
                float f10 = fontMetrics.descent - fontMetrics.ascent;
                WheelView wheelView2 = WheelView.this;
                float f11 = height - f10;
                wheelView2.f3278d1 = f11;
                wheelView2.f3281e1 = (-f11) / 2.0f;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            WheelView.this.o0();
            WheelView.this.d0();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            if (animatedValue instanceof Float) {
                WheelView.this.f3296n0 = ((Float) animatedValue).floatValue();
                WheelView.this.F();
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface d {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface e {
    }

    public interface f<T> {
        void a(WheelView<T> wheelView, T t10, int i10);
    }

    public interface g {
        void a(int i10, int i11);

        void b(int i10);

        void c(int i10);

        void d(int i10);
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SoundPool f3318a = new SoundPool.Builder().build();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3319b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f3320c;

        public static h c() {
            return new h();
        }

        public float a() {
            return this.f3320c;
        }

        public void b(Context context, @RawRes int i10) {
            SoundPool soundPool = this.f3318a;
            if (soundPool != null) {
                this.f3319b = soundPool.load(context, i10, 1);
            }
        }

        public void d() {
            int i10;
            SoundPool soundPool = this.f3318a;
            if (soundPool == null || (i10 = this.f3319b) == 0) {
                return;
            }
            float f10 = this.f3320c;
            soundPool.play(i10, f10, f10, 1, 0, 1.0f);
        }

        public void e() {
            SoundPool soundPool = this.f3318a;
            if (soundPool != null) {
                soundPool.release();
                this.f3318a = null;
            }
        }

        public void f(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
            this.f3320c = f10;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    public WheelView(Context context) {
        this(context, null);
    }

    private int getCurrentPosition() {
        float f10;
        int iS;
        if (this.f3283f0.isEmpty()) {
            return -1;
        }
        float f11 = this.f3296n0;
        if (f11 < 0.0f) {
            f10 = f11 - (this.L0 / 2);
            iS = s();
        } else {
            f10 = f11 + (this.L0 / 2);
            iS = s();
        }
        int size = ((int) (f10 / iS)) % this.f3283f0.size();
        return size < 0 ? size + this.f3283f0.size() : size;
    }

    public static float m0(float f10) {
        return TypedValue.applyDimension(2, f10, Resources.getSystem().getDisplayMetrics());
    }

    public static float u(float f10) {
        return TypedValue.applyDimension(1, f10, Resources.getSystem().getDisplayMetrics());
    }

    @Nullable
    public T A(int i10) {
        if (L(i10)) {
            return this.f3283f0.get(i10);
        }
        if (this.f3283f0.size() > 0 && i10 >= this.f3283f0.size()) {
            List<T> list = this.f3283f0;
            return list.get(list.size() - 1);
        }
        if (this.f3283f0.size() <= 0 || i10 >= 0) {
            return null;
        }
        return this.f3283f0.get(0);
    }

    public final void B(Context context, AttributeSet attributeSet) {
        this.f3276d = false;
        this.T0 = hj.h.I();
        this.f3298p = 1;
        this.V = 0.0f;
        Locale.getDefault();
        Resources resources = context.getResources();
        this.E0 = ContextCompat.getColor(context, R.color.os_text_primary_color);
        this.F0 = ContextCompat.getColor(context, R.color.os_text_quaternary_color);
        this.G0 = ContextCompat.getColor(context, R.color.os_text_tertiary_color);
        this.H0 = ContextCompat.getColor(context, R.color.os_text_tertiary_color);
        this.U0 = ContextCompat.getColor(context, R.color.os_altitude_secondary_color);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.wheelWidth});
        this.K0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, resources.getDimensionPixelSize(R.dimen.picker_wheel_width_hour));
        this.L0 = resources.getDimensionPixelSize(R.dimen.picker_wheel_item_height);
        typedArrayObtainStyledAttributes.recycle();
        this.B0 = resources.getDimensionPixelSize(R.dimen.picker_wheel_text_first);
        this.C0 = resources.getDimensionPixelSize(R.dimen.picker_wheel_text_first);
        this.D0 = resources.getDimensionPixelSize(R.dimen.picker_wheel_text_select);
        this.I0 = resources.getDimensionPixelSize(R.dimen.picker_wheel_item_height);
        this.J0 = resources.getDimensionPixelSize(R.dimen.picker_wheel_item_height_select);
        this.f3270b.setTextSize(this.C0);
        this.f3270b.setColor(this.G0);
        this.f3273c.setTextSize(this.C0);
        this.f3289i = f3249i1;
        this.f3285g = 5;
        this.f3285g = k(5);
        this.f3302s0 = 0;
        this.f3303t0 = 0;
        this.f3295n = false;
        this.f3305v = false;
        this.f3311y = 0;
        this.f3309x = f3252l1;
        this.f3307w = this.E0;
        this.f3313z = 0.0f;
        this.I = 0.0f;
        this.J = false;
        this.K = 0;
        this.f3271b0 = false;
        this.f3274c0 = 1;
        this.f3277d0 = 0.75f;
        this.f3280e0 = 1.0f;
        this.f3280e0 = 1.0f;
        if (1.0f > 1.0f || 1.0f < 0.0f) {
            this.f3280e0 = 1.0f;
        }
        float f10 = context.getResources().getDisplayMetrics().density;
        this.Y0 = 360.0f * f10;
        this.Z0 = f10 * 2.0f;
    }

    public final void C(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            this.f3314z0.f(0.3f);
            return;
        }
        this.f3314z0.f((audioManager.getStreamVolume(3) * 1.0f) / audioManager.getStreamMaxVolume(3));
    }

    public final void D(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3290i0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f3291j0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3292k0 = new pj.d(context, new OvershootInterpolator(2.0f));
        this.U = new Rect();
        this.W = new Camera();
        this.f3268a0 = new Matrix();
        this.X0 = context.getResources().getDisplayMetrics().density;
        if (this.A0 && !isInEditMode()) {
            this.f3314z0 = new h();
            C(context);
        }
        q();
        p0();
        post(new a());
    }

    public final void E() {
        if (this.f3288h0 == null) {
            this.f3288h0 = VelocityTracker.obtain();
        }
    }

    public final void F() {
        float f10 = this.f3296n0;
        if (f10 != this.f3297o0) {
            this.f3297o0 = f10;
            g gVar = this.f3312y0;
            if (gVar != null) {
                gVar.d((int) f10);
            }
            U(this.f3296n0);
            R();
            invalidate();
        }
    }

    public final boolean G() {
        ValueAnimator valueAnimator = this.f3287g1;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean H() {
        return this.f3276d;
    }

    public boolean I() {
        return this.f3271b0;
    }

    public boolean J() {
        return this.f3295n;
    }

    public boolean K() {
        return this.J;
    }

    public boolean L(int i10) {
        return i10 >= 0 && i10 < this.f3283f0.size();
    }

    public boolean M() {
        return this.f3286g0;
    }

    public boolean N() {
        return this.f3305v;
    }

    public boolean O() {
        return this.A0;
    }

    public boolean P() {
        return this.M0;
    }

    public float Q(boolean z10, float f10) {
        float fM = m((this.f3296n0 + f10) % s()) + f10;
        boolean z11 = false;
        boolean z12 = fM < 0.0f && this.f3296n0 + fM >= ((float) this.f3293l0);
        if (fM > 0.0f && this.f3296n0 + fM <= this.f3294m0) {
            z11 = true;
        }
        if (!z12 && !z11) {
            return 0.0f;
        }
        if (z10) {
            this.f3292k0.z(0, (int) this.f3296n0, 0, (int) fM, 350);
        }
        return fM;
    }

    public final void R() {
        int i10 = this.f3303t0;
        int currentPosition = getCurrentPosition();
        if (i10 != currentPosition) {
            g gVar = this.f3312y0;
            if (gVar != null) {
                float f10 = this.f3297o0;
                if (f10 >= this.f3293l0 && f10 <= this.f3294m0) {
                    gVar.a(i10, currentPosition);
                }
            }
            T(i10, currentPosition);
            X();
            this.f3303t0 = currentPosition;
            this.f3302s0 = currentPosition;
        }
    }

    public void S(T t10, int i10) {
    }

    public void T(int i10, int i11) {
    }

    public void U(float f10) {
    }

    public void V(int i10) {
    }

    public void W(int i10) {
    }

    public void X() {
        h hVar = this.f3314z0;
        if (hVar == null || !this.A0) {
            return;
        }
        hVar.d();
    }

    public final int Y() {
        Paint.FontMetrics fontMetrics = this.f3267a.getFontMetrics();
        float f10 = fontMetrics.ascent;
        return (int) t.a.a(fontMetrics.descent, f10, 2.0f, f10);
    }

    public final void Z(float f10) {
        int i10 = this.f3298p;
        if (i10 == 0) {
            this.L = (int) f10;
        } else if (i10 != 2) {
            this.L = getWidth() / 2;
        } else {
            this.L = (int) (getWidth() - f10);
        }
    }

    public void a() {
        pj.d dVar = this.f3292k0;
        if (dVar.f13142r) {
            return;
        }
        dVar.a();
    }

    public final void a0() {
        VelocityTracker velocityTracker = this.f3288h0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f3288h0 = null;
        }
    }

    public final int b0(String str) {
        float f10;
        float fMeasureText = this.f3267a.measureText(str);
        float width = getWidth();
        float f11 = this.V * 2.0f;
        if (f11 > width / 10.0f) {
            f10 = (width * 9.0f) / 10.0f;
            f11 = f10 / 10.0f;
        } else {
            f10 = width - f11;
        }
        if (f10 <= 0.0f) {
            return this.f3282f;
        }
        float f12 = this.C0;
        while (fMeasureText > f10) {
            f12 -= 1.0f;
            if (f12 <= 0.0f) {
                break;
            }
            this.f3267a.setTextSize(f12);
            fMeasureText = this.f3267a.measureText(str);
        }
        Z(f11 / 2.0f);
        return Y();
    }

    public final void c0(Paint paint, String str) {
        int width;
        if (TextUtils.isEmpty(str) || (width = getWidth()) == 0) {
            return;
        }
        this.W0.setTextSize(paint.getTextSize());
        if (((int) Math.ceil(Layout.getDesiredWidth(str, this.W0))) > width) {
            Paint paint2 = this.f3267a;
            paint2.setTextSize(paint2.getTextSize() - this.X0);
            c0(paint, str);
        }
    }

    public void d0() {
        if (this.f3292k0.f13142r) {
            return;
        }
        ViewCompat.postOnAnimation(this, this.f3284f1);
    }

    public void e0(float f10, boolean z10) {
        float f11 = this.f3309x;
        if (z10) {
            f10 = u(f10);
        }
        this.f3309x = f10;
        if (f11 == f10) {
            return;
        }
        invalidate();
    }

    public void f0(float f10, boolean z10) {
        float f11 = this.f3313z;
        if (z10) {
            f10 = u(f10);
        }
        this.f3313z = f10;
        if (f11 == f10) {
            return;
        }
        invalidate();
    }

    public void g0(float f10, boolean z10) {
        float f11 = this.f3289i;
        if (z10) {
            f10 = u(f10);
        }
        this.f3289i = f10;
        if (f11 == f10) {
            return;
        }
        this.f3296n0 = 0.0f;
        q();
        requestLayout();
        invalidate();
    }

    public int getCurvedArcDirection() {
        return this.f3274c0;
    }

    public float getCurvedArcDirectionFactor() {
        return this.f3277d0;
    }

    @Deprecated
    public float getCurvedRefractRatio() {
        return this.f3280e0;
    }

    public List<T> getData() {
        return this.f3283f0;
    }

    public Paint.Cap getDividerCap() {
        return this.H;
    }

    public int getDividerColor() {
        return this.f3307w;
    }

    public float getDividerHeight() {
        return this.f3309x;
    }

    public float getDividerPaddingForWrap() {
        return this.f3313z;
    }

    public int getDividerType() {
        return this.f3311y;
    }

    public float getLineSpacing() {
        return this.f3289i;
    }

    public f<T> getOnItemSelectedListener() {
        return this.f3310x0;
    }

    public g getOnWheelChangedListener() {
        return this.f3312y0;
    }

    public float getPlayVolume() {
        h hVar = this.f3314z0;
        if (hVar == null) {
            return 0.0f;
        }
        return hVar.a();
    }

    public float getRefractRatio() {
        return this.f3280e0;
    }

    public Paint getSecondPaint() {
        return this.f3270b;
    }

    public T getSelectedItemData() {
        return A(this.f3302s0);
    }

    public int getSelectedItemPosition() {
        return this.f3302s0;
    }

    public Paint getSelectedPaint() {
        return this.f3273c;
    }

    public int getSelectedRectColor() {
        return this.K;
    }

    public int getTextAlign() {
        return this.f3298p;
    }

    public float getTextBoundaryMargin() {
        return this.V;
    }

    public int getTextSecondColor() {
        return this.G0;
    }

    public int getTextSelectColor() {
        return this.E0;
    }

    public int getTextSizeSecond() {
        return this.C0;
    }

    public int getTextSizeSelect() {
        return this.D0;
    }

    public Typeface getTypeface() {
        return this.f3267a.getTypeface();
    }

    public int getVisibleItems() {
        return this.f3285g;
    }

    public int getWheelHeight() {
        return this.L0;
    }

    public void h0(int i10, boolean z10) {
        i0(i10, z10, 0);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public void i0(int i10, boolean z10, int i11) {
        int iO;
        if (L(i10) && (iO = o(i10)) != 0) {
            a();
            if (z10) {
                pj.d dVar = this.f3292k0;
                int i12 = (int) this.f3296n0;
                if (i11 <= 0) {
                    i11 = 250;
                }
                dVar.z(0, i12, 0, iO, i11);
                F();
                return;
            }
            t(iO);
            this.f3302s0 = i10;
            f<T> fVar = this.f3310x0;
            if (fVar != null) {
                fVar.a(this, this.f3283f0.get(i10), this.f3302s0);
            }
            S(this.f3283f0.get(this.f3302s0), this.f3302s0);
            g gVar = this.f3312y0;
            if (gVar != null) {
                gVar.c(this.f3302s0);
            }
            W(this.f3302s0);
            F();
        }
    }

    public void j0(float f10, boolean z10) {
        float f11 = this.V;
        if (z10) {
            f10 = u(f10);
        }
        this.V = f10;
        if (f11 == f10) {
            return;
        }
        requestLayout();
        invalidate();
    }

    public final int k(int i10) {
        return Math.abs(((i10 / 2) * 2) + 1);
    }

    public void k0(Typeface typeface, boolean z10) {
        if (typeface == null || this.f3267a.getTypeface() == typeface) {
            return;
        }
        w();
        this.f3304u0 = z10;
        if (z10) {
            if (typeface.isBold()) {
                this.f3306v0 = Typeface.create(typeface, 0);
                this.f3308w0 = typeface;
            } else {
                this.f3306v0 = typeface;
                this.f3308w0 = Typeface.create(typeface, 1);
            }
            this.f3267a.setTypeface(this.f3308w0);
        } else {
            this.f3267a.setTypeface(typeface);
        }
        q();
        n();
        this.f3296n0 = this.f3302s0 * this.L0;
        p();
        requestLayout();
        invalidate();
    }

    public final void l(float f10, float f11) {
        if (f10 == f11) {
            return;
        }
        if (this.f3287g1 == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(new float[0]);
            this.f3287g1 = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setInterpolator(new pj.c(0.25f, 0.0f, 0.0f, 1.0f));
            this.f3287g1.setDuration(200L);
            this.f3287g1.addUpdateListener(new c());
        }
        this.f3287g1.setFloatValues(f10, f11);
        this.f3287g1.start();
    }

    public void l0(Calendar calendar, boolean z10) {
        this.Q0 = calendar;
        this.M0 = z10;
    }

    public final float m(float f10) {
        float fAbs = Math.abs(f10);
        int i10 = this.L0;
        if (fAbs > i10 / 2) {
            return (this.f3296n0 < 0.0f ? -i10 : i10) - f10;
        }
        return -f10;
    }

    public final void n() {
        int i10 = this.f3298p;
        if (i10 == 0) {
            this.L = (int) (getPaddingLeft() + this.V);
        } else if (i10 != 2) {
            this.L = getWidth() / 2;
        } else {
            this.L = (int) ((getWidth() - getPaddingRight()) - this.V);
        }
        Paint.FontMetrics fontMetrics = this.f3279e;
        float f10 = fontMetrics.ascent;
        this.f3282f = (int) t.a.a(fontMetrics.descent, f10, 2.0f, f10);
    }

    public int n0(float f10) {
        int i10 = this.G0;
        int i11 = this.E0;
        if (i10 == i11) {
            return i11;
        }
        int i12 = (i10 & ViewCompat.MEASURED_STATE_MASK) >>> 24;
        int i13 = (i10 & 16711680) >>> 16;
        int i14 = (i10 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >>> 8;
        int i15 = i10 & 255;
        return ((int) ((((i11 & 255) - i15) * f10) + i15)) | (((int) ((((((-16777216) & i11) >>> 24) - i12) * f10) + i12)) << 24) | (((int) (((((16711680 & i11) >>> 16) - i13) * f10) + i13)) << 16) | (((int) (((((65280 & i11) >>> 8) - i14) * f10) + i14)) << 8);
    }

    public final int o(int i10) {
        return (int) ((i10 * this.L0) - this.f3296n0);
    }

    public void o0() {
        if (this.f3292k0.c()) {
            float f10 = this.f3296n0;
            pj.d dVar = this.f3292k0;
            boolean z10 = dVar.f13142r;
            float fM = dVar.m() + dVar.f13136l;
            this.f3296n0 = fM;
            if (!this.f3275c1 || this.f3295n) {
                F();
            } else if (z10) {
                l(f10, fM);
            } else {
                F();
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h hVar = this.f3314z0;
        if (hVar != null) {
            hVar.e();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i10 = this.U0;
        if (i10 != 0) {
            canvas.drawColor(i10);
        }
        int iS = s();
        float f10 = iS;
        int i11 = (int) (this.f3296n0 / f10);
        float height = getHeight();
        float f11 = height * 0.5f;
        int i12 = ((int) (height / f10)) + 4;
        int i13 = i11 - (i12 >> 1);
        float f12 = i12 + i13;
        float f13 = f10 * 0.5f;
        float f14 = (f11 - f13) - this.f3296n0;
        while (i13 < f12) {
            float f15 = f14 + (i13 * iS);
            float fAbs = Math.abs((f11 - f15) - f13);
            if (fAbs < f13) {
                float f16 = 1.0f - (fAbs / f13);
                int i14 = this.D0;
                int i15 = this.C0;
                this.f3273c.setTextSize((((((i14 - i15) * 1.0f) / i15) * f16) + 1.0f) * i15);
                this.f3273c.setColor(n0(f16));
                v(canvas, this.f3273c, i13, f15, f10);
            } else {
                v(canvas, this.f3270b, i13, f15, f10);
            }
            i13++;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        int paddingBottom;
        if (this.f3271b0) {
            paddingBottom = (int) ((((double) ((this.L0 * this.f3285g) * 2)) / 3.141592653589793d) + ((double) getPaddingTop()) + ((double) getPaddingBottom()));
        } else {
            paddingBottom = getPaddingBottom() + getPaddingTop() + (this.L0 * this.f3285g);
        }
        int paddingRight = (int) ((this.V * 2.0f) + getPaddingRight() + getPaddingLeft() + this.K0);
        if (this.f3271b0) {
            paddingRight += (int) (Math.sin(0.06544984694978735d) * ((double) paddingBottom));
        }
        setMeasuredDimension(View.resolveSizeAndState(paddingRight, i10, 0), View.resolveSizeAndState(paddingBottom, i11, 0));
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.U.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        this.M = this.U.centerX();
        int iCenterY = this.U.centerY();
        this.N = iCenterY;
        int i14 = this.L0;
        float f10 = this.I;
        this.O = (int) ((iCenterY - (i14 / 2)) - f10);
        this.P = (int) ((i14 / 2) + iCenterY + f10);
        this.Q = getPaddingLeft();
        this.R = getPaddingTop();
        this.S = getWidth() - getPaddingRight();
        this.T = getHeight() - getPaddingBottom();
        n();
        p();
        int iO = o(this.f3302s0);
        if (iO > 0) {
            t(iO);
        }
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ae  */
    @Override // android.view.View
    @b.a({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float yVelocity;
        if (G()) {
            return false;
        }
        if (!isEnabled() || this.f3283f0.isEmpty()) {
            return super.onTouchEvent(motionEvent);
        }
        E();
        this.f3288h0.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            x();
            this.f3299p0 = motionEvent.getY();
            this.f3300q0 = this.f3296n0;
            this.f3301r0 = System.currentTimeMillis();
            this.f3269a1 = (int) (hj.h.M(this.f3270b) * this.f3283f0.size());
            this.f3272b1 = false;
        } else if (actionMasked == 1) {
            this.f3288h0.computeCurrentVelocity(1000, this.f3290i0);
            yVelocity = this.f3288h0.getYVelocity();
            if (Math.abs(yVelocity) <= this.f3291j0 || this.f3272b1) {
                x();
                this.f3292k0.e(0, (int) this.f3296n0, 0, (int) (-yVelocity), 0, 0, this.f3293l0, this.f3294m0);
                float f10 = this.f3292k0.f13130f;
                float f11 = this.f3296n0;
                this.f3296n0 = f10;
                float fQ = Q(false, 0.0f);
                this.f3296n0 = f11;
                this.f3292k0.w(fQ);
            } else {
                Q(true, System.currentTimeMillis() - this.f3301r0 <= 120 ? (int) (motionEvent.getY() - this.N) : 0);
            }
            d0();
            F();
            a0();
        } else if (actionMasked == 2) {
            float y10 = this.f3299p0 - motionEvent.getY();
            if (Math.abs(y10) >= this.f3269a1) {
                this.f3272b1 = true;
            }
            float f12 = this.f3300q0 + y10;
            this.f3296n0 = f12;
            if (this.f3275c1 && !this.f3295n) {
                float f13 = this.f3278d1;
                if (f12 > f13) {
                    this.f3296n0 = f13;
                }
                float f14 = this.f3296n0;
                float f15 = this.f3281e1;
                if (f14 < f15) {
                    this.f3296n0 = f15;
                }
            }
            g gVar = this.f3312y0;
            if (gVar != null) {
                gVar.b(1);
            }
            V(1);
            F();
        } else if (actionMasked == 3) {
            this.f3288h0.computeCurrentVelocity(1000, this.f3290i0);
            yVelocity = this.f3288h0.getYVelocity();
            if (Math.abs(yVelocity) <= this.f3291j0) {
                x();
                this.f3292k0.e(0, (int) this.f3296n0, 0, (int) (-yVelocity), 0, 0, this.f3293l0, this.f3294m0);
                float f16 = this.f3292k0.f13130f;
                float f17 = this.f3296n0;
                this.f3296n0 = f16;
                float fQ2 = Q(false, 0.0f);
                this.f3296n0 = f17;
                this.f3292k0.w(fQ2);
            } else {
                x();
                this.f3292k0.e(0, (int) this.f3296n0, 0, (int) (-yVelocity), 0, 0, this.f3293l0, this.f3294m0);
                float f18 = this.f3292k0.f13130f;
                float f19 = this.f3296n0;
                this.f3296n0 = f18;
                float fQ3 = Q(false, 0.0f);
                this.f3296n0 = f19;
                this.f3292k0.w(fQ3);
            }
            d0();
            F();
            a0();
        }
        return true;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (i10 == 0) {
            if (hj.h.y(getContext())) {
                Paint paint = this.f3270b;
                Typeface typeface = Typeface.DEFAULT_BOLD;
                paint.setTypeface(typeface);
                this.f3273c.setTypeface(typeface);
                return;
            }
            Paint paint2 = this.f3270b;
            Typeface typeface2 = Typeface.DEFAULT;
            paint2.setTypeface(typeface2);
            this.f3273c.setTypeface(typeface2);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        if (z10) {
            return;
        }
        a();
        setSelectedItemPosition(getSelectedItemPosition());
    }

    public final void p() {
        boolean z10 = this.f3295n;
        this.f3293l0 = z10 ? Integer.MIN_VALUE : 0;
        this.f3294m0 = z10 ? Integer.MAX_VALUE : (this.f3283f0.size() - 1) * this.L0;
    }

    public final void p0() {
        int i10 = this.f3298p;
        if (i10 == 0) {
            this.f3267a.setTextAlign(Paint.Align.LEFT);
        } else if (i10 != 2) {
            this.f3267a.setTextAlign(Paint.Align.CENTER);
        } else {
            this.f3267a.setTextAlign(Paint.Align.RIGHT);
        }
    }

    public final void q() {
        this.f3267a.setTextSize(this.D0);
        this.f3279e = this.f3267a.getFontMetrics();
    }

    public final String r(String str) {
        if (this.Q0 == null) {
            return null;
        }
        int i10 = Integer.parseInt(str);
        if (this.R0 == null) {
            this.R0 = Calendar.getInstance();
        }
        this.R0.set(1, this.Q0.get(1));
        this.R0.set(6, i10);
        int i11 = this.R0.get(2);
        List<String> list = this.S0;
        if (list == null || list.size() <= i11) {
            return "";
        }
        int i12 = this.R0.get(5);
        if (this.T0) {
            return String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i12)) + getContext().getString(R.string.day_time_picker) + " " + this.S0.get(i11);
        }
        return this.S0.get(i11) + " " + String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(i12)) + getContext().getString(R.string.day_time_picker);
    }

    public final int s() {
        int i10 = this.L0;
        if (i10 > 0) {
            return i10;
        }
        return 1;
    }

    public void set24HoursFormat(boolean z10) {
        this.P0 = z10;
    }

    public void setAmPmWheel(boolean z10) {
        this.f3275c1 = z10;
    }

    public void setAutoFitTextSize(boolean z10) {
        this.f3276d = z10;
        invalidate();
    }

    public void setCurved(boolean z10) {
        if (this.f3271b0 == z10) {
            return;
        }
        this.f3271b0 = z10;
        q();
        requestLayout();
        invalidate();
    }

    public void setCurvedArcDirection(int i10) {
        if (this.f3274c0 == i10) {
            return;
        }
        this.f3274c0 = i10;
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:7:0x000c A[PHI: r0
      0x000c: PHI (r0v4 float) = (r0v2 float), (r0v3 float) binds: [B:6:0x000a, B:9:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    public void setCurvedArcDirectionFactor(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        if (this.f3277d0 == f10) {
            return;
        }
        float f11 = 0.0f;
        if (f10 < 0.0f) {
            f10 = f11;
        } else {
            f11 = 1.0f;
            if (f10 > 1.0f) {
                f10 = f11;
            }
        }
        this.f3277d0 = f10;
        invalidate();
    }

    @Deprecated
    public void setCurvedRefractRatio(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        setRefractRatio(f10);
    }

    public void setCyclic(boolean z10) {
        if (this.f3295n == z10) {
            return;
        }
        this.f3295n = z10;
        w();
        p();
        this.f3296n0 = this.f3302s0 * this.L0;
        invalidate();
    }

    public void setData(List<T> list) {
        if (list == null) {
            return;
        }
        this.f3283f0 = list;
        if (this.f3286g0 || list.size() <= 0) {
            this.f3302s0 = 0;
            this.f3303t0 = 0;
        } else if (this.f3302s0 >= this.f3283f0.size()) {
            int size = this.f3283f0.size() - 1;
            this.f3302s0 = size;
            this.f3303t0 = size;
        }
        w();
        q();
        p();
        this.f3296n0 = this.f3302s0 * this.L0;
        requestLayout();
        invalidate();
    }

    public void setDividerCap(Paint.Cap cap) {
        if (this.H == cap) {
            return;
        }
        this.H = cap;
        invalidate();
    }

    public void setDividerColor(@ColorInt int i10) {
        if (this.f3307w == i10) {
            return;
        }
        this.f3307w = i10;
        invalidate();
    }

    public void setDividerColorRes(@ColorRes int i10) {
        setDividerColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setDividerHeight(float f10) {
        e0(f10, false);
    }

    public void setDividerPaddingForWrap(float f10) {
        f0(f10, false);
    }

    public void setDividerType(int i10) {
        if (this.f3311y == i10) {
            return;
        }
        this.f3311y = i10;
        invalidate();
    }

    public void setDrawSelectedRect(boolean z10) {
        this.J = z10;
        invalidate();
    }

    public void setHourWheel(boolean z10) {
        this.N0 = z10;
    }

    public void setLineSpacing(float f10) {
        g0(f10, false);
    }

    public void setMinuteWheel(boolean z10) {
        this.O0 = z10;
    }

    public void setMonthList(List<String> list) {
        this.S0 = list;
    }

    public void setOnItemSelectedListener(f<T> fVar) {
        this.f3310x0 = fVar;
    }

    public void setOnWheelChangedListener(g gVar) {
        this.f3312y0 = gVar;
    }

    public void setPlayVolume(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        h hVar = this.f3314z0;
        if (hVar != null) {
            hVar.f(f10);
        }
    }

    public void setRefractRatio(@FloatRange(from = 0.0d, to = 1.0d) float f10) {
        float f11 = this.f3280e0;
        this.f3280e0 = f10;
        if (f10 > 1.0f || f10 < 0.0f) {
            this.f3280e0 = 1.0f;
        }
        if (f11 == this.f3280e0) {
            return;
        }
        invalidate();
    }

    public void setResetSelectedPosition(boolean z10) {
        this.f3286g0 = z10;
    }

    public void setSelectedItemPosition(int i10) {
        h0(i10, false);
    }

    public void setSelectedRectColor(@ColorInt int i10) {
        this.K = i10;
        invalidate();
    }

    public void setSelectedRectColorRes(@ColorRes int i10) {
        setSelectedRectColor(ContextCompat.getColor(getContext(), i10));
    }

    public void setShowDivider(boolean z10) {
        if (this.f3305v == z10) {
            return;
        }
        this.f3305v = z10;
        invalidate();
    }

    public void setSoundEffect(boolean z10) {
        this.A0 = z10;
    }

    public void setSoundEffectResource(@RawRes int i10) {
        h hVar = this.f3314z0;
        if (hVar != null) {
            hVar.b(getContext(), i10);
        }
    }

    public void setTextAlign(int i10) {
        if (this.f3298p == i10) {
            return;
        }
        this.f3298p = i10;
        p0();
        n();
        invalidate();
    }

    public void setTextBoundaryMargin(float f10) {
        j0(f10, false);
    }

    public void setTextSecondColor(int i10) {
        this.G0 = i10;
        invalidate();
    }

    public void setTextSelectColor(int i10) {
        this.E0 = i10;
        invalidate();
    }

    public void setTextSizeSecond(int i10) {
        this.C0 = i10;
        this.f3270b.setTextSize(i10);
        invalidate();
    }

    public void setTextSizeSelect(int i10) {
        this.D0 = i10;
        this.f3273c.setTextSize(i10);
        invalidate();
    }

    public void setTypeface(Typeface typeface) {
        k0(typeface, false);
    }

    public void setVisibleItems(int i10) {
        if (this.f3285g == i10) {
            return;
        }
        this.f3285g = k(i10);
        this.f3296n0 = 0.0f;
        requestLayout();
        invalidate();
    }

    public void setWheelBackgroundColor(int i10) {
        this.U0 = i10;
    }

    public void setWheelHeight(int i10) {
        this.L0 = i10;
        invalidate();
    }

    public final void t(float f10) {
        float f11 = this.f3296n0 + f10;
        this.f3296n0 = f11;
        if (this.f3295n) {
            return;
        }
        int i10 = this.f3293l0;
        if (f11 < i10) {
            this.f3296n0 = i10;
            return;
        }
        int i11 = this.f3294m0;
        if (f11 > i11) {
            this.f3296n0 = i11;
        }
    }

    public final void v(Canvas canvas, Paint paint, int i10, float f10, float f11) {
        String strY = y(i10);
        if (strY == null) {
            return;
        }
        float textSize = paint.getTextSize();
        float fMeasureText = paint.measureText(strY);
        float f12 = (f11 - textSize) * 0.5f;
        float width = getWidth() - fMeasureText;
        if (width < 0.0f) {
            strY = TextUtils.ellipsize(strY, new TextPaint(paint), getWidth(), TextUtils.TruncateAt.END).toString();
            width = getWidth() - fMeasureText;
        }
        canvas.drawText(strY, width > 0.0f ? width * 0.5f : 0.0f, f10 + f12 + textSize, paint);
    }

    public void w() {
        pj.d dVar = this.f3292k0;
        if (dVar.f13142r) {
            return;
        }
        dVar.f13142r = true;
    }

    public void x() {
        pj.d dVar = this.f3292k0;
        if (dVar.f13142r) {
            return;
        }
        dVar.f13142r = true;
    }

    public final String y(int i10) {
        int size = this.f3283f0.size();
        String strZ = null;
        if (size == 0) {
            return null;
        }
        if (this.f3295n) {
            int i11 = i10 % size;
            if (i11 < 0) {
                i11 += size;
            }
            strZ = z(this.f3283f0.get(i11));
        } else if (i10 >= 0 && i10 < size) {
            strZ = z(this.f3283f0.get(i10));
        }
        return (!this.M0 || TextUtils.isEmpty(strZ)) ? strZ : r(strZ);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String z(T t10) {
        if (t10 == 0) {
            return "";
        }
        if (!(t10 instanceof Integer)) {
            return t10 instanceof String ? (String) t10 : t10.toString();
        }
        Integer num = (Integer) t10;
        boolean z10 = this.N0;
        String str = TimeModel.NUMBER_FORMAT;
        if (!z10 ? this.O0 : this.P0) {
            str = TimeModel.ZERO_LEADING_NUMBER_FORMAT;
        }
        return String.format(Locale.getDefault(), str, num).concat("");
    }

    public WheelView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WheelView(Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f3267a = new Paint(1);
        this.f3270b = new Paint(1);
        this.f3273c = new Paint(1);
        this.H = Paint.Cap.ROUND;
        this.f3283f0 = new ArrayList(1);
        this.f3286g0 = false;
        this.f3297o0 = 0.0f;
        this.f3304u0 = false;
        this.f3306v0 = null;
        this.f3308w0 = null;
        this.A0 = false;
        this.S0 = new ArrayList();
        this.V0 = new Matrix();
        this.W0 = new TextPaint(1);
        this.Y0 = 720.0f;
        this.Z0 = 2.0f;
        this.f3284f1 = new b();
        B(context, attributeSet);
        D(context);
    }
}
