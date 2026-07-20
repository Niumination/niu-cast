package fe;

import android.animation.ValueAnimator;
import android.util.Log;
import com.transsion.widgetslib.widget.shadow.FloatingOvalButton;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FloatingOvalButton f5029b;

    public /* synthetic */ c(FloatingOvalButton floatingOvalButton, int i8) {
        this.f5028a = i8;
        this.f5029b = floatingOvalButton;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f5028a) {
            case 0:
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingOvalButton floatingOvalButton = this.f5029b;
                floatingOvalButton.e = fFloatValue;
                Log.d("FloatingOvalButton", "mCurrentScale: " + floatingOvalButton.e);
                floatingOvalButton.f3635a.setScaleX(floatingOvalButton.e);
                floatingOvalButton.f3635a.setScaleY(floatingOvalButton.e);
                break;
            default:
                float fFloatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                FloatingOvalButton floatingOvalButton2 = this.f5029b;
                floatingOvalButton2.e = fFloatValue2;
                Log.d("FloatingOvalButton", "mCurrentScale1: " + floatingOvalButton2.e);
                floatingOvalButton2.f3635a.setScaleX(floatingOvalButton2.e);
                floatingOvalButton2.f3635a.setScaleY(floatingOvalButton2.e);
                break;
        }
    }
}
