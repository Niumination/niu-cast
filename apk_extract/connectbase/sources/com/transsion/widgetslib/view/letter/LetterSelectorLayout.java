package com.transsion.widgetslib.view.letter;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import androidx.annotation.IntRange;
import androidx.core.content.ContextCompat;
import com.transsion.widgetslib.R;
import io.github.inflationx.calligraphy3.HasTypeface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class LetterSelectorLayout extends FrameLayout implements HasTypeface {
    public static final int K0 = 1;
    public static final int L0 = 2;
    public static final int M0 = 3;
    public static final float O0 = 0.6f;
    public static final float P0 = 1.0f;
    public static final int Q0 = 255;
    public boolean A0;
    public boolean B0;
    public boolean C0;
    public int D0;
    public int E0;
    public int F0;
    public float G0;
    public final Paint H;
    public int H0;
    public final Paint I;
    public h.a I0;
    public final Paint J;
    public boolean J0;
    public final Paint K;
    public float L;
    public float M;
    public float N;
    public long O;
    public long P;
    public boolean Q;
    public boolean R;
    public h S;
    public List<String> T;
    public final List<String> U;
    public final List<String> V;
    public float W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2566a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public int f2567a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f2568b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f2569b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f2570c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f2571c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ValueAnimator f2572d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f2573d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ValueAnimator f2574e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public int f2575e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Runnable f2576f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public int f2577f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f2578g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public int f2579g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public int f2580h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f2581i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public int f2582i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f2583j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public ArrayList<String> f2584k0;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public boolean f2585l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public Bitmap f2586m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f2587n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f2588n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f2589o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f2590p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final RectF f2591p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public boolean f2592q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final RectF f2593r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final RectF f2594s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final ArrayMap<RectF, g> f2595t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final RectF f2596u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Bitmap f2597v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final RectF f2598v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Bitmap f2599w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public final List<RectF> f2600w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Interpolator f2601x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public String f2602x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Paint f2603y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public int f2604y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Paint f2605z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final List<g> f2606z0;
    public static final String N0 = "☆";
    public static final List<String> R0 = Arrays.asList(N0, "#", "…", "♤", N0, "Λ");
    public static final String S0 = "LetterSelectorLayout";

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() / 200.0f;
            LetterSelectorLayout.this.f2578g = (int) (255.0f * fFloatValue);
            LetterSelectorLayout letterSelectorLayout = LetterSelectorLayout.this;
            letterSelectorLayout.f2581i = (fFloatValue * 0.39999998f) + 0.6f;
            letterSelectorLayout.invalidate();
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            LetterSelectorLayout.this.f2590p = true;
            LetterSelectorLayout letterSelectorLayout = LetterSelectorLayout.this;
            letterSelectorLayout.f2587n = false;
            letterSelectorLayout.f2581i = 0.0f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ValueAnimator valueAnimator;
            ValueAnimator valueAnimator2;
            if (LetterSelectorLayout.this.f2590p) {
                return;
            }
            LetterSelectorLayout letterSelectorLayout = LetterSelectorLayout.this;
            if (!letterSelectorLayout.f2587n || (valueAnimator = letterSelectorLayout.f2572d) == null || valueAnimator.isRunning() || (valueAnimator2 = LetterSelectorLayout.this.f2574e) == null || valueAnimator2.isRunning()) {
                return;
            }
            LetterSelectorLayout.this.t0();
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LetterSelectorLayout.this.f2581i = 1.0f - ((((Float) valueAnimator.getAnimatedValue()).floatValue() / 200.0f) * 0.39999998f);
            LetterSelectorLayout.this.invalidate();
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            LetterSelectorLayout.this.f2587n = false;
            LetterSelectorLayout.this.f2581i = 0.0f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            LetterSelectorLayout.this.f2587n = false;
            LetterSelectorLayout letterSelectorLayout = LetterSelectorLayout.this;
            letterSelectorLayout.f2581i = 0.0f;
            letterSelectorLayout.invalidate();
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LetterSelectorLayout.this.f2572d == null || LetterSelectorLayout.this.f2572d.isRunning()) {
                return;
            }
            LetterSelectorLayout.this.f2572d.start();
            LetterSelectorLayout.this.f2574e.start();
        }
    }

    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            LetterSelectorLayout.this.f2578g = (int) (255.0f - ((((Float) valueAnimator.getAnimatedValue()).floatValue() / 100.0f) * 255.0f));
        }
    }

    public static class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LetterSelectorLayout f2617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Context f2618b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2619c;

        public interface a {
            void a(String str, int i10, int i11, boolean z10);

            boolean b();
        }

        public /* synthetic */ h(LetterSelectorLayout letterSelectorLayout, a aVar) {
            this(letterSelectorLayout);
        }

        public static int J(Context context, int i10) {
            return (int) TypedValue.applyDimension(2, i10, context.getResources().getDisplayMetrics());
        }

        public static int d(Context context, int i10) {
            return (int) TypedValue.applyDimension(1, i10, context.getResources().getDisplayMetrics());
        }

        public h A(String str) {
            this.f2617a.setSelectedLetter(str);
            return this;
        }

        public h B(int i10) {
            this.f2617a.f2583j0 = i10;
            this.f2617a.K.setColor(i10);
            return this;
        }

        public h C(ArrayList<String> arrayList) {
            this.f2617a.f2584k0 = arrayList;
            this.f2617a.invalidate();
            return this;
        }

        public h D(boolean z10) {
            this.f2617a.f2585l0 = z10;
            return this;
        }

        public h E(int i10) {
            this.f2617a.W = b(i10);
            return this;
        }

        public h F(int i10, int i11) {
            this.f2617a.I.setColor(i10);
            return this;
        }

        public h G(boolean z10) {
            this.f2617a.f2592q0 = z10;
            return this;
        }

        public h H(boolean z10) {
            this.f2617a.C0 = z10;
            return this;
        }

        public h I(boolean z10) {
            this.f2617a.s0(z10);
            return this;
        }

        public h K(int i10) {
            this.f2617a.f2573d0 = b(i10);
            return this;
        }

        public h L(int i10) {
            this.f2617a.f2571c0 = b(i10);
            return this;
        }

        public final int b(int i10) {
            return this.f2619c ? d(this.f2618b, i10) : i10;
        }

        public final int c(int i10) {
            return this.f2619c ? J(this.f2618b, i10) : i10;
        }

        public final void e() {
            this.f2617a.U.clear();
            for (String str : this.f2617a.T) {
                if (!this.f2617a.V.contains(str)) {
                    this.f2617a.U.add(str);
                }
            }
            LetterSelectorLayout letterSelectorLayout = this.f2617a;
            letterSelectorLayout.U.addAll(letterSelectorLayout.V);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x008f  */
        public void f(Context context) {
            Resources resources = context.getResources();
            z(context.getResources().getDimensionPixelSize(R.dimen.letter_top_padding), resources.getDimensionPixelSize(R.dimen.letter_bottom_padding), resources.getDimensionPixelSize(hj.h.K(context) ? R.dimen.os_letter_padding_curse : R.dimen.os_letter_padding));
            q(resources.getDimensionPixelSize(R.dimen.blade_list_section_font_Size), resources.getDimensionPixelSize(R.dimen.blade_list_section_max_font_Size), resources.getDimensionPixelSize(R.dimen.blade_list_section_indicate_font_Size));
            this.f2617a.f2566a = ContextCompat.getColor(context, R.color.os_text_secondary_color);
            this.f2617a.f2568b = ContextCompat.getColor(context, R.color.os_text_quaternary_color);
            LetterSelectorLayout letterSelectorLayout = this.f2617a;
            p(letterSelectorLayout.f2566a, letterSelectorLayout.f2568b, ContextCompat.getColor(context, R.color.letter_select_color));
            String strO = hj.h.o();
            int i10 = R.color.os_platform_basic_color_hios;
            if (TextUtils.isEmpty(strO)) {
                i10 = R.color.os_platform_basic_color_hios;
            } else {
                String[] strArr = hj.h.f7214g;
                if (strO.equalsIgnoreCase(strArr[0])) {
                    i10 = R.color.os_platform_basic_color_hios;
                } else if (strO.equalsIgnoreCase(strArr[1])) {
                    i10 = R.color.os_platform_basic_color_xos;
                } else if (strO.equalsIgnoreCase(strArr[2])) {
                    i10 = R.color.os_platform_basic_color_itel;
                }
            }
            B(ContextCompat.getColor(context, i10));
            Bitmap bitmapJ = hj.c.J(ContextCompat.getDrawable(context, R.drawable.ic_touch_bg));
            if (ui.a.s()) {
                bitmapJ = hj.c.E(bitmapJ);
            }
            t(bitmapJ, bitmapJ.getWidth(), bitmapJ.getHeight());
            E(resources.getDimensionPixelSize(R.dimen.blade_touch_width));
            this.f2617a.f2569b0 = resources.getDimensionPixelOffset(R.dimen.os_letter_bubble_margin_end);
            r(ContextCompat.getColor(context, R.color.os_letter_bubble_bg));
            this.f2617a.f2597v = hj.c.J(ContextCompat.getDrawable(context, R.drawable.os_letter_star_bubble));
            this.f2617a.f2599w = hj.c.J(ContextCompat.getDrawable(context, R.drawable.os_letter_star));
            this.f2617a.G0 = TypedValue.applyDimension(1, 14.5f, resources.getDisplayMetrics());
        }

        public final void g() {
            boolean z10;
            char cCharAt;
            Iterator it = this.f2617a.T.iterator();
            while (true) {
                z10 = true;
                if (!it.hasNext()) {
                    break;
                }
                String str = (String) it.next();
                if (str == null || str.length() != 1 || (!LetterSelectorLayout.R0.contains(str) && ((cCharAt = str.charAt(0)) < 'A' || cCharAt > 'Z'))) {
                    z10 = false;
                    break;
                }
            }
            this.f2617a.U.clear();
            if (z10) {
                LetterSelectorLayout letterSelectorLayout = this.f2617a;
                letterSelectorLayout.U.addAll(letterSelectorLayout.V);
                for (String str2 : this.f2617a.T) {
                    if (!this.f2617a.V.contains(str2)) {
                        this.f2617a.U.add(str2);
                    }
                }
            } else {
                LetterSelectorLayout letterSelectorLayout2 = this.f2617a;
                letterSelectorLayout2.U.addAll(letterSelectorLayout2.T);
            }
            new mi.f(this.f2618b).h(this.f2617a.U);
            if (this.f2617a.U.contains(LetterSelectorLayout.N0)) {
                this.f2617a.U.remove(LetterSelectorLayout.N0);
                this.f2617a.U.add(0, LetterSelectorLayout.N0);
            }
        }

        public boolean h() {
            return this.f2617a.J0;
        }

        public h i(a aVar) {
            this.f2617a.I0 = aVar;
            return this;
        }

        public h j() {
            this.f2617a.invalidate();
            return this;
        }

        public h k() {
            this.f2617a.r0();
            this.f2617a.requestLayout();
            return this;
        }

        public h l(int i10) {
            this.f2617a.O = i10;
            return this;
        }

        public h m(@IntRange(from = 50, to = 1000) int i10) {
            if (i10 < 50) {
                i10 = 50;
            }
            if (i10 > 1000) {
                i10 = 1000;
            }
            this.f2617a.D0 = i10;
            return this;
        }

        public h n(Interpolator interpolator) {
            if (interpolator == null) {
                interpolator = new LinearInterpolator();
            }
            this.f2617a.f2601x = interpolator;
            return this;
        }

        public h o(int i10, int i11) {
            p(i10, i11, ContextCompat.getColor(this.f2618b, R.color.letter_select_color));
            return this;
        }

        public h p(int i10, int i11, int i12) {
            this.f2617a.f2566a = i10;
            LetterSelectorLayout letterSelectorLayout = this.f2617a;
            letterSelectorLayout.f2568b = i11;
            letterSelectorLayout.f2603y.setColor(i10);
            this.f2617a.f2605z.setColor(i10);
            LetterSelectorLayout letterSelectorLayout2 = this.f2617a;
            letterSelectorLayout2.f2582i0 = i12;
            letterSelectorLayout2.J.setColor(i12);
            return this;
        }

        public h q(int i10, int i11, int i12) {
            this.f2617a.L = c(i10);
            this.f2617a.M = c(i11);
            this.f2617a.N = c(i12);
            LetterSelectorLayout letterSelectorLayout = this.f2617a;
            letterSelectorLayout.f2603y.setTextSize(letterSelectorLayout.L);
            LetterSelectorLayout letterSelectorLayout2 = this.f2617a;
            letterSelectorLayout2.K.setTextSize(letterSelectorLayout2.L);
            LetterSelectorLayout letterSelectorLayout3 = this.f2617a;
            letterSelectorLayout3.f2605z.setTextSize(letterSelectorLayout3.M);
            LetterSelectorLayout letterSelectorLayout4 = this.f2617a;
            letterSelectorLayout4.J.setTextSize(letterSelectorLayout4.N);
            this.f2617a.x0();
            return this;
        }

        public h r(int i10) {
            this.f2617a.f2580h0 = i10;
            this.f2617a.I.setColor(i10);
            return this;
        }

        public h s(int i10, int i11) {
            this.f2617a.f2567a0 = b(i11);
            return this;
        }

        public h t(Bitmap bitmap, int i10, int i11) {
            this.f2617a.f2586m0 = bitmap;
            this.f2617a.f2588n0 = b(i10);
            this.f2617a.f2589o0 = bitmap != null;
            return this;
        }

        public h u(long j10) {
            this.f2617a.P = j10;
            return this;
        }

        public h v(int i10) {
            this.f2617a.f2569b0 = b(i10);
            return this;
        }

        @Deprecated
        public h w(String[] strArr) {
            return x(strArr);
        }

        public h x(String[] strArr) {
            this.f2617a.T = Arrays.asList(strArr);
            this.f2617a.U.clear();
            LetterSelectorLayout letterSelectorLayout = this.f2617a;
            letterSelectorLayout.U.addAll(letterSelectorLayout.T);
            return this;
        }

        @Deprecated
        public h y(String[] strArr) {
            return x(strArr);
        }

        public h z(int i10, int i11, int i12) {
            this.f2617a.f2571c0 = b(i10);
            this.f2617a.f2573d0 = b(i11);
            this.f2617a.f2575e0 = b(i12);
            return this;
        }

        public h(LetterSelectorLayout letterSelectorLayout) {
            this.f2619c = true;
            this.f2617a = letterSelectorLayout;
            this.f2618b = letterSelectorLayout.getContext();
        }
    }

    public LetterSelectorLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f2601x = new DecelerateInterpolator();
        this.f2603y = new Paint(1);
        this.f2605z = new Paint(1);
        this.H = new Paint(1);
        this.I = new Paint(1);
        this.J = new Paint(1);
        this.K = new Paint(1);
        this.O = 200L;
        this.P = 1000L;
        this.Q = false;
        this.R = true;
        this.U = new ArrayList();
        this.V = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        this.W = 0.0f;
        this.f2580h0 = -16731411;
        this.f2582i0 = -1;
        this.f2583j0 = -8750470;
        this.f2585l0 = true;
        this.f2591p0 = new RectF();
        this.f2592q0 = true;
        this.f2593r0 = new RectF();
        this.f2594s0 = new RectF();
        this.f2595t0 = new ArrayMap<>();
        this.f2596u0 = new RectF();
        this.f2598v0 = new RectF();
        this.f2600w0 = new ArrayList();
        this.f2604y0 = -1;
        this.f2606z0 = new ArrayList();
        this.B0 = true;
        this.C0 = true;
        this.D0 = 1000;
        this.J0 = false;
        n0();
    }

    public final void d0() {
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.f2576f);
        }
        ValueAnimator valueAnimator = this.f2570c;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f2570c.cancel();
        }
        ValueAnimator valueAnimator2 = this.f2572d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f2572d.cancel();
        }
        ValueAnimator valueAnimator3 = this.f2574e;
        if (valueAnimator3 == null || !valueAnimator3.isRunning()) {
            return;
        }
        this.f2574e.cancel();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        ArrayList<String> arrayList;
        Bitmap bitmap;
        Bitmap bitmap2;
        super.draw(canvas);
        if (this.B0) {
            h.a aVar = this.I0;
            if ((aVar == null || aVar.b()) && this.f2600w0.size() > 0) {
                canvas.save();
                canvas.clipRect(this.f2598v0);
                for (int i10 = 0; i10 < this.f2600w0.size(); i10++) {
                    RectF rectF = this.f2600w0.get(i10);
                    g gVar = this.f2595t0.get(rectF);
                    if (gVar != null) {
                        String str = gVar.f2614b;
                        float fAscent = (this.f2603y.ascent() + this.f2603y.descent()) / 2.0f;
                        if ((str != null && str.equals(this.f2602x0)) || ((arrayList = this.f2584k0) != null && arrayList.contains(str))) {
                            if (!N0.equals(this.f2602x0) || (bitmap2 = this.f2599w) == null) {
                                canvas.drawText(this.f2602x0, rectF.centerX() - gVar.f2616d, rectF.centerY() - fAscent, this.K);
                            } else {
                                canvas.drawBitmap(bitmap2.extractAlpha(), rectF.centerX() - (this.f2599w.getWidth() / 2.0f), rectF.centerY() - (this.f2599w.getHeight() / 2.0f), this.K);
                            }
                            float fHeight = this.f2591p0.height();
                            this.f2591p0.top = rectF.centerY() - (fHeight / 2.0f);
                            RectF rectF2 = this.f2591p0;
                            rectF2.bottom = rectF2.top + fHeight;
                        } else if (!N0.equals(str) || (bitmap = this.f2599w) == null) {
                            canvas.drawText(str, rectF.centerX() - gVar.f2616d, rectF.centerY() - fAscent, this.f2603y);
                        } else {
                            canvas.drawBitmap(bitmap.extractAlpha(), rectF.centerX() - (this.f2599w.getWidth() / 2.0f), rectF.centerY() - (this.f2599w.getHeight() / 2.0f), this.f2603y);
                        }
                    }
                }
                canvas.restore();
                g0(canvas);
            }
        }
    }

    public final void e0() {
        boolean z10 = false;
        boolean z11 = getLayoutDirection() == 1;
        if ((z11 && this.R) || (!z11 && !this.R)) {
            z10 = true;
        }
        this.Q = z10;
    }

    public final int f0(int i10) {
        return (int) TypedValue.applyDimension(1, i10, getResources().getDisplayMetrics());
    }

    public final void g0(Canvas canvas) {
        Bitmap bitmap;
        if (TextUtils.isEmpty(this.f2602x0) || !this.f2587n) {
            return;
        }
        canvas.save();
        this.J.setAlpha(this.f2578g);
        this.I.setAlpha(this.f2578g);
        if (this.f2589o0) {
            float f10 = this.f2581i;
            canvas.scale(f10, f10, this.f2591p0.centerX(), this.f2591p0.centerY());
            canvas.drawBitmap(this.f2586m0.extractAlpha(), (Rect) null, this.f2591p0, this.I);
        } else {
            canvas.drawCircle(this.f2591p0.centerX(), this.f2591p0.centerY(), this.f2567a0, this.I);
        }
        canvas.save();
        float fMeasureText = this.J.measureText(this.f2602x0);
        float width = this.f2586m0.getWidth() - (this.E0 * 2);
        float f11 = fMeasureText > width ? width / fMeasureText : 1.0f;
        canvas.scale(f11, f11, this.f2591p0.centerX(), this.f2591p0.centerY());
        if (!N0.equals(this.f2602x0) || (bitmap = this.f2597v) == null) {
            canvas.drawText(this.f2602x0, this.f2591p0.centerX() - (fMeasureText / 2.0f), this.f2591p0.centerY() - ((this.J.ascent() + this.J.descent()) / 2.0f), this.J);
        } else {
            canvas.drawBitmap(bitmap.extractAlpha(), this.f2591p0.centerX() - (this.f2597v.getWidth() / 2.0f), this.f2591p0.centerY() - (this.f2597v.getHeight() / 2.0f), this.J);
        }
        canvas.restore();
        canvas.restore();
    }

    public int getPanelWidth() {
        return this.F0;
    }

    public h h0(boolean z10, boolean z11) {
        if (this.S == null) {
            this.S = new h(this);
        }
        this.R = z10;
        h hVar = this.S;
        hVar.f2619c = z11;
        return hVar;
    }

    public final float i0(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return paint.getTextSize() + (-(((fontMetrics.bottom - fontMetrics.top) - paint.getTextSize()) * 0.5f));
    }

    public final void j0(RectF rectF, g gVar) {
        if (gVar == null) {
            return;
        }
        int iIndexOf = this.f2606z0.indexOf(gVar);
        if (this.A0) {
            int iIndexOf2 = this.f2600w0.indexOf(rectF);
            int size = this.f2600w0.size();
            int size2 = this.f2606z0.size();
            int i10 = 0;
            if (iIndexOf2 == 0 && iIndexOf > 0) {
                int i11 = iIndexOf - 1;
                int i12 = 0;
                for (int i13 = i11; i13 < i11 + size; i13++) {
                    if (i12 < size && i13 < size2) {
                        this.f2595t0.put(this.f2600w0.get(i12), this.f2606z0.get(i13));
                    }
                    i12++;
                }
            }
            if (iIndexOf2 == size - 1 && iIndexOf < size2 - 1) {
                int iIndexOf3 = this.f2606z0.indexOf(this.f2595t0.get(this.f2600w0.get(0))) + 1;
                for (int i14 = iIndexOf3; i14 < size + iIndexOf3; i14++) {
                    if (i10 < size && i14 < size2) {
                        this.f2595t0.put(this.f2600w0.get(i10), this.f2606z0.get(i14));
                    }
                    i10++;
                }
            }
        }
        if (gVar.f2615c) {
            m0(gVar, 3);
            u0();
        }
    }

    public final void k0(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<RectF> it = this.f2600w0.iterator();
        while (it.hasNext()) {
            g gVar = this.f2595t0.get(it.next());
            if (gVar != null && str.equals(gVar.f2614b)) {
                return;
            }
        }
        int iIndexOf = this.U.indexOf(str);
        int size = this.f2606z0.size();
        int size2 = this.f2600w0.size();
        if (this.f2604y0 >= i10) {
            int i11 = 0;
            while (i11 < size2 && iIndexOf < size) {
                this.f2595t0.put(this.f2600w0.get(i11), this.f2606z0.get(iIndexOf));
                i11++;
                iIndexOf++;
            }
            return;
        }
        for (int i12 = size2 - 1; iIndexOf >= 0 && iIndexOf < size && i12 >= 0; i12--) {
            this.f2595t0.put(this.f2600w0.get(i12), this.f2606z0.get(iIndexOf));
            iIndexOf--;
        }
    }

    public final void l0() {
        h.a aVar = this.I0;
        if (aVar != null) {
            aVar.a(null, 0, 2, false);
        }
        this.J0 = false;
    }

    public final void m0(g gVar, int i10) {
        h.a aVar;
        if (gVar == null) {
            return;
        }
        String str = gVar.f2614b;
        if (str == null || str.equals(this.f2602x0)) {
            if (i10 != 1 || (aVar = this.I0) == null) {
                return;
            }
            aVar.a(str, gVar.f2613a, i10, gVar.f2615c);
            return;
        }
        setSelectedLetter(str);
        h.a aVar2 = this.I0;
        if (aVar2 != null) {
            aVar2.a(str, gVar.f2613a, i10, gVar.f2615c);
        }
    }

    public final void n0() {
        setWillNotDraw(false);
        setClickable(true);
        this.f2571c0 = f0(30);
        this.f2573d0 = f0(30);
        this.f2575e0 = f0(14);
        this.H0 = f0(4);
        this.L = y0(2, 10);
        this.M = y0(2, 40);
        this.N = y0(2, 30);
        this.f2567a0 = getContext().getResources().getDimensionPixelOffset(R.dimen.letter_indicator_radius);
        this.f2569b0 = f0(24);
        this.f2603y.setTextSize(this.L);
        this.f2603y.setColor(this.f2566a);
        Paint paint = this.f2603y;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.f2605z.setTextSize(this.M);
        this.f2605z.setColor(this.f2566a);
        this.K.setColor(this.f2583j0);
        this.K.setTextSize(this.L);
        this.J.setColor(this.f2582i0);
        this.J.setTextSize(this.N);
        this.I.setColor(v0(0.5f, this.f2580h0));
        this.I.setStyle(style);
        this.f2588n0 = f0(64);
        this.f2589o0 = this.f2586m0 != null;
        x0();
        o0();
        this.E0 = f0(3);
        this.G0 = f0(14);
    }

    public final void o0() {
        if (this.f2570c == null) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 200.0f);
            this.f2570c = valueAnimatorOfFloat;
            valueAnimatorOfFloat.setDuration(200L);
            this.f2570c.addUpdateListener(new a());
            this.f2570c.addListener(new b());
            this.f2570c.setInterpolator(new pj.c(0.2f, 0.0f, 0.1f, 1.0f));
        }
        if (this.f2572d == null) {
            ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(0.0f, 200.0f);
            this.f2572d = valueAnimatorOfFloat2;
            valueAnimatorOfFloat2.setDuration(200L);
            this.f2572d.addUpdateListener(new c());
            this.f2572d.addListener(new d());
            this.f2572d.setInterpolator(new pj.c(0.4f, 0.0f, 1.0f, 1.0f));
            this.f2576f = new e();
        }
        if (this.f2574e == null) {
            ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, 100.0f);
            this.f2574e = valueAnimatorOfFloat3;
            valueAnimatorOfFloat3.setDuration(150L);
            this.f2574e.addUpdateListener(new f());
            this.f2574e.setInterpolator(new pj.c(0.4f, 0.0f, 1.0f, 1.0f));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2595t0.clear();
        this.f2600w0.clear();
        this.f2606z0.clear();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (p0()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() != 0 || !w0(motionEvent.getX(), motionEvent.getY())) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        requestDisallowInterceptTouchEvent(true);
        return true;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.f2577f0 = i10;
        this.f2579g0 = i11;
        r0();
        invalidate();
    }

    /* JADX WARN: Code duplicated, block: B:43:0x009d  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        g gVar;
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2;
        RectF rectF;
        g gVar2;
        if (p0() || !this.B0) {
            if (this.J0) {
                l0();
            }
            return super.onTouchEvent(motionEvent);
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        if (motionEvent.getAction() == 0 && !w0(x10, y10)) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            requestDisallowInterceptTouchEvent(true);
            this.J0 = true;
            for (RectF rectF2 : this.f2600w0) {
                if (rectF2.contains(x10, y10) && (gVar = this.f2595t0.get(rectF2)) != null) {
                    if (!gVar.f2615c) {
                        h.a aVar = this.I0;
                        if (aVar == null) {
                            break;
                        }
                        aVar.a(null, 0, 1, false);
                        break;
                    }
                    m0(gVar, 1);
                    u0();
                    break;
                }
            }
        } else if (action == 1) {
            l0();
            valueAnimator = this.f2570c;
            if ((valueAnimator != null || !valueAnimator.isRunning()) && (valueAnimator2 = this.f2572d) != null && !valueAnimator2.isRunning()) {
                t0();
            }
        } else if (action == 2) {
            if (!this.f2596u0.contains(x10, y10)) {
                return true;
            }
            this.J0 = true;
            boolean zContains = this.f2593r0.contains(x10, y10);
            boolean zContains2 = this.f2594s0.contains(x10, y10);
            if (zContains || zContains2) {
                if (zContains) {
                    rectF = this.f2600w0.get(0);
                } else {
                    List<RectF> list = this.f2600w0;
                    rectF = list.get(list.size() - 1);
                }
                g gVar3 = this.f2595t0.get(rectF);
                if (gVar3 == null) {
                    return true;
                }
                j0(rectF, gVar3);
            } else {
                for (RectF rectF3 : this.f2600w0) {
                    if (rectF3.contains(x10, y10) && (gVar2 = this.f2595t0.get(rectF3)) != null) {
                        j0(rectF3, gVar2);
                    }
                }
            }
        } else if (action == 3) {
            l0();
            valueAnimator = this.f2570c;
            if (valueAnimator != null) {
                t0();
            } else {
                t0();
            }
        }
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z10) {
        super.onVisibilityAggregated(z10);
        if (getHandler() != null && this.f2576f != null) {
            getHandler().removeCallbacks(this.f2576f);
        }
        d0();
        this.f2587n = false;
        this.f2581i = 0.0f;
    }

    public final boolean p0() {
        h.a aVar;
        return this.f2606z0.size() == 0 || !(((aVar = this.I0) == null || aVar.b()) && this.B0);
    }

    public boolean q0() {
        return this.B0;
    }

    public final void r0() {
        List<String> list = this.U;
        if (list == null || list.size() == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        if (width == 0 || height == 0) {
            return;
        }
        if (this.f2577f0 != width) {
            this.f2577f0 = width;
        }
        if (this.f2579g0 != height) {
            this.f2579g0 = height;
        }
        this.f2595t0.clear();
        this.f2600w0.clear();
        this.f2606z0.clear();
        e0();
        int size = this.U.size();
        float fMax = 0.0f;
        for (int i10 = 0; i10 < size; i10++) {
            String str = this.U.get(i10);
            if (!TextUtils.isEmpty(str)) {
                g gVar = new g();
                gVar.f2613a = i10;
                gVar.f2614b = str;
                gVar.f2615c = this.T.contains(str);
                gVar.f2616d = this.f2603y.measureText(str) / 2.0f;
                this.f2606z0.add(gVar);
                fMax = Math.max(this.f2603y.measureText(str), fMax);
            }
        }
        int i11 = this.f2571c0;
        RectF rectF = new RectF();
        float f10 = i11;
        rectF.top = f10;
        int i12 = (this.f2575e0 * 2) + ((int) fMax);
        this.F0 = i12;
        rectF.bottom = f10 + this.G0;
        if (this.Q) {
            rectF.left = 0.0f;
            rectF.right = i12 + 0.0f;
        } else {
            float f11 = this.f2577f0;
            rectF.right = f11;
            rectF.left = f11 - i12;
        }
        float fHeight = rectF.height();
        if (fHeight == 0.0f) {
            return;
        }
        int size2 = this.U.size();
        boolean z10 = this.C0;
        if (z10) {
            this.f2573d0 = 0;
            i11 = 0;
        }
        int i13 = this.f2579g0;
        float f12 = (i13 - i11) - this.f2573d0;
        int i14 = z10 ? ((int) (f12 / fHeight)) - 2 : (int) (f12 / fHeight);
        if (i14 < 1) {
            return;
        }
        boolean z11 = size2 > i14;
        this.A0 = z11;
        if (z11) {
            size2 = i14;
        }
        if (z10) {
            int i15 = (int) ((i13 - (size2 * fHeight)) / 2.0f);
            if (i15 < 0) {
                i15 = 0;
            }
            this.f2573d0 = i15;
            float f13 = i15;
            rectF.top = f13;
            rectF.bottom = f13 + fHeight;
        }
        this.f2596u0.set(rectF);
        for (int i16 = 0; i16 < size2; i16++) {
            RectF rectF2 = new RectF(rectF.left, rectF.top, rectF.right, rectF.bottom);
            this.f2600w0.add(rectF2);
            float f14 = rectF.bottom;
            rectF.top = f14;
            rectF.bottom = f14 + fHeight;
            this.f2595t0.put(rectF2, this.f2606z0.get(i16));
        }
        RectF rectF3 = this.f2594s0;
        float f15 = rectF.left;
        float f16 = rectF.top;
        float f17 = fHeight * 2.0f;
        rectF3.set(f15, f16, rectF.right, f16 + f17);
        RectF rectF4 = this.f2596u0;
        rectF4.bottom = this.f2594s0.bottom;
        RectF rectF5 = this.f2593r0;
        float f18 = rectF.left;
        float f19 = rectF4.top;
        rectF5.set(f18, f19 - f17, rectF.right, f19);
        RectF rectF6 = this.f2596u0;
        float f20 = this.f2593r0.top;
        rectF6.top = f20;
        if (this.Q) {
            this.f2598v0.set(rectF6.left, f20, rectF6.right - this.H0, rectF6.bottom);
        } else {
            this.f2598v0.set(rectF6.left + this.H0, f20, rectF6.right, rectF6.bottom);
        }
        this.F0 = (int) this.f2598v0.width();
        if (this.f2600w0.size() <= 0) {
            return;
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.os_letter_bubble_size);
        float f21 = this.F0 + this.f2569b0;
        if (!this.Q) {
            f21 = (this.f2577f0 - f21) - dimensionPixelOffset;
        }
        float f22 = dimensionPixelOffset;
        this.f2591p0.set(f21, 0.0f, f21 + f22, f22);
    }

    public final void s0(boolean z10) {
        if (z10 == this.B0) {
            return;
        }
        this.B0 = z10;
        this.K.setAlpha(z10 ? 255 : 0);
        this.f2603y.setAlpha(this.B0 ? 255 : 0);
        this.H.setAlpha(this.B0 ? 255 : 0);
        this.f2605z.setAlpha(this.B0 ? 255 : 0);
        this.I.setAlpha(this.B0 ? 255 : 0);
        this.J.setAlpha(this.B0 ? 255 : 0);
        invalidate();
    }

    public void setSelectedLetter(String str) {
        int iIndexOf;
        if (this.U == null || str == null || str.equals(this.f2602x0) || (iIndexOf = this.U.indexOf(str)) < 0) {
            return;
        }
        if (this.A0) {
            k0(str, iIndexOf);
        }
        this.f2602x0 = str;
        this.f2604y0 = iIndexOf;
        invalidate();
    }

    public void setShowSelector(boolean z10) {
        this.B0 = z10;
    }

    @Override // io.github.inflationx.calligraphy3.HasTypeface
    public void setTypeface(Typeface typeface) {
        Paint paint = this.f2603y;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        Paint paint2 = this.f2605z;
        if (paint2 != null) {
            paint2.setTypeface(typeface);
        }
        Paint paint3 = this.H;
        if (paint3 != null) {
            paint3.setTypeface(typeface);
        }
        Paint paint4 = this.I;
        if (paint4 != null) {
            paint4.setTypeface(typeface);
        }
        Paint paint5 = this.J;
        if (paint5 != null) {
            paint5.setTypeface(typeface);
        }
        Paint paint6 = this.K;
        if (paint6 != null) {
            paint6.setTypeface(typeface);
        }
    }

    public final void t0() {
        d0();
        if (getHandler() == null || !this.f2587n) {
            return;
        }
        getHandler().postDelayed(this.f2576f, this.D0);
    }

    public final void u0() {
        ValueAnimator valueAnimator;
        if (getHandler() != null) {
            getHandler().removeCallbacks(this.f2576f);
        }
        ValueAnimator valueAnimator2 = this.f2572d;
        if (valueAnimator2 != null && valueAnimator2.isRunning()) {
            this.f2572d.cancel();
        }
        ValueAnimator valueAnimator3 = this.f2574e;
        if (valueAnimator3 != null && valueAnimator3.isRunning()) {
            this.f2574e.cancel();
        }
        if (this.f2581i == 1.0f || (valueAnimator = this.f2570c) == null || valueAnimator.isRunning()) {
            return;
        }
        this.f2570c.start();
        this.f2587n = true;
        this.f2590p = false;
    }

    public final int v0(float f10, int i10) {
        return Color.argb(((int) (f10 * 255.0f)) & 255, Color.red(i10), Color.green(i10), Color.blue(i10));
    }

    public final boolean w0(float f10, float f11) {
        return this.f2606z0.size() != 0 && this.f2600w0.size() != 0 && this.f2585l0 && this.f2596u0.contains(f10, f11);
    }

    public final void x0() {
        this.H.setTextSize(this.L);
        this.H.setTextSize(this.M);
        this.H.setTextSize(this.N);
    }

    public final int y0(int i10, int i11) {
        return (int) TypedValue.applyDimension(i10, i11, getResources().getDisplayMetrics());
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2613a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f2614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f2616d;

        public g() {
            this.f2615c = true;
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }

    public LetterSelectorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2601x = new DecelerateInterpolator();
        this.f2603y = new Paint(1);
        this.f2605z = new Paint(1);
        this.H = new Paint(1);
        this.I = new Paint(1);
        this.J = new Paint(1);
        this.K = new Paint(1);
        this.O = 200L;
        this.P = 1000L;
        this.Q = false;
        this.R = true;
        this.U = new ArrayList();
        this.V = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        this.W = 0.0f;
        this.f2580h0 = -16731411;
        this.f2582i0 = -1;
        this.f2583j0 = -8750470;
        this.f2585l0 = true;
        this.f2591p0 = new RectF();
        this.f2592q0 = true;
        this.f2593r0 = new RectF();
        this.f2594s0 = new RectF();
        this.f2595t0 = new ArrayMap<>();
        this.f2596u0 = new RectF();
        this.f2598v0 = new RectF();
        this.f2600w0 = new ArrayList();
        this.f2604y0 = -1;
        this.f2606z0 = new ArrayList();
        this.B0 = true;
        this.C0 = true;
        this.D0 = 1000;
        this.J0 = false;
        n0();
    }

    public LetterSelectorLayout(Context context) {
        super(context);
        this.f2601x = new DecelerateInterpolator();
        this.f2603y = new Paint(1);
        this.f2605z = new Paint(1);
        this.H = new Paint(1);
        this.I = new Paint(1);
        this.J = new Paint(1);
        this.K = new Paint(1);
        this.O = 200L;
        this.P = 1000L;
        this.Q = false;
        this.R = true;
        this.U = new ArrayList();
        this.V = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");
        this.W = 0.0f;
        this.f2580h0 = -16731411;
        this.f2582i0 = -1;
        this.f2583j0 = -8750470;
        this.f2585l0 = true;
        this.f2591p0 = new RectF();
        this.f2592q0 = true;
        this.f2593r0 = new RectF();
        this.f2594s0 = new RectF();
        this.f2595t0 = new ArrayMap<>();
        this.f2596u0 = new RectF();
        this.f2598v0 = new RectF();
        this.f2600w0 = new ArrayList();
        this.f2604y0 = -1;
        this.f2606z0 = new ArrayList();
        this.B0 = true;
        this.C0 = true;
        this.D0 = 1000;
        this.J0 = false;
        n0();
    }
}
