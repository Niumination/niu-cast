package ie;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.animation.AnimationUtils;
import androidx.core.view.ViewCompat;
import com.transsion.widgetslib.widget.timepicker.wheel.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WheelView f5784b;

    public /* synthetic */ d(WheelView wheelView, int i8) {
        this.f5783a = i8;
        this.f5784b = wheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String strK;
        float fB;
        float f;
        WheelView wheelView = this.f5784b;
        switch (this.f5783a) {
            case 0:
                if (wheelView.f3770s0 && !wheelView.f3754i && (strK = wheelView.k(0)) != null && !strK.isEmpty()) {
                    Paint.FontMetrics fontMetrics = wheelView.f3749c.getFontMetrics();
                    float height = wheelView.getHeight();
                    float f4 = fontMetrics.descent;
                    float f10 = fontMetrics.ascent;
                    float f11 = f4 - f10;
                    int i8 = wheelView.d0;
                    int i9 = wheelView.e;
                    wheelView.f3766q0 = (i8 * i9 * 0.5f) + f11;
                    wheelView.f3768r0 = -(((i8 * i9) * 0.5f) - f11);
                    wheelView.t0 = ((f10 + height) / 2.0f) + wheelView.K;
                    wheelView.f3772u0 = (-(height - f11)) / 2.0f;
                    break;
                }
                break;
            default:
                c cVar = wheelView.I;
                if (!cVar.f5775o) {
                    int iCurrentAnimationTimeMillis = (int) (AnimationUtils.currentAnimationTimeMillis() - cVar.f5770j);
                    int i10 = cVar.f5771k;
                    if (iCurrentAnimationTimeMillis < i10) {
                        int i11 = cVar.f5764b;
                        if (i11 == 0) {
                            float interpolation = cVar.f5763a.getInterpolation(iCurrentAnimationTimeMillis * cVar.f5772l);
                            cVar.f5768h = Math.round(cVar.f5773m * interpolation);
                            cVar.f5769i = Math.round(interpolation * cVar.f5774n) + cVar.f5765c;
                        } else if (i11 == 1) {
                            float f12 = i10;
                            float f13 = iCurrentAnimationTimeMillis / f12;
                            int i12 = (int) (f13 * 100.0f);
                            if (i12 < 100) {
                                float f14 = i12 / 100.0f;
                                int i13 = i12 + 1;
                                float[] fArr = c.A;
                                float f15 = fArr[i12];
                                f = (fArr[i13] - f15) / ((i13 / 100.0f) - f14);
                                fB = a1.a.b(f13, f14, f, f15);
                            } else {
                                fB = 1.0f;
                                f = 0.0f;
                            }
                            cVar.f5776r = ((f * cVar.f5777s) / f12) * 1000.0f;
                            int iRound = Math.round(cVar.f5766d * fB);
                            cVar.f5768h = iRound;
                            int iMin = Math.min(iRound, 0);
                            cVar.f5768h = iMin;
                            cVar.f5768h = Math.max(iMin, 0);
                            int i14 = cVar.f5765c;
                            int iRound2 = Math.round(fB * (cVar.e - i14)) + i14;
                            cVar.f5769i = iRound2;
                            int iMin2 = Math.min(iRound2, cVar.f5767g);
                            cVar.f5769i = iMin2;
                            int iMax = Math.max(iMin2, cVar.f);
                            cVar.f5769i = iMax;
                            if (cVar.f5768h == cVar.f5766d && iMax == cVar.e) {
                                cVar.f5775o = true;
                            }
                        }
                    } else {
                        cVar.f5768h = cVar.f5766d;
                        cVar.f5769i = cVar.e;
                        cVar.f5775o = true;
                    }
                    float f16 = wheelView.L;
                    c cVar2 = wheelView.I;
                    boolean z2 = cVar2.f5775o;
                    float fixedFlingValue = wheelView.I.getFixedFlingValue() + cVar2.getCurrY();
                    wheelView.L = fixedFlingValue;
                    if (wheelView.f3754i || !z2) {
                        wheelView.n();
                    } else if (f16 != fixedFlingValue) {
                        if (wheelView.G0 == null) {
                            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(new float[0]);
                            wheelView.G0 = valueAnimatorOfFloat;
                            valueAnimatorOfFloat.setInterpolator(new a(0.25f, 0.0f));
                            wheelView.G0.setDuration(200L);
                            wheelView.G0.addUpdateListener(new ee.k(wheelView, 3));
                        }
                        wheelView.G0.setFloatValues(f16, fixedFlingValue);
                        wheelView.G0.start();
                    }
                }
                if (!wheelView.I.f5775o) {
                    ViewCompat.postOnAnimation(wheelView, wheelView.F0);
                }
                if (wheelView.I.f5775o) {
                    wheelView.announceForAccessibility(wheelView.getContentDescription());
                }
                break;
        }
    }
}
