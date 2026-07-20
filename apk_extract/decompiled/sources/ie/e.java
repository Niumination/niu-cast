package ie;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.transsion.widgetslib.widget.timepicker.wheel.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public final class e implements DynamicAnimation.OnAnimationUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WheelView f5785a;

    public e(WheelView wheelView) {
        this.f5785a = wheelView;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
    public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f, float f4) {
        WheelView wheelView = this.f5785a;
        wheelView.L = wheelView.I.getFixedFlingValue() + f;
        wheelView.n();
    }
}
