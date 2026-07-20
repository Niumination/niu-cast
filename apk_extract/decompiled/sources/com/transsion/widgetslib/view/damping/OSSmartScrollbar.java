package com.transsion.widgetslib.view.damping;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Property;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.widgetslib.R$styleable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import k3.z8;
import kd.a;
import kd.b;
import r2.w;

/* JADX INFO: loaded from: classes2.dex */
public class OSSmartScrollbar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f3238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f3239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f3240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public PathMeasure f3241d;
    public Path e;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Path f3242h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f3243i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f3244j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3245k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3246l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3247m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ObjectAnimator f3248n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewGroup f3249o;
    public final w p;

    public OSSmartScrollbar(@NonNull Context context) {
        super(context);
        this.f3249o = null;
        this.p = new w(this, 1);
        d(null);
    }

    public static int e(String str) {
        Method declaredMethod;
        try {
            declaredMethod = View.class.getDeclaredMethod(str, null);
        } catch (NoSuchMethodException e) {
            z8.c("OSSmartScrollbar", "get declared method error !", e);
            declaredMethod = null;
        }
        if (declaredMethod == null) {
            return 0;
        }
        declaredMethod.setAccessible(true);
        try {
            Object objInvoke = declaredMethod.invoke(null, null);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
            return 0;
        } catch (IllegalAccessException | InvocationTargetException e4) {
            z8.c("OSSmartScrollbar", "invoke method error !", e4);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollExtent() {
        return e("computeVerticalScrollExtent");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollOffset() {
        return e("computeVerticalScrollOffset");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getScrollRange() {
        return e("computeVerticalScrollRange");
    }

    public final void d(AttributeSet attributeSet) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i8 = displayMetrics.heightPixels;
        this.f3246l = Color.parseColor("#33FFFFFF");
        this.f3247m = Color.parseColor("#99FFFFFF");
        this.f3240c = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.OSSmartScrollbar);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i9 = 0; i9 < indexCount; i9++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i9);
                if (index == R$styleable.OSSmartScrollbar_arc_color) {
                    setArcColor(typedArrayObtainStyledAttributes.getColor(index, this.f3246l));
                } else if (index == R$styleable.OSSmartScrollbar_bar_color) {
                    setBarColor(typedArrayObtainStyledAttributes.getColor(index, this.f3247m));
                } else if (index == R$styleable.OSSmartScrollbar_bar_margin) {
                    setBarMargin(typedArrayObtainStyledAttributes.getDimension(index, this.f3240c));
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        Paint paint = new Paint(1);
        this.f3238a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f3238a.setStrokeCap(Paint.Cap.ROUND);
        float fApplyDimension = TypedValue.applyDimension(1, 2.5f, displayMetrics);
        this.f3239b = fApplyDimension;
        this.f3238a.setStrokeWidth(fApplyDimension);
        this.f3241d = new PathMeasure();
        this.e = new Path();
        this.f3242h = new Path();
        this.f3243i = TypedValue.applyDimension(1, 9.0f, displayMetrics);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<OSSmartScrollbar, Float>) View.ALPHA, 1.0f, 0.0f);
        this.f3248n = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setDuration(getScrollBarFadeDuration()).setStartDelay(((long) getScrollBarDefaultDelayBeforeFade()) * 4);
        new a(this);
        new b(this);
    }

    public final void f() {
        if (this.f3248n.isRunning()) {
            this.f3248n.cancel();
        }
        Handler handler = getHandler();
        if (handler != null) {
            w wVar = this.p;
            if (handler.hasCallbacks(wVar)) {
                handler.removeCallbacks(wVar);
            }
        }
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3242h.isEmpty() || this.f3249o == null) {
            return;
        }
        canvas.save();
        canvas.translate(this.f3249o.getWidth() / 2.0f, getHeight() / 2.0f);
        this.f3238a.setColor(this.f3246l);
        canvas.drawPath(this.e, this.f3238a);
        this.f3238a.setColor(this.f3247m);
        canvas.drawPath(this.f3242h, this.f3238a);
        canvas.restore();
        if (this.f3248n.isRunning()) {
            this.f3248n.cancel();
        }
        setAlpha(1.0f);
        Handler handler = getHandler();
        if (handler != null) {
            w wVar = this.p;
            if (handler.hasCallbacks(wVar)) {
                handler.removeCallbacks(wVar);
            }
            handler.postDelayed(wVar, 100L);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i8, int i9) {
        int iApplyDimension;
        super.onMeasure(i8, i9);
        int mode = View.MeasureSpec.getMode(i8);
        int mode2 = View.MeasureSpec.getMode(i9);
        if (mode == 1073741824) {
            iApplyDimension = View.MeasureSpec.getSize(i8);
        } else {
            iApplyDimension = (int) (this.f3239b + this.f3240c + ((int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics())));
        }
        setMeasuredDimension(iApplyDimension, mode2 == 1073741824 ? View.MeasureSpec.getSize(i9) : (int) TypedValue.applyDimension(1, 45.0f, getResources().getDisplayMetrics()));
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
        ViewParent parent = getParent();
        if (parent instanceof ViewGroup) {
            this.f3249o = (ViewGroup) parent;
        } else {
            this.f3249o = null;
        }
        ViewGroup viewGroup = this.f3249o;
        if (viewGroup == null) {
            return;
        }
        int width = viewGroup.getWidth();
        int height = this.f3249o.getHeight();
        float fMin = ((Math.min(width, height) - this.f3239b) / 2.0f) - this.f3240c;
        this.e.reset();
        float f = -fMin;
        this.e.addArc(f, f, fMin, fMin, -164.0f, -32.0f);
        if (getLayoutDirection() == 0) {
            setRotation(-180.0f);
        }
        this.f3241d.setPath(this.e, false);
        float length = this.f3241d.getLength();
        this.f3245k = length - 0.0f;
        this.f3244j = length - this.f3243i;
        z8.f("OSSmartScrollbar", "refreshArc, arcLen: " + length + ", mBarLen: 0.0, mMinBarLen: " + this.f3243i + ", mMaxBarLen: " + this.f3244j + ", mStopD: " + this.f3245k + ", w: " + width + ", h: " + height + ", radius: " + fMin);
        this.f3242h.reset();
        float f4 = this.f3245k * 0.0f;
        this.f3241d.getSegment(f4, 0.0f + f4, this.f3242h, true);
    }

    @Override // android.view.View
    public final void onVisibilityAggregated(boolean z2) {
        super.onVisibilityAggregated(z2);
        if (z2) {
            return;
        }
        f();
    }

    public void setArcColor(int i8) {
        this.f3246l = i8;
    }

    public void setBarColor(int i8) {
        this.f3247m = i8;
    }

    public void setBarMargin(float f) {
        this.f3240c = f;
    }

    public OSSmartScrollbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3249o = null;
        this.p = new w(this, 1);
        d(attributeSet);
    }

    public OSSmartScrollbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3249o = null;
        this.p = new w(this, 1);
        d(attributeSet);
    }
}
