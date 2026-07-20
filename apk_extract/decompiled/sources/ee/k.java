package ee;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.view.damping.OSScrollbarLayout;
import com.transsion.widgetslib.widget.seekbar.OSSeekbar;
import com.transsion.widgetslib.widget.tablayout.TabLayout;
import com.transsion.widgetslib.widget.timepicker.wheel.WheelView;
import java.util.ArrayList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4899a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f4900b;

    public /* synthetic */ k(Object obj, int i8) {
        this.f4899a = i8;
        this.f4900b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator animation) {
        float fB;
        switch (this.f4899a) {
            case 0:
                Intrinsics.checkNotNullParameter(animation, "animation");
                Object animatedValue = animation.getAnimatedValue();
                Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
                float fFloatValue = ((Float) animatedValue).floatValue();
                OSSeekbar oSSeekbar = (OSSeekbar) this.f4900b;
                float f = oSSeekbar.I;
                float fB2 = a1.a.b(oSSeekbar.J, f, fFloatValue, f);
                oSSeekbar.f3591m = fB2;
                oSSeekbar.f3581d = oSSeekbar.b(fB2);
                oSSeekbar.getClass();
                if (fFloatValue <= 0.5f) {
                    float f4 = oSSeekbar.K;
                    fB = a1.a.b(oSSeekbar.L, f4, fFloatValue * 2, f4);
                } else {
                    float f10 = oSSeekbar.L;
                    fB = a1.a.b(oSSeekbar.M, f10, (fFloatValue - 0.5f) * 2, f10);
                }
                oSSeekbar.A = fB;
                oSSeekbar.invalidate();
                break;
            case 1:
                Intrinsics.checkNotNullParameter(animation, "animator");
                float animatedFraction = animation.getAnimatedFraction() * animation.getDuration();
                ArrayList arrayList = (ArrayList) this.f4900b;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i8 = size - 1;
                        Object obj = arrayList.get(size);
                        Intrinsics.checkNotNullExpressionValue(obj, "mFloatProps[i]");
                        fd.d dVar = (fd.d) obj;
                        dVar.getClass();
                        float interpolation = dVar.f.getInterpolation(Math.min(1.0f, Math.max(0.0f, animatedFraction - 0.0f) / dVar.e));
                        dVar.f5024b.set(dVar.f5023a, Float.valueOf(((1 - interpolation) * dVar.f5025c) + (dVar.f5026d * interpolation)));
                        if (i8 >= 0) {
                            size = i8;
                        }
                    }
                }
                break;
            case 2:
                ((TabLayout) this.f4900b).scrollTo(((Integer) animation.getAnimatedValue()).intValue(), 0);
                break;
            case 3:
                Object animatedValue2 = animation.getAnimatedValue();
                if (animatedValue2 instanceof Float) {
                    float fFloatValue2 = ((Float) animatedValue2).floatValue();
                    WheelView wheelView = (WheelView) this.f4900b;
                    wheelView.L = fFloatValue2;
                    wheelView.n();
                }
                break;
            case 4:
                ((pd.e) this.f4900b).e.setAlpha(((Integer) animation.getAnimatedValue()).intValue());
                break;
            case 5:
                Object animatedValue3 = animation.getAnimatedValue();
                if (animatedValue3 instanceof Float) {
                    float fFloatValue3 = ((Float) animatedValue3).floatValue();
                    rd.g gVar = (rd.g) this.f4900b;
                    gVar.d((int) fFloatValue3);
                    gVar.c(fFloatValue3);
                }
                break;
            default:
                Object animatedValue4 = animation.getAnimatedValue();
                if (animatedValue4 instanceof Float) {
                    OSScrollbarLayout oSScrollbarLayout = (OSScrollbarLayout) this.f4900b;
                    if (oSScrollbarLayout.f3227m) {
                        oSScrollbarLayout.f3228n.setAlpha(((Float) animatedValue4).floatValue());
                    }
                }
                break;
        }
    }

    public k(fd.d[] floatProp) {
        this.f4899a = 1;
        Intrinsics.checkNotNullParameter(floatProp, "floatProp");
        ArrayList arrayList = new ArrayList();
        this.f4900b = arrayList;
        arrayList.addAll(ArraysKt.toList(floatProp));
    }
}
