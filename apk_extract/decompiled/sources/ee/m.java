package ee;

import android.animation.ValueAnimator;
import com.transsion.widgetslib.widget.seekbar.OSWideSeekbar;

/* JADX INFO: loaded from: classes2.dex */
public final class m implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OSWideSeekbar f4904b;

    public /* synthetic */ m(OSWideSeekbar oSWideSeekbar, int i8) {
        this.f4903a = i8;
        this.f4904b = oSWideSeekbar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f4903a) {
            case 0:
                OSWideSeekbar oSWideSeekbar = this.f4904b;
                oSWideSeekbar.f3615h = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar.f3616i;
                oSWideSeekbar.f3614d = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar.e;
                oSWideSeekbar.invalidate();
                break;
            default:
                OSWideSeekbar oSWideSeekbar2 = this.f4904b;
                oSWideSeekbar2.f3615h = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar2.f3616i;
                oSWideSeekbar2.f3614d = ((Float) valueAnimator.getAnimatedValue()).floatValue() * oSWideSeekbar2.e;
                oSWideSeekbar2.invalidate();
                break;
        }
    }
}
