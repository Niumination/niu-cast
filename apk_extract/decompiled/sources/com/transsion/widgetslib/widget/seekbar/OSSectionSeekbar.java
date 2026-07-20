package com.transsion.widgetslib.widget.seekbar;

import a4.a;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.transsion.widgetslib.R$attr;
import com.transsion.widgetslib.R$color;
import com.transsion.widgetslib.R$styleable;
import ee.c;
import ee.d;
import ee.e;
import ee.f;
import java.lang.ref.WeakReference;
import java.math.BigDecimal;
import k3.z1;
import k3.z8;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pd.j;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001:\u0003H#@B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0006¢\u0006\u0004\b\u0013\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0018\u0010\u0011JQ\u0010!\u001a\u00020\f2B\u0010 \u001a>\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u001e0\u001d¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u0019¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0015\u0010(\u001a\u00020\f2\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0006H\u0002¢\u0006\u0004\b,\u0010+J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010+J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010+R$\u00104\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R$\u00107\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R$\u0010:\u001a\u00020\n2\u0006\u0010/\u001a\u00020\n8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\"\u0010?\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010+\"\u0004\b>\u0010\u0011R$\u0010A\u001a\u0004\u0018\u00010@8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bG\u0010+¨\u0006I"}, d2 = {"Lcom/transsion/widgetslib/widget/seekbar/OSSectionSeekbar;", "Landroid/view/View;", "Landroid/content/Context;", "mContext", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "progress", "", "setProgress", "(F)V", "trackColor", "setTrackColor", "(I)V", "secondTrackColor", "setSecondTrackColor", "thumbColor", "setThumbOutColor", "setThumbInsideColor", "thumbInsideUnAbleColorHios", "setThumbInsideUnAbleColorHios", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "sectionCount", "Landroid/util/SparseArray;", "", "array", "onCustomize", "setCustomSectionTextArray", "(Lkotlin/jvm/functions/Function2;)V", "Lee/d;", "getConfigBuilder", "()Lee/d;", "", "vibrateAble", "setVibrateAble", "(Z)V", "getDotColor", "()I", "getThumbInsideColor", "getThumbOutColor", "getSecondTrackColor", "<set-?>", "c", "F", "getMin", "()F", "min", "d", "getMax", "max", "e", "getProgressFloat", "progressFloat", "h", "I", "getMFinalProgress", "setMFinalProgress", "mFinalProgress", "Lee/e;", "onProgressChangedListener", "Lee/e;", "getOnProgressChangedListener", "()Lee/e;", "setOnProgressChangedListener", "(Lee/e;)V", "getProgress", "k3/z1", "widgetsLib_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSSectionSeekbar.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSSectionSeekbar.kt\ncom/transsion/widgetslib/widget/seekbar/OSSectionSeekbar\n+ 2 SparseArray.kt\nandroidx/core/util/SparseArrayKt\n*L\n1#1,1308:1\n56#2:1309\n*S KotlinDebug\n*F\n+ 1 OSSectionSeekbar.kt\ncom/transsion/widgetslib/widget/seekbar/OSSectionSeekbar\n*L\n201#1:1309\n*E\n"})
public class OSSectionSeekbar extends View {
    public static final /* synthetic */ int p0 = 0;
    public final int A;
    public final boolean B;
    public float C;
    public float D;
    public int E;
    public float F;
    public float G;
    public float H;
    public boolean I;
    public SparseArray J;
    public float K;
    public float L;
    public float M;
    public final Paint N;
    public final Paint O;
    public final Rect P;
    public final Rect Q;
    public d R;
    public final int S;
    public final int T;
    public final int U;
    public final int V;
    public boolean W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3547a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ValueAnimator f3548a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3549b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public float f3550b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public float min;
    public float c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public float max;
    public float d0;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public float progressFloat;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public float f3553e0;
    public boolean f0;
    public float g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name and from kotlin metadata */
    public int mFinalProgress;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public float f3555h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f3556i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final float f3557i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f3558j;
    public float j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f3559k;
    public float k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f3560l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public float f3561l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3562m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public boolean f3563m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3564n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final c f3565n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f3566o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public boolean f3567o0;
    public final int p;
    public final int q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f3568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f3569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f3570t;
    public int u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f3571v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f3572w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3573x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3574y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3575z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSectionSeekbar(Context mContext) {
        this(mContext, null, 6, 0);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    private final int getDotColor() {
        return isEnabled() ? this.f3573x : this.V;
    }

    private final int getSecondTrackColor() {
        return isEnabled() ? this.f3570t : this.S;
    }

    private final int getThumbInsideColor() {
        return isEnabled() ? this.f3571v : this.U;
    }

    private final int getThumbOutColor() {
        return isEnabled() ? this.u : this.T;
    }

    public final float a(float f) {
        float f4 = this.L;
        if (f <= f4) {
            return f4;
        }
        float f10 = this.M;
        if (f >= f10) {
            return f10;
        }
        float f11 = 0.0f;
        int i8 = 0;
        while (i8 <= this.f3562m) {
            float f12 = this.H;
            f11 = (i8 * f12) + this.L;
            if (f11 <= f && f - f11 <= f12) {
                break;
            }
            i8++;
        }
        float f13 = f - f11;
        float f14 = this.H;
        return f13 <= f14 / 2.0f ? f11 : ((i8 + 1) * f14) + this.L;
    }

    public final int b(float f) {
        return Math.round(((f - this.min) / this.C) * this.f3562m);
    }

    public final float c(float f) {
        return j.v() ? (((this.M - f) * this.C) / this.G) + this.min : (((f - this.L) * this.C) / this.G) + this.min;
    }

    public final ValueAnimator d() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimator.addUpdateListener(new a(this, 1));
        valueAnimator.addListener(new f(this, 0));
        Intrinsics.checkNotNullExpressionValue(valueAnimator, "valueAnimator");
        return valueAnimator;
    }

    public final void e() {
        int i8;
        if (this.min == this.max) {
            this.min = 0.0f;
            this.max = 100.0f;
        }
        float f = this.min;
        float f4 = this.max;
        if (f > f4) {
            this.max = f;
            this.min = f4;
        }
        float f10 = this.progressFloat;
        float f11 = this.min;
        if (f10 < f11) {
            this.progressFloat = f11;
        }
        float f12 = this.progressFloat;
        float f13 = this.max;
        if (f12 > f13) {
            this.progressFloat = f13;
        }
        int i9 = this.f3559k;
        int i10 = this.f3558j;
        if (i9 < i10) {
            this.f3559k = z1.a(2) + i10;
        }
        int i11 = this.f3564n;
        int i12 = this.f3559k;
        if (i11 <= i12) {
            this.f3564n = z1.a(4) + i12;
        }
        int i13 = this.f3566o;
        int i14 = this.f3564n;
        if (i13 < i14) {
            this.f3566o = z1.a(6) + i14;
        }
        if (this.f3562m <= 0) {
            this.f3562m = 10;
        }
        float f14 = this.max - this.min;
        this.C = f14;
        int i15 = this.f3562m;
        float f15 = f14 / i15;
        this.D = f15;
        if (f15 < 1.0f) {
            this.f3556i = true;
        }
        if (this.f3575z < 1) {
            this.f3575z = 1;
        }
        int i16 = 0;
        boolean z2 = this.f3575z > 1 && i15 % 2 == 0;
        if (this.B && this.J.size() == 0 && (i8 = this.f3562m) >= 0) {
            while (true) {
                float f16 = (this.D * i16) + this.min;
                if (!z2 || i16 % this.f3575z == 0) {
                    this.J.put(i16, this.f3556i ? String.valueOf(BigDecimal.valueOf(f16).setScale(1, 4).floatValue()) : String.valueOf((int) f16));
                }
                if (i16 == i8) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        setProgress(this.progressFloat);
    }

    public final void f() {
        if (!this.f3567o0) {
            z8.f(null, "vibrate Able is false");
            return;
        }
        if (j.f8781w && getHandler() != null && j.f8772k) {
            Handler handler = getHandler();
            c cVar = this.f3565n0;
            if (handler.hasCallbacks(cVar)) {
                return;
            }
            getHandler().postDelayed(cVar, 50L);
        }
    }

    public final void g(float f, float f4, long j8, boolean z2) {
        this.W = true;
        ValueAnimator valueAnimator = this.f3548a0;
        if (valueAnimator == null) {
            this.f3548a0 = d();
        } else {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.f3548a0;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
                this.f3548a0 = d();
            }
        }
        ValueAnimator valueAnimator3 = this.f3548a0;
        Intrinsics.checkNotNull(valueAnimator3);
        valueAnimator3.setDuration(j8);
        this.f3550b0 = f;
        this.c0 = f4;
        this.d0 = this.f3553e0;
        this.f0 = z2;
        this.f3555h0 = this.g0;
        ValueAnimator valueAnimator4 = this.f3548a0;
        if (valueAnimator4 != null) {
            valueAnimator4.setInterpolator(z2 ? new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f) : new LinearInterpolator());
            valueAnimator4.start();
        }
    }

    public d getConfigBuilder() {
        int color;
        if (this.R == null) {
            d dVar = new d();
            dVar.C = new WeakReference(this);
            dVar.f4851a = 0.0f;
            dVar.f4852b = 100.0f;
            dVar.f4853c = 0.0f;
            int i8 = R$attr.os_seekbar_section_thumb_in_color;
            int i9 = R$color.os_color_white100;
            Context context = this.f3547a;
            dVar.f4866t = j.e(context, i8, i9);
            dVar.f = j.f(R$attr.os_seekbar_section_track_width, z1.a(3), context);
            dVar.f4855g = j.f(R$attr.os_seekbar_section_second_track_width, z1.a(3), context);
            dVar.f4863o = j.f(R$attr.os_seekbar_section_dot_size, z1.a(6), context);
            dVar.f4856h = (int) TypedValue.applyDimension(2, 12, Resources.getSystem().getDisplayMetrics());
            dVar.f4858j = j.f(R$attr.os_seekbar_section_text_top_margin, z1.a(11), context);
            dVar.f4859k = 0;
            dVar.f4860l = z1.a(3);
            dVar.f4861m = j.f(R$attr.os_seekbar_section_thumb_in_width, z1.a(8), context);
            dVar.f4862n = j.f(R$attr.os_seekbar_section_thumb_out_width, z1.a(14), context);
            dVar.f4857i = j.f(R$attr.os_seekbar_section_t_track_width, z1.a(22), context);
            dVar.p = 5;
            dVar.f4854d = false;
            dVar.e = true;
            dVar.q = j.d(R$attr.os_fill_weaker, context.getColor(R$color.os_fill_weaker_hios), context);
            dVar.f4864r = j.d(R$attr.os_platform_basic_color, context.getColor(R$color.os_platform_basic_color_hios), context);
            dVar.f4865s = j.d(R$attr.os_platform_basic_color, context.getColor(R$color.os_platform_basic_color_hios), context);
            dVar.u = j.d(R$attr.os_text_info, context.getColor(R$color.os_text_info_hios), context);
            dVar.f4867v = j.d(R$attr.os_grayfill_strong, context.getColor(R$color.os_grayfill_strong_hios), context);
            if (j.f8765b) {
                color = context.getResources().getColor(R$color.os_color_white30, context.getTheme());
            } else {
                TypedValue typedValue = new TypedValue();
                color = context.getTheme().resolveAttribute(R$attr.os_platform_basic_color, typedValue, true) ? ContextCompat.getColor(context, typedValue.resourceId) : ContextCompat.getColor(context, R$color.os_platform_basic_color_hios);
            }
            dVar.f4868w = color;
            int iD = j.d(R$attr.os_grayfill_base, context.getColor(R$color.os_grayfill_base_hios), context);
            dVar.f4870y = iD;
            dVar.f4871z = iD;
            dVar.A = j.d(R$attr.os_seekbar_section_thumb_in_disable_color, context.getColor(R$color.os_comp_color_switch_hios), context);
            dVar.B = j.d(R$attr.os_seekbar_section_dot_disable_color, context.getColor(R$color.os_grayfill_strong_hios), context);
            this.R = dVar;
        }
        d dVar2 = this.R;
        Intrinsics.checkNotNull(dVar2);
        return dVar2;
    }

    public final int getMFinalProgress() {
        return this.mFinalProgress;
    }

    public final float getMax() {
        return this.max;
    }

    public final float getMin() {
        return this.min;
    }

    public final e getOnProgressChangedListener() {
        return null;
    }

    public final int getProgress() {
        return Math.round(this.progressFloat);
    }

    public final float getProgressFloat() {
        return this.progressFloat;
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Handler handler = getHandler();
        c cVar = this.f3565n0;
        if (handler.hasCallbacks(cVar)) {
            handler.removeCallbacks(cVar);
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float fB;
        float fB2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        boolean z2 = j.f8765b;
        Paint paint = this.O;
        Paint paint2 = this.N;
        if (!z2) {
            float paddingTop = (this.f3566o * 0.5f) + getPaddingTop() + this.A;
            paint2.setColor(this.f3574y);
            paint2.setTextSize(this.f3560l);
            float f = this.L;
            float f4 = this.M;
            float fHeight = (this.f3566o * 0.5f) + paddingTop + this.A + this.p + this.P.height();
            if (!this.I) {
                if (j.v()) {
                    fB = f4 - ((this.progressFloat - this.min) * (this.G / this.C));
                } else {
                    fB = a1.a.b(this.progressFloat, this.min, this.G / this.C, f);
                }
                this.F = fB;
            }
            paint2.setColor(getSecondTrackColor());
            paint2.setStrokeWidth(this.f3559k);
            if (j.v()) {
                canvas.drawLine(this.F, paddingTop, f4, paddingTop, paint2);
            } else {
                canvas.drawLine(f, paddingTop, this.F, paddingTop, paint2);
            }
            paint2.setColor(this.f3569s);
            paint2.setStrokeWidth(this.f3558j);
            if (j.v()) {
                canvas.drawLine(f, paddingTop, this.F, paddingTop, paint2);
            } else {
                canvas.drawLine(this.F, paddingTop, f4, paddingTop, paint2);
            }
            int i8 = this.f3562m;
            if (i8 >= 0) {
                int i9 = 0;
                while (true) {
                    float f10 = j.v() ? f4 - (i9 * this.H) : (i9 * this.H) + f;
                    if (i9 > this.E || !isEnabled()) {
                        paint2.setColor(this.f3572w);
                    } else {
                        paint2.setColor(this.f3573x);
                    }
                    canvas.drawCircle(f10, paddingTop, this.f3568r * 0.5f, paint2);
                    paint2.setColor(this.f3574y);
                    if (this.J.get(j.v() ? this.f3562m - i9 : i9, null) != null && this.B) {
                        canvas.drawText((String) this.J.get(i9), f10, fHeight, paint2);
                    }
                    if (i9 == i8) {
                        break;
                    } else {
                        i9++;
                    }
                }
            }
            paint.setColor(getThumbOutColor());
            paint.setStyle(Paint.Style.STROKE);
            int i10 = this.f3566o;
            int i11 = this.f3564n;
            float f11 = (i10 - i11) * 0.5f;
            float f12 = i11 >> 1;
            paint.setStrokeWidth(f11);
            canvas.drawCircle(this.F, paddingTop, (0.5f * f11) + f12, paint);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(getThumbInsideColor());
            canvas.drawCircle(this.F, paddingTop, f12, paint);
            return;
        }
        float paddingTop2 = (this.f3566o * 0.5f) + getPaddingTop() + this.A;
        paint2.setColor(this.f3574y);
        paint2.setTextSize(this.f3560l);
        float f13 = this.L;
        int i12 = this.f3566o;
        float f14 = i12 / 2;
        float f15 = this.f3553e0 / 2;
        float f16 = f15 + (f13 - f14);
        float f17 = (this.M + f14) - f15;
        float fAbs = Math.abs(paint2.getFontMetrics().ascent) + (i12 * 0.5f) + paddingTop2 + this.A + this.p;
        if (!this.I && !this.W) {
            if (j.v()) {
                fB2 = this.M - ((this.progressFloat - this.min) * (this.G / this.C));
            } else {
                fB2 = a1.a.b(this.progressFloat, this.min, this.G / this.C, this.L);
            }
            this.F = fB2;
        }
        paint2.setColor(this.f3569s);
        paint2.setStrokeWidth(this.f3553e0);
        canvas.drawLine(f16, paddingTop2, f17, paddingTop2, paint2);
        paint2.setColor(getSecondTrackColor());
        paint2.setStrokeWidth(this.f3553e0);
        if (j.v()) {
            canvas.drawLine(this.F, paddingTop2, f17, paddingTop2, paint2);
        } else {
            canvas.drawLine(f16, paddingTop2, this.F, paddingTop2, paint2);
        }
        int i13 = this.f3562m;
        if (i13 >= 0) {
            int i14 = 0;
            while (true) {
                float f18 = j.v() ? this.M - (i14 * this.H) : this.L + (i14 * this.H);
                if (!j.v() ? f18 >= this.F + (this.f3566o / 2) : f18 <= this.F - (this.f3566o / 2)) {
                    paint2.setColor(getDotColor());
                } else {
                    paint2.setColor(this.f3572w);
                }
                canvas.drawCircle(f18, paddingTop2, this.f3568r * 0.5f, paint2);
                paint2.setColor(this.f3574y);
                if (this.J.get(j.v() ? this.f3562m - i14 : i14, null) != null && this.B) {
                    canvas.drawText((String) this.J.get(i14), f18, fAbs, paint2);
                }
                if (i14 == i13) {
                    break;
                } else {
                    i14++;
                }
            }
        }
        paint.setColor(getThumbOutColor());
        float f19 = this.g0;
        if (f19 > 0.0f) {
            canvas.drawCircle(this.F, paddingTop2, ((f19 * 0.1f) + 0.9f) * (this.f3566o / 2), paint);
        }
        paint.setStyle(Paint.Style.FILL);
        int thumbInsideColor = getThumbInsideColor();
        paint.setColor((thumbInsideColor & ViewCompat.MEASURED_SIZE_MASK) | (((int) ((thumbInsideColor >>> 24) * this.g0)) << 24));
        canvas.drawCircle(this.F, paddingTop2, (this.f3564n / 2) * this.g0, paint);
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        float fontSpacing;
        super.onMeasure(i8, i9);
        int paddingBottom = getPaddingBottom() + (this.A * 2) + getPaddingTop() + this.f3566o;
        int size = this.J.size();
        Paint paint = this.N;
        if (size == 0) {
            fontSpacing = 0.0f;
        } else {
            fontSpacing = paint.getFontSpacing();
            int size2 = this.J.size();
            for (int i10 = 0; i10 < size2; i10++) {
                String str = (String) this.J.get(i10);
                int length = str.length();
                Rect rect = this.Q;
                paint.getTextBounds(str, 0, length, rect);
                fontSpacing = Math.max(fontSpacing, rect.height());
            }
        }
        if (this.B) {
            paddingBottom += this.p + ((int) fontSpacing) + this.q;
        }
        setMeasuredDimension(View.resolveSize(z1.a(180), i8), paddingBottom);
        int i11 = this.f3566o / 2;
        this.L = getPaddingLeft() + i11;
        this.M = (getMeasuredWidth() - getPaddingRight()) - i11;
        paint.setTextSize(this.f3560l);
        int size3 = this.J.size();
        Rect rect2 = this.P;
        if (size3 > 0) {
            rect2.set(0, 0, 0, 0);
            String str2 = (String) this.J.get(0);
            if (!TextUtils.isEmpty(str2)) {
                paint.getTextBounds(str2, 0, str2.length(), rect2);
            }
        }
        double d7 = i11;
        this.L = (float) Math.max(d7, rect2.width() / 2.0f);
        if (this.J.size() != this.f3562m + 1) {
            rect2.set(0, 0, 0, 0);
            String str3 = (String) this.J.get(this.f3562m);
            if (!TextUtils.isEmpty(str3)) {
                paint.getTextBounds(str3, 0, str3.length(), rect2);
            }
        }
        float measuredWidth = getMeasuredWidth() - ((float) Math.max(d7, rect2.width() / 2.0f));
        this.M = measuredWidth;
        float f = measuredWidth - this.L;
        this.G = f;
        this.H = (f * 1.0f) / this.f3562m;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(state instanceof Bundle)) {
            super.onRestoreInstanceState(state);
            return;
        }
        Bundle bundle = (Bundle) state;
        float f = bundle.getFloat("progress");
        this.progressFloat = f;
        this.E = b(f);
        super.onRestoreInstanceState(bundle.getParcelable("save_instance"));
        setProgress(this.progressFloat);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("save_instance", super.onSaveInstanceState());
        bundle.putFloat("progress", this.progressFloat);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        post(new c(this, 0));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b0 A[PHI: r4
      0x00b0: PHI (r4v11 float) = (r4v9 float), (r4v10 float) binds: [B:37:0x00ae, B:40:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:49:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:58:0x00f9 A[PHI: r3
      0x00f9: PHI (r3v19 float) = (r3v17 float), (r3v18 float) binds: [B:57:0x00f7, B:60:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:63:0x0105  */
    /* JADX WARN: Code duplicated, block: B:65:0x0109  */
    /* JADX WARN: Code duplicated, block: B:67:0x0115 A[PHI: r3
      0x0115: PHI (r3v16 float) = (r3v14 float), (r3v15 float) binds: [B:66:0x0113, B:69:0x011b] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:68:0x0117  */
    /* JADX WARN: Code duplicated, block: B:71:0x011e  */
    /* JADX WARN: Code duplicated, block: B:73:0x0127  */
    /* JADX WARN: Code duplicated, block: B:75:0x0139 A[PHI: r0
      0x0139: PHI (r0v45 float) = (r0v42 float), (r0v43 float) binds: [B:74:0x0137, B:77:0x013f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:76:0x013b  */
    /* JADX WARN: Code duplicated, block: B:85:0x017d  */
    /* JADX WARN: Code duplicated, block: B:87:0x018a  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:91:0x01bd  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        int iB;
        float f;
        float f4;
        float x2;
        float f10;
        float f11;
        boolean z2;
        float f12;
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            performClick();
            getParent().requestDisallowInterceptTouchEvent(true);
            boolean zIsEnabled = isEnabled();
            this.I = zIsEnabled;
            this.f3563m0 = false;
            if (zIsEnabled) {
                if (j.f8765b) {
                    float x8 = event.getX();
                    this.k0 = x8;
                    this.f3561l0 = x8;
                    Math.abs(event.getX() - this.F);
                    float f13 = this.F;
                    g(f13, f13, 200L, false);
                    float fC = c(this.F);
                    this.progressFloat = fC;
                    this.E = b(fC);
                } else {
                    float fA = a(event.getX());
                    this.K = fA;
                    this.F = fA;
                    float fC2 = c(fA);
                    this.progressFloat = fC2;
                    this.E = b(fC2);
                    invalidate();
                }
            }
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.I = false;
            if (j.f8765b) {
                iB = b(c(event.getX()));
                float fA2 = a(event.getX());
                float fC3 = c(fA2);
                this.progressFloat = fC3;
                this.mFinalProgress = Math.round(fC3);
                if (this.E != iB) {
                    this.E = iB;
                    f();
                }
                g(this.F, fA2, 250L, true);
            } else {
                this.mFinalProgress = Math.round(this.progressFloat);
                f();
            }
        } else if (actionMasked == 2) {
            boolean zIsEnabled2 = isEnabled();
            this.I = zIsEnabled2;
            if (zIsEnabled2) {
                if (!j.f8765b) {
                    float fA3 = a(event.getX());
                    if (fA3 != this.K) {
                        this.K = fA3;
                        this.F = fA3;
                        float fC4 = c(fA3);
                        this.progressFloat = fC4;
                        this.E = b(fC4);
                        invalidate();
                        f();
                    }
                } else if (((float) Math.abs(event.getX() - this.f3561l0)) > ((int) TypedValue.applyDimension(1, 1, Resources.getSystem().getDisplayMetrics()))) {
                    this.j0 = event.getX();
                    float fA4 = a(event.getX());
                    boolean z3 = !j.v() ? event.getX() - fA4 > ((float) (this.f3566o / 2)) || event.getX() - fA4 < 0.0f : event.getX() - fA4 < ((float) ((-this.f3566o) / 2)) || event.getX() - fA4 > 0.0f;
                    int iB2 = b(c(event.getX()));
                    if (iB2 == this.E || (!((z2 = this.f3563m0) && z3) && z2)) {
                        ValueAnimator valueAnimator = this.f3548a0;
                        if (valueAnimator != null) {
                            Intrinsics.checkNotNull(valueAnimator);
                            if (valueAnimator.isRunning()) {
                                float x10 = event.getX();
                                float f14 = this.L;
                                if (x10 < f14) {
                                    x10 = f14;
                                } else {
                                    f14 = this.M;
                                    if (x10 > f14) {
                                        x10 = f14;
                                    }
                                }
                                this.c0 = x10;
                            } else if (this.f3563m0) {
                                f = this.F + (((this.j0 - this.k0) * 2) / 3);
                                f4 = this.L;
                                if (f < f4) {
                                    f = f4;
                                } else {
                                    f4 = this.M;
                                    if (f > f4) {
                                        f = f4;
                                    }
                                }
                                this.F = f;
                                this.progressFloat = c(f);
                                invalidate();
                            } else {
                                float f15 = this.F;
                                x2 = event.getX();
                                f10 = this.L;
                                if (x2 < f10) {
                                    f11 = f10;
                                } else {
                                    f10 = this.M;
                                    if (x2 > f10) {
                                        f11 = f10;
                                    } else {
                                        f11 = x2;
                                    }
                                }
                                g(f15, f11, 200L, false);
                            }
                        } else if (this.f3563m0) {
                            float f16 = this.F;
                            x2 = event.getX();
                            f10 = this.L;
                            if (x2 < f10) {
                                f11 = f10;
                            } else {
                                f10 = this.M;
                                if (x2 > f10) {
                                    f11 = f10;
                                } else {
                                    f11 = x2;
                                }
                            }
                            g(f16, f11, 200L, false);
                        } else {
                            f = this.F + (((this.j0 - this.k0) * 2) / 3);
                            f4 = this.L;
                            if (f < f4) {
                                f = f4;
                            } else {
                                f4 = this.M;
                                if (f > f4) {
                                    f = f4;
                                }
                            }
                            this.F = f;
                            this.progressFloat = c(f);
                            invalidate();
                        }
                    } else {
                        if (z2) {
                            f12 = fA4;
                        } else {
                            float x11 = event.getX();
                            float f17 = this.L;
                            if (x11 < f17) {
                                x11 = f17;
                            } else {
                                f17 = this.M;
                                if (x11 > f17) {
                                    x11 = f17;
                                }
                            }
                            f12 = x11;
                        }
                        this.progressFloat = c(fA4);
                        this.E = iB2;
                        ValueAnimator valueAnimator2 = this.f3548a0;
                        if (valueAnimator2 != null) {
                            Intrinsics.checkNotNull(valueAnimator2);
                            if (valueAnimator2.isRunning()) {
                                this.c0 = f12;
                            } else {
                                g(this.F, f12, 200L, false);
                            }
                        } else {
                            g(this.F, f12, 200L, false);
                        }
                        f();
                    }
                    this.k0 = this.j0;
                    this.f3563m0 = true;
                }
            }
        } else if (actionMasked == 3) {
            getParent().requestDisallowInterceptTouchEvent(false);
            this.I = false;
            if (j.f8765b) {
                iB = b(c(event.getX()));
                float fA5 = a(event.getX());
                float fC5 = c(fA5);
                this.progressFloat = fC5;
                this.mFinalProgress = Math.round(fC5);
                if (this.E != iB) {
                    this.E = iB;
                    f();
                }
                g(this.F, fA5, 250L, true);
            } else {
                this.mFinalProgress = Math.round(this.progressFloat);
                f();
            }
        }
        return this.I || super.onTouchEvent(event);
    }

    public final void setCustomSectionTextArray(Function2<? super Integer, ? super SparseArray<String>, ? extends SparseArray<String>> onCustomize) {
        Intrinsics.checkNotNullParameter(onCustomize, "onCustomize");
        this.J = onCustomize.invoke(Integer.valueOf(this.f3562m), this.J);
        int i8 = this.f3562m;
        if (i8 >= 0) {
            int i9 = 0;
            while (true) {
                if (this.J.get(i9) == null) {
                    this.J.put(i9, "");
                }
                if (i9 == i8) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        requestLayout();
        invalidate();
    }

    public final void setMFinalProgress(int i8) {
        this.mFinalProgress = i8;
    }

    public final void setOnProgressChangedListener(e eVar) {
    }

    public final void setProgress(float progress) {
        float fRound = (Math.round((progress / this.C) * this.f3562m) * this.C) / this.f3562m;
        this.progressFloat = fRound;
        this.E = b(fRound);
        postInvalidate();
    }

    public final void setSecondTrackColor(int secondTrackColor) {
        if (this.f3570t != secondTrackColor) {
            this.f3570t = secondTrackColor;
            invalidate();
        }
    }

    public final void setThumbInsideColor(int thumbColor) {
        if (this.f3571v != thumbColor) {
            this.f3571v = thumbColor;
            invalidate();
        }
    }

    @Deprecated(message = "new version deprecated")
    public final void setThumbInsideUnAbleColorHios(int thumbInsideUnAbleColorHios) {
    }

    public final void setThumbOutColor(int thumbColor) {
        if (this.u != thumbColor) {
            this.u = thumbColor;
            invalidate();
        }
    }

    public final void setTrackColor(int trackColor) {
        if (this.f3569s != trackColor) {
            this.f3569s = trackColor;
            invalidate();
        }
    }

    public final void setVibrateAble(boolean vibrateAble) {
        this.f3567o0 = vibrateAble;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSectionSeekbar(Context mContext, AttributeSet attributeSet) {
        this(mContext, attributeSet, 4, 0);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
    }

    public /* synthetic */ OSSectionSeekbar(Context context, AttributeSet attributeSet, int i8, int i9) {
        this(context, (i8 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSSectionSeekbar(Context mContext, AttributeSet attributeSet, int i8) {
        OSSectionSeekbar oSSectionSeekbar;
        super(mContext, attributeSet, i8);
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.f3547a = mContext;
        this.f3549b = "OSSectionSeekbar";
        this.J = new SparseArray();
        this.g0 = 1.0f;
        this.f3555h0 = 1.0f;
        this.f3565n0 = new c(this, 1);
        this.f3567o0 = true;
        d builder = getConfigBuilder();
        WeakReference weakReference = builder.C;
        if (weakReference != null && (oSSectionSeekbar = (OSSectionSeekbar) weakReference.get()) != null) {
            Intrinsics.checkNotNullParameter(builder, "builder");
            oSSectionSeekbar.min = builder.getMin();
            oSSectionSeekbar.max = builder.getMax();
            oSSectionSeekbar.progressFloat = builder.getProgress();
            oSSectionSeekbar.f3556i = builder.getFloatType();
            oSSectionSeekbar.f3558j = builder.getTrackSize();
            oSSectionSeekbar.f3553e0 = builder.getTrackSize();
            oSSectionSeekbar.f3557i0 = builder.getTrackSizeMax();
            oSSectionSeekbar.f3559k = builder.getSecondTrackSize();
            oSSectionSeekbar.f3564n = builder.getThumbInWidth();
            oSSectionSeekbar.f3566o = builder.getThumbOutWidth();
            oSSectionSeekbar.f3568r = builder.getDotsSize();
            oSSectionSeekbar.p = builder.getTextTopMargin();
            oSSectionSeekbar.q = builder.getTextBottomMargin();
            oSSectionSeekbar.A = builder.getProcessMarginTopBottow();
            oSSectionSeekbar.f3569s = builder.getTrackColor();
            oSSectionSeekbar.f3570t = builder.getSecondTrackColor();
            oSSectionSeekbar.u = builder.getThumbOutColor();
            oSSectionSeekbar.f3571v = builder.getThumbInsideColor();
            oSSectionSeekbar.f3572w = builder.getDotsColor();
            oSSectionSeekbar.f3573x = builder.getDotsSelectedColor();
            oSSectionSeekbar.f3562m = builder.getSectionCount();
            oSSectionSeekbar.f3560l = builder.getSectionTextSize();
            oSSectionSeekbar.f3574y = builder.getSectionTextColor();
            oSSectionSeekbar.f3575z = builder.getSectionTextInterval();
            oSSectionSeekbar.B = builder.getDisplayCharacters();
            oSSectionSeekbar.e();
            oSSectionSeekbar.R = null;
            oSSectionSeekbar.S = builder.getSecondTrackColorDisable();
            oSSectionSeekbar.T = builder.getThumbOutColorDisable();
            oSSectionSeekbar.U = builder.getThumbInsideColorDisable();
            oSSectionSeekbar.V = builder.getDotsSelectedColorDisable();
            oSSectionSeekbar.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes = mContext.obtainStyledAttributes(attributeSet, R$styleable.OSSectionSeekbar, i8, 0);
        Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "mContext.obtainStyledAtt…Seekbar, defStyleAttr, 0)");
        this.min = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSSectionSeekbar_osSectionSeekbarMin, 0.0f);
        this.max = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSSectionSeekbar_osSectionSeekbarMax, 100.0f);
        float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.OSSectionSeekbar_osSectionSeekbarProgress, this.min);
        this.progressFloat = f;
        this.E = b(f);
        this.f3562m = typedArrayObtainStyledAttributes.getInteger(R$styleable.OSSectionSeekbar_osSectionSeekbarSectionCount, 5);
        this.B = typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSectionSeekbar_osSectionSeekbarDisplayCharacters, true);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(R$styleable.OSSectionSeekbar_android_enabled, isEnabled()));
        typedArrayObtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.N = paint;
        paint.setAntiAlias(true);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        Paint.Align align = Paint.Align.CENTER;
        paint.setTextAlign(align);
        Paint paint2 = new Paint();
        this.O = paint2;
        paint2.setAntiAlias(true);
        paint2.setStrokeCap(cap);
        paint2.setTextAlign(align);
        this.P = new Rect();
        this.Q = new Rect();
        z1.a(2);
        e();
    }
}
