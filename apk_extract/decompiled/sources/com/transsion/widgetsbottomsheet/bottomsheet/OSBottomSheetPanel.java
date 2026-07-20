package com.transsion.widgetsbottomsheet.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.PathInterpolator;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.transsion.widgetsbottomsheet.R$attr;
import com.transsion.widgetsbottomsheet.R$color;
import com.transsion.widgetsbottomsheet.R$dimen;
import com.transsion.widgetsbottomsheet.R$id;
import com.transsion.widgetsbottomsheet.bottomsheet.OSBottomSheetPanel;
import com.transsion.widgetslib.R$bool;
import gd.g;
import gd.h;
import gd.k;
import gd.l;
import gd.q;
import hd.a;
import k3.z8;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import md.f;
import pd.j;
import u8.b;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\b\b\u0001\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0019\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0013R(\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010'\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010+\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0015\u001a\u0004\b)\u0010\u0017\"\u0004\b*\u0010\u0013R\"\u0010/\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010\u0015\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010\u0013R\"\u00105\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\nR\"\u00109\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00101\u001a\u0004\b7\u00103\"\u0004\b8\u0010\nR\"\u0010=\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u00101\u001a\u0004\b;\u00103\"\u0004\b<\u0010\nR\u001b\u0010A\u001a\u00020\u00028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010\u001eR\u001b\u0010F\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bC\u0010?\u001a\u0004\bD\u0010ER\"\u0010J\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bG\u0010\u0015\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0013R(\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00100K8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010P¨\u0006R"}, d2 = {"Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBottomSheetPanel;", "Landroid/widget/LinearLayout;", "Landroid/view/View;", "outsideView", "", "setOutsideView", "(Landroid/view/View;)V", "", "visible", "setDragHandleVisibility", "(Z)V", "supportGesture", "setSupportGesture", "Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "getDialog", "()Lcom/transsion/widgetsbottomsheet/bottomsheet/OSBaseBottomSheetDialog;", "", TypedValues.Custom.S_COLOR, "setBackgroundFillColor", "(I)V", "e", "I", "getMPanelVisibleHeight", "()I", "setMPanelVisibleHeight", "mPanelVisibleHeight", "<set-?>", "j", "Landroid/view/View;", "getMOutsideView", "()Landroid/view/View;", "mOutsideView", "", "t", "J", "getMCustomEnterDuration", "()J", "setMCustomEnterDuration", "(J)V", "mCustomEnterDuration", "u", "getMCustomContentMaxHeight", "setMCustomContentMaxHeight", "mCustomContentMaxHeight", "v", "getMCustomTopMargin", "setMCustomTopMargin", "mCustomTopMargin", "w", "Z", "getMCanDown", "()Z", "setMCanDown", "mCanDown", "x", "getMCanUp", "setMCanUp", "mCanUp", "B", "getMFixedHeight", "setMFixedHeight", "mFixedHeight", "C", "Lkotlin/Lazy;", "getMDragRect", "mDragRect", "Landroid/view/ViewGroup;", ExifInterface.LONGITUDE_EAST, "getMPanelContent", "()Landroid/view/ViewGroup;", "mPanelContent", "F", "getSoftKeyboardHeight", "setSoftKeyboardHeight", "softKeyboardHeight", "Landroidx/lifecycle/MutableLiveData;", "Landroidx/lifecycle/MutableLiveData;", "getLivePanelWidth", "()Landroidx/lifecycle/MutableLiveData;", "setLivePanelWidth", "(Landroidx/lifecycle/MutableLiveData;)V", "livePanelWidth", "widgetsbottomsheet_release"}, k = 1, mv = {1, 8, 0}, xi = ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@SourceDebugExtension({"SMAP\nOSBottomSheetPanel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OSBottomSheetPanel.kt\ncom/transsion/widgetsbottomsheet/bottomsheet/OSBottomSheetPanel\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,687:1\n350#2:688\n*S KotlinDebug\n*F\n+ 1 OSBottomSheetPanel.kt\ncom/transsion/widgetsbottomsheet/bottomsheet/OSBottomSheetPanel\n*L\n326#1:688\n*E\n"})
public final class OSBottomSheetPanel extends LinearLayout {
    public static final PathInterpolator K = new PathInterpolator(0.01f, 0.0f, 0.0f, 1.0f);
    public static final PathInterpolator L = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    public static final PathInterpolator M = new PathInterpolator(0.33f, 0.0f, 0.66f, 1.0f);
    public static final PathInterpolator N = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    public final float A;

    /* JADX INFO: renamed from: B, reason: from kotlin metadata */
    public boolean mFixedHeight;

    /* JADX INFO: renamed from: C, reason: from kotlin metadata */
    public final Lazy mDragRect;
    public boolean D;

    /* JADX INFO: renamed from: E, reason: from kotlin metadata */
    public final Lazy mPanelContent;

    /* JADX INFO: renamed from: F, reason: from kotlin metadata */
    public int softKeyboardHeight;
    public int G;
    public boolean H;
    public int I;

    /* JADX INFO: renamed from: J, reason: from kotlin metadata */
    public MutableLiveData livePanelWidth;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f2995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ValueAnimator f2996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ValueAnimator f2997c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SpringAnimation f2998d;

    /* JADX INFO: renamed from: e, reason: from kotlin metadata */
    public int mPanelVisibleHeight;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OSBaseBottomSheetDialog f2999h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g f3000i;

    /* JADX INFO: renamed from: j, reason: collision with root package name and from kotlin metadata */
    public View mOutsideView;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f3002k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public float f3003l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f3004m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f3005n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3006o;
    public float p;
    public float q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f3007r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3008s;

    /* JADX INFO: renamed from: t, reason: collision with root package name and from kotlin metadata */
    public long mCustomEnterDuration;

    /* JADX INFO: renamed from: u, reason: from kotlin metadata */
    public int mCustomContentMaxHeight;

    /* JADX INFO: renamed from: v, reason: collision with root package name and from kotlin metadata */
    public int mCustomTopMargin;

    /* JADX INFO: renamed from: w, reason: collision with root package name and from kotlin metadata */
    public boolean mCanDown;

    /* JADX INFO: renamed from: x, reason: collision with root package name and from kotlin metadata */
    public boolean mCanUp;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3013y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public View f3014z;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSBottomSheetPanel(Context context) {
        this(context, null, 0, 14);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final View getMDragRect() {
        Object value = this.mDragRect.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mDragRect>(...)");
        return (View) value;
    }

    private final ViewGroup getMPanelContent() {
        Object value = this.mPanelContent.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-mPanelContent>(...)");
        return (ViewGroup) value;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0031  */
    /* JADX WARN: Code duplicated, block: B:19:0x007f  */
    /* JADX WARN: Code duplicated, block: B:21:0x0089  */
    /* JADX WARN: Code duplicated, block: B:22:0x009d  */
    /* JADX WARN: Code duplicated, block: B:25:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:8:0x001d  */
    public final int a() {
        int i8;
        int dimensionPixelOffset;
        View view;
        if (j.t(getContext()) && !j.u(getContext())) {
            getContext();
            if (j.s()) {
                if (j.r(getContext())) {
                }
                Context context = getContext();
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                i8 = displayMetrics.heightPixels;
            } else {
                i8 = j.i(getContext());
            }
        } else if (!j.r(getContext()) || j.A(getContext())) {
            Context context2 = getContext();
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics2);
            i8 = displayMetrics2.heightPixels;
        } else {
            i8 = j.i(getContext());
        }
        if (j.t(getContext())) {
            getContext();
            if (!j.s()) {
                dimensionPixelOffset = getContext().getResources().getDimensionPixelOffset(R$dimen.os_bottom_sheet_large_margin_bottom_normal) + j.l(getContext());
            } else if (j.w(getContext())) {
                dimensionPixelOffset = j.l(getContext()) - a.a(getContext(), 4);
            } else {
                dimensionPixelOffset = this.mCustomTopMargin;
                if (dimensionPixelOffset <= 0) {
                    dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_bottom_sheet_margin_top_normal);
                }
            }
        } else if (j.w(getContext())) {
            dimensionPixelOffset = j.l(getContext()) - a.a(getContext(), 4);
        } else {
            dimensionPixelOffset = this.mCustomTopMargin;
            if (dimensionPixelOffset <= 0) {
                dimensionPixelOffset = getResources().getDimensionPixelOffset(R$dimen.os_bottom_sheet_margin_top_normal);
            }
        }
        int i9 = i8 - dimensionPixelOffset;
        getContext();
        if (!j.f8768g) {
            int i10 = i9 - this.softKeyboardHeight;
            ViewGroup.LayoutParams layoutParams = getMPanelContent().getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            return i10 - (marginLayoutParams != null ? marginLayoutParams.topMargin : 0);
        }
        if (!this.f3013y) {
            return i9;
        }
        int i11 = j.i(getContext());
        int height = this.softKeyboardHeight - (i11 - getMPanelContent().getHeight());
        View view2 = this.f3014z;
        ViewGroup.LayoutParams layoutParams2 = view2 != null ? view2.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
        View view3 = this.f3014z;
        if (view3 != null) {
            if (height <= 0 || this.softKeyboardHeight <= this.I) {
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = 0;
                }
                view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), view3.getPaddingRight(), 0);
            } else {
                view3.setPadding(view3.getPaddingLeft(), view3.getPaddingTop(), view3.getPaddingRight(), height);
                if (marginLayoutParams2 != null) {
                    marginLayoutParams2.topMargin = -height;
                }
            }
        }
        int i12 = this.softKeyboardHeight;
        this.I = i12;
        if (i12 <= 0) {
            return i9;
        }
        View view4 = this.f3014z;
        View viewFindFocus = view4 != null ? view4.findFocus() : null;
        if (viewFindFocus == null) {
            return i9;
        }
        int[] iArr = new int[2];
        viewFindFocus.getLocationOnScreen(iArr);
        int height2 = viewFindFocus.getHeight() + (iArr[1] - (i11 - this.softKeyboardHeight));
        if (height2 <= 0 || (view = this.f3014z) == null) {
            return i9;
        }
        view.setScrollY(view.getScrollY() + height2);
        return i9;
    }

    public final float b(float f) {
        float f4 = this.A;
        return RangesKt.coerceAtMost(RangesKt.coerceAtLeast(0.0f, f4 - ((f4 / this.mPanelVisibleHeight) * f)), 1.0f);
    }

    public final void c() {
        final float translationY = getTranslationY();
        float f = this.mPanelVisibleHeight;
        final float f4 = f - translationY;
        float fMax = Math.max(100.0f, (200.0f / f) * f4);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.setDuration(Math.round(fMax));
        valueAnimatorOfFloat.setInterpolator(N);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: gd.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator animation) {
                PathInterpolator pathInterpolator = OSBottomSheetPanel.K;
                OSBottomSheetPanel this$0 = this;
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = (((Float) animatedValue).floatValue() * f4) + translationY;
                View view = this$0.mOutsideView;
                if (view != null) {
                    view.setAlpha(this$0.b(fFloatValue));
                }
                this$0.setTranslationY(fFloatValue);
            }
        });
        valueAnimatorOfFloat.addListener(new gd.j(this, 2));
        valueAnimatorOfFloat.start();
    }

    public final void d() {
        if (this.H) {
            return;
        }
        getContext();
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        int i8 = this.G;
        float dimension = getContext().getResources().getDimension(R$dimen.os_radius_xxxl);
        f fVar = new f();
        Color.parseColor("#FE945F");
        fVar.f8017b = rectF;
        fVar.f8018c = dimension;
        fVar.e = true;
        Paint paint = new Paint();
        fVar.f8016a = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i8);
        if (fVar.f8019d == null) {
            fVar.f8019d = new b();
        }
        setBackground(fVar);
    }

    /* JADX INFO: renamed from: getDialog, reason: from getter */
    public final OSBaseBottomSheetDialog getF2999h() {
        return this.f2999h;
    }

    public final MutableLiveData<Integer> getLivePanelWidth() {
        return this.livePanelWidth;
    }

    public final boolean getMCanDown() {
        return this.mCanDown;
    }

    public final boolean getMCanUp() {
        return this.mCanUp;
    }

    public final int getMCustomContentMaxHeight() {
        return this.mCustomContentMaxHeight;
    }

    public final long getMCustomEnterDuration() {
        return this.mCustomEnterDuration;
    }

    public final int getMCustomTopMargin() {
        return this.mCustomTopMargin;
    }

    public final boolean getMFixedHeight() {
        return this.mFixedHeight;
    }

    public final View getMOutsideView() {
        return this.mOutsideView;
    }

    public final int getMPanelVisibleHeight() {
        return this.mPanelVisibleHeight;
    }

    public final int getSoftKeyboardHeight() {
        return this.softKeyboardHeight;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (j.t(getContext()) && getContext().getResources().getBoolean(R$bool.os_flag_refs_pad_value)) {
            getContext();
            if (j.s()) {
                return;
            }
            post(new g(this, 1));
        }
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.H != j.a(getContext())) {
            this.H = !this.H;
            invalidate();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (this.f3000i == null) {
            super.onDraw(canvas);
            return;
        }
        setVisibility(8);
        post(this.f3000i);
        this.f3000i = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (!this.D) {
            return false;
        }
        boolean zOnInterceptTouchEvent = super.onInterceptTouchEvent(ev);
        int action = ev.getAction();
        SpringAnimation springAnimation = this.f2998d;
        if (action == 0) {
            float rawY = ev.getRawY();
            this.f3003l = rawY;
            this.f3005n = rawY;
            this.f3004m = ev.getRawX();
            this.f3006o = false;
            this.f3013y = false;
            if (!springAnimation.isRunning()) {
                return zOnInterceptTouchEvent;
            }
            springAnimation.cancel();
            return zOnInterceptTouchEvent;
        }
        if (action != 1) {
            if (action == 2) {
                this.f3005n = ev.getRawY();
                float rawX = ev.getRawX();
                if (!this.f3006o) {
                    float f = rawX - this.f3004m;
                    this.p = f;
                    this.q = Math.abs(f);
                    float f4 = this.f3005n - this.f3003l;
                    this.f3007r = f4;
                    float fAbs = Math.abs(f4);
                    if (this.p != 0.0f || this.f3007r != 0.0f) {
                        float f10 = this.q;
                        float f11 = this.f3002k;
                        if (f10 >= f11 || fAbs >= f11) {
                            this.f3006o = true;
                            this.f3008s = fAbs > f10;
                            View view = this.f3014z;
                            if (view != null) {
                                Intrinsics.checkNotNull(view);
                                this.mCanUp = view.canScrollVertically(1);
                                View view2 = this.f3014z;
                                Intrinsics.checkNotNull(view2);
                                this.mCanDown = view2.canScrollVertically(-1);
                            }
                        }
                    }
                    return zOnInterceptTouchEvent;
                }
                if (this.f3013y) {
                    if (this.f3014z == null || !this.f3008s) {
                        return zOnInterceptTouchEvent;
                    }
                    boolean z2 = this.mCanDown;
                    if (z2 || this.mCanUp) {
                        if (z2 && this.mCanUp) {
                            return zOnInterceptTouchEvent;
                        }
                        if (z2) {
                            if (this.f3007r >= 0.0f) {
                                return zOnInterceptTouchEvent;
                            }
                        } else if (this.f3007r <= 0.0f) {
                            return zOnInterceptTouchEvent;
                        }
                    }
                } else if (!this.f3008s) {
                    return zOnInterceptTouchEvent;
                }
                return true;
            }
            if (action != 3) {
                return zOnInterceptTouchEvent;
            }
        }
        if (this.f3006o || getTranslationY() == 0.0f) {
            return zOnInterceptTouchEvent;
        }
        springAnimation.animateToFinalPosition(0.0f);
        return zOnInterceptTouchEvent;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i8, int i9, int i10, int i11) {
        super.onLayout(z2, i8, i9, i10, i11);
        if (this.mPanelVisibleHeight == -1) {
            this.f3000i = new g(this, 0);
            return;
        }
        this.mPanelVisibleHeight = getHeight() - getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_pull_rect);
        d();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00be  */
    /* JADX WARN: Code duplicated, block: B:40:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:41:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:52:0x010d  */
    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i8, int i9) {
        int i10;
        boolean z2;
        float f;
        int iMin;
        View viewFindViewById;
        Integer numValueOf;
        getContext();
        if (j.s() && (viewFindViewById = findViewById(R$id.pull_rect)) != null) {
            boolean zM = j.m(getContext());
            boolean zQ = j.q(getContext());
            if (zM && zQ) {
                numValueOf = Integer.valueOf(R$dimen.os_ultra_small_embedded_bottom_sheet_pull_rect_gesture);
            } else if (zM) {
                numValueOf = Integer.valueOf(R$dimen.os_ultra_small_embedded_bottom_sheet_pull_rect);
            } else {
                numValueOf = !zQ ? Integer.valueOf(R$dimen.os_ultra_small_bottom_sheet_pull_rect) : null;
            }
            if (numValueOf != null) {
                int iIntValue = numValueOf.intValue();
                ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = getResources().getDimensionPixelSize(iIntValue);
                }
            }
        }
        int i11 = getResources().getDisplayMetrics().widthPixels;
        OSBaseBottomSheetDialog oSBaseBottomSheetDialog = this.f2999h;
        Intrinsics.checkNotNull(oSBaseBottomSheetDialog);
        if (j.y(oSBaseBottomSheetDialog.getWindow()) || j.r(getContext()) || j.A(getContext()) || j.z(getContext())) {
            if (j.t(getContext()) && (!j.r(getContext()) || j.m(getContext()) || j.u(getContext()))) {
                getContext();
                if (!j.s()) {
                    getContext();
                    z2 = j.f8768g;
                    if (z2) {
                        f = 0.7f;
                    } else {
                        f = 0.72f;
                    }
                    if (j.w(getContext()) && getContext().getResources().getBoolean(R$bool.os_flag_refs_pad_value)) {
                        getContext();
                        if (j.s()) {
                            i11 = j.i(getContext()) * 2;
                        } else {
                            i11 = j.i(getContext());
                        }
                    }
                    int i12 = (int) (i11 * f);
                    int i13 = i11;
                    iMin = i12;
                    getContext();
                    if (z2) {
                        iMin = Math.min(iMin, getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_panel_max_width));
                    }
                    i10 = iMin;
                    i11 = i13;
                }
            }
            i10 = i11;
        } else {
            getContext();
            z2 = j.f8768g;
            if (z2) {
                f = 0.7f;
            } else {
                f = 0.72f;
            }
            if (j.w(getContext())) {
                getContext();
                if (j.s()) {
                    i11 = j.i(getContext());
                } else {
                    i11 = j.i(getContext()) * 2;
                }
            }
            int i14 = (int) (i11 * f);
            int i15 = i11;
            iMin = i14;
            getContext();
            if (z2) {
                iMin = Math.min(iMin, getResources().getDimensionPixelSize(R$dimen.os_bottom_sheet_panel_max_width));
            }
            i10 = iMin;
            i11 = i15;
        }
        z8.d("OSBottomSheetPanel", "onMeasure, screenWidth: " + i11 + ", widthPixels: " + i10);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10, BasicMeasure.EXACTLY);
        if (!this.mFixedHeight) {
            getMPanelContent().getLayoutParams().height = -2;
        }
        measureChild(getMPanelContent(), iMakeMeasureSpec, i9);
        int iA = this.mCustomContentMaxHeight;
        if (iA <= 0) {
            iA = a();
        }
        if (getMPanelContent().getMeasuredHeight() >= iA || this.mCustomTopMargin > 0) {
            ViewGroup mPanelContent = getMPanelContent();
            ViewGroup.LayoutParams layoutParams2 = getMPanelContent().getLayoutParams();
            layoutParams2.height = iA;
            mPanelContent.setLayoutParams(layoutParams2);
        } else if (this.mFixedHeight) {
            getMPanelContent().getLayoutParams().height = getMPanelContent().getMeasuredHeight();
        }
        super.onMeasure(iMakeMeasureSpec, i9);
        this.livePanelWidth.setValue(Integer.valueOf(i10));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View target, float f, float f4, boolean z2) {
        Intrinsics.checkNotNullParameter(target, "target");
        return super.onNestedFling(target, f, f4, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View target, float f, float f4) {
        Intrinsics.checkNotNullParameter(target, "target");
        return super.onNestedPreFling(target, f, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View target, int i8, int i9, int[] consumed) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        super.onNestedPreScroll(target, i8, i9, consumed);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View target, int i8, int i9, int i10, int i11) {
        Intrinsics.checkNotNullParameter(target, "target");
        super.onNestedScroll(target, i8, i9, i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View child, View target, int i8) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        super.onNestedScrollAccepted(child, target, i8);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View child, View target, int i8) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.f3013y = true;
        this.f3014z = target;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View child) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.onStopNestedScroll(child);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:59:0x0116  */
    /* JADX WARN: Code duplicated, block: B:62:0x011f  */
    /* JADX WARN: Code duplicated, block: B:63:0x0123  */
    /* JADX WARN: Code duplicated, block: B:65:0x012b  */
    /* JADX WARN: Code duplicated, block: B:68:0x0130  */
    /* JADX WARN: Code duplicated, block: B:70:0x0138  */
    /* JADX WARN: Code duplicated, block: B:72:0x013c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0147  */
    /* JADX WARN: Code duplicated, block: B:77:0x014c  */
    /* JADX WARN: Code duplicated, block: B:79:0x0154  */
    /* JADX WARN: Code duplicated, block: B:80:0x0158  */
    /* JADX WARN: Code duplicated, block: B:83:0x015d  */
    /* JADX WARN: Code duplicated, block: B:87:0x0168  */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent event) {
        float translationY;
        float fAbs;
        SpringAnimation springAnimation;
        VelocityTracker velocityTracker;
        float fA;
        Intrinsics.checkNotNullParameter(event, "event");
        q qVar = this.f2995a;
        if (qVar != null) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (qVar.f5163j) {
                if (qVar.f5161h == null) {
                    VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                    qVar.f5161h = velocityTrackerObtain;
                    if (velocityTrackerObtain != null) {
                        velocityTrackerObtain.clear();
                    }
                }
                VelocityTracker velocityTracker2 = qVar.f5161h;
                Intrinsics.checkNotNull(velocityTracker2);
                velocityTracker2.addMovement(event);
                int action = event.getAction();
                OSBottomSheetPanel oSBottomSheetPanel = qVar.f5156a;
                if (action != 0) {
                    float f = qVar.e;
                    if (action == 1) {
                        qVar.f5164k = false;
                        event.getRawY();
                        translationY = oSBottomSheetPanel.getTranslationY();
                        VelocityTracker velocityTracker3 = qVar.f5161h;
                        Intrinsics.checkNotNull(velocityTracker3);
                        velocityTracker3.computeCurrentVelocity(1000, qVar.f5162i);
                        VelocityTracker velocityTracker4 = qVar.f5161h;
                        Intrinsics.checkNotNull(velocityTracker4);
                        fAbs = Math.abs(velocityTracker4.getYVelocity());
                        if (qVar.f5159d < 0.0f) {
                            fAbs *= -1.0f;
                        }
                        if (fAbs > 200.0f) {
                            oSBottomSheetPanel.c();
                        } else {
                            springAnimation = oSBottomSheetPanel.f2998d;
                            if (fAbs < -200.0f) {
                                springAnimation.setStartVelocity(j.f8769h ? 0.0f : fAbs);
                                springAnimation.animateToFinalPosition(f);
                            } else if (translationY > f) {
                                springAnimation.setStartVelocity(j.f8769h ? 0.0f : fAbs);
                                springAnimation.animateToFinalPosition(f);
                            } else if (translationY - f < qVar.f5160g / 2.0f) {
                                springAnimation.setStartVelocity(j.f8769h ? 0.0f : fAbs);
                                springAnimation.animateToFinalPosition(f);
                            } else {
                                oSBottomSheetPanel.c();
                            }
                        }
                        velocityTracker = qVar.f5161h;
                        if (velocityTracker != null) {
                            velocityTracker.clear();
                            velocityTracker.recycle();
                        }
                        qVar.f5161h = null;
                    } else if (action != 2) {
                        if (action == 3) {
                            qVar.f5164k = false;
                            event.getRawY();
                            translationY = oSBottomSheetPanel.getTranslationY();
                            VelocityTracker velocityTracker5 = qVar.f5161h;
                            Intrinsics.checkNotNull(velocityTracker5);
                            velocityTracker5.computeCurrentVelocity(1000, qVar.f5162i);
                            VelocityTracker velocityTracker6 = qVar.f5161h;
                            Intrinsics.checkNotNull(velocityTracker6);
                            fAbs = Math.abs(velocityTracker6.getYVelocity());
                            if (qVar.f5159d < 0.0f) {
                                fAbs *= -1.0f;
                            }
                            if (fAbs > 200.0f) {
                                oSBottomSheetPanel.c();
                            } else {
                                springAnimation = oSBottomSheetPanel.f2998d;
                                if (fAbs < -200.0f) {
                                    springAnimation.setStartVelocity(j.f8769h ? 0.0f : fAbs);
                                    springAnimation.animateToFinalPosition(f);
                                } else if (translationY > f) {
                                    springAnimation.setStartVelocity(j.f8769h ? 0.0f : fAbs);
                                    springAnimation.animateToFinalPosition(f);
                                } else if (translationY - f < qVar.f5160g / 2.0f) {
                                    springAnimation.setStartVelocity(j.f8769h ? 0.0f : fAbs);
                                    springAnimation.animateToFinalPosition(f);
                                } else {
                                    oSBottomSheetPanel.c();
                                }
                            }
                            velocityTracker = qVar.f5161h;
                            if (velocityTracker != null) {
                                velocityTracker.clear();
                                velocityTracker.recycle();
                            }
                            qVar.f5161h = null;
                        }
                    } else if (qVar.f5164k) {
                        float rawY = event.getRawY();
                        qVar.f5157b = rawY;
                        float f4 = rawY - qVar.f5158c;
                        qVar.f5159d = f4;
                        if (f4 != 0.0f) {
                            qVar.f += f4;
                            float translationY2 = oSBottomSheetPanel.getTranslationY();
                            float f10 = qVar.f5159d;
                            float fA2 = translationY2 + f10;
                            if (j.f8769h) {
                                if (fA2 >= f) {
                                    f = fA2;
                                }
                                fA2 = f;
                            } else if (f10 < 0.0f) {
                                if (translationY2 > f && fA2 < f) {
                                    float fAbs2 = Math.abs(fA2 - f);
                                    fA2 = (translationY2 - Math.abs(qVar.f5159d - fAbs2)) - q.a(qVar.f, fAbs2);
                                } else if (translationY2 < f) {
                                    fA = q.a(qVar.f, f10);
                                    fA2 = fA + translationY2;
                                }
                            } else if (translationY2 < f && fA2 > f) {
                                float fAbs3 = Math.abs(fA2 - f);
                                fA2 = translationY2 + fAbs3 + q.a(qVar.f, Math.abs(qVar.f5159d - fAbs3));
                            } else if (translationY2 < f) {
                                fA = q.a(qVar.f, f10);
                                fA2 = fA + translationY2;
                            }
                            oSBottomSheetPanel.setTranslationY(fA2);
                            View view = oSBottomSheetPanel.mOutsideView;
                            if (view != null) {
                                view.setAlpha(oSBottomSheetPanel.b(fA2));
                            }
                            qVar.f5158c = qVar.f5157b;
                        }
                    } else {
                        qVar.f5158c = event.getRawY();
                        qVar.f5159d = 0.0f;
                        qVar.f = 0.0f;
                        qVar.f5160g = oSBottomSheetPanel.getMPanelVisibleHeight();
                        qVar.f5164k = true;
                    }
                } else {
                    qVar.f5158c = event.getRawY();
                    qVar.f5159d = 0.0f;
                    qVar.f = 0.0f;
                    qVar.f5160g = oSBottomSheetPanel.getMPanelVisibleHeight();
                    qVar.f5164k = true;
                }
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        super.requestDisallowInterceptTouchEvent(z2);
        if (getTranslationY() == 0.0f) {
            return;
        }
        this.f2998d.animateToFinalPosition(0.0f);
    }

    public final void setBackgroundFillColor(@ColorInt int color) {
        this.G = color;
    }

    public void setDragHandleVisibility(boolean visible) {
        if (visible) {
            getMDragRect().setVisibility(0);
            ViewGroup.LayoutParams layoutParams = getMPanelContent().getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = (int) getContext().getResources().getDimension(R$dimen.os_bottom_sheet_handle_height);
            return;
        }
        getMDragRect().setVisibility(8);
        ViewGroup.LayoutParams layoutParams2 = getMPanelContent().getLayoutParams();
        Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) getContext().getResources().getDimension(R$dimen.os_space100);
    }

    public final void setLivePanelWidth(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.livePanelWidth = mutableLiveData;
    }

    public final void setMCanDown(boolean z2) {
        this.mCanDown = z2;
    }

    public final void setMCanUp(boolean z2) {
        this.mCanUp = z2;
    }

    public final void setMCustomContentMaxHeight(int i8) {
        this.mCustomContentMaxHeight = i8;
    }

    public final void setMCustomEnterDuration(long j8) {
        this.mCustomEnterDuration = j8;
    }

    public final void setMCustomTopMargin(int i8) {
        this.mCustomTopMargin = i8;
    }

    public final void setMFixedHeight(boolean z2) {
        this.mFixedHeight = z2;
    }

    public final void setMPanelVisibleHeight(int i8) {
        this.mPanelVisibleHeight = i8;
    }

    public final void setOutsideView(View outsideView) {
        Intrinsics.checkNotNullParameter(outsideView, "outsideView");
        this.mOutsideView = outsideView;
    }

    public final void setSoftKeyboardHeight(int i8) {
        this.softKeyboardHeight = i8;
    }

    public final void setSupportGesture(boolean supportGesture) {
        this.D = supportGesture;
        q qVar = this.f2995a;
        if (qVar == null) {
            return;
        }
        qVar.f5163j = supportGesture;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSBottomSheetPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 12);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OSBottomSheetPanel(Context context, AttributeSet attributeSet, int i8) {
        this(context, attributeSet, i8, 8);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public OSBottomSheetPanel(Context context, AttributeSet attributeSet, int i8, int i9) {
        attributeSet = (i9 & 2) != 0 ? null : attributeSet;
        boolean z2 = false;
        i8 = (i9 & 4) != 0 ? 0 : i8;
        Intrinsics.checkNotNullParameter(context, "context");
        super(context, attributeSet, i8, 0);
        this.mPanelVisibleHeight = -1;
        this.A = 0.2f;
        this.mDragRect = LazyKt.lazy(new k(this));
        this.D = true;
        this.mPanelContent = LazyKt.lazy(new l(this));
        this.f3002k = ViewConfiguration.get(context).getScaledTouchSlop();
        SpringAnimation springAnimation = new SpringAnimation(this, DynamicAnimation.TRANSLATION_Y);
        this.f2998d = springAnimation;
        springAnimation.setSpring(new SpringForce().setStiffness(400.0f).setDampingRatio(1.2f));
        springAnimation.addUpdateListener(new h(this, 0));
        setOrientation(1);
        this.A = a.c(context) ? 0.6f : 0.2f;
        setWillNotDraw(false);
        j.z(context);
        this.G = j.d(R$attr.os_open_bg, context.getColor(R$color.os_open_bg_hios), context);
        if (j.t(context) && !j.s() && (!j.r(context) || j.m(context) || j.u(context))) {
            z2 = true;
        }
        this.H = z2;
        this.livePanelWidth = new MutableLiveData();
    }
}
