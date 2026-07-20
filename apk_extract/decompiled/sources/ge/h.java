package ge;

import android.animation.ValueAnimator;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.transsion.widgetslib.view.shimmer.OSShimmerLayout;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f5171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ViewGroup f5173d;

    public /* synthetic */ h(ViewGroup viewGroup, int i8, int i9, int i10) {
        this.f5170a = i10;
        this.f5173d = viewGroup;
        this.f5171b = i8;
        this.f5172c = i9;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5170a) {
            case 0:
                float animatedFraction = valueAnimator.getAnimatedFraction();
                com.transsion.widgetslib.widget.tablayout.a aVar = (com.transsion.widgetslib.widget.tablayout.a) this.f5173d;
                int iLerp = AnimationUtils.lerp(aVar.f3726m, this.f5171b, animatedFraction);
                int iLerp2 = AnimationUtils.lerp(aVar.f3727n, this.f5172c, animatedFraction);
                if (iLerp != aVar.f3721h || iLerp2 != aVar.f3722i) {
                    aVar.f3721h = iLerp;
                    aVar.f3722i = iLerp2;
                    ViewCompat.postInvalidateOnAnimation(aVar);
                }
                break;
            default:
                int iIntValue = ((Integer) valueAnimator.getAnimatedValue()).intValue() + this.f5171b;
                OSShimmerLayout oSShimmerLayout = (OSShimmerLayout) this.f5173d;
                oSShimmerLayout.f3333a = iIntValue;
                if (oSShimmerLayout.f3333a + this.f5172c >= 0) {
                    oSShimmerLayout.invalidate();
                }
                break;
        }
    }
}
