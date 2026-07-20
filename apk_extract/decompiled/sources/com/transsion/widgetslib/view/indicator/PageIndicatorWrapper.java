package com.transsion.widgetslib.view.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import com.transsion.widgetslib.R$styleable;
import td.d;
import td.e;

/* JADX INFO: loaded from: classes2.dex */
public class PageIndicatorWrapper extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SpringPageIndicator f3272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3273b;

    public PageIndicatorWrapper(Context context) {
        this(context, null);
    }

    public final void a(float f) {
        if (this.f3273b) {
            SpringPageIndicator springPageIndicator = this.f3272a;
            if (springPageIndicator.A.size() <= 1) {
                springPageIndicator.J = 0.0f;
                return;
            }
            if (Math.abs(f) == 1.0f) {
                f = 0.0f;
            }
            springPageIndicator.D = (((double) f) == 0.5d || f == 0.0f) ? false : true;
            springPageIndicator.d();
            if (springPageIndicator.f3274a) {
                springPageIndicator.C = f > 0.0f ? Math.max(0, springPageIndicator.B - 1) : Math.min(springPageIndicator.A.size() - 1, springPageIndicator.B + 1);
            } else {
                springPageIndicator.C = f >= 0.0f ? Math.min(springPageIndicator.A.size() - 1, springPageIndicator.B + 1) : Math.max(0, springPageIndicator.B - 1);
            }
            springPageIndicator.f3289v = (e) springPageIndicator.A.get(springPageIndicator.B);
            springPageIndicator.f3291x = (e) springPageIndicator.A.get(springPageIndicator.C);
            if (springPageIndicator.B == springPageIndicator.C) {
                springPageIndicator.D = false;
            }
            springPageIndicator.f3293z = f < 0.0f ? -1 : 1;
            float fAbs = Math.abs(f) * 2.0f;
            springPageIndicator.J = fAbs;
            int i8 = springPageIndicator.f3277d;
            int i9 = springPageIndicator.f3278h;
            int i10 = springPageIndicator.e;
            if (fAbs <= 1.0f) {
                e eVar = springPageIndicator.f3289v;
                eVar.f10215c = i10 - ((i10 - i9) * fAbs);
                e eVar2 = springPageIndicator.f3290w;
                eVar2.f10215c = i9 * fAbs;
                float f4 = eVar.f10213a;
                int i11 = springPageIndicator.f3293z;
                float f10 = i10 * i11;
                e eVar3 = springPageIndicator.f3291x;
                eVar2.f10213a = (((eVar3.f10213a - f4) - f10) * fAbs) + f4 + f10;
                if (springPageIndicator.C != springPageIndicator.B) {
                    eVar3.f10215c = i8 - ((i8 - i9) * fAbs);
                    e eVar4 = springPageIndicator.f3292y;
                    eVar4.f10215c = eVar2.f10215c;
                    float f11 = eVar3.f10213a - (i8 * i11);
                    eVar4.f10213a = f11 - ((f11 - eVar.f10213a) * fAbs);
                }
            } else {
                e eVar5 = springPageIndicator.f3289v;
                float f12 = i9;
                float f13 = fAbs - 1.0f;
                eVar5.f10215c = ((i8 - i9) * f13) + f12;
                e eVar6 = springPageIndicator.f3290w;
                float f14 = 2.0f - fAbs;
                eVar6.f10215c = f12 * f14;
                float f15 = eVar5.f10213a;
                int i12 = springPageIndicator.f3293z;
                float f16 = i8 * i12;
                e eVar7 = springPageIndicator.f3291x;
                eVar6.f10213a = (((eVar7.f10213a - f15) - f16) * f14) + f15 + f16;
                if (springPageIndicator.C != springPageIndicator.B) {
                    eVar7.f10215c = ((i10 - i9) * f13) + f12;
                    e eVar8 = springPageIndicator.f3292y;
                    eVar8.f10215c = eVar6.f10215c;
                    float f17 = eVar7.f10213a - (i10 * i12);
                    eVar8.f10213a = f17 - ((f17 - eVar5.f10213a) * f14);
                }
            }
            Log.d("SpringPageIndicator", "generatePath: mCurrentMovedCircle = " + springPageIndicator.f3290w.toString());
            e eVar9 = springPageIndicator.f3289v;
            float f18 = eVar9.f10215c;
            e eVar10 = springPageIndicator.f3290w;
            double dAcos = Math.acos((f18 - eVar10.f10215c) / (eVar10.f10213a - eVar9.f10213a));
            PointF pointF = springPageIndicator.f3280j;
            e eVar11 = springPageIndicator.f3289v;
            pointF.x = eVar11.f10213a + ((float) (Math.cos(dAcos) * ((double) eVar11.f10215c)));
            PointF pointF2 = springPageIndicator.f3280j;
            e eVar12 = springPageIndicator.f3289v;
            pointF2.y = eVar12.f10214b - ((float) (Math.sin(dAcos) * ((double) eVar12.f10215c)));
            PointF pointF3 = springPageIndicator.f3282l;
            e eVar13 = springPageIndicator.f3290w;
            pointF3.x = eVar13.f10213a + ((float) (Math.cos(dAcos) * ((double) eVar13.f10215c)));
            PointF pointF4 = springPageIndicator.f3282l;
            e eVar14 = springPageIndicator.f3290w;
            pointF4.y = eVar14.f10214b - ((float) (Math.sin(dAcos) * ((double) eVar14.f10215c)));
            PointF pointF5 = springPageIndicator.f3281k;
            pointF5.x = springPageIndicator.f3280j.x;
            e eVar15 = springPageIndicator.f3289v;
            pointF5.y = eVar15.f10214b + ((float) (Math.sin(dAcos) * ((double) eVar15.f10215c)));
            PointF pointF6 = springPageIndicator.f3283m;
            pointF6.x = springPageIndicator.f3282l.x;
            e eVar16 = springPageIndicator.f3290w;
            pointF6.y = eVar16.f10214b + ((float) (Math.sin(dAcos) * ((double) eVar16.f10215c)));
            PointF pointF7 = springPageIndicator.f3284n;
            PointF pointF8 = springPageIndicator.f3280j;
            float f19 = pointF8.x;
            PointF pointF9 = springPageIndicator.f3282l;
            float f20 = ((pointF9.x - f19) / 2.0f) + f19;
            pointF7.x = f20;
            float f21 = springPageIndicator.f3289v.f10214b;
            pointF7.y = f21 - ((pointF9.y - pointF8.y) / 2.0f);
            PointF pointF10 = springPageIndicator.f3285o;
            pointF10.x = f20;
            pointF10.y = ((pointF9.y - pointF8.y) / 2.0f) + f21;
            e eVar17 = springPageIndicator.f3291x;
            double dAcos2 = Math.acos((eVar17.f10215c - springPageIndicator.f3290w.f10215c) / (springPageIndicator.f3292y.f10213a - eVar17.f10213a));
            PointF pointF11 = springPageIndicator.p;
            e eVar18 = springPageIndicator.f3291x;
            pointF11.x = eVar18.f10213a + ((float) (Math.cos(dAcos2) * ((double) eVar18.f10215c)));
            PointF pointF12 = springPageIndicator.p;
            e eVar19 = springPageIndicator.f3291x;
            pointF12.y = eVar19.f10214b - ((float) (Math.sin(dAcos2) * ((double) eVar19.f10215c)));
            PointF pointF13 = springPageIndicator.f3286r;
            e eVar20 = springPageIndicator.f3292y;
            pointF13.x = eVar20.f10213a + ((float) (Math.cos(dAcos2) * ((double) eVar20.f10215c)));
            PointF pointF14 = springPageIndicator.f3286r;
            e eVar21 = springPageIndicator.f3292y;
            pointF14.y = eVar21.f10214b - ((float) (Math.sin(dAcos2) * ((double) eVar21.f10215c)));
            PointF pointF15 = springPageIndicator.q;
            pointF15.x = springPageIndicator.p.x;
            e eVar22 = springPageIndicator.f3291x;
            pointF15.y = eVar22.f10214b + ((float) (Math.sin(dAcos2) * ((double) eVar22.f10215c)));
            PointF pointF16 = springPageIndicator.f3287s;
            pointF16.x = springPageIndicator.f3286r.x;
            e eVar23 = springPageIndicator.f3292y;
            pointF16.y = eVar23.f10214b + ((float) (Math.sin(dAcos2) * ((double) eVar23.f10215c)));
            PointF pointF17 = springPageIndicator.f3288t;
            PointF pointF18 = springPageIndicator.p;
            float f22 = pointF18.x;
            PointF pointF19 = springPageIndicator.f3286r;
            float f23 = ((pointF19.x - f22) / 2.0f) + f22;
            pointF17.x = f23;
            float f24 = springPageIndicator.f3291x.f10214b;
            pointF17.y = f24 - ((pointF19.y - pointF18.y) / 2.0f);
            PointF pointF20 = springPageIndicator.u;
            pointF20.x = f23;
            pointF20.y = ((pointF19.y - pointF18.y) / 2.0f) + f24;
            springPageIndicator.E.reset();
            Path path = springPageIndicator.E;
            e eVar24 = springPageIndicator.f3289v;
            path.addCircle(eVar24.f10213a, eVar24.f10214b, eVar24.f10215c, springPageIndicator.f3293z > 0 ? Path.Direction.CW : Path.Direction.CCW);
            if (springPageIndicator.B != springPageIndicator.C) {
                Path path2 = springPageIndicator.E;
                e eVar25 = springPageIndicator.f3290w;
                path2.addCircle(eVar25.f10213a, eVar25.f10214b, eVar25.f10215c, springPageIndicator.f3293z > 0 ? Path.Direction.CW : Path.Direction.CCW);
                Path path3 = springPageIndicator.E;
                PointF pointF21 = springPageIndicator.f3280j;
                path3.moveTo(pointF21.x, pointF21.y);
                Path path4 = springPageIndicator.E;
                PointF pointF22 = springPageIndicator.f3284n;
                float f25 = pointF22.x;
                float f26 = pointF22.y;
                PointF pointF23 = springPageIndicator.f3282l;
                path4.quadTo(f25, f26, pointF23.x, pointF23.y);
                Path path5 = springPageIndicator.E;
                PointF pointF24 = springPageIndicator.f3283m;
                path5.lineTo(pointF24.x, pointF24.y);
                Path path6 = springPageIndicator.E;
                PointF pointF25 = springPageIndicator.f3285o;
                float f27 = pointF25.x;
                float f28 = pointF25.y;
                PointF pointF26 = springPageIndicator.f3281k;
                path6.quadTo(f27, f28, pointF26.x, pointF26.y);
                Path path7 = springPageIndicator.E;
                PointF pointF27 = springPageIndicator.f3280j;
                path7.lineTo(pointF27.x, pointF27.y);
                Path path8 = springPageIndicator.F;
                PointF pointF28 = springPageIndicator.p;
                path8.moveTo(pointF28.x, pointF28.y);
                Path path9 = springPageIndicator.F;
                PointF pointF29 = springPageIndicator.f3288t;
                float f29 = pointF29.x;
                float f30 = pointF29.y;
                PointF pointF30 = springPageIndicator.f3286r;
                path9.quadTo(f29, f30, pointF30.x, pointF30.y);
                Path path10 = springPageIndicator.F;
                PointF pointF31 = springPageIndicator.f3287s;
                path10.lineTo(pointF31.x, pointF31.y);
                Path path11 = springPageIndicator.F;
                PointF pointF32 = springPageIndicator.u;
                float f31 = pointF32.x;
                float f32 = pointF32.y;
                PointF pointF33 = springPageIndicator.q;
                path11.quadTo(f31, f32, pointF33.x, pointF33.y);
                Path path12 = springPageIndicator.F;
                PointF pointF34 = springPageIndicator.p;
                path12.lineTo(pointF34.x, pointF34.y);
                Path path13 = springPageIndicator.F;
                e eVar26 = springPageIndicator.f3291x;
                path13.addCircle(eVar26.f10213a, eVar26.f10214b, eVar26.f10215c, springPageIndicator.f3293z > 0 ? Path.Direction.CCW : Path.Direction.CW);
                Path path14 = springPageIndicator.F;
                e eVar27 = springPageIndicator.f3292y;
                path14.addCircle(eVar27.f10213a, eVar27.f10214b, eVar27.f10215c, springPageIndicator.f3293z > 0 ? Path.Direction.CCW : Path.Direction.CW);
            }
            springPageIndicator.invalidate();
        }
    }

    @Override // android.view.View
    public final void onSizeChanged(int i8, int i9, int i10, int i11) {
        super.onSizeChanged(i8, i9, i10, i11);
    }

    public void setActiveMarker(int i8) {
        if (this.f3273b) {
            this.f3272a.setCurrentMarker(i8);
        }
    }

    public void setNormalColor(@ColorInt int i8) {
        this.f3272a.setNormalColor(i8);
    }

    public void setPageIndicatorMarkerClickListener(d dVar) {
        if (this.f3273b) {
            this.f3272a.setMarkerClickListener(dVar);
        }
    }

    public void setSearchVisible(boolean z2) {
    }

    public void setSelectedColor(@ColorInt int i8) {
        this.f3272a.setSelectedColor(i8);
    }

    public PageIndicatorWrapper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIndicatorWrapper(Context context, AttributeSet attributeSet, int i8) {
        super(context, attributeSet, i8);
        this.f3273b = true;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.PageIndicatorWrapper, i8, 0);
        int integer = typedArrayObtainStyledAttributes.getInteger(R$styleable.PageIndicatorWrapper_maxMarkerNum, 9);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = 40;
        layoutParams.rightMargin = 40;
        layoutParams.gravity = 17;
        SpringPageIndicator springPageIndicator = new SpringPageIndicator(context, attributeSet);
        this.f3272a = springPageIndicator;
        springPageIndicator.setLayoutParams(layoutParams);
        springPageIndicator.setMaxMarkerNum(integer);
        addView(springPageIndicator);
        typedArrayObtainStyledAttributes.recycle();
    }
}
